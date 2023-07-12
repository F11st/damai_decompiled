package com.youku.playerservice.axp;

import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class DrmConfig {
    private String mAuthCode;
    private String mKeyIndex;

    public DrmConfig(String str, String str2) {
        this.mKeyIndex = str;
        this.mAuthCode = str2;
    }

    public String getAuthCode() {
        return this.mAuthCode;
    }

    public String getKeyIndex() {
        return this.mKeyIndex;
    }

    @NonNull
    public String toString() {
        return " keyIndex:" + this.mKeyIndex + " authCode:" + this.mAuthCode;
    }
}
