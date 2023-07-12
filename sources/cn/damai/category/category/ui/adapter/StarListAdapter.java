package cn.damai.category.category.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.category.bean.StarAndBrandItem;
import cn.damai.category.category.bean.StarBean;
import cn.damai.category.category.ui.viewholder.StarHolder;
import cn.damai.category.category.ui.viewholder.ToursHolder;
import cn.damai.category.category.ui.viewholder.VideoStarHolder;
import cn.damai.commonbusiness.search.Daojishi;
import cn.damai.commonbusiness.search.viewholder.ProjectItemViewHolder;
import cn.damai.homepage.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.wh2;
import tb.yf2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class StarListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private View.OnClickListener b;
    private View.OnClickListener c;
    private View.OnClickListener d;
    private View.OnClickListener e;
    private List<StarAndBrandItem> f = new ArrayList();
    private String g;
    private Daojishi h;
    private boolean i;
    private boolean j;

    public StarListAdapter(boolean z, Context context, String str, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4) {
        this.a = context;
        this.g = str;
        this.d = onClickListener;
        this.c = onClickListener2;
        this.b = onClickListener3;
        this.e = onClickListener4;
        this.j = z;
    }

    public void a(List<StarAndBrandItem> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1006393228")) {
            ipChange.ipc$dispatch("-1006393228", new Object[]{this, list});
        } else if (wh2.e(list) > 0) {
            this.f.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void b(List<StarAndBrandItem> list, Daojishi daojishi) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1641111411")) {
            ipChange.ipc$dispatch("-1641111411", new Object[]{this, list, daojishi});
        } else if (wh2.e(list) > 0) {
            this.h = daojishi;
            this.f.clear();
            a(list);
        } else {
            this.f.clear();
            notifyDataSetChanged();
        }
    }

    public void c(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1755004040")) {
            ipChange.ipc$dispatch("1755004040", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.i = z;
        }
    }

    public void d(int i) {
        StarAndBrandItem starAndBrandItem;
        StarBean starBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "297975329")) {
            ipChange.ipc$dispatch("297975329", new Object[]{this, Integer.valueOf(i)});
        } else if (this.f != null) {
            for (int i2 = 0; i2 < this.f.size(); i2++) {
                if (i2 == i && (starAndBrandItem = this.f.get(i2)) != null && (starBean = starAndBrandItem.starBean) != null) {
                    starBean.followStatus = 1;
                    notifyDataSetChanged();
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "336745577") ? ((Integer) ipChange.ipc$dispatch("336745577", new Object[]{this})).intValue() : wh2.e(this.f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1565724016") ? ((Integer) ipChange.ipc$dispatch("-1565724016", new Object[]{this, Integer.valueOf(i)})).intValue() : this.f.get(i).type;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1457797872")) {
            ipChange.ipc$dispatch("1457797872", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else if (viewHolder != null) {
            StarAndBrandItem starAndBrandItem = this.f.get(i);
            starAndBrandItem.position = i;
            int i2 = starAndBrandItem.type;
            if (i2 == 2) {
                ((StarHolder) viewHolder).a(starAndBrandItem, i, this.c);
                if (this.d != null) {
                    viewHolder.itemView.setTag(starAndBrandItem);
                    viewHolder.itemView.setOnClickListener(this.d);
                }
                if (starAndBrandItem.starBean != null) {
                    yf2.j(this.j, viewHolder.itemView, starAndBrandItem.index, z20.E(), starAndBrandItem.starBean.damaiId, this.g);
                }
            } else if (i2 == 4) {
                ProjectItemViewHolder projectItemViewHolder = (ProjectItemViewHolder) viewHolder;
                projectItemViewHolder.u(this.h);
                projectItemViewHolder.k(starAndBrandItem.projectItemBean);
                if (this.b != null) {
                    viewHolder.itemView.setTag(starAndBrandItem);
                    viewHolder.itemView.setOnClickListener(this.b);
                }
                if (starAndBrandItem.projectItemBean != null) {
                    yf2.k(this.j, viewHolder.itemView, starAndBrandItem.index, z20.E(), starAndBrandItem.projectItemBean.id, this.g);
                }
            } else if (i2 == 11) {
                ((VideoStarHolder) viewHolder).b(starAndBrandItem, this.h);
                if (this.b != null) {
                    viewHolder.itemView.setTag(starAndBrandItem);
                    viewHolder.itemView.setOnClickListener(this.b);
                }
            } else if (i2 != 12) {
            } else {
                ((ToursHolder) viewHolder).a(starAndBrandItem, i, this.i);
                if (this.b != null) {
                    viewHolder.itemView.setTag(starAndBrandItem);
                    viewHolder.itemView.setOnClickListener(this.b);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-76222714")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-76222714", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        LayoutInflater from = LayoutInflater.from(this.a);
        if (i != 2) {
            if (i != 4) {
                if (i != 11) {
                    if (i != 12) {
                        return null;
                    }
                    return new ToursHolder(LayoutInflater.from(this.a).inflate(R$layout.category_star_jour_container_layout, viewGroup, false), this.g, this.e);
                }
                return new VideoStarHolder(from);
            }
            return new ProjectItemViewHolder(this.a, from);
        }
        return new StarHolder(from);
    }
}
