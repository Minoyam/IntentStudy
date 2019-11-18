package com.cnm.intentstudy

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, SubActivity::class.java)

//        1 -> + , 2 -> - , 3 -> * , 4 -> /
        bt_plus.setOnClickListener {
            intentLoad(intent, "1")
        }
        bt_minus.setOnClickListener {
            intentLoad(intent, "2")
        }
        bt_multiplication.setOnClickListener {
            intentLoad(intent, "3")
        }
        bt_division.setOnClickListener {
            intentLoad(intent, "4")
        }

    }

//    연산자를 구분할 수 있는 값을 intent에 저장하고 SubActivity에 넘겨주는 함수
    private fun intentLoad(intent: Intent, value: String) {
        intent.putExtra("cal", value)
        startActivityForResult(intent, 1001)

    }

//    SubActivity에서 연산 값을 받아와서 결과값을 출력해준다.
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 1001) {
            if (resultCode == Activity.RESULT_OK) {
                tv_return.text = data?.getStringExtra("result")
            }
        }
    }
}
