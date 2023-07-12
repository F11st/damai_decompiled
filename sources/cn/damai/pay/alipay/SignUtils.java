package cn.damai.pay.alipay;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class SignUtils {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String ALGORITHM = "RSA";
    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final String SIGN_ALGORITHMS = "SHA1WithRSA";
    private static final String SIGN_SHA256RSA_ALGORITHMS = "SHA256WithRSA";

    private static String getAlgorithms(boolean z) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1940842254") ? (String) ipChange.ipc$dispatch("1940842254", new Object[]{Boolean.valueOf(z)}) : z ? SIGN_SHA256RSA_ALGORITHMS : "SHA1WithRSA";
    }

    public static String sign(String str, String str2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-104070543")) {
            return (String) ipChange.ipc$dispatch("-104070543", new Object[]{str, str2, Boolean.valueOf(z)});
        }
        try {
            PrivateKey generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str2)));
            Signature signature = Signature.getInstance(getAlgorithms(z));
            signature.initSign(generatePrivate);
            signature.update(str.getBytes("UTF-8"));
            return Base64.encode(signature.sign());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
