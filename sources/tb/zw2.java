package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.util.Check;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class zw2 implements Check {
    @NotNull
    private final String a;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a extends zw2 {
        private final int b;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public a(int r3) {
            /*
                r2 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "must have at least "
                r0.append(r1)
                r0.append(r3)
                java.lang.String r1 = " value parameter"
                r0.append(r1)
                r1 = 1
                if (r3 <= r1) goto L18
                java.lang.String r1 = "s"
                goto L1a
            L18:
                java.lang.String r1 = ""
            L1a:
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r1 = 0
                r2.<init>(r0, r1)
                r2.b = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: tb.zw2.a.<init>(int):void");
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.Check
        public boolean check(@NotNull FunctionDescriptor functionDescriptor) {
            b41.i(functionDescriptor, "functionDescriptor");
            return functionDescriptor.getValueParameters().size() >= this.b;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class b extends zw2 {
        private final int b;

        public b(int i) {
            super("must have exactly " + i + " value parameters", null);
            this.b = i;
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.Check
        public boolean check(@NotNull FunctionDescriptor functionDescriptor) {
            b41.i(functionDescriptor, "functionDescriptor");
            return functionDescriptor.getValueParameters().size() == this.b;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class c extends zw2 {
        @NotNull
        public static final c INSTANCE = new c();

        private c() {
            super("must have no value parameters", null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.Check
        public boolean check(@NotNull FunctionDescriptor functionDescriptor) {
            b41.i(functionDescriptor, "functionDescriptor");
            return functionDescriptor.getValueParameters().isEmpty();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class d extends zw2 {
        @NotNull
        public static final d INSTANCE = new d();

        private d() {
            super("must have a single value parameter", null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.Check
        public boolean check(@NotNull FunctionDescriptor functionDescriptor) {
            b41.i(functionDescriptor, "functionDescriptor");
            return functionDescriptor.getValueParameters().size() == 1;
        }
    }

    private zw2(String str) {
        this.a = str;
    }

    public /* synthetic */ zw2(String str, k50 k50Var) {
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
        return Check.a.a(this, functionDescriptor);
    }
}
