package kotlin.reflect;

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import kotlin.ExperimentalStdlibApi;
import kotlin.NotImplementedError;
import kotlin.collections.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
@ExperimentalStdlibApi
/* loaded from: classes3.dex */
public final class b implements TypeVariable<GenericDeclaration>, TypeImpl {
    @NotNull
    private final KTypeParameter a;

    public b(@NotNull KTypeParameter kTypeParameter) {
        b41.i(kTypeParameter, "typeParameter");
        this.a = kTypeParameter;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) obj;
            if (b41.d(getName(), typeVariable.getName()) && b41.d(getGenericDeclaration(), typeVariable.getGenericDeclaration())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.TypeVariable
    @NotNull
    public Type[] getBounds() {
        int q;
        Type c;
        List<KType> upperBounds = this.a.getUpperBounds();
        q = n.q(upperBounds, 10);
        ArrayList arrayList = new ArrayList(q);
        for (KType kType : upperBounds) {
            c = TypesJVMKt.c(kType, true);
            arrayList.add(c);
        }
        Object[] array = arrayList.toArray(new Type[0]);
        b41.g(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (Type[]) array;
    }

    @Override // java.lang.reflect.TypeVariable
    @NotNull
    public GenericDeclaration getGenericDeclaration() {
        throw new NotImplementedError("An operation is not implemented: " + ("getGenericDeclaration() is not yet supported for type variables created from KType: " + this.a));
    }

    @Override // java.lang.reflect.TypeVariable
    @NotNull
    public String getName() {
        return this.a.getName();
    }

    @Override // java.lang.reflect.Type, kotlin.reflect.TypeImpl
    @NotNull
    public String getTypeName() {
        return getName();
    }

    public int hashCode() {
        return getName().hashCode() ^ getGenericDeclaration().hashCode();
    }

    @NotNull
    public String toString() {
        return getTypeName();
    }
}
