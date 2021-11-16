package com.example.dz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var editTextTaskProduct:EditText
    lateinit var buttonAddTask:Button
    lateinit var recyclerVeiwProductList:RecyclerView

    lateinit var productManager: ProductManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        productManager = ProductManager()

        editTextTaskProduct = findViewById(R.id.editTextTaskProduct)

        buttonAddTask = findViewById(R.id.buttonAddTask)
        buttonAddTask.setOnClickListener(buttonAddProductOnClick)

        recyclerVeiwProductList = findViewById(R.id.recyclerVeiwProductList)
        var llm = LinearLayoutManager(applicationContext)
        recyclerVeiwProductList.layoutManager = llm
    }

    private val buttonAddProductOnClick:View.OnClickListener = View.OnClickListener {
        var name = editTextTaskProduct.text.toString()
        editTextTaskProduct.text.clear()

        var product:ItemProduct = ItemProduct(name)
        productManager.addProduct(product)

        var rvAdapter:RvAdapter = RvAdapter(productManager)
        recyclerVeiwProductList.adapter = rvAdapter

    }
}