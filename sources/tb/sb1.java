package tb;

import android.util.Log;
import com.alibaba.pictures.cornerstone.protocol.ILogger;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class sb1 implements ILogger {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.alibaba.pictures.cornerstone.protocol.ILogger
    public void d(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1846356532")) {
            ipChange.ipc$dispatch("1846356532", new Object[]{this, str});
        } else {
            d("Cornerstone", str);
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ILogger
    public void e(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-191699757")) {
            ipChange.ipc$dispatch("-191699757", new Object[]{this, str});
        } else {
            e("Cornerstone", str);
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ILogger
    public void w(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1777992705")) {
            ipChange.ipc$dispatch("1777992705", new Object[]{this, str});
        } else {
            w("Cornerstone", str);
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ILogger
    public void d(@NotNull String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "574074622")) {
            ipChange.ipc$dispatch("574074622", new Object[]{this, str, str2});
            return;
        }
        b41.i(str, "tag");
        if (t6.INSTANCE.debugable()) {
            String str3 = "Cornerstone:" + str;
            if (str2 == null) {
                str2 = "";
            }
            Log.d(str3, str2);
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ILogger
    public void e(@NotNull String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2035654621")) {
            ipChange.ipc$dispatch("2035654621", new Object[]{this, str, str2});
            return;
        }
        b41.i(str, "tag");
        if (t6.INSTANCE.debugable()) {
            String str3 = "Cornerstone:" + str;
            if (str2 == null) {
                str2 = "";
            }
            Log.e(str3, str2);
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ILogger
    public void w(@NotNull String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1720676469")) {
            ipChange.ipc$dispatch("-1720676469", new Object[]{this, str, str2});
            return;
        }
        b41.i(str, "tag");
        if (t6.INSTANCE.debugable()) {
            String str3 = "Cornerstone:" + str;
            if (str2 == null) {
                str2 = "";
            }
            Log.w(str3, str2);
        }
    }
}
