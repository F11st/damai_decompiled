package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.user.C0529c;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectTour;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.e80;
import tb.m62;
import tb.pp2;
import tb.qd2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ProjectTourViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private LinearLayout a;
    private TextView b;
    private TextView c;
    private View d;
    private View e;
    private int f;
    private int g;
    private Context h;
    private View.OnClickListener i;
    private String j;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectTourViewHolder$a */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2414a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2414a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1053370765")) {
                ipChange.ipc$dispatch("-1053370765", new Object[]{this, view});
                return;
            }
            ProjectTour projectTour = (ProjectTour) view.getTag();
            if (projectTour == null || projectTour.itemId.equals(ProjectTourViewHolder.this.j)) {
                return;
            }
            C0529c.e().x(pp2.u().Q0(ProjectTourViewHolder.this.j, projectTour.index));
            Bundle bundle = new Bundle();
            bundle.putString(IssueConstants.ProjectID, projectTour.itemId);
            qd2.a(ProjectTourViewHolder.this.h, projectTour.schema, bundle);
        }
    }

    public ProjectTourViewHolder(Context context, LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.project_item_tour_child, (ViewGroup) null));
        this.i = new View$OnClickListenerC2414a();
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-2, -2));
        this.h = context;
        d(this.itemView);
        this.g = m62.a(context, 98.0f);
        this.f = (e80.d() - m62.a(context, 39.0f)) / 2;
    }

    private void d(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-923573806")) {
            ipChange.ipc$dispatch("-923573806", new Object[]{this, view});
            return;
        }
        this.a = (LinearLayout) view.findViewById(R$id.ll_tour);
        this.b = (TextView) view.findViewById(R$id.tv_tour_city);
        this.c = (TextView) view.findViewById(R$id.tv_tour_time);
        this.d = view.findViewById(R$id.v_left);
        this.e = view.findViewById(R$id.v_right);
        this.a.setOnClickListener(this.i);
    }

    public void c(String str, ProjectTour projectTour, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1013177208")) {
            ipChange.ipc$dispatch("-1013177208", new Object[]{this, str, projectTour, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (projectTour == null) {
        } else {
            projectTour.index = i2;
            this.j = str;
            this.a.setTag(projectTour);
            if (!TextUtils.isEmpty(str) && str.equals(projectTour.itemId)) {
                this.a.setBackgroundResource(R$drawable.bg_project_tour_red);
                this.b.setTextColor(Color.parseColor("#FF388F"));
            } else {
                this.a.setBackgroundResource(R$drawable.bg_project_tour_grey);
                this.b.setTextColor(Color.parseColor("#111111"));
            }
            this.b.setText(projectTour.cityName);
            this.c.setText(projectTour.showTime);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.a.getLayoutParams();
            if (i == 2) {
                layoutParams.width = this.f;
            } else {
                layoutParams.width = this.g;
            }
            if (i2 == 0) {
                this.d.setVisibility(0);
                this.e.setVisibility(8);
            } else if (i2 == i - 1) {
                this.d.setVisibility(8);
                this.e.setVisibility(0);
            } else {
                this.d.setVisibility(8);
                this.e.setVisibility(8);
            }
            this.a.setLayoutParams(layoutParams);
        }
    }
}
