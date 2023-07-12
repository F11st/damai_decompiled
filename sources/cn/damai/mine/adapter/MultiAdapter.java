package cn.damai.mine.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.bean.RankBean;
import cn.damai.commonbusiness.discover.viewholder.BaseViewHolder;
import cn.damai.commonbusiness.discover.viewholder.NoteViewHolder;
import cn.damai.commonbusiness.discover.viewholder.OnItemClickListener;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.search.viewholder.ProjectItemViewHolder;
import cn.damai.mine.listener.OnMultiListClickListener;
import cn.damai.tetris.component.discover.bean.Extra;
import cn.damai.tetris.component.discover.bean.NoteBean;
import cn.damai.tetris.component.discover.bean.ThemeBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.cb2;
import tb.rm1;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class MultiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private OnMultiListClickListener b;
    private Exposure c;
    private List d;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface Exposure {
        void exposureNote(View view, NoteBean noteBean, int i);

        void exposureProject(View view, ProjectItemBean projectItemBean, int i);

        void exposureRank(View view, RankBean rankBean, int i);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.mine.adapter.MultiAdapter$a */
    /* loaded from: classes6.dex */
    public class C1426a implements OnItemClickListener<NoteBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        C1426a() {
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.OnItemClickListener
        /* renamed from: a */
        public void onEditClick(NoteBean noteBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1136202230")) {
                ipChange.ipc$dispatch("-1136202230", new Object[]{this, noteBean, Integer.valueOf(i)});
            }
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.OnItemClickListener
        /* renamed from: b */
        public void onItemClick(NoteBean noteBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1166350495")) {
                ipChange.ipc$dispatch("-1166350495", new Object[]{this, noteBean, Integer.valueOf(i)});
            } else if (MultiAdapter.this.b != null) {
                MultiAdapter.this.b.onNoteClick(noteBean, i);
            }
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.OnItemClickListener
        public /* synthetic */ void onDnaClick(NoteBean noteBean, int i) {
            rm1.a(this, noteBean, i);
        }
    }

    public MultiAdapter(Context context, OnMultiListClickListener onMultiListClickListener) {
        this.a = context;
        this.b = onMultiListClickListener;
    }

    public void b(List list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-738562256")) {
            ipChange.ipc$dispatch("-738562256", new Object[]{this, list});
        } else if (cb2.d(list)) {
        } else {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            int size = this.d.size();
            this.d.addAll(list);
            notifyItemRangeInserted(size, list.size());
        }
    }

    public void c(Exposure exposure) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "305077656")) {
            ipChange.ipc$dispatch("305077656", new Object[]{this, exposure});
        } else {
            this.c = exposure;
        }
    }

    public void d(List list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "965444175")) {
            ipChange.ipc$dispatch("965444175", new Object[]{this, list});
            return;
        }
        this.d = list;
        notifyDataSetChanged();
    }

    public void e(List list, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1522447422")) {
            ipChange.ipc$dispatch("1522447422", new Object[]{this, list, Boolean.valueOf(z)});
        } else if (z) {
            d(list);
        } else {
            b(list);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1516839367")) {
            return ((Integer) ipChange.ipc$dispatch("-1516839367", new Object[]{this})).intValue();
        }
        List list = this.d;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1748505696")) {
            return ((Integer) ipChange.ipc$dispatch("1748505696", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        Class<?> cls = this.d.get(i).getClass();
        if (cls == ThemeBean.class) {
            return 2;
        }
        if (cls == NoteBean.class) {
            return 1;
        }
        if (cls == ProjectItemBean.class) {
            return 3;
        }
        if (cls == RankBean.class) {
            return 4;
        }
        return super.getItemViewType(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-305443040")) {
            ipChange.ipc$dispatch("-305443040", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        Object obj = this.d.get(i);
        if (viewHolder instanceof BaseViewHolder) {
            if (obj instanceof Extra) {
                Extra extra = (Extra) obj;
                if (i % 5 == 0) {
                    extra.setHwRatio(1.3333334f);
                } else {
                    extra.setHwRatio(1.0f);
                }
            }
            ((BaseViewHolder) viewHolder).a(obj, i);
        }
        Exposure exposure = this.c;
        if (exposure != null) {
            if (obj instanceof NoteBean) {
                exposure.exposureNote(viewHolder.itemView, (NoteBean) obj, i);
            } else if (obj instanceof RankBean) {
                exposure.exposureRank(viewHolder.itemView, (RankBean) obj, i);
            } else if (obj instanceof ProjectItemBean) {
                exposure.exposureProject(viewHolder.itemView, (ProjectItemBean) obj, i);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2041311446")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("2041311446", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        if (i != 1) {
            Context context = this.a;
            return new ProjectItemViewHolder(context, LayoutInflater.from(context));
        }
        return new NoteViewHolder(this.a, viewGroup, new C1426a());
    }
}
