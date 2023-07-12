package tb;

import android.view.View;
import android.widget.LinearLayout;
import cn.damai.uikit.wheel.WheelView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.LinkedList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class p13 {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<View> a;
    private List<View> b;
    private WheelView c;

    public p13(WheelView wheelView) {
        this.c = wheelView;
    }

    private List<View> a(View view, List<View> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1673950953")) {
            return (List) ipChange.ipc$dispatch("-1673950953", new Object[]{this, view, list});
        }
        if (list == null) {
            list = new LinkedList<>();
        }
        list.add(view);
        return list;
    }

    private View c(List<View> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-173812913")) {
            return (View) ipChange.ipc$dispatch("-173812913", new Object[]{this, list});
        }
        if (list == null || list.size() <= 0) {
            return null;
        }
        View view = list.get(0);
        list.remove(0);
        return view;
    }

    private void g(View view, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1640887154")) {
            ipChange.ipc$dispatch("1640887154", new Object[]{this, view, Integer.valueOf(i)});
            return;
        }
        int itemsCount = this.c.getViewAdapter().getItemsCount();
        if ((i < 0 || i >= itemsCount) && !this.c.isCyclic()) {
            this.b = a(view, this.b);
            return;
        }
        while (i < 0) {
            i += itemsCount;
        }
        int i2 = i % itemsCount;
        this.a = a(view, this.a);
    }

    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "626480253")) {
            ipChange.ipc$dispatch("626480253", new Object[]{this});
            return;
        }
        List<View> list = this.a;
        if (list != null) {
            list.clear();
        }
        List<View> list2 = this.b;
        if (list2 != null) {
            list2.clear();
        }
    }

    public View d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-119714807") ? (View) ipChange.ipc$dispatch("-119714807", new Object[]{this}) : c(this.b);
    }

    public View e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1495972466") ? (View) ipChange.ipc$dispatch("1495972466", new Object[]{this}) : c(this.a);
    }

    public int f(LinearLayout linearLayout, int i, p41 p41Var) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-537119909")) {
            return ((Integer) ipChange.ipc$dispatch("-537119909", new Object[]{this, linearLayout, Integer.valueOf(i), p41Var})).intValue();
        }
        int i3 = i;
        while (i2 < linearLayout.getChildCount()) {
            if (p41Var.a(i3)) {
                i2++;
            } else {
                g(linearLayout.getChildAt(i2), i3);
                linearLayout.removeViewAt(i2);
                if (i2 == 0) {
                    i++;
                }
            }
            i3++;
        }
        return i;
    }
}
