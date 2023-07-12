package com.taobao.slide.api;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.taobao.slide.model.ResultDO;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class SlideSubscriber {
    private Type a;
    private Handler b;
    private Map<String, ResultDO> c;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public enum Type {
        EXACT,
        PREFIX,
        REGULAR
    }

    public SlideSubscriber() {
        this(null);
    }

    public void a(String str, ResultDO resultDO) {
        if (this.c == null) {
            this.c = new HashMap();
        }
        this.c.put(str, resultDO);
    }

    public void b() {
        this.c.clear();
        this.c = null;
    }

    public Handler c() {
        return this.b;
    }

    public Map<String, ResultDO> d() {
        return this.c;
    }

    public Type e() {
        Type type = this.a;
        return type == null ? Type.EXACT : type;
    }

    public abstract void f(Map<String, ResultDO> map);

    public SlideSubscriber(@Nullable Handler handler) {
        this.b = handler;
    }
}
