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
    <EssayTile v-for="essay in essayRef.essays" :key="essay.id" :essay="essay"></EssayTile>
    <v-pagination class="mt-auto mb-10" v-model="currentPage" :length="totalPages"/>
  </v-container>
</template>

<script lang="ts" setup>
import {ref, reactive, onMounted, onUpdated} from 'vue'
import EssayTile from './EssayTile.vue'
import {getLatestEssays} from '@/api/essay'

const currentPage = ref(1)
const totalPages = ref(5)

const essayRef = reactive({essays: {}})

getLatestEssays().then(
  res => {
    essayRef.essays = res
  }
)

</script>
