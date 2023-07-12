package cn.damai.ticklet.utils;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.math.BigInteger;
import mtopsdk.common.util.SymbolExpUtil;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class b {
    private static transient /* synthetic */ IpChange $ipChange;

    public static byte[] a(byte[] bArr, String str) throws Exception {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1113722714")) {
            return (byte[]) ipChange.ipc$dispatch("1113722714", new Object[]{bArr, str});
        }
        String[] split = str.split(SymbolExpUtil.SYMBOL_VERTICALBAR);
        return b(bArr, new BigInteger(split[0]), new BigInteger(split[1]));
    }

    private static byte[] b(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) throws Exception {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1916675254") ? (byte[]) ipChange.ipc$dispatch("1916675254", new Object[]{bArr, bigInteger, bigInteger2}) : new BigInteger(bArr).modPow(bigInteger2, bigInteger).toByteArray();
    }
}
