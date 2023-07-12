package tb;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class i61 {
    public static final int ARRAY_INDEX_NO = -1;
    public static final double ERROR_RESULT_DOUBLE = -1.0d;
    public static final float ERROR_RESULT_FLOAT = -1.0f;
    public static final int ERROR_RESULT_INT = -1;
    public static final long ERROR_RESULT_LONG = -1;
    @NotNull
    public static final i61 INSTANCE = new i61();

    private i61() {
    }

    private final boolean d(String str) {
        boolean K;
        if (str.length() > 0) {
            K = StringsKt__StringsKt.K(str, jn1.ARRAY_START_STR, false, 2, null);
            if (K) {
                return true;
            }
        }
        return false;
    }

    private final int e(String str, int i) {
        Pattern pattern;
        try {
            pattern = yq0.a;
            Matcher matcher = pattern == null ? null : pattern.matcher(str);
            if (matcher == null || !matcher.find()) {
                return i;
            }
            String group = matcher.group();
            b41.h(group, "m.group()");
            return Integer.parseInt(group);
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
    }

    public final int a(@NotNull String str) {
        Pattern pattern;
        b41.i(str, "arrayKey");
        if (d(str)) {
            pattern = yq0.a;
            if (pattern == null) {
                yq0.a = Pattern.compile("(?<=\\[)(.+?)(?=\\])");
            }
            return e(str, -1);
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0013, code lost:
        r0 = kotlin.text.StringsKt__StringsKt.Z(r10, tb.jn1.ARRAY_START_STR, 0, false, 6, null);
     */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String b(@org.jetbrains.annotations.NotNull java.lang.String r10) {
        /*
            r9 = this;
            java.lang.String r0 = "arrayKey"
            tb.b41.i(r10, r0)
            int r0 = r10.length()
            r1 = 0
            if (r0 <= 0) goto Le
            r0 = 1
            goto Lf
        Le:
            r0 = 0
        Lf:
            java.lang.String r2 = ""
            if (r0 == 0) goto L2a
            r5 = 0
            r6 = 0
            r7 = 6
            r8 = 0
            java.lang.String r4 = "["
            r3 = r10
            int r0 = kotlin.text.C8596g.Z(r3, r4, r5, r6, r7, r8)
            if (r0 >= 0) goto L21
            goto L2a
        L21:
            java.lang.String r2 = r10.substring(r1, r0)
            java.lang.String r10 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            tb.b41.h(r2, r10)
        L2a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.i61.b(java.lang.String):java.lang.String");
    }

    @Nullable
    public final Object c(@NotNull Object obj, @NotNull String str, int i) {
        b41.i(obj, "src");
        b41.i(str, "arrayIndexKey");
        String b = b(str);
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject.containsKey(b)) {
                JSONArray jSONArray = jSONObject.getJSONArray(b);
                if (jSONArray.size() > i) {
                    return jSONArray.get(i);
                }
            }
        } else if (obj instanceof JSONArray) {
            JSONArray jSONArray2 = (JSONArray) obj;
            if (jSONArray2.size() > i) {
                return jSONArray2.get(i);
            }
        }
        return null;
    }

    @NotNull
    public final String[] f(@NotNull String str) {
        int Z;
        String[] strArr;
        b41.i(str, "key");
        String[] strArr2 = new String[0];
        if (str.length() > 0) {
            Z = StringsKt__StringsKt.Z(str, ".", 0, false, 6, null);
            if (Z == -1) {
                return new String[]{str};
            }
            int i = Z + 1;
            if (i < str.length()) {
                String substring = str.substring(0, Z);
                b41.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String substring2 = str.substring(i);
                b41.h(substring2, "(this as java.lang.String).substring(startIndex)");
                strArr = new String[]{substring, substring2};
            } else {
                String substring3 = str.substring(0, Z);
                b41.h(substring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                strArr = new String[]{substring3};
            }
            return strArr;
        }
        return strArr2;
    }
}
