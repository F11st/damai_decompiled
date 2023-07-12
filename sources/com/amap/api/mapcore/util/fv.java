package com.amap.api.mapcore.util;

import android.content.Context;
import com.alimm.xadsdk.request.builder.IRequestConst;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class fv<T, V> extends fu<T, V> {
    public fv(Context context, T t) {
        super(context, t);
    }

    @Override // com.amap.api.mapcore.util.fu
    protected abstract String a();

    @Override // com.amap.api.mapcore.util.fu
    protected abstract V b(String str) throws ft;

    @Override // com.amap.api.mapcore.util.fu
    protected V f() {
        return null;
    }

    @Override // com.amap.api.mapcore.util.ii
    public byte[] getEntityBytes() {
        try {
            return a().getBytes("utf-8");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.mapcore.util.dp, com.amap.api.mapcore.util.ii
    public Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.mapcore.util.fu, com.amap.api.mapcore.util.ii
    public Map<String, String> getRequestHead() {
        HashMap hashMap = new HashMap(16);
        hashMap.put("Content-Type", " application/json");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put(IRequestConst.USER_AGENT, "AMAP SDK Android Trace 7.4.0");
        hashMap.put("x-INFO", gf.b(this.f));
        hashMap.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", "7.4.0", AgooConstants.MESSAGE_TRACE));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }
}
