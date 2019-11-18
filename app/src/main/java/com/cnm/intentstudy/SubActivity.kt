package com.cnm.intentstudy

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        bt_send.setOnClickListener {
//            연산 할 값이 둘 중 하나라도 입력이 안되있으면 Toast로 알려주고 return 한다.
            if (et_first.text.toString() == "" || et_second.text.toString() == "") {
                Toast.makeText(this, "연산할 값을 넣어주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            // 연산 할 값을 저장할 변수
            val first = et_first.text.toString().toInt()
            val second = et_second.text.toString().toInt()

//            intent에서 MainActivity에서 저장했던 연산자구분 값을 가져와서 연산한다음 result에 정의한다.
            val result = when (intent.getStringExtra("cal")) {
                "1" -> {
                    "연산결과: ${first + second}"
                }
                "2" -> {
                    "연산결과: ${first - second}"
                }
                "3" -> {
                    "연산결과: ${first * second}"
                }
                "4" -> {
                    "연산결과: ${(first / second.toDouble())}"
                }
                else -> {
                    error("")
                }
            }
//            정의한 result값을 다시 MainActivity에 보낸다.
            val intent = Intent()
            intent.putExtra("result", result)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

    }


}
