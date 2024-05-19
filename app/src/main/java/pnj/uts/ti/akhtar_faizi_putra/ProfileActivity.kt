package pnj.uts.ti.akhtar_faizi_putra

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    private lateinit var tvEmail: TextView
    private lateinit var tvNim: TextView
    private lateinit var tvNama: TextView
    private lateinit var tvKelas: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        tvEmail = findViewById(R.id.tv_email)
        tvNim = findViewById(R.id.tv_nim)
        tvNama = findViewById(R.id.tv_nama)
        tvKelas = findViewById(R.id.tv_kelas)

        // Retrieve data from SharedPreferences
        val sharedPreferences: SharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)
        val email = sharedPreferences.getString("Email", "No email found")
        val nim = sharedPreferences.getString("Nim", "No NIM found")
        val nama = sharedPreferences.getString("Nama", "No name found")
        val kelas = sharedPreferences.getString("Kelas", "No class found")

        // Set data to TextViews
        tvEmail.text = email
        tvNim.text = nim
        tvNama.text = nama
        tvKelas.text = kelas
    }


}

