package jp.ne.so_net.blog.sora0125.numberetcgenerator.NumberetcGenerator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.RadioGroup
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_main.*
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
            lateinit var generateResult: ResultData
            lateinit var dispString: String

            // ラジオボタンごとの処理
            when (id) {
                R.id.radioButton_digit3 -> {
                    generateResult = generateNumbers3()
                    dispString =  generateResult.digit100 + generateResult.digit10 + generateResult.digit1
                }
                R.id.radioButton_digit4 -> {
                    generateResult = generateNumbers4()
                    dispString =  generateResult.digit1000 + generateResult.digit100 + generateResult.digit10 + generateResult.digit1
                }
                else -> {
                    generateResult = generateNumbers3()
                    dispString =  generateResult.digit100 + generateResult.digit10 + generateResult.digit1
                }
            }

            val displayNumbers: TextView = findViewById(R.id.generateResult)
            displayNumbers.text = dispString
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
    private fun generateNumbers3() :ResultData {
        val r = Random()
        val digit1 = Integer.toString(r.nextInt(10))
        val digit10 = Integer.toString(r.nextInt(10))
        val digit100 = Integer.toString(r.nextInt(10))
        val rs = ResultData(digit1, digit10, digit100)

        return  rs
    }

    /**
     * Method Name : generateNumbers4
     * summary    : ４桁の数字を生成する
     */
    private fun generateNumbers4() :ResultData {
        val r = Random()
        val digit1 = Integer.toString(r.nextInt(10))
        val digit10 = Integer.toString(r.nextInt(10))
        val digit100 = Integer.toString(r.nextInt(10))
        val digit1000 = Integer.toString(r.nextInt(10))
        val rs = ResultData(digit1, digit10, digit100, digit1000)

        return  rs
    }
    
}
