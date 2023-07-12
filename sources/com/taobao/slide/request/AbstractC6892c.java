package com.taobao.slide.request;

import android.content.Context;
import mtopsdk.common.util.HttpHeaderConstant;
import tb.hh1;
import tb.m42;

/* compiled from: Taobao */
/* renamed from: com.taobao.slide.request.c */
/* loaded from: classes11.dex */
public abstract class AbstractC6892c<T> extends AbstractC6891b<T> {
    public AbstractC6892c(Context context, String str, String str2) {
        super(context, str, str2);
    }

    @Override // com.taobao.slide.request.AbstractC6891b
    protected String a() throws Throwable {
        IConnection c6893d;
        if (AbstractC6891b.d) {
            c6893d = new C6894e(this.a);
        } else {
            c6893d = new C6893d();
        }
        try {
            m42.g("BaseRequest", "CdnRequest", "URL", this.b);
            c6893d.openConnection(this.b);
            if (AbstractC6891b.d) {
                c6893d.addHeader(HttpHeaderConstant.F_REFER, hh1.MODULE_NAME);
            }
            c6893d.setMethod("GET");
            c6893d.connect();
            int responseCode = c6893d.getResponseCode();
            if (responseCode == 200) {
                return c6893d.getResponse();
            }
            throw new RuntimeException("get response code:" + responseCode);
        } finally {
        }
    }
}
