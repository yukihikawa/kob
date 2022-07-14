<template>
  <nav>
    <h1>hello vue</h1>
    <div>bot昵称: {{ bot_name }}</div>
    <div>bot战力: {{ bot_rating }}</div>
  </nav>
  <router-view/>
</template>

<script>
import $ from 'jquery';
import { ref } from 'vue';
/*import NavBar from "@/co/!*mponents/NavBar";
import "bootstrap/dist/"*!/*/


export default{
  name: "App",

  setup: () => {
    let bot_name = ref("");
    let bot_rating = ref("");

    $.ajax({
      url: "http://127.0.0.1:3000/pk/getBotInfo/",
      type: "get",
      success: resp => {
        /*console.log(resp)*/
        bot_name.value = resp.name;
        bot_rating.value = resp.rating;
      }
    })

    return {
      bot_name,
      bot_rating
    }
  }
}
</script>


<style>

body {
  background-image: url("@/assets/background.png");
  background-size: cover;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
