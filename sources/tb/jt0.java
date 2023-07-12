package tb;

import androidx.annotation.NonNull;
import cn.damai.fluttercommon.plugin.mtop.MtopPlugin;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.embedding.engine.FlutterEngine;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public final class jt0 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static AtomicBoolean a = new AtomicBoolean(false);
    private static Set<vq> b;

    public static void a(@NonNull FlutterEngine flutterEngine) {
        Set<vq> set;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1278990399")) {
            ipChange.ipc$dispatch("1278990399", new Object[]{flutterEngine});
        } else if (a.get()) {
            cb1.c("GeneratedPluginRegistrant", "Flutter plugin already attached to Engine, return");
        } else if (flutterEngine != null && (set = b) != null && set.size() != 0) {
            for (vq vqVar : b) {
                try {
                    flutterEngine.getPlugins().add(vqVar);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            a.compareAndSet(false, true);
        }
    }

    public static void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1466433974")) {
            ipChange.ipc$dispatch("1466433974", new Object[0]);
            return;
        }
        if (b == null) {
            b = new HashSet();
        }
        b.add(new MtopPlugin());
        b.add(new pn1());
        b.add(new at2());
        b.add(new ji1());
        b.add(new eb2());
        b.add(new v9());
        b.add(new sq());
    }
}
