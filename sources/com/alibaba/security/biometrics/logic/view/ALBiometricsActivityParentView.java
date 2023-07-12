package com.alibaba.security.biometrics.logic.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.opengl.GLSurfaceView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.alibaba.security.biometrics.R;
import com.alibaba.security.biometrics.a.InterfaceC3740a;
import com.alibaba.security.biometrics.activity.BaseAlBioActivity;
import com.alibaba.security.biometrics.logic.model.DazzleCollectDataUIConfigItem;
import com.alibaba.security.biometrics.logic.view.a.InterfaceC3779a;
import com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView;
import com.alibaba.security.biometrics.logic.view.widget.CameraActivityWidgetParent;
import com.alibaba.security.biometrics.logic.view.widget.DetectActionResultWidget;
import com.alibaba.security.biometrics.logic.view.widget.DetectActionWidget;
import com.alibaba.security.biometrics.logic.view.widget.GuideWidget;
import com.alibaba.security.biometrics.logic.view.widget.PrivacyWidget;
import com.alibaba.security.biometrics.logic.view.widget.TitleBarWidget;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.model.detector.ABDetectType;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.service.model.result.ALBiometricsCodes;
import java.util.List;

/* compiled from: Taobao */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes8.dex */
public class ALBiometricsActivityParentView extends RelativeLayout {
    protected static final long g = 350;
    protected static final String h = "";
    protected static final String i = "guide";
    protected static final String j = "privacy";
    protected static final String k = "bio";
    protected static final String l = "result";
    private static final String p = "ALBiometricsActivityParentView";
    public CameraActivityWidgetParent a;
    public TitleBarWidget b;
    public GuideWidget c;
    public PrivacyWidget d;
    public DetectActionWidget e;
    public DetectActionResultWidget f;
    protected BaseAlBioActivity m;
    protected ALBiometricsParams n;
    protected String o;
    private View q;
    private String r;
    private InterfaceC3778a s;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView$3  reason: invalid class name */
    /* loaded from: classes8.dex */
    public class AnonymousClass3 implements RPDetectCoreView.InterfaceC3781a {
        final /* synthetic */ Runnable a;

        public AnonymousClass3(Runnable runnable) {
            this.a = runnable;
        }

        @Override // com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView.InterfaceC3781a
        public final void a() {
            this.a.run();
        }

        @Override // com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView.InterfaceC3781a
        public final void b() {
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView$a */
    /* loaded from: classes8.dex */
    public interface InterfaceC3778a {
        void c(boolean z);

        void d();

        void e();

        void g();
    }

    public ALBiometricsActivityParentView(Context context, ALBiometricsParams aLBiometricsParams) {
        super(context);
        this.o = "";
        this.r = "";
        this.m = (BaseAlBioActivity) context;
        this.n = aLBiometricsParams;
        View inflate = LayoutInflater.from(context).inflate(R.C3736layout.rp_face_liveness_activity, this);
        this.q = inflate;
        this.a = (CameraActivityWidgetParent) inflate.findViewById(R.id.abfl_widget_camera);
        this.b = (TitleBarWidget) this.q.findViewById(R.id.widget_title_bar);
        this.e = (DetectActionWidget) this.q.findViewById(R.id.widget_abfl_detectaction);
        this.f = (DetectActionResultWidget) this.q.findViewById(R.id.widget_abfl_detectactionresult);
        this.c = (GuideWidget) this.q.findViewById(R.id.widget_abfl_guide);
        this.d = (PrivacyWidget) this.q.findViewById(R.id.widget_abfl_privacy);
        this.e.setActivity(this.m);
        this.o = "";
        this.r = "";
    }

    private void a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.C3736layout.rp_face_liveness_activity, this);
        this.q = inflate;
        this.a = (CameraActivityWidgetParent) inflate.findViewById(R.id.abfl_widget_camera);
        this.b = (TitleBarWidget) this.q.findViewById(R.id.widget_title_bar);
        this.e = (DetectActionWidget) this.q.findViewById(R.id.widget_abfl_detectaction);
        this.f = (DetectActionResultWidget) this.q.findViewById(R.id.widget_abfl_detectactionresult);
        this.c = (GuideWidget) this.q.findViewById(R.id.widget_abfl_guide);
        this.d = (PrivacyWidget) this.q.findViewById(R.id.widget_abfl_privacy);
        this.e.setActivity(this.m);
        this.o = "";
        this.r = "";
    }

