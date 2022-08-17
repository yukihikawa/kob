package com.kob.backend.consumer;

import com.alibaba.fastjson.JSONObject;
import com.kob.backend.consumer.utils.Game;
import com.kob.backend.consumer.utils.JwtAuthentication;
import com.kob.backend.mapper.UserMapper;
import com.kob.backend.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @program: backend
 * @description:
 * @author: WRF
 * @create: 2022-08-14 19:05
 **/

@Component
@ServerEndpoint("/websocket/{token}")
public class WebSocketServer {
    //每次有链接时new一个该类的实例

    //存储所有连接，全局变量
    final private static ConcurrentHashMap<Integer, WebSocketServer> users = new ConcurrentHashMap<>();

    /*匹配池,线程安全的集合*/
    final private static CopyOnWriteArraySet<User> matchPool = new CopyOnWriteArraySet<>();
    private User user;
    private Session session = null;  //用于从后端向前端发送
    private static UserMapper userMapper;  //数据库

    //本类不是单例，需要特殊注入
    /*public WebSocketServer(UserMapper userMapper) {
        this.userMapper = userMapper;
    }*/

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        WebSocketServer.userMapper = userMapper;
    }



    @OnOpen
    public void onOpen(Session session, @PathParam("token") String token) throws IOException {

        this.session = session;
        System.out.println("Connected!");
        /*Integer userId = Integer.parseInt(token);*/
        Integer userId = JwtAuthentication.getUserId(token);//从token中获取用户,通过jwt验证


        this.user = userMapper.selectById(userId); //尝试解析


        if(user != null){
            users.put(userId, this);
        }else {
            this.session.close();
        }

        System.out.println(user);
    }

    @OnClose
    public void onClose(){
        //关闭连接
        System.out.println("disconnected!");
        if(this.user != null){
            users.remove(this.user.getId());
            matchPool.remove(this.user);
        }
    }

    private void startMatching(){
        System.out.println("Start matching！");
        matchPool.add(this.user); //加入匹配池

        while(matchPool.size() >= 2){  /*任意两个配对*/
            Iterator<User> it = matchPool.iterator();
            User a = it.next(), b = it.next();
            matchPool.remove(a);
            matchPool.remove(b);

            Game game = new Game(13, 14, 20);
            game.createMap();

            JSONObject respA = new JSONObject();
            respA.put("event", "start-matching");
            respA.put("opponent_username", b.getUsername());
            respA.put("opponent_photo", b.getPhoto());
            respA.put("gamemap",game.getG());
            users.get(a.getId()).sendMessage(respA.toJSONString()); /*获取连接,送往前端*/

            JSONObject respB = new JSONObject();
            respB.put("event", "start-matching");
            respB.put("opponent_username", a.getUsername());
            respB.put("opponent_photo", a.getPhoto());
            respB.put("gamemap",game.getG());
            users.get(b.getId()).sendMessage(respB.toJSONString());

        }
    }

    private void stopMatching(){
        System.out.println("stop matching");
        matchPool.remove(this.user);
    }

    @OnMessage
    public void onMessage(String message, Session session){  /*本质是一个路由,判断将任务交给谁*/
        //从Client接收消息
        System.out.println("receive message!");
        /*解析前端请求*/
        JSONObject data = JSONObject.parseObject(message);
        /*取出event*/
        String evevt = data.getString("event");
        if("start-matching".equals(evevt)){
            startMatching();
        } else if ("stop-matching".equals(evevt)){
            stopMatching();
        }
    }

    @OnError
    public void onError(Session session, Throwable error){
        error.printStackTrace();
    }

    public void sendMessage(String message){
        synchronized (this.session) {
            try{
                this.session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
