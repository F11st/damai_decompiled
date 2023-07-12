package tb;

import com.alibaba.pictures.dolores.business.AsyncResult;
import com.alibaba.pictures.dolores.request.DoloresRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class cc0 {
    private static transient /* synthetic */ IpChange $ipChange;

    @NotNull
    public static final <BizResponse> AsyncResult<BizResponse> a(@NotNull DoloresRequest<BizResponse> doloresRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1275458570")) {
            return (AsyncResult) ipChange.ipc$dispatch("1275458570", new Object[]{doloresRequest});
        }
        b41.i(doloresRequest, "$this$async");
        return rb0.Companion.a(doloresRequest).a();
    }
}
