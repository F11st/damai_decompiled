package com.youku.live.dago.widgetlib.ailproom;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.ailpchat.ConnectState;
import com.youku.live.dago.widgetlib.ailpchat.IChatConnection;
import com.youku.live.dago.widgetlib.ailpchat.MessageDelegate;
import com.youku.live.dago.widgetlib.ailplive.LiveManager;
import com.youku.live.dago.widgetlib.ailproom.callback.ResultCallback;
import com.youku.live.dago.widgetlib.ailproom.config.ILRoomConfiguration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class AbsInteractLiveManager {
    private static transient /* synthetic */ IpChange $ipChange;
    public String mRoomId = "";
    public String mSessionId = "";
    public String mUniqueKey = "";
    public AbsILRoom room = null;
    public static ConcurrentMap<String, AbsInteractLiveManager> managers = new ConcurrentHashMap();
    public static ConcurrentMap<String, LiveManager.LiveChangeListener> liveImListeners = new ConcurrentHashMap();

    public static AbsInteractLiveManager getInstance(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1038946199")) {
            return (AbsInteractLiveManager) ipChange.ipc$dispatch("1038946199", new Object[]{str, str2});
        }
        String str3 = str + str2;
        new InteractLiveManager(str, str2).setLiveListener(liveImListeners.get(str3));
        managers.putIfAbsent(str3, new InteractLiveManager(str, str2));
        return managers.get(str3);
    }

    public abstract void addMessageListener(MessageDelegate messageDelegate);

    public abstract void createRoom(String str, String str2, ILRoomConfiguration iLRoomConfiguration, ResultCallback resultCallback);

    public abstract String getRoomID();

    public abstract ConnectState getRoomState();

    public abstract void joinRoom(String str, String str2, ILRoomConfiguration iLRoomConfiguration);

    public abstract void joinRoom(String str, String str2, ILRoomConfiguration iLRoomConfiguration, ResultCallback resultCallback);

    public void leave() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1415652990")) {
            ipChange.ipc$dispatch("1415652990", new Object[]{this});
            return;
        }
        ConcurrentMap<String, AbsInteractLiveManager> concurrentMap = managers;
        if (concurrentMap.containsKey(this.mRoomId + this.mSessionId)) {
            ConcurrentMap<String, AbsInteractLiveManager> concurrentMap2 = managers;
            concurrentMap2.remove(this.mRoomId + this.mSessionId);
        }
        ConcurrentMap<String, LiveManager.LiveChangeListener> concurrentMap3 = liveImListeners;
        if (concurrentMap3.containsKey(this.mRoomId + this.mSessionId)) {
            ConcurrentMap<String, LiveManager.LiveChangeListener> concurrentMap4 = liveImListeners;
            concurrentMap4.remove(this.mRoomId + this.mSessionId);
        }
    }

    public abstract void linkRoom(String str, ResultCallback resultCallback);

    public abstract void quitRoom();

    public abstract void quitRoomNative();

    public abstract void sendMessage(Map<String, Object> map, ResultCallback resultCallback);

    public abstract void setChatRoomListener(IChatConnection.WeexMessageListener weexMessageListener);

    public abstract void setLiveListener(LiveManager.LiveChangeListener liveChangeListener);

    public abstract void switchRoom(String str, ILRoomConfiguration iLRoomConfiguration, ResultCallback resultCallback);
}
