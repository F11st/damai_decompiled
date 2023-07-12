package com.ali.user.mobile.callback;

import android.hardware.fingerprint.FingerprintManager;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public interface FingerCallback {
    void onAuthenticationError(int i, CharSequence charSequence);

    void onAuthenticationFailed();

    void onAuthenticationHelp(int i, CharSequence charSequence);

    void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult);
}
