<template>
  <v-form fast-fail @submit.prevent>
    <v-card class="mx-auto w-50" elevation="1" max-width="460">
      <v-card-title class="py-5 font-weight-black">登录</v-card-title>

      <v-card-text>
        <div class="text-subtitle-2 font-weight-black mb-1">用户名</div>
        <v-text-field v-model="username" label="User Name" single-line variant="outlined" clearable required
          :rules="[required]" type="input" hint="用户名应由字母、数字或下划线组成"></v-text-field>
        <div class="text-subtitle-2 font-weight-black mb-1">密码</div>
        <v-text-field v-model="password" label="Password" single-line variant="outlined" clearable required
          :rules="[required]" type="input" hint="密码应由字母、数字或下划线组成"></v-text-field>

        <v-btn type="submit" :disabled="loading" :loading="loading" block class="text-none mb-4" color="indigo-darken-3"
          size="x-large" variant="flat" @click="submit(username, password)">
          登录
        </v-btn>

        <v-btn block class="text-none" color="grey-lighten-3" size="x-large" variant="flat">
          取消
        </v-btn>
        <v-btn block class="text-decoration-underline" size="x-large" variant="plain"
          @click="router.push('/auth/register')">
          没有帐户？前往注册
        </v-btn>
      </v-card-text>
    </v-card>
  </v-form>
</template>

<script lang="ts" setup>
import { ref, watch } from 'vue'
import { useRouter } from 'vue-router'
import { hash } from '@/services/crypto'
import { login } from '@/services/api'
const loading = ref(false)

const username = ref('')
const password = ref('')

const router = useRouter()
function required(v: any) {
  return !!v || '此项必填'
}

async function submit(username: string, password: string) {
  loading.value = true
  if (username == '' || password == '') {
    return
  }
  password = hash(password)
  console.log(username, password)
  try {
    const res = await login(username, password)
    console.log(res)
  } catch (e) {
    console.log('error', e)
  }
  loading.value = false
  router.push('/')
}

watch(loading, val => {
  if (!val) return
  setTimeout(() => (loading.value = false), 2000)
})
</script>
