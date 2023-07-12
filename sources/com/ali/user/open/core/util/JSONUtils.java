package com.ali.user.open.core.util;

import android.util.Base64;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class JSONUtils {
    public static Boolean optBoolean(JSONObject jSONObject, String str) {
        return Boolean.valueOf(jSONObject.has(str) ? jSONObject.optBoolean(str) : false);
    }

    public static Integer optInteger(JSONObject jSONObject, String str) {
        if (jSONObject.has(str)) {
            return Integer.valueOf(jSONObject.optInt(str));
        }
        return null;
    }

    public static Long optLong(JSONObject jSONObject, String str) {
        if (jSONObject.has(str)) {
            return Long.valueOf(jSONObject.optLong(str));
        }
        return null;
    }

    public static String optString(JSONObject jSONObject, String str) {
        if (jSONObject.has(str)) {
            return jSONObject.optString(str);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.lang.Character[], T] */
    /* JADX WARN: Type inference failed for: r0v9, types: [T, java.lang.Byte[]] */
    public static <T> T parseStringValue(String str, Class<T> cls) {
        if (str == 0 || cls == null) {
            return null;
        }
        if (String.class.equals(cls)) {
            return str;
        }
        if (!Short.TYPE.equals(cls) && !Short.class.equals(cls)) {
            if (!Integer.TYPE.equals(cls) && !Integer.class.equals(cls)) {
                if (!Long.TYPE.equals(cls) && !Long.class.equals(cls)) {
                    if (!Boolean.TYPE.equals(cls) && !Boolean.class.equals(cls)) {
                        if (!Float.TYPE.equals(cls) && !Float.class.equals(cls)) {
                            if (!Double.TYPE.equals(cls) && !Double.class.equals(cls)) {
                                if (!Byte.TYPE.equals(cls) && !Byte.class.equals(cls)) {
                                    int i = 0;
                                    if (!Character.TYPE.equals(cls) && !Character.class.equals(cls)) {
                                        if (Date.class.isAssignableFrom(cls)) {
                                            try {
                                                return (T) new SimpleDateFormat("yyyyMMddHHmmssSSSZ", Locale.US).parse(str);
                                            } catch (ParseException e) {
                                                throw new RuntimeException("Parse Date error", e);
                                            }
                                        }
                                        char charAt = str.charAt(0);
                                        if (!cls.isArray()) {
                                            if (charAt == '{') {
                                                try {
                                                    JSONObject jSONObject = new JSONObject(str);
                                                    if (Map.class.isAssignableFrom(cls)) {
                                                        return (T) toMap(jSONObject);
                                                    }
                                                    return (T) toPOJO(jSONObject, cls);
                                                } catch (Exception e2) {
                                                    throw new RuntimeException(e2);
                                                }
                                            } else if (cls.isAssignableFrom(String.class)) {
                                                return str;
                                            } else {
                                                return null;
                                            }
                                        }
                                        Class<?> componentType = cls.getComponentType();
                                        if (charAt == '[') {
                                            try {
                                                return (T) toPOJOArray(new JSONArray(str), componentType);
                                            } catch (Exception e3) {
                                                throw new RuntimeException(e3);
                                            }
                                        } else if (String.class.equals(componentType)) {
                                            return (T) str.split(",");
                                        } else {
                                            if (Character.TYPE.equals(componentType)) {
                                                return (T) str.toCharArray();
                                            }
                                            if (Character.class.equals(componentType)) {
                                                char[] charArray = str.toCharArray();
                                                int length = charArray.length;
                                                ?? r0 = (T) new Character[length];
                                                while (i < length) {
                                                    r0[i] = Character.valueOf(charArray[i]);
                                                    i++;
                                                }
                                                return r0;
                                            } else if (Byte.TYPE.equals(componentType)) {
                                                return (T) Base64.decode(str, 0);
                                            } else {
                                                if (Byte.class.equals(componentType)) {
                                                    byte[] decode = Base64.decode(str, 0);
                                                    int length2 = decode.length;
                                                    ?? r02 = (T) new Byte[length2];
                                                    while (i < length2) {
                                                        r02[i] = Byte.valueOf(decode[i]);
                                                        i++;
                                                    }
                                                    return r02;
                                                }
                                                return null;
                                            }
                                        }
                                    }
                                    return (T) Character.valueOf(str.charAt(0));
                                }
                                return (T) Byte.valueOf(str);
                            }
                            return (T) Double.valueOf(str);
                        }
                        return (T) Float.valueOf(str);
                    }
                    return (T) Boolean.valueOf(str);
                }
                return (T) Long.valueOf(str);
            }
            return (T) Integer.valueOf(str);
        }
        return (T) Short.valueOf(str);
    }

    public static JSONArray toJsonArray(Object[] objArr) {
        JSONArray jSONArray = new JSONArray();
        for (Object obj : objArr) {
            if (obj instanceof Map) {
                jSONArray.put(toJsonObject((Map) obj));
            } else {
                jSONArray.put(obj);
            }
        }
        return jSONArray;
    }

    public static JSONObject toJsonObject(Map<String, ? extends Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                Object value = entry.getValue();
                if (value != null) {
                    if (value instanceof Map) {
                        jSONObject.put(entry.getKey(), toJsonObject((Map) value));
                    } else if (value instanceof List) {
                        jSONObject.put(entry.getKey(), toJsonArray((List) value));
                    } else if (value.getClass().isArray()) {
                        jSONObject.put(entry.getKey(), toJsonArray((Object[]) value));
                    } else {
                        jSONObject.put(entry.getKey(), value);
                    }
                }
            }
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Object> toList(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(jSONArray.length());
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            Object obj = jSONArray.get(i);
            if (obj instanceof JSONObject) {
                arrayList.add(toMap((JSONObject) obj));
            } else if (obj instanceof JSONArray) {
                arrayList.add(toList((JSONArray) obj));
            } else {
                arrayList.add(jSONArray.get(i));
            }
        }
        return arrayList;
    }

    public static Map<String, Object> toMap(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        if (jSONObject == null) {
            return hashMap;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = jSONObject.opt(next);
            if (opt instanceof JSONObject) {
                hashMap.put(next, toMap((JSONObject) opt));
            } else if (opt instanceof JSONArray) {
                hashMap.put(next, toList((JSONArray) opt));
            } else {
                hashMap.put(next, opt);
            }
        }
        return hashMap;
    }

    public static <T> T toPOJO(JSONObject jSONObject, Class<T> cls) {
        Field[] fields;
        char c;
        Object obj;
        if (jSONObject == null || cls == null || cls == Void.TYPE) {
            return null;
        }
        try {
            T newInstance = cls.newInstance();
            for (Field field : cls.getFields()) {
                Class<?> type = field.getType();
                String name = field.getName();
                if (jSONObject.has(name)) {
                    if (!type.isPrimitive()) {
                        if (type == String.class) {
                            obj = jSONObject.getString(name);
                        } else {
                            if (type != Boolean.class && type != Integer.class && type != Short.class && type != Long.class && type != Double.class) {
                                if (type.isArray()) {
                                    obj = toPOJOArray(jSONObject.getJSONArray(name), type.getComponentType());
                                } else if (Map.class.isAssignableFrom(type)) {
                                    obj = toMap(jSONObject.getJSONObject(name));
                                } else {
                                    obj = toPOJO(jSONObject.getJSONObject(name), type);
                                }
                            }
                            obj = jSONObject.get(name);
                        }
                        field.set(newInstance, obj);
                    } else if (type == Boolean.TYPE) {
                        field.setBoolean(newInstance, jSONObject.getBoolean(name));
                    } else if (type == Byte.TYPE) {
                        field.setByte(newInstance, (byte) jSONObject.getInt(name));
                    } else if (type == Character.TYPE) {
                        String string = jSONObject.getString(name);
                        if (string != null && string.length() != 0) {
                            c = string.charAt(0);
                            field.setChar(newInstance, c);
                        }
                        c = 0;
                        field.setChar(newInstance, c);
                    } else if (type == Short.TYPE) {
                        field.setShort(newInstance, (short) jSONObject.getInt(name));
                    } else if (type == Integer.TYPE) {
                        field.setInt(newInstance, jSONObject.getInt(name));
                    } else if (type == Long.TYPE) {
                        field.setLong(newInstance, jSONObject.getLong(name));
                    } else if (type == Float.TYPE) {
                        field.setFloat(newInstance, (float) jSONObject.getDouble(name));
                    } else if (type == Double.TYPE) {
                        field.setDouble(newInstance, jSONObject.getDouble(name));
                    }
                }
            }
            return newInstance;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T[] toPOJOArray(JSONArray jSONArray, Class<T> cls) {
        char c;
        Object obj;
        if (jSONArray == null || cls == null || cls == Void.TYPE) {
            return null;
        }
        Object newInstance = Array.newInstance((Class<?>) cls, jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                if (!cls.isPrimitive()) {
                    if (cls == String.class) {
                        obj = jSONArray.getString(i);
                    } else {
                        if (cls != Boolean.class && cls != Integer.class && cls != Short.class && cls != Long.class && cls != Double.class) {
                            if (cls.isArray()) {
                                obj = toPOJOArray(jSONArray.getJSONArray(i), cls.getComponentType());
                            } else if (Map.class.isAssignableFrom(cls)) {
                                obj = toMap(jSONArray.getJSONObject(i));
                            } else {
                                obj = toPOJO(jSONArray.getJSONObject(i), cls);
                            }
                        }
                        obj = jSONArray.get(i);
                    }
                    Array.set(newInstance, i, obj);
                } else if (cls == Boolean.TYPE) {
                    Array.setBoolean(newInstance, i, jSONArray.getBoolean(i));
                } else if (cls == Byte.TYPE) {
                    Array.setByte(newInstance, i, (byte) jSONArray.getInt(i));
                } else if (cls == Character.TYPE) {
                    String string = jSONArray.getString(i);
                    if (string != null && string.length() != 0) {
                        c = string.charAt(0);
                        Array.setChar(newInstance, i, c);
                    }
                    c = 0;
                    Array.setChar(newInstance, i, c);
                } else if (cls == Short.TYPE) {
                    Array.setShort(newInstance, i, (short) jSONArray.getInt(i));
                } else if (cls == Integer.TYPE) {
                    Array.setInt(newInstance, i, jSONArray.getInt(i));
                } else if (cls == Long.TYPE) {
                    Array.setLong(newInstance, i, jSONArray.getLong(i));
                } else if (cls == Float.TYPE) {
                    Array.setFloat(newInstance, i, (float) jSONArray.getDouble(i));
                } else if (cls == Double.TYPE) {
                    Array.setDouble(newInstance, i, jSONArray.getDouble(i));
                }
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        return (T[]) ((Object[]) newInstance);
    }

    public static JSONArray toJsonArray(List<Object> list) {
        JSONArray jSONArray = new JSONArray();
        for (Object obj : list) {
            if (obj instanceof Map) {
                jSONArray.put(toJsonObject((Map) obj));
            } else {
                jSONArray.put(obj);
            }
        }
        return jSONArray;
    }
}
