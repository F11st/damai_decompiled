package cn.damai.ticklet.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.member.R$string;
import cn.damai.ticklet.bean.TickletTransferManagerListExtra;
import cn.damai.ticklet.inteface.TickletTransferCallback;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.py2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TransferAllowAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<TickletTransferManagerListExtra> a = new ArrayList();
    private Context b;
    private TickletTransferCallback c;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        DMIconFontTextView a;
        TextView b;
        TextView c;
        TextView d;
        TextView e;
        TextView f;
        View g;
        LinearLayout h;

        public ViewHolder(TransferAllowAdapter transferAllowAdapter, View view) {
            super(view);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1475092147")) {
                ipChange.ipc$dispatch("1475092147", new Object[]{this, view});
            } else {
                TransferAllowAdapter.this.c.chooseUpdateView(this.a);
            }
        }
    }

    public TransferAllowAdapter(Activity activity, LayoutInflater layoutInflater) {
        this.b = activity;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: b */
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-867170625")) {
            ipChange.ipc$dispatch("-867170625", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        TickletTransferManagerListExtra tickletTransferManagerListExtra = this.a.get(i);
        if (tickletTransferManagerListExtra == null) {
            return;
        }
        viewHolder.itemView.setTag(Integer.valueOf(i));
        py2.F(viewHolder.e, tickletTransferManagerListExtra.fullSeatInfo);
        viewHolder.a.setVisibility(0);
        if (!TextUtils.isEmpty(tickletTransferManagerListExtra.topLimitFlag) && "1".equals(tickletTransferManagerListExtra.topLimitFlag)) {
            viewHolder.d.setVisibility(0);
            viewHolder.d.setText(this.b.getResources().getString(R$string.ticklet_transfer_limit_top_tip));
            viewHolder.e.setTextColor(Color.parseColor("#aaaaaa"));
            viewHolder.a.setText(this.b.getResources().getString(R$string.iconfont_weixuan16));
            viewHolder.a.setTextColor(Color.parseColor("#E1E1E1"));
            viewHolder.itemView.setOnClickListener(null);
        } else {
            if (!TextUtils.isEmpty(tickletTransferManagerListExtra.topLimitCountDown)) {
                viewHolder.d.setVisibility(0);
                viewHolder.d.setText(this.b.getResources().getString(R$string.ticklet_transfer_allow_transfer_num, tickletTransferManagerListExtra.topLimitCountDown));
            } else {
                viewHolder.d.setVisibility(8);
            }
            viewHolder.e.setTextColor(Color.parseColor("#4a4a4a"));
            if (this.a.get(i).isCheck) {
                viewHolder.a.setTextColor(Color.parseColor("#ff2d79"));
                viewHolder.a.setText(this.b.getResources().getString(R$string.iconfont_danxuanxuanzhong16));
            } else {
                viewHolder.a.setTextColor(Color.parseColor("#636363"));
                viewHolder.a.setText(this.b.getResources().getString(R$string.iconfont_weixuan16));
            }
            viewHolder.itemView.setOnClickListener(new a(i));
        }
        String str = tickletTransferManagerListExtra.certName;
        String str2 = tickletTransferManagerListExtra.certId;
        viewHolder.h.setVisibility(8);
        py2.F(viewHolder.b, str);
        py2.F(viewHolder.c, str2);
        py2.F(viewHolder.f, tickletTransferManagerListExtra.productSystemVoucherIdWithPre);
        if (i != this.a.size() - 1) {
            viewHolder.g.setVisibility(0);
        } else {
            viewHolder.g.setVisibility(4);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: c */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1173088169")) {
            return (ViewHolder) ipChange.ipc$dispatch("-1173088169", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        View inflate = LayoutInflater.from(this.b).inflate(R$layout.ticklet_transfer_allow_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(this, inflate);
        viewHolder.a = (DMIconFontTextView) inflate.findViewById(R$id.ticklet_transfer_tv_choose_icon);
        viewHolder.b = (TextView) inflate.findViewById(R$id.ticklet_transfer_name);
        viewHolder.c = (TextView) inflate.findViewById(R$id.ticklet_transfer_cert);
        viewHolder.d = (TextView) inflate.findViewById(R$id.ticklet_transfer_limit_value);
        viewHolder.e = (TextView) inflate.findViewById(R$id.ticklet_transfer_seat_num);
        viewHolder.f = (TextView) inflate.findViewById(R$id.ticklet_transfer_tn);
        viewHolder.g = inflate.findViewById(R$id.ticklet_transfer_allow_line);
        viewHolder.h = (LinearLayout) inflate.findViewById(R$id.ticklet_ll_transfer_face_icon);
        return viewHolder;
    }

    public void d(TickletTransferCallback tickletTransferCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-203961099")) {
            ipChange.ipc$dispatch("-203961099", new Object[]{this, tickletTransferCallback});
        } else {
            this.c = tickletTransferCallback;
        }
    }

    public void e(List<TickletTransferManagerListExtra> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1334482943")) {
            ipChange.ipc$dispatch("1334482943", new Object[]{this, list});
        } else {
            this.a = list;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-949770654") ? ((Integer) ipChange.ipc$dispatch("-949770654", new Object[]{this})).intValue() : this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "171703910")) {
            return ((Long) ipChange.ipc$dispatch("171703910", new Object[]{this, Integer.valueOf(i)})).longValue();
        }
        return 0L;
    }

    public TransferAllowAdapter(Context context) {
        this.b = context;
    }
}
