package com.ali.user.mobile.service;

import com.ali.user.mobile.callback.FingerCallback;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public interface FingerprintService {
    public static final int ERROR_CRYPTO_NOT_INIT = 100;

    void authenticate(FingerCallback fingerCallback);

    void cancelIdentify();

    boolean isFingerprintAvailable();

    boolean isFingerprintSetable();

    void remoteFingerId(String str);
}
