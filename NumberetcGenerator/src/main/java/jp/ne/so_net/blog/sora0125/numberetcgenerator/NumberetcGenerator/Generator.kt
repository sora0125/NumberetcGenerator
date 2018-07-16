package jp.ne.so_net.blog.sora0125.numberetcgenerator.NumberetcGenerator

import org.apache.commons.lang.RandomStringUtils
import java.lang.StringBuilder
import java.util.*

// 生成する乱数の範囲
const val SEED_NUMBER = 10

class Generator {
    /**
     * Method Name : generateNumbers3
     * summary    : ３桁の数字を生成する
     */
    fun generateNumbers3() :String {
        val r = Random()
        val digit1 = Integer.toString(r.nextInt(SEED_NUMBER))
        val digit10 = Integer.toString(r.nextInt(SEED_NUMBER))
        val digit100 = Integer.toString(r.nextInt(SEED_NUMBER))
        val rs =  digit100 + digit10 + digit1

        return  rs
    }

    /**
     * Method Name : generateNumbers4
     * summary    : ４桁の数字を生成する
     */
    fun generateNumbers4() :String {
        val r = Random()
        val digit1 = Integer.toString(r.nextInt(SEED_NUMBER))
        val digit10 = Integer.toString(r.nextInt(SEED_NUMBER))
        val digit100 = Integer.toString(r.nextInt(SEED_NUMBER))
        val digit1000 = Integer.toString(r.nextInt(SEED_NUMBER))
        val rs =  digit1000 + digit100 + digit10 + digit1

        return  rs
    }

    /**
     * Method Name : generateRandomStringAN
     * summary    : 入力された桁数のアルファベット・数字を含む文字列を生成する
     */
    fun generateRandomStringAN(digit: Int) :String {
        val rs = RandomStringUtils.randomAlphanumeric(digit)

        return  rs
    }

    /**
     * Method Name : generateRandomStringASCII
     * summary    : 入力された桁数のアルファベット・数字・記号を含む文字列を生成する
     */
    fun generateRandomStringASCII(digit: Int) :String {
        val rs = RandomStringUtils.randomAscii(digit)

        return  rs
    }

    /**
     * Method Name : generateRandomSelectString
     * summary    : 指定した文字から数字をランダムに決定する
     */
    private fun generateRandomSelectString(seed: String) :String {
        val rs = RandomStringUtils.random(1,seed)
        return  rs
    }

    /**
     * Method Name : generateSelectString
     * summary    : 入力されたキーワードから文字列を生成する
     */
    fun generateSelectString(field1: String, field2: String, field3: String, field4: String) :String {
        // 入力された文字列を格納するリスト
        val inputList: MutableList<String> = mutableListOf()
        inputList.add(field1)
        inputList.add(field2)
        inputList.add(field3)
        inputList.add(field4)

        // 表示する順番を保存する
        val orderList: MutableList<String> = mutableListOf()
        // 表示順を決める時に使う一時的なリスト
        val orderListTmp: MutableList<String> = mutableListOf()
        val tmpStrBuilder = StringBuilder()
        orderList.add("0")
        orderList.add("1")
        orderList.add("2")
        orderList.add("3")
        orderListTmp.addAll(orderList)
        // 乱数の元になる数字を初期化
        var seed = orderList[0] + orderList[1] + orderList[2] + orderList[3]
        var resultstr = generateRandomSelectString(seed)
        var i = 0
        // 選ばれた数字をリストから削除し、フィールド数分繰り返す
        while (i < 4) {
            val rsTmp = StringBuilder()
            for (order in orderListTmp) {
                if (order == resultstr) {
                    tmpStrBuilder.append(inputList[resultstr.toInt()])
                    orderList.remove(resultstr)
                    i++
                }else {
                    rsTmp.append(order)
                }
            }
            orderListTmp.remove(resultstr)
            // 数字が残っていれば表示順を決定するメソッドに渡す
            if (!rsTmp.isEmpty()) {
                seed = rsTmp.toString()
                resultstr = generateRandomSelectString(seed)
            }
        }

        val rs = tmpStrBuilder.toString()
        return  rs
    }
}

