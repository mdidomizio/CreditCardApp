package com.example.creditcardapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState

@Composable
fun CreditCardScreen(viewModel: CreditCardViewModel) {
    val creditCards by viewModel.creditCards.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        viewModel.fetchCreditCards()
    }

    Column() {
        if(creditCards.isEmpty()) {
            //show loading indicator or placeholder
            Text(text = "Loading...")
        } else {
            //display the list of credit cards
            LazyColumn {
                items(creditCards) { creditCard->
                    /*Text(text = creditCard.expiringDate)
                    Text(text = creditCard.number)
                    Text(text = creditCard.type)*/
                    Text(text = creditCard.id.toString())
                    Divider() //add a divider between items
                }
            }
        }
    }

}