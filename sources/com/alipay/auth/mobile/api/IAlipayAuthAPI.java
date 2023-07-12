package com.alipay.auth.mobile.api;

import android.app.Activity;
import android.content.Intent;
import com.alipay.auth.mobile.exception.AlipayAuthIllegalArgumentException;
import com.alipay.auth.mobile.exception.PreAlipayAuthException;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IAlipayAuthAPI {
    void handleIntent(Intent intent, IAlipayAuthEventHandler iAlipayAuthEventHandler) throws AlipayAuthIllegalArgumentException;

    boolean isAlipayAppInstalled();

    boolean isAlipayAppSurpportAPI();

    boolean isAlipayAuthCallBack(Intent intent);

    void openAlipayAuth(Activity activity, String str, String str2, String str3, String str4) throws AlipayAuthIllegalArgumentException, PreAlipayAuthException;
}
