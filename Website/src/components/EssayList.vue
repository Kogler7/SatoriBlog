<template>
  <v-container class="h-100 d-flex flex-column">
    <h2>最新文章</h2>
    <v-tabs>
      <v-tab>全部</v-tab>
      <v-tab>人文</v-tab>
      <v-tab>科技</v-tab>
      <!-- 在此处添加其他选项卡 -->
    </v-tabs>
    <v-divider></v-divider>
    <EssayTile v-for="essay in essays" :key="essay.essayId" :essay="essay"></EssayTile>
    <v-pagination class="mt-auto mb-10" v-model="currentPage" :length="totalPages" />
  </v-container>
</template>

<script lang="ts" setup>
import { ref, reactive } from 'vue'
import EssayTile from './EssayTile.vue'
const currentPage = ref(1)
const totalPages = ref(5)
const essays = reactive([
  {
    essayId: 0,
    title: "文章标题",
    brief: "文章简介",
    userId: 0,
    user: "用户名",
    sectId: 0,
    sect: "板块名",
    tags: ["标签1", "标签2"],
    cover: "https://picsum.photos/200/300",
    agrees: 1,
    likes: 2,
    stars: 3,
    views: 4,
    initTime: new Date("2021-01-01"),
  },
  {
    essayId: 0,
    title: "文章标题",
    brief: "文章简介",
    userId: 0,
    user: "用户名",
    sectId: 0,
    sect: "板块名",
    tags: ["标签1", "标签2"],
    cover: "https://picsum.photos/200/300",
    agrees: 1,
    likes: 2,
    stars: 3,
    views: 4,
    initTime: new Date("2021-01-01"),
  }
])
</script>
