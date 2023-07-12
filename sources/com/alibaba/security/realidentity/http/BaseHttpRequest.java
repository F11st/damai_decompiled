package com.alibaba.security.realidentity.http;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.security.biometrics.jni.ALBiometricsJni;
import com.alibaba.security.common.d.C3801a;
import com.alibaba.security.common.d.C3811h;
import com.alibaba.security.realidentity.a.C3847g;
import com.alibaba.security.realidentity.bean.ClientInfo;
import com.alibaba.security.realidentity.http.model.HttpRequest;
import com.alibaba.security.realidentity.jsbridge.AbstractC3893a;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class BaseHttpRequest extends HttpRequest {
    @JSONField(name = AbstractC3893a.f)
    private String clientInfo;
    @JSONField(name = AbstractC3893a.d)
    private String verifyToken;

    public BaseHttpRequest(String str) {
        this.verifyToken = str;
        String a = C3801a.a(ALBiometricsJni.genVersionTag(C3847g.C3848a.a.c, str));
        ClientInfo clientInfo = new ClientInfo();
        clientInfo.setVersionTag(a);
        this.clientInfo = C3811h.a(clientInfo);
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
