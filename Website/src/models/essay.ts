export interface Section {
    id: number
    sectName: string
    hostId: number
    brief: string
    essayCnt: number
    starCnt: number
    viewCnt: number
    initTime: Date
}

export interface Comment {
    id: number
    userId: number
    user: string
    essayId: number
    content: string
    agrees: number
    initTime: Date
}

export interface EssayBrief {
    id: number
    title: string
    brief: string
    userId: number
    user: string
    sectId: number
    sect: string
    tags: string[]
    cover: string
    agrees: number
    likeCnt: number
    starCnt: number
    cmtCnt: number
    viewCnt: number
    initTime: Date
}

export interface EssayContent {
    essayId: number
    outline: string
    content: string
}

export interface EssayDetail {
    essayId: number
    comments: Comment[]
    updated: Date
}

export interface Essay {
    essayId: number
    brief: EssayBrief
    content: EssayContent
    details: EssayDetail
}
