package com.taobao.slide.request;

import android.content.Context;
import mtopsdk.common.util.HttpHeaderConstant;
import tb.hh1;
import tb.m42;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class c<T> extends b<T> {
    public c(Context context, String str, String str2) {
        super(context, str, str2);
    }

    @Override // com.taobao.slide.request.b
    protected String a() throws Throwable {
        IConnection dVar;
        if (b.d) {
            dVar = new e(this.a);
        } else {
            dVar = new d();
        }
        try {
            m42.g("BaseRequest", "CdnRequest", "URL", this.b);
            dVar.openConnection(this.b);
            if (b.d) {
                dVar.addHeader(HttpHeaderConstant.F_REFER, hh1.MODULE_NAME);
            }
            dVar.setMethod("GET");
            dVar.connect();
            int responseCode = dVar.getResponseCode();
            if (responseCode == 200) {
                return dVar.getResponse();
            }
            throw new RuntimeException("get response code:" + responseCode);
        } finally {
        }
    }
}
