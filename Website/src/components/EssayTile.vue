<template>
  <v-card elevation="0">
    <v-container @click="goEssay(essay.id)">
      <v-row>
        <v-col cols="12">
          <v-card-subtitle>{{ essay.initTime }}</v-card-subtitle>
          <v-card-title>{{ essay.title }}</v-card-title>
          <v-card-text>{{ essay.brief }}</v-card-text>
        </v-col>
        <v-spacer></v-spacer>

        <v-col cols="2">
          <v-card-subtitle>
            <v-icon>mdi-heart</v-icon>
            {{ essay.likeCnt }}
          </v-card-subtitle>
        </v-col>
        <v-col cols="2">
          <v-card-subtitle>
            <v-icon>mdi-star</v-icon>{{ essay.starCnt }}
          </v-card-subtitle>
        </v-col>
        <v-col cols="2">
          <v-card-subtitle>
            <v-icon>mdi-comment</v-icon>
            {{ essay.cmtCnt }}
          </v-card-subtitle>
        </v-col>
      </v-row>
    </v-container>
  </v-card>
  <v-divider></v-divider>
</template>

<script lang="ts" setup>
import { EssayBrief } from '@/models/essay'
import { formatDate } from '@/utils/date'
import {onMounted,onUpdated} from "vue";
import router from "@/router";

defineProps<{
  essay: EssayBrief
}>()


const goEssay = (essayID) => {
  console.log('点击文章标题跳转到文章详情页'+essayID)
  router.push('/essay?id='+essayID)
}


</script>
