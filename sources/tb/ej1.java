package tb;

import android.view.View;
import android.widget.LinearLayout;
import cn.damai.commonbusiness.R$drawable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ej1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private LinearLayout a;
    private List<View> b = new ArrayList();

    public ej1(LinearLayout linearLayout) {
        this.a = linearLayout;
        linearLayout.getContext();
        a();
    }

    private void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1719872502")) {
            ipChange.ipc$dispatch("1719872502", new Object[]{this});
            return;
        }
        if (this.b == null) {
            this.b = new ArrayList();
        }
        this.b.clear();
        int childCount = this.a.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.b.add(this.a.getChildAt(i));
        }
    }

    public void b(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2074240518")) {
            ipChange.ipc$dispatch("2074240518", new Object[]{this, Integer.valueOf(i)});
        } else if (this.b != null) {
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                View view = this.b.get(i2);
                if (view != null) {
                    if (i2 == 0) {
                        view.setBackgroundResource(R$drawable.sku_heat_icon_left);
                    } else if (i2 == this.b.size() - 1) {
                        if (i - 1 == i2) {
                            view.setBackgroundResource(R$drawable.sku_heat_icon_right);
                        } else {
                            view.setBackgroundResource(R$drawable.sku_heat_icon_right_hui);
                        }
                    } else if (i2 < i) {
                        view.setBackgroundResource(R$drawable.sku_heat_icon_middle);
                    } else {
                        view.setBackgroundResource(R$drawable.sku_heat_icon_middle_hui);
                    }
                }
            }
        }
    }
}
