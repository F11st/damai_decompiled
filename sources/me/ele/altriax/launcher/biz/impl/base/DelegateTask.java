package me.ele.altriax.launcher.biz.impl.base;

import android.app.Application;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import java.util.HashMap;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;
import me.ele.altriax.launcher.common.AltriaXLog;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class DelegateTask<D> implements Task {
    @Nullable
    public abstract D getDelegate(@NonNull Application application);

    public abstract String getName();

    public void init(@NonNull Application application, @NonNull HashMap<String, Object> hashMap) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        String name = getName();
        AltriaXLog.v(AltriaXLog.ALTRIAX, AltriaXLog.formatLog(AltriaXLog.ALTRIAX, name, ExifInterface.LATITUDE_SOUTH, SystemClock.elapsedRealtime() + ""));
        delegateInit(application, hashMap);
        long elapsedRealtime2 = SystemClock.elapsedRealtime();
        String name2 = getName();
        AltriaXLog.v(AltriaXLog.ALTRIAX, AltriaXLog.formatLog(AltriaXLog.ALTRIAX, name2, ExifInterface.LONGITUDE_EAST, SystemClock.elapsedRealtime() + AltriaXLaunchTime.SPACE + (elapsedRealtime2 - elapsedRealtime) + "ms"));
    }
}
