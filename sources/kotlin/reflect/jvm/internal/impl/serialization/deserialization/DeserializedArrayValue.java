package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.fn;
import tb.y7;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class DeserializedArrayValue extends y7 {
    @NotNull
    private final z71 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedArrayValue(@NotNull List<? extends fn<?>> list, @NotNull final z71 z71Var) {
        super(list, new Function1<ModuleDescriptor, z71>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedArrayValue.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final z71 invoke(@NotNull ModuleDescriptor moduleDescriptor) {
                b41.i(moduleDescriptor, AdvanceSetting.NETWORK_TYPE);
                return z71.this;
            }
        });
        b41.i(list, "value");
        b41.i(z71Var, "type");
        this.c = z71Var;
    }

    @NotNull
    public final z71 c() {
        return this.c;
    }
}
