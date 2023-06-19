<template>
  <v-card class="bg-grey-lighten-4">
    <v-card>
      <v-card-title>
        <h1>{{ essayRef.essay.title }}</h1>
      </v-card-title>
      <v-card-text>
        <h2>{{ essayRef.essay.brief }}</h2>
      </v-card-text>
    </v-card>
    <v-card class="mx-10 my-10 ">
      <v-layout>
        <v-navigation-drawer>
          <v-card-title>
            <h1>目录</h1>
          </v-card-title>
        </v-navigation-drawer>
        <v-main>
          <md-editor v-model="essayRef.essay.content" preview-only :include-level="[3, 4]"/>
        </v-main>
      </v-layout>
    </v-card>
    <v-card-title class="mx-10">
      <h2>评论</h2>
    </v-card-title>
    <v-card class="mx-10 my-10">
      <v-divider></v-divider>
      <CommentTile v-for="comment in commentRef.comments" :key="comment.id" :comment="comment"></CommentTile>
    </v-card>
  </v-card>
</template>

<script lang="ts" setup>
  // 根据路由参数获取文章id
  import {reactive} from "vue";
  import {useRoute} from "vue-router";
  import {getEssayById, getEssayContent} from "@/api/essay";
  import CommentTile from "@/components/CommentTile.vue";
  import MdEditor from 'md-editor-v3';
  import {getCommentsByEssayId} from "@/api/comment";
  const route = useRoute();


  let essayID:string = route.query.id as string;
  console.log('文章id'+essayID)

  const essayRef = reactive({essay: {}})
  getEssayById(essayID).then(
    res => {
      essayRef.essay = res
      getEssayContent(essayRef.essay.path).then(
        res => {
          essayRef.essay.content = res
        }
      )
    }
  )

  const commentRef = reactive({comments: {}})
  getCommentsByEssayId(essayID).then(
    res => {
      commentRef.comments = res
      console.log(commentRef.comments)
    }
  )

</script>
