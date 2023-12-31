package tb;

import android.text.TextUtils;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.notification.DXSignalProduce;
import com.taobao.android.dinamicx.widget.event.IDXControlEventListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class bu implements DXSignalProduce.SignalReceiver {
    public static final int PERIOD_COUNT = 2;
    int c;
    CopyOnWriteArrayList<au> b = new CopyOnWriteArrayList<>();
    Map<String, List<IDXControlEventListener>> a = new HashMap();

    public bu() {
        DXSignalProduce.e().f(this);
    }

    public void a(au auVar) {
        List<IDXControlEventListener> list;
        if (auVar == null || TextUtils.isEmpty(auVar.b) || (list = this.a.get(auVar.b)) == null) {
            return;
        }
        for (IDXControlEventListener iDXControlEventListener : list) {
            iDXControlEventListener.receivedControlEvent(auVar);
        }
    }

    public void b(au auVar) {
        boolean z = false;
        int i = 0;
        while (true) {
            try {
                if (i >= this.b.size()) {
                    z = true;
                    break;
                } else if (this.b.get(i).a(auVar)) {
                    break;
                } else {
                    i++;
                }
            } catch (Throwable th) {
                ry.b(th);
                com.taobao.android.dinamicx.e eVar = new com.taobao.android.dinamicx.e(r10.DB_NAME);
                e.a aVar = new e.a("ControlEventCenter", "ControlEventCenter_Exception", com.taobao.android.dinamicx.e.DX_ERROR_CODE_CONTROL_EVENT_CENTER_EXCEPTION_CRASH);
                aVar.e = ry.a(th);
                eVar.c.add(aVar);
                DXAppMonitor.n(eVar);
                return;
            }
        }
        if (z) {
            this.b.add(auVar);
        }
    }

    public void c(IDXControlEventListener iDXControlEventListener, String str) {
        if (TextUtils.isEmpty(str) || iDXControlEventListener == null) {
            return;
        }
        List<IDXControlEventListener> list = this.a.get(str);
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(iDXControlEventListener);
            this.a.put(str, arrayList);
            return;
        }
        list.add(iDXControlEventListener);
    }

    @Override // com.taobao.android.dinamicx.notification.DXSignalProduce.SignalReceiver
    public void onReceiver() {
        int i = this.c;
        if (i == 2) {
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                a(this.b.get(i2));
            }
            this.b.clear();
            this.c = 0;
            return;
        }
        this.c = i + 1;
    }
}
