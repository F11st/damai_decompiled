package com.alibaba.security.realidentity.http;

import com.alibaba.security.realidentity.http.base.BusinessHttpWrapper;
import com.alibaba.security.realidentity.http.base.RetrofitHttpCallback;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface IHttpInvoker {
    void dynamic(BusinessHttpWrapper businessHttpWrapper, RetrofitHttpCallback retrofitHttpCallback);

    void normal(BusinessHttpWrapper businessHttpWrapper, RetrofitHttpCallback retrofitHttpCallback);

    void start(BusinessHttpWrapper businessHttpWrapper, RetrofitHttpCallback retrofitHttpCallback);

    void submit(BusinessHttpWrapper businessHttpWrapper, RetrofitHttpCallback retrofitHttpCallback);

    void upload(BusinessHttpWrapper businessHttpWrapper, RetrofitHttpCallback retrofitHttpCallback);
}
