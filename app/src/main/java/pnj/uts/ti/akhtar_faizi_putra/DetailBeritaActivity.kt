package pnj.uts.ti.akhtar_faizi_putra

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import pnj.uts.ti.akhtar_faizi_putra.R

class DetailBeritaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_berita)

        // Mendapatkan data berita dari intent
        val judul = intent.getStringExtra("judul")
        val deskripsi = intent.getStringExtra("deskripsi")

        // Menampilkan data berita di TextView
        val textViewJudul = findViewById<TextView>(R.id.textViewJudul)
        val textViewDeskripsi = findViewById<TextView>(R.id.textViewDeskripsi)

        textViewJudul.text = judul
        textViewDeskripsi.text = deskripsi
    }
}
