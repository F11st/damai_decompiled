package com.alibaba.security.biometrics.logic.view.widget;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.internal.view.SupportMenu;
import com.alibaba.security.biometrics.R;
import com.alibaba.security.biometrics.c.C3757d;
import com.alibaba.security.biometrics.logic.model.DazzleCollectDataUIConfigItem;
import com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView;
import com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.skin.model.DetectAnimSkinData;
import com.alibaba.security.common.c.C3800a;
import com.alibaba.security.common.d.C3807d;
import com.alibaba.security.common.view.GifImageView;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class DetectActionWidget extends BaseWidget {
    private static final String c = "DetectActionWidget";
    private static final long d = 500;
    private static final long e = 1000;
    private static final int f = 1;
    private static final int g = 2;
    private static final int h = 3;
    public RPDetectCoreView b;
    private TextView i;
    private TextView j;
    private LinearLayout k;
    private GifImageView l;
    private ImageView m;
    private View n;
    private TextView o;
    private Handler p;
    private Activity q;
    private long r;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.biometrics.logic.view.widget.DetectActionWidget$a */
    /* loaded from: classes8.dex */
    public interface InterfaceC3782a {
        DazzleCollectDataUIConfigItem a(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.biometrics.logic.view.widget.DetectActionWidget$b */
    /* loaded from: classes8.dex */
    public static class HandlerC3783b extends Handler {
        private final DetectActionWidget a;

        public HandlerC3783b(DetectActionWidget detectActionWidget) {
            super(Looper.getMainLooper());
            this.a = detectActionWidget;
        }

        @Override // android.os.Handler
        public final void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 1) {
                DetectActionWidget.b(this.a);
            } else if (i == 2) {
                DetectActionWidget.a(this.a, message);
            } else if (i != 3) {
            } else {
                this.a.r = 0L;
            }
        }
    }

    public DetectActionWidget(Context context) {
        super(context);
        k();
    }

    private void k() {
        this.p = new HandlerC3783b(this);
    }

    private void l() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.l.getLayoutParams();
        layoutParams.setMargins(0, this.b.getCircleBottom() + C3807d.a(getContext(), 80.0f), 0, 0);
        this.l.setLayoutParams(layoutParams);
        this.l.requestLayout();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
        layoutParams2.setMargins(0, this.b.getCircleBottom() + C3807d.a(getContext(), 78.0f), 0, 0);
        this.m.setLayoutParams(layoutParams2);
        this.m.requestLayout();
    }

    private void m() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
        layoutParams.setMargins(0, this.b.getCircleBottom() + C3807d.a(getContext(), 20.0f), 0, 0);
        this.i.setLayoutParams(layoutParams);
        this.i.requestLayout();
    }

    private void n() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
        int radius = this.b.getRadius();
        layoutParams.height = radius * 2;
        layoutParams.topMargin = this.b.getCircleCenterY() - radius;
        this.o.setLayoutParams(layoutParams);
        this.o.requestLayout();
    }

    private void o() {
        this.r = 0L;
    }

    private void p() {
        ALBiometricsActivityParentView.InterfaceC3778a interfaceC3778a = this.a;
        if (interfaceC3778a != null) {
            interfaceC3778a.g();
        }
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    protected final void b() {
        C3788b.a(this.i, d("actionTipText"));
        C3788b.a(this.j, d("messageText"));
        DetectAnimSkinData e2 = e("detectAnimation");
        if (e2 != null) {
            this.b.setBreatheColor(C3757d.a(e2.getWarningColor(), SupportMenu.CATEGORY_MASK));
            this.b.setWaitingColor(C3757d.a(e2.getLoadingColor(), -16776961));
            return;
        }
        this.b.setBreatheColor(SupportMenu.CATEGORY_MASK);
        this.b.setWaitingColor(-16776961);
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public final void c() {
        g();
        this.o.setVisibility(8);
        this.b.b();
        this.p.removeCallbacksAndMessages(null);
    }

    public final void f(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b();
        C3788b.a(this.i, d("actionTipText"));
        this.p.removeMessages(1);
        this.p.sendEmptyMessageDelayed(1, 1000L);
        if (System.currentTimeMillis() - this.r >= 500) {
            this.i.setText(str);
            this.r = System.currentTimeMillis();
        }
    }

    public final void g() {
        this.l.setVisibility(8);
        this.m.setVisibility(8);
    }

    public int getMaskCircleDisplayY() {
        return this.b.getCircleCenterY();
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    protected String getSkinParentKey() {
        return "detectPage";
    }

    public final void h() {
        C3800a.d(c, "stopDazzleCollectView");
        this.p.removeMessages(2);
        this.b.setBackgroundColor(-1);
        this.b.invalidate();
    }

    public final void i() {
        this.i.setText("");
        this.i.setVisibility(4);
    }

    public final void j() {
        b();
        this.k.setVisibility(4);
        this.i.setVisibility(4);
        this.o.setVisibility(0);
        RPDetectCoreView rPDetectCoreView = this.b;
        if (rPDetectCoreView.h == null) {
            ValueAnimator duration = ValueAnimator.ofInt(0, 360).setDuration(2000L);
            rPDetectCoreView.h = duration;
            duration.setRepeatCount(-1);
            rPDetectCoreView.h.addUpdateListener(new RPDetectCoreView.AnonymousClass2());
            rPDetectCoreView.h.start();
        }
    }

    public void setActivity(Activity activity) {
        this.q = activity;
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    protected final void a() {
        this.l = (GifImageView) findViewById(R.id.abfl_widget_da_actionGuidance_image);
        this.m = (ImageView) findViewById(R.id.abfl_widget_da_actionGuidance_anim_image);
        this.i = (TextView) findViewById(R.id.abfl_widget_da_mainPrompt);
        this.j = (TextView) findViewById(R.id.widget_da_self_name);
        this.k = (LinearLayout) findViewById(R.id.widget_da_self_name_parent);
        this.n = findViewById(R.id.abfl_widget_da_maskview_blurview);
        this.b = (RPDetectCoreView) findViewById(R.id.abfl_widget_da_maskview);
        this.o = (TextView) findViewById(R.id.abfl_waiting_tip);
    }

    public DetectActionWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k();
    }

    private void g(String str) {
        this.r = 0L;
        C3788b.a(this.i, d("actionTipText"));
        this.p.removeMessages(1);
        this.i.setText(str);
        this.i.setVisibility(0);
    }

    public DetectActionWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        k();
    }

    private void h(String str) {
        C3788b.a(this.i, d("actionTipText"));
        this.p.removeMessages(1);
        this.p.sendEmptyMessageDelayed(1, 1000L);
        if (System.currentTimeMillis() - this.r < 500) {
            return;
        }
        this.i.setText(str);
        this.r = System.currentTimeMillis();
    }

    static /* synthetic */ void b(DetectActionWidget detectActionWidget) {
        ALBiometricsActivityParentView.InterfaceC3778a interfaceC3778a = detectActionWidget.a;
        if (interfaceC3778a != null) {
            interfaceC3778a.g();
        }
    }

    private void a(int i) {
        this.m.setVisibility(0);
        this.m.setImageDrawable(getResources().getDrawable(i));
        ((AnimationDrawable) this.m.getDrawable()).start();
    }

    public final void a(String str, ALBiometricsParams aLBiometricsParams) {
        b();
        g(str);
        String str2 = aLBiometricsParams.userName;
        if (!TextUtils.isEmpty(str2)) {
            C3788b.a(this.j, d("messageText"));
            this.k.setVisibility(0);
            this.j.setText(str2);
            return;
        }
        this.k.setVisibility(8);
    }

    public final void a(DazzleCollectDataUIConfigItem dazzleCollectDataUIConfigItem, InterfaceC3782a interfaceC3782a, int i) {
        g(dazzleCollectDataUIConfigItem.getTitle());
        this.k.setVisibility(4);
        try {
            this.i.setTextColor(Color.parseColor(dazzleCollectDataUIConfigItem.getTextColor()));
        } catch (Exception unused) {
            this.i.setTextColor(getContext().getResources().getColor(R.C3734color.rpsdk_color_333333));
        }
        try {
            this.b.setBackgroundColor(Color.parseColor(dazzleCollectDataUIConfigItem.getColor()));
        } catch (Exception unused2) {
            this.b.setBackgroundColor(-1);
        }
        dazzleCollectDataUIConfigItem.setTimeInterval(System.currentTimeMillis());
        C3807d.a(this.q, (int) (dazzleCollectDataUIConfigItem.getScreenLight() * 255.0f));
        if (dazzleCollectDataUIConfigItem.getDuration() <= 0.0f) {
            a(interfaceC3782a, i);
            return;
        }
        long duration = dazzleCollectDataUIConfigItem.getDuration() * 1000.0f;
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.arg1 = i;
        obtain.obj = interfaceC3782a;
        this.p.sendMessageDelayed(obtain, duration);
    }

    private void a(InterfaceC3782a interfaceC3782a, int i) {
        int i2 = i + 1;
        DazzleCollectDataUIConfigItem a = interfaceC3782a.a(i2);
        if (a != null) {
            a(a, interfaceC3782a, i2);
        }
    }

    public final void a(final RPDetectCoreView.InterfaceC3781a interfaceC3781a) {
        b();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
        layoutParams.setMargins(0, this.b.getCircleBottom() + C3807d.a(getContext(), 20.0f), 0, 0);
        this.i.setLayoutParams(layoutParams);
        this.i.requestLayout();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.l.getLayoutParams();
        layoutParams2.setMargins(0, this.b.getCircleBottom() + C3807d.a(getContext(), 80.0f), 0, 0);
        this.l.setLayoutParams(layoutParams2);
        this.l.requestLayout();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
        layoutParams3.setMargins(0, this.b.getCircleBottom() + C3807d.a(getContext(), 78.0f), 0, 0);
        this.m.setLayoutParams(layoutParams3);
        this.m.requestLayout();
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
        int radius = this.b.getRadius();
        layoutParams4.height = radius * 2;
        layoutParams4.topMargin = this.b.getCircleCenterY() - radius;
        this.o.setLayoutParams(layoutParams4);
        this.o.requestLayout();
        setVisibility(0);
        this.n.setVisibility(0);
        RPDetectCoreView rPDetectCoreView = this.b;
        RPDetectCoreView.InterfaceC3781a interfaceC3781a2 = new RPDetectCoreView.InterfaceC3781a() { // from class: com.alibaba.security.biometrics.logic.view.widget.DetectActionWidget.1
            @Override // com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView.InterfaceC3781a
            public final void a() {
                RPDetectCoreView.InterfaceC3781a interfaceC3781a3 = interfaceC3781a;
                if (interfaceC3781a3 != null) {
                    interfaceC3781a3.a();
                }
            }

            @Override // com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView.InterfaceC3781a
            public final void b() {
                RPDetectCoreView.InterfaceC3781a interfaceC3781a3 = interfaceC3781a;
                if (interfaceC3781a3 != null) {
                    interfaceC3781a3.b();
                }
                DetectActionWidget.this.n.setVisibility(8);
            }
        };
        rPDetectCoreView.d = 2.5f;
        rPDetectCoreView.e = 1.0f;
        rPDetectCoreView.c = 350L;
        rPDetectCoreView.a = interfaceC3781a2;
        rPDetectCoreView.f = false;
        rPDetectCoreView.b = SystemClock.uptimeMillis();
        rPDetectCoreView.invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.alibaba.security.biometrics.service.model.detector.ABDetectType r4, com.alibaba.security.biometrics.service.model.params.ALBiometricsParams r5) {
        /*
            r3 = this;
            r3.b()
            java.lang.String r0 = ""
            if (r4 == 0) goto L5f
            int[] r1 = com.alibaba.security.biometrics.c.C3749b.AnonymousClass1.a
            int r2 = r4.ordinal()
            r1 = r1[r2]
            switch(r1) {
                case 1: goto L55;
                case 2: goto L55;
                case 3: goto L4a;
                case 4: goto L4a;
                case 5: goto L3f;
                case 6: goto L3f;
                case 7: goto L34;
                case 8: goto L29;
                case 9: goto L1e;
                case 10: goto L13;
                case 11: goto L13;
                case 12: goto L5f;
                default: goto L12;
            }
        L12:
            goto L5f
        L13:
            android.content.res.Resources r0 = r3.getResources()
            int r1 = com.alibaba.security.biometrics.R.string.face_detect_action_turn_right_or_left
            java.lang.String r0 = r0.getString(r1)
            goto L5f
        L1e:
            android.content.res.Resources r0 = r3.getResources()
            int r1 = com.alibaba.security.biometrics.R.string.face_detect_action_turn_left
            java.lang.String r0 = r0.getString(r1)
            goto L5f
        L29:
            android.content.res.Resources r0 = r3.getResources()
            int r1 = com.alibaba.security.biometrics.R.string.face_detect_action_turn_right
            java.lang.String r0 = r0.getString(r1)
            goto L5f
        L34:
            android.content.res.Resources r0 = r3.getResources()
            int r1 = com.alibaba.security.biometrics.R.string.face_detect_action_pitch_down_head
            java.lang.String r0 = r0.getString(r1)
            goto L5f
        L3f:
            android.content.res.Resources r0 = r3.getResources()
            int r1 = com.alibaba.security.biometrics.R.string.face_detect_action_raise_head
            java.lang.String r0 = r0.getString(r1)
            goto L5f
        L4a:
            android.content.res.Resources r0 = r3.getResources()
            int r1 = com.alibaba.security.biometrics.R.string.face_detect_action_mounth
            java.lang.String r0 = r0.getString(r1)
            goto L5f
        L55:
            android.content.res.Resources r0 = r3.getResources()
            int r1 = com.alibaba.security.biometrics.R.string.face_detect_action_blink
            java.lang.String r0 = r0.getString(r1)
        L5f:
            r3.a(r0, r5)
            if (r4 == 0) goto L7c
            int[] r5 = com.alibaba.security.biometrics.c.C3749b.AnonymousClass1.a
            int r4 = r4.ordinal()
            r4 = r5[r4]
            switch(r4) {
                case 1: goto L79;
                case 2: goto L79;
                case 3: goto L76;
                case 4: goto L76;
                case 5: goto L73;
                case 6: goto L73;
                case 7: goto L73;
                case 8: goto L70;
                case 9: goto L70;
                case 10: goto L70;
                case 11: goto L70;
                default: goto L6f;
            }
        L6f:
            goto L7c
        L70:
            int r4 = com.alibaba.security.biometrics.R.C3735drawable.rp_face_guide_yaw_anim
            goto L7d
        L73:
            int r4 = com.alibaba.security.biometrics.R.C3735drawable.rp_face_guide_pitch_anim
            goto L7d
        L76:
            int r4 = com.alibaba.security.biometrics.R.C3735drawable.rp_face_guide_mouth_anim
            goto L7d
        L79:
            int r4 = com.alibaba.security.biometrics.R.C3735drawable.rp_face_guide_blink_anim
            goto L7d
        L7c:
            r4 = -1
        L7d:
            if (r4 <= 0) goto L9d
            android.widget.ImageView r5 = r3.m
            r0 = 0
            r5.setVisibility(r0)
            android.widget.ImageView r5 = r3.m
            android.content.res.Resources r0 = r3.getResources()
            android.graphics.drawable.Drawable r4 = r0.getDrawable(r4)
            r5.setImageDrawable(r4)
            android.widget.ImageView r4 = r3.m
            android.graphics.drawable.Drawable r4 = r4.getDrawable()
            android.graphics.drawable.AnimationDrawable r4 = (android.graphics.drawable.AnimationDrawable) r4
            r4.start()
        L9d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.biometrics.logic.view.widget.DetectActionWidget.a(com.alibaba.security.biometrics.service.model.detector.ABDetectType, com.alibaba.security.biometrics.service.model.params.ALBiometricsParams):void");
    }

    private void a(boolean z) {
        RPDetectCoreView rPDetectCoreView = this.b;
        if (rPDetectCoreView == null) {
            return;
        }
        if (z) {
            rPDetectCoreView.a();
            return;
        }
        if (rPDetectCoreView.g == null) {
            ValueAnimator duration = ValueAnimator.ofInt(100, 0).setDuration(1000L);
            rPDetectCoreView.g = duration;
            duration.setRepeatCount(-1);
            rPDetectCoreView.g.addUpdateListener(new RPDetectCoreView.AnonymousClass1());
            rPDetectCoreView.g.start();
        }
        rPDetectCoreView.invalidate();
    }

    private void a(Message message) {
        a((InterfaceC3782a) message.obj, message.arg1);
    }

    static /* synthetic */ void a(DetectActionWidget detectActionWidget, Message message) {
        detectActionWidget.a((InterfaceC3782a) message.obj, message.arg1);
    }
}
