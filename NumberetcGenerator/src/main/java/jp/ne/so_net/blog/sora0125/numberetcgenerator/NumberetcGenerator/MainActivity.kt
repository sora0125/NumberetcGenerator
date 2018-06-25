package jp.ne.so_net.blog.sora0125.numberetcgenerator.NumberetcGenerator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.RadioGroup
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_main.*
import org.apache.commons.lang.RandomStringUtils
import java.security.SecureRandom
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        // 更新ボタンの処理
        fab.setOnClickListener { view ->

            val radioGroup: RadioGroup = findViewById(R.id.radioGroup_1)
            val id = radioGroup.checkedRadioButtonId
            lateinit var generateResult: String

            // ラジオボタンごとの処理
            when (id) {
                // ３桁
                R.id.radioButton_digit3 -> {
                    generateResult = generateNumbers3()
                }
                // ４桁
                R.id.radioButton_digit4 -> {
                    generateResult = generateNumbers4()
                }
                // 8桁の文字列（数字＋アルファベット）
                R.id.radioButton_passAN8 -> {
                    generateResult = generateRandomStringAN8()
                }
                // 8桁の任意の文字列
                R.id.radioButton_pass_select8 -> {
                    generateResult = generateRandomSelectString8()
                }
                // 未選択時（デフォルトで３桁）
                else -> {
                    generateResult = generateNumbers3()
                }
            }

            val displayNumbers: TextView = findViewById(R.id.generateResult)
            displayNumbers.text = generateResult
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    /**
     * Method Name : generateNumbers3
     * summary    : ３桁の数字を生成する
     */
    private fun generateNumbers3() :String {
        val r = Random()
        val digit1 = Integer.toString(r.nextInt(10))
        val digit10 = Integer.toString(r.nextInt(10))
        val digit100 = Integer.toString(r.nextInt(10))
        val rs =  digit100 + digit10 + digit1

        return  rs
    }

    /**
     * Method Name : generateNumbers4
     * summary    : ４桁の数字を生成する
     */
    private fun generateNumbers4() :String {
        val r = Random()
        val digit1 = Integer.toString(r.nextInt(10))
        val digit10 = Integer.toString(r.nextInt(10))
        val digit100 = Integer.toString(r.nextInt(10))
        val digit1000 = Integer.toString(r.nextInt(10))
        val rs =  digit1000 + digit100 + digit10 + digit1

        return  rs
    }

    /**
     * Method Name : generateRandomStringAN8
     * summary    : 8桁のアルファベット・数字を含む文字列を生成する
     */
    private fun generateRandomStringAN8() :String {
        val rs = RandomStringUtils.randomAlphanumeric(8)

        return  rs
    }

    /**
     * Method Name : generateRandomSelectString8
     * summary    : 指定した文字の8桁の文字列を生成する
     */
    private fun generateRandomSelectString8() :String {
        val rs = RandomStringUtils.random(8,"tadakun")

        return  rs
    }

}
