package tb;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.taobao.android.dinamicx.view.richtext.node.C6414a;
import com.taobao.android.dinamicx.view.richtext.node.C6424b;
import com.taobao.android.dinamicx.view.richtext.node.RichText;
import com.taobao.android.dinamicx.view.richtext.node.RichTextNode;
import com.taobao.android.dinamicx.view.richtext.span.VerticalCenterSpan;
import com.taobao.android.dinamicx.view.richtext.span.VerticalTopSpan;
import java.util.Iterator;
import java.util.regex.Pattern;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class q32 {
    public static final CharSequence DEFAULT_ELLIPSIS_TEXT = "…";
    private int A;
    private int B;
    private float C;
    private float D;
    private float F;
    private int J;
    private int K;
    private int L;
    private int M;
    private float O;
    private Context a;
    private RichText b;
    private Layout c;
    private float d;
    private float e;
    private CharSequence f;
    private TextPaint g;
    private Paint h;
    private TextUtils.TruncateAt i;
    private Layout.Alignment j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int r;
    private CharSequence s;
    private String x;
    private float q = -1.0f;
    private int t = 32;
    private int u = -16777216;
    private boolean v = false;
    private boolean w = false;
    private int y = 0;
    private int z = 0;
    private int E = 0;
    private int G = Integer.MAX_VALUE;
    private int H = Integer.MAX_VALUE;
    private int I = 1;
    private float N = -1.0f;
    private CharSequence P = DEFAULT_ELLIPSIS_TEXT;
    private float Q = 0.0f;
    private boolean R = true;
    private boolean S = false;
    private int T = 0;

    /* compiled from: Taobao */
    /* renamed from: tb.q32$a */
    /* loaded from: classes11.dex */
    public static class C9594a {
        private int a;
        private int b;

        public C9594a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public int a() {
            return this.b;
        }

        public int b() {
            return this.a;
        }
    }

    private CharSequence a(CharSequence charSequence, int i) {
        int i2;
        int i3 = 1;
        boolean z = this.M == 0;
        SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(charSequence);
        boolean z2 = valueOf.length() < this.s.length() && this.i == TextUtils.TruncateAt.END;
        int length = valueOf.length() - (z2 ? this.P.length() : 0);
        int i4 = 0;
        int i5 = 0;
        while (i4 < this.b.size()) {
            int lineForOffset = this.c.getLineForOffset(i5);
            RichTextNode richTextNode = this.b.get(i4);
            if ((richTextNode instanceof C6424b) && !z) {
                if (i5 >= length) {
                    break;
                }
                int min = Math.min(richTextNode.getText().length() + i5, length);
                int lineForOffset2 = this.c.getLineForOffset(min - 1);
                int i6 = lineForOffset;
                while (i6 <= lineForOffset2) {
                    int lineTop = this.c.getLineTop(i6) - this.c.getLineBaseline(i6);
                    int lineBottom = this.c.getLineBottom(i6) - this.c.getLineBaseline(i6);
                    if (i6 == this.c.getLineCount() - i3) {
                        lineBottom = (int) (lineBottom + this.c.getSpacingAdd());
                    }
                    valueOf.setSpan(this.M == i3 ? new VerticalCenterSpan(lineTop, lineBottom, ((int) this.c.getSpacingAdd()) / 2) : new VerticalTopSpan(lineTop, lineBottom), Math.max(i5, this.c.getLineStart(i6)), Math.min(min, this.c.getLineEnd(i6)), 33);
                    i6++;
                    i3 = 1;
                }
            }
            if (richTextNode instanceof C6414a) {
                C6414a c6414a = (C6414a) richTextNode;
                int lineBottom2 = this.c.getLineBottom(lineForOffset) - this.c.getLineTop(lineForOffset);
                if (this.M == 1) {
                    int q = ((lineBottom2 - c6414a.q()) >> 1) + ((int) (this.c.getSpacingAdd() / 2.0f));
                    i2 = lineForOffset == this.c.getLineCount() - 1 ? (int) (q - (this.c.getSpacingAdd() / 2.0f)) : q;
                } else {
                    i2 = 0;
                }
                if (this.M == 2) {
                    i2 = lineBottom2 - c6414a.q();
                }
                if (this.M == 0) {
                    i2 = (int) this.c.getSpacingAdd();
                }
                c6414a.t(-i2);
            }
            i5 += richTextNode.getText().length();
            i4++;
            i3 = 1;
        }
        if (z2 && !z) {
            int lineCount = this.c.getLineCount() - 1;
            int lineTop2 = this.c.getLineTop(lineCount) - this.c.getLineBaseline(lineCount);
            int lineBottom3 = (this.c.getLineBottom(lineCount) - this.c.getLineBaseline(lineCount)) + ((int) this.c.getSpacingAdd());
            valueOf.setSpan(this.M == 1 ? new VerticalCenterSpan(lineTop2, lineBottom3, ((int) this.c.getSpacingAdd()) / 2) : new VerticalTopSpan(lineTop2, lineBottom3), Math.max(valueOf.length() - this.P.length(), 0), valueOf.length(), 33);
        }
        if (charSequence instanceof SpannableStringBuilder) {
            return null;
        }
        this.c = t(((i - j()) - k()) - (this.z * 2), valueOf, false);
        return valueOf;
    }

    private CharSequence b(CharSequence charSequence) {
        int i;
        float measureText;
        int i2;
        int i3;
        boolean z;
        int i4;
        int lineEnd = this.c.getLineEnd(this.I - 1);
        try {
            TextUtils.TruncateAt truncateAt = this.i;
            if (truncateAt != null && truncateAt == TextUtils.TruncateAt.END && charSequence.length() != 1) {
                CharSequence charSequence2 = this.P;
                if (charSequence2 instanceof Spannable) {
                    measureText = Layout.getDesiredWidth(charSequence2, 0, charSequence2.length(), this.g);
                } else {
                    measureText = this.g.measureText(charSequence2, 0, charSequence2.length());
                }
                float width = this.c.getWidth() - measureText;
                int lineStart = this.c.getLineStart(this.I - 1);
                Iterator<RichTextNode> descendingIterator = this.b.descendingIterator();
                int length = this.b.originText().length();
                TextPaint textPaint = new TextPaint();
                if (Build.VERSION.SDK_INT >= 21) {
                    textPaint.setLetterSpacing(this.g.getLetterSpacing());
                }
                float min = Math.min(Math.max(0.0f, this.c.getLineWidth(this.I - 1)), this.c.getWidth());
                C6424b c6424b = null;
                int i5 = 0;
                while (descendingIterator.hasNext()) {
                    RichTextNode next = descendingIterator.next();
                    int max = Math.max(length - next.getText().length(), lineStart);
                    if (length > lineEnd) {
                        int lineForOffset = this.c.getLineForOffset(length);
                        int lineForOffset2 = this.c.getLineForOffset(length - next.getText().length());
                        if (lineForOffset > this.I - 1 && descendingIterator.hasNext() && lineForOffset2 > this.I - 1) {
                            length -= next.getText().length();
                        } else if (!(next instanceof C6414a)) {
                            i3 = lineEnd;
                        }
                    } else {
                        i3 = length;
                    }
                    if (max < lineStart) {
                        break;
                    } else if (next instanceof C6424b) {
                        c6424b = (C6424b) next;
                        textPaint.setTextSize(c6424b.H() == 0 ? this.t : c6424b.H());
                        int i6 = i3 - 1;
                        boolean z2 = charSequence.charAt(i6) == ' ';
                        while (true) {
                            if (i6 < max) {
                                i2 = lineStart;
                                break;
                            }
                            i2 = lineStart;
                            if (charSequence.charAt(i6) != ' ' || !z2) {
                                break;
                            }
                            i6--;
                            lineStart = i2;
                        }
                        int i7 = i6 + 1;
                        int i8 = i7 - 1;
                        float f = min;
                        while (true) {
                            if (i8 < max) {
                                z = false;
                                break;
                            }
                            f = min - textPaint.measureText(charSequence, i8, i7);
                            if (f < width) {
                                if (!r(charSequence.charAt(i8)) && i8 - 1 >= max && s(charSequence.subSequence(i4, i8 + 1).toString())) {
                                    i8--;
                                }
                                i5 = i8;
                                z = true;
                            } else {
                                i8--;
                            }
                        }
                        if (z) {
                            break;
                        }
                        min = f;
                        length -= next.getText().length();
                        lineStart = i2;
                    } else {
                        i2 = lineStart;
                        if (next instanceof C6414a) {
                            C6414a c6414a = (C6414a) next;
                            min -= c6414a.r();
                            if (min < width) {
                                i5 = i3 - c6414a.getText().length();
                                break;
                            }
                        }
                        length -= next.getText().length();
                        lineStart = i2;
                    }
                }
                i2 = lineStart;
                int i9 = i5 == 0 ? i2 : i5;
                CharSequence charSequence3 = this.P;
                if (!(charSequence3 instanceof Spannable) && c6424b != null && c6424b.G() != null) {
                    SpannableString spannableString = new SpannableString(charSequence3);
                    spannableString.setSpan(new ForegroundColorSpan(c6424b.G().intValue()), 0, charSequence3.length(), 33);
                    charSequence3 = spannableString;
                }
                return TextUtils.concat(charSequence.subSequence(0, i9), charSequence3);
            }
            i = 0;
            try {
                return charSequence.subSequence(0, lineEnd);
            } catch (Exception e) {
                e = e;
                CharSequence subSequence = charSequence.subSequence(i, lineEnd);
                e.printStackTrace();
                return subSequence;
            }
        } catch (Exception e2) {
            e = e2;
            i = 0;
        }
    }

    private float c(int i, int i2) {
        Layout layout = this.c;
        int height = layout != null ? layout.getHeight() : 0;
        int i3 = ((i - this.o) - this.p) - (this.z * 2);
        if (height <= 0 || i3 <= 0 || height >= i3 || i2 != 1073741824) {
            return 0.0f;
        }
        return (i3 - height) >> 1;
    }

    private TextUtils.TruncateAt g(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return null;
                }
                return TextUtils.TruncateAt.END;
            }
            return TextUtils.TruncateAt.MIDDLE;
        }
        return TextUtils.TruncateAt.START;
    }

    private Typeface o() {
        if (this.x != null) {
            return Typeface.createFromAsset(f().getAssets(), this.x);
        }
        boolean z = this.v;
        if (z && this.w) {
            return Typeface.defaultFromStyle(3);
        }
        if (z) {
            return Typeface.defaultFromStyle(1);
        }
        if (this.w) {
            return Typeface.defaultFromStyle(2);
        }
        return Typeface.defaultFromStyle(0);
    }

    private void p() {
        int i;
        RichText richText = this.b;
        if (richText != null) {
            CharSequence renderText = richText.renderText();
            if (!renderText.equals(this.s)) {
                this.s = renderText;
            }
        }
        if (this.s == null) {
            return;
        }
        if (this.g == null) {
            this.g = new TextPaint();
        }
        if (this.h == null) {
            this.h = new Paint();
        }
        this.g.setAntiAlias(true);
        int i2 = this.t;
        if (i2 >= 0) {
            this.g.setTextSize(i2);
        }
        this.g.setColor(this.u);
        this.g.setTypeface(o());
        this.i = g(this.J);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 17) {
            this.j = e(this.L);
        }
        TextPaint textPaint = this.g;
        textPaint.bgColor = this.y;
        float f = this.F;
        if (f != 0.0f && (i = this.E) != 0) {
            textPaint.setShadowLayer(f, this.C, this.D, i);
        }
        float f2 = this.O;
        if (f2 >= 0.0f && i3 >= 21) {
            this.g.setLetterSpacing(f2);
        }
        if (this.K > 0) {
            SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(this.s);
            valueOf.setSpan(new LeadingMarginSpan.Standard(this.K, 0), 0, valueOf.length(), 33);
            this.s = valueOf;
        }
        if (this.A == 1) {
            this.g.setUnderlineText(true);
        }
        if (this.B == 1) {
            this.g.setStrikeThruText(true);
        }
    }

    private boolean r(char c) {
        return c >= 9728 && c <= 10239;
    }

    private boolean s(String str) {
        return Pattern.compile("[🀀-🏿]|[🐀-\u1f7ff]").matcher(str).find();
    }

    private Layout t(int i, CharSequence charSequence, boolean z) {
        int i2 = i < 0 ? 0 : i;
        boolean z2 = this.q >= 0.0f;
        float f = this.t;
        float descent = this.g.descent() - this.g.ascent();
        boolean z3 = this.N >= descent;
        this.o = l();
        this.p = i();
        if (z) {
            if (z2 && !z3) {
                float f2 = this.q - (descent - f);
                this.Q = f2;
                this.Q = Math.max(f2, 0.0f);
                this.R = false;
            }
            if (z3) {
                float f3 = descent - f;
                float f4 = this.N;
                int i3 = (int) (((f4 - descent) + f3) / 2.0f);
                int max = Math.max((int) (((f4 - descent) - f3) / 2.0f), 0);
                int max2 = Math.max(i3, 0);
                this.o = l() + max;
                this.p = i() + max2;
                if (z2) {
                    this.Q = max + max2 + this.q;
                } else {
                    this.Q = max + max2;
                }
                this.R = false;
            }
        }
        return new StaticLayout(charSequence, this.g, i2, this.j, 1.0f, this.Q, this.R);
    }

    public void A(CharSequence charSequence) {
        this.P = charSequence;
        this.S = true;
    }

    public void B(int i) {
        this.K = i;
    }

    public void C(String str) {
        this.x = str;
    }

    public void D(boolean z) {
        this.v = z;
    }

    public void E(boolean z) {
        this.w = z;
    }

    public void F(int i) {
        this.r = i;
    }

    public void G(float f) {
        this.O = f;
        this.S = true;
    }

    public void H(int i) {
        this.J = i;
    }

    public void I(float f) {
        this.N = f;
    }

    public void J(float f) {
        this.q = f;
    }

    public void K(int i) {
        this.H = i;
        this.S = true;
    }

    public void L(int i) {
        this.I = i;
        this.S = true;
    }

    public void M(int i) {
        this.G = i;
        this.S = true;
    }

    public void N(int i) {
        this.n = i;
    }

    public void O(int i) {
        this.k = i;
        this.S = true;
    }

    public void P(int i) {
        this.l = i;
        this.S = true;
    }

    public void Q(int i) {
        this.m = i;
    }

    public void R(int i) {
        this.E = i;
    }

    public void S(float f) {
        this.C = f;
    }

    public void T(float f) {
        this.D = f;
    }

    public void U(float f) {
        this.F = f;
    }

    public void V(int i) {
    }

    public void W(int i) {
        this.B = i;
    }

    public void X(RichText richText) {
        this.s = null;
        this.b = richText;
    }

    public void Y(int i) {
        this.u = i;
    }

    public void Z(int i) {
        this.L = i;
    }

    public void a0(int i) {
        this.t = i;
    }

    public void b0(Integer num) {
    }

    public void c0(int i) {
        this.A = i;
    }

    public void d(Canvas canvas) {
        this.d = j();
        canvas.save();
        float f = this.d;
        int i = this.z;
        canvas.translate(f + i, this.e + this.o + i);
        Layout layout = this.c;
        if (layout != null) {
            layout.draw(canvas);
        }
        canvas.restore();
    }

    @RequiresApi(api = 17)
    protected Layout.Alignment e(int i) {
        if (h() == 1) {
            if (i != 1) {
                if (i != 2) {
                    return Layout.Alignment.ALIGN_OPPOSITE;
                }
                return Layout.Alignment.ALIGN_NORMAL;
            }
            return Layout.Alignment.ALIGN_CENTER;
        } else if (i != 1) {
            if (i != 2) {
                return Layout.Alignment.ALIGN_NORMAL;
            }
            return Layout.Alignment.ALIGN_OPPOSITE;
        } else {
            return Layout.Alignment.ALIGN_CENTER;
        }
    }

    public Context f() {
        return this.a;
    }

    public int h() {
        return this.r;
    }

    public int i() {
        return this.n;
    }

    public int j() {
        return this.k;
    }

    public int k() {
        return this.l;
    }

    public int l() {
        return this.m;
    }

    @Nullable
    public <T> T[] m(int i, int i2, Class<T> cls) {
        CharSequence charSequence;
        Layout layout;
        if (this.b == null) {
            return null;
        }
        if ((this.P instanceof Spannable) && (charSequence = this.f) != null && this.J == 3) {
            int length = charSequence.length() - this.P.length();
            int length2 = this.f.length();
            if (i >= length && i2 <= length2 && (layout = this.c) != null && this.T > layout.getLineCount()) {
                CharSequence charSequence2 = this.P;
                return (T[]) ((Spannable) charSequence2).getSpans(0, charSequence2.length(), cls);
            }
        }
        CharSequence renderText = this.b.renderText();
        if (renderText instanceof Spannable) {
            return (T[]) ((Spannable) renderText).getSpans(i, i2, cls);
        }
        return null;
    }

    public int n(float f, float f2) {
        int i = (int) f;
        int i2 = (int) f2;
        Layout layout = this.c;
        if (layout == null) {
            return -1;
        }
        int i3 = i - this.k;
        int lineForVertical = layout.getLineForVertical(i2 - this.o);
        int offsetForHorizontal = this.c.getOffsetForHorizontal(lineForVertical, i3);
        int i4 = this.c.getPrimaryHorizontal(offsetForHorizontal) < f ? offsetForHorizontal + 1 : offsetForHorizontal - 1;
        int lineStart = this.c.getLineStart(lineForVertical);
        int lineEnd = this.c.getLineEnd(lineForVertical);
        return i4 < lineStart ? lineStart : i4 > lineEnd ? lineEnd : i4;
    }

    public boolean q() {
        Layout layout;
        return (this.P.equals(DEFAULT_ELLIPSIS_TEXT) || (layout = this.c) == null || this.T <= layout.getLineCount()) ? false : true;
    }

    public C9594a u(int i, int i2) {
        int size;
        p();
        CharSequence charSequence = this.s;
        int i3 = 0;
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            size = View.MeasureSpec.getSize(i);
        } else {
            size = View.MeasureSpec.getSize(i);
            if (charSequence != null) {
                size = Math.min(Math.min(((int) Math.ceil(Layout.getDesiredWidth(charSequence, 0, charSequence.length(), this.g))) + j() + k() + (this.z * 2), size), this.G);
            }
        }
        if (size != 0 && !TextUtils.isEmpty(charSequence)) {
            int j = ((size - j()) - k()) - (this.z * 2);
            boolean z = (this.f == null || this.b.renderText().equals(charSequence)) ? false : true;
            Layout layout = this.c;
            if (layout != null) {
                if (layout.getWidth() <= j && !z && !this.S) {
                    if (this.c.getWidth() < j) {
                        this.c.increaseWidthTo(size);
                    }
                } else {
                    this.c = t(j, charSequence, true);
                    this.S = false;
                }
            } else {
                this.c = t(j, charSequence, true);
            }
            this.T = this.c.getLineCount();
            if (this.c.getLineCount() > this.I) {
                charSequence = SpannableStringBuilder.valueOf(b(charSequence));
                this.c = t(j, charSequence, false);
            } else {
                CharSequence charSequence2 = this.f;
                if (charSequence2 != null) {
                    charSequence = charSequence2;
                }
            }
        }
        if (this.c != null && charSequence != null) {
            int mode = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            if (mode == 1073741824) {
                i3 = size2;
            } else if (!TextUtils.isEmpty(charSequence)) {
                i3 = Math.min(Math.min(this.c.getHeight() + this.p + this.o + (this.z * 2), size2), this.H);
            }
            this.e = c(i3, mode);
            CharSequence a = a(charSequence, size);
            if (a != null) {
                charSequence = a;
            }
            this.f = charSequence;
            return new C9594a(size, i3);
        }
        return new C9594a(size, 0);
    }

    public void v(int i) {
        this.M = i;
    }

    public void w(int i) {
    }

    public void x(int i) {
        this.z = Math.max(i, 0);
    }

    public void y(Context context) {
        this.a = context;
    }

    public void z(int i) {
    }
}
