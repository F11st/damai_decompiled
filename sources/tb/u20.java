package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.wireless.security.sdk.SecurityGuardManager;
import com.taobao.wireless.security.sdk.staticdatastore.IStaticDataStoreComponent;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class u20 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int CASH_304_SUCCESS = 304;
    public static final int CASH_FAIL = 301;
    public static final int CASH_SUCCESS = 300;
    public static final int FAILED = 101;
    public static final int SUCCESS = 100;
    private static SecurityGuardManager a;

    /* JADX INFO: Access modifiers changed from: protected */
    public static String a(String str) {
        IStaticDataStoreComponent staticDataStoreComp;
        String extraData;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1566101756")) {
            return (String) ipChange.ipc$dispatch("1566101756", new Object[]{str});
        }
        if (a == null) {
            a = SecurityGuardManager.getInstance(mu0.a());
        }
        SecurityGuardManager securityGuardManager = a;
        if (securityGuardManager == null || (staticDataStoreComp = securityGuardManager.getStaticDataStoreComp()) == null || (extraData = staticDataStoreComp.getExtraData(str)) == null) {
            return "";
        }
        PrintStream printStream = System.out;
        printStream.println("Get extra data: " + extraData);
        return extraData;
    }

    public static String b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "522019325")) {
            return (String) ipChange.ipc$dispatch("522019325", new Object[0]);
        }
        StringBuffer stringBuffer = new StringBuffer();
        String a2 = a("appsecret");
        for (int i = 0; i < a2.length(); i++) {
            stringBuffer.append((char) (a2.charAt(i) - 1));
        }
        return stringBuffer.toString();
    }

    public static String c(ArrayList<String> arrayList, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-808616531")) {
            return (String) ipChange.ipc$dispatch("-808616531", new Object[]{arrayList, map});
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            sb.append(map.get(arrayList.get(i)));
        }
        return wh2.f(sb.toString());
    }
}
