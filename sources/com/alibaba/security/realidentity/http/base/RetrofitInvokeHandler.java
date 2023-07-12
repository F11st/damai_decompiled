package com.alibaba.security.realidentity.http.base;

import com.alibaba.security.common.d.C3811h;
import com.alibaba.security.realidentity.http.AbsRPCInvoker;
import com.alibaba.security.realidentity.http.annotation.Api;
import com.alibaba.security.realidentity.http.annotation.Body;
import com.alibaba.security.realidentity.http.base.Request;
import com.alibaba.security.realidentity.http.model.HttpMethod;
import com.alibaba.security.realidentity.http.model.HttpRequest;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class RetrofitInvokeHandler implements InvocationHandler {
    private static final String TAG = "RetrofitInvokeHandler";
    private AbsRPCInvoker absRPCInvoker;

    public RetrofitInvokeHandler(AbsRPCInvoker absRPCInvoker) {
        this.absRPCInvoker = absRPCInvoker;
    }

    private Request analyzeRequest(BusinessRequest... businessRequestArr) {
        HttpRequest httpRequest = null;
        if (businessRequestArr == null) {
            return null;
        }
        HttpMethod httpMethod = HttpMethod.POST;
        String str = "";
        for (BusinessRequest businessRequest : businessRequestArr) {
            Api api = (Api) businessRequest.httpRequestCls.getAnnotation(Api.class);
            if (api != null) {
                str = api.name();
                httpMethod = api.method();
            }
            if (((Body) businessRequest.httpRequestCls.getAnnotation(Body.class)) != null) {
                httpRequest = businessRequest.httpRequest;
            }
        }
        return buildRequest(str, httpMethod.name(), httpRequest);
    }

    private Request buildRequest(String str, String str2, HttpRequest httpRequest) {
        Request.Builder builder = new Request.Builder();
        builder.method(str2);
        builder.path(str);
        if (httpRequest != null) {
            builder.body(C3811h.a(httpRequest));
        }
        return builder.build();
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        BusinessHttpWrapper businessHttpWrapper;
        BusinessRequest businessRequest;
        Request analyzeRequest;
        if (obj == null || method == null || objArr == null || objArr.length < 2 || !(objArr[0] instanceof BusinessHttpWrapper) || !(objArr[1] instanceof RetrofitHttpCallback) || (businessRequest = (businessHttpWrapper = (BusinessHttpWrapper) objArr[0]).httpRequest) == null || businessHttpWrapper.httpResponse == null || (analyzeRequest = analyzeRequest(businessRequest)) == null) {
            return null;
        }
        RetrofitHttpCallback retrofitHttpCallback = (RetrofitHttpCallback) objArr[1];
        retrofitHttpCallback.setResponse(businessHttpWrapper.httpResponse);
        AbsRPCInvoker absRPCInvoker = this.absRPCInvoker;
        if (absRPCInvoker != null) {
            absRPCInvoker.enqueue(analyzeRequest, retrofitHttpCallback);
        }
        return null;
    }
}
