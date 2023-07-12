package tb;

import cn.damai.tetris.core.IContext;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class nm<T> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final IContext a;
    private String b;
    private T c;

    public nm(IContext iContext) {
        this.a = iContext;
    }

    public IContext a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2012579904") ? (IContext) ipChange.ipc$dispatch("2012579904", new Object[]{this}) : this.a;
    }

    public T b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-310647925") ? (T) ipChange.ipc$dispatch("-310647925", new Object[]{this}) : this.c;
    }

    public String c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1387595639") ? (String) ipChange.ipc$dispatch("-1387595639", new Object[]{this}) : this.b;
    }

    public void d(T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-928708841")) {
            ipChange.ipc$dispatch("-928708841", new Object[]{this, t});
        } else {
            this.c = t;
        }
    }

    public void e(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-358548619")) {
            ipChange.ipc$dispatch("-358548619", new Object[]{this, str});
        } else {
            this.b = str;
        }
    }
}
