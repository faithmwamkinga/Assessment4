package com.example.Assessment4

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.Assessment4.Model.Post
import com.example.Assessment4.api.ApiClient
import com.example.Assessment4.api.ApiInterface
import com.squareup.picasso.Picasso
import com.example.assessment4.databinding.PostlistBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

private fun CoroutineScope.displayPost() {
    TODO("Not yet implemented")
}

private fun <ImageView> Any.into(ivproduct: ImageView) {

}

private fun Any.resize(i: Int, i1: Int): Any {



 fun Any.centerCrop(): Any {



fun Picasso.load(thumbnail: Any): Any {


    class PostDetails : AppCompatActivity() {
        lateinit var binding: PostlistBinding
        lateinit var apiInterface: ApiInterface
        var postId = -1
        private var post: Post? = null


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = PostlistBinding.inflate(layoutInflater)

            setContentView(binding.root)
            apiInterface = ApiClient.buildClient(ApiInterface::class.java)

            val bundle = intent.extras
            if (bundle != null) {
                fetchPostDetails()

            }

//        fun displayPost() {
//            TODO("Not yet implemented")
//        }

            @OptIn(DelicateCoroutinesApi::class)
            fun fetchPostDetails() {
                GlobalScope.launch(Dispatchers.Main) {
                    val response = apiInterface.getPostById(postId)

                    if (response.isSuccessful) {
                        post = response.body()
                        displayPost()

                    } else {
                        Toast.makeText(
                            this@PostDetails,
                            "Error, cannot fetch product details",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }

            fun displayPost() {
                post?.let {
                    binding.tvTitle.text = it.title
                    binding.tvBody.text = it.body

                    Picasso
                        .get()
                        .load(it.thumbnail)
                        .resize(250, 250)
                        .centerCrop()
                        .into(binding.ivpost)

                }


            }

        }

        private fun fetchPostDetails() {
            TODO("Not yet implemented")
        }
//        postId =bundle.getInt("POST_ID",-1)
    }
    return ""
}


class PostDetails {

}
