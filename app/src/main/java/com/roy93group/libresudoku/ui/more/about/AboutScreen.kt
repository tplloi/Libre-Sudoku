package com.roy93group.libresudoku.ui.more.about

import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.roy93group.libresudoku.BuildConfig
import com.roy93group.libresudoku.R
import com.roy93group.libresudoku.ext.moreApp
import com.roy93group.libresudoku.ext.openBrowserPolicy
import com.roy93group.libresudoku.ext.openUrlInBrowser
import com.roy93group.libresudoku.ext.rateApp
import com.roy93group.libresudoku.ext.shareApp
import com.roy93group.libresudoku.ui.components.PreferenceRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(
    activity: Activity,
    navigateBack: () -> Unit,
    navigateOpenSourceLicenses: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.about_title)) },
                navigationIcon = {
                    IconButton(onClick = navigateBack) {
                        Icon(
                            painter = painterResource(R.drawable.ic_round_arrow_back_24),
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.size(56.dp),
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = null,
                )
                Text(
                    textAlign = TextAlign.Center,
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.titleLarge
                )
            }

            HorizontalDivider()

            PreferenceRow(
                title = stringResource(R.string.about_version),
                subtitle = BuildConfig.VERSION_NAME,
                painter = painterResource(R.drawable.ic_outline_info_24),
            )

//            val uriHandler = LocalUriHandler.current
            PreferenceRow(
                title = stringResource(R.string.rate),
                painter = painterResource(R.drawable.baseline_rate_review_24),
                onClick = {
                    activity.rateApp(activity.packageName)
                }
            )
            PreferenceRow(
                title = stringResource(R.string.more),
                painter = painterResource(R.drawable.baseline_card_giftcard_24),
                onClick = {
                    activity.moreApp()
                }
            )
            PreferenceRow(
                title = stringResource(R.string.share_app),
                painter = painterResource(R.drawable.baseline_ios_share_24),
                onClick = {
                    activity.shareApp()
                }
            )
            PreferenceRow(
                title = stringResource(R.string.policy),
                painter = painterResource(R.drawable.baseline_local_police_24),
                onClick = {
                    activity.openBrowserPolicy()
                }
            )
            PreferenceRow(
                title = stringResource(R.string.about_github_project),
                painter = painterResource(R.drawable.ic_github_24dp),
                onClick = {
                    activity.openUrlInBrowser("https://github.com/tplloi/Libre-Sudoku/tree/dev")
                }
            )

            PreferenceRow(
                title = stringResource(R.string.libraries_licenses_title),
                painter = painterResource(R.drawable.ic_outline_info_24),
                onClick = navigateOpenSourceLicenses
            )
        }
    }
}