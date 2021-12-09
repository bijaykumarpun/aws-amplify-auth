package test.aws.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SignInActivity : AppCompatActivity() {
    lateinit var buttonSignIn:Button
    lateinit var etUsername:EditText
    lateinit var etPassword:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        //init ui
        buttonSignIn = findViewById(R.id.button_sign_in)
        etUsername = findViewById(R.id.sign_in_username)
        etPassword = findViewById(R.id.sign_in_password)


        buttonSignIn.setOnClickListener{
            if(etUsername.text.toString().isNotEmpty() &&
                etPassword.text.toString().isNotEmpty()){
                performSignIn(etUsername.text.toString(),
                    etPassword.text.toString())
            }
        }

        (findViewById<TextView>(R.id.goto_sign_up)).setOnClickListener{
            startActivity(Intent(this,SignUpActivity::class.java))
        }

    }

    private fun performSignIn(username:String, password:String){
        //Todo
    }
}