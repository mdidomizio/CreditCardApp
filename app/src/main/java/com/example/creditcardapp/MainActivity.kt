package com.example.creditcardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels


class MainActivity : ComponentActivity() {

    private val viewModel: CreditCardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CreditCardScreen(viewModel)
        }
    }
}

