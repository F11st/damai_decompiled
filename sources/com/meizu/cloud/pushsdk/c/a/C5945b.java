package com.meizu.cloud.pushsdk.c.a;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.meizu.cloud.pushsdk.c.a.C5945b;
import com.meizu.cloud.pushsdk.c.b.C5953a;
import com.meizu.cloud.pushsdk.c.c.AbstractC5970j;
import com.meizu.cloud.pushsdk.c.c.C5955b;
import com.meizu.cloud.pushsdk.c.c.C5957c;
import com.meizu.cloud.pushsdk.c.c.C5961f;
import com.meizu.cloud.pushsdk.c.c.C5964g;
import com.meizu.cloud.pushsdk.c.c.C5965h;
import com.meizu.cloud.pushsdk.c.c.C5971k;
import com.meizu.cloud.pushsdk.c.c.InterfaceC5954a;
import com.meizu.cloud.pushsdk.c.d.InterfaceC5975a;
import com.meizu.cloud.pushsdk.c.e.C5978c;
import com.meizu.cloud.pushsdk.c.g.C5987g;
import com.meizu.cloud.pushsdk.c.h.C5997b;
import java.io.File;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;
import tb.jn1;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.c.a.b */
/* loaded from: classes10.dex */
public class C5945b<T extends C5945b> {
    private static final String a = "b";
    private static final C5964g w = C5964g.a("application/json; charset=utf-8");
    private static final C5964g x = C5964g.a("text/x-markdown; charset=utf-8");
    private static final Object z = new Object();
    private InterfaceC5954a A;
    private int B;
    private boolean C;
    private int D;
    private InterfaceC5975a E;
    private Bitmap.Config F;
    private int G;
    private int H;
    private ImageView.ScaleType I;
    private final Executor J;
    private String K;
    private Type L;
    private final int b;
    private final EnumC5951d c;
    private final int d;
    private final String e;
    private int f;
    private final Object g;
    private EnumC5952e h;
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
    private C5964g y;

    /* compiled from: Taobao */
    /* renamed from: com.meizu.cloud.pushsdk.c.a.b$2  reason: invalid class name */
    /* loaded from: classes10.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC5952e.values().length];
            a = iArr;
            try {
                iArr[EnumC5952e.JSON_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[EnumC5952e.JSON_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[EnumC5952e.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[EnumC5952e.BITMAP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[EnumC5952e.PREFETCH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.meizu.cloud.pushsdk.c.a.b$a */
    /* loaded from: classes10.dex */
    public static class C5946a<T extends C5946a> {
        private final String b;
        private Object c;
        private final String g;
        private final String h;
        private Executor j;
        private String k;
        private EnumC5951d a = EnumC5951d.MEDIUM;
        private final HashMap<String, String> d = new HashMap<>();
        private final HashMap<String, String> e = new HashMap<>();
        private final HashMap<String, String> f = new HashMap<>();
        private int i = 0;

        public C5946a(String str, String str2, String str3) {
            this.b = str;
            this.g = str2;
            this.h = str3;
        }

