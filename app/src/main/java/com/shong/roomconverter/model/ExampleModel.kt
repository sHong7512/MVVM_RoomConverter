package com.shong.roomconverter.model


data class ExampleModel(
    var user: User,
    var timeMillis: Long,
    var friend: Friend?,
    var contact: Contact?
)

data class User(
    var name : String,
    var americanAge : Int?,
)

data class Contact(
    var email: String,
    var phone: String?
)

data class Friend(
    var user: User,
    var contact: Contact?
)