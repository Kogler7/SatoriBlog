import { request } from '@/services/api'

export async function getCommentsByEssayId(id: string) {
  const response = await request.get(`/comments?essayId=${id}`)
  const comments = response.data
  return comments
}
