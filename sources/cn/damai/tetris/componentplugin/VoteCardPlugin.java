package cn.damai.tetris.componentplugin;

import androidx.annotation.Nullable;
import cn.damai.commonbusiness.discover.bean.VoteInfoBean;
import cn.damai.tetris.v2.componentplugin.ComponentPageUi;
import cn.damai.tetris.v2.componentplugin.ComponentPlugin;
import cn.damai.tetris.v2.structure.section.ISection;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.m61;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class VoteCardPlugin extends ComponentPlugin {
    private static transient /* synthetic */ IpChange $ipChange;

    public VoteCardPlugin(ComponentPageUi componentPageUi) {
        super(componentPageUi);
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public boolean onLoadMore() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "153509638")) {
            return ((Boolean) ipChange.ipc$dispatch("153509638", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public boolean onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2083056669")) {
            return ((Boolean) ipChange.ipc$dispatch("2083056669", new Object[]{this, Integer.valueOf(i), obj})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public boolean onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-894581002")) {
            return ((Boolean) ipChange.ipc$dispatch("-894581002", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public void onSectionBind(ISection iSection) {
        VoteInfoBean voteInfoBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1761503548")) {
            ipChange.ipc$dispatch("1761503548", new Object[]{this, iSection});
            return;
        }
        JSONObject item = iSection.getItem();
        if (item == null || (voteInfoBean = (VoteInfoBean) m61.d(item, VoteInfoBean.class)) == null) {
            return;
        }
        voteInfoBean.posInFeedList = iSection.getIndex();
        iSection.setExtra(voteInfoBean);
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public void onSectionRemoved(@Nullable ISection iSection) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "204706661")) {
            ipChange.ipc$dispatch("204706661", new Object[]{this, iSection});
        }
    }
}
