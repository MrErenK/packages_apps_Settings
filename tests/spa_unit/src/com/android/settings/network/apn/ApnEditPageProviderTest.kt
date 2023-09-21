/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.network.apn

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onChild
import androidx.compose.ui.test.onChildAt
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performScrollToNode
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.android.settings.R
import com.google.common.truth.Truth
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ApnEditPageProviderTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val context: Context = ApplicationProvider.getApplicationContext()
    private val apnName = "apn_name"
    private val mmsc = "mmsc"
    private val mmsProxy = "mms_proxy"
    private val mnc = "mnc"
    private val apnType = "apn_type"
    private val apnRoaming = "IPv4"
    private val apnEnable = context.resources.getString(R.string.carrier_enabled)
    private val apnData = ApnData(
        name = apnName,
        mmsc = mmsc,
        mmsProxy = mmsProxy,
        mnc = mnc,
        apnType = apnType,
        apnRoaming = apnRoaming,
        apnEnable = true
    )

    @Test
    fun apnEditPageProvider_name() {
        Truth.assertThat(ApnEditPageProvider.name).isEqualTo("Apn")
    }

    @Test
    fun title_displayed() {
        composeTestRule.setContent {
            ApnPage(remember {
                mutableStateOf(apnData)
            })
        }
        composeTestRule.onNodeWithText(context.getString(R.string.apn_edit)).assertIsDisplayed()
    }

    @Test
    fun name_displayed() {
        composeTestRule.setContent {
            ApnPage(remember {
                mutableStateOf(apnData)
            })
        }
        composeTestRule.onNodeWithText(apnName, true).assertIsDisplayed()
    }

    @Test
    fun mmsc_displayed() {
        composeTestRule.setContent {
            ApnPage(remember {
                mutableStateOf(apnData)
            })
        }
        composeTestRule.onRoot().onChild().onChildAt(0)
            .performScrollToNode(hasText(mmsc, true))
        composeTestRule.onNodeWithText(mmsc, true).assertIsDisplayed()
    }

    @Test
    fun mms_proxy_displayed() {
        composeTestRule.setContent {
            ApnPage(remember {
                mutableStateOf(apnData)
            })
        }
        composeTestRule.onRoot().onChild().onChildAt(0)
            .performScrollToNode(hasText(mmsProxy, true))
        composeTestRule.onNodeWithText(mmsProxy, true).assertIsDisplayed()
    }

    @Test
    fun mnc_displayed() {
        composeTestRule.setContent {
            ApnPage(remember {
                mutableStateOf(apnData)
            })
        }
        composeTestRule.onRoot().onChild().onChildAt(0)
            .performScrollToNode(hasText(mnc, true))
        composeTestRule.onNodeWithText(mnc, true).assertIsDisplayed()
    }

    @Test
    fun apn_type_displayed() {
        composeTestRule.setContent {
            ApnPage(remember {
                mutableStateOf(apnData)
            })
        }
        composeTestRule.onRoot().onChild().onChildAt(0)
            .performScrollToNode(hasText(apnType, true))
        composeTestRule.onNodeWithText(apnType, true).assertIsDisplayed()
    }

    @Test
    fun apn_roaming_displayed() {
        composeTestRule.setContent {
            ApnPage(remember {
                mutableStateOf(apnData)
            })
        }
        composeTestRule.onRoot().onChild().onChildAt(0)
            .performScrollToNode(hasText(apnRoaming, true))
        composeTestRule.onNodeWithText(apnRoaming, true).assertIsDisplayed()
    }

    @Test
    fun carrier_enabled_displayed() {
        composeTestRule.setContent {
            ApnPage(remember {
                mutableStateOf(apnData)
            })
        }
        composeTestRule.onRoot().onChild().onChildAt(0)
            .performScrollToNode(hasText(apnEnable, true))
        composeTestRule.onNodeWithText(apnEnable, true).assertIsDisplayed()
    }

    @Test
    fun carrier_enabled_isChecked() {
        composeTestRule.setContent {
            ApnPage(remember {
                mutableStateOf(apnData)
            })
        }
        composeTestRule.onRoot().onChild().onChildAt(0)
            .performScrollToNode(hasText(apnEnable, true))
        composeTestRule.onNodeWithText(apnEnable, true).assertIsOn()
    }
}