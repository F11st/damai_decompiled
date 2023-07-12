package cn.damai.tetris.component.live.mvp;

import android.os.Bundle;
import android.text.TextUtils;
import cn.damai.tetris.component.live.bean.LiveHeaderPicBean;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.core.ut.TrackType;
import cn.damai.uikit.nav.NavProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.cs;
import tb.ja;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class HeaderPresenter extends BasePresenter<HeaderContract$Model, HeaderView, BaseSection> implements HeaderContract$Presenter<HeaderContract$Model, HeaderView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;
    public ja mContext;
    public TrackInfo mTrackInfo;
    public HeaderView mView;

    public HeaderPresenter(HeaderView headerView, String str, ja jaVar) {
        super(headerView, str, jaVar);
        this.mView = headerView;
        this.mContext = jaVar;
    }

    @Override // cn.damai.tetris.component.live.mvp.HeaderContract$Presenter
    public void headerClick(LiveHeaderPicBean liveHeaderPicBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "980030956")) {
            ipChange.ipc$dispatch("980030956", new Object[]{this, liveHeaderPicBean});
        } else if (liveHeaderPicBean == null || TextUtils.isEmpty(liveHeaderPicBean.themeId) || this.mTrackInfo == null) {
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("themeId", liveHeaderPicBean.themeId);
            NavProxy.from(getContext().getActivity()).withExtras(bundle).toHost(cs.DISCOVER_THEME);
            if (this.mTrackInfo != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("city", this.mTrackInfo.get("city") + "");
                hashMap.put("contentlabel", liveHeaderPicBean.themeName);
                hashMap.put("usercode", this.mTrackInfo.get("usercode") + "");
                TrackType trackType = TrackType.click;
                TrackInfo trackInfo = this.mTrackInfo;
                userTrack(trackType, null, trackInfo.trackB, trackInfo.trackC, "big_pic", hashMap, true);
            }
        }
    }

    @Override // cn.damai.tetris.core.BasePresenter, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1767323663")) {
            ipChange.ipc$dispatch("1767323663", new Object[]{this, Integer.valueOf(i), obj});
        } else if (this.mView == null || this.mContext.getActivity() == null) {
        } else {
            if (i == 3) {
                this.mView.videoPlay();
            } else if (i == 4) {
                this.mView.videoStop();
            } else if (i != 6) {
            } else {
                this.mView.videoDestory();
            }
        }
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public void init(HeaderContract$Model headerContract$Model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1393346877")) {
            ipChange.ipc$dispatch("1393346877", new Object[]{this, headerContract$Model});
            return;
        }
        this.mTrackInfo = headerContract$Model.getTrackInfo();
        getView().setData(headerContract$Model.getHeaderBean());
    }
}
