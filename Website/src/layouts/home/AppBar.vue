<template>
  <v-app-bar flat>
    <v-app-bar-title>
      SATORI
    </v-app-bar-title>

    <v-tabs v-model="tab" background-color="primary" dark align-tabs="center">
      <v-tab>首页</v-tab>
      <v-tab>文章</v-tab>
      <v-tab>想法</v-tab>
    </v-tabs>
    <search />
  </v-app-bar>
</template>

<script lang="ts" setup>
import { ref, watch } from 'vue'
import { useRouter } from 'vue-router'
import Search from '@/components/Search.vue'
const router = useRouter()
const tab = ref(0)
watch(tab, (to, from) => {
  if (to == 0) router.push('/')
  else if (to == 1) router.push('/essay')
  else if (to == 2) router.push('/idea')
})
</script>
