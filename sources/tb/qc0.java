package tb;

import android.text.TextUtils;
import com.alipay.sdk.m.l.C4232c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class qc0 {
    public List<l41> a = new ArrayList();
    public jq1 b = new jq1();

    public qc0() {
    }

    public boolean a() {
        List<l41> list;
        if (this.b != null && (list = this.a) != null && !list.isEmpty()) {
            if (TextUtils.isEmpty(this.b.f)) {
                ka0.h("DownloadRequest", C4232c.j, "param fileStorePath is null");
                return false;
            }
            for (l41 l41Var : this.a) {
                if (TextUtils.isEmpty(l41Var.a)) {
                    ka0.h("DownloadRequest", C4232c.j, "param url is null");
                    return false;
                }
            }
            ArrayList arrayList = new ArrayList();
            for (l41 l41Var2 : this.a) {
                if (!arrayList.contains(l41Var2)) {
                    arrayList.add(l41Var2);
                }
            }
            this.a = arrayList;
            return true;
        }
        ka0.h("DownloadRequest", C4232c.j, "param is null");
        return false;
    }

    public qc0(String str) {
        l41 l41Var = new l41();
        l41Var.a = str;
        this.a.add(l41Var);
    }
}
