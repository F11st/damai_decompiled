package tb;

import android.util.Log;
import com.alibaba.pictures.dolores.log.IDoloresLog;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class yb0 implements IDoloresLog {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean a;

    public final void a(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-256203133")) {
            ipChange.ipc$dispatch("-256203133", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.a = z;
        }
    }

    @Override // com.alibaba.pictures.dolores.log.IDoloresLog
    public void debug(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1483202763")) {
            ipChange.ipc$dispatch("-1483202763", new Object[]{this, str, str2});
        } else if (this.a && str2 != null) {
            Log.d(str, str2);
        }
    }

    @Override // com.alibaba.pictures.dolores.log.IDoloresLog
    public void error(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-139275808")) {
            ipChange.ipc$dispatch("-139275808", new Object[]{this, str, str2});
        } else if (this.a && str2 != null) {
            Log.e(str, str2);
        }
    }

    @Override // com.alibaba.pictures.dolores.log.IDoloresLog
    public void info(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-607907108")) {
            ipChange.ipc$dispatch("-607907108", new Object[]{this, str, str2});
        } else if (this.a && str2 != null) {
            Log.i(str, str2);
        }
    }

    @Override // com.alibaba.pictures.dolores.log.IDoloresLog
    public void verbose(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-823928474")) {
            ipChange.ipc$dispatch("-823928474", new Object[]{this, str, str2});
        } else if (this.a && str2 != null) {
            Log.v(str, str2);
        }
    }

    @Override // com.alibaba.pictures.dolores.log.IDoloresLog
    public void warn(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1167622660")) {
            ipChange.ipc$dispatch("1167622660", new Object[]{this, str, str2});
        } else if (this.a && str2 != null) {
            Log.w(str, str2);
        }
    }
}
