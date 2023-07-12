package tb;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class vd1 {
    private static transient /* synthetic */ IpChange $ipChange;

    private static String a(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "86841302")) {
            return (String) ipChange.ipc$dispatch("86841302", new Object[]{map});
        }
        if (map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
            sb.append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private static String b(MessageDigest messageDigest) {
        byte[] digest;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1173821484")) {
            return (String) ipChange.ipc$dispatch("1173821484", new Object[]{messageDigest});
        }
        StringBuilder sb = new StringBuilder();
        for (byte b : messageDigest.digest()) {
            sb.append(Integer.toHexString((b >> 4) & 15));
            sb.append(Integer.toHexString(b & 15));
        }
        return sb.toString();
    }

    public static String c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "776778477")) {
            return (String) ipChange.ipc$dispatch("776778477", new Object[]{str});
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            messageDigest.update(str.getBytes(Charset.forName("UTF-8")));
            return b(messageDigest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String d(Map<String, String> map) {
        String str = "";
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1964632586")) {
            return (String) ipChange.ipc$dispatch("-1964632586", new Object[]{map});
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            messageDigest.update(a(map).getBytes("utf-8"));
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer("");
            for (int i = 0; i < digest.length; i++) {
                int i2 = digest[i];
                if (i2 < 0) {
                    i2 += 256;
                }
                if (i2 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i2));
            }
            str = stringBuffer.toString();
        } catch (Exception unused) {
        }
        return str.toUpperCase();
    }
}
