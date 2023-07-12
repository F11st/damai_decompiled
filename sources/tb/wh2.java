package tb;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.purchase.core.utils.PurchaseConstants;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class wh2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static long a(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-437193318")) {
            return ((Long) ipChange.ipc$dispatch("-437193318", new Object[]{str})).longValue();
        }
        try {
            if (i(str)) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
                return simpleDateFormat.parse(str).getTime();
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static Integer b(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "122110730")) {
            return (Integer) ipChange.ipc$dispatch("122110730", new Object[]{str});
        }
        if (str != null && !TextUtils.isEmpty(str.trim())) {
            try {
                String trim = str.trim();
                String str2 = "";
                boolean z = false;
                for (int i = 0; i < trim.length(); i++) {
                    if (trim.charAt(i) >= '0' && trim.charAt(i) <= '9') {
                        str2 = str2 + trim.charAt(i);
                        z = true;
                    } else if (z) {
                        break;
                    }
                }
                if (!TextUtils.isEmpty(str2)) {
                    return Integer.valueOf(Integer.parseInt(str2));
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String c(double d) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-151162547")) {
            return (String) ipChange.ipc$dispatch("-151162547", new Object[]{Double.valueOf(d)});
        }
        String o = o(d);
        try {
            int indexOf = o.indexOf(".");
            if (indexOf > 0 && (i = indexOf + 1) < o.length()) {
                String substring = o.substring(i);
                if (!"0".equals(substring) && !"00".equals(substring)) {
                    return substring.endsWith("0") ? o.substring(0, indexOf + 2) : o;
                }
                return o.substring(0, indexOf);
            }
            return o;
        } catch (Exception e) {
            e.printStackTrace();
            return o;
        }
    }

    public static String d(float f) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-968810997")) {
            return (String) ipChange.ipc$dispatch("-968810997", new Object[]{Float.valueOf(f)});
        }
        String p = p(f);
        try {
            int indexOf = p.indexOf(".");
            if (indexOf > 0 && (i = indexOf + 1) < p.length()) {
                String substring = p.substring(i);
                if (!"0".equals(substring) && !"00".equals(substring)) {
                    return substring.endsWith("0") ? p.substring(0, indexOf + 2) : p;
                }
                return p.substring(0, indexOf);
            }
            return p;
        } catch (Exception e) {
            e.printStackTrace();
            return p;
        }
    }

    public static <T> int e(List<T> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1731176667")) {
            return ((Integer) ipChange.ipc$dispatch("-1731176667", new Object[]{list})).intValue();
        }
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public static String f(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "310362217")) {
            return (String) ipChange.ipc$dispatch("310362217", new Object[]{str});
        }
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException unused) {
        }
        byte[] digest = messageDigest.digest();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < digest.length; i++) {
            if (Integer.toHexString(digest[i] & 255).length() == 1) {
                stringBuffer.append("0");
                stringBuffer.append(Integer.toHexString(digest[i] & 255));
            } else {
                stringBuffer.append(Integer.toHexString(digest[i] & 255));
            }
        }
        return stringBuffer.toString();
    }

    public static String g(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-749664599")) {
            return (String) ipChange.ipc$dispatch("-749664599", new Object[]{Integer.valueOf(i)});
        }
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append("abcdefghijklmnopqrstuvwxyz0123456789".charAt(random.nextInt(36)));
        }
        return stringBuffer.toString();
    }

    public static boolean h(String str) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1892021852")) {
            return ((Boolean) ipChange.ipc$dispatch("-1892021852", new Object[]{str})).booleanValue();
        }
        if (j(str)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                z = false;
            }
        }
        return z;
    }

    public static boolean i(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1737719085") ? ((Boolean) ipChange.ipc$dispatch("1737719085", new Object[]{str})).booleanValue() : str != null && str.length() > 0;
    }

    public static boolean j(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "337606443") ? ((Boolean) ipChange.ipc$dispatch("337606443", new Object[]{str})).booleanValue() : str == null || "".equals(str.trim()) || str.trim().length() == 0 || "null".equals(str.trim());
    }

    public static int k(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-353968891")) {
            return ((Integer) ipChange.ipc$dispatch("-353968891", new Object[]{str})).intValue();
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return Integer.MIN_VALUE;
        }
    }

    public static int l(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1911896100")) {
            return ((Integer) ipChange.ipc$dispatch("1911896100", new Object[]{str, Integer.valueOf(i)})).intValue();
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static long m(String str, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1287697097")) {
            return ((Long) ipChange.ipc$dispatch("-1287697097", new Object[]{str, Long.valueOf(j)})).longValue();
        }
        try {
            return Long.parseLong(str);
        } catch (Exception unused) {
            return j;
        }
    }

    public static long n(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "799547287")) {
            return ((Long) ipChange.ipc$dispatch("799547287", new Object[]{str})).longValue();
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return Long.MIN_VALUE;
        }
    }

    public static String o(double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "612714282")) {
            return (String) ipChange.ipc$dispatch("612714282", new Object[]{Double.valueOf(d)});
        }
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.applyPattern(PurchaseConstants.NULL_PRICE);
        return decimalFormat.format(d);
    }

    public static String p(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-204934168")) {
            return (String) ipChange.ipc$dispatch("-204934168", new Object[]{Float.valueOf(f)});
        }
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.applyPattern(PurchaseConstants.NULL_PRICE);
        return decimalFormat.format(f);
    }
}
