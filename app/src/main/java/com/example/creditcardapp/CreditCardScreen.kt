package com.example.creditcardapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
            ) {
                LazyColumn {
                    items(creditCards) { creditCard->

                        Text(text = "Expiring date: ${creditCard.credit_card_expiry_date}")
                        Text(text = "Credit card type: ${creditCard.credit_card_type}")
                        Text(text = "Credit card number: ${creditCard.credit_card_number}")
                        /*Text(text = creditCard.id.toString())
                        Text(text = creditCard.uid)*/
                        Divider() //add a divider between itemsœœ
                    }
                }
            }

        }
    }

}