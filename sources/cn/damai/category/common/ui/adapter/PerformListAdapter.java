package cn.damai.category.common.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.calendar.bean.ProjectItem;
import cn.damai.category.calendar.ui.viewholder.CategoryNearViewHolder;
import cn.damai.category.category.bean.CategoryItemRankBean;
import cn.damai.category.category.repository.CategoryRepository;
import cn.damai.commonbusiness.rank.CommonRankHolder;
import cn.damai.commonbusiness.rank.RankItemBean;
import cn.damai.commonbusiness.search.Daojishi;
import cn.damai.commonbusiness.search.viewholder.ProjectItemViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.bh;
import tb.o91;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class PerformListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private View.OnClickListener b;
    private boolean e;
    private Daojishi g;
    private CategoryRepository h;
    private List<ProjectItem> c = new ArrayList();
    private boolean d = false;
    private boolean f = false;

    public PerformListAdapter(Context context, boolean z, View.OnClickListener onClickListener) {
        this.a = context;
        this.e = z;
        this.b = onClickListener;
    }

    public void a(List<ProjectItem> list, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1732053494")) {
            ipChange.ipc$dispatch("1732053494", new Object[]{this, list, Boolean.valueOf(z)});
            return;
        }
        this.d = z;
        if (wh2.e(list) > 0) {
            this.c.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void b(List<ProjectItem> list, boolean z, Daojishi daojishi) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "240081385")) {
            ipChange.ipc$dispatch("240081385", new Object[]{this, list, Boolean.valueOf(z), daojishi});
        } else if (wh2.e(list) > 0) {
            this.f = false;
            this.g = daojishi;
            this.c.clear();
            a(list, z);
        } else {
            this.c.clear();
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "261994111") ? ((Integer) ipChange.ipc$dispatch("261994111", new Object[]{this})).intValue() : wh2.e(this.c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1189960102") ? ((Integer) ipChange.ipc$dispatch("1189960102", new Object[]{this, Integer.valueOf(i)})).intValue() : this.c.get(i).type;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        CategoryItemRankBean categoryItemRankBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-525921510")) {
            ipChange.ipc$dispatch("-525921510", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else if (viewHolder != null) {
            ProjectItem projectItem = this.c.get(i);
            projectItem.index = i;
            if (i == 0 && projectItem.type == 1) {
                this.f = true;
            }
            int i2 = projectItem.type;
            if (i2 == 1) {
                ((CategoryNearViewHolder) viewHolder).a(projectItem.hasCurrentCity, false);
            } else if (i2 == 4) {
                ProjectItemViewHolder projectItemViewHolder = (ProjectItemViewHolder) viewHolder;
                projectItemViewHolder.w(this.b);
                projectItemViewHolder.u(this.g);
                projectItemViewHolder.n(projectItem.projectItemBean, this.d);
                if (i == 0) {
                    if (!this.e) {
                        projectItemViewHolder.j().setVisibility(8);
                    } else {
                        projectItemViewHolder.j().setVisibility(0);
                    }
                }
                if (i == 1 && this.f) {
                    projectItemViewHolder.j().setVisibility(8);
                }
                if (this.h != null) {
                    bh m = bh.m();
                    View view = viewHolder.itemView;
                    int i3 = projectItem.index;
                    String str = this.h.categoryName;
                    String str2 = projectItem.projectItemBean.id;
                    m.s(view, i3, str, str2, projectItem.type + "", projectItem.projectItemBean.alg);
                }
            } else if (i2 == 5 && (categoryItemRankBean = projectItem.rankBean) != null) {
                RankItemBean rankItemBean = new RankItemBean();
                rankItemBean.type = 1;
                if (!o91.a(categoryItemRankBean.verticalPicList) && categoryItemRankBean.verticalPicList.get(0) != null) {
                    rankItemBean.pic = categoryItemRankBean.verticalPicList.get(0);
                }
                rankItemBean.shortName = categoryItemRankBean.shortName;
                rankItemBean.shortDesc = categoryItemRankBean.shortDesc;
                rankItemBean.followDesc = categoryItemRankBean.followDesc;
                ((CommonRankHolder) viewHolder).a(rankItemBean);
                if (this.h != null) {
                    bh m2 = bh.m();
                    View view2 = viewHolder.itemView;
                    int i4 = projectItem.index;
                    String str3 = this.h.categoryName;
                    m2.s(view2, i4, str3, null, projectItem.type + "", null);
                }
                if (this.b != null) {
                    viewHolder.itemView.setTag(projectItem);
                    viewHolder.itemView.setOnClickListener(this.b);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1002224156")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("1002224156", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        LayoutInflater from = LayoutInflater.from(this.a);
        if (i != 1) {
            if (i != 4) {
                if (i != 5) {
                    return null;
                }
                return new CommonRankHolder(from);
            }
            return new ProjectItemViewHolder(this.a, from);
        }
        return new CategoryNearViewHolder(from);
    }
}
