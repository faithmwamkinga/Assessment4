package com.example.Assessment4.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.Assessment4.Model.Post
import com.example.Assessment4.Viewmodel.PostViewModel
import com.example.assessment4.databinding.ActivityMainBinding

//there was a databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val postViewModel:PostViewModel by viewModels()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }

    override fun onResume() {
        super.onResume()
        postViewModel.fetchPosts()

        postViewModel.errLiveData.observe(this, Observer { err->
            Toast.makeText(baseContext,err,Toast.LENGTH_SHORT).show() })

        postViewModel.postLiveData.observe(this, Observer { postList:List<Post>->
            binding.rvposts.layoutManager=GridLayoutManager(this@MainActivity,2)
            binding.rvposts.adapter =PostRvAdapter(postList,this)

        })


        }
    }




