package com.alibaba.fastjson.util;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.ali.user.mobile.app.constant.UTConstant;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alimm.xadsdk.base.expose.RetryMonitorDbHelper;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.ui.component.WXComponent;
import com.vivo.push.PushClientConstants;
import com.youku.upsplayer.util.YKUpsConvert;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.AccessControlException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.KClassImpl;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class TypeUtils {
    public static boolean compatibleWithJavaBean = false;
    private static volatile Map<Class, String[]> kotlinIgnores = null;
    private static volatile boolean kotlinIgnores_error = false;
    private static volatile boolean kotlin_class_klass_error = false;
    private static volatile boolean kotlin_error = false;
    private static volatile Constructor kotlin_kclass_constructor = null;
    private static volatile Method kotlin_kclass_getConstructors = null;
    private static volatile Method kotlin_kfunction_getParameters = null;
    private static volatile Method kotlin_kparameter_getName = null;
    private static volatile Class kotlin_metadata = null;
    private static volatile boolean kotlin_metadata_error = false;
    private static final ConcurrentMap<String, Class<?>> mappings;
    private static boolean setAccessibleEnable = true;

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(36, 0.75f, 1);
        mappings = concurrentHashMap;
        concurrentHashMap.put("byte", Byte.TYPE);
        concurrentHashMap.put("short", Short.TYPE);
        concurrentHashMap.put("int", Integer.TYPE);
        concurrentHashMap.put("long", Long.TYPE);
        concurrentHashMap.put(TypedValues.Custom.S_FLOAT, Float.TYPE);
        concurrentHashMap.put("double", Double.TYPE);
        concurrentHashMap.put(TypedValues.Custom.S_BOOLEAN, Boolean.TYPE);
        concurrentHashMap.put("char", Character.TYPE);
        concurrentHashMap.put("[byte", byte[].class);
        concurrentHashMap.put("[short", short[].class);
        concurrentHashMap.put("[int", int[].class);
        concurrentHashMap.put("[long", long[].class);
        concurrentHashMap.put("[float", float[].class);
        concurrentHashMap.put("[double", double[].class);
        concurrentHashMap.put("[boolean", boolean[].class);
        concurrentHashMap.put("[char", char[].class);
        concurrentHashMap.put("[B", byte[].class);
        concurrentHashMap.put("[S", short[].class);
        concurrentHashMap.put("[I", int[].class);
        concurrentHashMap.put("[J", long[].class);
        concurrentHashMap.put("[F", float[].class);
        concurrentHashMap.put("[D", double[].class);
        concurrentHashMap.put("[C", char[].class);
        concurrentHashMap.put("[Z", boolean[].class);
        concurrentHashMap.put("java.util.HashMap", HashMap.class);
        concurrentHashMap.put("java.util.TreeMap", TreeMap.class);
        concurrentHashMap.put("java.util.Date", Date.class);
        concurrentHashMap.put("com.alibaba.fastjson.JSONObject", JSONObject.class);
        concurrentHashMap.put("java.util.concurrent.ConcurrentHashMap", ConcurrentHashMap.class);
        concurrentHashMap.put("java.text.SimpleDateFormat", SimpleDateFormat.class);
        concurrentHashMap.put("java.lang.StackTraceElement", StackTraceElement.class);
        concurrentHashMap.put("java.lang.RuntimeException", RuntimeException.class);
    }

    public static void addMapping(String str, Class<?> cls) {
        mappings.put(str, cls);
    }

    public static final <T> T cast(Object obj, Class<T> cls, ParserConfig parserConfig) {
        return (T) cast(obj, cls, parserConfig, 0);
    }

    public static final BigDecimal castToBigDecimal(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return (BigDecimal) obj;
        }
        if (obj instanceof BigInteger) {
            return new BigDecimal((BigInteger) obj);
        }
        String obj2 = obj.toString();
        if (obj2.length() == 0 || "null".equals(obj2)) {
            return null;
        }
        return new BigDecimal(obj2);
    }

    public static final BigInteger castToBigInteger(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigInteger) {
            return (BigInteger) obj;
        }
        if (!(obj instanceof Float) && !(obj instanceof Double)) {
            String obj2 = obj.toString();
            if (obj2.length() == 0 || "null".equals(obj2)) {
                return null;
            }
            return new BigInteger(obj2);
        }
        return BigInteger.valueOf(((Number) obj).longValue());
    }

    public static final Boolean castToBoolean(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof BigDecimal) {
            return Boolean.valueOf(((BigDecimal) obj).intValueExact() == 1);
        } else if (obj instanceof Number) {
            return Boolean.valueOf(((Number) obj).intValue() == 1);
        } else {
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0 || "null".equals(str)) {
                    return null;
                }
                if (!"true".equalsIgnoreCase(str) && !"1".equals(str)) {
                    if ("false".equalsIgnoreCase(str) || "0".equals(str)) {
                        return Boolean.FALSE;
                    }
                } else {
                    return Boolean.TRUE;
                }
            }
            throw new JSONException("can not cast to int, value : " + obj);
        }
    }

    public static final Byte castToByte(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Byte.valueOf(((Number) obj).byteValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
            return Byte.valueOf(Byte.parseByte(str));
        }
        throw new JSONException("can not cast to byte, value : " + obj);
    }

    public static final byte[] castToBytes(Object obj) {
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            return JSONLexer.decodeFast(str, 0, str.length());
        }
        throw new JSONException("can not cast to int, value : " + obj);
    }

    public static final Character castToChar(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Character) {
            return (Character) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0) {
                return null;
            }
            if (str.length() == 1) {
                return Character.valueOf(str.charAt(0));
            }
            throw new JSONException("can not cast to byte, value : " + obj);
        }
        throw new JSONException("can not cast to byte, value : " + obj);
    }

    public static final Date castToDate(Object obj) {
        String str;
        long longValueExact;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Calendar) {
            return ((Calendar) obj).getTime();
        }
        if (obj instanceof Date) {
            return (Date) obj;
        }
        long j = -1;
        if (obj instanceof BigDecimal) {
            BigDecimal bigDecimal = (BigDecimal) obj;
            int scale = bigDecimal.scale();
            if (scale >= -100 && scale <= 100) {
                longValueExact = bigDecimal.longValue();
            } else {
                longValueExact = bigDecimal.longValueExact();
            }
            j = longValueExact;
        } else if (obj instanceof Number) {
            j = ((Number) obj).longValue();
        } else if (obj instanceof String) {
            String str2 = (String) obj;
            if (str2.indexOf(45) != -1) {
                if (str2.length() == JSON.DEFFAULT_DATE_FORMAT.length()) {
                    str = JSON.DEFFAULT_DATE_FORMAT;
                } else if (str2.length() == 10) {
                    str = RetryMonitorDbHelper.DATE_FORMAT;
                } else if (str2.length() == 19) {
                    str = "yyyy-MM-dd HH:mm:ss";
                } else {
                    str = (str2.length() == 29 && str2.charAt(26) == ':' && str2.charAt(28) == '0') ? "yyyy-MM-dd'T'HH:mm:ss.SSSXXX" : "yyyy-MM-dd HH:mm:ss.SSS";
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, JSON.defaultLocale);
                simpleDateFormat.setTimeZone(JSON.defaultTimeZone);
                try {
                    return simpleDateFormat.parse(str2);
                } catch (ParseException unused) {
                    throw new JSONException("can not cast to Date, value : " + str2);
                }
            } else if (str2.length() == 0 || "null".equals(str2)) {
                return null;
            } else {
                j = Long.parseLong(str2);
            }
        }
        if (j >= 0) {
            return new Date(j);
        }
        throw new JSONException("can not cast to Date, value : " + obj);
    }

    public static final Double castToDouble(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        if (obj instanceof String) {
            String obj2 = obj.toString();
            if (obj2.length() == 0 || "null".equals(obj2) || "NULL".equals(obj2)) {
                return null;
            }
            return Double.valueOf(Double.parseDouble(obj2));
        }
        throw new JSONException("can not cast to double, value : " + obj);
    }

    public static final <T> T castToEnum(Object obj, Class<T> cls, ParserConfig parserConfig) {
        try {
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0) {
                    return null;
                }
                return (T) Enum.valueOf(cls, str);
            }
            if ((obj instanceof Integer) || (obj instanceof Long)) {
                int intValue = ((Number) obj).intValue();
                T[] enumConstants = cls.getEnumConstants();
                if (intValue < enumConstants.length) {
                    return enumConstants[intValue];
                }
            }
            throw new JSONException("can not cast to : " + cls.getName());
        } catch (Exception e) {
            throw new JSONException("can not cast to : " + cls.getName(), e);
        }
    }

    public static final Float castToFloat(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Float.valueOf(((Number) obj).floatValue());
        }
        if (obj instanceof String) {
            String obj2 = obj.toString();
            if (obj2.length() == 0 || "null".equals(obj2)) {
                return null;
            }
            return Float.valueOf(Float.parseFloat(obj2));
        }
        throw new JSONException("can not cast to float, value : " + obj);
    }

    public static final Integer castToInt(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof BigDecimal) {
            BigDecimal bigDecimal = (BigDecimal) obj;
            int scale = bigDecimal.scale();
            if (scale >= -100 && scale <= 100) {
                return Integer.valueOf(bigDecimal.intValue());
            }
            return Integer.valueOf(bigDecimal.intValueExact());
        } else if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        } else {
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0 || "null".equals(str)) {
                    return null;
                }
                return Integer.valueOf(Integer.parseInt(str));
            }
            throw new JSONException("can not cast to int, value : " + obj);
        }
    }

    public static final <T> T castToJavaBean(Object obj, Class<T> cls) {
        return (T) cast(obj, (Class<Object>) cls, ParserConfig.global);
    }

    public static final Long castToLong(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            BigDecimal bigDecimal = (BigDecimal) obj;
            int scale = bigDecimal.scale();
            if (scale >= -100 && scale <= 100) {
                return Long.valueOf(bigDecimal.longValue());
            }
            return Long.valueOf(bigDecimal.longValueExact());
        } else if (obj instanceof Number) {
            return Long.valueOf(((Number) obj).longValue());
        } else {
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0 || "null".equals(str)) {
                    return null;
                }
                try {
                    return Long.valueOf(Long.parseLong(str));
                } catch (NumberFormatException unused) {
                    JSONLexer jSONLexer = new JSONLexer(str);
                    Calendar calendar = jSONLexer.scanISO8601DateIfMatch(false) ? jSONLexer.calendar : null;
                    jSONLexer.close();
                    if (calendar != null) {
                        return Long.valueOf(calendar.getTimeInMillis());
                    }
                }
            }
            throw new JSONException("can not cast to long, value : " + obj);
        }
    }

    public static final Short castToShort(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Short.valueOf(((Number) obj).shortValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
            return Short.valueOf(Short.parseShort(str));
        }
        throw new JSONException("can not cast to short, value : " + obj);
    }

    public static final String castToString(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.Class] */
    public static Type checkPrimitiveArray(GenericArrayType genericArrayType) {
        Type genericComponentType = genericArrayType.getGenericComponentType();
        String str = jn1.ARRAY_START_STR;
        while (genericComponentType instanceof GenericArrayType) {
            genericComponentType = ((GenericArrayType) genericComponentType).getGenericComponentType();
            str = str + str;
        }
        if (genericComponentType instanceof Class) {
            Class cls = (Class) genericComponentType;
            if (cls.isPrimitive()) {
                try {
                    if (cls == Boolean.TYPE) {
                        genericArrayType = Class.forName(str + "Z");
                    } else if (cls == Character.TYPE) {
                        genericArrayType = Class.forName(str + "C");
                    } else if (cls == Byte.TYPE) {
                        genericArrayType = Class.forName(str + "B");
                    } else if (cls == Short.TYPE) {
                        genericArrayType = Class.forName(str + ExifInterface.LATITUDE_SOUTH);
                    } else if (cls == Integer.TYPE) {
                        genericArrayType = Class.forName(str + "I");
                    } else if (cls == Long.TYPE) {
                        genericArrayType = Class.forName(str + "J");
                    } else if (cls == Float.TYPE) {
                        genericArrayType = Class.forName(str + UTConstant.Args.UT_SUCCESS_F);
                    } else {
                        genericArrayType = genericArrayType;
                        if (cls == Double.TYPE) {
                            genericArrayType = Class.forName(str + "D");
                        }
                    }
                } catch (ClassNotFoundException unused) {
                }
            }
        }
        return genericArrayType;
    }

    /* JADX WARN: Code restructure failed: missing block: B:200:0x0430, code lost:
        if (r0 == null) goto L176;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:287:0x05cd  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x05df  */
    /* JADX WARN: Type inference failed for: r18v15, types: [java.lang.annotation.Annotation[][]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<com.alibaba.fastjson.util.FieldInfo> computeGetters(java.lang.Class<?> r42, int r43, boolean r44, com.alibaba.fastjson.annotation.JSONType r45, java.util.Map<java.lang.String, java.lang.String> r46, boolean r47, boolean r48, boolean r49, com.alibaba.fastjson.PropertyNamingStrategy r50) {
        /*
            Method dump skipped, instructions count: 1533
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.TypeUtils.computeGetters(java.lang.Class, int, boolean, com.alibaba.fastjson.annotation.JSONType, java.util.Map, boolean, boolean, boolean, com.alibaba.fastjson.PropertyNamingStrategy):java.util.List");
    }

    public static String decapitalize(String str) {
        if (str == null || str.length() == 0 || (str.length() > 1 && Character.isUpperCase(str.charAt(1)) && Character.isUpperCase(str.charAt(0)))) {
            return str;
        }
        char[] charArray = str.toCharArray();
        charArray[0] = Character.toLowerCase(charArray[0]);
        return new String(charArray);
    }

    public static Object defaultValue(Class<?> cls) {
        if (cls == Byte.TYPE) {
            return (byte) 0;
        }
        if (cls == Short.TYPE) {
            return (short) 0;
        }
        if (cls == Integer.TYPE) {
            return 0;
        }
        if (cls == Long.TYPE) {
            return 0L;
        }
        if (cls == Float.TYPE) {
            return Float.valueOf(0.0f);
        }
        if (cls == Double.TYPE) {
            return Double.valueOf(0.0d);
        }
        if (cls == Boolean.TYPE) {
            return Boolean.FALSE;
        }
        if (cls == Character.TYPE) {
            return Character.valueOf(YKUpsConvert.CHAR_ZERO);
        }
        return null;
    }

    public static long fnv_64_lower(String str) {
        if (str == null) {
            return 0L;
        }
        long j = -3750763034362895579L;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt != '_' && charAt != '-') {
                if (charAt >= 'A' && charAt <= 'Z') {
                    charAt = (char) (charAt + ' ');
                }
                j = (j ^ charAt) * 1099511628211L;
            }
        }
        return j;
    }

    public static boolean getArgument(Type[] typeArr, TypeVariable[] typeVariableArr, Type[] typeArr2) {
        if (typeArr2 == null || typeVariableArr.length == 0) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < typeArr.length; i++) {
            Type type = typeArr[i];
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                if (getArgument(actualTypeArguments, typeVariableArr, typeArr2)) {
                    typeArr[i] = new ParameterizedTypeImpl(actualTypeArguments, parameterizedType.getOwnerType(), parameterizedType.getRawType());
                    z = true;
                }
            } else if (type instanceof TypeVariable) {
                for (int i2 = 0; i2 < typeVariableArr.length; i2++) {
                    if (type.equals(typeVariableArr[i2])) {
                        typeArr[i] = typeArr2[i2];
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public static Class<?> getClass(Type type) {
        if (type.getClass() == Class.class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return getClass(((ParameterizedType) type).getRawType());
        }
        if (type instanceof TypeVariable) {
            return (Class) ((TypeVariable) type).getBounds()[0];
        }
        if (type instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type).getUpperBounds();
            if (upperBounds.length == 1) {
                return getClass(upperBounds[0]);
            }
            return Object.class;
        }
        return Object.class;
    }

    public static Class<?> getClassFromMapping(String str) {
        return mappings.get(str);
    }

    public static Type getCollectionItemType(Type type) {
        Type type2;
        if (type instanceof ParameterizedType) {
            type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof WildcardType) {
                Type[] upperBounds = ((WildcardType) type2).getUpperBounds();
                if (upperBounds.length == 1) {
                    type2 = upperBounds[0];
                }
            }
        } else {
            if (type instanceof Class) {
                Class cls = (Class) type;
                if (!cls.getName().startsWith("java.")) {
                    type2 = getCollectionItemType(cls.getGenericSuperclass());
                }
            }
            type2 = null;
        }
        return type2 == null ? Object.class : type2;
    }

    public static Field getField(Class<?> cls, String str, Field[] fieldArr) {
        return getField(cls, str, fieldArr, null);
    }

    private static Field getField0(Class<?> cls, String str, Field[] fieldArr, Map<Class<?>, Field[]> map) {
        char charAt;
        char charAt2;
        for (Field field : fieldArr) {
            String name = field.getName();
            if (str.equals(name)) {
                return field;
            }
            if (str.length() > 2 && (charAt = str.charAt(0)) >= 'a' && charAt <= 'z' && (charAt2 = str.charAt(1)) >= 'A' && charAt2 <= 'Z' && str.equalsIgnoreCase(name)) {
                return field;
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass == null || superclass == Object.class) {
            return null;
        }
        Field[] fieldArr2 = map != null ? map.get(superclass) : null;
        if (fieldArr2 == null) {
            fieldArr2 = superclass.getDeclaredFields();
            if (map != null) {
                map.put(superclass, fieldArr2);
            }
        }
        return getField(superclass, str, fieldArr2, map);
    }

    public static Type getGenericParamType(Type type) {
        return type instanceof Class ? getGenericParamType(((Class) type).getGenericSuperclass()) : type;
    }

    public static String[] getKoltinConstructorParameters(Class cls) {
        if (kotlin_kclass_constructor == null && !kotlin_class_klass_error) {
            try {
                int i = KClassImpl.e;
                kotlin_kclass_constructor = KClassImpl.class.getConstructor(Class.class);
                kotlin_kclass_getConstructors = KClassImpl.class.getMethod("getConstructors", new Class[0]);
                kotlin_kfunction_getParameters = KFunction.class.getMethod("getParameters", new Class[0]);
                kotlin_kparameter_getName = KParameter.class.getMethod("getName", new Class[0]);
            } catch (Throwable unused) {
                kotlin_class_klass_error = true;
            }
        }
        if (kotlin_kclass_constructor == null || kotlin_error) {
            return null;
        }
        try {
            Iterator it = ((Iterable) kotlin_kclass_getConstructors.invoke(kotlin_kclass_constructor.newInstance(cls), new Object[0])).iterator();
            Object obj = null;
            while (it.hasNext()) {
                Object next = it.next();
                List list = (List) kotlin_kfunction_getParameters.invoke(next, new Object[0]);
                if (obj == null || list.size() != 0) {
                    obj = next;
                }
                it.hasNext();
            }
            List list2 = (List) kotlin_kfunction_getParameters.invoke(obj, new Object[0]);
            String[] strArr = new String[list2.size()];
            for (int i2 = 0; i2 < list2.size(); i2++) {
                strArr[i2] = (String) kotlin_kparameter_getName.invoke(list2.get(i2), new Object[0]);
            }
            return strArr;
        } catch (Throwable unused2) {
            kotlin_error = true;
            return null;
        }
    }

    public static JSONField getSupperMethodAnnotation(Class<?> cls, Method method) {
        Method[] methods;
        boolean z;
        JSONField jSONField;
        Method[] methods2;
        boolean z2;
        JSONField jSONField2;
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Method method2 : cls2.getMethods()) {
                if (method2.getName().equals(method.getName())) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    Class<?>[] parameterTypes2 = method.getParameterTypes();
                    if (parameterTypes.length != parameterTypes2.length) {
                        continue;
                    } else {
                        int i = 0;
                        while (true) {
                            if (i >= parameterTypes.length) {
                                z2 = true;
                                break;
                            } else if (!parameterTypes[i].equals(parameterTypes2[i])) {
                                z2 = false;
                                break;
                            } else {
                                i++;
                            }
                        }
                        if (z2 && (jSONField2 = (JSONField) method2.getAnnotation(JSONField.class)) != null) {
                            return jSONField2;
                        }
                    }
                }
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null && Modifier.isAbstract(superclass.getModifiers())) {
            Class<?>[] parameterTypes3 = method.getParameterTypes();
            for (Method method3 : superclass.getMethods()) {
                Class<?>[] parameterTypes4 = method3.getParameterTypes();
                if (parameterTypes4.length == parameterTypes3.length && method3.getName().equals(method.getName())) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= parameterTypes3.length) {
                            z = true;
                            break;
                        } else if (!parameterTypes4[i2].equals(parameterTypes3[i2])) {
                            z = false;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (z && (jSONField = (JSONField) method3.getAnnotation(JSONField.class)) != null) {
                        return jSONField;
                    }
                }
            }
        }
        return null;
    }

    public static boolean isGenericParamType(Type type) {
        Type genericSuperclass;
        if (type instanceof ParameterizedType) {
            return true;
        }
        return (type instanceof Class) && (genericSuperclass = ((Class) type).getGenericSuperclass()) != Object.class && isGenericParamType(genericSuperclass);
    }

    private static boolean isJSONTypeIgnore(Class<?> cls, JSONType jSONType, String str) {
        if (jSONType != null && jSONType.ignores() != null) {
            for (String str2 : jSONType.ignores()) {
                if (str.equalsIgnoreCase(str2)) {
                    return true;
                }
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        return (superclass == Object.class || superclass == null || !isJSONTypeIgnore(superclass, (JSONType) superclass.getAnnotation(JSONType.class), str)) ? false : true;
    }

    public static boolean isKotlin(Class cls) {
        if (kotlin_metadata == null && !kotlin_metadata_error) {
            try {
                kotlin_metadata = Class.forName("kotlin.Metadata");
            } catch (Throwable unused) {
                kotlin_metadata_error = true;
            }
        }
        if (kotlin_metadata == null) {
            return false;
        }
        return cls.isAnnotationPresent(kotlin_metadata);
    }

    private static boolean isKotlinIgnore(Class cls, String str) {
        String[] strArr;
        if (kotlinIgnores == null && !kotlinIgnores_error) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(Class.forName("tb.ei"), new String[]{"getEndInclusive", "isEmpty"});
                hashMap.put(Class.forName("tb.n31"), new String[]{"getEndInclusive", "isEmpty"});
                hashMap.put(Class.forName("tb.ec1"), new String[]{"getEndInclusive", "isEmpty"});
                hashMap.put(Class.forName("tb.bk"), new String[]{"getEndInclusive", "isEmpty"});
                hashMap.put(Class.forName("tb.ak"), new String[]{"getEndInclusive", "isEmpty"});
                kotlinIgnores = hashMap;
            } catch (Throwable unused) {
                kotlinIgnores_error = true;
            }
        }
        return (kotlinIgnores == null || (strArr = kotlinIgnores.get(cls)) == null || Arrays.binarySearch(strArr, str) < 0) ? false : true;
    }

    public static Class<?> loadClass(String str, ClassLoader classLoader) {
        return loadClass(str, classLoader, false);
    }

    public static double parseDouble(String str) {
        double d;
        double d2;
        int length = str.length();
        if (length > 10) {
            return Double.parseDouble(str);
        }
        long j = 0;
        boolean z = false;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt == '-' && i2 == 0) {
                z = true;
            } else if (charAt == '.') {
                if (i != 0) {
                    return Double.parseDouble(str);
                }
                i = (length - i2) - 1;
            } else if (charAt < '0' || charAt > '9') {
                return Double.parseDouble(str);
            } else {
                j = (j * 10) + (charAt - '0');
            }
        }
        if (z) {
            j = -j;
        }
        switch (i) {
            case 0:
                return j;
            case 1:
                d = j;
                d2 = 10.0d;
                break;
            case 2:
                d = j;
                d2 = 100.0d;
                break;
            case 3:
                d = j;
                d2 = 1000.0d;
                break;
            case 4:
                d = j;
                d2 = 10000.0d;
                break;
            case 5:
                d = j;
                d2 = 100000.0d;
                break;
            case 6:
                d = j;
                d2 = 1000000.0d;
                break;
            case 7:
                d = j;
                d2 = 1.0E7d;
                break;
            case 8:
                d = j;
                d2 = 1.0E8d;
                break;
            case 9:
                d = j;
                d2 = 1.0E9d;
                break;
            default:
                return Double.parseDouble(str);
        }
        return d / d2;
    }

    public static float parseFloat(String str) {
        float f;
        float f2;
        int length = str.length();
        if (length >= 10) {
            return Float.parseFloat(str);
        }
        long j = 0;
        boolean z = false;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt == '-' && i2 == 0) {
                z = true;
            } else if (charAt == '.') {
                if (i != 0) {
                    return Float.parseFloat(str);
                }
                i = (length - i2) - 1;
            } else if (charAt < '0' || charAt > '9') {
                return Float.parseFloat(str);
            } else {
                j = (j * 10) + (charAt - '0');
            }
        }
        if (z) {
            j = -j;
        }
        switch (i) {
            case 0:
                return (float) j;
            case 1:
                f = (float) j;
                f2 = 10.0f;
                break;
            case 2:
                f = (float) j;
                f2 = 100.0f;
                break;
            case 3:
                f = (float) j;
                f2 = 1000.0f;
                break;
            case 4:
                f = (float) j;
                f2 = 10000.0f;
                break;
            case 5:
                f = (float) j;
                f2 = 100000.0f;
                break;
            case 6:
                f = (float) j;
                f2 = 1000000.0f;
                break;
            case 7:
                f = (float) j;
                f2 = 1.0E7f;
                break;
            case 8:
                f = (float) j;
                f2 = 1.0E8f;
                break;
            case 9:
                f = (float) j;
                f2 = 1.0E9f;
                break;
            default:
                return Float.parseFloat(str);
        }
        return f / f2;
    }

    public static boolean setAccessible(Class<?> cls, Member member, int i) {
        if (member != null && setAccessibleEnable) {
            Class<? super Object> superclass = cls.getSuperclass();
            if ((superclass == null || superclass == Object.class) && (member.getModifiers() & 1) != 0 && (i & 1) != 0) {
                return false;
            }
            try {
                ((AccessibleObject) member).setAccessible(true);
                return true;
            } catch (AccessControlException unused) {
                setAccessibleEnable = false;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T cast(Object obj, Class<T> cls, ParserConfig parserConfig, int i) {
        T t;
        if (obj == 0) {
            return null;
        }
        if (cls != null) {
            if (cls == obj.getClass()) {
                return obj;
            }
            if (obj instanceof Map) {
                if (cls == Map.class) {
                    return obj;
                }
                Map map = (Map) obj;
                return (cls != Object.class || map.containsKey(JSON.DEFAULT_TYPE_KEY)) ? (T) castToJavaBean(map, cls, parserConfig, i) : obj;
            }
            int i2 = 0;
            if (cls.isArray()) {
                if (obj instanceof Collection) {
                    Collection<Object> collection = (Collection) obj;
                    T t2 = (T) Array.newInstance(cls.getComponentType(), collection.size());
                    for (Object obj2 : collection) {
                        Array.set(t2, i2, cast(obj2, (Class<Object>) cls.getComponentType(), parserConfig));
                        i2++;
                    }
                    return t2;
                } else if (cls == byte[].class) {
                    return (T) castToBytes(obj);
                }
            }
            if (cls.isAssignableFrom(obj.getClass())) {
                return obj;
            }
            if (cls != Boolean.TYPE && cls != Boolean.class) {
                if (cls != Byte.TYPE && cls != Byte.class) {
                    if ((cls == Character.TYPE || cls == Character.class) && (obj instanceof String)) {
                        String str = (String) obj;
                        if (str.length() == 1) {
                            return (T) Character.valueOf(str.charAt(0));
                        }
                    }
                    if (cls != Short.TYPE && cls != Short.class) {
                        if (cls != Integer.TYPE && cls != Integer.class) {
                            if (cls != Long.TYPE && cls != Long.class) {
                                if (cls != Float.TYPE && cls != Float.class) {
                                    if (cls != Double.TYPE && cls != Double.class) {
                                        if (cls == String.class) {
                                            return (T) castToString(obj);
                                        }
                                        if (cls == BigDecimal.class) {
                                            return (T) castToBigDecimal(obj);
                                        }
                                        if (cls == BigInteger.class) {
                                            return (T) castToBigInteger(obj);
                                        }
                                        if (cls == Date.class) {
                                            return (T) castToDate(obj);
                                        }
                                        if (cls.isEnum()) {
                                            return (T) castToEnum(obj, cls, parserConfig);
                                        }
                                        if (Calendar.class.isAssignableFrom(cls)) {
                                            Date castToDate = castToDate(obj);
                                            if (cls == Calendar.class) {
                                                t = (T) Calendar.getInstance(JSON.defaultTimeZone, JSON.defaultLocale);
                                            } else {
                                                try {
                                                    t = (T) ((Calendar) cls.newInstance());
                                                } catch (Exception e) {
                                                    throw new JSONException("can not cast to : " + cls.getName(), e);
                                                }
                                            }
                                            ((Calendar) t).setTime(castToDate);
                                            return t;
                                        }
                                        if (obj instanceof String) {
                                            String str2 = (String) obj;
                                            if (str2.length() == 0 || "null".equals(str2)) {
                                                return null;
                                            }
                                            if (cls == Currency.class) {
                                                return (T) Currency.getInstance(str2);
                                            }
                                        }
                                        throw new JSONException("can not cast to : " + cls.getName());
                                    }
                                    return (T) castToDouble(obj);
                                }
                                return (T) castToFloat(obj);
                            }
                            return (T) castToLong(obj);
                        }
                        return (T) castToInt(obj);
                    }
                    return (T) castToShort(obj);
                }
                return (T) castToByte(obj);
            }
            return (T) castToBoolean(obj);
        }
        throw new IllegalArgumentException("clazz is null");
    }

    public static final <T> T castToJavaBean(Map<String, Object> map, Class<T> cls, ParserConfig parserConfig) {
        return (T) castToJavaBean(map, cls, parserConfig, 0);
    }

    public static Field getField(Class<?> cls, String str, Field[] fieldArr, Map<Class<?>, Field[]> map) {
        Field field0 = getField0(cls, str, fieldArr, map);
        if (field0 == null) {
            field0 = getField0(cls, JSMethod.NOT_SET + str, fieldArr, map);
        }
        if (field0 == null) {
            field0 = getField0(cls, "m_" + str, fieldArr, map);
        }
        if (field0 == null) {
            return getField0(cls, WXComponent.PROP_FS_MATCH_PARENT + str.substring(0, 1).toUpperCase() + str.substring(1), fieldArr, map);
        }
        return field0;
    }

    public static Class<?> loadClass(String str, ClassLoader classLoader, boolean z) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.length() < 256) {
            ConcurrentMap<String, Class<?>> concurrentMap = mappings;
            Class<?> cls = concurrentMap.get(str);
            if (cls != null) {
                return cls;
            }
            if (str.charAt(0) == '[') {
                Class<?> loadClass = loadClass(str.substring(1), classLoader, false);
                if (loadClass == null) {
                    return null;
                }
                return Array.newInstance(loadClass, 0).getClass();
            } else if (str.startsWith("L") && str.endsWith(";")) {
                return loadClass(str.substring(1, str.length() - 1), classLoader, false);
            } else {
                if (classLoader != null) {
                    try {
                        cls = classLoader.loadClass(str);
                        if (z) {
                            concurrentMap.put(str, cls);
                        }
                        return cls;
                    } catch (Exception unused) {
                    }
                }
                try {
                    ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
                    if (contextClassLoader != null && contextClassLoader != classLoader) {
                        Class<?> loadClass2 = contextClassLoader.loadClass(str);
                        if (z) {
                            try {
                                mappings.put(str, loadClass2);
                            } catch (Exception unused2) {
                                cls = loadClass2;
                            }
                        }
                        return loadClass2;
                    }
                } catch (Exception unused3) {
                }
                try {
                    cls = Class.forName(str);
                    mappings.put(str, cls);
                    return cls;
                } catch (Exception unused4) {
                    return cls;
                }
            }
        }
        throw new JSONException("className too long. " + str);
    }

    public static final <T> T castToJavaBean(Map<String, Object> map, Class<T> cls, ParserConfig parserConfig, int i) {
        JSONObject jSONObject;
        int i2 = 0;
        try {
            if (cls == StackTraceElement.class) {
                String str = (String) map.get(PushClientConstants.TAG_CLASS_NAME);
                String str2 = (String) map.get("methodName");
                String str3 = (String) map.get("fileName");
                Number number = (Number) map.get("lineNumber");
                if (number != null) {
                    if (number instanceof BigDecimal) {
                        i2 = ((BigDecimal) number).intValueExact();
                    } else {
                        i2 = number.intValue();
                    }
                }
                return (T) new StackTraceElement(str, str2, str3, i2);
            }
            Object obj = map.get(JSON.DEFAULT_TYPE_KEY);
            if (obj instanceof String) {
                String str4 = (String) obj;
                if (parserConfig == null) {
                    parserConfig = ParserConfig.global;
                }
                Class<?> checkAutoType = parserConfig.checkAutoType(str4, null, i);
                if (checkAutoType != null) {
                    if (!checkAutoType.equals(cls)) {
                        return (T) castToJavaBean(map, checkAutoType, parserConfig, i);
                    }
                } else {
                    throw new ClassNotFoundException(str4 + " not found");
                }
            }
            if (cls.isInterface()) {
                if (map instanceof JSONObject) {
                    jSONObject = (JSONObject) map;
                } else {
                    jSONObject = new JSONObject(map);
                }
                if (parserConfig == null) {
                    parserConfig = ParserConfig.getGlobalInstance();
                }
                return parserConfig.getDeserializer(cls) != null ? (T) JSON.parseObject(JSON.toJSONString(jSONObject), cls) : (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, jSONObject);
            } else if (cls == String.class && (map instanceof JSONObject)) {
                return (T) map.toString();
            } else {
                if (parserConfig == null) {
                    parserConfig = ParserConfig.global;
                }
                ObjectDeserializer deserializer = parserConfig.getDeserializer(cls);
                JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) deserializer : null;
                if (javaBeanDeserializer != null) {
                    return (T) javaBeanDeserializer.createInstance(map, parserConfig);
                }
                throw new JSONException("can not get javaBeanDeserializer");
            }
        } catch (Exception e) {
            throw new JSONException(e.getMessage(), e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T cast(Object obj, Type type, ParserConfig parserConfig) {
        if (obj == 0) {
            return null;
        }
        if (type instanceof Class) {
            return (T) cast(obj, (Class) type, parserConfig, 0);
        }
        if (type instanceof ParameterizedType) {
            return (T) cast(obj, (ParameterizedType) type, parserConfig);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
        }
        if (type instanceof TypeVariable) {
            return obj;
        }
        throw new JSONException("can not cast to : " + type);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r8v9, types: [T, java.util.Map, java.util.HashMap] */
    public static final <T> T cast(Object obj, ParameterizedType parameterizedType, ParserConfig parserConfig) {
        Object cast;
        T t;
        Object cast2;
        Type rawType = parameterizedType.getRawType();
        if (rawType == List.class || rawType == ArrayList.class) {
            Type type = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof List) {
                List list = (List) obj;
                int size = list.size();
                ?? r0 = (T) new ArrayList(size);
                for (int i = 0; i < size; i++) {
                    Object obj2 = list.get(i);
                    if (type instanceof Class) {
                        if (obj2 != null && obj2.getClass() == JSONObject.class) {
                            cast = ((JSONObject) obj2).toJavaObject((Class) type, parserConfig, 0);
                        } else {
                            cast = cast(obj2, (Class) type, parserConfig, 0);
                        }
                    } else {
                        cast = cast(obj2, type, parserConfig);
                    }
                    r0.add(cast);
                }
                return r0;
            }
        }
        if (rawType == Set.class || rawType == HashSet.class || rawType == TreeSet.class || rawType == List.class || rawType == ArrayList.class) {
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof Iterable) {
                if (rawType != Set.class && rawType != HashSet.class) {
                    if (rawType == TreeSet.class) {
                        t = (T) new TreeSet();
                    } else {
                        t = (T) new ArrayList();
                    }
                } else {
                    t = (T) new HashSet();
                }
                for (T t2 : (Iterable) obj) {
                    if (type2 instanceof Class) {
                        if (t2 != null && t2.getClass() == JSONObject.class) {
                            cast2 = ((JSONObject) t2).toJavaObject((Class) type2, parserConfig, 0);
                        } else {
                            cast2 = cast(t2, (Class) type2, parserConfig, 0);
                        }
                    } else {
                        cast2 = cast(t2, type2, parserConfig);
                    }
                    ((Collection) t).add(cast2);
                }
                return t;
            }
        }
        if (rawType == Map.class || rawType == HashMap.class) {
            Type type3 = parameterizedType.getActualTypeArguments()[0];
            Type type4 = parameterizedType.getActualTypeArguments()[1];
            if (obj instanceof Map) {
                ?? r8 = (T) new HashMap();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    r8.put(cast(entry.getKey(), type3, parserConfig), cast(entry.getValue(), type4, parserConfig));
                }
                return r8;
            }
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
        }
        if (parameterizedType.getActualTypeArguments().length == 1 && (parameterizedType.getActualTypeArguments()[0] instanceof WildcardType)) {
            return (T) cast(obj, rawType, parserConfig);
        }
        throw new JSONException("can not cast to : " + parameterizedType);
    }
}
