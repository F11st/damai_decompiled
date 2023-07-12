package cn.damai.tetris.component.rank;

import android.os.Bundle;
import android.view.View;
import cn.damai.commonbusiness.rank.RankInfo;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.tetris.component.rank.RankCardContract;
import cn.damai.tetris.component.rank.bean.RankItemBean;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.uikit.nav.INavUri;
import cn.damai.uikit.nav.NavProxy;
import cn.damai.user.repertoite.ui.RepertoireDetailFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Map;
import tb.ja;
import tb.pb;
import tb.qd2;
import tb.u12;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class RankCardPresenter extends BasePresenter<RankCardContract.Model, RankCardContract.View, BaseSection> implements RankCardContract.Presenter<RankCardContract.Model, RankCardContract.View, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;
    private TrackInfo mTrackInfo;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-836330487")) {
                ipChange.ipc$dispatch("-836330487", new Object[]{this, view});
                return;
            }
            RankCardPresenter rankCardPresenter = RankCardPresenter.this;
            rankCardPresenter.userTrackClick("item_" + RankCardPresenter.this.getModel().getOffset(), RankCardPresenter.this.mTrackInfo.getArgsMap(), true);
            if (RankCardPresenter.this.getModel().getData() == null || RankCardPresenter.this.getModel().getData().id <= 0 || RankCardPresenter.this.getContext().getActivity() == null) {
                return;
            }
            if (RankCardPresenter.this.getModel().getData().type != 99) {
                RankCardPresenter rankCardPresenter2 = RankCardPresenter.this;
                rankCardPresenter2.navToProjcet(rankCardPresenter2.getModel().getData(), RankCardPresenter.this.mTrackInfo.getArgsMap());
                return;
            }
            RankCardPresenter rankCardPresenter3 = RankCardPresenter.this;
            rankCardPresenter3.navToRepro(rankCardPresenter3.getModel().getData());
        }
    }

    public RankCardPresenter(RankCardView rankCardView, String str, ja jaVar) {
        super(rankCardView, str, jaVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void navToProjcet(RankItemBean rankItemBean, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1103124026")) {
            ipChange.ipc$dispatch("1103124026", new Object[]{this, rankItemBean, map});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(IssueConstants.ProjectID, rankItemBean.id + "");
        bundle.putString("projectName", rankItemBean.name);
        bundle.putString("projectImage", rankItemBean.headPic);
        RankInfo rankInfo = new RankInfo();
        rankInfo.setId(map.get(pb.CNT_CONTENT_ID));
        rankInfo.setName(map.get("titlelabel"));
        rankInfo.setOrder(rankItemBean.order + "");
        bundle.putParcelable("rankInfo", rankInfo);
        qd2.a(getContext().getActivity(), rankItemBean.schema, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void navToRepro(RankItemBean rankItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "392556614")) {
            ipChange.ipc$dispatch("392556614", new Object[]{this, rankItemBean});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(RepertoireDetailFragment.REPERTOIREID, rankItemBean.id + "");
        NavProxy.from(getContext().getActivity()).withExtras(bundle).toUri(INavUri.page(u12.REPERTOITE));
    }

    @Override // cn.damai.tetris.core.BasePresenter, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1718750520")) {
            ipChange.ipc$dispatch("-1718750520", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public void init(RankCardContract.Model model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "736654877")) {
            ipChange.ipc$dispatch("736654877", new Object[]{this, model});
        } else if (model == null) {
        } else {
            this.mTrackInfo = model.getTrackInfo();
            if (model.getData() == null || getView() == null || getView().getHolder() == null) {
                return;
            }
            TrackInfo trackInfo = this.mTrackInfo;
            trackInfo.put("item_id", (Object) (model.getData().id + ""));
            getView().getHolder().a(model.getOffset(), 0, model.getData());
            getView().getRootView().setOnClickListener(new a());
            View rootView = getView().getRootView();
            userTrackExpose(rootView, "item_" + getModel().getOffset(), this.mTrackInfo.getArgsMap(), true);
        }
    }
}
