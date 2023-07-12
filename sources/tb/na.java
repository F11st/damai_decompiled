package tb;

import com.alibaba.pictures.dolores.request.DoloresRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class na<BizResponse> implements DoloresRequest<BizResponse> {
    private static transient /* synthetic */ IpChange $ipChange;
    @JvmField
    @Nullable
    public String a;

    @Override // com.alibaba.pictures.dolores.request.DoloresRequest
    @NotNull
    public String markRequestLabel() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1456557408") ? (String) ipChange.ipc$dispatch("-1456557408", new Object[]{this}) : "tpp";
    }
}
