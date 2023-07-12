package tb;

import android.view.View;
import com.taobao.android.dinamic.tempate.DinamicTemplate;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class iy2 {
    private View a;
    private DinamicTemplate b;
    private p80 c;
    private String d;
    private ArrayList<View> e;

    public iy2(String str) {
        this.d = str;
    }

    public ArrayList<View> a() {
        return this.e;
    }

    public p80 b() {
        if (this.c == null) {
            this.c = new p80(this.d);
        }
        return this.c;
    }

    public DinamicTemplate c() {
        return this.b;
    }

    public View d() {
        return this.a;
    }

    public boolean e() {
        p80 p80Var = this.c;
        return p80Var == null || p80Var.d();
    }

    public boolean f() {
        p80 p80Var = this.c;
        return p80Var == null || p80Var.d();
    }

    public void g(ArrayList<View> arrayList) {
        this.e = arrayList;
    }

    public void h(DinamicTemplate dinamicTemplate) {
        this.b = dinamicTemplate;
    }

    public void i(View view) {
        this.a = view;
    }
}
