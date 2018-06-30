package jp.ne.so_net.blog.sora0125.numberetcgenerator.NumberetcGenerator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    /**
     * Method Name : onCreate
     * summary    : メイン画面の初期化を行う
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setSupportActionBar(toolbar)

        update_btn.setOnClickListener { _ ->
            val radioGroup: RadioGroup = findViewById(R.id.radioGroup_1)
            val editText1 = findViewById<EditText>(R.id.text_field1)
            val editText2 = findViewById<EditText>(R.id.text_field2)
            val editText3 = findViewById<EditText>(R.id.text_field3)
            val editText4 = findViewById<EditText>(R.id.text_field4)

            // 押されたラジオボタンのIDを取得
            val radioCurrentId = radioGroup.checkedRadioButtonId

            lateinit var generateResult: String
            val generator = Generator()
            val validation = Validator()

            // ラジオボタンごとの処理
            when (radioCurrentId) {
                // ３桁の数字
                R.id.radioButton_digit3 -> {
                    generateResult = generator.generateNumbers3()
                }
                // ４桁の数字
                R.id.radioButton_digit4 -> {
                    generateResult = generator.generateNumbers4()
                }
                // 8桁の文字列（数字＋アルファベット）
                R.id.radioButton_passAN8 -> {
                    generateResult = generator.generateRandomStringAN8()
                }
                // 8桁の任意の文字列
                R.id.radioButton_pass_select8 -> {
                    generateResult = generator.generateRandomSelectString8()
                }
                // 任意の文字列
                R.id.radioButton_pass_any_select -> {
                    val text1 = editText1.text.toString()
                    val text2 = editText2.text.toString()
                    val text3 = editText3.text.toString()
                    val text4 = editText4.text.toString()

                    val checkStr = text1 + text2 + text3 + text4
                    // 文字の長さをチェック
                    if (!validation.isInputStrLengthChecked(checkStr)) {
                        Toast.makeText(this, "32文字以内にしてください", Toast.LENGTH_LONG).show()
                        return@setOnClickListener
                    }
                    // 文字の種類をチェック
                    if (!validation.isInputStrChecked(checkStr)) {
                        Toast.makeText(this, "改行以外を入力してください", Toast.LENGTH_LONG).show()
                        return@setOnClickListener
                    }
                    generateResult = generator.generateSelectString(text1, text2, text3, text4)
                }
                // 未選択時（デフォルトで３桁）
                else -> {
                    generateResult = generator.generateNumbers3()
                }
            }

            //　生成した結果を表示
            val displayNumbers: TextView = findViewById(R.id.generateResult)
            displayNumbers.text = generateResult
        }
    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.menu_main, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        return when (item.itemId) {
//            R.id.action_settings -> true
//            else -> super.onOptionsItemSelected(item)
//        }
//    }

}
