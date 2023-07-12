package com.youku.network;

import com.youku.httpcommunication.C7924a;
import com.youku.network.b.C7983b;
import com.youku.network.b.InterfaceC7982a;
import com.youku.network.call.C7987a;
import com.youku.network.call.C7988b;
import com.youku.network.call.C7993g;
import com.youku.network.call.C7997k;
import com.youku.network.call.C7999m;
import com.youku.network.config.YKNetworkConfig;
import com.youku.network.d.C8005a;
import mtopsdk.mtop.domain.MethodEnum;

/* compiled from: Taobao */
/* renamed from: com.youku.network.b */
/* loaded from: classes13.dex */
public class C7980b {
    public static volatile boolean a = true;
    private static Object b = new Object();
    private C7984c c;
    private C7988b d;
    private InterfaceC7982a e = new C7983b();

    /* compiled from: Taobao */
    /* renamed from: com.youku.network.b$1  reason: invalid class name */
    /* loaded from: classes13.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[YKNetworkConfig.CallType.values().length];
            a = iArr;
            try {
                iArr[YKNetworkConfig.CallType.NETWORKSDK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[YKNetworkConfig.CallType.OKHTTP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[YKNetworkConfig.CallType.MTOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.youku.network.b$a */
    /* loaded from: classes13.dex */
    public static class C7981a {
        private C7984c a = C7984c.a();
        private YKNetworkConfig.CallType b = null;

        public C7981a a(int i) {
            this.a.a(i);
            return this;
        }

        public C7981a a(YKNetworkConfig.CallType callType) {
            this.b = callType;
            return this;
        }

        public C7981a a(String str) {
            this.a.a(str);
            return this;
        }

        public C7981a a(String str, String str2) {
            this.a.a(str, str2);
            return this;
        }

        public C7981a a(MethodEnum methodEnum) {
            this.a.a(methodEnum);
            return this;
        }

        public C7981a a(boolean z) {
            this.a.a(z);
            return this;
        }

        public C7980b a() {
            C7987a c7997k;
            C7980b c7980b = new C7980b();
            c7980b.a(this.a);
            if (this.b == null) {
                this.b = YKNetworkConfig.a(this.a.e());
                this.b = C8005a.a(this.a.b(), this.b);
            }
            C7924a.a("YKNetwork", "callType---" + this.b + "--url--:" + this.a.e());
            int i = AnonymousClass1.a[this.b.ordinal()];
            if (i == 1) {
                c7997k = new C7997k();
            } else if (i != 2) {
                if (i == 3) {
                    c7997k = new C7993g();
                }
                c7980b.c();
                return c7980b;
            } else {
                c7997k = new C7999m();
            }
            c7980b.a(c7997k);
            c7980b.c();
            return c7980b;
        }

        public C7981a b(int i) {
            this.a.b(i);
            return this;
        }

        public C7981a b(String str) {
            this.a.d(str);
            return this;
        }

        public C7981a b(String str, String str2) {
            this.a.b(str, str2);
            return this;
        }

        public C7981a b(boolean z) {
            this.a.b(z);
            return this;
        }

        public C7981a c(int i) {
            this.a.d(i);
            return this;
        }

        public C7981a c(String str) {
            this.a.b(str);
            return this;
        }

        public C7981a d(int i) {
            this.a.e(i);
            return this;
        }

        public C7981a d(String str) {
            this.a.c(str);
            return this;
        }

        public C7981a e(int i) {
            this.a.c(i);
            return this;
        }

        public C7981a e(String str) {
            this.a.e(str);
            return this;
        }

        public C7981a f(String str) {
            this.a.f(str);
            return this;
        }

        public C7981a g(String str) {
            this.a.g(str);
            return this;
        }

        public C7981a h(String str) {
            this.a.h(str);
            return this;
        }

        public C7981a i(String str) {
            this.a.i(str);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.e.a(this.c);
        this.d.a(this.c);
    }

    public void a() {
    }

    public void a(C7984c c7984c) {
        this.c = c7984c;
    }

    public void a(C7987a c7987a) {
        this.d = new C7988b(c7987a);
    }

    public C8004d b() {
        a();
        return this.d.a();
    }
}
