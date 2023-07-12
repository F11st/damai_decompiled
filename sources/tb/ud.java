package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public abstract class ud {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int DEFAULT_CACHE_VALID_MILLS = 1500;

    public int cacheValidMills() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1004998363")) {
            return ((Integer) ipChange.ipc$dispatch("-1004998363", new Object[]{this})).intValue();
        }
        return 1500;
    }

    public abstract boolean is4Preload();
}
