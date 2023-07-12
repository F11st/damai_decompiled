package tb;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.tetris.component.star.bean.CombineFillperItems;
import cn.damai.tetris.component.star.bean.FillperItemBean;
import cn.damai.uikit.view.DMLabelType;
import cn.damai.uikit.view.DMLabelView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ek0 {
    private static transient /* synthetic */ IpChange $ipChange;
    public ViewGroup a;
    private int[] b = {R$id.xunyan_flipper_item_1, R$id.xunyan_flipper_item_2, R$id.xunyan_flipper_item_3};

    public ek0(View view) {
        this.a = (ViewGroup) view;
    }

    private void c(ViewGroup viewGroup, TextView textView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-692181641")) {
            ipChange.ipc$dispatch("-692181641", new Object[]{this, viewGroup, textView, str});
        } else if (TextUtils.isEmpty(str)) {
            viewGroup.setVisibility(4);
        } else {
            viewGroup.setVisibility(0);
            textView.setText(str);
        }
    }

    public void a(CombineFillperItems combineFillperItems) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-583995265")) {
            ipChange.ipc$dispatch("-583995265", new Object[]{this, combineFillperItems});
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (combineFillperItems.itemBeans[i] != null) {
                this.a.findViewById(this.b[i]).setVisibility(0);
                b(combineFillperItems.itemBeans[i], i, (ViewGroup) this.a.findViewById(this.b[i]));
            } else {
                this.a.findViewById(this.b[i]).setVisibility(4);
            }
        }
    }

    public void b(FillperItemBean fillperItemBean, int i, ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1574803163")) {
            ipChange.ipc$dispatch("1574803163", new Object[]{this, fillperItemBean, Integer.valueOf(i), viewGroup});
        } else if (fillperItemBean == null) {
        } else {
            c(viewGroup, (TextView) viewGroup.findViewById(R$id.xunyan_item_tv_1), fillperItemBean.text);
            if (i == 0) {
                ((DMLabelView) viewGroup.findViewById(R$id.xunyan_item_laeblview1)).setLabelType(DMLabelType.LABEL_TYPE_CUSTOM).setBgColor("#FFA7AA", "#FF88AE");
            } else if (i == 1) {
                ((DMLabelView) viewGroup.findViewById(R$id.xunyan_item_laeblview1)).setLabelType(DMLabelType.LABEL_TYPE_CUSTOM).setBgColor("#D2CBFE", "#A79AFF");
            } else if (i == 2) {
                ((DMLabelView) viewGroup.findViewById(R$id.xunyan_item_laeblview1)).setLabelType(DMLabelType.LABEL_TYPE_CUSTOM).setBgColor("#B5EFFF", "#74D1FF");
            }
        }
    }
}
