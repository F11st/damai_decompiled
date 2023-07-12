package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class q40 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(List<ByteBuffer> list, String str) {
        Iterator<ByteBuffer> it;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1797967450")) {
            ipChange.ipc$dispatch("-1797967450", new Object[]{list, str});
        } else if (C9269io.c()) {
            String str2 = str + ":=";
            while (list.iterator().hasNext()) {
                str2 = str2 + sh2.d(it.next()) + "|";
            }
            C9269io.a("binary", str2);
        }
    }

    public static void b(List<Long> list, String str) {
        Iterator<Long> it;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "697579594")) {
            ipChange.ipc$dispatch("697579594", new Object[]{list, str});
        } else if (C9269io.c()) {
            String str2 = str + ":=";
            while (list.iterator().hasNext()) {
                str2 = str2 + sh2.e(String.valueOf(it.next().longValue()).getBytes()) + "|";
            }
            C9269io.a("binary", str2);
        }
    }

    public static void c(List<Long> list, String str) {
        Iterator<Long> it;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "480104799")) {
            ipChange.ipc$dispatch("480104799", new Object[]{list, str});
        } else if (C9269io.c()) {
            String str2 = str + ":=";
            while (list.iterator().hasNext()) {
                str2 = str2 + it.next() + "|";
            }
            C9269io.a("binary", str2);
        }
    }

    public static void d(List<String> list, String str) {
        Iterator<String> it;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2108685610")) {
            ipChange.ipc$dispatch("2108685610", new Object[]{list, str});
        } else if (C9269io.c()) {
            String str2 = str + ":=";
            while (list.iterator().hasNext()) {
                str2 = str2 + it.next() + "|";
            }
            C9269io.a("binary", str2);
        }
    }
}
