package tb;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class gh1 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String MODULE_BANNER = "banner";
    public static final String MODULE_BRAND2 = "brand2";
    public static final String MODULE_DETAILEDLIST2 = "detailedList2";
    public static final String MODULE_HOMEBROADCAST = "homeBroadcast";
    public static final String MODULE_HOME_AD = "home_ad";
    public static final String MODULE_HOME_COLLECTION = "home_collection";
    public static final String MODULE_HOME_LIVE_SUSPENDP = "home_live_suspend";
    public static final String MODULE_HOME_POP = "home_pop";
    public static final String MODULE_HOME_TOUR = "home_tour";
    public static final String MODULE_HOME_VIDEO = "home_video";
    public static final String MODULE_ICON_FIVE = "icon_five";
    public static final String MODULE_MUSTSEERANK = "mustSeeRank";
    public static final String MODULE_MUSTSEERANK3 = "mustSeeRank3";
    public static final String MODULE_RECENTPROJECT = "recentProject";
    public static final String MODULE_SEARCHTIP = "searchTip";
    public static final String MODULE_WARNINGMESSAGE = "warningMessage";
    public static final String MODULE_WATERFLOW_TITLE = "home_guess";
    public static final int TYPE_BANNER = 0;
    public static final int TYPE_BRAND2 = 12;
    public static final int TYPE_DETAILEDLIST2 = 11;
    public static final int TYPE_HOMEBROADCAST = 2;
    public static final int TYPE_HOME_AD = 15;
    public static final int TYPE_HOME_COLLECTION = 13;
    public static final int TYPE_HOME_LIVE_SUSPENDP = 16;
    public static final int TYPE_HOME_POP = 14;
    public static final int TYPE_HOME_TOUR = 10;
    public static final int TYPE_HOME_VIDEO = 9;
    public static final int TYPE_ICON_FIVE = 1;
    public static final int TYPE_MUSTSEERANK = 4;
    public static final int TYPE_MUSTSEERANK3 = 7;
    public static final int TYPE_RECENTPROJECT = 5;
    public static final int TYPE_SEARCHTIP = 222;
    public static final int TYPE_WARNINGMESSAGE = 3;
    public static final int TYPE_WATERFLOW_TITLE = 399;
    public static final int WATERFLOW_CARDTYPE_CATEGORY = 308;
    public static final int WATERFLOW_CARDTYPE_CIRCLE = 313;
    public static final int WATERFLOW_CARDTYPE_COUPON = 301;
    public static final int WATERFLOW_CARDTYPE_DETAILEDLIST = 307;
    public static final int WATERFLOW_CARDTYPE_GOODS = 304;
    public static final int WATERFLOW_CARDTYPE_MARKETING = 302;
    public static final int WATERFLOW_CARDTYPE_NOTE = 310;
    public static final int WATERFLOW_CARDTYPE_RANKLIST = 305;
    public static final int WATERFLOW_CARDTYPE_THEME = 311;
    public static final int WATERFLOW_CARDTYPE_TICKET = 303;
    public static final int WATERFLOW_CARDTYPE_VENUES = 306;
    public static final int WATERFLOW_CARDTYPE_VIP = 309;
    public static final int WATERFLOW_CARDTYPE_VOTE = 312;
    public static final String WATERFLOW_ID_CATEGORY = "8";
    public static final String WATERFLOW_ID_CIRCLE = "13";
    public static final String WATERFLOW_ID_COUPON = "1";
    public static final String WATERFLOW_ID_DETAILEDLIST = "7";
    public static final String WATERFLOW_ID_GOODS = "4";
    public static final String WATERFLOW_ID_MARKETING = "2";
    public static final String WATERFLOW_ID_NOTE = "10";
    public static final String WATERFLOW_ID_NOTE_NEW = "14";
    public static final String WATERFLOW_ID_RANKLIST = "5";
    public static final String WATERFLOW_ID_THEME = "11";
    public static final String WATERFLOW_ID_TICKET = "3";
    public static final String WATERFLOW_ID_VENUES = "6";
    public static final String WATERFLOW_ID_VIP = "9";
    public static final String WATERFLOW_ID_VOTE = "12";
    public static Map<String, Integer> a = new HashMap();
    public static List<Integer> b = new ArrayList();
    public static List<Integer> c = new ArrayList();
    public static List<Integer> d = new ArrayList();

    static {
        a.put(MODULE_BANNER, 0);
        a.put(MODULE_ICON_FIVE, 1);
        a.put(MODULE_HOMEBROADCAST, 2);
        a.put(MODULE_WARNINGMESSAGE, 3);
        a.put(MODULE_MUSTSEERANK, 4);
        a.put(MODULE_RECENTPROJECT, 5);
        a.put(MODULE_MUSTSEERANK3, 7);
        a.put(MODULE_HOME_VIDEO, 9);
        a.put(MODULE_HOME_TOUR, 10);
        a.put(MODULE_SEARCHTIP, 222);
        a.put(MODULE_DETAILEDLIST2, 11);
        a.put(MODULE_BRAND2, 12);
        a.put(MODULE_HOME_COLLECTION, 13);
        a.put(MODULE_HOME_POP, 14);
        a.put(MODULE_HOME_AD, 15);
        a.put(MODULE_HOME_LIVE_SUSPENDP, 16);
        a.put(MODULE_WATERFLOW_TITLE, 399);
        a.put("2", 302);
        a.put("3", 303);
        a.put("4", 304);
        a.put("5", 305);
        a.put("6", 306);
        a.put("7", 307);
        a.put("8", 308);
        a.put("9", 309);
        a.put("10", 310);
        a.put("14", 310);
        a.put("11", 311);
        a.put("12", 312);
        a.put("13", 313);
        b.clear();
        c.clear();
        d.clear();
        b.add(222);
        b.add(0);
        b.add(3);
        b.add(5);
        b.add(9);
        b.add(10);
        b.add(14);
        b.add(7);
        b.add(399);
        c.add(302);
        c.add(303);
        c.add(304);
        c.add(305);
        c.add(306);
        c.add(307);
        c.add(308);
        c.add(309);
        c.add(310);
        c.add(311);
        c.add(312);
        c.add(313);
        d.add(1);
        d.add(2);
        d.add(13);
        d.add(11);
        d.add(12);
        d.add(15);
        d.add(4);
    }

    public static int a(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1956418353")) {
            return ((Integer) ipChange.ipc$dispatch("1956418353", new Object[]{Integer.valueOf(i)})).intValue();
        }
        if (b.contains(Integer.valueOf(i))) {
            return 1;
        }
        if (c.contains(Integer.valueOf(i))) {
            return 2;
        }
        return d.contains(Integer.valueOf(i)) ? 3 : 0;
    }

    public static boolean b(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1064441408") ? ((Boolean) ipChange.ipc$dispatch("-1064441408", new Object[]{str})).booleanValue() : (TextUtils.isEmpty(str) || a.get(str) == null) ? false : true;
    }
}
