<template>
  <v-container class="w-25">
    <v-row>
      <v-col cols="9" class="h-75">
        <v-text-field v-model="search" label="搜索" single-line hide-details clearable clear-icon="mdi-close-circle"
          @keyup.enter="submit"></v-text-field>
      </v-col>
      <v-col cols="3">
        <v-btn color="primary" @click="submit" density="compact" icon="mdi-magnify"></v-btn>
      </v-col>
    </v-row>
  </v-container>
</template>

<script lang="ts" setup>
import { ref } from "vue"
const emits = defineEmits(["search"])
const search = ref("")
function submit() {
  if (search.value) {
    emits("search", search.value)
  }
}
</script>
