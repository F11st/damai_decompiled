package com.youku.live.messagechannel.conf;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class OrangeConfKey {
    public static KeyInfo maxPullmsgDistributeCnt = new KeyInfo("maxPullmsgDistributeCnt", "300");
    public static KeyInfo minPullInterval = new KeyInfo("minPullInterval", "10");
    public static KeyInfo heartBeatInterval = new KeyInfo("heartBeatInterval", "60");
    public static KeyInfo cdnExpireInterval = new KeyInfo("cdnExpireInterval", "300");
    public static KeyInfo closePull = new KeyInfo("closePull", "0");
    public static KeyInfo closeHeartBeat = new KeyInfo("closeHeartBeat", "0");
    public static KeyInfo closeDataReport = new KeyInfo("closeDataReport", "0");
    public static KeyInfo closeHighDiscardMsgDataReport = new KeyInfo("closeHighDiscardMsgDataReport", "0");
    public static KeyInfo maxMemCacheCount = new KeyInfo("maxMemCacheCount", "10000");
    public static KeyInfo maxDiskCacheCount = new KeyInfo("maxDiskCacheCount", "1000");
    public static KeyInfo closeMemCache = new KeyInfo("closeMemCache", "0");
    public static KeyInfo closeDiskCache = new KeyInfo("closeDiskCache", "0");
    public static KeyInfo diskCleanInterval = new KeyInfo("diskCleanInterval", "60");
    public static KeyInfo reportDistributeInterval = new KeyInfo("reportDistributeInterval", "60");
    public static KeyInfo callbackWaitTime = new KeyInfo("callbackWaitTime", "10");
    public static KeyInfo storeMarkMessageCount = new KeyInfo("storeMarkMessageCount", "600");
    public static KeyInfo reportMarkMessageCount = new KeyInfo("reportMarkMessageCount", "30");
    public static KeyInfo closeAppMonitorStoreMarkMessageOverflowReport = new KeyInfo("closeAppMonitorStoreMarkMessageOverflowReport", "0");
    public static KeyInfo closeAppMonitorHeartBeatReport = new KeyInfo("closeAppMonitorHeartBeatReport", "0");
    public static KeyInfo appMonitorHeartBeatInterval = new KeyInfo("appMonitorHeartBeatInterval", "30");
    public static KeyInfo closeAccsMassCloseSupplySubscribe = new KeyInfo("closeAccsMassCloseSupplySubscribe", "0");
    public static KeyInfo connectionsLaunchTimeout = new KeyInfo("connectionsLaunchTimeout", "3");
    public static KeyInfo frontBackHelperStartDelay = new KeyInfo("frontBackHelperStartDelay", "1");
    public static KeyInfo accsYoukuConnectHost = new KeyInfo("accsYoukuConnectHost", "msgacs.youku.com");
    public static KeyInfo accsH5ReconnectInterval = new KeyInfo("accsH5ReconnectInterval", "2");
    public static KeyInfo accsH5ReconnectRetryMaxCount = new KeyInfo("accsH5ReconnectRetryMaxCount", "5");
    public static KeyInfo accsH5PingInterval = new KeyInfo("accsH5PingInterval", "20");
    public static KeyInfo accsH5SelfCheckInterval = new KeyInfo("accsH5SelfCheckInterval", "60");
    public static KeyInfo accsH5ConnectWssTimeOut = new KeyInfo("accsH5ConnectWssTimeOut", "2");

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public class Group {
        public static final String android_youku_messagechannel = "android_youku_messagechannel";

        public Group() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class KeyInfo {
        public String def;
        public String name;

        public KeyInfo(String str, String str2) {
            this.name = str;
            this.def = str2;
        }
    }
}
