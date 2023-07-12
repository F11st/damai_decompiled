package tb;

import android.graphics.Color;
import cn.damai.commonbusiness.dynamicx.customwidget.textview.GradientBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class ci1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static ci1 b;
    private static int c;
    private final List<GradientBean> a;

    public ci1() {
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        arrayList.add(new GradientBean(Color.parseColor("#FF45BD"), Color.parseColor("#D34BFF"), 0.0f));
        arrayList.add(new GradientBean(Color.parseColor("#A045FF"), Color.parseColor("#3BB2FF"), 0.0f));
        arrayList.add(new GradientBean(Color.parseColor("#FFA44B"), Color.parseColor("#FF6B6B"), 0.0f));
        arrayList.add(new GradientBean(Color.parseColor("#23C8EF"), Color.parseColor("#25E4A1"), 0.0f));
    }

    public static synchronized ci1 c() {
        synchronized (ci1.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1888833883")) {
                return (ci1) ipChange.ipc$dispatch("1888833883", new Object[0]);
            }
            if (b == null) {
                b = new ci1();
            }
            return b;
        }
    }

    public GradientBean a(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1129755413") ? (GradientBean) ipChange.ipc$dispatch("1129755413", new Object[]{this, Integer.valueOf(i)}) : this.a.get(i % this.a.size());
    }

    public int b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1012455323")) {
            return ((Integer) ipChange.ipc$dispatch("1012455323", new Object[]{this})).intValue();
        }
        int i = c;
        c = i + 1;
        return i;
    }
}
