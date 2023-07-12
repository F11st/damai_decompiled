package tb;

import com.alibaba.pictures.uploader.UploadStatus;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.uploader.export.ITaskResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class uu2 {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String a;
    @Nullable
    private String b;
    @Nullable
    private UploadStatus c;
    private int d;
    @Nullable
    private ITaskResult e;
    @Nullable
    private fl2 f;

    @Nullable
    public final String a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-596547403") ? (String) ipChange.ipc$dispatch("-596547403", new Object[]{this}) : this.b;
    }

    @Nullable
    public final String b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1820910345") ? (String) ipChange.ipc$dispatch("1820910345", new Object[]{this}) : this.a;
    }

    public final int c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1032553646") ? ((Integer) ipChange.ipc$dispatch("1032553646", new Object[]{this})).intValue() : this.d;
    }

    @Nullable
    public final ITaskResult d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1690477337") ? (ITaskResult) ipChange.ipc$dispatch("1690477337", new Object[]{this}) : this.e;
    }

    public final void e(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1365613409")) {
            ipChange.ipc$dispatch("1365613409", new Object[]{this, str});
        } else {
            this.b = str;
        }
    }

    public final void f(@Nullable fl2 fl2Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1629306272")) {
            ipChange.ipc$dispatch("-1629306272", new Object[]{this, fl2Var});
        } else {
            this.f = fl2Var;
        }
    }

    public final void g(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1716499941")) {
            ipChange.ipc$dispatch("1716499941", new Object[]{this, Long.valueOf(j)});
        }
    }

    public final void h(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1002607731")) {
            ipChange.ipc$dispatch("-1002607731", new Object[]{this, str});
        } else {
            this.a = str;
        }
    }

    public final void i(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1439792972")) {
            ipChange.ipc$dispatch("-1439792972", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.d = i;
        }
    }

    public final void j(@Nullable ITaskResult iTaskResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1100942401")) {
            ipChange.ipc$dispatch("-1100942401", new Object[]{this, iTaskResult});
        } else {
            this.e = iTaskResult;
        }
    }

    public final void k(@Nullable UploadStatus uploadStatus) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1549063202")) {
            ipChange.ipc$dispatch("-1549063202", new Object[]{this, uploadStatus});
        } else {
            this.c = uploadStatus;
        }
    }

    @NotNull
    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1591979456")) {
            return (String) ipChange.ipc$dispatch("-1591979456", new Object[]{this});
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.valueOf(this.c));
        stringBuffer.append(":");
        UploadStatus uploadStatus = this.c;
        if (uploadStatus != null) {
            int i = tu2.$EnumSwitchMapping$0[uploadStatus.ordinal()];
            if (i == 1) {
                stringBuffer.append(this.d);
                stringBuffer.append("%");
            } else if (i == 2) {
                fl2 fl2Var = this.f;
                stringBuffer.append(fl2Var != null ? fl2Var.a : null);
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        b41.h(stringBuffer2, "buffer.toString()");
        return stringBuffer2;
    }
}
