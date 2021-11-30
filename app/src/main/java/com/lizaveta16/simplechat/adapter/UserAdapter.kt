package com.lizaveta16.simplechat.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lizaveta16.simplechat.databinding.UserListItemBinding
import com.lizaveta16.simplechat.model.User

class UserAdapter : ListAdapter<User, UserAdapter.UserHolder>(UserComparator()){

    class UserHolder(private val binding: UserListItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(user : User) = with(binding){
            message.text = user.message
            userName.text = user.name
        }

        companion object{
            fun create(parent: ViewGroup) : UserHolder{
                return UserHolder(UserListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            }
        }
    }

    class UserComparator() : DiffUtil.ItemCallback<User>(){
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        return UserHolder.create(parent)
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.bind(getItem(position))
    }
}