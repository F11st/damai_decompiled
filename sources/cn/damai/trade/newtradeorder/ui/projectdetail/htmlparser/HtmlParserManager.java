package cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser;

import android.content.Context;
import android.text.Spanned;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.sm;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class HtmlParserManager {
    private static transient /* synthetic */ IpChange $ipChange;
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private float f;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface OnParseFinishedListener {
        void onParseFinished(List<a> list);
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface OnSpanClickListener {
        void onSpanClick(int i, String str);
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public static class a {
        private static transient /* synthetic */ IpChange $ipChange;
        private int a;
        private Spanned b;
        private int c;
        private int d;
        private int e;
        private int f;
        private String g;

        public Spanned a() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-868270498") ? (Spanned) ipChange.ipc$dispatch("-868270498", new Object[]{this}) : this.b;
        }

        public int b() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1892743277") ? ((Integer) ipChange.ipc$dispatch("-1892743277", new Object[]{this})).intValue() : this.f;
        }

        public int c() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1534701840") ? ((Integer) ipChange.ipc$dispatch("-1534701840", new Object[]{this})).intValue() : this.e;
        }

        public String d() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1349031808") ? (String) ipChange.ipc$dispatch("-1349031808", new Object[]{this}) : this.g;
        }

        public int e() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1039143332") ? ((Integer) ipChange.ipc$dispatch("1039143332", new Object[]{this})).intValue() : this.a;
        }

        public void f(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "737838429")) {
                ipChange.ipc$dispatch("737838429", new Object[]{this, Integer.valueOf(i)});
            }
        }

        public void g(Spanned spanned) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-44233056")) {
                ipChange.ipc$dispatch("-44233056", new Object[]{this, spanned});
            } else {
                this.b = spanned;
            }
        }

        public void h(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1920403241")) {
                ipChange.ipc$dispatch("-1920403241", new Object[]{this, Integer.valueOf(i)});
            } else {
                this.f = i;
            }
        }

        public void i(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1271239758")) {
                ipChange.ipc$dispatch("-1271239758", new Object[]{this, Integer.valueOf(i)});
            } else {
                this.e = i;
            }
        }

        public void j(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-312701333")) {
                ipChange.ipc$dispatch("-312701333", new Object[]{this, Integer.valueOf(i)});
            } else {
                this.d = i;
            }
        }

        public void k(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "836930142")) {
                ipChange.ipc$dispatch("836930142", new Object[]{this, str});
            } else {
                this.g = str;
            }
        }

        public void l(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2060122238")) {
                ipChange.ipc$dispatch("2060122238", new Object[]{this, Integer.valueOf(i)});
            } else {
                this.a = i;
            }
        }

        public void m(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1080831074")) {
                ipChange.ipc$dispatch("-1080831074", new Object[]{this, Integer.valueOf(i)});
            } else {
                this.c = i;
            }
        }

        public String toString() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "312614691")) {
                return (String) ipChange.ipc$dispatch("312614691", new Object[]{this});
            }
            return ", content:" + ((CharSequence) this.b) + ", width:" + this.c + ", height:" + this.d + ", damaiWidth:" + this.e + ", damaiHeight:" + this.f + "}";
        }
    }

    private HtmlParserManager(int i, float f, int i2, int i3, int i4, int i5) {
        this.a = i;
        this.f = f;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
    }

    public static HtmlParserManager a(int i, float f, int i2, int i3, int i4, int i5) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "615764478") ? (HtmlParserManager) ipChange.ipc$dispatch("615764478", new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) : new HtmlParserManager(i, f, i2, i3, i4, i5);
    }

    private void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1772003772")) {
            ipChange.ipc$dispatch("1772003772", new Object[]{this});
            return;
        }
        sm b = sm.b();
        b.h(this.b);
        b.g(this.c);
        b.d(this.d);
        b.c(this.e);
        b.f(this.f);
        b.e(this.a);
    }

    public void c(Context context, String str, OnSpanClickListener onSpanClickListener, OnParseFinishedListener onParseFinishedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1050761823")) {
            ipChange.ipc$dispatch("-1050761823", new Object[]{this, context, str, onSpanClickListener, onParseFinishedListener});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            b();
            HtmlView.d(str).e(context, onSpanClickListener, onParseFinishedListener);
        }
    }
}
