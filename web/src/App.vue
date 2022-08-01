<template>
  <NavBar/>
  <router-view></router-view>
</template>

<script>
import NavBar from '@/components/NavBar';
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap'
/*import $ from 'jquery'*/

export default{
  name: "App",
  components: {
    NavBar
  },
  setup(){
/*
    $.ajax({
      url: "http://127.0.0.1:3000/user/account/info/",
      type: "get",
      headers: {
        Authorization: "Bearer " + "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJmNjRhYzI4Yzc5ZDk0NTMzYTkyMzk2NTc1ZjE4YWI3OCIsInN1YiI6IjEiLCJpc3MiOiJzZyIsImlhdCI6MTY1ODkyODk1NywiZXhwIjoxNjYwMTM4NTU3fQ.h-udh_5-nytQH-7JcQyqg6O-NiXksC0LPsrQVySqYHw",
      },
      success(resp){
        console.log(resp);
      },
      error(resp){
        console.log(resp);
      }
    });
    $.ajax({
      url: "http://127.0.0.1:3000/user/account/register/",
      type: "post",
      data: {
        username: "yoimiya",
        password: "123456",
        confirmedPassword: "123456",
      },
      success(resp){
        console.log(resp);
      },
      error(resp){
        console.log(resp);
      }
    });*/
  }

}
</script>


<style>

body {
  background-image: url("@/assets/images/background.png");
  background-size: cover;
}

</style>
