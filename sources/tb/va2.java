package tb;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class va2 {
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.protobuf.c a;
    @NotNull
    private final GeneratedMessageLite.c<ProtoBuf$Constructor, List<ProtoBuf$Annotation>> b;
    @NotNull
    private final GeneratedMessageLite.c<ProtoBuf$Class, List<ProtoBuf$Annotation>> c;
    @NotNull
    private final GeneratedMessageLite.c<ProtoBuf$Function, List<ProtoBuf$Annotation>> d;
    @NotNull
    private final GeneratedMessageLite.c<ProtoBuf$Property, List<ProtoBuf$Annotation>> e;
    @NotNull
    private final GeneratedMessageLite.c<ProtoBuf$Property, List<ProtoBuf$Annotation>> f;
    @NotNull
    private final GeneratedMessageLite.c<ProtoBuf$Property, List<ProtoBuf$Annotation>> g;
    @NotNull
    private final GeneratedMessageLite.c<ProtoBuf$EnumEntry, List<ProtoBuf$Annotation>> h;
    @NotNull
    private final GeneratedMessageLite.c<ProtoBuf$Property, ProtoBuf$Annotation.Argument.Value> i;
    @NotNull
    private final GeneratedMessageLite.c<ProtoBuf$ValueParameter, List<ProtoBuf$Annotation>> j;
    @NotNull
    private final GeneratedMessageLite.c<ProtoBuf$Type, List<ProtoBuf$Annotation>> k;
    @NotNull
    private final GeneratedMessageLite.c<ProtoBuf$TypeParameter, List<ProtoBuf$Annotation>> l;

    public va2(@NotNull kotlin.reflect.jvm.internal.impl.protobuf.c cVar, @NotNull GeneratedMessageLite.c<ProtoBuf$Package, Integer> cVar2, @NotNull GeneratedMessageLite.c<ProtoBuf$Constructor, List<ProtoBuf$Annotation>> cVar3, @NotNull GeneratedMessageLite.c<ProtoBuf$Class, List<ProtoBuf$Annotation>> cVar4, @NotNull GeneratedMessageLite.c<ProtoBuf$Function, List<ProtoBuf$Annotation>> cVar5, @NotNull GeneratedMessageLite.c<ProtoBuf$Property, List<ProtoBuf$Annotation>> cVar6, @NotNull GeneratedMessageLite.c<ProtoBuf$Property, List<ProtoBuf$Annotation>> cVar7, @NotNull GeneratedMessageLite.c<ProtoBuf$Property, List<ProtoBuf$Annotation>> cVar8, @NotNull GeneratedMessageLite.c<ProtoBuf$EnumEntry, List<ProtoBuf$Annotation>> cVar9, @NotNull GeneratedMessageLite.c<ProtoBuf$Property, ProtoBuf$Annotation.Argument.Value> cVar10, @NotNull GeneratedMessageLite.c<ProtoBuf$ValueParameter, List<ProtoBuf$Annotation>> cVar11, @NotNull GeneratedMessageLite.c<ProtoBuf$Type, List<ProtoBuf$Annotation>> cVar12, @NotNull GeneratedMessageLite.c<ProtoBuf$TypeParameter, List<ProtoBuf$Annotation>> cVar13) {
        b41.i(cVar, "extensionRegistry");
        b41.i(cVar2, "packageFqName");
        b41.i(cVar3, "constructorAnnotation");
        b41.i(cVar4, "classAnnotation");
        b41.i(cVar5, "functionAnnotation");
        b41.i(cVar6, "propertyAnnotation");
        b41.i(cVar7, "propertyGetterAnnotation");
        b41.i(cVar8, "propertySetterAnnotation");
        b41.i(cVar9, "enumEntryAnnotation");
        b41.i(cVar10, "compileTimeValue");
        b41.i(cVar11, "parameterAnnotation");
        b41.i(cVar12, "typeAnnotation");
        b41.i(cVar13, "typeParameterAnnotation");
        this.a = cVar;
        this.b = cVar3;
        this.c = cVar4;
        this.d = cVar5;
        this.e = cVar6;
        this.f = cVar7;
        this.g = cVar8;
        this.h = cVar9;
        this.i = cVar10;
        this.j = cVar11;
        this.k = cVar12;
        this.l = cVar13;
    }

    @NotNull
    public final GeneratedMessageLite.c<ProtoBuf$Class, List<ProtoBuf$Annotation>> a() {
        return this.c;
    }

    @NotNull
    public final GeneratedMessageLite.c<ProtoBuf$Property, ProtoBuf$Annotation.Argument.Value> b() {
        return this.i;
    }

    @NotNull
    public final GeneratedMessageLite.c<ProtoBuf$Constructor, List<ProtoBuf$Annotation>> c() {
        return this.b;
    }

    @NotNull
    public final GeneratedMessageLite.c<ProtoBuf$EnumEntry, List<ProtoBuf$Annotation>> d() {
        return this.h;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.protobuf.c e() {
        return this.a;
    }

    @NotNull
    public final GeneratedMessageLite.c<ProtoBuf$Function, List<ProtoBuf$Annotation>> f() {
        return this.d;
    }

    @NotNull
    public final GeneratedMessageLite.c<ProtoBuf$ValueParameter, List<ProtoBuf$Annotation>> g() {
        return this.j;
    }

    @NotNull
    public final GeneratedMessageLite.c<ProtoBuf$Property, List<ProtoBuf$Annotation>> h() {
        return this.e;
    }

    @NotNull
    public final GeneratedMessageLite.c<ProtoBuf$Property, List<ProtoBuf$Annotation>> i() {
        return this.f;
    }

    @NotNull
    public final GeneratedMessageLite.c<ProtoBuf$Property, List<ProtoBuf$Annotation>> j() {
        return this.g;
    }

    @NotNull
    public final GeneratedMessageLite.c<ProtoBuf$Type, List<ProtoBuf$Annotation>> k() {
        return this.k;
    }

    @NotNull
    public final GeneratedMessageLite.c<ProtoBuf$TypeParameter, List<ProtoBuf$Annotation>> l() {
        return this.l;
    }
}
