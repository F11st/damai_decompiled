package tb;

import com.vivo.push.PushClientConstants;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class z61 implements DeserializedContainerSource {
    @NotNull
    private final t61 a;
    @Nullable
    private final t61 b;
    @Nullable
    private final KotlinJvmBinaryClass c;

    public z61(@NotNull t61 t61Var, @Nullable t61 t61Var2, @NotNull ProtoBuf$Package protoBuf$Package, @NotNull NameResolver nameResolver, @Nullable g21<x61> g21Var, boolean z, @NotNull DeserializedContainerAbiStability deserializedContainerAbiStability, @Nullable KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        b41.i(t61Var, PushClientConstants.TAG_CLASS_NAME);
        b41.i(protoBuf$Package, "packageProto");
        b41.i(nameResolver, "nameResolver");
        b41.i(deserializedContainerAbiStability, "abiStability");
        this.a = t61Var;
        this.b = t61Var2;
        this.c = kotlinJvmBinaryClass;
        GeneratedMessageLite.c<ProtoBuf$Package, Integer> cVar = JvmProtoBuf.packageModuleName;
        b41.h(cVar, "packageModuleName");
        Integer num = (Integer) fx1.a(protoBuf$Package, cVar);
        if (num == null) {
            return;
        }
        nameResolver.getString(num.intValue());
    }

    @NotNull
    public final hj a() {
        return new hj(this.a.g(), d());
    }

    @Nullable
    public final t61 b() {
        return this.b;
    }

    @Nullable
    public final KotlinJvmBinaryClass c() {
        return this.c;
    }

    @NotNull
    public final ni1 d() {
        String G0;
        String f = this.a.f();
        b41.h(f, "className.internalName");
        G0 = StringsKt__StringsKt.G0(f, r10.DIR, null, 2, null);
        ni1 f2 = ni1.f(G0);
        b41.h(f2, "identifier(className.int….substringAfterLast('/'))");
        return f2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.SourceElement
    @NotNull
    public SourceFile getContainingFile() {
        SourceFile sourceFile = SourceFile.NO_SOURCE_FILE;
        b41.h(sourceFile, "NO_SOURCE_FILE");
        return sourceFile;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource
    @NotNull
    public String getPresentableString() {
        return "Class '" + a().b().b() + '\'';
    }

    @NotNull
    public String toString() {
        return ((Object) z61.class.getSimpleName()) + ": " + this.a;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public z61(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass r11, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package r12, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r13, @org.jetbrains.annotations.Nullable tb.g21<tb.x61> r14, boolean r15, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability r16) {
        /*
            r10 = this;
            java.lang.String r0 = "kotlinClass"
            r9 = r11
            tb.b41.i(r11, r0)
            java.lang.String r0 = "packageProto"
            r4 = r12
            tb.b41.i(r12, r0)
            java.lang.String r0 = "nameResolver"
            r5 = r13
            tb.b41.i(r13, r0)
            java.lang.String r0 = "abiStability"
            r8 = r16
            tb.b41.i(r8, r0)
            tb.hj r0 = r11.getClassId()
            tb.t61 r2 = tb.t61.b(r0)
            java.lang.String r0 = "byClassId(kotlinClass.classId)"
            tb.b41.h(r2, r0)
            kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader r0 = r11.getClassHeader()
            java.lang.String r0 = r0.e()
            r1 = 0
            if (r0 != 0) goto L33
        L31:
            r3 = r1
            goto L43
        L33:
            int r3 = r0.length()
            if (r3 <= 0) goto L3b
            r3 = 1
            goto L3c
        L3b:
            r3 = 0
        L3c:
            if (r3 == 0) goto L31
            tb.t61 r1 = tb.t61.d(r0)
            goto L31
        L43:
            r1 = r10
            r4 = r12
            r5 = r13
            r6 = r14
            r7 = r15
            r8 = r16
            r9 = r11
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.z61.<init>(kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver, tb.g21, boolean, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability):void");
    }
}
