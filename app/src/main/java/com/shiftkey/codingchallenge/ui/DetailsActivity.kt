package com.shiftkey.codingchallenge.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    Column {
                        Text(text = "Title")
                    }
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = { finish() }
                    ) {
                        Text("Ok")
                    }
//                    AlertDialog(
//                        onDismissRequest = {},
//                        title = {
//                            Text(text = "Title")
//                        },
//                        text = {
//                            Column {
//                                TextField(
//                                    value = "",
//                                    onValueChange = {}
//                                )
//                                Text("Custom Text")
//                                Checkbox(checked = false, onCheckedChange = {})
//                            }
//                        },
//                        buttons = {
//                            Row(
//                                modifier = Modifier.padding(all = 8.dp),
//                                horizontalArrangement = Arrangement.Center
//                            ) {
//                                Button(
//                                    modifier = Modifier.fillMaxWidth(),
//                                    onClick = { }
//                                ) {
//                                    Text("Dismiss")
//                                }
//                            }
//                        }
//                    )
                }
            }
        }
    }
}