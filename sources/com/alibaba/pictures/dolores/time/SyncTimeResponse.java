package com.alibaba.pictures.dolores.time;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/alibaba/pictures/dolores/time/SyncTimeResponse;", "Ljava/io/Serializable;", "", "t", "Ljava/lang/String;", "getT", "()Ljava/lang/String;", "setT", "(Ljava/lang/String;)V", "<init>", "()V", "dolores_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public final class SyncTimeResponse implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String t;

    @Nullable
    public final String getT() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-931401484") ? (String) ipChange.ipc$dispatch("-931401484", new Object[]{this}) : this.t;
    }

    public final void setT(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "503731202")) {
            ipChange.ipc$dispatch("503731202", new Object[]{this, str});
        } else {
            this.t = str;
        }
    }
}
