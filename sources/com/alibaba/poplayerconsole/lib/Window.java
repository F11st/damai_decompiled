package com.alibaba.poplayerconsole.lib;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.alibaba.poplayerconsole.R$drawable;
import com.alibaba.poplayerconsole.R$id;
import com.alibaba.poplayerconsole.R$layout;
import com.alibaba.poplayerconsole.lib.StandOutWindow;
import java.util.LinkedList;
import tb.ep2;
import tb.hw2;
import tb.rf2;

/* compiled from: Taobao */
@SuppressLint({"ClickableViewAccessibility"})
/* loaded from: classes8.dex */
public class Window extends FrameLayout {
    static final String TAG = "Window";
    public static final int VISIBILITY_GONE = 0;
    public static final int VISIBILITY_TRANSITION = 2;
    public static final int VISIBILITY_VISIBLE = 1;
    public Class<? extends StandOutWindow> cls;
    public Bundle data;
    int displayHeight;
    int displayWidth;
    public int flags;
    public boolean focused;
    public int id;
    private final StandOutWindow mContext;
    private LayoutInflater mLayoutInflater;
    public StandOutWindow.StandOutLayoutParams originalParams;
    public ep2 touchInfo;
    public int visibility;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.poplayerconsole.lib.Window$a */
    /* loaded from: classes8.dex */
    class View$OnTouchListenerC3713a implements View.OnTouchListener {
        final /* synthetic */ StandOutWindow a;
        final /* synthetic */ int b;

