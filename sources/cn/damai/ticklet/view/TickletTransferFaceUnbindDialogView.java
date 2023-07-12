package cn.damai.ticklet.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.member.R$color;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.ticklet.bean.TickletTransferManagerListExtra;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TickletTransferFaceUnbindDialogView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context context;
    private LinearLayoutManager mLinearLayoutManager;
    private RecyclerView mRecyclerViewTransfer;
    private TransferTicketFaceUnbindAdapter mTransferTicketFaceUnbindAdapter;
    private View partent;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static class TransferTicketFaceUnbindAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private static transient /* synthetic */ IpChange $ipChange;
        private Context a;
        private List<TickletTransferManagerListExtra> b;

        public TransferTicketFaceUnbindAdapter(Context context) {
            this.a = context;
        }

        private void a(TextView textView, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1122509006")) {
                ipChange.ipc$dispatch("1122509006", new Object[]{this, textView, str});
            } else if (!TextUtils.isEmpty(str)) {
                textView.setVisibility(0);
                textView.setText(str);
            } else {
                textView.setVisibility(8);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2016611274")) {
                return ((Integer) ipChange.ipc$dispatch("-2016611274", new Object[]{this})).intValue();
            }
            List<TickletTransferManagerListExtra> list = this.b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-213641469")) {
                ipChange.ipc$dispatch("-213641469", new Object[]{this, viewHolder, Integer.valueOf(i)});
                return;
            }
            a aVar = (a) viewHolder;
            TickletTransferManagerListExtra tickletTransferManagerListExtra = this.b.get(i);
            if (i == 0) {
                TextView textView = aVar.a;
                textView.setPadding(textView.getPaddingLeft(), t60.a(this.a, 18.0f), aVar.a.getPaddingLeft(), aVar.a.getPaddingBottom());
            } else {
                TextView textView2 = aVar.a;
                textView2.setPadding(textView2.getPaddingLeft(), 0, aVar.a.getPaddingLeft(), aVar.a.getPaddingBottom());
            }
            if (tickletTransferManagerListExtra != null) {
                a(aVar.a, tickletTransferManagerListExtra.fullSeatInfo);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1635402157") ? (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-1635402157", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new a(LayoutInflater.from(this.a).inflate(R$layout.ticklet_transfer_face_unbind_ticket_item_layout, viewGroup, false));
        }

        public void setData(List<TickletTransferManagerListExtra> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2089953702")) {
                ipChange.ipc$dispatch("2089953702", new Object[]{this, list});
                return;
            }
            this.b = list;
            notifyDataSetChanged();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    private static class a extends RecyclerView.ViewHolder {
        public TextView a;

        public a(View view) {
            super(view);
            this.a = (TextView) view.findViewById(R$id.ticklet_transfer_ticket_item_seat_info_tv);
            TextView textView = (TextView) view.findViewById(R$id.ticklet_transfer_ticket_item_cert_num_tv);
        }
    }

    public TickletTransferFaceUnbindDialogView(Context context) {
        this(context, null);
    }

    private void initRecyclerView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1898237620")) {
            ipChange.ipc$dispatch("1898237620", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.context).inflate(R$layout.ticklet_transfer_face_unbind_dialog_layout, this);
        this.partent = inflate;
        this.mRecyclerViewTransfer = (RecyclerView) inflate.findViewById(R$id.ticklet_transfer_face_unbind_recycler_view);
        TransferTicketFaceUnbindAdapter transferTicketFaceUnbindAdapter = new TransferTicketFaceUnbindAdapter(getContext());
        this.mTransferTicketFaceUnbindAdapter = transferTicketFaceUnbindAdapter;
        this.mRecyclerViewTransfer.setAdapter(transferTicketFaceUnbindAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.mLinearLayoutManager = linearLayoutManager;
        linearLayoutManager.setOrientation(1);
        this.mRecyclerViewTransfer.setLayoutManager(this.mLinearLayoutManager);
    }

    public void setData(List<TickletTransferManagerListExtra> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2085013479")) {
            ipChange.ipc$dispatch("2085013479", new Object[]{this, list});
        } else {
            this.mTransferTicketFaceUnbindAdapter.setData(list);
        }
    }

    public TickletTransferFaceUnbindDialogView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TickletTransferFaceUnbindDialogView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        setOrientation(1);
        setBackgroundResource(R$color.white);
        initRecyclerView();
    }
}
