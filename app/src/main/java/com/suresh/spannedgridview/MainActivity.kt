package com.suresh.spannedgridview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.suresh.spannedgridview.adapter.GridItemAdapter
import com.suresh.spannedgridview.customview.SpaceItemDecorator
import com.suresh.spannedgridview.customview.SpanSize
import com.suresh.spannedgridview.customview.SpannedGridLayoutManager

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: GridItemAdapter
    val imageList = listOf(
        R.drawable.imagee,
        R.drawable.imagee,
        R.drawable.imagee,
        R.drawable.imagee,
        R.drawable.imagee,
        R.drawable.imagee
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val photoGrid = findViewById<RecyclerView>(R.id.photoGrid)

        adapter = GridItemAdapter(arrayListOf())

        val spannedGridLayoutManager = SpannedGridLayoutManager(
            orientation = SpannedGridLayoutManager.Orientation.VERTICAL,
            spans = 3
        )
        spannedGridLayoutManager.itemOrderIsStable = true

        photoGrid.layoutManager = spannedGridLayoutManager

        photoGrid.addItemDecoration(
            SpaceItemDecorator(
                left = 3,
                top = 3,
                right = 3,
                bottom = 3
            )
        )
        photoGrid.adapter = adapter
        adapter.setData(imageList)

         spannedGridLayoutManager.spanSizeLookup =
             SpannedGridLayoutManager.SpanSizeLookup { position ->
                 if (position == 0) {
                     SpanSize(2, 2)
                 } else {
                     SpanSize(1, 1)
                 }
             }
    }
}