package com.alibaba.security.realidentity.business.dynamic;

import android.text.TextUtils;
import com.alibaba.security.realidentity.http.AbsHttpResponse;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class DynamicHttpResponse extends AbsHttpResponse {
    private String result;

    public String getResult() {
        return this.result;
    }

    @Override // com.alibaba.security.realidentity.http.model.HttpResponse
    public boolean isSuccessful() {
        return !TextUtils.isEmpty(this.result);
    }

    public void setResult(String str) {
        this.result = str;
    }
}
