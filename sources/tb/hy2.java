package tb;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class hy2 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String h = "tb.hy2";
    private final View a;
    private View b;
    private View c;
    private ViewGroup d;
    private final ViewGroup.LayoutParams e;
    private int f = 0;
    private final int g;

    public hy2(View view) {
        this.a = view;
        this.e = view.getLayoutParams();
        this.c = view;
        this.g = view.getId();
    }

    private boolean b() {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1677605043")) {
            return ((Boolean) ipChange.ipc$dispatch("-1677605043", new Object[]{this})).booleanValue();
        }
        if (this.d == null) {
            ViewGroup viewGroup = (ViewGroup) this.a.getParent();
            this.d = viewGroup;
            if (viewGroup == null) {
                Log.e(h, "the source view have not attach to any view");
                return false;
            }
            int childCount = viewGroup.getChildCount();
            while (true) {
                if (i >= childCount) {
                    break;
                } else if (this.a == this.d.getChildAt(i)) {
                    this.f = i;
                    break;
                } else {
                    i++;
                }
            }
        }
        return true;
    }

    public View a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "747665095") ? (View) ipChange.ipc$dispatch("747665095", new Object[]{this}) : this.b;
    }

    public void c(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "233738965")) {
            ipChange.ipc$dispatch("233738965", new Object[]{this, view});
        } else if (this.c == view) {
        } else {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            if (b()) {
                this.b = view;
                this.d.removeView(this.c);
                this.b.setId(this.g);
                this.d.addView(this.b, this.f, this.e);
                this.c = this.b;
            }
        }
    }

    public void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1625091901")) {
            ipChange.ipc$dispatch("-1625091901", new Object[]{this});
            return;
        }
        ViewGroup viewGroup = this.d;
        if (viewGroup != null) {
            viewGroup.removeView(this.c);
            this.d.addView(this.a, this.f, this.e);
            this.c = this.a;
            this.b = null;
        }
    }
}
