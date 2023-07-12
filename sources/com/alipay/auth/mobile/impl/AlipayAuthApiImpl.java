package com.alipay.auth.mobile.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.auth.mobile.api.IAlipayAuthAPI;
import com.alipay.auth.mobile.api.IAlipayAuthEventHandler;
import com.alipay.auth.mobile.api.IAlipayAuthMonitor;
import com.alipay.auth.mobile.common.AlipayAuthConstant;
import com.alipay.auth.mobile.common.AlipayAuthUtils;
import com.alipay.auth.mobile.common.AlipayDataResolver;
import com.alipay.auth.mobile.common.LoggerUtils;
import com.alipay.auth.mobile.common.MonitorAlipayAuth;
import com.alipay.auth.mobile.exception.AlipayAuthIllegalArgumentException;
import com.alipay.auth.mobile.exception.PreAlipayAuthException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Properties;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class AlipayAuthApiImpl implements IAlipayAuthAPI {
    private Context a;
    private IAlipayAuthMonitor b;

    public AlipayAuthApiImpl(Context context, IAlipayAuthMonitor iAlipayAuthMonitor) {
        LoggerUtils.d("AlipayAuthApiImpl", "new instance");
        this.a = context;
        this.b = iAlipayAuthMonitor;
    }

    @Override // com.alipay.auth.mobile.api.IAlipayAuthAPI
    public void handleIntent(Intent intent, IAlipayAuthEventHandler iAlipayAuthEventHandler) throws AlipayAuthIllegalArgumentException {
        if (intent == null) {
            LoggerUtils.d("AlipayAuthApiImpl", "intent 为  null");
            throw new AlipayAuthIllegalArgumentException("intent can not be null");
        } else if (iAlipayAuthEventHandler != null) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                String string = extras.getString("code");
                String string2 = extras.getString("msg");
                String string3 = extras.getString("token");
                boolean z = extras.getBoolean("success");
                int i = extras.getInt(AlipayAuthConstant.AuthState.AUTH_STATE_KEY);
                MonitorAlipayAuth.getInstance().monitorAlipayAuth(this.b, "AliPayAuth_CanHandleCallback");
                if (z && !TextUtils.isEmpty(string3)) {
                    iAlipayAuthEventHandler.alipayAuthSuccess(string3);
                    LoggerUtils.d("AlipayAuthApiImpl", "get authToken success");
                    new Properties().put("authToken", string3);
                    MonitorAlipayAuth.getInstance().monitorAlipayAuth(this.b, "AliPayAuth_CallbackSucess");
                } else if (3001 == i) {
                    iAlipayAuthEventHandler.alipayAuthDidCancel();
                    LoggerUtils.d("AlipayAuthApiImpl", "user cancel");
                    MonitorAlipayAuth.getInstance().monitorAlipayAuth(this.b, "AliPayAuth_CallbackCancel");
                } else if (3002 == i) {
                    iAlipayAuthEventHandler.alipayAuthDidCancel();
                    LoggerUtils.d("AlipayAuthApiImpl", "user change account");
                    MonitorAlipayAuth.getInstance().monitorAlipayAuth(this.b, "AliPayAuth_CallbackCancel");
                } else if (TextUtils.isEmpty(string3)) {
                    iAlipayAuthEventHandler.alipayAuthFailure();
                    LoggerUtils.d("AlipayAuthApiImpl", "token is empty");
                    MonitorAlipayAuth.getInstance().monitorAlipayAuth(this.b, "AliPayAuth_CallbackError");
                } else {
                    iAlipayAuthEventHandler.alipayAuthFailure();
                    LoggerUtils.d("AlipayAuthApiImpl", "auth other failture");
                    MonitorAlipayAuth.getInstance().monitorAlipayAuth(this.b, "AliPayAuth_CallbackError");
                }
                LoggerUtils.d("AlipayAuthApiImpl", "alipay auth back data:code=" + string + " msg=" + string2 + " token=" + string3 + " success=" + z);
                return;
            }
            LoggerUtils.d("AlipayAuthApiImpl", "alipay auth back data: intent.getExtras() is null");
            iAlipayAuthEventHandler.alipayAuthFailure();
            MonitorAlipayAuth.getInstance().monitorAlipayAuth(this.b, "AliPayAuth_CallbackError");
        } else {
            LoggerUtils.d("AlipayAuthApiImpl", "eventHandler 为  null ,业务方需传递一个非空实例");
            throw new AlipayAuthIllegalArgumentException("callabck IAlipaySSOEventHandler object can not be null");
        }
    }

    @Override // com.alipay.auth.mobile.api.IAlipayAuthAPI
    public boolean isAlipayAppInstalled() {
        try {
            this.a.getPackageManager().getPackageInfo("com.eg.android.AlipayGphone", 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            LoggerUtils.e("AlipayAuthApiImpl", "isAlipayAppInstalled Exception", e);
            return false;
        } catch (Throwable th) {
            LoggerUtils.e("AlipayAuthApiImpl", "isAlipayAppInstalled Throwable", th);
            return false;
        }
    }

    @Override // com.alipay.auth.mobile.api.IAlipayAuthAPI
    public boolean isAlipayAppSurpportAPI() {
        Throwable th;
        PackageInfo packageInfo;
        boolean z = true;
        try {
            int alipayAuthLoginSupportVersion = new AlipayDataResolver(this.a).getAlipayAuthLoginSupportVersion(0);
            if (alipayAuthLoginSupportVersion < 966042200) {
                if (alipayAuthLoginSupportVersion == 0 && (packageInfo = this.a.getPackageManager().getPackageInfo("com.eg.android.AlipayGphone", 16384)) != null) {
                    if (packageInfo.versionCode > 93) {
                        return true;
                    }
                }
                return false;
            }
            try {
                LoggerUtils.d("AlipayAuthApiImpl", "auth login supportVersion = " + alipayAuthLoginSupportVersion);
                return true;
            } catch (Throwable th2) {
                th = th2;
                LoggerUtils.e("AlipayAuthApiImpl", "isAlipayAppSurpportAPI error", th);
                return z;
            }
        } catch (Throwable th3) {
            th = th3;
            z = false;
        }
    }

    @Override // com.alipay.auth.mobile.api.IAlipayAuthAPI
    public boolean isAlipayAuthCallBack(Intent intent) {
        return (intent == null || intent.getExtras() == null || !intent.getExtras().containsKey(AlipayAuthConstant.AuthState.AUTH_STATE_KEY)) ? false : true;
    }

    @Override // com.alipay.auth.mobile.api.IAlipayAuthAPI
    public void openAlipayAuth(Activity activity, String str, String str2, String str3, String str4) throws AlipayAuthIllegalArgumentException, PreAlipayAuthException {
        if (isAlipayAppInstalled()) {
            if (isAlipayAppSurpportAPI()) {
                if (activity != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                    Properties properties = new Properties();
                    properties.put("appkey", str);
                    properties.put("packageName", str3);
                    MonitorAlipayAuth.getInstance().monitorAlipayAuth(this.b, "AliPayAuth_Open", properties);
                    String encrypt = AlipayAuthUtils.encrypt(this.a, str, str2, this.b);
                    String valueOf = String.valueOf(System.currentTimeMillis());
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("appKey", str);
                    linkedHashMap.put("timestamp", valueOf);
                    linkedHashMap.put("uuid", encrypt);
                    String atlasSignData = AlipayAuthUtils.atlasSignData(this.a, str, AlipayAuthUtils.strJoint(linkedHashMap), this.b);
                    try {
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        String encode = URLEncoder.encode(encrypt, "utf-8");
                        HashMap hashMap = new HashMap();
                        hashMap.put("packageName", str3);
                        hashMap.put(AlipayAuthConstant.FULL_CLASS_NAME, str4);
                        hashMap.put("uuid", encode);
                        hashMap.put("timestamp", valueOf);
                        hashMap.put(AlipayAuthConstant.SIGN_DATA, atlasSignData);
                        hashMap.put("appKey", str);
                        String strJoint = AlipayAuthUtils.strJoint(AlipayAuthConstant.ALIPAY_URI, hashMap);
                        LoggerUtils.d("AlipayAuthApiImpl", strJoint);
                        intent.setData(Uri.parse(strJoint));
                        activity.startActivity(intent);
                        Properties properties2 = new Properties();
                        properties2.put("openURL", strJoint);
                        MonitorAlipayAuth.getInstance().monitorAlipayAuth(this.b, "AliPayAuth_Jump2AliPay", properties2);
                        return;
                    } catch (Throwable th) {
                        MonitorAlipayAuth.getInstance().monitorAlipayAuth(this.b, "AliPayAuth_Jump2AliPay_Fail");
                        throw new PreAlipayAuthException("pre auth login process error", th);
                    }
                }
                throw new AlipayAuthIllegalArgumentException("one or some must need param is null");
            }
            throw new PreAlipayAuthException("alipay auth api not support");
        }
        throw new PreAlipayAuthException("alipay has not install");
    }
}