    private void g() {
        CameraActivityWidgetParent cameraActivityWidgetParent = this.a;
        if (cameraActivityWidgetParent != null) {
            cameraActivityWidgetParent.a();
        }
    }

    private void h() {
        CameraActivityWidgetParent cameraActivityWidgetParent = this.a;
        if (cameraActivityWidgetParent != null) {
            cameraActivityWidgetParent.b();
        }
    }

    private void i() {
        CameraActivityWidgetParent cameraActivityWidgetParent = this.a;
        if (cameraActivityWidgetParent != null) {
            cameraActivityWidgetParent.c();
        }
        TitleBarWidget titleBarWidget = this.b;
        if (titleBarWidget != null) {
            titleBarWidget.d();
        }
        GuideWidget guideWidget = this.c;
        if (guideWidget != null) {
            guideWidget.d();
        }
        PrivacyWidget privacyWidget = this.d;
        if (privacyWidget != null) {
            privacyWidget.d();
        }
        DetectActionWidget detectActionWidget = this.e;
        if (detectActionWidget != null) {
            detectActionWidget.d();
        }
        DetectActionResultWidget detectActionResultWidget = this.f;
        if (detectActionResultWidget != null) {
            detectActionResultWidget.d();
        }
    }

    private void j() {
        this.a = (CameraActivityWidgetParent) this.q.findViewById(R.id.abfl_widget_camera);
        this.b = (TitleBarWidget) this.q.findViewById(R.id.widget_title_bar);
        this.e = (DetectActionWidget) this.q.findViewById(R.id.widget_abfl_detectaction);
        this.f = (DetectActionResultWidget) this.q.findViewById(R.id.widget_abfl_detectactionresult);
        this.c = (GuideWidget) this.q.findViewById(R.id.widget_abfl_guide);
        this.d = (PrivacyWidget) this.q.findViewById(R.id.widget_abfl_privacy);
        this.e.setActivity(this.m);
    }

    private void k() {
        DetectActionWidget detectActionWidget = this.e;
        if (detectActionWidget != null) {
            detectActionWidget.c();
        }
        DetectActionResultWidget detectActionResultWidget = this.f;
        if (detectActionResultWidget != null) {
            detectActionResultWidget.b = 0;
        }
    }

    private void l() {
        CameraActivityWidgetParent cameraActivityWidgetParent = this.a;
        if (cameraActivityWidgetParent != null) {
            cameraActivityWidgetParent.setVisibility(0);
        }
    }

    private void m() {
        CameraActivityWidgetParent cameraActivityWidgetParent = this.a;
        if (cameraActivityWidgetParent != null) {
            cameraActivityWidgetParent.setVisibility(8);
        }
    }

