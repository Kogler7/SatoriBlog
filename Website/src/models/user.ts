export interface User {
  id: number;
  userName: string;
  passWord: string;
  auth?: string;
  sex?: string;
  nick?: string;
  brief?: string;
  birth?: Date;
  email?: string;
}

export interface Fans {
  id: number;
  userId: number;
  fanId: number;
}
