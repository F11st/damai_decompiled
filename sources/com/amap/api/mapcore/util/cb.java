package com.amap.api.mapcore.util;

import com.alimm.xadsdk.request.builder.IRequestConst;
import java.util.Hashtable;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class cb extends dp {
    private String d;

    public cb(String str) {
        this.d = str;
    }

    @Override // com.amap.api.mapcore.util.ii
    public String getIPV6URL() {
        return getURL();
    }

    @Override // com.amap.api.mapcore.util.dp, com.amap.api.mapcore.util.ii
    public Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.mapcore.util.ii
    public Map<String, String> getRequestHead() {
        Hashtable hashtable = new Hashtable(32);
        hashtable.put(IRequestConst.USER_AGENT, "MAC=channel:amapapi");
        return hashtable;
    }

    @Override // com.amap.api.mapcore.util.ii
    public String getURL() {
        return this.d;
    }

    @Override // com.amap.api.mapcore.util.ii
    public boolean isSupportIPV6() {
        return false;
    }
}
