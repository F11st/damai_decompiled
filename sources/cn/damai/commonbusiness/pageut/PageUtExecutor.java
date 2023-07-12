package cn.damai.commonbusiness.pageut;

import android.app.Activity;
import androidx.viewpager.widget.ViewPager;
import cn.damai.common.user.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class PageUtExecutor implements ViewPager.OnPageChangeListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private Activity a;
    private UTKeyBuilderProvider b;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public interface FragmentPropertiesProvider {
        Map get(String str);

        void put(String str, Map map);
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public interface UTKeyBuilderProvider {
        a.b get(int i);
    }

    public PageUtExecutor(Activity activity, UTKeyBuilderProvider uTKeyBuilderProvider) {
        this.a = activity;
        this.b = uTKeyBuilderProvider;
    }

    private boolean b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-39974842") ? ((Boolean) ipChange.ipc$dispatch("-39974842", new Object[]{this})).booleanValue() : (this.a == null || this.b == null) ? false : true;
    }

    public void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1147486643")) {
            ipChange.ipc$dispatch("1147486643", new Object[]{this});
        } else {
            onPageSelected(0);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1845976683")) {
            ipChange.ipc$dispatch("1845976683", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-705919478")) {
            ipChange.ipc$dispatch("-705919478", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-448055434")) {
            ipChange.ipc$dispatch("-448055434", new Object[]{this, Integer.valueOf(i)});
        } else if (b()) {
            a.h(this.a, this.b.get(i));
        }
    }
}
