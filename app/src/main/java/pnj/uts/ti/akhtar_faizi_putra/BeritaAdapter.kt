import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pnj.uts.ti.akhtar_faizi_putra.Berita
import pnj.uts.ti.akhtar_faizi_putra.DetailBeritaActivity
import pnj.uts.ti.akhtar_faizi_putra.R

class BeritaAdapter(private val beritaList: List<Berita>) :
    RecyclerView.Adapter<BeritaAdapter.BeritaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeritaViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_berita, parent, false)
        return BeritaViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BeritaViewHolder, position: Int) {
        val currentBerita = beritaList[position]
        holder.judulBeritaTextView.text = currentBerita.judul
        holder.deskripsiBeritaTextView.text = currentBerita.deskripsi
        // Set other properties accordingly
    }

    override fun getItemCount(): Int {
        return beritaList.size
    }

    inner class BeritaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val judulBeritaTextView: TextView = itemView.findViewById(R.id.text_judul_berita)
        val deskripsiBeritaTextView: TextView = itemView.findViewById(R.id.text_tanggal_berita)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val berita = beritaList[position]
                    val intent = Intent(itemView.context, DetailBeritaActivity::class.java).apply {
                        putExtra("judul", berita.judul)
                        putExtra("deskripsi", berita.deskripsi)
                    }
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

}
