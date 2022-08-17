<template>
<!--    对战和匹配界面的展示条件-->
    <PlayGround v-if="$store.state.pk.status === 'playing'"/>
    <MatchGround v-if="$store.state.pk.status === 'matching'"/>
</template>

<script>
import PlayGround from '../../components/PlayGround.vue'
import MatchGround from '../../components/MatchGround.vue'
import {onMounted, onUnmounted} from 'vue' /*当组件被挂载/卸载时*/
import {useStore} from 'vuex'

export default {
    components: {
        PlayGround,
        MatchGround,
    },
    setup() {
        const store = useStore();
        //webSocket协议的url
        const socketUrl = `ws://127.0.0.1:3000/websocket/${store.state.user.token}/`;

        let socket = null;
        onMounted(() => {
            store.commit("updateOpponent", {   /*设置一个默认对手样式*/
                username: "我的对手",
                photo: "https://cdn.acwing.com/media/article/image/2022/08/09/1_1db2488f17-anonymous.png",
            })

            //创建连接
            socket = new WebSocket(socketUrl);
            //开启连接时
            socket.onopen = () => {
                console.log("connected!");
                store.commit("updateSocket", socket);
            }

            //收到消息时
            socket.onmessage = msg => {
                const data = JSON.parse(msg.data);   /*从后端发过来的JSON,详见WebSocketServer的startMatching函数*/
                if (data.event === "start-matching") {  // 匹配成功
                    store.commit("updateOpponent", {   /*根据发来的JSON更新对手信息*/
                        username: data.opponent_username,
                        photo: data.opponent_photo,
                    });
                    setTimeout(() => {
                        store.commit("updateStatus", "playing");/*更改页面状态*/
                    }, 2000);  /*延迟*/
                    store.commit("updateGamemap", data.gamemap);
                }
            }


            socket.onclose = () => {
                console.log("disconnected!");
            }
        });

        onUnmounted(() => {
            //断开连接,避免冗余
            socket.close();
            store.commit("updateStatus", "matching");
        })
    }
}
</script>

<style scoped>
</style>
