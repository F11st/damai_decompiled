package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.b81;
import tb.v13;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class LazyWrappedType extends v13 {
    @NotNull
    private final StorageManager b;
    @NotNull
    private final Function0<z71> c;
    @NotNull
    private final NotNullLazyValue<z71> d;

    /* JADX WARN: Multi-variable type inference failed */
    public LazyWrappedType(@NotNull StorageManager storageManager, @NotNull Function0<? extends z71> function0) {
        b41.i(storageManager, "storageManager");
        b41.i(function0, "computation");
        this.b = storageManager;
        this.c = function0;
        this.d = storageManager.createLazyValue(function0);
    }

    @Override // tb.v13
    @NotNull
    protected z71 g() {
        return this.d.invoke();
    }

    @Override // tb.v13
    public boolean h() {
        return this.d.isComputed();
    }

    @Override // tb.z71
    @NotNull
    /* renamed from: j */
    public LazyWrappedType e(@NotNull final b81 b81Var) {
        b41.i(b81Var, "kotlinTypeRefiner");
        return new LazyWrappedType(this.b, new Function0<z71>() { // from class: kotlin.reflect.jvm.internal.impl.types.LazyWrappedType$refine$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final z71 invoke() {
                Function0 function0;
                b81 b81Var2 = b81.this;
                function0 = this.c;
                return b81Var2.g((z71) function0.invoke());
            }
        });
    }
}
