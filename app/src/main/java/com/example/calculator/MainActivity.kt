package com.example.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var num1 by remember {
                mutableStateOf("")
            }
            var num2 by remember {
                mutableStateOf("")
            }
            Column {
                Spacer(modifier = Modifier.height(250.dp))
                TextField(value = num1, onValueChange = {
                    num1 = it;
                }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
                TextField(value = num2, onValueChange = {
                    num2 = it;
                }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
                Row {
                    Button(onClick = {
                        val result = num1.toDoubleOrNull()?.plus(num2.toDoubleOrNull() ?: 0.0)
                        if (result != null) {
                            Toast.makeText(applicationContext, "Result is $result", Toast.LENGTH_SHORT).show()
                        }
                    }) {
                        Text(text = "Add")
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(onClick = {
                        val result = num1.toDoubleOrNull()?.minus(num2.toDoubleOrNull() ?: 0.0)
                        if (result != null) {
                            Toast.makeText(applicationContext, "Result is $result", Toast.LENGTH_SHORT).show()
                        }
                    }) {
                        Text(text = "Subtract")
                    }
                }
                Row {
                    Button(onClick = {
                        val result = num1.toDoubleOrNull()?.times(num2.toDoubleOrNull() ?: 1.0)
                        if (result != null) {
                            Toast.makeText(applicationContext, "Result is $result", Toast.LENGTH_SHORT).show()
                        }
                    }) {
                        Text(text = "Multiply")
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(onClick = {
                        val num2Double = num2.toDoubleOrNull()
                        if (num2Double != null && num2Double != 0.0) {
                            val result = num1.toDoubleOrNull()?.div(num2Double)
                            if (result != null) {
                                Toast.makeText(applicationContext, "Result is $result", Toast.LENGTH_SHORT).show()
                            }
                        } else {
                            Toast.makeText(applicationContext, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                        }
                    }) {
                        Text(text = "Divide")
                    }
                }
            }
        }
    }
}
