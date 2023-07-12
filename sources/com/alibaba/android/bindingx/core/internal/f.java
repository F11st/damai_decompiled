package com.alibaba.android.bindingx.core.internal;

import android.content.Context;
import android.text.TextUtils;
import android.view.animation.AnimationUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.android.bindingx.core.BindingXCore;
import com.alibaba.android.bindingx.core.BindingXEventType;
import com.alibaba.android.bindingx.core.PlatformManager;
import com.alibaba.android.bindingx.core.internal.AnimationFrame;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import tb.bb1;
import tb.jn1;
import tb.xg0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class f extends AbstractEventHandler implements AnimationFrame.Callback {
    private long n;
    private AnimationFrame o;
    private boolean p;

    public f(Context context, PlatformManager platformManager, Object... objArr) {
        super(context, platformManager, objArr);
        this.n = 0L;
        this.p = false;
        AnimationFrame animationFrame = this.o;
        if (animationFrame == null) {
            this.o = AnimationFrame.b();
        } else {
            animationFrame.a();
        }
    }

    private void i(String str, long j, Object... objArr) {
        if (this.c != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("state", str);
            hashMap.put("t", Long.valueOf(j));
            hashMap.put("token", this.g);
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Map)) {
                hashMap.putAll((Map) objArr[0]);
            }
            this.c.callback(hashMap);
            bb1.a(">>>>>>>>>>>fire event:(" + str + "," + j + jn1.BRACKET_END_STR);
        }
    }

    private void j() {
        long j = 0;
        if (this.n == 0) {
            this.n = AnimationUtils.currentAnimationTimeMillis();
            this.p = false;
        } else {
            j = AnimationUtils.currentAnimationTimeMillis() - this.n;
        }
        try {
            if (bb1.a) {
                bb1.a(String.format(Locale.getDefault(), "[TimingHandler] timing elapsed. (t:%d)", Long.valueOf(j)));
            }
            JSMath.applyTimingValuesToScope(this.d, j);
            if (!this.p) {
                c(this.a, this.d, BindingXEventType.TYPE_TIMING);
            }
            this.p = d(this.j, this.d);
        } catch (Exception e) {
            bb1.c("runtime error", e);
        }
    }

    @Override // com.alibaba.android.bindingx.core.internal.AnimationFrame.Callback
    public void doFrame() {
        j();
    }

    @Override // com.alibaba.android.bindingx.core.internal.AbstractEventHandler
    protected void e(@NonNull Map<String, Object> map) {
        i("exit", (long) ((Double) map.get("t")).doubleValue(), new Object[0]);
        AnimationFrame animationFrame = this.o;
        if (animationFrame != null) {
            animationFrame.a();
        }
        this.n = 0L;
        if (this.i == null || TextUtils.isEmpty(this.g)) {
            return;
        }
        this.i.cleanHandlerByToken(this.g);
        this.i = null;
    }

    @Override // com.alibaba.android.bindingx.core.internal.AbstractEventHandler
    protected void f(String str, @NonNull Map<String, Object> map) {
        i("interceptor", (long) ((Double) map.get("t")).doubleValue(), Collections.singletonMap("interceptor", str));
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
        if (this.o == null) {
            this.o = AnimationFrame.b();
        }
        i("start", 0L, new Object[0]);
        this.o.a();
        this.o.c(this);
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public boolean onCreate(@NonNull String str, @NonNull String str2) {
        return true;
    }

    @Override // com.alibaba.android.bindingx.core.internal.AbstractEventHandler, com.alibaba.android.bindingx.core.IEventHandler
    public void onDestroy() {
        super.onDestroy();
        b();
        AnimationFrame animationFrame = this.o;
        if (animationFrame != null) {
            animationFrame.d();
            this.o = null;
        }
        this.n = 0L;
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public boolean onDisable(@NonNull String str, @NonNull String str2) {
        i("end", System.currentTimeMillis() - this.n, new Object[0]);
        b();
        AnimationFrame animationFrame = this.o;
        if (animationFrame != null) {
            animationFrame.a();
        }
        this.n = 0L;
        return true;
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void onStart(@NonNull String str, @NonNull String str2) {
    }
}
