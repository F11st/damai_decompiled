package me.ele.altriax.launcher.real.time.data.core;

import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IELRealTime extends IELUniversalRealTime, IUniversalRealTime {
    void setH5ActivityStart();

    void setHomeStart();

    void setLoadUrlStart(@NonNull String str);

    void setPageFinished(@NonNull String str);

    void setT1End(@NonNull String str);
}
