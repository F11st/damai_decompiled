package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.fd2;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface FlexibleTypeDeserializer {

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer$a */
    /* loaded from: classes3.dex */
    public static final class C8509a implements FlexibleTypeDeserializer {
        @NotNull
        public static final C8509a INSTANCE = new C8509a();

        private C8509a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer
        @NotNull
        public z71 create(@NotNull ProtoBuf$Type protoBuf$Type, @NotNull String str, @NotNull fd2 fd2Var, @NotNull fd2 fd2Var2) {
            b41.i(protoBuf$Type, "proto");
            b41.i(str, "flexibleId");
            b41.i(fd2Var, "lowerBound");
            b41.i(fd2Var2, "upperBound");
            throw new IllegalArgumentException("This method should not be used.");
        }
    }

    @NotNull
    z71 create(@NotNull ProtoBuf$Type protoBuf$Type, @NotNull String str, @NotNull fd2 fd2Var, @NotNull fd2 fd2Var2);
}
