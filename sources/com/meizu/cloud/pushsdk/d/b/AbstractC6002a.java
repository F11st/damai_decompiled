package com.meizu.cloud.pushsdk.d.b;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.meizu.cloud.pushsdk.c.c.AbstractC5970j;
import com.meizu.cloud.pushsdk.c.c.C5960e;
import com.meizu.cloud.pushsdk.c.c.C5964g;
import com.meizu.cloud.pushsdk.c.c.C5968i;
import com.meizu.cloud.pushsdk.c.c.C5971k;
import com.meizu.cloud.pushsdk.c.c.InterfaceC5954a;
import com.meizu.cloud.pushsdk.d.a.C6000b;
import com.meizu.cloud.pushsdk.d.a.InterfaceC5999a;
import com.meizu.cloud.pushsdk.d.f.C6030c;
import com.meizu.cloud.pushsdk.d.f.C6032e;
import io.flutter.wpkbridge.WPKFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.d.b.a */
/* loaded from: classes10.dex */
public abstract class AbstractC6002a {
    protected final Context a;
    protected final InterfaceC6010f b;
    protected final int c;
    protected final int d;
    protected final int e;
    protected final TimeUnit f;
    protected final AtomicBoolean g;
    private final String h;
    private final C5964g i;
    private Uri.Builder j;
    private EnumC6008d k;
    private EnumC6006b l;
    private EnumC6012h m;
    private final SSLSocketFactory n;
    private final HostnameVerifier o;
    private String p;
    private final long q;
    private final long r;
    private final InterfaceC5954a s;

    /* compiled from: Taobao */
    /* renamed from: com.meizu.cloud.pushsdk.d.b.a$a */
    /* loaded from: classes10.dex */
    public static class C6003a {
        protected final String a;
        protected final Context b;
        protected SSLSocketFactory m;
        protected HostnameVerifier n;
        protected InterfaceC6010f c = null;
        protected EnumC6008d d = EnumC6008d.POST;
        protected EnumC6006b e = EnumC6006b.Single;
        protected EnumC6012h f = EnumC6012h.HTTPS;
        protected int g = 5;
        protected int h = 250;
        protected int i = 5;
        protected long j = 40000;
        protected long k = 40000;
        protected TimeUnit l = TimeUnit.SECONDS;
        protected InterfaceC5954a o = new C5960e();

        public C6003a(String str, Context context, Class<? extends AbstractC6002a> cls) {
            this.a = str;
            this.b = context;
        }

        public C6003a a(int i) {
            this.g = i;
            return this;
        }

        public C6003a a(InterfaceC5954a interfaceC5954a) {
            if (interfaceC5954a != null) {
                this.o = interfaceC5954a;
                String simpleName = C6003a.class.getSimpleName();
                C6030c.c(simpleName, "set new call " + interfaceC5954a, new Object[0]);
            }
            return this;
        }

        public C6003a a(EnumC6006b enumC6006b) {
            this.e = enumC6006b;
            return this;
        }

        public C6003a a(InterfaceC6010f interfaceC6010f) {
            this.c = interfaceC6010f;
            return this;
        }

        public C6003a b(int i) {
            this.h = i;
            return this;
        }

        public C6003a c(int i) {
            this.i = i;
            return this;
        }
    }

    public AbstractC6002a(C6003a c6003a) {
        String simpleName = AbstractC6002a.class.getSimpleName();
        this.h = simpleName;
        this.i = C5964g.a("application/json; charset=utf-8");
        this.g = new AtomicBoolean(false);
        this.k = c6003a.d;
        this.b = c6003a.c;
        this.a = c6003a.b;
        this.l = c6003a.e;
        this.m = c6003a.f;
        this.n = c6003a.m;
        this.o = c6003a.n;
        this.c = c6003a.g;
        this.d = c6003a.i;
        this.e = c6003a.h;
        this.q = c6003a.j;
        this.r = c6003a.k;
        this.p = c6003a.a;
        this.f = c6003a.l;
        this.s = c6003a.o;
        c();
        C6030c.c(simpleName, "Emitter created successfully!", new Object[0]);
    }

    private C5968i a(InterfaceC5999a interfaceC5999a) {
        a(interfaceC5999a, "");
        this.j.clearQuery();
        HashMap hashMap = (HashMap) interfaceC5999a.a();
        for (String str : hashMap.keySet()) {
            this.j.appendQueryParameter(str, (String) hashMap.get(str));
        }
        return new C5968i.C5969a().a(this.j.build().toString()).a().c();
    }

