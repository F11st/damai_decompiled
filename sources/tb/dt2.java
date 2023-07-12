package tb;

import com.taobao.monitor.impl.data.utsession.IUTSession;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class dt2 implements IUTSession {
    private static final dt2 b = new dt2();
    private IUTSession a = null;

    private dt2() {
    }

    public static dt2 a() {
        return b;
    }

    public void b(IUTSession iUTSession) {
        this.a = iUTSession;
    }

    @Override // com.taobao.monitor.impl.data.utsession.IUTSession
    public String getUtsid() {
        IUTSession iUTSession = this.a;
        return iUTSession == null ? "" : iUTSession.getUtsid();
    }
}
