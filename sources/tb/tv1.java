package tb;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.damai.category.ranking.ui.RankListFragment;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.imagebrowse.bean.PicInfo;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.evaluate.ui.NewEvaluateListActivity;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.trade.R$string;
import cn.damai.trade.newtradeorder.ui.projectdetail.common.bean.VenueBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.BrandAndArtists;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.PerformSeatImageBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectDynamicExtDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectStaticApproval;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectStaticDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectStaticEnterpriseInfo;
import cn.damai.trade.newtradeorder.ui.projectdetail.ui.activity.ProjectDetailActivity;
import cn.damai.user.userprofile.FeedsViewModel;
import com.alibaba.aliweex.adapter.module.location.ILocatable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class tv1 {
    private static transient /* synthetic */ IpChange $ipChange;

    private static String a(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1580520252") ? (String) ipChange.ipc$dispatch("1580520252", new Object[]{str}) : !TextUtils.isEmpty(str) ? String.format("%1$s%2$s", "￥", str) : "";
    }

    public static void b(ProjectDetailActivity projectDetailActivity, long j, ProjectStaticDataBean projectStaticDataBean) {
        ProjectStaticEnterpriseInfo projectStaticEnterpriseInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-677752779")) {
            ipChange.ipc$dispatch("-677752779", new Object[]{projectDetailActivity, Long.valueOf(j), projectStaticDataBean});
            return;
        }
        ProjectStaticApproval projectStaticApproval = projectStaticDataBean.itemExtendInfo.approvalVO;
        if (projectStaticApproval == null || (projectStaticEnterpriseInfo = projectStaticApproval.enterpriseInfo) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("approvalUrlList", (ArrayList) projectStaticApproval.approvalUrlList);
        bundle.putString("cpName", projectStaticEnterpriseInfo.cpName);
        bundle.putString("socialCreditCode", projectStaticEnterpriseInfo.socialCreditCode);
        bundle.putString("legalPerson", projectStaticEnterpriseInfo.legalPerson);
        bundle.putString("regCapStr", projectStaticEnterpriseInfo.regCapStr);
        bundle.putString("opFrom", projectStaticEnterpriseInfo.opFrom);
        bundle.putString("opTo", projectStaticEnterpriseInfo.opTo);
        bundle.putString("entType", projectStaticEnterpriseInfo.entType);
        bundle.putString("entAddress", projectStaticEnterpriseInfo.entAddress);
        DMNav.from(projectDetailActivity).withExtras(bundle).toUri(NavUri.b("project_cert_detail"));
    }

    public static void c(Context context, long j, long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1921952769")) {
            ipChange.ipc$dispatch("1921952769", new Object[]{context, Long.valueOf(j), Long.valueOf(j2)});
        } else if (context != null && j2 > 0) {
            cn.damai.common.user.c.e().x(pp2.u().V0(j));
            Bundle bundle = new Bundle();
            bundle.putLong(RankListFragment.KEY_RANK_ID, j2);
            DMNav.from(context).withExtras(bundle).toUri(NavUri.b("ranking"));
        }
    }

    public static void d(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1945279384")) {
            ipChange.ipc$dispatch("-1945279384", new Object[]{context, str});
        } else if (context == null || TextUtils.isEmpty(str)) {
        } else {
            DMNav.from(context).withExtras(new Bundle()).toUri(str);
        }
    }

    public static void e(ProjectStaticDataBean projectStaticDataBean, long j, Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1090733876")) {
            ipChange.ipc$dispatch("1090733876", new Object[]{projectStaticDataBean, Long.valueOf(j), context});
        } else if (projectStaticDataBean == null || context == null) {
        } else {
            cn.damai.common.user.c.e().x(pp2.u().S0(j));
            VenueBean venue = projectStaticDataBean.getVenue();
            if (venue == null || TextUtils.isEmpty(venue.getVenueName()) || venue.getVenueName().contains(cm2.b(context, R$string.damai_projectdetail_tbd))) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString(ILocatable.ADDRESS, venue.getVenueAddr());
            bundle.putString(FeedsViewModel.ARG_USERID, venue.getVenueId());
            bundle.putString("usertype", "3");
            DMNav.from(context).withExtras(bundle).toUri(NavUri.b(cs.ARTISTID_THEME));
        }
    }

    public static void f(ProjectStaticDataBean projectStaticDataBean, long j, Context context) {
        VenueBean venue;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1286126335")) {
            ipChange.ipc$dispatch("1286126335", new Object[]{projectStaticDataBean, Long.valueOf(j), context});
            return;
        }
        cn.damai.common.user.c.e().x(pp2.u().a0(j));
        if (projectStaticDataBean == null || context == null || (venue = projectStaticDataBean.getVenue()) == null || TextUtils.isEmpty(venue.getVenueName()) || venue.getVenueName().contains(cm2.b(context, R$string.damai_projectdetail_tbd))) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("name", venue.getVenueName());
        bundle.putLong("venueid", wh2.m(venue.getVenueId(), 0L));
        bundle.putLong("projectId", j);
        DMNav.from(context).forResult(4128).withExtras(bundle).toUri(NavUri.b("venuemap"));
    }

    public static void g(Context context, ProjectDynamicExtDataBean projectDynamicExtDataBean, long j, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-344795846")) {
            ipChange.ipc$dispatch("-344795846", new Object[]{context, projectDynamicExtDataBean, Long.valueOf(j), Integer.valueOf(i)});
        } else if (context == null || projectDynamicExtDataBean == null) {
        } else {
            if (yb.m(projectDynamicExtDataBean)) {
                cn.damai.common.user.c.e().x(pp2.u().v(j));
                q(context, j, yb.l(projectDynamicExtDataBean), yb.e(projectDynamicExtDataBean), i);
                return;
            }
            cn.damai.common.user.c.e().x(pp2.u().A0(j, i));
            ArrayList<PicInfo> e = yb.e(projectDynamicExtDataBean);
            if (e == null || e.isEmpty()) {
                return;
            }
            l(context, j, e, i);
        }
    }

    public static void h(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1894943917")) {
            ipChange.ipc$dispatch("1894943917", new Object[]{context, str});
        } else if (TextUtils.isEmpty(str) || context == null) {
        } else {
            DMNav.from(context).toUri(str);
        }
    }

    public static void i(Context context, long j, int i, ProjectItemBean projectItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-560651511")) {
            ipChange.ipc$dispatch("-560651511", new Object[]{context, Long.valueOf(j), Integer.valueOf(i), projectItemBean});
        } else if (projectItemBean != null) {
            cn.damai.common.user.c.e().x(pp2.u().L0(String.valueOf(j), projectItemBean.id, projectItemBean.alg, i));
            Bundle bundle = new Bundle();
            bundle.putString(IssueConstants.ProjectID, projectItemBean.id);
            bundle.putString("projectName", projectItemBean.name);
            bundle.putString("projectImage", projectItemBean.verticalPic);
            bundle.putString("projectPrice", a(projectItemBean.formattedPriceStr));
            qd2.a(context, projectItemBean.schema, bundle);
        }
    }

    public static void j(Context context, BrandAndArtists brandAndArtists, String str, int i, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1290991155")) {
            ipChange.ipc$dispatch("-1290991155", new Object[]{context, brandAndArtists, str, Integer.valueOf(i), str2});
        } else if (brandAndArtists == null || context == null) {
        } else {
            cn.damai.common.user.c e = cn.damai.common.user.c.e();
            pp2 u = pp2.u();
            e.x(u.g0(str, brandAndArtists.type + "", String.valueOf(brandAndArtists.id), i, str2));
            Bundle bundle = new Bundle();
            bundle.putString("artistid", String.valueOf(brandAndArtists.id));
            bundle.putString("artistname", brandAndArtists.name);
            DMNav.from(context).withExtras(bundle).toUri(NavUri.b(cs.ARTISTID_THEME));
        }
    }

    public static void k(Context context, BrandAndArtists brandAndArtists, String str, int i, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-542095245")) {
            ipChange.ipc$dispatch("-542095245", new Object[]{context, brandAndArtists, str, Integer.valueOf(i), str2});
        } else if (context == null || brandAndArtists == null) {
        } else {
            cn.damai.common.user.c e = cn.damai.common.user.c.e();
            pp2 u = pp2.u();
            e.x(u.g0(str, brandAndArtists.type + "", String.valueOf(brandAndArtists.id), i, str2));
            Bundle bundle = new Bundle();
            bundle.putString("brandid", brandAndArtists.id + "");
            bundle.putString("projectId", str);
            DMNav.from(context).withExtras(bundle).toUri(NavUri.b(cs.ARTISTID_THEME));
        }
    }

    public static void l(Context context, long j, ArrayList<PicInfo> arrayList, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-54225004")) {
            ipChange.ipc$dispatch("-54225004", new Object[]{context, Long.valueOf(j), arrayList, Integer.valueOf(i)});
        } else if (context == null) {
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("projectId", String.valueOf(j));
            bundle.putParcelableArrayList("pic_info", arrayList);
            bundle.putInt("position", i);
            DMNav.from(context).withExtras(bundle).toUri(cs.e());
        }
    }

    public static void m(Context context, String str, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1921553009")) {
            ipChange.ipc$dispatch("1921553009", new Object[]{context, str, Long.valueOf(j)});
        } else if (context != null) {
            cn.damai.common.user.c.e().x(pp2.u().s0(j, z20.E(), str));
            Bundle bundle = new Bundle();
            bundle.putString(g41.ISSUE_PARAM_COMMENT_ID, str);
            DMNav.from(context).withExtras(bundle).toUri(NavUri.b(cs.X));
        }
    }

    public static void n(Context context, long j, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1757289580")) {
            ipChange.ipc$dispatch("1757289580", new Object[]{context, Long.valueOf(j), str, str2, str3});
        } else if (context != null) {
            Bundle bundle = new Bundle();
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            bundle.putString(g41.ISSUE_PARAM_IPID, str);
            bundle.putLong("itemId", j);
            bundle.putString("tourId", str2);
            bundle.putString("contentId", str3);
            bundle.putBoolean(NewEvaluateListActivity.IS_ALLOW_SHOW_WANT_GUIDE, true);
            bundle.putString(NewEvaluateListActivity.TOWHERE_TAG, NewEvaluateListActivity.TOWHERE_EVALUATE);
            DMNav.from(context).withExtras(bundle).toUri(NavUri.b(cs.W));
        }
    }

    public static void o(Context context, long j, String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1713795212")) {
            ipChange.ipc$dispatch("-1713795212", new Object[]{context, Long.valueOf(j), str, str2, str3, str4, str5});
        } else if (context != null) {
            Bundle bundle = new Bundle();
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            bundle.putString(g41.ISSUE_PARAM_IPID, str);
            bundle.putLong("itemId", j);
            bundle.putString("tourId", str2);
            bundle.putString("labelName", str3);
            bundle.putString("labelType", str4);
            bundle.putString("labelId", str5);
            bundle.putBoolean(NewEvaluateListActivity.IS_ALLOW_SHOW_WANT_GUIDE, true);
            bundle.putString(NewEvaluateListActivity.TOWHERE_TAG, NewEvaluateListActivity.TOWHERE_EVALUATE);
            DMNav.from(context).withExtras(bundle).toUri(NavUri.b(cs.W));
        }
    }

    public static void p(Context context, long j, List<String> list, List<PerformSeatImageBean> list2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "300954931")) {
            ipChange.ipc$dispatch("300954931", new Object[]{context, Long.valueOf(j), list, list2, Boolean.valueOf(z)});
        } else if (context != null) {
            int e = wh2.e(list);
            if (e == 0 && (list2 == null || list2.size() == 0)) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            if (list2 == null || list2.size() <= 0) {
                for (int i = 0; i < e; i++) {
                    PicInfo picInfo = new PicInfo();
                    picInfo.setPicUrl(list.get(i));
                    arrayList.add(picInfo);
                }
            } else {
                for (int i2 = 0; i2 < list2.size(); i2++) {
                    PicInfo picInfo2 = new PicInfo();
                    picInfo2.setPicUrl(list2.get(i2).getSeatImg());
                    picInfo2.setPicTitle(list2.get(i2).getPerformName());
                    arrayList.add(picInfo2);
                }
            }
            l(context, j, arrayList, 0);
            cn.damai.common.user.c.e().x(pp2.u().N0(j, z));
        }
    }

    public static void q(Context context, long j, ArrayList<VideoInfo> arrayList, ArrayList<PicInfo> arrayList2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1297159017")) {
            ipChange.ipc$dispatch("1297159017", new Object[]{context, Long.valueOf(j), arrayList, arrayList2, Integer.valueOf(i)});
        } else if (context != null) {
            Bundle bundle = new Bundle();
            bundle.putString("projectId", String.valueOf(j));
            for (int i2 = 0; i2 < wh2.e(arrayList); i2++) {
                if (!TextUtils.isEmpty(arrayList.get(i2).getVideoUrl())) {
                    arrayList.get(i2).setType(VideoInfo.VideoType.VIDEO_URL);
                }
            }
            bundle.putParcelableArrayList("video_info", arrayList);
            bundle.putParcelableArrayList("pic_info", arrayList2);
            bundle.putInt("position", i);
            DMNav.from(context).withExtras(bundle).toUri(NavUri.b("videobrowse"));
        }
    }
}