    private C5968i a(ArrayList<InterfaceC5999a> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator<InterfaceC5999a> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next().a());
        }
        C6000b c6000b = new C6000b("push_group_data", arrayList2);
        String str = this.h;
        C6030c.b(str, "final SelfDescribingJson " + c6000b, new Object[0]);
        String uri = this.j.build().toString();
        return new C5968i.C5969a().a(uri).a(AbstractC5970j.a(this.i, c6000b.toString())).c();
    }

    private void a(C5971k c5971k) {
        if (c5971k != null) {
            try {
                if (c5971k.b() != null) {
                    c5971k.b().close();
                }
            } catch (Exception unused) {
                C6030c.b(this.h, "Unable to close source data", new Object[0]);
            }
        }
    }

    private void a(InterfaceC5999a interfaceC5999a, String str) {
        if ("".equals(str)) {
            str = C6032e.a();
        }
        interfaceC5999a.a(WPKFactory.CONF_SERVER_TIME, str);
    }

    private void c() {
        StringBuilder sb;
        String str;
        String str2 = this.h;
        C6030c.a(str2, "security " + this.m, new Object[0]);
        if (this.m == EnumC6012h.HTTP) {
            sb = new StringBuilder();
            str = "http://";
        } else {
            sb = new StringBuilder();
            str = "https://";
        }
        sb.append(str);
        sb.append(this.p);
        this.j = Uri.parse(sb.toString()).buildUpon();
        if (this.k == EnumC6008d.GET) {
            this.j.appendPath("i");
        } else {
            this.j.appendEncodedPath("push_data_report/mobile");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int a(C5968i c5968i) {
        C5971k c5971k = null;
        try {
            C6030c.b(this.h, "Sending request: %s", c5968i);
            c5971k = this.s.a(c5968i);
            return c5971k.a();
        } catch (IOException e) {
            C6030c.a(this.h, "Request sending failed: %s", Log.getStackTraceString(e));
            return -1;
        } finally {
            a(c5971k);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LinkedList<C6009e> a(C6007c c6007c) {
        int size = c6007c.a().size();
        LinkedList<Long> b = c6007c.b();
        LinkedList<C6009e> linkedList = new LinkedList<>();
        long j = 22;
        if (this.k == EnumC6008d.GET) {
            for (int i = 0; i < size; i++) {
                LinkedList linkedList2 = new LinkedList();
                linkedList2.add(b.get(i));
                InterfaceC5999a interfaceC5999a = c6007c.a().get(i);
                linkedList.add(new C6009e(interfaceC5999a.b() + 22 > this.q, a(interfaceC5999a), linkedList2));
            }
        } else {
            int i2 = 0;
            while (i2 < size) {
                LinkedList linkedList3 = new LinkedList();
                ArrayList<InterfaceC5999a> arrayList = new ArrayList<>();
                long j2 = 0;
                int i3 = i2;
                while (i3 < this.l.a() + i2 && i3 < size) {
                    InterfaceC5999a interfaceC5999a2 = c6007c.a().get(i3);
                    long b2 = interfaceC5999a2.b() + j;
                    if (b2 + 88 > this.r) {
                        ArrayList<InterfaceC5999a> arrayList2 = new ArrayList<>();
                        LinkedList linkedList4 = new LinkedList();
                        arrayList2.add(interfaceC5999a2);
                        linkedList4.add(b.get(i3));
                        linkedList.add(new C6009e(true, a(arrayList2), linkedList4));
                    } else {
                        j2 += b2;
                        if (j2 + 88 + (arrayList.size() - 1) > this.r) {
                            linkedList.add(new C6009e(false, a(arrayList), linkedList3));
                            ArrayList<InterfaceC5999a> arrayList3 = new ArrayList<>();
                            LinkedList linkedList5 = new LinkedList();
                            arrayList3.add(interfaceC5999a2);
                            linkedList5.add(b.get(i3));
                            arrayList = arrayList3;
                            linkedList3 = linkedList5;
                            j2 = b2;
                        } else {
                            arrayList.add(interfaceC5999a2);
                            linkedList3.add(b.get(i3));
                        }
                    }
                    i3++;
                    j = 22;
                }
                if (!arrayList.isEmpty()) {
                    linkedList.add(new C6009e(false, a(arrayList), linkedList3));
                }
                i2 += this.l.a();
                j = 22;
            }
        }
        return linkedList;
    }

    public abstract void a();

    public abstract void a(InterfaceC5999a interfaceC5999a, boolean z);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(int i) {
        return i >= 200 && i < 300;
    }

    public String b() {
        return this.j.clearQuery().build().toString();
    }
}
