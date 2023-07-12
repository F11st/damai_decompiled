package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.C8177b;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.C8214m;
import kotlin.collections.C8215n;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.builtins.AbstractC8271b;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.b81;
import tb.gu2;
import tb.k50;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class NewCapturedTypeConstructor implements CapturedTypeConstructor {
    @NotNull
    private final TypeProjection a;
    @Nullable
    private Function0<? extends List<? extends gu2>> b;
    @Nullable
    private final NewCapturedTypeConstructor c;
    @Nullable
    private final TypeParameterDescriptor d;
    @NotNull
    private final Lazy e;

    public NewCapturedTypeConstructor(@NotNull TypeProjection typeProjection, @Nullable Function0<? extends List<? extends gu2>> function0, @Nullable NewCapturedTypeConstructor newCapturedTypeConstructor, @Nullable TypeParameterDescriptor typeParameterDescriptor) {
        Lazy a;
        b41.i(typeProjection, "projection");
        this.a = typeProjection;
        this.b = function0;
        this.c = newCapturedTypeConstructor;
        this.d = typeParameterDescriptor;
        a = C8177b.a(LazyThreadSafetyMode.PUBLICATION, new Function0<List<? extends gu2>>() { // from class: kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor$_supertypes$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final List<? extends gu2> invoke() {
                Function0 function02;
                function02 = NewCapturedTypeConstructor.this.b;
                if (function02 == null) {
                    return null;
                }
                return (List) function02.invoke();
            }
        });
        this.e = a;
    }

    private final List<gu2> c() {
        return (List) this.e.getValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    /* renamed from: b */
    public List<gu2> getSupertypes() {
        List<gu2> g;
        List<gu2> c = c();
        if (c == null) {
            g = C8214m.g();
            return g;
        }
        return c;
    }

    public final void d(@NotNull final List<? extends gu2> list) {
        b41.i(list, "supertypes");
        this.b = new Function0<List<? extends gu2>>() { // from class: kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor$initializeSupertypes$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends gu2> invoke() {
                return list;
            }
        };
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    /* renamed from: e */
    public NewCapturedTypeConstructor refine(@NotNull final b81 b81Var) {
        b41.i(b81Var, "kotlinTypeRefiner");
        TypeProjection refine = getProjection().refine(b81Var);
        b41.h(refine, "projection.refine(kotlinTypeRefiner)");
        Function0<List<? extends gu2>> function0 = this.b == null ? null : new Function0<List<? extends gu2>>() { // from class: kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor$refine$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends gu2> invoke() {
                int q;
                List<gu2> supertypes = NewCapturedTypeConstructor.this.getSupertypes();
                b81 b81Var2 = b81Var;
                q = C8215n.q(supertypes, 10);
                ArrayList arrayList = new ArrayList(q);
                for (gu2 gu2Var : supertypes) {
                    arrayList.add(gu2Var.h(b81Var2));
                }
                return arrayList;
            }
        };
        NewCapturedTypeConstructor newCapturedTypeConstructor = this.c;
        if (newCapturedTypeConstructor == null) {
            newCapturedTypeConstructor = this;
        }
        return new NewCapturedTypeConstructor(refine, function0, newCapturedTypeConstructor, this.d);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (b41.d(NewCapturedTypeConstructor.class, obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedTypeConstructor");
            NewCapturedTypeConstructor newCapturedTypeConstructor = (NewCapturedTypeConstructor) obj;
            NewCapturedTypeConstructor newCapturedTypeConstructor2 = this.c;
            if (newCapturedTypeConstructor2 == null) {
                newCapturedTypeConstructor2 = this;
            }
            NewCapturedTypeConstructor newCapturedTypeConstructor3 = newCapturedTypeConstructor.c;
            if (newCapturedTypeConstructor3 != null) {
                newCapturedTypeConstructor = newCapturedTypeConstructor3;
            }
            return newCapturedTypeConstructor2 == newCapturedTypeConstructor;
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public AbstractC8271b getBuiltIns() {
        z71 type = getProjection().getType();
        b41.h(type, "projection.type");
        return TypeUtilsKt.h(type);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @Nullable
    public ClassifierDescriptor getDeclarationDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public List<TypeParameterDescriptor> getParameters() {
        List<TypeParameterDescriptor> g;
        g = C8214m.g();
        return g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor
    @NotNull
    public TypeProjection getProjection() {
        return this.a;
    }

    public int hashCode() {
        NewCapturedTypeConstructor newCapturedTypeConstructor = this.c;
        return newCapturedTypeConstructor == null ? super.hashCode() : newCapturedTypeConstructor.hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public boolean isDenotable() {
        return false;
    }

    @NotNull
    public String toString() {
        return "CapturedType(" + getProjection() + ')';
    }

    public /* synthetic */ NewCapturedTypeConstructor(TypeProjection typeProjection, Function0 function0, NewCapturedTypeConstructor newCapturedTypeConstructor, TypeParameterDescriptor typeParameterDescriptor, int i, k50 k50Var) {
        this(typeProjection, (i & 2) != 0 ? null : function0, (i & 4) != 0 ? null : newCapturedTypeConstructor, (i & 8) != 0 ? null : typeParameterDescriptor);
    }

    public /* synthetic */ NewCapturedTypeConstructor(TypeProjection typeProjection, List list, NewCapturedTypeConstructor newCapturedTypeConstructor, int i, k50 k50Var) {
        this(typeProjection, list, (i & 4) != 0 ? null : newCapturedTypeConstructor);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewCapturedTypeConstructor(@NotNull TypeProjection typeProjection, @NotNull final List<? extends gu2> list, @Nullable NewCapturedTypeConstructor newCapturedTypeConstructor) {
        this(typeProjection, new Function0<List<? extends gu2>>() { // from class: kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends gu2> invoke() {
                return list;
            }
        }, newCapturedTypeConstructor, null, 8, null);
        b41.i(typeProjection, "projection");
        b41.i(list, "supertypes");
    }
}
