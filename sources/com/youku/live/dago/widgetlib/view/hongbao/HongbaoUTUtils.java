package com.youku.live.dago.widgetlib.view.hongbao;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import com.youku.live.dsl.usertrack.IUserTracker;
import com.youku.live.widgets.WidgetSDKEngine;
import com.youku.live.widgets.protocol.Orientation;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class HongbaoUTUtils {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static int CLICK_EVENT = 2101;
    public static int EXPOSE_EVENT = 2201;
    public static String PAGENAME = "page_laifeng_room";
    public static String SPM_AB = "";
    public static boolean VIDEO_LANDSCAPE;

    public static void awardHongbaoAttentionClick(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2104117056")) {
            ipChange.ipc$dispatch("2104117056", new Object[]{str, str2, str3});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i("hongbaoUT", "awardHongbaoAttentionClick");
        HashMap hashMap = new HashMap();
        hashMap.put("spm", SPM_AB + ".redenvelope.followbutton");
        hashMap.put("direction", getDirection());
        hashMap.put("anchor-id", str);
        hashMap.put("roomid", str2);
        hashMap.put("screenid", str3);
        ((IUserTracker) Dsl.getService(IUserTracker.class)).track4Click(PAGENAME, "redenvelope_followbutton", hashMap);
    }

    public static void awardHongbaoAttentionExpose(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-50197830")) {
            ipChange.ipc$dispatch("-50197830", new Object[]{str, str2, str3});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i("hongbaoUT", "awardHongbaoAttentionExpose");
        HashMap hashMap = new HashMap();
        hashMap.put("spm", SPM_AB + ".redenvelope.followbutton");
        hashMap.put("direction", getDirection());
        hashMap.put("anchor-id", str);
        hashMap.put("roomid", str2);
        hashMap.put("screenid", str3);
        ((IUserTracker) Dsl.getService(IUserTracker.class)).trackCustom(PAGENAME, EXPOSE_EVENT, "redenvelope_followbutton", "", "", hashMap);
    }

    public static void awardHongbaoClick(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-182713932")) {
            ipChange.ipc$dispatch("-182713932", new Object[]{str, str2, str3});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i("hongbaoUT", "awardHongbaoClick");
        HashMap hashMap = new HashMap();
        hashMap.put("spm", SPM_AB + ".redenvelope.cover");
        hashMap.put("direction", getDirection());
        hashMap.put("anchor-id", str);
        hashMap.put("roomid", str2);
        hashMap.put("screenid", str3);
        ((IUserTracker) Dsl.getService(IUserTracker.class)).track4Click(PAGENAME, "redenvelope_cover", hashMap);
    }

    public static void awardHongbaoExitClick(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-990246414")) {
            ipChange.ipc$dispatch("-990246414", new Object[]{str, str2, str3});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i("hongbaoUT", "awardHongbaoExitClick");
        HashMap hashMap = new HashMap();
        hashMap.put("spm", SPM_AB + ".redenvelope.exitbutton");
        hashMap.put("direction", getDirection());
        hashMap.put("anchor-id", str);
        hashMap.put("roomid", str2);
        hashMap.put("screenid", str3);
        ((IUserTracker) Dsl.getService(IUserTracker.class)).track4Click(PAGENAME, "redenvelope_exitbutton", hashMap);
    }

    public static void awardHongbaoExitExpose(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1486184888")) {
            ipChange.ipc$dispatch("-1486184888", new Object[]{str, str2, str3});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i("hongbaoUT", "awardHongbaoExitExpose");
        HashMap hashMap = new HashMap();
        hashMap.put("spm", SPM_AB + ".redenvelope.exitbutton");
        hashMap.put("direction", getDirection());
        hashMap.put("anchor-id", str);
        hashMap.put("roomid", str2);
        hashMap.put("screenid", str3);
        ((IUserTracker) Dsl.getService(IUserTracker.class)).trackCustom(PAGENAME, EXPOSE_EVENT, "redenvelope_exitbutton", "", "", hashMap);
    }

    public static void awardHongbaoExpose(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2072485574")) {
            ipChange.ipc$dispatch("2072485574", new Object[]{str, str2, str3});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i("hongbaoUT", "awardHongbaoExpose");
        HashMap hashMap = new HashMap();
        hashMap.put("spm", SPM_AB + ".redenvelope.cover");
        hashMap.put("direction", getDirection());
        hashMap.put("anchor-id", str);
        hashMap.put("roomid", str2);
        hashMap.put("screenid", str3);
        ((IUserTracker) Dsl.getService(IUserTracker.class)).trackCustom(PAGENAME, EXPOSE_EVENT, "redenvelope_cover", "", "", hashMap);
    }

    public static void awardHongbaoGetClick(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-245446472")) {
            ipChange.ipc$dispatch("-245446472", new Object[]{str, str2, str3});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i("hongbaoUT", "awardHongbaoGetClick");
        HashMap hashMap = new HashMap();
        hashMap.put("spm", SPM_AB + ".redenvelope.receivebutton");
        hashMap.put("direction", getDirection());
        hashMap.put("anchor-id", str);
        hashMap.put("roomid", str2);
        hashMap.put("screenid", str3);
        ((IUserTracker) Dsl.getService(IUserTracker.class)).track4Click(PAGENAME, "redenvelope_receivebutton", hashMap);
    }

    public static void awardHongbaoGetExpose(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "127776834")) {
            ipChange.ipc$dispatch("127776834", new Object[]{str, str2, str3});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i("hongbaoUT", "awardHongbaoGetExpose");
        HashMap hashMap = new HashMap();
        hashMap.put("spm", SPM_AB + ".redenvelope.receivebutton");
        hashMap.put("direction", getDirection());
        hashMap.put("anchor-id", str);
        hashMap.put("roomid", str2);
        hashMap.put("screenid", str3);
        ((IUserTracker) Dsl.getService(IUserTracker.class)).trackCustom(PAGENAME, EXPOSE_EVENT, "redenvelope_receivebutton", "", "", hashMap);
    }

    public static void awardHongbaoKnownClick(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2064357925")) {
            ipChange.ipc$dispatch("2064357925", new Object[]{str, str2, str3});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i("hongbaoUT", "awardHongbaoKnownClick");
        HashMap hashMap = new HashMap();
        hashMap.put("spm", SPM_AB + ".redenvelope.knownbutton");
        hashMap.put("direction", getDirection());
        hashMap.put("anchor-id", str);
        hashMap.put("roomid", str2);
        hashMap.put("screenid", str3);
        ((IUserTracker) Dsl.getService(IUserTracker.class)).track4Click(PAGENAME, "redenvelope_knownbutton", hashMap);
    }

    public static void awardHongbaoKnownExpose(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1282730891")) {
            ipChange.ipc$dispatch("-1282730891", new Object[]{str, str2, str3});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i("hongbaoUT", "awardHongbaoKnownExpose");
        HashMap hashMap = new HashMap();
        hashMap.put("spm", SPM_AB + ".redenvelope.knownbutton");
        hashMap.put("direction", getDirection());
        hashMap.put("anchor-id", str);
        hashMap.put("roomid", str2);
        hashMap.put("screenid", str3);
        ((IUserTracker) Dsl.getService(IUserTracker.class)).trackCustom(PAGENAME, EXPOSE_EVENT, "redenvelope_knownbutton", "", "", hashMap);
    }

    private static String getDirection() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1676854422") ? (String) ipChange.ipc$dispatch("-1676854422", new Object[0]) : WidgetSDKEngine.getOrientation() == Orientation.ORIENTATION_LANDSCAPE ? "fplayer" : VIDEO_LANDSCAPE ? "vhplayer" : "vplayer";
    }

    public static void smallHongbaoClick(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2123583818")) {
            ipChange.ipc$dispatch("2123583818", new Object[]{str, str2, str3});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i("hongbaoUT", "smallHongbaoClick " + getDirection());
        HashMap hashMap = new HashMap();
        hashMap.put("spm", SPM_AB + ".redenvelope.ornament");
        hashMap.put("direction", getDirection());
        hashMap.put("anchor-id", str);
        hashMap.put("roomid", str2);
        hashMap.put("screenid", str3);
        ((IUserTracker) Dsl.getService(IUserTracker.class)).track4Click(PAGENAME, "redenvelope_ornament", hashMap);
    }

    public static void smallHongbaoExpose(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "553271792")) {
            ipChange.ipc$dispatch("553271792", new Object[]{str, str2, str3});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i("hongbaoUT", "smallHongbaoExpose");
        HashMap hashMap = new HashMap();
        hashMap.put("spm", SPM_AB + ".redenvelope.ornament");
        hashMap.put("direction", getDirection());
        hashMap.put("anchor-id", str);
        hashMap.put("roomid", str2);
        hashMap.put("screenid", str3);
        ((IUserTracker) Dsl.getService(IUserTracker.class)).trackCustom(PAGENAME, EXPOSE_EVENT, "redenvelope_ornament", "", "", hashMap);
    }
}
