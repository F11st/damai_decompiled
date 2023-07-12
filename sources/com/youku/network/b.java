package com.youku.network;

import com.youku.network.call.g;
import com.youku.network.call.k;
import com.youku.network.call.m;
import com.youku.network.config.YKNetworkConfig;
import mtopsdk.mtop.domain.MethodEnum;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class b {
    public static volatile boolean a = true;
    private static Object b = new Object();
    private c c;
    private com.youku.network.call.b d;
    private com.youku.network.b.a e = new com.youku.network.b.b();

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
    /* loaded from: classes13.dex */
    public static class a {
        private c a = c.a();
        private YKNetworkConfig.CallType b = null;

        public a a(int i) {
            this.a.a(i);
            return this;
        }

        public a a(YKNetworkConfig.CallType callType) {
            this.b = callType;
            return this;
        }

        public a a(String str) {
            this.a.a(str);
            return this;
        }

        public a a(String str, String str2) {
            this.a.a(str, str2);
            return this;
        }

        public a a(MethodEnum methodEnum) {
            this.a.a(methodEnum);
            return this;
        }

        public a a(boolean z) {
            this.a.a(z);
            return this;
        }

        public b a() {
            com.youku.network.call.a kVar;
            b bVar = new b();
            bVar.a(this.a);
            if (this.b == null) {
                this.b = YKNetworkConfig.a(this.a.e());
                this.b = com.youku.network.d.a.a(this.a.b(), this.b);
            }
            com.youku.httpcommunication.a.a("YKNetwork", "callType---" + this.b + "--url--:" + this.a.e());
            int i = AnonymousClass1.a[this.b.ordinal()];
            if (i == 1) {
                kVar = new k();
            } else if (i != 2) {
                if (i == 3) {
                    kVar = new g();
                }
                bVar.c();
                return bVar;
            } else {
                kVar = new m();
            }
            bVar.a(kVar);
            bVar.c();
            return bVar;
        }

        public a b(int i) {
            this.a.b(i);
            return this;
        }

        public a b(String str) {
            this.a.d(str);
            return this;
        }

        public a b(String str, String str2) {
            this.a.b(str, str2);
            return this;
        }

        public a b(boolean z) {
            this.a.b(z);
            return this;
        }

        public a c(int i) {
            this.a.d(i);
            return this;
        }

        public a c(String str) {
            this.a.b(str);
            return this;
        }

        public a d(int i) {
            this.a.e(i);
            return this;
        }

        public a d(String str) {
            this.a.c(str);
            return this;
        }

        public a e(int i) {
            this.a.c(i);
            return this;
        }

        public a e(String str) {
            this.a.e(str);
            return this;
        }

        public a f(String str) {
            this.a.f(str);
            return this;
        }

        public a g(String str) {
            this.a.g(str);
            return this;
        }

        public a h(String str) {
            this.a.h(str);
            return this;
        }

        public a i(String str) {
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

    public void a(c cVar) {
        this.c = cVar;
    }

    public void a(com.youku.network.call.a aVar) {
        this.d = new com.youku.network.call.b(aVar);
    }

    public d b() {
        a();
        return this.d.a();
    }
}
