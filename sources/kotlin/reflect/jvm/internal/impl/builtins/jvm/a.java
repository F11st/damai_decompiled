package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.reflect.jvm.internal.impl.builtins.b;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import org.jetbrains.annotations.NotNull;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
final class a extends b {
    @NotNull
    public static final C0413a Companion = new C0413a(null);
    @NotNull
    private static final b g = new a();

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.builtins.jvm.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0413a {
        private C0413a() {
        }

        public /* synthetic */ C0413a(k50 k50Var) {
            this();
        }

        @NotNull
        public final b a() {
            return a.g;
        }
    }

    private a() {
        super(new LockBasedStorageManager("FallbackBuiltIns"));
        f(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.builtins.b
    @NotNull
    /* renamed from: E0 */
    public PlatformDependentDeclarationFilter.a M() {
        return PlatformDependentDeclarationFilter.a.INSTANCE;
    }
}
