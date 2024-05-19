import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import pnj.uts.ti.akhtar_faizi_putra.MainActivity
import pnj.uts.ti.akhtar_faizi_putra.R

class ProfileFragment : Fragment() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_profile, container, false)

        // Inisialisasi SharedPreferences
        sharedPreferences = requireContext().getSharedPreferences("UserData", Context.MODE_PRIVATE)

        // Tentukan TextView untuk menampilkan informasi profil
        val tvEmail: TextView = view.findViewById(R.id.tv_email)
        val tvNim: TextView = view.findViewById(R.id.tv_nim)
        val tvNama: TextView = view.findViewById(R.id.tv_nama)
        val tvKelas: TextView = view.findViewById(R.id.tv_kelas)

        // Ambil data profil pengguna dari SharedPreferences
        val email = sharedPreferences.getString("Email", "")
        val nim = sharedPreferences.getString("Nim", "")
        val nama = sharedPreferences.getString("Nama", "")
        val kelas = sharedPreferences.getString("Kelas", "")

        // Setel teks pada TextView dengan data profil pengguna yang diambil dari SharedPreferences
        tvEmail.text = "Email: $email"
        tvNim.text = "NIM: $nim"
        tvNama.text = "Nama: $nama"
        tvKelas.text = "Kelas: $kelas"

        // Inisialisasi tombol logout
        val btnLogout: Button = view.findViewById(R.id.btn_logout)

        // Tambahkan onClickListener pada tombol logout
        btnLogout.setOnClickListener {
            // Menghapus SharedPreferences
            sharedPreferences.edit().clear().apply()

            // Kembali ke halaman login
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }

        return view
    }
}
