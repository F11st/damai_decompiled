package com.alibaba.wireless.security.aopsdk.f;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Factory.java */
/* loaded from: classes.dex */
public class a {
    public static Object a(Class<?> cls, Object... objArr) {
        Object newInstance = Array.newInstance(cls, objArr.length);
        for (int i = 0; i < objArr.length; i++) {
            try {
                Array.set(newInstance, i, objArr[i]);
            } catch (Throwable th) {
            }
        }
        return newInstance;
    }

    public static Object b(Class<?> cls, Object... objArr) {
        Class<?>[] clsArr;
        if (objArr != null) {
            Class<?>[] clsArr2 = new Class[objArr.length];
            for (int i = 0; i < objArr.length; i++) {
                clsArr2[i] = objArr[i].getClass();
            }
            clsArr = clsArr2;
        } else {
            clsArr = new Class[0];
        }
        try {
            return cls.getDeclaredConstructor(clsArr).newInstance(objArr);
        } catch (Throwable th) {
            return null;
        }
    }

    public static List<Object> a(Class<?> cls, JSONArray jSONArray) {
        if (!List.class.isAssignableFrom(cls) || jSONArray == null) {
            return null;
        }
        try {
            List<Object> list = (List) b(cls, new Object[0]);
            if (list != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        list.add(jSONArray.get(i));
                    } catch (Throwable th) {
                        return list;
                    }
                }
                return list;
            }
            return list;
        } catch (Throwable th2) {
            return null;
        }
    }

    public static Map<Object, Object> a(Class<?> cls, JSONObject jSONObject) {
        if (!Map.class.isAssignableFrom(cls) || jSONObject == null) {
            return null;
        }
        try {
            Map<Object, Object> map = (Map) b(cls, new Object[0]);
            if (map != null) {
                try {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        map.put(next, jSONObject.get(next));
                    }
                    return map;
                } catch (Throwable th) {
                    return map;
                }
            }
            return map;
        } catch (Throwable th2) {
            return null;
        }
    }

    public static Set<Object> b(Class<?> cls, JSONArray jSONArray) {
        if (!Set.class.isAssignableFrom(cls) || jSONArray == null) {
            return null;
        }
        try {
            Set<Object> set = (Set) b(cls, new Object[0]);
            if (set != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        set.add(jSONArray.get(i));
                    } catch (Throwable th) {
                        return set;
                    }
                }
                return set;
            }
            return set;
        } catch (Throwable th2) {
            return null;
        }
    }

    public static char a(String str) {
        if (str == null || str.length() <= 0) {
            return (char) 0;
        }
        return str.charAt(0);
    }
}
