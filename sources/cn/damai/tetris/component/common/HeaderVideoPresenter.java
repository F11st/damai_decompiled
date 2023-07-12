package cn.damai.tetris.component.common;

import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.v2.structure.section.ISection;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ja;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class HeaderVideoPresenter extends BasePresenter<HeaderVideoContract$Model, HeaderVideoView, BaseSection> implements HeaderVideoContract$Presenter<HeaderVideoContract$Model, HeaderVideoView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;
    private ISection lastSection;
    public ja mContext;
    public TrackInfo mTrackInfo;
    public HeaderVideoView mView;

    public HeaderVideoPresenter(HeaderVideoView headerVideoView, String str, ja jaVar) {
        super(headerVideoView, str, jaVar);
        this.mView = headerVideoView;
        this.mContext = jaVar;
    }

    @Override // cn.damai.tetris.core.BasePresenter, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-947998549")) {
            ipChange.ipc$dispatch("-947998549", new Object[]{this, Integer.valueOf(i), obj});
        } else {
            getView().setMessage(i, obj);
        }
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public void init(HeaderVideoContract$Model headerVideoContract$Model) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-967071425")) {
            ipChange.ipc$dispatch("-967071425", new Object[]{this, headerVideoContract$Model});
            return;
        }
        this.mTrackInfo = headerVideoContract$Model.getTrackInfo();
        ISection iSection = this.lastSection;
        z = (iSection == null || iSection != getSection()) ? true : true;
        this.lastSection = getSection();
        getView().setData(headerVideoContract$Model.getData(), getSection().getComponentId(), this.mTrackInfo, z);
    }
}
