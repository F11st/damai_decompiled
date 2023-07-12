package cn.damai.ticklet.ui.adapter;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.py2;
import tb.rp2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TickletTransferTipsViewHolder extends ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView a;
    private TextView b;
    private Activity c;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.ticklet.ui.adapter.TickletTransferTipsViewHolder$a */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC2054a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ rp2 a;

        View$OnClickListenerC2054a(rp2 rp2Var) {
            this.a = rp2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1052531042")) {
                ipChange.ipc$dispatch("-1052531042", new Object[]{this, view});
            } else if (this.a.e() == null || TextUtils.isEmpty(this.a.e().getLink())) {
            } else {
                py2.f().n(TickletTransferTipsViewHolder.this.c, this.a.e().getLink());
            }
        }
    }

    public TickletTransferTipsViewHolder(Activity activity, LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.ticklet_transfer_tips_item, (ViewGroup) null));
        this.c = activity;
        this.a = (TextView) this.itemView.findViewById(R$id.ticklet_transfer_tip_text);
        this.b = (TextView) this.itemView.findViewById(R$id.ticklet_transfer_tip_right_arrow);
        this.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void b(rp2 rp2Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-274109249")) {
            ipChange.ipc$dispatch("-274109249", new Object[]{this, rp2Var});
            return;
        }
        this.a.setText(rp2Var.b());
        if (!TextUtils.isEmpty(rp2Var.e().getLink())) {
            View$OnClickListenerC2054a view$OnClickListenerC2054a = new View$OnClickListenerC2054a(rp2Var);
            this.b.setVisibility(0);
            this.a.setOnClickListener(view$OnClickListenerC2054a);
            this.b.setOnClickListener(view$OnClickListenerC2054a);
            return;
        }
        this.b.setVisibility(8);
    }
}
