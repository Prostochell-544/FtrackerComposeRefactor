@file:Suppress("UNUSED_EXPRESSION")

package com.examle.ftrackercomposerefactor.ui.elements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

class MainPage {
    var phoneNumberSetter: String? = null

    @Composable
    public fun SwitchWithLabel(label: String, state: Boolean, onStateChange: (Boolean) -> Unit) {

        val checkedState = remember { mutableStateOf(value = false) }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(text = label)
            Spacer(modifier = Modifier.padding(start = 8.dp))
            Switch(
                checked = checkedState.value,
                onCheckedChange = { checkedState.value = it }
            )
        }
    }

    @Composable
    public fun PhoneNumberInput() {
        var phoneNumber by remember { mutableStateOf("") }

        Column {
            OutlinedTextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                label = { Text("Phone number") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
            )

            Button(onClick = {
                phoneNumberSetter = phoneNumber
                println("Phone number is $phoneNumber")
            }) {
                Text("Apply")


            }
        }
    }
}







