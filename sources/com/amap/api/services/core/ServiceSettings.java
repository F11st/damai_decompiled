package com.amap.api.services.core;

import android.content.Context;
import com.amap.api.col.s.C4389bm;
import com.amap.api.col.s.C4434h;
import com.amap.api.col.s.C4435i;
import com.amap.api.col.s.ao;
import com.amap.api.col.s.bq;
import com.amap.api.col.s.bt;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ServiceSettings {
    public static final String CHINESE = "zh-CN";
    public static final String ENGLISH = "en";
    public static final int HTTP = 1;
    public static final int HTTPS = 2;
    private static ServiceSettings c;
    private String a = "zh-CN";
    private int b = 1;
    private int d = 20000;
    private int e = 20000;

    private ServiceSettings() {
    }

    public static ServiceSettings getInstance() {
        if (c == null) {
            c = new ServiceSettings();
        }
        return c;
    }

    public static synchronized void updatePrivacyAgree(Context context, boolean z) {
        synchronized (ServiceSettings.class) {
            bt.a(context, z, C4434h.a(false));
        }
    }

    public static synchronized void updatePrivacyShow(Context context, boolean z, boolean z2) {
        synchronized (ServiceSettings.class) {
            bt.a(context, z, z2, C4434h.a(false));
        }
    }

    public void destroyInnerAsynThreadPool() {
        try {
            ao.b();
        } catch (Throwable th) {
            C4435i.a(th, "ServiceSettings", "destroyInnerAsynThreadPool");
        }
    }

    public int getConnectionTimeOut() {
        return this.d;
    }

    public String getLanguage() {
        return this.a;
    }

    public int getProtocol() {
        return this.b;
    }

    public int getSoTimeOut() {
        return this.e;
    }

    public void setApiKey(String str) {
        C4389bm.a(str);
    }

    public void setConnectionTimeOut(int i) {
        if (i < 5000) {
            this.d = 5000;
        } else if (i > 30000) {
            this.d = 30000;
        } else {
            this.d = i;
        }
    }

    public void setLanguage(String str) {
        this.a = str;
    }

    public void setProtocol(int i) {
        this.b = i;
        bq.a().a(this.b == 2);
    }

    public void setSoTimeOut(int i) {
        if (i < 5000) {
            this.e = 5000;
        } else if (i > 30000) {
            this.e = 30000;
        } else {
            this.e = i;
        }
    }
}
