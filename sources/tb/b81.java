package tb;

import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class b81 {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a extends b81 {
        @NotNull
        public static final a INSTANCE = new a();

        private a() {
        }

        @Override // tb.b81
        @Nullable
        public ClassDescriptor a(@NotNull hj hjVar) {
            b41.i(hjVar, "classId");
            return null;
        }

        @Override // tb.b81
        @NotNull
        public <S extends MemberScope> S b(@NotNull ClassDescriptor classDescriptor, @NotNull Function0<? extends S> function0) {
            b41.i(classDescriptor, "classDescriptor");
            b41.i(function0, "compute");
            return function0.invoke();
        }

        @Override // tb.b81
        public boolean c(@NotNull ModuleDescriptor moduleDescriptor) {
            b41.i(moduleDescriptor, "moduleDescriptor");
            return false;
        }

        @Override // tb.b81
        public boolean d(@NotNull TypeConstructor typeConstructor) {
            b41.i(typeConstructor, "typeConstructor");
            return false;
        }

        @Override // tb.b81
        @NotNull
        public Collection<z71> f(@NotNull ClassDescriptor classDescriptor) {
            b41.i(classDescriptor, "classDescriptor");
            Collection<z71> supertypes = classDescriptor.getTypeConstructor().getSupertypes();
            b41.h(supertypes, "classDescriptor.typeConstructor.supertypes");
            return supertypes;
        }

        @Override // tb.b81
        @NotNull
        public z71 g(@NotNull z71 z71Var) {
            b41.i(z71Var, "type");
            return z71Var;
        }

        @Override // tb.b81
        @Nullable
        /* renamed from: h */
        public ClassDescriptor e(@NotNull DeclarationDescriptor declarationDescriptor) {
            b41.i(declarationDescriptor, "descriptor");
            return null;
        }
    }

    @Nullable
    public abstract ClassDescriptor a(@NotNull hj hjVar);

    @NotNull
    public abstract <S extends MemberScope> S b(@NotNull ClassDescriptor classDescriptor, @NotNull Function0<? extends S> function0);

    public abstract boolean c(@NotNull ModuleDescriptor moduleDescriptor);

    public abstract boolean d(@NotNull TypeConstructor typeConstructor);

    @Nullable
    public abstract ClassifierDescriptor e(@NotNull DeclarationDescriptor declarationDescriptor);

    @NotNull
    public abstract Collection<z71> f(@NotNull ClassDescriptor classDescriptor);

    @NotNull
    public abstract z71 g(@NotNull z71 z71Var);
}
