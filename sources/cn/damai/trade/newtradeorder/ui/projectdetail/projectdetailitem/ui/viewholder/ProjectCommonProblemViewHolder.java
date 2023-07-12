package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.dataholder.ProjectDataHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.listeners.OnCommonProblemsListener;
import cn.damai.uikit.flowlayout.FlowLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.pp2;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ProjectCommonProblemViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private FlowLayout b;
    private TextView c;
    private List<String> d;
    private OnCommonProblemsListener e;
    private boolean f;
    private String g;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-667108055")) {
                ipChange.ipc$dispatch("-667108055", new Object[]{this, view});
            } else if (ProjectCommonProblemViewHolder.this.e != null) {
                ProjectCommonProblemViewHolder.this.e.onMoreClick(4, -1, ProjectCommonProblemViewHolder.this.c.getTop());
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;
        final /* synthetic */ String b;

        b(int i, String str) {
            this.a = i;
            this.b = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1444182314")) {
                ipChange.ipc$dispatch("1444182314", new Object[]{this, view});
            } else if (ProjectCommonProblemViewHolder.this.e != null) {
                ProjectCommonProblemViewHolder.this.e.onProblemItemClick(this.a, this.b);
            }
        }
    }

    public ProjectCommonProblemViewHolder(Context context, OnCommonProblemsListener onCommonProblemsListener, ViewGroup viewGroup) {
        super(LayoutInflater.from(context).inflate(R$layout.project_item_common_problems_layout, viewGroup, false));
        this.a = context;
        this.e = onCommonProblemsListener;
        this.b = (FlowLayout) this.itemView.findViewById(R$id.project_common_problems_fl);
        TextView textView = (TextView) this.itemView.findViewById(R$id.project_item_more_text_tv);
        this.c = textView;
        textView.setOnClickListener(new a());
    }

    private void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-320175459")) {
            ipChange.ipc$dispatch("-320175459", new Object[]{this});
            return;
        }
        int e = wh2.e(this.d);
        for (int i = 0; i < e; i++) {
            this.b.addView(d(i, this.d.get(i)));
        }
    }

    private View d(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-288453186")) {
            return (View) ipChange.ipc$dispatch("-288453186", new Object[]{this, Integer.valueOf(i), str});
        }
        View inflate = LayoutInflater.from(this.a).inflate(R$layout.project_detail_item_problem_item, (ViewGroup) this.b, false);
        TextView textView = (TextView) inflate.findViewById(R$id.problem_name_tv);
        textView.setText(str);
        pp2.u().I1(textView, this.g, i);
        textView.setOnClickListener(new b(i, str));
        return inflate;
    }

    public void e(ProjectDataHolder projectDataHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1076934832")) {
            ipChange.ipc$dispatch("-1076934832", new Object[]{this, projectDataHolder});
        } else if (this.f) {
        } else {
            this.f = true;
            this.b.removeAllViews();
            List<String> list = this.d;
            if (list == null || list.isEmpty()) {
                this.d = projectDataHolder.getCommonProblems();
            }
            this.g = projectDataHolder.getProjectId();
            c();
        }
    }
}
