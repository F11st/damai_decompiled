package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.autofittext;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.Editable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.SingleLineTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import cn.damai.trade.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class AutoFitHelper {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView a;
    private TextPaint b;
    private float c;
    private int d;
    private float e;
    private float f;
    private float g;
    private boolean h;
    private boolean i;
    private ArrayList<OnTextSizeChangeListener> j;
    private TextWatcher k = new C2373c();
    private View.OnLayoutChangeListener l = new View$OnLayoutChangeListenerC2372b();

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface OnTextSizeChangeListener {
        void onTextSizeChange(float f, float f2);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.autofittext.AutoFitHelper$b */
    /* loaded from: classes16.dex */
    public class View$OnLayoutChangeListenerC2372b implements View.OnLayoutChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        private View$OnLayoutChangeListenerC2372b() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1540421399")) {
                ipChange.ipc$dispatch("-1540421399", new Object[]{this, view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)});
            } else {
                AutoFitHelper.this.c();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.autofittext.AutoFitHelper$c */
    /* loaded from: classes16.dex */
    public class C2373c implements TextWatcher {
        private static transient /* synthetic */ IpChange $ipChange;

        private C2373c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "84324666")) {
                ipChange.ipc$dispatch("84324666", new Object[]{this, editable});
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2018426697")) {
                ipChange.ipc$dispatch("2018426697", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-645562263")) {
                ipChange.ipc$dispatch("-645562263", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            } else {
                AutoFitHelper.this.c();
            }
        }
    }

    private AutoFitHelper(TextView textView) {
        float f = textView.getContext().getResources().getDisplayMetrics().scaledDensity;
        this.a = textView;
        this.b = new TextPaint();
        w(textView.getTextSize());
        this.d = i(textView);
        this.e = f * 8.0f;
        this.f = this.c;
        this.g = 0.5f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1876203057")) {
            ipChange.ipc$dispatch("1876203057", new Object[]{this});
            return;
        }
        float textSize = this.a.getTextSize();
        this.i = true;
        d(this.a, this.b, this.e, this.f, this.d, this.g);
        this.i = false;
        float textSize2 = this.a.getTextSize();
        if (textSize2 != textSize) {
            n(textSize2, textSize);
        }
    }

    private static void d(TextView textView, TextPaint textPaint, float f, float f2, int i, float f3) {
        int width;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1992291632")) {
            ipChange.ipc$dispatch("-1992291632", new Object[]{textView, textPaint, Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Float.valueOf(f3)});
        } else if (i <= 0 || i == Integer.MAX_VALUE || (width = (textView.getWidth() - textView.getPaddingLeft()) - textView.getPaddingRight()) <= 0) {
        } else {
            CharSequence text = textView.getText();
            TransformationMethod transformationMethod = textView.getTransformationMethod();
            if (transformationMethod != null) {
                text = transformationMethod.getTransformation(text, textView);
            }
            Context context = textView.getContext();
            Resources system = Resources.getSystem();
            if (context != null) {
                system = context.getResources();
            }
            DisplayMetrics displayMetrics = system.getDisplayMetrics();
            textPaint.set(textView.getPaint());
            textPaint.setTextSize(f2);
            float g = ((i != 1 || textPaint.measureText(text, 0, text.length()) <= ((float) width)) && h(text, textPaint, f2, (float) width, displayMetrics) <= i) ? f2 : g(text, textPaint, width, i, 0.0f, f2, f3, displayMetrics);
            if (g < f) {
                g = f;
            }
            textView.setTextSize(0, g);
        }
    }

    public static AutoFitHelper e(TextView textView) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1884247200") ? (AutoFitHelper) ipChange.ipc$dispatch("-1884247200", new Object[]{textView}) : f(textView, null, 0);
    }

    public static AutoFitHelper f(TextView textView, AttributeSet attributeSet, int i) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-119745707")) {
            return (AutoFitHelper) ipChange.ipc$dispatch("-119745707", new Object[]{textView, attributeSet, Integer.valueOf(i)});
        }
        AutoFitHelper autoFitHelper = new AutoFitHelper(textView);
        if (attributeSet != null) {
            Context context = textView.getContext();
            float l = autoFitHelper.l();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.AutoFitTextView, i, 0);
            z = obtainStyledAttributes.getBoolean(R$styleable.AutoFitTextView_sizeToFit, true);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.AutoFitTextView_minTextSize, (int) autoFitHelper.k());
            float f = obtainStyledAttributes.getFloat(R$styleable.AutoFitTextView_precision, l);
            obtainStyledAttributes.recycle();
            autoFitHelper.s(0, dimensionPixelSize).t(f);
        }
        autoFitHelper.o(z);
        return autoFitHelper;
    }

    private static float g(CharSequence charSequence, TextPaint textPaint, float f, int i, float f2, float f3, float f4, DisplayMetrics displayMetrics) {
        StaticLayout staticLayout;
        int i2;
        float f5;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-990201785")) {
            return ((Float) ipChange.ipc$dispatch("-990201785", new Object[]{charSequence, textPaint, Float.valueOf(f), Integer.valueOf(i), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), displayMetrics})).floatValue();
        }
        float f6 = (f2 + f3) / 2.0f;
        textPaint.setTextSize(TypedValue.applyDimension(0, f6, displayMetrics));
        if (i != 1) {
            StaticLayout staticLayout2 = new StaticLayout(charSequence, textPaint, (int) f, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            i2 = staticLayout2.getLineCount();
            staticLayout = staticLayout2;
        } else {
            staticLayout = null;
            i2 = 1;
        }
        if (i2 > i) {
            return f3 - f2 < f4 ? f2 : g(charSequence, textPaint, f, i, f2, f6, f4, displayMetrics);
        } else if (i2 < i) {
            return g(charSequence, textPaint, f, i, f6, f3, f4, displayMetrics);
        } else {
            float f7 = 0.0f;
            if (i == 1) {
                f5 = textPaint.measureText(charSequence, 0, charSequence.length());
            } else {
                for (int i3 = 0; i3 < i2; i3++) {
                    if (staticLayout.getLineWidth(i3) > f7) {
                        f7 = staticLayout.getLineWidth(i3);
                    }
                }
                f5 = f7;
            }
            if (f3 - f2 < f4) {
                return f2;
            }
            if (f5 > f) {
                return g(charSequence, textPaint, f, i, f2, f6, f4, displayMetrics);
            }
            return f5 < f ? g(charSequence, textPaint, f, i, f6, f3, f4, displayMetrics) : f6;
        }
    }

    private static int h(CharSequence charSequence, TextPaint textPaint, float f, float f2, DisplayMetrics displayMetrics) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-742977552")) {
            return ((Integer) ipChange.ipc$dispatch("-742977552", new Object[]{charSequence, textPaint, Float.valueOf(f), Float.valueOf(f2), displayMetrics})).intValue();
        }
        textPaint.setTextSize(TypedValue.applyDimension(0, f, displayMetrics));
        return new StaticLayout(charSequence, textPaint, (int) f2, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true).getLineCount();
    }

    private static int i(TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1125053717")) {
            return ((Integer) ipChange.ipc$dispatch("1125053717", new Object[]{textView})).intValue();
        }
        TransformationMethod transformationMethod = textView.getTransformationMethod();
        if (transformationMethod == null || !(transformationMethod instanceof SingleLineTransformationMethod)) {
            if (Build.VERSION.SDK_INT >= 16) {
                return textView.getMaxLines();
            }
            return -1;
        }
        return 1;
    }

    private void n(float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1942389007")) {
            ipChange.ipc$dispatch("-1942389007", new Object[]{this, Float.valueOf(f), Float.valueOf(f2)});
            return;
        }
        ArrayList<OnTextSizeChangeListener> arrayList = this.j;
        if (arrayList == null) {
            return;
        }
        Iterator<OnTextSizeChangeListener> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().onTextSizeChange(f, f2);
        }
    }

    private void u(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1698969657")) {
            ipChange.ipc$dispatch("1698969657", new Object[]{this, Float.valueOf(f)});
        } else if (f != this.f) {
            this.f = f;
            c();
        }
    }

    private void v(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "588530727")) {
            ipChange.ipc$dispatch("588530727", new Object[]{this, Float.valueOf(f)});
        } else if (f != this.e) {
            this.e = f;
            c();
        }
    }

    private void w(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1898927555")) {
            ipChange.ipc$dispatch("-1898927555", new Object[]{this, Float.valueOf(f)});
        } else if (this.c != f) {
            this.c = f;
        }
    }

    public AutoFitHelper b(OnTextSizeChangeListener onTextSizeChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1023863796")) {
            return (AutoFitHelper) ipChange.ipc$dispatch("-1023863796", new Object[]{this, onTextSizeChangeListener});
        }
        if (this.j == null) {
            this.j = new ArrayList<>();
        }
        this.j.add(onTextSizeChangeListener);
        return this;
    }

    public float j() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1451931893") ? ((Float) ipChange.ipc$dispatch("-1451931893", new Object[]{this})).floatValue() : this.f;
    }

    public float k() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-795015843") ? ((Float) ipChange.ipc$dispatch("-795015843", new Object[]{this})).floatValue() : this.e;
    }

    public float l() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-797499041") ? ((Float) ipChange.ipc$dispatch("-797499041", new Object[]{this})).floatValue() : this.g;
    }

    public boolean m() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-282533920") ? ((Boolean) ipChange.ipc$dispatch("-282533920", new Object[]{this})).booleanValue() : this.h;
    }

    public AutoFitHelper o(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "76424499")) {
            return (AutoFitHelper) ipChange.ipc$dispatch("76424499", new Object[]{this, Boolean.valueOf(z)});
        }
        if (this.h != z) {
            this.h = z;
            if (z) {
                this.a.addTextChangedListener(this.k);
                this.a.addOnLayoutChangeListener(this.l);
                c();
            } else {
                this.a.removeTextChangedListener(this.k);
                this.a.removeOnLayoutChangeListener(this.l);
                this.a.setTextSize(0, this.c);
            }
        }
        return this;
    }

    public AutoFitHelper p(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "139072996")) {
            return (AutoFitHelper) ipChange.ipc$dispatch("139072996", new Object[]{this, Integer.valueOf(i)});
        }
        if (this.d != i) {
            this.d = i;
            c();
        }
        return this;
    }

    public AutoFitHelper q(float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "17987952") ? (AutoFitHelper) ipChange.ipc$dispatch("17987952", new Object[]{this, Float.valueOf(f)}) : r(2, f);
    }

    public AutoFitHelper r(int i, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2101553221")) {
            return (AutoFitHelper) ipChange.ipc$dispatch("-2101553221", new Object[]{this, Integer.valueOf(i), Float.valueOf(f)});
        }
        Context context = this.a.getContext();
        Resources system = Resources.getSystem();
        if (context != null) {
            system = context.getResources();
        }
        u(TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
        return this;
    }

    public AutoFitHelper s(int i, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1844722419")) {
            return (AutoFitHelper) ipChange.ipc$dispatch("-1844722419", new Object[]{this, Integer.valueOf(i), Float.valueOf(f)});
        }
        Context context = this.a.getContext();
        Resources system = Resources.getSystem();
        if (context != null) {
            system = context.getResources();
        }
        v(TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
        return this;
    }

    public AutoFitHelper t(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-413791332")) {
            return (AutoFitHelper) ipChange.ipc$dispatch("-413791332", new Object[]{this, Float.valueOf(f)});
        }
        if (this.g != f) {
            this.g = f;
            c();
        }
        return this;
    }

    public void x(int i, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "249894784")) {
            ipChange.ipc$dispatch("249894784", new Object[]{this, Integer.valueOf(i), Float.valueOf(f)});
        } else if (this.i) {
        } else {
            Context context = this.a.getContext();
            Resources system = Resources.getSystem();
            if (context != null) {
                system = context.getResources();
            }
            w(TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
        }
    }
}
