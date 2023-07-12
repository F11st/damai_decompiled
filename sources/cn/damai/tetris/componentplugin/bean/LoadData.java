package cn.damai.tetris.componentplugin.bean;

import cn.damai.tetris.v2.common.Node;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.cb2;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class LoadData {
    private static transient /* synthetic */ IpChange $ipChange;
    public boolean firstPage;
    public boolean hasNextPage;
    public List<Node> sectionList;

    public LoadData(boolean z, boolean z2, List<Node> list) {
        this.firstPage = z;
        this.hasNextPage = z2;
        this.sectionList = list;
    }

    public boolean hasListSize() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1507899933") ? ((Boolean) ipChange.ipc$dispatch("-1507899933", new Object[]{this})).booleanValue() : !cb2.d(this.sectionList);
    }
}
