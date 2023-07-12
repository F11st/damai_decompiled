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
    public a e = new a();
    public nh1.a f = new nh1.a();

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class a {
        public boolean a = true;
        public boolean b;
        public boolean c;
        public boolean d;
        public boolean e;
        public int f;
        public int g;
        public String h;

        public a a(int i, int i2, String str) {
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
        a aVar = this.e;
        if (aVar.a) {
            id2Var.a = true;
            id2Var.d = w21Var.e.getAbsolutePath();
            id2Var.b = this.a;
            id2Var.c = "下载成功";
        } else {
            id2Var.a = false;
            id2Var.b = aVar.f;
            id2Var.h.a(aVar.c);
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
        nh1.a aVar2 = this.f;
        aVar2.a = w21Var.c;
        aVar2.b = id2Var.e.b;
        long j = aVar2.f;
        if (0 != j) {
            aVar2.g = (aVar2.i / 1024.0d) / (j / 1000.0d);
        }
        boolean z = id2Var.a;
        aVar2.c = z;
        if (z) {
            aVar2.j = String.valueOf(this.a);
        } else {
            a aVar3 = this.e;
            aVar2.j = String.valueOf((aVar3.f * 1000) - aVar3.g);
        }
        nh1.a aVar4 = this.f;
        aVar4.k = this.e.h;
        aVar4.h = id2Var.f.a;
        this.b.onResult(id2Var);
    }

    public void b() {
        IListener iListener = this.b;
        if (iListener != null) {
            iListener.onProgress(this.c);
        }
    }
}
