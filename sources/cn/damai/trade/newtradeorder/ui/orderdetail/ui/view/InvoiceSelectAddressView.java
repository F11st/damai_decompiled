package cn.damai.trade.newtradeorder.ui.orderdetail.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.address.bean.AddressBean;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.adapter.InvoiceAddressAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class InvoiceSelectAddressView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<AddressBean> mAddressList;
    private InvoiceAddressAdapter mInvoiceAddressAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    private InvoiceAddressAdapter.OnAddressItemClickListener mOnAddressItemClickListener;
    private OnAddressItemSelectedListener mOnAddressItemSelectedListener;
    private View.OnClickListener mOnConfirmClickListener;
    private RecyclerView mRcvAddressList;
    private AddressBean mSelectedAddress;
    private TextView mTvAddAddress;
    private TextView mTvCancel;
    private TextView mTvConfirm;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface OnAddressItemSelectedListener {
        void onItemSelected(AddressBean addressBean);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.orderdetail.ui.view.InvoiceSelectAddressView$a */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2188a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2188a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1928944654")) {
                ipChange.ipc$dispatch("-1928944654", new Object[]{this, view});
            } else if (InvoiceSelectAddressView.this.mOnAddressItemSelectedListener != null) {
                InvoiceSelectAddressView.this.mOnAddressItemSelectedListener.onItemSelected(InvoiceSelectAddressView.this.mSelectedAddress);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.orderdetail.ui.view.InvoiceSelectAddressView$b */
    /* loaded from: classes8.dex */
    public class C2189b implements InvoiceAddressAdapter.OnAddressItemClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2189b() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.orderdetail.ui.adapter.InvoiceAddressAdapter.OnAddressItemClickListener
        public void onItemClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "436023776")) {
                ipChange.ipc$dispatch("436023776", new Object[]{this, view});
            } else if (view.getTag() == null) {
            } else {
                try {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (intValue < 0 || intValue >= InvoiceSelectAddressView.this.mAddressList.size()) {
                        return;
                    }
                    AddressBean addressBean = (AddressBean) InvoiceSelectAddressView.this.mAddressList.get(intValue);
                    if (InvoiceSelectAddressView.this.mSelectedAddress == null || InvoiceSelectAddressView.this.mSelectedAddress.getAddressId() != addressBean.getAddressId()) {
                        InvoiceSelectAddressView.this.mSelectedAddress = addressBean;
                        InvoiceSelectAddressView.this.mInvoiceAddressAdapter.f(InvoiceSelectAddressView.this.mSelectedAddress);
                        InvoiceSelectAddressView.this.mInvoiceAddressAdapter.notifyDataSetChanged();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public InvoiceSelectAddressView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2053577188")) {
            ipChange.ipc$dispatch("2053577188", new Object[]{this, context});
            return;
        }
        LayoutInflater.from(context).inflate(R$layout.trade_order_create_address_select_layout, this);
        this.mTvCancel = (TextView) findViewById(R$id.trade_order_address_select_cancel_tv);
        this.mTvConfirm = (TextView) findViewById(R$id.trade_order_address_select_confirm_tv);
        this.mTvAddAddress = (TextView) findViewById(R$id.trade_order_add_new_address_tv);
        this.mRcvAddressList = (RecyclerView) findViewById(R$id.trade_order_address_list_rlv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        this.mLinearLayoutManager = linearLayoutManager;
        this.mRcvAddressList.setLayoutManager(linearLayoutManager);
        this.mAddressList = new ArrayList();
        InvoiceAddressAdapter invoiceAddressAdapter = new InvoiceAddressAdapter(getContext(), this.mAddressList);
        this.mInvoiceAddressAdapter = invoiceAddressAdapter;
        invoiceAddressAdapter.e(this.mOnAddressItemClickListener);
        this.mRcvAddressList.setAdapter(this.mInvoiceAddressAdapter);
        initListeners();
        setupListeners();
    }

    private void initListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "629493479")) {
            ipChange.ipc$dispatch("629493479", new Object[]{this});
            return;
        }
        this.mOnConfirmClickListener = new View$OnClickListenerC2188a();
        this.mOnAddressItemClickListener = new C2189b();
    }

    private void setupListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "924549938")) {
            ipChange.ipc$dispatch("924549938", new Object[]{this});
            return;
        }
        this.mTvConfirm.setOnClickListener(this.mOnConfirmClickListener);
        this.mInvoiceAddressAdapter.e(this.mOnAddressItemClickListener);
    }

    public void addOrderAddressList(AddressBean addressBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1509391575")) {
            ipChange.ipc$dispatch("1509391575", new Object[]{this, addressBean});
            return;
        }
        this.mAddressList.add(0, addressBean);
        this.mInvoiceAddressAdapter.notifyDataSetChanged();
    }

    public void setOnAddAddressClickListener(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "398667565")) {
            ipChange.ipc$dispatch("398667565", new Object[]{this, onClickListener});
        } else {
            this.mTvAddAddress.setOnClickListener(onClickListener);
        }
    }

    public void setOnAddressItemSelectedListener(OnAddressItemSelectedListener onAddressItemSelectedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "474484156")) {
            ipChange.ipc$dispatch("474484156", new Object[]{this, onAddressItemSelectedListener});
        } else {
            this.mOnAddressItemSelectedListener = onAddressItemSelectedListener;
        }
    }

    public void setOnCancelClickListener(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-690622106")) {
            ipChange.ipc$dispatch("-690622106", new Object[]{this, onClickListener});
        } else {
            this.mTvCancel.setOnClickListener(onClickListener);
        }
    }

    public void setOrderAddressList(List<AddressBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1802153921")) {
            ipChange.ipc$dispatch("1802153921", new Object[]{this, list});
            return;
        }
        list.clear();
        list.addAll(list);
        this.mInvoiceAddressAdapter.notifyDataSetChanged();
    }

    public void setOrderAddressListAndSelected(List<AddressBean> list, AddressBean addressBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2125812193")) {
            ipChange.ipc$dispatch("-2125812193", new Object[]{this, list, addressBean});
            return;
        }
        this.mSelectedAddress = addressBean;
        this.mInvoiceAddressAdapter.f(addressBean);
        this.mAddressList.clear();
        this.mAddressList.addAll(list);
        this.mInvoiceAddressAdapter.notifyDataSetChanged();
    }

    public void setSelectedOrderAddress(AddressBean addressBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1819539929")) {
            ipChange.ipc$dispatch("1819539929", new Object[]{this, addressBean});
            return;
        }
        this.mInvoiceAddressAdapter.f(addressBean);
        this.mInvoiceAddressAdapter.notifyDataSetChanged();
    }

    public InvoiceSelectAddressView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public InvoiceSelectAddressView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }
}
