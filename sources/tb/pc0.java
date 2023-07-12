package tb;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import cn.damai.common.OrangeConfigCenter;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import com.alibaba.security.common.track.model.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class pc0 extends ll {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static String c = "downgrade_h5param";
    public static String d = "downgrade_projectid";
    public static String e = "damai_downgrade_project_detail";
    public static String f = "damai_downgrade_buy";
    public static String g = "damai_downgrade_order_detail";
    public static String h = "switch_qilin";
    public static String i = "switch_project_id";
    public static String j = "dmdowngrade=true";
    private HashSet<String> a = new HashSet<>();
    private HashMap<String, String> b = new HashMap<>();

    public pc0() {
        HashSet<String> hashSet = this.a;
        hashSet.add(cs.a + cs.b);
        HashSet<String> hashSet2 = this.a;
        hashSet2.add(cs.a + cs.PAGE_QILIN_JPG_REGION);
        HashSet<String> hashSet3 = this.a;
        hashSet3.add(cs.a + cs.PAGE_QILIN_JPG_SEAT);
        HashSet<String> hashSet4 = this.a;
        hashSet4.add(cs.a + cs.PAGE_QILIN_SVG_SEAT);
        HashMap<String, String> hashMap = this.b;
        hashMap.put(cs.a + cs.b, e);
        HashMap<String, String> hashMap2 = this.b;
        hashMap2.put(cs.a + cs.g, g);
        HashMap<String, String> hashMap3 = this.b;
        hashMap3.put(cs.a + cs.h, g);
    }

    private long c(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2142730214")) {
            return ((Long) ipChange.ipc$dispatch("2142730214", new Object[]{this, intent})).longValue();
        }
        long longExtra = intent != null ? intent.getLongExtra(d, 0L) : 0L;
        return longExtra != 0 ? longExtra : mp2.a(intent.getExtras());
    }

    private boolean d(long j2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-451620474") ? ((Boolean) ipChange.ipc$dispatch("-451620474", new Object[]{this, Long.valueOf(j2)})).booleanValue() : j2 >= 100000000;
    }

    private void e(String str, Intent intent, Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-49550891")) {
            ipChange.ipc$dispatch("-49550891", new Object[]{this, str, intent, context});
            return;
        }
        Bundle bundle = new Bundle();
        String str2 = "";
        String stringExtra = intent.getStringExtra(c) != null ? intent.getStringExtra(c) : "";
        if (str.equals(cs.a + cs.b)) {
            if (d(c(intent))) {
                str2 = ev0.a() + "?itemId=" + c(intent) + "&" + stringExtra + "&" + j + "&loading=false";
            }
        } else {
            if (!str.equals(cs.a + cs.PAGE_QILIN_JPG_REGION)) {
                if (!str.equals(cs.a + cs.PAGE_QILIN_JPG_SEAT)) {
                    if (!str.equals(cs.a + cs.PAGE_QILIN_SVG_SEAT)) {
                        cb1.b("DMNav", "DowngradeProcessor navToWebView emptyurl . ");
                        return;
                    }
                }
            }
            str2 = stringExtra + "&" + j + "&loading=false";
        }
        bundle.putString("url", str2);
        cb1.b("DMNav", "DowngradeProcessor navToWebView url : " + str2);
        DMNav.from(context).withExtras(bundle).toUri(NavUri.b(a.c.d));
    }

    public boolean a(String str, long j2) {
        String[] split;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1271365116")) {
            return ((Boolean) ipChange.ipc$dispatch("-1271365116", new Object[]{this, str, Long.valueOf(j2)})).booleanValue();
        }
        String str2 = this.b.get(str);
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        cb1.b("DMNav", "DowngradeProcessor checkDowngrade orangekey: " + str2);
        if (j2 == 0) {
            return false;
        }
        if ((d(j2) ? OrangeConfigCenter.c().a(str2, h, 0) : 0) == 1) {
            cb1.b("DMNav", "DowngradeProcessor checkDowngrade SWITCH_KEY_QILIN ");
            return true;
        }
        String b = OrangeConfigCenter.c().b(str2, i, "");
        cb1.b("DMNav", "DowngradeProcessor targetId : " + j2 + " , projectId[] : " + b);
        if (!TextUtils.isEmpty(b)) {
            for (String str3 : b.split(",")) {
                if ((j2 + "").equals(str3)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean b(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-248154237") ? ((Boolean) ipChange.ipc$dispatch("-248154237", new Object[]{this, str})).booleanValue() : this.a.contains(str);
    }

    @Override // cn.damai.common.nav.DMNav.NavPreprocessor
    public boolean beforeNavTo(Intent intent, Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1663361141")) {
            return ((Boolean) ipChange.ipc$dispatch("-1663361141", new Object[]{this, intent, context})).booleanValue();
        }
        if (intent != null && !TextUtils.isEmpty(intent.getDataString())) {
            String dataString = intent.getDataString();
            long currentTimeMillis = System.currentTimeMillis();
            cb1.b("DMNav", "DowngradeProcessor url : " + dataString);
            Uri parse = Uri.parse(dataString);
            String str = parse.getScheme() + jg1.SCHEME_SLASH + parse.getHost();
            if (b(str) && a(str, c(intent))) {
                e(str, intent, context);
                return true;
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            cb1.b("DMNav", "DowngradeProcessor return false : " + dataString + " , time : " + (currentTimeMillis2 - currentTimeMillis));
        }
        return false;
    }
}
