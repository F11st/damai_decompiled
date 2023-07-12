package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.l;
import kotlin.collections.n;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.j70;
import tb.jx1;
import tb.k70;
import tb.t1;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class DeserializedTypeParameterDescriptor extends t1 {
    @NotNull
    private final j70 k;
    @NotNull
    private final ProtoBuf$TypeParameter l;
    @NotNull
    private final k70 m;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public DeserializedTypeParameterDescriptor(@org.jetbrains.annotations.NotNull tb.j70 r12, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter r13, int r14) {
        /*
            r11 = this;
            java.lang.String r0 = "c"
            tb.b41.i(r12, r0)
            java.lang.String r0 = "proto"
            tb.b41.i(r13, r0)
            kotlin.reflect.jvm.internal.impl.storage.StorageManager r2 = r12.h()
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r3 = r12.e()
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations$a r0 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r4 = r0.b()
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r0 = r12.g()
            int r1 = r13.getName()
            tb.ni1 r5 = tb.pi1.b(r0, r1)
            tb.hx1 r0 = tb.hx1.INSTANCE
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter$Variance r1 = r13.getVariance()
            java.lang.String r6 = "proto.variance"
            tb.b41.h(r1, r6)
            kotlin.reflect.jvm.internal.impl.types.Variance r6 = r0.d(r1)
            boolean r7 = r13.getReified()
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r9 = kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE
            kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker$a r10 = kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker.a.INSTANCE
            r1 = r11
            r8 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r11.k = r12
            r11.l = r13
            tb.k70 r13 = new tb.k70
            kotlin.reflect.jvm.internal.impl.storage.StorageManager r12 = r12.h()
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeParameterDescriptor$annotations$1 r14 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeParameterDescriptor$annotations$1
            r14.<init>()
            r13.<init>(r12, r14)
            r11.m = r13
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeParameterDescriptor.<init>(tb.j70, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter, int):void");
    }

    @Override // tb.o2
    @NotNull
    protected List<z71> f() {
        int q;
        List<z71> e;
        List<ProtoBuf$Type> p = jx1.p(this.l, this.k.j());
        if (p.isEmpty()) {
            e = l.e(DescriptorUtilsKt.g(this).y());
            return e;
        }
        TypeDeserializer i = this.k.i();
        q = n.q(p, 10);
        ArrayList arrayList = new ArrayList(q);
        for (ProtoBuf$Type protoBuf$Type : p) {
            arrayList.add(i.q(protoBuf$Type));
        }
        return arrayList;
    }

    @Override // tb.y5, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    @NotNull
    /* renamed from: h */
    public k70 getAnnotations() {
        return this.m;
    }

    @NotNull
    public final ProtoBuf$TypeParameter i() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tb.o2
    @NotNull
    /* renamed from: j */
    public Void e(@NotNull z71 z71Var) {
        b41.i(z71Var, "type");
        throw new IllegalStateException(b41.r("There should be no cycles for deserialized type parameters, but found for: ", this));
    }
}
