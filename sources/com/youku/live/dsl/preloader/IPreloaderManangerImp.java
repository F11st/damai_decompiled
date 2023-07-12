package com.youku.live.dsl.preloader;

import android.content.Context;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.liveplayback.widget.preload.PlayerPreloader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class IPreloaderManangerImp implements IPreloaderMananger {
    private static transient /* synthetic */ IpChange $ipChange;
    private static IPreloaderManangerImp sInstance;
    private Map<String, IPreloader> preloaderMananger;

    private IPreloaderManangerImp() {
    }

    private IPreloader createPreloaderIfNotExists(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "473338057")) {
            return (IPreloader) ipChange.ipc$dispatch("473338057", new Object[]{this, str});
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        IPreloader iPreloader = getPreloaderMananger().get(str);
        if (iPreloader == null) {
            synchronized (this) {
                iPreloader = getPreloaderMananger().get(str);
                if (iPreloader == null) {
                    iPreloader = new ILivePayControlPreloader();
                    getPreloaderMananger().put(str, iPreloader);
                }
            }
        }
        return iPreloader;
    }

    public static IPreloaderMananger getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1077348753")) {
            return (IPreloaderMananger) ipChange.ipc$dispatch("-1077348753", new Object[0]);
        }
        if (sInstance == null) {
            synchronized (IPreloaderManangerImp.class) {
                if (sInstance == null) {
                    sInstance = new IPreloaderManangerImp();
                }
            }
        }
        return sInstance;
    }

    private Map<String, IPreloader> getPreloaderMananger() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-415753835")) {
            return (Map) ipChange.ipc$dispatch("-415753835", new Object[]{this});
        }
        if (this.preloaderMananger == null) {
            synchronized (this) {
                if (this.preloaderMananger == null) {
                    this.preloaderMananger = new ConcurrentHashMap();
                }
            }
        }
        return this.preloaderMananger;
    }

    private IPreloader getPreloaderOnly(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1529575691")) {
            return (IPreloader) ipChange.ipc$dispatch("-1529575691", new Object[]{this, str});
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return getPreloaderMananger().get(str);
    }

    @Override // com.youku.live.dsl.preloader.IPreloaderMananger
    public IPreloader createLivePlayControlPreloader(String str, String str2, Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1089752646")) {
            return (IPreloader) ipChange.ipc$dispatch("1089752646", new Object[]{this, str, str2, context});
        }
        IPreloader createPreloaderIfNotExists = createPreloaderIfNotExists(str);
        if (createPreloaderIfNotExists instanceof ILivePayControlPreloader) {
            ((ILivePayControlPreloader) createPreloaderIfNotExists).async(str, str2, context);
        }
        return createPreloaderIfNotExists;
    }

    @Override // com.youku.live.dsl.preloader.IPreloaderMananger
    public boolean createPlayerPreloader() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2085972488") ? ((Boolean) ipChange.ipc$dispatch("2085972488", new Object[]{this})).booleanValue() : PlayerPreloader.getInstance() != null;
    }

    @Override // com.youku.live.dsl.preloader.IPreloaderMananger
    public IPreloader getLivePlayControlPreloader(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1614991682")) {
            return (IPreloader) ipChange.ipc$dispatch("1614991682", new Object[]{this, str});
        }
        IPreloader preloaderOnly = getPreloaderOnly(str);
        if (preloaderOnly instanceof ILivePayControlPreloader) {
            ILivePayControlPreloader iLivePayControlPreloader = (ILivePayControlPreloader) preloaderOnly;
            if (iLivePayControlPreloader.isTimeout()) {
                iLivePayControlPreloader.removeSelf();
                return null;
            }
            return preloaderOnly;
        }
        return preloaderOnly;
    }

    public IPreloader removePreloader(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "699985727") ? (IPreloader) ipChange.ipc$dispatch("699985727", new Object[]{this, str}) : getPreloaderMananger().remove(str);
    }
}
