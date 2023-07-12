package tb;

import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.reflect.jvm.internal.calls.Caller;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class an2 implements Caller {
    @NotNull
    public static final an2 INSTANCE = new an2();

    private an2() {
    }

    @Nullable
    public Void a() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    @Nullable
    public Object call(@NotNull Object[] objArr) {
        b41.i(objArr, "args");
        throw new UnsupportedOperationException("call/callBy are not supported for this declaration.");
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public /* bridge */ /* synthetic */ Member getMember() {
        return (Member) a();
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    @NotNull
    public List<Type> getParameterTypes() {
        List<Type> g;
        g = kotlin.collections.m.g();
        return g;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    @NotNull
    public Type getReturnType() {
        Class cls = Void.TYPE;
        b41.h(cls, "Void.TYPE");
        return cls;
    }
}
