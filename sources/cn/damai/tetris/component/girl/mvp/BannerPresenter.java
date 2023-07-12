package cn.damai.tetris.component.girl.mvp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import cn.damai.category.ranking.ui.RankListFragment;
import cn.damai.tetris.component.girl.bean.BannerBean;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.core.ut.TrackType;
import cn.damai.uikit.nav.INavUri;
import cn.damai.uikit.nav.NavProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.ja;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class BannerPresenter extends BasePresenter<BannerContract$Model, BannerView, BaseSection> implements BannerContract$Presenter<BannerContract$Model, BannerView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;
    TrackInfo mTrackInfo;

    public BannerPresenter(BannerView bannerView, String str, ja jaVar) {
        super(bannerView, str, jaVar);
    }

    @Override // cn.damai.tetris.component.girl.mvp.BannerContract$Presenter
    public void exposeItemView(View view, BannerBean bannerBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1013884702")) {
            ipChange.ipc$dispatch("1013884702", new Object[]{this, view, bannerBean, Integer.valueOf(i)});
        } else if (this.mContext == null || view == null) {
        } else {
            userTrackExpose(view, "banneritem_" + i);
        }
    }

    @Override // cn.damai.tetris.component.girl.mvp.BannerContract$Presenter
    public void itemClick(BannerBean bannerBean, int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-312374431")) {
            ipChange.ipc$dispatch("-312374431", new Object[]{this, bannerBean, Integer.valueOf(i), str});
            return;
        }
        if (bannerBean.type == 4) {
            Bundle bundle = new Bundle();
            bundle.putLong(RankListFragment.KEY_RANK_ID, bannerBean.rankId);
            NavProxy.from(getContext().getActivity()).withExtras(bundle).toUri(INavUri.page("ranking"));
        } else {
            NavProxy.from(getContext().getActivity()).toUri(bannerBean.url);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("titlelabel", str);
        if (!TextUtils.isEmpty(bannerBean.url)) {
            hashMap.put("contentlabel", bannerBean.url);
        }
        TrackType trackType = TrackType.click;
        TrackInfo trackInfo = this.mTrackInfo;
        String str2 = trackInfo.trackB;
        String str3 = trackInfo.trackC;
        userTrack(trackType, null, str2, str3, "banneritem_" + i, hashMap, true);
    }

    @Override // cn.damai.tetris.core.BasePresenter, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "379986880")) {
            ipChange.ipc$dispatch("379986880", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public void init(BannerContract$Model bannerContract$Model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1042317667")) {
            ipChange.ipc$dispatch("-1042317667", new Object[]{this, bannerContract$Model});
            return;
        }
        getView().setAdapter();
        getView().setData(bannerContract$Model.getBannerList(), bannerContract$Model.getTitle());
        this.mTrackInfo = bannerContract$Model.getTrackInfo();
    }
}
