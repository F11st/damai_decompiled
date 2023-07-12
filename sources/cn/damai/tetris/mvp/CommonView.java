package cn.damai.tetris.mvp;

import android.content.Context;
import android.view.View;
import cn.damai.tetris.core.AbsView;
import cn.damai.tetris.core.NodeData;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.v2.structure.section.ISection;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.mu0;
import tb.wl2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class CommonView extends AbsView<CommonContract$Presenter> implements CommonContract$View<CommonContract$Presenter> {
    private static transient /* synthetic */ IpChange $ipChange;
    private CommonPresenter commonPresenter;
    private Context mContext;
    private ISection mLastSection;
    private View mView;
    private CommonViewHolder viewHolder;

    public CommonView(View view) {
        super(view);
        this.mView = view;
        this.mContext = mu0.a();
    }

    private ISection getNowSection() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-927903244")) {
            return (ISection) ipChange.ipc$dispatch("-927903244", new Object[]{this});
        }
        CommonContract$Presenter presenter = getPresenter();
        if (presenter != null) {
            return presenter.getSection();
        }
        return null;
    }

    @Override // cn.damai.tetris.mvp.CommonContract$View
    public boolean rebindAble() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-936565534")) {
            return ((Boolean) ipChange.ipc$dispatch("-936565534", new Object[]{this})).booleanValue();
        }
        CommonViewHolder commonViewHolder = this.viewHolder;
        if (commonViewHolder != null) {
            return commonViewHolder.rebindAble();
        }
        return false;
    }

    @Override // cn.damai.tetris.mvp.CommonContract$View
    public void rebindData(NodeData nodeData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-685615598")) {
            ipChange.ipc$dispatch("-685615598", new Object[]{this, nodeData});
            return;
        }
        CommonViewHolder commonViewHolder = this.viewHolder;
        if (commonViewHolder != null) {
            commonViewHolder.rebind(nodeData);
        }
    }

    @Override // cn.damai.tetris.mvp.CommonContract$View
    public void setCommonPresenter(CommonPresenter commonPresenter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "88649498")) {
            ipChange.ipc$dispatch("88649498", new Object[]{this, commonPresenter});
        } else {
            this.commonPresenter = commonPresenter;
        }
    }

    @Override // cn.damai.tetris.mvp.CommonContract$View
    public void setData(NodeData nodeData, String str, TrackInfo trackInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "904271231")) {
            ipChange.ipc$dispatch("904271231", new Object[]{this, nodeData, str, trackInfo});
            return;
        }
        if (this.viewHolder == null) {
            CommonViewHolder a = wl2.a(str, this.mView);
            this.viewHolder = a;
            a.setCommonPresenter(this.commonPresenter);
        }
        ISection nowSection = getNowSection();
        boolean z = this.mLastSection != nowSection;
        this.mLastSection = nowSection;
        if (trackInfo == null) {
            trackInfo = new TrackInfo();
        }
        trackInfo.put("ABTrackInfo", nowSection.getRawData().get("abBucket"));
        this.viewHolder.setNode(nodeData, trackInfo, z);
    }

    @Override // cn.damai.tetris.mvp.CommonContract$View
    public void setMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1886045412")) {
            ipChange.ipc$dispatch("-1886045412", new Object[]{this, Integer.valueOf(i), obj});
            return;
        }
        CommonViewHolder commonViewHolder = this.viewHolder;
        if (commonViewHolder != null) {
            commonViewHolder.setMessage(i, obj);
        }
    }
}
