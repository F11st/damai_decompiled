package cn.damai.h5container;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.user.userprofile.FeedsViewModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Set;
import tb.cb2;
import tb.cs;
import tb.l8;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class NativePageInterceptor {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int PAGE_CLUB = 3;
    public static final String PAGE_CLUB_PAGE = "app/dmfe/star/pages/home/index.html";
    public static final int PAGE_CONTENT = 1;
    public static final int PAGE_NONE = 0;
    public static final int PAGE_THEME = 2;
    public static final String PATH_CONTENT_PAGE = "damai/activity/discover/detail.html";
    public static final String PATH_THEME_PAGE = "damai/activity/discover/themepage.html";

    public static void interceptToNativePage(Activity activity, int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1278027634")) {
            ipChange.ipc$dispatch("1278027634", new Object[]{activity, Integer.valueOf(i), str});
        } else if (activity != null && !TextUtils.isEmpty(str)) {
            Bundle bundle = new Bundle();
            String str2 = null;
            if (i == 1) {
                saveBundle(bundle, str);
                str2 = cs.DISCOVER_CONTENT_DETAIL;
            } else if (i == 2) {
                saveBundle(bundle, str);
                str2 = cs.DISCOVER_THEME;
            } else if (i == 3) {
                Uri parse = Uri.parse(str);
                Set<String> queryParameterNames = parse.getQueryParameterNames();
                if (!cb2.d(queryParameterNames)) {
                    for (String str3 : queryParameterNames) {
                        String queryParameter = parse.getQueryParameter(str3);
                        if (l8.KEY_ARTIST_ID.equals(queryParameter)) {
                            bundle.putString(FeedsViewModel.ARG_USERID, queryParameter);
                        } else {
                            bundle.putString(str3, queryParameter);
                        }
                    }
                }
                bundle.putString("usertype", "2");
                str2 = cs.ARTISTID_THEME;
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            DMNav.from(activity).withExtras(bundle).toUri(NavUri.b(str2));
        }
    }

    private static void saveBundle(Bundle bundle, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1039702145")) {
            ipChange.ipc$dispatch("-1039702145", new Object[]{bundle, str});
            return;
        }
        try {
            Uri parse = Uri.parse(str);
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            if (cb2.d(queryParameterNames)) {
                return;
            }
            for (String str2 : queryParameterNames) {
                bundle.putString(str2, parse.getQueryParameter(str2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int shouldIntercept(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1403870182")) {
            return ((Integer) ipChange.ipc$dispatch("-1403870182", new Object[]{str})).intValue();
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                Uri parse = Uri.parse(str);
                String path = parse.getPath();
                if (!TextUtils.isEmpty(path)) {
                    if (path.contains(PATH_CONTENT_PAGE)) {
                        if (wh2.h(parse.getQueryParameter("contentId"))) {
                            return 1;
                        }
                    } else if (path.contains(PATH_THEME_PAGE)) {
                        if (wh2.h(parse.getQueryParameter("themeId"))) {
                            return 2;
                        }
                    } else if (path.contains(PAGE_CLUB_PAGE) && wh2.h(parse.getQueryParameter(l8.KEY_ARTIST_ID))) {
                        return 3;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
