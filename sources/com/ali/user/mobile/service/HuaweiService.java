package com.ali.user.mobile.service;

import android.content.Context;
import com.ali.user.mobile.callback.CommonDataCallback;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public interface HuaweiService {
    void getAuthCode(CommonDataCallback commonDataCallback);

    void init(Context context);

    boolean isSessionValid();

    void launchAuth(Context context, CommonDataCallback commonDataCallback);
}
