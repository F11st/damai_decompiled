package com.alibaba.pictures.bricks.component.home;

import com.alibaba.pictures.bricks.bean.HeadAtmosphereBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class StateAtmo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private final State state;

    public StateAtmo(@Nullable State state, @Nullable HeadAtmosphereBean headAtmosphereBean) {
        this.state = state;
    }

    @Nullable
    public final State getState() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-159557464") ? (State) ipChange.ipc$dispatch("-159557464", new Object[]{this}) : this.state;
    }
}
