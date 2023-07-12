package tb;

import com.alibaba.pictures.accs.IACCSConfigProvider;
import com.alibaba.pictures.accs.PushAgent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.accs.AccsException;
import com.taobao.accs.IAppReceiver;
import com.taobao.accs.utl.ALog;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* renamed from: tb.f */
/* loaded from: classes7.dex */
public final class C9120f implements IAppReceiver {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final String a;
    private final IACCSConfigProvider b;

    public C9120f(@NotNull IACCSConfigProvider iACCSConfigProvider) {
        b41.i(iACCSConfigProvider, "configProvider");
        this.b = iACCSConfigProvider;
        this.a = "ACCS.ACCSAPPReceiver";
    }

    @Override // com.taobao.accs.IAppReceiver
    @NotNull
    public Map<String, String> getAllServices() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2078637565")) {
            return (Map) ipChange.ipc$dispatch("-2078637565", new Object[]{this});
        }
        HashMap<String, String> accsServiceMap = this.b.getAccsServiceMap();
        return accsServiceMap != null ? accsServiceMap : new HashMap();
    }

    @Override // com.taobao.accs.IAppReceiver
    @NotNull
    public String getService(@Nullable String str) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-2004274658")) {
            return (String) ipChange.ipc$dispatch("-2004274658", new Object[]{this, str});
        }
        HashMap<String, String> accsServiceMap = this.b.getAccsServiceMap();
        String str2 = accsServiceMap != null ? accsServiceMap.get(str) : null;
        if (str2 != null && str2.length() != 0) {
            z = false;
        }
        return z ? "" : str2;
    }

    @Override // com.taobao.accs.IAppReceiver
    public void onBindApp(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2081070123")) {
            ipChange.ipc$dispatch("-2081070123", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ALog.d("accs", "bindApp", new Object[0]);
        if (i == 200) {
            try {
                ALog.d(this.a, "bindApp success", new Object[0]);
                try {
                    PushAgent.b(this.b.getContext(), this.b.getUserId());
                } catch (AccsException e) {
                    e.printStackTrace();
                }
            } catch (Exception e2) {
                ALog.e(this.a + "_accs", "exception==" + e2, new Object[0]);
            }
        }
    }

    @Override // com.taobao.accs.IAppReceiver
    public void onBindUser(@Nullable String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-470999895")) {
            ipChange.ipc$dispatch("-470999895", new Object[]{this, str, Integer.valueOf(i)});
            return;
        }
        ALog.e("accs", "bindUser" + str, new Object[0]);
    }

    @Override // com.taobao.accs.IAppReceiver
    public void onData(@NotNull String str, @NotNull String str2, @NotNull byte[] bArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1926447511")) {
            ipChange.ipc$dispatch("-1926447511", new Object[]{this, str, str2, bArr});
            return;
        }
        b41.i(str, "s");
        b41.i(str2, "s1");
        b41.i(bArr, "bytes");
        ALog.d("accs", bArr.toString(), new Object[0]);
    }

    @Override // com.taobao.accs.IAppReceiver
    public void onSendData(@Nullable String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1239600429")) {
            ipChange.ipc$dispatch("-1239600429", new Object[]{this, str, Integer.valueOf(i)});
        }
    }

    @Override // com.taobao.accs.IAppReceiver
    public void onUnbindApp(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-112544036")) {
            ipChange.ipc$dispatch("-112544036", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // com.taobao.accs.IAppReceiver
    public void onUnbindUser(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-577419508")) {
            ipChange.ipc$dispatch("-577419508", new Object[]{this, Integer.valueOf(i)});
        }
    }
}
