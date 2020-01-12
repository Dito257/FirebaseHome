package com.example.authorization

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        auth = FirebaseAuth.getInstance()

        regBtn.setOnClickListener {

            val email: String = email.text.toString()
            val password: String = password.text.toString()

            if (TextUtils.isEmpty((email)) || TextUtils.isEmpty(password)) {

                    Toast.makeText(this, "გთხოვთ შეავსოთ ყველა ველი!", Toast.LENGTH_LONG).show()


                } else {

                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) {task ->
                        if (task.isSuccessful) {

                            Toast.makeText(this," რეგისტრაცია დასრულდა წარმატებით! ", Toast.LENGTH_LONG).show()

                        }
                    }

            }
        }
    }
}
