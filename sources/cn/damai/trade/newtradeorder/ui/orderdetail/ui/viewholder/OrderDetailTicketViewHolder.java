package cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.trade.R$color;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailTicketService;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailTicketServiceTitle;
import cn.damai.uikit.flowlayout.FlowLayout;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.mo1;
import tb.wh2;
import tb.xr;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class OrderDetailTicketViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private FlowLayout a;
    private LayoutInflater b;
    private Context c;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a(OrderDetailTicketViewHolder orderDetailTicketViewHolder) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "930097172")) {
                ipChange.ipc$dispatch("930097172", new Object[]{this, view});
                return;
            }
            Object tag = view.getTag();
            if (tag != null) {
                xr.c(mo1.NOTIFY_JUMP_TICKET_SERVICE, tag);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class b implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DMIconFontTextView a;
        final /* synthetic */ ImageView b;

        b(OrderDetailTicketViewHolder orderDetailTicketViewHolder, DMIconFontTextView dMIconFontTextView, ImageView imageView) {
            this.a = dMIconFontTextView;
            this.b = imageView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1910742983")) {
                ipChange.ipc$dispatch("1910742983", new Object[]{this, dVar});
                return;
            }
            this.a.setVisibility(0);
            this.b.setVisibility(8);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class c implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DMIconFontTextView a;
        final /* synthetic */ ImageView b;

        c(OrderDetailTicketViewHolder orderDetailTicketViewHolder, DMIconFontTextView dMIconFontTextView, ImageView imageView) {
            this.a = dMIconFontTextView;
            this.b = imageView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1770807324")) {
                ipChange.ipc$dispatch("1770807324", new Object[]{this, eVar});
            } else if (eVar != null && eVar.a != null) {
                this.a.setVisibility(8);
                this.b.setVisibility(0);
                this.b.setImageDrawable(eVar.a);
            } else {
                this.a.setVisibility(0);
                this.b.setVisibility(8);
            }
        }
    }

    public OrderDetailTicketViewHolder(Context context, LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.order_detail_ticket_service, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.b = layoutInflater;
        this.c = context;
        FlowLayout flowLayout = (FlowLayout) this.itemView.findViewById(R$id.fl_ticket_service);
        this.a = flowLayout;
        flowLayout.setSingleLine(true);
        this.itemView.setOnClickListener(new a(this));
    }

    private View a(OrderDetailTicketServiceTitle orderDetailTicketServiceTitle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "220099494")) {
            return (View) ipChange.ipc$dispatch("220099494", new Object[]{this, orderDetailTicketServiceTitle});
        }
        if (orderDetailTicketServiceTitle == null) {
            return null;
        }
        View inflate = this.b.inflate(R$layout.order_detail_ticket_item, (ViewGroup) this.a, false);
        TextView textView = (TextView) inflate.findViewById(R$id.tv_service_info);
        ImageView imageView = (ImageView) inflate.findViewById(R$id.icon);
        DMIconFontTextView dMIconFontTextView = (DMIconFontTextView) inflate.findViewById(R$id.iconfont);
        textView.setText(orderDetailTicketServiceTitle.text);
        try {
            if (!TextUtils.isEmpty(orderDetailTicketServiceTitle.fontColor)) {
                textView.setTextColor(Color.parseColor(orderDetailTicketServiceTitle.fontColor));
            }
        } catch (Exception unused) {
            textView.setTextColor(ContextCompat.getColor(this.c, R$color.color_666666));
        }
        cn.damai.common.image.a.b().c(orderDetailTicketServiceTitle.icon).n(new c(this, dMIconFontTextView, imageView)).e(new b(this, dMIconFontTextView, imageView)).f();
        return inflate;
    }

    public void b(List<OrderDetailTicketService> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "708087734")) {
            ipChange.ipc$dispatch("708087734", new Object[]{this, list});
            return;
        }
        int e = wh2.e(list);
        if (e <= 0) {
            return;
        }
        this.a.removeAllViews();
        this.itemView.setTag(list);
        for (int i = 0; i < e; i++) {
            View a2 = a(list.get(i).title);
            if (a2 != null) {
                this.a.addView(a2);
            }
        }
    }
}
