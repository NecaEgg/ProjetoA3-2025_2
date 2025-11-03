<script setup>
import Header from './components/Header.vue';
</script>

<template>
  <Header />
  <router-view class="content" />

</template>

<style scoped>
.content {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  text-align: center;
  height: calc(100vh - 60px);
}
</style>
