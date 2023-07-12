package tb;

import com.taobao.android.dinamicx.widget.DXWidgetNode;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class i00 extends hy {
    protected int d;
    protected int e;
    protected int f;
    protected int g;
    protected String h;
    protected DXWidgetNode i;

    public i00(long j) {
        super(j);
    }

    public void f(int i) {
        this.e = i;
    }

    public void g(int i) {
        this.d = i;
    }

    public void h(int i) {
        this.g = i;
    }

    public void i(int i) {
        this.f = i;
    }

    public void j(DXWidgetNode dXWidgetNode) {
        this.i = dXWidgetNode;
    }

    public void k(String str) {
        this.h = str;
    }

    public String toString() {
        return "DXRecyclerEvent{, deltaY=" + this.d + ", deltaX=" + this.e + ", offsetY=" + this.f + ", offsetX=" + this.g + ", userId='" + this.h + "', selfWidget=" + this.i + '}';
    }
}
