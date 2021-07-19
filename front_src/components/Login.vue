<template>
<div>

  <input type="id" placeholder="input your id" v-model="id">
  <input type="password" placeholder="input your password" v-model="password">

  <button @click="Success">로그인하기</button>
  <button @click="join">회원가입</button>
  <button @click="LoginSuccess">로그인 성공 시</button>
  <button @click="LoginFail">로그인 실패 시</button>
</div>
</template>

<script>
import axios from 'axios'                                      //데이터를 주고받기 위해 사용

export default {
  name: 'HelloWorld',
  data () {
    return {
      id:"",                                                    //변수선언
      password:"",     
      result: ""
    }
  },
  methods: {
   Success() {
     this.result = axios.get('signIn/into?id='+this.id+'&password='+this.password)
     console.log(this.result)
   },
    join() {
     axios.get('signup/save?id='+this.id+'&password='+this.password)
      alert('회원가입이 완료되었습니다.')
    },
    LoginSuccess() {
        this.$router.push('/LoginSuccess')                      //index.js 파일 내의 path를 통해 components 폴더 내 해당 파일이 실행(router의 역할)
      },
      LoginFail(){
        this.$router.push('/Loginfail')
      }
    }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
