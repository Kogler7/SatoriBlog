<template>
  <v-card class="mx-auto w-25" max-width="400" elevation="0">
    <v-card-text>
      <v-text-field :loading="loading" density="compact" variant="solo" label="搜索" append-inner-icon="mdi-magnify"
        single-line hide-details @click:append-inner="submit"></v-text-field>
    </v-card-text>
  </v-card>
</template>

<script lang="ts" setup>
import { ref } from "vue"
const emits = defineEmits(["search"])
const search = ref("")
const loaded = ref(false)
const loading = ref(false)
function submit() {
  loading.value = true
  if (search.value) {
    emits("search", search.value)
  }
  setTimeout(() => {
    loading.value = false
    loaded.value = true
  }, 2000)
}
</script>
