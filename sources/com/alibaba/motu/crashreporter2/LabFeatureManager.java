package com.alibaba.motu.crashreporter2;

import android.content.Context;
import android.os.Build;
import com.alibaba.motu.crashreporter.Configuration;
import com.alibaba.motu.crashreporter.ignores.FakeFinallzeExceptionIgnore;
import com.alibaba.motu.crashreporter2.Utils;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class LabFeatureManager {
    CatcherManager mCatcherManager;
    Configuration mConfiguration;
    Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LabFeatureManager(Context context, Configuration configuration, CatcherManager catcherManager) {
        this.mContext = context;
        this.mConfiguration = configuration;
        this.mCatcherManager = catcherManager;
        if (configuration.getBoolean(Configuration.enableFinalizeFake, true)) {
            this.mCatcherManager.addUncaughtExceptionIgnore(new FakeFinallzeExceptionIgnore());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void disable() {
        if (!this.mConfiguration.getBoolean(Configuration.disableJitCompilation, true) || Build.VERSION.SDK_INT >= 21) {
            return;
        }
        Utils.VMRuntimeUtils.startJitCompilation();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void enable() {
        if (!this.mConfiguration.getBoolean(Configuration.disableJitCompilation, true) || Build.VERSION.SDK_INT >= 21) {
            return;
        }
        Utils.VMRuntimeUtils.disableJitCompilation();
    }
}
