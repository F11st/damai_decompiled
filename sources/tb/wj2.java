package tb;

import android.app.Application;
import com.alibaba.poplayer.norm.ILogAdapter;
import com.alibaba.poplayer.utils.ConsoleLogger$Level;
import com.alibaba.poplayerconsole.PopLayerConsole;
import com.alibaba.poplayerconsole.PopLayerDebugActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class wj2 implements ILogAdapter {
    private static transient /* synthetic */ IpChange $ipChange;

    public wj2(Application application) {
    }

    @Override // com.alibaba.poplayer.norm.ILogAdapter
    public void Loge(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1709285925")) {
            ipChange.ipc$dispatch("1709285925", new Object[]{this, str});
        } else if (PopLayerDebugActivity.a()) {
            PopLayerConsole.P(str, ConsoleLogger$Level.E);
        }
    }

    @Override // com.alibaba.poplayer.norm.ILogAdapter
    public void Logi(String str, Object... objArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "100258032")) {
            ipChange.ipc$dispatch("100258032", new Object[]{this, str, objArr});
        } else if (PopLayerDebugActivity.a()) {
            PopLayerConsole.P(str, ConsoleLogger$Level.I);
        }
    }
}
