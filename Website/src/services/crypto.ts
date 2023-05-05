import CryptoJS from "crypto-js"

export function hash(plain: string) {
  return CryptoJS.MD5(plain).toString()
}
