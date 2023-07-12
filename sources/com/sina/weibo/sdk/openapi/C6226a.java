package com.sina.weibo.sdk.openapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.C6195a;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AccessTokenHelper;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.C6206a;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.b.C6209a;
import com.sina.weibo.sdk.b.C6212c;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.share.C6231e;
import com.sina.weibo.sdk.share.ShareTransActivity;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.sina.weibo.sdk.web.b.C6241d;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;

/* compiled from: Taobao */
/* renamed from: com.sina.weibo.sdk.openapi.a */
/* loaded from: classes7.dex */
public final class C6226a implements IWBAPI {
    private Context mContext;
    private C6206a r = new C6206a();
    private C6231e s = new C6231e();

    public C6226a(Context context) {
        this.mContext = context;
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void authorize(Activity activity, WbAuthListener wbAuthListener) {
        C6206a c6206a = this.r;
        C6212c.a("WBSsoTag", "authorize()");
        if (wbAuthListener != null) {
            c6206a.d = wbAuthListener;
            if (C6195a.a(activity)) {
                if (C6209a.e(activity) != null) {
                    c6206a.a(activity);
                    return;
                }
            }
            c6206a.b(activity);
            return;
        }
        throw new RuntimeException("listener can not be null.");
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void authorizeCallback(Activity activity, int i, int i2, Intent intent) {
        C6206a c6206a = this.r;
        C6212c.a("WBSsoTag", "authorizeCallback()");
        WbAuthListener wbAuthListener = c6206a.d;
        if (wbAuthListener != null) {
            if (32973 != i) {
                wbAuthListener.onError(new UiError(-7, "request code is error", "requestCode is error"));
            } else if (i2 != -1) {
                if (i2 == 0) {
                    wbAuthListener.onCancel();
                } else {
                    wbAuthListener.onError(new UiError(-6, "result code is error", "result code is error"));
                }
            } else if (intent != null) {
                String stringExtra = intent.getStringExtra("error");
                String stringExtra2 = intent.getStringExtra(PushMessageHelper.ERROR_TYPE);
                String stringExtra3 = intent.getStringExtra("error_description");
                if (TextUtils.isEmpty(stringExtra) && TextUtils.isEmpty(stringExtra2) && TextUtils.isEmpty(stringExtra3)) {
                    Oauth2AccessToken parseAccessToken = Oauth2AccessToken.parseAccessToken(intent.getExtras());
                    if (parseAccessToken != null) {
                        AccessTokenHelper.writeAccessToken(activity, parseAccessToken);
                        c6206a.d.onComplete(parseAccessToken);
                        return;
                    }
                    c6206a.d.onError(new UiError(-4, "oauth2AccessToken is null", "oauth2AccessToken is null"));
                } else if (!"access_denied".equals(stringExtra) && !"OAuthAccessDeniedException".equals(stringExtra)) {
                    c6206a.d.onError(new UiError(-5, stringExtra2, stringExtra3));
                } else {
                    c6206a.d.onCancel();
                }
            }
        }
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void authorizeClient(Activity activity, WbAuthListener wbAuthListener) {
        C6206a c6206a = this.r;
        C6212c.a("WBSsoTag", "authorizeClient()");
        if (wbAuthListener != null) {
            c6206a.d = wbAuthListener;
            c6206a.a(activity);
            return;
        }
        throw new RuntimeException("listener can not be null.");
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void authorizeWeb(Activity activity, WbAuthListener wbAuthListener) {
        C6206a c6206a = this.r;
        C6212c.a("WBSsoTag", "authorizeWeb()");
        if (wbAuthListener != null) {
            c6206a.d = wbAuthListener;
            c6206a.b(activity);
            return;
        }
        throw new RuntimeException("listener can not be null.");
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void doResultIntent(Intent intent, WbShareCallback wbShareCallback) {
        Bundle extras;
        if (intent == null || wbShareCallback == null || (extras = intent.getExtras()) == null) {
            return;
        }
        try {
            int i = extras.getInt("_weibo_resp_errcode", -1);
            if (i == 0) {
                wbShareCallback.onComplete();
            } else if (i == 1) {
                wbShareCallback.onCancel();
            } else if (i != 2) {
            } else {
                wbShareCallback.onError(new UiError(i, extras.getString("_weibo_resp_errstr"), "error from weibo client!"));
            }
        } catch (Exception e) {
            wbShareCallback.onError(new UiError(-1, e.getMessage(), e.getMessage()));
        }
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final boolean isWBAppInstalled() {
        return C6195a.a(this.mContext);
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final boolean isWBAppSupportMultipleImage() {
        return C6195a.b(this.mContext);
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void registerApp(Context context, AuthInfo authInfo) {
        registerApp(context, authInfo, null);
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void setLoggerEnable(boolean z) {
        C6212c.setLoggerEnable(z);
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void shareMessage(Activity activity, WeiboMultiMessage weiboMultiMessage, boolean z) {
        C6231e c6231e = this.s;
        if (activity != null) {
            if (C6195a.a(activity) || !z) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - c6231e.D >= DanmakuFactory.DEFAULT_DANMAKU_DURATION_V) {
                    c6231e.D = currentTimeMillis;
                    if (z) {
                        C6231e.a(activity, weiboMultiMessage);
                        return;
                    }
                    C6209a.C6210a e = C6209a.e(activity);
                    if (C6195a.a(activity) && e != null) {
                        C6209a.C6210a e2 = C6209a.e(activity);
                        boolean z2 = false;
                        if (e2 != null && e2.ah > 10000) {
                            z2 = true;
                        }
                        if (z2) {
                            C6231e.a(activity, weiboMultiMessage);
                            return;
                        }
                    }
                    AuthInfo a = C6195a.a();
                    if (a != null) {
                        C6241d c6241d = new C6241d(a);
                        c6241d.setContext(activity);
                        c6241d.aE = weiboMultiMessage;
                        c6241d.packageName = activity.getPackageName();
                        Oauth2AccessToken readAccessToken = AccessTokenHelper.readAccessToken(activity);
                        if (readAccessToken != null) {
                            String accessToken = readAccessToken.getAccessToken();
                            if (!TextUtils.isEmpty(readAccessToken.getAccessToken())) {
                                c6241d.ae = accessToken;
                            }
                        }
                        Bundle bundle = new Bundle();
                        c6241d.writeToBundle(bundle);
                        Intent intent = new Intent(activity, ShareTransActivity.class);
                        intent.putExtra("start_flag", 1001);
                        intent.putExtra("start_web_activity", "com.sina.weibo.sdk.web.WebActivity");
                        intent.putExtras(bundle);
                        activity.startActivityForResult(intent, 10001);
                    }
                }
            }
        }
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void registerApp(Context context, AuthInfo authInfo, SdkListener sdkListener) {
        C6195a.a(authInfo, sdkListener);
    }
}
