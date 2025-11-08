package com.tving.presentation.contentdetail.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tving.presentation.common.utils.ThemePreview

@Composable
fun InfoItem(
    modifier: Modifier = Modifier,
    label: String,
    value: String
) {
    Column(
        modifier = modifier
    ) {
        Text(text = label)
        Text(
            modifier = Modifier.padding(top = 2.dp),
            text= value,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
    }
}

@ThemePreview
@Composable
private fun InfoItemPreview() {
    InfoItem(
        label = "Type",
        value = "Photo"
    )
}
