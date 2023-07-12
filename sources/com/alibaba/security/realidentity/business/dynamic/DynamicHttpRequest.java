package com.alibaba.security.realidentity.business.dynamic;

import com.alibaba.security.realidentity.http.BaseHttpRequest;
import com.alibaba.security.realidentity.http.annotation.Api;
import com.alibaba.security.realidentity.http.annotation.Body;
import com.alibaba.security.realidentity.http.model.HttpMethod;

/* compiled from: Taobao */
@Api(method = HttpMethod.POST, name = "mtop.verifycenter.rp.getwirelessconf")
@Body
/* loaded from: classes8.dex */
public class DynamicHttpRequest extends BaseHttpRequest {
    private String keys;

    public DynamicHttpRequest(String str) {
        super(str);
    }

    public String getKeys() {
        return this.keys;
    }

    public void setKeys(String str) {
        this.keys = str;
    }
}
