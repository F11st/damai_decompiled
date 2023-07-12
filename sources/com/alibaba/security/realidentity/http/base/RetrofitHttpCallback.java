package com.alibaba.security.realidentity.http.base;

import com.alibaba.security.common.c.C3800a;
import com.alibaba.security.common.d.C3811h;
import com.alibaba.security.realidentity.http.IHttpCallback;
import com.alibaba.security.realidentity.http.RpHttpResponse;
import com.alibaba.security.realidentity.http.model.HttpResponse;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class RetrofitHttpCallback implements IHttpCallback {
    private static final String TAG = "RetrofitHttpCallback";
    private Class<? extends HttpResponse> httpResponse = HttpResponse.class;

    private HttpResponse analyzeResponse(String str, Class<? extends HttpResponse> cls) {
        try {
            return (HttpResponse) C3811h.a(str, cls, false);
        } catch (Throwable unused) {
            C3800a.c(TAG, "analyzeResponse fail ,jsonResponse is ".concat(String.valueOf(str)));
            return new HttpResponse() { // from class: com.alibaba.security.realidentity.http.base.RetrofitHttpCallback.1
                @Override // com.alibaba.security.realidentity.http.model.HttpResponse
                public boolean isSuccessful() {
                    return false;
                }
            };
        }
    }

    protected abstract void onFailure(HttpResponse httpResponse);

    @Override // com.alibaba.security.realidentity.http.IHttpCallback
    public void onFailure(Exception exc) {
        onNetError(exc);
    }

    protected abstract void onNetError(Exception exc);

    @Override // com.alibaba.security.realidentity.http.IHttpCallback
    public void onResponse(RpHttpResponse rpHttpResponse) {
        HttpResponse analyzeResponse = analyzeResponse(rpHttpResponse.getResponseBody(), this.httpResponse);
        if (analyzeResponse != null && analyzeResponse.isSuccessful()) {
            onSuccess(analyzeResponse);
        } else {
            onFailure(analyzeResponse);
        }
    }

    protected abstract void onSuccess(HttpResponse httpResponse);

    public void setResponse(Class<? extends HttpResponse> cls) {
        this.httpResponse = cls;
    }
}
