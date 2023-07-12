package com.google.common.math;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.math.RoundingMode;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.jn1;

/* compiled from: Taobao */
@CanIgnoreReturnValue
@GwtCompatible
/* loaded from: classes10.dex */
final class e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(boolean z, double d, RoundingMode roundingMode) {
        if (z) {
            return;
        }
        throw new ArithmeticException("rounded value is out of range for input " + d + " and rounding mode " + roundingMode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(boolean z, String str, int i, int i2) {
        if (z) {
            return;
        }
        throw new ArithmeticException("overflow: " + str + jn1.BRACKET_START_STR + i + AVFSCacheConstants.COMMA_SEP + i2 + jn1.BRACKET_END_STR);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(@NullableDecl String str, int i) {
        if (i > 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " (" + i + ") must be > 0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(boolean z) {
        if (!z) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }
}
