package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.user.C0529c;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectRatingContentLabelBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.pp2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class HeaderScoreTagAdapter extends RecyclerView.Adapter<ViewHolder> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<ProjectRatingContentLabelBean> b;
    private LayoutInflater c;
    private long d;
    private OnHeadClickListener e;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private final TextView a;
        private View b;
        private View c;

        public ViewHolder(@NonNull HeaderScoreTagAdapter headerScoreTagAdapter, View view) {
            super(view);
            this.a = (TextView) view.findViewById(R$id.tv_tag);
            this.b = view.findViewById(R$id.v_left);
            this.c = view.findViewById(R$id.v_right);
        }

        public void a(@NonNull ViewHolder viewHolder, String str, int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1778397405")) {
                ipChange.ipc$dispatch("1778397405", new Object[]{this, viewHolder, str, Integer.valueOf(i), Integer.valueOf(i2)});
                return;
            }
            TextView textView = viewHolder.a;
            if (textView != null) {
                textView.setText(str);
            }
            if (i == 0) {
                this.b.setVisibility(0);
                this.c.setVisibility(8);
            } else if (i == i2 - 1) {
                this.b.setVisibility(8);
                this.c.setVisibility(0);
            } else {
                this.b.setVisibility(8);
                this.c.setVisibility(8);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.adapter.HeaderScoreTagAdapter$a */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2283a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ProjectRatingContentLabelBean a;
        final /* synthetic */ int b;

        View$OnClickListenerC2283a(ProjectRatingContentLabelBean projectRatingContentLabelBean, int i) {
            this.a = projectRatingContentLabelBean;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1277585017")) {
                ipChange.ipc$dispatch("1277585017", new Object[]{this, view});
            } else if (this.a == null || HeaderScoreTagAdapter.this.e == null) {
            } else {
                HeaderScoreTagAdapter.this.e.onScoreBottomTagClick(this.a);
                C0529c.e().x(pp2.u().Z0(Long.toString(HeaderScoreTagAdapter.this.d), this.b));
            }
        }
    }

    public HeaderScoreTagAdapter(Context context, List<ProjectRatingContentLabelBean> list, long j, OnHeadClickListener onHeadClickListener) {
        this.a = context;
        this.b = list;
        this.c = LayoutInflater.from(context);
        this.d = j;
        this.e = onHeadClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: c */
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1543299841")) {
            ipChange.ipc$dispatch("-1543299841", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        List<ProjectRatingContentLabelBean> list = this.b;
        if (list == null || list.size() == 0) {
            return;
        }
        ProjectRatingContentLabelBean projectRatingContentLabelBean = this.b.get(i);
        viewHolder.a(viewHolder, projectRatingContentLabelBean.labelName, i, this.b.size());
        viewHolder.itemView.setOnClickListener(new View$OnClickListenerC2283a(projectRatingContentLabelBean, i));
        pp2.u().e2(viewHolder.itemView, Long.toString(this.d), projectRatingContentLabelBean.labelName, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: d */
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "791826199") ? (ViewHolder) ipChange.ipc$dispatch("791826199", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new ViewHolder(this, this.c.inflate(R$layout.header_project_socre_bottom_tag_item, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1237465640") ? ((Integer) ipChange.ipc$dispatch("1237465640", new Object[]{this})).intValue() : this.b.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "228407916")) {
            ipChange.ipc$dispatch("228407916", new Object[]{this, view});
        }
    }
}
