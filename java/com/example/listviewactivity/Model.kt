package com.example.listviewactivity

data class User(val name : String , val des : String)

data class UserItem(val user: User , var isSelected : Boolean)