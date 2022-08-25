package com.kob.botrunningsystem.service.impl.utils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: backendcloud
 * @description:
 * @author: WRF
 * @create: 2022-08-22 19:55
 **/
public class BotPool extends Thread{
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private Queue<Bot> bots = new LinkedList<>();  //队列

    /**插入一个bot对象
     * @param userId
     * @param botCode
     * @param input
     */
    public void addBot(Integer userId, String botCode, String input){
        lock.lock();
        try{
            bots.add(new Bot(userId, botCode, input));
            condition.signalAll();  //添加后唤醒线程
        } finally {
            lock.unlock();
        }
    }

    /**消费/执行任务
     * @param bot
     */
    private void consume(Bot bot){
        Consumer consumer = new Consumer();
        consumer.startTimeOut(2000, bot);  //最多执行2秒
    }
    @Override
    public void run() {  //类似消息队列
        while (true){
            lock.lock();
            if(bots.isEmpty()){ //如果空则阻塞
                try {
                    condition.await(); //默认会有释放锁操作
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    lock.unlock();
                    break;
                }
            }else{
                Bot bot = bots.remove();
                lock.unlock();
                consume(bot); //可能会执行一段时间,所以要先解锁
            }
        }
    }
}
