package com.youku.live.widgets.connector;

import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.widgets.ActivityLifecycleState;
import com.youku.live.widgets.protocol.activity.IActivityBackPressedListener;
import com.youku.live.widgets.protocol.activity.IActivityConfigurationChangedListener;
import com.youku.live.widgets.protocol.activity.IActivityConfigurationOrientationChangedListener;
import com.youku.live.widgets.protocol.activity.IActivityKeyDownListener;
import com.youku.live.widgets.protocol.activity.IActivityLifecycleStateChangedListener;
import com.youku.live.widgets.protocol.activity.IActivityLowMemoryListener;
import com.youku.live.widgets.protocol.activity.IActivityRequestPermissionsResultListener;
import com.youku.live.widgets.protocol.activity.IActivityResultListener;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class EngineListenerConnector implements IActivityBackPressedListener, IActivityConfigurationChangedListener, IActivityConfigurationOrientationChangedListener, IActivityKeyDownListener, IActivityLifecycleStateChangedListener, IActivityLowMemoryListener, IActivityRequestPermissionsResultListener, IActivityResultListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<IActivityBackPressedListener> mActivityBackPressedListeners;
    private List<IActivityConfigurationChangedListener> mActivityConfigurationChangedListeners;
    private List<IActivityConfigurationOrientationChangedListener> mActivityConfigurationOrientationChangedListeners;
    private List<IActivityKeyDownListener> mActivityKeyDownListeners;
    private List<IActivityLifecycleStateChangedListener> mActivityLifecycleStateChangedListeners;
    private List<IActivityLowMemoryListener> mActivityLowMemoryListeners;
    private List<IActivityRequestPermissionsResultListener> mActivityRequestPermissionsResultListeners;
    private List<IActivityResultListener> mActivityResultListeners;

    public void clear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "827969954")) {
            ipChange.ipc$dispatch("827969954", new Object[]{this});
            return;
        }
        getActivityBackPressedListeners().clear();
        getActivityConfigurationChangedListeners().clear();
        getActivityConfigurationOrientationChangedListeners().clear();
        getActivityLifecycleStateChangedListeners().clear();
        getActivityLowMemoryListeners().clear();
        getActivityRequestPermissionsResultListeners().clear();
        getActivityResultListeners().clear();
        getActivityKeyDownListeners().clear();
    }

    public List<IActivityBackPressedListener> getActivityBackPressedListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "132421377")) {
            return (List) ipChange.ipc$dispatch("132421377", new Object[]{this});
        }
        if (this.mActivityBackPressedListeners == null) {
            synchronized (this) {
                if (this.mActivityBackPressedListeners == null) {
                    this.mActivityBackPressedListeners = new CopyOnWriteArrayList();
                }
            }
        }
        return this.mActivityBackPressedListeners;
    }

    public List<IActivityConfigurationChangedListener> getActivityConfigurationChangedListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1747466440")) {
            return (List) ipChange.ipc$dispatch("1747466440", new Object[]{this});
        }
        if (this.mActivityConfigurationChangedListeners == null) {
            synchronized (this) {
                if (this.mActivityConfigurationChangedListeners == null) {
                    this.mActivityConfigurationChangedListeners = new CopyOnWriteArrayList();
                }
            }
        }
        return this.mActivityConfigurationChangedListeners;
    }

    public List<IActivityConfigurationOrientationChangedListener> getActivityConfigurationOrientationChangedListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1058269954")) {
            return (List) ipChange.ipc$dispatch("1058269954", new Object[]{this});
        }
        if (this.mActivityConfigurationOrientationChangedListeners == null) {
            synchronized (this) {
                if (this.mActivityConfigurationOrientationChangedListeners == null) {
                    this.mActivityConfigurationOrientationChangedListeners = new CopyOnWriteArrayList();
                }
            }
        }
        return this.mActivityConfigurationOrientationChangedListeners;
    }

    public List<IActivityKeyDownListener> getActivityKeyDownListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-257519013")) {
            return (List) ipChange.ipc$dispatch("-257519013", new Object[]{this});
        }
        if (this.mActivityKeyDownListeners == null) {
            synchronized (this) {
                if (this.mActivityKeyDownListeners == null) {
                    this.mActivityKeyDownListeners = new CopyOnWriteArrayList();
                }
            }
        }
        return this.mActivityKeyDownListeners;
    }

    public List<IActivityLifecycleStateChangedListener> getActivityLifecycleStateChangedListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-184269361")) {
            return (List) ipChange.ipc$dispatch("-184269361", new Object[]{this});
        }
        if (this.mActivityLifecycleStateChangedListeners == null) {
            synchronized (this) {
                if (this.mActivityLifecycleStateChangedListeners == null) {
                    this.mActivityLifecycleStateChangedListeners = new CopyOnWriteArrayList();
                }
            }
        }
        return this.mActivityLifecycleStateChangedListeners;
    }

    public List<IActivityLowMemoryListener> getActivityLowMemoryListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "867313991")) {
            return (List) ipChange.ipc$dispatch("867313991", new Object[]{this});
        }
        if (this.mActivityLowMemoryListeners == null) {
            synchronized (this) {
                if (this.mActivityLowMemoryListeners == null) {
                    this.mActivityLowMemoryListeners = new CopyOnWriteArrayList();
                }
            }
        }
        return this.mActivityLowMemoryListeners;
    }

    public List<IActivityRequestPermissionsResultListener> getActivityRequestPermissionsResultListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2121149364")) {
            return (List) ipChange.ipc$dispatch("2121149364", new Object[]{this});
        }
        if (this.mActivityRequestPermissionsResultListeners == null) {
            synchronized (this) {
                if (this.mActivityRequestPermissionsResultListeners == null) {
                    this.mActivityRequestPermissionsResultListeners = new CopyOnWriteArrayList();
                }
            }
        }
        return this.mActivityRequestPermissionsResultListeners;
    }

    public List<IActivityResultListener> getActivityResultListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1224397079")) {
            return (List) ipChange.ipc$dispatch("-1224397079", new Object[]{this});
        }
        if (this.mActivityResultListeners == null) {
            synchronized (this) {
                if (this.mActivityResultListeners == null) {
                    this.mActivityResultListeners = new CopyOnWriteArrayList();
                }
            }
        }
        return this.mActivityResultListeners;
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityBackPressedListener
    public boolean onActivityBackPressed() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "898136486")) {
            return ((Boolean) ipChange.ipc$dispatch("898136486", new Object[]{this})).booleanValue();
        }
        Iterator<IActivityBackPressedListener> it = getActivityBackPressedListeners().iterator();
        while (it.hasNext() && !(z = it.next().onActivityBackPressed())) {
        }
        return z;
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityConfigurationChangedListener
    public void onActivityConfigurationChanged(Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-439202303")) {
            ipChange.ipc$dispatch("-439202303", new Object[]{this, configuration});
            return;
        }
        for (IActivityConfigurationChangedListener iActivityConfigurationChangedListener : getActivityConfigurationChangedListeners()) {
            iActivityConfigurationChangedListener.onActivityConfigurationChanged(configuration);
        }
        if (configuration != null) {
            onActivityConfigurationOrientationChanged(configuration.orientation);
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityConfigurationOrientationChangedListener
    public void onActivityConfigurationOrientationChanged(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1125173440")) {
            ipChange.ipc$dispatch("-1125173440", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        for (IActivityConfigurationOrientationChangedListener iActivityConfigurationOrientationChangedListener : getActivityConfigurationOrientationChangedListeners()) {
            iActivityConfigurationOrientationChangedListener.onActivityConfigurationOrientationChanged(i);
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityKeyDownListener
    public boolean onActivityKeyDown(int i, KeyEvent keyEvent) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-577854503")) {
            return ((Boolean) ipChange.ipc$dispatch("-577854503", new Object[]{this, Integer.valueOf(i), keyEvent})).booleanValue();
        }
        Iterator<IActivityKeyDownListener> it = getActivityKeyDownListeners().iterator();
        while (it.hasNext() && !(z = it.next().onActivityKeyDown(i, keyEvent))) {
        }
        return z;
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityLifecycleStateChangedListener
    public void onActivityLifecycleStateChanged(ActivityLifecycleState activityLifecycleState) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1182510900")) {
            ipChange.ipc$dispatch("-1182510900", new Object[]{this, activityLifecycleState});
            return;
        }
        for (IActivityLifecycleStateChangedListener iActivityLifecycleStateChangedListener : getActivityLifecycleStateChangedListeners()) {
            iActivityLifecycleStateChangedListener.onActivityLifecycleStateChanged(activityLifecycleState);
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityLowMemoryListener
    public void onActivityLowMemory() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1317320408")) {
            ipChange.ipc$dispatch("-1317320408", new Object[]{this});
            return;
        }
        for (IActivityLowMemoryListener iActivityLowMemoryListener : getActivityLowMemoryListeners()) {
            iActivityLowMemoryListener.onActivityLowMemory();
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityRequestPermissionsResultListener
    public void onActivityRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-280781307")) {
            ipChange.ipc$dispatch("-280781307", new Object[]{this, Integer.valueOf(i), strArr, iArr});
            return;
        }
        for (IActivityRequestPermissionsResultListener iActivityRequestPermissionsResultListener : getActivityRequestPermissionsResultListeners()) {
            iActivityRequestPermissionsResultListener.onActivityRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityResultListener
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1515214835")) {
            ipChange.ipc$dispatch("-1515214835", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        for (IActivityResultListener iActivityResultListener : getActivityResultListeners()) {
            iActivityResultListener.onActivityResult(i, i2, intent);
        }
    }
}
