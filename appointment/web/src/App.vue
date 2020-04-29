<template>
  <div id="app">
    <div>
      <headerk></headerk>
    </div>
    <div>
      <router-view/>
    </div>
    <div>
      <bottom></bottom>
    </div>
  </div>
</template>

<script>
import headerk from "./components/headerk";
import Bottom from "./components/bottom";
export default {
  name: 'App',
  components: {
    Bottom,
    "headerk":headerk
  }
}
</script>

<style>

</style>
