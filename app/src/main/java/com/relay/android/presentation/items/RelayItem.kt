package com.relay.android.presentation.items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.relay.android.domain.model.RelayModel
import com.relay.android.presentation.ui.theme.RelaySystemAndroidTheme
import java.time.LocalDate
import java.time.OffsetDateTime
import java.time.temporal.ChronoUnit
import java.util.*

@Composable
fun RelayItem(
    relayModel: RelayModel,
    modifier: Modifier
) {

    val color = Color(
        Random().nextInt(256),
        Random().nextInt(256),
        Random().nextInt(256),
        alpha = 30
    )

    Box(modifier = modifier) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(color)
                .padding(vertical = 16.dp, horizontal = 24.dp)
        ) {
            Column {
                Text(
                    text = relayModel.id.toString(),
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = relayModel.type,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(top = 24.dp)
                )

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = relayModel.createdAt.toLocalDateTime()
                            .truncatedTo(ChronoUnit.MINUTES).toString(),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light,
                        modifier = Modifier
                            .padding(top = 24.dp)
                    )
                    Text(
                        text = "${relayModel.nextCheckDate.dayOfMonth} ${relayModel.nextCheckDate.month} ${relayModel.nextCheckDate.year}".lowercase(),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light,
                        modifier = Modifier
                            .padding(top = 24.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RelayItemPreview() {
    val item = RelayModel(
        id = 1,
        type = "NMH-400",
        createdAt = OffsetDateTime.now(),
        updatedAt = OffsetDateTime.now()
            .plusMinutes(Random().nextInt(100).toLong()),
        nextCheckDate = LocalDate.now().plusMonths(Random().nextInt(10).toLong())
    )
    RelaySystemAndroidTheme {
        RelayItem(item, modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp))
    }
}