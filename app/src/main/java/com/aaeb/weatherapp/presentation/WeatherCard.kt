package com.aaeb.weatherapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aaeb.weatherapp.R
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun WeatherCard(
    state: WeatherState?,
    backgroundColor: Color,
    modifier: Modifier = Modifier,
) {
//    state?.weatherInfo?.currentWeatherData?.let { data ->
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
            .padding(15.dp)
            .background(backgroundColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Today ",
                modifier = Modifier.align(Alignment.End),
                color = Color.White
            )
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_cloudy),
                modifier = Modifier.size(150.dp),
                contentDescription = null
            )
            Text(text = "31.7 C", fontSize = 30.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Overcast")
            Spacer(modifier = Modifier.height(25.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.fillMaxWidth()
            ) {
                WeatherDataRow(
                    tintIcon = Color.White,
                    icon = ImageVector.vectorResource(id = R.drawable.ic_snowy),
                    data = "Test"
                )
                WeatherDataRow(
                    tintIcon = Color.White,
                    icon = ImageVector.vectorResource(id = R.drawable.ic_snowy),
                    data = "Test"
                )
                WeatherDataRow(
                    tintIcon = Color.White,
                    icon = ImageVector.vectorResource(id = R.drawable.ic_snowy),
                    data = "Test"
                )
            }
        }
    }
//    }
}