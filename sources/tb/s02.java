package tb;

import java.lang.reflect.Type;
import kotlin.jvm.JvmName;
import kotlin.reflect.KType;
import kotlin.reflect.TypesJVMKt;
import kotlin.reflect.jvm.internal.KTypeImpl;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmName(name = "ReflectJvmMapping")
/* loaded from: classes3.dex */
public final class s02 {
    @NotNull
    public static final Type a(@NotNull KType kType) {
        b41.i(kType, "$this$javaType");
        Type javaType = ((KTypeImpl) kType).getJavaType();
        return javaType != null ? javaType : TypesJVMKt.f(kType);
    }
}
