package com.example.appq

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView

class Adapter(val data: List<Data>? = null):RecyclerView.Adapter<Adapter.ViewHolder>() {

     var OnItemClick:(Data) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {

       return  data?.size ?: 0

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      data?.get(position)?.let {
          holder.bind(it)
          holder.itemView.setOnClickListener { view ->
              OnItemClick.invoke(it)
          }
      }


    }

    class ViewHolder(itemview:View):RecyclerView.ViewHolder(itemview){

        fun bind(data: Data){
            val name = itemView.findViewById<TextView>(R.id.cardtextview)

            val userpost = itemView.findViewById<ImageView>(R.id.cardpost)
            val liketext = itemView.findViewById<TextView>(R.id.liketext)
            val commenttext = itemView.findViewById<TextView>(R.id.commenttext)
            val playvideoicon = itemView.findViewById<ImageView>(R.id.playvideoicon)

             name.text = data.userName
            liketext .text = data.likes
            commenttext.text = data.comments

            if (data.content.contains(".mp4")){
                Glide.with(itemView.context).load(data.thumb).into(userpost)
                playvideoicon.visibility = View.VISIBLE
            }
            else {
                Glide.with(itemView.context).load(data.content).into(userpost)
                playvideoicon.visibility = View.GONE

            }
            //Glide.with(itemView.context).load(data.userImage).centerCrop().into(userimage)
        }
    }
}