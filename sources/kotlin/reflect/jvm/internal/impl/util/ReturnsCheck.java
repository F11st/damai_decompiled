package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.util.Check;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.fd2;
import tb.k50;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class ReturnsCheck implements Check {
    @NotNull
    private final String a;
    @NotNull
    private final Function1<kotlin.reflect.jvm.internal.impl.builtins.b, z71> b;
    @NotNull
    private final String c;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class ReturnsBoolean extends ReturnsCheck {
        @NotNull
        public static final ReturnsBoolean INSTANCE = new ReturnsBoolean();

        private ReturnsBoolean() {
            super("Boolean", new Function1<kotlin.reflect.jvm.internal.impl.builtins.b, z71>() { // from class: kotlin.reflect.jvm.internal.impl.util.ReturnsCheck.ReturnsBoolean.1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final z71 invoke(@NotNull kotlin.reflect.jvm.internal.impl.builtins.b bVar) {
                    b41.i(bVar, "$this$null");
                    fd2 n = bVar.n();
                    b41.h(n, "booleanType");
                    return n;
                }
            }, null);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class ReturnsInt extends ReturnsCheck {
        @NotNull
        public static final ReturnsInt INSTANCE = new ReturnsInt();

        private ReturnsInt() {
            super("Int", new Function1<kotlin.reflect.jvm.internal.impl.builtins.b, z71>() { // from class: kotlin.reflect.jvm.internal.impl.util.ReturnsCheck.ReturnsInt.1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final z71 invoke(@NotNull kotlin.reflect.jvm.internal.impl.builtins.b bVar) {
                    b41.i(bVar, "$this$null");
                    fd2 D = bVar.D();
                    b41.h(D, "intType");
                    return D;
                }
            }, null);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class ReturnsUnit extends ReturnsCheck {
        @NotNull
        public static final ReturnsUnit INSTANCE = new ReturnsUnit();

        private ReturnsUnit() {
            super("Unit", new Function1<kotlin.reflect.jvm.internal.impl.builtins.b, z71>() { // from class: kotlin.reflect.jvm.internal.impl.util.ReturnsCheck.ReturnsUnit.1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final z71 invoke(@NotNull kotlin.reflect.jvm.internal.impl.builtins.b bVar) {
                    b41.i(bVar, "$this$null");
                    fd2 Z = bVar.Z();
                    b41.h(Z, "unitType");
                    return Z;
                }
            }, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ReturnsCheck(String str, Function1<? super kotlin.reflect.jvm.internal.impl.builtins.b, ? extends z71> function1) {
        this.a = str;
        this.b = function1;
        this.c = b41.r("must return ", str);
    }

    public /* synthetic */ ReturnsCheck(String str, Function1 function1, k50 k50Var) {
        this(str, function1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public boolean check(@NotNull FunctionDescriptor functionDescriptor) {
        b41.i(functionDescriptor, "functionDescriptor");
        return b41.d(functionDescriptor.getReturnType(), this.b.invoke(DescriptorUtilsKt.g(functionDescriptor)));
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    @NotNull
    public String getDescription() {
        return this.c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    @Nullable
    public String invoke(@NotNull FunctionDescriptor functionDescriptor) {
        return Check.a.a(this, functionDescriptor);
    }
}
