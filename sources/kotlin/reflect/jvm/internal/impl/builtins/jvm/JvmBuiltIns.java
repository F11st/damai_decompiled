package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.AbstractC8271b;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a12;
import tb.b41;
import tb.tg2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class JvmBuiltIns extends AbstractC8271b {
    static final /* synthetic */ KProperty<Object>[] j = {a12.i(new PropertyReference1Impl(a12.b(JvmBuiltIns.class), "customizer", "getCustomizer()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsCustomizer;"))};
    @NotNull
    private final Kind g;
    @Nullable
    private Function0<C8282a> h;
    @NotNull
    private final NotNullLazyValue i;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public enum Kind {
        FROM_DEPENDENCIES,
        FROM_CLASS_LOADER,
        FALLBACK
    }

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns$a */
    /* loaded from: classes3.dex */
    public static final class C8282a {
        @NotNull
        private final ModuleDescriptor a;
        private final boolean b;

        public C8282a(@NotNull ModuleDescriptor moduleDescriptor, boolean z) {
            b41.i(moduleDescriptor, "ownerModuleDescriptor");
            this.a = moduleDescriptor;
            this.b = z;
        }

        @NotNull
        public final ModuleDescriptor a() {
            return this.a;
        }

        public final boolean b() {
            return this.b;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns$b */
    /* loaded from: classes3.dex */
    public /* synthetic */ class C8283b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Kind.values().length];
            iArr[Kind.FROM_DEPENDENCIES.ordinal()] = 1;
            iArr[Kind.FROM_CLASS_LOADER.ordinal()] = 2;
            iArr[Kind.FALLBACK.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JvmBuiltIns(@NotNull final StorageManager storageManager, @NotNull Kind kind) {
        super(storageManager);
        b41.i(storageManager, "storageManager");
        b41.i(kind, "kind");
        this.g = kind;
        this.i = storageManager.createLazyValue(new Function0<JvmBuiltInsCustomizer>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns$customizer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final JvmBuiltInsCustomizer invoke() {
                ModuleDescriptorImpl r = JvmBuiltIns.this.r();
                b41.h(r, "builtInsModule");
                StorageManager storageManager2 = storageManager;
                final JvmBuiltIns jvmBuiltIns = JvmBuiltIns.this;
                return new JvmBuiltInsCustomizer(r, storageManager2, new Function0<JvmBuiltIns.C8282a>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns$customizer$2.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final JvmBuiltIns.C8282a invoke() {
                        Function0 function0;
                        function0 = JvmBuiltIns.this.h;
                        if (function0 != null) {
                            JvmBuiltIns.C8282a c8282a = (JvmBuiltIns.C8282a) function0.invoke();
                            JvmBuiltIns.this.h = null;
                            return c8282a;
                        }
                        throw new AssertionError("JvmBuiltins instance has not been initialized properly");
                    }
                });
            }
        });
        int i = C8283b.$EnumSwitchMapping$0[kind.ordinal()];
        if (i == 2) {
            f(false);
        } else if (i != 3) {
        } else {
            f(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.builtins.AbstractC8271b
    @NotNull
    /* renamed from: F0 */
    public List<ClassDescriptorFactory> v() {
        List<ClassDescriptorFactory> l0;
        Iterable<ClassDescriptorFactory> v = super.v();
        b41.h(v, "super.getClassDescriptorFactories()");
        StorageManager U = U();
        b41.h(U, "storageManager");
        ModuleDescriptorImpl r = r();
        b41.h(r, "builtInsModule");
        l0 = CollectionsKt___CollectionsKt.l0(v, new JvmBuiltInClassDescriptorFactory(U, r, null, 4, null));
        return l0;
    }

    @NotNull
    public final JvmBuiltInsCustomizer G0() {
        return (JvmBuiltInsCustomizer) tg2.a(this.i, this, j[0]);
    }

    public final void H0(@NotNull final ModuleDescriptor moduleDescriptor, final boolean z) {
        b41.i(moduleDescriptor, "moduleDescriptor");
        I0(new Function0<C8282a>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns$initialize$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final JvmBuiltIns.C8282a invoke() {
                return new JvmBuiltIns.C8282a(ModuleDescriptor.this, z);
            }
        });
    }

    public final void I0(@NotNull Function0<C8282a> function0) {
        b41.i(function0, "computation");
        this.h = function0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.AbstractC8271b
    @NotNull
    protected PlatformDependentDeclarationFilter M() {
        return G0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.AbstractC8271b
    @NotNull
    protected AdditionalClassPartsProvider g() {
        return G0();
    }
}
