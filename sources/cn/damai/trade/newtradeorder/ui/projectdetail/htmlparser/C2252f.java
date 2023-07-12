package cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser;

import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AlignmentSpan;
import android.util.Log;
import cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.C2247c;
import cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.HtmlParserManager;
import cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.callback.ImageGetter;
import cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.callback.ImageGetterCallBack;
import cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.callback.SpanClickListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import org.apache.commons.text.StringEscapeUtils;
import tb.cb1;
import tb.fi2;
import tb.g11;
import tb.g91;
import tb.ky1;
import tb.nw0;
import tb.uz0;
import tb.xz0;

/* compiled from: Taobao */
/* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.f */
/* loaded from: classes8.dex */
public class C2252f implements ParserCallback, ImageGetterCallBack {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final String m = "htmlParser " + C2252f.class.getSimpleName();
    private String a;
    private SpannableStringBuilder b;
    private ImageGetter c;
    private SpanClickListener d;
    private C2249d e;
    private Stack<C2247c> f;
    private int g;
    private HtmlParserManager.OnParseFinishedListener h;
    private List<HtmlParserManager.C2244a> i;
    private int j;
    private boolean k;
    private List<HtmlParserManager.C2244a> l;

    private C2252f(String str, ImageGetter imageGetter, SpanClickListener spanClickListener, HtmlParserManager.OnParseFinishedListener onParseFinishedListener) {
        this.a = str;
        this.d = spanClickListener;
        this.c = imageGetter;
        C2249d c2249d = new C2249d();
        this.e = c2249d;
        c2249d.p(this);
        this.f = new Stack<>();
        this.g = 0;
        this.i = new ArrayList();
        this.l = new ArrayList();
        this.h = onParseFinishedListener;
        this.j = 1;
    }

