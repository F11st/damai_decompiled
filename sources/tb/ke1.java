package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.util.Check;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class ke1 implements Check {
    @NotNull
    private final String a;

    /* compiled from: Taobao */
    /* renamed from: tb.ke1$a */
    /* loaded from: classes3.dex */
    public static final class C9349a extends ke1 {
        @NotNull
        public static final C9349a INSTANCE = new C9349a();

        private C9349a() {
            super("must be a member function", null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.Check
        public boolean check(@NotNull FunctionDescriptor functionDescriptor) {
            b41.i(functionDescriptor, "functionDescriptor");
            return functionDescriptor.getDispatchReceiverParameter() != null;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.ke1$b */
    /* loaded from: classes3.dex */
    public static final class C9350b extends ke1 {
        @NotNull
        public static final C9350b INSTANCE = new C9350b();

        private C9350b() {
            super("must be a member or an extension function", null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.Check
        public boolean check(@NotNull FunctionDescriptor functionDescriptor) {
            b41.i(functionDescriptor, "functionDescriptor");
            return (functionDescriptor.getDispatchReceiverParameter() == null && functionDescriptor.getExtensionReceiverParameter() == null) ? false : true;
        }
    }

    private ke1(String str) {
        this.a = str;
    }

    public /* synthetic */ ke1(String str, k50 k50Var) {
        this(str);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    @NotNull
    public String getDescription() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    @Nullable
    public String invoke(@NotNull FunctionDescriptor functionDescriptor) {
        return Check.C8556a.a(this, functionDescriptor);
    }
}
