package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import com.huawei.hms.opendevice.AbstractC5658c;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.kk;
import tb.r81;
import tb.t81;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class LazyJavaTypeParameterResolver implements TypeParameterResolver {
    @NotNull
    private final r81 a;
    @NotNull
    private final DeclarationDescriptor b;
    private final int c;
    @NotNull
    private final Map<JavaTypeParameter, Integer> d;
    @NotNull
    private final MemoizedFunctionToNullable<JavaTypeParameter, t81> e;

    public LazyJavaTypeParameterResolver(@NotNull r81 r81Var, @NotNull DeclarationDescriptor declarationDescriptor, @NotNull JavaTypeParameterListOwner javaTypeParameterListOwner, int i) {
        b41.i(r81Var, AbstractC5658c.a);
        b41.i(declarationDescriptor, "containingDeclaration");
        b41.i(javaTypeParameterListOwner, "typeParameterOwner");
        this.a = r81Var;
        this.b = declarationDescriptor;
        this.c = i;
        this.d = kk.d(javaTypeParameterListOwner.getTypeParameters());
        this.e = r81Var.e().createMemoizedFunctionWithNullableValues(new Function1<JavaTypeParameter, t81>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaTypeParameterResolver$resolve$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final t81 invoke(@NotNull JavaTypeParameter javaTypeParameter) {
                Map map;
                r81 r81Var2;
                DeclarationDescriptor declarationDescriptor2;
                int i2;
                DeclarationDescriptor declarationDescriptor3;
                b41.i(javaTypeParameter, "typeParameter");
                map = LazyJavaTypeParameterResolver.this.d;
                Integer num = (Integer) map.get(javaTypeParameter);
                if (num == null) {
                    return null;
                }
                LazyJavaTypeParameterResolver lazyJavaTypeParameterResolver = LazyJavaTypeParameterResolver.this;
                int intValue = num.intValue();
                r81Var2 = lazyJavaTypeParameterResolver.a;
                r81 b = ContextKt.b(r81Var2, lazyJavaTypeParameterResolver);
                declarationDescriptor2 = lazyJavaTypeParameterResolver.b;
                r81 h = ContextKt.h(b, declarationDescriptor2.getAnnotations());
                i2 = lazyJavaTypeParameterResolver.c;
                int i3 = i2 + intValue;
                declarationDescriptor3 = lazyJavaTypeParameterResolver.b;
                return new t81(h, javaTypeParameter, i3, declarationDescriptor3);
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver
    @Nullable
    public TypeParameterDescriptor resolveTypeParameter(@NotNull JavaTypeParameter javaTypeParameter) {
        b41.i(javaTypeParameter, "javaTypeParameter");
        t81 invoke = this.e.invoke(javaTypeParameter);
        return invoke == null ? this.a.f().resolveTypeParameter(javaTypeParameter) : invoke;
    }
}
