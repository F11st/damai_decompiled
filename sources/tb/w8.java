package tb;

import android.text.TextUtils;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Hashtable;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.text.C8590b;
import kotlin.text.C8604o;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class w8 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int COLOR_NONE = 1;
    @NotNull
    public static final String DAMAI_HEIGHT = "damai_height";
    @NotNull
    public static final String DAMAI_WIDTH = "damai_width";
    @NotNull
    public static final w8 INSTANCE = new w8();
    @Nullable
    private static Hashtable<String, Integer> a;

    static {
        Hashtable<String, Integer> hashtable = new Hashtable<>();
        a = hashtable;
        hashtable.put("aqua", -16711681);
        hashtable.put("black", -16777216);
        hashtable.put("blue", -16776961);
        hashtable.put("darkgrey", -5658199);
        hashtable.put("fuchsia", -65281);
        hashtable.put("gray", -8355712);
        hashtable.put("grey", -8355712);
        hashtable.put("green", -16744448);
        hashtable.put("lightblue", -5383962);
        hashtable.put("lightgrey", -2894893);
        hashtable.put("lime", -16711936);
        hashtable.put("maroon", -8388608);
        hashtable.put("navy", -16777088);
        hashtable.put("olive", -8355840);
        hashtable.put("orange", -23296);
        hashtable.put("purple", -8388480);
        hashtable.put("red", Integer.valueOf((int) SupportMenu.CATEGORY_MASK));
        hashtable.put("silver", -4144960);
        hashtable.put("teal", -16744320);
        hashtable.put("white", -1);
        hashtable.put("yellow", Integer.valueOf((int) InputDeviceCompat.SOURCE_ANY));
        hashtable.put("sienna", -6270419);
        hashtable.put("darkolivegreen", -11179217);
        hashtable.put("darkgreen", -16751616);
        hashtable.put("darkslateblue", -12042869);
        hashtable.put("indigo", -11861886);
        hashtable.put("darkslategray", -13676721);
        hashtable.put("darkred", -7667712);
        hashtable.put("darkorange", -29696);
        hashtable.put("slategray", -9404272);
        hashtable.put("dimgray", -9868951);
        hashtable.put("sandybrown", -744352);
        hashtable.put("yellowgreen", -5374161);
        hashtable.put("seagreen", -13726889);
        hashtable.put("mediumturquoise", -12004916);
        hashtable.put("royalblue", -12490271);
        hashtable.put("magenta", -65281);
        hashtable.put("cyan", -16711681);
        hashtable.put("deepskyblue", -16728065);
        hashtable.put("darkorchid", -6737204);
        hashtable.put("pink", -16181);
        hashtable.put("wheat", -663885);
        hashtable.put("lemonchiffon", -1331);
        hashtable.put("palegreen", -6751336);
        hashtable.put("paleturquoise", -5247250);
        hashtable.put("plum", -2252579);
    }

    private w8() {
    }

    private final int a(boolean z, String str, int i) {
        int j;
        boolean E;
        boolean E2;
        boolean E3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1688209098")) {
            return ((Integer) ipChange.ipc$dispatch("1688209098", new Object[]{this, Boolean.valueOf(z), str, Integer.valueOf(i)})).intValue();
        }
        if (z) {
            j = j(str, i, "text-align", 15);
        } else {
            j = j(str, i, "align", 10);
        }
        if (j > 0) {
            while (true) {
                b41.f(str);
                if (j >= str.length() || (b41.k(str.charAt(j), 97) >= 0 && b41.k(str.charAt(j), 122) <= 0)) {
                    break;
                }
                j++;
            }
            E = C8604o.E(str, "right", j, false, 4, null);
            if (E) {
                return 2;
            }
            E2 = C8604o.E(str, "center", j, false, 4, null);
            if (E2) {
                return 1;
            }
            E3 = C8604o.E(str, "left", j, false, 4, null);
            return E3 ? 0 : -1;
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0041, code lost:
        r2 = kotlin.text.StringsKt__StringsKt.Z(r10, "=", r2, false, 4, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004e, code lost:
        r0 = kotlin.text.StringsKt__StringsKt.Z(r10, "\"", r2, false, 4, null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String b(java.lang.String r10, int r11, java.lang.String r12) {
        /*
            r9 = this;
            com.android.alibaba.ip.runtime.IpChange r2 = tb.w8.$ipChange
            java.lang.String r3 = "1660403506"
            boolean r4 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r2, r3)
            r6 = 2
            r5 = 4
            r7 = 1
            if (r4 == 0) goto L24
            java.lang.Object[] r4 = new java.lang.Object[r5]
            r5 = 0
            r4[r5] = r9
            r4[r7] = r10
            java.lang.Integer r0 = java.lang.Integer.valueOf(r11)
            r4[r6] = r0
            r0 = 3
            r4[r0] = r12
            java.lang.Object r0 = r2.ipc$dispatch(r3, r4)
            java.lang.String r0 = (java.lang.String) r0
            return r0
        L24:
            tb.b41.f(r10)
            int r2 = r10.length()
            int r2 = r2 - r11
            int r2 = r2 - r5
            int r3 = r12.length()
            r8 = 0
            if (r2 >= r3) goto L35
            return r8
        L35:
            int r2 = r12.length()
            int r2 = r2 + r5
            int r2 = r9.j(r10, r11, r12, r2)
            if (r2 >= 0) goto L41
            return r8
        L41:
            r3 = 0
            r4 = 4
            r5 = 0
            java.lang.String r1 = "="
            r0 = r10
            int r2 = kotlin.text.C8596g.Z(r0, r1, r2, r3, r4, r5)
            if (r2 >= 0) goto L4e
            return r8
        L4e:
            r3 = 0
            r4 = 4
            r5 = 0
            java.lang.String r1 = "\""
            r0 = r10
            int r0 = kotlin.text.C8596g.Z(r0, r1, r2, r3, r4, r5)
            if (r0 >= 0) goto L5b
            return r8
        L5b:
            int r0 = r0 + r7
            int r1 = r10.length()
            int r1 = r1 - r6
            if (r0 <= r1) goto L64
            return r8
        L64:
            int r1 = r10.length()
            int r1 = r1 - r6
            r2 = 10
            r3 = 32
            if (r0 >= r1) goto L7e
            char r1 = r10.charAt(r0)
            if (r1 == r3) goto L7b
            char r1 = r10.charAt(r0)
            if (r1 != r2) goto L7e
        L7b:
            int r0 = r0 + 1
            goto L64
        L7e:
            int r1 = r0 + 1
        L80:
            int r4 = r10.length()
            int r4 = r4 - r7
            if (r1 >= r4) goto L9e
            char r4 = r10.charAt(r1)
            r5 = 34
            if (r4 == r5) goto L9e
            char r4 = r10.charAt(r1)
            if (r4 == r3) goto L9e
            char r4 = r10.charAt(r1)
            if (r4 == r2) goto L9e
            int r1 = r1 + 1
            goto L80
        L9e:
            int r2 = r10.length()
            int r2 = r2 - r7
            if (r1 > r2) goto Lae
            java.lang.String r8 = r10.substring(r0, r1)
            java.lang.String r0 = "this as java.lang.String…ing(startIndex, endIndex)"
            tb.b41.h(r8, r0)
        Lae:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.w8.b(java.lang.String, int, java.lang.String):java.lang.String");
    }

    private final int c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-986687341")) {
            return ((Integer) ipChange.ipc$dispatch("-986687341", new Object[]{this, str})).intValue();
        }
        String replaceAll = Pattern.compile("[^0-9]").matcher(str).replaceAll("");
        try {
            b41.h(replaceAll, "result");
            return Integer.parseInt(replaceAll);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private final int d(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1169044823")) {
            return ((Integer) ipChange.ipc$dispatch("-1169044823", new Object[]{this, str, Integer.valueOf(i)})).intValue();
        }
        String b = b(str, i, "size");
        if (b != null && TextUtils.isDigitsOnly(b)) {
            return Integer.parseInt(b);
        }
        return -1;
    }

    private final int e(int i, int i2, String str) {
        int a2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "433699836")) {
            return ((Integer) ipChange.ipc$dispatch("433699836", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), str})).intValue();
        }
        int i3 = i2 - i;
        if (i3 < 3) {
            return 1;
        }
        b41.f(str);
        if (str.charAt(i) == '#') {
            if (i3 == 9) {
                i += 2;
            }
            if (i2 - i == 7) {
                String substring = str.substring(i + 1, i2);
                b41.h(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                a2 = C8590b.a(16);
                return Integer.parseInt(substring, a2) | (-16777216);
            }
            return 1;
        }
        Hashtable<String, Integer> hashtable = a;
        b41.f(hashtable);
        String substring2 = str.substring(i, i2);
        b41.h(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
        Locale locale = Locale.US;
        b41.h(locale, "US");
        String lowerCase = substring2.toLowerCase(locale);
        b41.h(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        Integer num = hashtable.get(lowerCase);
        if (num != null) {
            return num.intValue();
        }
        return 1;
    }

    private final int f(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "899299914")) {
            return ((Integer) ipChange.ipc$dispatch("899299914", new Object[]{this, str})).intValue();
        }
        return -1;
    }

    private final int g(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2095476499")) {
            return ((Integer) ipChange.ipc$dispatch("-2095476499", new Object[]{this, str})).intValue();
        }
        return -1;
    }

    private final int i(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-747560469")) {
            return ((Integer) ipChange.ipc$dispatch("-747560469", new Object[]{this, str, Integer.valueOf(i)})).intValue();
        }
        int j = j(str, i, "color", 10);
        if (j < 0) {
            return 1;
        }
        if (j > i + 5) {
            b41.f(str);
            int i2 = j - 6;
            if (str.charAt(i2) == '-' || str.charAt(i2) == 'g') {
                return 1;
            }
        }
        while (true) {
            b41.f(str);
            if (j >= str.length() - 3) {
                return 1;
            }
            if (str.charAt(j) == '=') {
                while (j < str.length() - 3 && str.charAt(j) != '\"') {
                    j++;
                }
                if (str.charAt(j) == '\"') {
                    int i3 = j + 1;
                    int i4 = i3;
                    while (i4 < str.length() && str.charAt(i4) != '\"' && str.charAt(i4) != ' ' && str.charAt(i4) != '\n') {
                        i4++;
                    }
                    return e(i3, i4, str);
                }
                return -1;
            } else if (str.charAt(j) == ':') {
                int i5 = j + 1;
                while (i5 < str.length() - 3 && (str.charAt(i5) == ' ' || str.charAt(i5) == '\n')) {
                    i5++;
                }
                int i6 = i5 + 1;
                while (i6 < str.length() && str.charAt(i6) != ';' && str.charAt(i6) != ' ' && str.charAt(i6) != '\n' && str.charAt(i6) != '\"') {
                    i6++;
                }
                return e(i5, i6, str);
            } else if (str.charAt(j) == '\"') {
                return 1;
            } else {
                j++;
            }
        }
    }

    private final int j(String str, int i, String str2, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1147936715")) {
            return ((Integer) ipChange.ipc$dispatch("1147936715", new Object[]{this, str, Integer.valueOf(i), str2, Integer.valueOf(i2)})).intValue();
        }
        b41.f(str);
        int length = str.length() - i;
        if (length < i2) {
            return -1;
        }
        int i3 = 0;
        while (i3 <= length - i2) {
            int i4 = 0;
            while (str.charAt(i3) == str2.charAt(i4)) {
                i4++;
                i3++;
                if (i4 == str2.length()) {
                    return i3;
                }
            }
            i3++;
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003f, code lost:
        r0 = kotlin.text.StringsKt__StringsKt.Z(r10, "\"", r2, false, 4, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0031, code lost:
        r2 = kotlin.text.StringsKt__StringsKt.Z(r10, "=", r11, false, 4, null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String k(java.lang.String r10, int r11, java.lang.String r12) {
        /*
            r9 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = tb.w8.$ipChange
            java.lang.String r1 = "878057923"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r6 = 2
            r7 = 1
            if (r2 == 0) goto L24
            r2 = 4
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r9
            r2[r7] = r10
            java.lang.Integer r3 = java.lang.Integer.valueOf(r11)
            r2[r6] = r3
            r3 = 3
            r2[r3] = r12
            java.lang.Object r0 = r0.ipc$dispatch(r1, r2)
            java.lang.String r0 = (java.lang.String) r0
            return r0
        L24:
            int r0 = r10.length()
            int r0 = r0 - r11
            int r1 = r12.length()
            r8 = 0
            if (r0 >= r1) goto L31
            return r8
        L31:
            r3 = 0
            r4 = 4
            r5 = 0
            java.lang.String r1 = "="
            r0 = r10
            r2 = r11
            int r2 = kotlin.text.C8596g.Z(r0, r1, r2, r3, r4, r5)
            if (r2 >= 0) goto L3f
            return r8
        L3f:
            r3 = 0
            r4 = 4
            r5 = 0
            java.lang.String r1 = "\""
            r0 = r10
            int r0 = kotlin.text.C8596g.Z(r0, r1, r2, r3, r4, r5)
            if (r0 >= 0) goto L4c
            return r8
        L4c:
            int r0 = r0 + r7
            int r1 = r10.length()
            int r1 = r1 - r6
            if (r0 <= r1) goto L55
            return r8
        L55:
            int r1 = r10.length()
            int r1 = r1 - r6
            r2 = 10
            r3 = 32
            if (r0 >= r1) goto L6f
            char r1 = r10.charAt(r0)
            if (r1 == r3) goto L6c
            char r1 = r10.charAt(r0)
            if (r1 != r2) goto L6f
        L6c:
            int r0 = r0 + 1
            goto L55
        L6f:
            int r1 = r0 + 1
        L71:
            int r4 = r10.length()
            int r4 = r4 - r7
            if (r1 >= r4) goto L8f
            char r4 = r10.charAt(r1)
            r5 = 34
            if (r4 == r5) goto L8f
            char r4 = r10.charAt(r1)
            if (r4 == r3) goto L8f
            char r4 = r10.charAt(r1)
            if (r4 == r2) goto L8f
            int r1 = r1 + 1
            goto L71
        L8f:
            int r2 = r10.length()
            int r2 = r2 - r7
            if (r1 > r2) goto L9f
            java.lang.String r8 = r10.substring(r0, r1)
            java.lang.String r0 = "this as java.lang.String…ing(startIndex, endIndex)"
            tb.b41.h(r8, r0)
        L9f:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.w8.k(java.lang.String, int, java.lang.String):java.lang.String");
    }

    public final int h(@Nullable String str, @Nullable String str2) {
        boolean K;
        boolean K2;
        int Z;
        boolean K3;
        int Z2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1183766978")) {
            return ((Integer) ipChange.ipc$dispatch("1183766978", new Object[]{this, str, str2})).intValue();
        }
        if (str != null) {
            b41.f(str2);
            K = StringsKt__StringsKt.K(str, str2, false, 2, null);
            if (K) {
                K2 = StringsKt__StringsKt.K(str, ";", false, 2, null);
                if (K2) {
                    Z = StringsKt__StringsKt.Z(str, str2, 0, false, 6, null);
                    String substring = str.substring(Z);
                    b41.h(substring, "this as java.lang.String).substring(startIndex)");
                    if (substring != null) {
                        K3 = StringsKt__StringsKt.K(substring, ";", false, 2, null);
                        if (K3) {
                            Z2 = StringsKt__StringsKt.Z(str, ";", 0, false, 6, null);
                            String substring2 = substring.substring(0, Z2);
                            b41.h(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                            return c(substring2);
                        }
                        return -1;
                    }
                    return -1;
                }
                return -1;
            }
            return -1;
        }
        return -1;
    }

    public final boolean l(@Nullable String str) {
        boolean K;
        int f0;
        boolean K2;
        boolean K3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1844938474")) {
            return ((Boolean) ipChange.ipc$dispatch("-1844938474", new Object[]{this, str})).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        b41.f(str);
        K = StringsKt__StringsKt.K(str, ".", false, 2, null);
        if (K) {
            f0 = StringsKt__StringsKt.f0(str, ".", 0, false, 6, null);
            String substring = str.substring(f0);
            b41.h(substring, "this as java.lang.String).substring(startIndex)");
            if (!TextUtils.isEmpty(substring)) {
                String lowerCase = substring.toLowerCase();
                b41.h(lowerCase, "this as java.lang.String).toLowerCase()");
                K2 = StringsKt__StringsKt.K(lowerCase, "jpg", false, 2, null);
                if (K2) {
                    return true;
                }
                K3 = StringsKt__StringsKt.K(lowerCase, "png", false, 2, null);
                return K3;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0100, code lost:
        if (r5.c() > 0) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0109 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final tb.vz0.C9832b m(int r23, @org.jetbrains.annotations.Nullable char[] r24, int r25) {
        /*
            Method dump skipped, instructions count: 452
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.w8.m(int, char[], int):tb.vz0$b");
    }
}
