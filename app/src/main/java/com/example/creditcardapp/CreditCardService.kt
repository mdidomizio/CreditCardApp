package com.example.creditcardapp

import retrofit2.http.GET

//set up retrofit (interface for defining the API endpoints
interface CreditCardService {
    @GET("credit_cards?size=10")
    suspend fun getCreditCards(): List<CreditCard>
}