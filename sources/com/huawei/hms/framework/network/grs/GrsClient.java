package com.huawei.hms.framework.network.grs;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class GrsClient {
    private static final String EMPTY_STRING = "";
    private final C5561c grsClientGlobal;

    public GrsClient(Context context, GrsBaseInfo grsBaseInfo) {
        if (context == null || grsBaseInfo == null) {
            throw new NullPointerException("invalid init params for context is null or GrsBaseInfo instance is null Object.");
        }
        this.grsClientGlobal = C5563d.a(grsBaseInfo, context);
    }

    public void ayncGetGrsUrl(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack) {
        C5561c c5561c = this.grsClientGlobal;
        if (c5561c == null) {
            iQueryUrlCallBack.onCallBackFail(-8);
        } else {
            c5561c.a(str, str2, iQueryUrlCallBack);
        }
    }

    public void ayncGetGrsUrls(String str, IQueryUrlsCallBack iQueryUrlsCallBack) {
        C5561c c5561c = this.grsClientGlobal;
        if (c5561c == null) {
            iQueryUrlsCallBack.onCallBackFail(-8);
        } else {
            c5561c.a(str, iQueryUrlsCallBack);
        }
    }

    public void clearSp() {
        C5561c c5561c = this.grsClientGlobal;
        if (c5561c == null) {
            return;
        }
        c5561c.a();
    }

    public boolean forceExpire() {
        C5561c c5561c = this.grsClientGlobal;
        if (c5561c == null) {
            return false;
        }
        return c5561c.b();
    }

    public String synGetGrsUrl(String str, String str2) {
        C5561c c5561c = this.grsClientGlobal;
        return c5561c == null ? "" : c5561c.a(str, str2);
    }

    public Map<String, String> synGetGrsUrls(String str) {
        C5561c c5561c = this.grsClientGlobal;
        return c5561c == null ? new HashMap() : c5561c.a(str);
    }
}
