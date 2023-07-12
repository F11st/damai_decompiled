package com.alibaba.pictures.bricks.component.instructions;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.bean.TicketNote;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ProjectSupportServiceViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView a;
    private TextView b;
    private View c;

    public ProjectSupportServiceViewHolder(Context context, ViewGroup viewGroup) {
        super(LayoutInflater.from(context).inflate(R$layout.bricks_layout_service_notice_item, viewGroup, false));
        b();
    }

    private void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1999031237")) {
            ipChange.ipc$dispatch("-1999031237", new Object[]{this});
            return;
        }
        this.a = (TextView) this.itemView.findViewById(R$id.project_service_item_tag_name_tv);
        this.b = (TextView) this.itemView.findViewById(R$id.project_service_item_tag_desc_tv);
        this.c = this.itemView.findViewById(R$id.line);
    }

    private void c(String str, String str2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "948053867")) {
            ipChange.ipc$dispatch("948053867", new Object[]{this, str, str2, Boolean.valueOf(z)});
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.a.setText(str);
            this.a.setVisibility(0);
        } else {
            this.a.setVisibility(8);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.b.setVisibility(0);
            this.b.setText(str2);
        } else {
            this.b.setVisibility(8);
        }
        if (z) {
            this.c.setVisibility(0);
        } else {
            this.c.setVisibility(8);
        }
    }

    public void a(TicketNote ticketNote, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1724019050")) {
            ipChange.ipc$dispatch("-1724019050", new Object[]{this, ticketNote, Boolean.valueOf(z)});
        } else if (ticketNote == null) {
        } else {
            c(ticketNote.getTitle(), ticketNote.getContent(), z);
        }
    }

    public void d(ArrayList<TicketNote> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "318241312")) {
            ipChange.ipc$dispatch("318241312", new Object[]{this, arrayList});
        }
    }
}
