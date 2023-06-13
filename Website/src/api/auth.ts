import { request } from '@/services/api'

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
