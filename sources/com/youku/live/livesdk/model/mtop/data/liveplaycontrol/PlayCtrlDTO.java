package com.youku.live.livesdk.model.mtop.data.liveplaycontrol;

import com.alibaba.fastjson.JSONArray;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class PlayCtrlDTO implements Serializable {
    public int dfi;
    public boolean horizontalScreen;
    public boolean isShowing;
    public List<MicMessageBodyV2> mcs;
    public String mcuStreamUrl;
    public List<String> po;
    public long roomId;
    public long screenId;
    public List<PlayCtrlDef> tls;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class MicExtraV2 implements Serializable {
        public Integer d;
        public Integer ml;
        public Integer p;
        public Integer sa;
        public Object[] t;
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class MicMessageBodyV2 implements Serializable {

        /* renamed from: me  reason: collision with root package name */
        public MicExtraV2 f1039me;
        public MicStreamV2 ms;
        public MicUserV2 mu;
        public Integer v;
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class MicStreamPlayAbility implements Serializable {
        public JSONArray Artp;
        public JSONArray Hls;
        public JSONArray HttpFlv;
        public JSONArray Rtmp;
        public JSONArray Rtp;
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class MicStreamV2 implements Serializable {
        public Integer apd;
        public Integer hv;
        public String ln;
        public Integer mn;
        public Integer mute;
        public MicStreamPlayAbility playInfo;
        public String psu;
        public String psun;
        public Rtc rtc;
        public Integer st;
        public String tk;
        public Long u;
        public String uk;
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class MicUserV2 implements Serializable {
        public String f;
        public Integer ha = 0;
        public Integer ia;
        public Long ls;
        public String n;
        public Long u;
        public Long ytid;
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class PlayCtrlDef implements Serializable {
        public int idx;
        public String title;
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class Rtc implements Serializable {
        public String apd;
        public String cnn;
        public List<String> gslb;
        public String non;
        public String tk;
        public long ts;
        public String u;
    }
}
