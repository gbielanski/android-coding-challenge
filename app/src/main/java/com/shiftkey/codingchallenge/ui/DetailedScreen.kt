package com.shiftkey.codingchallenge.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shiftkey.codingchallenge.R
import com.shiftkey.codingchallenge.domain.*
import com.shiftkey.codingchallenge.domain.FacilityType
import com.shiftkey.codingchallenge.domain.LocalizedSpecialty
import com.shiftkey.codingchallenge.domain.ShiftItem
import com.shiftkey.codingchallenge.domain.Skill

private val shiftItemPreview = ShiftItem(
    shiftId = 1L,
    startTime = "2022-08-20 19:00:00",
    endTime = "2022-08-21 19:00:00",
    isPremiumRate = true,
    isCovid = true,
    kind = "Day Shift",
    skill = Skill(
        name = "Long Term Care",
        color = "#007AFF",
    ),
    facilityType = FacilityType(
        name = "Skilled Nursing Facility",
        color = "#AF52DE"
    ),
    localizedSpecialty = LocalizedSpecialty(
        name = "Certified Nursing Aide",
        abbreviation = "CNA",
        specialty = Specialty(
            name = "Certified Nursing Aide",
            color = "#007AFF",
            abbreviation = "CNA",
        )
    )
)

@Preview
@Composable
fun DetailedScreenPreview() {
    DetailedScreen(
        shiftItem = shiftItemPreview,
        onButtonClicked = {}
    )
}

@Composable
internal fun DetailedScreen(
    shiftItem: ShiftItem,
    onButtonClicked: () -> Unit,
    modifier: Modifier = Modifier.padding(
        horizontal = MarginSize.Large.dp,
        vertical = MarginSize.Small.dp,
    )
) {
    MaterialTheme {
        Surface {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(shiftItem.facilityType.color.toComposeColor())
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(MarginSize.Medium.dp)
                ) {
                    Text(
                        modifier = Modifier.padding(
                            horizontal = MarginSize.Large.dp,
                            vertical = MarginSize.Large.dp,
                        ),
                        text = shiftItem.facilityType.name,
                        fontSize = TextSize.Title.sp,
                    )
                    Text(
                        modifier = modifier,
                        text = shiftItem.startTime,
                        fontSize = TextSize.Body.sp,
                    )
                    Text(
                        modifier = modifier,
                        text = shiftItem.endTime,
                        fontSize = TextSize.Body.sp,
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                shiftItem.skill.color.toComposeColor()
                            ),
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        Text(
                            text = shiftItem.skill.name,
                            fontSize = TextSize.Highlighted.sp,
                        )
                    }
                    Row(
                        modifier = modifier,
                        horizontalArrangement = Arrangement.spacedBy(MarginSize.Medium.dp)
                    ) {
                        Text(
                            text = shiftItem.kind
                        )
                        Row(
                        ) {
                            Text(text = stringResource(R.string.covid))
                            Icon(getIcon(shiftItem.isCovid), contentDescription = "")

                        }
                        Row {
                            Text(text = stringResource(R.string.premium))
                            Icon(getIcon(shiftItem.isPremiumRate), contentDescription = "")
                        }
                    }
                    Box(
                        modifier = modifier
                            .background(shiftItem.localizedSpecialty.specialty.color.toComposeColor())
                    ) {
                        Text(
                            modifier = modifier,
                            text = shiftItem.localizedSpecialty.name,
                            fontSize = TextSize.Highlighted.sp,
                        )
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = { onButtonClicked() }
                    ) {
                        Text(stringResource(R.string.ok))
                    }
                }
            }
        }
    }
}

@Composable
private fun getIcon(positive: Boolean) = if (positive) {
    Icons.Rounded.Check
} else {
    Icons.Rounded.Close
}

enum class MarginSize(val dp: Dp) {
    Small(4.dp),
    Medium(8.dp),
    Large(16.dp);
}

enum class TextSize(val sp: TextUnit) {
    Body(14.sp),
    Highlighted(18.sp),
    Title(24.sp);
}