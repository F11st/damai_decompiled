package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class sw0<BizResponse> extends uf<BizResponse, BizResponse> {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private Boolean b;

    public sw0(BizResponse bizresponse) {
        super(bizresponse);
    }

    @Nullable
    public final Boolean b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "718040865") ? (Boolean) ipChange.ipc$dispatch("718040865", new Object[]{this}) : this.b;
    }

    public final void c(@Nullable Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-496268127")) {
            ipChange.ipc$dispatch("-496268127", new Object[]{this, bool});
        } else {
            this.b = bool;
        }
    }
}
