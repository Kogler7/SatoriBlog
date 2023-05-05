<template>
  <v-app>
    <admin-bar />
    <v-spacer />
    <router-view />
    <v-spacer />
    <admin-footer />
  </v-app>
</template>

<script lang="ts" setup>
import AdminBar from './AppBar.vue'
import AdminFooter from './Footer.vue'
</script>
