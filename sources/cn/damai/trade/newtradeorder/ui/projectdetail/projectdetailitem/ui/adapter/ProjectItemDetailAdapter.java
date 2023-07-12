package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.trade.newtradeorder.ui.projectdetail.listeners.OnEvaluateMineListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.listeners.OnRecommendItemClickListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.dataholder.ProjectDataHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.ShareManagerImpl;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.listeners.OnCommonProblemsListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.listeners.OnDiscussionClickListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.listeners.OnItemExtendInfoItemClickListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.listeners.OnSectionMoreClickListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectArtistSingleViewHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectAtmosphericBannerViewHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectBlankViewHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectBrandAndArtistMultiViewHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectBrandSingleViewHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectCommonProblemViewHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectDiscoverViewHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectDiscussionViewHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectEvaluateMineViewHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectEvaluateViewHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectExtendInfoViewHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectFreeTicketViewHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectHighLightsViewHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectLineViewHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectMoreContentViewHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectNoticePromptViewHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectRecommendViewHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectRichShrinkViewHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectSectionDividerViewHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectShareViewHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectTitleViewHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.ui.activity.ProjectDetailActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.wh2;
import tb.zx2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ProjectItemDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<ProjectDataHolder> a = new ArrayList();
    private ProjectDetailActivity b;
    private zx2 c;
    private long d;
    private String e;
    private String f;
    private OnEvaluateMineListener g;
    private OnRecommendItemClickListener h;
    private OnItemExtendInfoItemClickListener i;
    private OnCommonProblemsListener j;
    private OnDiscussionClickListener k;
    private OnSectionMoreClickListener l;
    private View.OnClickListener m;
    private ShareManagerImpl n;

    public ProjectItemDetailAdapter(ProjectDetailActivity projectDetailActivity, long j) {
        this.b = projectDetailActivity;
        this.d = j;
    }

    public void a(ProjectDataHolder projectDataHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1902855070")) {
            ipChange.ipc$dispatch("-1902855070", new Object[]{this, projectDataHolder});
            return;
        }
        this.a.clear();
        this.a.add(projectDataHolder);
        notifyDataSetChanged();
    }

    public List<ProjectDataHolder> b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1696995461") ? (List) ipChange.ipc$dispatch("-1696995461", new Object[]{this}) : this.a;
    }

    public void c(List<ProjectDataHolder> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1256504830")) {
            ipChange.ipc$dispatch("-1256504830", new Object[]{this, list});
        } else if (list == null || list.isEmpty()) {
        } else {
            this.a.clear();
            this.a.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void d(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-270497336")) {
            ipChange.ipc$dispatch("-270497336", new Object[]{this, onClickListener});
        } else {
            this.m = onClickListener;
        }
    }

    public void e(OnDiscussionClickListener onDiscussionClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1758202259")) {
            ipChange.ipc$dispatch("1758202259", new Object[]{this, onDiscussionClickListener});
        } else {
            this.k = onDiscussionClickListener;
        }
    }

    public void f(OnEvaluateMineListener onEvaluateMineListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2136423409")) {
            ipChange.ipc$dispatch("2136423409", new Object[]{this, onEvaluateMineListener});
        } else {
            this.g = onEvaluateMineListener;
        }
    }

    public void g(OnSectionMoreClickListener onSectionMoreClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "542046093")) {
            ipChange.ipc$dispatch("542046093", new Object[]{this, onSectionMoreClickListener});
        } else {
            this.l = onSectionMoreClickListener;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1485313872") ? ((Integer) ipChange.ipc$dispatch("1485313872", new Object[]{this})).intValue() : wh2.e(this.a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1596516855") ? ((Integer) ipChange.ipc$dispatch("1596516855", new Object[]{this, Integer.valueOf(i)})).intValue() : this.a.get(i).getModuleType();
    }

    public void h(OnItemExtendInfoItemClickListener onItemExtendInfoItemClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "826345299")) {
            ipChange.ipc$dispatch("826345299", new Object[]{this, onItemExtendInfoItemClickListener});
        } else {
            this.i = onItemExtendInfoItemClickListener;
        }
    }

    public void i(OnCommonProblemsListener onCommonProblemsListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1394749475")) {
            ipChange.ipc$dispatch("-1394749475", new Object[]{this, onCommonProblemsListener});
        } else {
            this.j = onCommonProblemsListener;
        }
    }

    public void j(OnRecommendItemClickListener onRecommendItemClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1797706921")) {
            ipChange.ipc$dispatch("-1797706921", new Object[]{this, onRecommendItemClickListener});
        } else {
            this.h = onRecommendItemClickListener;
        }
    }

    public void k(ShareManagerImpl shareManagerImpl) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1985715509")) {
            ipChange.ipc$dispatch("1985715509", new Object[]{this, shareManagerImpl});
        } else {
            this.n = shareManagerImpl;
        }
    }

    public void l(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2135517938")) {
            ipChange.ipc$dispatch("2135517938", new Object[]{this, str, str2});
            return;
        }
        this.e = str;
        this.f = str2;
    }

    public void m(zx2 zx2Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1209096537")) {
            ipChange.ipc$dispatch("-1209096537", new Object[]{this, zx2Var});
        } else {
            this.c = zx2Var;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-757482583")) {
            ipChange.ipc$dispatch("-757482583", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        ProjectDataHolder projectDataHolder = this.a.get(i);
        if (projectDataHolder == null) {
            return;
        }
        int moduleType = projectDataHolder.getModuleType();
        if (moduleType == 0) {
            ((ProjectEvaluateMineViewHolder) viewHolder).c(projectDataHolder);
        } else if (moduleType == 11) {
            ((ProjectRichShrinkViewHolder) viewHolder).r(projectDataHolder);
        } else if (moduleType == 17) {
            ((ProjectDiscussionViewHolder) viewHolder).b(projectDataHolder);
        } else if (moduleType == 27) {
            ((ProjectFreeTicketViewHolder) viewHolder).a(projectDataHolder);
        } else if (moduleType != 28) {
            switch (moduleType) {
                case 3:
                    ((ProjectExtendInfoViewHolder) viewHolder).m(projectDataHolder);
                    return;
                case 4:
                    ((ProjectCommonProblemViewHolder) viewHolder).e(projectDataHolder);
                    return;
                case 5:
                    ((ProjectRecommendViewHolder) viewHolder).E(projectDataHolder);
                    return;
                case 6:
                    ((ProjectTitleViewHolder) viewHolder).a(projectDataHolder);
                    return;
                case 7:
                    ((ProjectMoreContentViewHolder) viewHolder).d(projectDataHolder);
                    return;
                case 8:
                    ((ProjectAtmosphericBannerViewHolder) viewHolder).f(projectDataHolder);
                    return;
                case 9:
                    ((ProjectEvaluateViewHolder) viewHolder).f(projectDataHolder);
                    return;
                default:
                    switch (moduleType) {
                        case 13:
                            ((ProjectHighLightsViewHolder) viewHolder).a(projectDataHolder);
                            return;
                        case 14:
                            ((ProjectNoticePromptViewHolder) viewHolder).b(projectDataHolder);
                            return;
                        case 15:
                            ((ProjectBlankViewHolder) viewHolder).a(projectDataHolder);
                            return;
                        default:
                            switch (moduleType) {
                                case 30:
                                    ((ProjectDiscoverViewHolder) viewHolder).a(projectDataHolder);
                                    return;
                                case 31:
                                    ((ProjectBrandAndArtistMultiViewHolder) viewHolder).b(projectDataHolder);
                                    return;
                                case 32:
                                    ((ProjectArtistSingleViewHolder) viewHolder).d(projectDataHolder);
                                    return;
                                case 33:
                                    ((ProjectBrandSingleViewHolder) viewHolder).a(projectDataHolder, this.c);
                                    return;
                                default:
                                    return;
                            }
                    }
            }
        } else {
            ((ProjectLineViewHolder) viewHolder).a(projectDataHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1824292973")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("1824292973", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        switch (i) {
            case 0:
                return new ProjectEvaluateMineViewHolder(this.b, this.g, viewGroup);
            case 1:
            case 2:
            case 10:
            case 12:
            case 16:
            case 18:
            case 19:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 29:
            default:
                return null;
            case 3:
                return new ProjectExtendInfoViewHolder(this.b, viewGroup, this.i);
            case 4:
                return new ProjectCommonProblemViewHolder(this.b, this.j, viewGroup);
            case 5:
                return new ProjectRecommendViewHolder(this.b, this.h, viewGroup);
            case 6:
                return new ProjectTitleViewHolder(this.b, viewGroup);
            case 7:
                return new ProjectMoreContentViewHolder(this.b, this.l, viewGroup);
            case 8:
                return new ProjectAtmosphericBannerViewHolder(this.b, viewGroup);
            case 9:
                return new ProjectEvaluateViewHolder(this.b, this.d, this.e, this.f);
            case 11:
                return new ProjectRichShrinkViewHolder(this.b, viewGroup, this.i);
            case 13:
                return new ProjectHighLightsViewHolder(this.b, viewGroup);
            case 14:
                return new ProjectNoticePromptViewHolder(this.b, this.l, viewGroup);
            case 15:
                return new ProjectBlankViewHolder(this.b, viewGroup);
            case 17:
                return new ProjectDiscussionViewHolder(this.b, viewGroup, this.k);
            case 20:
                return new ProjectSectionDividerViewHolder(this.b, viewGroup);
            case 26:
                return new ProjectShareViewHolder(this.b, this.n, viewGroup);
            case 27:
                return new ProjectFreeTicketViewHolder(this.b, viewGroup, this.h);
            case 28:
                return new ProjectLineViewHolder(this.b, viewGroup);
            case 30:
                return new ProjectDiscoverViewHolder(this.b, viewGroup, this.m);
            case 31:
                return new ProjectBrandAndArtistMultiViewHolder(this.b, viewGroup);
            case 32:
                return new ProjectArtistSingleViewHolder(this.b, viewGroup);
            case 33:
                return new ProjectBrandSingleViewHolder(this.b, viewGroup);
        }
    }
}
