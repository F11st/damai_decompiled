package tb;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.address.bean.DivisionBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class ja0 extends q2 {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<DivisionBean> i;

    public ja0(Context context, List<DivisionBean> list) {
        super(context);
        this.i = list;
        e(context.getResources().getColor(R$color.color_222222));
        f(16);
    }

    @Override // tb.q2
    protected CharSequence b(int i) {
        DivisionBean divisionBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-510270704")) {
            return (CharSequence) ipChange.ipc$dispatch("-510270704", new Object[]{this, Integer.valueOf(i)});
        }
        if (i < 0 || i > this.i.size() || (divisionBean = this.i.get(i)) == null) {
            return null;
        }
        return divisionBean.getDivisionName();
    }

    @Override // tb.q2, cn.damai.uikit.wheel.adapters.WheelViewAdapter
    public View getItem(int i, View view, ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2073344022") ? (View) ipChange.ipc$dispatch("2073344022", new Object[]{this, Integer.valueOf(i), view, viewGroup}) : super.getItem(i, view, viewGroup);
    }

    @Override // cn.damai.uikit.wheel.adapters.WheelViewAdapter
    public int getItemsCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-200012035")) {
            return ((Integer) ipChange.ipc$dispatch("-200012035", new Object[]{this})).intValue();
        }
        List<DivisionBean> list = this.i;
        if (list != null) {
            return list.size();
        }
        return 0;
    }
}
