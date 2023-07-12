package com.youku.live.dago.widgetlib.ailproom.adapter.logging;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.ailpbaselib.protocol.AILPLoggingProtocol;
import java.util.Objects;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AILPLoggingAdapter implements AILPLoggingProtocol {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int DEBUG = 3;
    private static final int ERROR = 6;
    private static final int INFO = 4;
    private static final int VERBOSE = 2;
    private static final int WARN = 5;
    private final String DEFAULT_TAG = "NO_TAG";

    @NonNull
    static <T> T checkNotNull(@Nullable T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2084902976")) {
            return (T) ipChange.ipc$dispatch("2084902976", new Object[]{t});
        }
        Objects.requireNonNull(t);
        return t;
    }

    @NonNull
    private String createMessage(@NonNull String str, @Nullable Object... objArr) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-253385680") ? (String) ipChange.ipc$dispatch("-253385680", new Object[]{this, str, objArr}) : (objArr == null || objArr.length == 0) ? str : String.format(str, objArr);
    }

    private void log(int i, @NonNull String str, @NonNull String str2, @Nullable Object... objArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "532062232")) {
            ipChange.ipc$dispatch("532062232", new Object[]{this, Integer.valueOf(i), str, str2, objArr});
            return;
        }
        checkNotNull(str2);
        log(i, str, createMessage(str2, objArr));
    }

    @Override // com.youku.live.dago.widgetlib.ailpbaselib.protocol.AILPLoggingProtocol
    public void d(@NonNull String str, @NonNull String str2, @Nullable Object... objArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1655209249")) {
            ipChange.ipc$dispatch("-1655209249", new Object[]{this, str, str2, objArr});
        } else {
            log(3, str, str2, objArr);
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailpbaselib.protocol.AILPLoggingProtocol
    public void e(@NonNull String str, @NonNull String str2, @Nullable Object... objArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1374859360")) {
            ipChange.ipc$dispatch("-1374859360", new Object[]{this, str, str2, objArr});
        } else {
            log(6, str, str2, objArr);
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailpbaselib.protocol.AILPLoggingProtocol
    public void i(@NonNull String str, @NonNull String str2, @Nullable Object... objArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-253459804")) {
            ipChange.ipc$dispatch("-253459804", new Object[]{this, str, str2, objArr});
        } else {
            log(4, str, str2, objArr);
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailpbaselib.protocol.AILPLoggingProtocol
    public void v(@NonNull String str, @NonNull String str2, @Nullable Object... objArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-903878543")) {
            ipChange.ipc$dispatch("-903878543", new Object[]{this, str, str2, objArr});
        } else {
            log(2, str, str2, objArr);
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailpbaselib.protocol.AILPLoggingProtocol
    public void w(@NonNull String str, @NonNull String str2, @Nullable Object... objArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-623528654")) {
            ipChange.ipc$dispatch("-623528654", new Object[]{this, str, str2, objArr});
        } else {
            log(5, str, str2, objArr);
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailpbaselib.protocol.AILPLoggingProtocol
    public void d(@NonNull String str, Object... objArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1893049065")) {
            ipChange.ipc$dispatch("1893049065", new Object[]{this, str, objArr});
        } else {
            log(3, null, str, objArr);
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailpbaselib.protocol.AILPLoggingProtocol
    public void e(@NonNull String str, @Nullable Object... objArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-42611222")) {
            ipChange.ipc$dispatch("-42611222", new Object[]{this, str, objArr});
        } else {
            log(6, null, str, objArr);
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailpbaselib.protocol.AILPLoggingProtocol
    public void i(@NonNull String str, @Nullable Object... objArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "804682222")) {
            ipChange.ipc$dispatch("804682222", new Object[]{this, str, objArr});
        } else {
            log(4, null, str, objArr);
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailpbaselib.protocol.AILPLoggingProtocol
    public void v(@NonNull String str, @Nullable Object... objArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1410902267")) {
            ipChange.ipc$dispatch("1410902267", new Object[]{this, str, objArr});
        } else {
            log(2, null, str, objArr);
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailpbaselib.protocol.AILPLoggingProtocol
    public void w(@NonNull String str, @Nullable Object... objArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-524758020")) {
            ipChange.ipc$dispatch("-524758020", new Object[]{this, str, objArr});
        } else {
            log(5, null, str, objArr);
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailpbaselib.protocol.AILPLoggingProtocol
    public void d(@NonNull String str, @NonNull String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "170900242")) {
            ipChange.ipc$dispatch("170900242", new Object[]{this, str, str2});
        } else {
            log(3, str, str2);
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailpbaselib.protocol.AILPLoggingProtocol
    public void e(@NonNull String str, @NonNull String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1632480241")) {
            ipChange.ipc$dispatch("1632480241", new Object[]{this, str, str2});
        } else {
            log(6, str, str2);
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailpbaselib.protocol.AILPLoggingProtocol
    public void i(@NonNull String str, @NonNull String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1111134355")) {
            ipChange.ipc$dispatch("-1111134355", new Object[]{this, str, str2});
        } else {
            log(4, str, str2);
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailpbaselib.protocol.AILPLoggingProtocol
    public void v(@NonNull String str, @NonNull String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "709536448")) {
            ipChange.ipc$dispatch("709536448", new Object[]{this, str, str2});
        } else {
            log(2, str, str2);
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailpbaselib.protocol.AILPLoggingProtocol
    public void w(@NonNull String str, @NonNull String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2123850849")) {
            ipChange.ipc$dispatch("-2123850849", new Object[]{this, str, str2});
        } else {
            log(5, str, str2);
        }
    }

    public void log(int i, @Nullable String str, @NonNull String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "275316345")) {
            ipChange.ipc$dispatch("275316345", new Object[]{this, Integer.valueOf(i), str, str2});
            return;
        }
        checkNotNull(str2);
        if (TextUtils.isEmpty(str)) {
            str = "NO_TAG";
        }
        Log.println(i, str, str2);
    }
}
