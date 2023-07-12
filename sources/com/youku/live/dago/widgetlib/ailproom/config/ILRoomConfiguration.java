package com.youku.live.dago.widgetlib.ailproom.config;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ILRoomConfiguration {
    public ChatRoomConfiguration chatRoomConfiguration;
    public LiveConfiguration liveConfiguration;
    public String roomId = "";
    public String mtopAppKey = "";
    public String licence = "";

    public ILRoomConfiguration() {
        this.chatRoomConfiguration = null;
        this.liveConfiguration = null;
        this.liveConfiguration = new LiveConfiguration();
        this.chatRoomConfiguration = new ChatRoomConfiguration();
    }
}
