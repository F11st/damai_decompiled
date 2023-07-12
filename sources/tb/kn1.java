package tb;

import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public abstract class kn1<E> {
    private static transient /* synthetic */ IpChange $ipChange;

    public abstract E a();

    @NonNull
    public abstract String b();

    public abstract long c();

    @NonNull
    public abstract String d();

    public abstract boolean e();

    public String toString() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1863840550") ? (String) ipChange.ipc$dispatch("1863840550", new Object[]{this}) : JSON.toJSONString(this);
    }
}
