package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.builtins.b;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.fd2;
import tb.fn;
import tb.hp0;
import tb.ni1;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class BuiltInAnnotationDescriptor implements AnnotationDescriptor {
    @NotNull
    private final b a;
    @NotNull
    private final hp0 b;
    @NotNull
    private final Map<ni1, fn<?>> c;
    @NotNull
    private final Lazy d;

    /* JADX WARN: Multi-variable type inference failed */
    public BuiltInAnnotationDescriptor(@NotNull b bVar, @NotNull hp0 hp0Var, @NotNull Map<ni1, ? extends fn<?>> map) {
        Lazy a;
        b41.i(bVar, "builtIns");
        b41.i(hp0Var, "fqName");
        b41.i(map, "allValueArguments");
        this.a = bVar;
        this.b = hp0Var;
        this.c = map;
        a = kotlin.b.a(LazyThreadSafetyMode.PUBLICATION, new Function0<fd2>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.annotations.BuiltInAnnotationDescriptor$type$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final fd2 invoke() {
                b bVar2;
                bVar2 = BuiltInAnnotationDescriptor.this.a;
                return bVar2.o(BuiltInAnnotationDescriptor.this.getFqName()).getDefaultType();
            }
        });
        this.d = a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    @NotNull
    public Map<ni1, fn<?>> getAllValueArguments() {
        return this.c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    @NotNull
    public hp0 getFqName() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    @NotNull
    public SourceElement getSource() {
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        b41.h(sourceElement, "NO_SOURCE");
        return sourceElement;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    @NotNull
    public z71 getType() {
        Object value = this.d.getValue();
        b41.h(value, "<get-type>(...)");
        return (z71) value;
    }
}
