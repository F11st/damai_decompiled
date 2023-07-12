package cn.damai.tetris.component.music.mvp;

import cn.damai.musicfestival.bean.FeedInfo;
import cn.damai.tetris.component.music.mvp.DiscoverFeedPluginContract;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.NodeData;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.m61;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class DiscoverFeedPluginModel extends AbsModel implements DiscoverFeedPluginContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    private FeedInfo mTitle;

    @Override // cn.damai.tetris.component.music.mvp.DiscoverFeedPluginContract.Model
    public FeedInfo getBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "927791536") ? (FeedInfo) ipChange.ipc$dispatch("927791536", new Object[]{this}) : this.mTitle;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1586358718")) {
            ipChange.ipc$dispatch("-1586358718", new Object[]{this, baseNode});
            return;
        }
        NodeData item = baseNode.getItem();
        if (item != null) {
            this.mTitle = (FeedInfo) m61.d(item, FeedInfo.class);
        }
    }
}
