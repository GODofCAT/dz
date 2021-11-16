package com.example.dz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RvAdapter: RecyclerView.Adapter<RvAdapter.ProductItemViewHolder> {
    class ProductItemViewHolder internal constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var textViewProductName: TextView =
            itemView.findViewById(R.id.textViewProductName)
        var buttonTaskitemViewDeleteTask: Button =
            itemView.findViewById(R.id.buttonTaskItemViewDelete)
    }

    private var productManager:ProductManager

    constructor(productManager: ProductManager){
        this.productManager = productManager
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductItemViewHolder {
        val v:View = LayoutInflater.from(parent.context).inflate(R.layout.product_item,parent,false)

        return ProductItemViewHolder(v)
    }

    override fun onBindViewHolder(holder: ProductItemViewHolder, position: Int) {
        var productItem: ItemProduct = productManager.getByIndex(position)

        holder.textViewProductName.text = productItem.name

        holder.buttonTaskitemViewDeleteTask.setOnClickListener{
            productManager.deleteProduct(position)

            notifyItemRemoved(position)
            notifyItemRangeChanged(position, productManager.getCount())
        }
    }

    override fun getItemCount(): Int {
        return productManager.getCount()
    }
}