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
    private InterfaceC4514a d;
    private int e;

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.dg$a */
    /* loaded from: classes10.dex */
    public interface InterfaceC4514a {
        void a(byte[] bArr, int i);
    }

    public dg(Context context, InterfaceC4514a interfaceC4514a, int i, String str) {
        this.e = 0;
        this.a = context;
        this.d = interfaceC4514a;
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
        df.C4513a e;
        byte[] bArr;
        try {
            if (MapsInitializer.getNetWorkEnable()) {
                df dfVar = this.c;
                if (dfVar != null && (e = dfVar.e()) != null && (bArr = e.a) != null) {
                    InterfaceC4514a interfaceC4514a = this.d;
                    if (interfaceC4514a != null) {
                        interfaceC4514a.a(bArr, this.e);
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
