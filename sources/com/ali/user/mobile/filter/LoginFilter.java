package com.ali.user.mobile.filter;

import android.app.Activity;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public interface LoginFilter {
    void onLoginFail(int i, String str);

    void onLoginSuccess(Activity activity, LoginFilterCallback loginFilterCallback);
}
