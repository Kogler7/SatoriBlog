<template>
  <v-card elevation="0">
    <v-container>
      <v-row>
        <v-col cols="12">
          <v-card-subtitle>
            <v-avatar
              color="grey-darken-3"
              image="https://img.zcool.cn/community/01b9955d822df0a801211d53830bf6.jpg@1280w_1l_2o_100sh.jpg"
            ></v-avatar>
            {{ comment.nick }}

          </v-card-subtitle>
        </v-col>
        <v-spacer></v-spacer>
        <v-col>
          <v-card-text>
            {{ comment.content }}
          </v-card-text>
        </v-col>
      </v-row>
    </v-container>
  </v-card>
  <v-divider></v-divider>
</template>

<script lang="ts" setup>
import {reactive} from "vue";
import {getUserById} from "@/api/user";

defineProps<{
  comment: {
    id: number;
    content: string;
    initTime: string;
    nick: string;
  }
}>()


</script>
