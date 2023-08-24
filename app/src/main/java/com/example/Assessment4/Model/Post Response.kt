package com.example.Assessment4.Model

data class `PostResponse`(
    var userId:String,
    var id:Int,
    var title:String,
    var body:String
) {
    val posts: List<Post>?
        get() {
            TODO()
        }
}
