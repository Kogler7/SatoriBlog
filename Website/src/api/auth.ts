import { request } from '@/services/api'

export let userId = 0

export async function login(username: string, password: string) {
  try {
    const res = await request.post('/auth/login', {
      username,
      password,
    })
    userId = parseInt(res.data)
    if (Number.isNaN(userId)) return false
    return true
  }
  catch (err) {
    return false
  }
}

export function register(username: string, password: string) {
  return request.post('/auth/register', {
    username,
    password,
  })
}
