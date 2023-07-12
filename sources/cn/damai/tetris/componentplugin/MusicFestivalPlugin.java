package cn.damai.tetris.componentplugin;

import androidx.annotation.Nullable;
import cn.damai.musicfestival.bean.MusicFestivalRes;
import cn.damai.tetris.core.NodeData;
import cn.damai.tetris.v2.componentplugin.ComponentPageUi;
import cn.damai.tetris.v2.componentplugin.ComponentPlugin;
import cn.damai.tetris.v2.structure.section.ISection;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.bi1;
import tb.m61;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class MusicFestivalPlugin extends ComponentPlugin {
    private static transient /* synthetic */ IpChange $ipChange;
    private bi1 mUt;

    public MusicFestivalPlugin(ComponentPageUi componentPageUi) {
        super(componentPageUi);
        this.mUt = new bi1();
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public boolean onLoadMore() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "756932189")) {
            return ((Boolean) ipChange.ipc$dispatch("756932189", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public boolean onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1681529932")) {
            return ((Boolean) ipChange.ipc$dispatch("-1681529932", new Object[]{this, Integer.valueOf(i), obj})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public boolean onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "648904895")) {
            return ((Boolean) ipChange.ipc$dispatch("648904895", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public void onSectionBind(ISection iSection) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2034189523")) {
            ipChange.ipc$dispatch("2034189523", new Object[]{this, iSection});
        } else if (iSection != null) {
            JSONObject item = iSection.getItem();
            if (item != null) {
                MusicFestivalRes musicFestivalRes = (MusicFestivalRes) m61.d(new NodeData(item), MusicFestivalRes.class);
                if (musicFestivalRes != null) {
                    musicFestivalRes.initData();
                }
                iSection.setExtra(musicFestivalRes);
            }
            this.mUt.a(iSection, "category_music", "bottom");
        }
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public void onSectionRemoved(@Nullable ISection iSection) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2009431150")) {
            ipChange.ipc$dispatch("2009431150", new Object[]{this, iSection});
        }
    }
}
