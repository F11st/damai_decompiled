package tb;

import android.content.SharedPreferences;
import android.text.TextUtils;
import cn.damai.common.DamaiConstants;
import cn.damai.common.R$string;
import cn.damai.common.app.ShareperfenceConstants;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.wireless.security.sdk.SecurityGuardManager;
import com.taobao.wireless.security.sdk.dynamicdataencrypt.IDynamicDataEncryptComponent;
import com.tencent.connect.common.Constants;
import com.youku.middlewareservice.provider.kvdata.SPProviderProxy;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class z20 implements ShareperfenceConstants {
    private static transient /* synthetic */ IpChange $ipChange;

    private static SharedPreferences A(String str, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1131056003") ? (SharedPreferences) ipChange.ipc$dispatch("1131056003", new Object[]{str, Integer.valueOf(i)}) : SPProviderProxy.getSharedPreferences(str);
    }

    public static void A0(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "441523557")) {
            ipChange.ipc$dispatch("441523557", new Object[]{str});
        } else {
            A("welcome_url", 0).edit().putString(ShareperfenceConstants.WELCOME_CLICK, str).commit();
        }
    }

    public static String B(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1989397082") ? (String) ipChange.ipc$dispatch("1989397082", new Object[]{str}) : SPProviderProxy.getPreferenceString(str);
    }

    public static void B0(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-880702626")) {
            ipChange.ipc$dispatch("-880702626", new Object[]{str});
        } else {
            A("welcome_url", 0).edit().putString("welcome_url", str).commit();
        }
    }

    public static boolean C() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "128253287") ? ((Boolean) ipChange.ipc$dispatch("128253287", new Object[0])).booleanValue() : "1".equals(B(ShareperfenceConstants.TABLIVE_CDN_REQUEST));
    }

    public static void C0(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2012995428")) {
            ipChange.ipc$dispatch("2012995428", new Object[]{str});
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            str = v20.b(str);
        }
        A(ShareperfenceConstants.USER_SHAREPERFENCE, 0).edit().putString(ShareperfenceConstants.YOUKU_USERID, str).commit();
    }

    public static String D(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-153119917")) {
            return (String) ipChange.ipc$dispatch("-153119917", new Object[]{str});
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        SharedPreferences A = A(ShareperfenceConstants.DM_USER_CENTER_CACHE, 0);
        IDynamicDataEncryptComponent I = I();
        if (I != null) {
            try {
                String string = A.getString(I.dynamicEncryptDDp(str), "");
                return !TextUtils.isEmpty(string) ? I.dynamicDecryptDDp(string) : "";
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        return "";
    }

    public static void D0(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-225995698")) {
            ipChange.ipc$dispatch("-225995698", new Object[]{str});
        } else {
            A(ShareperfenceConstants.FIRST_QQ_SHAREPREFENCE, 0).edit().putString(ShareperfenceConstants.FIRST_QQ_SHOW, str).commit();
        }
    }

    public static String E() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1713837227") ? (String) ipChange.ipc$dispatch("1713837227", new Object[0]) : A(ShareperfenceConstants.USER_SHAREPERFENCE, 0).getString(ShareperfenceConstants.USERCODE, "");
    }

    public static String F() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1881604489") ? (String) ipChange.ipc$dispatch("-1881604489", new Object[0]) : A(ShareperfenceConstants.USER_SECURITY_KEY, 0).getString(ShareperfenceConstants.USER_SECURITY_KEY, "");
    }

    public static int G() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1548932143") ? ((Integer) ipChange.ipc$dispatch("-1548932143", new Object[0])).intValue() : A(ShareperfenceConstants.USER_SHAREPERFENCE, 0).getInt(ShareperfenceConstants.USER_VTAG, 0);
    }

    public static String H() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1939082670")) {
            return (String) ipChange.ipc$dispatch("-1939082670", new Object[0]);
        }
        String string = A(ShareperfenceConstants.USER_SHAREPERFENCE, 0).getString(ShareperfenceConstants.YOUKU_USERID, "");
        return !TextUtils.isEmpty(string) ? v20.a(string) : string;
    }

    private static IDynamicDataEncryptComponent I() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1304697451")) {
            return (IDynamicDataEncryptComponent) ipChange.ipc$dispatch("1304697451", new Object[0]);
        }
        try {
            SecurityGuardManager securityGuardManager = SecurityGuardManager.getInstance(mu0.a());
            if (securityGuardManager != null) {
                return securityGuardManager.getDynamicDataEncryptComp();
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String J() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "37712784") ? (String) ipChange.ipc$dispatch("37712784", new Object[0]) : A(ShareperfenceConstants.FIRST_QQ_SHAREPREFENCE, 0).getString(ShareperfenceConstants.FIRST_QQ_SHOW, null);
    }

    public static boolean K() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1196768299") ? ((Boolean) ipChange.ipc$dispatch("1196768299", new Object[0])).booleanValue() : A(ShareperfenceConstants.USER_SHAREPERFENCE, 0).getBoolean(ShareperfenceConstants.DM_APP_RECOMMEND_SWITCH_STATUS, true);
    }

    public static boolean L() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1149194278") ? ((Boolean) ipChange.ipc$dispatch("-1149194278", new Object[0])).booleanValue() : A(ShareperfenceConstants.HOMEPAGE_DETAILED_COLLECT, 0).getBoolean(ShareperfenceConstants.KEY_DETAILED_COLLECT_PAGE, false);
    }

    public static void M(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1674452864")) {
            ipChange.ipc$dispatch("1674452864", new Object[]{str});
        } else {
            T(DamaiConstants.APP_STARTUP_ORANGE_CONFIG, str);
        }
    }

    public static void N(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1059777620")) {
            ipChange.ipc$dispatch("-1059777620", new Object[]{str});
        } else {
            T(ShareperfenceConstants.DRAMA_CHANNEL_CDN_REQUEST, str);
        }
    }

    public static void O(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1159768474")) {
            ipChange.ipc$dispatch("1159768474", new Object[]{str});
        } else {
            T(ShareperfenceConstants.HOMEPAGE_CDN_REQUEST, str);
        }
    }

    public static void P(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1768195257")) {
            ipChange.ipc$dispatch("1768195257", new Object[]{str});
        } else {
            T(ShareperfenceConstants.NEW_CHANNEL_PAGE_CDN_REQUEST, str);
        }
    }

    public static void Q(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1760171580")) {
            ipChange.ipc$dispatch("1760171580", new Object[]{str});
        } else {
            T(ShareperfenceConstants.NEW_HOMEPAGE_CDN_REQUEST, str);
        }
    }

    public static void R() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-11497043")) {
            ipChange.ipc$dispatch("-11497043", new Object[0]);
        } else {
            A(ShareperfenceConstants.ORDER_DETAIL_CAN_RESELL, 0).edit().putBoolean(ShareperfenceConstants.ORDER_DETAIL_CAN_RESELL, true).commit();
        }
    }

    public static void S(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-318716418")) {
            ipChange.ipc$dispatch("-318716418", new Object[]{Integer.valueOf(i)});
        } else {
            A(ShareperfenceConstants.RED_PACKAGE_TYPE, 0).edit().putInt(ShareperfenceConstants.RED_PACKAGE_TYPE, i).commit();
        }
    }

    public static void T(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1617436727")) {
            ipChange.ipc$dispatch("1617436727", new Object[]{str, str2});
        } else {
            SPProviderProxy.savePreference(str, str2);
        }
    }

    public static void U(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "48045033")) {
            ipChange.ipc$dispatch("48045033", new Object[]{str});
        } else {
            T(ShareperfenceConstants.TABLIVE_CDN_REQUEST, str);
        }
    }

    public static void V(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2033623499")) {
            ipChange.ipc$dispatch("-2033623499", new Object[]{Long.valueOf(j)});
            return;
        }
        SharedPreferences.Editor edit = A(ShareperfenceConstants.LATEST_PROJECT_INFO, 0).edit();
        edit.putLong("sellStartTime", j);
        edit.commit();
    }

    public static void W(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1378875696")) {
            ipChange.ipc$dispatch("-1378875696", new Object[]{str});
        } else {
            A(ShareperfenceConstants.TD_LOGIN, 0).edit().putString(ShareperfenceConstants.TD_LOGIN_M, str).commit();
        }
    }

    public static void X(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "485558869")) {
            ipChange.ipc$dispatch("485558869", new Object[]{str});
            return;
        }
        SharedPreferences A = A(ShareperfenceConstants.QQ_ACCESS_TOKEN, 32768);
        String[] split = str.split(",");
        if (split[0] == null || split[1] == null) {
            return;
        }
        SharedPreferences.Editor edit = A.edit();
        edit.putString(Constants.PARAM_ACCESS_TOKEN, split[0]);
        edit.putLong(Constants.PARAM_EXPIRES_IN, Long.valueOf(split[1]).longValue());
        if (split.length > 2) {
            edit.putString("openid", split[2]);
        }
        edit.commit();
    }

    public static void Y(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1860291848")) {
            ipChange.ipc$dispatch("1860291848", new Object[]{str});
        } else {
            A(ShareperfenceConstants.USER_SHAREPERFENCE, 0).edit().putString("alipay_accesstoken", str).commit();
        }
    }

    public static void Z(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1002965711")) {
            ipChange.ipc$dispatch("1002965711", new Object[]{str});
        } else {
            A(ShareperfenceConstants.USER_SHAREPERFENCE, 0).edit().putString("alipay_phone", str).commit();
        }
    }

    public static void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1596384897")) {
            ipChange.ipc$dispatch("-1596384897", new Object[0]);
            return;
        }
        SharedPreferences.Editor edit = A(ShareperfenceConstants.QQ_ACCESS_TOKEN, 32768).edit();
        edit.putString(Constants.PARAM_ACCESS_TOKEN, "");
        edit.putLong(Constants.PARAM_EXPIRES_IN, 1L);
        edit.putString("openid", "");
        edit.commit();
    }

    public static void a0(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1353810217")) {
            ipChange.ipc$dispatch("1353810217", new Object[]{Boolean.valueOf(z)});
        } else {
            A(ShareperfenceConstants.USER_SHAREPERFENCE, 0).edit().putBoolean(ShareperfenceConstants.DM_APP_RECOMMEND_SWITCH_STATUS, z).commit();
        }
    }

    public static String b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "986576113") ? (String) ipChange.ipc$dispatch("986576113", new Object[0]) : B(DamaiConstants.APP_STARTUP_ORANGE_CONFIG);
    }

    public static void b0(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1591145042")) {
            ipChange.ipc$dispatch("1591145042", new Object[]{Boolean.valueOf(z)});
        } else {
            A(ShareperfenceConstants.USER_SHAREPERFENCE, 0).edit().putBoolean(ShareperfenceConstants.IS_BIND_MOBILE, z).commit();
        }
    }

    public static String c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "91326265") ? (String) ipChange.ipc$dispatch("91326265", new Object[0]) : A(ShareperfenceConstants.CITY_SHAREPREFENCE, 0).getString(ShareperfenceConstants.CITY_ID, "852");
    }

    public static void c0(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1436022213")) {
            ipChange.ipc$dispatch("1436022213", new Object[]{str});
        } else {
            A(ShareperfenceConstants.CITY_SHAREPREFENCE, 0).edit().putString(ShareperfenceConstants.CITY_ID, str).commit();
        }
    }

    public static String d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1936077801") ? (String) ipChange.ipc$dispatch("1936077801", new Object[0]) : A(ShareperfenceConstants.CITY_SHAREPREFENCE, 0).getString(ShareperfenceConstants.CITY_NAME, cm2.b(mu0.a().getApplicationContext(), R$string.damai_addreceipt_beijing));
    }

    public static void d0(double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-999648887")) {
            ipChange.ipc$dispatch("-999648887", new Object[]{Double.valueOf(d)});
            return;
        }
        SharedPreferences.Editor edit = A(ShareperfenceConstants.CITY_SHAREPREFENCE, 0).edit();
        edit.putString(ShareperfenceConstants.CITY_LAT, d + "").commit();
    }

    public static boolean e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-160123516") ? ((Boolean) ipChange.ipc$dispatch("-160123516", new Object[0])).booleanValue() : A(ShareperfenceConstants.ADDRESS_LIST_PROMPT, 0).getBoolean(ShareperfenceConstants.KEY_CLOSED_INVALID_ADDRESS_PROMPT, false);
    }

    public static void e0(double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-639475697")) {
            ipChange.ipc$dispatch("-639475697", new Object[]{Double.valueOf(d)});
            return;
        }
        SharedPreferences.Editor edit = A(ShareperfenceConstants.CITY_SHAREPREFENCE, 0).edit();
        edit.putString(ShareperfenceConstants.CITY_LNG, d + "").commit();
    }

    public static String f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1718067697")) {
            return (String) ipChange.ipc$dispatch("1718067697", new Object[0]);
        }
        SharedPreferences A = A(ShareperfenceConstants.DM_USER_CENTER_CACHE, 0);
        if (A == null) {
            return "";
        }
        IDynamicDataEncryptComponent I = I();
        if (I != null) {
            try {
                return I.dynamicDecryptDDp(A.getString(ShareperfenceConstants.DM_CURRENT_USERDATA, ""));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static void f0(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "6541845")) {
            ipChange.ipc$dispatch("6541845", new Object[]{str});
        } else {
            A(ShareperfenceConstants.CITY_SHAREPREFENCE, 0).edit().putString(ShareperfenceConstants.CITY_NAME, str).commit();
        }
    }

    public static boolean g() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "492706556") ? ((Boolean) ipChange.ipc$dispatch("492706556", new Object[0])).booleanValue() : "1".equals(B(ShareperfenceConstants.DRAMA_CHANNEL_CDN_REQUEST));
    }

    public static void g0() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1906359374")) {
            ipChange.ipc$dispatch("-1906359374", new Object[0]);
        } else {
            A(ShareperfenceConstants.CITY_SHAREPREFENCE, 0).edit().putString(ShareperfenceConstants.SET_CITY, "true").commit();
        }
    }

    public static <T> T h(String str, Class<T> cls) {
        String dynamicDecryptDDp;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1318942156")) {
            return (T) ipChange.ipc$dispatch("-1318942156", new Object[]{str, cls});
        }
        T t = null;
        try {
            Map<String, ?> all = A(str, 0).getAll();
            List<Field> w = w(cls);
            IDynamicDataEncryptComponent I = I();
            if (all.size() > 0 && w.size() > 0) {
                t = cls.newInstance();
                for (Map.Entry<String, ?> entry : all.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    try {
                        if (!TextUtils.isEmpty(key) && I != null && !TextUtils.isEmpty((String) value) && (dynamicDecryptDDp = I.dynamicDecryptDDp((String) value)) != null) {
                            value = dynamicDecryptDDp;
                        }
                    } catch (Exception unused) {
                    }
                    Iterator<Field> it = w.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Field next = it.next();
                            if (next.getName().equalsIgnoreCase(key)) {
                                next.set(t, value);
                                break;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    public static void h0(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1103135392")) {
            ipChange.ipc$dispatch("-1103135392", new Object[]{Boolean.valueOf(z)});
        } else {
            A(ShareperfenceConstants.ADDRESS_LIST_PROMPT, 0).edit().putBoolean(ShareperfenceConstants.KEY_CLOSED_INVALID_ADDRESS_PROMPT, z).commit();
        }
    }

    public static String i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1154617584")) {
            return (String) ipChange.ipc$dispatch("-1154617584", new Object[0]);
        }
        String string = A(ShareperfenceConstants.USER_SHAREPERFENCE, 0).getString(ShareperfenceConstants.HAVANA_USERID, "");
        if (TextUtils.isEmpty(string)) {
            return string;
        }
        String a = v20.a(string);
        return !TextUtils.isEmpty(a) ? a : string;
    }

    public static void i0(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-461615778")) {
            ipChange.ipc$dispatch("-461615778", new Object[]{Boolean.valueOf(z)});
        } else {
            A(ShareperfenceConstants.USER_SHAREPERFENCE, 0).edit().putBoolean(ShareperfenceConstants.USER_SECURITY, z).commit();
        }
    }

    public static boolean j() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-386931706") ? ((Boolean) ipChange.ipc$dispatch("-386931706", new Object[0])).booleanValue() : mu0.a().getApplicationContext().getSharedPreferences("homepage_pre", 0).getBoolean("homepage_pre", false);
    }

    public static void j0(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2002304421")) {
            ipChange.ipc$dispatch("2002304421", new Object[]{str});
            return;
        }
        SharedPreferences A = A(ShareperfenceConstants.DM_USER_CENTER_CACHE, 0);
        if (A == null) {
            return;
        }
        IDynamicDataEncryptComponent I = I();
        if (I != null) {
            try {
                str = I.dynamicEncryptDDp(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        A.edit().putString(ShareperfenceConstants.DM_CURRENT_USERDATA, str).commit();
    }

    public static String k() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-662134325") ? (String) ipChange.ipc$dispatch("-662134325", new Object[0]) : mu0.a().getApplicationContext().getSharedPreferences("homepage_pre_time", 0).getString("homepage_pre_time", "");
    }

    public static void k0(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1035525682")) {
            ipChange.ipc$dispatch("-1035525682", new Object[]{str});
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            str = v20.b(str);
        }
        A(ShareperfenceConstants.USER_SHAREPERFENCE, 0).edit().putString(ShareperfenceConstants.HAVANA_USERID, str).commit();
        if (TextUtils.isEmpty(str)) {
            cn.damai.common.user.c.e().w("havanaid");
        } else {
            l23.INSTANCE.d(str);
        }
    }

    public static boolean l() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-773719446") ? ((Boolean) ipChange.ipc$dispatch("-773719446", new Object[0])).booleanValue() : "1".equals(B(ShareperfenceConstants.HOMEPAGE_CDN_REQUEST));
    }

    public static void l0(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2091774330")) {
            ipChange.ipc$dispatch("-2091774330", new Object[]{Boolean.valueOf(z)});
        } else {
            mu0.a().getApplicationContext().getSharedPreferences("homepage_pre", 0).edit().putBoolean("homepage_pre", z).commit();
        }
    }

    public static long m() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-592760083") ? ((Long) ipChange.ipc$dispatch("-592760083", new Object[0])).longValue() : A(ShareperfenceConstants.LATEST_PROJECT_INFO, 0).getLong("sellStartTime", 0L);
    }

    public static void m0(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1273337460")) {
            ipChange.ipc$dispatch("1273337460", new Object[]{str});
            return;
        }
        SharedPreferences.Editor edit = A("location", 0).edit();
        edit.putString(ShareperfenceConstants.LOCATION_ADD, str + "").commit();
    }

    public static double n() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1021391359") ? ((Double) ipChange.ipc$dispatch("-1021391359", new Object[0])).doubleValue() : Double.parseDouble(A("location", 0).getString(ShareperfenceConstants.LOCATION_LAT, "39.907325"));
    }

    public static void n0(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1334438200")) {
            ipChange.ipc$dispatch("-1334438200", new Object[]{str});
        } else {
            A(ShareperfenceConstants.CURRENT_CITY_SHAREPREFENCE, 0).edit().putString(ShareperfenceConstants.CITY_ID, str).commit();
        }
    }

    public static double o() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1009772869") ? ((Double) ipChange.ipc$dispatch("-1009772869", new Object[0])).doubleValue() : Double.parseDouble(A("location", 0).getString(ShareperfenceConstants.LOCATION_LNG, "116.39145"));
    }

    public static void o0(double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-678302209")) {
            ipChange.ipc$dispatch("-678302209", new Object[]{Double.valueOf(d)});
            return;
        }
        SharedPreferences.Editor edit = A("location", 0).edit();
        edit.putString(ShareperfenceConstants.LOCATION_LAT, d + "").commit();
    }

    public static String p() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1684076595") ? (String) ipChange.ipc$dispatch("1684076595", new Object[0]) : A("location", 0).getString(ShareperfenceConstants.LOCATION_NAME, "北京市");
    }

    public static void p0(double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-318129019")) {
            ipChange.ipc$dispatch("-318129019", new Object[]{Double.valueOf(d)});
            return;
        }
        SharedPreferences.Editor edit = A("location", 0).edit();
        edit.putString(ShareperfenceConstants.LOCATION_LNG, d + "").commit();
    }

    public static String q() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-817112183") ? (String) ipChange.ipc$dispatch("-817112183", new Object[0]) : A(ShareperfenceConstants.USER_SHAREPERFENCE, 0).getString(ShareperfenceConstants.LOGIN_KEY, "");
    }

    public static void q0(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1064647947")) {
            ipChange.ipc$dispatch("1064647947", new Object[]{str});
            return;
        }
        SharedPreferences.Editor edit = A("location", 0).edit();
        edit.putString(ShareperfenceConstants.LOCATION_NAME, str + "").commit();
    }

    public static String r() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1558885330")) {
            return (String) ipChange.ipc$dispatch("-1558885330", new Object[0]);
        }
        String string = A(ShareperfenceConstants.USER_SHAREPERFENCE, 0).getString("mobile", "");
        return !TextUtils.isEmpty(string) ? v20.a(string) : string;
    }

    public static void r0(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "556998261")) {
            ipChange.ipc$dispatch("556998261", new Object[]{str});
        } else {
            A(ShareperfenceConstants.USER_SHAREPERFENCE, 0).edit().putString(ShareperfenceConstants.LOGIN_KEY, str).commit();
        }
    }

    public static String s() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2145260924") ? (String) ipChange.ipc$dispatch("2145260924", new Object[0]) : mu0.a().getApplicationContext().getSharedPreferences(ShareperfenceConstants.MTOP_PROJECT, 0).getString(ShareperfenceConstants.MTOP_PROJECT, "");
    }

    public static void s0(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1117631434")) {
            ipChange.ipc$dispatch("-1117631434", new Object[]{str});
        } else {
            A(ShareperfenceConstants.USER_SHAREPERFENCE, 0).edit().putString(ShareperfenceConstants.OLD_LOGIN_KEY, str).commit();
        }
    }

    public static boolean t() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2058281666") ? ((Boolean) ipChange.ipc$dispatch("2058281666", new Object[0])).booleanValue() : mu0.a().getApplicationContext().getSharedPreferences(ShareperfenceConstants.MTOP_PROJECT_TAG, 0).getBoolean(DamaiConstants.MTOP_PROJECT_TAG_CHECK, false);
    }

    public static void t0(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1865788903")) {
            ipChange.ipc$dispatch("-1865788903", new Object[]{str});
        } else {
            A(ShareperfenceConstants.PROJECT_PAGE_SHAREPREFENCE, 0).edit().putString(ShareperfenceConstants.PROJECT_NAT_DATA, str).commit();
        }
    }

    public static boolean u() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1413909657") ? ((Boolean) ipChange.ipc$dispatch("1413909657", new Object[0])).booleanValue() : mu0.a().getApplicationContext().getSharedPreferences(ShareperfenceConstants.MTOP_SWITCH_PROTOCOL_CONFIG, 0).getBoolean(DamaiConstants.MTOP_PROTOCOL_CHECK, false);
    }

    public static void u0() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1199729734")) {
            ipChange.ipc$dispatch("-1199729734", new Object[0]);
        } else {
            A(ShareperfenceConstants.HOMEPAGE_DETAILED_COLLECT, 0).edit().putBoolean(ShareperfenceConstants.KEY_DETAILED_COLLECT_PAGE, true).commit();
        }
    }

    public static boolean v() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "58097850") ? ((Boolean) ipChange.ipc$dispatch("58097850", new Object[0])).booleanValue() : "1".equals(B(ShareperfenceConstants.NEW_HOMEPAGE_CDN_REQUEST));
    }

    public static void v0(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-575048641")) {
            ipChange.ipc$dispatch("-575048641", new Object[]{Boolean.valueOf(z)});
        } else {
            A(ShareperfenceConstants.USER_SHAREPERFENCE, 0).edit().putBoolean(ShareperfenceConstants.IS_REAL_NAME, z).commit();
        }
    }

    public static List<Field> w(Class<?> cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1881140407")) {
            return (List) ipChange.ipc$dispatch("1881140407", new Object[]{cls});
        }
        if (cls.equals(Object.class)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Field field : cls.getFields()) {
            arrayList.add(field);
        }
        return arrayList;
    }

    public static void w0(String str, String str2) {
        SharedPreferences A;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1738587157")) {
            ipChange.ipc$dispatch("-1738587157", new Object[]{str, str2});
        } else if (TextUtils.isEmpty(str) || (A = A(ShareperfenceConstants.DM_USER_CENTER_CACHE, 0)) == null) {
        } else {
            IDynamicDataEncryptComponent I = I();
            if (I != null) {
                try {
                    str = I.dynamicEncryptDDp(str);
                    str2 = I.dynamicEncryptDDp(str2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            A.edit().putString(str, str2).commit();
        }
    }

    public static String x() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-654597312") ? (String) ipChange.ipc$dispatch("-654597312", new Object[0]) : A(ShareperfenceConstants.USER_SHAREPERFENCE, 0).getString(ShareperfenceConstants.OLD_LOGIN_KEY, "");
    }

    public static void x0(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1707018643")) {
            ipChange.ipc$dispatch("1707018643", new Object[]{str});
            return;
        }
        A(ShareperfenceConstants.USER_SHAREPERFENCE, 0).edit().putString(ShareperfenceConstants.USERCODE, str).commit();
        if (TextUtils.isEmpty(str)) {
            cn.damai.common.user.c.e().w("usercode");
        }
    }

    public static String y() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "49880165") ? (String) ipChange.ipc$dispatch("49880165", new Object[0]) : A(ShareperfenceConstants.PROJECT_PAGE_SHAREPREFENCE, 0).getString(ShareperfenceConstants.PROJECT_NAT_DATA, "");
    }

    public static void y0(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2081616351")) {
            ipChange.ipc$dispatch("2081616351", new Object[]{str});
        } else {
            A(ShareperfenceConstants.USER_SECURITY_KEY, 0).edit().putString(ShareperfenceConstants.USER_SECURITY_KEY, str).commit();
        }
    }

    public static int z() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1663384625") ? ((Integer) ipChange.ipc$dispatch("1663384625", new Object[0])).intValue() : A(ShareperfenceConstants.RED_PACKAGE_TYPE, 0).getInt(ShareperfenceConstants.RED_PACKAGE_TYPE, 0);
    }

    public static void z0(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "138526193")) {
            ipChange.ipc$dispatch("138526193", new Object[]{Integer.valueOf(i)});
        } else {
            A(ShareperfenceConstants.USER_SHAREPERFENCE, 0).edit().putInt(ShareperfenceConstants.USER_VTAG, i).commit();
        }
    }
}
