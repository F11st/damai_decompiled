package tb;

import android.util.Log;
import cn.damai.common.AppConfig;
import cn.damai.common.util.ToastUtil;
import cn.damai.tetris.component.common.AccountAlbumContract;
import cn.damai.tetris.component.rank.RankFilterPlugin;
import cn.damai.tetris.componentplugin.AnchorFloatingPlugin;
import cn.damai.tetris.componentplugin.DiscoverFeedPlugin;
import cn.damai.tetris.componentplugin.FilterPanelPlugin;
import cn.damai.tetris.componentplugin.MusicFestivalPlugin;
import cn.damai.tetris.componentplugin.ProjectFilterPlugin;
import cn.damai.tetris.componentplugin.VerticalDramaByMonthPlugin;
import cn.damai.tetris.componentplugin.VoteCardPlugin;
import cn.damai.tetris.core.nav.NavigatorProxy;
import cn.damai.tetris.core.ut.TrackProxy;
import cn.damai.tetris.v2.componentplugin.ComponentPlugin;
import cn.damai.tetris.v2.componentplugin.ComponentPluginType;
import cn.damai.tetris.v2.util.LocalDxTemplate;
import cn.damai.uikit.image.C2497a;
import cn.damai.uikit.image.IImageLoader;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class yl2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(ja jaVar) {
        DinamicXEngine dXEngine;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1041116136")) {
            ipChange.ipc$dispatch("-1041116136", new Object[]{jaVar});
            return;
        }
        try {
            if (!AppConfig.v() || jaVar == null) {
                return;
            }
            List<String> d = m90.d();
            if (cb2.d(d) || (dXEngine = jaVar.getDXEngine()) == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            for (String str : d) {
                DXTemplateItem b = m90.b(str);
                DXTemplateItem h = dXEngine.h(b);
                if (h == null || !h.isPreset || h.version != b.version) {
                    hashMap.put(str, b);
                    StringBuilder sb = new StringBuilder();
                    String str2 = h != null ? ": name=" + h.name + " version=" + h.version + " isPreset=" + h.isPreset : "空~";
                    sb.append("无法映射的cms组件：");
                    sb.append(str);
                    sb.append(",需要的是：name=");
                    sb.append(b.name);
                    sb.append(" version=");
                    sb.append(b.version);
                    sb.append(";但DxEngine返回的是");
                    sb.append(str2);
                    cb1.c("LocalCms2Dx", sb.toString());
                }
            }
            if (hashMap.size() > 0) {
                ToastUtil.i("警告!!!存在CMS组件与Dx内置模板映射关系有误 YuShiLei");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void b(IImageLoader iImageLoader, TrackProxy.ITrack iTrack) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "122451678")) {
            ipChange.ipc$dispatch("122451678", new Object[]{iImageLoader, iTrack});
            return;
        }
        C9039db.a("dm_banner_videoheader_ip");
        C9039db.a("dm_banner_row1_girl");
        C9039db.a("dm_banner_with_title");
        C9039db.a("dm_card_ip_videoalbum");
        C9039db.a("dm_card_actoralbum");
        C9039db.a(xl2.DM_COMMON_LOOP_BANNER_CID);
        C9039db.a(xl2.DM_HOME_BANNER_CID);
        C9039db.a("live_perform_announce");
        C9039db.a("dm_livehouse_artist_list");
        C9039db.a(xl2.DRAMA_CALENDAR_HORIZONTAL_CID);
        C9039db.a(xl2.DRAMA_LIST_WORTH_TO_SEE);
        C9039db.a(xl2.DM_COMMON_LOOP_BANNER_CID);
        C9039db.a("dm_rank_square_rank_header_list");
        C9039db.a(xl2.DM_FLOATING_ANCHOR_POINT_BAR_CID);
        C9039db.a("dm_artist_tour_info");
        C9039db.a("dm_tour_project_more");
        C9039db.a("dm_artist_group_relate");
        C9039db.a("dm_common_loop_banner_with_size");
        C9039db.a("dm_base_content_free_test");
        C9039db.a(AccountAlbumContract.CID);
        Log.d("launcher", "initTetrisProxy addBlackId new");
        LocalDxTemplate localDxTemplate = new LocalDxTemplate();
        localDxTemplate.name = "damai_musicfestival_brand";
        localDxTemplate.version = 12L;
        localDxTemplate.templateUrl = "";
        m90.h(xl2.DX_MUSIC_FESTIVAL_IP_LIST_CID, localDxTemplate);
        LocalDxTemplate localDxTemplate2 = new LocalDxTemplate();
        localDxTemplate2.name = "damai_music_festival_hot_project_list";
        localDxTemplate2.version = 18L;
        localDxTemplate2.templateUrl = "";
        m90.h(xl2.DX_MUSIC_FESTIVAL_HOT_PROJECT_LIST_CID, localDxTemplate2);
        cb.a(new hh());
        C9039db.b(xl2.DISCOVER_FEED_COMPONENT_ID, new q90());
        C9039db.b(xl2.DISCOVER_FEED_V2_COMPONENT_ID, new p90());
        C9039db.b(xl2.CIRCLE_FEED_COMPONENT_ID, new ri());
        C9039db.b("dm_rank_square_project_vertical_list", new uy1());
        C9039db.b(xl2.CATEGORY_LIST_COMPONENT_ID, new ah());
        C9039db.b(xl2.DX_MUSIC_FESTIVAL_HOT_PROJECT_LIST_CID, new yh1());
        C9039db.b(xl2.DX_MUSIC_FESTIVAL_IP_LIST_CID, new zh1());
        C9039db.b("damai_brand_show_representation", new jd());
        C9039db.b("dm_home_video", new zy0());
        C9039db.b("damai_home_grabticket_notice", new nx0());
        C9039db.b(xl2.DRAMA_CALENDAR_VERTICAL_CID, new lx2());
        C9039db.b(xl2.PROJECT_BROADCAST_HORIZONTAL_LIST, new lv1());
        C9039db.b(xl2.DM_CARD_PROJECT_BROADCAST_CID, new mv1());
        C9039db.b(xl2.DM_PROJECT_FILTER_PANEL_CID, new bw1());
        C9039db.b(xl2.DM_PROJECT_LIST_BELOW_FILTER_PANEL_CID, new cw1());
        C9039db.b(xl2.PROJECT_FILTER_OPTION_C_ID, new bw1());
        C9039db.b(xl2.RANK_FILTER_VIEW_C_ID, new vy1());
        C9039db.c(xl2.DISCOVER_FEED_COMPONENT_ID, new r90());
        C9039db.c(xl2.DISCOVER_FEED_V2_COMPONENT_ID, new r90());
        C9039db.c(xl2.CIRCLE_FEED_COMPONENT_ID, new xi());
        C9039db.c("dm_rank_square_project_vertical_list", new az1());
        C9039db.c(xl2.DM_FLOATING_ANCHOR_POINT_BAR_CID, new rg2());
        ComponentPluginType componentPluginType = ComponentPluginType.ONE_CID_2_ONE_PLUGIN;
        ComponentPlugin.registerPlugin(xl2.DM_PROJECT_FILTER_PANEL_CID, componentPluginType, FilterPanelPlugin.class);
        ComponentPlugin.registerPlugin(xl2.DM_FLOATING_ANCHOR_POINT_BAR_CID, componentPluginType, AnchorFloatingPlugin.class);
        ComponentPluginType componentPluginType2 = ComponentPluginType.ONE_SECTION_2_ONE_PLUGIN;
        ComponentPlugin.registerPlugin(xl2.DRAMA_CALENDAR_VERTICAL_CID, componentPluginType2, VerticalDramaByMonthPlugin.class);
        ComponentPlugin.registerPlugin(xl2.MUSIC_FESTIVAL_MAP_COMPONENT_ID, componentPluginType2, MusicFestivalPlugin.class);
        ComponentPlugin.registerPlugin(xl2.DISCOVER_FEED_V2_COMPONENT_PLUGIN_ID, componentPluginType, DiscoverFeedPlugin.class);
        ComponentPlugin.registerPlugin(xl2.VOTE_C_ID, componentPluginType, VoteCardPlugin.class);
        ComponentPlugin.registerPlugin(xl2.PROJECT_FILTER_OPTION_C_ID, componentPluginType2, ProjectFilterPlugin.class);
        ComponentPlugin.registerPlugin(xl2.RANK_FILTER_VIEW_C_ID, componentPluginType2, RankFilterPlugin.class);
        try {
            C2497a.b(iImageLoader);
            TrackProxy.b(iTrack);
            NavigatorProxy.b(new bj1());
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("TetrisProxyInit", " ======= TetrisProxyInit ERROR ====== ");
        }
    }
}
