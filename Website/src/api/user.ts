import { request } from '@/services/api'
import { User } from "@/models/user"

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
