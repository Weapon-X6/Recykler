package sv.edu.udb.recycling

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MyRecycler(private val lista: ArrayList<Country>, private val context: Context)
    : RecyclerView.Adapter<MyRecycler.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.rv_item_row, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val current = lista[position]
        holder.tvCountry.text = current.name
        holder.tvCapital.text = current.city
        Picasso.get().load(current.flag).into(holder.imgFlag)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    class Holder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener{
        val tvCountry: TextView = v.findViewById(R.id.tvRV_country)
        val tvCapital: TextView = v.findViewById(R.id.tvRV_capital)
        val imgFlag: ImageView = v.findViewById(R.id.tvRv_flag)

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            try{
                val context = itemView.context
                val intent = Intent(context, SubActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                intent.putExtra(KEY_COUNTRY, tvCountry.text)

                Log.d("TAG", "Country ${tvCountry.text}")
                context.startActivity(intent)
            }catch(ex: Exception){
                Log.e("TAG", ex.message)
            }
        }

        companion object{
            const val KEY_COUNTRY="country"
        }
    }
}