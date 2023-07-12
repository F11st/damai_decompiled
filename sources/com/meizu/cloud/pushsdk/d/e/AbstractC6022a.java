package com.meizu.cloud.pushsdk.d.e;

import android.content.Context;
import com.meizu.cloud.pushsdk.PushManager;
import com.meizu.cloud.pushsdk.d.a.C6000b;
import com.meizu.cloud.pushsdk.d.a.C6001c;
import com.meizu.cloud.pushsdk.d.b.AbstractC6002a;
import com.meizu.cloud.pushsdk.d.c.C6015b;
import com.meizu.cloud.pushsdk.d.f.C6030c;
import com.meizu.cloud.pushsdk.d.f.EnumC6029b;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.d.e.a */
/* loaded from: classes10.dex */
public abstract class AbstractC6022a {
    private static final String n = "a";
    protected AbstractC6002a b;
    protected C6026c c;
    protected C6025b d;
    protected final String e;
    protected final String f;
    protected final boolean g;
    protected final EnumC6029b h;
    protected final boolean i;
    protected final long j;
    protected final int k;
    protected final TimeUnit l;
    protected final String a = PushManager.TAG;
    protected final AtomicBoolean m = new AtomicBoolean(true);

    /* compiled from: Taobao */
    /* renamed from: com.meizu.cloud.pushsdk.d.e.a$a */
    /* loaded from: classes10.dex */
    public static class C6023a {
        protected final AbstractC6002a a;
        protected final String b;
        protected final String c;
        protected final Context d;
        protected C6026c e = null;
        protected boolean f = false;
        protected EnumC6029b g = EnumC6029b.OFF;
        protected boolean h = false;
        protected long i = 600;
        protected long j = 300;
        protected long k = 15;
        protected int l = 10;
        protected TimeUnit m = TimeUnit.SECONDS;

        public C6023a(AbstractC6002a abstractC6002a, String str, String str2, Context context, Class<? extends AbstractC6022a> cls) {
            this.a = abstractC6002a;
            this.b = str;
            this.c = str2;
            this.d = context;
        }

        public C6023a a(int i) {
            this.l = i;
            return this;
        }

        public C6023a a(C6026c c6026c) {
            this.e = c6026c;
            return this;
        }

        public C6023a a(EnumC6029b enumC6029b) {
            this.g = enumC6029b;
            return this;
        }

        public C6023a a(Boolean bool) {
            this.f = bool.booleanValue();
            return this;
        }
    }

    public AbstractC6022a(C6023a c6023a) {
        this.b = c6023a.a;
        this.f = c6023a.c;
        this.g = c6023a.f;
        this.e = c6023a.b;
        this.c = c6023a.e;
        this.h = c6023a.g;
        boolean z = c6023a.h;
        this.i = z;
        this.j = c6023a.k;
        int i = c6023a.l;
        this.k = i < 2 ? 2 : i;
        this.l = c6023a.m;
        if (z) {
            this.d = new C6025b(c6023a.i, c6023a.j, c6023a.m, c6023a.d);
        }
        C6030c.a(c6023a.g);
        C6030c.c(n, "Tracker created successfully.", new Object[0]);
    }

    private C6000b a(List<C6000b> list) {
        if (this.i) {
            list.add(this.d.a());
        }
        C6026c c6026c = this.c;
        if (c6026c != null) {
            if (!c6026c.a().isEmpty()) {
                list.add(new C6000b("geolocation", this.c.a()));
            }
            if (!this.c.b().isEmpty()) {
                list.add(new C6000b("mobileinfo", this.c.b()));
            }
        }
        LinkedList linkedList = new LinkedList();
        for (C6000b c6000b : list) {
            linkedList.add(c6000b.a());
        }
        return new C6000b("push_extra_info", linkedList);
    }

    private void a(C6001c c6001c, List<C6000b> list, boolean z) {
        if (this.c != null) {
            c6001c.a(new HashMap(this.c.c()));
            c6001c.a("et", a(list).a());
        }
        C6030c.c(n, "Adding new payload to event storage: %s", c6001c);
        this.b.a(c6001c, z);
    }

    public void a() {
        if (this.m.get()) {
            b().a();
        }
    }

    public void a(C6015b c6015b, boolean z) {
        if (this.m.get()) {
            a(c6015b.e(), c6015b.a(), z);
        }
    }

    public void a(C6026c c6026c) {
        this.c = c6026c;
    }

    public AbstractC6002a b() {
        return this.b;
    }
}
