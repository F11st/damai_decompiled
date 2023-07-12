package tb;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.media.arch.instruments.statistics.ConfigReporter;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public final class ad1 extends Handler {
    private static transient /* synthetic */ IpChange $ipChange;
    private static ad1 b;
    private final Queue<dq> a = new LinkedBlockingQueue();

    /* compiled from: Taobao */
    /* renamed from: tb.ad1$a */
    /* loaded from: classes4.dex */
    public class ViewTreeObserver$OnGlobalLayoutListenerC8905a implements ViewTreeObserver.OnGlobalLayoutListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View a;
        final /* synthetic */ dq b;

        ViewTreeObserver$OnGlobalLayoutListenerC8905a(View view, dq dqVar) {
            this.a = view;
            this.b = dqVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @TargetApi(16)
        public void onGlobalLayout() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1636224369")) {
                ipChange.ipc$dispatch("1636224369", new Object[]{this});
                return;
            }
            if (Build.VERSION.SDK_INT < 16) {
                this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            } else {
                this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
            if (this.b.f() != null) {
                this.a.startAnimation(this.b.f());
                ad1.d(this.b.d(), this.b.j());
                if (-1 != this.b.e().a) {
                    ad1 ad1Var = ad1.this;
                    dq dqVar = this.b;
                    ad1Var.m(dqVar, -1040155167, dqVar.e().a + this.b.f().getDuration());
                }
            }
        }
    }

    private ad1() {
    }

    private void c(dq dqVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1877265846")) {
            ipChange.ipc$dispatch("-1877265846", new Object[]{this, dqVar});
        } else if (dqVar.u()) {
        } else {
            View k = dqVar.k();
            if (k.getParent() == null) {
                ViewGroup.LayoutParams layoutParams = k.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
                }
                if (dqVar.l() != null) {
                    ViewGroup l = dqVar.l();
                    if (o(l)) {
                        l.addView(k, layoutParams);
                    } else {
                        l.addView(k, 0, layoutParams);
                    }
                } else {
                    Activity d = dqVar.d();
                    if (d == null || d.isFinishing()) {
                        return;
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i(marginLayoutParams, d);
                    h(marginLayoutParams, d);
                    d.addContentView(k, layoutParams);
                }
            }
            k.requestLayout();
            ViewTreeObserver viewTreeObserver = k.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver$OnGlobalLayoutListenerC8905a(k, dqVar));
            }
        }
    }

    public static void d(Context context, CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1134862260")) {
            ipChange.ipc$dispatch("-1134862260", new Object[]{context, charSequence});
            return;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 4) {
            AccessibilityManager accessibilityManager = context != null ? (AccessibilityManager) context.getSystemService("accessibility") : null;
            if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
                return;
            }
            AccessibilityEvent obtain = AccessibilityEvent.obtain(i < 16 ? 8 : 16384);
            obtain.getText().add(charSequence);
            obtain.setClassName(ad1.class.getName());
            obtain.setPackageName(context.getPackageName());
            accessibilityManager.sendAccessibilityEvent(obtain);
        }
    }

    private long e(dq dqVar) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1989716243") ? ((Long) ipChange.ipc$dispatch("-1989716243", new Object[]{this, dqVar})).longValue() : dqVar.e().a + dqVar.f().getDuration() + dqVar.h().getDuration();
    }

    private void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "858071508")) {
            ipChange.ipc$dispatch("858071508", new Object[]{this});
        } else if (this.a.isEmpty()) {
        } else {
            dq peek = this.a.peek();
            if (peek.d() == null) {
                this.a.poll();
            }
            if (!peek.u()) {
                l(peek, -1040157475);
                if (peek.g() != null) {
                    peek.g().onDisplayed();
                    return;
                }
                return;
            }
            m(peek, 794631, e(peek));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized ad1 g() {
        synchronized (ad1.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-692148659")) {
                return (ad1) ipChange.ipc$dispatch("-692148659", new Object[0]);
            }
            if (b == null) {
                b = new ad1();
            }
            return b;
        }
    }

    @TargetApi(11)
    private void h(ViewGroup.MarginLayoutParams marginLayoutParams, Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1219085332")) {
            ipChange.ipc$dispatch("-1219085332", new Object[]{this, marginLayoutParams, activity});
        } else if (Build.VERSION.SDK_INT < 11 || !activity.getWindow().hasFeature(9)) {
        } else {
            n(marginLayoutParams, activity);
        }
    }

    @TargetApi(19)
    private void i(ViewGroup.MarginLayoutParams marginLayoutParams, Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-150292483")) {
            ipChange.ipc$dispatch("-150292483", new Object[]{this, marginLayoutParams, activity});
        } else if (Build.VERSION.SDK_INT < 19 || (activity.getWindow().getAttributes().flags & ConfigReporter.BIT_GETTER_IMP) != 67108864) {
        } else {
            n(marginLayoutParams, activity);
        }
    }

    private void j(dq dqVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "487389089")) {
            ipChange.ipc$dispatch("487389089", new Object[]{this, dqVar});
            return;
        }
        removeMessages(-1040157475, dqVar);
        removeMessages(794631, dqVar);
        removeMessages(-1040155167, dqVar);
    }

    private void l(dq dqVar, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1685966815")) {
            ipChange.ipc$dispatch("-1685966815", new Object[]{this, dqVar, Integer.valueOf(i)});
            return;
        }
        Message obtainMessage = obtainMessage(i);
        obtainMessage.obj = dqVar;
        sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(dq dqVar, int i, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1528206929")) {
            ipChange.ipc$dispatch("1528206929", new Object[]{this, dqVar, Integer.valueOf(i), Long.valueOf(j)});
            return;
        }
        Message obtainMessage = obtainMessage(i);
        obtainMessage.obj = dqVar;
        sendMessageDelayed(obtainMessage, j);
    }

    private void n(ViewGroup.MarginLayoutParams marginLayoutParams, Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-850884902")) {
            ipChange.ipc$dispatch("-850884902", new Object[]{this, marginLayoutParams, activity});
            return;
        }
        View findViewById = activity.findViewById(Resources.getSystem().getIdentifier("action_bar_container", "id", "android"));
        if (findViewById != null) {
            marginLayoutParams.topMargin = findViewById.getBottom();
        }
    }

    private boolean o(ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "72805685") ? ((Boolean) ipChange.ipc$dispatch("72805685", new Object[]{this, viewGroup})).booleanValue() : (viewGroup instanceof FrameLayout) || (viewGroup instanceof AdapterView) || (viewGroup instanceof RelativeLayout);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(dq dqVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2052640156")) {
            ipChange.ipc$dispatch("-2052640156", new Object[]{this, dqVar});
            return;
        }
        this.a.add(dqVar);
        f();
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1073345902")) {
            ipChange.ipc$dispatch("1073345902", new Object[]{this, message});
            return;
        }
        dq dqVar = (dq) message.obj;
        if (dqVar == null) {
            return;
        }
        int i = message.what;
        if (i == -1040157475) {
            c(dqVar);
        } else if (i != -1040155167) {
            if (i != 794631) {
                super.handleMessage(message);
            } else {
                f();
            }
        } else {
            k(dqVar);
            if (dqVar.g() != null) {
                dqVar.g().onRemoved();
            }
        }
    }

    protected void k(dq dqVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1445257469")) {
            ipChange.ipc$dispatch("1445257469", new Object[]{this, dqVar});
            return;
        }
        j(dqVar);
        View k = dqVar.k();
        ViewGroup viewGroup = (ViewGroup) k.getParent();
        if (viewGroup != null) {
            k.startAnimation(dqVar.h());
            dq poll = this.a.poll();
            viewGroup.removeView(k);
            if (poll != null) {
                poll.a();
                poll.c();
                if (poll.g() != null) {
                    poll.g().onRemoved();
                }
                poll.b();
            }
            m(dqVar, 794631, dqVar.h().getDuration());
        }
    }

    @Override // android.os.Handler
    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-898575364")) {
            return (String) ipChange.ipc$dispatch("-898575364", new Object[]{this});
        }
        return "Manager{croutonQueue=" + this.a + '}';
    }
}
