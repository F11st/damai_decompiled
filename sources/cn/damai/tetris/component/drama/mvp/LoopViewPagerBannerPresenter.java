package cn.damai.tetris.component.drama.mvp;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import cn.damai.commonbusiness.R$id;
import cn.damai.tetris.component.drama.mvp.LoopViewPagerBannerContract;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.uikit.banner.sub.BannerItem;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.d23;
import tb.ja;
import tb.q60;
import tb.xc0;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class LoopViewPagerBannerPresenter extends BasePresenter<LoopViewPagerBannerModel, LoopViewPagerBannerView, BaseSection> implements LoopViewPagerBannerContract.Presenter<LoopViewPagerBannerModel, LoopViewPagerBannerView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;

    public LoopViewPagerBannerPresenter(LoopViewPagerBannerView loopViewPagerBannerView, String str, ja jaVar) {
        super(loopViewPagerBannerView, str, jaVar);
    }

    @Override // cn.damai.tetris.component.drama.mvp.LoopViewPagerBannerContract.Presenter
    public void exposeBanner(View view, BannerItem bannerItem, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "186706735")) {
            ipChange.ipc$dispatch("186706735", new Object[]{this, view, bannerItem, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> f = d23.f();
        d23.h(f, "contentlabel", bannerItem.bannerUrl());
        userTrackExpose(view, "item_" + i, f, false);
    }

    @Override // cn.damai.tetris.component.drama.mvp.LoopViewPagerBannerContract.Presenter
    public void itemClick(LoopViewPagerBannerContract.View view, BannerItem bannerItem, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "358774075")) {
            ipChange.ipc$dispatch("358774075", new Object[]{this, view, bannerItem, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> f = d23.f();
        if (getModel().getTrackInfo().getArgsMap() != null) {
            f.putAll(getModel().getTrackInfo().getArgsMap());
        }
        d23.h(f, "contentlabel", bannerItem.bannerUrl());
        userTrackClick("item_" + i, f, true);
        xc0.d(getContext(), bannerItem.bannerUrl());
    }

    @Override // cn.damai.tetris.core.BasePresenter, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        LoopViewPagerBannerView view;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1381002417")) {
            ipChange.ipc$dispatch("1381002417", new Object[]{this, Integer.valueOf(i), obj});
            return;
        }
        if (i == 11004) {
            getView().clean();
        }
        if (i == 11001 && (view = getView()) != null && (obj instanceof Boolean)) {
            view.onUserVisibleHint(((Boolean) obj).booleanValue());
        }
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public void init(LoopViewPagerBannerModel loopViewPagerBannerModel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1855097779")) {
            ipChange.ipc$dispatch("1855097779", new Object[]{this, loopViewPagerBannerModel});
            return;
        }
        getView().setData(loopViewPagerBannerModel.getBean(), 0);
        if (!TextUtils.isEmpty(getSection().getStyleInfo().getString("title")) && getView().getTitle() != null) {
            getView().getTitle().setText(getSection().getStyleInfo().getString("title"));
        } else {
            ((FrameLayout.LayoutParams) getView().getRootView().findViewById(R$id.loop_banner).getLayoutParams()).setMargins(0, q60.a(getContext().getActivity(), 8.0f), 0, q60.a(getContext().getActivity(), 7.0f));
        }
    }
}
