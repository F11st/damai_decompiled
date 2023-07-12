package com.alibaba.security.realidentity.http;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.security.biometrics.jni.ALBiometricsJni;
import com.alibaba.security.common.d.h;
import com.alibaba.security.realidentity.a.g;
import com.alibaba.security.realidentity.bean.ClientInfo;
import com.alibaba.security.realidentity.http.model.HttpRequest;
import com.alibaba.security.realidentity.jsbridge.a;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class BaseHttpRequest extends HttpRequest {
    @JSONField(name = a.f)
    private String clientInfo;
    @JSONField(name = a.d)
    private String verifyToken;

    public BaseHttpRequest(String str) {
        this.verifyToken = str;
        String a = com.alibaba.security.common.d.a.a(ALBiometricsJni.genVersionTag(g.a.a.c, str));
        ClientInfo clientInfo = new ClientInfo();
        clientInfo.setVersionTag(a);
        this.clientInfo = h.a(clientInfo);
    }

    public String getClientInfo() {
        return this.clientInfo;
    }

    public String getVerifyToken() {
        return this.verifyToken;
    }

    public void setClientInfo(String str) {
        this.clientInfo = str;
    }

    public void setVerifyToken(String str) {
        this.verifyToken = str;
    }
}
