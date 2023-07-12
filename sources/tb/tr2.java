package tb;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import cn.damai.category.category.ui.ShowFragment;
import cn.damai.common.AppConfig;
import cn.damai.common.OrangeConfigCenter;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$string;
import cn.damai.homepage.MainActivity;
import cn.damai.im.UserInfoUtil;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.login.LoginManager;
import com.alimm.xadsdk.base.expose.MonitorType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.purchase.core.utils.PurchaseConstants;
import com.taobao.weex.common.Constants;
import com.youku.alixplayer.opensdk.statistics.StaticsUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class tr2 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String SCHEME = "damai://V1/";
    public static final String SCHEME_CATEGORYPAGE = "damai://V1/CategoryPage";
    public static final String SCHEME_HOMEPAGE = "damai://V1/HomePage";
    public static final String SCHEME_MINEPAGE = "damai://V1/MinePage";
    public static final String SCHEME_PROJECT_DETAIL = "damai://V1/ProjectPage?id=";
    public static final String TPP_H5_URL = "https://h5.m.taopiaopiao.com/app/movie/pages/index/index.html?from=damai";
    private static volatile tr2 c = null;
    public static String d = "from";
    public static int e = 1;
    public static Map<String, String> f = new HashMap();
    Uri a;
    private boolean b = false;

    /* compiled from: Taobao */
    /* renamed from: tb.tr2$a */
    /* loaded from: classes6.dex */
    public class DialogInterface$OnClickListenerC9730a implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        DialogInterface$OnClickListenerC9730a(tr2 tr2Var) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-981985943")) {
                ipChange.ipc$dispatch("-981985943", new Object[]{this, dialogInterface, Integer.valueOf(i)});
            } else {
                dialogInterface.dismiss();
            }
        }
    }

    private tr2() {
        f.put("LiveRoom", "liveroom");
        f.put("IpDramaPage", "ipdrama");
        f.put("RepertoirePage", u12.REPERTOITE);
        f.put("UserprofilePage", cs.Y);
        f.put("OrderDetailPage", cs.g);
        f.put("HNOrderDetailPage", cs.h);
        f.put("MediaBrowser", "videobrowse");
        f.put("TicketReceivePage", "ticklet");
        f.put("TicketDetailPage", "member_ticketwalletinfo");
        f.put("TicketListPage", "member_ticketwalletlist");
        f.put("CommentDetailPage", "commentdetail");
        f.put("CommentListPage", "comment_list");
        f.put("TicketToCommentListPage", "mycomment");
        f.put("FollowReplyPage", cs.y);
        f.put("PublishPage", "issue");
        f.put("RealNameAuthResult", "realname_auth_result");
        f.put("FeedBackDetailPage", "my_feed_back_detail");
        f.put("OrderCheckPage", cs.c);
        f.put("RankingListPage", cs.C);
        f.put("IPRankingListPage", cs.D);
        f.put("DetailedListPage", cs.E);
        f.put("DiscountPage", cs.DISCOUNT_TICKET);
        f.put("Discover", cs.PAGE_DISCOVER);
        f.put("DiscoverThemePage", cs.DISCOVER_THEME);
        f.put("DiscoverContentDetail", cs.DISCOVER_CONTENT_DETAIL);
        f.put("DramaComming", cs.DRAMA_COMMING);
        f.put("LiveHouseSecond", cs.LIVE_HOUSE_SECOND_PAGE);
        f.put("NewStarList", cs.r);
        f.put("NewBrandList", cs.s);
        f.put("MemberCenterTab", cs.q);
        f.put("ArtistOfficialContentListPage", cs.PAGE_ARTIST_OFFICAL_CONTENT_LIST);
        f.put("Popcorn", "popcorn_open_mock_case_list");
        f.put("skuPage", cs.F);
        f.put("PerformCalendar", cs.A);
        f.put("RankSquare", cs.B);
        f.put("RankSquareCmsPage", cs.RANK_SQUARE_CMS_HOST);
        f.put("DiscoverCircleThemePage", cs.DISCOVER_CIRCLE_THEME_PAGE);
        f.put("MessagePushSetting", cs.MESSAGE_PUSH_SETTING);
        f.put("ArtistOfficialContentListPage", cs.B);
        f.put("CmsCommonSecond", "cms_common_second");
        f.put("SystemSeting", cs.PERMISSION_ENTRANCE);
        f.put("PushSeting", cs.MESSAGE_PUSH_SETTING);
        f.put("PrivacySeting", cs.PRIVACY_SETTING);
        f.put("VenueNavi", "venuemap");
        f.put("ScriptPlay", cs.SCRIPT_SHOP_DETAIL);
        f.put("ScriptDetail", cs.SCRIPT_DETAIL);
        f.put("ScriptCouponDetail", cs.SCRIPT_COUPON_DETAIL);
        f.put("CouponPayResult", cs.SCRIPT_COUPON_PAY_RESULT);
        f.put("EvaluateList", cs.W);
        f.put("MinePage?value=FollowPage", cs.H);
        f.put("MinePage?value=FansPage", cs.H);
        f.put("MinePage?value=WantPraisePage", cs.I);
        f.put("MinePage?value=WantedPage", "MinePage");
        f.put("MessagePage", cs.x);
        f.put("MinePage?value=DynamicPage", "MinePage");
        f.put("MinePage?value=OrderPage", cs.f);
        f.put("MyAddressListPage", cs.N);
        f.put("SearchMainPage", cs.o);
        f.put("CustomersPage", cs.R);
        f.put("AddCustomerPage", cs.z);
        f.put("EditAccountPage", cs.J);
        f.put("AccountSafePage", cs.K);
        f.put("CouponOrderConfirm", cs.COUPON_ORDER_CONFIRM);
        f.put("CouponOrderDetail", cs.COUPON_ORDER_DETAIL);
        f.put("TicketSouvenirPage", cs.TICKET_SOUNENVIR);
        f.put("TicketESouvenirPage", cs.TICKET_E_SOUNENVIR);
        f.put("TicketVenuePage", cs.TICKET_VENUEPOINT);
        f.put("TicketNoticePage", cs.TICKET_NOTICE);
        f.put("ScriptSelect", cs.SCRIPT_SELECT);
        f.put("SettingsPage", cs.V);
        f.put("BroadcastListPage", "grab");
        f.put("DmCommonChannel", cs.NEW_SHOW_CALENDAR);
    }

    public static tr2 b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "328044061")) {
            return (tr2) ipChange.ipc$dispatch("328044061", new Object[0]);
        }
        if (c == null) {
            synchronized (tr2.class) {
                if (c == null) {
                    c = new tr2();
                }
            }
        }
        return c;
    }

    public static Bundle c(String str) {
        Set<String> queryParameterNames;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "243851001")) {
            return (Bundle) ipChange.ipc$dispatch("243851001", new Object[]{str});
        }
        String str2 = SCHEME + str;
        Bundle bundle = new Bundle();
        if (!wh2.j(str2)) {
            try {
                Uri parse = Uri.parse(str2);
                if (parse != null && (queryParameterNames = parse.getQueryParameterNames()) != null && queryParameterNames.iterator() != null) {
                    for (String str3 : queryParameterNames) {
                        bundle.putString(str3, parse.getQueryParameter(str3));
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return bundle;
    }

    private void d(Context context, String str, String str2, int i, Intent intent) {
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String queryParameter;
        String str13;
        String str14;
        String str15;
        String str16;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-572309649")) {
            ipChange.ipc$dispatch("-572309649", new Object[]{this, context, str, str2, Integer.valueOf(i), intent});
        } else if (str != null) {
            String str17 = "";
            if (str.contains("?")) {
                str3 = str.substring(0, str.indexOf("?"));
                str4 = str.substring(str.indexOf("?") + 1, str.length());
            } else {
                str3 = str;
                str4 = "";
            }
            Uri parse = Uri.parse(str);
            if (str3 == null || str3.equals("")) {
                return;
            }
            if (str3.equals("CategoryPage")) {
                if (str4 == null || str4.equals("")) {
                    return;
                }
                try {
                    str13 = parse.getQueryParameter("id");
                    try {
                        str14 = parse.getQueryParameter("option");
                        try {
                            str16 = parse.getQueryParameter("type");
                            str15 = str14;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            str15 = str14;
                            str16 = "0";
                            e(context, str13, str2, str15, str16, i, intent);
                        }
                    } catch (Exception e3) {
                        e = e3;
                        str14 = "0";
                    }
                } catch (Exception e4) {
                    e = e4;
                    str13 = "0";
                    str14 = str13;
                }
                e(context, str13, str2, str15, str16, i, intent);
            } else if (str3.equals("MinePage")) {
                if (str4 != null && !str4.equals("")) {
                    String queryParameter2 = parse.getQueryParameter("value");
                    if (queryParameter2 == null || queryParameter2.equals("")) {
                        return;
                    }
                    if (queryParameter2.equals("OrderPage")) {
                        p(context, i, intent);
                        return;
                    } else if (queryParameter2.equals("FavouritePage")) {
                        k(context, i, intent);
                        return;
                    } else if (queryParameter2.equals("SubscribePage")) {
                        n(context, i, intent);
                        return;
                    } else if (queryParameter2.equals("FansPage")) {
                        g(context, i, intent, parse);
                        return;
                    } else if (queryParameter2.equals("FollowPage")) {
                        h(context, i, intent, parse);
                        return;
                    } else if (queryParameter2.equals("WantPraisePage")) {
                        u(context, i, intent, parse);
                        return;
                    } else if (queryParameter2.equals("DynamicPage")) {
                        o(context, i, intent, queryParameter2);
                        return;
                    } else if (queryParameter2.equals("WantedPage")) {
                        o(context, i, intent, queryParameter2);
                        return;
                    } else if (queryParameter2.equals("PointsPage")) {
                        m(context, i, intent);
                        return;
                    } else if (queryParameter2.equals("CouponPage")) {
                        l(context, i, intent);
                        return;
                    } else if (queryParameter2.equals("AddressPage")) {
                        j(context, i, intent);
                        return;
                    } else if (queryParameter2.equals("SecurityPage")) {
                        String b = cm2.b(context, R$string.damai_usercenter_security_center);
                        if (LoginManager.k().q()) {
                            Intent intent2 = new Intent();
                            if (intent != null && intent.getExtras() != null) {
                                intent2.putExtras(intent.getExtras());
                            }
                            intent2.putExtra("url", "https://msecurity.damai.cn/securityCenter-front-wap/index");
                            intent2.putExtra("status", true);
                            intent2.putExtra("title", b);
                            x(context, intent2, i, cs.t);
                            return;
                        }
                        return;
                    } else {
                        w(context, new Intent(), i, cs.m(), intent);
                        return;
                    }
                }
                w(context, new Intent(), i, cs.m(), intent);
            } else if (str3.equals("ProjectPage")) {
                if (str4 == null || str4.equals("") || (queryParameter = parse.getQueryParameter("id")) == null || queryParameter.equals("0") || queryParameter.equals(Constants.Name.UNDEFINED) || queryParameter.equals("null")) {
                    return;
                }
                try {
                    long parseLong = Long.parseLong(queryParameter);
                    Intent intent3 = new Intent();
                    Bundle bundle = new Bundle();
                    if (intent != null && intent.getExtras() != null) {
                        bundle.putAll(intent.getExtras());
                    }
                    bundle.putLong(IssueConstants.ProjectID, parseLong);
                    intent3.putExtras(bundle);
                    v(context, intent3, i, cs.a());
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            } else if (str3.equals("WebPage")) {
                if (str4 == null || str4.equals("")) {
                    return;
                }
                try {
                    str17 = Uri.parse(SCHEME + str).getQueryParameter("url");
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
                Intent intent4 = new Intent();
                if (intent.getExtras() != null) {
                    intent4.putExtras(intent.getExtras());
                }
                intent4.putExtra("url", str17);
                if (!TextUtils.isEmpty(str17)) {
                    intent4.putExtra("title", str17);
                }
                intent4.putExtra("qiandao", true);
                intent4.putExtra(MonitorType.SKIP, false);
                intent4.putExtra("fromQr", true);
                int i2 = i == -1 ? 100 : i;
                if (this.b) {
                    intent4.addFlags(268435456);
                }
                x(context, intent4, i2, cs.t);
            } else if (str3.equals("SearchPage")) {
                if (str4 == null || str4.equals("")) {
                    return;
                }
                String queryParameter3 = parse.getQueryParameter("keyword");
                Intent intent5 = new Intent();
                intent5.putExtra("autowords", queryParameter3);
                y(context, intent5, i, cs.o, intent);
            } else if (str3.equals("HomePage")) {
                if (str4 == null || str4.equals("")) {
                    str11 = "";
                } else {
                    try {
                        str12 = parse.getQueryParameter("id");
                    } catch (Exception e7) {
                        e = e7;
                        str12 = "";
                    }
                    try {
                        str17 = parse.getQueryParameter("type");
                    } catch (Exception e8) {
                        e = e8;
                        e.printStackTrace();
                        str11 = str12;
                        i(context, str11, str17, i, intent);
                    }
                    str11 = str12;
                }
                i(context, str11, str17, i, intent);
            } else if (str3.equals("SecondLevelHomePage")) {
                if (TextUtils.isEmpty(str4)) {
                    str10 = "";
                    str9 = str10;
                } else {
                    try {
                        str7 = parse.getQueryParameter("id");
                        try {
                            str8 = parse.getQueryParameter("type");
                            try {
                                str9 = parse.getQueryParameter(MainActivity.KEY_REF_ITEM_ID);
                            } catch (Exception e9) {
                                e = e9;
                                e.printStackTrace();
                                str9 = "";
                                str17 = str8;
                                str10 = str7;
                                f(context, str10, str17, str9, i, intent);
                            }
                        } catch (Exception e10) {
                            e = e10;
                            str8 = "";
                        }
                    } catch (Exception e11) {
                        e = e11;
                        str7 = "";
                        str8 = str7;
                    }
                    str17 = str8;
                    str10 = str7;
                }
                f(context, str10, str17, str9, i, intent);
            } else if (str3.equals("LoginPage")) {
                LoginManager.k().v(context);
            } else if (str3.equals("MovieListPage")) {
                Intent intent6 = new Intent();
                intent6.putExtra("url", TPP_H5_URL);
                y(context, intent6, i, cs.t, intent);
            } else if (str3.equals("ArtistOfficialContentListPage")) {
                if (str4 == null || str4.equals("")) {
                    str5 = "";
                } else {
                    try {
                        str6 = parse.getQueryParameter(l8.KEY_ARTIST_ID);
                        try {
                            str17 = parse.getQueryParameter("type");
                        } catch (Exception e12) {
                            e = e12;
                            e.printStackTrace();
                            str5 = str6;
                            t(context, str5, str17, i, intent);
                        }
                    } catch (Exception e13) {
                        e = e13;
                        str6 = "";
                    }
                    str5 = str6;
                }
                t(context, str5, str17, i, intent);
            } else if (str3.equals("EditAccountPage")) {
                Bundle bundle2 = new Bundle();
                if (intent != null && intent.getExtras() != null) {
                    bundle2.putAll(intent.getExtras());
                }
                bundle2.putAll(c(str));
                String str18 = f.get(str3);
                if (UserInfoUtil.a() != null && UserInfoUtil.a().getUserBaseInfo() != null) {
                    bundle2.putString("nickName", UserInfoUtil.a().getUserBaseInfo().getNickname());
                    bundle2.putString("userIntro", UserInfoUtil.a().getUserBaseInfo().getUserIntro());
                    bundle2.putString("birthday", UserInfoUtil.a().getUserBaseInfo().getBirthday());
                    bundle2.putInt("sex", UserInfoUtil.a().getUserBaseInfo().getSex());
                }
                if (context instanceof Activity) {
                    DMNav.from(context).stack(this.a).forResult(i).withExtras(bundle2).toUri(NavUri.b(str18));
                } else {
                    DMNav.from(context).stack(this.a).withExtras(bundle2).toUri(NavUri.b(str18));
                }
            } else if (!wh2.j(f.get(str3))) {
                Bundle bundle3 = new Bundle();
                if (intent != null && intent.getExtras() != null) {
                    bundle3.putAll(intent.getExtras());
                }
                bundle3.putAll(c(str));
                String str19 = f.get(str3);
                if (context instanceof Activity) {
                    DMNav.from(context).stack(this.a).forResult(i).withExtras(bundle3).toUri(NavUri.b(str19));
                } else {
                    DMNav.from(context).stack(this.a).withExtras(bundle3).toUri(NavUri.b(str19));
                }
            } else {
                new DMDialog(context).o(true).v(PurchaseConstants.NORMAL_WARNING_TITLE).q("请更新APP到最新版使用哦.").t(3).n("我知道了", new DialogInterface$OnClickListenerC9730a(this)).show();
                b23.g("UIRouterManager:jsondata={appVersion:" + AppConfig.q() + ",url:" + parse.toString() + "}", StaticsUtil.PLAY_CODE_103, "UIRouterManager地址转换异常");
            }
        }
    }

    private void e(Context context, String str, String str2, String str3, String str4, int i, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "57754160")) {
            ipChange.ipc$dispatch("57754160", new Object[]{this, context, str, str2, str3, str4, Integer.valueOf(i), intent});
            return;
        }
        Intent intent2 = new Intent();
        if (intent != null && intent.getExtras() != null) {
            intent2.putExtras(intent.getExtras());
        }
        intent2.putExtra("categoryId", str);
        if (!TextUtils.isEmpty(str2)) {
            intent2.putExtra(ShowFragment.CATEGORYNAME_KEY, str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            intent2.putExtra("option", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            intent2.putExtra("type", str4);
        }
        x(context, intent2, i, cs.p);
    }

    private void f(Context context, String str, String str2, String str3, int i, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2006701460")) {
            ipChange.ipc$dispatch("2006701460", new Object[]{this, context, str, str2, str3, Integer.valueOf(i), intent});
            return;
        }
        Intent intent2 = new Intent();
        if (intent != null && intent.getExtras() != null) {
            intent2.putExtras(intent.getExtras());
        }
        if (!TextUtils.isEmpty(str)) {
            intent2.putExtra("id", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            intent2.putExtra("type", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            intent2.putExtra(MainActivity.KEY_REF_ITEM_ID, str3);
        }
        x(context, intent2, i, cs.m);
    }

    private void g(Context context, int i, Intent intent, Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "336928375")) {
            ipChange.ipc$dispatch("336928375", new Object[]{this, context, Integer.valueOf(i), intent, uri});
            return;
        }
        boolean booleanQueryParameter = uri.getBooleanQueryParameter("self", true);
        if (booleanQueryParameter && !LoginManager.k().q()) {
            z(context);
            return;
        }
        Bundle bundle = new Bundle();
        if (intent != null && intent.getExtras() != null) {
            bundle.putAll(intent.getExtras());
        }
        String queryParameter = uri.getQueryParameter("currentUserId");
        if (TextUtils.isEmpty(queryParameter)) {
            queryParameter = z20.i();
        }
        bundle.putString("userId", queryParameter);
        bundle.putString("relationType", "2");
        bundle.putString("targetType", "1");
        bundle.putString("targetId", queryParameter);
        bundle.putBoolean("self", booleanQueryParameter);
        if (i != -1) {
            DMNav.from(context).stack(this.a).forResult(i).withExtras(bundle).toUri(cs.j());
        } else {
            DMNav.from(context).stack(this.a).withExtras(bundle).toUri(cs.j());
        }
    }

    private void h(Context context, int i, Intent intent, Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "148933798")) {
            ipChange.ipc$dispatch("148933798", new Object[]{this, context, Integer.valueOf(i), intent, uri});
            return;
        }
        boolean booleanQueryParameter = uri.getBooleanQueryParameter("self", true);
        if (booleanQueryParameter && !LoginManager.k().q()) {
            z(context);
            return;
        }
        Bundle bundle = new Bundle();
        if (intent != null && intent.getExtras() != null) {
            bundle.putAll(intent.getExtras());
        }
        String queryParameter = uri.getQueryParameter("currentUserId");
        if (TextUtils.isEmpty(queryParameter)) {
            queryParameter = z20.i();
        }
        bundle.putString("userId", queryParameter);
        bundle.putString("relationType", "1");
        bundle.putBoolean("self", booleanQueryParameter);
        if (i != -1) {
            DMNav.from(context).stack(this.a).forResult(i).withExtras(bundle).toUri(cs.j());
        } else {
            DMNav.from(context).stack(this.a).withExtras(bundle).toUri(cs.j());
        }
    }

    private void i(Context context, String str, String str2, int i, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1720460756")) {
            ipChange.ipc$dispatch("1720460756", new Object[]{this, context, str, str2, Integer.valueOf(i), intent});
            return;
        }
        Intent intent2 = new Intent();
        if (intent != null && intent.getExtras() != null) {
            intent2.putExtras(intent.getExtras());
        }
        if (!TextUtils.isEmpty(str)) {
            intent2.putExtra("id", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            intent2.putExtra("type", str2);
        }
        x(context, intent2, i, cs.n);
    }

    private void j(Context context, int i, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1686405241")) {
            ipChange.ipc$dispatch("1686405241", new Object[]{this, context, Integer.valueOf(i), intent});
        } else if (!LoginManager.k().q()) {
            z(context);
        } else {
            Bundle bundle = new Bundle();
            if (intent != null && intent.getExtras() != null) {
                bundle.putAll(intent.getExtras());
            }
            if (i != -1) {
                DMNav.from(context).stack(this.a).withExtras(bundle).forResult(i).toUri(cs.g());
            } else {
                DMNav.from(context).stack(this.a).withExtras(bundle).toUri(cs.g());
            }
        }
    }

    private void k(Context context, int i, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1838977632")) {
            ipChange.ipc$dispatch("1838977632", new Object[]{this, context, Integer.valueOf(i), intent});
        } else if (!LoginManager.k().q()) {
            z(context);
        } else {
            Bundle bundle = new Bundle();
            if (intent != null && intent.getExtras() != null) {
                bundle.putAll(intent.getExtras());
            }
            bundle.putString("userId", z20.i());
            bundle.putString("relationType", "1");
            bundle.putBoolean("self", true);
            if (i != -1) {
                DMNav.from(context).stack(this.a).forResult(i).withExtras(bundle).toUri(cs.j());
            } else {
                DMNav.from(context).stack(this.a).withExtras(bundle).toUri(cs.j());
            }
        }
    }

    private void l(Context context, int i, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1748018813")) {
            ipChange.ipc$dispatch("-1748018813", new Object[]{this, context, Integer.valueOf(i), intent});
        } else if (!LoginManager.k().q()) {
            z(context);
        } else {
            Bundle bundle = new Bundle();
            if (intent != null && intent.getExtras() != null) {
                bundle.putAll(intent.getExtras());
            }
            if ("1".equals(OrangeConfigCenter.c().b(on1.b, "myCouponDowngrade", "0"))) {
                if (i != -1) {
                    DMNav.from(context).stack(this.a).withExtras(bundle).forResult(i).toUri(cs.d());
                } else {
                    DMNav.from(context).stack(this.a).withExtras(bundle).toUri(cs.d());
                }
            } else if (i != -1) {
                DMNav.from(context).stack(this.a).withExtras(bundle).forResult(i).toUri("damai://V1/Flutter?flutter_path=dm_coupon_list&bizType=0");
            } else {
                DMNav.from(context).stack(this.a).withExtras(bundle).toUri("damai://V1/Flutter?flutter_path=dm_coupon_list&bizType=0");
            }
        }
    }

    private void m(Context context, int i, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1640010329")) {
            ipChange.ipc$dispatch("1640010329", new Object[]{this, context, Integer.valueOf(i), intent});
        } else if (!LoginManager.k().q()) {
            z(context);
        } else {
            Bundle bundle = new Bundle();
            if (intent != null && intent.getExtras() != null) {
                bundle.putAll(intent.getExtras());
            }
            if (i != -1) {
                DMNav.from(context).stack(this.a).withExtras(bundle).forResult(i).toUri(cs.h());
            } else {
                DMNav.from(context).stack(this.a).withExtras(bundle).toUri(cs.h());
            }
        }
    }

    private void n(Context context, int i, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-809180812")) {
            ipChange.ipc$dispatch("-809180812", new Object[]{this, context, Integer.valueOf(i), intent});
        } else if (!LoginManager.k().q()) {
            z(context);
        } else {
            Bundle bundle = new Bundle();
            if (intent != null && intent.getExtras() != null) {
                bundle.putAll(intent.getExtras());
            }
            if (i != -1) {
                DMNav.from(context).stack(this.a).withExtras(bundle).forResult(i).toUri(cs.j());
            } else {
                DMNav.from(context).stack(this.a).withExtras(bundle).toUri(cs.j());
            }
        }
    }

    private void o(Context context, int i, Intent intent, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1624281747")) {
            ipChange.ipc$dispatch("-1624281747", new Object[]{this, context, Integer.valueOf(i), intent, str});
        } else if (!LoginManager.k().q()) {
            z(context);
        } else {
            Bundle bundle = new Bundle();
            if (intent != null && intent.getExtras() != null) {
                bundle.putAll(intent.getExtras());
            }
            bundle.putString("userId", z20.i());
            Bundle bundle2 = new Bundle();
            bundle2.putString("pageName", str);
            bundle.putBundle("pageKey", bundle2);
            if (i != -1) {
                DMNav.from(context).stack(this.a).forResult(i).withExtras(bundle).toUri(cs.m());
            } else {
                DMNav.from(context).stack(this.a).withExtras(bundle).toUri(cs.m());
            }
        }
    }

    private void p(Context context, int i, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "739133520")) {
            ipChange.ipc$dispatch("739133520", new Object[]{this, context, Integer.valueOf(i), intent});
            return;
        }
        Intent intent2 = new Intent();
        if (intent != null && intent.getExtras() != null) {
            intent2.putExtras(intent.getExtras());
        }
        if (!LoginManager.k().q()) {
            z(context);
            return;
        }
        intent2.putExtra("from_where", "damai");
        x(context, intent2, i, cs.f);
    }

    private void t(Context context, String str, String str2, int i, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1787703425")) {
            ipChange.ipc$dispatch("-1787703425", new Object[]{this, context, str, str2, Integer.valueOf(i), intent});
            return;
        }
        Intent intent2 = new Intent();
        if (intent != null && intent.getExtras() != null) {
            intent2.putExtras(intent.getExtras());
        }
        if (!TextUtils.isEmpty(str)) {
            intent2.putExtra(l8.KEY_ARTIST_ID, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            intent2.putExtra("type", str2);
        }
        x(context, intent2, i, cs.PAGE_ARTIST_OFFICAL_CONTENT_LIST);
    }

    private void u(Context context, int i, Intent intent, Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1992467678")) {
            ipChange.ipc$dispatch("-1992467678", new Object[]{this, context, Integer.valueOf(i), intent, uri});
            return;
        }
        boolean booleanQueryParameter = uri.getBooleanQueryParameter("self", true);
        if (booleanQueryParameter && !LoginManager.k().q()) {
            z(context);
            return;
        }
        Bundle bundle = new Bundle();
        if (intent != null && intent.getExtras() != null) {
            bundle.putAll(intent.getExtras());
        }
        String queryParameter = uri.getQueryParameter("currentUserId");
        if (TextUtils.isEmpty(queryParameter)) {
            queryParameter = z20.i();
        }
        bundle.putString("userId", queryParameter);
        bundle.putString("targetIdStr", queryParameter);
        bundle.putBoolean("self", booleanQueryParameter);
        if (i != -1) {
            DMNav.from(context).stack(this.a).forResult(i).withExtras(bundle).toUri(cs.n());
        } else {
            DMNav.from(context).stack(this.a).withExtras(bundle).toUri(cs.n());
        }
    }

    private void v(Context context, Intent intent, int i, NavUri navUri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1259021269")) {
            ipChange.ipc$dispatch("-1259021269", new Object[]{this, context, intent, Integer.valueOf(i), navUri});
        } else {
            w(context, intent, i, navUri, null);
        }
    }

    private void w(Context context, Intent intent, int i, NavUri navUri, Intent intent2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "297358056")) {
            ipChange.ipc$dispatch("297358056", new Object[]{this, context, intent, Integer.valueOf(i), navUri, intent2});
            return;
        }
        DMNav from = DMNav.from(context);
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        if (intent2 != null && intent2.getExtras() != null) {
            extras.putAll(intent2.getExtras());
        }
        if (extras != null) {
            from = from.withExtras(extras);
        }
        if (i != -1 && (context instanceof Activity)) {
            from = from.forResult(i);
        }
        if (this.b) {
            from = from.withFlags(268435456);
        }
        Uri uri = this.a;
        if (uri != null) {
            from.stack(uri);
        }
        if (navUri != null) {
            from.toUri(navUri);
        }
    }

    private void x(Context context, Intent intent, int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1687755964")) {
            ipChange.ipc$dispatch("-1687755964", new Object[]{this, context, intent, Integer.valueOf(i), str});
        } else {
            w(context, intent, i, NavUri.b(str), null);
        }
    }

    private void y(Context context, Intent intent, int i, String str, Intent intent2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2097012481")) {
            ipChange.ipc$dispatch("2097012481", new Object[]{this, context, intent, Integer.valueOf(i), str, intent2});
        } else {
            w(context, intent, i, NavUri.b(str), intent2);
        }
    }

    private void z(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2145405405")) {
            ipChange.ipc$dispatch("-2145405405", new Object[]{this, context});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(d, e);
        DMNav.from(context).stack(this.a).withExtras(bundle).toUri(cs.f());
    }

    public void a(Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1018442982")) {
            ipChange.ipc$dispatch("1018442982", new Object[]{this, uri});
        } else {
            this.a = uri;
        }
    }

    public void q(Activity activity, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1065175733")) {
            ipChange.ipc$dispatch("-1065175733", new Object[]{this, activity, str});
        } else {
            r(activity, str, -1);
        }
    }

    public void r(Context context, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1676748512")) {
            ipChange.ipc$dispatch("1676748512", new Object[]{this, context, str, Integer.valueOf(i)});
        } else {
            s(context, str, i, false, null);
        }
    }

    public void s(Context context, String str, int i, boolean z, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1840534449")) {
            ipChange.ipc$dispatch("1840534449", new Object[]{this, context, str, Integer.valueOf(i), Boolean.valueOf(z), intent});
            return;
        }
        this.b = z;
        if (str != null && str.startsWith(SCHEME)) {
            d(context, str.substring(11, str.length()), null, i, intent);
            return;
        }
        ToastUtil.i("invalidate path:" + str);
    }
}
