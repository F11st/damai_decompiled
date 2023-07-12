package com.alibaba.poplayerconsole.lib;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.alibaba.poplayerconsole.R$anim;
import com.alibaba.poplayerconsole.R$id;
import com.alibaba.poplayerconsole.R$layout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import tb.ep2;
import tb.hw2;
import tb.r10;
import tb.rf2;
import tb.s13;
import tb.v;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class StandOutWindow extends Service {
    public static final String ACTION_CLOSE = "CLOSE";
    public static final String ACTION_CLOSE_ALL = "CLOSE_ALL";
    public static final String ACTION_HIDE = "HIDE";
    public static final String ACTION_RESTORE = "RESTORE";
    public static final String ACTION_SEND_DATA = "SEND_DATA";
    public static final String ACTION_SHOW = "SHOW";
    public static final int DEFAULT_ID = 0;
    public static final int DISREGARD_ID = -2;
    public static final int ONGOING_NOTIFICATION_ID = -1;
    static s13 h = new s13();
    static Window i = null;
    public String a = "";
    public int b = 0;
    public int c = 0;
    WindowManager d;
    private NotificationManager e;
    LayoutInflater f;
    private boolean g;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    class a implements View.OnClickListener {
        final /* synthetic */ d a;
        final /* synthetic */ PopupWindow b;

        a(StandOutWindow standOutWindow, d dVar, PopupWindow popupWindow) {
            this.a = dVar;
            this.b = popupWindow;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.b.run();
            this.b.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class b implements Animation.AnimationListener {
        final /* synthetic */ Window a;

        b(Window window) {
            this.a = window;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            StandOutWindow.this.d.removeView(this.a);
            this.a.visibility = 0;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class c implements Animation.AnimationListener {
        final /* synthetic */ Window a;
        final /* synthetic */ int b;

        c(Window window, int i) {
            this.a = window;
            this.b = i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            StandOutWindow.this.d.removeView(this.a);
            this.a.visibility = 0;
            StandOutWindow.h.f(this.b, StandOutWindow.this.getClass());
            if (StandOutWindow.this.k().size() == 0) {
                StandOutWindow.this.g = false;
                StandOutWindow.this.stopForeground(true);
                StandOutWindow.this.stopSelf();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    protected class d {
        public String a;
        public Runnable b;

        public d(StandOutWindow standOutWindow, int i, String str, Runnable runnable) {
            this.a = str;
            this.b = runnable;
        }

        public String toString() {
            return this.a;
        }
    }

    public static void B(Context context, Class<? extends StandOutWindow> cls, int i2, int i3, Bundle bundle, Class<? extends StandOutWindow> cls2, int i4) {
        context.startService(p(context, cls, i2, i3, bundle, cls2, i4));
    }

    public static void E(Context context, Class<? extends StandOutWindow> cls, int i2) {
        context.startService(q(context, cls, i2));
    }

    public static void e(Context context, Class<? extends StandOutWindow> cls) {
        context.startService(h(context, cls));
    }

    public static Intent h(Context context, Class<? extends StandOutWindow> cls) {
        return new Intent(context, cls).setAction(ACTION_CLOSE_ALL);
    }

    public static Intent p(Context context, Class<? extends StandOutWindow> cls, int i2, int i3, Bundle bundle, Class<? extends StandOutWindow> cls2, int i4) {
        return new Intent(context, cls).putExtra("id", i2).putExtra("requestCode", i3).putExtra("wei.mark.standout.data", bundle).putExtra("wei.mark.standout.fromCls", cls2).putExtra("fromId", i4).setAction(ACTION_SEND_DATA);
    }

    public static Intent q(Context context, Class<? extends StandOutWindow> cls, int i2) {
        Uri uri;
        boolean d2 = h.d(i2, cls);
        String str = d2 ? ACTION_RESTORE : ACTION_SHOW;
        if (d2) {
            uri = Uri.parse("standout://" + cls + r10.DIR + i2);
        } else {
            uri = null;
        }
        return new Intent(context, cls).putExtra("id", i2).setAction(str).setData(uri);
    }

    public boolean A(int i2, Window window, View view, MotionEvent motionEvent) {
        StandOutLayoutParams layoutParams = window.getLayoutParams();
        int action = motionEvent.getAction();
        if (action == 0) {
            window.touchInfo.c = (int) motionEvent.getRawX();
            window.touchInfo.d = (int) motionEvent.getRawY();
            ep2 ep2Var = window.touchInfo;
            ep2Var.a = ep2Var.c;
            ep2Var.b = ep2Var.d;
            return true;
        } else if (action != 2) {
            return true;
        } else {
            int rawX = ((int) motionEvent.getRawX()) - window.touchInfo.c;
            ep2 ep2Var2 = window.touchInfo;
            int rawY = ((int) motionEvent.getRawY()) - ep2Var2.d;
            int i3 = ((WindowManager.LayoutParams) layoutParams).width + rawX;
            ((WindowManager.LayoutParams) layoutParams).width = i3;
            ((WindowManager.LayoutParams) layoutParams).height += rawY;
            if (i3 >= layoutParams.minWidth && i3 <= layoutParams.maxWidth) {
                ep2Var2.c = (int) motionEvent.getRawX();
            }
            int i4 = ((WindowManager.LayoutParams) layoutParams).height;
            if (i4 >= layoutParams.minHeight && i4 <= layoutParams.maxHeight) {
                window.touchInfo.d = (int) motionEvent.getRawY();
            }
            window.edit().f(((WindowManager.LayoutParams) layoutParams).width, ((WindowManager.LayoutParams) layoutParams).height).a();
            return true;
        }
    }

    public final void C(Window window) {
        i = window;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized Window D(int i2) {
        Window r = r(i2);
        if (r == null) {
            r = new Window(this, i2);
        }
        if (y(i2, r)) {
            Log.d("StandOutWindow", "Window " + i2 + " show cancelled by implementation.");
            return null;
        } else if (r.visibility == 1) {
            Log.d("StandOutWindow", "Window " + i2 + " is already shown.");
            g(i2);
            return r;
        } else {
            r.visibility = 1;
            Animation loadAnimation = t(i2) ? AnimationUtils.loadAnimation(this, R$anim.console_show) : AnimationUtils.loadAnimation(this, 17432576);
            try {
                this.d.addView(r, r.getLayoutParams());
                if (loadAnimation != null) {
                    r.getChildAt(0).startAnimation(loadAnimation);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            h.e(i2, getClass(), r);
            Notification o = o(i2);
            if (o != null) {
                o.flags |= 32;
                if (!this.g) {
                    startForeground(getClass().hashCode() - 1, o);
                    this.g = true;
                } else {
                    this.e.notify(getClass().hashCode() - 1, o);
                }
            } else if (!this.g) {
                throw new RuntimeException("Your StandOutWindow service mustprovide a persistent notification.The notification prevents Androidfrom killing your service in lowmemory situations.");
            }
            g(i2);
            return r;
        }
    }

    public synchronized boolean F(Window window) {
        if (window != null) {
        } else {
            throw new IllegalArgumentException("Tried to unfocus a null window.");
        }
        return window.onFocus(false);
    }

    public void G(int i2, StandOutLayoutParams standOutLayoutParams) {
        Window r = r(i2);
        if (r != null) {
            int i3 = r.visibility;
            if (i3 == 0 || i3 == 2) {
                return;
            }
            try {
                r.setLayoutParams(standOutLayoutParams);
                this.d.updateViewLayout(r, standOutLayoutParams);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        throw new IllegalArgumentException("Tried to updateViewLayout(" + i2 + ") a null window.");
    }

    public final synchronized void b(int i2) {
        Window r = r(i2);
        if (r != null) {
            int i3 = r.visibility;
            if (i3 == 0) {
                throw new IllegalStateException("Tried to bringToFront(" + i2 + ") a window that is not shown.");
            } else if (i3 == 2) {
                return;
            } else {
                StandOutLayoutParams layoutParams = r.getLayoutParams();
                try {
                    this.d.removeView(r);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    this.d.addView(r, layoutParams);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return;
            }
        }
        throw new IllegalArgumentException("Tried to bringToFront(" + i2 + ") a null window.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized void c(int i2) {
        Window r = r(i2);
        if (r != null) {
            if (r.visibility == 2) {
                return;
            }
            if (u(i2, r)) {
                Log.w("StandOutWindow", "Window " + i2 + " close cancelled by implementation.");
                return;
            }
            this.e.cancel(getClass().hashCode() + i2);
            F(r);
            r.visibility = 2;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, 17432577);
            try {
                if (loadAnimation != null) {
                    loadAnimation.setAnimationListener(new c(r, i2));
                    r.getChildAt(0).startAnimation(loadAnimation);
                } else {
                    this.d.removeView(r);
                    h.f(i2, getClass());
                    if (h.c(getClass()) == 0) {
                        this.g = false;
                        stopForeground(true);
                        stopSelf();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return;
        }
        throw new IllegalArgumentException("Tried to close(" + i2 + ") a null window.");
    }

    public final synchronized void d() {
        if (v()) {
            Log.w("StandOutWindow", "Windows close all cancelled by implementation.");
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (Integer num : k()) {
            linkedList.add(Integer.valueOf(num.intValue()));
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            c(((Integer) it.next()).intValue());
        }
    }

    public abstract void f(int i2, FrameLayout frameLayout);

    public final synchronized boolean g(int i2) {
        Window r = r(i2);
        if (r != null) {
            if (hw2.a(r.flags, rf2.FLAG_WINDOW_FOCUSABLE_DISABLE)) {
                return false;
            }
            Window window = i;
            if (window != null) {
                F(window);
            }
            return r.onFocus(true);
        }
        throw new IllegalArgumentException("Tried to focus(" + i2 + ") a null window.");
    }

    @SuppressLint({"InflateParams"})
    public PopupWindow i(int i2) {
        List<d> j = j(i2);
        if (j == null) {
            j = new ArrayList<>();
        }
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        PopupWindow popupWindow = new PopupWindow((View) linearLayout, -2, -2, true);
        for (d dVar : j) {
            ViewGroup viewGroup = (ViewGroup) this.f.inflate(R$layout.console_drop_down_item, (ViewGroup) null);
            linearLayout.addView(viewGroup);
            ((TextView) viewGroup.findViewById(R$id.description)).setText(dVar.a);
            viewGroup.setOnClickListener(new a(this, dVar, popupWindow));
        }
        popupWindow.setBackgroundDrawable(getResources().getDrawable(17301530));
        return popupWindow;
    }

    public List<d> j(int i2) {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Set<Integer> k() {
        return h.b(getClass());
    }

    public final Window l() {
        return i;
    }

    @TargetApi(21)
    public Notification m(int i2) {
        int i3 = this.b;
        long currentTimeMillis = System.currentTimeMillis();
        Context applicationContext = getApplicationContext();
        String str = this.a + " Hidden";
        String format = String.format("%s: %s", str, "");
        Intent q = q(this, getClass(), i2);
        return new Notification.Builder(applicationContext).setContentTitle(str).setContentText("").setContentIntent(q != null ? PendingIntent.getService(this, 0, q, 134217728) : null).setSmallIcon(i3).setTicker(format).setWhen(currentTimeMillis).build();
    }

    public abstract StandOutLayoutParams n(int i2, Window window);

    @TargetApi(21)
    public Notification o(int i2) {
        int i3 = this.b;
        String str = this.a + " Running";
        return new Notification.Builder(getApplicationContext()).setContentTitle(str).setContentText("").setContentIntent(null).setSmallIcon(i3).setTicker(String.format("%s: %s", str, "")).setWhen(System.currentTimeMillis()).build();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.d = (WindowManager) getSystemService(v.ATTACH_MODE_WINDOW);
        this.e = (NotificationManager) getSystemService("notification");
        this.f = (LayoutInflater) getSystemService("layout_inflater");
        this.g = false;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        d();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        super.onStartCommand(intent, i2, i3);
        if (intent != null) {
            String action = intent.getAction();
            int intExtra = intent.getIntExtra("id", 0);
            if (intExtra != -1) {
                if (!ACTION_SHOW.equals(action) && !ACTION_RESTORE.equals(action)) {
                    if (ACTION_HIDE.equals(action)) {
                        s(intExtra);
                        return 2;
                    } else if (ACTION_CLOSE.equals(action)) {
                        c(intExtra);
                        return 2;
                    } else if (ACTION_CLOSE_ALL.equals(action)) {
                        d();
                        return 2;
                    } else if (ACTION_SEND_DATA.equals(action)) {
                        if (!t(intExtra) && intExtra != -2) {
                            Log.w("StandOutWindow", "Sending data to non-existant window. If this is not intended, make sure toId is either an existing window's id or DISREGARD_ID.");
                        }
                        x(intExtra, intent.getIntExtra("requestCode", 0), intent.getBundleExtra("wei.mark.standout.data"), (Class) intent.getSerializableExtra("wei.mark.standout.fromCls"), intent.getIntExtra("fromId", 0));
                        return 2;
                    } else {
                        return 2;
                    }
                }
                D(intExtra);
                return 2;
            }
            throw new RuntimeException("ID cannot equals StandOutWindow.ONGOING_NOTIFICATION_ID");
        }
        Log.w("StandOutWindow", "Tried to onStartCommand() with a null intent.");
        return 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Window r(int i2) {
        return h.a(i2, getClass());
    }

    public final synchronized void s(int i2) {
        Window r = r(i2);
        if (r != null) {
            if (w(i2, r)) {
                Log.d("StandOutWindow", "Window " + i2 + " hide cancelled by implementation.");
                return;
            }
            if (r.visibility == 0) {
                Log.d("StandOutWindow", "Window " + i2 + " is already hidden.");
            }
            if (hw2.a(r.flags, rf2.FLAG_WINDOW_HIDE_ENABLE)) {
                r.visibility = 2;
                Notification m = m(i2);
                Animation loadAnimation = AnimationUtils.loadAnimation(this, R$anim.console_hide);
                try {
                    if (loadAnimation != null) {
                        loadAnimation.setAnimationListener(new b(r));
                        r.getChildAt(0).startAnimation(loadAnimation);
                    } else {
                        this.d.removeView(r);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                m.flags = m.flags | 32 | 16;
                this.e.notify(getClass().hashCode() + i2, m);
            } else {
                c(i2);
            }
            return;
        }
        throw new IllegalArgumentException("Tried to hide(" + i2 + ") a null window.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean t(int i2) {
        return h.d(i2, getClass());
    }

    public boolean u(int i2, Window window) {
        return false;
    }

    public boolean v() {
        return false;
    }

    public boolean w(int i2, Window window) {
        return false;
    }

    public void x(int i2, int i3, Bundle bundle, Class<? extends StandOutWindow> cls, int i4) {
    }

    public boolean y(int i2, Window window) {
        return false;
    }

    public boolean z(int i2, Window window, View view, MotionEvent motionEvent) {
        StandOutLayoutParams layoutParams = window.getLayoutParams();
        ep2 ep2Var = window.touchInfo;
        int i3 = ep2Var.c - ep2Var.a;
        int i4 = ep2Var.d - ep2Var.b;
        int action = motionEvent.getAction();
        if (action == 0) {
            window.touchInfo.c = (int) motionEvent.getRawX();
            window.touchInfo.d = (int) motionEvent.getRawY();
            ep2 ep2Var2 = window.touchInfo;
            ep2Var2.a = ep2Var2.c;
            ep2Var2.b = ep2Var2.d;
        } else if (action == 1) {
            boolean z = false;
            window.touchInfo.j = false;
            if (motionEvent.getPointerCount() == 1) {
                if (Math.abs(i3) < layoutParams.threshold && Math.abs(i4) < layoutParams.threshold) {
                    z = true;
                }
                if (z && hw2.a(window.flags, rf2.FLAG_WINDOW_BRING_TO_FRONT_ON_TAP)) {
                    b(i2);
                }
            } else if (hw2.a(window.flags, rf2.FLAG_WINDOW_BRING_TO_FRONT_ON_TOUCH)) {
                b(i2);
            }
        } else if (action == 2) {
            int rawX = ((int) motionEvent.getRawX()) - window.touchInfo.c;
            ep2 ep2Var3 = window.touchInfo;
            int rawY = ((int) motionEvent.getRawY()) - ep2Var3.d;
            ep2Var3.c = (int) motionEvent.getRawX();
            window.touchInfo.d = (int) motionEvent.getRawY();
            if (window.touchInfo.j || Math.abs(i3) >= layoutParams.threshold || Math.abs(i4) >= layoutParams.threshold) {
                window.touchInfo.j = true;
                if (hw2.a(window.flags, rf2.FLAG_BODY_MOVE_ENABLE)) {
                    if (motionEvent.getPointerCount() == 1) {
                        ((WindowManager.LayoutParams) layoutParams).x += rawX;
                        ((WindowManager.LayoutParams) layoutParams).y += rawY;
                    }
                    window.edit().c(((WindowManager.LayoutParams) layoutParams).x, ((WindowManager.LayoutParams) layoutParams).y).a();
                }
            }
        }
        return true;
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class StandOutLayoutParams extends WindowManager.LayoutParams {
        public static final int AUTO_POSITION = -2147483647;
        public static final int BOTTOM = Integer.MAX_VALUE;
        public static final int CENTER = Integer.MIN_VALUE;
        public static final int LEFT = 0;
        public static final int RIGHT = Integer.MAX_VALUE;
        public static final int TOP = 0;
        public int maxHeight;
        public int maxWidth;
        public int minHeight;
        public int minWidth;
        public int threshold;

        public StandOutLayoutParams(int i) {
            super(200, 200, 2002, 262176, -3);
            int i2 = StandOutWindow.this.c;
            setFocusFlag(false);
            if (!hw2.a(i2, rf2.FLAG_WINDOW_EDGE_LIMITS_ENABLE)) {
                ((WindowManager.LayoutParams) this).flags |= 512;
            }
            ((WindowManager.LayoutParams) this).x = getX(i, ((WindowManager.LayoutParams) this).width);
            ((WindowManager.LayoutParams) this).y = getY(i, ((WindowManager.LayoutParams) this).height);
            ((WindowManager.LayoutParams) this).gravity = 51;
            this.threshold = 10;
            this.minHeight = 0;
            this.minWidth = 0;
            this.maxHeight = Integer.MAX_VALUE;
            this.maxWidth = Integer.MAX_VALUE;
        }

        private int getX(int i, int i2) {
            return ((StandOutWindow.h.g() * 100) + (i * 100)) % (StandOutWindow.this.d.getDefaultDisplay().getWidth() - i2);
        }

        private int getY(int i, int i2) {
            Display defaultDisplay = StandOutWindow.this.d.getDefaultDisplay();
            return ((StandOutWindow.h.g() * 100) + (((WindowManager.LayoutParams) this).x + (((i * 100) * 200) / (defaultDisplay.getWidth() - ((WindowManager.LayoutParams) this).width)))) % (defaultDisplay.getHeight() - i2);
        }

        public void setFocusFlag(boolean z) {
            if (z) {
                ((WindowManager.LayoutParams) this).flags ^= 8;
            } else {
                ((WindowManager.LayoutParams) this).flags |= 8;
            }
        }

        public StandOutLayoutParams(StandOutWindow standOutWindow, int i, int i2, int i3) {
            this(i);
            ((WindowManager.LayoutParams) this).width = i2;
            ((WindowManager.LayoutParams) this).height = i3;
        }

        public StandOutLayoutParams(StandOutWindow standOutWindow, int i, int i2, int i3, int i4, int i5) {
            this(standOutWindow, i, i2, i3);
            if (i4 != -2147483647) {
                ((WindowManager.LayoutParams) this).x = i4;
            }
            if (i5 != -2147483647) {
                ((WindowManager.LayoutParams) this).y = i5;
            }
            Display defaultDisplay = standOutWindow.d.getDefaultDisplay();
            int width = defaultDisplay.getWidth();
            int height = defaultDisplay.getHeight();
            int i6 = ((WindowManager.LayoutParams) this).x;
            if (i6 == Integer.MAX_VALUE) {
                ((WindowManager.LayoutParams) this).x = width - i2;
            } else if (i6 == Integer.MIN_VALUE) {
                ((WindowManager.LayoutParams) this).x = (width - i2) / 2;
            }
            int i7 = ((WindowManager.LayoutParams) this).y;
            if (i7 == Integer.MAX_VALUE) {
                ((WindowManager.LayoutParams) this).y = height - i3;
            } else if (i7 == Integer.MIN_VALUE) {
                ((WindowManager.LayoutParams) this).y = (height - i3) / 2;
            }
        }

        public StandOutLayoutParams(StandOutWindow standOutWindow, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
            this(standOutWindow, i, i2, i3, i4, i5);
            this.minWidth = i6;
            this.minHeight = i7;
        }
    }
}
