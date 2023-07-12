package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.fn;
import tb.hp0;
import tb.ni1;
import tb.z71;

/* compiled from: Taobao */
/* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.annotations.a */
/* loaded from: classes3.dex */
public class C8306a implements AnnotationDescriptor {
    private final z71 a;
    private final Map<ni1, fn<?>> b;
    private final SourceElement c;

    public C8306a(@NotNull z71 z71Var, @NotNull Map<ni1, fn<?>> map, @NotNull SourceElement sourceElement) {
        if (z71Var == null) {
            a(0);
        }
        if (map == null) {
            a(1);
        }
        if (sourceElement == null) {
            a(2);
        }
        this.a = z71Var;
        this.b = map;
        this.c = sourceElement;
    }

    private static /* synthetic */ void a(int i) {
        String str = (i == 3 || i == 4 || i == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 3 || i == 4 || i == 5) ? 2 : 3];
        if (i == 1) {
            objArr[0] = "valueArguments";
        } else if (i == 2) {
            objArr[0] = "source";
        } else if (i == 3 || i == 4 || i == 5) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        } else {
            objArr[0] = "annotationType";
        }
        if (i == 3) {
            objArr[1] = "getType";
        } else if (i == 4) {
            objArr[1] = "getAllValueArguments";
        } else if (i != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        } else {
            objArr[1] = "getSource";
        }
        if (i != 3 && i != 4 && i != 5) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        if (i != 3 && i != 4 && i != 5) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    @NotNull
    public Map<ni1, fn<?>> getAllValueArguments() {
        Map<ni1, fn<?>> map = this.b;
        if (map == null) {
            a(4);
        }
        return map;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    @Nullable
    public hp0 getFqName() {
        return AnnotationDescriptor.C8301a.a(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    @NotNull
    public SourceElement getSource() {
        SourceElement sourceElement = this.c;
        if (sourceElement == null) {
            a(5);
        }
        return sourceElement;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    @NotNull
    public z71 getType() {
        z71 z71Var = this.a;
        if (z71Var == null) {
            a(3);
        }
        return z71Var;
    }

    public String toString() {
        return DescriptorRenderer.FQ_NAMES_IN_TYPES.b(this, null);
    }
}
