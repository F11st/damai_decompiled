package tb;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class oq2 extends br2 {
    @NotNull
    public static final a Companion = new a(null);

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {

        /* compiled from: Taobao */
        /* renamed from: tb.oq2$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0461a extends oq2 {
            final /* synthetic */ Map<TypeConstructor, TypeProjection> a;
            final /* synthetic */ boolean b;

            /* JADX WARN: Multi-variable type inference failed */
            C0461a(Map<TypeConstructor, ? extends TypeProjection> map, boolean z) {
                this.a = map;
                this.b = z;
            }

            @Override // tb.br2
            public boolean a() {
                return this.b;
            }

            @Override // tb.br2
            public boolean f() {
                return this.a.isEmpty();
            }

            @Override // tb.oq2
            @Nullable
            public TypeProjection k(@NotNull TypeConstructor typeConstructor) {
                b41.i(typeConstructor, "key");
                return this.a.get(typeConstructor);
            }
        }

        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        public static /* synthetic */ oq2 e(a aVar, Map map, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return aVar.d(map, z);
        }

        @JvmStatic
        @NotNull
        public final br2 a(@NotNull TypeConstructor typeConstructor, @NotNull List<? extends TypeProjection> list) {
            int q;
            List H0;
            Map r;
            b41.i(typeConstructor, "typeConstructor");
            b41.i(list, "arguments");
            List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
            b41.h(parameters, "typeConstructor.parameters");
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) kotlin.collections.k.d0(parameters);
            if (typeParameterDescriptor != null && typeParameterDescriptor.isCapturedFromOuterDeclaration()) {
                List<TypeParameterDescriptor> parameters2 = typeConstructor.getParameters();
                b41.h(parameters2, "typeConstructor.parameters");
                q = kotlin.collections.n.q(parameters2, 10);
                ArrayList arrayList = new ArrayList(q);
                for (TypeParameterDescriptor typeParameterDescriptor2 : parameters2) {
                    arrayList.add(typeParameterDescriptor2.getTypeConstructor());
                }
                H0 = CollectionsKt___CollectionsKt.H0(arrayList, list);
                r = kotlin.collections.x.r(H0);
                return e(this, r, false, 2, null);
            }
            return new h21(parameters, list);
        }

        @JvmStatic
        @NotNull
        public final br2 b(@NotNull z71 z71Var) {
            b41.i(z71Var, "kotlinType");
            return a(z71Var.c(), z71Var.b());
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final oq2 c(@NotNull Map<TypeConstructor, ? extends TypeProjection> map) {
            b41.i(map, "map");
            return e(this, map, false, 2, null);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final oq2 d(@NotNull Map<TypeConstructor, ? extends TypeProjection> map, boolean z) {
            b41.i(map, "map");
            return new C0461a(map, z);
        }
    }

    @JvmStatic
    @NotNull
    public static final br2 i(@NotNull TypeConstructor typeConstructor, @NotNull List<? extends TypeProjection> list) {
        return Companion.a(typeConstructor, list);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final oq2 j(@NotNull Map<TypeConstructor, ? extends TypeProjection> map) {
        return Companion.c(map);
    }

    @Override // tb.br2
    @Nullable
    public TypeProjection e(@NotNull z71 z71Var) {
        b41.i(z71Var, "key");
        return k(z71Var.c());
    }

    @Nullable
    public abstract TypeProjection k(@NotNull TypeConstructor typeConstructor);
}
