package com.alibaba.security.realidentity.business.submit;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.security.realidentity.http.annotation.Api;
import com.alibaba.security.realidentity.http.annotation.Body;
import com.alibaba.security.realidentity.http.model.HttpMethod;
import com.alibaba.security.realidentity.http.model.HttpRequest;
import com.alibaba.security.realidentity.jsbridge.AbstractC3893a;

/* compiled from: Taobao */
@Api(method = HttpMethod.POST, name = "mtop.verifycenter.rp.submit")
@Body
/* loaded from: classes8.dex */
public class SubmitHttpRequest extends HttpRequest {
    @JSONField(name = AbstractC3893a.d)
    public String verifyToken;
}
