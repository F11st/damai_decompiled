package com.alibaba.security.realidentity.business.start;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.security.realidentity.http.BaseHttpRequest;
import com.alibaba.security.realidentity.http.annotation.Api;
import com.alibaba.security.realidentity.http.annotation.Body;
import com.alibaba.security.realidentity.http.model.HttpMethod;

/* compiled from: Taobao */
@Api(method = HttpMethod.POST, name = "mtop.verifycenter.rp.start")
@Body
/* loaded from: classes8.dex */
public class StartHttpRequest extends BaseHttpRequest {
    @JSONField(name = "extendMap")
    private String extendMap;

    public StartHttpRequest(String str) {
        super(str);
    }

    public String getExtendMap() {
        return this.extendMap;
    }

    public void setExtendMap(String str) {
        this.extendMap = str;
    }
}
