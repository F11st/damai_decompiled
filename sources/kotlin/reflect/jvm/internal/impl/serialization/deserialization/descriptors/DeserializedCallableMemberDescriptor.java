package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.hx2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface DeserializedCallableMemberDescriptor extends CallableMemberDescriptor, DeserializedMemberDescriptor {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        @NotNull
        public static List<hx2> a(@NotNull DeserializedCallableMemberDescriptor deserializedCallableMemberDescriptor) {
            b41.i(deserializedCallableMemberDescriptor, "this");
            return DeserializedMemberDescriptor.a.a(deserializedCallableMemberDescriptor);
        }
    }
}
