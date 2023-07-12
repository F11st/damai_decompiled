package tb;

import anet.channel.thread.ThreadPoolExecutorFactory;
import com.youku.live.livesdk.preloader.Preloader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import mtopsdk.common.util.HttpHeaderConstant;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class g22 {
    private static Map<String, Integer> a;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put("tpatch", 3);
        a.put("so", 3);
        a.put(Preloader.KEY_JSON, 3);
        a.put("html", 4);
        a.put("htm", 4);
        a.put("css", 5);
        a.put("js", 5);
        a.put("webp", 6);
        a.put("png", 6);
        a.put("jpg", 6);
        a.put("do", 6);
        a.put("zip", Integer.valueOf(ThreadPoolExecutorFactory.b.c));
        a.put("bin", Integer.valueOf(ThreadPoolExecutorFactory.b.c));
        a.put("apk", Integer.valueOf(ThreadPoolExecutorFactory.b.c));
    }

    public static int a(anet.channel.request.a aVar) {
        Integer num;
        Objects.requireNonNull(aVar, "url is null!");
        if (aVar.g().containsKey(HttpHeaderConstant.X_PV)) {
            return 1;
        }
        String k = h01.k(aVar.j().h());
        if (k == null || (num = a.get(k)) == null) {
            return 6;
        }
        return num.intValue();
    }
}
