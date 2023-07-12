package cn.damai.tetris.component.rank;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import cn.damai.category.ranking.ui.RankListFragment;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.tetris.component.rank.RankSelectContract;
import cn.damai.tetris.component.rank.bean.RankCityIdTarget;
import cn.damai.tetris.component.rank.bean.RankCityValue;
import cn.damai.tetris.component.rank.bean.RankSelectBean;
import cn.damai.tetris.component.rank.bean.RankSelectItemBean;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.ut.TrackType;
import cn.damai.tetris.v2.structure.container.ValueKey;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.d23;
import tb.ja;
import tb.pb;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class RankSelectPresenter extends BasePresenter<RankSelectModel, RankSelectView, BaseSection> implements RankSelectContract.Presenter<RankSelectModel, RankSelectView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;

    public RankSelectPresenter(@Nullable RankSelectView rankSelectView, @Nullable String str, @Nullable ja jaVar) {
        super(rankSelectView, str, jaVar);
    }

    private final RankCityValue getRankCity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1529729410")) {
            return (RankCityValue) ipChange.ipc$dispatch("-1529729410", new Object[]{this});
        }
        ja context = getContext();
        if (context != null && context.getContainer() != null) {
            Object containerValue = context.getContainer().getContainerValue(ValueKey.KEY_RANK_SQUARE_INPUT_CITY_ID, new RankCityIdTarget());
            b41.h(containerValue, "{\n                contex…          )\n            }");
            return (RankCityValue) containerValue;
        }
        return new RankCityValue(z20.c(), z20.d());
    }

    @Override // cn.damai.tetris.component.rank.RankSelectContract.Presenter
    public void expose(@Nullable View view, @Nullable RankSelectItemBean rankSelectItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1070638447")) {
            ipChange.ipc$dispatch("-1070638447", new Object[]{this, view, rankSelectItemBean, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> g = d23.g();
        d23.h(g, "city", getRankCity().cityName);
        d23.h(g, "titlelabel", rankSelectItemBean != null ? rankSelectItemBean.shortName : null);
        d23.h(g, pb.CNT_CONTENT_ID, rankSelectItemBean != null ? rankSelectItemBean.id : null);
        TrackType trackType = TrackType.expose;
        b41.f(view);
        View rootView = view.getRootView();
        String str = ((RankSelectModel) this.mModel).getTrackInfo().trackB;
        userTrack(trackType, rootView, str, "theme_ranklist", "item_" + i, g, true);
    }

    @Override // cn.damai.tetris.component.rank.RankSelectContract.Presenter
    public void itemClick(@Nullable RankSelectView rankSelectView, @Nullable RankSelectItemBean rankSelectItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "761329312")) {
            ipChange.ipc$dispatch("761329312", new Object[]{this, rankSelectView, rankSelectItemBean, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> g = d23.g();
        d23.h(g, "city", getRankCity().cityName);
        b41.f(rankSelectItemBean);
        d23.h(g, "titlelabel", rankSelectItemBean.shortName);
        d23.h(g, pb.CNT_CONTENT_ID, rankSelectItemBean.id);
        TrackType trackType = TrackType.click;
        String str = ((RankSelectModel) this.mModel).getTrackInfo().trackB;
        userTrack(trackType, null, str, "theme_ranklist", "item_" + i, g, true);
        try {
            Bundle bundle = new Bundle();
            String str2 = rankSelectItemBean.id;
            b41.f(str2);
            bundle.putLong(RankListFragment.KEY_RANK_ID, Long.parseLong(str2));
            bundle.putString("cityId", getRankCity().cityId);
            DMNav.from(getContext().getActivity().getBaseContext()).withExtras(bundle).toUri(NavUri.b("ranking"));
        } catch (NumberFormatException e) {
            String message = e.getMessage();
            if (message != null) {
                Log.e("RankSelectPresenter", message);
            }
        }
    }

    @Override // cn.damai.tetris.core.BasePresenter, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, @Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-25406756")) {
            ipChange.ipc$dispatch("-25406756", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public void init(@NotNull RankSelectModel rankSelectModel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1857787181")) {
            ipChange.ipc$dispatch("-1857787181", new Object[]{this, rankSelectModel});
            return;
        }
        b41.i(rankSelectModel, "dramaWorthSeeModel");
        RankSelectBean bean = rankSelectModel.getBean();
        RankSelectView view = getView();
        b41.f(view);
        view.setData(bean, 0);
    }
}
