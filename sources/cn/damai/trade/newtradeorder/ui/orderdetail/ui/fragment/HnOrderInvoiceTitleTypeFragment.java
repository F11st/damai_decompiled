package cn.damai.trade.newtradeorder.ui.orderdetail.ui.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.trade.R$color;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.hn.HnInvoiceTitleType;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class HnOrderInvoiceTitleTypeFragment extends DamaiBaseMvpFragment {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnConfirmInvoiceTitleListener mConfirmInvoiceTypeListener;
    private Context mContext;
    private List<HnInvoiceTitleType> mInvoiceTitleTypeList;
    private LinearLayout mInvoiceTitleViewContainer;
    private View$OnClickListenerC2187a mOnInvoiceItemClickListener;
    private HnInvoiceTitleType mSelectedHnInvoiceTitleType;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface OnConfirmInvoiceTitleListener {
        void onConfirmInvoiceTitle(HnInvoiceTitleType hnInvoiceTitleType);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.orderdetail.ui.fragment.HnOrderInvoiceTitleTypeFragment$a */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2187a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        public View$OnClickListenerC2187a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1255375380")) {
                ipChange.ipc$dispatch("-1255375380", new Object[]{this, view});
            } else if (view.getTag() != null && (view.getTag() instanceof HnInvoiceTitleType)) {
                int childCount = HnOrderInvoiceTitleTypeFragment.this.mInvoiceTitleViewContainer.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = HnOrderInvoiceTitleTypeFragment.this.mInvoiceTitleViewContainer.getChildAt(i);
                    if (childAt == view) {
                        HnOrderInvoiceTitleTypeFragment.this.setInvoiceTitleTypeSelected(childAt, (HnInvoiceTitleType) view.getTag());
                    } else {
                        HnOrderInvoiceTitleTypeFragment.this.setInvoiceTitleTypeUnSelected(childAt);
                    }
                }
            }
        }
    }

    private void addInvoiceTitleView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "876982789")) {
            ipChange.ipc$dispatch("876982789", new Object[]{this, context});
            return;
        }
        List<HnInvoiceTitleType> list = this.mInvoiceTitleTypeList;
        if (list == null || list.isEmpty() || this.mInvoiceTitleViewContainer == null) {
            return;
        }
        LayoutInflater from = LayoutInflater.from(context);
        this.mOnInvoiceItemClickListener = new View$OnClickListenerC2187a();
        int size = this.mInvoiceTitleTypeList.size();
        for (int i = 0; i < size; i++) {
            HnInvoiceTitleType hnInvoiceTitleType = this.mInvoiceTitleTypeList.get(i);
            View inflate = from.inflate(R$layout.hn_order_invoice_title_item, (ViewGroup) null);
            ((TextView) inflate.findViewById(R$id.tv_text)).setText(hnInvoiceTitleType.invoiceTitleTypeStr);
            inflate.setTag(hnInvoiceTitleType);
            inflate.setOnClickListener(this.mOnInvoiceItemClickListener);
            if ("2".equals(hnInvoiceTitleType.invoiceTitleType)) {
                setInvoiceTitleTypeSelected(inflate, hnInvoiceTitleType);
            }
            this.mInvoiceTitleViewContainer.addView(inflate);
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected int getLayoutResource() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1385024871") ? ((Integer) ipChange.ipc$dispatch("-1385024871", new Object[]{this})).intValue() : R$layout.fragment_hn_invoice_title;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1251836081")) {
            ipChange.ipc$dispatch("-1251836081", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1218648252")) {
            ipChange.ipc$dispatch("1218648252", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1937598561")) {
            ipChange.ipc$dispatch("1937598561", new Object[]{this});
            return;
        }
        this.mInvoiceTitleViewContainer = (LinearLayout) this.rootView.findViewById(R$id.layout_invoice_title);
        ((TextView) this.rootView.findViewById(R$id.confirm_button)).setOnClickListener(this);
        addInvoiceTitleView(this.mContext);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "281857846")) {
            ipChange.ipc$dispatch("281857846", new Object[]{this, context});
            return;
        }
        super.onAttach(context);
        this.mContext = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        OnConfirmInvoiceTitleListener onConfirmInvoiceTitleListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1299342329")) {
            ipChange.ipc$dispatch("-1299342329", new Object[]{this, view});
        } else if (view.getId() != R$id.confirm_button || (onConfirmInvoiceTitleListener = this.mConfirmInvoiceTypeListener) == null) {
        } else {
            onConfirmInvoiceTitleListener.onConfirmInvoiceTitle(this.mSelectedHnInvoiceTitleType);
        }
    }

    public void setInvoiceTitleTypeData(List<HnInvoiceTitleType> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1046389748")) {
            ipChange.ipc$dispatch("1046389748", new Object[]{this, list});
        } else {
            this.mInvoiceTitleTypeList = list;
        }
    }

    public void setInvoiceTitleTypeSelected(View view, HnInvoiceTitleType hnInvoiceTitleType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1012128710")) {
            ipChange.ipc$dispatch("-1012128710", new Object[]{this, view, hnInvoiceTitleType});
            return;
        }
        this.mSelectedHnInvoiceTitleType = hnInvoiceTitleType;
        ((DMIconFontTextView) view.findViewById(R$id.ic_selection)).setTextColor(ContextCompat.getColor(this.mContext, R$color.main_color));
    }

    public void setInvoiceTitleTypeUnSelected(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-91592167")) {
            ipChange.ipc$dispatch("-91592167", new Object[]{this, view});
        } else {
            ((DMIconFontTextView) view.findViewById(R$id.ic_selection)).setTextColor(ContextCompat.getColor(this.mContext, R$color.color_E0E0E0));
        }
    }

    public void setOnConfirmInvoiceTitleListener(OnConfirmInvoiceTitleListener onConfirmInvoiceTitleListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1197806964")) {
            ipChange.ipc$dispatch("1197806964", new Object[]{this, onConfirmInvoiceTitleListener});
        } else {
            this.mConfirmInvoiceTypeListener = onConfirmInvoiceTitleListener;
        }
    }
}
