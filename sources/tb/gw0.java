package tb;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.imagebrowse.bean.PicInfo;
import cn.damai.commonbusiness.model.RealNameAuthStatusBean;
import cn.damai.user.ModifyAvatarActivity;
import cn.damai.user.userhome.bean.UserHomeDataBean;
import cn.damai.user.userhome.bean.UserInfoBean;
import com.ali.user.mobile.model.TokenType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Random;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class gw0 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(UserHomeDataBean userHomeDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1299245471")) {
            ipChange.ipc$dispatch("1299245471", new Object[]{userHomeDataBean});
        } else if (userHomeDataBean == null || userHomeDataBean.getUserInfo() == null) {
        } else {
            UserInfoBean userInfo = userHomeDataBean.getUserInfo();
            String imgUrl = userInfo.getImgUrl();
            if (TextUtils.isEmpty(imgUrl)) {
                return;
            }
            try {
                Uri parse = Uri.parse(imgUrl);
                if (TextUtils.isEmpty(parse.getQueryParameter("ran"))) {
                    Uri.Builder buildUpon = parse.buildUpon();
                    userInfo.setImgUrl(buildUpon.appendQueryParameter("ran", new Random().nextInt() + "").build().toString());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String b(UserHomeDataBean userHomeDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "50578488")) {
            return (String) ipChange.ipc$dispatch("50578488", new Object[]{userHomeDataBean});
        }
        UserInfoBean d = d(userHomeDataBean);
        if (d != null) {
            return d.getImgUrl();
        }
        return null;
    }

    public static String c(UserHomeDataBean userHomeDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1803426569")) {
            return (String) ipChange.ipc$dispatch("-1803426569", new Object[]{userHomeDataBean});
        }
        UserInfoBean d = d(userHomeDataBean);
        if (d != null) {
            return d.headBgImg;
        }
        return null;
    }

    public static UserInfoBean d(UserHomeDataBean userHomeDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1634114794")) {
            return (UserInfoBean) ipChange.ipc$dispatch("-1634114794", new Object[]{userHomeDataBean});
        }
        if (userHomeDataBean != null) {
            return userHomeDataBean.getUserInfo();
        }
        return null;
    }

    public static void e(Activity activity, RealNameAuthStatusBean realNameAuthStatusBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-240574114")) {
            ipChange.ipc$dispatch("-240574114", new Object[]{activity, realNameAuthStatusBean});
        } else if (realNameAuthStatusBean == null || activity == null) {
        } else {
            int accountVerifyCode = realNameAuthStatusBean.getAccountVerifyCode();
            if (accountVerifyCode == 1) {
                Bundle bundle = new Bundle();
                bundle.putBoolean(TokenType.LOGIN, false);
                DMNav.from(activity).withExtras(bundle).toUri(cs.i());
            } else if (accountVerifyCode == 5) {
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("authBean", realNameAuthStatusBean);
                DMNav.from(activity).withExtras(bundle2).toUri(NavUri.b(cs.U));
            }
        }
    }

    public static void f(Activity activity, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1120118480")) {
            ipChange.ipc$dispatch("-1120118480", new Object[]{activity, str});
        } else if (activity == null) {
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("mtopapi", "mtop.damai.wireless.user.uploadHeadImg");
            bundle.putString("title", null);
            bundle.putString(ModifyAvatarActivity.MODIFY_AVATAR, str);
            bundle.putString(ModifyAvatarActivity.FROM_WHERE, ModifyAvatarActivity.FROM_MODIFY_USERR_HEAD);
            DMNav.from(activity).withExtras(bundle).needLogin().toUri(NavUri.b("modifyavatar"));
        }
    }

    public static void g(Activity activity, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1900668384")) {
            ipChange.ipc$dispatch("-1900668384", new Object[]{activity, str});
        } else if (activity == null || TextUtils.isEmpty(str)) {
        } else {
            Bundle bundle = new Bundle();
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            PicInfo picInfo = new PicInfo();
            picInfo.setPicUrl(str);
            picInfo.setPicDesc("");
            arrayList.add(picInfo);
            bundle.putParcelableArrayList("pic_info", arrayList);
            bundle.putInt("position", 0);
            DMNav.from(activity).withExtras(bundle).toUri(cs.e());
        }
    }

    public static void h(Activity activity, String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "47654063")) {
            ipChange.ipc$dispatch("47654063", new Object[]{activity, str, Boolean.valueOf(z)});
        } else if (activity == null || TextUtils.isEmpty(str)) {
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("userId", str);
            bundle.putString("relationType", "2");
            bundle.putString("targetType", "1");
            bundle.putString("targetId", str);
            bundle.putBoolean("self", z);
            DMNav.from(activity).withExtras(bundle).toUri(cs.j());
        }
    }

    public static void i(Activity activity, String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "155113776")) {
            ipChange.ipc$dispatch("155113776", new Object[]{activity, str, Boolean.valueOf(z)});
        } else if (activity == null || TextUtils.isEmpty(str)) {
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("userId", str);
            bundle.putString("relationType", "1");
            bundle.putBoolean("self", z);
            DMNav.from(activity).withExtras(bundle).toUri(cs.j());
        }
    }

    public static void j(Activity activity, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-936491344")) {
            ipChange.ipc$dispatch("-936491344", new Object[]{activity, str});
        } else if (activity == null) {
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("mtopapi", "mtop.damai.wireless.user.saveUserProfile");
            bundle.putString("title", "设置背景");
            bundle.putInt(ModifyAvatarActivity.IMG_CORP_TYPE, ModifyAvatarActivity.IMG_CORP_TYPE_169);
            bundle.putString(ModifyAvatarActivity.MODIFY_AVATAR, str);
            bundle.putString(ModifyAvatarActivity.FROM_WHERE, ModifyAvatarActivity.FROM_MODIFY_BIG_IMG);
            DMNav.from(activity).withExtras(bundle).toUri(NavUri.b("modifyavatar"));
        }
    }

    public static void k(Activity activity, UserInfoBean userInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1670392359")) {
            ipChange.ipc$dispatch("-1670392359", new Object[]{activity, userInfoBean});
        } else if (activity == null || userInfoBean == null) {
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("nickName", userInfoBean.getUserNick());
            bundle.putString("userIntro", userInfoBean.userIntro);
            bundle.putString("birthday", userInfoBean.birthday);
            bundle.putInt("sex", userInfoBean.sex);
            DMNav.from(activity).withExtras(bundle).toUri(NavUri.b("editaccount"));
        }
    }

    public static void l(Activity activity, String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-877199780")) {
            ipChange.ipc$dispatch("-877199780", new Object[]{activity, str, Boolean.valueOf(z)});
        } else if (activity == null || TextUtils.isEmpty(str)) {
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("targetIdStr", str);
            bundle.putBoolean("self", z);
            DMNav.from(activity).withExtras(bundle).toUri(cs.n());
        }
    }
}
