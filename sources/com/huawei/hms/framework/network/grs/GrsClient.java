package com.huawei.hms.framework.network.grs;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class GrsClient {
    private static final String EMPTY_STRING = "";
    private final c grsClientGlobal;

    public GrsClient(Context context, GrsBaseInfo grsBaseInfo) {
        if (context == null || grsBaseInfo == null) {
            throw new NullPointerException("invalid init params for context is null or GrsBaseInfo instance is null Object.");
        }
        this.grsClientGlobal = d.a(grsBaseInfo, context);
    }

    public void ayncGetGrsUrl(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack) {
        c cVar = this.grsClientGlobal;
        if (cVar == null) {
            iQueryUrlCallBack.onCallBackFail(-8);
        } else {
            cVar.a(str, str2, iQueryUrlCallBack);
        }
    }

    public void ayncGetGrsUrls(String str, IQueryUrlsCallBack iQueryUrlsCallBack) {
        c cVar = this.grsClientGlobal;
        if (cVar == null) {
            iQueryUrlsCallBack.onCallBackFail(-8);
        } else {
            cVar.a(str, iQueryUrlsCallBack);
        }
    }

    public void clearSp() {
        c cVar = this.grsClientGlobal;
        if (cVar == null) {
            return;
        }
        cVar.a();
    }

    public boolean forceExpire() {
        c cVar = this.grsClientGlobal;
        if (cVar == null) {
            return false;
        }
        return cVar.b();
    }

    public String synGetGrsUrl(String str, String str2) {
        c cVar = this.grsClientGlobal;
        return cVar == null ? "" : cVar.a(str, str2);
    }

    public Map<String, String> synGetGrsUrls(String str) {
        c cVar = this.grsClientGlobal;
        return cVar == null ? new HashMap() : cVar.a(str);
    }
}
