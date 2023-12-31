package com.alibaba.security.biometrics.logic.a;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import com.alibaba.security.biometrics.ALBiometricsEventListener;
import com.alibaba.security.biometrics.R;
import com.alibaba.security.biometrics.activity.BaseBioNavigatorActivity;
import com.alibaba.security.biometrics.camera.c;
import com.alibaba.security.biometrics.component.AudioSettingComponent;
import com.alibaba.security.biometrics.component.MediaSystemComponent;
import com.alibaba.security.biometrics.component.b;
import com.alibaba.security.biometrics.component.d;
import com.alibaba.security.biometrics.component.e;
import com.alibaba.security.biometrics.jni.ABJniDetectResult;
import com.alibaba.security.biometrics.jni.ALBiometricsJni;
import com.alibaba.security.biometrics.logic.model.DazzleCollectDataUIConfigItem;
import com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView;
import com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView;
import com.alibaba.security.biometrics.logic.view.widget.CameraActivityWidgetParent;
import com.alibaba.security.biometrics.logic.view.widget.DetectActionResultWidget;
import com.alibaba.security.biometrics.logic.view.widget.DetectActionWidget;
import com.alibaba.security.biometrics.logic.view.widget.GuideWidget;
import com.alibaba.security.biometrics.logic.view.widget.PrivacyWidget;
import com.alibaba.security.biometrics.logic.view.widget.TitleBarWidget;
import com.alibaba.security.biometrics.logic.view.widget.a;
import com.alibaba.security.biometrics.service.ALBiometricsService;
import com.alibaba.security.biometrics.service.ALBiometricsServiceEventListener;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.listener.OnRetryListener;
import com.alibaba.security.biometrics.service.model.ABDetectFrame;
import com.alibaba.security.biometrics.service.model.ALBiometricsType;
import com.alibaba.security.biometrics.service.model.detector.ABDetectType;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.service.model.result.ABImageResult;
import com.alibaba.security.biometrics.service.model.result.ALBiometricsResult;
import com.alibaba.security.biometrics.service.model.result.SensorInfo;
import com.alibaba.security.biometrics.service.sensor.SensorGetter;
import com.alibaba.security.biometrics.theme.ALBiometricsConfig;
import com.alibaba.security.common.d.h;
import com.alibaba.security.common.d.m;
import com.alibaba.security.common.track.a.a;
import com.alibaba.security.common.track.model.LastExitTrackMsg;
import com.alibaba.security.common.track.model.LastExitTrackMsgPage;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.common.track.model.a;
import com.uc.webview.export.media.MessageID;
import com.youku.uplayer.AliMediaPlayer;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class a implements GLSurfaceView.Renderer, com.alibaba.security.biometrics.a.a, d, ALBiometricsActivityParentView.a, ALBiometricsServiceEventListener {
    public static final int a = 1010;
    public static final String b = "model_loading_error_code";
    private static final String e = "ALBiometricsPresenter";
    private static final long f = 500;
    private com.alibaba.security.biometrics.logic.view.b.a A;
    private SurfaceTexture B;
    private com.alibaba.security.biometrics.logic.view.widget.a C;
    private List<Integer> E;
    private ABJniDetectResult F;
    private SensorGetter G;
    private SensorInfo H;
    private SensorInfo I;
    public ALBiometricsActivityParentView d;
    private final Activity g;
    private c h;
    private ALBiometricsService i;
    private ALBiometricsConfig j;
    private boolean k;
    private ALBiometricsEventListener l;
    private int m;
    private ABDetectType n;
    private int p;
    private ALBiometricsParams q;
    private String r;
    private List<DazzleCollectDataUIConfigItem> s;
    private ALBiometricsResult t;
    private boolean u;
    private String v;
    private int w;
    private long x;
    private boolean y;
    private boolean z;
    public int c = 0;
    private final Runnable o = new Runnable() { // from class: com.alibaba.security.biometrics.logic.a.a.1
        @Override // java.lang.Runnable
        public final void run() {
            if (a.this.n == null || !a.this.k) {
                return;
            }
            ((MediaSystemComponent) e.a(MediaSystemComponent.class)).a(a.this.n);
        }
    };
    private final View.OnClickListener D = new View.OnClickListener() { // from class: com.alibaba.security.biometrics.logic.a.a.6
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            a.this.a(a.this.j == null || a.this.j.isShouldAlertOnExit());
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.biometrics.logic.a.a$11  reason: invalid class name */
    /* loaded from: classes8.dex */
    public final class AnonymousClass11 implements Runnable {
        AnonymousClass11() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.this.b(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.biometrics.logic.a.a$12  reason: invalid class name */
    /* loaded from: classes8.dex */
    public final class AnonymousClass12 implements Runnable {
        AnonymousClass12() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.f();
        }
    }

    public a(Activity activity) {
        this.g = activity;
    }

    private void A() {
        String string = this.g.getResources().getString(R.string.face_detect_action_mirror);
        ALBiometricsActivityParentView aLBiometricsActivityParentView = this.d;
        if (aLBiometricsActivityParentView != null) {
            aLBiometricsActivityParentView.b(string);
        }
    }

    private boolean B() {
        com.alibaba.security.biometrics.logic.view.widget.a aVar = this.C;
        return aVar != null && aVar.a();
    }

    private void C() {
        if (M()) {
            this.q.timeout = 12;
        } else {
            this.q.timeout = 40;
        }
    }

    private static DazzleCollectDataUIConfigItem D() {
        DazzleCollectDataUIConfigItem dazzleCollectDataUIConfigItem = new DazzleCollectDataUIConfigItem();
        dazzleCollectDataUIConfigItem.setTitle("检测中···");
        dazzleCollectDataUIConfigItem.setScreenLight(1.0f);
        dazzleCollectDataUIConfigItem.setColor("#FFFFFF");
        dazzleCollectDataUIConfigItem.setTextColor("#333333");
        dazzleCollectDataUIConfigItem.setDuration(1.0f);
        return dazzleCollectDataUIConfigItem;
    }

    private static List<DazzleCollectDataUIConfigItem> E() {
        ArrayList arrayList = new ArrayList();
        DazzleCollectDataUIConfigItem dazzleCollectDataUIConfigItem = new DazzleCollectDataUIConfigItem();
        dazzleCollectDataUIConfigItem.setTitle("即将进行闪屏检测，请正脸看向屏幕");
        dazzleCollectDataUIConfigItem.setScreenLight(0.1f);
        dazzleCollectDataUIConfigItem.setColor("#FFFFFF");
        dazzleCollectDataUIConfigItem.setDuration(1.0f);
        arrayList.add(dazzleCollectDataUIConfigItem);
        DazzleCollectDataUIConfigItem dazzleCollectDataUIConfigItem2 = new DazzleCollectDataUIConfigItem();
        dazzleCollectDataUIConfigItem2.setTitle("即将进行闪屏检测，请保持姿势不变");
        dazzleCollectDataUIConfigItem2.setScreenLight(0.2f);
        dazzleCollectDataUIConfigItem2.setColor("#000000");
        dazzleCollectDataUIConfigItem2.setDuration(1.0f);
        arrayList.add(dazzleCollectDataUIConfigItem2);
        DazzleCollectDataUIConfigItem dazzleCollectDataUIConfigItem3 = new DazzleCollectDataUIConfigItem();
        dazzleCollectDataUIConfigItem3.setTitle("即将进行闪屏检测，请保持姿势不变");
        dazzleCollectDataUIConfigItem3.setScreenLight(1.0f);
        dazzleCollectDataUIConfigItem3.setColor("#ADFF2F");
        dazzleCollectDataUIConfigItem3.setDuration(1.0f);
        arrayList.add(dazzleCollectDataUIConfigItem3);
        DazzleCollectDataUIConfigItem dazzleCollectDataUIConfigItem4 = new DazzleCollectDataUIConfigItem();
        dazzleCollectDataUIConfigItem4.setTitle("即将进行闪屏检测，请保持姿势不变");
        dazzleCollectDataUIConfigItem4.setScreenLight(0.5f);
        dazzleCollectDataUIConfigItem4.setColor("#000000");
        dazzleCollectDataUIConfigItem4.setDuration(1.0f);
        arrayList.add(dazzleCollectDataUIConfigItem4);
        DazzleCollectDataUIConfigItem dazzleCollectDataUIConfigItem5 = new DazzleCollectDataUIConfigItem();
        dazzleCollectDataUIConfigItem5.setTitle("即将进行闪屏检测，请保持姿势不变");
        dazzleCollectDataUIConfigItem5.setScreenLight(0.5f);
        dazzleCollectDataUIConfigItem5.setColor("#ADFF2F");
        dazzleCollectDataUIConfigItem5.setDuration(1.0f);
        arrayList.add(dazzleCollectDataUIConfigItem5);
        return arrayList;
    }

    private void F() {
        ALBiometricsEventListener aLBiometricsEventListener = this.l;
        if (aLBiometricsEventListener != null) {
            aLBiometricsEventListener.onBusinessOk();
        }
    }

    private void G() {
        ((BaseBioNavigatorActivity) this.g).a(this.o);
        ((BaseBioNavigatorActivity) this.g).b(this.o);
    }

    private void H() {
        ((MediaSystemComponent) e.a(MediaSystemComponent.class)).d();
        ((BaseBioNavigatorActivity) this.g).a(this.o);
    }

    private void I() {
        this.m = 8;
        Activity activity = this.g;
        if (activity != null) {
            activity.finish();
        }
    }

    private void J() {
        h();
    }

    private void K() {
        H();
        ALBiometricsService aLBiometricsService = this.i;
        if (aLBiometricsService != null) {
            aLBiometricsService.release();
        }
    }

    private boolean L() {
        ALBiometricsParams aLBiometricsParams;
        if (M() || (aLBiometricsParams = this.q) == null) {
            return false;
        }
        return aLBiometricsParams.needSuccessVideo || aLBiometricsParams.needFailVideo;
    }

    private boolean M() {
        return ALBiometricsType.isDazzle(this.q.mBiometricsType);
    }

    private static String N() {
        byte[] makeResult = ALBiometricsJni.makeResult(((b) e.a(b.class)).f());
        if (makeResult == null) {
            return null;
        }
        Q();
        return com.alibaba.security.common.d.a.a(makeResult);
    }

    private static void O() {
        ((b) e.a(b.class)).d();
    }

    private static void P() {
        ((b) e.a(b.class)).e();
    }

    private static void Q() {
        ((b) e.a(b.class)).g();
    }

    private static int a(int i) {
        return (i < 4000 || i >= 5000) ? i : GlobalErrorCode.ERROR_CTID;
    }

    static /* synthetic */ int g(a aVar) {
        aVar.m = 2;
        return 2;
    }

    static /* synthetic */ boolean l(a aVar) {
        aVar.u = false;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        onCancel(q());
        c();
        I();
    }

    private int q() {
        ALBiometricsActivityParentView aLBiometricsActivityParentView = this.d;
        if (aLBiometricsActivityParentView == null || !aLBiometricsActivityParentView.f()) {
            return -1;
        }
        return this.d.getDetectResultErrorCode();
    }

    private boolean r() {
        return q() == 0;
    }

    private LastExitTrackMsg s() {
        if (this.d != null) {
            LastExitTrackMsg lastExitTrackMsg = new LastExitTrackMsg();
            lastExitTrackMsg.setPage(LastExitTrackMsgPage.BIO.getMsg());
            lastExitTrackMsg.setView(this.d.getCurrentShowView());
            HashMap hashMap = new HashMap();
            hashMap.put("step", Integer.valueOf(this.m));
            hashMap.put("errorCode", Integer.valueOf(this.p));
            hashMap.put("retryCounts", Integer.valueOf(this.c));
            lastExitTrackMsg.setParams(h.a((Object) h.a((Object) hashMap)));
            return lastExitTrackMsg;
        }
        return null;
    }

    private String t() {
        HashMap hashMap = new HashMap();
        hashMap.put("step", Integer.valueOf(this.m));
        hashMap.put("errorCode", Integer.valueOf(this.p));
        hashMap.put("retryCounts", Integer.valueOf(this.c));
        return h.a((Object) hashMap);
    }

    private void u() {
        b(false);
    }

    private boolean v() {
        int i = this.p;
        return i == -99999 || i == 0;
    }

    private void w() {
        c("view");
        this.d.a();
    }

    private void x() {
        c cVar = this.h;
        if (cVar == null) {
            return;
        }
        onLogTrack(TrackLog.createStartCameraParametersLog(cVar.m()));
    }

    private void y() {
        c cVar = this.h;
        if (cVar == null) {
            return;
        }
        onLogTrack(TrackLog.createFinishCameraParametersLog(cVar.n()));
    }

    private void z() {
        if (!m.a(this.g, "android.permission.CAMERA")) {
            m.a(this.g, new String[]{"android.permission.CAMERA"}, 1010, "人脸识别服务需要您授权相机权限", new AnonymousClass11(), new AnonymousClass12());
        } else {
            b(false);
        }
    }

    @Override // com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView.a
    public final void e() {
        this.z = false;
        c("startClick");
        b(false);
    }

    @Override // com.alibaba.security.biometrics.jni.listener.OnSgProcessListener
    public final String getAppKey() {
        ALBiometricsEventListener aLBiometricsEventListener = this.l;
        if (aLBiometricsEventListener != null) {
            return aLBiometricsEventListener.getAppKey();
        }
        return null;
    }

    @Override // com.alibaba.security.biometrics.service.model.ALBiometricsEvents.OnActionEndListener
    public final void onActionEnd(ABDetectType aBDetectType, int i, int i2) {
        ALBiometricsActivityParentView aLBiometricsActivityParentView;
        HashMap hashMap = new HashMap();
        hashMap.put("index", Integer.valueOf(i));
        hashMap.put("actionType", h.a(aBDetectType));
        ALBiometricsJni.bhL(13, h.a((Object) hashMap));
        onLogTrack(a("finishAction", aBDetectType.getValue(), i));
        if (aBDetectType == ABDetectType.AIMLESS || (aLBiometricsActivityParentView = this.d) == null) {
            return;
        }
        aLBiometricsActivityParentView.b();
    }

    @Override // com.alibaba.security.biometrics.service.model.ALBiometricsEvents.OnActionStartListener
    public final void onActionStart(ABDetectType aBDetectType, int i, int i2) {
        this.m = 4;
        this.n = aBDetectType;
        HashMap hashMap = new HashMap();
        hashMap.put("index", Integer.valueOf(i));
        hashMap.put("actionType", h.a(aBDetectType));
        ALBiometricsJni.bhL(12, h.a((Object) hashMap));
        onLogTrack(a("startAction", aBDetectType.getValue(), i));
        a(aBDetectType);
    }

    @Override // com.alibaba.security.biometrics.service.model.ALBiometricsEvents.OnAdjustEndListener
    public final void onAdjustEnd() {
        ALBiometricsJni.bhL(11, "");
        onLogTrack(d("didAdjust"));
    }

    @Override // com.alibaba.security.biometrics.service.model.ALBiometricsEvents.OnAdjustStartListener
    public final void onAdjustStart() {
        this.m = 3;
        ALBiometricsJni.bhL(10, "");
        onLogTrack(d("willAdjust"));
        A();
    }

    @Override // com.alibaba.security.biometrics.service.model.ALBiometricsEvents.OnBeforeRetryListener
    public final void onBeforeRetry(OnRetryListener onRetryListener, String str) {
        ALBiometricsEventListener aLBiometricsEventListener = this.l;
        if (aLBiometricsEventListener != null) {
            aLBiometricsEventListener.onBeforeRetry(onRetryListener, str, N());
        }
    }

    @Override // com.alibaba.security.biometrics.service.model.ALBiometricsEvents.OnCancelListener
    public final void onCancel(int i) {
        LastExitTrackMsg lastExitTrackMsg;
        if (this.d != null) {
            lastExitTrackMsg = new LastExitTrackMsg();
            lastExitTrackMsg.setPage(LastExitTrackMsgPage.BIO.getMsg());
            lastExitTrackMsg.setView(this.d.getCurrentShowView());
            HashMap hashMap = new HashMap();
            hashMap.put("step", Integer.valueOf(this.m));
            hashMap.put("errorCode", Integer.valueOf(this.p));
            hashMap.put("retryCounts", Integer.valueOf(this.c));
            lastExitTrackMsg.setParams(h.a((Object) h.a((Object) hashMap)));
        } else {
            lastExitTrackMsg = null;
        }
        a.C0165a.a.a = lastExitTrackMsg;
        HashMap hashMap2 = new HashMap();
        hashMap2.put("errorCode", Integer.valueOf(i));
        ALBiometricsJni.bhL(21, h.a((Object) hashMap2));
        if (this.l != null) {
            this.l.onCancel(i, com.alibaba.security.common.d.a.a(ALBiometricsJni.dumpBeh(true)), N());
        }
    }

    @Override // com.alibaba.security.biometrics.service.model.ALBiometricsEvents.OnDetectContinueListener
    public final void onDetectContinue(ABImageResult aBImageResult) {
    }

    @Override // com.alibaba.security.biometrics.service.model.ALBiometricsEvents.OnDetectStartListener
    public final void onDetectStart() {
        if (L()) {
            f("开始录制活体视频");
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onDrawFrame(GL10 gl10) {
        this.A.onDrawFrame(gl10);
    }

    @Override // com.alibaba.security.biometrics.service.model.ALBiometricsEvents.OnFinishListener
    public final void onFinish(int i, final Bundle bundle) {
        final ALBiometricsResult aLBiometricsResult = (ALBiometricsResult) bundle.getSerializable(ALBiometricsKeys.KEY_RESULT_DATA);
        if (bundle.containsKey(ALBiometricsKeys.KEY_RESULT_LOG_DATA)) {
            Bundle bundle2 = bundle.getBundle(ALBiometricsKeys.KEY_RESULT_LOG_DATA);
            if (bundle2 != null) {
                bundle2.putInt("time_show_nav", this.q.stepNav ? 1 : 0);
            }
            onOldLogRecord(bundle2);
        }
        this.p = i;
        this.t = aLBiometricsResult;
        if (i == 0) {
            ALBiometricsJni.bhL(18, h.a(this.F));
            if (L()) {
                a(new com.alibaba.security.common.e.b() { // from class: com.alibaba.security.biometrics.logic.a.a.2
                    @Override // com.alibaba.security.common.e.b
                    public final void onFinish(String str, int i2) {
                        aLBiometricsResult.setVideoS(str);
                        a.this.a(aLBiometricsResult);
                    }
                }, false, "算法检测成功,停止录制活体视频");
            } else {
                a(aLBiometricsResult);
            }
        } else if (L()) {
            a(new com.alibaba.security.common.e.b() { // from class: com.alibaba.security.biometrics.logic.a.a.3
                @Override // com.alibaba.security.common.e.b
                public final void onFinish(String str, int i2) {
                    aLBiometricsResult.setVideoF(str);
                    a.this.a(bundle.getInt(ALBiometricsKeys.KEY_ERROR_CODE), bundle);
                }
            }, false, "算法检测失败，停止录制活体视频");
        } else {
            a(bundle.getInt(ALBiometricsKeys.KEY_ERROR_CODE), bundle);
        }
    }

    @Override // com.alibaba.security.biometrics.service.model.ALBiometricsEvents.OnFrameDetectedListener
    public final void onFrameDetected(ABDetectFrame aBDetectFrame) {
        RPDetectCoreView rPDetectCoreView;
        if (aBDetectFrame == null || this.d == null || !this.k) {
            return;
        }
        this.F = aBDetectFrame.getDetectResult();
        if (System.currentTimeMillis() - this.x < 500) {
            return;
        }
        this.x = System.currentTimeMillis();
        ALBiometricsActivityParentView aLBiometricsActivityParentView = this.d;
        boolean hasFace = aBDetectFrame.hasFace();
        DetectActionWidget detectActionWidget = aLBiometricsActivityParentView.e;
        if (detectActionWidget != null && (rPDetectCoreView = detectActionWidget.b) != null) {
            if (hasFace) {
                rPDetectCoreView.a();
            } else {
                if (rPDetectCoreView.g == null) {
                    ValueAnimator duration = ValueAnimator.ofInt(100, 0).setDuration(1000L);
                    rPDetectCoreView.g = duration;
                    duration.setRepeatCount(-1);
                    rPDetectCoreView.g.addUpdateListener(new RPDetectCoreView.AnonymousClass1());
                    rPDetectCoreView.g.start();
                }
                rPDetectCoreView.invalidate();
            }
        }
        if (!aBDetectFrame.hasFace()) {
            this.d.a(1002);
        }
        if (M()) {
            com.alibaba.security.biometrics.logic.view.widget.a aVar = this.C;
            if (aVar != null && aVar.a()) {
                return;
            }
            if (aBDetectFrame.hasFace() && !this.u) {
                i(true);
            }
            if (!aBDetectFrame.hasFace()) {
                e("人脸不在框内");
            }
        }
        this.l.onFrameResult(aBDetectFrame.getFaceImage(), aBDetectFrame.getImageWidth(), aBDetectFrame.getImageHeight());
    }

    @Override // com.alibaba.security.biometrics.service.listener.OnLogTrackListener
    public final void onLogTrack(TrackLog trackLog) {
        ALBiometricsEventListener aLBiometricsEventListener = this.l;
        if (aLBiometricsEventListener != null) {
            aLBiometricsEventListener.onLogTrack(trackLog);
        }
    }

    @Override // com.alibaba.security.biometrics.service.model.ALBiometricsEvents.OnMessageListener
    public final void onMessage(int i, Bundle bundle) {
        if (!this.k || this.d == null) {
            return;
        }
        if (i == -10213 || i == -10214 || i == -10215 || i == -10219) {
            onLogTrack(TrackLog.createBioMonitorExpLog(i, bundle != null ? bundle.getString(ALBiometricsKeys.KEY_ERROR_MESSAGE, "") : ""));
        }
        if (M()) {
            return;
        }
        this.d.a(i);
    }

    @Override // com.alibaba.security.biometrics.service.listener.OnLogTrackListener
    public final void onOldLogRecord(Bundle bundle) {
        try {
            com.alibaba.security.biometrics.c.b.a.b().a().putAll(bundle);
        } catch (Exception unused) {
        }
        ALBiometricsEventListener aLBiometricsEventListener = this.l;
        if (aLBiometricsEventListener != null) {
            aLBiometricsEventListener.onOldLogRecord(bundle);
        }
    }

    @Override // com.alibaba.security.biometrics.service.model.ALBiometricsEvents.OnRecognizeEndListener
    public final void onRecognizeEnd() {
    }

    @Override // com.alibaba.security.biometrics.service.model.ALBiometricsEvents.OnRecognizeStartListener
    public final void onRecognizeStart() {
    }

    @Override // com.alibaba.security.biometrics.service.model.ALBiometricsEvents.OnReflectEndListener
    public final void onReflectEnd() {
    }

    @Override // com.alibaba.security.biometrics.service.model.ALBiometricsEvents.OnReflectStartListener
    public final void onReflectStart() {
        this.m = 5;
        com.alibaba.security.common.d.d.a(this.g, (int) AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_FIXED_GEAR_INDEX);
        ALBiometricsActivityParentView aLBiometricsActivityParentView = this.d;
        if (aLBiometricsActivityParentView != null) {
            aLBiometricsActivityParentView.c();
        }
    }

    @Override // com.alibaba.security.biometrics.service.listener.OnSensorTrackListener
    public final void onSensorReset() {
        ALBiometricsEventListener aLBiometricsEventListener = this.l;
        if (aLBiometricsEventListener != null) {
            aLBiometricsEventListener.onSensorReset();
        }
    }

    @Override // com.alibaba.security.biometrics.service.listener.OnSensorTrackListener
    public final void onSensorStart() {
        ALBiometricsEventListener aLBiometricsEventListener = this.l;
        if (aLBiometricsEventListener != null) {
            aLBiometricsEventListener.onSensorStart();
        }
    }

    @Override // com.alibaba.security.biometrics.service.listener.OnSensorTrackListener
    public final void onSensorStop() {
        ALBiometricsEventListener aLBiometricsEventListener = this.l;
        if (aLBiometricsEventListener != null) {
            aLBiometricsEventListener.onSensorStop();
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceChanged(GL10 gl10, int i, int i2) {
        this.A.onSurfaceChanged(gl10, i, i2);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        this.A.onSurfaceCreated(gl10, eGLConfig);
        SurfaceTexture surfaceTexture = this.A.c;
        this.B = surfaceTexture;
        this.h.a(surfaceTexture);
        this.B.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: com.alibaba.security.biometrics.logic.a.a.13
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                CameraActivityWidgetParent cameraActivityWidgetParent = a.this.d.a;
                if (cameraActivityWidgetParent != null) {
                    cameraActivityWidgetParent.a();
                }
            }
        });
    }

    @Override // com.alibaba.security.biometrics.jni.listener.OnSgProcessListener
    public final String sign(String str) {
        ALBiometricsEventListener aLBiometricsEventListener = this.l;
        if (aLBiometricsEventListener != null) {
            return aLBiometricsEventListener.sign(str);
        }
        return null;
    }

    private void c(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("actionType", str);
        onLogTrack(TrackLog.createBioPrivacyPageLog(h.a((Map) hashMap)));
    }

    public static void f() {
        ((com.alibaba.security.biometrics.logic.a) e.a(com.alibaba.security.biometrics.logic.a.class)).a(GlobalErrorCode.ERROR_DEVICE_CAMERA_NO_PERMISSION, "CameraPermissionComponent ERROR_DEVICE_CAMERA_NO_PERMISSION", null);
    }

    private void h(boolean z) {
        this.E.remove((Object) 2);
        if (this.r == null) {
            com.alibaba.security.common.c.a.d(e, "mDazzleBizConfig is null");
            return;
        }
        com.alibaba.security.common.d.d.a(this.g, 255);
        List<DazzleCollectDataUIConfigItem> a2 = h.a(this.r, DazzleCollectDataUIConfigItem.class);
        if (a2 == null) {
            com.alibaba.security.common.c.a.d(e, "mDazzleBizConfig is not json:\n" + this.r);
            return;
        }
        for (DazzleCollectDataUIConfigItem dazzleCollectDataUIConfigItem : a2) {
            dazzleCollectDataUIConfigItem.setTitle("检测中···");
        }
        this.s = a2;
        this.q.mBiometricsType = 2;
        C();
        j(z);
        i(false);
    }

    private void i() {
        ALBiometricsEventListener aLBiometricsEventListener = this.l;
        if (aLBiometricsEventListener != null) {
            aLBiometricsEventListener.onSensorStart();
        }
    }

    private void j() {
        ALBiometricsEventListener aLBiometricsEventListener = this.l;
        if (aLBiometricsEventListener != null) {
            aLBiometricsEventListener.onSensorStop();
        }
    }

    private void k() {
        ALBiometricsEventListener aLBiometricsEventListener = this.l;
        if (aLBiometricsEventListener != null) {
            aLBiometricsEventListener.onSensorReset();
        }
    }

    private void l() {
        ALBiometricsActivityParentView aLBiometricsActivityParentView = this.d;
        if (aLBiometricsActivityParentView != null) {
            aLBiometricsActivityParentView.e();
        }
    }

    private void m() {
        int i = this.c + 1;
        this.c = i;
        ALBiometricsParams aLBiometricsParams = this.q;
        if (i > aLBiometricsParams.retryThreshold) {
            a(GlobalErrorCode.ERROR_USER_RETRY_LIMITED, ALBiometricsKeys.KEY_RETRY_THRESHOLD, (String) null);
            return;
        }
        ALBiometricsService aLBiometricsService = this.i;
        if (aLBiometricsService != null) {
            aLBiometricsService.setParams(aLBiometricsParams);
        }
        ALBiometricsJni.bhL(20, "");
        ALBiometricsEventListener aLBiometricsEventListener = this.l;
        if (aLBiometricsEventListener != null) {
            aLBiometricsEventListener.onSensorReset();
        }
        n();
        b(true);
        Q();
        ((b) e.a(b.class)).d();
    }

    private void n() {
        if (this.q.bioSteps != null) {
            this.E = new ArrayList(this.q.bioSteps);
        }
        if (this.E == null) {
            this.E = new ArrayList();
        }
        if (this.E.isEmpty()) {
            this.E.add(1);
        }
    }

    private void o() {
        this.c = 0;
    }

    @Override // com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView.a
    public final void d() {
        this.y = false;
        b("startClick");
        b(false);
    }

    @Override // com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView.a
    public final void g() {
        if (this.k && !M()) {
            int i = this.m;
            if (i == 3) {
                A();
            } else if (i == 4) {
                a(this.n);
            }
        }
    }

    private void b(ALBiometricsActivityParentView aLBiometricsActivityParentView) {
        aLBiometricsActivityParentView.setOnButtonClickListener(this);
        aLBiometricsActivityParentView.setOnCloseListener(this.D);
        aLBiometricsActivityParentView.setOnDetectActionResultListener(this);
        aLBiometricsActivityParentView.setRenderer(this);
    }

    private void f(boolean z) {
        if (this.E.size() == 1 && this.E.contains(2)) {
            ALBiometricsParams aLBiometricsParams = this.q;
            aLBiometricsParams.actionCount = 0;
            aLBiometricsParams.stepAdjust = true;
            this.E.add(0, 1);
        }
        if (this.E.indexOf(2) == 0 && this.r != null) {
            h(z);
        } else {
            g(z);
        }
    }

    private void e(boolean z) {
        if (this.k) {
            return;
        }
        this.k = true;
        this.p = GlobalErrorCode.INIT;
        ALBiometricsEventListener aLBiometricsEventListener = this.l;
        if (aLBiometricsEventListener != null) {
            aLBiometricsEventListener.onSensorStart();
        }
        this.d.d();
        Point g = this.h.g();
        if (g == null) {
            com.alibaba.security.common.c.a.d(e, "getCameraPreviewSize is null");
            return;
        }
        this.d.a(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(g), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(g));
        this.m = 1;
        ALBiometricsJni.bhL(2, this.h.f());
        if (this.E.size() == 1 && this.E.contains(2)) {
            ALBiometricsParams aLBiometricsParams = this.q;
            aLBiometricsParams.actionCount = 0;
            aLBiometricsParams.stepAdjust = true;
            this.E.add(0, 1);
        }
        if (this.E.indexOf(2) == 0 && this.r != null) {
            h(z);
        } else {
            g(z);
        }
    }

    private void i(boolean z) {
        if (this.s == null || this.u) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.s);
        arrayList.add(0, D());
        if (z) {
            this.c++;
        }
        if (this.c > this.q.retryThreshold) {
            a(GlobalErrorCode.ERROR_USER_RETRY_LIMITED, "dazzle retryThreshold", (String) null);
            return;
        }
        onLogTrack(TrackLog.startShowDazzleView(h.a(this.s), h.a(arrayList), "开始炫彩闪屏"));
        this.u = true;
        H();
        this.i.resetBioTimeOut(12);
        this.H = new SensorInfo(this.G.getCurrentLightValue(), this.G.getProximityValue());
        this.d.a(arrayList, new com.alibaba.security.biometrics.logic.view.a.a() { // from class: com.alibaba.security.biometrics.logic.a.a.4
            @Override // com.alibaba.security.biometrics.logic.view.a.a
            public final void a() {
                a aVar = a.this;
                aVar.I = new SensorInfo(aVar.G.getCurrentLightValue(), a.this.G.getProximityValue());
                a.l(a.this);
                a.this.a(new com.alibaba.security.common.e.b() { // from class: com.alibaba.security.biometrics.logic.a.a.4.1
                    @Override // com.alibaba.security.common.e.b
                    public final void onFinish(String str, int i) {
                        a.this.v = str;
                        a.this.w = i;
                        a aVar2 = a.this;
                        aVar2.a(aVar2.t);
                        try {
                            a.this.onLogTrack(TrackLog.dazzleFailedTrack("finish record", String.valueOf(new File(a.this.v).length() / 1024), System.currentTimeMillis()));
                        } catch (Exception unused) {
                        }
                    }
                }, false, "停止录制并保存炫彩视频-炫彩闪屏结束");
            }

            @Override // com.alibaba.security.biometrics.logic.view.a.a
            public final void b() {
                a.this.f("开始录制炫彩视频");
            }

            @Override // com.alibaba.security.biometrics.logic.view.a.a
            public final void c() {
            }
        });
    }

    private void j(boolean z) {
        ALBiometricsService aLBiometricsService = new ALBiometricsService(this.g, this.q, this);
        this.i = aLBiometricsService;
        if (z) {
            aLBiometricsService.restart();
        } else {
            aLBiometricsService.start();
        }
    }

    private void d(final boolean z) {
        ALBiometricsParams aLBiometricsParams = this.q;
        if (aLBiometricsParams.reachBusinessRetryLimit) {
            a(GlobalErrorCode.ERROR_USER_RETRY_LIMITED, "reachBusinessRetryLimit", (String) null);
            return;
        }
        int i = aLBiometricsParams.ctidResultCode;
        if (i != -2 && i != 0) {
            a(i, "Error on CTID auth, code: ".concat(String.valueOf(i)), (String) null);
        } else if (this.y) {
            b("view");
            this.d.a(this.q.userName);
        } else if (this.z) {
            c("view");
            this.d.a();
        } else {
            this.h.a(new c.a() { // from class: com.alibaba.security.biometrics.logic.a.a.9
                @Override // com.alibaba.security.biometrics.camera.c.a
                public final void a(int i2, String str) {
                    a.this.a(i2, str, (String) null);
                    a.e(a.this);
                }

                @Override // com.alibaba.security.biometrics.camera.c.a
                public final void a() {
                    a.a(a.this, z);
                    a.e(a.this);
                }

                @Override // com.alibaba.security.biometrics.camera.c.a
                public final void a(byte[] bArr, int i2, int i3, int i4) {
                    if (a.this.m == 1) {
                        a.g(a.this);
                    }
                    if (a.this.i != null) {
                        a.this.i.process(bArr, i2, i3, i4);
                    }
                }
            });
            SurfaceTexture surfaceTexture = this.B;
            if (surfaceTexture != null) {
                this.h.a(surfaceTexture);
            }
            ALBiometricsActivityParentView aLBiometricsActivityParentView = this.d;
            Runnable runnable = new Runnable() { // from class: com.alibaba.security.biometrics.logic.a.a.10
                @Override // java.lang.Runnable
                public final void run() {
                    if (a.this.h.k()) {
                        a.a(a.this, z);
                    }
                }
            };
            DetectActionWidget detectActionWidget = aLBiometricsActivityParentView.e;
            if (detectActionWidget != null) {
                detectActionWidget.a(new ALBiometricsActivityParentView.AnonymousClass3(runnable));
            }
        }
    }

    @Override // com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView.a
    public final void c(boolean z) {
        try {
            int i = 1;
            ((MediaSystemComponent) e.a(MediaSystemComponent.class)).a(!z);
            int d = ((AudioSettingComponent) e.a(AudioSettingComponent.class)).d();
            if (z) {
                boolean z2 = d == 0;
                ((AudioSettingComponent) e.a(AudioSettingComponent.class)).d = z2;
                if (z2) {
                    try {
                        ((AudioSettingComponent) e.a(AudioSettingComponent.class)).e.setRingerMode(2);
                    } catch (Throwable unused) {
                    }
                }
            }
            HashMap hashMap = new HashMap();
            if (!z) {
                i = 0;
            }
            hashMap.put("isOn", Integer.valueOf(i));
            onLogTrack(TrackLog.createSoundClickLog(h.a((Map) hashMap)));
        } catch (Throwable unused2) {
        }
    }

    private void b(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("actionType", str);
        onLogTrack(TrackLog.createBioGuidePageLog(h.a((Map) hashMap)));
    }

    private void g(boolean z) {
        com.alibaba.security.common.d.d.a(this.g, 255);
        this.E.remove((Object) 1);
        this.q.mBiometricsType = 1;
        j(z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0059, code lost:
        if (android.text.TextUtils.isEmpty(r2) == false) goto L11;
     */
    @Override // com.alibaba.security.biometrics.component.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(android.app.Activity r2, com.alibaba.security.biometrics.service.model.params.ALBiometricsParams r3, com.alibaba.security.biometrics.theme.ALBiometricsConfig r4, com.alibaba.security.biometrics.ALBiometricsEventListener r5) {
        /*
            r1 = this;
            r1.l = r5
            r1.q = r3
            r1.j = r4
            com.alibaba.security.biometrics.camera.b r4 = new com.alibaba.security.biometrics.camera.b
            r4.<init>(r2, r3)
            r1.h = r4
            com.alibaba.security.biometrics.logic.view.b.a r4 = new com.alibaba.security.biometrics.logic.view.b.a
            com.alibaba.security.biometrics.camera.c r5 = r1.h
            com.alibaba.security.biometrics.service.model.params.ALBiometricsParams r0 = r1.q
            r4.<init>(r2, r5, r0)
            r1.A = r4
            r2 = 0
            r1.m = r2
            r2 = -99999(0xfffffffffffe7961, float:NaN)
            r1.p = r2
            com.alibaba.security.biometrics.service.model.params.ALBiometricsParams r2 = r1.q
            boolean r4 = r2.stepNav
            r1.y = r4
            boolean r2 = r2.stepPrivacy
            r1.z = r2
            r1.C()
            r1.n()
            java.util.List<java.lang.Integer> r2 = r1.E
            r4 = 2
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            boolean r2 = r2.contains(r4)
            if (r2 == 0) goto L5c
            java.lang.String r2 = r3.bizConf
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 18
            if (r3 < r4) goto L5c
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L5c
            byte[] r2 = com.alibaba.security.common.d.a.a(r2)
            if (r2 == 0) goto L5c
            java.lang.String r2 = com.alibaba.security.biometrics.jni.ALBiometricsJni.dp(r2)
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L5c
            goto L5d
        L5c:
            r2 = 0
        L5d:
            r1.r = r2
            com.alibaba.security.biometrics.service.sensor.SensorGetter r2 = com.alibaba.security.biometrics.service.sensor.SensorGetter.getDefault()
            r1.G = r2
            r2.start()
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.biometrics.logic.a.a.a(android.app.Activity, com.alibaba.security.biometrics.service.model.params.ALBiometricsParams, com.alibaba.security.biometrics.theme.ALBiometricsConfig, com.alibaba.security.biometrics.ALBiometricsEventListener):boolean");
    }

    @Override // com.alibaba.security.biometrics.component.d
    public final boolean b() {
        int i = this.m;
        if (i != 0 && i != 6 && i != 7 && i != 8) {
            a(GlobalErrorCode.ERROR_DETECT_INTERRUPT, MessageID.onPause, (String) null);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        this.h.l();
        com.alibaba.security.common.c.a.a(e, str + "\ttime:" + (System.currentTimeMillis() - currentTimeMillis));
        onLogTrack(TrackLog.startRecordVideo(str, Log.getStackTraceString(new Throwable()), String.valueOf(this.h.j()), System.currentTimeMillis() - currentTimeMillis));
    }

    public final void b(boolean z) {
        if (m.a(this.g, "android.permission.CAMERA")) {
            d(z);
        }
    }

    private static TrackLog b(int i, String str) {
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer(a.C0166a.a);
        trackLog.setService(a.c.e);
        trackLog.setMethod(a.b.J);
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(i));
        hashMap.put(com.alibaba.security.realidentity.jsbridge.a.af, str);
        trackLog.setParams(h.a((Map) hashMap));
        return trackLog;
    }

    public final void h() {
        K();
        if (this.h.k()) {
            y();
            this.h.d();
        }
        this.k = false;
    }

    @Override // com.alibaba.security.biometrics.component.d
    public final boolean c() {
        Dialog dialog;
        this.k = false;
        this.c = 0;
        h();
        ALBiometricsActivityParentView aLBiometricsActivityParentView = this.d;
        if (aLBiometricsActivityParentView != null) {
            DetectActionWidget detectActionWidget = aLBiometricsActivityParentView.e;
            if (detectActionWidget != null) {
                detectActionWidget.c();
            }
            DetectActionResultWidget detectActionResultWidget = aLBiometricsActivityParentView.f;
            if (detectActionResultWidget != null) {
                detectActionResultWidget.b = 0;
            }
        }
        ALBiometricsService aLBiometricsService = this.i;
        if (aLBiometricsService != null) {
            aLBiometricsService.release();
        }
        com.alibaba.security.biometrics.logic.view.widget.a aVar = this.C;
        if (aVar != null && aVar.a() && (dialog = this.C.a) != null) {
            dialog.dismiss();
        }
        ALBiometricsActivityParentView aLBiometricsActivityParentView2 = this.d;
        if (aLBiometricsActivityParentView2 != null) {
            Runnable runnable = new Runnable() { // from class: com.alibaba.security.biometrics.logic.a.a.5
                @Override // java.lang.Runnable
                public final void run() {
                    if (a.this.A != null) {
                        com.alibaba.security.biometrics.logic.view.b.a aVar2 = a.this.A;
                        SurfaceTexture surfaceTexture = aVar2.c;
                        if (surfaceTexture != null) {
                            surfaceTexture.release();
                            aVar2.c = null;
                        }
                        aVar2.a = -1;
                        com.alibaba.security.common.a.a aVar3 = aVar2.b;
                        if (aVar3 != null) {
                            aVar3.a();
                        }
                    }
                }
            };
            CameraActivityWidgetParent cameraActivityWidgetParent = aLBiometricsActivityParentView2.a;
            if (cameraActivityWidgetParent != null) {
                cameraActivityWidgetParent.a(runnable);
            }
        }
        ALBiometricsEventListener aLBiometricsEventListener = this.l;
        if (aLBiometricsEventListener != null) {
            aLBiometricsEventListener.onBiometricsFinish(this.p);
        }
        this.G.stop();
        return true;
    }

    private static TrackLog d(String str) {
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer(a.C0166a.a);
        trackLog.setService(a.c.e);
        trackLog.setMethod(a.b.I);
        HashMap hashMap = new HashMap();
        hashMap.put("action", str);
        trackLog.setParams(h.a((Map) hashMap));
        return trackLog;
    }

    private void e(String str) {
        if (this.u) {
            onLogTrack(TrackLog.stopShowDazzleView("停止炫彩闪屏", h.a(this.s)));
            this.u = false;
            if (this.h.j()) {
                a((com.alibaba.security.common.e.b) null, true, "停止录制并删除炫彩视频-".concat(String.valueOf(str)));
            }
            this.d.e.h();
        }
    }

    private void b(ALBiometricsResult aLBiometricsResult) {
        this.m = 7;
        this.k = false;
        h();
        this.d.c();
        aLBiometricsResult.setBh(com.alibaba.security.common.d.a.a(ALBiometricsJni.dumpBeh(true)));
        ALBiometricsEventListener aLBiometricsEventListener = this.l;
        if (aLBiometricsEventListener != null) {
            aLBiometricsEventListener.onSuccess(aLBiometricsResult);
        }
    }

    private static String a(String str) {
        byte[] a2;
        if (Build.VERSION.SDK_INT < 18 || TextUtils.isEmpty(str) || (a2 = com.alibaba.security.common.d.a.a(str)) == null) {
            return null;
        }
        String dp = ALBiometricsJni.dp(a2);
        if (TextUtils.isEmpty(dp)) {
            return null;
        }
        return dp;
    }

    static /* synthetic */ void e(a aVar) {
        c cVar = aVar.h;
        if (cVar != null) {
            aVar.onLogTrack(TrackLog.createStartCameraParametersLog(cVar.m()));
        }
    }

    private void b(int i) {
        com.alibaba.security.biometrics.c.b.c.a(i, this.c);
    }

    @Override // com.alibaba.security.biometrics.component.d
    public final void a(ALBiometricsActivityParentView aLBiometricsActivityParentView) {
        this.d = aLBiometricsActivityParentView;
        aLBiometricsActivityParentView.setOnButtonClickListener(this);
        aLBiometricsActivityParentView.setOnCloseListener(this.D);
        aLBiometricsActivityParentView.setOnDetectActionResultListener(this);
        aLBiometricsActivityParentView.setRenderer(this);
        if (!m.a(this.g, "android.permission.CAMERA")) {
            m.a(this.g, new String[]{"android.permission.CAMERA"}, 1010, "人脸识别服务需要您授权相机权限", new AnonymousClass11(), new AnonymousClass12());
        } else {
            b(false);
        }
    }

    private void a(int i, String str) {
        a(i, str, (String) null);
    }

    public final void a(int i, String str, String str2) {
        e("活体认证结束:" + i + ":" + str);
        this.k = false;
        if (i == 0) {
            this.m = 7;
        } else {
            this.m = 6;
        }
        h();
        this.p = a(i);
        if (this.c > this.q.retryThreshold && (i == -10204 || i == -10205 || i == -10206)) {
            i = GlobalErrorCode.ERROR_USER_RETRY_LIMITED;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("algoResult", h.a(this.F));
        hashMap.put("errorCode", Integer.valueOf(i));
        hashMap.put("errorMsg", str);
        ALBiometricsJni.bhL(19, h.a((Object) hashMap));
        this.d.a(i, str2, com.alibaba.security.common.d.a.a(ALBiometricsJni.dumpBeh(true)));
        P();
    }

    @Override // com.alibaba.security.biometrics.a.a
    public final void a(int i, int i2, int i3) {
        if (i2 == 0) {
            a(i, true, i3);
        } else if (i2 != 1) {
        } else {
            a(i, false, i3);
        }
    }

    private void a(int i, int[] iArr) {
        if (i == 1010) {
            if ((iArr.length > 0 ? iArr[0] : -1) != 0) {
                f();
            } else {
                b(false);
            }
        }
    }

    @Override // com.alibaba.security.biometrics.component.d
    public final boolean a() {
        ALBiometricsActivityParentView aLBiometricsActivityParentView = this.d;
        if (aLBiometricsActivityParentView != null) {
            CameraActivityWidgetParent cameraActivityWidgetParent = aLBiometricsActivityParentView.a;
            if (cameraActivityWidgetParent != null) {
                cameraActivityWidgetParent.c();
            }
            TitleBarWidget titleBarWidget = aLBiometricsActivityParentView.b;
            if (titleBarWidget != null) {
                titleBarWidget.d();
            }
            GuideWidget guideWidget = aLBiometricsActivityParentView.c;
            if (guideWidget != null) {
                guideWidget.d();
            }
            PrivacyWidget privacyWidget = aLBiometricsActivityParentView.d;
            if (privacyWidget != null) {
                privacyWidget.d();
            }
            DetectActionWidget detectActionWidget = aLBiometricsActivityParentView.e;
            if (detectActionWidget != null) {
                detectActionWidget.d();
            }
            DetectActionResultWidget detectActionResultWidget = aLBiometricsActivityParentView.f;
            if (detectActionResultWidget != null) {
                detectActionResultWidget.d();
                return true;
            }
            return true;
        }
        return true;
    }

    private void a(ABDetectType aBDetectType) {
        if (aBDetectType == null || aBDetectType == ABDetectType.AIMLESS) {
            return;
        }
        ((MediaSystemComponent) e.a(MediaSystemComponent.class)).a(aBDetectType);
        G();
        ALBiometricsActivityParentView aLBiometricsActivityParentView = this.d;
        if (aLBiometricsActivityParentView != null) {
            aLBiometricsActivityParentView.a(aBDetectType);
        }
    }

    private static TrackLog a(String str, int i, int i2) {
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer(a.C0166a.a);
        trackLog.setService(a.c.e);
        trackLog.setMethod("action");
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(i));
        hashMap.put("index", Integer.valueOf(i2));
        hashMap.put("action", str);
        trackLog.setParams(h.a((Map) hashMap));
        return trackLog;
    }

    private void a(Bundle bundle) {
        if (bundle == null || !bundle.containsKey(ALBiometricsKeys.KEY_RESULT_LOG_DATA)) {
            return;
        }
        Bundle bundle2 = bundle.getBundle(ALBiometricsKeys.KEY_RESULT_LOG_DATA);
        if (bundle2 != null) {
            bundle2.putInt("time_show_nav", this.q.stepNav ? 1 : 0);
        }
        onOldLogRecord(bundle2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ALBiometricsResult aLBiometricsResult) {
        if (this.E.contains(1)) {
            g(false);
        } else if (this.E.contains(2) && this.r != null) {
            h(false);
        } else if (aLBiometricsResult == null) {
            com.alibaba.security.common.c.a.d(e, "bio result is null");
        } else {
            aLBiometricsResult.setDazzleVideoPath(this.v);
            aLBiometricsResult.setDazzleCollectRotate(this.w);
            aLBiometricsResult.addDazzleCollectConfigs(this.s);
            aLBiometricsResult.getDazzleDataConfigs().setLastSensorInfo(this.I);
            aLBiometricsResult.getDazzleDataConfigs().setFirstSensorInfo(this.H);
            aLBiometricsResult.setCollectedData(N());
            b(aLBiometricsResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.alibaba.security.common.e.b bVar, boolean z, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        this.h.a(bVar, z);
        com.alibaba.security.common.c.a.a(e, str + "\tcostTime:" + (System.currentTimeMillis() - currentTimeMillis));
        onLogTrack(TrackLog.stopRecordVideo(str, Log.getStackTraceString(new Throwable()), String.valueOf(this.h.j()), System.currentTimeMillis() - currentTimeMillis));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, Bundle bundle) {
        if (i == -10211 || i == -10210 || i == -10209) {
            com.alibaba.security.common.d.d.a(this.g, 255);
        }
        String string = bundle.getString(ALBiometricsKeys.KEY_ERROR_MESSAGE, "");
        onLogTrack(TrackLog.createBioMonitorExpLog(i, string));
        a(i, string, (String) null);
    }

    private void a(int i, boolean z, int i2) {
        if (i != 10002 && i != 10004) {
            if (i != 10005) {
                if (i != 10009) {
                    if (i != 10010) {
                        if (i == 10012) {
                            if (z) {
                                com.alibaba.security.biometrics.c.e.a(this.g);
                            }
                            b(i2);
                            I();
                            onCancel(i2);
                            return;
                        } else if (i != 10013) {
                            switch (i) {
                                case BaseBioNavigatorActivity.n /* 20002 */:
                                case BaseBioNavigatorActivity.o /* 20003 */:
                                    break;
                                case BaseBioNavigatorActivity.p /* 20004 */:
                                    if (z) {
                                        m();
                                        return;
                                    }
                                    return;
                                case 20005:
                                case 20007:
                                    if (z) {
                                        m();
                                        return;
                                    }
                                    return;
                                case 20006:
                                    break;
                                case 20008:
                                    if (z) {
                                        I();
                                        F();
                                        return;
                                    }
                                    return;
                                default:
                                    return;
                            }
                        }
                    }
                }
            }
            b(i2);
            I();
            onCancel(i2);
            return;
        }
        if (z) {
            m();
            return;
        }
        b(i2);
        I();
        onCancel(i2);
    }

    @Override // com.alibaba.security.biometrics.component.d
    public final boolean a(int i, KeyEvent keyEvent) {
        boolean z = true;
        if (i == 4) {
            ALBiometricsConfig aLBiometricsConfig = this.j;
            if (aLBiometricsConfig != null && !aLBiometricsConfig.isShouldAlertOnExit()) {
                z = false;
            }
            a(z);
            return false;
        }
        return true;
    }

    public final void a(boolean z) {
        if (q() == 0) {
            I();
            F();
        } else if (z) {
            if (M()) {
                e("弹出确认对话框（退出活体认证）");
            }
            if (this.C == null) {
                a.C0163a c0163a = new a.C0163a(this.g);
                c0163a.b = this.g.getResources().getString(R.string.face_dialog_exit_message);
                c0163a.d = true;
                c0163a.e = false;
                String string = this.g.getResources().getString(R.string.face_dialog_exit_button_confirm);
                a.c cVar = new a.c() { // from class: com.alibaba.security.biometrics.logic.a.a.8
                    @Override // com.alibaba.security.biometrics.logic.view.widget.a.c
                    public final void a(Dialog dialog) {
                        if (dialog != null) {
                            dialog.dismiss();
                        }
                        a.this.p();
                    }
                };
                c0163a.f = string;
                c0163a.h = cVar;
                String string2 = this.g.getResources().getString(R.string.face_dialog_exit_button_cancel);
                a.b bVar = new a.b() { // from class: com.alibaba.security.biometrics.logic.a.a.7
                    @Override // com.alibaba.security.biometrics.logic.view.widget.a.b
                    public final void a(Dialog dialog) {
                        dialog.dismiss();
                    }
                };
                c0163a.i = string2;
                c0163a.k = bVar;
                this.C = new com.alibaba.security.biometrics.logic.view.widget.a(c0163a);
            }
            com.alibaba.security.biometrics.logic.view.widget.a aVar = this.C;
            Dialog dialog = aVar.a;
            if (dialog == null || dialog.isShowing()) {
                return;
            }
            aVar.a.show();
        } else {
            p();
        }
    }

    static /* synthetic */ void a(a aVar, boolean z) {
        if (aVar.k) {
            return;
        }
        aVar.k = true;
        aVar.p = GlobalErrorCode.INIT;
        ALBiometricsEventListener aLBiometricsEventListener = aVar.l;
        if (aLBiometricsEventListener != null) {
            aLBiometricsEventListener.onSensorStart();
        }
        aVar.d.d();
        Point g = aVar.h.g();
        if (g == null) {
            com.alibaba.security.common.c.a.d(e, "getCameraPreviewSize is null");
            return;
        }
        aVar.d.a(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(g), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(g));
        aVar.m = 1;
        ALBiometricsJni.bhL(2, aVar.h.f());
        if (aVar.E.size() == 1 && aVar.E.contains(2)) {
            ALBiometricsParams aLBiometricsParams = aVar.q;
            aLBiometricsParams.actionCount = 0;
            aLBiometricsParams.stepAdjust = true;
            aVar.E.add(0, 1);
        }
        if (aVar.E.indexOf(2) == 0 && aVar.r != null) {
            aVar.h(z);
        } else {
            aVar.g(z);
        }
    }
}
