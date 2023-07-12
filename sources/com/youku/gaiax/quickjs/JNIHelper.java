package com.youku.gaiax.quickjs;

import androidx.annotation.Keep;
import com.youku.gaiax.quickjs.adapter.TypeAdapter;
import java.lang.reflect.Type;

/* compiled from: Taobao */
@Keep
/* loaded from: classes2.dex */
class JNIHelper {
    private static final Type VOID_PRIMITIVE_TYPE = Void.TYPE;
    private static final Type CHAR_PRIMITIVE_TYPE = Character.TYPE;
    private static final Type BOOLEAN_PRIMITIVE_TYPE = Boolean.TYPE;
    private static final Type BYTE_PRIMITIVE_TYPE = Byte.TYPE;
    private static final Type SHORT_PRIMITIVE_TYPE = Short.TYPE;
    private static final Type INT_PRIMITIVE_TYPE = Integer.TYPE;
    private static final Type LONG_PRIMITIVE_TYPE = Long.TYPE;
    private static final Type FLOAT_PRIMITIVE_TYPE = Float.TYPE;
    private static final Type DOUBLE_PRIMITIVE_TYPE = Double.TYPE;

    JNIHelper() {
    }

    private static boolean isPrimitiveType(Type type) {
        return (type instanceof Class) && ((Class) type).isPrimitive();
    }

    private static boolean isSameType(Type type, Type type2) {
        return type == type2 || (type != null && type.equals(type2));
    }

    private static long javaValueToJSValue(JSContext jSContext, Type type, boolean z) {
        return javaValueToJSValue(jSContext, type, Boolean.valueOf(z));
    }

    private static Object jsValueToJavaValue(JSContext jSContext, Type type, long j) {
        Object fromJSValue;
        synchronized (jSContext.jsRuntime) {
            jSContext.checkClosed();
            TypeAdapter adapter = jSContext.quickJS.getAdapter(type);
            JSValue wrapAsJSValue = jSContext.wrapAsJSValue(j);
            fromJSValue = adapter.fromJSValue(jSContext.quickJS, jSContext, wrapAsJSValue);
            if (wrapAsJSValue == null) {
                QuickJS.destroyValue(jSContext.pointer, j);
            }
        }
        return fromJSValue;
    }

    private static boolean unbox(Boolean bool) {
        return bool.booleanValue();
    }

    private static long javaValueToJSValue(JSContext jSContext, Type type, char c) {
        return javaValueToJSValue(jSContext, type, Character.valueOf(c));
    }

    private static char unbox(Character ch) {
        return ch.charValue();
    }

    private static long javaValueToJSValue(JSContext jSContext, Type type, byte b) {
        return javaValueToJSValue(jSContext, type, Byte.valueOf(b));
    }

    private static byte unbox(Byte b) {
        return b.byteValue();
    }

    private static long javaValueToJSValue(JSContext jSContext, Type type, short s) {
        return javaValueToJSValue(jSContext, type, Short.valueOf(s));
    }

    private static short unbox(Short sh) {
        return sh.shortValue();
    }

    private static long javaValueToJSValue(JSContext jSContext, Type type, int i) {
        return javaValueToJSValue(jSContext, type, Integer.valueOf(i));
    }

    private static int unbox(Integer num) {
        return num.intValue();
    }

    private static long javaValueToJSValue(JSContext jSContext, Type type, long j) {
        return javaValueToJSValue(jSContext, type, Long.valueOf(j));
    }

    private static long unbox(Long l) {
        return l.longValue();
    }

    private static long javaValueToJSValue(JSContext jSContext, Type type, float f) {
        return javaValueToJSValue(jSContext, type, Float.valueOf(f));
    }

    private static float unbox(Float f) {
        return f.floatValue();
    }

    private static long javaValueToJSValue(JSContext jSContext, Type type, double d) {
        return javaValueToJSValue(jSContext, type, Double.valueOf(d));
    }

    private static double unbox(Double d) {
        return d.doubleValue();
    }

    private static long javaValueToJSValue(JSContext jSContext, Type type, Object obj) {
        long j;
        synchronized (jSContext.jsRuntime) {
            jSContext.checkClosed();
            j = jSContext.quickJS.getAdapter(type).toJSValue(jSContext.quickJS, jSContext, obj).pointer;
        }
        return j;
    }
}
