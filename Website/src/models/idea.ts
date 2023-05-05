export interface Idea {
  id: number;
  userId: number;
  keywords: string;
  brief: string;
  argument: string;
  exploration: string;
  privacy: string;
  agreeCnt: number;
  likeCnt: number;
  initTime: Date;
  updateTime: Date;
}
