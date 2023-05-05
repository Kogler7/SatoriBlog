<template>
  <v-card class="pa-10 ma-10 elevation-3">
    <form @submit.prevent="submit">
      <v-container>
        <v-row>
          <!--username-->
          <v-col cols="12" md="2">
            <v-text-field variant="underlined" v-model="username.value.value" :counter="20"
              :error-messages="username.errorMessage.value" label="username"></v-text-field>
          </v-col>
          <!--auth-->
          <v-col cols="12" md="2">
            <v-select variant="underlined" v-model="auth.value.value" :items="authItems"
              :error-messages="auth.errorMessage.value" label="auth"></v-select>
          </v-col>
          <!--sex-->
          <v-col cols="12" md="2">
            <v-select variant="underlined" v-model="sex.value.value" :items="sexItems"
              :error-messages="sex.errorMessage.value" label="sex"></v-select>
          </v-col>
          <!--email-->
          <v-col cols="12" md="2">
            <v-text-field variant="underlined" v-model="email.value.value" :error-messages="email.errorMessage.value"
              label="email"></v-text-field>
          </v-col>
          <!--birth-->
          <v-col cols="12" md="2">
            <v-text-field variant="underlined" v-model="birth.value.value" :counter="11"
              :error-messages="birth.errorMessage.value" label="birth"></v-text-field>
          </v-col>
          <!--submit-->
          <v-col cols="12" md="2">
            <v-btn class="mt-2" type="submit" height="40" width="110" color="primary">
              添加
            </v-btn>
          </v-col>

        </v-row>
      </v-container>
    </form>
    <v-card>
      <v-table fixed-header height="300px">
        <thead>
          <tr>
            <th class="text-left">
              用户名
            </th>
            <th class="text-left">
              昵称
            </th>
            <th class="text-left">
              性别
            </th>
            <th class="text-left">
              生日
            </th>
            <th class="text-left">
              邮箱
            </th>
            <th class="text-left">
              权限
            </th>
            <th class="text-left">
              操作
            </th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="user in info.users" :key="user.id">
            <td>{{ user.userName }}</td>
            <td>{{ user.nick ?? '' }}</td>
            <td>{{ user.sex == 'M' ? '男' : '女' }}</td>
            <td>{{ user.birth ?? '' }}</td>
            <td>{{ user.email ?? '' }}</td>
            <td>{{ authItems[parseInt(user.auth ?? '2')] }}</td>
            <td>
              <v-row>
                <v-btn density="compact" icon="mdi-trash-can-outline" @click="deleteUserById(user.id)" variant="tonal"
                  color="red-darken-1"></v-btn>
                <v-btn density="compact" icon="mdi-pencil" class="ml-2">
                  <v-icon></v-icon>
                  <user-modify v-model="tmpUser" />
                </v-btn>
              </v-row>
            </td>
          </tr>
        </tbody>
      </v-table>
    </v-card>
  </v-card>
</template>

<script lang="ts" setup>
import { ref, reactive, onMounted } from "vue"
import { User } from "@/models/user"
import { useField, useForm } from 'vee-validate'
import { getUsers, addUser, updateUser, deleteUser } from '@/services/api'
import UserModify from '@/components/UserModify.vue'

const tmpUser = reactive<User>({
  id: 1,
  userName: "Bret",
  passWord: "",
  email: "",
})

const dialog = ref(false)

const info = reactive<{ users: User[] }>({
  users: []
})

onMounted(async () => {
  const res = await getUsers()
  info.users = res.data
  console.log(res)
})

async function deleteUserById(id: number) {
  console.log("deleting", id)
  const del = await deleteUser(id)
  console.log(del)
  const res = await getUsers()
  console.log(res)
  info.users = res.data
}

const authItems = ["Admin", "Operator", "User", "Guest"]
const sexItems = ["男", "女"]

const { handleSubmit, handleReset } = useForm({
  validationSchema: {
    username(value: string) {
      if (!value) return true
      else if (value?.length >= 2 && value?.length <= 20) return true
      return 'Name must be less than 20 characters and more than 2 characters.'
    },
    nickname(value: string) {
      if (!value) return true
      else if (value?.length >= 2 && value?.length <= 20) return true
      return 'Name must be less than 20 characters and more than 2 characters.'
    },
    auth(value: string) {
      if (!value) return true
      else if (value === 'Admin' || value === 'Operator' || value === 'User' || value === 'Guest') return true
      return 'authorization must be valid.'
    },
    sex(value: string) {
      if (!value) return true
      else if (value === '男' || value === '女') return true
      return 'sex must be valid.'
    },
    email(value: string) {
      if (!value) return true
      else if (/.+@.+\..+/.test(value)) return true
      return 'E-mail must be valid.'
    },
  },
})

const username = useField('username')
const auth = useField('auth')
const sex = useField('sex')
const email = useField('email')
const birth = useField('birth')

const submit = handleSubmit(values => {
  if (!values.username) values.username = ''
  if (!values.auth) values.auth = 'User'
  if (!values.sex) values.sex = 'Male'
  if (!values.email) values.email = ''
  if (!values.birth) values.birth = '2002-02-02'

  var uAuth = authItems.indexOf(values.auth.toString())
  if (uAuth == -1) uAuth = 2

  const user: User = {
    id: 0,
    userName: values.username,
    passWord: '',
    auth: uAuth.toString(),
    sex: values.sex == 'Male' ? 'M' : 'F',
    nick: values.nickname,
    brief: '',
    birth: values.birth,
    email: values.email,
  }

  addUser(user).then(res => {
    console.log(res)
    getUsers().then(res => {
      info.users = res.data
    })
  })
})
</script>
