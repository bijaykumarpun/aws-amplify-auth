package test.aws.auth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.amplifyframework.auth.options.AuthSignUpOptions
import com.amplifyframework.core.Amplify

class SignUpActivity : AppCompatActivity() {
    lateinit var buttonSignUp:Button
    lateinit var etUsername:EditText
    lateinit var etPassword:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

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

        (findViewById<TextView>(R.id.goto_verification)).setOnClickListener{
            val i = Intent(this,VerificationActivity::class.java)
            i.putExtra("email",etUsername.text.toString())
            startActivity(i)
        }

    }

    private fun performSignUp(username:String, password:String){
        val option:AuthSignUpOptions = AuthSignUpOptions.builder()
            .build()
        Amplify.Auth.signUp(username,password,option,{result->
            Log.d("Amplify success 4343", result.toString())

        }, { error ->
            error.message?.let{
                Log.d("Amplify error 2323",it)
            }
        }
        )
    }
}