package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.mapcore.util.df;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class dg implements Runnable {
    private Context a;
    private IAMapDelegate b;
    private df c;
    private a d;
    private int e;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface a {
        void a(byte[] bArr, int i);
    }

    public dg(Context context, a aVar, int i, String str) {
        this.e = 0;
        this.a = context;
        this.d = aVar;
        this.e = i;
        if (this.c == null) {
            this.c = new df(context, "", i != 0);
        }
        this.c.a(str);
    }

    public void a(String str) {
        df dfVar = this.c;
        if (dfVar != null) {
            dfVar.d(str);
        }
    }

    public void b() {
        ep.a().a(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        df.a e;
        byte[] bArr;
        try {
            if (MapsInitializer.getNetWorkEnable()) {
                df dfVar = this.c;
                if (dfVar != null && (e = dfVar.e()) != null && (bArr = e.a) != null) {
                    a aVar = this.d;
                    if (aVar != null) {
                        aVar.a(bArr, this.e);
                    } else {
                        IAMapDelegate iAMapDelegate = this.b;
                        if (iAMapDelegate != null) {
                            iAMapDelegate.setCustomMapStyle(iAMapDelegate.getMapConfig().isCustomStyleEnable(), e.a);
                        }
                    }
                }
                hd.a(this.a, eq.e());
                IAMapDelegate iAMapDelegate2 = this.b;
                if (iAMapDelegate2 != null) {
                    iAMapDelegate2.setRunLowFrame(false);
                }
            }
        } catch (Throwable th) {
            hd.c(th, "CustomStyleTask", "download customStyle");
            th.printStackTrace();
        }
    }

    public void a() {
        this.a = null;
        if (this.c != null) {
            this.c = null;
        }
    }

    public dg(Context context, IAMapDelegate iAMapDelegate) {
        this.e = 0;
        this.a = context;
        this.b = iAMapDelegate;
        if (this.c == null) {
            this.c = new df(context, "");
        }
    }
}
