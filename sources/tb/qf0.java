package tb;

import com.alibaba.appmonitor.pool.C3316a;
import com.alibaba.appmonitor.pool.Reusable;
import com.alibaba.appmonitor.pool.ReuseJSONObject;
import com.alibaba.fastjson.JSONObject;
import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import com.youku.vpm.track.OnePlayTrack;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public abstract class qf0 implements Reusable {
    public String a;
    public String b;
    public String c;
    public int d;
    public long e = AbsPerformance.LONG_NIL;
    public long f = 0;

    public void a(Long l) {
        if (l == null) {
            l = Long.valueOf(System.currentTimeMillis() / 1000);
        }
        if (this.e > l.longValue()) {
            this.e = l.longValue();
        }
        if (this.f < l.longValue()) {
            this.f = l.longValue();
        }
    }

    public JSONObject b() {
        JSONObject jSONObject = (JSONObject) C3316a.a().poll(ReuseJSONObject.class, new Object[0]);
        jSONObject.put("page", (Object) this.a);
        jSONObject.put("monitorPoint", (Object) this.b);
        jSONObject.put(OnePlayTrack.PlayType.BEGIN, (Object) Long.valueOf(this.e));
        jSONObject.put("end", (Object) Long.valueOf(this.f));
        String str = this.c;
        if (str != null) {
            jSONObject.put("arg", (Object) str);
        }
        return jSONObject;
    }

    @Override // com.alibaba.appmonitor.pool.Reusable
    public void clean() {
        this.d = 0;
        this.a = null;
        this.b = null;
        this.c = null;
        this.e = AbsPerformance.LONG_NIL;
        this.f = 0L;
    }

    @Override // com.alibaba.appmonitor.pool.Reusable
    public void fill(Object... objArr) {
        this.d = ((Integer) objArr[0]).intValue();
        this.a = (String) objArr[1];
        this.b = (String) objArr[2];
        if (objArr.length <= 3 || objArr[3] == null) {
            return;
        }
        this.c = (String) objArr[3];
    }
}
