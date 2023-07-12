package com.ali.user.mobile.url.service.impl;

import android.content.Context;
import android.text.TextUtils;
import com.ali.user.mobile.callback.CommonDataCallback;
import com.ali.user.mobile.common.api.AliUserLogin;
import com.ali.user.mobile.common.api.LoginApprearanceExtensions;
import com.ali.user.mobile.helper.IUccInterface;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.model.UrlParam;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class UrlUtil {
    public static final String TAG = "login.urlUtil";

    public static void OpenUCC(Context context, UrlParam urlParam, CommonDataCallback commonDataCallback) {
        if (urlParam == null || TextUtils.isEmpty(urlParam.url)) {
            return;
        }
        LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
        if (loginApprearanceExtensions != null && loginApprearanceExtensions.getUccHelper() != null) {
            try {
                ((IUccInterface) AliUserLogin.mAppreanceExtentions.getUccHelper().newInstance()).openUrl(context, urlParam, commonDataCallback);
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        TLogAdapter.e(TAG, "no ucc helper ");
    }
}
