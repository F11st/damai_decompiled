package com.youku.live.dago.widgetlib.model;

import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.model.mtop.data.livefullinfo.ConnectionInfo;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class LiveFullInfo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String adInfo;
    public boolean alibabaNetPlay;
    public String area;
    public String backgroundUrl;
    public String bizExtra;
    public int bizType;
    public String broadcastVideo;
    public String broadcastVideoCode;
    public int broadcastVideoQuailty;
    public String bundleUrl;
    public String categoryId;
    public String categoryName;
    public String changeVideo;
    public ConnectionInfo chatRoomConnectionInfo;
    public String clientIp;
    public int cnWatch;
    public String createTime;
    public List<Tab> customTab;
    public boolean decorate;
    public String description;
    public boolean drm;
    public String endTime;
    public long endTimestamp;
    public int groupId;
    public int hasPostAd;
    public String img916Url;
    public String imgBUrl;
    public String imgMUrl;
    public String imgSUrl;
    public boolean interact;
    public int isPlay;
    public int isRecordOpen;
    public int isTest;
    public String keywords;
    public boolean landScape;
    public String layout;
    public Layout layouts;
    public String linkUrl;
    public String liveId;
    public int liveStatus;
    public String liveUuid;
    public String mediaBackgroundUrl;
    public int memberRight;
    public String name;
    public long now;
    public boolean paid;
    public int playType;
    public String player;
    public String qrCodeUrl;
    public String reviewStatus;
    public String screenId;
    public String sdkBackgroundUrl;
    public String sdkTopBackgroundUrl;
    public String sdkVersion;
    public boolean showCustomTab;
    public String showId;
    public String source;
    public String startTime;
    public long startTimestamp;
    public int state;
    public String templateId;
    public boolean timeShift;
    public String token;
    public String userId;
    public String videoId;
    public String videoUrl;
    public String videoUrlCode;
    public int videoUrlQuality;
    public String widgetShareDescription;
    public String widgetShareImgUrl;
    public String widgetShareTitle;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class BanSubInfo implements Serializable {
        public boolean ban;
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class ChatRoomConnectionInfo implements Serializable {
        public String appId;
        public String bizId;
        public String channelId;
        public JSONObject connectionMode;
        public Ext ext;
        public String protocol;
        public long serverTime;
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class CloseButton implements Serializable {
        public Margin m = new Margin();
        public Size s = new Size();
        public String src;
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class Ext implements Serializable {
        public BanSubInfo banSub4Native;
        public String topic;
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class Layout implements Serializable {
        public static final int Portrait = 2;
        public static final int PortraitOrLandsapce = 26;
        public String bg;
        public boolean pcdnEnable;
        public int pts;
        public PursueVideoFrame pvf;
        public boolean sap;
        public String sb;
        public int sei;
        public int seig;
        public String st;
        public float sw;
        public CloseButton cb = new CloseButton();
        public PlayerView pv = new PlayerView();
        public boolean norv = false;
        public boolean supportedlv = true;
        public int sios = 2;
        public boolean spc = true;
        public boolean spcd = true;
        public int tnr = 0;
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class Margin implements Serializable {
        public float b;
        public float l;
        public float r;
        public float t;
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class PlayerView implements Serializable {
        public Margin m;
        public Size s;

        public PlayerView() {
            Margin margin = new Margin();
            this.m = margin;
            margin.t = 0.0f;
            margin.l = 0.0f;
            margin.b = 0.0f;
            margin.r = 0.0f;
            this.s = new Size();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class PursueVideoFrame implements Serializable {
        public int on = 0;
        public int pbt = 0;
        public int bpbt = 0;
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class Size implements Serializable {
        public float h;
        public float w;
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class Tab implements Serializable {
        public String description;
        public String name;
        public String state;
        public String url;
    }

    private void setModelOne() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1795223778")) {
            ipChange.ipc$dispatch("-1795223778", new Object[]{this});
            return;
        }
        Layout layout = new Layout();
        this.layouts = layout;
        layout.sw = 750.0f;
        CloseButton closeButton = layout.cb;
        closeButton.src = "";
        Margin margin = closeButton.m;
        margin.t = 0.0f;
        margin.l = 0.0f;
        Size size = closeButton.s;
        size.w = 32.0f;
        size.h = 32.0f;
        layout.norv = false;
        PlayerView playerView = layout.pv;
        Margin margin2 = playerView.m;
        margin2.t = 0.0f;
        margin2.l = 0.0f;
        Size size2 = playerView.s;
        size2.w = 750.0f;
        size2.h = 422.0f;
    }

    private void setModelThree() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "891122982")) {
            ipChange.ipc$dispatch("891122982", new Object[]{this});
            return;
        }
        Layout layout = new Layout();
        this.layouts = layout;
        layout.sw = 750.0f;
        CloseButton closeButton = layout.cb;
        closeButton.src = "";
        closeButton.m.t = 0.0f;
        Size size = closeButton.s;
        size.w = 32.0f;
        size.h = 32.0f;
        Margin margin = layout.pv.m;
        margin.t = 175.0f;
        margin.l = 10.0f;
    }

    private void setModelTwo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1643468424")) {
            ipChange.ipc$dispatch("-1643468424", new Object[]{this});
            return;
        }
        Layout layout = new Layout();
        this.layouts = layout;
        layout.sw = 750.0f;
        CloseButton closeButton = layout.cb;
        closeButton.src = "";
        closeButton.m.t = 0.0f;
        Size size = closeButton.s;
        size.w = 32.0f;
        size.h = 32.0f;
        Margin margin = layout.pv.m;
        margin.t = 0.0f;
        margin.l = 0.0f;
    }

    public void setLayoutModel(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1182590227")) {
            ipChange.ipc$dispatch("1182590227", new Object[]{this, Integer.valueOf(i)});
        } else if (i == 1) {
            setModelOne();
        } else if (i == 2) {
            setModelTwo();
        } else if (i != 3) {
        } else {
            setModelThree();
        }
    }
}
