<template>
  <Nav
    v-if="
      !$route.path.includes('/login') &&
      !$route.path.includes('/register') &&
      !$route.path.includes('/character')
    "
  />
  <RouterView />
</template>

<script>
import Nav from "./components/NavBar/Nav.vue"
export default {
  name: "App",
  components: {
    Nav,
  },
};
</script>

<style scoped>

</style>