    private void n() {
        DetectActionResultWidget detectActionResultWidget = this.f;
        if (detectActionResultWidget != null) {
            detectActionResultWidget.e();
        }
        DetectActionWidget detectActionWidget = this.e;
        if (detectActionWidget != null) {
            if (!(detectActionWidget.getVisibility() == 0)) {
                this.e.a(new String[0]);
            }
        }
        TitleBarWidget titleBarWidget = this.b;
        if (titleBarWidget != null) {
            titleBarWidget.setTitle(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        TitleBarWidget titleBarWidget = this.b;
        if (titleBarWidget != null) {
            titleBarWidget.a(new String[0]);
        }
    }

    private void p() {
        TitleBarWidget titleBarWidget = this.b;
        if (titleBarWidget != null) {
            titleBarWidget.e();
        }
    }

    private static void q() {
    }

    private void r() {
        this.e.h();
    }

    private static boolean s() {
        return false;
    }

    private static void t() {
    }

    public String getCurrentShowView() {
        return this.o;
    }

    public int getDetectResultErrorCode() {
        DetectActionResultWidget detectActionResultWidget = this.f;
        if (detectActionResultWidget != null) {
            return detectActionResultWidget.getDetectResultErrorCode();
        }
        return 0;
    }

    public String getmLastShowView() {
        return this.r;
    }

    public void setALBiometricsParams(ALBiometricsParams aLBiometricsParams) {
        this.n = aLBiometricsParams;
    }

    public void setOnButtonClickListener(InterfaceC3778a interfaceC3778a) {
        this.s = interfaceC3778a;
        TitleBarWidget titleBarWidget = this.b;
        if (titleBarWidget != null) {
            titleBarWidget.setOnBioMainHandlerListener(interfaceC3778a);
        }
        GuideWidget guideWidget = this.c;
        if (guideWidget != null) {
            guideWidget.setOnBioMainHandlerListener(interfaceC3778a);
        }
        PrivacyWidget privacyWidget = this.d;
        if (privacyWidget != null) {
            privacyWidget.setOnBioMainHandlerListener(interfaceC3778a);
        }
        DetectActionWidget detectActionWidget = this.e;
        if (detectActionWidget != null) {
            detectActionWidget.setOnBioMainHandlerListener(interfaceC3778a);
        }
    }

    public void setOnCloseListener(View.OnClickListener onClickListener) {
        this.b.setOnCloseListener(onClickListener);
    }

    public void setOnDetectActionResultListener(InterfaceC3740a interfaceC3740a) {
        this.f.setOnDetectActionResultListener(interfaceC3740a);
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        CameraActivityWidgetParent cameraActivityWidgetParent = this.a;
        if (cameraActivityWidgetParent != null) {
            cameraActivityWidgetParent.setRenderer(renderer);
        }
    }

    private void b(Runnable runnable) {
        DetectActionWidget detectActionWidget = this.e;
        if (detectActionWidget != null) {
            detectActionWidget.a(new AnonymousClass3(runnable));
        }
    }

    public final void c() {
        DetectActionWidget detectActionWidget = this.e;
        if (detectActionWidget == null || detectActionWidget.getVisibility() != 0) {
            return;
        }
        this.e.j();
        o();
    }

    public final void d() {
        o();
        CameraActivityWidgetParent cameraActivityWidgetParent = this.a;
        if (cameraActivityWidgetParent != null) {
            cameraActivityWidgetParent.setVisibility(0);
        }
        DetectActionResultWidget detectActionResultWidget = this.f;
        if (detectActionResultWidget != null) {
            detectActionResultWidget.e();
        }
        DetectActionWidget detectActionWidget = this.e;
        if (detectActionWidget != null) {
            if (!(detectActionWidget.getVisibility() == 0)) {
                this.e.a(new String[0]);
            }
        }
        TitleBarWidget titleBarWidget = this.b;
        if (titleBarWidget != null) {
            titleBarWidget.setTitle(null);
        }
        this.r = this.o;
        this.o = k;
    }

    public final void e() {
        DetectActionResultWidget detectActionResultWidget = this.f;
        if (detectActionResultWidget != null) {
            detectActionResultWidget.g();
        }
        this.r = this.o;
        this.o = "result";
    }

    public final boolean f() {
        return "result".equals(this.o);
    }

    public final void b() {
        DetectActionWidget detectActionWidget = this.e;
        if (detectActionWidget != null) {
            detectActionWidget.i();
            this.e.g();
            this.e.c();
        }
    }

    public final void b(String str) {
        DetectActionWidget detectActionWidget = this.e;
        if (detectActionWidget != null) {
            detectActionWidget.a(str, this.n);
        }
    }

    private void a(Runnable runnable) {
        CameraActivityWidgetParent cameraActivityWidgetParent = this.a;
        if (cameraActivityWidgetParent != null) {
            cameraActivityWidgetParent.a(runnable);
        }
    }

    private void a(boolean z) {
        RPDetectCoreView rPDetectCoreView;
        DetectActionWidget detectActionWidget = this.e;
        if (detectActionWidget == null || (rPDetectCoreView = detectActionWidget.b) == null) {
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

    public final void a(final List<DazzleCollectDataUIConfigItem> list, final InterfaceC3779a interfaceC3779a) {
        if (this.e == null || list.isEmpty()) {
            return;
        }
        o();
        final int size = list.size();
        this.e.a(list.get(0), new DetectActionWidget.InterfaceC3782a() { // from class: com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView.1
            @Override // com.alibaba.security.biometrics.logic.view.widget.DetectActionWidget.InterfaceC3782a
            public final DazzleCollectDataUIConfigItem a(int i2) {
                if (i2 >= size) {
                    interfaceC3779a.a();
                    return null;
                }
                if (i2 == 1) {
                    interfaceC3779a.b();
                }
                return (DazzleCollectDataUIConfigItem) list.get(i2);
            }
        }, 0);
    }

    public final void a(int i2, String str, String str2) {
        DetectActionResultWidget detectActionResultWidget = this.f;
        if (detectActionResultWidget != null) {
            detectActionResultWidget.a(i2, new Runnable() { // from class: com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView.2
                @Override // java.lang.Runnable
                public final void run() {
                    ALBiometricsActivityParentView.a(ALBiometricsActivityParentView.this);
                    ALBiometricsActivityParentView.this.o();
                    ALBiometricsActivityParentView.this.b();
                    ALBiometricsActivityParentView.this.e.setVisibility(8);
                    ALBiometricsActivityParentView.this.f.setVisibility(0);
                    if (ALBiometricsActivityParentView.this.d != null) {
                        ALBiometricsActivityParentView.this.d.setVisibility(8);
                    }
                    if (ALBiometricsActivityParentView.this.c != null) {
                        ALBiometricsActivityParentView.this.c.setVisibility(8);
                    }
                }
            }, this.n, str2, str);
        }
        this.r = this.o;
        this.o = "result";
    }

    public final void a(int i2, int i3) {
        if (this.a != null) {
            this.a.a(i2, i3, this.e.getMaskCircleDisplayY(), this.n.cameraPreviewSizeSwitch);
        }
    }

    public final void a(String str) {
        GuideWidget guideWidget = this.c;
        if (guideWidget != null) {
            guideWidget.a(str);
        }
        o();
        this.b.setTitle(getContext().getString(R.string.rp_guide_title));
        this.r = this.o;
        this.o = "guide";
    }

    public final void a() {
        if (this.c != null) {
            this.d.a(new String[0]);
        }
        o();
        this.b.setTitle(getContext().getString(R.string.rp_privacy_title));
        this.r = this.o;
        this.o = j;
    }

    public final void a(int i2) {
        String string;
        if (this.e != null) {
            Resources resources = getContext().getResources();
            if (i2 == -10219) {
                string = resources.getString(R.string.face_liveness_action_fail_tip_common);
            } else if (i2 == 1004) {
                string = resources.getString(R.string.face_detect_toast_too_shake);
            } else if (i2 == 1013) {
                string = resources.getString(R.string.face_detect_toast_pitch_angle_not_suitable);
            } else if (i2 == 1060) {
                string = resources.getString(R.string.face_liveness_env_too_bright);
            } else if (i2 == 1001) {
                string = resources.getString(R.string.face_detect_toast_too_dark);
            } else if (i2 != 1002) {
                switch (i2) {
                    case GlobalErrorCode.ERROR_TOUCH_TOO_MUCH_MINE_OCCLUSION /* -10215 */:
                        string = resources.getString(R.string.face_liveness_action_fail_tip_occlusion);
                        break;
                    case GlobalErrorCode.ERROR_TOUCH_TOO_MUCH_MINE_FACE /* -10214 */:
                        string = resources.getString(R.string.face_liveness_action_fail_tip_face_error);
                        break;
                    case GlobalErrorCode.ERROR_TOUCH_TOO_MUCH_MINE_ACTION /* -10213 */:
                        string = resources.getString(R.string.face_liveness_action_fail_tip_action_wrong);
                        break;
                    default:
                        switch (i2) {
                            case 1006:
                                string = resources.getString(R.string.face_detect_toast_no_dectect_action);
                                break;
                            case 1007:
                                string = resources.getString(R.string.face_detect_toast_too_close);
                                break;
                            case 1008:
                                string = resources.getString(R.string.face_detect_toast_too_far);
                                break;
                            default:
                                switch (i2) {
                                    case ALBiometricsCodes.TIP_ACTION_TOO_SMALL /* 1053 */:
                                        string = resources.getString(R.string.face_detect_toast_action_too_small);
                                        break;
                                    case ALBiometricsCodes.TIP_RAISE_PHONE /* 1054 */:
                                        string = resources.getString(R.string.face_detect_toast_raise_phone);
                                        break;
                                    case ALBiometricsCodes.TIP_FACE_LIGHT /* 1055 */:
                                        string = resources.getString(R.string.face_detect_toast_face_light);
                                        break;
                                    default:
                                        string = "";
                                        break;
                                }
                        }
                }
            } else {
                string = resources.getString(R.string.face_detect_toast_not_in_region);
            }
            this.e.f(string);
        }
    }

    public final void a(ABDetectType aBDetectType) {
        DetectActionWidget detectActionWidget = this.e;
        if (detectActionWidget != null) {
            detectActionWidget.setVisibility(0);
            this.e.a(aBDetectType, this.n);
        }
    }

    static /* synthetic */ void a(ALBiometricsActivityParentView aLBiometricsActivityParentView) {
        CameraActivityWidgetParent cameraActivityWidgetParent = aLBiometricsActivityParentView.a;
        if (cameraActivityWidgetParent != null) {
            cameraActivityWidgetParent.setVisibility(8);
        }
    }
}
