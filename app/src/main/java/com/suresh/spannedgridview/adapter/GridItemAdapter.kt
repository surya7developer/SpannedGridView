package com.suresh.spannedgridview.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.facebook.common.util.UriUtil
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.interfaces.DraweeController
import com.facebook.drawee.view.SimpleDraweeView
import com.suresh.spannedgridview.R


class GridItemAdapter(var imageList: List<Int>) :
    RecyclerView.Adapter<GridItemAdapter.GridItemViewHolder>() {

    inner class GridItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView = view.findViewById<AppCompatImageView>(R.id.image)
    //    val profilePhotoView = view.findViewById<SimpleDraweeView>(R.id.profilePhotoView)
    }


    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): GridItemViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        val itemChoiceViewHolder = inflater.inflate(
            R.layout.item_photos_picker, viewGroup, false
        )
        return GridItemViewHolder(itemChoiceViewHolder)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun onBindViewHolder(holder: GridItemViewHolder, position: Int) {
       /* val uri = Uri.Builder()
            .scheme(UriUtil.LOCAL_RESOURCE_SCHEME) // "res"
            .path(java.lang.String.valueOf(imageList[position]))
            .build()

        val controllerOne: DraweeController = Fresco.newDraweeControllerBuilder()
            .setUri("https://dummyimage.com/900x700/663399/fff")
            .setAutoPlayAnimations(true)
            .build()
        holder.profilePhotoView.controller = controllerOne*/

        holder.imageView.setImageResource(imageList[position])
        //holder.profilePhotoView.setImageURI(uri);
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    fun setData(imageList: List<Int>) {
        this.imageList = imageList
        notifyDataSetChanged()
    }


}