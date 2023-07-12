package com.alibaba.security.biometrics.logic.view.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.security.biometrics.R;
import com.alibaba.security.biometrics.a.InterfaceC3740a;
import com.alibaba.security.biometrics.activity.BaseBioNavigatorActivity;
import com.alibaba.security.biometrics.c.C3753c;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.listener.OnRetryListener;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class DetectActionResultWidget extends BaseWidget {
    private static final String c = "DetectActionResultWidget";
    public int b;
    private ImageView d;
    private TextView e;
    private TextView f;
    private Button g;
    private Button h;
    private InterfaceC3740a i;

    public DetectActionResultWidget(Context context) {
        super(context);
        this.b = 0;
    }

    private void h() {
        this.b = 0;
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    protected final void b() {
        C3788b.a(this.g, c("mainButton"));
        C3788b.a(this.e, d("titleText"));
        C3788b.a(this.f, d("messageText"));
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public final void c() {
        this.b = 0;
    }

    public final void g() {
        b();
        C3788b.a(this.d, a("promptSucceedImageView"), R.C3735drawable.rp_face_result_icon_ok);
        this.e.setText(R.string.face_liveness_success);
        this.f.setVisibility(4);
        this.g.setVisibility(4);
        this.h.setVisibility(4);
        setVisibility(0);
        setAlpha(1.0f);
    }

    public int getDetectResultErrorCode() {
        return this.b;
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    protected String getSkinParentKey() {
        return "resultPage";
    }

    public void setOnDetectActionResultListener(InterfaceC3740a interfaceC3740a) {
        this.i = interfaceC3740a;
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    protected final void a() {
        this.b = -1;
        this.d = (ImageView) findViewById(R.id.abfl_widget_dar_icon);
        this.e = (TextView) findViewById(R.id.abfl_widget_dar_title);
        this.f = (TextView) findViewById(R.id.abfl_widget_dar_content);
        this.g = (Button) findViewById(R.id.abfl_widget_dar_btn);
        this.h = (Button) findViewById(R.id.abfl_widget_dar_other_btn);
    }

    public DetectActionResultWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 0;
    }

    public DetectActionResultWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 0;
    }

    private void a(final int i, String str, CharSequence charSequence, String str2, boolean z, final int i2) {
        b();
        if (i2 == 0) {
            C3788b.a(this.d, a("promptSucceedImageView"), R.C3735drawable.rp_face_result_icon_ok);
        } else {
            C3788b.a(this.d, a("promptFailImageView"), R.C3735drawable.rp_face_result_icon_fail);
        }
        this.e.setText(str);
        this.g.setText(str2);
        this.g.setVisibility(0);
        try {
            if (Build.VERSION.SDK_INT < 11) {
                setVisibility(0);
                setAlpha(1.0f);
            } else {
                C3753c.AnonymousClass1 anonymousClass1 = new C3753c.AnonymousClass1(this);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillBefore(true);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                alphaAnimation.setAnimationListener(anonymousClass1);
                startAnimation(alphaAnimation);
            }
        } catch (Throwable unused) {
        }
        if (charSequence != null) {
            this.f.setText(charSequence);
        } else {
            this.f.setText("");
        }
        this.f.setVisibility(charSequence == null ? 4 : 0);
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.security.biometrics.logic.view.widget.DetectActionResultWidget.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (DetectActionResultWidget.this.i != null) {
                    DetectActionResultWidget.this.i.a(i, 0, i2);
                }
                DetectActionResultWidget.this.setVisibility(8);
            }
        });
        if (z) {
            this.h.setVisibility(0);
            this.h.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.security.biometrics.logic.view.widget.DetectActionResultWidget.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (DetectActionResultWidget.this.i != null) {
                        DetectActionResultWidget.this.i.a(BaseBioNavigatorActivity.n, 1, i2);
                    }
                    DetectActionResultWidget.this.setVisibility(8);
                }
            });
            return;
        }
        this.h.setVisibility(4);
    }

    public final void a(final int i, final Runnable runnable, final ALBiometricsParams aLBiometricsParams, String str, final String str2) {
        b();
        InterfaceC3740a interfaceC3740a = this.i;
        if (interfaceC3740a != null) {
            interfaceC3740a.onBeforeRetry(new OnRetryListener() { // from class: com.alibaba.security.biometrics.logic.view.widget.DetectActionResultWidget.3
                @Override // com.alibaba.security.biometrics.service.listener.OnRetryListener
                public final void onRetry(int i2) {
                    int i3 = i;
                    if (i2 != 0) {
                        i3 = GlobalErrorCode.ERROR_BUSINESS_RETRY_REACH_THRESHOLD;
                    }
                    DetectActionResultWidget.a(DetectActionResultWidget.this, i3, runnable, aLBiometricsParams, str2);
                }
            }, str);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x043e  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x04b2  */
    /* JADX WARN: Removed duplicated region for block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(int r19, java.lang.Runnable r20, com.alibaba.security.biometrics.service.model.params.ALBiometricsParams r21, java.lang.String r22) {
        /*
            Method dump skipped, instructions count: 1350
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.biometrics.logic.view.widget.DetectActionResultWidget.a(int, java.lang.Runnable, com.alibaba.security.biometrics.service.model.params.ALBiometricsParams, java.lang.String):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x043b  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x04af  */
    /* JADX WARN: Removed duplicated region for block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(int r19, com.alibaba.security.biometrics.service.model.params.ALBiometricsParams r20, java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 1348
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.biometrics.logic.view.widget.DetectActionResultWidget.a(int, com.alibaba.security.biometrics.service.model.params.ALBiometricsParams, java.lang.String):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02f1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ void a(com.alibaba.security.biometrics.logic.view.widget.DetectActionResultWidget r18, int r19, java.lang.Runnable r20, com.alibaba.security.biometrics.service.model.params.ALBiometricsParams r21, java.lang.String r22) {
        /*
            Method dump skipped, instructions count: 1362
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.biometrics.logic.view.widget.DetectActionResultWidget.a(com.alibaba.security.biometrics.logic.view.widget.DetectActionResultWidget, int, java.lang.Runnable, com.alibaba.security.biometrics.service.model.params.ALBiometricsParams, java.lang.String):void");
    }
}
