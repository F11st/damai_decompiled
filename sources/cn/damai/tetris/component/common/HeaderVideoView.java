package cn.damai.tetris.component.common;

import android.content.Context;
import android.view.View;
import cn.damai.tetris.core.AbsView;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.mvp.CommonBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class HeaderVideoView extends AbsView<HeaderVideoContract$Presenter> implements HeaderVideoContract$View<HeaderVideoContract$Presenter> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context mContext;
    private View mView;
    private HeaderVideoViewHolder viewHolder;

    public HeaderVideoView(View view) {
        super(view);
        this.mView = view;
        this.mContext = mu0.a();
    }

    @Override // cn.damai.tetris.component.common.HeaderVideoContract$View
    public void setData(CommonBean commonBean, String str, TrackInfo trackInfo, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1483115169")) {
            ipChange.ipc$dispatch("1483115169", new Object[]{this, commonBean, str, trackInfo, Boolean.valueOf(z)});
            return;
        }
        if (this.viewHolder == null) {
            this.viewHolder = new HeaderVideoViewHolder(getView());
        }
        commonBean.trackInfo = trackInfo;
        this.viewHolder.setReset(z);
        this.viewHolder.setData(commonBean);
    }

    @Override // cn.damai.tetris.component.common.HeaderVideoContract$View
    public void setMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-460563981")) {
            ipChange.ipc$dispatch("-460563981", new Object[]{this, Integer.valueOf(i), obj});
            return;
        }
        HeaderVideoViewHolder headerVideoViewHolder = this.viewHolder;
        if (headerVideoViewHolder != null) {
            headerVideoViewHolder.setMessage(i, obj);
        }
    }
}
