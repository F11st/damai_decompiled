package tb;

import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.v2.convertor.ChainPreProcess;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class cb {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final List<ChainPreProcess> a = new ArrayList();

    static {
        a(new ih());
    }

    public static void a(ChainPreProcess chainPreProcess) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1662278392")) {
            ipChange.ipc$dispatch("-1662278392", new Object[]{chainPreProcess});
        } else if (chainPreProcess != null) {
            a.add(chainPreProcess);
        }
    }

    public void b(BaseResponse baseResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1708286625")) {
            ipChange.ipc$dispatch("1708286625", new Object[]{this, baseResponse});
        } else if (baseResponse != null) {
            List<ChainPreProcess> list = a;
            if (list.size() > 0) {
                for (ChainPreProcess chainPreProcess : list) {
                    chainPreProcess.process(baseResponse);
                }
            }
        }
    }
}
