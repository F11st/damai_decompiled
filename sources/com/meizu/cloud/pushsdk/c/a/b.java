package com.meizu.cloud.pushsdk.c.a;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.meizu.cloud.pushsdk.c.a.b;
import com.meizu.cloud.pushsdk.c.c.b;
import com.meizu.cloud.pushsdk.c.c.c;
import com.meizu.cloud.pushsdk.c.c.f;
import com.meizu.cloud.pushsdk.c.c.g;
import com.meizu.cloud.pushsdk.c.c.h;
import com.meizu.cloud.pushsdk.c.c.j;
import com.meizu.cloud.pushsdk.c.c.k;
import java.io.File;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class b<T extends b> {
    private static final String a = "b";
    private static final g w = g.a("application/json; charset=utf-8");
    private static final g x = g.a("text/x-markdown; charset=utf-8");
    private static final Object z = new Object();
    private com.meizu.cloud.pushsdk.c.c.a A;
    private int B;
    private boolean C;
    private int D;
    private com.meizu.cloud.pushsdk.c.d.a E;
    private Bitmap.Config F;
    private int G;
    private int H;
    private ImageView.ScaleType I;
    private final Executor J;
    private String K;
    private Type L;
    private final int b;
    private final com.meizu.cloud.pushsdk.c.a.d c;
    private final int d;
    private final String e;
    private int f;
    private final Object g;
    private e h;
    private final HashMap<String, String> i;
    private HashMap<String, String> j;
    private HashMap<String, String> k;
    private HashMap<String, String> l;
    private final HashMap<String, String> m;
    private final HashMap<String, String> n;
    private HashMap<String, File> o;
    private String p;
    private String q;
    private JSONObject r;
    private JSONArray s;
    private String t;
    private byte[] u;
    private File v;
    private g y;

    /* compiled from: Taobao */
    /* renamed from: com.meizu.cloud.pushsdk.c.a.b$2  reason: invalid class name */
    /* loaded from: classes10.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[e.values().length];
            a = iArr;
            try {
                iArr[e.JSON_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[e.JSON_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[e.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[e.BITMAP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[e.PREFETCH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a<T extends a> {
        private final String b;
        private Object c;
        private final String g;
        private final String h;
        private Executor j;
        private String k;
        private com.meizu.cloud.pushsdk.c.a.d a = com.meizu.cloud.pushsdk.c.a.d.MEDIUM;
        private final HashMap<String, String> d = new HashMap<>();
        private final HashMap<String, String> e = new HashMap<>();
        private final HashMap<String, String> f = new HashMap<>();
        private int i = 0;

        public a(String str, String str2, String str3) {
            this.b = str;
            this.g = str2;
            this.h = str3;
        }

        public b a() {
            return new b(this);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.meizu.cloud.pushsdk.c.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0259b<T extends C0259b> {
        private final String c;
        private Object d;
        private Bitmap.Config e;
        private int f;
        private int g;
        private ImageView.ScaleType h;
        private Executor l;
        private String m;
        private com.meizu.cloud.pushsdk.c.a.d a = com.meizu.cloud.pushsdk.c.a.d.MEDIUM;
        private final HashMap<String, String> i = new HashMap<>();
        private final HashMap<String, String> j = new HashMap<>();
        private final HashMap<String, String> k = new HashMap<>();
        private final int b = 0;

        public C0259b(String str) {
            this.c = str;
        }

        public T a(HashMap<String, String> hashMap) {
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    this.j.put(entry.getKey(), entry.getValue());
                }
            }
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class c<T extends c> {
        private final String b;
        private Object c;
        private Executor j;
        private String k;
        private String l;
        private com.meizu.cloud.pushsdk.c.a.d a = com.meizu.cloud.pushsdk.c.a.d.MEDIUM;
        private final HashMap<String, String> d = new HashMap<>();
        private final HashMap<String, String> e = new HashMap<>();
        private final HashMap<String, String> f = new HashMap<>();
        private final HashMap<String, String> g = new HashMap<>();
        private final HashMap<String, File> h = new HashMap<>();
        private int i = 0;

        public c(String str) {
            this.b = str;
        }

        public T a(String str, File file) {
            this.h.put(str, file);
            return this;
        }

        public T a(HashMap<String, String> hashMap) {
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    this.e.put(entry.getKey(), entry.getValue());
                }
            }
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class d<T extends d> {
        private final String c;
        private Object d;
        private Executor o;
        private String p;
        private String q;
        private com.meizu.cloud.pushsdk.c.a.d a = com.meizu.cloud.pushsdk.c.a.d.MEDIUM;
        private JSONObject e = null;
        private JSONArray f = null;
        private String g = null;
        private byte[] h = null;
        private File i = null;
        private final HashMap<String, String> j = new HashMap<>();
        private final HashMap<String, String> k = new HashMap<>();
        private final HashMap<String, String> l = new HashMap<>();
        private final HashMap<String, String> m = new HashMap<>();
        private final HashMap<String, String> n = new HashMap<>();
        private final int b = 1;

        public d(String str) {
            this.c = str;
        }

        public T a(HashMap<String, String> hashMap) {
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    this.k.put(entry.getKey(), entry.getValue());
                }
            }
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    public b(a aVar) {
        this.j = new HashMap<>();
        this.k = new HashMap<>();
        this.l = new HashMap<>();
        this.o = new HashMap<>();
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.y = null;
        this.D = 0;
        this.L = null;
        this.d = 1;
        this.b = 0;
        this.c = aVar.a;
        this.e = aVar.b;
        this.g = aVar.c;
        this.p = aVar.g;
        this.q = aVar.h;
        this.i = aVar.d;
        this.m = aVar.e;
        this.n = aVar.f;
        this.D = aVar.i;
        this.J = aVar.j;
        this.K = aVar.k;
    }

    public b(C0259b c0259b) {
        this.j = new HashMap<>();
        this.k = new HashMap<>();
        this.l = new HashMap<>();
        this.o = new HashMap<>();
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.y = null;
        this.D = 0;
        this.L = null;
        this.d = 0;
        this.b = c0259b.b;
        this.c = c0259b.a;
        this.e = c0259b.c;
        this.g = c0259b.d;
        this.i = c0259b.i;
        this.F = c0259b.e;
        this.H = c0259b.g;
        this.G = c0259b.f;
        this.I = c0259b.h;
        this.m = c0259b.j;
        this.n = c0259b.k;
        this.J = c0259b.l;
        this.K = c0259b.m;
    }

    public b(c cVar) {
        this.j = new HashMap<>();
        this.k = new HashMap<>();
        this.l = new HashMap<>();
        this.o = new HashMap<>();
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.y = null;
        this.D = 0;
        this.L = null;
        this.d = 2;
        this.b = 1;
        this.c = cVar.a;
        this.e = cVar.b;
        this.g = cVar.c;
        this.i = cVar.d;
        this.m = cVar.f;
        this.n = cVar.g;
        this.l = cVar.e;
        this.o = cVar.h;
        this.D = cVar.i;
        this.J = cVar.j;
        this.K = cVar.k;
        if (cVar.l != null) {
            this.y = g.a(cVar.l);
        }
    }

    public b(d dVar) {
        this.j = new HashMap<>();
        this.k = new HashMap<>();
        this.l = new HashMap<>();
        this.o = new HashMap<>();
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.y = null;
        this.D = 0;
        this.L = null;
        this.d = 0;
        this.b = dVar.b;
        this.c = dVar.a;
        this.e = dVar.c;
        this.g = dVar.d;
        this.i = dVar.j;
        this.j = dVar.k;
        this.k = dVar.l;
        this.m = dVar.m;
        this.n = dVar.n;
        this.r = dVar.e;
        this.s = dVar.f;
        this.t = dVar.g;
        this.v = dVar.i;
        this.u = dVar.h;
        this.J = dVar.o;
        this.K = dVar.p;
        if (dVar.q != null) {
            this.y = g.a(dVar.q);
        }
    }

    public com.meizu.cloud.pushsdk.c.a.c a() {
        this.h = e.STRING;
        return com.meizu.cloud.pushsdk.c.e.c.a(this);
    }

    public com.meizu.cloud.pushsdk.c.a.c a(k kVar) {
        com.meizu.cloud.pushsdk.c.a.c<Bitmap> a2;
        int i = AnonymousClass2.a[this.h.ordinal()];
        if (i == 1) {
            try {
                return com.meizu.cloud.pushsdk.c.a.c.a(new JSONArray(com.meizu.cloud.pushsdk.c.g.g.a(kVar.b().a()).h()));
            } catch (Exception e) {
                return com.meizu.cloud.pushsdk.c.a.c.a(com.meizu.cloud.pushsdk.c.h.b.b(new com.meizu.cloud.pushsdk.c.b.a(e)));
            }
        } else if (i == 2) {
            try {
                return com.meizu.cloud.pushsdk.c.a.c.a(new JSONObject(com.meizu.cloud.pushsdk.c.g.g.a(kVar.b().a()).h()));
            } catch (Exception e2) {
                return com.meizu.cloud.pushsdk.c.a.c.a(com.meizu.cloud.pushsdk.c.h.b.b(new com.meizu.cloud.pushsdk.c.b.a(e2)));
            }
        } else if (i == 3) {
            try {
                return com.meizu.cloud.pushsdk.c.a.c.a(com.meizu.cloud.pushsdk.c.g.g.a(kVar.b().a()).h());
            } catch (Exception e3) {
                return com.meizu.cloud.pushsdk.c.a.c.a(com.meizu.cloud.pushsdk.c.h.b.b(new com.meizu.cloud.pushsdk.c.b.a(e3)));
            }
        } else if (i != 4) {
            if (i != 5) {
                return null;
            }
            return com.meizu.cloud.pushsdk.c.a.c.a("prefetch");
        } else {
            synchronized (z) {
                try {
                    try {
                        a2 = com.meizu.cloud.pushsdk.c.h.b.a(kVar, this.G, this.H, this.F, this.I);
                    } catch (Exception e4) {
                        return com.meizu.cloud.pushsdk.c.a.c.a(com.meizu.cloud.pushsdk.c.h.b.b(new com.meizu.cloud.pushsdk.c.b.a(e4)));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return a2;
        }
    }

    public com.meizu.cloud.pushsdk.c.b.a a(com.meizu.cloud.pushsdk.c.b.a aVar) {
        try {
            if (aVar.a() != null && aVar.a().b() != null && aVar.a().b().a() != null) {
                aVar.b(com.meizu.cloud.pushsdk.c.g.g.a(aVar.a().b().a()).h());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aVar;
    }

    public void a(com.meizu.cloud.pushsdk.c.c.a aVar) {
        this.A = aVar;
    }

    public void a(String str) {
        this.K = str;
    }

    public com.meizu.cloud.pushsdk.c.a.c b() {
        this.h = e.BITMAP;
        return com.meizu.cloud.pushsdk.c.e.c.a(this);
    }

    public com.meizu.cloud.pushsdk.c.a.c c() {
        return com.meizu.cloud.pushsdk.c.e.c.a(this);
    }

    public int d() {
        return this.b;
    }

    public String e() {
        String str = this.e;
        for (Map.Entry<String, String> entry : this.n.entrySet()) {
            str = str.replace(jn1.BLOCK_START_STR + entry.getKey() + "}", String.valueOf(entry.getValue()));
        }
        f.a f = f.c(str).f();
        for (Map.Entry<String, String> entry2 : this.m.entrySet()) {
            f.a(entry2.getKey(), entry2.getValue());
        }
        return f.b().toString();
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public e f() {
        return this.h;
    }

    public int g() {
        return this.d;
    }

    public String h() {
        return this.K;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public com.meizu.cloud.pushsdk.c.d.a i() {
        return new com.meizu.cloud.pushsdk.c.d.a() { // from class: com.meizu.cloud.pushsdk.c.a.b.1
            @Override // com.meizu.cloud.pushsdk.c.d.a
            public void a(long j, long j2) {
                b.this.B = (int) ((100 * j) / j2);
                if (b.this.E == null || b.this.C) {
                    return;
                }
                b.this.E.a(j, j2);
            }
        };
    }

    public String j() {
        return this.p;
    }

    public String k() {
        return this.q;
    }

    public com.meizu.cloud.pushsdk.c.c.a l() {
        return this.A;
    }

    public j m() {
        JSONObject jSONObject = this.r;
        if (jSONObject != null) {
            g gVar = this.y;
            return gVar != null ? j.a(gVar, jSONObject.toString()) : j.a(w, jSONObject.toString());
        }
        JSONArray jSONArray = this.s;
        if (jSONArray != null) {
            g gVar2 = this.y;
            return gVar2 != null ? j.a(gVar2, jSONArray.toString()) : j.a(w, jSONArray.toString());
        }
        String str = this.t;
        if (str != null) {
            g gVar3 = this.y;
            return gVar3 != null ? j.a(gVar3, str) : j.a(x, str);
        }
        File file = this.v;
        if (file != null) {
            g gVar4 = this.y;
            return gVar4 != null ? j.a(gVar4, file) : j.a(x, file);
        }
        byte[] bArr = this.u;
        if (bArr != null) {
            g gVar5 = this.y;
            return gVar5 != null ? j.a(gVar5, bArr) : j.a(x, bArr);
        }
        b.a aVar = new b.a();
        try {
            for (Map.Entry<String, String> entry : this.j.entrySet()) {
                if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                    aVar.a(entry.getKey(), entry.getValue());
                }
            }
            for (Map.Entry<String, String> entry2 : this.k.entrySet()) {
                if (!TextUtils.isEmpty(entry2.getKey()) && !TextUtils.isEmpty(entry2.getValue())) {
                    aVar.b(entry2.getKey(), entry2.getValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aVar.a();
    }

    public j n() {
        h.a a2 = new h.a().a(h.e);
        try {
            for (Map.Entry<String, String> entry : this.l.entrySet()) {
                a2.a(com.meizu.cloud.pushsdk.c.c.c.a("Content-Disposition", "form-data; name=\"" + entry.getKey() + "\""), j.a((g) null, entry.getValue()));
            }
            for (Map.Entry<String, File> entry2 : this.o.entrySet()) {
                if (entry2.getValue() != null) {
                    String name = entry2.getValue().getName();
                    j a3 = j.a(g.a(com.meizu.cloud.pushsdk.c.h.b.a(name)), entry2.getValue());
                    a2.a(com.meizu.cloud.pushsdk.c.c.c.a("Content-Disposition", "form-data; name=\"" + entry2.getKey() + "\"; filename=\"" + name + "\""), a3);
                    g gVar = this.y;
                    if (gVar != null) {
                        a2.a(gVar);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a2.a();
    }

    public com.meizu.cloud.pushsdk.c.c.c o() {
        c.a aVar = new c.a();
        try {
            for (Map.Entry<String, String> entry : this.i.entrySet()) {
                aVar.a(entry.getKey(), entry.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aVar.a();
    }

    public String toString() {
        return "ANRequest{sequenceNumber='" + this.f + ", mMethod=" + this.b + ", mPriority=" + this.c + ", mRequestType=" + this.d + ", mUrl=" + this.e + '}';
    }
}
