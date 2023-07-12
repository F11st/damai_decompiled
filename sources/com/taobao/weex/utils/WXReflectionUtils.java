package com.taobao.weex.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXReflectionUtils {
    public static Field getDeclaredField(Object obj, String str) {
        for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            try {
                return cls.getDeclaredField(str);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static Object parseArgument(Type type, Object obj) {
        if (obj != null) {
            if (obj.getClass() == type) {
                return obj;
            }
            if ((type instanceof Class) && ((Class) type).isAssignableFrom(obj.getClass())) {
                return obj;
            }
        }
        if (type == String.class) {
            return obj instanceof String ? obj : JSON.toJSONString(obj);
        }
        Class<?> cls = Integer.TYPE;
        if (type == cls) {
            return obj.getClass().isAssignableFrom(cls) ? obj : Integer.valueOf(WXUtils.getInt(obj));
        }
        Class<?> cls2 = Long.TYPE;
        if (type == cls2) {
            return obj.getClass().isAssignableFrom(cls2) ? obj : Long.valueOf(WXUtils.getLong(obj));
        } else if (type == Double.TYPE) {
            return obj.getClass().isAssignableFrom(Double.TYPE) ? obj : Double.valueOf(WXUtils.getDouble(obj));
        } else {
            Class<?> cls3 = Float.TYPE;
            if (type == cls3) {
                return obj.getClass().isAssignableFrom(cls3) ? obj : Float.valueOf(WXUtils.getFloat(obj));
            } else if (type == JSONArray.class && obj != null && obj.getClass() == JSONArray.class) {
                return obj;
            } else {
                if (type == JSONObject.class && obj != null && obj.getClass() == JSONObject.class) {
                    return obj;
                }
                return JSON.parseObject(obj instanceof String ? (String) obj : JSON.toJSONString(obj), type, new Feature[0]);
            }
        }
    }

    public static void setProperty(Object obj, Field field, Object obj2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        if (obj == null || field == null) {
            return;
        }
        try {
            field.setAccessible(true);
            field.set(obj, obj2);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0098 A[Catch: Exception -> 0x00ab, TryCatch #0 {Exception -> 0x00ab, blocks: (B:7:0x000c, B:9:0x0014, B:11:0x0018, B:38:0x0090, B:40:0x0098, B:44:0x00a8, B:43:0x00a0, B:13:0x001c, B:15:0x0024, B:18:0x002d, B:20:0x0035, B:23:0x003e, B:25:0x0046, B:28:0x004f, B:30:0x0055, B:34:0x0060, B:35:0x0069, B:36:0x0077, B:37:0x0084), top: B:47:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void setValue(java.lang.Object r4, java.lang.String r5, java.lang.Object r6) {
        /*
            java.lang.Class<java.lang.Boolean> r0 = java.lang.Boolean.class
            if (r4 == 0) goto Lab
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            if (r1 == 0) goto Lc
            goto Lab
        Lc:
            java.lang.reflect.Field r5 = getDeclaredField(r4, r5)     // Catch: java.lang.Exception -> Lab
            boolean r1 = r6 instanceof java.math.BigDecimal     // Catch: java.lang.Exception -> Lab
            if (r1 != 0) goto L1c
            boolean r1 = r6 instanceof java.lang.Number     // Catch: java.lang.Exception -> Lab
            if (r1 != 0) goto L1c
            boolean r1 = r6 instanceof java.lang.String     // Catch: java.lang.Exception -> Lab
            if (r1 == 0) goto L5e
        L1c:
            java.lang.Class r1 = r5.getType()     // Catch: java.lang.Exception -> Lab
            java.lang.Class<java.lang.Float> r2 = java.lang.Float.class
            if (r1 == r2) goto L84
            java.lang.Class r1 = r5.getType()     // Catch: java.lang.Exception -> Lab
            java.lang.Class r2 = java.lang.Float.TYPE     // Catch: java.lang.Exception -> Lab
            if (r1 != r2) goto L2d
            goto L84
        L2d:
            java.lang.Class r1 = r5.getType()     // Catch: java.lang.Exception -> Lab
            java.lang.Class<java.lang.Double> r2 = java.lang.Double.class
            if (r1 == r2) goto L77
            java.lang.Class r1 = r5.getType()     // Catch: java.lang.Exception -> Lab
            java.lang.Class r2 = java.lang.Double.TYPE     // Catch: java.lang.Exception -> Lab
            if (r1 != r2) goto L3e
            goto L77
        L3e:
            java.lang.Class r1 = r5.getType()     // Catch: java.lang.Exception -> Lab
            java.lang.Class<java.lang.Integer> r2 = java.lang.Integer.class
            if (r1 == r2) goto L69
            java.lang.Class r1 = r5.getType()     // Catch: java.lang.Exception -> Lab
            java.lang.Class r2 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> Lab
            if (r1 != r2) goto L4f
            goto L69
        L4f:
            java.lang.Class r1 = r5.getType()     // Catch: java.lang.Exception -> Lab
            if (r1 == r0) goto L60
            java.lang.Class r1 = r5.getType()     // Catch: java.lang.Exception -> Lab
            java.lang.Class r2 = java.lang.Boolean.TYPE     // Catch: java.lang.Exception -> Lab
            if (r1 != r2) goto L5e
            goto L60
        L5e:
            r1 = r6
            goto L90
        L60:
            java.lang.String r1 = r6.toString()     // Catch: java.lang.Exception -> Lab
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch: java.lang.Exception -> Lab
            goto L90
        L69:
            java.lang.String r1 = r6.toString()     // Catch: java.lang.Exception -> Lab
            double r1 = java.lang.Double.parseDouble(r1)     // Catch: java.lang.Exception -> Lab
            int r1 = (int) r1     // Catch: java.lang.Exception -> Lab
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Exception -> Lab
            goto L90
        L77:
            java.lang.String r1 = r6.toString()     // Catch: java.lang.Exception -> Lab
            double r1 = java.lang.Double.parseDouble(r1)     // Catch: java.lang.Exception -> Lab
            java.lang.Double r1 = java.lang.Double.valueOf(r1)     // Catch: java.lang.Exception -> Lab
            goto L90
        L84:
            java.lang.String r1 = r6.toString()     // Catch: java.lang.Exception -> Lab
            float r1 = java.lang.Float.parseFloat(r1)     // Catch: java.lang.Exception -> Lab
            java.lang.Float r1 = java.lang.Float.valueOf(r1)     // Catch: java.lang.Exception -> Lab
        L90:
            java.lang.Class r2 = r5.getType()     // Catch: java.lang.Exception -> Lab
            java.lang.Class r3 = java.lang.Boolean.TYPE     // Catch: java.lang.Exception -> Lab
            if (r2 == r3) goto L9e
            java.lang.Class r2 = r5.getType()     // Catch: java.lang.Exception -> Lab
            if (r2 != r0) goto La8
        L9e:
            if (r6 == 0) goto La8
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Exception -> Lab
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r6)     // Catch: java.lang.Exception -> Lab
        La8:
            setProperty(r4, r5, r1)     // Catch: java.lang.Exception -> Lab
        Lab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.weex.utils.WXReflectionUtils.setValue(java.lang.Object, java.lang.String, java.lang.Object):void");
    }
}
