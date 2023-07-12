package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.mapcore.util.Cif;
import com.amap.api.mapcore.util.ca;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.MapsInitializer;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import mtopsdk.network.util.Constants;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class bu implements Cif.a {
    bv a;
    long d;
    bp f;
    a h;
    private Context i;
    private ca j;
    private String k;
    private il l;
    private bq m;
    long b = 0;
    long c = 0;
    boolean e = true;
    long g = 0;
    private boolean n = false;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface a {
        void c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class b extends dp {
        private final String d;

        public b(String str) {
            this.d = str;
        }

        @Override // com.amap.api.mapcore.util.ii
        public String getIPV6URL() {
            return getURL();
        }

        @Override // com.amap.api.mapcore.util.ii
        public Map<String, String> getRequestHead() {
            return null;
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

    public bu(bv bvVar, String str, Context context, ca caVar) throws IOException {
        this.a = null;
        this.f = bp.a(context.getApplicationContext());
        this.a = bvVar;
        this.i = context;
        this.k = str;
        this.j = caVar;
        d();
    }

    private void c() throws IOException {
        cb cbVar = new cb(this.k);
        cbVar.setConnectionTimeout(30000);
        cbVar.setSoTimeout(30000);
        this.l = new il(cbVar, this.b, this.c, MapsInitializer.getProtocol() == 2);
        this.m = new bq(this.a.b() + File.separator + this.a.c(), this.b);
    }

    private void d() {
        File file = new File(this.a.b() + this.a.c());
        if (file.exists()) {
            this.e = false;
            this.b = file.length();
            try {
                long g = g();
                this.d = g;
                this.c = g;
                return;
            } catch (IOException unused) {
                ca caVar = this.j;
                if (caVar != null) {
                    caVar.a(ca.a.file_io_exception);
                    return;
                }
                return;
            }
        }
        this.b = 0L;
        this.c = 0L;
    }

    private boolean e() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a.b());
        sb.append(File.separator);
        sb.append(this.a.c());
        return new File(sb.toString()).length() >= 10;
    }

    private void f() throws AMapException {
        if (ge.a != 1) {
            for (int i = 0; i < 3; i++) {
                try {
                } catch (Throwable th) {
                    hd.c(th, "SiteFileFetch", "authOffLineDownLoad");
                    th.printStackTrace();
                }
                if (ge.a(this.i, eq.e())) {
                    return;
                }
            }
        }
    }

    private long g() throws IOException {
        Map<String, String> map;
        try {
            map = ih.b().b(new b(this.a.a()), MapsInitializer.getProtocol() == 2);
        } catch (gb e) {
            e.printStackTrace();
            map = null;
        }
        int i = -1;
        if (map != null) {
            for (String str : map.keySet()) {
                if (Constants.Protocol.CONTENT_LENGTH.equalsIgnoreCase(str)) {
                    i = Integer.parseInt(map.get(str));
                }
            }
        }
        return i;
    }

    private void h() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.a == null || currentTimeMillis - this.g <= 500) {
            return;
        }
        i();
        this.g = currentTimeMillis;
        a(this.b);
    }

    private void i() {
        this.f.a(this.a.e(), this.a.d(), this.d, this.b, this.c);
    }

    public void a() {
        try {
            if (eq.d(this.i)) {
                f();
                if (ge.a != 1) {
                    ca caVar = this.j;
                    if (caVar != null) {
                        caVar.a(ca.a.amap_exception);
                        return;
                    }
                    return;
                }
                if (!e()) {
                    this.e = true;
                }
                if (this.e) {
                    long g = g();
                    this.d = g;
                    if (g == -1) {
                        bx.a("File Length is not known!");
                    } else if (g == -2) {
                        bx.a("File is not access!");
                    } else {
                        this.c = g;
                    }
                    this.b = 0L;
                }
                ca caVar2 = this.j;
                if (caVar2 != null) {
                    caVar2.n();
                }
                if (this.b >= this.c) {
                    onFinish();
                    return;
                }
                c();
                this.l.a(this);
                return;
            }
            ca caVar3 = this.j;
            if (caVar3 != null) {
                caVar3.a(ca.a.network_exception);
            }
        } catch (AMapException e) {
            hd.c(e, "SiteFileFetch", "download");
            ca caVar4 = this.j;
            if (caVar4 != null) {
                caVar4.a(ca.a.amap_exception);
            }
        } catch (IOException unused) {
            ca caVar5 = this.j;
            if (caVar5 != null) {
                caVar5.a(ca.a.file_io_exception);
            }
        }
    }

    public void b() {
        il ilVar = this.l;
        if (ilVar != null) {
            ilVar.a();
        }
    }

    @Override // com.amap.api.mapcore.util.Cif.a
    public void onDownload(byte[] bArr, long j) {
        try {
            this.m.a(bArr);
            this.b = j;
            h();
        } catch (IOException e) {
            e.printStackTrace();
            hd.c(e, "fileAccessI", "fileAccessI.write(byte[] data)");
            ca caVar = this.j;
            if (caVar != null) {
                caVar.a(ca.a.file_io_exception);
            }
            il ilVar = this.l;
            if (ilVar != null) {
                ilVar.a();
            }
        }
    }

    @Override // com.amap.api.mapcore.util.Cif.a
    public void onException(Throwable th) {
        bq bqVar;
        this.n = true;
        b();
        ca caVar = this.j;
        if (caVar != null) {
            caVar.a(ca.a.network_exception);
        }
        if ((th instanceof IOException) || (bqVar = this.m) == null) {
            return;
        }
        bqVar.a();
    }

    @Override // com.amap.api.mapcore.util.Cif.a
    public void onFinish() {
        h();
        ca caVar = this.j;
        if (caVar != null) {
            caVar.o();
        }
        bq bqVar = this.m;
        if (bqVar != null) {
            bqVar.a();
        }
        a aVar = this.h;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // com.amap.api.mapcore.util.Cif.a
    public void onStop() {
        if (this.n) {
            return;
        }
        ca caVar = this.j;
        if (caVar != null) {
            caVar.p();
        }
        i();
    }

    private void a(long j) {
        ca caVar;
        long j2 = this.d;
        if (j2 <= 0 || (caVar = this.j) == null) {
            return;
        }
        caVar.a(j2, j);
        this.g = System.currentTimeMillis();
    }

    public void a(a aVar) {
        this.h = aVar;
    }
}
