package cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser;

import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AlignmentSpan;
import android.util.Log;
import cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.HtmlParserManager;
import cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.c;
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
/* loaded from: classes8.dex */
public class f implements ParserCallback, ImageGetterCallBack {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final String m = "htmlParser " + f.class.getSimpleName();
    private String a;
    private SpannableStringBuilder b;
    private ImageGetter c;
    private SpanClickListener d;
    private d e;
    private Stack<c> f;
    private int g;
    private HtmlParserManager.OnParseFinishedListener h;
    private List<HtmlParserManager.a> i;
    private int j;
    private boolean k;
    private List<HtmlParserManager.a> l;

    private f(String str, ImageGetter imageGetter, SpanClickListener spanClickListener, HtmlParserManager.OnParseFinishedListener onParseFinishedListener) {
        this.a = str;
        this.d = spanClickListener;
        this.c = imageGetter;
        d dVar = new d();
        this.e = dVar;
        dVar.p(this);
        this.f = new Stack<>();
        this.g = 0;
        this.i = new ArrayList();
        this.l = new ArrayList();
        this.h = onParseFinishedListener;
        this.j = 1;
    }

    private void a(c.a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-445838645")) {
            ipChange.ipc$dispatch("-445838645", new Object[]{this, aVar});
            return;
        }
        HtmlParserManager.a aVar2 = new HtmlParserManager.a();
        aVar2.l(this.j);
        aVar2.g(new SpannableStringBuilder().append((CharSequence) new SpannableString(aVar.a)));
        aVar2.f(aVar.g);
        aVar2.m(aVar.h);
        aVar2.j(aVar.i);
        aVar2.i(aVar.j);
        aVar2.h(aVar.k);
        this.i.add(aVar2);
        if (this.k) {
            this.l.add(aVar2);
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
        HtmlParserManager.a aVar = new HtmlParserManager.a();
        aVar.l(this.j);
        if (this.j == 1 && (length = this.b.length()) > 1) {
            int i = length - 1;
            if (this.b.charAt(i) == '\n') {
                this.b.delete(i, length);
            }
            cb1.b(m, "mSpannedBuilder str = " + this.b.toString());
        }
        aVar.g(this.b);
        this.i.add(aVar);
        this.b = new SpannableStringBuilder();
        this.g = 0;
        this.j = 1;
    }

    public static void c(String str, ImageGetter imageGetter, SpanClickListener spanClickListener, HtmlParserManager.OnParseFinishedListener onParseFinishedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-798146420")) {
            ipChange.ipc$dispatch("-798146420", new Object[]{str, imageGetter, spanClickListener, onParseFinishedListener});
        } else {
            new f(str, imageGetter, spanClickListener, onParseFinishedListener).m();
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

    private void e(int i, boolean z, int i2, int i3, c.a aVar) {
        Layout.Alignment alignment;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1849267337")) {
            ipChange.ipc$dispatch("-1849267337", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), aVar});
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
        if (z || aVar == null) {
            return;
        }
        int i5 = aVar.g;
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

    private void f(int i, int i2, c.a aVar) {
        Layout.Alignment alignment;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2104427085")) {
            ipChange.ipc$dispatch("2104427085", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), aVar});
            return;
        }
        l(i, new nw0(i2));
        if (aVar != null) {
            int i3 = aVar.e;
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

    private void h(int i, c.a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "802027047")) {
            ipChange.ipc$dispatch("802027047", new Object[]{this, Integer.valueOf(i), aVar});
        } else if (aVar == null) {
        } else {
            int i2 = aVar.h;
            String str = aVar.a;
            if (i2 == -1) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.j = 2;
                a(aVar);
            } else if (i2 <= 36) {
                ImageGetter imageGetter = this.c;
                if (imageGetter != null) {
                    imageGetter.getDrawable(str, i, this.g, this);
                }
            } else if (TextUtils.isEmpty(str)) {
            } else {
                this.j = 2;
                a(aVar);
            }
        }
    }

    private void i(int i, c.a aVar) {
        Layout.Alignment alignment;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2147372858")) {
            ipChange.ipc$dispatch("2147372858", new Object[]{this, Integer.valueOf(i), aVar});
        } else if (aVar == null) {
        } else {
            l(i, new fi2(aVar));
            int i2 = aVar.e;
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
        List<HtmlParserManager.a> list = this.l;
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
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.f.endElement(int, java.lang.String):void");
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
    public void startElement(c cVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-377516657")) {
            ipChange.ipc$dispatch("-377516657", new Object[]{this, cVar});
            return;
        }
        if (xz0.a(cVar.a)) {
            e(0, true, cVar.a, this.g, null);
        }
        int i = cVar.a;
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
                        h(this.g, cVar.d);
                        return;
                    case 16:
                        e(-1, false, i, this.g, cVar.d);
                        return;
                }
                cVar.c = this.g;
                this.f.push(cVar);
                return;
            }
            g(this.g);
        }
    }
}
