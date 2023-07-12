package com.youku.live.dago.liveplayback.widget.plugins;

import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplugin.base.IPlugin;
import java.lang.reflect.InvocationTargetException;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class LazyLoadingPlugin implements IPlugin {
    private static transient /* synthetic */ IpChange $ipChange;
    private Class[] mArgClasses;
    private Object[] mArguments;
    private IPlugin mInnerPlugin;
    private Class<? extends IPlugin> mInnerPluginClass;

    public LazyLoadingPlugin(Class<? extends IPlugin> cls, Object... objArr) {
        this.mArguments = null;
        this.mArgClasses = null;
        if (cls != null) {
            this.mInnerPlugin = null;
            this.mInnerPluginClass = cls;
            this.mArguments = objArr;
            if (objArr == null) {
                return;
            }
            this.mArgClasses = new Class[objArr.length];
            int i = 0;
            while (true) {
                Object[] objArr2 = this.mArguments;
                if (i >= objArr2.length) {
                    return;
                }
                this.mArgClasses[i] = objArr2[i].getClass();
                i++;
            }
        } else {
            throw new IllegalArgumentException("inner Plugin can not be null");
        }
    }

    private void ensureInnerPlugin() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-252344236")) {
            ipChange.ipc$dispatch("-252344236", new Object[]{this});
        } else if (this.mInnerPlugin == null) {
            synchronized (this) {
                if (this.mInnerPlugin == null) {
                    try {
                        try {
                            try {
                                Object[] objArr = this.mArguments;
                                if (objArr != null && objArr.length > 0) {
                                    this.mInnerPlugin = this.mInnerPluginClass.getConstructor(this.mArgClasses).newInstance(this.mArguments);
                                } else {
                                    this.mInnerPlugin = this.mInnerPluginClass.newInstance();
                                }
                            } catch (NoSuchMethodException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e2) {
                                e2.printStackTrace();
                            }
                        } catch (InstantiationException e3) {
                            e3.printStackTrace();
                        }
                    } catch (IllegalAccessException e4) {
                        e4.printStackTrace();
                    }
                }
            }
        }
    }

    @Override // com.youku.alixplugin.base.IPlugin
    public View getHolderView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2120374854")) {
            return (View) ipChange.ipc$dispatch("-2120374854", new Object[]{this});
        }
        ensureInnerPlugin();
        return this.mInnerPlugin.getHolderView();
    }

    @Override // com.youku.alixplugin.base.IPlugin
    public String getLayerId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "721917739")) {
            return (String) ipChange.ipc$dispatch("721917739", new Object[]{this});
        }
        ensureInnerPlugin();
        return this.mInnerPlugin.getLayerId();
    }

    @Override // com.youku.alixplugin.base.IPlugin
    public int getMajorLevel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2039806545")) {
            return ((Integer) ipChange.ipc$dispatch("2039806545", new Object[]{this})).intValue();
        }
        ensureInnerPlugin();
        return this.mInnerPlugin.getMajorLevel();
    }

    @Override // com.youku.alixplugin.base.IPlugin
    public int getMinorLevel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "179630157")) {
            return ((Integer) ipChange.ipc$dispatch("179630157", new Object[]{this})).intValue();
        }
        ensureInnerPlugin();
        return this.mInnerPlugin.getMinorLevel();
    }

    @Override // com.youku.alixplugin.base.IPlugin
    public String getName() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1797143618")) {
            return (String) ipChange.ipc$dispatch("1797143618", new Object[]{this});
        }
        ensureInnerPlugin();
        return this.mInnerPlugin.getName();
    }

    @Override // com.youku.alixplugin.base.IPlugin
    public boolean isActive() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-498190689")) {
            return ((Boolean) ipChange.ipc$dispatch("-498190689", new Object[]{this})).booleanValue();
        }
        ensureInnerPlugin();
        return this.mInnerPlugin.isActive();
    }

    @Override // com.youku.alixplugin.base.IPlugin
    public boolean isAttached() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1661992895")) {
            return ((Boolean) ipChange.ipc$dispatch("-1661992895", new Object[]{this})).booleanValue();
        }
        ensureInnerPlugin();
        return this.mInnerPlugin.isAttached();
    }

    @Override // com.youku.alixplugin.base.IPlugin
    public boolean isEnable() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1334336766")) {
            return ((Boolean) ipChange.ipc$dispatch("-1334336766", new Object[]{this})).booleanValue();
        }
        ensureInnerPlugin();
        return this.mInnerPlugin.isEnable();
    }

    @Override // com.youku.alixplugin.base.IPlugin
    public void onAvailabilityChanged(boolean z, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1417056268")) {
            ipChange.ipc$dispatch("-1417056268", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i)});
            return;
        }
        ensureInnerPlugin();
        this.mInnerPlugin.onAvailabilityChanged(z, i);
    }

    @Override // com.youku.alixplugin.base.IPlugin
    public void onCreate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1313520688")) {
            ipChange.ipc$dispatch("-1313520688", new Object[]{this});
            return;
        }
        ensureInnerPlugin();
        this.mInnerPlugin.onCreate();
    }

    @Override // com.youku.alixplugin.base.IPlugin
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1972248252")) {
            ipChange.ipc$dispatch("-1972248252", new Object[]{this});
            return;
        }
        ensureInnerPlugin();
        this.mInnerPlugin.onDestroy();
    }

    @Override // com.youku.alixplugin.base.IPlugin
    public void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-684592612")) {
            ipChange.ipc$dispatch("-684592612", new Object[]{this});
            return;
        }
        ensureInnerPlugin();
        this.mInnerPlugin.onStart();
    }

    @Override // com.youku.alixplugin.base.IPlugin
    public void onStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1514733770")) {
            ipChange.ipc$dispatch("1514733770", new Object[]{this});
            return;
        }
        ensureInnerPlugin();
        this.mInnerPlugin.onStop();
    }

    @Override // com.youku.alixplugin.base.IPlugin
    public void release() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1993503400")) {
            ipChange.ipc$dispatch("-1993503400", new Object[]{this});
            return;
        }
        ensureInnerPlugin();
        this.mInnerPlugin.release();
    }

    @Override // com.youku.alixplugin.base.IPlugin
    public void setEnable(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1432153990")) {
            ipChange.ipc$dispatch("-1432153990", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        ensureInnerPlugin();
        this.mInnerPlugin.setEnable(z);
    }
}
