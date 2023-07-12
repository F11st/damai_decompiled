package tb;

import com.alibaba.pictures.dolores.request.DoloresRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class bc0 {
    private static transient /* synthetic */ IpChange $ipChange;

    @NotNull
    public static final <BizResponse> rb0<BizResponse> a(@NotNull DoloresRequest<BizResponse> doloresRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-956643511")) {
            return (rb0) ipChange.ipc$dispatch("-956643511", new Object[]{doloresRequest});
        }
        b41.i(doloresRequest, "$this$dolores");
        return rb0.Companion.a(doloresRequest);
    }
}
