package cn.damai.commonbusiness.servicenotice;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.DMRoundedCornersBitmapProcessor;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.contacts.bean.IdCardTypes;
import cn.damai.commonbusiness.share.generateimage.GenerateImageUtil;
import cn.damai.uikit.view.RoundImageView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import tb.m62;
import tb.z3;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ProjectSupportServiceViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView a;
    private TextView b;
    private LinearLayout c;
    private TextView d;
    private FrameLayout e;
    private RoundImageView f;
    private View g;
    private int h;
    public Context i;
    private ArrayList<IdCardTypes> j;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.servicenotice.ProjectSupportServiceViewHolder$a */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0866a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0866a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-355185920")) {
                ipChange.ipc$dispatch("-355185920", new Object[]{this, view});
            } else if (ProjectSupportServiceViewHolder.this.j != null) {
                ProjectSupportServiceViewHolder projectSupportServiceViewHolder = ProjectSupportServiceViewHolder.this;
                z3.a(projectSupportServiceViewHolder.i, 4121, GenerateImageUtil.TYPE_FROMWHERE_PEOJECT_DETAIL, projectSupportServiceViewHolder.j);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.servicenotice.ProjectSupportServiceViewHolder$b */
    /* loaded from: classes.dex */
    public class C0867b implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C0867b() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.C0501d c0501d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1723373389")) {
                ipChange.ipc$dispatch("-1723373389", new Object[]{this, c0501d});
            } else {
                ProjectSupportServiceViewHolder.this.e.setVisibility(8);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.servicenotice.ProjectSupportServiceViewHolder$c */
    /* loaded from: classes.dex */
    public class C0868c implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C0868c() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.C0502e c0502e) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-583481336")) {
                ipChange.ipc$dispatch("-583481336", new Object[]{this, c0502e});
            } else if (c0502e == null || c0502e.a == null) {
            } else {
                ProjectSupportServiceViewHolder.this.f.setImageDrawable(c0502e.a);
                ProjectSupportServiceViewHolder.this.f.getLayoutParams().height = (int) (c0502e.a.getIntrinsicHeight() * ((ProjectSupportServiceViewHolder.this.h * 1.0f) / c0502e.a.getIntrinsicWidth()));
                ProjectSupportServiceViewHolder.this.e.setVisibility(0);
            }
        }
    }

    public ProjectSupportServiceViewHolder(Context context, ViewGroup viewGroup) {
        super(LayoutInflater.from(context).inflate(R$layout.layout_service_notice_item, viewGroup, false));
        this.h = 0;
        this.i = context;
        g();
    }

    private void g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1712659594")) {
            ipChange.ipc$dispatch("1712659594", new Object[]{this});
            return;
        }
        this.a = (TextView) this.itemView.findViewById(R$id.project_service_item_tag_name_tv);
        this.b = (TextView) this.itemView.findViewById(R$id.project_service_item_tag_desc_tv);
        this.c = (LinearLayout) this.itemView.findViewById(R$id.project_service_item_tag_action);
        this.d = (TextView) this.itemView.findViewById(R$id.project_support_service_item_action_desc);
        this.e = (FrameLayout) this.itemView.findViewById(R$id.project_service_item_tag_ll);
        this.f = (RoundImageView) this.itemView.findViewById(R$id.project_service_item_tag_img);
        this.g = this.itemView.findViewById(R$id.line);
        this.h = DisplayMetrics.getwidthPixels(m62.b(this.i)) - m62.a(this.i, 42.0f);
    }

    private void h(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "555260587")) {
            ipChange.ipc$dispatch("555260587", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str) && "1".equals(str)) {
            if (this.c.getVisibility() == 8) {
                this.c.setVisibility(0);
            }
            this.d.setText(this.i.getResources().getString(R$string.add_contacts_title_text));
            this.c.setVisibility(this.j == null ? 8 : 0);
            this.c.setOnClickListener(new View$OnClickListenerC0866a());
        } else if (this.c.getVisibility() == 0) {
            this.c.setVisibility(8);
        }
    }

    private void i(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "3628728")) {
            ipChange.ipc$dispatch("3628728", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
            this.e.setVisibility(8);
        } else {
            DMImageCreator c = C0504a.b().c(str);
            int i = R$drawable.uikit_default_image_bg_grey;
            c.i(i).c(i).k(new DMRoundedCornersBitmapProcessor(6, 0)).n(new C0868c()).e(new C0867b()).f();
        }
    }

    private void j(String str, String str2, boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1885300376")) {
            ipChange.ipc$dispatch("1885300376", new Object[]{this, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)});
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
            if (z) {
                this.b.setText(Html.fromHtml(str2));
            } else {
                this.b.setText(str2);
            }
        } else {
            this.b.setVisibility(8);
        }
        if (z2) {
            this.g.setVisibility(0);
        } else {
            this.g.setVisibility(8);
        }
    }

    public void e(ServiceNote serviceNote, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1133949544")) {
            ipChange.ipc$dispatch("1133949544", new Object[]{this, serviceNote, Boolean.valueOf(z)});
        } else if (serviceNote == null) {
        } else {
            j(serviceNote.getTagName(), TextUtils.isEmpty(serviceNote.tagDescWithStyle) ? serviceNote.getTagDesc() : serviceNote.tagDescWithStyle, !TextUtils.isEmpty(serviceNote.tagDescWithStyle), z);
            h(serviceNote.getTagType());
            i(serviceNote.imgUrl);
        }
    }

    public void f(TicketNote ticketNote, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "516534261")) {
            ipChange.ipc$dispatch("516534261", new Object[]{this, ticketNote, Boolean.valueOf(z)});
        } else if (ticketNote == null) {
        } else {
            j(ticketNote.title, ticketNote.getContent(), false, z);
            i(ticketNote.getImgUrl());
        }
    }

    public void k(ArrayList<IdCardTypes> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1071883631")) {
            ipChange.ipc$dispatch("1071883631", new Object[]{this, arrayList});
        } else {
            this.j = arrayList;
        }
    }
}
