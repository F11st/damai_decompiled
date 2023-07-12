package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.dataholder.ProjectDataHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.listeners.OnSectionMoreClickListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.pp2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ProjectMoreContentViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private View a;
    private TextView b;
    private OnSectionMoreClickListener c;
    private int d;
    private int e;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "348876185")) {
                ipChange.ipc$dispatch("348876185", new Object[]{this, view});
            } else if (ProjectMoreContentViewHolder.this.c != null) {
                ProjectMoreContentViewHolder.this.c.onMoreClick(ProjectMoreContentViewHolder.this.d, ProjectMoreContentViewHolder.this.e, ProjectMoreContentViewHolder.this.itemView.getTop());
            }
        }
    }

    public ProjectMoreContentViewHolder(Context context, OnSectionMoreClickListener onSectionMoreClickListener, ViewGroup viewGroup) {
        super(LayoutInflater.from(context).inflate(R$layout.project_item_more_layout, viewGroup, false));
        this.c = onSectionMoreClickListener;
        e();
    }

    private void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "183573798")) {
            ipChange.ipc$dispatch("183573798", new Object[]{this});
            return;
        }
        this.b = (TextView) this.itemView.findViewById(R$id.project_item_more_text_tv);
        this.a = this.itemView.findViewById(R$id.line);
        this.b.setOnClickListener(new a());
    }

    public void d(ProjectDataHolder projectDataHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2024624064")) {
            ipChange.ipc$dispatch("2024624064", new Object[]{this, projectDataHolder});
        } else if (projectDataHolder == null) {
        } else {
            this.e = projectDataHolder.getRichType();
            String moreContent = projectDataHolder.getMoreContent();
            if (TextUtils.isEmpty(moreContent)) {
                this.b.setVisibility(8);
                this.b.setText("");
            } else {
                this.b.setVisibility(0);
                this.b.setText(moreContent);
            }
            int moreType = projectDataHolder.getMoreType();
            this.d = moreType;
            if (moreType == 0) {
                this.a.setVisibility(0);
            } else if (moreType == 2) {
                this.a.setVisibility(0);
                pp2.u().T1(this.b, projectDataHolder.getProjectId());
            } else {
                if (moreType == 4) {
                    pp2.u().o2(this.b, projectDataHolder.getProjectId());
                }
                this.a.setVisibility(8);
            }
        }
    }
}
