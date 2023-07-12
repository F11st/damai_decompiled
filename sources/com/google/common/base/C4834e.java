package com.google.common.base;

import com.alipay.sdk.m.n.C4250a;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.util.Arrays;
import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.du1;

/* compiled from: Taobao */
@GwtCompatible
/* renamed from: com.google.common.base.e */
/* loaded from: classes10.dex */
public final class C4834e {

    /* compiled from: Taobao */
    /* renamed from: com.google.common.base.e$b */
    /* loaded from: classes10.dex */
    public static final class C4836b {
        private final String a;
        private final C4837a b;
        private C4837a c;
        private boolean d;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: Taobao */
        /* renamed from: com.google.common.base.e$b$a */
        /* loaded from: classes10.dex */
        public static final class C4837a {
            @NullableDecl
            String a;
            @NullableDecl
            Object b;
            @NullableDecl
            C4837a c;

            private C4837a() {
            }
        }

        private C4837a e() {
            C4837a c4837a = new C4837a();
            this.c.c = c4837a;
            this.c = c4837a;
            return c4837a;
        }

        private C4836b f(@NullableDecl Object obj) {
            e().b = obj;
            return this;
        }

        private C4836b g(String str, @NullableDecl Object obj) {
            C4837a e = e();
            e.b = obj;
            e.a = (String) du1.p(str);
            return this;
        }

        @CanIgnoreReturnValue
        public C4836b a(String str, double d) {
            return g(str, String.valueOf(d));
        }

        @CanIgnoreReturnValue
        public C4836b b(String str, int i) {
            return g(str, String.valueOf(i));
        }

        @CanIgnoreReturnValue
        public C4836b c(String str, long j) {
            return g(str, String.valueOf(j));
        }

        @CanIgnoreReturnValue
        public C4836b d(String str, @NullableDecl Object obj) {
            return g(str, obj);
        }

        @CanIgnoreReturnValue
        public C4836b h(@NullableDecl Object obj) {
            return f(obj);
        }

        public String toString() {
            boolean z = this.d;
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.a);
            sb.append('{');
            String str = "";
            for (C4837a c4837a = this.b.c; c4837a != null; c4837a = c4837a.c) {
                Object obj = c4837a.b;
                if (!z || obj != null) {
                    sb.append(str);
                    String str2 = c4837a.a;
                    if (str2 != null) {
                        sb.append(str2);
                        sb.append(C4250a.h);
                    }
                    if (obj != null && obj.getClass().isArray()) {
                        String deepToString = Arrays.deepToString(new Object[]{obj});
                        sb.append((CharSequence) deepToString, 1, deepToString.length() - 1);
                    } else {
                        sb.append(obj);
                    }
                    str = AVFSCacheConstants.COMMA_SEP;
                }
            }
            sb.append('}');
            return sb.toString();
        }

        private C4836b(String str) {
            C4837a c4837a = new C4837a();
            this.b = c4837a;
            this.c = c4837a;
            this.d = false;
            this.a = (String) du1.p(str);
        }
    }

    public static <T> T a(@NullableDecl T t, @NullableDecl T t2) {
        if (t != null) {
            return t;
        }
        Objects.requireNonNull(t2, "Both parameters are null");
        return t2;
    }

    public static C4836b b(Object obj) {
        return new C4836b(obj.getClass().getSimpleName());
    }
}
