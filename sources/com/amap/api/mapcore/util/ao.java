package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.mapcore.util.an;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ao extends an {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static abstract class a implements an.a {
        @Override // com.amap.api.mapcore.util.an.a
        public boolean a(an anVar) {
            return a((ao) anVar);
        }

        public abstract boolean a(ao aoVar);

        @Override // com.amap.api.mapcore.util.an.a
        public boolean b(an anVar) {
            return b((ao) anVar);
        }

        public abstract boolean b(ao aoVar);

        @Override // com.amap.api.mapcore.util.an.a
        public void c(an anVar) {
            c((ao) anVar);
        }

        public abstract void c(ao aoVar);
    }

    public ao(Context context, a aVar) {
        super(context, aVar);
    }

    public float l() {
        return (float) (((Math.atan2(i(), h()) - Math.atan2(f(), e())) * 180.0d) / 3.141592653589793d);
    }
}