    private void a(C2247c.C2248a c2248a) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-445838645")) {
            ipChange.ipc$dispatch("-445838645", new Object[]{this, c2248a});
            return;
        }
        HtmlParserManager.C2244a c2244a = new HtmlParserManager.C2244a();
        c2244a.l(this.j);
        c2244a.g(new SpannableStringBuilder().append((CharSequence) new SpannableString(c2248a.a)));
        c2244a.f(c2248a.g);
        c2244a.m(c2248a.h);
        c2244a.j(c2248a.i);
        c2244a.i(c2248a.j);
        c2244a.h(c2248a.k);
        this.i.add(c2244a);
        if (this.k) {
            this.l.add(c2244a);
        }
        this.b = new SpannableStringBuilder();
        this.g = 0;
        this.j = 1;
    }

    private void b() {
        int length;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-925916982")) {
            ipChange.ipc$dispatch("-925916982", new Object[]{this});
            return;
        }
        HtmlParserManager.C2244a c2244a = new HtmlParserManager.C2244a();
        c2244a.l(this.j);
        if (this.j == 1 && (length = this.b.length()) > 1) {
            int i = length - 1;
            if (this.b.charAt(i) == '\n') {
                this.b.delete(i, length);
            }
            cb1.b(m, "mSpannedBuilder str = " + this.b.toString());
        }
        c2244a.g(this.b);
        this.i.add(c2244a);
        this.b = new SpannableStringBuilder();
        this.g = 0;
        this.j = 1;
    }

    public static void c(String str, ImageGetter imageGetter, SpanClickListener spanClickListener, HtmlParserManager.OnParseFinishedListener onParseFinishedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-798146420")) {
            ipChange.ipc$dispatch("-798146420", new Object[]{str, imageGetter, spanClickListener, onParseFinishedListener});
        } else {
            new C2252f(str, imageGetter, spanClickListener, onParseFinishedListener).m();
        }
    }

    private void d(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "267685675")) {
            ipChange.ipc$dispatch("267685675", new Object[]{this, Integer.valueOf(i)});
        } else {
            l(i, new ky1());
        }
    }

    private void e(int i, boolean z, int i2, int i3, C2247c.C2248a c2248a) {
        Layout.Alignment alignment;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1849267337")) {
            ipChange.ipc$dispatch("-1849267337", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), c2248a});
            return;
        }
        int i4 = this.g;
        if (i4 <= 0) {
            return;
        }
        if (this.b.charAt(i4 - 1) != '\n') {
            this.b.append('\n');
            this.g++;
        }
        if (z || c2248a == null) {
            return;
        }
        int i5 = c2248a.g;
        if (i5 == 0) {
            alignment = Layout.Alignment.ALIGN_NORMAL;
        } else if (i5 == 2) {
            alignment = Layout.Alignment.ALIGN_OPPOSITE;
        } else {
            alignment = i5 == 1 ? Layout.Alignment.ALIGN_CENTER : null;
        }
        if (alignment != null) {
            k(i3, this.g, new AlignmentSpan.Standard(alignment));
        }
    }

    private void f(int i, int i2, C2247c.C2248a c2248a) {
        Layout.Alignment alignment;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2104427085")) {
            ipChange.ipc$dispatch("2104427085", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), c2248a});
            return;
        }
        l(i, new nw0(i2));
        if (c2248a != null) {
            int i3 = c2248a.e;
            if (i3 == 0) {
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else if (i3 == 2) {
                alignment = Layout.Alignment.ALIGN_OPPOSITE;
            } else {
                alignment = i3 == 1 ? Layout.Alignment.ALIGN_CENTER : null;
            }
            if (alignment != null) {
                k(i, this.g, new AlignmentSpan.Standard(alignment));
            }
        }
    }

    private void g(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1574196538")) {
            ipChange.ipc$dispatch("-1574196538", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.b.append(' ');
        this.g++;
        l(i, new uz0());
    }

    private void h(int i, C2247c.C2248a c2248a) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "802027047")) {
            ipChange.ipc$dispatch("802027047", new Object[]{this, Integer.valueOf(i), c2248a});
        } else if (c2248a == null) {
        } else {
            int i2 = c2248a.h;
            String str = c2248a.a;
            if (i2 == -1) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.j = 2;
                a(c2248a);
            } else if (i2 <= 36) {
                ImageGetter imageGetter = this.c;
                if (imageGetter != null) {
                    imageGetter.getDrawable(str, i, this.g, this);
                }
            } else if (TextUtils.isEmpty(str)) {
            } else {
                this.j = 2;
                a(c2248a);
            }
        }
    }

    private void i(int i, C2247c.C2248a c2248a) {
        Layout.Alignment alignment;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2147372858")) {
            ipChange.ipc$dispatch("2147372858", new Object[]{this, Integer.valueOf(i), c2248a});
        } else if (c2248a == null) {
        } else {
            l(i, new fi2(c2248a));
            int i2 = c2248a.e;
            if (i2 == 0) {
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else if (i2 == 2) {
                alignment = Layout.Alignment.ALIGN_OPPOSITE;
            } else {
                alignment = i2 == 1 ? Layout.Alignment.ALIGN_CENTER : null;
            }
            if (alignment != null) {
                k(i, this.g, new AlignmentSpan.Standard(alignment));
            }
        }
    }

    private void j(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1234007385")) {
            ipChange.ipc$dispatch("1234007385", new Object[]{this, Integer.valueOf(i), str});
            return;
        }
        l(i, new g91(str, this.d));
        List<HtmlParserManager.C2244a> list = this.l;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.l.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.l.get(i2).k(str);
        }
        this.l.clear();
    }

    private void k(int i, int i2, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1068120661")) {
            ipChange.ipc$dispatch("-1068120661", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), obj});
        } else if (i2 <= i) {
        } else {
            this.b.setSpan(obj, i, i2, 33);
        }
    }

    private void l(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2072047408")) {
            ipChange.ipc$dispatch("-2072047408", new Object[]{this, Integer.valueOf(i), obj});
        } else {
            k(i, this.g, obj);
        }
    }

    private void m() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2011962905")) {
            ipChange.ipc$dispatch("-2011962905", new Object[]{this});
            return;
        }
        try {
            this.e.g(this.a);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.ParserCallback
    public void characters(char[] cArr, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1792263597")) {
            ipChange.ipc$dispatch("1792263597", new Object[]{this, cArr, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        String unescapeHtml4 = StringEscapeUtils.unescapeHtml4(new String(cArr, i, i2));
        if (TextUtils.isEmpty(unescapeHtml4)) {
            return;
        }
        this.b.append((CharSequence) unescapeHtml4);
        this.g += unescapeHtml4.length();
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.ParserCallback
    public void endDocument() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1407262875")) {
            ipChange.ipc$dispatch("-1407262875", new Object[]{this});
            return;
        }
        String str = m;
        Log.d(str, "end   document: " + SystemClock.elapsedRealtime());
        SpannableStringBuilder spannableStringBuilder = this.b;
        if (spannableStringBuilder != null && spannableStringBuilder.length() != 0) {
            b();
        }
        HtmlParserManager.OnParseFinishedListener onParseFinishedListener = this.h;
        if (onParseFinishedListener != null) {
            onParseFinishedListener.onParseFinished(this.i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.ParserCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void endElement(int r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.C2252f.endElement(int, java.lang.String):void");
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.callback.ImageGetterCallBack
    public void onImageReady(String str, int i, int i2, Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1457717654")) {
            ipChange.ipc$dispatch("1457717654", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2), drawable});
            return;
        }
        for (g11 g11Var : (g11[]) this.b.getSpans(i, i2, g11.class)) {
            this.b.removeSpan(g11Var);
        }
        k(i, i2, new g11(str, drawable));
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.ParserCallback
    public void startDocument(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "132518597")) {
            ipChange.ipc$dispatch("132518597", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        String str = m;
        Log.d(str, "start document: " + SystemClock.elapsedRealtime());
        this.i = new ArrayList();
        this.b = new SpannableStringBuilder();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.ParserCallback
    public void startElement(C2247c c2247c) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-377516657")) {
            ipChange.ipc$dispatch("-377516657", new Object[]{this, c2247c});
            return;
        }
        if (xz0.a(c2247c.a)) {
            e(0, true, c2247c.a, this.g, null);
        }
        int i = c2247c.a;
        if (i != -1) {
            if (i != 72) {
                switch (i) {
                    case 14:
                        this.k = true;
                        break;
                    case 15:
                        SpannableStringBuilder spannableStringBuilder = this.b;
                        if (spannableStringBuilder != null && spannableStringBuilder.length() != 0) {
                            b();
                        }
                        h(this.g, c2247c.d);
                        return;
                    case 16:
                        e(-1, false, i, this.g, c2247c.d);
                        return;
                }
                c2247c.c = this.g;
                this.f.push(c2247c);
                return;
            }
            g(this.g);
        }
    }
}
