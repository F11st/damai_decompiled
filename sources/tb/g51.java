package tb;

import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class g51 implements FlexibleTypeDeserializer {
    @NotNull
    public static final g51 INSTANCE = new g51();

    private g51() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer
    @NotNull
    public z71 create(@NotNull ProtoBuf$Type protoBuf$Type, @NotNull String str, @NotNull fd2 fd2Var, @NotNull fd2 fd2Var2) {
        b41.i(protoBuf$Type, "proto");
        b41.i(str, "flexibleId");
        b41.i(fd2Var, "lowerBound");
        b41.i(fd2Var2, "upperBound");
        if (!b41.d(str, "kotlin.jvm.PlatformType")) {
            fd2 j = kf0.j("Error java flexible type with id: " + str + ". (" + fd2Var + ".." + fd2Var2 + ')');
            b41.h(j, "createErrorType(\"Error j…owerBound..$upperBound)\")");
            return j;
        } else if (protoBuf$Type.hasExtension(JvmProtoBuf.isRaw)) {
            return new RawTypeImpl(fd2Var, fd2Var2);
        } else {
            return KotlinTypeFactory.d(fd2Var, fd2Var2);
        }
    }
}
