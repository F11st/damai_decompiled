package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.purchase.core.utils.PurchaseConstants;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.List;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class th2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static String a(double d) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1596719334")) {
            return (String) ipChange.ipc$dispatch("1596719334", new Object[]{Double.valueOf(d)});
        }
        String f = f(d);
        try {
            int indexOf = f.indexOf(".");
            if (indexOf > 0 && (i = indexOf + 1) < f.length()) {
                String substring = f.substring(i);
                if (!"0".equals(substring) && !"00".equals(substring)) {
                    return substring.endsWith("0") ? f.substring(0, indexOf + 2) : f;
                }
                return f.substring(0, indexOf);
            }
            return f;
        } catch (Exception e) {
            e.printStackTrace();
            return f;
        }
    }

    public static <T> int b(List<T> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1292511084")) {
            return ((Integer) ipChange.ipc$dispatch("1292511084", new Object[]{list})).intValue();
        }
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public static String c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1133881090")) {
            return (String) ipChange.ipc$dispatch("1133881090", new Object[]{str});
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

    public static boolean d(String str) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "474014763")) {
            return ((Boolean) ipChange.ipc$dispatch("474014763", new Object[]{str})).booleanValue();
        }
        if (e(str)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                z = false;
            }
        }
        return z;
    }

    public static boolean e(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2061093874") ? ((Boolean) ipChange.ipc$dispatch("2061093874", new Object[]{str})).booleanValue() : str == null || "".equals(str.trim()) || str.trim().length() == 0 || "null".equals(str.trim());
    }

    public static String f(double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-952315389")) {
            return (String) ipChange.ipc$dispatch("-952315389", new Object[]{Double.valueOf(d)});
        }
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.applyPattern(PurchaseConstants.NULL_PRICE);
        return decimalFormat.format(d);
    }
}
