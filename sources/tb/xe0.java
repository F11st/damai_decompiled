package tb;

import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class xe0 extends fn<Pair<? extends hj, ? extends ni1>> {
    @NotNull
    private final hj b;
    @NotNull
    private final ni1 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xe0(@NotNull hj hjVar, @NotNull ni1 ni1Var) {
        super(hq2.a(hjVar, ni1Var));
        b41.i(hjVar, "enumClassId");
        b41.i(ni1Var, "enumEntryName");
        this.b = hjVar;
        this.c = ni1Var;
    }

    @Override // tb.fn
    @NotNull
    public z71 a(@NotNull ModuleDescriptor moduleDescriptor) {
        b41.i(moduleDescriptor, "module");
        ClassDescriptor a = FindClassInModuleKt.a(moduleDescriptor, this.b);
        fd2 fd2Var = null;
        if (a != null) {
            if (!d70.A(a)) {
                a = null;
            }
            if (a != null) {
                fd2Var = a.getDefaultType();
            }
        }
        if (fd2Var == null) {
            fd2 j = kf0.j("Containing class for error-class based enum entry " + this.b + '.' + this.c);
            b41.h(j, "createErrorType(\"Contain…mClassId.$enumEntryName\")");
            return j;
        }
        return fd2Var;
    }

    @NotNull
    public final ni1 c() {
        return this.c;
    }

    @Override // tb.fn
    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.b.j());
        sb.append('.');
        sb.append(this.c);
        return sb.toString();
    }
}
