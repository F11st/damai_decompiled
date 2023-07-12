package me.ele.altriax.launcher.real.time.data.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import java.util.Map;
import tb.qf2;
import tb.rf0;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IUniversalRealTime {
    void setApmEvents(@Nullable List<rf0> list);

    void setApmProperties(@Nullable Map<String, Object> map);

    void setApmStages(@Nullable List<qf2> list);

    void setApmStart();

    void setApmStats(@Nullable Map<String, Object> map);

    void setBizEvent(@NonNull String str, @NonNull String str2);

    void setBizTime(@NonNull String str, long j);

    void setDagEnd();

    void setDagStart();

    void setFirstInstall(boolean z);

    void setFirstLaunch(boolean z);

    void setHomeStart();

    void setLaunchType(@Nullable String str);

    void setLauncherResumeTime();

    void setLauncherStartTime();

    void setMAC(long j);

    void setMAHead(long j);

    void setMATail(long j);

    void setMFront(long j);

    void setMLaunch(long j);

    void setRenderComplete(long j);

    void setRenderComplete(long j, long j2);
}
