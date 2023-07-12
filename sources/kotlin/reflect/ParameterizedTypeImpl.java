package kotlin.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.ExperimentalStdlibApi;
import kotlin.collections.ArraysKt___ArraysKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.jn1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
@ExperimentalStdlibApi
/* loaded from: classes3.dex */
public final class ParameterizedTypeImpl implements ParameterizedType, TypeImpl {
    @NotNull
    private final Class<?> a;
    @Nullable
    private final Type b;
    @NotNull
    private final Type[] c;

    public ParameterizedTypeImpl(@NotNull Class<?> cls, @Nullable Type type, @NotNull List<? extends Type> list) {
        b41.i(cls, "rawType");
        b41.i(list, "typeArguments");
        this.a = cls;
        this.b = type;
        Object[] array = list.toArray(new Type[0]);
        b41.g(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        this.c = (Type[]) array;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            if (b41.d(this.a, parameterizedType.getRawType()) && b41.d(this.b, parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.ParameterizedType
    @NotNull
    public Type[] getActualTypeArguments() {
        return this.c;
    }

    @Override // java.lang.reflect.ParameterizedType
    @Nullable
    public Type getOwnerType() {
        return this.b;
    }

    @Override // java.lang.reflect.ParameterizedType
    @NotNull
    public Type getRawType() {
        return this.a;
    }

    @Override // java.lang.reflect.Type, kotlin.reflect.TypeImpl
    @NotNull
    public String getTypeName() {
        String h;
        String h2;
        StringBuilder sb = new StringBuilder();
        Type type = this.b;
        if (type != null) {
            h2 = TypesJVMKt.h(type);
            sb.append(h2);
            sb.append("$");
            sb.append(this.a.getSimpleName());
        } else {
            h = TypesJVMKt.h(this.a);
            sb.append(h);
        }
        Type[] typeArr = this.c;
        if (!(typeArr.length == 0)) {
            ArraysKt___ArraysKt.D(typeArr, sb, null, jn1.L, jn1.G, 0, null, ParameterizedTypeImpl$getTypeName$1$1.INSTANCE, 50, null);
        }
        String sb2 = sb.toString();
        b41.h(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public int hashCode() {
        int hashCode = this.a.hashCode();
        Type type = this.b;
        return (hashCode ^ (type != null ? type.hashCode() : 0)) ^ Arrays.hashCode(getActualTypeArguments());
    }

    @NotNull
    public String toString() {
        return getTypeName();
    }
}
