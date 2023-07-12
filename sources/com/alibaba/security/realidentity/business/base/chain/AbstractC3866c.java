package com.alibaba.security.realidentity.business.base.chain;

import com.alibaba.security.realidentity.business.bucket.HttpBucketParams;
import com.alibaba.security.realidentity.http.base.RetrofitHttpCallback;
import com.alibaba.security.realidentity.http.model.HttpResponse;

/* compiled from: Taobao */
/* renamed from: com.alibaba.security.realidentity.business.base.chain.c */
/* loaded from: classes8.dex */
public abstract class AbstractC3866c extends RetrofitHttpCallback {
    private HttpBucketParams a;

    public AbstractC3866c(HttpBucketParams httpBucketParams) {
        this.a = httpBucketParams;
    }

    protected abstract void a(HttpBucketParams httpBucketParams);

    protected abstract void b(HttpBucketParams httpBucketParams);

    @Override // com.alibaba.security.realidentity.http.base.RetrofitHttpCallback
    public void onFailure(HttpResponse httpResponse) {
        HttpBucketParams httpBucketParams = this.a;
        if (httpBucketParams != null) {
            httpBucketParams.transform(httpResponse);
        }
        b(this.a);
    }

    @Override // com.alibaba.security.realidentity.http.base.RetrofitHttpCallback
    public abstract void onNetError(Exception exc);

    @Override // com.alibaba.security.realidentity.http.base.RetrofitHttpCallback
    public void onSuccess(HttpResponse httpResponse) {
        HttpBucketParams httpBucketParams = this.a;
        if (httpBucketParams != null) {
            httpBucketParams.transform(httpResponse);
        }
        a(this.a);
    }
}
