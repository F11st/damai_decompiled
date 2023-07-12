package com.alibaba.android.bindingx.core.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.android.bindingx.core.BindingXCore;
import com.alibaba.android.bindingx.core.PlatformManager;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import tb.bb1;
import tb.jn1;
import tb.xg0;

/* compiled from: Taobao */
/* renamed from: com.alibaba.android.bindingx.core.internal.g */
/* loaded from: classes5.dex */
public class GestureDetector$OnGestureListenerC3217g extends AbstractEventHandler implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private float n;
    private float o;
    private double p;
    private double q;
    private GestureDetector r;
    private VelocityTracker s;
    private int t;

    public GestureDetector$OnGestureListenerC3217g(Context context, PlatformManager platformManager, Object... objArr) {
        super(context, platformManager, objArr);
        this.r = new GestureDetector(context, this, new Handler(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper()));
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.t = viewConfiguration.getScaledMaximumFlingVelocity();
        viewConfiguration.getScaledMinimumFlingVelocity();
    }

    private void i(String str, double d, double d2, float f, float f2, Object... objArr) {
        if (this.c != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("state", str);
            double nativeToWeb = this.h.e().nativeToWeb(d, new Object[0]);
            double nativeToWeb2 = this.h.e().nativeToWeb(d2, new Object[0]);
            hashMap.put("deltaX", Double.valueOf(nativeToWeb));
            hashMap.put("deltaY", Double.valueOf(nativeToWeb2));
            if ("end".equals(str)) {
                hashMap.put("velocityX", Float.valueOf(f));
                hashMap.put("velocityY", Float.valueOf(f2));
            }
            hashMap.put("token", this.g);
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Map)) {
                hashMap.putAll((Map) objArr[0]);
            }
            this.c.callback(hashMap);
            bb1.a(">>>>>>>>>>>fire event:(" + str + "," + nativeToWeb + "," + nativeToWeb2 + jn1.BRACKET_END_STR);
        }
    }

    @Override // com.alibaba.android.bindingx.core.internal.AbstractEventHandler
    protected void e(@NonNull Map<String, Object> map) {
        i("exit", ((Double) map.get("internal_x")).doubleValue(), ((Double) map.get("internal_y")).doubleValue(), 0.0f, 0.0f, new Object[0]);
    }

    @Override // com.alibaba.android.bindingx.core.internal.AbstractEventHandler
    protected void f(String str, @NonNull Map<String, Object> map) {
        i("interceptor", ((Double) map.get("internal_x")).doubleValue(), ((Double) map.get("internal_y")).doubleValue(), 0.0f, 0.0f, Collections.singletonMap("interceptor", str));
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void onActivityPause() {
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void onActivityResume() {
    }

    @Override // com.alibaba.android.bindingx.core.internal.AbstractEventHandler, com.alibaba.android.bindingx.core.IEventHandler
    public void onBindExpression(@NonNull String str, @Nullable Map<String, Object> map, @Nullable xg0 xg0Var, @NonNull List<Map<String, Object>> list, @Nullable BindingXCore.JavaScriptCallback javaScriptCallback) {
        super.onBindExpression(str, map, xg0Var, list, javaScriptCallback);
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public boolean onCreate(@NonNull String str, @NonNull String str2) {
        View findViewBy = this.h.g().findViewBy(str, TextUtils.isEmpty(this.f) ? this.e : this.f);
        if (findViewBy == null) {
            bb1.b("[ExpressionTouchHandler] onCreate failed. sourceView not found:" + str);
            return false;
        }
        findViewBy.setOnTouchListener(this);
        bb1.a("[ExpressionTouchHandler] onCreate success. {source:" + str + ",type:" + str2 + "}");
        return true;
    }

    @Override // com.alibaba.android.bindingx.core.internal.AbstractEventHandler, com.alibaba.android.bindingx.core.IEventHandler
    public void onDestroy() {
        super.onDestroy();
        if (this.a != null) {
            this.a.clear();
            this.a = null;
        }
        this.j = null;
        this.c = null;
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public boolean onDisable(@NonNull String str, @NonNull String str2) {
        View findViewBy = this.h.g().findViewBy(str, TextUtils.isEmpty(this.f) ? this.e : this.f);
        if (findViewBy != null) {
            findViewBy.setOnTouchListener(null);
        }
        bb1.a("remove touch listener success.[" + str + "," + str2 + jn1.ARRAY_END_STR);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        float rawY;
        float f3;
        if (motionEvent == null) {
            f3 = this.n;
            rawY = this.o;
        } else {
            float rawX = motionEvent.getRawX();
            rawY = motionEvent.getRawY();
            f3 = rawX;
        }
        if (motionEvent2 == null) {
            return false;
        }
        float rawX2 = motionEvent2.getRawX() - f3;
        float rawY2 = motionEvent2.getRawY() - rawY;
        try {
            if (bb1.a) {
                bb1.a(String.format(Locale.getDefault(), "[TouchHandler] pan moved. (x:%f,y:%f)", Float.valueOf(rawX2), Float.valueOf(rawY2)));
            }
            JSMath.applyXYToScope(this.d, rawX2, rawY2, this.h.e());
            if (!d(this.j, this.d)) {
                c(this.a, this.d, "pan");
            }
        } catch (Exception e) {
            bb1.c("runtime error", e);
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void onStart(@NonNull String str, @NonNull String str2) {
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        try {
            if (this.s == null) {
                this.s = VelocityTracker.obtain();
            }
            this.s.addMovement(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.n = motionEvent.getRawX();
                this.o = motionEvent.getRawY();
                i("start", 0.0d, 0.0d, 0.0f, 0.0f, new Object[0]);
            } else if (actionMasked == 1) {
                this.n = 0.0f;
                this.o = 0.0f;
                b();
                this.s.computeCurrentVelocity(1000, this.t);
                i("end", this.p, this.q, this.s.getXVelocity(), this.s.getYVelocity(), new Object[0]);
                this.p = 0.0d;
                this.q = 0.0d;
                VelocityTracker velocityTracker = this.s;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    this.s = null;
                }
            } else if (actionMasked != 2) {
                if (actionMasked == 3) {
                    this.n = 0.0f;
                    this.o = 0.0f;
                    b();
                    i("cancel", this.p, this.q, 0.0f, 0.0f, new Object[0]);
                    VelocityTracker velocityTracker2 = this.s;
                    if (velocityTracker2 != null) {
                        velocityTracker2.recycle();
                        this.s = null;
                    }
                }
            } else if (this.n == 0.0f && this.o == 0.0f) {
                this.n = motionEvent.getRawX();
                this.o = motionEvent.getRawY();
                i("start", 0.0d, 0.0d, 0.0f, 0.0f, new Object[0]);
            } else {
                this.p = motionEvent.getRawX() - this.n;
                this.q = motionEvent.getRawY() - this.o;
            }
        } catch (Exception e) {
            bb1.c("runtime error ", e);
        }
        return this.r.onTouchEvent(motionEvent);
    }
}
