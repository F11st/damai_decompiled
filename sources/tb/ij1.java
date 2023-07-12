package tb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.WishHeaPricetBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ij1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private View a;
    private Context b;
    private LinearLayout c;

    public ij1(View view) {
        this.a = view;
        this.b = view.getContext();
        b();
    }

    private void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1569978456")) {
            ipChange.ipc$dispatch("-1569978456", new Object[]{this});
        } else {
            this.c = (LinearLayout) this.a.findViewById(R$id.layout_heat_list);
        }
    }

    private void d(View view, WishHeaPricetBean wishHeaPricetBean, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1406319883")) {
            ipChange.ipc$dispatch("-1406319883", new Object[]{this, view, wishHeaPricetBean, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        TextView textView = (TextView) view.findViewById(R$id.tv_name);
        ImageView imageView = (ImageView) view.findViewById(R$id.image_xin);
        ej1 ej1Var = new ej1((LinearLayout) view.findViewById(R$id.layout_heat_icon));
        TextView textView2 = (TextView) view.findViewById(R$id.tv_people_tip);
        View findViewById = view.findViewById(R$id.view_line);
        findViewById.setVisibility(0);
        if (i == 0) {
            textView.setTextColor(this.b.getResources().getColor(R$color.color_FF2869));
            imageView.setVisibility(0);
        } else {
            textView.setTextColor(this.b.getResources().getColor(R$color.color_3c3f44));
            imageView.setVisibility(8);
        }
        if (i == i2 - 1) {
            findViewById.setVisibility(8);
        }
        textView.setText(wishHeaPricetBean.priceName);
        textView2.setText(wishHeaPricetBean.heatDesc);
        ej1Var.b(wishHeaPricetBean.heat);
    }

    public View a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2093833492") ? (View) ipChange.ipc$dispatch("2093833492", new Object[]{this}) : this.a;
    }

    public void c(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1705129110")) {
            ipChange.ipc$dispatch("-1705129110", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.a.setVisibility(i);
        }
    }

    public void e(List<WishHeaPricetBean> list, long j) {
        WishHeaPricetBean wishHeaPricetBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1472239612")) {
            ipChange.ipc$dispatch("-1472239612", new Object[]{this, list, Long.valueOf(j)});
            return;
        }
        this.c.removeAllViews();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            WishHeaPricetBean wishHeaPricetBean2 = list.get(i);
            if (wishHeaPricetBean2 != null) {
                try {
                    arrayList.add((WishHeaPricetBean) wishHeaPricetBean2.clone());
                } catch (CloneNotSupportedException unused) {
                }
            }
        }
        int i2 = 0;
        while (true) {
            if (i2 >= arrayList.size()) {
                wishHeaPricetBean = null;
                break;
            }
            wishHeaPricetBean = (WishHeaPricetBean) arrayList.get(i2);
            if (wishHeaPricetBean.priceId == j) {
                arrayList.remove(i2);
                break;
            }
            i2++;
        }
        if (wishHeaPricetBean != null) {
            arrayList.add(0, wishHeaPricetBean);
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            WishHeaPricetBean wishHeaPricetBean3 = (WishHeaPricetBean) arrayList.get(i3);
            if (wishHeaPricetBean3 != null) {
                View inflate = LayoutInflater.from(this.b).inflate(R$layout.fragment_sku_ncov_see_heat_item, (ViewGroup) null, false);
                this.c.addView(inflate);
                d(inflate, wishHeaPricetBean3, i3, arrayList.size());
            }
        }
    }
}
