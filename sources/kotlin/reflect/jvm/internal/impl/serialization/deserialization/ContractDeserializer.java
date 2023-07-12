package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.er2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface ContractDeserializer {
    @NotNull
    public static final C8504a Companion = C8504a.a;

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer$a */
    /* loaded from: classes3.dex */
    public static final class C8504a {
        static final /* synthetic */ C8504a a = new C8504a();
        @NotNull
        private static final ContractDeserializer b = new C8505a();

        /* compiled from: Taobao */
        /* renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer$a$a */
        /* loaded from: classes3.dex */
        public static final class C8505a implements ContractDeserializer {
            C8505a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer
            @Nullable
            public Pair deserializeContractFromFunction(@NotNull ProtoBuf$Function protoBuf$Function, @NotNull FunctionDescriptor functionDescriptor, @NotNull er2 er2Var, @NotNull TypeDeserializer typeDeserializer) {
                b41.i(protoBuf$Function, "proto");
                b41.i(functionDescriptor, "ownerFunction");
                b41.i(er2Var, "typeTable");
                b41.i(typeDeserializer, "typeDeserializer");
                return null;
            }
        }

        private C8504a() {
        }

        @NotNull
        public final ContractDeserializer a() {
            return b;
        }
    }

    @Nullable
    Pair<CallableDescriptor.UserDataKey<?>, Object> deserializeContractFromFunction(@NotNull ProtoBuf$Function protoBuf$Function, @NotNull FunctionDescriptor functionDescriptor, @NotNull er2 er2Var, @NotNull TypeDeserializer typeDeserializer);
}
