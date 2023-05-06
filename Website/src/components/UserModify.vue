<template>
  <v-dialog v-model="dialog" persistent width="1024" activator="parent">
    <v-card>
      <v-card-title>
        <span class="text-h5">User Profile</span>
      </v-card-title>
      <v-card-text>
        <v-container>
          <v-row>
            <v-col cols="6">
              <v-text-field v-model="user.userName" label="用户名*" required></v-text-field>
            </v-col>
            <v-col cols="6">
              <v-text-field v-model="user.nick" label="昵称"></v-text-field>
            </v-col>
            <v-col cols="6">
              <v-select v-model="user.auth" :items="authItems" label="权限*" required></v-select>
            </v-col>
            <v-col cols="6">
              <v-select v-model="user.sex" :items="sexItems" label="性别*" required></v-select>
            </v-col>
            <v-col cols="12">
              <v-text-field v-model="user.passWord" label="密码*" type="password" required></v-text-field>
            </v-col>
            <v-col cols="6">
              <v-text-field v-model="user.email" label="邮箱*" required></v-text-field>
            </v-col>
            <v-col cols="6">
              <v-text-field v-model="user.birth" label="生日"></v-text-field>
            </v-col>
            <v-col cols="12">
              <v-text-field v-model="user.brief" label="简介"></v-text-field>
            </v-col>
          </v-row>
        </v-container>
      </v-card-text>
      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn color="blue-darken-1" variant="text" @click="dialog = false">
          取消
        </v-btn>
        <v-btn color="blue-darken-1" variant="text" @click="submit()">
          保存
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>


<script lang="ts" setup>
import { User } from '@/models/user';
import { ref, reactive } from 'vue'
import { updateUser } from '@/services/api'

const emits = defineEmits(['update:modelValue'])
const props = defineProps<{
  modelValue: User,
}>()

const authItems = ["Admin", "Operator", "User", "Guest"]
const sexItems = ["男", "女"]

const user = reactive(props.modelValue)
user.sex = user.sex == 'M' ? '男' : '女'

async function submit() {
  user.sex = user.sex == '男' ? 'M' : 'F'

  updateUser(user)
  emits('update:modelValue', user)
  dialog.value = false
}

const dialog = ref(false)
</script>
