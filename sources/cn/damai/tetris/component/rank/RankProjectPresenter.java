package cn.damai.tetris.component.rank;

import android.os.Bundle;
import cn.damai.commonbusiness.rank.RankInfo;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.tetris.component.discover.mvp.NotePresenter;
import cn.damai.tetris.component.rank.RankProjectContract;
import cn.damai.tetris.component.rank.bean.RankCityIdTarget;
import cn.damai.tetris.component.rank.bean.RankCityValue;
import cn.damai.tetris.component.rank.bean.RankFilterTarget;
import cn.damai.tetris.component.rank.bean.RankFilterValue;
import cn.damai.tetris.component.rank.bean.RankItemBean;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.core.msg.Message;
import cn.damai.tetris.core.ut.TrackType;
import cn.damai.tetris.v2.structure.container.ValueKey;
import cn.damai.uikit.nav.INavUri;
import cn.damai.uikit.nav.NavProxy;
import cn.damai.user.repertoite.ui.RepertoireDetailFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.d23;
import tb.ja;
import tb.k50;
import tb.pb;
import tb.qd2;
import tb.u12;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class RankProjectPresenter extends BasePresenter<RankProjectModel, RankProjectView, BaseSection> implements RankProjectContract.Presenter<RankProjectModel, RankProjectView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    public static final int LOGIN_FOR_FAVORITE = 4097;
    @Nullable
    private TrackInfo mTrackInfo;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    public RankProjectPresenter(@Nullable RankProjectView rankProjectView, @Nullable String str, @Nullable ja jaVar) {
        super(rankProjectView, str, jaVar);
    }

    private final RankCityValue getRankCity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "931249391")) {
            return (RankCityValue) ipChange.ipc$dispatch("931249391", new Object[]{this});
        }
        ja context = getContext();
        if (context != null && context.getContainer() != null) {
            Object containerValue = context.getContainer().getContainerValue(ValueKey.KEY_RANK_SQUARE_INPUT_CITY_ID, new RankCityIdTarget());
            b41.h(containerValue, "{\n                contex…          )\n            }");
            return (RankCityValue) containerValue;
        }
        return new RankCityValue(z20.c(), z20.d());
    }

    private final RankFilterValue getRankFilterValue() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1653849500")) {
            return (RankFilterValue) ipChange.ipc$dispatch("-1653849500", new Object[]{this});
        }
        ja context = getContext();
        if (context != null && context.getContainer() != null) {
            Object containerValue = context.getContainer().getContainerValue(ValueKey.KEY_RANK_SQUARE_FILTER_INFO, new RankFilterTarget());
            b41.h(containerValue, "{\n                contex…          )\n            }");
            return (RankFilterValue) containerValue;
        }
        return new RankFilterValue(null, null);
    }

    private final Map<String, String> getUtArgs(RankItemBean rankItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-788897322")) {
            return (Map) ipChange.ipc$dispatch("-788897322", new Object[]{this, rankItemBean});
        }
        HashMap<String, String> g = d23.g();
        d23.h(g, "city", getRankCity().cityName);
        b41.f(rankItemBean);
        d23.h(g, pb.CNT_CONTENT_ID, rankItemBean.rankId);
        d23.h(g, "item_id", rankItemBean.id + "");
        d23.h(g, "titlelabel", getRankFilterValue().weiDuTabName);
        b41.h(g, "map");
        return g;
    }

    private final String getUtD(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1821320612")) {
            return (String) ipChange.ipc$dispatch("-1821320612", new Object[]{this, Integer.valueOf(i)});
        }
        return "category_" + getRankFilterValue().mainTabIndex + "_dimension_" + getRankFilterValue().subTabIndex + "_item_" + i;
    }

    private final void navToProjcet(RankItemBean rankItemBean, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1995275543")) {
            ipChange.ipc$dispatch("1995275543", new Object[]{this, rankItemBean, map});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(IssueConstants.ProjectID, rankItemBean.id + "");
        bundle.putString("projectName", rankItemBean.name);
        bundle.putString("projectImage", rankItemBean.headPic);
        RankInfo rankInfo = new RankInfo();
        rankInfo.setId(rankItemBean.rankId);
        rankInfo.setName(rankItemBean.rankName);
        rankInfo.setOrder(rankItemBean.order + "");
        bundle.putParcelable("rankInfo", rankInfo);
        qd2.a(getContext().getActivity(), rankItemBean.schema, bundle);
    }

    private final void navToRepro(RankItemBean rankItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2004131895")) {
            ipChange.ipc$dispatch("-2004131895", new Object[]{this, rankItemBean});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(RepertoireDetailFragment.REPERTOIREID, rankItemBean.id + "");
        NavProxy.from(getContext().getActivity()).withExtras(bundle).toUri(INavUri.page(u12.REPERTOITE));
    }

    @Override // cn.damai.tetris.component.rank.RankProjectContract.Presenter
    public void itemClick(@Nullable RankProjectView rankProjectView, @Nullable RankItemBean rankItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1005673970")) {
            ipChange.ipc$dispatch("1005673970", new Object[]{this, rankProjectView, rankItemBean, Integer.valueOf(i)});
            return;
        }
        ja context = getContext();
        if (rankItemBean == null || context == null) {
            return;
        }
        userTrack(TrackType.click, null, ((RankProjectModel) this.mModel).getTrackInfo().trackB, "list", getUtD(i), getUtArgs(rankItemBean), true);
        if (rankItemBean.id <= 0 || getContext().getActivity() == null) {
            return;
        }
        if (rankItemBean.type != 99) {
            TrackInfo trackInfo = this.mTrackInfo;
            b41.f(trackInfo);
            Map<String, String> argsMap = trackInfo.getArgsMap();
            b41.h(argsMap, "mTrackInfo!!.argsMap");
            navToProjcet(rankItemBean, argsMap);
            return;
        }
        navToRepro(rankItemBean);
    }

    @Override // cn.damai.tetris.core.BasePresenter, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, @Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1661325749")) {
            ipChange.ipc$dispatch("-1661325749", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.tetris.component.rank.RankProjectContract.Presenter
    public void wantSeeClick(@Nullable RankProjectView rankProjectView, @Nullable RankItemBean rankItemBean, int i, @NotNull FollowDataBean followDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "727876435")) {
            ipChange.ipc$dispatch("727876435", new Object[]{this, rankProjectView, rankItemBean, Integer.valueOf(i), followDataBean});
            return;
        }
        b41.i(followDataBean, "followDataBean");
        userTrack(TrackType.click, null, ((RankProjectModel) this.mModel).getTrackInfo().trackB, "list", "like", getUtArgs(rankItemBean), true);
        if (followDataBean.getStatus() > 0) {
            followDataBean.tempRank = rankItemBean;
            sendMsg(new Message(24, followDataBean));
        }
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public void init(@NotNull RankProjectModel rankProjectModel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1657156849")) {
            ipChange.ipc$dispatch("1657156849", new Object[]{this, rankProjectModel});
            return;
        }
        b41.i(rankProjectModel, "rankModel");
        this.mTrackInfo = rankProjectModel.getTrackInfo();
        RankItemBean bean = rankProjectModel.getBean();
        RankProjectView view = getView();
        b41.f(view);
        b41.f(bean);
        view.setData(bean, bean.index);
        if (NotePresenter.isTrackInfoValid(this.mTrackInfo)) {
            TrackType trackType = TrackType.expose;
            userTrack(trackType, view.getRootView(), ((RankProjectModel) this.mModel).getTrackInfo().trackB, "list", getUtD(bean.index), getUtArgs(bean), true);
            userTrack(trackType, view.getRootView(), ((RankProjectModel) this.mModel).getTrackInfo().trackB, "list", "like", getUtArgs(bean), true);
        }
    }
}
