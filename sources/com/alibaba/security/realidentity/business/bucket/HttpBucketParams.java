package com.alibaba.security.realidentity.business.bucket;

import com.alibaba.security.realidentity.http.model.HttpResponse;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class HttpBucketParams extends BucketParams {
    private HttpResponse mHttpResponse;

    public abstract HttpBucketParams doTransform(HttpResponse httpResponse);

    public HttpResponse getmHttpResponse() {
        return this.mHttpResponse;
    }

    public void setmHttpResponse(HttpResponse httpResponse) {
        this.mHttpResponse = httpResponse;
    }

    public final HttpBucketParams transform(HttpResponse httpResponse) {
        this.mHttpResponse = httpResponse;
        doTransform(httpResponse);
        return this;
    }
}
