package cn.damai.ticklet.zxing;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import java.util.Hashtable;
import tb.df0;
import tb.dy1;
import tb.fa;
import tb.me0;
import tb.nc;
import tb.ne;
import tb.pe0;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class a implements Writer {
    private static transient /* synthetic */ IpChange $ipChange;

    private static nc a(dy1 dy1Var, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-914457086")) {
            return (nc) ipChange.ipc$dispatch("-914457086", new Object[]{dy1Var, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        ne c = dy1Var.c();
        int e = c.e();
        int d = c.d();
        int max = Math.max(i, e);
        int max2 = Math.max(i2, d);
        int min = Math.min(max / e, max2 / d);
        int i3 = (max - (e * min)) / 2;
        int i4 = (max2 - (d * min)) / 2;
        nc ncVar = new nc(max, max2);
        int i5 = 0;
        while (i5 < d) {
            int i6 = i3;
            int i7 = 0;
            while (i7 < e) {
                if (c.b(i7, i5) == 1) {
                    ncVar.d(i6, i4, min, min);
                }
                i7++;
                i6 += min;
            }
            i5++;
            i4 += min;
        }
        return ncVar;
    }

    @Override // com.google.zxing.Writer
    public nc encode(String str, fa faVar, int i, int i2) throws WriterException {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1858851980") ? (nc) ipChange.ipc$dispatch("-1858851980", new Object[]{this, str, faVar, Integer.valueOf(i), Integer.valueOf(i2)}) : encode(str, faVar, i, i2, null);
    }

    @Override // com.google.zxing.Writer
    public nc encode(String str, fa faVar, int i, int i2, Hashtable hashtable) throws WriterException {
        df0 df0Var;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1456734869")) {
            return (nc) ipChange.ipc$dispatch("1456734869", new Object[]{this, str, faVar, Integer.valueOf(i), Integer.valueOf(i2), hashtable});
        }
        if (str != null && str.length() != 0) {
            if (faVar != fa.QR_CODE) {
                throw new IllegalArgumentException("Can only encode QR_CODE, but got " + faVar);
            } else if (i >= 0 && i2 >= 0) {
                df0 df0Var2 = df0.L;
                if (hashtable != null && (df0Var = (df0) hashtable.get(me0.ERROR_CORRECTION)) != null) {
                    df0Var2 = df0Var;
                }
                dy1 dy1Var = new dy1();
                pe0.l(str, df0Var2, hashtable, dy1Var);
                return a(dy1Var, i, i2);
            } else {
                throw new IllegalArgumentException("Requested dimensions are too small: " + i + 'x' + i2);
            }
        }
        throw new IllegalArgumentException("Found empty contents");
    }
}
