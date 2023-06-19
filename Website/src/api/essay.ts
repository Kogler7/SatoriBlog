import { request } from '@/services/api'
import { EssayBrief } from "@/models/essay"
import {LocationQueryValue} from "vue-router";

export async function getLatestEssays() {
  const list = await request.get('/essays/latest?section=all')
  const arr = list.data
  // console.log(arr)
  return arr
}

export async function getEssaysOfSect(name: string) {
  return request.get(`/essays/latest?section=${name}`)
}

export async function getEssayById(id: string) {
  const response = await request.get(`/essay/info?id=${id}`)
  const essay = response.data
  return essay
}

export async function getEssayContent(path: string) {
  const response = await request.get(`/src/essay?path=${path}`)
  const content = response.data
  return content
}
