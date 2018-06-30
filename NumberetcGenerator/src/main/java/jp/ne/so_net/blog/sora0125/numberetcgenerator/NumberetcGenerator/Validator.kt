package jp.ne.so_net.blog.sora0125.numberetcgenerator.NumberetcGenerator

class Validator {

    /**
     * Method Name : isInputStrLengthChecked
     * summary    : 入力された文字列の長さをチェックする
     */
    fun isInputStrLengthChecked(inputStr: String): Boolean{
        var result = false
        val MAX_LENGTH = 32
        if (inputStr.length < MAX_LENGTH) {
            result = true

        }

        return result
    }

    /**
     * Method Name : isInputStrLengthChecked
     * summary    : 入力された文字列の種類をチェックする
     */
    fun isInputStrChecked(inputStr: String): Boolean {
        var result = true
        // 改行が入っていたらエラー
//        val regex = Regex("""^[a-zA-Z0-9=^~|@`{}:*;+_/?.,<>!"#$%&'()¥n].+$""")
        val regex = Regex("¥¥n")
        if (regex.containsMatchIn(inputStr)) {
            result = false
        }

        return result
    }
}