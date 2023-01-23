<script setup>
import Header from "../Header.vue";
import Footer from "../Footer.vue";
</script>
<template>
    <Header />
    <router-view></router-view>
    <!-- 클래스명으로도 사용가능 -->
    <!-- <RouterView /> -->
    <Footer />
</template>