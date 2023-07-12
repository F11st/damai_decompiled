package com.youku.live.livesdk.widgets.plugin.channel;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.widgets.protocol.IDestroyable;
import com.youku.live.widgets.protocol.IResult;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ChannelListenersMananger implements IDestroyable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String MSG_TYPE_ALL = "*";
    private volatile boolean mDestroyed = false;
    private ConcurrentHashMap<String, CopyOnWriteArrayList<IResult>> mMsgTypeResultListeners;

    private ConcurrentHashMap<String, CopyOnWriteArrayList<IResult>> getMsgTypeResultListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1486771151")) {
            return (ConcurrentHashMap) ipChange.ipc$dispatch("1486771151", new Object[]{this});
        }
        if (this.mMsgTypeResultListeners == null) {
            synchronized (this) {
                if (this.mMsgTypeResultListeners == null) {
                    this.mMsgTypeResultListeners = new ConcurrentHashMap<>();
                }
            }
        }
        return this.mMsgTypeResultListeners;
    }

    private CopyOnWriteArrayList<IResult> getResultListenersByMsgType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2035012653")) {
            return (CopyOnWriteArrayList) ipChange.ipc$dispatch("-2035012653", new Object[]{this, str});
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return getMsgTypeResultListeners().get(str);
    }

    @Override // com.youku.live.widgets.protocol.IDestroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-538216806")) {
            ipChange.ipc$dispatch("-538216806", new Object[]{this});
        } else if (this.mDestroyed) {
        } else {
            synchronized (this) {
                if (!this.mDestroyed) {
                    this.mDestroyed = true;
                    ConcurrentHashMap<String, CopyOnWriteArrayList<IResult>> concurrentHashMap = this.mMsgTypeResultListeners;
                    if (concurrentHashMap != null) {
                        concurrentHashMap.clear();
                        this.mMsgTypeResultListeners = null;
                    }
                }
            }
        }
    }

    public void processMessage(String str, Map<String, Object> map) {
        CopyOnWriteArrayList<IResult> resultListenersByMsgType;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2045773667")) {
            ipChange.ipc$dispatch("-2045773667", new Object[]{this, str, map});
        } else if (TextUtils.isEmpty(str) || map == null) {
        } else {
            if (!"*".equals(str) && (resultListenersByMsgType = getResultListenersByMsgType(str)) != null) {
                Iterator<IResult> it = resultListenersByMsgType.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().onResult(map);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
            CopyOnWriteArrayList<IResult> resultListenersByMsgType2 = getResultListenersByMsgType("*");
            if (resultListenersByMsgType2 != null) {
                Iterator<IResult> it2 = resultListenersByMsgType2.iterator();
                while (it2.hasNext()) {
                    try {
                        it2.next().onResult(map);
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
            }
        }
    }

    public boolean putResultListenersByMsgType(String str, IResult iResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-31682950")) {
            return ((Boolean) ipChange.ipc$dispatch("-31682950", new Object[]{this, str, iResult})).booleanValue();
        }
        synchronized (this) {
            if (this.mDestroyed) {
                return false;
            }
            if (!TextUtils.isEmpty(str) && iResult != null) {
                ConcurrentHashMap<String, CopyOnWriteArrayList<IResult>> msgTypeResultListeners = getMsgTypeResultListeners();
                if (msgTypeResultListeners == null) {
                    return false;
                }
                CopyOnWriteArrayList<IResult> copyOnWriteArrayList = msgTypeResultListeners.get(str);
                if (copyOnWriteArrayList == null) {
                    copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                    msgTypeResultListeners.put(str, copyOnWriteArrayList);
                }
                return copyOnWriteArrayList.add(iResult);
            }
            return false;
        }
    }

    public synchronized boolean removeResultListenersByMsgType(String str, IResult iResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1607581965")) {
            return ((Boolean) ipChange.ipc$dispatch("1607581965", new Object[]{this, str, iResult})).booleanValue();
        } else if (TextUtils.isEmpty(str)) {
            return false;
        } else {
            ConcurrentHashMap<String, CopyOnWriteArrayList<IResult>> msgTypeResultListeners = getMsgTypeResultListeners();
            if (msgTypeResultListeners == null) {
                return false;
            }
            CopyOnWriteArrayList<IResult> copyOnWriteArrayList = msgTypeResultListeners.get(str);
            if (copyOnWriteArrayList != null) {
                return copyOnWriteArrayList.remove(iResult);
            }
            return false;
        }
    }
}
