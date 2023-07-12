package tb;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import cn.damai.user.userprofile.bean.ArticleFeedData;
import cn.damai.user.userprofile.bean.CommentFeedData;
import cn.damai.user.userprofile.bean.DynamicFeedData;
import cn.damai.user.userprofile.bean.FeedMergeDataDO;
import cn.damai.user.userprofile.bean.FollowFeedData;
import cn.damai.user.userprofile.bean.UserData;
import com.alibaba.aliweex.adapter.module.location.ILocatable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.tencent.open.SocialConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class kv2 {
    private static transient /* synthetic */ IpChange $ipChange;
    public String a = iv2.USER_HOME_PAGE;
    public Map b;

    public static String b(FeedMergeDataDO feedMergeDataDO) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1947734834")) {
            return (String) ipChange.ipc$dispatch("-1947734834", new Object[]{feedMergeDataDO});
        }
        if (feedMergeDataDO == null) {
            return null;
        }
        List<DynamicFeedData> list = feedMergeDataDO.dynamicData;
        if (list != null && list.get(0) != null) {
            return feedMergeDataDO.dynamicData.get(0).bizId;
        }
        List<CommentFeedData> list2 = feedMergeDataDO.commentData;
        if (list2 != null && list2.get(0) != null) {
            return feedMergeDataDO.commentData.get(0).bizId;
        }
        List<FollowFeedData> list3 = feedMergeDataDO.followData;
        if (list3 != null && list3.get(0) != null) {
            return feedMergeDataDO.followData.get(0).bizId;
        }
        List<ArticleFeedData> list4 = feedMergeDataDO.articleData;
        if (list4 == null || list4.get(0) == null) {
            return null;
        }
        return feedMergeDataDO.articleData.get(0).bizId;
    }

    private Map<String, Object> c(UserData userData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1663742846")) {
            return (Map) ipChange.ipc$dispatch("-1663742846", new Object[]{this, userData});
        }
        HashMap hashMap = new HashMap();
        String str = userData.nickname;
        long j = userData.bid;
        if (j != 0) {
            hashMap.put("id", Long.valueOf(j));
        } else {
            hashMap.put("id", userData.userId);
        }
        if (userData.vaccount) {
            hashMap.put("showv", "true");
        }
        hashMap.put("name", str);
        hashMap.put(ILocatable.ADDRESS, userData.city);
        hashMap.put(SocialConstants.PARAM_APP_DESC, userData.summary);
        hashMap.put("headpic", userData.headImg);
        hashMap.put("sex", Integer.valueOf(userData.sex));
        hashMap.put("bg", userData.headBgImg);
        hashMap.put("birthday", userData.birthday);
        hashMap.put("self", userData.mySelf ? "1" : "0");
        hashMap.put("followstate", Integer.valueOf(userData.favoriteFlag));
        hashMap.put("lcount", Long.valueOf(userData.focusNum));
        hashMap.put("fcount", Long.valueOf(userData.fansNum));
        hashMap.put("followdesc", userData.commonInfo);
        hashMap.put("type", Integer.valueOf(userData.type));
        hashMap.put("buser", Boolean.valueOf(userData.vaccount));
        hashMap.put("bname", userData.nickname);
        hashMap.put("bid", Long.valueOf(userData.bid));
        hashMap.put("talkId", userData.talkId);
        hashMap.put("talkInfo", userData.talkInfo);
        hashMap.put("talkUserImg", userData.talkUserImg);
        return hashMap;
    }

    public static void e(Context context, String str, String str2, String str3, boolean z, Map map, Map map2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "157164500")) {
            ipChange.ipc$dispatch("157164500", new Object[]{context, str, str2, str3, Boolean.valueOf(z), map, map2});
        } else if (context instanceof FragmentActivity) {
            HashMap hashMap = new HashMap();
            hashMap.put("usercode", z20.E());
            if (map != null) {
                hashMap.put("biz_id", map.get("id") + "");
                hashMap.put("biz_type", map.get("type") + "");
                if (map.containsKey("talkId")) {
                    hashMap.put("chat_group_id", map.get("talkId") + "");
                }
                hashMap.put(u12.VIEW_TYPE, map.get("self") + "");
            }
            if (map2 != null) {
                hashMap.putAll(map2);
            }
            if (str == null) {
                str = iv2.USER_HOME_PAGE;
            }
            cn.damai.common.user.c.e().x(new cn.damai.common.user.b().e(str, str2, str3, hashMap, Boolean.valueOf(z)));
        }
    }

    public static void f(Context context, String str, String str2, String str3, boolean z, boolean z2, Map map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2051899301")) {
            ipChange.ipc$dispatch("2051899301", new Object[]{context, str, str2, str3, Boolean.valueOf(z), Boolean.valueOf(z2), map});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("self", z2 ? "1" : "0");
        e(context, str, str2, str3, z, hashMap, map);
    }

    public void a(UserData userData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1077483479")) {
            ipChange.ipc$dispatch("-1077483479", new Object[]{this, userData});
        } else {
            this.b = c(userData);
        }
    }

    public void d(int i, Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-684514349")) {
            ipChange.ipc$dispatch("-684514349", new Object[]{this, Integer.valueOf(i), activity});
            return;
        }
        if (i == 5) {
            this.a = u12.REPERTOITE;
        } else if (i != 1) {
            this.a = "business_homepage";
        }
        cn.damai.common.user.c.e().L(activity, this.a);
    }

    public void g(String str, String str2, String str3, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1111863408")) {
            ipChange.ipc$dispatch("1111863408", new Object[]{this, str, str2, str3, Boolean.valueOf(z)});
        } else {
            i(str, str2, str3, z, this.b, null);
        }
    }

    public void h(String str, String str2, String str3, boolean z, Map map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2076654869")) {
            ipChange.ipc$dispatch("2076654869", new Object[]{this, str, str2, str3, Boolean.valueOf(z), map});
        } else {
            i(str, str2, str3, z, this.b, map);
        }
    }

    public void i(String str, String str2, String str3, boolean z, Map map, Map map2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "411054544")) {
            ipChange.ipc$dispatch("411054544", new Object[]{this, str, str2, str3, Boolean.valueOf(z), map, map2});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        if (map != null) {
            hashMap.put("biz_id", map.get("id") + "");
            hashMap.put("biz_type", map.get("type") + "");
            if (map.containsKey("talkId")) {
                hashMap.put("chat_group_id", map.get("talkId") + "");
            }
            hashMap.put(u12.VIEW_TYPE, map.get("self") + "");
        }
        if (map2 != null) {
            hashMap.putAll(map2);
        }
        cn.damai.common.user.c.e().x(new cn.damai.common.user.b().e(str, str2, str3, hashMap, Boolean.valueOf(z)));
    }
}
