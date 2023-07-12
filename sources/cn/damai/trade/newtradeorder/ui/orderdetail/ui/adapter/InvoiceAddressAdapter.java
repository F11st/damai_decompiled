package cn.damai.trade.newtradeorder.ui.orderdetail.ui.adapter;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.address.bean.AddressBean;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import tb.d41;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class InvoiceAddressAdapter extends RecyclerView.Adapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<AddressBean> b;
    private AddressBean c;
    private OnAddressItemClickListener d;
    private int e;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class AddressItemViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        public ImageView a;
        public TextView b;
        public TextView c;
        public View d;

        public AddressItemViewHolder(View view) {
            super(view);
            a(view);
        }

        private void a(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1531393756")) {
                ipChange.ipc$dispatch("1531393756", new Object[]{this, view});
                return;
            }
            this.a = (ImageView) view.findViewById(R$id.order_address_select_indicator_iv);
            this.b = (TextView) view.findViewById(R$id.order_address_receiver_name_phone_num_tv);
            this.c = (TextView) view.findViewById(R$id.order_address_detail_tv);
            this.d = view.findViewById(R$id.order_address_item_divider);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface OnAddressItemClickListener {
        void onItemClick(View view);
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "440781857")) {
                ipChange.ipc$dispatch("440781857", new Object[]{this, view});
            } else if (InvoiceAddressAdapter.this.d != null) {
                InvoiceAddressAdapter.this.d.onItemClick(view);
            }
        }
    }

    public InvoiceAddressAdapter(Context context, List<AddressBean> list) {
        this.a = context;
        this.b = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AddressItemViewHolder addressItemViewHolder, AddressBean addressBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1149129010")) {
            ipChange.ipc$dispatch("-1149129010", new Object[]{this, addressItemViewHolder, addressBean, Integer.valueOf(i)});
            return;
        }
        AddressBean addressBean2 = this.c;
        if (addressBean2 != null && addressBean2.getAddressId() == addressBean.getAddressId()) {
            addressItemViewHolder.a.setSelected(true);
        } else {
            addressItemViewHolder.a.setSelected(false);
        }
        String consigneeName = addressBean.getConsigneeName();
        String mobile = addressBean.getMobile();
        if (wh2.j(consigneeName)) {
            consigneeName = "";
        }
        if (wh2.j(mobile)) {
            mobile = "";
        }
        TextPaint paint = addressItemViewHolder.b.getPaint();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (((int) paint.measureText(new SpannableStringBuilder().append((CharSequence) " ").append((CharSequence) " ").append((CharSequence) mobile).toString())) + (((int) paint.measureText(consigneeName)) % this.e) > this.e) {
            spannableStringBuilder.append((CharSequence) consigneeName).append((CharSequence) StringUtils.LF).append((CharSequence) mobile);
        } else {
            spannableStringBuilder.append((CharSequence) consigneeName).append((CharSequence) " ").append((CharSequence) " ").append((CharSequence) mobile);
        }
        if (!wh2.j(spannableStringBuilder.toString())) {
            addressItemViewHolder.b.setText(spannableStringBuilder.toString());
        } else {
            addressItemViewHolder.b.setText("");
        }
        String a2 = d41.a(addressBean);
        if (!wh2.j(a2)) {
            addressItemViewHolder.c.setText(a2);
        } else {
            addressItemViewHolder.c.setText(a2);
        }
        if (i == getItemCount() - 1) {
            addressItemViewHolder.d.setVisibility(8);
        } else {
            addressItemViewHolder.d.setVisibility(0);
        }
        addressItemViewHolder.itemView.setTag(Integer.valueOf(i));
        addressItemViewHolder.itemView.setOnClickListener(new a());
    }

    public void e(OnAddressItemClickListener onAddressItemClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1979856988")) {
            ipChange.ipc$dispatch("-1979856988", new Object[]{this, onAddressItemClickListener});
        } else {
            this.d = onAddressItemClickListener;
        }
    }

    public void f(AddressBean addressBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1482146927")) {
            ipChange.ipc$dispatch("-1482146927", new Object[]{this, addressBean});
        } else {
            this.c = addressBean;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-70774321") ? ((Integer) ipChange.ipc$dispatch("-70774321", new Object[]{this})).intValue() : wh2.e(this.b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "213345738")) {
            ipChange.ipc$dispatch("213345738", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        final AddressBean addressBean = this.b.get(i);
        if (addressBean == null) {
            return;
        }
        final AddressItemViewHolder addressItemViewHolder = (AddressItemViewHolder) viewHolder;
        if (this.e <= 0) {
            addressItemViewHolder.b.post(new Runnable() { // from class: cn.damai.trade.newtradeorder.ui.orderdetail.ui.adapter.InvoiceAddressAdapter.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1248958352")) {
                        ipChange2.ipc$dispatch("1248958352", new Object[]{this});
                        return;
                    }
                    InvoiceAddressAdapter.this.e = (addressItemViewHolder.b.getWidth() - addressItemViewHolder.b.getPaddingLeft()) - addressItemViewHolder.b.getPaddingRight();
                    InvoiceAddressAdapter.this.d(addressItemViewHolder, addressBean, i);
                }
            });
        } else {
            d(addressItemViewHolder, addressBean, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1548366484") ? (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-1548366484", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new AddressItemViewHolder(LayoutInflater.from(this.a).inflate(R$layout.trade_order_create_address_select_item, viewGroup, false));
    }
}
