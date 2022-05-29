package com.juhnowski.dosimetr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.juhnowski.dosimetr.ui.theme.DosimetrTheme

class AboutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DosimetrTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AboutCompose()
                }
            }
        }
    }
}

@Composable
fun AboutCompose() {
    Card {
        var expanded by remember {
            mutableStateOf(false)
        }
        Column(Modifier.clickable {expanded = !expanded}){
            Image(painter = painterResource(R.drawable.profile_picture ),
                  contentDescription = null,
                modifier = Modifier
                    .size(400.dp)
                    .clip(CircleShape)
            )
            AnimatedVisibility(!expanded) {
                Column {
                    Text(
                        text = "Версия:" + BuildConfig.VERSION_NAME,
                        style = MaterialTheme.typography.h4
                    )
                    Text(
                        text = "подробнее..."
                    )
                }

            }
            AnimatedVisibility(expanded) {
                Column{
                    Text(
                        text = "Dosimetr App",
                        style = MaterialTheme.typography.h4
                    )
                    Text(text = "Date: 24.05.2022")
                    Text(text = "Начальная версия - пока ничего не работает")
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DosimetrTheme {
        AboutCompose()
    }
}