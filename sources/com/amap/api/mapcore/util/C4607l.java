package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.mapcore.util.Cif;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.amap.api.mapcore.util.l */
/* loaded from: classes10.dex */
public class C4607l implements Cif.InterfaceC4587a {
    C4608a a;
    private final Context b;
    private RandomAccessFile c;
    private il d;
    private String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.l$a */
    /* loaded from: classes10.dex */
    public static class C4608a {
        protected String a;
        protected String b;
        protected String c;
        protected String d;
        protected String e;
        protected C4610c f;

        public C4608a(String str, String str2, String str3, String str4) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4 + ".tmp";
            this.e = str4;
        }

        public String a() {
            return this.a;
        }

        public String b() {
            return this.b;
        }

        public String c() {
            return this.d;
        }

        public String d() {
            return this.e;
        }

        public C4610c e() {
            return this.f;
        }

        public void a(C4610c c4610c) {
            this.f = c4610c;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.l$b */
    /* loaded from: classes10.dex */
    static class C4609b extends AbstractC4517dp {
        private final C4608a d;

        C4609b(C4608a c4608a) {
            this.d = c4608a;
        }

        @Override // com.amap.api.mapcore.util.ii
        public String getIPV6URL() {
            return getURL();
        }

        @Override // com.amap.api.mapcore.util.AbstractC4517dp, com.amap.api.mapcore.util.ii
        public Map<String, String> getParams() {
            return null;
        }

        @Override // com.amap.api.mapcore.util.ii
        public Map<String, String> getRequestHead() {
            return null;
        }

        @Override // com.amap.api.mapcore.util.ii
        public String getURL() {
            C4608a c4608a = this.d;
            if (c4608a != null) {
                return c4608a.a();
            }
            return null;
        }

        @Override // com.amap.api.mapcore.util.ii
        public boolean isSupportIPV6() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.l$c */
    /* loaded from: classes10.dex */
    public static class C4610c {
        protected String a;
        protected String b;

        public C4610c(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        public String a() {
            return this.a;
        }

        public String b() {
            return this.b;
        }

        public boolean c() {
            return (TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.b)) ? false : true;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.l$d */
    /* loaded from: classes10.dex */
    static class C4611d extends C4608a {
        public C4611d(String str, String str2, String str3, String str4) {
            super(str, str2, str3, str4);
        }

        public void a(String str, String str2) {
            a(new C4610c(str, str2));
        }
    }

    public C4607l(Context context, C4608a c4608a, gm gmVar) {
        this.b = context.getApplicationContext();
        if (c4608a == null) {
            return;
        }
        this.a = c4608a;
        this.d = new il(new C4609b(c4608a));
        this.e = c4608a.c();
    }

    private boolean b() {
        C4610c e = this.a.e();
        return (e != null && e.c() && eg.a(this.b, e.a(), e.b(), "").equalsIgnoreCase(this.a.b())) ? false : true;
    }

    public void a() {
        il ilVar;
        try {
            if (!b() || (ilVar = this.d) == null) {
                return;
            }
            ilVar.a(this);
        } catch (Throwable th) {
            hd.c(th, "AuthTaskDownload", "startDownload()");
        }
    }

    @Override // com.amap.api.mapcore.util.Cif.InterfaceC4587a
    public void onDownload(byte[] bArr, long j) {
        try {
            if (this.c == null) {
                File file = new File(this.e);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                this.c = new RandomAccessFile(file, "rw");
            }
            this.c.seek(j);
            this.c.write(bArr);
        } catch (Throwable th) {
            hd.c(th, "AuthTaskDownload", "onDownload()");
        }
    }

    @Override // com.amap.api.mapcore.util.Cif.InterfaceC4587a
    public void onException(Throwable th) {
        try {
            RandomAccessFile randomAccessFile = this.c;
            if (randomAccessFile == null) {
                return;
            }
            randomAccessFile.close();
        } catch (Throwable th2) {
            hd.c(th2, "AuthTaskDownload", "onException()");
        }
    }

    @Override // com.amap.api.mapcore.util.Cif.InterfaceC4587a
    public void onFinish() {
        try {
            RandomAccessFile randomAccessFile = this.c;
            if (randomAccessFile == null) {
                return;
            }
            randomAccessFile.close();
            String b = this.a.b();
            String a = gk.a(this.e);
            if (a != null && b.equalsIgnoreCase(a)) {
                String d = this.a.d();
                br brVar = new br();
                File file = new File(this.e);
                brVar.a(file, new File(d), -1L, bx.a(file), null);
                C4610c e = this.a.e();
                if (e != null && e.c()) {
                    eg.a(this.b, e.a(), e.b(), (Object) a);
                }
                new File(this.e).delete();
                return;
            }
            new File(this.e).delete();
        } catch (Throwable th) {
            hd.c(th, "AuthTaskDownload", "onFinish()");
        }
    }

    @Override // com.amap.api.mapcore.util.Cif.InterfaceC4587a
    public void onStop() {
    }
}
