package com.example.Assessment4.Viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.Assessment4.Model.Post
import com.example.Assessment4.Repository.PostRepository
import kotlinx.coroutines.launch

class PostViewModel:ViewModel() {
    val postRepo=PostRepository()
    val postLiveData=MutableLiveData<List<Post>>()
    var errLiveData=MutableLiveData<String>()

    fun fetchPosts(){
        viewModelScope.launch {
            val response=postRepo.getPost()
            if (response.isSuccessful){
                postLiveData.postValue(response.body()?.posts)
            }
            else{
                errLiveData.postValue(response.errorBody()?.string())
            }
        }
    }

}