package tb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import cn.damai.common.DamaiConstants;
import cn.damai.common.nav.DMNav;
import cn.damai.commonbusiness.model.UserBaseInfoBean;
import cn.damai.commonbusiness.model.UserData;
import cn.damai.commonbusiness.model.UserVipBean;
import cn.damai.im.UserInfoUtil;
import cn.damai.login.LoginManager;
import cn.damai.mine.userinfo.bean.UserCenterDataBean;
import cn.damai.user.userhome.bean.UserInfoBean;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.login4android.Login;
import java.util.Random;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class wf1 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static String a(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-320268576")) {
            return (String) ipChange.ipc$dispatch("-320268576", new Object[]{Integer.valueOf(i)});
        }
        if (i > 10000) {
            return (i / 10000) + "." + ((i % 10000) / 1000) + "万";
        }
        return String.valueOf(i);
    }

    public static UserCenterDataBean b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-472157226")) {
            return (UserCenterDataBean) ipChange.ipc$dispatch("-472157226", new Object[0]);
        }
        String E = z20.E();
        if (!d() || TextUtils.isEmpty(E)) {
            return null;
        }
        try {
            return (UserCenterDataBean) JSON.parseObject(z20.D(E), UserCenterDataBean.class);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void c(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1299955272")) {
            ipChange.ipc$dispatch("-1299955272", new Object[]{activity});
        } else if (activity == null || activity.isFinishing()) {
        } else {
            DMNav.from(activity).withExtras(new Bundle()).toUri(cs.f());
        }
    }

    public static boolean d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1188593088") ? ((Boolean) ipChange.ipc$dispatch("-1188593088", new Object[0])).booleanValue() : LoginManager.k().q();
    }

    public static void e(UserCenterDataBean userCenterDataBean) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1567347314")) {
            ipChange.ipc$dispatch("1567347314", new Object[]{userCenterDataBean});
            return;
        }
        String E = z20.E();
        if (!d() || TextUtils.isEmpty(E) || userCenterDataBean == null) {
            return;
        }
        if (userCenterDataBean.getUserInfo() != null) {
            String imgUrl = userCenterDataBean.getUserInfo().getImgUrl();
            if (!TextUtils.isEmpty(imgUrl) && imgUrl.contains("?")) {
                str = imgUrl + "&ran=" + new Random().nextInt();
            } else {
                str = imgUrl + "?ran=" + new Random().nextInt();
            }
            userCenterDataBean.getUserInfo().setImgUrl(str);
            z20.T(Login.getHeadPicLink(), str);
        }
        z20.w0(E, JSON.toJSONString(userCenterDataBean));
        UserInfoUtil.e(new UserVipBean(userCenterDataBean.isVip(), userCenterDataBean.getVipLevel() + "", userCenterDataBean.getVipLevelIcon()));
    }

    public static void f(FragmentActivity fragmentActivity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "24777046")) {
            ipChange.ipc$dispatch("24777046", new Object[]{fragmentActivity});
        } else if (fragmentActivity != null) {
            try {
                Intent intent = new Intent();
                intent.setAction(DamaiConstants.TICKLET_EXTERNAL_CALL_BRODCAST_ACTION);
                intent.setPackage("cn.damai");
                intent.putExtra("type", 3);
                intent.putExtra("from", "mine_preload");
                intent.putExtra("downTime", false);
                fragmentActivity.sendBroadcast(intent);
            } catch (Exception e) {
                p3.a("damai_member", "member_service_start", "mine_sync", e.getMessage());
            }
        }
    }

    public static void g(UserInfoBean userInfoBean) {
        UserBaseInfoBean userBaseInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-249463162")) {
            ipChange.ipc$dispatch("-249463162", new Object[]{userInfoBean});
            return;
        }
        UserData a = UserInfoUtil.a();
        if (a == null || (userBaseInfo = a.getUserBaseInfo()) == null) {
            return;
        }
        userBaseInfo.setHeadImg(userInfoBean.getImgUrl());
        userBaseInfo.setNickname(userInfoBean.getUserNick());
        userBaseInfo.setVip(userInfoBean.isVip());
        userBaseInfo.setVipLevel(userInfoBean.getVipLevel());
        userBaseInfo.setVipLevelIcon(userInfoBean.getVipLevelIcon());
        userBaseInfo.setBirthday(userInfoBean.birthday);
        userBaseInfo.setSex(userInfoBean.sex);
        userBaseInfo.setUserIntro(userInfoBean.userIntro);
        a.setUserBaseInfo(userBaseInfo);
        UserInfoUtil.d(a);
    }
}
