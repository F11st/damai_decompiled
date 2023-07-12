package tb;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.collections.C8202e;
import kotlin.reflect.jvm.internal.calls.BoundCaller;
import kotlin.reflect.jvm.internal.calls.Caller;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.yf;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class x31 implements Caller<Method> {
    @NotNull
    private final Type a;
    private final Method b;
    @NotNull
    private final List<Type> c;

    /* compiled from: Taobao */
    /* renamed from: tb.x31$a */
    /* loaded from: classes3.dex */
    public static final class C9906a extends x31 implements BoundCaller {
        private final Object d;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public C9906a(@org.jetbrains.annotations.NotNull java.lang.reflect.Method r3, @org.jetbrains.annotations.Nullable java.lang.Object r4) {
            /*
                r2 = this;
                java.lang.String r0 = "unboxMethod"
                tb.b41.i(r3, r0)
                java.util.List r0 = kotlin.collections.C8212k.g()
                r1 = 0
                r2.<init>(r3, r0, r1)
                r2.d = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: tb.x31.C9906a.<init>(java.lang.reflect.Method, java.lang.Object):void");
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        @Nullable
        public Object call(@NotNull Object[] objArr) {
            b41.i(objArr, "args");
            b(objArr);
            return a(this.d, objArr);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.x31$b */
    /* loaded from: classes3.dex */
    public static final class C9907b extends x31 {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public C9907b(@org.jetbrains.annotations.NotNull java.lang.reflect.Method r3) {
            /*
                r2 = this;
                java.lang.String r0 = "unboxMethod"
                tb.b41.i(r3, r0)
                java.lang.Class r0 = r3.getDeclaringClass()
                java.util.List r0 = kotlin.collections.C8212k.e(r0)
                r1 = 0
                r2.<init>(r3, r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: tb.x31.C9907b.<init>(java.lang.reflect.Method):void");
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        @Nullable
        public Object call(@NotNull Object[] objArr) {
            Object[] h;
            b41.i(objArr, "args");
            b(objArr);
            Object obj = objArr[0];
            yf.C9962d c9962d = yf.Companion;
            if (objArr.length <= 1) {
                h = new Object[0];
            } else {
                h = C8202e.h(objArr, 1, objArr.length);
                Objects.requireNonNull(h, "null cannot be cast to non-null type kotlin.Array<T>");
            }
            return a(obj, h);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private x31(Method method, List<? extends Type> list) {
        this.b = method;
        this.c = list;
        Class<?> returnType = method.getReturnType();
        b41.h(returnType, "unboxMethod.returnType");
        this.a = returnType;
    }

    @Nullable
    protected final Object a(@Nullable Object obj, @NotNull Object[] objArr) {
        b41.i(objArr, "args");
        return this.b.invoke(obj, Arrays.copyOf(objArr, objArr.length));
    }

    public void b(@NotNull Object[] objArr) {
        b41.i(objArr, "args");
        Caller.C8265a.a(this, objArr);
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    @Nullable
    /* renamed from: c */
    public final Method getMember() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    @NotNull
    public final List<Type> getParameterTypes() {
        return this.c;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    @NotNull
    public final Type getReturnType() {
        return this.a;
    }

    public /* synthetic */ x31(Method method, List list, k50 k50Var) {
        this(method, list);
    }
}
