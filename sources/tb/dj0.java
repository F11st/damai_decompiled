package tb;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.damai.projectfiltercopy.bean.Type;
import cn.damai.projectfiltercopy.filterbtn.BtnInfoProvider;
import cn.damai.projectfiltercopy.filterbtn.FilterBtn;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.R$string;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class dj0 implements FilterBtn {
    private static transient /* synthetic */ IpChange $ipChange;
    private final Type a;
    private View b;
    private TextView c;
    private TextView d;
    private BtnInfoProvider e;

    public dj0(Context context, Type type, BtnInfoProvider btnInfoProvider) {
        int max;
        this.a = type;
        this.e = btnInfoProvider;
        View inflate = LayoutInflater.from(context).inflate(R$layout.copy_item_filter_btn_view, (ViewGroup) null);
        this.b = inflate;
        this.d = (TextView) inflate.findViewById(R$id.filter_btn_name);
        this.c = (TextView) this.b.findViewById(R$id.filter_btn_arrow);
        if (Type.NEW_CATEGORY == type) {
            this.d.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        }
        if (Type.SORT == type) {
            return;
        }
        int i = DisplayMetrics.getwidthPixels(k62.b(context));
        int a = k62.a(context, 100.0f);
        float leftBtnTotalWidthWeight = btnInfoProvider.getLeftBtnTotalWidthWeight();
        float f = type.widthWeight;
        int a2 = k62.a(context, 35.0f);
        if (leftBtnTotalWidthWeight > 0.0f) {
            max = Math.max(a2, (int) (((i - a) * (f / leftBtnTotalWidthWeight)) - k62.a(context, 22.0f)));
        } else {
            max = Math.max(a2, (int) ((a / 4.0f) - k62.a(context, 22.0f)));
        }
        int min = Math.min(a2, max);
        this.d.setMaxWidth(max);
        this.d.setMinWidth(min);
    }

    @Override // cn.damai.projectfiltercopy.filterbtn.FilterBtn
    public Type getType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1165145925") ? (Type) ipChange.ipc$dispatch("1165145925", new Object[]{this}) : this.a;
    }

    @Override // cn.damai.projectfiltercopy.filterbtn.FilterBtn
    public View getView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1480326498") ? (View) ipChange.ipc$dispatch("1480326498", new Object[]{this}) : this.b;
    }

    @Override // cn.damai.projectfiltercopy.filterbtn.FilterBtn
    public void setState(boolean z) {
        qd btnText;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1790785292")) {
            ipChange.ipc$dispatch("-1790785292", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        BtnInfoProvider btnInfoProvider = this.e;
        if (btnInfoProvider == null || (btnText = btnInfoProvider.getBtnText(this.a)) == null) {
            return;
        }
        this.d.setText(btnText.f());
        boolean z2 = btnText.b;
        int i = z2 ? jh0.C_FF2869 : jh0.C_333333;
        int i2 = z2 ? jh0.C_FF2869 : jh0.C_5F6672;
        this.d.setTextColor(i);
        if (Type.SORT == this.a) {
            this.c.setText(R$string.iconfont_paixu_24);
        } else {
            this.c.setText(z ? R$string.iconfont_shaixuanshang12 : R$string.iconfont_shaixuanxia12);
        }
        this.c.setTextColor(i2);
    }
}
