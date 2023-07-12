package com.youku.gaiax.js.support;

import androidx.exifinterface.media.ExifInterface;
import com.ali.user.mobile.app.constant.UTConstant;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.youku.gaiax.js.support.Types;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import tb.jn1;
import tb.r10;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class GaiaXMethod {
    public final String name;
    public final Type[] parameterTypes;
    public final Type returnType;

    public GaiaXMethod(Type type, String str, Type[] typeArr) {
        this.returnType = canonicalize(type);
        this.name = str;
        this.parameterTypes = new Type[typeArr.length];
        for (int i = 0; i < typeArr.length; i++) {
            this.parameterTypes[i] = canonicalize(typeArr[i]);
        }
    }

    private static Type canonicalize(Type type) {
        return Types.removeSubtypeWildcard(Types.canonicalize(type));
    }

    public static GaiaXMethod create(Type type, Method method) {
        Class<?> rawType = Types.getRawType(type);
        Type resolve = Types.resolve(type, rawType, method.getGenericReturnType());
        if (resolve instanceof TypeVariable) {
            return null;
        }
        String name = method.getName();
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        int length = genericParameterTypes.length;
        Type[] typeArr = new Type[length];
        for (int i = 0; i < length; i++) {
            typeArr[i] = Types.resolve(type, rawType, genericParameterTypes[i]);
            if (typeArr[i] instanceof TypeVariable) {
                return null;
            }
        }
        return new GaiaXMethod(resolve, name, typeArr);
    }

    private static String getTypeSignature(Type type) {
        if (type instanceof Types.GenericArrayTypeImpl) {
            return jn1.ARRAY_START_STR + getTypeSignature(((Types.GenericArrayTypeImpl) type).getGenericComponentType());
        }
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            if (type == Void.TYPE) {
                return "V";
            }
            if (type == Boolean.TYPE) {
                return "Z";
            }
            if (type == Byte.TYPE) {
                return "B";
            }
            if (type == Character.TYPE) {
                return "C";
            }
            if (type == Short.TYPE) {
                return ExifInterface.LATITUDE_SOUTH;
            }
            if (type == Integer.TYPE) {
                return "I";
            }
            if (type == Long.TYPE) {
                return "J";
            }
            if (type == Float.TYPE) {
                return UTConstant.Args.UT_SUCCESS_F;
            }
            if (type == Double.TYPE) {
                return "D";
            }
        }
        String name = Types.getRawType(type).getName();
        StringBuilder sb = new StringBuilder(name.length() + 2);
        sb.append("L");
        for (int i = 0; i < name.length(); i++) {
            char charAt = name.charAt(i);
            if (charAt == '.') {
                charAt = r10.DIR;
            }
            sb.append(charAt);
        }
        sb.append(";");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj instanceof GaiaXMethod) {
            GaiaXMethod gaiaXMethod = (GaiaXMethod) obj;
            return this.returnType.equals(gaiaXMethod.returnType) && this.name.equals(gaiaXMethod.name) && Arrays.equals(this.parameterTypes, gaiaXMethod.parameterTypes);
        }
        return false;
    }

    String getSignature() {
        StringBuilder sb = new StringBuilder();
        sb.append(jn1.BRACKET_START_STR);
        for (Type type : this.parameterTypes) {
            sb.append(getTypeSignature(type));
        }
        sb.append(jn1.BRACKET_END_STR);
        sb.append(getTypeSignature(this.returnType));
        return sb.toString();
    }

    public int hashCode() {
        return ((((this.returnType.hashCode() + 31) * 31) + this.name.hashCode()) * 31) + Arrays.hashCode(this.parameterTypes);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.returnType);
        sb.append(" ");
        sb.append(this.name);
        sb.append(jn1.BRACKET_START_STR);
        for (int i = 0; i < this.parameterTypes.length; i++) {
            if (i != 0) {
                sb.append(AVFSCacheConstants.COMMA_SEP);
            }
            sb.append(this.parameterTypes[i]);
        }
        sb.append(jn1.BRACKET_END_STR);
        return sb.toString();
    }
}
