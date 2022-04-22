package com.example.authentication.presentation.util

import android.app.Activity
import android.util.Log
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.CommonStatusCodes

@Composable
fun StartActivityForResult(
    key: Any,
    onResultReceived: (String) -> Unit,
    onDialogDismissed: () -> Unit,
    launcher: (ManagedActivityResultLauncher<IntentSenderRequest, ActivityResult>) -> Unit
){
    val activity = LocalContext.current as Activity
    val activityLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartIntentSenderForResult()
    ) { result ->
        try {
            if (result.resultCode == Activity.RESULT_OK) {
                val oneTapClient = Identity.getSignInClient(activity)
                val credentials = oneTapClient.getSignInCredentialFromIntent(result.data)
                val tokenId = credentials.googleIdToken
                if (tokenId != null) {
                    onResultReceived(tokenId)
                } else {
                    Log.d("StartActivityForResult", "BLACK SCRIM CLICKED< DIALOG CLOSED")
                    onDialogDismissed()
                }
            }
        } catch (e: ApiException) {
            when (e.statusCode) {
                CommonStatusCodes.CANCELED -> {
                    Log.d("StartActivityForResult", "ONE-TAP DIALOG CANCELED.")
                    onDialogDismissed()
                }
                CommonStatusCodes.NETWORK_ERROR -> {
                    Log.d("StartActivityForResult", "ONE-TAP NETWORK ERROR.")
                    onDialogDismissed()
                }
                else -> {
                    Log.d("StartActivityForResult", "${e.message}")
                    onDialogDismissed()
                }
            }
        }
    }

    LaunchedEffect(key1 = key) {
        launcher(activityLauncher)
    }
}