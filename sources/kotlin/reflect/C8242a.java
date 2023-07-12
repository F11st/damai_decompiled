package kotlin.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import kotlin.ExperimentalStdlibApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
@ExperimentalStdlibApi
/* renamed from: kotlin.reflect.a */
/* loaded from: classes3.dex */
public final class C8242a implements GenericArrayType, TypeImpl {
    @NotNull
    private final Type a;

    public C8242a(@NotNull Type type) {
        b41.i(type, "elementType");
        this.a = type;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof GenericArrayType) && b41.d(getGenericComponentType(), ((GenericArrayType) obj).getGenericComponentType());
    }

    @Override // java.lang.reflect.GenericArrayType
    @NotNull
    public Type getGenericComponentType() {
        return this.a;
    }

    @Override // java.lang.reflect.Type, kotlin.reflect.TypeImpl
    @NotNull
    public String getTypeName() {
        String h;
        StringBuilder sb = new StringBuilder();
        h = TypesJVMKt.h(this.a);
        sb.append(h);
        sb.append("[]");
        return sb.toString();
    }

    public int hashCode() {
        return getGenericComponentType().hashCode();
    }

    @NotNull
    public String toString() {
        return getTypeName();
    }
}
