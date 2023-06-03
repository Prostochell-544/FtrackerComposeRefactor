package com.examle.ftrackercomposerefactor.ui.elements

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.Role.Companion.Switch
import androidx.compose.ui.unit.dp

var label = "Test"
@Composable
public fun MainUI() {
    var switchOn by remember {
        mutableStateOf(false)
    }
    Text(text = label)
    Spacer(modifier = Modifier.padding(start = 8.dp))
    Switch(checked = switchOn,
        onCheckedChange = { switchOn_ ->
            switchOn = switchOn_})
}
@Composable
fun Switch(
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {}




