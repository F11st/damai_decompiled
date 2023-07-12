package tb;

import com.alibaba.pictures.dolores.DoloresKernel;
import com.alibaba.pictures.dolores.request.DoloresRequest;
import com.alibaba.pictures.request.BaseMtopRequest;
import com.alibaba.pictures.request.BaseRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.LinkedHashMap;
import mtopsdk.mtop.domain.IMTOPDataObject;
import mtopsdk.mtop.domain.MtopRequest;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class xb0 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final xb0 INSTANCE = new xb0();

    static {
        new LinkedHashMap(10);
    }

    private xb0() {
    }

    @Nullable
    public final <BizResponse> DoloresKernel<BizResponse> a(@NotNull DoloresRequest<BizResponse> doloresRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1177830475")) {
            return (DoloresKernel) ipChange.ipc$dispatch("-1177830475", new Object[]{this, doloresRequest});
        }
        b41.i(doloresRequest, "request");
        if ((doloresRequest instanceof BaseMtopRequest) || (doloresRequest instanceof BaseRequest) || (doloresRequest instanceof IMTOPDataObject) || (doloresRequest instanceof MtopRequest)) {
            return new ac0();
        }
        if (doloresRequest instanceof na) {
            return new wb0();
        }
        String str = "request : " + doloresRequest.getClass().getSimpleName() + " ,没有对应的请求kernel，需要新写！！！！";
        rq.c("DoloresKernelManager", str);
        zb0.h(doloresRequest.getClass().getSimpleName(), "1001", str, "");
        return null;
    }
}
