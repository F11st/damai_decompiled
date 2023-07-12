package tb;

import java.math.BigInteger;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class lx1 {
    public static final BigInteger FEATURE_TAG_ID = new BigInteger("1");
    public static final BigInteger FEATURE_CONTAINER_CACHE = new BigInteger("2");
    public static final BigInteger FEATURE_SIMPLE_POPUP = new BigInteger("4");

    public static boolean a(BigInteger bigInteger, BigInteger bigInteger2) {
        if (bigInteger == null || bigInteger2 == null) {
            return false;
        }
        return bigInteger2.equals(bigInteger.and(bigInteger2));
    }
}
