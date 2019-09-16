package sv.edu.udb.recycling

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var countries: ArrayList<Country> = arrayListOf(
        Country("Denmark","Copenhagen", R.drawable.dk),
        Country("Germany","Berlin", R.drawable.de),
        Country("Norway","Oslo", R.drawable.no),
        Country("Japan","Tokyo",R.drawable.jp),
        Country("Ukraine","Kiev", R.drawable.nl),
        Country("Sweden","Stockholm", R.drawable.se),
        Country("Czech Republic","Praga", R.drawable.cz),
        Country("Canada","Vancouver", R.drawable.ca)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv: RecyclerView = findViewById(R.id.recycler)
        rv.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        rv.adapter = MyRecycler(countries, applicationContext)
    }
}
