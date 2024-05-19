package com.shashank.composable.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shashank.theme.PrimaryColor

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    label: String = "Done",
    labelColor: Color = Color.White,
    onClick: () -> Unit,
    border: Boolean = false,
    borderStrokeWidth: Int? = 1,
    borderColor: Color = Color.White,
    buttonColor: Color = PrimaryColor,
    disabledButtonColor: Color = Color.Gray,
    disabledButtonTextColor: Color = Color.Black,
    icon: @Composable (() -> Unit)? = null,
    iconColor: Color = Color.White,
    iconPadding: Int = 0,
    buttonShape: RoundedCornerShape = RoundedCornerShape(8.dp),
    textStyle: TextStyle = MaterialTheme.typography.labelLarge
) {

    Button(
        modifier = modifier,
        onClick = { onClick()},
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = buttonColor,
            contentColor = labelColor,
            disabledContainerColor = disabledButtonColor,
            disabledContentColor = disabledButtonTextColor
        ),
        shape = buttonShape,

    ) {
        Text(text = label, style = textStyle)
    }
}


@Preview(showBackground = true)
@Composable
fun CustomButtonPreview() {
    CustomButton(onClick = { /*TODO*/ })
}