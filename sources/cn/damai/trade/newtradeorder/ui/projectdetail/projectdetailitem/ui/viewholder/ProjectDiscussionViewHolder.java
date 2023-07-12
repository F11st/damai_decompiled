package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.dataholder.ProjectDataHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.listeners.OnDiscussionClickListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ProjectDiscussionViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView a;
    private TextView b;
    private OnDiscussionClickListener c;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectDiscussionViewHolder$a */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2391a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2391a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1721700861")) {
                ipChange.ipc$dispatch("-1721700861", new Object[]{this, view});
            } else if (ProjectDiscussionViewHolder.this.c != null) {
                ProjectDiscussionViewHolder.this.c.onDiscussionClick(view);
            }
        }
    }

    public ProjectDiscussionViewHolder(Context context, ViewGroup viewGroup, OnDiscussionClickListener onDiscussionClickListener) {
        super(LayoutInflater.from(context).inflate(R$layout.project_item_discussion_layout, viewGroup, false));
        this.c = onDiscussionClickListener;
        c();
        d();
    }

    private void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1590072729")) {
            ipChange.ipc$dispatch("-1590072729", new Object[]{this});
            return;
        }
        this.a = (TextView) this.itemView.findViewById(R$id.project_discussion_content_tv);
        LinearLayout linearLayout = (LinearLayout) this.itemView.findViewById(R$id.project_discussion_indicator_lv);
        this.b = (TextView) this.itemView.findViewById(R$id.project_discussion_tips_tv);
    }

    private void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1448300291")) {
            ipChange.ipc$dispatch("1448300291", new Object[]{this});
        } else {
            this.itemView.setOnClickListener(new View$OnClickListenerC2391a());
        }
    }

    public void b(ProjectDataHolder projectDataHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "847458602")) {
            ipChange.ipc$dispatch("847458602", new Object[]{this, projectDataHolder});
            return;
        }
        SpannableString discussionContent = projectDataHolder.getDiscussionContent();
        String discussionTips = projectDataHolder.getDiscussionTips();
        TextView textView = this.a;
        if (TextUtils.isEmpty(discussionContent)) {
            discussionContent = "";
        }
        textView.setText(discussionContent);
        TextView textView2 = this.b;
        if (TextUtils.isEmpty(discussionTips)) {
            discussionTips = "";
        }
        textView2.setText(discussionTips);
    }
}
