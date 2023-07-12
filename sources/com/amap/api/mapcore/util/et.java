package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import com.amap.api.mapcore.util.dc;
import com.amap.api.mapcore.util.eu;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class et {
    private eu a;
    private eu.C4534a b;
    protected Resources d;
    private boolean e = false;
    protected boolean c = false;
    private final Object f = new Object();
    private InterfaceC4533c g = null;

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.et$a */
    /* loaded from: classes10.dex */
    public class C4531a extends dq<Boolean, Void, Bitmap> {
        private final WeakReference<dc.C4503a> e;

        public C4531a(dc.C4503a c4503a) {
            this.e = new WeakReference<>(c4503a);
        }

        private dc.C4503a e() {
            dc.C4503a c4503a = this.e.get();
            if (this == et.c(c4503a)) {
                return c4503a;
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.amap.api.mapcore.util.dq
        public void b(Bitmap bitmap) {
            super.b((C4531a) bitmap);
            synchronized (et.this.f) {
                try {
                    et.this.f.notifyAll();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.amap.api.mapcore.util.dq
        public Bitmap a(Boolean... boolArr) {
            try {
                boolean booleanValue = boolArr[0].booleanValue();
                dc.C4503a c4503a = this.e.get();
                if (c4503a == null) {
                    return null;
                }
                String str = c4503a.a + "-" + c4503a.b + "-" + c4503a.c;
                synchronized (et.this.f) {
                    while (et.this.c && !d()) {
                        et.this.f.wait();
                    }
                }
                Bitmap b = (et.this.a == null || d() || e() == null || et.this.e) ? null : et.this.a.b(str);
                if (booleanValue && b == null && !d() && e() != null && !et.this.e) {
                    synchronized (et.class) {
                        b = et.this.a((Object) c4503a);
                    }
                }
                if (b != null && et.this.a != null) {
                    et.this.a.a(str, b);
                }
                return b;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.amap.api.mapcore.util.dq
        public void a(Bitmap bitmap) {
            try {
                bitmap = (d() || et.this.e) ? null : null;
                dc.C4503a e = e();
                if (bitmap == null || bitmap.isRecycled() || e == null) {
                    return;
                }
                e.a(bitmap);
                if (et.this.g != null) {
                    et.this.g.a();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.et$b */
    /* loaded from: classes10.dex */
    public class C4532b extends dq<Object, Void, Void> {
        protected C4532b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.amap.api.mapcore.util.dq
        /* renamed from: d */
        public Void a(Object... objArr) {
            try {
                int intValue = ((Integer) objArr[0]).intValue();
                if (intValue == 0) {
                    et.this.c();
                } else if (intValue == 1) {
                    et.this.b();
                } else if (intValue == 2) {
                    et.this.d();
                } else if (intValue == 3) {
                    et.this.c(((Boolean) objArr[1]).booleanValue());
                } else if (intValue == 4) {
                    et.this.e();
                }
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.et$c */
    /* loaded from: classes10.dex */
    public interface InterfaceC4533c {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public et(Context context) {
        this.d = context.getResources();
    }

    protected abstract Bitmap a(Object obj);

    protected void e() {
        eu euVar = this.a;
        if (euVar != null) {
            euVar.a(false);
            this.a.a();
        }
    }

    public void f() {
        new C4532b().c(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static C4531a c(dc.C4503a c4503a) {
        if (c4503a != null) {
            return c4503a.j;
        }
        return null;
    }

    public void a(boolean z, dc.C4503a c4503a) {
        if (c4503a == null) {
            return;
        }
        Bitmap bitmap = null;
        try {
            if (this.a != null) {
                bitmap = this.a.a(c4503a.a + "-" + c4503a.b + "-" + c4503a.c);
            }
            if (bitmap != null) {
                c4503a.a(bitmap);
                return;
            }
            C4531a c4531a = new C4531a(c4503a);
            c4503a.j = c4531a;
            c4531a.a(dq.c, Boolean.valueOf(z));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected void d() {
        eu euVar = this.a;
        if (euVar != null) {
            euVar.c();
        }
    }

    public void b(boolean z) {
        synchronized (this.f) {
            this.c = z;
            if (!z) {
                this.f.notifyAll();
            }
        }
    }

    protected void c() {
        eu euVar = this.a;
        if (euVar != null) {
            euVar.b();
        }
    }

    public void d(boolean z) {
        new C4532b().c(3, Boolean.valueOf(z));
    }

    protected void c(boolean z) {
        eu euVar = this.a;
        if (euVar != null) {
            euVar.a(z);
            this.a = null;
        }
    }

    protected void b() {
        eu euVar = this.a;
        if (euVar != null) {
            euVar.a();
        }
    }

    public void a(eu.C4534a c4534a) {
        this.b = c4534a;
        this.a = eu.a(c4534a);
        new C4532b().c(1);
    }

    public void a(boolean z) {
        this.e = z;
        b(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public eu a() {
        return this.a;
    }

    public static void a(dc.C4503a c4503a) {
        C4531a c = c(c4503a);
        if (c != null) {
            c.a(true);
        }
    }

    public void a(InterfaceC4533c interfaceC4533c) {
        this.g = interfaceC4533c;
    }

    public void a(String str) {
        this.b.b(str);
        new C4532b().c(4);
    }
}
