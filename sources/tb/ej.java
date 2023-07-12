package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ej {
    @NotNull
    private final NameResolver a;
    @NotNull
    private final ProtoBuf$Class b;
    @NotNull
    private final AbstractC9135fc c;
    @NotNull
    private final SourceElement d;

    public ej(@NotNull NameResolver nameResolver, @NotNull ProtoBuf$Class protoBuf$Class, @NotNull AbstractC9135fc abstractC9135fc, @NotNull SourceElement sourceElement) {
        b41.i(nameResolver, "nameResolver");
        b41.i(protoBuf$Class, "classProto");
        b41.i(abstractC9135fc, "metadataVersion");
        b41.i(sourceElement, "sourceElement");
        this.a = nameResolver;
        this.b = protoBuf$Class;
        this.c = abstractC9135fc;
        this.d = sourceElement;
    }

    @NotNull
    public final NameResolver a() {
        return this.a;
    }

    @NotNull
    public final ProtoBuf$Class b() {
        return this.b;
    }

    @NotNull
    public final AbstractC9135fc c() {
        return this.c;
    }

    @NotNull
    public final SourceElement d() {
        return this.d;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ej) {
            ej ejVar = (ej) obj;
            return b41.d(this.a, ejVar.a) && b41.d(this.b, ejVar.b) && b41.d(this.c, ejVar.c) && b41.d(this.d, ejVar.d);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    @NotNull
    public String toString() {
        return "ClassData(nameResolver=" + this.a + ", classProto=" + this.b + ", metadataVersion=" + this.c + ", sourceElement=" + this.d + ')';
    }
}
