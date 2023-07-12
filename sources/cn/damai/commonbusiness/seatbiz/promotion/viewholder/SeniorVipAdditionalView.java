package cn.damai.commonbusiness.seatbiz.promotion.viewholder;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class SeniorVipAdditionalView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private TextView mDiscount;
    @NotNull
    private TextView mDiscountDes;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SeniorVipAdditionalView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SeniorVipAdditionalView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    public /* synthetic */ SeniorVipAdditionalView(Context context, AttributeSet attributeSet, int i, int i2, k50 k50Var) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void setData(@Nullable Integer num, @Nullable Integer num2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1183915112")) {
            ipChange.ipc$dispatch("-1183915112", new Object[]{this, num, num2});
            return;
        }
        setVisibility(num == null ? 8 : 0);
        this.mDiscountDes.setVisibility(num2 == null ? 8 : 0);
        String str = "积分" + num + (char) 25240;
        String str2 = "本次将为您省" + num2 + "积分";
        if (num != null) {
            this.mDiscount.setText(str);
        }
        if (num2 != null) {
            this.mDiscountDes.setText(str2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SeniorVipAdditionalView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        LayoutInflater.from(context).inflate(R$layout.senior_vip_addition_view, this);
        View findViewById = findViewById(R$id.tv_discount);
        b41.h(findViewById, "findViewById(R.id.tv_discount)");
        this.mDiscount = (TextView) findViewById;
        View findViewById2 = findViewById(R$id.tv_discount_des);
        b41.h(findViewById2, "findViewById(R.id.tv_discount_des)");
        this.mDiscountDes = (TextView) findViewById2;
    }
}
