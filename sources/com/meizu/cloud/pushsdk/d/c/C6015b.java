package com.meizu.cloud.pushsdk.d.c;

import com.alimm.xadsdk.request.builder.IRequestConst;
import com.meizu.cloud.pushsdk.d.a.C6001c;
import com.meizu.cloud.pushsdk.d.c.C6013a;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import com.meizu.cloud.pushsdk.notification.model.BrightRemindSetting;
import mtopsdk.xstate.util.XStateConstants;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.d.c.b */
/* loaded from: classes10.dex */
public class C6015b extends C6013a {
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final int i;

    /* compiled from: Taobao */
    /* renamed from: com.meizu.cloud.pushsdk.d.c.b$a */
    /* loaded from: classes10.dex */
    public static abstract class AbstractC6016a<T extends AbstractC6016a<T>> extends C6013a.AbstractC6014a<T> {
        private String a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;
        private String h;
        private int i = 0;

        public T a(int i) {
            this.i = i;
            return (T) a();
        }

        public T a(String str) {
            this.a = str;
            return (T) a();
        }

        public T b(String str) {
            this.b = str;
            return (T) a();
        }

        public C6015b b() {
            return new C6015b(this);
        }

        public T c(String str) {
            this.c = str;
            return (T) a();
        }

        public T d(String str) {
            this.d = str;
            return (T) a();
        }

        public T e(String str) {
            this.e = str;
            return (T) a();
        }

        public T f(String str) {
            this.f = str;
            return (T) a();
        }

        public T g(String str) {
            this.g = str;
            return (T) a();
        }

        public T h(String str) {
            this.h = str;
            return (T) a();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.meizu.cloud.pushsdk.d.c.b$b */
    /* loaded from: classes10.dex */
    private static class C6017b extends AbstractC6016a<C6017b> {
        private C6017b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.meizu.cloud.pushsdk.d.c.C6013a.AbstractC6014a
        /* renamed from: c */
        public C6017b a() {
            return this;
        }
    }

    protected C6015b(AbstractC6016a<?> abstractC6016a) {
        super(abstractC6016a);
        this.b = ((AbstractC6016a) abstractC6016a).b;
        this.c = ((AbstractC6016a) abstractC6016a).c;
        this.a = ((AbstractC6016a) abstractC6016a).a;
        this.d = ((AbstractC6016a) abstractC6016a).d;
        this.e = ((AbstractC6016a) abstractC6016a).e;
        this.f = ((AbstractC6016a) abstractC6016a).f;
        this.g = ((AbstractC6016a) abstractC6016a).g;
        this.h = ((AbstractC6016a) abstractC6016a).h;
        this.i = ((AbstractC6016a) abstractC6016a).i;
    }

    public static AbstractC6016a<?> d() {
        return new C6017b();
    }

    public C6001c e() {
        C6001c c6001c = new C6001c();
        c6001c.a("en", this.a);
        c6001c.a(IRequestConst.TI, this.b);
        c6001c.a(AppIconSetting.DEFAULT_LARGE_ICON, this.c);
        c6001c.a(XStateConstants.KEY_PV, this.d);
        c6001c.a(IRequestConst.PN, this.e);
        c6001c.a("si", this.f);
        c6001c.a("ms", this.g);
        c6001c.a("ect", this.h);
        c6001c.a(BrightRemindSetting.BRIGHT_REMIND, Integer.valueOf(this.i));
        return a(c6001c);
    }
}
