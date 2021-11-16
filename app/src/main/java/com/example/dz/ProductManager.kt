package com.example.dz

class ProductManager {
    private var products:ArrayList<ItemProduct> = arrayListOf()
    private var id:Int = 0

    fun addProduct(product: ItemProduct){
        product.id = id
        products.add(product)
        id++
    }

    fun deleteProduct(index:Int){
        products.removeAt(index)
    }

    fun getByIndex(index:Int):ItemProduct{
        return products[index]
    }

    fun getCount():Int{
        return products.size
    }
}