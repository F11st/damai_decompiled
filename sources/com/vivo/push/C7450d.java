package com.vivo.push;

import android.content.Intent;
import com.vivo.push.b.C7421i;
import com.vivo.push.b.C7422j;
import com.vivo.push.b.C7423k;
import com.vivo.push.b.C7424l;
import com.vivo.push.b.C7425m;
import com.vivo.push.b.C7426n;
import com.vivo.push.b.C7427o;
import com.vivo.push.b.C7428p;
import com.vivo.push.b.C7429q;
import com.vivo.push.b.C7430r;
import com.vivo.push.b.C7432t;
import com.vivo.push.b.C7433u;
import com.vivo.push.d.AbstractC7480z;
import com.vivo.push.d.ag;
import com.vivo.push.util.C7523p;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.d */
/* loaded from: classes11.dex */
public final class C7450d implements IPushClientFactory {
    private ag a = new ag();

    @Override // com.vivo.push.IPushClientFactory
    public final AbstractC7480z createReceiveTask(AbstractC7496o abstractC7496o) {
        return ag.b(abstractC7496o);
    }

    @Override // com.vivo.push.IPushClientFactory
    public final AbstractC7496o createReceiverCommand(Intent intent) {
        AbstractC7496o c7433u;
        AbstractC7496o c7432t;
        int intExtra = intent.getIntExtra("command", -1);
        if (intExtra < 0) {
            intExtra = intent.getIntExtra("method", -1);
        }
        if (intExtra == 20) {
            c7433u = new C7433u();
        } else if (intExtra != 2016) {
            switch (intExtra) {
                case 1:
                case 2:
                    c7432t = new C7432t(intExtra);
                    c7433u = c7432t;
                    break;
                case 3:
                    c7433u = new C7427o();
                    break;
                case 4:
                    c7433u = new C7429q();
                    break;
                case 5:
                    c7433u = new C7428p();
                    break;
                case 6:
                    c7433u = new C7430r();
                    break;
                case 7:
                    c7433u = new C7426n();
                    break;
                case 8:
                    c7433u = new C7425m();
                    break;
                case 9:
                    c7433u = new C7423k();
                    break;
                case 10:
                case 11:
                    c7432t = new C7421i(intExtra);
                    c7433u = c7432t;
                    break;
                case 12:
                    c7433u = new C7422j();
                    break;
                default:
                    c7433u = null;
                    break;
            }
        } else {
            c7433u = new C7424l();
        }
        if (c7433u != null) {
            C7410a a = C7410a.a(intent);
            if (a == null) {
                C7523p.b("PushCommand", "bundleWapper is null");
            } else {
                c7433u.b(a);
            }
        }
        return c7433u;
    }

    @Override // com.vivo.push.IPushClientFactory
    public final AbstractRunnableC7491l createTask(AbstractC7496o abstractC7496o) {
        return ag.a(abstractC7496o);
    }
}
