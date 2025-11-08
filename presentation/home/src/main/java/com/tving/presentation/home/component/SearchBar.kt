package com.tving.presentation.home.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.tving.designsystem.R
import com.tving.presentation.common.utils.ThemePreview

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    input: String,
    onInputChange: (String) -> Unit = {},
    onClickClear: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 2.dp,
                shape = RoundedCornerShape(4.dp),
                color = Color.Black
            )
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            modifier = Modifier.widthIn(max = 300.dp),
            value = input,
            placeholder = {
                Text(
                    text = "Search videos and images"
                )
            },
            onValueChange = { onInputChange(it) },
            leadingIcon = {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_back),
                    tint = Color.Unspecified,
                    contentDescription = "search button"
                )
            },
            visualTransformation = VisualTransformation.None,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
            ),
            label = null,
            singleLine = true
        )
        Spacer(
            modifier = Modifier.weight(1f)
        )
        if (input.isNotEmpty()) {
            IconButton(
                onClick = onClickClear
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_erase),
                    tint = Color.Unspecified,
                    contentDescription = "erase button"
                )
            }
        }
    }
}

@ThemePreview
@Composable
private fun SearchBarPreview() {
    SearchBar(
        input = "",
        modifier = Modifier.padding(16.dp)
    )
}