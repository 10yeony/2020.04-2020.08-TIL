<!--
지금의 App.vue가 하는 일은 딱히 없기 때문에 아래부분의 내용을 출력하고 나머지 기능은 없다.
라우터 링크를 클릭하면 페이지 이동 효과
 -->
<template>
  <div id="app">
    <div id="nav">
      <!--
     1. 아래 라우터 to 속성에 경로를 지정했음
     2. 사용자가 화면에서 라우터 링크에 대응하는 html 링크를 클릭하면
        2.1 index..js 에서 등록된 라우터들을 검색함(뭘로? to="/url" 경로로 검색함.)
        2.2 아래의 라우터 경로를 찾아냄
            {
              path: "/",
              name: "customers",
              alias: "/customer",
              component: CustomersList
            }
        2.3 연결된 컴포넌트를 router-view 영역에 실행함.
    -->
      <router-link to="/">모든 사원 보기</router-link> |
      <router-link to="/about">About</router-link>
    </div>
    <router-view />
  </div>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
