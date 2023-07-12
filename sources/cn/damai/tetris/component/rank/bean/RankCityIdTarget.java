package cn.damai.tetris.component.rank.bean;

import cn.damai.tetris.v2.structure.container.ValueTarget;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class RankCityIdTarget implements ValueTarget<RankCityValue> {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.tetris.v2.structure.container.ValueTarget
    public Class<RankCityValue> getValueClass() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1351339527") ? (Class) ipChange.ipc$dispatch("-1351339527", new Object[]{this}) : RankCityValue.class;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // cn.damai.tetris.v2.structure.container.ValueTarget
    public RankCityValue getDefault() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-414898090") ? (RankCityValue) ipChange.ipc$dispatch("-414898090", new Object[]{this}) : new RankCityValue(z20.c(), z20.d());
    }
}
