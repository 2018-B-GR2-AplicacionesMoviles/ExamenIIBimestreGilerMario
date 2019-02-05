package com.example.usrdel.myapplication

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_tienda.view.*

class TiendaAdapter(val items : ArrayList<Tienda>, val context:Context) :RecyclerView.Adapter<TiendaAdapter.ViewHolder>(){
    override fun getItemCount(): Int {
        return items.size
    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_tienda, p0, false))
    }
    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0?.tienda?.text=items.get(p1).nombre
    }

    class ViewHolder(v:View):RecyclerView.ViewHolder(v){
        val tienda=v.txt_input

    }

}