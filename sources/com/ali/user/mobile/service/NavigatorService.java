package com.ali.user.mobile.service;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.ali.user.mobile.filter.LoginFilterCallback;
import com.ali.user.mobile.model.CommonCallback;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.RegistParam;
import com.ali.user.mobile.model.UrlParam;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public interface NavigatorService {
    void fetchRegisterUrl(Context context, RegistParam registParam);

    void fingerIV(Context context, CommonCallback commonCallback);

    void fingerLogin(Context context, CommonCallback commonCallback);

    void fingerSet(Context context, CommonCallback commonCallback);

    void navToLoginPage(Context context, String str, boolean z);

    void navToLoginPostPage(Context context, String str, LoginFilterCallback loginFilterCallback);

    void navToWebViewPage(String str, UrlParam urlParam);

    void openLoginPage(Context context, String str, Bundle bundle);

    void openRegWebViewPage(Context context, String str, String str2, LoginParam loginParam);

    void openRegWebViewPage(String str, String str2, String str3, LoginParam loginParam);

    void openRegisterPage(Context context, RegistParam registParam);

    void openWebViewPage(Context context, UrlParam urlParam);

    void startWebViewForResult(Activity activity, UrlParam urlParam);
}
