<template>

<div>
 <h3>로그인 실패</h3>
 <button @click="reLogin">로그인 다시하기</button>

</div>

</template>

<script>
export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  },
 methods: {
   reLogin() {
     this.$router.push('/')    //index.js 파일 내의 path를 타고 components 폴더 내 해당 파일이 실행(router의 역할)
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
