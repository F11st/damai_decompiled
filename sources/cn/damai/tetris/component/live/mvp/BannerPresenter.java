package cn.damai.tetris.component.live.mvp;

import android.os.Bundle;
import android.text.TextUtils;
import cn.damai.tetris.component.live.bean.LiveHeaderCardItemBean;
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
public class BannerPresenter extends BasePresenter<BannerContract$Model, BannerView, BaseSection> implements BannerContract$Presenter<BannerContract$Model, BannerView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;
    public TrackInfo mTrackInfo;

    public BannerPresenter(BannerView bannerView, String str, ja jaVar) {
        super(bannerView, str, jaVar);
    }

    @Override // cn.damai.tetris.component.live.mvp.BannerContract$Presenter
    public void itemClick(LiveHeaderCardItemBean liveHeaderCardItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1906455239")) {
            ipChange.ipc$dispatch("1906455239", new Object[]{this, liveHeaderCardItemBean, Integer.valueOf(i)});
        } else if (liveHeaderCardItemBean == null || this.mTrackInfo == null) {
        } else {
            int i2 = liveHeaderCardItemBean.type;
            if (i2 == 3) {
                NavProxy.from(getContext().getActivity()).toUri(liveHeaderCardItemBean.url);
            } else if (i2 == 2 && !TextUtils.isEmpty(liveHeaderCardItemBean.id)) {
                Bundle bundle = new Bundle();
                bundle.putString("themeId", liveHeaderCardItemBean.id);
                NavProxy.from(getContext().getActivity()).withExtras(bundle).toHost(cs.DISCOVER_THEME);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("city", this.mTrackInfo.get("city") + "");
            if (!TextUtils.isEmpty(liveHeaderCardItemBean.url)) {
                hashMap.put("contentlabel", liveHeaderCardItemBean.name + "&" + liveHeaderCardItemBean.url);
            } else {
                hashMap.put("contentlabel", liveHeaderCardItemBean.name);
            }
            hashMap.put("usercode", this.mTrackInfo.get("usercode") + "");
            TrackInfo trackInfo = this.mTrackInfo;
            if (trackInfo != null) {
                TrackType trackType = TrackType.click;
                String str = trackInfo.trackB;
                String str2 = trackInfo.trackC;
                userTrack(trackType, null, str, str2, "item_" + i, hashMap, true);
            }
        }
    }

    @Override // cn.damai.tetris.core.BasePresenter, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1160606192")) {
            ipChange.ipc$dispatch("-1160606192", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public void init(BannerContract$Model bannerContract$Model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "516574365")) {
            ipChange.ipc$dispatch("516574365", new Object[]{this, bannerContract$Model});
            return;
        }
        this.mTrackInfo = bannerContract$Model.getTrackInfo();
        getView().setData(bannerContract$Model.getBannerBean());
    }
}
