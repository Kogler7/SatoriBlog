import { request } from '@/services/api'
import { EssayBrief } from "@/models/essay"

export async function getLatestEssays() {
  const list = await request.get('/essays/latest?section=all')
  const arr = list.data
  console.log(arr)
  return arr
}

export async function getEssaysOfSect(name: string) {
  return request.get(`/essays/latest?section=${name}`)
}
