package com.alibaba.security.realidentity.jsbridge;

import android.taobao.windvane.jsbridge.WVResult;
import com.alibaba.security.biometrics.jni.VersionKey;

/* compiled from: Taobao */
@f(a = "checkEnvironment")
/* loaded from: classes8.dex */
public class c extends a {
    @Override // com.alibaba.security.realidentity.jsbridge.a
    protected final String a() {
        return "checkEnvironment";
    }

    @Override // com.alibaba.security.realidentity.jsbridge.a
    public final boolean a(String str, h hVar) {
        boolean z;
        boolean z2;
        String str2 = VersionKey.RP_SDK_VERSION;
        boolean z3 = true;
        try {
            Class.forName("android.taobao.windvane.jsbridge.WVJsBridge");
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        try {
            Class.forName("android.taobao.windvane.extra.uc.WVUCWebView");
            z2 = true;
        } catch (ClassNotFoundException unused2) {
            z2 = false;
        }
        try {
            Class.forName("");
        } catch (ClassNotFoundException unused3) {
            z3 = false;
        }
        WVResult wVResult = new WVResult();
        wVResult.addData("isWindvane", Boolean.valueOf(z));
        wVResult.addData("isWindvaneUCWebview", Boolean.valueOf(z2));
        wVResult.addData("isSecurityGuard", Boolean.valueOf(z3));
        wVResult.addData("rpsdkVersion", str2);
        wVResult.addData("faceLivenessVersion", VersionKey.FL_SDK_VERSION);
        hVar.b(wVResult);
        return false;
    }

    @Override // com.alibaba.security.realidentity.jsbridge.a
    protected final boolean c() {
        return false;
    }
}
