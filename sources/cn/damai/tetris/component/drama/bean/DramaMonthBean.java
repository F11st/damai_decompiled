package cn.damai.tetris.component.drama.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;
import tb.cb2;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class DramaMonthBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public List<DramaV1Bean> content;
    public String labelName;
    public int tabIndex = -1;
    public boolean isLastTab = false;
    public int headPosInTotalList = -1;
    public boolean isExpand = false;

    public void utParamsInset() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1737960514")) {
            ipChange.ipc$dispatch("1737960514", new Object[]{this});
        } else if (!cb2.d(this.content)) {
            for (DramaV1Bean dramaV1Bean : this.content) {
                dramaV1Bean.tempLabelName = this.labelName;
            }
        }
    }
}
