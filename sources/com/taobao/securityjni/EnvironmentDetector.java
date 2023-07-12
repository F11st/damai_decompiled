package com.taobao.securityjni;

import android.content.ContextWrapper;
import com.taobao.wireless.security.sdk.SecurityGuardManager;
import com.taobao.wireless.security.sdk.rootdetect.IRootDetectComponent;
import com.taobao.wireless.security.sdk.simulatordetect.ISimulatorDetectComponent;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes11.dex */
public class EnvironmentDetector {
    private ContextWrapper context;

    public EnvironmentDetector(ContextWrapper contextWrapper) {
        this.context = contextWrapper;
    }

    public boolean isRoot() {
        IRootDetectComponent rootDetectComp = SecurityGuardManager.getInstance(this.context).getRootDetectComp();
        if (rootDetectComp != null) {
            return rootDetectComp.isRoot();
        }
        return false;
    }

    public boolean isSimulator() {
        ISimulatorDetectComponent simulatorDetectComp = SecurityGuardManager.getInstance(this.context).getSimulatorDetectComp();
        if (simulatorDetectComp != null) {
            return simulatorDetectComp.isSimulator();
        }
        return false;
    }
}
