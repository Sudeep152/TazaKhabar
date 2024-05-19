package com.shashank.composable.component

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.shashank.composable.utils.Constants
import com.shashank.composable.utils.Constants.EMPTY_STRING
import com.shashank.composable.utils.Constants.FIVE_DP
import com.shashank.composable.utils.Constants.ONE_DP
import com.shashank.theme.PrimaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomOutlinedTextField(
    onInputTextChange: (String) -> Unit,
    text: String = EMPTY_STRING,
    hintText: String = EMPTY_STRING,
    placeholderText: String = EMPTY_STRING,
    borderColor: Color = Color.Gray,
    borderWidth: Dp = ONE_DP,
    shape: Shape = RectangleShape,
    modifier: Modifier = Modifier,
    isSingleLine: Boolean = true,
    nextFocus: Boolean = false,
    rightDrawable: Int? = null,
    leftDrawable: Int? = null,
    isPasswordField: Boolean = false,
    isEmailField: Boolean = false
) {
    val textFieldValue = remember { mutableStateOf(EMPTY_STRING) }
    val isPasswordVisible = remember { mutableStateOf(false) }

    OutlinedTextField(
        singleLine = isSingleLine,
        modifier = modifier
            .padding(bottom = Constants.TWENTY_DP),
        value = textFieldValue.value,
        onValueChange = {
            textFieldValue.value = it
            onInputTextChange(it)
        },
        placeholder = {
            Text(text = placeholderText)
        },
        label = {
            Text(text = hintText, style = MaterialTheme.typography.bodyMedium)
        },
        visualTransformation = if (isPasswordField) if (isPasswordVisible.value) VisualTransformation.None else PasswordVisualTransformation()
        else VisualTransformation.None,

        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color.LightGray,
            focusedBorderColor = PrimaryColor,
            cursorColor = PrimaryColor,
            focusedLabelColor = PrimaryColor
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = if (isPasswordField) KeyboardType.Password else if (isEmailField) KeyboardType.Email else KeyboardType.Text,
            imeAction = if (nextFocus) ImeAction.Next else ImeAction.Done
        ), trailingIcon = {
            if (isPasswordField) {
                if (textFieldValue.value.isNotEmpty()) {
                    val icon =
                        if (isPasswordVisible.value) Icons.Rounded.Visibility else Icons.Filled.VisibilityOff
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        modifier = Modifier.clickable {
                            isPasswordVisible.value = !isPasswordVisible.value
                        })
                }
            }
        }
    )
}