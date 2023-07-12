package cn.damai.ultron.custom.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.common.user.C0529c;
import cn.damai.ultron.R$id;
import cn.damai.ultron.R$layout;
import cn.damai.ultron.utils.DmUltronConstants;
import cn.damai.ultron.view.bean.DmPayTypeBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;
import tb.kb0;
import tb.ua0;
import tb.va0;
import tb.wh2;
import tb.xr;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class PayTypeView extends LinearLayout implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private int defaultShowNum;
    private va0 dmPayTypeComponent;
    private Boolean isAllShow;
    private LinearLayout ll_pay_info;
    private LinearLayout ll_pay_type;
    private LinearLayout ll_show_all;
    private Context mContext;
    private View partent;
    private PayTypeItemView selectView;
    private TextView tv_pay_info;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.ultron.custom.view.PayTypeView$a */
    /* loaded from: classes17.dex */
    public class View$OnClickListenerC2622a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DmPayTypeBean a;
        final /* synthetic */ PayTypeItemView b;
        final /* synthetic */ int c;

        View$OnClickListenerC2622a(DmPayTypeBean dmPayTypeBean, PayTypeItemView payTypeItemView, int i) {
            this.a = dmPayTypeBean;
            this.b = payTypeItemView;
            this.c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1500589078")) {
                ipChange.ipc$dispatch("1500589078", new Object[]{this, view});
            } else if (this.a.isSelect()) {
            } else {
                if (PayTypeView.this.selectView != null) {
                    PayTypeView.this.selectView.setChecked(Boolean.FALSE, false);
                }
                this.b.setChecked(Boolean.TRUE, true);
                PayTypeView.this.selectView = this.b;
                xr.c(DmUltronConstants.REFRESH_PAYTYPE_COMPONENT_DATA, PayTypeView.this.dmPayTypeComponent.a());
                try {
                    C0529c.e().x(kb0.u().z(this.c, String.valueOf(ua0.b(PayTypeView.this.mContext)), this.a.name));
                } catch (Exception unused) {
                }
            }
        }
    }

    public PayTypeView(Context context) {
        this(context, null);
    }

    private void initData(List<DmPayTypeBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1539670545")) {
            ipChange.ipc$dispatch("-1539670545", new Object[]{this, list});
        } else if (wh2.e(list) > 0) {
            this.ll_pay_type.removeAllViews();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == null) {
                    return;
                }
                DmPayTypeBean dmPayTypeBean = list.get(i);
                PayTypeItemView payTypeItemView = new PayTypeItemView(this.mContext);
                payTypeItemView.setDmPayTypeComponent(this.dmPayTypeComponent);
                payTypeItemView.setData(dmPayTypeBean);
                if (dmPayTypeBean.isSelect()) {
                    PayTypeItemView payTypeItemView2 = this.selectView;
                    if (payTypeItemView2 != null) {
                        payTypeItemView2.setChecked(Boolean.FALSE, false);
                    }
                    this.selectView = payTypeItemView;
                    payTypeItemView.setChecked(Boolean.TRUE, false);
                }
                payTypeItemView.setOnClickListener(new View$OnClickListenerC2622a(dmPayTypeBean, payTypeItemView, i));
                if (!this.isAllShow.booleanValue() && i >= this.defaultShowNum) {
                    payTypeItemView.setVisibility(8);
                }
                this.ll_pay_type.addView(payTypeItemView);
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("item_id", ua0.b(getContext()) + "");
                    hashMap.put("titlelabel", dmPayTypeBean.name);
                    hashMap.put("discount_name", dmPayTypeBean.promotionDesc);
                    C0529c e = C0529c.e();
                    e.G(payTypeItemView, "pay_type_" + i, "pay", "confirm", hashMap);
                } catch (Exception unused) {
                }
            }
            if (this.isAllShow.booleanValue() || list.size() <= this.defaultShowNum) {
                this.isAllShow = Boolean.TRUE;
                this.ll_show_all.setVisibility(8);
            }
        }
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-425247709")) {
            ipChange.ipc$dispatch("-425247709", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(R$layout.ultron_pay_type_item, this);
        this.partent = inflate;
        this.ll_pay_info = (LinearLayout) inflate.findViewById(R$id.ll_pay_info);
        this.ll_pay_type = (LinearLayout) this.partent.findViewById(R$id.ll_pay_type);
        this.ll_show_all = (LinearLayout) this.partent.findViewById(R$id.ll_show_all);
        this.tv_pay_info = (TextView) this.partent.findViewById(R$id.tv_pay_info);
        this.ll_show_all.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1462158153")) {
            ipChange.ipc$dispatch("1462158153", new Object[]{this, view});
        } else if (view == this.ll_show_all) {
            for (int i = 0; i < this.ll_pay_type.getChildCount(); i++) {
                this.ll_pay_type.getChildAt(i).setVisibility(0);
            }
            this.ll_show_all.setVisibility(8);
            this.isAllShow = Boolean.TRUE;
            try {
                C0529c.e().x(kb0.u().y(this.mContext));
            } catch (Exception unused) {
            }
        }
    }

    public void setDmPayTypeComponent(va0 va0Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1956608309")) {
            ipChange.ipc$dispatch("1956608309", new Object[]{this, va0Var});
            return;
        }
        this.dmPayTypeComponent = va0Var;
        if (va0Var != null) {
            if (wh2.e(va0Var.c()) == 0) {
                this.ll_pay_info.setVisibility(8);
                return;
            }
            this.ll_pay_info.setVisibility(0);
            initData(va0Var.c());
            this.tv_pay_info.setText(va0Var.b());
        }
    }

    public PayTypeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PayTypeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.defaultShowNum = 2;
        this.selectView = null;
        this.isAllShow = Boolean.FALSE;
        this.mContext = context;
        initView();
    }
}
