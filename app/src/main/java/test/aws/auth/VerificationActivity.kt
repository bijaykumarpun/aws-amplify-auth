package test.aws.auth

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.amplifyframework.core.Amplify

class VerificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_verification)
        val etUsername = findViewById<EditText>(R.id.verify_username)
        val verificationCode = findViewById<EditText>(R.id.verify_confirm_code)
        val email:String? = intent.getStringExtra("email")

        email?.let{
            etUsername.setText(it)
        }

        ( findViewById<Button>(R.id.button_verify)).setOnClickListener{
            verifyUser(etUsername.text.toString(),verificationCode.text.toString())
        }
    }

    private fun verifyUser(email: String, verificationCode: String) {

        Amplify.Auth.confirmSignUp(email,verificationCode,{result->
            Log.d("Verification success",result.nextStep.toString())

        },{
            it.message?.let{
                Log.d("Verification error ",it)
            }
        })
    }
}