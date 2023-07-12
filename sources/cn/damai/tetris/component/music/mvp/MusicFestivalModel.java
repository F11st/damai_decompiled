package cn.damai.tetris.component.music.mvp;

import cn.damai.musicfestival.bean.MusicFestivalRes;
import cn.damai.tetris.component.music.mvp.MusicFestivalContract;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class MusicFestivalModel extends AbsModel implements MusicFestivalContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    private MusicFestivalRes bean;

    @Override // cn.damai.tetris.component.music.mvp.MusicFestivalContract.Model
    public MusicFestivalRes getBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "4063532") ? (MusicFestivalRes) ipChange.ipc$dispatch("4063532", new Object[]{this}) : this.bean;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "227292495")) {
            ipChange.ipc$dispatch("227292495", new Object[]{this, baseNode});
        }
    }
}
