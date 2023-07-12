package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Bundle;
import com.amap.api.mapcore.util.bu;
import com.amap.api.mapcore.util.ca;
import com.amap.api.maps.AMap;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class bf extends jk implements bu.a {
    private bu a;
    private bw b;
    private bz c;
    private Context d;
    private Bundle f;
    private boolean g;

    public bf(bz bzVar, Context context) {
        this.f = new Bundle();
        this.g = false;
        this.c = bzVar;
        this.d = context;
    }

    private String d() {
        return eq.c(this.d);
    }

    private void e() throws IOException {
        bu buVar = new bu(new bv(this.c.getUrl(), d(), this.c.z(), 1, this.c.A()), this.c.getUrl(), this.d, this.c);
        this.a = buVar;
        buVar.a(this);
        bz bzVar = this.c;
        this.b = new bw(bzVar, bzVar);
        if (this.g) {
            return;
        }
        this.a.a();
    }

    public void a() {
        this.g = true;
        bu buVar = this.a;
        if (buVar != null) {
            buVar.b();
        } else {
            cancelTask();
        }
        bw bwVar = this.b;
        if (bwVar != null) {
            bwVar.a();
        }
    }

    public void b() {
        Bundle bundle = this.f;
        if (bundle != null) {
            bundle.clear();
            this.f = null;
        }
    }

    @Override // com.amap.api.mapcore.util.bu.a
    public void c() {
        bw bwVar = this.b;
        if (bwVar != null) {
            bwVar.b();
        }
    }

    @Override // com.amap.api.mapcore.util.jk
    public void runTask() {
        if (this.c.y()) {
            this.c.a(ca.a.file_io_exception);
            return;
        }
        try {
            e();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public bf(bz bzVar, Context context, AMap aMap) {
        this(bzVar, context);
    }
}
