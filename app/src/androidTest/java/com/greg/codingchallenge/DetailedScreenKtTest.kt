package com.greg.codingchallenge

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.greg.codingchallenge.ui.DetailedScreen
import org.junit.Rule
import org.junit.Test

class DetailedScreenKtTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `detailedScreenShouldDisplayShiftData`() {
        composeTestRule.setContent {
            DetailedScreen(screenState = testScreenState, onButtonClicked = { })
        }

        composeTestRule.onNodeWithText(START_TIME).assertIsDisplayed()
        composeTestRule.onNodeWithText(END_TIME).assertIsDisplayed()
        composeTestRule.onNodeWithText(KIND).assertIsDisplayed()
        composeTestRule.onNodeWithText(SKILL).assertIsDisplayed()
        composeTestRule.onNodeWithText(FACILITY).assertIsDisplayed()
    }
}
