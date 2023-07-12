package tb;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.C8214m;
import kotlin.collections.C8215n;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.gx1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class z5 implements AnnotationAndConstantLoader<AnnotationDescriptor, fn<?>> {
    @NotNull
    private final va2 a;
    @NotNull
    private final a6 b;

    /* compiled from: Taobao */
    /* renamed from: tb.z5$a */
    /* loaded from: classes3.dex */
    public /* synthetic */ class C10013a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AnnotatedCallableKind.values().length];
            iArr[AnnotatedCallableKind.PROPERTY.ordinal()] = 1;
            iArr[AnnotatedCallableKind.PROPERTY_GETTER.ordinal()] = 2;
            iArr[AnnotatedCallableKind.PROPERTY_SETTER.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public z5(@NotNull ModuleDescriptor moduleDescriptor, @NotNull NotFoundClasses notFoundClasses, @NotNull va2 va2Var) {
        b41.i(moduleDescriptor, "module");
        b41.i(notFoundClasses, "notFoundClasses");
        b41.i(va2Var, "protocol");
        this.a = va2Var;
        this.b = new a6(moduleDescriptor, notFoundClasses);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    @Nullable
    /* renamed from: a */
    public fn<?> loadPropertyConstant(@NotNull gx1 gx1Var, @NotNull ProtoBuf$Property protoBuf$Property, @NotNull z71 z71Var) {
        b41.i(gx1Var, "container");
        b41.i(protoBuf$Property, "proto");
        b41.i(z71Var, "expectedType");
        ProtoBuf$Annotation.Argument.Value value = (ProtoBuf$Annotation.Argument.Value) fx1.a(protoBuf$Property, this.a.b());
        if (value == null) {
            return null;
        }
        return this.b.f(z71Var, value, gx1Var.b());
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    @NotNull
    public List<AnnotationDescriptor> loadCallableAnnotations(@NotNull gx1 gx1Var, @NotNull MessageLite messageLite, @NotNull AnnotatedCallableKind annotatedCallableKind) {
        List<ProtoBuf$Annotation> list;
        int q;
        b41.i(gx1Var, "container");
        b41.i(messageLite, "proto");
        b41.i(annotatedCallableKind, "kind");
        if (messageLite instanceof ProtoBuf$Constructor) {
            list = (List) ((ProtoBuf$Constructor) messageLite).getExtension(this.a.c());
        } else if (messageLite instanceof ProtoBuf$Function) {
            list = (List) ((ProtoBuf$Function) messageLite).getExtension(this.a.f());
        } else if (!(messageLite instanceof ProtoBuf$Property)) {
            throw new IllegalStateException(b41.r("Unknown message: ", messageLite).toString());
        } else {
            int i = C10013a.$EnumSwitchMapping$0[annotatedCallableKind.ordinal()];
            if (i == 1) {
                list = (List) ((ProtoBuf$Property) messageLite).getExtension(this.a.h());
            } else if (i == 2) {
                list = (List) ((ProtoBuf$Property) messageLite).getExtension(this.a.i());
            } else if (i == 3) {
                list = (List) ((ProtoBuf$Property) messageLite).getExtension(this.a.j());
            } else {
                throw new IllegalStateException("Unsupported callable kind with property proto".toString());
            }
        }
        if (list == null) {
            list = C8214m.g();
        }
        q = C8215n.q(list, 10);
        ArrayList arrayList = new ArrayList(q);
        for (ProtoBuf$Annotation protoBuf$Annotation : list) {
            arrayList.add(this.b.a(protoBuf$Annotation, gx1Var.b()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    @NotNull
    public List<AnnotationDescriptor> loadClassAnnotations(@NotNull gx1.C9189a c9189a) {
        int q;
        b41.i(c9189a, "container");
        List<ProtoBuf$Annotation> list = (List) c9189a.f().getExtension(this.a.a());
        if (list == null) {
            list = C8214m.g();
        }
        q = C8215n.q(list, 10);
        ArrayList arrayList = new ArrayList(q);
        for (ProtoBuf$Annotation protoBuf$Annotation : list) {
            arrayList.add(this.b.a(protoBuf$Annotation, c9189a.b()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    @NotNull
    public List<AnnotationDescriptor> loadEnumEntryAnnotations(@NotNull gx1 gx1Var, @NotNull ProtoBuf$EnumEntry protoBuf$EnumEntry) {
        int q;
        b41.i(gx1Var, "container");
        b41.i(protoBuf$EnumEntry, "proto");
        List<ProtoBuf$Annotation> list = (List) protoBuf$EnumEntry.getExtension(this.a.d());
        if (list == null) {
            list = C8214m.g();
        }
        q = C8215n.q(list, 10);
        ArrayList arrayList = new ArrayList(q);
        for (ProtoBuf$Annotation protoBuf$Annotation : list) {
            arrayList.add(this.b.a(protoBuf$Annotation, gx1Var.b()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    @NotNull
    public List<AnnotationDescriptor> loadExtensionReceiverParameterAnnotations(@NotNull gx1 gx1Var, @NotNull MessageLite messageLite, @NotNull AnnotatedCallableKind annotatedCallableKind) {
        List<AnnotationDescriptor> g;
        b41.i(gx1Var, "container");
        b41.i(messageLite, "proto");
        b41.i(annotatedCallableKind, "kind");
        g = C8214m.g();
        return g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    @NotNull
    public List<AnnotationDescriptor> loadPropertyBackingFieldAnnotations(@NotNull gx1 gx1Var, @NotNull ProtoBuf$Property protoBuf$Property) {
        List<AnnotationDescriptor> g;
        b41.i(gx1Var, "container");
        b41.i(protoBuf$Property, "proto");
        g = C8214m.g();
        return g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    @NotNull
    public List<AnnotationDescriptor> loadPropertyDelegateFieldAnnotations(@NotNull gx1 gx1Var, @NotNull ProtoBuf$Property protoBuf$Property) {
        List<AnnotationDescriptor> g;
        b41.i(gx1Var, "container");
        b41.i(protoBuf$Property, "proto");
        g = C8214m.g();
        return g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    @NotNull
    public List<AnnotationDescriptor> loadTypeAnnotations(@NotNull ProtoBuf$Type protoBuf$Type, @NotNull NameResolver nameResolver) {
        int q;
        b41.i(protoBuf$Type, "proto");
        b41.i(nameResolver, "nameResolver");
        List<ProtoBuf$Annotation> list = (List) protoBuf$Type.getExtension(this.a.k());
        if (list == null) {
            list = C8214m.g();
        }
        q = C8215n.q(list, 10);
        ArrayList arrayList = new ArrayList(q);
        for (ProtoBuf$Annotation protoBuf$Annotation : list) {
            arrayList.add(this.b.a(protoBuf$Annotation, nameResolver));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    @NotNull
    public List<AnnotationDescriptor> loadTypeParameterAnnotations(@NotNull ProtoBuf$TypeParameter protoBuf$TypeParameter, @NotNull NameResolver nameResolver) {
        int q;
        b41.i(protoBuf$TypeParameter, "proto");
        b41.i(nameResolver, "nameResolver");
        List<ProtoBuf$Annotation> list = (List) protoBuf$TypeParameter.getExtension(this.a.l());
        if (list == null) {
            list = C8214m.g();
        }
        q = C8215n.q(list, 10);
        ArrayList arrayList = new ArrayList(q);
        for (ProtoBuf$Annotation protoBuf$Annotation : list) {
            arrayList.add(this.b.a(protoBuf$Annotation, nameResolver));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    @NotNull
    public List<AnnotationDescriptor> loadValueParameterAnnotations(@NotNull gx1 gx1Var, @NotNull MessageLite messageLite, @NotNull AnnotatedCallableKind annotatedCallableKind, int i, @NotNull ProtoBuf$ValueParameter protoBuf$ValueParameter) {
        int q;
        b41.i(gx1Var, "container");
        b41.i(messageLite, "callableProto");
        b41.i(annotatedCallableKind, "kind");
        b41.i(protoBuf$ValueParameter, "proto");
        List<ProtoBuf$Annotation> list = (List) protoBuf$ValueParameter.getExtension(this.a.g());
        if (list == null) {
            list = C8214m.g();
        }
        q = C8215n.q(list, 10);
        ArrayList arrayList = new ArrayList(q);
        for (ProtoBuf$Annotation protoBuf$Annotation : list) {
            arrayList.add(this.b.a(protoBuf$Annotation, gx1Var.b()));
        }
        return arrayList;
    }
}
