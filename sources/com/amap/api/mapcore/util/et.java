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
    private eu.a b;
    protected Resources d;
    private boolean e = false;
    protected boolean c = false;
    private final Object f = new Object();
    private c g = null;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class a extends dq<Boolean, Void, Bitmap> {
        private final WeakReference<dc.a> e;

        public a(dc.a aVar) {
            this.e = new WeakReference<>(aVar);
        }

        private dc.a e() {
            dc.a aVar = this.e.get();
            if (this == et.c(aVar)) {
                return aVar;
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.amap.api.mapcore.util.dq
        public void b(Bitmap bitmap) {
            super.b((a) bitmap);
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
                dc.a aVar = this.e.get();
                if (aVar == null) {
                    return null;
                }
                String str = aVar.a + "-" + aVar.b + "-" + aVar.c;
                synchronized (et.this.f) {
                    while (et.this.c && !d()) {
                        et.this.f.wait();
                    }
                }
                Bitmap b = (et.this.a == null || d() || e() == null || et.this.e) ? null : et.this.a.b(str);
                if (booleanValue && b == null && !d() && e() != null && !et.this.e) {
                    synchronized (et.class) {
                        b = et.this.a((Object) aVar);
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
                dc.a e = e();
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
    /* loaded from: classes10.dex */
    public class b extends dq<Object, Void, Void> {
        protected b() {
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
    /* loaded from: classes10.dex */
    public interface c {
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
        new b().c(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static a c(dc.a aVar) {
        if (aVar != null) {
            return aVar.j;
        }
        return null;
    }

    public void a(boolean z, dc.a aVar) {
        if (aVar == null) {
            return;
        }
        Bitmap bitmap = null;
        try {
            if (this.a != null) {
                bitmap = this.a.a(aVar.a + "-" + aVar.b + "-" + aVar.c);
            }
            if (bitmap != null) {
                aVar.a(bitmap);
                return;
            }
            a aVar2 = new a(aVar);
            aVar.j = aVar2;
            aVar2.a(dq.c, Boolean.valueOf(z));
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
        new b().c(3, Boolean.valueOf(z));
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

    public void a(eu.a aVar) {
        this.b = aVar;
        this.a = eu.a(aVar);
        new b().c(1);
    }

    public void a(boolean z) {
        this.e = z;
        b(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public eu a() {
        return this.a;
    }

    public static void a(dc.a aVar) {
        a c2 = c(aVar);
        if (c2 != null) {
            c2.a(true);
        }
    }

    public void a(c cVar) {
        this.g = cVar;
    }

    public void a(String str) {
        this.b.b(str);
        new b().c(4);
    }
}
