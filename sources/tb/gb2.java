package tb;

import cn.damai.common.user.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class gb2 extends cn.damai.common.user.b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String MESSAGE_PUSH_SETTING_PAGE = "setting_msgpush";
    public static final String MY_ABOUT_PAGE = "about";
    public static final String SETTING_PAGE = "setting";

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    private static class b {
        private static final gb2 a = new gb2();
    }

    public static final gb2 g() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2002163291") ? (gb2) ipChange.ipc$dispatch("-2002163291", new Object[0]) : b.a;
    }

    public a.b f() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1910556014") ? (a.b) ipChange.ipc$dispatch("-1910556014", new Object[]{this}) : b(MY_ABOUT_PAGE);
    }

    public a.b h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1708394074")) {
            return (a.b) ipChange.ipc$dispatch("1708394074", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("titlelabel", "消息推送");
        return e(MESSAGE_PUSH_SETTING_PAGE, "list", "push_mark", hashMap, Boolean.FALSE);
    }

    public a.b i() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1723528090") ? (a.b) ipChange.ipc$dispatch("-1723528090", new Object[]{this}) : b(MESSAGE_PUSH_SETTING_PAGE);
    }

    public a.b j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1445371755")) {
            return (a.b) ipChange.ipc$dispatch("-1445371755", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("titlelabel", "消息推送");
        return e(MESSAGE_PUSH_SETTING_PAGE, "list", "marketingmsg_mark", hashMap, Boolean.FALSE);
    }

    public a.b k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1614224596")) {
            return (a.b) ipChange.ipc$dispatch("-1614224596", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("titlelabel", "关于大麦");
        return e("setting", "list", MY_ABOUT_PAGE, hashMap, Boolean.TRUE);
    }

    public a.b l() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-906707911")) {
            return (a.b) ipChange.ipc$dispatch("-906707911", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("titlelabel", "账号安全");
        return e("setting", "list", vf1.MY_ACCOUTMANAGE_SAFE_PAGE, hashMap, Boolean.TRUE);
    }

    public a.b m() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-866003248")) {
            return (a.b) ipChange.ipc$dispatch("-866003248", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("titlelabel", "检查更新");
        return e("setting", "list", "updatecheck", hashMap, Boolean.FALSE);
    }

    public a.b n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "818363122")) {
            return (a.b) ipChange.ipc$dispatch("818363122", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("titlelabel", "清空缓存");
        return e("setting", "list", "clear_cache", hashMap, Boolean.FALSE);
    }

    public a.b o() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-653258922")) {
            return (a.b) ipChange.ipc$dispatch("-653258922", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("titlelabel", "客服中心");
        return e("setting", "list", "customer_service_phone", hashMap, Boolean.TRUE);
    }

    public a.b p() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1100751106")) {
            return (a.b) ipChange.ipc$dispatch("1100751106", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("titlelabel", "意见反馈");
        return e("setting", "list", "feedback", hashMap, Boolean.TRUE);
    }

    public a.b q() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1791067198")) {
            return (a.b) ipChange.ipc$dispatch("1791067198", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("titlelabel", "帮助中心");
        return e("setting", "list", "help", hashMap, Boolean.TRUE);
    }

    public a.b r() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1236774745")) {
            return (a.b) ipChange.ipc$dispatch("-1236774745", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("titlelabel", "退出登陆");
        return e("setting", "list", "logout", hashMap, Boolean.FALSE);
    }

    public a.b s() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1316033001")) {
            return (a.b) ipChange.ipc$dispatch("-1316033001", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("titlelabel", "设置");
        return e("setting", "list", "msgpush", hashMap, Boolean.TRUE);
    }

    public a.b t() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1773097391") ? (a.b) ipChange.ipc$dispatch("1773097391", new Object[]{this}) : b("setting");
    }

    private gb2() {
    }
}
