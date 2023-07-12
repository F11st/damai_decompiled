package cn.damai.homepage.component.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.app.base.BaseActivity;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.discover.bean.CircleCard;
import cn.damai.commonbusiness.discover.bean.VoteBean;
import cn.damai.commonbusiness.discover.bean.VoteInfoBean;
import cn.damai.commonbusiness.discover.viewholder.CircleGroupViewHolder;
import cn.damai.commonbusiness.discover.viewholder.HomeFeedProjectViewHolder;
import cn.damai.commonbusiness.discover.viewholder.NoteViewHolder;
import cn.damai.commonbusiness.discover.viewholder.OnItemClickListener;
import cn.damai.commonbusiness.discover.viewholder.VotePanel;
import cn.damai.commonbusiness.discover.viewholder.VoteViewHolder;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.bean.WaterFlowRec2Project;
import cn.damai.homepage.bean.WaterFlowRecommendItem;
import cn.damai.homepage.ui.adapter.ExtraBean;
import cn.damai.homepage.ui.adapter.GuessAdapter;
import cn.damai.homepage.ui.viewholder.WaterFlowBrandViewHolder;
import cn.damai.homepage.ui.viewholder.WaterFlowCategoryViewHolder;
import cn.damai.homepage.ui.viewholder.WaterFlowCouponViewHolder;
import cn.damai.homepage.ui.viewholder.WaterFlowGoodsViewHolder;
import cn.damai.homepage.ui.viewholder.WaterFlowRankListViewHolder;
import cn.damai.homepage.ui.viewholder.WaterFlowThemeViewHolder;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.tetris.component.discover.bean.NoteBean;
import cn.damai.tetris.component.discover.bean.ProjectInNote;
import cn.damai.uikit.util.DialogUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.cs;
import tb.fm;
import tb.pl;
import tb.py0;
import tb.rm1;
import tb.ry0;
import tb.w03;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class HomePageViewFactory {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.component.base.HomePageViewFactory$a */
    /* loaded from: classes5.dex */
    public class C1138a implements OnItemClickListener<NoteBean> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Context a;
        final /* synthetic */ View b;

        C1138a(Context context, View view) {
            this.a = context;
            this.b = view;
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.OnItemClickListener
        /* renamed from: a */
        public void onDnaClick(NoteBean noteBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1515794119")) {
                ipChange.ipc$dispatch("-1515794119", new Object[]{this, noteBean, Integer.valueOf(i)});
                return;
            }
            C0529c.e().x(py0.I().w());
            if (TextUtils.isEmpty(noteBean.goDnaUrl)) {
                DialogUtil.b(this.a).show();
            } else {
                DMNav.from(this.a).toUri(noteBean.goDnaUrl);
            }
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.OnItemClickListener
        /* renamed from: b */
        public void onEditClick(NoteBean noteBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1223578948")) {
                ipChange.ipc$dispatch("1223578948", new Object[]{this, noteBean, Integer.valueOf(i)});
                return;
            }
            Object extraObj = noteBean.getExtraObj(ExtraBean.EXTRA_KEY);
            if (extraObj instanceof ExtraBean) {
                ExtraBean extraBean = (ExtraBean) extraObj;
                py0 I = py0.I();
                int i2 = extraBean.pageNum;
                int i3 = extraBean.pos;
                ProjectInNote projectInNote = noteBean.project;
                C0529c.e().x(I.L(noteBean, i2, i3, projectInNote == null ? "" : projectInNote.id, "14"));
            }
            if (noteBean.project != null) {
                Bundle bundle = new Bundle();
                bundle.putString(IssueConstants.ProjectID, noteBean.project.id);
                bundle.putString("projectName", noteBean.project.name);
                bundle.putString("projectImage", noteBean.project.verticalPic);
                DMNav.from(this.b.getContext()).withExtras(bundle).toUri(NavUri.b(pl.PROJECT_DETAIL_PAGE));
            }
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.OnItemClickListener
        /* renamed from: c */
        public void onItemClick(NoteBean noteBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1193430683")) {
                ipChange.ipc$dispatch("1193430683", new Object[]{this, noteBean, Integer.valueOf(i)});
            } else if (this.a == null) {
            } else {
                Object extraObj = noteBean.getExtraObj(ExtraBean.EXTRA_KEY);
                if (extraObj instanceof ExtraBean) {
                    ExtraBean extraBean = (ExtraBean) extraObj;
                    py0 I = py0.I();
                    int i2 = extraBean.pageNum;
                    int i3 = extraBean.pos;
                    ProjectInNote projectInNote = noteBean.project;
                    C0529c.e().x(I.K(noteBean, i2, i3, projectInNote == null ? "" : projectInNote.id, "14"));
                }
                Bundle bundle = new Bundle();
                bundle.putString("contentId", noteBean.id);
                bundle.putFloat("picWhRatio", noteBean.localPicWhRatio);
                DMNav.from(this.a).withExtras(bundle).toUri(NavUri.b(cs.DISCOVER_CONTENT_DETAIL));
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.component.base.HomePageViewFactory$b */
    /* loaded from: classes5.dex */
    public class C1139b implements OnItemClickListener<CircleCard> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Context a;
        final /* synthetic */ View b;

        C1139b(Context context, View view) {
            this.a = context;
            this.b = view;
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.OnItemClickListener
        /* renamed from: a */
        public void onEditClick(CircleCard circleCard, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1507117728")) {
                ipChange.ipc$dispatch("1507117728", new Object[]{this, circleCard, Integer.valueOf(i)});
            } else {
                py0.I().k(this.b, circleCard.id, i, "", "13");
            }
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.OnItemClickListener
        /* renamed from: b */
        public void onItemClick(CircleCard circleCard, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1476969463")) {
                ipChange.ipc$dispatch("1476969463", new Object[]{this, circleCard, Integer.valueOf(i)});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("themeId", String.valueOf(circleCard.id));
            DMNav.from(this.a).withExtras(bundle).toUri(NavUri.b(cs.DISCOVER_CIRCLE_THEME_PAGE));
            C0529c.e().x(py0.I().u(circleCard.id, i, "", "13"));
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.OnItemClickListener
        public /* synthetic */ void onDnaClick(CircleCard circleCard, int i) {
            rm1.a(this, circleCard, i);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.component.base.HomePageViewFactory$c */
    /* loaded from: classes5.dex */
    public class C1140c implements VotePanel.VoteActionListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Context a;
        final /* synthetic */ String b;

        C1140c(Context context, String str) {
            this.a = context;
            this.b = str;
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.VotePanel.VoteActionListener
        @Nullable
        public Activity getActivity() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "139098745")) {
                return (Activity) ipChange.ipc$dispatch("139098745", new Object[]{this});
            }
            Context context = this.a;
            if (context instanceof Activity) {
                return (Activity) context;
            }
            return null;
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.VotePanel.VoteActionListener
        public void onVoteInfoUpdate(@NonNull VoteInfoBean voteInfoBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-622129157")) {
                ipChange.ipc$dispatch("-622129157", new Object[]{this, voteInfoBean});
            }
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.VotePanel.VoteActionListener
        public void showActivityLoading(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1136558224")) {
                ipChange.ipc$dispatch("1136558224", new Object[]{this, Boolean.valueOf(z)});
                return;
            }
            Activity activity = getActivity();
            if (activity instanceof BaseActivity) {
                BaseActivity baseActivity = (BaseActivity) activity;
                if (z) {
                    baseActivity.startProgressDialog();
                } else {
                    baseActivity.stopProgressDialog();
                }
            }
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.VotePanel.VoteUtListener
        public void ut4CancelVoteClick(VoteInfoBean voteInfoBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1869766900")) {
                ipChange.ipc$dispatch("-1869766900", new Object[]{this, voteInfoBean});
            } else {
                py0.I().i(voteInfoBean, this.b);
            }
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.VotePanel.VoteUtListener
        public void ut4VoteCardExposure(View view, VoteInfoBean voteInfoBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1834957674")) {
                ipChange.ipc$dispatch("1834957674", new Object[]{this, view, voteInfoBean, Integer.valueOf(i)});
            } else {
                py0.I().m(view, voteInfoBean, i, this.b);
            }
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.VotePanel.VoteUtListener
        public void ut4VoteClick(VoteInfoBean voteInfoBean, VoteBean voteBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-474701730")) {
                ipChange.ipc$dispatch("-474701730", new Object[]{this, voteInfoBean, voteBean, Integer.valueOf(i)});
            } else {
                py0.I().j(voteInfoBean, voteBean, i, this.b);
            }
        }
    }

    private static VotePanel.VoteActionListener a(Context context, String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1656032984") ? (VotePanel.VoteActionListener) ipChange.ipc$dispatch("1656032984", new Object[]{context, str}) : new C1140c(context, str);
    }

    public static void b(@NonNull RecyclerView.ViewHolder viewHolder, fm fmVar, int i, GuessAdapter guessAdapter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1251012006")) {
            ipChange.ipc$dispatch("1251012006", new Object[]{viewHolder, fmVar, Integer.valueOf(i), guessAdapter});
            return;
        }
        w03 w03Var = fmVar instanceof w03 ? (w03) fmVar : null;
        WaterFlowRecommendItem waterFlowRecommendItem = w03Var != null ? w03Var.c : null;
        int i2 = fmVar.a;
        switch (i2) {
            case 302:
            case 309:
                ((WaterFlowCouponViewHolder) viewHolder).handleView(i2, waterFlowRecommendItem);
                return;
            case 303:
                if (waterFlowRecommendItem != null) {
                    ((WaterFlowGoodsViewHolder) viewHolder).f(waterFlowRecommendItem, guessAdapter, i);
                    return;
                }
                return;
            case 304:
                if (waterFlowRecommendItem != null) {
                    ((HomeFeedProjectViewHolder) viewHolder).a(new WaterFlowRec2Project(waterFlowRecommendItem), i);
                    return;
                }
                return;
            case 305:
            case 307:
                ((WaterFlowRankListViewHolder) viewHolder).handleView(waterFlowRecommendItem);
                return;
            case 306:
                ((WaterFlowBrandViewHolder) viewHolder).handleView(waterFlowRecommendItem);
                return;
            case 308:
                ((WaterFlowCategoryViewHolder) viewHolder).handleView(waterFlowRecommendItem);
                return;
            case 310:
                NoteBean noteBean = waterFlowRecommendItem.contentCard;
                if (noteBean != null) {
                    if (i % 5 == 0) {
                        noteBean.setHwRatio(1.3333334f);
                    } else {
                        noteBean.setHwRatio(1.0f);
                    }
                    noteBean.putExtraObj2Map(ExtraBean.EXTRA_KEY, new ExtraBean(waterFlowRecommendItem.pageNum, waterFlowRecommendItem.index));
                    ((NoteViewHolder) viewHolder).a(noteBean, waterFlowRecommendItem.index);
                    return;
                }
                return;
            case 311:
                ((WaterFlowThemeViewHolder) viewHolder).b(waterFlowRecommendItem, i);
                return;
            case 312:
                if (waterFlowRecommendItem != null) {
                    ((VoteViewHolder) viewHolder).a(waterFlowRecommendItem.voteCard, waterFlowRecommendItem.index);
                    return;
                }
                return;
            case 313:
                if (waterFlowRecommendItem != null) {
                    ((CircleGroupViewHolder) viewHolder).a(waterFlowRecommendItem.circleCard, waterFlowRecommendItem.index);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public static RecyclerView.ViewHolder c(ViewGroup viewGroup, String str, Context context, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1308950972")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("1308950972", new Object[]{viewGroup, str, context, Integer.valueOf(i)});
        }
        switch (i) {
            case 302:
            case 309:
                return new WaterFlowCouponViewHolder(str, context);
            case 303:
                return new WaterFlowGoodsViewHolder(str, context);
            case 304:
                return new HomeFeedProjectViewHolder(viewGroup, new ry0(context, str));
            case 305:
            case 307:
                return new WaterFlowRankListViewHolder(str, context);
            case 306:
                return new WaterFlowBrandViewHolder(str, context);
            case 308:
                return new WaterFlowCategoryViewHolder(str, context);
            case 310:
                View inflate = LayoutInflater.from(context).inflate(R$layout.homepage_waterflow_recmmend_note, viewGroup, false);
                return new NoteViewHolder(inflate, new C1138a(context, inflate)) { // from class: cn.damai.homepage.component.base.HomePageViewFactory.2
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // cn.damai.commonbusiness.discover.viewholder.NoteViewHolder
                    public void j(View view, NoteBean noteBean, int i2) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-1686423747")) {
                            ipChange2.ipc$dispatch("-1686423747", new Object[]{this, view, noteBean, Integer.valueOf(i2)});
                        } else {
                            py0.I().l(view);
                        }
                    }

                    @Override // cn.damai.commonbusiness.discover.viewholder.NoteViewHolder
                    public void k(View view, NoteBean noteBean, int i2) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-1119808444")) {
                            ipChange2.ipc$dispatch("-1119808444", new Object[]{this, view, noteBean, Integer.valueOf(i2)});
                            return;
                        }
                        Object extraObj = noteBean.getExtraObj(ExtraBean.EXTRA_KEY);
                        if (extraObj instanceof ExtraBean) {
                            ExtraBean extraBean = (ExtraBean) extraObj;
                            py0 I = py0.I();
                            int i3 = extraBean.pageNum;
                            int i4 = extraBean.pos;
                            ProjectInNote projectInNote = noteBean.project;
                            I.n(view, noteBean, i3, i4, projectInNote == null ? "" : projectInNote.id);
                        }
                    }
                };
            case 311:
                return new WaterFlowThemeViewHolder(str, context);
            case 312:
                return new VoteViewHolder(LayoutInflater.from(context).inflate(R$layout.homepage_waterflow_rec_vote, viewGroup, false), a(context, str));
            case 313:
                View inflate2 = LayoutInflater.from(context).inflate(R$layout.item_discover_feed_circle, viewGroup, false);
                return new CircleGroupViewHolder(inflate2, new C1139b(context, inflate2));
            default:
                return null;
        }
    }
}
