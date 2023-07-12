package com.alibaba.pictures.bricks.channel.component;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.ICreator;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.Config;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.Node;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ProjectFilterComponentCreator implements ICreator<IComponent<ComponentValue>, Node> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.youku.arch.v3.ICreator
    @NotNull
    public IComponent<ComponentValue> create(@NotNull Config<Node> config) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-74105849")) {
            return (IComponent) ipChange.ipc$dispatch("-74105849", new Object[]{this, config});
        }
        b41.i(config, Constants.CONFIG);
        return new ProjectFilterComponent(config.getContext(), config.getData());
    }
}
