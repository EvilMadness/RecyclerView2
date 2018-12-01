package garcia.castro.luis.recyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.single_person.view.*

class PersonasAdapter(var personas: ArrayList<Persona>,var context:Context):RecyclerView.Adapter<PersonasAdapter.ViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.single_person, p0,false)
        val viewHolder = ViewHolder(view)
        view.tag = viewHolder
        return viewHolder
    }

    override fun getItemCount(): Int {
        return personas.size
    }

    override fun onBindViewHolder(holder: ViewHolder, p1: Int) {
        holder.nombre!!.text = personas[p1].nombre
        holder.genero!!.text = personas[p1].genero
        Picasso.get().load(personas[p1].foto)
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.imagen)
    }


    class ViewHolder(vista:View):RecyclerView.ViewHolder(vista){
        var imagen:ImageView? = null
        var nombre:TextView? = null
        var genero:TextView? = null

        init {
            imagen = vista.ivFoto
            nombre = vista.tvNombre
            genero = vista.tvGenero
        }
    }
}