package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.util.Arrays;
import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.du1;

/* compiled from: Taobao */
@GwtCompatible
/* loaded from: classes10.dex */
public final class e {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class b {
        private final String a;
        private final a b;
        private a c;
        private boolean d;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public static final class a {
            @NullableDecl
            String a;
            @NullableDecl
            Object b;
            @NullableDecl
            a c;

            private a() {
            }
        }

        private a e() {
            a aVar = new a();
            this.c.c = aVar;
            this.c = aVar;
            return aVar;
        }

        private b f(@NullableDecl Object obj) {
            e().b = obj;
            return this;
        }

        private b g(String str, @NullableDecl Object obj) {
            a e = e();
            e.b = obj;
            e.a = (String) du1.p(str);
            return this;
        }

        @CanIgnoreReturnValue
        public b a(String str, double d) {
            return g(str, String.valueOf(d));
        }

        @CanIgnoreReturnValue
        public b b(String str, int i) {
            return g(str, String.valueOf(i));
        }

        @CanIgnoreReturnValue
        public b c(String str, long j) {
            return g(str, String.valueOf(j));
        }

        @CanIgnoreReturnValue
        public b d(String str, @NullableDecl Object obj) {
            return g(str, obj);
        }

        @CanIgnoreReturnValue
        public b h(@NullableDecl Object obj) {
            return f(obj);
        }

        public String toString() {
            boolean z = this.d;
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.a);
            sb.append('{');
            String str = "";
            for (a aVar = this.b.c; aVar != null; aVar = aVar.c) {
                Object obj = aVar.b;
                if (!z || obj != null) {
                    sb.append(str);
                    String str2 = aVar.a;
                    if (str2 != null) {
                        sb.append(str2);
                        sb.append(com.alipay.sdk.m.n.a.h);
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

        private b(String str) {
            a aVar = new a();
            this.b = aVar;
            this.c = aVar;
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

    public static b b(Object obj) {
        return new b(obj.getClass().getSimpleName());
    }
}
