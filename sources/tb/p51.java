package tb;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class p51 {
    @NotNull
    public static final p51 INSTANCE = new p51();

    private p51() {
    }

    public static /* synthetic */ ClassDescriptor h(p51 p51Var, hp0 hp0Var, kotlin.reflect.jvm.internal.impl.builtins.b bVar, Integer num, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        return p51Var.g(hp0Var, bVar, num);
    }

    @NotNull
    public final ClassDescriptor a(@NotNull ClassDescriptor classDescriptor) {
        b41.i(classDescriptor, "mutable");
        hp0 p = o51.INSTANCE.p(d70.m(classDescriptor));
        if (p != null) {
            ClassDescriptor o = DescriptorUtilsKt.g(classDescriptor).o(p);
            b41.h(o, "descriptor.builtIns.getB…Name(oppositeClassFqName)");
            return o;
        }
        throw new IllegalArgumentException("Given class " + classDescriptor + " is not a mutable collection");
    }

    @NotNull
    public final ClassDescriptor b(@NotNull ClassDescriptor classDescriptor) {
        b41.i(classDescriptor, "readOnly");
        hp0 q = o51.INSTANCE.q(d70.m(classDescriptor));
        if (q != null) {
            ClassDescriptor o = DescriptorUtilsKt.g(classDescriptor).o(q);
            b41.h(o, "descriptor.builtIns.getB…Name(oppositeClassFqName)");
            return o;
        }
        throw new IllegalArgumentException("Given class " + classDescriptor + " is not a read-only collection");
    }

    public final boolean c(@NotNull ClassDescriptor classDescriptor) {
        b41.i(classDescriptor, "mutable");
        return o51.INSTANCE.l(d70.m(classDescriptor));
    }

    public final boolean d(@NotNull z71 z71Var) {
        b41.i(z71Var, "type");
        ClassDescriptor g = fr2.g(z71Var);
        return g != null && c(g);
    }

    public final boolean e(@NotNull ClassDescriptor classDescriptor) {
        b41.i(classDescriptor, "readOnly");
        return o51.INSTANCE.m(d70.m(classDescriptor));
    }

    public final boolean f(@NotNull z71 z71Var) {
        b41.i(z71Var, "type");
        ClassDescriptor g = fr2.g(z71Var);
        return g != null && e(g);
    }

    @Nullable
    public final ClassDescriptor g(@NotNull hp0 hp0Var, @NotNull kotlin.reflect.jvm.internal.impl.builtins.b bVar, @Nullable Integer num) {
        b41.i(hp0Var, "fqName");
        b41.i(bVar, "builtIns");
        hj n = (num == null || !b41.d(hp0Var, o51.INSTANCE.i())) ? o51.INSTANCE.n(hp0Var) : kotlin.reflect.jvm.internal.impl.builtins.c.a(num.intValue());
        if (n != null) {
            return bVar.o(n.b());
        }
        return null;
    }

    @NotNull
    public final Collection<ClassDescriptor> i(@NotNull hp0 hp0Var, @NotNull kotlin.reflect.jvm.internal.impl.builtins.b bVar) {
        List j;
        Set c;
        Set d;
        b41.i(hp0Var, "fqName");
        b41.i(bVar, "builtIns");
        ClassDescriptor h = h(this, hp0Var, bVar, null, 4, null);
        if (h == null) {
            d = kotlin.collections.e0.d();
            return d;
        }
        hp0 q = o51.INSTANCE.q(DescriptorUtilsKt.j(h));
        if (q == null) {
            c = kotlin.collections.d0.c(h);
            return c;
        }
        ClassDescriptor o = bVar.o(q);
        b41.h(o, "builtIns.getBuiltInClass…otlinMutableAnalogFqName)");
        j = kotlin.collections.m.j(h, o);
        return j;
    }
}
