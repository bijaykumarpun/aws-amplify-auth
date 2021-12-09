package test.aws.auth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.amplifyframework.auth.AuthException
import com.amplifyframework.auth.result.AuthSignInResult
import com.amplifyframework.core.Amplify
import com.amplifyframework.core.Consumer

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
        Amplify.Auth.signIn(username,password,
            { value ->
                Log.d("Amplify Success 442",value.toString())
                })
        { value ->
            value.message?.let {
                Log.d("Amplify Error 2323", it)
            }
        }
    }
}