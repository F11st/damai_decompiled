package com.alibaba.android.bindingx.core.internal;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import com.alibaba.android.bindingx.core.PlatformManager;
import com.alibaba.android.bindingx.core.internal.RotationGestureDetector;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import tb.bb1;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class d extends AbstractEventHandler implements View.OnTouchListener, RotationGestureDetector.OnRotationGestureListener {
    private RotationGestureDetector n;
    private double o;

    public d(Context context, PlatformManager platformManager, Object... objArr) {
        super(context, platformManager, objArr);
        this.n = new RotationGestureDetector(this);
    }

    private void i(String str, double d, Object... objArr) {
        if (this.c != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("state", str);
            hashMap.put("rotation", Double.valueOf(d));
            hashMap.put("token", this.g);
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Map)) {
                hashMap.putAll((Map) objArr[0]);
            }
            this.c.callback(hashMap);
            bb1.a(">>>>>>>>>>>fire event:(" + str + "," + d + jn1.BRACKET_END_STR);
        }
    }

    @Override // com.alibaba.android.bindingx.core.internal.AbstractEventHandler
    protected void e(@NonNull Map<String, Object> map) {
        i("exit", ((Double) map.get(UploadQueueMgr.MSGTYPE_REALTIME)).doubleValue(), new Object[0]);
    }

    @Override // com.alibaba.android.bindingx.core.internal.AbstractEventHandler
    protected void f(String str, @NonNull Map<String, Object> map) {
        i("interceptor", ((Double) map.get(UploadQueueMgr.MSGTYPE_REALTIME)).doubleValue(), Collections.singletonMap("interceptor", str));
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
            bb1.b("[RotationHandler] onCreate failed. sourceView not found:" + str);
            return false;
        }
        findViewBy.setOnTouchListener(this);
        bb1.a("[RotationHandler] onCreate success. {source:" + str + ",type:" + str2 + "}");
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

    @Override // com.alibaba.android.bindingx.core.internal.RotationGestureDetector.OnRotationGestureListener
    public void onRotation(RotationGestureDetector rotationGestureDetector) {
        try {
            this.o += rotationGestureDetector.c();
            if (bb1.a) {
                bb1.a(String.format(Locale.getDefault(), "[RotationHandler] current rotation in degrees: %f", Double.valueOf(this.o)));
            }
            JSMath.applyRotationInDegreesToScope(this.d, this.o);
            if (d(this.j, this.d)) {
                return;
            }
            c(this.a, this.d, "rotation");
        } catch (Exception e) {
            bb1.c("runtime error", e);
        }
    }

    @Override // com.alibaba.android.bindingx.core.internal.RotationGestureDetector.OnRotationGestureListener
    public void onRotationBegin(RotationGestureDetector rotationGestureDetector) {
        bb1.a("[RotationHandler] rotation gesture begin");
        i("start", 0.0d, new Object[0]);
    }

    @Override // com.alibaba.android.bindingx.core.internal.RotationGestureDetector.OnRotationGestureListener
    public void onRotationEnd(RotationGestureDetector rotationGestureDetector) {
        bb1.a("[RotationHandler] rotation gesture end");
        i("end", this.o, new Object[0]);
        this.o = 0.0d;
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void onStart(@NonNull String str, @NonNull String str2) {
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.n.d(motionEvent);
    }
}
