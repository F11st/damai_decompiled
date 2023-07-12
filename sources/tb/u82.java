package tb;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.damai.common.util.ToastUtil;
import cn.damai.seat.R$id;
import cn.damai.seat.R$string;
import cn.damai.seat.bean.PriceBarInfo;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public abstract class u82 implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private View a;
    private TextView b;
    private View c;
    private View d;
    private View e;
    private TextView f;
    private DMIconFontTextView g;
    private TextView h;
    private ViewGroup i;
    private TextView j;

    public u82(Activity activity, View view) {
        this.a = view;
        this.c = view.findViewById(R$id.layout_seat_price_and_num);
        this.e = this.a.findViewById(R$id.layout_seat_total_price);
        this.h = (TextView) this.a.findViewById(R$id.total_price);
        this.g = (DMIconFontTextView) this.a.findViewById(R$id.choose_arrow_ift);
        this.f = (TextView) this.a.findViewById(R$id.order_promotion_tv);
        this.d = this.a.findViewById(R$id.empty_seat_layout);
        this.b = (TextView) this.a.findViewById(R$id.seat_confirm_order);
        this.i = (ViewGroup) this.a.findViewById(R$id.layout_seat_num);
        this.j = (TextView) this.a.findViewById(R$id.tv_select_seat_num);
        this.a.setOnClickListener(this);
    }

    @Deprecated
    public void a(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-597834356")) {
            ipChange.ipc$dispatch("-597834356", new Object[]{this, Boolean.valueOf(z)});
        }
    }

    public abstract void b();

    public abstract void c();

    public void d(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-156410288")) {
            ipChange.ipc$dispatch("-156410288", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.g.setText(!z ? R$string.iconfont_shaixuanxia12 : R$string.iconfont_shaixuanshang12);
        }
    }

    public void e(PriceBarInfo priceBarInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-800233135")) {
            ipChange.ipc$dispatch("-800233135", new Object[]{this, priceBarInfo});
        } else if (priceBarInfo == null) {
        } else {
            if (!TextUtils.isEmpty(priceBarInfo.toastMsg)) {
                ToastUtil.i(priceBarInfo.toastMsg);
            }
            if (priceBarInfo.isPayFirstV2) {
                this.c.setVisibility(8);
                this.i.setVisibility(0);
                this.j.setText(priceBarInfo.tipSpanV2);
                this.b.setAlpha(priceBarInfo.clickableV2 ? 1.0f : 0.6f);
                this.b.setOnClickListener(priceBarInfo.clickableV2 ? this : null);
                return;
            }
            this.c.setVisibility(0);
            this.i.setVisibility(8);
            boolean z = priceBarInfo.clickableV2;
            this.d.setVisibility(z ? 8 : 0);
            this.e.setVisibility(z ? 0 : 8);
            if (z) {
                r92.g(this.f, priceBarInfo.tipMsgV2);
                String str = priceBarInfo.totalPriceTextV2;
                if (!TextUtils.isEmpty(str)) {
                    str = str.replaceAll("¥", "");
                }
                this.h.setText(str);
            }
            this.b.setAlpha(z ? 1.0f : 0.5f);
            this.b.setOnClickListener(z ? this : null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-344174680")) {
            ipChange.ipc$dispatch("-344174680", new Object[]{this, view});
            return;
        }
        int id = view.getId();
        if (r92.c()) {
            return;
        }
        if (id == R$id.seat_confirm_order) {
            b();
        } else if (id == R$id.seat_jpg_bottom_bar) {
            c();
        }
    }
}
