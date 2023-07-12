package tb;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class jq2 {
    @NotNull
    public static final a Companion = new a(null);
    @Nullable
    private final jq2 a;
    @NotNull
    private final TypeAliasDescriptor b;
    @NotNull
    private final List<TypeProjection> c;
    @NotNull
    private final Map<TypeParameterDescriptor, TypeProjection> d;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        @NotNull
        public final jq2 a(@Nullable jq2 jq2Var, @NotNull TypeAliasDescriptor typeAliasDescriptor, @NotNull List<? extends TypeProjection> list) {
            int q;
            List H0;
            Map r;
            b41.i(typeAliasDescriptor, "typeAliasDescriptor");
            b41.i(list, "arguments");
            List<TypeParameterDescriptor> parameters = typeAliasDescriptor.getTypeConstructor().getParameters();
            b41.h(parameters, "typeAliasDescriptor.typeConstructor.parameters");
            q = kotlin.collections.n.q(parameters, 10);
            ArrayList arrayList = new ArrayList(q);
            for (TypeParameterDescriptor typeParameterDescriptor : parameters) {
                arrayList.add(typeParameterDescriptor.getOriginal());
            }
            H0 = CollectionsKt___CollectionsKt.H0(arrayList, list);
            r = kotlin.collections.x.r(H0);
            return new jq2(jq2Var, typeAliasDescriptor, list, r, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private jq2(jq2 jq2Var, TypeAliasDescriptor typeAliasDescriptor, List<? extends TypeProjection> list, Map<TypeParameterDescriptor, ? extends TypeProjection> map) {
        this.a = jq2Var;
        this.b = typeAliasDescriptor;
        this.c = list;
        this.d = map;
    }

    public /* synthetic */ jq2(jq2 jq2Var, TypeAliasDescriptor typeAliasDescriptor, List list, Map map, k50 k50Var) {
        this(jq2Var, typeAliasDescriptor, list, map);
    }

    @NotNull
    public final List<TypeProjection> a() {
        return this.c;
    }

    @NotNull
    public final TypeAliasDescriptor b() {
        return this.b;
    }

    @Nullable
    public final TypeProjection c(@NotNull TypeConstructor typeConstructor) {
        b41.i(typeConstructor, "constructor");
        ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
        if (declarationDescriptor instanceof TypeParameterDescriptor) {
            return this.d.get(declarationDescriptor);
        }
        return null;
    }

    public final boolean d(@NotNull TypeAliasDescriptor typeAliasDescriptor) {
        b41.i(typeAliasDescriptor, "descriptor");
        if (!b41.d(this.b, typeAliasDescriptor)) {
            jq2 jq2Var = this.a;
            if (!(jq2Var == null ? false : jq2Var.d(typeAliasDescriptor))) {
                return false;
            }
        }
        return true;
    }
}
