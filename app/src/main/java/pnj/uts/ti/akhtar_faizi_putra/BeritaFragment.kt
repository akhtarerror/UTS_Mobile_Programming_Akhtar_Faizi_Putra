import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pnj.uts.ti.akhtar_faizi_putra.Berita
import pnj.uts.ti.akhtar_faizi_putra.R

class BeritaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_berita, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view_berita)

        val adapter = BeritaAdapter(generateDummyBeritaList())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        return view
    }

    private fun generateDummyBeritaList(): List<Berita> {
        val beritaList = ArrayList<Berita>()
        for (i in 1..10) {
            val berita = Berita("Judul Berita $i", "Deskripsi Berita $i")
            beritaList.add(berita)
        }
        return beritaList
    }
}
