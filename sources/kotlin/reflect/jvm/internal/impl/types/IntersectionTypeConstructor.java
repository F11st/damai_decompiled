package kotlin.reflect.jvm.internal.impl.types;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.C8214m;
import kotlin.collections.C8215n;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.AbstractC8271b;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope;
import kotlin.reflect.jvm.internal.impl.types.model.IntersectionTypeConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.b81;
import tb.fd2;
import tb.jn1;
import tb.ul;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class IntersectionTypeConstructor implements TypeConstructor, IntersectionTypeConstructorMarker {
    @Nullable
    private z71 a;
    @NotNull
    private final LinkedHashSet<z71> b;
    private final int c;

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor$a */
    /* loaded from: classes3.dex */
    public static final class C8537a<T> implements Comparator {
        final /* synthetic */ Function1 a;

        public C8537a(Function1 function1) {
            this.a = function1;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int a;
            z71 z71Var = (z71) t;
            Function1 function1 = this.a;
            b41.h(z71Var, AdvanceSetting.NETWORK_TYPE);
            String obj = function1.invoke(z71Var).toString();
            z71 z71Var2 = (z71) t2;
            Function1 function12 = this.a;
            b41.h(z71Var2, AdvanceSetting.NETWORK_TYPE);
            a = ul.a(obj, function12.invoke(z71Var2).toString());
            return a;
        }
    }

    public IntersectionTypeConstructor(@NotNull Collection<? extends z71> collection) {
        b41.i(collection, "typesToIntersect");
        collection.isEmpty();
        LinkedHashSet<z71> linkedHashSet = new LinkedHashSet<>(collection);
        this.b = linkedHashSet;
        this.c = linkedHashSet.hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String e(IntersectionTypeConstructor intersectionTypeConstructor, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1<z71, String>() { // from class: kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor$makeDebugNameForIntersectionType$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final String invoke(@NotNull z71 z71Var) {
                    b41.i(z71Var, AdvanceSetting.NETWORK_TYPE);
                    return z71Var.toString();
                }
            };
        }
        return intersectionTypeConstructor.d(function1);
    }

    @NotNull
    public final MemberScope a() {
        return TypeIntersectionScope.Companion.a("member scope for intersection type", this.b);
    }

    @NotNull
    public final fd2 b() {
        List g;
        Annotations b = Annotations.Companion.b();
        g = C8214m.g();
        return KotlinTypeFactory.k(b, this, g, false, a(), new Function1<b81, fd2>() { // from class: kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor$createType$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final fd2 invoke(@NotNull b81 b81Var) {
                b41.i(b81Var, "kotlinTypeRefiner");
                return IntersectionTypeConstructor.this.refine(b81Var).b();
            }
        });
    }

    @Nullable
    public final z71 c() {
        return this.a;
    }

    @NotNull
    public final String d(@NotNull final Function1<? super z71, ? extends Object> function1) {
        List u0;
        String Z;
        b41.i(function1, "getProperTypeRelatedToStringify");
        u0 = CollectionsKt___CollectionsKt.u0(this.b, new C8537a(function1));
        Z = CollectionsKt___CollectionsKt.Z(u0, " & ", jn1.BLOCK_START_STR, "}", 0, null, new Function1<z71, CharSequence>() { // from class: kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor$makeDebugNameForIntersectionType$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(z71 z71Var) {
                Function1<z71, Object> function12 = function1;
                b41.h(z71Var, AdvanceSetting.NETWORK_TYPE);
                return function12.invoke(z71Var).toString();
            }
        }, 24, null);
        return Z;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IntersectionTypeConstructor) {
            return b41.d(this.b, ((IntersectionTypeConstructor) obj).b);
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    /* renamed from: f */
    public IntersectionTypeConstructor refine(@NotNull b81 b81Var) {
        int q;
        b41.i(b81Var, "kotlinTypeRefiner");
        Collection<z71> supertypes = getSupertypes();
        q = C8215n.q(supertypes, 10);
        ArrayList arrayList = new ArrayList(q);
        boolean z = false;
        for (z71 z71Var : supertypes) {
            arrayList.add(z71Var.e(b81Var));
            z = true;
        }
        IntersectionTypeConstructor intersectionTypeConstructor = null;
        if (z) {
            z71 c = c();
            intersectionTypeConstructor = new IntersectionTypeConstructor(arrayList).g(c != null ? c.e(b81Var) : null);
        }
        return intersectionTypeConstructor == null ? this : intersectionTypeConstructor;
    }

    @NotNull
    public final IntersectionTypeConstructor g(@Nullable z71 z71Var) {
        return new IntersectionTypeConstructor(this.b, z71Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public AbstractC8271b getBuiltIns() {
        AbstractC8271b builtIns = this.b.iterator().next().c().getBuiltIns();
        b41.h(builtIns, "intersectedTypes.iterato…xt().constructor.builtIns");
        return builtIns;
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

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public Collection<z71> getSupertypes() {
        return this.b;
    }

    public int hashCode() {
        return this.c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public boolean isDenotable() {
        return false;
    }

    @NotNull
    public String toString() {
        return e(this, null, 1, null);
    }

    private IntersectionTypeConstructor(Collection<? extends z71> collection, z71 z71Var) {
        this(collection);
        this.a = z71Var;
    }
}
