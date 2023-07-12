package tb;

import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.monitor.DXTraceUtil;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class yq0 {
    @Nullable
    private static Pattern a;

    @Nullable
    public static final Object c(@NotNull JSON json, @NotNull String str) {
        int Z;
        int Z2;
        int Z3;
        CharSequence M0;
        JSONArray jSONArray;
        b41.i(json, "<this>");
        b41.i(str, "valuePath");
        try {
            Z = StringsKt__StringsKt.Z(str, ".", 0, false, 6, null);
            Z2 = StringsKt__StringsKt.Z(str, jn1.ARRAY_START_STR, 0, false, 6, null);
            Z3 = StringsKt__StringsKt.Z(str, jn1.ARRAY_END_STR, 0, false, 6, null);
            if (Z == -1 && Z2 != -1 && Z3 != -1) {
                String substring = str.substring(0, Z2);
                b41.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String substring2 = str.substring(Z2 + 1, Z3);
                b41.h(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                int parseInt = Integer.parseInt(substring2);
                JSONObject jSONObject = json instanceof JSONObject ? (JSONObject) json : null;
                if (jSONObject != null && (jSONArray = jSONObject.getJSONArray(substring)) != null) {
                    if (jSONArray.size() > parseInt) {
                        return jSONArray.get(parseInt);
                    }
                    Log.e("[GaiaX]", "getAnyExt IndexOutOfBounds: XPath: " + str + " Index: " + parseInt + ", Size: " + jSONArray.size());
                    return null;
                }
                return null;
            } else if (Z == -1 && Z2 == -1 && Z3 == -1) {
                JSONObject jSONObject2 = json instanceof JSONObject ? (JSONObject) json : null;
                if (jSONObject2 == null) {
                    return null;
                }
                return jSONObject2.get(str);
            } else {
                String substring3 = str.substring(0, Z);
                b41.h(substring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                if (substring3 != null) {
                    M0 = StringsKt__StringsKt.M0(substring3);
                    String obj = M0.toString();
                    String substring4 = str.substring(Z + 1, str.length());
                    b41.h(substring4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    JSONObject jSONObject3 = json instanceof JSONObject ? (JSONObject) json : null;
                    Object c = jSONObject3 == null ? null : c(jSONObject3, obj);
                    JSON json2 = c instanceof JSON ? (JSON) c : null;
                    if (json2 == null) {
                        return null;
                    }
                    return c(json2, substring4);
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
        } catch (Exception e) {
            wq0 wq0Var = wq0.INSTANCE;
            if (wq0Var.b()) {
                wq0Var.a(e);
            }
            return null;
        }
    }

    public static final int d(@NotNull JSON json, @NotNull String str) {
        b41.i(json, "<this>");
        b41.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
        Object c = c(json, str);
        if (c == null) {
            c = "";
        }
        String obj = c.toString();
        try {
            if (obj.length() > 0) {
                return Integer.parseInt(obj);
            }
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @NotNull
    public static final JSONArray e(@NotNull JSON json, @NotNull String str) {
        b41.i(json, "<this>");
        b41.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
        Object c = c(json, str);
        JSONArray jSONArray = c instanceof JSONArray ? (JSONArray) c : null;
        return jSONArray == null ? new JSONArray() : jSONArray;
    }

    public static final long f(@NotNull JSON json, @NotNull String str) {
        b41.i(json, "<this>");
        b41.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
        Object c = c(json, str);
        if (c == null) {
            c = "";
        }
        String obj = c.toString();
        try {
            if (obj.length() > 0) {
                return Long.parseLong(obj);
            }
            return -1L;
        } catch (Exception e) {
            e.printStackTrace();
            return -1L;
        }
    }

    @NotNull
    public static final String g(@NotNull JSON json, @NotNull String str) {
        b41.i(json, "<this>");
        b41.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
        String h = h(json, str);
        return h == null ? "" : h;
    }

    @Nullable
    public static final String h(@NotNull JSON json, @NotNull String str) {
        b41.i(json, "<this>");
        b41.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
        Object c = c(json, str);
        if (c == null) {
            return null;
        }
        return c.toString();
    }

    @NotNull
    public static final JSONObject i(@NotNull String str) {
        b41.i(str, "<this>");
        try {
            JSONObject parseObject = JSON.parseObject(str);
            b41.h(parseObject, "{\n    JSONObject.parseObject(this)\n}");
            return parseObject;
        } catch (Exception unused) {
            return new JSONObject();
        }
    }

    public static final void j(@NotNull JSON json, @NotNull String str, @NotNull Object obj) {
        b41.i(json, "<this>");
        b41.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
        b41.i(obj, "value");
        try {
            i61 i61Var = i61.INSTANCE;
            String[] f = i61Var.f(str);
            if (!(f.length == 0)) {
                String str2 = f[0];
                String str3 = f.length >= 2 ? f[1] : null;
                int a2 = i61Var.a(str2);
                if (str3 != null) {
                    if (str3.length() > 0) {
                        if (a2 == -1) {
                            if (json instanceof JSONObject) {
                                Object obj2 = ((JSONObject) json).get(str2);
                                if (obj2 instanceof JSON) {
                                    j((JSON) obj2, str3, obj);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        Object c = i61Var.c(json, str2, a2);
                        if (c instanceof JSON) {
                            j((JSON) c, str3, obj);
                            return;
                        }
                        return;
                    }
                }
                if (a2 == -1 && (json instanceof JSONObject)) {
                    ((Map) json).put(str2, obj);
                    return;
                }
                String b = i61Var.b(str2);
                if (json instanceof JSONObject) {
                    if (((JSONObject) json).containsKey(b)) {
                        ((JSONObject) json).getJSONArray(b).add(a2, obj);
                    }
                } else if (json instanceof JSONArray) {
                    ((JSONArray) json).add(a2, obj);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
