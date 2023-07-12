package cn.damai.tetris.component.rank.bean;

import cn.damai.tetris.v2.structure.container.ValueTarget;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class RankFilterTarget implements ValueTarget<RankFilterValue> {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.tetris.v2.structure.container.ValueTarget
    public Class<RankFilterValue> getValueClass() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-420510041") ? (Class) ipChange.ipc$dispatch("-420510041", new Object[]{this}) : RankFilterValue.class;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // cn.damai.tetris.v2.structure.container.ValueTarget
    public RankFilterValue getDefault() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "146887029") ? (RankFilterValue) ipChange.ipc$dispatch("146887029", new Object[]{this}) : new RankFilterValue(null, null);
    }
}
