package tb;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.reflect.jvm.internal.calls.Caller;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class m21<M extends Member> implements Caller<M> {
    private final C9430a a;
    private final Caller<M> b;
    private final boolean c;

    /* compiled from: Taobao */
    /* renamed from: tb.m21$a */
    /* loaded from: classes3.dex */
    private static final class C9430a {
        @NotNull
        private final n31 a;
        @NotNull
        private final Method[] b;
        @Nullable
        private final Method c;

        public C9430a(@NotNull n31 n31Var, @NotNull Method[] methodArr, @Nullable Method method) {
            b41.i(n31Var, "argumentRange");
            b41.i(methodArr, "unbox");
            this.a = n31Var;
            this.b = methodArr;
            this.c = method;
        }

        @NotNull
        public final n31 a() {
            return this.a;
        }

        @NotNull
        public final Method[] b() {
            return this.b;
        }

        @Nullable
        public final Method c() {
            return this.c;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x004f, code lost:
        if ((r9 instanceof kotlin.reflect.jvm.internal.calls.BoundCaller) != false) goto L24;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public m21(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r8, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.calls.Caller<? extends M> r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 399
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.m21.<init>(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.calls.Caller, boolean):void");
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    @Nullable
    public Object call(@NotNull Object[] objArr) {
        Object invoke;
        b41.i(objArr, "args");
        C9430a c9430a = this.a;
        n31 a = c9430a.a();
        Method[] b = c9430a.b();
        Method c = c9430a.c();
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        b41.h(copyOf, "java.util.Arrays.copyOf(this, size)");
        Objects.requireNonNull(copyOf, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        int a2 = a.a();
        int b2 = a.b();
        if (a2 <= b2) {
            while (true) {
                Method method = b[a2];
                Object obj = objArr[a2];
                if (method != null) {
                    if (obj != null) {
                        obj = method.invoke(obj, new Object[0]);
                    } else {
                        Class<?> returnType = method.getReturnType();
                        b41.h(returnType, "method.returnType");
                        obj = zv2.g(returnType);
                    }
                }
                copyOf[a2] = obj;
                if (a2 == b2) {
                    break;
                }
                a2++;
            }
        }
        Object call = this.b.call(copyOf);
        return (c == null || (invoke = c.invoke(null, call)) == null) ? call : invoke;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public M getMember() {
        return this.b.getMember();
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    @NotNull
    public List<Type> getParameterTypes() {
        return this.b.getParameterTypes();
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    @NotNull
    public Type getReturnType() {
        return this.b.getReturnType();
    }
}
