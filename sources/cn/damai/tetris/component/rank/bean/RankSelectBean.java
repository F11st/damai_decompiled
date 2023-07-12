package cn.damai.tetris.component.rank.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public final class RankSelectBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private RankSelectExtraBean extra;
    @JvmField
    @Nullable
    public List<RankSelectItemBean> result;

    @Nullable
    public final RankSelectExtraBean getExtra() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1059105954") ? (RankSelectExtraBean) ipChange.ipc$dispatch("-1059105954", new Object[]{this}) : this.extra;
    }

    public final void setExtra(@Nullable RankSelectExtraBean rankSelectExtraBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1795691158")) {
            ipChange.ipc$dispatch("-1795691158", new Object[]{this, rankSelectExtraBean});
        } else {
            this.extra = rankSelectExtraBean;
        }
    }
}
