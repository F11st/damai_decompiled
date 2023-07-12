package tb;

import android.graphics.Color;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public abstract class f52 {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<Integer> a;
    private int b;

    public boolean a(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1440624812")) {
            return ((Boolean) ipChange.ipc$dispatch("1440624812", new Object[]{this, Integer.valueOf(i)})).booleanValue();
        }
        List<Integer> list = this.a;
        if (list == null || list.isEmpty()) {
            return false;
        }
        return this.a.contains(Integer.valueOf(i));
    }

    public int b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "263344876") ? ((Integer) ipChange.ipc$dispatch("263344876", new Object[]{this})).intValue() : this.b;
    }

    public void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "515835390")) {
            ipChange.ipc$dispatch("515835390", new Object[]{this});
            return;
        }
        List<String> d = d();
        if (d == null || d.isEmpty()) {
            return;
        }
        this.a = new ArrayList();
        for (String str : d) {
            this.a.add(Integer.valueOf((cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.c.c(str).intValue() & 16777215) | (-16777216)));
        }
        this.b = Color.parseColor(e());
    }

    public abstract List<String> d();

    public abstract String e();
}
