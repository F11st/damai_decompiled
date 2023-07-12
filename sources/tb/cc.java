package tb;

import cn.damai.seatdecoder.common.decoder.serialize.quantumbinrary.binary.model.orig.OrigRegion;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class cc {
    private static transient /* synthetic */ IpChange $ipChange;
    private LinkedHashMap<String, y40> b;
    private x40 a = x40.b(this);
    private c50 c = c50.d();

    private cc() {
    }

    public static String c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "417894615") ? (String) ipChange.ipc$dispatch("417894615", new Object[0]) : "dadafeed";
    }

    public static cc d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-929234603") ? (cc) ipChange.ipc$dispatch("-929234603", new Object[0]) : new cc();
    }

    private InputStream e(InputStream inputStream) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1188754223")) {
            return (InputStream) ipChange.ipc$dispatch("-1188754223", new Object[]{this, inputStream});
        }
        if (!inputStream.markSupported()) {
            new BufferedInputStream(inputStream);
        }
        try {
            inputStream.mark(4);
            byte[] bArr = new byte[2];
            int read = inputStream.read(bArr, 0, 2);
            int i = 65535 & (bArr[0] + (bArr[1] << 8));
            inputStream.reset();
            return (read == 2 && i == 35615) ? new GZIPInputStream(inputStream) : inputStream;
        } catch (IOException e) {
            e.printStackTrace();
            return inputStream;
        }
    }

    public static String f() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1819404565") ? (String) ipChange.ipc$dispatch("1819404565", new Object[0]) : "0.4";
    }

    public LinkedHashMap<String, OrigRegion> a(InputStream inputStream) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1805232092")) {
            return (LinkedHashMap) ipChange.ipc$dispatch("-1805232092", new Object[]{this, inputStream});
        }
        w40 a = this.a.a(e(inputStream));
        this.b = a.a;
        this.c = a.b;
        LinkedHashMap<String, OrigRegion> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry<String, y40> entry : this.b.entrySet()) {
            y40 value = entry.getValue();
            value.e(entry.getKey());
            value.a();
            OrigRegion origRegion = new OrigRegion();
            origRegion.init(value.d(), value.c());
            linkedHashMap.put(value.d(), origRegion);
        }
        return linkedHashMap;
    }

    public c50 b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2093682439") ? (c50) ipChange.ipc$dispatch("-2093682439", new Object[]{this}) : this.c;
    }
}
