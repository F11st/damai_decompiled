package tb;

import cn.damai.seatdecoder.common.decoder.serialize.quantumbinrary.binary.model.orig.OrigRegion;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.InputStream;
import java.util.LinkedHashMap;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class hy1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static hy1 a;

    hy1() {
    }

    public static hy1 b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "122840091")) {
            return (hy1) ipChange.ipc$dispatch("122840091", new Object[0]);
        }
        if (a == null) {
            synchronized (hy1.class) {
                if (a == null) {
                    a = new hy1();
                }
            }
        }
        return a;
    }

    public LinkedHashMap<String, OrigRegion> a(InputStream inputStream) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1978553282") ? (LinkedHashMap) ipChange.ipc$dispatch("1978553282", new Object[]{this, inputStream}) : cc.d().a(inputStream);
    }

    public hy1 c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1150409954")) {
            return (hy1) ipChange.ipc$dispatch("-1150409954", new Object[]{this});
        }
        pw0.c();
        return this;
    }
}
