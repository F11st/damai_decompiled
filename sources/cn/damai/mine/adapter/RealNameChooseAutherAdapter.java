package cn.damai.mine.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.R$string;
import cn.damai.mine.bean.RealNameCustomerBean;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class RealNameChooseAutherAdapter extends RecyclerView.Adapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<RealNameCustomerBean> b;
    private RealNameCustomerBean c;
    private OnCustomerItemClickListener d;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static class CustomerItemViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        public DMIconFontTextView a;
        public TextView b;
        public TextView c;

        public CustomerItemViewHolder(View view) {
            super(view);
            a(view);
        }

        private void a(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1533360584")) {
                ipChange.ipc$dispatch("1533360584", new Object[]{this, view});
                return;
            }
            this.a = (DMIconFontTextView) view.findViewById(R$id.customer_select_indicator_iv);
            this.b = (TextView) view.findViewById(R$id.customer_name);
            this.c = (TextView) view.findViewById(R$id.customer_idcard_num);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface OnCustomerItemClickListener {
        void onItemClick(RealNameCustomerBean realNameCustomerBean);
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ RealNameCustomerBean a;

        a(RealNameCustomerBean realNameCustomerBean) {
            this.a = realNameCustomerBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1978385556")) {
                ipChange.ipc$dispatch("1978385556", new Object[]{this, view});
            } else if (RealNameChooseAutherAdapter.this.d != null) {
                RealNameChooseAutherAdapter.this.d.onItemClick(this.a);
            }
        }
    }

    public RealNameChooseAutherAdapter(Context context, List<RealNameCustomerBean> list) {
        this.a = context;
        this.b = list;
    }

    private void b(CustomerItemViewHolder customerItemViewHolder, RealNameCustomerBean realNameCustomerBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "161989085")) {
            ipChange.ipc$dispatch("161989085", new Object[]{this, customerItemViewHolder, realNameCustomerBean});
            return;
        }
        RealNameCustomerBean realNameCustomerBean2 = this.c;
        if (realNameCustomerBean2 != null) {
            if (realNameCustomerBean2.getIdentityNo().equals(realNameCustomerBean.getIdentityNo())) {
                customerItemViewHolder.a.setSelected(true);
                customerItemViewHolder.a.setText(R$string.iconfont_danxuanxuanzhong24);
            } else {
                customerItemViewHolder.a.setSelected(false);
                customerItemViewHolder.a.setText(R$string.iconfont_danxuanweixuanzhong24);
            }
        } else {
            customerItemViewHolder.a.setSelected(false);
            customerItemViewHolder.a.setText(R$string.iconfont_danxuanweixuanzhong24);
        }
        String name = realNameCustomerBean.getName();
        String maskedIdentityNo = realNameCustomerBean.getMaskedIdentityNo();
        if (!wh2.j(name)) {
            customerItemViewHolder.b.setText(name);
        }
        if (!wh2.j(maskedIdentityNo)) {
            TextView textView = customerItemViewHolder.c;
            textView.setText(realNameCustomerBean.getIdentityTypeName() + AltriaXLaunchTime.SPACE + maskedIdentityNo);
        }
        customerItemViewHolder.itemView.setOnClickListener(new a(realNameCustomerBean));
    }

    public void c(OnCustomerItemClickListener onCustomerItemClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-177200524")) {
            ipChange.ipc$dispatch("-177200524", new Object[]{this, onCustomerItemClickListener});
        } else {
            this.d = onCustomerItemClickListener;
        }
    }

    public void d(RealNameCustomerBean realNameCustomerBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1295727795")) {
            ipChange.ipc$dispatch("-1295727795", new Object[]{this, realNameCustomerBean});
        } else {
            this.c = realNameCustomerBean;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-838521277")) {
            return ((Integer) ipChange.ipc$dispatch("-838521277", new Object[]{this})).intValue();
        }
        List<RealNameCustomerBean> list = this.b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1806634794")) {
            ipChange.ipc$dispatch("-1806634794", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        RealNameCustomerBean realNameCustomerBean = this.b.get(i);
        if (realNameCustomerBean == null) {
            return;
        }
        b((CustomerItemViewHolder) viewHolder, realNameCustomerBean);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1064400928") ? (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-1064400928", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new CustomerItemViewHolder(LayoutInflater.from(this.a).inflate(R$layout.customer_select_item, viewGroup, false));
    }
}
