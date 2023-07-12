package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class c50 {
    private static transient /* synthetic */ IpChange $ipChange;
    private a50 a = new a50();
    private a50 b = new a50();
    private a50 c = new a50();

    c50() {
    }

    public static c50 d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1600606779") ? (c50) ipChange.ipc$dispatch("-1600606779", new Object[0]) : new c50();
    }

    public a50 a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2018737447") ? (a50) ipChange.ipc$dispatch("-2018737447", new Object[]{this}) : this.c;
    }

    public a50 b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-542645792") ? (a50) ipChange.ipc$dispatch("-542645792", new Object[]{this}) : this.a;
    }

    public void c(LinkedHashMap<String, ArrayList<String>> linkedHashMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1300972556")) {
            ipChange.ipc$dispatch("1300972556", new Object[]{this, linkedHashMap});
            return;
        }
        for (Map.Entry<String, ArrayList<String>> entry : linkedHashMap.entrySet()) {
            String key = entry.getKey();
            if ("floorDict".equalsIgnoreCase(key)) {
                this.a.c(entry.getValue());
            } else if ("rowDict".equalsIgnoreCase(key)) {
                this.b.c(entry.getValue());
            } else if ("chairDict".equalsIgnoreCase(key)) {
                this.c.c(entry.getValue());
            }
        }
        q40.d(this.a.a(), "floorDict");
        q40.d(this.b.a(), "rowDict");
        q40.d(this.c.a(), "chairDict");
    }

    public a50 e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1510993390") ? (a50) ipChange.ipc$dispatch("1510993390", new Object[]{this}) : this.b;
    }
}
