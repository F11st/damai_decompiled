package tb;

import androidx.annotation.Nullable;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.option.ImageExtra;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.option.Option;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ln1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private final HashMap<String, kn1<l11>> a = new HashMap<>();
    private final HashMap<String, kn1<e92>> b = new HashMap<>();

    @Nullable
    public List<kn1<?>> a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1698058829")) {
            return (List) ipChange.ipc$dispatch("-1698058829", new Object[]{this});
        }
        Collection<kn1<l11>> values = this.a.values();
        if (cb2.d(values)) {
            return null;
        }
        return new ArrayList(values);
    }

    @Nullable
    public List<kn1<?>> b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-595407707")) {
            return (List) ipChange.ipc$dispatch("-595407707", new Object[]{this});
        }
        Collection<kn1<e92>> values = this.b.values();
        if (cb2.d(values)) {
            return null;
        }
        return new ArrayList(values);
    }

    public void c(kn1<l11> kn1Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-676308804")) {
            ipChange.ipc$dispatch("-676308804", new Object[]{this, kn1Var});
        } else if (kn1Var != null) {
            this.a.put(kn1Var.b(), kn1Var);
        }
    }

    public void d(Option<ImageExtra>[] optionArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-295885505")) {
            ipChange.ipc$dispatch("-295885505", new Object[]{this, optionArr});
        } else if (optionArr != null && optionArr.length > 0) {
            for (Option<ImageExtra> option : optionArr) {
                c(option);
            }
        }
    }

    public void e(kn1<e92> kn1Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1706316004")) {
            ipChange.ipc$dispatch("-1706316004", new Object[]{this, kn1Var});
        } else if (kn1Var != null) {
            this.b.put(kn1Var.b(), kn1Var);
        }
    }
}
