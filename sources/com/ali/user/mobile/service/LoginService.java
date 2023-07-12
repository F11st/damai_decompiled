package com.ali.user.mobile.service;

import android.content.Context;
import com.ali.user.mobile.model.CommonCallback;
import com.ali.user.mobile.model.LoginParam;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public interface LoginService {
    void onekeyLogin(Context context, Map<String, String> map, CommonCallback commonCallback);

    void touristLogin(String str, LoginParam loginParam);
}
