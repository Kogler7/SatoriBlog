import axios from "axios"
import { User } from "@/models/user"

export const request = axios.create({
  baseURL: '/api',
})

export function login(username: string, password: string) {
  return request.post('/auth/login', {
    username,
    password,
  })
}

export function register(username: string, password: string) {
  return request.post('/auth/register', {
    username,
    password,
  })
}

export function getUserById(id: number) {
  return request.get(`/user?id=${id}`)
}

export function getUsers() {
  return request.get('/users')
}

export function addUser(user: User) {
  return request.post('/user', user)
}

export function updateUser(user: User) {
  return request.put('/user', user)
}

export function deleteUser(id: number) {
  return request.delete(`/user?id=${id}`)
}
