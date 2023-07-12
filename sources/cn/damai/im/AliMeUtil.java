package cn.damai.im;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import cn.damai.common.nav.DMNav;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.model.AliMeTokenInfo;
import cn.damai.im.request.AliMeTokenRequest;
import cn.damai.login.LoginManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import tb.cs;
import tb.mu0;
import tb.vd1;
import tb.wh2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class AliMeUtil {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String FROM_ACT = "damai_act";
    public static final String FROM_MESSAGE = "damai_msgbox";
    public static final String FROM_MINE = "damai_my";
    public static final String FROM_ORDER_DETAILS = "damai_orderdetail";
    public static final String FROM_ORDER_DETAIL_QUEST = "iUDekVTy3V";
    public static final String FROM_PROJECT_COMMON_PROBLEM = "2HoHjCkg7r";
    public static final String FROM_PROJECT_DETAIL = "damai_itemdetail";
    public static final String FROM_REALNAME_AUTH = "gNmJo1Iie8";
    public static final String FROM_SERVICE = "scfLHscDFa";
    public static final String FROM_SERVICE_PROBLEM = "que7SHuM7F";
    public static final String SESSION_COUPON_DETAIL = "ThV7YhIIcU";
    public static final String SESSION_COUPON_ORDER_DETAIL = "HKBKjpGqSO";
    public static final String SESSION_SCRIPT_COUPON_DETAIL = "K3WTW8mCj6";
    private static String a = "";

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public interface AliMeTokenListener {
        void onFailed();

        void onSuccess(String str);
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public interface OnAliMeTokenListener {
        void onFailed(String str, String str2);

        void onSuccess(String str);
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public interface UserCodeListener {
        void onFailed();

        void onSuccess(long j);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.im.AliMeUtil$a */
    /* loaded from: classes5.dex */
    public class C1272a implements UserCodeListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ long b;
        final /* synthetic */ Context c;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.im.AliMeUtil$a$a */
        /* loaded from: classes5.dex */
        public class C1273a implements AliMeTokenListener {
            private static transient /* synthetic */ IpChange $ipChange;

            C1273a() {
            }

            @Override // cn.damai.im.AliMeUtil.AliMeTokenListener
            public void onFailed() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-21095515")) {
                    ipChange.ipc$dispatch("-21095515", new Object[]{this});
                } else {
                    AliMeUtil.o();
                }
            }

            @Override // cn.damai.im.AliMeUtil.AliMeTokenListener
            public void onSuccess(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1436629807")) {
                    ipChange.ipc$dispatch("1436629807", new Object[]{this, str});
                    return;
                }
                String c = AliMeUtil.c(C1272a.this.a, str);
                AliMeUtil.b(C1272a.this.c, c + "&projectId=" + C1272a.this.b);
            }
        }

        C1272a(String str, long j, Context context) {
            this.a = str;
            this.b = j;
            this.c = context;
        }

        @Override // cn.damai.im.AliMeUtil.UserCodeListener
        public void onFailed() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "13531288")) {
                ipChange.ipc$dispatch("13531288", new Object[]{this});
            } else {
                AliMeUtil.o();
            }
        }

        @Override // cn.damai.im.AliMeUtil.UserCodeListener
        public void onSuccess(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1449105678")) {
                ipChange.ipc$dispatch("-1449105678", new Object[]{this, Long.valueOf(j)});
            } else {
                AliMeUtil.e(j, this.a, new C1273a());
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.im.AliMeUtil$b */
    /* loaded from: classes5.dex */
    public class C1274b implements UserCodeListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ Context d;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.im.AliMeUtil$b$a */
        /* loaded from: classes5.dex */
        public class C1275a implements AliMeTokenListener {
            private static transient /* synthetic */ IpChange $ipChange;

            C1275a() {
            }

            @Override // cn.damai.im.AliMeUtil.AliMeTokenListener
            public void onFailed() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1332214182")) {
                    ipChange.ipc$dispatch("1332214182", new Object[]{this});
                } else {
                    AliMeUtil.o();
                }
            }

            @Override // cn.damai.im.AliMeUtil.AliMeTokenListener
            public void onSuccess(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-908037234")) {
                    ipChange.ipc$dispatch("-908037234", new Object[]{this, str});
                } else if (!TextUtils.isEmpty(str)) {
                    C1274b c1274b = C1274b.this;
                    AliMeUtil.b(C1274b.this.d, AliMeUtil.f(c1274b.a, str, c1274b.b, c1274b.c));
                } else {
                    AliMeUtil.o();
                }
            }
        }

        C1274b(String str, String str2, String str3, Context context) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = context;
        }

        @Override // cn.damai.im.AliMeUtil.UserCodeListener
        public void onFailed() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1521083097")) {
                ipChange.ipc$dispatch("1521083097", new Object[]{this});
            } else {
                AliMeUtil.o();
            }
        }

        @Override // cn.damai.im.AliMeUtil.UserCodeListener
        public void onSuccess(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-95795981")) {
                ipChange.ipc$dispatch("-95795981", new Object[]{this, Long.valueOf(j)});
            } else {
                AliMeUtil.e(j, this.a, new C1275a());
            }
        }
    }

    public static void b(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1855972401")) {
            ipChange.ipc$dispatch("1855972401", new Object[]{context, str});
            return;
        }
        Intent intent = new Intent(context, AliMeActivity.class);
        intent.putExtra("url", str);
        context.startActivity(intent);
    }

    public static String c(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1745566092")) {
            return (String) ipChange.ipc$dispatch("1745566092", new Object[]{str, str2});
        }
        return "https://ai.alimebot.taobao.com/intl/index.htm?from=" + str + "&v=3&_user_access_token=" + str2;
    }

    public static void d(int i, String str, final OnAliMeTokenListener onAliMeTokenListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1380063454")) {
            ipChange.ipc$dispatch("1380063454", new Object[]{Integer.valueOf(i), str, onAliMeTokenListener});
            return;
        }
        AliMeTokenRequest aliMeTokenRequest = new AliMeTokenRequest();
        aliMeTokenRequest.userCode = String.valueOf(i);
        aliMeTokenRequest.from = str;
        aliMeTokenRequest.v = "3";
        aliMeTokenRequest.request(new DMMtopRequestListener<AliMeTokenInfo>(AliMeTokenInfo.class) { // from class: cn.damai.im.AliMeUtil.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1387166122")) {
                    ipChange2.ipc$dispatch("1387166122", new Object[]{this, str2, str3});
                    return;
                }
                OnAliMeTokenListener onAliMeTokenListener2 = onAliMeTokenListener;
                if (onAliMeTokenListener2 != null) {
                    onAliMeTokenListener2.onFailed(str2, str3);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(AliMeTokenInfo aliMeTokenInfo) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "342909218")) {
                    ipChange2.ipc$dispatch("342909218", new Object[]{this, aliMeTokenInfo});
                } else if (aliMeTokenInfo != null) {
                    OnAliMeTokenListener onAliMeTokenListener2 = onAliMeTokenListener;
                    if (onAliMeTokenListener2 != null) {
                        onAliMeTokenListener2.onSuccess(aliMeTokenInfo.getResult());
                    }
                } else {
                    OnAliMeTokenListener onAliMeTokenListener3 = onAliMeTokenListener;
                    if (onAliMeTokenListener3 != null) {
                        onAliMeTokenListener3.onFailed("", "");
                    }
                }
            }
        });
    }

    public static void e(long j, String str, final AliMeTokenListener aliMeTokenListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-548100930")) {
            ipChange.ipc$dispatch("-548100930", new Object[]{Long.valueOf(j), str, aliMeTokenListener});
            return;
        }
        AliMeTokenRequest aliMeTokenRequest = new AliMeTokenRequest();
        aliMeTokenRequest.userCode = String.valueOf(j);
        aliMeTokenRequest.from = str;
        aliMeTokenRequest.v = "3";
        aliMeTokenRequest.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
        aliMeTokenRequest.sign = vd1.d(aliMeTokenRequest.toSignParamMap());
        aliMeTokenRequest.request(new DMMtopRequestListener<AliMeTokenInfo>(AliMeTokenInfo.class) { // from class: cn.damai.im.AliMeUtil.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1394925481")) {
                    ipChange2.ipc$dispatch("1394925481", new Object[]{this, str2, str3});
                } else if (aliMeTokenListener != null) {
                    if ("FAIL_SYS_SESSION_EXPIRED".equals(str2)) {
                        String unused = AliMeUtil.a = "true";
                    }
                    aliMeTokenListener.onFailed();
                    String unused2 = AliMeUtil.a = "";
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(AliMeTokenInfo aliMeTokenInfo) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-2144210557")) {
                    ipChange2.ipc$dispatch("-2144210557", new Object[]{this, aliMeTokenInfo});
                } else if (aliMeTokenInfo != null) {
                    AliMeTokenListener aliMeTokenListener2 = aliMeTokenListener;
                    if (aliMeTokenListener2 != null) {
                        aliMeTokenListener2.onSuccess(aliMeTokenInfo.getResult());
                    }
                } else {
                    AliMeTokenListener aliMeTokenListener3 = aliMeTokenListener;
                    if (aliMeTokenListener3 != null) {
                        aliMeTokenListener3.onFailed();
                    }
                }
            }
        });
    }

    public static String f(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1824886622")) {
            return (String) ipChange.ipc$dispatch("-1824886622", new Object[]{str, str2, str3, str4});
        }
        if (!FROM_PROJECT_DETAIL.equals(str) && !SESSION_COUPON_DETAIL.equals(str)) {
            if (!FROM_PROJECT_COMMON_PROBLEM.equals(str) && !FROM_SERVICE_PROBLEM.equals(str) && !SESSION_SCRIPT_COUPON_DETAIL.equals(str)) {
                return c(str, str2);
            } else if (TextUtils.isEmpty(str4)) {
                return c(str, str2);
            } else {
                return c(str, str2) + "&" + i(str3) + "&attemptquery=" + URLEncoder.encode(str4);
            }
        }
        return c(str, str2) + "&projectId=" + str3;
    }

    public static String g(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1846974360")) {
            return (String) ipChange.ipc$dispatch("1846974360", new Object[]{str, str2, str3, str4, str5});
        }
        return c(str, str2) + "&" + i(str3) + "&attemptquery=" + str5 + "&orderId=" + str4;
    }

    public static String h(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1846311768")) {
            return (String) ipChange.ipc$dispatch("-1846311768", new Object[]{str, str2, str3, str4});
        }
        return c(str, str2) + "&" + i(str3) + "&orderId=" + str4;
    }

    private static String i(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-800241618")) {
            return (String) ipChange.ipc$dispatch("-800241618", new Object[]{str});
        }
        return "sopExtParam=" + URLEncoder.encode("{\"projectId\":\"" + str + "\"}");
    }

    public static void j(UserCodeListener userCodeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-343371106")) {
            ipChange.ipc$dispatch("-343371106", new Object[]{userCodeListener});
        } else if (!LoginManager.k().q()) {
            n();
        } else if (wh2.j(z20.E())) {
        } else {
            userCodeListener.onSuccess(Long.parseLong(z20.E()));
        }
    }

    public static void k(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "349626864")) {
            ipChange.ipc$dispatch("349626864", new Object[]{context, str});
        } else {
            l(context, str, 0L);
        }
    }

    public static void l(Context context, String str, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2046438700")) {
            ipChange.ipc$dispatch("-2046438700", new Object[]{context, str, Long.valueOf(j)});
        } else {
            j(new C1272a(str, j, context));
        }
    }

    public static void m(Context context, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "544464644")) {
            ipChange.ipc$dispatch("544464644", new Object[]{context, str, str2, str3});
        } else {
            j(new C1274b(str, str2, str3, context));
        }
    }

    private static void n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2053553948")) {
            ipChange.ipc$dispatch("2053553948", new Object[0]);
        } else {
            DMNav.from(mu0.a().getApplicationContext()).toUri(cs.f());
        }
    }

    public static void o() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1043768836")) {
            ipChange.ipc$dispatch("1043768836", new Object[0]);
        } else if ("true".equals(a)) {
        } else {
            ToastUtil.a().j(mu0.a().getApplicationContext(), "小蜜现在无法识别你的身份，请点击链接再次尝试！");
        }
    }

    public static void p(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1298016536")) {
            ipChange.ipc$dispatch("1298016536", new Object[]{str, str2});
        } else if ("FAIL_SYS_SESSION_EXPIRED".equals(str)) {
        } else {
            o();
        }
    }
}
