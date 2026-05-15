package com.channapatna.nammapride.ui.ai

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.channapatna.nammapride.databinding.ItemChatBotBinding
import com.channapatna.nammapride.databinding.ItemChatUserBinding
import com.channapatna.nammapride.model.ChatMessage

class ChatAdapter(private val messages: List<ChatMessage>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_BOT = 0
        private const val TYPE_USER = 1
    }

    inner class BotViewHolder(val binding: ItemChatBotBinding) :
        RecyclerView.ViewHolder(binding.root)

    inner class UserViewHolder(val binding: ItemChatUserBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun getItemViewType(position: Int) =
        if (messages[position].isBot) TYPE_BOT else TYPE_USER

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == TYPE_BOT) {
            BotViewHolder(
                ItemChatBotBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        } else {
            UserViewHolder(
                ItemChatUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val msg = messages[position]
        when (holder) {
            is BotViewHolder -> {
                holder.binding.tvMessage.text = msg.text
                holder.binding.tvTime.text = msg.timestamp
            }
            is UserViewHolder -> {
                holder.binding.tvMessage.text = msg.text
                holder.binding.tvTime.text = msg.timestamp
            }
        }
    }

    override fun getItemCount() = messages.size
}
