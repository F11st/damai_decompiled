package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.ArrayCodec;
import com.alibaba.fastjson.serializer.BigDecimalCodec;
import com.alibaba.fastjson.serializer.BooleanCodec;
import com.alibaba.fastjson.serializer.CollectionCodec;
import com.alibaba.fastjson.serializer.DateCodec;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.MiscCodec;
import com.alibaba.fastjson.serializer.NumberCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.IdentityHashMap;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class ParserConfig {
    private static long[] denyList = {-7600952144447537354L, -4082057040235125754L, -2364987994247679115L, -676156662527871184L, -254670111376247151L, 1502845958873959152L, 4147696707147271408L, 5347909877633654828L, 5751393439502795295L, 7702607466162283393L};
    public static ParserConfig global = new ParserConfig();
    public boolean autoTypeSupport;
    public ClassLoader defaultClassLoader;
    private final IdentityHashMap<ObjectDeserializer> deserializers;
    public PropertyNamingStrategy propertyNamingStrategy;
    public final SymbolTable symbolTable;

    public ParserConfig() {
        IdentityHashMap<ObjectDeserializer> identityHashMap = new IdentityHashMap<>(1024);
        this.deserializers = identityHashMap;
        this.symbolTable = new SymbolTable(16384);
        MiscCodec miscCodec = MiscCodec.instance;
        identityHashMap.put(SimpleDateFormat.class, miscCodec);
        DateCodec dateCodec = DateCodec.instance;
        identityHashMap.put(Date.class, dateCodec);
        identityHashMap.put(Calendar.class, dateCodec);
        identityHashMap.put(Map.class, MapDeserializer.instance);
        identityHashMap.put(HashMap.class, MapDeserializer.instance);
        identityHashMap.put(LinkedHashMap.class, MapDeserializer.instance);
        identityHashMap.put(TreeMap.class, MapDeserializer.instance);
        identityHashMap.put(ConcurrentMap.class, MapDeserializer.instance);
        identityHashMap.put(ConcurrentHashMap.class, MapDeserializer.instance);
        CollectionCodec collectionCodec = CollectionCodec.instance;
        identityHashMap.put(Collection.class, collectionCodec);
        identityHashMap.put(List.class, collectionCodec);
        identityHashMap.put(ArrayList.class, collectionCodec);
        JavaObjectDeserializer javaObjectDeserializer = JavaObjectDeserializer.instance;
        identityHashMap.put(Object.class, javaObjectDeserializer);
        identityHashMap.put(String.class, StringCodec.instance);
        identityHashMap.put(Character.TYPE, miscCodec);
        identityHashMap.put(Character.class, miscCodec);
        Class cls = Byte.TYPE;
        NumberCodec numberCodec = NumberCodec.instance;
        identityHashMap.put(cls, numberCodec);
        identityHashMap.put(Byte.class, numberCodec);
        identityHashMap.put(Short.TYPE, numberCodec);
        identityHashMap.put(Short.class, numberCodec);
        identityHashMap.put(Integer.TYPE, IntegerCodec.instance);
        identityHashMap.put(Integer.class, IntegerCodec.instance);
        identityHashMap.put(Long.TYPE, IntegerCodec.instance);
        identityHashMap.put(Long.class, IntegerCodec.instance);
        BigDecimalCodec bigDecimalCodec = BigDecimalCodec.instance;
        identityHashMap.put(BigInteger.class, bigDecimalCodec);
        identityHashMap.put(BigDecimal.class, bigDecimalCodec);
        identityHashMap.put(Float.TYPE, numberCodec);
        identityHashMap.put(Float.class, numberCodec);
        identityHashMap.put(Double.TYPE, numberCodec);
        identityHashMap.put(Double.class, numberCodec);
        Class cls2 = Boolean.TYPE;
        BooleanCodec booleanCodec = BooleanCodec.instance;
        identityHashMap.put(cls2, booleanCodec);
        identityHashMap.put(Boolean.class, booleanCodec);
        identityHashMap.put(Class.class, miscCodec);
        ArrayCodec arrayCodec = ArrayCodec.instance;
        identityHashMap.put(char[].class, arrayCodec);
        identityHashMap.put(Object[].class, arrayCodec);
        identityHashMap.put(UUID.class, miscCodec);
        identityHashMap.put(TimeZone.class, miscCodec);
        identityHashMap.put(Locale.class, miscCodec);
        identityHashMap.put(Currency.class, miscCodec);
        identityHashMap.put(URI.class, miscCodec);
        identityHashMap.put(URL.class, miscCodec);
        identityHashMap.put(Pattern.class, miscCodec);
        identityHashMap.put(Charset.class, miscCodec);
        identityHashMap.put(Number.class, numberCodec);
        identityHashMap.put(StackTraceElement.class, miscCodec);
        identityHashMap.put(Serializable.class, javaObjectDeserializer);
        identityHashMap.put(Cloneable.class, javaObjectDeserializer);
        identityHashMap.put(Comparable.class, javaObjectDeserializer);
        identityHashMap.put(Closeable.class, javaObjectDeserializer);
    }

    public static ParserConfig getGlobalInstance() {
        return global;
    }

    public static boolean isPrimitive(Class<?> cls) {
        return cls.isPrimitive() || cls == Boolean.class || cls == Character.class || cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == BigInteger.class || cls == BigDecimal.class || cls == String.class || cls == Date.class || cls == java.sql.Date.class || cls == Time.class || cls == Timestamp.class;
    }

    public Class<?> checkAutoType(String str, Class<?> cls, int i) {
        if (str == null) {
            return null;
        }
        if (str.length() < 128) {
            if (str.length() >= 3) {
                long charAt = (str.charAt(0) ^ (-3750763034362895579L)) * 1099511628211L;
                if (charAt != -5808493101479473382L) {
                    if ((charAt ^ str.charAt(str.length() - 1)) * 1099511628211L != 655701488918567152L) {
                        long charAt2 = (((((str.charAt(0) ^ (-3750763034362895579L)) * 1099511628211L) ^ str.charAt(1)) * 1099511628211L) ^ str.charAt(2)) * 1099511628211L;
                        for (int i2 = 3; i2 < str.length(); i2++) {
                            charAt2 = (charAt2 ^ str.charAt(i2)) * 1099511628211L;
                            if (Arrays.binarySearch(denyList, charAt2) >= 0 && TypeUtils.getClassFromMapping(str) == null) {
                                throw new JSONException("autoType is not support. " + str);
                            }
                        }
                        Class<?> classFromMapping = TypeUtils.getClassFromMapping(str);
                        if (classFromMapping != null) {
                            return classFromMapping;
                        }
                        Class<?> findClass = this.deserializers.findClass(str);
                        if (findClass != null) {
                            return findClass;
                        }
                        Class<?> loadClass = TypeUtils.loadClass(str, this.defaultClassLoader, false);
                        if (loadClass != null && cls != null && loadClass != HashMap.class) {
                            if (cls.isAssignableFrom(loadClass)) {
                                TypeUtils.addMapping(str, loadClass);
                                return loadClass;
                            }
                            throw new JSONException("type not match. " + str + " -> " + cls.getName());
                        } else if (loadClass.isAnnotationPresent(JSONType.class)) {
                            TypeUtils.addMapping(str, loadClass);
                            return loadClass;
                        } else {
                            int i3 = Feature.SupportAutoType.mask;
                            if ((i & i3) == 0 && (i3 & JSON.DEFAULT_PARSER_FEATURE) == 0 && !this.autoTypeSupport) {
                                throw new JSONException("autoType is not support : " + str);
                            }
                            TypeUtils.addMapping(str, loadClass);
                            return loadClass;
                        }
                    }
                    throw new JSONException("autoType is not support. " + str);
                }
                throw new JSONException("autoType is not support. " + str);
            }
        }
        throw new JSONException("autoType is not support. " + str);
    }

    public boolean containsKey(Class cls) {
        return this.deserializers.get(cls) != null;
    }

    public FieldDeserializer createFieldDeserializer(ParserConfig parserConfig, Class<?> cls, FieldInfo fieldInfo) {
        Class<?> cls2 = fieldInfo.fieldClass;
        if (cls2 != List.class && cls2 != ArrayList.class && (!cls2.isArray() || cls2.getComponentType().isPrimitive())) {
            return new DefaultFieldDeserializer(parserConfig, cls, fieldInfo);
        }
        return new ListTypeFieldDeserializer(parserConfig, cls, fieldInfo);
    }

    public ObjectDeserializer getDeserializer(Type type) {
        ObjectDeserializer objectDeserializer = this.deserializers.get(type);
        if (objectDeserializer != null) {
            return objectDeserializer;
        }
        if (type instanceof Class) {
            return getDeserializer((Class) type, type);
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            if (rawType instanceof Class) {
                return getDeserializer((Class) rawType, type);
            }
            return getDeserializer(rawType);
        }
        if (type instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type).getUpperBounds();
            if (upperBounds.length == 1) {
                return getDeserializer(upperBounds[0]);
            }
        }
        return JavaObjectDeserializer.instance;
    }

    public void putDeserializer(Type type, ObjectDeserializer objectDeserializer) {
        this.deserializers.put(type, objectDeserializer);
    }

    public ObjectDeserializer registerIfNotExists(Class<?> cls) {
        return registerIfNotExists(cls, cls.getModifiers(), false, true, true, true);
    }

    public ObjectDeserializer registerIfNotExists(Class<?> cls, int i, boolean z, boolean z2, boolean z3, boolean z4) {
        ObjectDeserializer objectDeserializer = this.deserializers.get(cls);
        if (objectDeserializer != null) {
            return objectDeserializer;
        }
        JavaBeanDeserializer javaBeanDeserializer = new JavaBeanDeserializer(this, cls, cls, JavaBeanInfo.build(cls, i, cls, z, z2, z3, z4, this.propertyNamingStrategy));
        putDeserializer(cls, javaBeanDeserializer);
        return javaBeanDeserializer;
    }

    public ObjectDeserializer getDeserializer(Class<?> cls, Type type) {
        ObjectDeserializer objectDeserializer;
        JSONType jSONType;
        Class<?> mappingTo;
        ObjectDeserializer objectDeserializer2 = this.deserializers.get(type);
        if (objectDeserializer2 != null) {
            return objectDeserializer2;
        }
        if (type == null) {
            type = cls;
        }
        ObjectDeserializer objectDeserializer3 = this.deserializers.get(type);
        if (objectDeserializer3 != null) {
            return objectDeserializer3;
        }
        if (!isPrimitive(cls) && (jSONType = (JSONType) cls.getAnnotation(JSONType.class)) != null && (mappingTo = jSONType.mappingTo()) != Void.class) {
            return getDeserializer(mappingTo, mappingTo);
        }
        if ((type instanceof WildcardType) || (type instanceof TypeVariable) || (type instanceof ParameterizedType)) {
            objectDeserializer3 = this.deserializers.get(cls);
        }
        if (objectDeserializer3 != null) {
            return objectDeserializer3;
        }
        ObjectDeserializer objectDeserializer4 = this.deserializers.get(type);
        if (objectDeserializer4 != null) {
            return objectDeserializer4;
        }
        if (cls.isEnum()) {
            objectDeserializer = new EnumDeserializer(cls);
        } else if (cls.isArray()) {
            objectDeserializer = ArrayCodec.instance;
        } else if (cls != Set.class && cls != HashSet.class && cls != Collection.class && cls != List.class && cls != ArrayList.class) {
            if (Collection.class.isAssignableFrom(cls)) {
                objectDeserializer = CollectionCodec.instance;
            } else if (Map.class.isAssignableFrom(cls)) {
                objectDeserializer = MapDeserializer.instance;
            } else if (Throwable.class.isAssignableFrom(cls)) {
                objectDeserializer = new ThrowableDeserializer(this, cls);
            } else if (cls.getName().equals("android.net.Uri")) {
                objectDeserializer = MiscCodec.instance;
            } else {
                objectDeserializer = new JavaBeanDeserializer(this, cls, type);
            }
        } else {
            objectDeserializer = CollectionCodec.instance;
        }
        putDeserializer(type, objectDeserializer);
        return objectDeserializer;
    }
}
