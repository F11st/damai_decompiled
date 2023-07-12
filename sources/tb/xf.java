package tb;

import com.taobao.android.dinamic.property.DAttrConstant;
import com.taobao.downloader.adpater.Monitor;
import com.taobao.downloader.request.DownloadListener;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class xf {
    private int a;
    private boolean b;
    private String c;
    private String d;
    private String e;
    private qc0 f;
    private DownloadListener g;

    public xf(String str, qc0 qc0Var, DownloadListener downloadListener) {
        this.e = str;
        this.f = qc0Var;
        this.g = downloadListener;
    }

    public void a(id2 id2Var) {
        if (id2Var == null) {
            return;
        }
        try {
            boolean z = true;
            if (id2Var.a) {
                ka0.c("Callback", "onDownloadFinish", "task", id2Var);
                this.g.onDownloadFinish(id2Var.e.a, id2Var.d);
            } else {
                ka0.c("Callback", "onDownloadError", "task", id2Var);
                this.g.onDownloadError(id2Var.e.a, id2Var.b, id2Var.c);
                this.b = true;
                this.c = String.valueOf(id2Var.b);
                this.d = id2Var.e.a;
            }
            int i = this.a + 1;
            this.a = i;
            if (i == this.f.a.size()) {
                ka0.c(DAttrConstant.VIEW_EVENT_FINISH, "task", id2Var);
                if (this.b) {
                    nh1.a(Monitor.POINT_ALL_CALLBACK, id2Var.f.n + this.e, this.c, this.d);
                } else {
                    nh1.b(Monitor.POINT_ALL_CALLBACK, id2Var.f.n + this.e);
                }
                DownloadListener downloadListener = this.g;
                if (this.b) {
                    z = false;
                }
                downloadListener.onFinish(z);
            }
        } catch (Throwable th) {
            ka0.d("Callback", "on callback", th, new Object[0]);
        }
    }
}
