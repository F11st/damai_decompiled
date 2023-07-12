package tb;

import com.taobao.downloader.download.IListener;
import mtopsdk.mtop.util.ErrorConstant;
import tb.nh1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class fp1 {
    public IListener b;
    public boolean d;
    public int a = 10;
    public long c = 0;
    public C9143a e = new C9143a();
    public nh1.C9474a f = new nh1.C9474a();

    /* compiled from: Taobao */
    /* renamed from: tb.fp1$a */
    /* loaded from: classes11.dex */
    public static class C9143a {
        public boolean a = true;
        public boolean b;
        public boolean c;
        public boolean d;
        public boolean e;
        public int f;
        public int g;
        public String h;

        public C9143a a(int i, int i2, String str) {
            this.a = false;
            this.f = i;
            this.g = i2;
            this.h = str;
            return this;
        }
    }

    public fp1(IListener iListener) {
        this.b = iListener;
    }

    public void a(w21 w21Var) {
        if (this.b == null) {
            return;
        }
        id2 id2Var = w21Var.b;
        C9143a c9143a = this.e;
        if (c9143a.a) {
            id2Var.a = true;
            id2Var.d = w21Var.e.getAbsolutePath();
            id2Var.b = this.a;
            id2Var.c = "下载成功";
        } else {
            id2Var.a = false;
            id2Var.b = c9143a.f;
            id2Var.h.a(c9143a.c);
            int i = id2Var.b;
            if (i == -21) {
                id2Var.c = "手机剩余空间不足";
            } else if (i != -18 && i != -15) {
                switch (i) {
                    case -12:
                        id2Var.c = ErrorConstant.ERRMSG_NETWORK_ERROR;
                        break;
                    case -11:
                        id2Var.c = "文件读写错误";
                        break;
                    case -10:
                        id2Var.c = "url错误";
                        break;
                    default:
                        id2Var.c = "下载失败";
                        break;
                }
            } else {
                id2Var.c = "文件校验失败";
            }
        }
        nh1.C9474a c9474a = this.f;
        c9474a.a = w21Var.c;
        c9474a.b = id2Var.e.b;
        long j = c9474a.f;
        if (0 != j) {
            c9474a.g = (c9474a.i / 1024.0d) / (j / 1000.0d);
        }
        boolean z = id2Var.a;
        c9474a.c = z;
        if (z) {
            c9474a.j = String.valueOf(this.a);
        } else {
            C9143a c9143a2 = this.e;
            c9474a.j = String.valueOf((c9143a2.f * 1000) - c9143a2.g);
        }
        nh1.C9474a c9474a2 = this.f;
        c9474a2.k = this.e.h;
        c9474a2.h = id2Var.f.a;
        this.b.onResult(id2Var);
    }

    public void b() {
        IListener iListener = this.b;
        if (iListener != null) {
            iListener.onProgress(this.c);
        }
    }
}
