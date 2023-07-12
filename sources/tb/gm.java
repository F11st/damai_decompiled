package tb;

import com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class gm {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final gm INSTANCE = new gm();
    @Nullable
    private static ComponentFilterBridge a;

    private gm() {
    }

    @NotNull
    public final synchronized ComponentFilterBridge a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1548437647")) {
            return (ComponentFilterBridge) ipChange.ipc$dispatch("1548437647", new Object[]{this});
        }
        ComponentFilterBridge componentFilterBridge = a;
        if (componentFilterBridge == null) {
            componentFilterBridge = new ce0();
        }
        return componentFilterBridge;
    }

    public final synchronized void b(@NotNull ComponentFilterBridge componentFilterBridge) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-379707461")) {
            ipChange.ipc$dispatch("-379707461", new Object[]{this, componentFilterBridge});
            return;
        }
        b41.i(componentFilterBridge, "inject");
        a = componentFilterBridge;
    }
}
