package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.reflect.jvm.internal.impl.builtins.AbstractC8271b;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import org.jetbrains.annotations.NotNull;
import tb.k50;

/* compiled from: Taobao */
/* renamed from: kotlin.reflect.jvm.internal.impl.builtins.jvm.a */
/* loaded from: classes3.dex */
final class C8289a extends AbstractC8271b {
    @NotNull
    public static final C8290a Companion = new C8290a(null);
    @NotNull
    private static final AbstractC8271b g = new C8289a();

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.builtins.jvm.a$a */
    /* loaded from: classes3.dex */
    public static final class C8290a {
        private C8290a() {
        }

        public /* synthetic */ C8290a(k50 k50Var) {
            this();
        }

        @NotNull
        public final AbstractC8271b a() {
            return C8289a.g;
        }
    }

    private C8289a() {
        super(new LockBasedStorageManager("FallbackBuiltIns"));
        f(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.builtins.AbstractC8271b
    @NotNull
    /* renamed from: E0 */
    public PlatformDependentDeclarationFilter.C8308a M() {
        return PlatformDependentDeclarationFilter.C8308a.INSTANCE;
    }
}
