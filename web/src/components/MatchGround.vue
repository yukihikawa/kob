<template>
    <div class="matchground">
        <div class="row">
            <!--        左右各6-->
            <div class="col-6">
                <div class="user-photo"><!--用户头像-->
                    <img :src="$store.state.user.photo" alt="">
                </div>
                <div class="user-username"><!--用户名-->
                    {{ $store.state.user.username }}
                </div>
            </div>
            <div class="col-6">
                <div class="user-photo">
                    <img :src="$store.state.pk.opponent_photo" alt="">
                </div>
                <div class="user-username">
                    {{ $store.state.pk.opponent_username }}
                </div>
            </div>
            <div class="col-12" style="text-align: center; padding-top: 15vh;"><!--按钮-->
                <button @click="click_match_btn" type="button" class="btn btn-warning btn-lg">{{
                        match_btn_info
                    }}
                </button>
            </div>
        </div>
    </div>
</template>

<script>
import {ref} from 'vue'
import {useStore} from 'vuex';

export default {
    setup() {
        const store = useStore();
        let match_btn_info = ref("开始匹配");  /*按钮信息*/

        const click_match_btn = () => {   /*点击后按钮变化*/
            if (match_btn_info.value === "开始匹配") {
                match_btn_info.value = "取消";
                store.state.pk.socket.send(JSON.stringify({ /*JSON封装成字符串,向后端发送*/
                    event: "start-matching",
                }));
            } else {
                match_btn_info.value = "开始匹配";
                store.state.pk.socket.send(JSON.stringify({
                    event: "stop-matching",
                }));
            }
        }

        return {
            match_btn_info,
            click_match_btn,
        }
    }
}
</script>

<style scoped>
div.matchground {
    width: 60vw;
    height: 70vh;
    margin: 40px auto;
    background-color: rgba(50, 50, 50, 0.5); /*背景颜色和透明度*/
}

div.user-photo {
    text-align: center;
    padding-top: 10vh;  /*边距*/
}

div.user-photo > img {
    border-radius: 50%; /*圆形*/
    width: 20vh;
}

div.user-username { /*用户名样式*/
    text-align: center;
    font-size: 24px;
    font-weight: 600;
    color: white;
    padding-top: 2vh;
}
</style>