        View$OnTouchListenerC3713a(StandOutWindow standOutWindow, int i) {
            this.a = standOutWindow;
            this.b = i;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.a.z(this.b, Window.this, view, motionEvent);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.poplayerconsole.lib.Window$b */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC3714b implements View.OnClickListener {
        final /* synthetic */ TextView a;

        View$OnClickListenerC3714b(TextView textView) {
            this.a = textView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PopupWindow i = Window.this.mContext.i(Window.this.id);
            if (i != null) {
                i.showAsDropDown(this.a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.poplayerconsole.lib.Window$c */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC3715c implements View.OnClickListener {
        View$OnClickListenerC3715c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Window.this.mContext.s(Window.this.id);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.poplayerconsole.lib.Window$d */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC3716d implements View.OnClickListener {
        View$OnClickListenerC3716d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            StandOutWindow.StandOutLayoutParams layoutParams = Window.this.getLayoutParams();
            if (Window.this.data.getBoolean("isMaximized")) {
                int i = ((WindowManager.LayoutParams) layoutParams).width;
                Window window = Window.this;
                if (i == window.displayWidth && ((WindowManager.LayoutParams) layoutParams).height == window.displayHeight && ((WindowManager.LayoutParams) layoutParams).x == 0 && ((WindowManager.LayoutParams) layoutParams).y == 0) {
                    window.data.putBoolean("isMaximized", false);
                    int i2 = Window.this.data.getInt("widthBeforeMaximize", -1);
                    int i3 = Window.this.data.getInt("heightBeforeMaximize", -1);
                    Window.this.edit().f(i2, i3).c(Window.this.data.getInt("xBeforeMaximize", -1), Window.this.data.getInt("yBeforeMaximize", -1)).a();
                    return;
                }
            }
            Window.this.data.putBoolean("isMaximized", true);
            Window.this.data.putInt("widthBeforeMaximize", ((WindowManager.LayoutParams) layoutParams).width);
            Window.this.data.putInt("heightBeforeMaximize", ((WindowManager.LayoutParams) layoutParams).height);
            Window.this.data.putInt("xBeforeMaximize", ((WindowManager.LayoutParams) layoutParams).x);
            Window.this.data.putInt("yBeforeMaximize", ((WindowManager.LayoutParams) layoutParams).y);
            Window.this.edit().e(1.0f, 1.0f).c(0, 0).a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.poplayerconsole.lib.Window$e */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC3717e implements View.OnClickListener {
        View$OnClickListenerC3717e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Window.this.mContext.c(Window.this.id);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.poplayerconsole.lib.Window$f */
    /* loaded from: classes8.dex */
    public class View$OnTouchListenerC3718f implements View.OnTouchListener {
        View$OnTouchListenerC3718f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            StandOutWindow standOutWindow = Window.this.mContext;
            Window window = Window.this;
            return standOutWindow.z(window.id, window, view, motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.poplayerconsole.lib.Window$g */
    /* loaded from: classes8.dex */
    public class View$OnTouchListenerC3719g implements View.OnTouchListener {
        View$OnTouchListenerC3719g() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            StandOutWindow standOutWindow = Window.this.mContext;
            Window window = Window.this;
            return standOutWindow.A(window.id, window, view, motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.poplayerconsole.lib.Window$h */
    /* loaded from: classes8.dex */
    public class View$OnTouchListenerC3720h implements View.OnTouchListener {
        View$OnTouchListenerC3720h() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            StandOutWindow standOutWindow = Window.this.mContext;
            Window window = Window.this;
            return standOutWindow.A(window.id, window, view, motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.poplayerconsole.lib.Window$i */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC3721i implements View.OnClickListener {
        final /* synthetic */ View a;

        View$OnClickListenerC3721i(View view) {
            this.a = view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PopupWindow i = Window.this.mContext.i(Window.this.id);
            if (i != null) {
                i.showAsDropDown(this.a);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.poplayerconsole.lib.Window$j */
    /* loaded from: classes8.dex */
    public class C3722j {
        public static final int UNCHANGED = Integer.MIN_VALUE;
        StandOutWindow.StandOutLayoutParams a;
        float c = 0.0f;
        float b = 0.0f;

        public C3722j() {
            this.a = Window.this.getLayoutParams();
        }

        private C3722j d(int i, int i2, boolean z) {
            StandOutWindow.StandOutLayoutParams standOutLayoutParams = this.a;
            if (standOutLayoutParams != null) {
                float f = this.b;
                if (f >= 0.0f && f <= 1.0f) {
                    float f2 = this.c;
                    if (f2 >= 0.0f && f2 <= 1.0f) {
                        if (i != Integer.MIN_VALUE) {
                            ((WindowManager.LayoutParams) standOutLayoutParams).x = (int) (i - (((WindowManager.LayoutParams) standOutLayoutParams).width * f));
                        }
                        if (i2 != Integer.MIN_VALUE) {
                            ((WindowManager.LayoutParams) standOutLayoutParams).y = (int) (i2 - (((WindowManager.LayoutParams) standOutLayoutParams).height * f2));
                        }
                        if (hw2.a(Window.this.flags, rf2.FLAG_WINDOW_EDGE_LIMITS_ENABLE)) {
                            StandOutWindow.StandOutLayoutParams standOutLayoutParams2 = this.a;
                            if (((WindowManager.LayoutParams) standOutLayoutParams2).gravity == 51) {
                                ((WindowManager.LayoutParams) standOutLayoutParams2).x = Math.min(Math.max(((WindowManager.LayoutParams) standOutLayoutParams2).x, 0), Window.this.displayWidth - ((WindowManager.LayoutParams) this.a).width);
                                StandOutWindow.StandOutLayoutParams standOutLayoutParams3 = this.a;
                                ((WindowManager.LayoutParams) standOutLayoutParams3).y = Math.min(Math.max(((WindowManager.LayoutParams) standOutLayoutParams3).y, 0), Window.this.displayHeight - ((WindowManager.LayoutParams) this.a).height);
                            } else {
                                throw new IllegalStateException("The window " + Window.this.id + " gravity must be TOP|LEFT if FLAG_WINDOW_EDGE_LIMITS_ENABLE or FLAG_WINDOW_EDGE_TILE_ENABLE is set.");
                            }
                        }
                    }
                }
                throw new IllegalStateException("Anchor point must be between 0 and 1, inclusive.");
            }
            return this;
        }

        private C3722j g(int i, int i2, boolean z) {
            StandOutWindow.StandOutLayoutParams standOutLayoutParams = this.a;
            if (standOutLayoutParams != null) {
                float f = this.b;
                if (f >= 0.0f && f <= 1.0f) {
                    float f2 = this.c;
                    if (f2 >= 0.0f && f2 <= 1.0f) {
                        int i3 = ((WindowManager.LayoutParams) standOutLayoutParams).width;
                        int i4 = ((WindowManager.LayoutParams) standOutLayoutParams).height;
                        if (i != Integer.MIN_VALUE) {
                            ((WindowManager.LayoutParams) standOutLayoutParams).width = i;
                        }
                        if (i2 != Integer.MIN_VALUE) {
                            ((WindowManager.LayoutParams) standOutLayoutParams).height = i2;
                        }
                        int i5 = standOutLayoutParams.maxWidth;
                        int i6 = standOutLayoutParams.maxHeight;
                        if (hw2.a(Window.this.flags, rf2.FLAG_WINDOW_EDGE_LIMITS_ENABLE)) {
                            i5 = Math.min(i5, Window.this.displayWidth);
                            i6 = Math.min(i6, Window.this.displayHeight);
                        }
                        StandOutWindow.StandOutLayoutParams standOutLayoutParams2 = this.a;
                        ((WindowManager.LayoutParams) standOutLayoutParams2).width = Math.min(Math.max(((WindowManager.LayoutParams) standOutLayoutParams2).width, standOutLayoutParams2.minWidth), i5);
                        StandOutWindow.StandOutLayoutParams standOutLayoutParams3 = this.a;
                        ((WindowManager.LayoutParams) standOutLayoutParams3).height = Math.min(Math.max(((WindowManager.LayoutParams) standOutLayoutParams3).height, standOutLayoutParams3.minHeight), i6);
                        if (hw2.a(Window.this.flags, rf2.FLAG_WINDOW_ASPECT_RATIO_ENABLE)) {
                            StandOutWindow.StandOutLayoutParams standOutLayoutParams4 = this.a;
                            float f3 = Window.this.touchInfo.i;
                            int i7 = (int) (((WindowManager.LayoutParams) standOutLayoutParams4).height * f3);
                            int i8 = (int) (((WindowManager.LayoutParams) standOutLayoutParams4).width / f3);
                            if (i8 >= standOutLayoutParams4.minHeight && i8 <= standOutLayoutParams4.maxHeight) {
                                ((WindowManager.LayoutParams) standOutLayoutParams4).height = i8;
                            } else {
                                ((WindowManager.LayoutParams) standOutLayoutParams4).width = i7;
                            }
                        }
                        if (!z) {
                            StandOutWindow.StandOutLayoutParams standOutLayoutParams5 = this.a;
                            c((int) (((WindowManager.LayoutParams) standOutLayoutParams5).x + (i3 * this.b)), (int) (((WindowManager.LayoutParams) standOutLayoutParams5).y + (i4 * this.c)));
                        }
                    }
                }
                throw new IllegalStateException("Anchor point must be between 0 and 1, inclusive.");
            }
            return this;
        }

        public void a() {
            if (this.a != null) {
                Window.this.mContext.G(Window.this.id, this.a);
                this.a = null;
            }
        }

        public C3722j b(float f, float f2) {
            if (f >= 0.0f && f <= 1.0f && f2 >= 0.0f && f2 <= 1.0f) {
                this.b = f;
                this.c = f2;
                return this;
            }
            throw new IllegalArgumentException("Anchor point must be between 0 and 1, inclusive.");
        }

        public C3722j c(int i, int i2) {
            return d(i, i2, false);
        }

        public C3722j e(float f, float f2) {
            Window window = Window.this;
            return f((int) (window.displayWidth * f), (int) (window.displayHeight * f2));
        }

        public C3722j f(int i, int i2) {
            return g(i, i2, false);
        }
    }

    public Window(Context context) {
        super(context);
        this.mContext = null;
    }

    @SuppressLint({"InflateParams"})
    private View getSystemDecorations() {
        View inflate = this.mLayoutInflater.inflate(R$layout.console_window, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R$id.window_icon);
        textView.setOnClickListener(new View$OnClickListenerC3714b(textView));
        ((TextView) inflate.findViewById(R$id.title)).setText(this.mContext.a);
        View findViewById = inflate.findViewById(R$id.min_window);
        findViewById.setOnClickListener(new View$OnClickListenerC3715c());
        findViewById.setVisibility(8);
        View findViewById2 = inflate.findViewById(R$id.max_window);
        findViewById2.setOnClickListener(new View$OnClickListenerC3716d());
        View findViewById3 = inflate.findViewById(R$id.close_window);
        findViewById3.setOnClickListener(new View$OnClickListenerC3717e());
        View findViewById4 = inflate.findViewById(R$id.ll_console_windowbar);
        findViewById4.setOnTouchListener(new View$OnTouchListenerC3718f());
        View findViewById5 = inflate.findViewById(R$id.corner);
        findViewById5.setOnTouchListener(new View$OnTouchListenerC3719g());
        if (hw2.a(this.flags, rf2.FLAG_WINDOW_HIDE_ENABLE)) {
            findViewById.setVisibility(0);
        }
        if (hw2.a(this.flags, rf2.FLAG_DECORATION_MAXIMIZE_DISABLE)) {
            findViewById2.setVisibility(8);
        }
        if (hw2.a(this.flags, rf2.FLAG_DECORATION_CLOSE_DISABLE)) {
            findViewById3.setVisibility(8);
        }
        if (hw2.a(this.flags, rf2.FLAG_DECORATION_MOVE_DISABLE)) {
            findViewById4.setOnTouchListener(null);
        }
        if (hw2.a(this.flags, rf2.FLAG_DECORATION_RESIZE_DISABLE)) {
            findViewById5.setVisibility(8);
        }
        return inflate;
    }

    void addFunctionality(View view) {
        View findViewById;
        View findViewById2;
        if (!hw2.a(this.flags, rf2.FLAG_ADD_FUNCTIONALITY_RESIZE_DISABLE) && (findViewById2 = view.findViewById(R$id.corner)) != null) {
            findViewById2.setOnTouchListener(new View$OnTouchListenerC3720h());
        }
        if (hw2.a(this.flags, rf2.FLAG_ADD_FUNCTIONALITY_DROP_DOWN_DISABLE) || (findViewById = view.findViewById(R$id.window_icon)) == null) {
            return;
        }
        findViewById.setOnClickListener(new View$OnClickListenerC3721i(findViewById));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && keyEvent.getKeyCode() == 4) {
            this.mContext.F(this);
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public C3722j edit() {
        return new C3722j();
    }

    void fixCompatibility(View view) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(view);
        while (true) {
            View view2 = (View) linkedList.poll();
            if (view2 == null) {
                return;
            }
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    linkedList.add(viewGroup.getChildAt(i));
                }
            }
        }
    }

    public boolean onFocus(boolean z) {
        if (hw2.a(this.flags, rf2.FLAG_WINDOW_FOCUSABLE_DISABLE) || z == this.focused) {
            return false;
        }
        this.focused = z;
        if (!hw2.a(this.flags, rf2.FLAG_WINDOW_FOCUS_INDICATOR_DISABLE)) {
            View findViewById = findViewById(R$id.content);
            if (z) {
                findViewById.setBackgroundResource(R$drawable.border_focused);
            } else if (hw2.a(this.flags, rf2.FLAG_DECORATION_SYSTEM)) {
                findViewById.setBackgroundResource(R$drawable.border);
            } else {
                findViewById.setBackgroundResource(0);
            }
        }
        StandOutWindow.StandOutLayoutParams layoutParams = getLayoutParams();
        layoutParams.setFocusFlag(z);
        this.mContext.G(this.id, layoutParams);
        if (z) {
            this.mContext.C(this);
            return true;
        } else if (this.mContext.l() == this) {
            this.mContext.C(null);
            return true;
        } else {
            return true;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        StandOutWindow.StandOutLayoutParams layoutParams = getLayoutParams();
        if (motionEvent.getAction() == 0 && this.mContext.l() != this) {
            this.mContext.g(this.id);
        }
        if (motionEvent.getPointerCount() >= 2 && hw2.a(this.flags, rf2.FLAG_WINDOW_PINCH_RESIZE_ENABLE) && (motionEvent.getAction() & 255) == 5) {
            ep2 ep2Var = this.touchInfo;
            ep2Var.f = 1.0d;
            ep2Var.e = -1.0d;
            ep2Var.g = ((WindowManager.LayoutParams) layoutParams).width;
            ep2Var.h = ((WindowManager.LayoutParams) layoutParams).height;
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 4 && this.mContext.l() == this) {
            this.mContext.F(this);
        }
        if (motionEvent.getPointerCount() >= 2 && hw2.a(this.flags, rf2.FLAG_WINDOW_PINCH_RESIZE_ENABLE)) {
            float x = motionEvent.getX(0);
            float y = motionEvent.getY(0);
            double sqrt = Math.sqrt(Math.pow(x - motionEvent.getX(1), 2.0d) + Math.pow(y - motionEvent.getY(1), 2.0d));
            if ((motionEvent.getAction() & 255) == 2) {
                ep2 ep2Var = this.touchInfo;
                if (ep2Var.e == -1.0d) {
                    ep2Var.e = sqrt;
                }
                ep2Var.f *= sqrt / ep2Var.e;
                ep2Var.e = sqrt;
                C3722j b = edit().b(0.5f, 0.5f);
                ep2 ep2Var2 = this.touchInfo;
                double d = ep2Var2.g;
                double d2 = ep2Var2.f;
                b.f((int) (d * d2), (int) (ep2Var2.h * d2)).a();
            }
        }
        return true;
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof StandOutWindow.StandOutLayoutParams) {
            super.setLayoutParams(layoutParams);
            return;
        }
        throw new IllegalArgumentException(TAG + this.id + ": LayoutParams must be an instance of StandOutLayoutParams.");
    }

    @Override // android.view.View
    public StandOutWindow.StandOutLayoutParams getLayoutParams() {
        StandOutWindow.StandOutLayoutParams standOutLayoutParams = (StandOutWindow.StandOutLayoutParams) super.getLayoutParams();
        return standOutLayoutParams == null ? this.originalParams : standOutLayoutParams;
    }

    public Window(StandOutWindow standOutWindow, int i) {
        super(standOutWindow);
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        standOutWindow.setTheme(0);
        this.mContext = standOutWindow;
        this.mLayoutInflater = LayoutInflater.from(standOutWindow);
        this.cls = standOutWindow.getClass();
        this.id = i;
        this.originalParams = standOutWindow.n(i, this);
        this.flags = standOutWindow.c;
        ep2 ep2Var = new ep2();
        this.touchInfo = ep2Var;
        StandOutWindow.StandOutLayoutParams standOutLayoutParams = this.originalParams;
        ep2Var.i = ((WindowManager.LayoutParams) standOutLayoutParams).width / ((WindowManager.LayoutParams) standOutLayoutParams).height;
        this.data = new Bundle();
        DisplayMetrics displayMetrics = standOutWindow.getResources().getDisplayMetrics();
        this.displayWidth = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
        this.displayHeight = (int) (com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics) - (displayMetrics.density * 25.0f));
        if (hw2.a(this.flags, rf2.FLAG_DECORATION_SYSTEM)) {
            View systemDecorations = getSystemDecorations();
            frameLayout = (FrameLayout) systemDecorations.findViewById(R$id.body);
            frameLayout2 = systemDecorations;
        } else {
            FrameLayout frameLayout3 = new FrameLayout(standOutWindow);
            frameLayout3.setId(R$id.content);
            frameLayout = frameLayout3;
            frameLayout2 = frameLayout3;
        }
        addView(frameLayout2);
        frameLayout.setOnTouchListener(new View$OnTouchListenerC3713a(standOutWindow, i));
        standOutWindow.f(i, frameLayout);
        if (frameLayout.getChildCount() != 0) {
            if (!hw2.a(this.flags, rf2.FLAG_FIX_COMPATIBILITY_ALL_DISABLE)) {
                fixCompatibility(frameLayout);
            }
            if (!hw2.a(this.flags, rf2.FLAG_ADD_FUNCTIONALITY_ALL_DISABLE)) {
                addFunctionality(frameLayout);
            }
            setTag(frameLayout.getTag());
            return;
        }
        throw new RuntimeException("You must attach your view to the given frame in createAndAttachView()");
    }
}
