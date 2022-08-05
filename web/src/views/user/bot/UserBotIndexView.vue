<template>
  <ContentField>
    <div>我的Bot</div>
  </ContentField>

</template>

<script>
import ContentField from "@/components/ContentField"
import $ from 'jquery'
import { useStore } from "vuex"

export default {
  name: "UserBotIndexView",
  components: {
    ContentField
  },
  setup(){
    const store = useStore();
    /*$.ajax({
      url: "http://127.0.0.1:3000/user/bot/add/",
      type: "POST",
      data:{
        title: "Bot的标题",
        description: "Bot的描述" ,
        content: "bot的内容"
      },
      headers:{
        Authorization: "Bearer " + store.state.user.token,
      },
      success(resp) {
        console.log(resp);
      },
      error(resp){
        console.log(resp);
      }
    })*/
    /*$.ajax({
      url: "http://127.0.0.1:3000/user/bot/remove/",
      type: "POST",
      data:{
        bot_id: '13',
      },
      headers:{
        Authorization: "Bearer " + store.state.user.token,
      },
      success(resp) {
        console.log(resp);
      },
      error(resp){
        console.log(resp);
      }
    })*/
    /*$.ajax({
      url: "http://127.0.0.1:3000/user/bot/getlist/",
      type: "GET",
      headers:{
        Authorization: "Bearer " + store.state.user.token,
      },
      success(resp) {
        console.log(resp);
      },
      error(resp){
        console.log(resp);
      }
    })*/
    $.ajax({
      url: "http://127.0.0.1:3000/user/bot/update/",
      type: "POST",
      data:{
        bot_id: "11",
        title: "Bot的新标题",
        description: "Bot的新描述" ,
        content: "bot的新内容fxb"
      },
      headers:{
        Authorization: "Bearer " + store.state.user.token,
      },
      success(resp) {
        console.log(resp);
      },
      error(resp){
        console.log(resp);
      }
    })
  }
}
</script>

<style scoped>

</style>
