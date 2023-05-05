<template>
  <v-app>
    <auth-bar />
    <v-spacer />
    <router-view />
    <v-spacer />
    <auth-footer />
  </v-app>
</template>

<script lang="ts" setup>
import AuthBar from './AppBar.vue'
import AuthFooter from './Footer.vue'
</script>
