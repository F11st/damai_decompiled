package com.alibaba.android.bindingx.core.internal;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import androidx.annotation.NonNull;
import com.alibaba.android.bindingx.core.BindingXEventType;
import com.alibaba.android.bindingx.core.PlatformManager;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import tb.bb1;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class c extends AbstractEventHandler implements ScaleGestureDetector.OnScaleGestureListener, View.OnTouchListener {
    private ScaleGestureDetector n;
    private boolean o;
    private int[] p;
    private double q;

    public c(Context context, PlatformManager platformManager, Object... objArr) {
        super(context, platformManager, objArr);
        this.p = new int[2];
        this.q = 1.0d;
        Handler handler = new Handler(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
        if (Build.VERSION.SDK_INT >= 19) {
            this.n = new ScaleGestureDetector(context, this, handler);
        } else {
            this.n = new ScaleGestureDetector(context, this);
        }
    }

    private void i(String str, double d, Object... objArr) {
        if (this.c != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("state", str);
            hashMap.put("scale", Double.valueOf(d));
            hashMap.put("token", this.g);
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Map)) {
                hashMap.putAll((Map) objArr[0]);
            }
            this.c.callback(hashMap);
            bb1.a(">>>>>>>>>>>fire event:(" + str + "," + d + jn1.BRACKET_END_STR);
        }
    }

    private void j() {
        if (this.o) {
            bb1.a("[PinchHandler] pinch gesture end");
            i("end", this.q, new Object[0]);
            this.o = false;
            int[] iArr = this.p;
            iArr[0] = -1;
            iArr[1] = -1;
            this.q = 1.0d;
        }
    }

    private void k() {
        bb1.a("[PinchHandler] pinch gesture begin");
        i("start", 1.0d, new Object[0]);
    }

    @Override // com.alibaba.android.bindingx.core.internal.AbstractEventHandler
    protected void e(@NonNull Map<String, Object> map) {
        i("exit", ((Double) map.get("s")).doubleValue(), new Object[0]);
    }

    @Override // com.alibaba.android.bindingx.core.internal.AbstractEventHandler
    protected void f(String str, @NonNull Map<String, Object> map) {
        i("interceptor", ((Double) map.get("s")).doubleValue(), Collections.singletonMap("interceptor", str));
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void onActivityPause() {
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void onActivityResume() {
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public boolean onCreate(@NonNull String str, @NonNull String str2) {
        View findViewBy = this.h.g().findViewBy(str, TextUtils.isEmpty(this.f) ? this.e : this.f);
        if (findViewBy == null) {
            bb1.b("[BindingXPinchHandler] onCreate failed. sourceView not found:" + str);
            return false;
        }
        findViewBy.setOnTouchListener(this);
        bb1.a("[BindingXPinchHandler] onCreate success. {source:" + str + ",type:" + str2 + "}");
        return true;
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public boolean onDisable(@NonNull String str, @NonNull String str2) {
        View findViewBy = this.h.g().findViewBy(str, TextUtils.isEmpty(this.f) ? this.e : this.f);
        bb1.a("remove touch listener success.[" + str + "," + str2 + jn1.ARRAY_END_STR);
        if (findViewBy != null) {
            findViewBy.setOnTouchListener(null);
            return true;
        }
        return false;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        if (!Float.isNaN(scaleFactor) && !Float.isInfinite(scaleFactor)) {
            this.q *= scaleFactor;
            try {
                if (bb1.a) {
                    bb1.a(String.format(Locale.getDefault(), "[PinchHandler] current scale factor: %f", Double.valueOf(this.q)));
                }
                JSMath.applyScaleFactorToScope(this.d, this.q);
                if (!d(this.j, this.d)) {
                    c(this.a, this.d, BindingXEventType.TYPE_PINCH);
                }
            } catch (Exception e) {
                bb1.c("runtime error", e);
            }
        }
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void onStart(@NonNull String str, @NonNull String str2) {
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.o = false;
            this.p[0] = motionEvent.getPointerId(motionEvent.getActionIndex());
            this.p[1] = -1;
        } else if (actionMasked == 1) {
            j();
        } else if (actionMasked != 5) {
            if (actionMasked == 6 && this.o) {
                int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                int[] iArr = this.p;
                if (pointerId == iArr[0] || pointerId == iArr[1]) {
                    j();
                }
            }
        } else if (!this.o) {
            this.p[1] = motionEvent.getPointerId(motionEvent.getActionIndex());
            this.o = true;
            k();
        }
        return this.n.onTouchEvent(motionEvent);
    }
}
