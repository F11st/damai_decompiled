package com.alibaba.security.realidentity.http.base;

import com.alibaba.security.realidentity.http.model.HttpRequest;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class BusinessRequest implements Serializable {
    public HttpRequest httpRequest;
    public Class<? extends HttpRequest> httpRequestCls;

    public BusinessRequest(Class<? extends HttpRequest> cls, HttpRequest httpRequest) {
        this.httpRequestCls = cls;
        this.httpRequest = httpRequest;
    }
}
