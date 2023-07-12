package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class xl2 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String BIG_NOTE_C_ID = "dm_feed_big_note";
    public static final String BIG_THEME_C_ID = "dm_feed_big_theme";
    public static final String BIG_VOTE_C_ID = "dm_feed_big_vote";
    public static final String CATEGORY_LIST_COMPONENT_ID = "dm_list_category";
    public static final String CIRCLE_FEED_COMPONENT_ID = "dm_circle_feed";
    public static final String DISCOVER_FEED_COMPONENT_ID = "dm_waterfall_feed_discover";
    public static final String DISCOVER_FEED_V2_COMPONENT_ID = "dm_red_book_water_fall_feed";
    public static final String DISCOVER_FEED_V2_COMPONENT_PLUGIN_ID = "dm_red_book_water_fall_feed_plugin";
    public static final String DISCUSS_C_ID = "dm_feed_discuss";
    public static final String DM_ARTIST_MAIN_OFFICIAL_CONTENT = "dm_artist_main_official_content";
    public static final String DM_ARTIST_MAIN_YUEHUA_CONTENT = "dm_artist_main_yuehua_content";
    public static final String DM_BASE_CONTENT_FREE = "dm_base_content_free";
    public static final String DM_BASE_CONTENT_VIP = "dm_base_content_vip";
    public static final String DM_CARD_CATEGORY_TITLE = "dm_card_category_title";
    public static final String DM_CARD_PROJECT_BROADCAST_CID = "dm_card_project_broadcast";
    public static final String DM_CARD_RANKLIST_HORIZONTAL = "dm_card_ranklist_horizontal";
    public static final String DM_COMMON_LOOP_BANNER_CID = "dm_common_loop_banner";
    public static final String DM_FLOATING_ANCHOR_POINT_BAR_CID = "dm_floating_anchor_point_bar";
    public static final String DM_HOME_BANNER_CID = "dm_home_banner";
    public static final String DM_HOME_FIVE_ENTRY_CID = "damai_home_five_entry";
    public static final String DM_PROJECT_FILTER_PANEL_CID = "dm_project_filter_panel";
    public static final String DM_PROJECT_HORIZONTAL = "dm_card_project_horizontal";
    public static final String DM_PROJECT_LIST_BELOW_FILTER_PANEL_CID = "dm_project_list_below_filter_panel";
    public static final String DRAMA_CALENDAR_HORIZONTAL_CID = "dm_card_drama_calendar_horizontal";
    public static final String DRAMA_CALENDAR_VERTICAL_CID = "dm_drama_calendar_vertical";
    public static final String DRAMA_LIST_WORTH_TO_SEE = "dm_drama_list_worth_to_see";
    public static final String DX_MUSIC_FESTIVAL_HOT_PROJECT_LIST_CID = "DinamicX_dm_hot_music_festival_project_list";
    public static final String DX_MUSIC_FESTIVAL_IP_LIST_CID = "DinamicX_dm_music_festival_ip_list";
    public static final String GAIAX_DEFAULT_TEMPLATE_BIZ_KEY = "damai";
    public static final String HAS_NEXT = "hasNext";
    public static final String HW_RATIO = "hwRatio";
    public static final float HW_RATIO_1_1 = 1.0f;
    public static final float HW_RATIO_4_3 = 1.3333334f;
    public static final String ITEM_INFO = "itemInfo";
    public static final String LAYOUT_TYPE_GRID = "grid";
    public static final String LAYOUT_TYPE_LINEAR = "linear";
    public static final String LAYOUT_TYPE_STAGGERED = "staggered";
    public static final String LAYOUT_TYPE_STICKY = "sticky";
    public static final String MUSIC_FESTIVAL_MAP_COMPONENT_ID = "dm_music_festival_map_view";
    public static final String NOTE_C_ID = "dm_feed_note";
    public static final String PAGE_MESSAGE_KEY_PREFIX = "page_inner_msgbus";
    public static final String PROJECT_BROADCAST_HORIZONTAL_LIST = "dm_project_broadcast_horizontal_list";
    public static final String PROJECT_C_ID = "dm_feed_project";
    public static final String PROJECT_FILTER_OPTION_C_ID = "dm_project_filter_option";
    public static final String RANK_FEED_COMPONENT_ID = "dm_rank_square_project_vertical_list";
    public static final String RANK_FILTER_VIEW_C_ID = "dm_rank_square_filter_view";
    public static final String RANK_PROJECT_C_ID = "dm_rank_square_project_vertical_list_item";
    public static final String RANK_PROJECT_LIST_ID = "dm_rank_square_project_vertical_list";
    public static final String THEME_C_ID = "dm_feed_theme";
    public static final String VOTE_C_ID = "dm_feed_vote";
    public static final String VOTE_TYPE_ID = "5";
    public static final String dm_discover_head_banner_cid = "dm_discover_head_banner";
    public static final String dm_discover_head_fixed_cid = "dm_discover_head_fixed";
    public static final String dm_discover_hot_theme_cid = "dm_discover_hot_theme";

    public static String a(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "494568484")) {
            return (String) ipChange.ipc$dispatch("494568484", new Object[]{str});
        }
        return "page_inner_msgbus@" + str;
    }
}
