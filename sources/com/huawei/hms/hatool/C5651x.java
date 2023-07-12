package com.huawei.hms.hatool;

import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.hatool.x */
/* loaded from: classes10.dex */
public class C5651x {
    public static C5651x b = new C5651x();
    public C5652a a = new C5652a();

    /* compiled from: Taobao */
    /* renamed from: com.huawei.hms.hatool.x$a */
    /* loaded from: classes10.dex */
    public class C5652a {
        public String a;
        public String b;
        public long c = 0;

        public C5652a() {
        }

        public void a(long j) {
            C5651x.this.a.c = j;
        }

        public void a(String str) {
            C5651x.this.a.b = str;
        }

        public void b(String str) {
            C5651x.this.a.a = str;
        }
    }

    public static C5651x d() {
        return b;
    }

    public String a() {
        return this.a.b;
    }

    public void a(String str, String str2) {
        long b2 = b();
        String b3 = C5645r0.b(str, str2);
        if (b3 == null || b3.isEmpty()) {
            C5653y.e("WorkKeyHandler", "get rsa pubkey config error");
            return;
        }
        if (b2 == 0) {
            b2 = System.currentTimeMillis();
        } else if (System.currentTimeMillis() - b2 <= 43200000) {
            return;
        }
        String generateSecureRandomStr = EncryptUtil.generateSecureRandomStr(16);
        String a = C5614e.a(b3, generateSecureRandomStr);
        this.a.a(b2);
        this.a.b(generateSecureRandomStr);
        this.a.a(a);
    }

    public long b() {
        return this.a.c;
    }

    public String c() {
        return this.a.a;
    }
}
