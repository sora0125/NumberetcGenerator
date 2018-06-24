package jp.ne.so_net.blog.sora0125.numberetcgenerator.NumberetcGenerator

/**
 * Class Name : ResultData
 * summary    : 生成結果を保持するクラス
 */
data class ResultData(var digit1: String,
                      var digit10: String,
                      var digit100: String) {
    var digit1000 = ""


    constructor(digit1: String,
                digit10: String,
                digit100: String,
                digit1000: String): this(digit1, digit10, digit100) {
        this.digit1000 = digit1000
    }
}
