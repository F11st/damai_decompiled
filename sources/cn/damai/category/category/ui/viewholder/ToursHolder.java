package cn.damai.category.category.ui.viewholder;

import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.category.bean.StarAndBrandItem;
import cn.damai.category.category.bean.ToursBean;
import cn.damai.category.category.bean.ToursCityBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.gp2;
import tb.o91;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ToursHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private gp2 a;
    private View b;

    public ToursHolder(View view, String str, View.OnClickListener onClickListener) {
        super(view);
        this.b = view;
    }

    public void a(StarAndBrandItem starAndBrandItem, int i, boolean z) {
        ToursBean toursBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2101588132")) {
            ipChange.ipc$dispatch("2101588132", new Object[]{this, starAndBrandItem, Integer.valueOf(i), Boolean.valueOf(z)});
            return;
        }
        this.a = new gp2(this.b);
        if (starAndBrandItem != null && (toursBean = starAndBrandItem.toursBean) != null && !o91.a(toursBean.tourProjects)) {
            this.a.b(true);
            List<ToursCityBean> list = starAndBrandItem.toursBean.tourProjects;
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (list.get(i3) != null && !TextUtils.isEmpty(list.get(i3).cityName)) {
                    i2++;
                    if (i3 == list.size() - 1) {
                        sb.append(list.get(i3).cityName);
                    } else {
                        sb.append(list.get(i3).cityName + " | ");
                    }
                }
            }
            this.a.a(i2, sb.toString());
            return;
        }
        this.a.b(false);
    }
}
