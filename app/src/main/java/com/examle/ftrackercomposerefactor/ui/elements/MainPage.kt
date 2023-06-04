@file:Suppress("UNUSED_EXPRESSION")

package com.examle.ftrackercomposerefactor.ui.elements

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties

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
public fun EditText() {
    val textState = remember { mutableStateOf(TextFieldValue()) }
    Column(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = textState.value,
            onValueChange = { textState.value = it },
            label = { Text("Test") },
            keyboardOptions = KeyboardOptions.Default,
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        )
    }
}
@Composable
public fun AcceptButton(text: String, onClick: (String) -> Unit) {
    Button(onClick = { onClick(text) }) {
        Text(text = "Assert")
    }
}
//@ExperimentalMaterial3Api
//@Composable
//public fun AlertDialog(
//    onDismissRequest: () -> Unit,
//    modifier: Modifier = Modifier,
//    properties: DialogProperties = DialogProperties(),
//    content: @Composable () -> Unit
//): Unit {
//}






