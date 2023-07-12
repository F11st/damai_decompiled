package kotlin.reflect.jvm.internal.impl.types;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.l;
import kotlin.collections.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.b81;
import tb.c81;
import tb.kf0;
import tb.pj;
import tb.wt2;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class AbstractTypeConstructor extends pj {
    @NotNull
    private final NotNullLazyValue<a> b;
    private final boolean c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public final class ModuleViewTypeConstructor implements TypeConstructor {
        @NotNull
        private final b81 a;
        @NotNull
        private final Lazy b;
        final /* synthetic */ AbstractTypeConstructor c;

        public ModuleViewTypeConstructor(@NotNull final AbstractTypeConstructor abstractTypeConstructor, b81 b81Var) {
            Lazy a;
            b41.i(abstractTypeConstructor, "this$0");
            b41.i(b81Var, "kotlinTypeRefiner");
            this.c = abstractTypeConstructor;
            this.a = b81Var;
            a = kotlin.b.a(LazyThreadSafetyMode.PUBLICATION, new Function0<List<? extends z71>>() { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$ModuleViewTypeConstructor$refinedSupertypes$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final List<? extends z71> invoke() {
                    b81 b81Var2;
                    b81Var2 = AbstractTypeConstructor.ModuleViewTypeConstructor.this.a;
                    return c81.b(b81Var2, abstractTypeConstructor.getSupertypes());
                }
            });
            this.b = a;
        }

        private final List<z71> b() {
            return (List) this.b.getValue();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        /* renamed from: c */
        public List<z71> getSupertypes() {
            return b();
        }

        public boolean equals(@Nullable Object obj) {
            return this.c.equals(obj);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public kotlin.reflect.jvm.internal.impl.builtins.b getBuiltIns() {
            kotlin.reflect.jvm.internal.impl.builtins.b builtIns = this.c.getBuiltIns();
            b41.h(builtIns, "this@AbstractTypeConstructor.builtIns");
            return builtIns;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public ClassifierDescriptor getDeclarationDescriptor() {
            return this.c.getDeclarationDescriptor();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public List<TypeParameterDescriptor> getParameters() {
            List<TypeParameterDescriptor> parameters = this.c.getParameters();
            b41.h(parameters, "this@AbstractTypeConstructor.parameters");
            return parameters;
        }

        public int hashCode() {
            return this.c.hashCode();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return this.c.isDenotable();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public TypeConstructor refine(@NotNull b81 b81Var) {
            b41.i(b81Var, "kotlinTypeRefiner");
            return this.c.refine(b81Var);
        }

        @NotNull
        public String toString() {
            return this.c.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        @NotNull
        private final Collection<z71> a;
        @NotNull
        private List<? extends z71> b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull Collection<? extends z71> collection) {
            List<? extends z71> e;
            b41.i(collection, "allSupertypes");
            this.a = collection;
            e = l.e(kf0.ERROR_TYPE_FOR_LOOP_IN_SUPERTYPES);
            this.b = e;
        }

        @NotNull
        public final Collection<z71> a() {
            return this.a;
        }

        @NotNull
        public final List<z71> b() {
            return this.b;
        }

        public final void c(@NotNull List<? extends z71> list) {
            b41.i(list, "<set-?>");
            this.b = list;
        }
    }

    public AbstractTypeConstructor(@NotNull StorageManager storageManager) {
        b41.i(storageManager, "storageManager");
        this.b = storageManager.createLazyValueWithPostCompute(new Function0<a>() { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$supertypes$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AbstractTypeConstructor.a invoke() {
                return new AbstractTypeConstructor.a(AbstractTypeConstructor.this.f());
            }
        }, new Function1<Boolean, a>() { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$supertypes$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ AbstractTypeConstructor.a invoke(Boolean bool) {
                return invoke(bool.booleanValue());
            }

            @NotNull
            public final AbstractTypeConstructor.a invoke(boolean z) {
                List e;
                e = l.e(kf0.ERROR_TYPE_FOR_LOOP_IN_SUPERTYPES);
                return new AbstractTypeConstructor.a(e);
            }
        }, new Function1<a, wt2>() { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$supertypes$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(AbstractTypeConstructor.a aVar) {
                invoke2(aVar);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull AbstractTypeConstructor.a aVar) {
                b41.i(aVar, "supertypes");
                SupertypeLoopChecker j = AbstractTypeConstructor.this.j();
                AbstractTypeConstructor abstractTypeConstructor = AbstractTypeConstructor.this;
                Collection<z71> a2 = aVar.a();
                final AbstractTypeConstructor abstractTypeConstructor2 = AbstractTypeConstructor.this;
                Function1<TypeConstructor, Iterable<? extends z71>> function1 = new Function1<TypeConstructor, Iterable<? extends z71>>() { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$supertypes$3$resultWithoutCycles$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Iterable<z71> invoke(@NotNull TypeConstructor typeConstructor) {
                        Collection e;
                        b41.i(typeConstructor, AdvanceSetting.NETWORK_TYPE);
                        e = AbstractTypeConstructor.this.e(typeConstructor, false);
                        return e;
                    }
                };
                final AbstractTypeConstructor abstractTypeConstructor3 = AbstractTypeConstructor.this;
                Collection<z71> findLoopsInSupertypesAndDisconnect = j.findLoopsInSupertypesAndDisconnect(abstractTypeConstructor, a2, function1, new Function1<z71, wt2>() { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$supertypes$3$resultWithoutCycles$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ wt2 invoke(z71 z71Var) {
                        invoke2(z71Var);
                        return wt2.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull z71 z71Var) {
                        b41.i(z71Var, AdvanceSetting.NETWORK_TYPE);
                        AbstractTypeConstructor.this.n(z71Var);
                    }
                });
                if (findLoopsInSupertypesAndDisconnect.isEmpty()) {
                    z71 g = AbstractTypeConstructor.this.g();
                    findLoopsInSupertypesAndDisconnect = g == null ? null : l.e(g);
                    if (findLoopsInSupertypesAndDisconnect == null) {
                        findLoopsInSupertypesAndDisconnect = m.g();
                    }
                }
                if (AbstractTypeConstructor.this.i()) {
                    SupertypeLoopChecker j2 = AbstractTypeConstructor.this.j();
                    final AbstractTypeConstructor abstractTypeConstructor4 = AbstractTypeConstructor.this;
                    Function1<TypeConstructor, Iterable<? extends z71>> function12 = new Function1<TypeConstructor, Iterable<? extends z71>>() { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$supertypes$3.2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        @NotNull
                        public final Iterable<z71> invoke(@NotNull TypeConstructor typeConstructor) {
                            Collection e;
                            b41.i(typeConstructor, AdvanceSetting.NETWORK_TYPE);
                            e = AbstractTypeConstructor.this.e(typeConstructor, true);
                            return e;
                        }
                    };
                    final AbstractTypeConstructor abstractTypeConstructor5 = AbstractTypeConstructor.this;
                    j2.findLoopsInSupertypesAndDisconnect(abstractTypeConstructor4, findLoopsInSupertypesAndDisconnect, function12, new Function1<z71, wt2>() { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$supertypes$3.3
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ wt2 invoke(z71 z71Var) {
                            invoke2(z71Var);
                            return wt2.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull z71 z71Var) {
                            b41.i(z71Var, AdvanceSetting.NETWORK_TYPE);
                            AbstractTypeConstructor.this.m(z71Var);
                        }
                    });
                }
                AbstractTypeConstructor abstractTypeConstructor6 = AbstractTypeConstructor.this;
                List<z71> list = findLoopsInSupertypesAndDisconnect instanceof List ? (List) findLoopsInSupertypesAndDisconnect : null;
                if (list == null) {
                    list = CollectionsKt___CollectionsKt.A0(findLoopsInSupertypesAndDisconnect);
                }
                aVar.c(abstractTypeConstructor6.l(list));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection<z71> e(TypeConstructor typeConstructor, boolean z) {
        AbstractTypeConstructor abstractTypeConstructor = typeConstructor instanceof AbstractTypeConstructor ? (AbstractTypeConstructor) typeConstructor : null;
        List m0 = abstractTypeConstructor != null ? CollectionsKt___CollectionsKt.m0(abstractTypeConstructor.b.invoke().a(), abstractTypeConstructor.h(z)) : null;
        if (m0 == null) {
            Collection<z71> supertypes = typeConstructor.getSupertypes();
            b41.h(supertypes, "supertypes");
            return supertypes;
        }
        return m0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public abstract Collection<z71> f();

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public z71 g() {
        return null;
    }

    @NotNull
    protected Collection<z71> h(boolean z) {
        List g;
        g = m.g();
        return g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean i() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public abstract SupertypeLoopChecker j();

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    /* renamed from: k */
    public List<z71> getSupertypes() {
        return this.b.invoke().b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public List<z71> l(@NotNull List<z71> list) {
        b41.i(list, "supertypes");
        return list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(@NotNull z71 z71Var) {
        b41.i(z71Var, "type");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(@NotNull z71 z71Var) {
        b41.i(z71Var, "type");
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public TypeConstructor refine(@NotNull b81 b81Var) {
        b41.i(b81Var, "kotlinTypeRefiner");
        return new ModuleViewTypeConstructor(this, b81Var);
    }
}
