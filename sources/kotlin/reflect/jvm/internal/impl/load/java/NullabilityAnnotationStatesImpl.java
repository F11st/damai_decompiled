package kotlin.reflect.jvm.internal.impl.load.java;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.name.a;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.hp0;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class NullabilityAnnotationStatesImpl<T> implements NullabilityAnnotationStates<T> {
    @NotNull
    private final Map<hp0, T> a;
    @NotNull
    private final LockBasedStorageManager b;
    @NotNull
    private final MemoizedFunctionToNullable<hp0, T> c;

    /* JADX WARN: Multi-variable type inference failed */
    public NullabilityAnnotationStatesImpl(@NotNull Map<hp0, ? extends T> map) {
        b41.i(map, "states");
        this.a = map;
        LockBasedStorageManager lockBasedStorageManager = new LockBasedStorageManager("Java nullability annotation states");
        this.b = lockBasedStorageManager;
        MemoizedFunctionToNullable<hp0, T> createMemoizedFunctionWithNullableValues = lockBasedStorageManager.createMemoizedFunctionWithNullableValues(new Function1<hp0, T>(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.NullabilityAnnotationStatesImpl$cache$1
            final /* synthetic */ NullabilityAnnotationStatesImpl<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final T invoke(hp0 hp0Var) {
                b41.h(hp0Var, AdvanceSetting.NETWORK_TYPE);
                return (T) a.a(hp0Var, this.this$0.a());
            }
        });
        b41.h(createMemoizedFunctionWithNullableValues, "storageManager.createMem…cificFqname(states)\n    }");
        this.c = createMemoizedFunctionWithNullableValues;
    }

    @NotNull
    public final Map<hp0, T> a() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.NullabilityAnnotationStates
    @Nullable
    public T get(@NotNull hp0 hp0Var) {
        b41.i(hp0Var, "fqName");
        return this.c.invoke(hp0Var);
    }
}
