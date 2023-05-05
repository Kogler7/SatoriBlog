<template>
  <v-card elevation="0">
    <v-container>
      <v-row>
        <v-col cols="9">
          <v-card-subtitle>{{ formatDate(essay.initTime) }}</v-card-subtitle>
          <v-card-title>{{ essay.title }}</v-card-title>
          <v-card-text>{{ essay.brief }}</v-card-text>
        </v-col>
        <v-spacer></v-spacer>
        <v-col cols="3">
          <v-chip class="ma-2" label v-for="tag in essay.tags" :key="tag">{{ tag }}</v-chip>
        </v-col>
      </v-row>
    </v-container>
  </v-card>
  <v-divider></v-divider>
</template>

<script lang="ts" setup>
import { EssayBrief } from '@/models/essay'
import { formatDate } from '@/utils/date'
defineProps<{
  essay: EssayBrief
}>()
</script>
