package com.amap.api.mapcore.util;

import android.text.TextUtils;
import java.net.Proxy;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class ii {
    public static final int DEFAULT_RETRY_TIMEOUT = 5000;
    int a = 20000;
    int b = 20000;
    Proxy c = null;

    private String a(String str) {
        Map<String, String> params;
        byte[] entityBytes = getEntityBytes();
        if (entityBytes == null || entityBytes.length == 0 || (params = getParams()) == null) {
            return str;
        }
        String a = ig.a(params);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append("?");
        stringBuffer.append(a);
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        return a(getURL());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c() {
        return a(getIPV6URL());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] d() {
        byte[] entityBytes = getEntityBytes();
        if (entityBytes == null || entityBytes.length == 0) {
            String a = ig.a(getParams());
            return !TextUtils.isEmpty(a) ? gn.a(a) : entityBytes;
        }
        return entityBytes;
    }

    public int getConntectionTimeout() {
        return this.a;
    }

    public byte[] getEntityBytes() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getIPDNSName() {
        return "";
    }

    public String getIPV6URL() {
        return getURL();
    }

    public abstract Map<String, String> getParams();

    public abstract Map<String, String> getRequestHead();

    public int getSoTimeout() {
        return this.b;
    }

    public abstract String getURL();

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isIPRequest() {
        return !TextUtils.isEmpty(getIPDNSName());
    }

    public boolean isIgnoreGZip() {
        return false;
    }

    public boolean isSupportIPV6() {
        return false;
    }

    public final void setConnectionTimeout(int i) {
        this.a = i;
    }

    public final void setProxy(Proxy proxy) {
        this.c = proxy;
    }

    public final void setSoTimeout(int i) {
        this.b = i;
    }
}
