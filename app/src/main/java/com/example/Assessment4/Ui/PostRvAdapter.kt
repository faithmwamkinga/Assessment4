package com.example.Assessment4.Ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.Assessment4.Model.Post
//import com.example.Assessment4.PostDetails
import com.example.assessment4.databinding.PostlistBinding
import com.squareup.picasso.Picasso

private val ViewBinding.cvPost: Any
    get() {
        TODO("Not yet implemented")
    }

class PostRvAdapter(private val postList: List<Post>, var context: Context) : RecyclerView.Adapter<PostRvAdapter.PostViewHolder>() {

    override fun <PostViewHolder> onCreateViewHolder(parent: ViewGroup, viewType: Int): PostRvAdapter.PostViewHolder {
        val binding = PostlistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    fun getPostCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = postList[position]
        val binding = holder.binding

        binding.tvTitle.text = "${post.title}"
        binding.tvBody.text = "${post.body}"

        Picasso.get()
            .load(post.thumbnail)
            .resize(250, 250)
            .into(binding.ivpost)

        holder.binding.cvPost.setOnClickListener {
            val intent = Intent(context, PostDetails::class.java)
            intent.putExtra("POST_ID", post.id)
            context.startActivity(intent)

        }
    }

    class PostDetails {

    }

    override fun getItemCount(): Int {
        return postList.size
    }

    class PostViewHolder(var binding: PostlistBinding) : RecyclerView.ViewHolder(binding.root)


}
