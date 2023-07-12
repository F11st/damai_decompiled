package com.youku.live.livesdk.wkit.plugin;

import android.content.Intent;
import android.content.res.Configuration;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import com.youku.live.livesdk.constants.ScreenConstants;
import com.youku.live.widgets.impl.BasePlugin;
import com.youku.live.widgets.protocol.ISystemEvent;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ScreenPlugin extends BasePlugin implements ScreenConstants, ISystemEvent {
    private static transient /* synthetic */ IpChange $ipChange;
    String currentAngleORIENTATION = null;

    private void broadcastOrientation(Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "83754780")) {
            ipChange.ipc$dispatch("83754780", new Object[]{this, map});
        } else {
            getEngineInstance().asyncPutData("OrientationChange", map);
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityBackPressedListener
    public boolean onActivityBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1448276969")) {
            return ((Boolean) ipChange.ipc$dispatch("1448276969", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityConfigurationChangedListener
    public void onActivityConfigurationChanged(Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1805602876")) {
            ipChange.ipc$dispatch("-1805602876", new Object[]{this, configuration});
        } else {
            setScreenType(configuration);
        }
    }

    @Override // com.youku.live.widgets.protocol.ISystemEvent
    public void onActivityDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-489315770")) {
            ipChange.ipc$dispatch("-489315770", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityLowMemoryListener
    public void onActivityLowMemory() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "269842475")) {
            ipChange.ipc$dispatch("269842475", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityResumeStateChangedListener
    public void onActivityPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1571049866")) {
            ipChange.ipc$dispatch("1571049866", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityRequestPermissionsResultListener
    public void onActivityRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-677206814")) {
            ipChange.ipc$dispatch("-677206814", new Object[]{this, Integer.valueOf(i), strArr, iArr});
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityResultListener
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1223342678")) {
            ipChange.ipc$dispatch("-1223342678", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityResumeStateChangedListener
    public void onActivityResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1189275203")) {
            ipChange.ipc$dispatch("-1189275203", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityStartStateChangedListener
    public void onActivityStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1614154654")) {
            ipChange.ipc$dispatch("1614154654", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityStartStateChangedListener
    public void onActivityStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2004528904")) {
            ipChange.ipc$dispatch("2004528904", new Object[]{this});
        }
    }

    public void setScreenType(Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1423690790")) {
            ipChange.ipc$dispatch("1423690790", new Object[]{this, configuration});
            return;
        }
        int i = configuration.orientation;
        if (this.currentAngleORIENTATION == null) {
            this.currentAngleORIENTATION = i == 1 ? "portrait" : "landscapeLeft";
        }
        HashMap hashMap = new HashMap();
        if (i == 1) {
            if (!this.currentAngleORIENTATION.equals("portrait") && !this.currentAngleORIENTATION.equals("portraitUpsideDown")) {
                this.currentAngleORIENTATION = "portrait";
                hashMap.put("orientation", "portrait");
            } else {
                hashMap.put("orientation", this.currentAngleORIENTATION);
            }
            ((ILog) Dsl.getService(ILog.class)).e("fornia", "orientation 000 fireGlobalEventCallback AILPOrientationChange params:" + hashMap.get("orientation"));
            broadcastOrientation(hashMap);
            return;
        }
        if (!this.currentAngleORIENTATION.equals("landscapeRight") && !this.currentAngleORIENTATION.equals("landscapeLeft")) {
            this.currentAngleORIENTATION = "landscapeLeft";
            hashMap.put("orientation", "landscapeLeft");
        } else {
            hashMap.put("orientation", this.currentAngleORIENTATION);
        }
        ((ILog) Dsl.getService(ILog.class)).e("fornia", "orientation 111 fireGlobalEventCallback AILPOrientationChange params:" + hashMap.get("orientation"));
        broadcastOrientation(hashMap);
    }

    @Override // com.youku.live.widgets.protocol.ISystemEvent
    public boolean systemEventFilter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1973805043")) {
            return ((Boolean) ipChange.ipc$dispatch("1973805043", new Object[]{this})).booleanValue();
        }
        return true;
    }
}
