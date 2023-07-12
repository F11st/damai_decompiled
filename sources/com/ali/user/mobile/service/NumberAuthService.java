package com.ali.user.mobile.service;

import android.content.Context;
import com.ali.user.mobile.callback.CommonDataCallback;
import com.ali.user.mobile.model.NumAuthCallback;
import com.ali.user.mobile.model.NumAuthCheckCallback;
import com.ali.user.mobile.model.NumAuthTokenCallback;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public interface NumberAuthService {
    boolean checkAuth();

    Map<String, String> getAuthInfoMap();

    void getLoginMaskPhone(int i, CommonDataCallback commonDataCallback);

    void getLoginMaskPhone(int i, String str, CommonDataCallback commonDataCallback);

    void getLoginToken(String str, NumAuthTokenCallback numAuthTokenCallback);

    void getToken(NumAuthTokenCallback numAuthTokenCallback);

    boolean hasPreFecthMaskPhone();

    void init(Context context, NumAuthCallback numAuthCallback);

    void isCan4GAuth(NumAuthCheckCallback numAuthCheckCallback);

    boolean isCan4GAuth();

    boolean isInited();

    boolean needPrefetch();

    void preFecth();

    void preFecth(String str);
}
