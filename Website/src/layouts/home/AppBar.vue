<template>
    <v-app-bar flat>
        <v-app-bar-title>
            SATORI
        </v-app-bar-title>

        <v-tabs v-model="tab" background-color="primary" dark align-tabs="center">
            <v-tab v-for="n in 6" :key="n">
                Item {{ n }}
            </v-tab>
        </v-tabs>
        <search />
    </v-app-bar>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
import Search from '@/components/Search.vue'
const tab = ref(0)
</script>
