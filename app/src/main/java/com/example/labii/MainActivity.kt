package com.example.labii

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.labii.ui.theme.LoginTheme

//Icons
//Investigar porque no me funciono los imports

val IconVisibility: ImageVector = ImageVector.Builder(
    defaultWidth = 24.dp, defaultHeight = 24.dp,
    viewportWidth = 24f, viewportHeight = 24f
).apply {
    path(fill = SolidColor(Color.Black)) {
        moveTo(12f, 4.5f)
        curveTo(7f, 4.5f, 2.73f, 7.61f, 1f, 12f)
        curveTo(2.73f, 16.39f, 7f, 19.5f, 12f, 19.5f)
        curveTo(17f, 19.5f, 21.27f, 16.39f, 23f, 12f)
        curveTo(21.27f, 7.61f, 17f, 4.5f, 12f, 4.5f)
        close()
        moveTo(12f, 17f)
        curveTo(9.24f, 17f, 7f, 14.76f, 7f, 12f)
        curveTo(7f, 9.24f, 9.24f, 7f, 12f, 7f)
        curveTo(14.76f, 7f, 17f, 9.24f, 17f, 12f)
        curveTo(17f, 14.76f, 14.76f, 17f, 12f, 17f)
        close()
        moveTo(12f, 9f)
        curveTo(10.34f, 9f, 9f, 10.34f, 9f, 12f)
        curveTo(9f, 13.66f, 10.34f, 15f, 12f, 15f)
        curveTo(13.66f, 15f, 15f, 13.66f, 15f, 12f)
        curveTo(15f, 10.34f, 13.66f, 9f, 12f, 9f)
        close()
    }
}.build()

val IconVisibilityOff: ImageVector = ImageVector.Builder(
    defaultWidth = 24.dp, defaultHeight = 24.dp,
    viewportWidth = 24f, viewportHeight = 24f
).apply {
    path(fill = SolidColor(Color.Black)) {
        moveTo(12f, 7f)
        curveTo(14.76f, 7f, 17f, 9.24f, 17f, 12f)
        curveTo(17f, 12.65f, 16.87f, 13.26f, 16.64f, 13.83f)
        lineTo(19.56f, 16.75f)
        curveTo(21.07f, 15.49f, 22.26f, 13.86f, 22.99f, 12f)
        curveTo(21.26f, 7.61f, 16.99f, 4.5f, 11.99f, 4.5f)
        curveTo(10.59f, 4.5f, 9.25f, 4.75f, 8.01f, 5.2f)
        lineTo(10.17f, 7.36f)
        curveTo(10.74f, 7.13f, 11.35f, 7f, 12f, 7f)
        close()
        moveTo(2f, 4.27f)
        lineTo(4.28f, 6.55f)
        lineTo(4.73f, 7f)
        curveTo(3.08f, 8.3f, 1.78f, 10.02f, 1f, 12f)
        curveTo(2.73f, 16.39f, 7f, 19.5f, 12f, 19.5f)
        curveTo(13.55f, 19.5f, 15.03f, 19.18f, 16.38f, 18.6f)
        lineTo(16.8f, 19.02f)
        lineTo(19.73f, 22f)
        lineTo(21f, 20.73f)
        lineTo(3.27f, 3f)
        lineTo(2f, 4.27f)
        close()
        moveTo(7.53f, 9.8f)
        lineTo(9.08f, 11.35f)
        curveTo(9.03f, 11.56f, 9f, 11.78f, 9f, 12f)
        curveTo(9f, 13.66f, 10.34f, 15f, 12f, 15f)
        curveTo(12.22f, 15f, 12.44f, 14.97f, 12.65f, 14.92f)
        lineTo(14.2f, 16.47f)
        curveTo(13.53f, 16.8f, 12.79f, 17f, 12f, 17f)
        curveTo(9.24f, 17f, 7f, 14.76f, 7f, 12f)
        curveTo(7f, 11.21f, 7.2f, 10.47f, 7.53f, 9.8f)
        close()
        moveTo(11.84f, 9.02f)
        lineTo(14.99f, 12.17f)
        lineTo(15.01f, 12f)
        curveTo(15.01f, 10.34f, 13.67f, 9f, 12.01f, 9f)
        lineTo(11.84f, 9.02f)
        close()
    }
}.build()

private fun isValidEmail(email: String) =
    android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()

private fun isValidPassword(password: String) = password.length >= 6


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginTheme {
                LoginScreen(
                    onLogin = { _, _ -> },
                    onForgotPassword = {}
                )
            }
        }
    }
}

//Pantalla

@Composable
fun LoginScreen(
    onLogin: (email: String, password: String) -> Unit = { _, _ -> },
    onForgotPassword: () -> Unit = {}
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var submitted by remember { mutableStateOf(false) }

    val emailError    = submitted && !isValidEmail(email)
    val passwordError = submitted && !isValidPassword(password)

    val focusManager = LocalFocusManager.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .systemBarsPadding(),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 28.dp, vertical = 36.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                Text(
                    text = "Bienvenido",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Inicio de Sesión",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(Modifier.height(4.dp))

                // Email
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it.trim() },
                    label = { Text("Correo Electrónico") },
                    leadingIcon = {
                        Icon(Icons.Default.Email, contentDescription = null)
                    },
                    isError = emailError,
                    supportingText = {
                        AnimatedVisibility(visible = emailError) {
                            Text("Ingresa un correo válido")
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Down) }
                    )
                )

                //Contraseña
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Contraseña") },
                    leadingIcon = {
                        Icon(Icons.Default.Lock, contentDescription = null)
                    },
                    trailingIcon = {
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(
                                imageVector = if (passwordVisible) IconVisibilityOff else IconVisibility,
                                contentDescription = if (passwordVisible)
                                    "Ocultar contraseña" else "Mostrar contraseña"
                            )
                        }
                    },
                    isError = passwordError,
                    supportingText = {
                        AnimatedVisibility(visible = passwordError) {
                            Text("Mínimo 6 caracteres")
                        }
                    },
                    visualTransformation = if (passwordVisible)
                        VisualTransformation.None else PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { focusManager.clearFocus() }
                    )
                )

                Button(
                    onClick = {
                        submitted = true
                        if (isValidEmail(email) && isValidPassword(password)) {
                            onLogin(email, password)
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        text = "Iniciar Sesión",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                TextButton(onClick = onForgotPassword) {
                    Text("¿Olvidaste tu contraseña?")
                }
            }
        }
    }
}