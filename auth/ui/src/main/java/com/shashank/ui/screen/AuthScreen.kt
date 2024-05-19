package com.shashank.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.shashank.composable.component.CustomButton
import com.shashank.composable.component.CustomOutlinedTextField
import com.shashank.composable.utils.Constants.FIFTEEN_DP
import com.shashank.composable.utils.Constants.FIFTY_DP
import com.shashank.composable.utils.Constants.FIVE_HUNDRED_DP
import com.shashank.composable.utils.Constants.ONE_FIFTY_DP
import com.shashank.composable.utils.Constants.THIRTY_DP
import com.shashank.composable.utils.Constants.TWO_HUNDRED_DP
import com.shashank.theme.DarkGrayColor
import com.shashank.theme.GrayColor
import com.shashank.theme.PrimaryColor
import com.shashank.theme.TazaKhabarTheme
import com.shashank.ui.R

@Composable
fun AuthenticationScreen(navigation: () -> Unit, navController: NavHostController) {
    val scrollState = rememberScrollState()
    val isRegisterScreen = remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = FIFTEEN_DP)
            .verticalScroll(scrollState)
    ) {

        Icon(
            modifier = Modifier
                .padding(vertical = THIRTY_DP)
                .clickable {
                    navController.popBackStack()
                },
            painter = painterResource(id = R.drawable.ic_back),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onBackground

        )

        Text(
            text = if (!isRegisterScreen.value) "Welcome back!" else "Sign up and get news!",
            Modifier
                .fillMaxWidth()
                .padding(vertical = FIFTEEN_DP),
            style = MaterialTheme.typography.titleLarge
        )
        if (!isRegisterScreen.value) {
            Text(
                text = "Let's sign you in to your account",
                Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.labelMedium,
                color = DarkGrayColor
            )
        }

        Spacer(modifier = Modifier.height(ONE_FIFTY_DP))

        if (isRegisterScreen.value)
            CustomOutlinedTextField(
                onInputTextChange = {},
                hintText = "Name",
                placeholderText = "Enter your name",
                modifier = Modifier.fillMaxWidth(),
                isSingleLine = true,
                nextFocus = true,
                isEmailField = true
            )

        CustomOutlinedTextField(
            onInputTextChange = {},
            hintText = "Email",
            placeholderText = "Enter your email",
            modifier = Modifier.fillMaxWidth(),
            isSingleLine = true,
            nextFocus = true,
            isEmailField = true
        )

        CustomOutlinedTextField(
            onInputTextChange = {},
            hintText = "Password",
            placeholderText = "Enter you password",
            modifier = Modifier.fillMaxWidth(),
            isPasswordField = true
        )

        if (!isRegisterScreen.value)
            Text(
                text = "Forgot password?",
                Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.bodyMedium,
                color = PrimaryColor,
                textAlign = TextAlign.End
            )
        Spacer(modifier = Modifier.height(FIFTY_DP))

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
            Column {
                CustomButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(FIFTY_DP),
                    label = if (isRegisterScreen.value) "Sign up" else "Login",
                    onClick = {
                        navigation()
                    },
                    border = false,
                    textStyle = MaterialTheme.typography.labelLarge
                )
                Spacer(modifier = Modifier.height(FIFTEEN_DP))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = GrayColor, RoundedCornerShape(8.dp))
                        .height(FIFTY_DP),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_google),
                        contentDescription = "ic_google"
                    )
                }
                val annotatedString = buildAnnotatedString {
                    append(if (isRegisterScreen.value) "Already have an account?" else "Don’t have account?")
                    withStyle(style = SpanStyle(PrimaryColor)) {
                        append(if (isRegisterScreen.value) "Login " else " Sign up")
                    }
                }

                Spacer(modifier = Modifier.height(FIFTEEN_DP))

                Text(
                    text = annotatedString,
                    Modifier
                        .fillMaxWidth()
                        .clickable {
                            isRegisterScreen.value = !isRegisterScreen.value
                        },
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}



