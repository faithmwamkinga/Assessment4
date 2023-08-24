package com.example.Assessment4.Model

data class Post(
    var id :  Int,
    var userId:Int,
    var title : String,
    var body : String,

) {
    val thumbnail: Any
        get() {
            TODO()
        }
}
