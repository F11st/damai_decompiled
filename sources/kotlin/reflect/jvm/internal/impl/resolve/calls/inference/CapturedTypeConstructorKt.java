package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.n;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.br2;
import tb.h21;
import tb.kg;
import tb.n60;
import tb.z71;
import tb.zq2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class CapturedTypeConstructorKt {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a extends n60 {
        final /* synthetic */ boolean b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(boolean z, br2 br2Var) {
            super(br2Var);
            this.b = z;
        }

        @Override // tb.br2
        public boolean b() {
            return this.b;
        }

        @Override // tb.n60, tb.br2
        @Nullable
        public TypeProjection e(@NotNull z71 z71Var) {
            b41.i(z71Var, "key");
            TypeProjection e = super.e(z71Var);
            if (e == null) {
                return null;
            }
            ClassifierDescriptor declarationDescriptor = z71Var.c().getDeclarationDescriptor();
            return CapturedTypeConstructorKt.b(e, declarationDescriptor instanceof TypeParameterDescriptor ? (TypeParameterDescriptor) declarationDescriptor : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TypeProjection b(final TypeProjection typeProjection, TypeParameterDescriptor typeParameterDescriptor) {
        if (typeParameterDescriptor == null || typeProjection.getProjectionKind() == Variance.INVARIANT) {
            return typeProjection;
        }
        if (typeParameterDescriptor.getVariance() == typeProjection.getProjectionKind()) {
            if (typeProjection.isStarProjection()) {
                StorageManager storageManager = LockBasedStorageManager.NO_LOCKS;
                b41.h(storageManager, "NO_LOCKS");
                return new zq2(new LazyWrappedType(storageManager, new Function0<z71>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt$createCapturedIfNeeded$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final z71 invoke() {
                        z71 type = TypeProjection.this.getType();
                        b41.h(type, "this@createCapturedIfNeeded.type");
                        return type;
                    }
                }));
            }
            return new zq2(typeProjection.getType());
        }
        return new zq2(c(typeProjection));
    }

    @NotNull
    public static final z71 c(@NotNull TypeProjection typeProjection) {
        b41.i(typeProjection, "typeProjection");
        return new kg(typeProjection, null, false, null, 14, null);
    }

    public static final boolean d(@NotNull z71 z71Var) {
        b41.i(z71Var, "<this>");
        return z71Var.c() instanceof CapturedTypeConstructor;
    }

    @NotNull
    public static final br2 e(@NotNull br2 br2Var, boolean z) {
        List<Pair> l0;
        int q;
        b41.i(br2Var, "<this>");
        if (br2Var instanceof h21) {
            h21 h21Var = (h21) br2Var;
            TypeParameterDescriptor[] j = h21Var.j();
            l0 = ArraysKt___ArraysKt.l0(h21Var.i(), h21Var.j());
            q = n.q(l0, 10);
            ArrayList arrayList = new ArrayList(q);
            for (Pair pair : l0) {
                arrayList.add(b((TypeProjection) pair.getFirst(), (TypeParameterDescriptor) pair.getSecond()));
            }
            Object[] array = arrayList.toArray(new TypeProjection[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            return new h21(j, (TypeProjection[]) array, z);
        }
        return new a(z, br2Var);
    }

    public static /* synthetic */ br2 f(br2 br2Var, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return e(br2Var, z);
    }
}
