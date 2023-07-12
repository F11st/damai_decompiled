package tb;

import android.content.Context;
import android.os.Message;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.efs.sdk.base.observer.IEfsReporterObserver;
import com.efs.sdk.base.processor.action.ILogEncryptAction;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class f33 {
    public String a;
    public String b;
    public Context c;
    public String i;
    public ILogEncryptAction o;
    public boolean d = true;
    public boolean e = true;
    public boolean f = false;
    private Boolean g = null;
    public boolean h = false;
    public boolean j = false;
    public long k = DanmakuFactory.DEFAULT_DANMAKU_DURATION_V;
    public long l = 10000;
    public long m = 10000;
    private Map<String, String> n = new HashMap(5);
    public ConcurrentHashMap<Integer, List<ValueCallback<Pair<Message, Message>>>> p = new ConcurrentHashMap<>();
    public List<IEfsReporterObserver> q = new ArrayList(5);

    public final List<ValueCallback<Pair<Message, Message>>> a(int i) {
        return (!this.p.containsKey(Integer.valueOf(i)) || this.p.get(Integer.valueOf(i)) == null) ? Collections.emptyList() : this.p.get(Integer.valueOf(i));
    }

    public final Map<String, String> b() {
        Map<String, String> map = this.n;
        return map == null ? Collections.emptyMap() : map;
    }

    public final void c(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        HashMap hashMap = new HashMap(this.n);
        hashMap.putAll(map);
        this.n = hashMap;
    }

    public final boolean d() {
        if (this.g == null) {
            this.g = Boolean.valueOf(m43.b(m43.a("logs")));
        }
        if (this.g.booleanValue()) {
            return true;
        }
        return this.f;
    }
}
