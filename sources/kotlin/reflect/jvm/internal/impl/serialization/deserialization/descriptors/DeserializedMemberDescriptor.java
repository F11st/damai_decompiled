package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.DeserializedDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.er2;
import tb.hx2;
import tb.ix2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface DeserializedMemberDescriptor extends DeserializedDescriptor, MemberDescriptor, DescriptorWithContainerSource {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public enum CoroutinesCompatibilityMode {
        COMPATIBLE,
        NEEDS_WRAPPER,
        INCOMPATIBLE
    }

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor$a */
    /* loaded from: classes3.dex */
    public static final class C8513a {
        @NotNull
        public static List<hx2> a(@NotNull DeserializedMemberDescriptor deserializedMemberDescriptor) {
            b41.i(deserializedMemberDescriptor, "this");
            return hx2.Companion.a(deserializedMemberDescriptor.getProto(), deserializedMemberDescriptor.getNameResolver(), deserializedMemberDescriptor.getVersionRequirementTable());
        }
    }

    @Nullable
    DeserializedContainerSource getContainerSource();

    @NotNull
    NameResolver getNameResolver();

    @NotNull
    MessageLite getProto();

    @NotNull
    er2 getTypeTable();

    @NotNull
    ix2 getVersionRequirementTable();

    @NotNull
    List<hx2> getVersionRequirements();
}
