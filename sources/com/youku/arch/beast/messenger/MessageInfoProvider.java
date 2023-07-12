package com.youku.arch.beast.messenger;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.beast.BeastZygote;
import com.youku.util.Logger;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class MessageInfoProvider {
    private static transient /* synthetic */ IpChange $ipChange;
    private static MessageInfoProvider sProvider;
    public ConcurrentHashMap<BeastZygote.Type, MessageInfoPlugin> mPluginMap;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static abstract class MessageInfoPlugin {
        public boolean dying = false;

        public abstract EventInfo getInfo();
    }

    private MessageInfoProvider() {
        ConcurrentHashMap<BeastZygote.Type, MessageInfoPlugin> concurrentHashMap = new ConcurrentHashMap<>();
        this.mPluginMap = concurrentHashMap;
        concurrentHashMap.put(BeastZygote.Type.LIVE, new MessageInfoPlugin() { // from class: com.youku.arch.beast.messenger.MessageInfoProvider.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.arch.beast.messenger.MessageInfoProvider.MessageInfoPlugin
            public EventInfo getInfo() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2047858465")) {
                    return (EventInfo) ipChange.ipc$dispatch("-2047858465", new Object[]{this});
                }
                return null;
            }
        });
        this.mPluginMap.put(BeastZygote.Type.VOD, new MessageInfoPlugin() { // from class: com.youku.arch.beast.messenger.MessageInfoProvider.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.arch.beast.messenger.MessageInfoProvider.MessageInfoPlugin
            public EventInfo getInfo() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1354465760")) {
                    return (EventInfo) ipChange.ipc$dispatch("-1354465760", new Object[]{this});
                }
                return null;
            }
        });
    }

    public static MessageInfoProvider getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1816841093")) {
            return (MessageInfoProvider) ipChange.ipc$dispatch("-1816841093", new Object[0]);
        }
        if (sProvider == null) {
            synchronized (MessageInfoProvider.class) {
                if (sProvider == null) {
                    sProvider = new MessageInfoProvider();
                }
            }
        }
        return sProvider;
    }

    public EventInfo getPluginInfo(BeastZygote.Type type) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2101421458")) {
            return (EventInfo) ipChange.ipc$dispatch("2101421458", new Object[]{this, type});
        }
        EventInfo info = this.mPluginMap.get(type).getInfo();
        if (this.mPluginMap.get(type).dying) {
            Logger.d("beastLib", "dying last msg");
            this.mPluginMap.put(type, new MessageInfoPlugin() { // from class: com.youku.arch.beast.messenger.MessageInfoProvider.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.arch.beast.messenger.MessageInfoProvider.MessageInfoPlugin
                public EventInfo getInfo() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-661073055")) {
                        return (EventInfo) ipChange2.ipc$dispatch("-661073055", new Object[]{this});
                    }
                    return null;
                }
            });
        }
        return info;
    }

    public void registerPlugin(BeastZygote.Type type, MessageInfoPlugin messageInfoPlugin) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1052307257")) {
            ipChange.ipc$dispatch("-1052307257", new Object[]{this, type, messageInfoPlugin});
        } else {
            this.mPluginMap.put(type, messageInfoPlugin);
        }
    }

    public void unregisterPlugin(BeastZygote.Type type) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1089199786")) {
            ipChange.ipc$dispatch("1089199786", new Object[]{this, type});
        } else {
            this.mPluginMap.get(type).dying = true;
        }
    }
}
