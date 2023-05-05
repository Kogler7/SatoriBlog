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
    essayId: number
    title: string
    brief: string
    userId: number
    user: string
    sectId: number
    sect: string
    tags: string[]
    cover: string
    agrees: number
    likes: number
    stars: number
    views: number
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
