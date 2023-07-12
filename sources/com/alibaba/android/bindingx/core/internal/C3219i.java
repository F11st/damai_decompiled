package com.alibaba.android.bindingx.core.internal;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import com.taobao.weex.ui.component.richtext.node.RichTextNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.CharUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import tb.bb1;
import tb.jn1;
import tb.xg0;

/* compiled from: Taobao */
/* renamed from: com.alibaba.android.bindingx.core.internal.i */
/* loaded from: classes5.dex */
class C3219i {
    private static final Map<String, Object> b = new HashMap(32);
    private JSONObject a;

    C3219i(String str) {
        try {
            this.a = (JSONObject) new JSONTokener(str).nextValue();
        } catch (Throwable th) {
            bb1.c("[Expression] expression is illegal. \n ", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static C3219i a(xg0 xg0Var) {
        if (xg0Var == null) {
            return null;
        }
        if (!TextUtils.isEmpty(xg0Var.b)) {
            return new C3219i(xg0Var.b);
        }
        JSONObject jSONObject = xg0Var.c;
        if (jSONObject != null) {
            return new C3219i(jSONObject);
        }
        return null;
    }

    private boolean b(Object obj, Object obj2) {
        if ((obj instanceof JSObjectInterface) && (obj2 instanceof JSObjectInterface)) {
            return obj == obj2;
        } else if ((obj instanceof String) && (obj2 instanceof String)) {
            return obj.equals(obj2);
        } else {
            return ((obj instanceof Boolean) && (obj2 instanceof Boolean)) ? h(obj) == h(obj2) : i(obj) == i(obj2);
        }
    }

    private Object d(JSONObject jSONObject, Map<String, Object> map) throws IllegalArgumentException, JSONException {
        String string = jSONObject.getString("type");
        JSONArray optJSONArray = jSONObject.optJSONArray(RichTextNode.CHILDREN);
        string.hashCode();
        char c = 65535;
        switch (string.hashCode()) {
            case -1746151498:
                if (string.equals("CallExpression")) {
                    c = 0;
                    break;
                }
                break;
            case 33:
                if (string.equals(jn1.AND_NOT)) {
                    c = 1;
                    break;
                }
                break;
            case 37:
                if (string.equals("%")) {
                    c = 2;
                    break;
                }
                break;
            case 42:
                if (string.equals(jn1.MUL)) {
                    c = 3;
                    break;
                }
                break;
            case 43:
                if (string.equals(jn1.PLUS)) {
                    c = 4;
                    break;
                }
                break;
            case 45:
                if (string.equals("-")) {
                    c = 5;
                    break;
                }
                break;
            case 47:
                if (string.equals("/")) {
                    c = 6;
                    break;
                }
                break;
            case 60:
                if (string.equals(jn1.L)) {
                    c = 7;
                    break;
                }
                break;
            case 62:
                if (string.equals(jn1.G)) {
                    c = '\b';
                    break;
                }
                break;
            case 63:
                if (string.equals("?")) {
                    c = '\t';
                    break;
                }
                break;
            case 1084:
                if (string.equals(jn1.NOT_EQUAL2)) {
                    c = '\n';
                    break;
                }
                break;
            case INoCaptchaComponent.SG_NC_VERI_WUA_INCORRECT_DATA_FILE /* 1216 */:
                if (string.equals(jn1.AND)) {
                    c = 11;
                    break;
                }
                break;
            case 1344:
                if (string.equals("**")) {
                    c = '\f';
                    break;
                }
                break;
            case 1921:
                if (string.equals(jn1.LE)) {
                    c = CharUtils.CR;
                    break;
                }
                break;
            case 1952:
                if (string.equals(jn1.EQUAL2)) {
                    c = 14;
                    break;
                }
                break;
            case 1983:
                if (string.equals(jn1.GE)) {
                    c = 15;
                    break;
                }
                break;
            case 3968:
                if (string.equals(jn1.OR)) {
                    c = 16;
                    break;
                }
                break;
            case 33665:
                if (string.equals(jn1.NOT_EQUAL)) {
                    c = 17;
                    break;
                }
                break;
            case 60573:
                if (string.equals(jn1.EQUAL)) {
                    c = 18;
                    break;
                }
                break;
            case 189157634:
                if (string.equals("NumericLiteral")) {
                    c = 19;
                    break;
                }
                break;
            case 375032009:
                if (string.equals("Identifier")) {
                    c = 20;
                    break;
                }
                break;
            case 1074430782:
                if (string.equals("StringLiteral")) {
                    c = 21;
                    break;
                }
                break;
            case 1816238983:
                if (string.equals("BooleanLiteral")) {
                    c = 22;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                JSFunctionInterface jSFunctionInterface = (JSFunctionInterface) d(optJSONArray.getJSONObject(0), map);
                ArrayList<Object> arrayList = new ArrayList<>();
                JSONArray jSONArray = optJSONArray.getJSONObject(1).getJSONArray(RichTextNode.CHILDREN);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(d(jSONArray.getJSONObject(i), map));
                }
                return jSFunctionInterface.execute(arrayList);
            case 1:
                return Boolean.valueOf(!h(d(optJSONArray.getJSONObject(0), map)));
            case 2:
                return Double.valueOf(i(d(optJSONArray.getJSONObject(0), map)) % i(d(optJSONArray.getJSONObject(1), map)));
            case 3:
                return Double.valueOf(i(d(optJSONArray.getJSONObject(0), map)) * i(d(optJSONArray.getJSONObject(1), map)));
            case 4:
                return Double.valueOf(i(d(optJSONArray.getJSONObject(0), map)) + i(d(optJSONArray.getJSONObject(1), map)));
            case 5:
                return Double.valueOf(i(d(optJSONArray.getJSONObject(0), map)) - i(d(optJSONArray.getJSONObject(1), map)));
            case 6:
                return Double.valueOf(i(d(optJSONArray.getJSONObject(0), map)) / i(d(optJSONArray.getJSONObject(1), map)));
            case 7:
                return Boolean.valueOf(i(d(optJSONArray.getJSONObject(0), map)) < i(d(optJSONArray.getJSONObject(1), map)));
            case '\b':
                return Boolean.valueOf(i(d(optJSONArray.getJSONObject(0), map)) > i(d(optJSONArray.getJSONObject(1), map)));
            case '\t':
                if (((Boolean) d(optJSONArray.getJSONObject(0), map)).booleanValue()) {
                    return d(optJSONArray.getJSONObject(1), map);
                }
                return d(optJSONArray.getJSONObject(2), map);
            case '\n':
                return Boolean.valueOf(!b(d(optJSONArray.getJSONObject(0), map), d(optJSONArray.getJSONObject(1), map)));
            case 11:
                Object d = d(optJSONArray.getJSONObject(0), map);
                return !h(d) ? d : d(optJSONArray.getJSONObject(1), map);
            case '\f':
                return Double.valueOf(Math.pow(i(d(optJSONArray.getJSONObject(0), map)), i(d(optJSONArray.getJSONObject(1), map))));
            case '\r':
                return Boolean.valueOf(i(d(optJSONArray.getJSONObject(0), map)) <= i(d(optJSONArray.getJSONObject(1), map)));
            case 14:
                return Boolean.valueOf(b(d(optJSONArray.getJSONObject(0), map), d(optJSONArray.getJSONObject(1), map)));
            case 15:
                return Boolean.valueOf(i(d(optJSONArray.getJSONObject(0), map)) >= i(d(optJSONArray.getJSONObject(1), map)));
            case 16:
                Object d2 = d(optJSONArray.getJSONObject(0), map);
                return h(d2) ? d2 : d(optJSONArray.getJSONObject(1), map);
            case 17:
                return Boolean.valueOf(!g(d(optJSONArray.getJSONObject(0), map), d(optJSONArray.getJSONObject(1), map)));
            case 18:
                return Boolean.valueOf(g(d(optJSONArray.getJSONObject(0), map), d(optJSONArray.getJSONObject(1), map)));
            case 19:
                return Double.valueOf(jSONObject.getDouble("value"));
            case 20:
                String string2 = jSONObject.getString("value");
                Object obj = map.get(string2);
                return obj == null ? f(string2) : obj;
            case 21:
                return jSONObject.getString("value");
            case 22:
                return Boolean.valueOf(jSONObject.getBoolean("value"));
            default:
                return null;
        }
    }

    @Nullable
    private static Object e(@NonNull Class<?> cls, @NonNull String str) {
        try {
            Map<String, Object> map = b;
            Object obj = map.get(str);
            if (obj == null) {
                obj = cls.getMethod(str, new Class[0]).invoke(null, new Object[0]);
            }
            if (obj != null) {
                map.put(str, obj);
            }
            return obj;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Nullable
    private Object f(@NonNull String str) {
        Object e = e(JSMath.class, str);
        if (e == null) {
            e = e(TimingFunctions.class, str);
        }
        if (e == null && bb1.a) {
            bb1.b("can not find inentifier: " + str);
        }
        return e;
    }

    private boolean g(Object obj, Object obj2) {
        if (!(obj instanceof JSObjectInterface) || (obj2 instanceof JSObjectInterface)) {
            if (!(obj instanceof Boolean) || (obj2 instanceof Boolean)) {
                if (!(obj instanceof Double) || (obj2 instanceof Double)) {
                    return (!(obj instanceof String) || (obj2 instanceof String)) && obj == obj2;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    private boolean h(Object obj) {
        if (obj instanceof String) {
            return "".equals(obj);
        }
        if (obj instanceof Double) {
            return ((Double) obj).doubleValue() != 0.0d;
        }
        return ((Boolean) obj).booleanValue();
    }

    private double i(Object obj) {
        if (obj instanceof String) {
            return Double.parseDouble((String) obj);
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue() ? 1.0d : 0.0d;
        }
        return ((Double) obj).doubleValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object c(Map<String, Object> map) throws IllegalArgumentException, JSONException {
        return d(this.a, map);
    }

    C3219i(JSONObject jSONObject) {
        this.a = jSONObject;
    }
}
