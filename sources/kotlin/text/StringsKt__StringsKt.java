package kotlin.text;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.taobao.weex.common.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.C8207h;
import kotlin.collections.C8212k;
import kotlin.collections.C8213l;
import kotlin.collections.C8215n;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.SocketClient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ai;
import tb.b41;
import tb.hq2;
import tb.i31;
import tb.l31;
import tb.n31;
import tb.ty1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class StringsKt__StringsKt extends C8604o {

    /* compiled from: Taobao */
    /* renamed from: kotlin.text.StringsKt__StringsKt$a */
    /* loaded from: classes3.dex */
    public static final class C8588a extends ai {
        private int a;
        final /* synthetic */ CharSequence b;

        C8588a(CharSequence charSequence) {
            this.b = charSequence;
        }

        @Override // tb.ai
        public char a() {
            CharSequence charSequence = this.b;
            int i = this.a;
            this.a = i + 1;
            return charSequence.charAt(i);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a < this.b.length();
        }
    }

    @NotNull
    public static final String A0(@NotNull CharSequence charSequence, @NotNull n31 n31Var) {
        b41.i(charSequence, "<this>");
        b41.i(n31Var, "range");
        return charSequence.subSequence(n31Var.getStart().intValue(), n31Var.getEndInclusive().intValue() + 1).toString();
    }

    @NotNull
    public static final String B0(@NotNull String str, char c, @NotNull String str2) {
        int Y;
        b41.i(str, "<this>");
        b41.i(str2, "missingDelimiterValue");
        Y = Y(str, c, 0, false, 6, null);
        if (Y == -1) {
            return str2;
        }
        String substring = str.substring(Y + 1, str.length());
        b41.h(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    @NotNull
    public static String C0(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        int Z;
        b41.i(str, "<this>");
        b41.i(str2, "delimiter");
        b41.i(str3, "missingDelimiterValue");
        Z = Z(str, str2, 0, false, 6, null);
        if (Z == -1) {
            return str3;
        }
        String substring = str.substring(Z + str2.length(), str.length());
        b41.h(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String D0(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return B0(str, c, str2);
    }

    public static /* synthetic */ String E0(String str, String str2, String str3, int i, Object obj) {
        String C0;
        if ((i & 2) != 0) {
            str3 = str;
        }
        C0 = C0(str, str2, str3);
        return C0;
    }

    @NotNull
    public static final String F0(@NotNull String str, char c, @NotNull String str2) {
        b41.i(str, "<this>");
        b41.i(str2, "missingDelimiterValue");
        int e0 = e0(str, c, 0, false, 6, null);
        if (e0 == -1) {
            return str2;
        }
        String substring = str.substring(e0 + 1, str.length());
        b41.h(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String G0(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return F0(str, c, str2);
    }

    public static final boolean H(@NotNull CharSequence charSequence, char c, boolean z) {
        int Y;
        b41.i(charSequence, "<this>");
        Y = Y(charSequence, c, 0, z, 2, null);
        return Y >= 0;
    }

    @NotNull
    public static final String H0(@NotNull String str, char c, @NotNull String str2) {
        int Y;
        b41.i(str, "<this>");
        b41.i(str2, "missingDelimiterValue");
        Y = Y(str, c, 0, false, 6, null);
        if (Y == -1) {
            return str2;
        }
        String substring = str.substring(0, Y);
        b41.h(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final boolean I(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, boolean z) {
        int Z;
        b41.i(charSequence, "<this>");
        b41.i(charSequence2, "other");
        if (charSequence2 instanceof String) {
            Z = Z(charSequence, (String) charSequence2, 0, z, 2, null);
            if (Z >= 0) {
                return true;
            }
        } else if (X(charSequence, charSequence2, 0, charSequence.length(), z, false, 16, null) >= 0) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final String I0(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        int Z;
        b41.i(str, "<this>");
        b41.i(str2, "delimiter");
        b41.i(str3, "missingDelimiterValue");
        Z = Z(str, str2, 0, false, 6, null);
        if (Z == -1) {
            return str3;
        }
        String substring = str.substring(0, Z);
        b41.h(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ boolean J(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return H(charSequence, c, z);
    }

    public static /* synthetic */ String J0(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return H0(str, c, str2);
    }

    public static /* synthetic */ boolean K(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return I(charSequence, charSequence2, z);
    }

    public static /* synthetic */ String K0(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return I0(str, str2, str3);
    }

    public static final boolean L(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        boolean q;
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            q = C8604o.q((String) charSequence, (String) charSequence2, true);
            return q;
        } else if (charSequence == charSequence2) {
            return true;
        } else {
            if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
                return false;
            }
            int length = charSequence.length();
            for (int i = 0; i < length; i++) {
                if (!C8591c.d(charSequence.charAt(i), charSequence2.charAt(i), true)) {
                    return false;
                }
            }
            return true;
        }
    }

    @NotNull
    public static String L0(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        int f0;
        b41.i(str, "<this>");
        b41.i(str2, "delimiter");
        b41.i(str3, "missingDelimiterValue");
        f0 = f0(str, str2, 0, false, 6, null);
        if (f0 == -1) {
            return str3;
        }
        String substring = str.substring(0, f0);
        b41.h(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final boolean M(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return b41.d(charSequence, charSequence2);
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static CharSequence M0(@NotNull CharSequence charSequence) {
        boolean c;
        b41.i(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            c = C8590b.c(charSequence.charAt(!z ? i : length));
            if (z) {
                if (!c) {
                    break;
                }
                length--;
            } else if (c) {
                i++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    public static final boolean N(@NotNull CharSequence charSequence, char c, boolean z) {
        int T;
        b41.i(charSequence, "<this>");
        if (charSequence.length() > 0) {
            T = T(charSequence);
            if (C8591c.d(charSequence.charAt(T), c, z)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean O(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, boolean z) {
        boolean p;
        b41.i(charSequence, "<this>");
        b41.i(charSequence2, Constants.Name.SUFFIX);
        if (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            p = C8604o.p((String) charSequence, (String) charSequence2, false, 2, null);
            return p;
        }
        return n0(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), z);
    }

    public static /* synthetic */ boolean P(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return N(charSequence, c, z);
    }

    public static /* synthetic */ boolean Q(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return O(charSequence, charSequence2, z);
    }

    public static final Pair<Integer, String> R(CharSequence charSequence, Collection<String> collection, int i, boolean z, boolean z2) {
        int T;
        int d;
        l31 g;
        Object obj;
        Object obj2;
        int a;
        if (!z && collection.size() == 1) {
            String str = (String) C8212k.p0(collection);
            int Z = !z2 ? Z(charSequence, str, i, false, 4, null) : f0(charSequence, str, i, false, 4, null);
            if (Z < 0) {
                return null;
            }
            return hq2.a(Integer.valueOf(Z), str);
        }
        if (z2) {
            T = T(charSequence);
            d = ty1.d(i, T);
            g = ty1.g(d, 0);
        } else {
            a = ty1.a(i, 0);
            g = new n31(a, charSequence.length());
        }
        if (charSequence instanceof String) {
            int a2 = g.a();
            int b = g.b();
            int c = g.c();
            if ((c > 0 && a2 <= b) || (c < 0 && b <= a2)) {
                while (true) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        obj2 = it.next();
                        String str2 = (String) obj2;
                        if (C8604o.t(str2, 0, (String) charSequence, a2, str2.length(), z)) {
                            break;
                        }
                    }
                    String str3 = (String) obj2;
                    if (str3 == null) {
                        if (a2 == b) {
                            break;
                        }
                        a2 += c;
                    } else {
                        return hq2.a(Integer.valueOf(a2), str3);
                    }
                }
            }
        } else {
            int a3 = g.a();
            int b2 = g.b();
            int c2 = g.c();
            if ((c2 > 0 && a3 <= b2) || (c2 < 0 && b2 <= a3)) {
                while (true) {
                    Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it2.next();
                        String str4 = (String) obj;
                        if (n0(str4, 0, charSequence, a3, str4.length(), z)) {
                            break;
                        }
                    }
                    String str5 = (String) obj;
                    if (str5 == null) {
                        if (a3 == b2) {
                            break;
                        }
                        a3 += c2;
                    } else {
                        return hq2.a(Integer.valueOf(a3), str5);
                    }
                }
            }
        }
        return null;
    }

    @NotNull
    public static n31 S(@NotNull CharSequence charSequence) {
        b41.i(charSequence, "<this>");
        return new n31(0, charSequence.length() - 1);
    }

    public static int T(@NotNull CharSequence charSequence) {
        b41.i(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int U(@NotNull CharSequence charSequence, char c, int i, boolean z) {
        b41.i(charSequence, "<this>");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(c, i);
        }
        return a0(charSequence, new char[]{c}, i, z);
    }

    public static final int V(@NotNull CharSequence charSequence, @NotNull String str, int i, boolean z) {
        b41.i(charSequence, "<this>");
        b41.i(str, "string");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i);
        }
        return X(charSequence, str, i, charSequence.length(), z, false, 16, null);
    }

    private static final int W(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        int T;
        int d;
        int a;
        l31 g;
        int a2;
        int d2;
        if (!z2) {
            a2 = ty1.a(i, 0);
            d2 = ty1.d(i2, charSequence.length());
            g = new n31(a2, d2);
        } else {
            T = T(charSequence);
            d = ty1.d(i, T);
            a = ty1.a(i2, 0);
            g = ty1.g(d, a);
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int a3 = g.a();
            int b = g.b();
            int c = g.c();
            if ((c <= 0 || a3 > b) && (c >= 0 || b > a3)) {
                return -1;
            }
            while (!C8604o.t((String) charSequence2, 0, (String) charSequence, a3, charSequence2.length(), z)) {
                if (a3 == b) {
                    return -1;
                }
                a3 += c;
            }
            return a3;
        }
        int a4 = g.a();
        int b2 = g.b();
        int c2 = g.c();
        if ((c2 <= 0 || a4 > b2) && (c2 >= 0 || b2 > a4)) {
            return -1;
        }
        while (!n0(charSequence2, 0, charSequence, a4, charSequence2.length(), z)) {
            if (a4 == b2) {
                return -1;
            }
            a4 += c2;
        }
        return a4;
    }

    static /* synthetic */ int X(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        return W(charSequence, charSequence2, i, i2, z, (i3 & 16) != 0 ? false : z2);
    }

    public static /* synthetic */ int Y(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return U(charSequence, c, i, z);
    }

    public static /* synthetic */ int Z(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return V(charSequence, str, i, z);
    }

    public static final int a0(@NotNull CharSequence charSequence, @NotNull char[] cArr, int i, boolean z) {
        int a;
        int T;
        boolean z2;
        char K;
        b41.i(charSequence, "<this>");
        b41.i(cArr, "chars");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            K = ArraysKt___ArraysKt.K(cArr);
            return ((String) charSequence).indexOf(K, i);
        }
        a = ty1.a(i, 0);
        T = T(charSequence);
        i31 it = new n31(a, T).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            char charAt = charSequence.charAt(nextInt);
            int length = cArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z2 = false;
                    continue;
                    break;
                } else if (C8591c.d(cArr[i2], charAt, z)) {
                    z2 = true;
                    continue;
                    break;
                } else {
                    i2++;
                }
            }
            if (z2) {
                return nextInt;
            }
        }
        return -1;
    }

    @NotNull
    public static final ai b0(@NotNull CharSequence charSequence) {
        b41.i(charSequence, "<this>");
        return new C8588a(charSequence);
    }

    public static final int c0(@NotNull CharSequence charSequence, char c, int i, boolean z) {
        b41.i(charSequence, "<this>");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(c, i);
        }
        return g0(charSequence, new char[]{c}, i, z);
    }

    public static final int d0(@NotNull CharSequence charSequence, @NotNull String str, int i, boolean z) {
        b41.i(charSequence, "<this>");
        b41.i(str, "string");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(str, i);
        }
        return W(charSequence, str, i, 0, z, true);
    }

    public static /* synthetic */ int e0(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = T(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return c0(charSequence, c, i, z);
    }

    public static /* synthetic */ int f0(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = T(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return d0(charSequence, str, i, z);
    }

    public static final int g0(@NotNull CharSequence charSequence, @NotNull char[] cArr, int i, boolean z) {
        int T;
        int d;
        char K;
        b41.i(charSequence, "<this>");
        b41.i(cArr, "chars");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            K = ArraysKt___ArraysKt.K(cArr);
            return ((String) charSequence).lastIndexOf(K, i);
        }
        T = T(charSequence);
        for (d = ty1.d(i, T); -1 < d; d--) {
            char charAt = charSequence.charAt(d);
            int length = cArr.length;
            boolean z2 = false;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (C8591c.d(cArr[i2], charAt, z)) {
                    z2 = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (z2) {
                return d;
            }
        }
        return -1;
    }

    @NotNull
    public static final Sequence<String> h0(@NotNull CharSequence charSequence) {
        b41.i(charSequence, "<this>");
        return v0(charSequence, new String[]{SocketClient.NETASCII_EOL, StringUtils.LF, StringUtils.CR}, false, 0, 6, null);
    }

    @NotNull
    public static final List<String> i0(@NotNull CharSequence charSequence) {
        List<String> B;
        b41.i(charSequence, "<this>");
        B = SequencesKt___SequencesKt.B(h0(charSequence));
        return B;
    }

    @NotNull
    public static final CharSequence j0(@NotNull CharSequence charSequence, int i, char c) {
        b41.i(charSequence, "<this>");
        if (i >= 0) {
            if (i <= charSequence.length()) {
                return charSequence.subSequence(0, charSequence.length());
            }
            StringBuilder sb = new StringBuilder(i);
            i31 it = new n31(1, i - charSequence.length()).iterator();
            while (it.hasNext()) {
                it.nextInt();
                sb.append(c);
            }
            sb.append(charSequence);
            return sb;
        }
        throw new IllegalArgumentException("Desired length " + i + " is less than zero.");
    }

    @NotNull
    public static String k0(@NotNull String str, int i, char c) {
        b41.i(str, "<this>");
        return j0(str, i, c).toString();
    }

    private static final Sequence<n31> l0(CharSequence charSequence, String[] strArr, int i, final boolean z, int i2) {
        final List d;
        q0(i2);
        d = C8207h.d(strArr);
        return new C8592d(charSequence, i, i2, new Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>>() { // from class: kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence2, Integer num) {
                return invoke(charSequence2, num.intValue());
            }

            @Nullable
            public final Pair<Integer, Integer> invoke(@NotNull CharSequence charSequence2, int i3) {
                Pair R;
                b41.i(charSequence2, "$this$$receiver");
                R = StringsKt__StringsKt.R(charSequence2, d, i3, z, false);
                if (R != null) {
                    return hq2.a(R.getFirst(), Integer.valueOf(((String) R.getSecond()).length()));
                }
                return null;
            }
        });
    }

    static /* synthetic */ Sequence m0(CharSequence charSequence, String[] strArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return l0(charSequence, strArr, i, z, i2);
    }

    public static final boolean n0(@NotNull CharSequence charSequence, int i, @NotNull CharSequence charSequence2, int i2, int i3, boolean z) {
        b41.i(charSequence, "<this>");
        b41.i(charSequence2, "other");
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!C8591c.d(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static String o0(@NotNull String str, @NotNull CharSequence charSequence) {
        b41.i(str, "<this>");
        b41.i(charSequence, Constants.Name.PREFIX);
        if (z0(str, charSequence, false, 2, null)) {
            String substring = str.substring(charSequence.length());
            b41.h(substring, "this as java.lang.String).substring(startIndex)");
            return substring;
        }
        return str;
    }

    @NotNull
    public static final CharSequence p0(@NotNull CharSequence charSequence, int i, int i2, @NotNull CharSequence charSequence2) {
        b41.i(charSequence, "<this>");
        b41.i(charSequence2, "replacement");
        if (i2 >= i) {
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence, 0, i);
            b41.h(sb, "this.append(value, startIndex, endIndex)");
            sb.append(charSequence2);
            sb.append(charSequence, i2, charSequence.length());
            b41.h(sb, "this.append(value, startIndex, endIndex)");
            return sb;
        }
        throw new IndexOutOfBoundsException("End index (" + i2 + ") is less than start index (" + i + ").");
    }

    public static final void q0(int i) {
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i).toString());
    }

    @NotNull
    public static final List<String> r0(@NotNull CharSequence charSequence, @NotNull String[] strArr, boolean z, int i) {
        Iterable<n31> l;
        int q;
        b41.i(charSequence, "<this>");
        b41.i(strArr, "delimiters");
        if (strArr.length == 1) {
            String str = strArr[0];
            if (!(str.length() == 0)) {
                return s0(charSequence, str, z, i);
            }
        }
        l = SequencesKt___SequencesKt.l(m0(charSequence, strArr, 0, z, i, 2, null));
        q = C8215n.q(l, 10);
        ArrayList arrayList = new ArrayList(q);
        for (n31 n31Var : l) {
            arrayList.add(A0(charSequence, n31Var));
        }
        return arrayList;
    }

    private static final List<String> s0(CharSequence charSequence, String str, boolean z, int i) {
        List<String> e;
        q0(i);
        int i2 = 0;
        int V = V(charSequence, str, 0, z);
        if (V != -1 && i != 1) {
            boolean z2 = i > 0;
            ArrayList arrayList = new ArrayList(z2 ? ty1.d(i, 10) : 10);
            do {
                arrayList.add(charSequence.subSequence(i2, V).toString());
                i2 = str.length() + V;
                if (z2 && arrayList.size() == i - 1) {
                    break;
                }
                V = V(charSequence, str, i2, z);
            } while (V != -1);
            arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
            return arrayList;
        }
        e = C8213l.e(charSequence.toString());
        return e;
    }

    public static /* synthetic */ List t0(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return r0(charSequence, strArr, z, i);
    }

    @NotNull
    public static final Sequence<String> u0(@NotNull final CharSequence charSequence, @NotNull String[] strArr, boolean z, int i) {
        Sequence<String> v;
        b41.i(charSequence, "<this>");
        b41.i(strArr, "delimiters");
        v = SequencesKt___SequencesKt.v(m0(charSequence, strArr, 0, z, i, 2, null), new Function1<n31, String>() { // from class: kotlin.text.StringsKt__StringsKt$splitToSequence$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final String invoke(@NotNull n31 n31Var) {
                b41.i(n31Var, AdvanceSetting.NETWORK_TYPE);
                return StringsKt__StringsKt.A0(charSequence, n31Var);
            }
        });
        return v;
    }

    public static /* synthetic */ Sequence v0(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return u0(charSequence, strArr, z, i);
    }

    public static final boolean w0(@NotNull CharSequence charSequence, char c, boolean z) {
        b41.i(charSequence, "<this>");
        return charSequence.length() > 0 && C8591c.d(charSequence.charAt(0), c, z);
    }

    public static final boolean x0(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, boolean z) {
        boolean F;
        b41.i(charSequence, "<this>");
        b41.i(charSequence2, Constants.Name.PREFIX);
        if (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            F = C8604o.F((String) charSequence, (String) charSequence2, false, 2, null);
            return F;
        }
        return n0(charSequence, 0, charSequence2, 0, charSequence2.length(), z);
    }

    public static /* synthetic */ boolean y0(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return w0(charSequence, c, z);
    }

    public static /* synthetic */ boolean z0(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return x0(charSequence, charSequence2, z);
    }
}
