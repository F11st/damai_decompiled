package com.alibaba.security.realidentity.http.base;

import com.alibaba.security.realidentity.http.model.HttpResponse;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class BusinessHttpWrapper implements Serializable {
    public BusinessRequest httpRequest;
    public Class<? extends HttpResponse> httpResponse;

    public BusinessHttpWrapper(Class<? extends HttpResponse> cls, BusinessRequest businessRequest) {
        this.httpRequest = businessRequest;
        this.httpResponse = cls;
    }
}
