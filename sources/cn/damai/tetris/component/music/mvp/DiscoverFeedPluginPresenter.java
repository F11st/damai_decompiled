package cn.damai.tetris.component.music.mvp;

import cn.damai.tetris.component.music.mvp.DiscoverFeedPluginContract;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ja;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class DiscoverFeedPluginPresenter extends BasePresenter<DiscoverFeedPluginContract.Model, DiscoverFeedPluginView, BaseSection> implements DiscoverFeedPluginContract.Presenter<DiscoverFeedPluginContract.Model, DiscoverFeedPluginView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;

    public DiscoverFeedPluginPresenter(DiscoverFeedPluginView discoverFeedPluginView, String str, ja jaVar) {
        super(discoverFeedPluginView, str, jaVar);
    }

    @Override // cn.damai.tetris.core.BasePresenter, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1753142441")) {
            ipChange.ipc$dispatch("1753142441", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public void init(DiscoverFeedPluginContract.Model model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1926322949")) {
            ipChange.ipc$dispatch("-1926322949", new Object[]{this, model});
        } else {
            getView().setData(model.getBean());
        }
    }
}
