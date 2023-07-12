package tb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class t81 extends t1 {
    @NotNull
    private final r81 k;
    @NotNull
    private final JavaTypeParameter l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t81(@NotNull r81 r81Var, @NotNull JavaTypeParameter javaTypeParameter, int i, @NotNull DeclarationDescriptor declarationDescriptor) {
        super(r81Var.e(), declarationDescriptor, new LazyJavaAnnotations(r81Var, javaTypeParameter, false, 4, null), javaTypeParameter.getName(), Variance.INVARIANT, false, i, SourceElement.NO_SOURCE, r81Var.a().v());
        b41.i(r81Var, com.huawei.hms.opendevice.c.a);
        b41.i(javaTypeParameter, "javaTypeParameter");
        b41.i(declarationDescriptor, "containingDeclaration");
        this.k = r81Var;
        this.l = javaTypeParameter;
    }

    private final List<z71> g() {
        int q;
        List<z71> e;
        Collection<JavaClassifierType> upperBounds = this.l.getUpperBounds();
        if (upperBounds.isEmpty()) {
            fd2 i = this.k.d().getBuiltIns().i();
            b41.h(i, "c.module.builtIns.anyType");
            fd2 I = this.k.d().getBuiltIns().I();
            b41.h(I, "c.module.builtIns.nullableAnyType");
            e = kotlin.collections.l.e(KotlinTypeFactory.d(i, I));
            return e;
        }
        q = kotlin.collections.n.q(upperBounds, 10);
        ArrayList arrayList = new ArrayList(q);
        for (JavaClassifierType javaClassifierType : upperBounds) {
            arrayList.add(this.k.g().o(javaClassifierType, u51.d(TypeUsage.COMMON, false, this, 1, null)));
        }
        return arrayList;
    }

    @Override // tb.o2
    @NotNull
    protected List<z71> d(@NotNull List<? extends z71> list) {
        b41.i(list, "bounds");
        return this.k.a().r().g(this, list, this.k);
    }

    @Override // tb.o2
    protected void e(@NotNull z71 z71Var) {
        b41.i(z71Var, "type");
    }

    @Override // tb.o2
    @NotNull
    protected List<z71> f() {
        return g();
    }
}