        public C5945b a() {
            return new C5945b(this);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.meizu.cloud.pushsdk.c.a.b$b */
    /* loaded from: classes10.dex */
    public static class C5947b<T extends C5947b> {
        private final String c;
        private Object d;
        private Bitmap.Config e;
        private int f;
        private int g;
        private ImageView.ScaleType h;
        private Executor l;
        private String m;
        private EnumC5951d a = EnumC5951d.MEDIUM;
        private final HashMap<String, String> i = new HashMap<>();
        private final HashMap<String, String> j = new HashMap<>();
        private final HashMap<String, String> k = new HashMap<>();
        private final int b = 0;

        public C5947b(String str) {
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

        public C5945b a() {
            return new C5945b(this);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.meizu.cloud.pushsdk.c.a.b$c */
    /* loaded from: classes10.dex */
    public static class C5948c<T extends C5948c> {
        private final String b;
        private Object c;
        private Executor j;
        private String k;
        private String l;
        private EnumC5951d a = EnumC5951d.MEDIUM;
        private final HashMap<String, String> d = new HashMap<>();
        private final HashMap<String, String> e = new HashMap<>();
        private final HashMap<String, String> f = new HashMap<>();
        private final HashMap<String, String> g = new HashMap<>();
        private final HashMap<String, File> h = new HashMap<>();
        private int i = 0;

        public C5948c(String str) {
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

        public C5945b a() {
            return new C5945b(this);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.meizu.cloud.pushsdk.c.a.b$d */
    /* loaded from: classes10.dex */
    public static class C5949d<T extends C5949d> {
        private final String c;
        private Object d;
        private Executor o;
        private String p;
        private String q;
        private EnumC5951d a = EnumC5951d.MEDIUM;
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

        public C5949d(String str) {
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

        public C5945b a() {
            return new C5945b(this);
        }
    }

    public C5945b(C5946a c5946a) {
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
        this.c = c5946a.a;
        this.e = c5946a.b;
        this.g = c5946a.c;
        this.p = c5946a.g;
        this.q = c5946a.h;
        this.i = c5946a.d;
        this.m = c5946a.e;
        this.n = c5946a.f;
        this.D = c5946a.i;
        this.J = c5946a.j;
        this.K = c5946a.k;
    }

    public C5945b(C5947b c5947b) {
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
        this.b = c5947b.b;
        this.c = c5947b.a;
        this.e = c5947b.c;
        this.g = c5947b.d;
        this.i = c5947b.i;
        this.F = c5947b.e;
        this.H = c5947b.g;
        this.G = c5947b.f;
        this.I = c5947b.h;
        this.m = c5947b.j;
        this.n = c5947b.k;
        this.J = c5947b.l;
        this.K = c5947b.m;
    }

    public C5945b(C5948c c5948c) {
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
        this.c = c5948c.a;
        this.e = c5948c.b;
        this.g = c5948c.c;
        this.i = c5948c.d;
        this.m = c5948c.f;
        this.n = c5948c.g;
        this.l = c5948c.e;
        this.o = c5948c.h;
        this.D = c5948c.i;
        this.J = c5948c.j;
        this.K = c5948c.k;
        if (c5948c.l != null) {
            this.y = C5964g.a(c5948c.l);
        }
    }

    public C5945b(C5949d c5949d) {
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
        this.b = c5949d.b;
        this.c = c5949d.a;
        this.e = c5949d.c;
        this.g = c5949d.d;
        this.i = c5949d.j;
        this.j = c5949d.k;
        this.k = c5949d.l;
        this.m = c5949d.m;
        this.n = c5949d.n;
        this.r = c5949d.e;
        this.s = c5949d.f;
        this.t = c5949d.g;
        this.v = c5949d.i;
        this.u = c5949d.h;
        this.J = c5949d.o;
        this.K = c5949d.p;
        if (c5949d.q != null) {
            this.y = C5964g.a(c5949d.q);
        }
    }

    public C5950c a() {
        this.h = EnumC5952e.STRING;
        return C5978c.a(this);
    }

    public C5950c a(C5971k c5971k) {
        C5950c<Bitmap> a2;
        int i = AnonymousClass2.a[this.h.ordinal()];
        if (i == 1) {
            try {
                return C5950c.a(new JSONArray(C5987g.a(c5971k.b().a()).h()));
            } catch (Exception e) {
                return C5950c.a(C5997b.b(new C5953a(e)));
            }
        } else if (i == 2) {
            try {
                return C5950c.a(new JSONObject(C5987g.a(c5971k.b().a()).h()));
            } catch (Exception e2) {
                return C5950c.a(C5997b.b(new C5953a(e2)));
            }
        } else if (i == 3) {
            try {
                return C5950c.a(C5987g.a(c5971k.b().a()).h());
            } catch (Exception e3) {
                return C5950c.a(C5997b.b(new C5953a(e3)));
            }
        } else if (i != 4) {
            if (i != 5) {
                return null;
            }
            return C5950c.a("prefetch");
        } else {
            synchronized (z) {
                try {
                    try {
                        a2 = C5997b.a(c5971k, this.G, this.H, this.F, this.I);
                    } catch (Exception e4) {
                        return C5950c.a(C5997b.b(new C5953a(e4)));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return a2;
        }
    }

    public C5953a a(C5953a c5953a) {
        try {
            if (c5953a.a() != null && c5953a.a().b() != null && c5953a.a().b().a() != null) {
                c5953a.b(C5987g.a(c5953a.a().b().a()).h());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c5953a;
    }

    public void a(InterfaceC5954a interfaceC5954a) {
        this.A = interfaceC5954a;
    }

    public void a(String str) {
        this.K = str;
    }

    public C5950c b() {
        this.h = EnumC5952e.BITMAP;
        return C5978c.a(this);
    }

    public C5950c c() {
        return C5978c.a(this);
    }

    public int d() {
        return this.b;
    }

    public String e() {
        String str = this.e;
        for (Map.Entry<String, String> entry : this.n.entrySet()) {
            str = str.replace(jn1.BLOCK_START_STR + entry.getKey() + "}", String.valueOf(entry.getValue()));
        }
        C5961f.C5962a f = C5961f.c(str).f();
        for (Map.Entry<String, String> entry2 : this.m.entrySet()) {
            f.a(entry2.getKey(), entry2.getValue());
        }
        return f.b().toString();
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public EnumC5952e f() {
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

    public InterfaceC5975a i() {
        return new InterfaceC5975a() { // from class: com.meizu.cloud.pushsdk.c.a.b.1
            @Override // com.meizu.cloud.pushsdk.c.d.InterfaceC5975a
            public void a(long j, long j2) {
                C5945b.this.B = (int) ((100 * j) / j2);
                if (C5945b.this.E == null || C5945b.this.C) {
                    return;
                }
                C5945b.this.E.a(j, j2);
            }
        };
    }

    public String j() {
        return this.p;
    }

    public String k() {
        return this.q;
    }

    public InterfaceC5954a l() {
        return this.A;
    }

    public AbstractC5970j m() {
        JSONObject jSONObject = this.r;
        if (jSONObject != null) {
            C5964g c5964g = this.y;
            return c5964g != null ? AbstractC5970j.a(c5964g, jSONObject.toString()) : AbstractC5970j.a(w, jSONObject.toString());
        }
        JSONArray jSONArray = this.s;
        if (jSONArray != null) {
            C5964g c5964g2 = this.y;
            return c5964g2 != null ? AbstractC5970j.a(c5964g2, jSONArray.toString()) : AbstractC5970j.a(w, jSONArray.toString());
        }
        String str = this.t;
        if (str != null) {
            C5964g c5964g3 = this.y;
            return c5964g3 != null ? AbstractC5970j.a(c5964g3, str) : AbstractC5970j.a(x, str);
        }
        File file = this.v;
        if (file != null) {
            C5964g c5964g4 = this.y;
            return c5964g4 != null ? AbstractC5970j.a(c5964g4, file) : AbstractC5970j.a(x, file);
        }
        byte[] bArr = this.u;
        if (bArr != null) {
            C5964g c5964g5 = this.y;
            return c5964g5 != null ? AbstractC5970j.a(c5964g5, bArr) : AbstractC5970j.a(x, bArr);
        }
        C5955b.C5956a c5956a = new C5955b.C5956a();
        try {
            for (Map.Entry<String, String> entry : this.j.entrySet()) {
                if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                    c5956a.a(entry.getKey(), entry.getValue());
                }
            }
            for (Map.Entry<String, String> entry2 : this.k.entrySet()) {
                if (!TextUtils.isEmpty(entry2.getKey()) && !TextUtils.isEmpty(entry2.getValue())) {
                    c5956a.b(entry2.getKey(), entry2.getValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c5956a.a();
    }

    public AbstractC5970j n() {
        C5965h.C5966a a2 = new C5965h.C5966a().a(C5965h.e);
        try {
            for (Map.Entry<String, String> entry : this.l.entrySet()) {
                a2.a(C5957c.a("Content-Disposition", "form-data; name=\"" + entry.getKey() + "\""), AbstractC5970j.a((C5964g) null, entry.getValue()));
            }
            for (Map.Entry<String, File> entry2 : this.o.entrySet()) {
                if (entry2.getValue() != null) {
                    String name = entry2.getValue().getName();
                    AbstractC5970j a3 = AbstractC5970j.a(C5964g.a(C5997b.a(name)), entry2.getValue());
                    a2.a(C5957c.a("Content-Disposition", "form-data; name=\"" + entry2.getKey() + "\"; filename=\"" + name + "\""), a3);
                    C5964g c5964g = this.y;
                    if (c5964g != null) {
                        a2.a(c5964g);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a2.a();
    }

    public C5957c o() {
        C5957c.C5958a c5958a = new C5957c.C5958a();
        try {
            for (Map.Entry<String, String> entry : this.i.entrySet()) {
                c5958a.a(entry.getKey(), entry.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c5958a.a();
    }

    public String toString() {
        return "ANRequest{sequenceNumber='" + this.f + ", mMethod=" + this.b + ", mPriority=" + this.c + ", mRequestType=" + this.d + ", mUrl=" + this.e + '}';
    }
}
