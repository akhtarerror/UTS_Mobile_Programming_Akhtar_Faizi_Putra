package pnj.uts.ti.akhtar_faizi_putra

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import pnj.uts.ti.akhtar_faizi_putra.HomeActivity

class MainActivity : AppCompatActivity() {
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button

    // Hardcoded email and password
    private val HARDCODED_EMAIL = "akhtar@gmail.com"
    private val HARDCODED_PASSWORD = "222021"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etEmail = findViewById(R.id.et_email)
        etPassword = findViewById(R.id.et_password)
        btnLogin = findViewById(R.id.btn_login)

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
            } else if (email == HARDCODED_EMAIL && password == HARDCODED_PASSWORD) {
                // Save data to SharedPreferences
                val sharedPreferences: SharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString("Email", email)
                editor.putString("Nim", "2207411002")
                editor.putString("Nama", "Akhtar Faizi Putra")
                editor.putString("Kelas", "TI-4A")
                editor.apply()

                // Navigate to Home Activity
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
