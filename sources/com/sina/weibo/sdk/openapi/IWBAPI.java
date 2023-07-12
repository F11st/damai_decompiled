package com.sina.weibo.sdk.openapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.share.WbShareCallback;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface IWBAPI {
    void authorize(Activity activity, WbAuthListener wbAuthListener);

    void authorizeCallback(Activity activity, int i, int i2, Intent intent);

    void authorizeClient(Activity activity, WbAuthListener wbAuthListener);

    void authorizeWeb(Activity activity, WbAuthListener wbAuthListener);

    void doResultIntent(Intent intent, WbShareCallback wbShareCallback);

    boolean isWBAppInstalled();

    boolean isWBAppSupportMultipleImage();

    void registerApp(Context context, AuthInfo authInfo);

    void registerApp(Context context, AuthInfo authInfo, SdkListener sdkListener);

    void setLoggerEnable(boolean z);

    void shareMessage(Activity activity, WeiboMultiMessage weiboMultiMessage, boolean z);
}
