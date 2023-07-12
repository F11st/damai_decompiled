package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.servicenotice.TicketNote;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.dataholder.ProjectDataHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.listeners.OnSectionMoreClickListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectNoticePromptViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ProjectNoticePromptViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private View f;
    private OnSectionMoreClickListener g;
    private int h;
    private int i;

    public ProjectNoticePromptViewHolder(Context context, OnSectionMoreClickListener onSectionMoreClickListener, ViewGroup viewGroup) {
        super(LayoutInflater.from(context).inflate(R$layout.project_item_notice_matter_item_layout, viewGroup, false));
        this.g = onSectionMoreClickListener;
        this.a = context;
        c();
    }

    private void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-901617805")) {
            ipChange.ipc$dispatch("-901617805", new Object[]{this});
            return;
        }
        this.b = (TextView) this.itemView.findViewById(R$id.project_item_prompt_tag_name_tv);
        this.c = (TextView) this.itemView.findViewById(R$id.project_item_prompt_tag_desc_tv);
        this.d = (TextView) this.itemView.findViewById(R$id.project_item_prompt_tag_name_tv2);
        this.e = (TextView) this.itemView.findViewById(R$id.project_item_prompt_tag_desc_tv2);
        this.f = this.itemView.findViewById(R$id.project_item_prompt_tag_desc_ll);
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: tb.dw1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProjectNoticePromptViewHolder.this.d(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1360514970")) {
            ipChange.ipc$dispatch("-1360514970", new Object[]{this, view});
            return;
        }
        OnSectionMoreClickListener onSectionMoreClickListener = this.g;
        if (onSectionMoreClickListener != null) {
            onSectionMoreClickListener.onMoreClick(this.h, this.i, this.itemView.getTop());
        }
    }

    public void b(ProjectDataHolder projectDataHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-250088802")) {
            ipChange.ipc$dispatch("-250088802", new Object[]{this, projectDataHolder});
        } else if (projectDataHolder != null) {
            TicketNote ticketNote = projectDataHolder.getTicketNote();
            boolean isTicketNoteEndPos = projectDataHolder.isTicketNoteEndPos();
            this.h = projectDataHolder.getMoreType();
            if (!isTicketNoteEndPos) {
                View view = this.itemView;
                view.setPadding(view.getPaddingLeft(), this.itemView.getPaddingTop(), this.itemView.getPaddingRight(), 0);
            } else {
                View view2 = this.itemView;
                view2.setPadding(view2.getPaddingLeft(), this.itemView.getPaddingTop(), this.itemView.getPaddingRight(), t60.a(this.a, 15.0f));
            }
            if (ticketNote != null) {
                String title = ticketNote.getTitle();
                String content = ticketNote.getContent();
                TextView textView = this.b;
                if (TextUtils.isEmpty(title)) {
                    title = "";
                }
                textView.setText(title);
                TextView textView2 = this.c;
                if (TextUtils.isEmpty(content)) {
                    content = "";
                }
                textView2.setText(content);
            }
            TicketNote ticketNote2rd = projectDataHolder.getTicketNote2rd();
            if (ticketNote2rd != null) {
                this.f.setVisibility(0);
                this.d.setText(!TextUtils.isEmpty(ticketNote2rd.getTitle()) ? ticketNote2rd.getTitle() : "");
                this.e.setText(TextUtils.isEmpty(ticketNote2rd.getContent()) ? "" : ticketNote2rd.getContent());
                return;
            }
            this.f.setVisibility(4);
        }
    }
}
