package tb;

import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ik {
    @NotNull
    public static final ik INSTANCE = new ik();
    @JvmField
    public static final boolean brittleContainsOptimizationEnabled;

    static {
        String property = System.getProperty("kotlin.collections.convert_arg_to_set_in_removeAll");
        brittleContainsOptimizationEnabled = property != null ? Boolean.parseBoolean(property) : false;
    }

    private ik() {
    }
}
