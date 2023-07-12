package com.taobao.slide.request;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.SecurityGuardParamContext;
import com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent;
import com.taobao.slide.api.SlideConfig;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mtopsdk.common.util.HttpHeaderConstant;
import tb.au1;
import tb.hh1;
import tb.m42;
import tb.nl;
import tb.tw0;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class a<T> extends b<T> {
    private SlideConfig e;
    private String f;
    private long g;
    private long h;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, SlideConfig slideConfig, String str, String str2, String str3) {
        super(context, str2, str3);
        this.e = slideConfig;
        this.f = str;
        this.g = (System.currentTimeMillis() / 1000) + this.h;
    }

    private void f(IConnection iConnection) throws Throwable {
        m42.g("BaseRequest", "AuthRequest", "URL", this.b);
        iConnection.setParams(b());
        iConnection.openConnection(this.b);
        iConnection.addHeader("S-APP-KEY", nl.e(this.e.getAppKey()));
        iConnection.addHeader("S-APP-VERSION", nl.e(this.e.getAppVersion()));
        iConnection.addHeader("S-DEVICE-ID", nl.e(this.f));
        iConnection.addHeader("S-TIMESTAMP", nl.e(String.valueOf(this.g)));
        iConnection.addHeader("S-SDK-VERSION", nl.e("1.0.0"));
        String c = c();
        iConnection.addHeader("S-SIGN", nl.e(g(c)));
        iConnection.addHeader("S-SIGN-VERSION", nl.e("1.0"));
        if (b.d) {
            iConnection.addHeader(HttpHeaderConstant.F_REFER, hh1.MODULE_NAME);
        }
        if (!TextUtils.isEmpty(c)) {
            iConnection.setMethod("POST");
            iConnection.setBody(c.getBytes());
        } else {
            iConnection.setMethod("GET");
        }
        iConnection.connect();
    }

    private String g(String str) throws Throwable {
        StringBuilder sb = new StringBuilder(this.b);
        sb.append("&");
        sb.append(this.e.getAppKey());
        sb.append("&");
        sb.append(this.e.getAppVersion());
        sb.append("&");
        sb.append(this.f);
        sb.append("&");
        sb.append(this.g);
        sb.append("&");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        sb.append(str);
        if (TextUtils.isEmpty(this.e.getAppSecret())) {
            SecurityGuardManager securityGuardManager = SecurityGuardManager.getInstance(this.a);
            au1.e(securityGuardManager, "SecurityGuardManager is null");
            ISecureSignatureComponent secureSignatureComp = securityGuardManager.getSecureSignatureComp();
            HashMap hashMap = new HashMap();
            hashMap.put("INPUT", sb.toString());
            SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
            securityGuardParamContext.appKey = this.e.getAppKey();
            securityGuardParamContext.paramMap = hashMap;
            securityGuardParamContext.requestType = 3;
            return secureSignatureComp.signRequest(securityGuardParamContext, this.e.getAuthCode());
        }
        return tw0.b(sb.toString(), this.e.getAppSecret());
    }

    @Override // com.taobao.slide.request.b
    protected String a() throws Throwable {
        IConnection dVar;
        if (b.d) {
            dVar = new e(this.a);
        } else {
            dVar = new d();
        }
        try {
            f(dVar);
            int responseCode = dVar.getResponseCode();
            if (responseCode >= 200 && responseCode <= 299) {
                Map<String, List<String>> headFields = dVar.getHeadFields();
                if (headFields != null && !headFields.isEmpty()) {
                    List<String> list = headFields.get("S-CODE");
                    if (list != null && !list.isEmpty()) {
                        String d = nl.d(list.get(0));
                        if ("10008".equals(d)) {
                            m42.k("BaseRequest", "get expired, correct timestamp", new Object[0]);
                            List<String> list2 = headFields.get("S-SERVER-TIMESTAMP");
                            if (list2 != null && !list2.isEmpty()) {
                                long j = nl.j(nl.d(headFields.get("S-SERVER-TIMESTAMP").get(0)));
                                if (j != 0) {
                                    long j2 = this.g;
                                    if (j2 != 0) {
                                        this.h = j - j2;
                                    }
                                }
                            } else {
                                m42.k("BaseRequest", "get expired, lack o-server-timestamp", new Object[0]);
                            }
                        }
                        if (!"10000".equals(d)) {
                            throw new IllegalArgumentException("get illegal ocode:" + d);
                        }
                    }
                    m42.k("BaseRequest", "get response lack o-code", new Object[0]);
                    return dVar.getResponse();
                }
                return dVar.getResponse();
            }
            throw new RuntimeException("get response code:" + responseCode);
        } finally {
        }
    }
}
