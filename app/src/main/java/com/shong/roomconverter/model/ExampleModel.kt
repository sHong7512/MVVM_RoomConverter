package com.shong.roomconverter.model


data class ExampleModel(
    var name: String,
    var timeMillis: Long,
    var friend: Friend?,
    var contact: Contact?
)

data class Contact(
    var email: String,
    var phone: String?
)

data class Friend(
    var name: String,
    var contact: Contact?
)