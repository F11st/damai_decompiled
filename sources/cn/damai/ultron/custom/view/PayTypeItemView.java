package cn.damai.ultron.custom.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.common.image.a;
import cn.damai.ultron.R$id;
import cn.damai.ultron.R$layout;
import cn.damai.ultron.view.bean.DmPayTypeBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.va0;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class PayTypeItemView extends RelativeLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private CheckBox cb_pay_check;
    String code;
    private va0 dmPayTypeComponent;
    private ImageView iv_pay;
    private Context mContext;
    private View partent;
    private RelativeLayout rl_pay;
    private TextView textPromotion;
    private TextView tv_pay_title;

    public PayTypeItemView(Context context) {
        this(context, null);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2017079190")) {
            ipChange.ipc$dispatch("2017079190", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(R$layout.ultron_pay_typeview, this);
        this.partent = inflate;
        this.rl_pay = (RelativeLayout) inflate.findViewById(R$id.rl_pay);
        this.iv_pay = (ImageView) this.partent.findViewById(R$id.iv_pay);
        this.tv_pay_title = (TextView) this.partent.findViewById(R$id.tv_pay_title);
        this.textPromotion = (TextView) this.partent.findViewById(R$id.text_promotion);
        CheckBox checkBox = (CheckBox) this.partent.findViewById(R$id.cb_pay_check);
        this.cb_pay_check = checkBox;
        checkBox.setEnabled(false);
        this.cb_pay_check.setFocusable(false);
    }

    public void setChecked(Boolean bool, boolean z) {
        va0 va0Var;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "549480749")) {
            ipChange.ipc$dispatch("549480749", new Object[]{this, bool, Boolean.valueOf(z)});
            return;
        }
        this.cb_pay_check.setChecked(bool.booleanValue());
        if (bool.booleanValue() && z && (va0Var = this.dmPayTypeComponent) != null) {
            List<DmPayTypeBean> c = va0Var.c();
            int e = wh2.e(c);
            for (int i = 0; i < e; i++) {
                DmPayTypeBean dmPayTypeBean = c.get(i);
                if (dmPayTypeBean.code.equals(this.code)) {
                    dmPayTypeBean.isUsed = "true";
                } else {
                    dmPayTypeBean.isUsed = "false";
                }
            }
            this.dmPayTypeComponent.d(c);
        }
    }

    public void setData(DmPayTypeBean dmPayTypeBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "324100218")) {
            ipChange.ipc$dispatch("324100218", new Object[]{this, dmPayTypeBean});
        } else if (dmPayTypeBean == null) {
        } else {
            this.code = dmPayTypeBean.code;
            a.b().c(dmPayTypeBean.icon).g(this.iv_pay);
            this.tv_pay_title.setText(dmPayTypeBean.name);
            if (!TextUtils.isEmpty(dmPayTypeBean.promotionDesc)) {
                this.textPromotion.setVisibility(0);
                this.textPromotion.setText(dmPayTypeBean.promotionDesc);
                return;
            }
            this.textPromotion.setVisibility(8);
        }
    }

    public void setDmPayTypeComponent(va0 va0Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "572347560")) {
            ipChange.ipc$dispatch("572347560", new Object[]{this, va0Var});
        } else {
            this.dmPayTypeComponent = va0Var;
        }
    }

    public PayTypeItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PayTypeItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.code = "";
        this.mContext = context;
        initView();
    }
}
