package com.taobao.tao.remotebusiness.auth;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface AuthListener {
    void onAuthCancel(String str, String str2);

    void onAuthFail(String str, String str2);

    void onAuthSuccess();
}
