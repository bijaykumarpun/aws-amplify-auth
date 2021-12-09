package test.aws.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {
    lateinit var buttonSignUp:Button
    lateinit var etUsername:EditText
    lateinit var etPassword:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        //init ui
        buttonSignUp = findViewById(R.id.button_sign_up)
        etUsername = findViewById(R.id.sign_up_username)
        etPassword = findViewById(R.id.sign_up_password)


        buttonSignUp.setOnClickListener{
            if(etUsername.text.toString().isNotEmpty() &&
                etPassword.text.toString().isNotEmpty()){
                performSignUp(etUsername.text.toString(),
                    etPassword.text.toString())
            }
        }
        (findViewById<TextView>(R.id.goto_sign_in)).setOnClickListener{
            startActivity(Intent(this,SignInActivity::class.java))
        }

    }

    private fun performSignUp(username:String, password:String){
        //Todo
    }
}