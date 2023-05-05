<template>
  <v-main>
    <router-view v-slot="{ Component }">
      <transition name="slide">
        <component :is="Component" />
      </transition>
    </router-view>
  </v-main>
</template>

<script lang="ts" setup>
  //
</script>

<style>
.slide-enter-active,
.slide-leave-active {
  transition: all 0.75s ease-out;
}


.slide-enter-to {
  position: absolute;
  right: 0;
}


.slide-enter-from {
  position: absolute;
  right: -100%;
}


.slide-leave-to {
  position: absolute;
  left: -100%;
}


.slide-leave-from {
  position: absolute;
  left: 0;
}
</style>
