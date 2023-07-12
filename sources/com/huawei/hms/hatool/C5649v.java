package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.hatool.v */
/* loaded from: classes10.dex */
public class C5649v {
    public static e1 a(String str, String str2) {
        e1 e1Var = new e1();
        e1Var.a(z0.a().a(str, str2));
        return e1Var;
    }

    public static f1 a(String str, String str2, String str3, String str4) {
        f1 f1Var = new f1();
        f1Var.a(str);
        f1Var.b(AbstractC5607b.f());
        f1Var.e(str2);
        f1Var.c(str4);
        StringBuffer stringBuffer = new StringBuffer("hmshi");
        stringBuffer.append(str3);
        stringBuffer.append("qrt");
        f1Var.d(stringBuffer.toString());
        return f1Var;
    }

    public static g1 a(String str, String str2, String str3) {
        g1 g1Var = new g1();
        g1Var.c(AbstractC5607b.j());
        g1Var.e(AbstractC5607b.l());
        g1Var.a(str3);
        g1Var.b(z0.a().b(str2, str));
        return g1Var;
    }

    public static C5644r b(String str, String str2) {
        C5653y.c("hmsSdk", "generate UploadData EventModelHandlerBase");
        C5651x.d().a(str, str2);
        if (TextUtils.isEmpty(C5651x.d().a())) {
            C5653y.f("hmsSdk", "event chifer is empty");
            return null;
        }
        return new C5644r(C5651x.d().c());
    }

    public static Map<String, String> c(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("App-Id", AbstractC5607b.f());
        hashMap.put("App-Ver", AbstractC5607b.g());
        hashMap.put("Sdk-Name", "hianalytics");
        hashMap.put("Sdk-Ver", "2.2.0.313");
        hashMap.put("Device-Type", Build.getMODEL());
        hashMap.put("servicetag", str);
        C5653y.a("hmsSdk", "sendData RequestId : %s", str2);
        hashMap.put("Request-Id", str2);
        return hashMap;
    }
}
