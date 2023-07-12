package com.taobao.android.ultron.expr;

import android.util.LruCache;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import tb.gn1;
import tb.vt2;

/* compiled from: Taobao */
/* renamed from: com.taobao.android.ultron.expr.b */
/* loaded from: classes11.dex */
class C6666b implements ValueResolver {
    private static final LruCache<String, Method> a = new LruCache<>(64);
    private static final LruCache<String, String> b = new LruCache<>(16);
    private static final LruCache<String, Field> c = new LruCache<>(32);
    private static final LruCache<String, String> d = new LruCache<>(16);

    @Override // com.taobao.android.ultron.expr.ValueResolver
    public boolean canResolve(Object obj, Class<?> cls, String str) {
        return true;
    }

    @Override // com.taobao.android.ultron.expr.ValueResolver
    public Object resolve(Object obj, Class<?> cls, String str) {
        String str2 = cls.getName() + "[]" + str;
        LruCache<String, Method> lruCache = a;
        Method method = lruCache.get(str2);
        if (method != null) {
            try {
                return method.invoke(obj, new Object[0]);
            } catch (Exception e) {
                vt2.g(e.getMessage(), new String[0]);
                return null;
            }
        }
        Field field = c.get(str2);
        if (field != null) {
            try {
                return field.get(obj);
            } catch (Exception e2) {
                vt2.g(e2.getMessage(), new String[0]);
                return null;
            }
        }
        if (b.get(str2) != "") {
            try {
                try {
                    Method method2 = cls.getMethod(gn1.TYPE_OPEN_URL_METHOD_GET + Character.toUpperCase(str.charAt(0)) + str.substring(1), new Class[0]);
                    lruCache.put(str2, method2);
                    return method2.invoke(obj, new Object[0]);
                } catch (NoSuchMethodException unused) {
                    b.put(str2, "");
                } catch (Exception e3) {
                    vt2.g(e3.getMessage(), new String[0]);
                    return null;
                }
            } catch (NoSuchMethodException unused2) {
                Method method3 = cls.getMethod("is" + Character.toUpperCase(str.charAt(0)) + str.substring(1), new Class[0]);
                a.put(str2, method3);
                return method3.invoke(obj, new Object[0]);
            } catch (Exception e4) {
                vt2.g(e4.getMessage(), new String[0]);
                return null;
            }
        }
        if (d.get(str2) != "") {
            try {
                Field field2 = cls.getField(str);
                c.put(str2, field2);
                return field2.get(obj);
            } catch (NoSuchFieldException unused3) {
                d.put(str2, "");
            } catch (Exception e5) {
                vt2.g(e5.getMessage(), new String[0]);
                return null;
            }
        }
        return null;
    }
}
