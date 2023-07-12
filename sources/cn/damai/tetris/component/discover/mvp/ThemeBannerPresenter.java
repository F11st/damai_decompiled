package cn.damai.tetris.component.discover.mvp;

import android.text.TextUtils;
import android.view.View;
import cn.damai.common.nav.DMNav;
import cn.damai.commonbusiness.discover.bean.ThemeBannerBean;
import cn.damai.tetris.component.discover.mvp.ThemeBannerContract;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.d23;
import tb.ja;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ThemeBannerPresenter extends BasePresenter<ThemeBannerModel, ThemeBannerView, BaseSection> implements ThemeBannerContract.Presenter<ThemeBannerModel, ThemeBannerView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;

    public ThemeBannerPresenter(ThemeBannerView themeBannerView, String str, ja jaVar) {
        super(themeBannerView, str, jaVar);
    }

    @Override // cn.damai.tetris.component.discover.mvp.ThemeBannerContract.Presenter
    public void exposeItem(View view, ThemeBannerBean themeBannerBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "208766461")) {
            ipChange.ipc$dispatch("208766461", new Object[]{this, view, themeBannerBean, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> f = d23.f();
        f.put("titlelabel", "关注");
        f.put("index", i + "");
        d23.h(f, "id", themeBannerBean.dispatchTaskId);
        userTrackExpose(view, "dbanner_" + i, f, false);
    }

    @Override // cn.damai.tetris.component.discover.mvp.ThemeBannerContract.Presenter
    public void itemClick(ThemeBannerBean themeBannerBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-794256343")) {
            ipChange.ipc$dispatch("-794256343", new Object[]{this, themeBannerBean, Integer.valueOf(i)});
            return;
        }
        String bannerUrl = themeBannerBean.bannerUrl();
        ja context = getContext();
        if (context == null || context.getActivity() == null || TextUtils.isEmpty(bannerUrl)) {
            return;
        }
        DMNav.from(context.getActivity()).toUri(bannerUrl);
        HashMap<String, String> f = d23.f();
        f.put("titlelabel", "关注");
        f.put("index", i + "");
        d23.h(f, "id", themeBannerBean.dispatchTaskId);
        userTrackClick("dbanner_" + i, f, true);
    }

    @Override // cn.damai.tetris.core.BasePresenter, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1281298162")) {
            ipChange.ipc$dispatch("-1281298162", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public void init(ThemeBannerModel themeBannerModel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "267900843")) {
            ipChange.ipc$dispatch("267900843", new Object[]{this, themeBannerModel});
        } else {
            getView().setData(themeBannerModel.getBean(), 0);
        }
    }
}
