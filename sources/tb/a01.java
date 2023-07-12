package tb;

import android.content.Context;
import android.text.Spanned;
import android.util.Log;
import android.widget.TextView;
import com.alibaba.pictures.bricks.util.htmlparser.DefaultImageGetter;
import com.alibaba.pictures.bricks.util.htmlparser.HtmlParserManager;
import com.alibaba.pictures.bricks.util.htmlparser.callback.ImageGetter;
import com.alibaba.pictures.bricks.util.htmlparser.callback.ViewChangeNotify;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.lang.ref.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.o32;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class a01 implements ViewChangeNotify {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final float LINE_HEIGHT = 1.4f;
    public static final int TEXT_COLOR = -13421773;
    public static final int URL_COLOR = -12552000;
    @NotNull
    private final String a;
    @Nullable
    private ImageGetter b;
    private boolean c;
    @Nullable
    private Spanned d;
    @Nullable
    private WeakReference<TextView> e;
    @NotNull
    private final Runnable f;
    @NotNull
    public static final a Companion = new a(null);
    private static final String g = a01.class.getSimpleName();
    private static float h = 40.0f;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        public final float a() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-81218082") ? ((Float) ipChange.ipc$dispatch("-81218082", new Object[]{this})).floatValue() : a01.h;
        }

        @NotNull
        public final a01 b(@NotNull String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1824174924")) {
                return (a01) ipChange.ipc$dispatch("1824174924", new Object[]{this, str});
            }
            b41.i(str, "source");
            return new a01(str, null);
        }
    }

    private a01(String str) {
        this.a = str;
        this.f = new Runnable() { // from class: tb.zz0
            @Override // java.lang.Runnable
            public final void run() {
                a01.d(a01.this);
            }
        };
    }

    public /* synthetic */ a01(String str, k50 k50Var) {
        this(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(a01 a01Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-915406958")) {
            ipChange.ipc$dispatch("-915406958", new Object[]{a01Var});
            return;
        }
        b41.i(a01Var, "this$0");
        WeakReference<TextView> weakReference = a01Var.e;
        b41.f(weakReference);
        TextView textView = weakReference.get();
        b41.f(textView);
        textView.setText(a01Var.d);
        Log.d(g, "notifyViewChange postInvalidateDelayed");
    }

    public final void c(@NotNull Context context, @Nullable HtmlParserManager.OnSpanClickListener onSpanClickListener, @Nullable HtmlParserManager.OnParseFinishedListener onParseFinishedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1601056639")) {
            ipChange.ipc$dispatch("1601056639", new Object[]{this, context, onSpanClickListener, onParseFinishedListener});
            return;
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        if (this.b == null) {
            this.b = new DefaultImageGetter("", tm.Companion.a().c(), context);
        }
        o32.a aVar = o32.Companion;
        String str = this.a;
        ImageGetter imageGetter = this.b;
        b41.f(imageGetter);
        aVar.a(str, imageGetter, new h50(onSpanClickListener), onParseFinishedListener);
    }

    @Override // com.alibaba.pictures.bricks.util.htmlparser.callback.ViewChangeNotify
    public void notifyViewChange() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-296009149")) {
            ipChange.ipc$dispatch("-296009149", new Object[]{this});
            return;
        }
        WeakReference<TextView> weakReference = this.e;
        if (weakReference == null) {
            return;
        }
        b41.f(weakReference);
        TextView textView = weakReference.get();
        if (!this.c || textView == null || this.d == null) {
            return;
        }
        textView.removeCallbacks(this.f);
        textView.postDelayed(this.f, 200L);
    }
}
