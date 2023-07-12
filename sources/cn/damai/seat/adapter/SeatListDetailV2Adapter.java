package cn.damai.seat.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.nav.DMNav;
import cn.damai.commonbusiness.discover.viewholder.BaseViewHolder;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.TicketMainUiModel;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.TicketSubUiModel;
import cn.damai.seat.R$drawable;
import cn.damai.seat.R$id;
import cn.damai.seat.R$layout;
import cn.damai.seat.adapter.SeatListDetailV2Adapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.cb2;
import tb.kg1;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class SeatListDetailV2Adapter extends RecyclerView.Adapter<BaseViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int TYPE_MODEL_SUB = 1638;
    public static final int TYPE_MODEL_TITLE = 2184;
    private Context a;
    private List b;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static class ModelSubViewHolder extends BaseViewHolder<TicketSubUiModel> {
        private static transient /* synthetic */ IpChange $ipChange;
        private TextView a;
        private TextView b;
        private TextView c;

        public ModelSubViewHolder(View view) {
            super(view);
            this.c = (TextView) view.findViewById(R$id.model_sub_desc);
            this.a = (TextView) view.findViewById(R$id.model_sub_title);
            this.b = (TextView) view.findViewById(R$id.model_sub_count);
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.BaseViewHolder
        /* renamed from: c */
        public void a(TicketSubUiModel ticketSubUiModel, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1615434763")) {
                ipChange.ipc$dispatch("1615434763", new Object[]{this, ticketSubUiModel, Integer.valueOf(i)});
                return;
            }
            this.a.setText(ticketSubUiModel.skuName);
            this.b.setText("x " + ticketSubUiModel.count);
            this.c.setText(ticketSubUiModel.amountText);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static class ModelTitleViewHolder extends BaseViewHolder<TicketMainUiModel> {
        private static transient /* synthetic */ IpChange $ipChange;
        private final TextView a;
        private final TextView b;
        private final ImageView c;

        public ModelTitleViewHolder(View view) {
            super(view);
            this.b = (TextView) view.findViewById(R$id.model_title);
            this.a = (TextView) view.findViewById(R$id.model_desc);
            this.c = (ImageView) view.findViewById(R$id.iv_icon);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(TicketMainUiModel ticketMainUiModel, View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "589500466")) {
                ipChange.ipc$dispatch("589500466", new Object[]{this, ticketMainUiModel, view});
            } else {
                DMNav.from(this.b.getContext()).toUri(ticketMainUiModel.iconJumpURL);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(TicketMainUiModel ticketMainUiModel, View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-219986991")) {
                ipChange.ipc$dispatch("-219986991", new Object[]{this, ticketMainUiModel, view});
            } else {
                DMNav.from(this.b.getContext()).toUri(ticketMainUiModel.iconJumpURL);
            }
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.BaseViewHolder
        /* renamed from: e */
        public void a(final TicketMainUiModel ticketMainUiModel, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1954163916")) {
                ipChange.ipc$dispatch("-1954163916", new Object[]{this, ticketMainUiModel, Integer.valueOf(i)});
                return;
            }
            this.b.setText(ticketMainUiModel.moduleTitle);
            if (!ticketMainUiModel.isTicketPriceModel() && !ticketMainUiModel.moduleType.equals("5")) {
                this.a.setTextColor(Color.parseColor("#FF2869"));
            } else {
                this.a.setTextColor(-16777216);
            }
            if (!TextUtils.isEmpty(ticketMainUiModel.moduleIconURL)) {
                this.c.setVisibility(0);
                kg1.q(this.c.getContext()).j(ticketMainUiModel.moduleIconURL).e(R$drawable.commonbusiness_help_icon).g(this.c);
            } else {
                this.c.setVisibility(8);
            }
            if (!TextUtils.isEmpty(ticketMainUiModel.iconJumpURL)) {
                this.b.setOnClickListener(new View.OnClickListener() { // from class: tb.i92
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SeatListDetailV2Adapter.ModelTitleViewHolder.this.f(ticketMainUiModel, view);
                    }
                });
                this.c.setOnClickListener(new View.OnClickListener() { // from class: tb.j92
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SeatListDetailV2Adapter.ModelTitleViewHolder.this.g(ticketMainUiModel, view);
                    }
                });
            }
            this.a.setText(ticketMainUiModel.moduleTotalAmtText);
        }
    }

    public SeatListDetailV2Adapter(Context context) {
        this.a = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1656974423")) {
            ipChange.ipc$dispatch("1656974423", new Object[]{this, baseViewHolder, Integer.valueOf(i)});
        } else {
            baseViewHolder.a(this.b.get(i), i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: b */
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "689181567")) {
            return (BaseViewHolder) ipChange.ipc$dispatch("689181567", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        if (i == 2184) {
            return new ModelTitleViewHolder(LayoutInflater.from(this.a).inflate(R$layout.item_seat_model_title, viewGroup, false));
        }
        return new ModelSubViewHolder(LayoutInflater.from(this.a).inflate(R$layout.item_seat_model_sub, viewGroup, false));
    }

    public void c(List<TicketMainUiModel> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-702999339")) {
            ipChange.ipc$dispatch("-702999339", new Object[]{this, list});
            return;
        }
        if (cb2.d(list)) {
            this.b = null;
        } else {
            this.b = new ArrayList();
            for (TicketMainUiModel ticketMainUiModel : list) {
                this.b.add(ticketMainUiModel);
                if (!cb2.d(ticketMainUiModel.moduleDetailVOList)) {
                    this.b.addAll(ticketMainUiModel.moduleDetailVOList);
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-896764294")) {
            return ((Integer) ipChange.ipc$dispatch("-896764294", new Object[]{this})).intValue();
        }
        List list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1815454753")) {
            return ((Integer) ipChange.ipc$dispatch("1815454753", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        Object obj = this.b.get(i);
        return obj instanceof TicketMainUiModel ? TYPE_MODEL_TITLE : obj instanceof TicketSubUiModel ? TYPE_MODEL_SUB : super.getItemViewType(i);
    }
}
