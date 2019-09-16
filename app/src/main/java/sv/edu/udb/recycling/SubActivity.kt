package sv.edu.udb.recycling

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_sub.*
import java.lang.Exception

class SubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        try {
            val info: String? = intent.getStringExtra(MyRecycler.Holder.KEY_COUNTRY)
            tvSub.text = info

        }catch (ex:Exception){
            Log.e("TAG", ex.message)
        }

    }
}
