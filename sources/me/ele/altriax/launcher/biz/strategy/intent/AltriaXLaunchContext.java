package me.ele.altriax.launcher.biz.strategy.intent;

import android.content.Intent;
import androidx.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class AltriaXLaunchContext {
    public final Intent intent;
    public final String packageName;
    public final String processName;
    public final String referrer;

    public AltriaXLaunchContext(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Intent intent) {
        this.packageName = str;
        this.processName = str2;
        this.referrer = str3;
        this.intent = intent;
    }
}
