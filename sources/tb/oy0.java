package tb;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.core.ut.TrackProxy;
import cn.damai.tetris.core.ut.TrackType;
import cn.damai.uikit.snake.ScrollTitleBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class oy0 extends cn.damai.common.user.b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String HOME_PAGE = "home";
    public static final String WELCOME_PAGE = "welcome";
    private static oy0 b;

    public static oy0 B() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1128425349")) {
            return (oy0) ipChange.ipc$dispatch("-1128425349", new Object[0]);
        }
        if (b == null) {
            b = new oy0();
        }
        return b;
    }

    private void f(TrackInfo trackInfo, Map map, TrackType trackType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-928776951")) {
            ipChange.ipc$dispatch("-928776951", new Object[]{this, trackInfo, map, trackType});
        } else if (trackInfo == null) {
        } else {
            String string = trackInfo.getString("ABTrackInfo");
            if (trackType == TrackType.click) {
                map.put("PreABTrackInfo", string);
            }
            map.put("ABTrackInfo", string);
            map.putAll(trackInfo.getArgsMap());
        }
    }

    public void A(TrackInfo trackInfo, String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1697132770")) {
            ipChange.ipc$dispatch("1697132770", new Object[]{this, trackInfo, str, str2, Integer.valueOf(i)});
        } else if (trackInfo == null) {
        } else {
            HashMap<String, String> g = d23.g();
            g.put("city", z20.d() + "市");
            g.put("titlelabel", str2);
            TrackType trackType = TrackType.click;
            f(trackInfo, g, trackType);
            TrackProxy.ITrack a = TrackProxy.a();
            String str3 = trackInfo.trackB;
            String str4 = trackInfo.trackC;
            a.userTrack(trackType, null, str3, str4, "tab_" + i, g, false);
        }
    }

    public void C(TrackInfo trackInfo, View view, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1928000489")) {
            ipChange.ipc$dispatch("-1928000489", new Object[]{this, trackInfo, view, str});
        } else if (trackInfo == null) {
        } else {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("contentlabel", str);
                TrackType trackType = TrackType.expose;
                f(trackInfo, hashMap, trackType);
                TrackProxy.a().userTrack(trackType, view, trackInfo.trackB, trackInfo.trackC, "suggestmessage", hashMap, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void D(TrackInfo trackInfo, View view, String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1559410941")) {
            ipChange.ipc$dispatch("1559410941", new Object[]{this, trackInfo, view, str, str2, Integer.valueOf(i)});
        } else if (trackInfo == null) {
        } else {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("city", z20.d() + "市");
                hashMap.put("titlelabel", str);
                hashMap.put("contentlabel", str2);
                TrackType trackType = TrackType.expose;
                f(trackInfo, hashMap, trackType);
                TrackProxy.ITrack a = TrackProxy.a();
                String str3 = trackInfo.trackB;
                String str4 = trackInfo.trackC;
                a.userTrack(trackType, view, str3, str4, "item_" + i, hashMap, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void E(TrackInfo trackInfo, View view, boolean z, String str, String str2, String str3, String str4, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-55283468")) {
            ipChange.ipc$dispatch("-55283468", new Object[]{this, trackInfo, view, Boolean.valueOf(z), str, str2, str3, str4, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (trackInfo == null) {
        } else {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("city", z20.d() + "市");
                hashMap.put("titlelabel", "必看排行榜");
                hashMap.put("contentlabel", str);
                hashMap.put("alg", str2);
                hashMap.put("scm", str3);
                if (z) {
                    hashMap.put("ranklist_id", str4);
                    hashMap.put(pb.PRE_CONTENT_ID, str4);
                    hashMap.put(pb.PRE_CONTENT_TYPE, "ranklist");
                } else {
                    hashMap.put("item_id", str4);
                }
                TrackType trackType = TrackType.expose;
                f(trackInfo, hashMap, trackType);
                TrackProxy.ITrack a = TrackProxy.a();
                String str5 = trackInfo.trackB;
                String str6 = trackInfo.trackC;
                a.userTrack(trackType, view, str5, str6, "ranklist_item_" + i, hashMap, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void F(TrackInfo trackInfo, View view, String str, String str2, String str3, String str4, String str5, int i, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "543783285")) {
            ipChange.ipc$dispatch("543783285", new Object[]{this, trackInfo, view, str, str2, str3, str4, str5, Integer.valueOf(i), map});
        } else if (trackInfo == null) {
        } else {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("city", z20.d() + "市");
                hashMap.put("titlelabel", str);
                hashMap.put("contentlabel", str2 + "&" + str3);
                hashMap.put("alg", str4);
                hashMap.put("item_id", str5);
                if (map != null) {
                    hashMap.putAll(map);
                }
                TrackType trackType = TrackType.expose;
                f(trackInfo, hashMap, trackType);
                TrackProxy.ITrack a = TrackProxy.a();
                String str6 = trackInfo.trackB;
                String str7 = trackInfo.trackC;
                a.userTrack(trackType, view, str6, str7, "item_" + i, hashMap, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void G(TrackInfo trackInfo, View view, TextView textView, String str, int i, int i2, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-277150611")) {
            ipChange.ipc$dispatch("-277150611", new Object[]{this, trackInfo, view, textView, str, Integer.valueOf(i), Integer.valueOf(i2), map});
            return;
        }
        try {
            HashMap<String, String> f = d23.f();
            f.put("item_id", str);
            TrackType trackType = TrackType.expose;
            f(trackInfo, f, trackType);
            TrackProxy.a().userTrack(trackType, view, trackInfo.trackB, trackInfo.trackC + "list_tab_" + i2, "item_" + i, f, true);
            HashMap<String, String> f2 = d23.f();
            f2.put("item_id", str);
            f(trackInfo, f2, trackType);
            if (map != null) {
                f2.putAll(map);
            }
            TrackProxy.a().userTrack(trackType, textView, trackInfo.trackB, trackInfo.trackC + "list_tab_" + i2, "favorite_" + i, f2, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void H(TrackInfo trackInfo, View view, List<ScrollTitleBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-293981049")) {
            ipChange.ipc$dispatch("-293981049", new Object[]{this, trackInfo, view, list});
        } else if (trackInfo != null) {
            for (int i = 0; i < list.size(); i++) {
                HashMap<String, String> g = d23.g();
                g.put("city", z20.d() + "市");
                g.put("titlelabel", list.get(i).name);
                TrackType trackType = TrackType.expose;
                f(trackInfo, g, trackType);
                TrackProxy.ITrack a = TrackProxy.a();
                String str = trackInfo.trackB;
                String str2 = trackInfo.trackC;
                a.userTrack(trackType, view, str, str2, "tab_" + i, g, false);
            }
        }
    }

    public void I(View view, String str, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "899031239")) {
            ipChange.ipc$dispatch("899031239", new Object[]{this, view, str, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", z20.d());
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("contentlabel", str);
        }
        TrackProxy.a().userTrack(TrackType.expose, view, "home", "activitybanner_" + i, "item_" + i2, hashMap, false);
    }

    public void J(TrackInfo trackInfo, View view, String str, String str2, String str3, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-741098444")) {
            ipChange.ipc$dispatch("-741098444", new Object[]{this, trackInfo, view, str, str2, str3, Integer.valueOf(i)});
        } else if (trackInfo == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("city", z20.d() + "市");
            hashMap.put("titlelabel", str);
            hashMap.put("biz_id", str2);
            hashMap.put("item_id", str3);
            TrackType trackType = TrackType.expose;
            f(trackInfo, hashMap, trackType);
            TrackProxy.ITrack a = TrackProxy.a();
            String str4 = trackInfo.trackB;
            String str5 = trackInfo.trackC;
            a.userTrack(trackType, view, str4, str5, "item_" + i, hashMap, false);
        }
    }

    public void K(TrackInfo trackInfo, View view, String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1997414769")) {
            ipChange.ipc$dispatch("1997414769", new Object[]{this, trackInfo, view, str, str2, Integer.valueOf(i)});
        } else if (trackInfo == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("city", z20.d() + "市");
            hashMap.put("titlelabel", str);
            hashMap.put("biz_id", str2);
            TrackType trackType = TrackType.expose;
            f(trackInfo, hashMap, trackType);
            TrackProxy.ITrack a = TrackProxy.a();
            String str3 = trackInfo.trackB;
            String str4 = trackInfo.trackC;
            a.userTrack(trackType, view, str3, str4, "card_" + i, hashMap, false);
        }
    }

    public void L(TrackInfo trackInfo, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "71105511")) {
            ipChange.ipc$dispatch("71105511", new Object[]{this, trackInfo, view});
        } else if (trackInfo == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("city", z20.d() + "市");
            hashMap.put("titlelabel", "大咖在大麦");
            TrackType trackType = TrackType.expose;
            f(trackInfo, hashMap, trackType);
            TrackProxy.a().userTrack(trackType, view, trackInfo.trackB, trackInfo.trackC, "all", hashMap, false);
        }
    }

    public void M(TrackInfo trackInfo, View view, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1804200487")) {
            ipChange.ipc$dispatch("1804200487", new Object[]{this, trackInfo, view, str, Integer.valueOf(i)});
        } else if (trackInfo == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("city", z20.d() + "市");
            hashMap.put("titlelabel", "直击现场");
            hashMap.put("item_id", str);
            TrackType trackType = TrackType.expose;
            f(trackInfo, hashMap, trackType);
            TrackProxy.ITrack a = TrackProxy.a();
            String str2 = trackInfo.trackB;
            String str3 = trackInfo.trackC;
            a.userTrack(trackType, view, str2, str3, "item_" + i, hashMap, false);
        }
    }

    public void N(TrackInfo trackInfo, View view, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1702339137")) {
            ipChange.ipc$dispatch("1702339137", new Object[]{this, trackInfo, view, str, Integer.valueOf(i)});
        } else if (trackInfo == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("city", z20.d() + "市");
            hashMap.put("titlelabel", "直击现场");
            hashMap.put("item_id", str);
            TrackType trackType = TrackType.expose;
            f(trackInfo, hashMap, trackType);
            TrackProxy.ITrack a = TrackProxy.a();
            String str2 = trackInfo.trackB;
            String str3 = trackInfo.trackC;
            a.userTrack(trackType, view, str2, str3, "buy_item_" + i, hashMap, false);
        }
    }

    public void O(TrackInfo trackInfo, View view, VideoInfo videoInfo, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1105482935")) {
            ipChange.ipc$dispatch("1105482935", new Object[]{this, trackInfo, view, videoInfo, str});
        } else if (trackInfo == null || videoInfo == null) {
        } else {
            String vid = videoInfo.getVid();
            if (TextUtils.isEmpty(vid)) {
                vid = videoInfo.getVideoUrl();
            }
            HashMap hashMap = new HashMap();
            hashMap.put("city", z20.d() + "市");
            hashMap.put("titlelabel", "直击现场");
            hashMap.put("video_id", vid);
            hashMap.put("item_id", str);
            hashMap.put(pb.PRE_CONTENT_ID, vid);
            hashMap.put(pb.PRE_CONTENT_TYPE, "video");
            TrackType trackType = TrackType.expose;
            f(trackInfo, hashMap, trackType);
            TrackProxy.a().userTrack(trackType, view, trackInfo.trackB, trackInfo.trackC, "video", hashMap, false);
        }
    }

    public void P(String str, String str2, String str3, String str4, VideoInfo videoInfo, long j, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "424527002")) {
            ipChange.ipc$dispatch("424527002", new Object[]{this, str, str2, str3, str4, videoInfo, Long.valueOf(j), str5});
        } else if (videoInfo == null) {
        } else {
            HashMap<String, String> g = d23.g();
            d23.h(g, "item_id", str4);
            if (!TextUtils.isEmpty(videoInfo.getVid())) {
                d23.h(g, "videoId", videoInfo.getVid());
            } else {
                d23.h(g, "videoId", videoInfo.getVideoUrl());
            }
            d23.h(g, "videoTitle", videoInfo.getTitle());
            d23.h(g, "duration", j + "");
            d23.h(g, "spm-url", "a2o4t." + str + "." + str2 + ".playend");
            d23.h(g, "play_session_id", str5);
            cn.damai.common.user.c e = cn.damai.common.user.c.e();
            e.D(str, "page_" + str + "_playend", "playend", "", g, 12003);
        }
    }

    public void Q(String str, String str2, String str3, String str4, VideoInfo videoInfo, boolean z, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "673625219")) {
            ipChange.ipc$dispatch("673625219", new Object[]{this, str, str2, str3, str4, videoInfo, Boolean.valueOf(z), str5});
        } else if (videoInfo == null) {
        } else {
            HashMap<String, String> g = d23.g();
            d23.h(g, "item_id", str4);
            if (!TextUtils.isEmpty(videoInfo.getVid())) {
                d23.h(g, "videoId", videoInfo.getVid());
            } else {
                d23.h(g, "videoId", videoInfo.getVideoUrl());
            }
            d23.h(g, "videoTitle", videoInfo.getTitle());
            d23.h(g, "is_auto_play", z ? "1" : "0");
            d23.h(g, "spm-url", "a2o4t." + str + "." + str2 + ".playstart");
            d23.h(g, "play_session_id", str5);
            cn.damai.common.user.c e = cn.damai.common.user.c.e();
            e.D(str, "page_" + str + "_playstart", "playstart", "", g, 12002);
        }
    }

    public void R(String str, String str2, String str3, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2109970001")) {
            ipChange.ipc$dispatch("-2109970001", new Object[]{this, str, str2, str3, Integer.valueOf(i)});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", z20.d() + "市");
        hashMap.put("video_id", str3);
        hashMap.put("status", i + "");
        TrackProxy.a().userTrack(TrackType.click, null, str, str2, "volumn", hashMap, false);
    }

    public void g(String str, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-123536482")) {
            ipChange.ipc$dispatch("-123536482", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", z20.d());
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("contentlabel", str);
        }
        TrackProxy.a().userTrack(TrackType.click, null, "home", "activitybanner_" + i, "item_" + i2, hashMap, true);
    }

    public void h(TrackInfo trackInfo, String str, String str2, String str3, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-300795694")) {
            ipChange.ipc$dispatch("-300795694", new Object[]{this, trackInfo, str, str2, str3, Integer.valueOf(i)});
        } else if (trackInfo == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("city", z20.d() + "市");
            hashMap.put("titlelabel", str);
            hashMap.put("contentlabel", str2);
            hashMap.put("scm", str3);
            TrackType trackType = TrackType.click;
            f(trackInfo, hashMap, trackType);
            TrackProxy.ITrack a = TrackProxy.a();
            String str4 = trackInfo.trackB;
            String str5 = trackInfo.trackC;
            a.userTrack(trackType, null, str4, str5, "item_" + i, hashMap, true);
        }
    }

    public void i(TrackInfo trackInfo, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1691836329")) {
            ipChange.ipc$dispatch("1691836329", new Object[]{this, trackInfo, str, Integer.valueOf(i)});
        } else if (trackInfo == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("city", z20.d() + "市");
            hashMap.put("titlelabel", "直击现场");
            hashMap.put("item_id", str);
            TrackType trackType = TrackType.click;
            f(trackInfo, hashMap, trackType);
            TrackProxy.ITrack a = TrackProxy.a();
            String str2 = trackInfo.trackB;
            String str3 = trackInfo.trackC;
            a.userTrack(trackType, null, str2, str3, "item_" + i, hashMap, true);
        }
    }

    public void j(TrackInfo trackInfo, String str, String str2, int i, int i2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "73076581")) {
            ipChange.ipc$dispatch("73076581", new Object[]{this, trackInfo, str, str2, Integer.valueOf(i), Integer.valueOf(i2), str3});
        } else if (trackInfo == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("city", z20.d() + "市");
            hashMap.put("titlelabel", "必看排行榜");
            hashMap.put("contentlabel", str);
            hashMap.put("alg", str2);
            TrackType trackType = TrackType.click;
            f(trackInfo, hashMap, trackType);
            TrackProxy.ITrack a = TrackProxy.a();
            String str4 = trackInfo.trackB;
            String str5 = trackInfo.trackC;
            a.userTrack(trackType, null, str4, str5, "ranklist_item_" + i2, hashMap, true);
        }
    }

    public void k(TrackInfo trackInfo, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1233242238")) {
            ipChange.ipc$dispatch("1233242238", new Object[]{this, trackInfo, str});
        } else if (trackInfo == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("city", z20.d() + "市");
            hashMap.put("titlelabel", str);
            TrackType trackType = TrackType.click;
            f(trackInfo, hashMap, trackType);
            TrackProxy.a().userTrack(trackType, null, trackInfo.trackB, trackInfo.trackC, "square", hashMap, true);
        }
    }

    public void l(TrackInfo trackInfo, String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "885666715")) {
            ipChange.ipc$dispatch("885666715", new Object[]{this, trackInfo, str, str2, Integer.valueOf(i)});
        } else if (trackInfo == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("city", z20.d() + "市");
            hashMap.put("titlelabel", str);
            hashMap.put("contentlabel", str2);
            TrackType trackType = TrackType.click;
            f(trackInfo, hashMap, trackType);
            TrackProxy.ITrack a = TrackProxy.a();
            String str3 = trackInfo.trackB;
            String str4 = trackInfo.trackC;
            a.userTrack(trackType, null, str3, str4, "mustsee_tab_" + i, hashMap, false);
        }
    }

    public void m(TrackInfo trackInfo, String str, String str2, String str3, String str4, String str5, int i, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1514710373")) {
            ipChange.ipc$dispatch("1514710373", new Object[]{this, trackInfo, str, str2, str3, str4, str5, Integer.valueOf(i), map});
        } else if (trackInfo == null) {
        } else {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("city", z20.d() + "市");
                hashMap.put("titlelabel", str);
                hashMap.put("contentlabel", str2 + "&" + str3);
                hashMap.put("item_id", str5);
                hashMap.put("scm", str4);
                if (map != null) {
                    hashMap.putAll(map);
                }
                TrackType trackType = TrackType.click;
                f(trackInfo, hashMap, trackType);
                TrackProxy.ITrack a = TrackProxy.a();
                String str6 = trackInfo.trackB;
                String str7 = trackInfo.trackC;
                a.userTrack(trackType, null, str6, str7, "item_" + i, hashMap, true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void n(TrackInfo trackInfo, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1411877863")) {
            ipChange.ipc$dispatch("-1411877863", new Object[]{this, trackInfo, str});
        } else if (trackInfo == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("city", z20.d() + "市");
            hashMap.put("titlelabel", str);
            TrackType trackType = TrackType.click;
            f(trackInfo, hashMap, trackType);
            TrackProxy.a().userTrack(trackType, null, trackInfo.trackB, trackInfo.trackC, "calendar", hashMap, true);
        }
    }

    public void o(TrackInfo trackInfo, String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1878675250")) {
            ipChange.ipc$dispatch("-1878675250", new Object[]{this, trackInfo, str, str2, Integer.valueOf(i)});
        } else if (trackInfo == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("city", z20.d() + "市");
            hashMap.put("titlelabel", str);
            hashMap.put("contentlabel", str2);
            TrackType trackType = TrackType.click;
            f(trackInfo, hashMap, trackType);
            TrackProxy.ITrack a = TrackProxy.a();
            String str3 = trackInfo.trackB;
            String str4 = trackInfo.trackC;
            a.userTrack(trackType, null, str3, str4, "recent_tab_" + i, hashMap, false);
        }
    }

    public void p(TrackInfo trackInfo, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "384858598")) {
            ipChange.ipc$dispatch("384858598", new Object[]{this, trackInfo, str});
        } else if (trackInfo == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("city", z20.d() + "市");
            hashMap.put("contentlabel", str);
            TrackType trackType = TrackType.click;
            f(trackInfo, hashMap, trackType);
            TrackProxy.a().userTrack(trackType, null, trackInfo.trackB, trackInfo.trackC, "suggestmessage", hashMap, false);
        }
    }

    public void q(TrackInfo trackInfo, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "546738876")) {
            ipChange.ipc$dispatch("546738876", new Object[]{this, trackInfo, str});
        } else if (trackInfo == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("city", z20.d() + "市");
            hashMap.put("titlelabel", str);
            TrackType trackType = TrackType.click;
            f(trackInfo, hashMap, trackType);
            TrackProxy.a().userTrack(trackType, null, trackInfo.trackB, trackInfo.trackC, "all", hashMap, true);
        }
    }

    public void r(TrackInfo trackInfo, String str, String str2, String str3, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "172804139")) {
            ipChange.ipc$dispatch("172804139", new Object[]{this, trackInfo, str, str2, str3, Integer.valueOf(i)});
        } else if (trackInfo == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("city", z20.d() + "市");
            hashMap.put("titlelabel", str);
            hashMap.put("biz_id", str2);
            hashMap.put("item_id", str3);
            TrackType trackType = TrackType.click;
            f(trackInfo, hashMap, trackType);
            TrackProxy.ITrack a = TrackProxy.a();
            String str4 = trackInfo.trackB;
            String str5 = trackInfo.trackC;
            a.userTrack(trackType, null, str4, str5, "item_" + i, hashMap, true);
        }
    }

    public void s(TrackInfo trackInfo, String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-424140614")) {
            ipChange.ipc$dispatch("-424140614", new Object[]{this, trackInfo, str, str2, Integer.valueOf(i)});
        } else if (trackInfo == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("city", z20.d() + "市");
            hashMap.put("titlelabel", str);
            hashMap.put("biz_id", str2);
            TrackType trackType = TrackType.click;
            f(trackInfo, hashMap, trackType);
            TrackProxy.ITrack a = TrackProxy.a();
            String str3 = trackInfo.trackB;
            String str4 = trackInfo.trackC;
            a.userTrack(trackType, null, str3, str4, "card_" + i, hashMap, true);
        }
    }

    public void t(TrackInfo trackInfo, String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2052586241")) {
            ipChange.ipc$dispatch("-2052586241", new Object[]{this, trackInfo, str, str2, Integer.valueOf(i)});
        } else if (trackInfo == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("city", z20.d() + "市");
            hashMap.put("titlelabel", str);
            hashMap.put("biz_id", str2);
            TrackType trackType = TrackType.click;
            f(trackInfo, hashMap, trackType);
            TrackProxy.ITrack a = TrackProxy.a();
            String str3 = trackInfo.trackB;
            String str4 = trackInfo.trackC;
            a.userTrack(trackType, null, str3, str4, "item_" + i, hashMap, false);
        }
    }

    public void u(TrackInfo trackInfo, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-252956698")) {
            ipChange.ipc$dispatch("-252956698", new Object[]{this, trackInfo, str, Integer.valueOf(i)});
        } else if (trackInfo == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("city", z20.d() + "市");
            hashMap.put("titlelabel", "直击现场");
            hashMap.put("item_id", str);
            TrackType trackType = TrackType.click;
            f(trackInfo, hashMap, trackType);
            TrackProxy.ITrack a = TrackProxy.a();
            String str2 = trackInfo.trackB;
            String str3 = trackInfo.trackC;
            a.userTrack(trackType, null, str2, str3, "buy_item_" + i, hashMap, true);
        }
    }

    public void v(TrackInfo trackInfo, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-254109480")) {
            ipChange.ipc$dispatch("-254109480", new Object[]{this, trackInfo, str, Integer.valueOf(i)});
        } else if (trackInfo == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("city", z20.d() + "市");
            hashMap.put("titlelabel", "直击现场");
            hashMap.put("item_id", str);
            TrackType trackType = TrackType.click;
            f(trackInfo, hashMap, trackType);
            TrackProxy.ITrack a = TrackProxy.a();
            String str2 = trackInfo.trackB;
            String str3 = trackInfo.trackC;
            a.userTrack(trackType, null, str2, str3, "item_" + i, hashMap, false);
        }
    }

    public void w(TrackInfo trackInfo, String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1278817378")) {
            ipChange.ipc$dispatch("1278817378", new Object[]{this, trackInfo, str, str2, Integer.valueOf(i)});
        } else if (trackInfo == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("city", z20.d() + "市");
            hashMap.put("titlelabel", "直击现场");
            hashMap.put("video_id", str);
            hashMap.put("item_id", str2);
            TrackType trackType = TrackType.click;
            f(trackInfo, hashMap, trackType);
            TrackProxy.ITrack a = TrackProxy.a();
            String str3 = trackInfo.trackB;
            String str4 = trackInfo.trackC;
            a.userTrack(trackType, null, str3, str4, "item_video_" + i, hashMap, true);
        }
    }

    public void x(TrackInfo trackInfo, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1202268324")) {
            ipChange.ipc$dispatch("-1202268324", new Object[]{this, trackInfo, str, Integer.valueOf(i)});
        } else if (trackInfo == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("city", z20.d() + "市");
            hashMap.put("titlelabel", "直击现场");
            hashMap.put("video_id", str);
            hashMap.put("status", i + "");
            TrackProxy.a().userTrack(TrackType.click, null, trackInfo.trackB, trackInfo.trackC, "volumn", hashMap, false);
        }
    }

    public void y(TrackInfo trackInfo, String str, int i, int i2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1707313752")) {
            ipChange.ipc$dispatch("-1707313752", new Object[]{this, trackInfo, str, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)});
            return;
        }
        try {
            HashMap<String, String> f = d23.f();
            f.put("item_id", str);
            f.put("type", z ? "1" : "0");
            TrackType trackType = TrackType.click;
            f(trackInfo, f, trackType);
            TrackProxy.a().userTrack(trackType, null, trackInfo.trackB, trackInfo.trackC + "list_tab_" + i, "favorite_" + i2, f, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void z(TrackInfo trackInfo, String str, String str2, int i, int i2, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1310637781")) {
            ipChange.ipc$dispatch("1310637781", new Object[]{this, trackInfo, str, str2, Integer.valueOf(i), Integer.valueOf(i2), map});
            return;
        }
        try {
            HashMap<String, String> f = d23.f();
            f.put("item_id", str);
            f.put("titlelabel", str2);
            if (map != null) {
                f.putAll(map);
            }
            TrackType trackType = TrackType.click;
            f(trackInfo, f, trackType);
            TrackProxy.a().userTrack(trackType, null, trackInfo.trackB, trackInfo.trackC + "list_tab_" + i2, "item_" + i, f, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
