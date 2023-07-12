package com.youku.live.livesdk.widgets.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class LaifengRoomInfoData implements Serializable {
    public Map<String, String> _extra;
    public AnchorData anchor;
    public IMData im;
    public RoomData room;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class AnchorData implements Serializable {
        public String faceUrl;
        public Long id;
        public String nickName;
        public String posterUrl;
        public Long ytid;
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class IMData implements Serializable {
        public String gate;
        public String token;
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class RollMsg implements Serializable {
        public String content;
        public Long id;
        public Long pattern;
        public Long status;
        public String title;
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class RoomData implements Serializable {
        public Long cid;
        public String cname;
        public Boolean horizontalScreen;
        public Long id;
        public Boolean joinMic;
        public Integer liveStatus;
        public String notice;
        public Boolean pk;
        public List<RollMsg> rollMsg;
        public String roomDescInfo;
        public Long screenId;
        public Long showId;
        public Long startTime;
        public Boolean status;
        public Boolean supportSwitchMic;
        public String theme;
        public Integer type;
        public Boolean useRtp;
    }
}
