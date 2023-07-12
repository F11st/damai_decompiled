package tb;

import androidx.viewpager.widget.ViewPager;
import cn.damai.ticklet.view.ViewPagerScroller;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Field;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class fy2 {
    private static transient /* synthetic */ IpChange $ipChange;
    ViewPager a;
    ViewPagerScroller b;

    public fy2(ViewPager viewPager) {
        this.a = viewPager;
        b();
    }

    private void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1498667205")) {
            ipChange.ipc$dispatch("1498667205", new Object[]{this});
            return;
        }
        this.b = new ViewPagerScroller(this.a.getContext());
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            declaredField.set(this.a, this.b);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
    }

    public ViewPagerScroller a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1724606404") ? (ViewPagerScroller) ipChange.ipc$dispatch("-1724606404", new Object[]{this}) : this.b;
    }
}
