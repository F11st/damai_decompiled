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
import kotlin.reflect.jvm.internal.impl.protobuf.C8447c;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class va2 {
    @NotNull
    private final C8447c a;
    @NotNull
    private final GeneratedMessageLite.C8441c<ProtoBuf$Constructor, List<ProtoBuf$Annotation>> b;
    @NotNull
    private final GeneratedMessageLite.C8441c<ProtoBuf$Class, List<ProtoBuf$Annotation>> c;
    @NotNull
    private final GeneratedMessageLite.C8441c<ProtoBuf$Function, List<ProtoBuf$Annotation>> d;
    @NotNull
    private final GeneratedMessageLite.C8441c<ProtoBuf$Property, List<ProtoBuf$Annotation>> e;
    @NotNull
    private final GeneratedMessageLite.C8441c<ProtoBuf$Property, List<ProtoBuf$Annotation>> f;
    @NotNull
    private final GeneratedMessageLite.C8441c<ProtoBuf$Property, List<ProtoBuf$Annotation>> g;
    @NotNull
    private final GeneratedMessageLite.C8441c<ProtoBuf$EnumEntry, List<ProtoBuf$Annotation>> h;
    @NotNull
    private final GeneratedMessageLite.C8441c<ProtoBuf$Property, ProtoBuf$Annotation.Argument.Value> i;
    @NotNull
    private final GeneratedMessageLite.C8441c<ProtoBuf$ValueParameter, List<ProtoBuf$Annotation>> j;
    @NotNull
    private final GeneratedMessageLite.C8441c<ProtoBuf$Type, List<ProtoBuf$Annotation>> k;
    @NotNull
    private final GeneratedMessageLite.C8441c<ProtoBuf$TypeParameter, List<ProtoBuf$Annotation>> l;

    public va2(@NotNull C8447c c8447c, @NotNull GeneratedMessageLite.C8441c<ProtoBuf$Package, Integer> c8441c, @NotNull GeneratedMessageLite.C8441c<ProtoBuf$Constructor, List<ProtoBuf$Annotation>> c8441c2, @NotNull GeneratedMessageLite.C8441c<ProtoBuf$Class, List<ProtoBuf$Annotation>> c8441c3, @NotNull GeneratedMessageLite.C8441c<ProtoBuf$Function, List<ProtoBuf$Annotation>> c8441c4, @NotNull GeneratedMessageLite.C8441c<ProtoBuf$Property, List<ProtoBuf$Annotation>> c8441c5, @NotNull GeneratedMessageLite.C8441c<ProtoBuf$Property, List<ProtoBuf$Annotation>> c8441c6, @NotNull GeneratedMessageLite.C8441c<ProtoBuf$Property, List<ProtoBuf$Annotation>> c8441c7, @NotNull GeneratedMessageLite.C8441c<ProtoBuf$EnumEntry, List<ProtoBuf$Annotation>> c8441c8, @NotNull GeneratedMessageLite.C8441c<ProtoBuf$Property, ProtoBuf$Annotation.Argument.Value> c8441c9, @NotNull GeneratedMessageLite.C8441c<ProtoBuf$ValueParameter, List<ProtoBuf$Annotation>> c8441c10, @NotNull GeneratedMessageLite.C8441c<ProtoBuf$Type, List<ProtoBuf$Annotation>> c8441c11, @NotNull GeneratedMessageLite.C8441c<ProtoBuf$TypeParameter, List<ProtoBuf$Annotation>> c8441c12) {
        b41.i(c8447c, "extensionRegistry");
        b41.i(c8441c, "packageFqName");
        b41.i(c8441c2, "constructorAnnotation");
        b41.i(c8441c3, "classAnnotation");
        b41.i(c8441c4, "functionAnnotation");
        b41.i(c8441c5, "propertyAnnotation");
        b41.i(c8441c6, "propertyGetterAnnotation");
        b41.i(c8441c7, "propertySetterAnnotation");
        b41.i(c8441c8, "enumEntryAnnotation");
        b41.i(c8441c9, "compileTimeValue");
        b41.i(c8441c10, "parameterAnnotation");
        b41.i(c8441c11, "typeAnnotation");
        b41.i(c8441c12, "typeParameterAnnotation");
        this.a = c8447c;
        this.b = c8441c2;
        this.c = c8441c3;
        this.d = c8441c4;
        this.e = c8441c5;
        this.f = c8441c6;
        this.g = c8441c7;
        this.h = c8441c8;
        this.i = c8441c9;
        this.j = c8441c10;
        this.k = c8441c11;
        this.l = c8441c12;
    }

    @NotNull
    public final GeneratedMessageLite.C8441c<ProtoBuf$Class, List<ProtoBuf$Annotation>> a() {
        return this.c;
    }

    @NotNull
    public final GeneratedMessageLite.C8441c<ProtoBuf$Property, ProtoBuf$Annotation.Argument.Value> b() {
        return this.i;
    }

    @NotNull
    public final GeneratedMessageLite.C8441c<ProtoBuf$Constructor, List<ProtoBuf$Annotation>> c() {
        return this.b;
    }

    @NotNull
    public final GeneratedMessageLite.C8441c<ProtoBuf$EnumEntry, List<ProtoBuf$Annotation>> d() {
        return this.h;
    }

    @NotNull
    public final C8447c e() {
        return this.a;
    }

    @NotNull
    public final GeneratedMessageLite.C8441c<ProtoBuf$Function, List<ProtoBuf$Annotation>> f() {
        return this.d;
    }

    @NotNull
    public final GeneratedMessageLite.C8441c<ProtoBuf$ValueParameter, List<ProtoBuf$Annotation>> g() {
        return this.j;
    }

    @NotNull
    public final GeneratedMessageLite.C8441c<ProtoBuf$Property, List<ProtoBuf$Annotation>> h() {
        return this.e;
    }

    @NotNull
    public final GeneratedMessageLite.C8441c<ProtoBuf$Property, List<ProtoBuf$Annotation>> i() {
        return this.f;
    }

    @NotNull
    public final GeneratedMessageLite.C8441c<ProtoBuf$Property, List<ProtoBuf$Annotation>> j() {
        return this.g;
    }

    @NotNull
    public final GeneratedMessageLite.C8441c<ProtoBuf$Type, List<ProtoBuf$Annotation>> k() {
        return this.k;
    }

    @NotNull
    public final GeneratedMessageLite.C8441c<ProtoBuf$TypeParameter, List<ProtoBuf$Annotation>> l() {
        return this.l;
    }
}
