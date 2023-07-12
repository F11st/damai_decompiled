package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.util.Locale;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.du1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
@GwtCompatible(emulated = true)
/* loaded from: classes10.dex */
public final class f {
    private static final PatternCompiler a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class b implements PatternCompiler {
        private b() {
        }

        @Override // com.google.common.base.PatternCompiler
        public com.google.common.base.b compile(String str) {
            return new JdkPattern(Pattern.compile(str));
        }

        @Override // com.google.common.base.PatternCompiler
        public boolean isPcreLike() {
            return true;
        }
    }

    static {
        Logger.getLogger(f.class.getName());
        a = c();
    }

    private f() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.google.common.base.b a(String str) {
        du1.p(str);
        return a.compile(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(double d) {
        return String.format(Locale.ROOT, "%.4g", Double.valueOf(d));
    }

    private static PatternCompiler c() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d() {
        return a.isPcreLike();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e(@NullableDecl String str) {
        return str == null || str.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long f() {
        return System.nanoTime();
    }
}
