package kotlin.reflect.jvm.internal.impl.descriptors;

import org.jetbrains.annotations.Nullable;
import tb.fn;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface VariableDescriptor extends ValueDescriptor {
    @Nullable
    fn<?> getCompileTimeInitializer();

    boolean isConst();

    boolean isLateInit();

    boolean isVar();
}
