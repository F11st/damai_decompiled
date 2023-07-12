package com.alibaba.security.biometrics.sensor.a;

import android.app.Activity;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.alibaba.security.biometrics.sensor.api.RpSecException;
import com.alibaba.security.biometrics.sensor.model.MotionEventData;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class c extends a<List<MotionEventData>> implements View.OnTouchListener {
    public volatile boolean c;
    public final List<MotionEventData> d;
    private View e;

    public c(Activity activity) {
        super(activity);
        this.c = false;
        this.d = new ArrayList();
    }

    private static MotionEventData b(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return null;
        }
        MotionEventData motionEventData = new MotionEventData();
        motionEventData.setAction(motionEvent.getAction());
        motionEventData.setDeviceID(motionEvent.getDeviceId());
        motionEventData.setDownTime(motionEvent.getDownTime());
        motionEventData.setElapsedRealtime(SystemClock.elapsedRealtime());
        motionEventData.setEventTime(motionEvent.getEventTime());
        motionEventData.setPressure(motionEvent.getPressure());
        motionEventData.setSize(motionEvent.getSize());
        motionEventData.setToolType(motionEvent.getToolType(0));
        motionEventData.setX(motionEvent.getX());
        motionEventData.setY(motionEvent.getY());
        return motionEventData;
    }

    private List<MotionEventData> e() {
        return this.d;
    }

    @Override // com.alibaba.security.biometrics.sensor.a.a
    public final void a(com.alibaba.security.biometrics.sensor.b.a aVar) throws RpSecException {
        super.a(aVar);
        Activity activity = this.a;
        if (activity != null) {
            Window window = activity.getWindow();
            if (window != null) {
                View decorView = window.getDecorView();
                this.e = decorView;
                if (decorView == null) {
                    throw new RpSecException("No DecorView found from current activity", (int) RpSecException.EXCEPTION_NO_DECOR_VIEW_FOUND);
                }
                return;
            }
            throw new RpSecException("No window found from current activity", (int) RpSecException.EXCEPTION_NO_WINDOW_FOUND_FROM_ACTIVITY);
        }
        throw new RpSecException("No activity found when initialized", -100);
    }

    @Override // com.alibaba.security.biometrics.sensor.a.a
    public final boolean c() {
        this.c = false;
        return false;
    }

    @Override // com.alibaba.security.biometrics.sensor.a.a
    public final void d() {
        List<MotionEventData> list = this.d;
        if (list != null) {
            list.clear();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
        if (r7.getAction() == 1) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0035  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r6 = r5.c
            r0 = 1
            r1 = 0
            if (r6 == 0) goto L32
            java.util.List<com.alibaba.security.biometrics.sensor.model.MotionEventData> r6 = r5.d
            int r6 = r6.size()
            com.alibaba.security.biometrics.sensor.b.a r2 = r5.b
            int r3 = r2.a
            r4 = 300(0x12c, float:4.2E-43)
            if (r3 > r4) goto L16
            if (r3 > 0) goto L1a
        L16:
            r3 = 100
            r2.a = r3
        L1a:
            int r2 = r2.a
            if (r6 > r2) goto L32
            int r6 = r7.getAction()
            if (r6 == 0) goto L33
            int r6 = r7.getAction()
            r2 = 2
            if (r6 == r2) goto L33
            int r6 = r7.getAction()
            if (r6 != r0) goto L32
            goto L33
        L32:
            r0 = 0
        L33:
            if (r0 == 0) goto L8b
            if (r7 != 0) goto L39
            r6 = 0
            goto L84
        L39:
            com.alibaba.security.biometrics.sensor.model.MotionEventData r6 = new com.alibaba.security.biometrics.sensor.model.MotionEventData
            r6.<init>()
            int r0 = r7.getAction()
            r6.setAction(r0)
            int r0 = r7.getDeviceId()
            r6.setDeviceID(r0)
            long r2 = r7.getDownTime()
            r6.setDownTime(r2)
            long r2 = android.os.SystemClock.elapsedRealtime()
            r6.setElapsedRealtime(r2)
            long r2 = r7.getEventTime()
            r6.setEventTime(r2)
            float r0 = r7.getPressure()
            r6.setPressure(r0)
            float r0 = r7.getSize()
            r6.setSize(r0)
            int r0 = r7.getToolType(r1)
            r6.setToolType(r0)
            float r0 = r7.getX()
            r6.setX(r0)
            float r7 = r7.getY()
            r6.setY(r7)
        L84:
            if (r6 == 0) goto L8b
            java.util.List<com.alibaba.security.biometrics.sensor.model.MotionEventData> r7 = r5.d
            r7.add(r6)
        L8b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.biometrics.sensor.a.c.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // com.alibaba.security.biometrics.sensor.a.a
    public final void a() throws RpSecException {
        if (this.e != null) {
            this.c = true;
            this.e.setOnTouchListener(this);
            return;
        }
        throw new RpSecException("No DecorView found from current activity while start", (int) RpSecException.EXCEPTION_NO_DECOR_VIEW_FOUND);
    }

    private boolean a(MotionEvent motionEvent) {
        if (this.c) {
            int size = this.d.size();
            com.alibaba.security.biometrics.sensor.b.a aVar = this.b;
            int i = aVar.a;
            if (i > 300 || i <= 0) {
                aVar.a = 100;
            }
            if (size <= aVar.a) {
                return motionEvent.getAction() == 0 || motionEvent.getAction() == 2 || motionEvent.getAction() == 1;
            }
            return false;
        }
        return false;
    }

    @Override // com.alibaba.security.biometrics.sensor.a.a
    public final /* bridge */ /* synthetic */ List<MotionEventData> b() {
        return this.d;
    }
}
