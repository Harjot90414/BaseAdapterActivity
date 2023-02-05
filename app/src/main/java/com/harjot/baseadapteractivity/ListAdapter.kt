package com.harjot.baseadapteractivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

/**
 * @Author: 017
 * @Date: 03/02/23
 * @Time: 4:56 PM
 */

class ListAdapter(var userArray: ArrayList<UserModel>, var clickInterface: ClickInterface) : BaseAdapter() {
    override fun getCount(): Int {
        return userArray.size
    }

    override fun getItem(position: Int): UserModel {
        return userArray[position]
    }

    override fun getItemId(position: Int): Long {
        return 767
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = LayoutInflater.from(parent?.context)
            .inflate(R.layout.item_base_adapter,
                parent, false)

        var tvName = view.findViewById<TextView>(R.id.tvName)
        var tvRollno = view.findViewById<TextView>(R.id.tvRollno)
        var tvPhoneno = view.findViewById<TextView>(R.id.tvPhoneno)
        var ivEdit = view.findViewById<ImageView>(R.id.ivEdit)
        var ivDelete = view.findViewById<ImageView>(R.id.ivDelete)

        tvName.setText(userArray[position].name)
        tvRollno.setText(userArray[position].rollno.toString())
        tvPhoneno.setText(userArray[position].phoneno.toString())
//        view.setOnClickListener {
//            System.out.println("in click")
//            clickInterface.listClick(position)
//        }

        ivEdit.setOnClickListener {
            clickInterface.editClick(position)
        }
        ivDelete.setOnClickListener {
            clickInterface.deleteClick(position)
        }
        return view

    }
}