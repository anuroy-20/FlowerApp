package com.example.flowerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class FlowerAboutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val emoji = intent.getStringExtra("emoji") ?: "🌹"
        val name = intent.getStringExtra("name") ?: "Flower"
        val fact1 = intent.getStringExtra("fact1") ?: ""
        val fact2 = intent.getStringExtra("fact2") ?: ""
        val fact3 = intent.getStringExtra("fact3") ?: ""
        val themeColorInt = intent.getIntExtra("themeColor", android.graphics.Color.parseColor("#E8304A"))
        val themeColor = Color(themeColorInt)

        setContent {
            FlowerAboutScreen(
                emoji = emoji,
                name = name,
                fact1 = fact1,
                fact2 = fact2,
                fact3 = fact3,
                themeColor = themeColor,
                onBack = { finish() }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlowerAboutScreen(
    emoji: String,
    name: String,
    fact1: String,
    fact2: String,
    fact3: String,
    themeColor: Color,
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "About $name",
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = themeColor)
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF5F5F5))
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Hero emoji circle
            Box(
                modifier = Modifier
                    .size(130.dp)
                    .background(themeColor.copy(alpha = 0.12f), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(text = emoji, fontSize = 64.sp)
            }

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = name,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1A1A1A)
            )

            Spacer(modifier = Modifier.height(6.dp))

            Surface(
                shape = RoundedCornerShape(20.dp),
                color = themeColor.copy(alpha = 0.12f)
            ) {
                Text(
                    text = "3 Things to Know",
                    fontSize = 12.sp,
                    color = themeColor,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.8.sp,
                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp)
                )
            }

            Spacer(modifier = Modifier.height(28.dp))

            listOf(fact1, fact2, fact3).forEachIndexed { index, fact ->
                FactCard(number = index + 1, fact = fact, themeColor = themeColor)
                Spacer(modifier = Modifier.height(14.dp))
            }
        }
    }
}

@Composable
fun FactCard(number: Int, fact: String, themeColor: Color) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Row(
            modifier = Modifier.padding(18.dp),
            verticalAlignment = Alignment.Top
        ) {
            Box(
                modifier = Modifier
                    .size(38.dp)
                    .background(themeColor, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = number.toString(),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.width(14.dp))

            Text(
                text = fact.trimStart('•', ' '),
                fontSize = 14.sp,
                color = Color(0xFF333333),
                lineHeight = 22.sp,
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 8.dp)
            )
        }
    }
}