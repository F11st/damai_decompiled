package com.airbnb.lottie;

import androidx.collection.ArraySet;
import androidx.core.util.Pair;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import tb.wd1;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class PerformanceTracker {
    private boolean a = false;
    private final Set<FrameListener> b = new ArraySet();
    private final Map<String, wd1> c = new HashMap();

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public interface FrameListener {
        void onFrameRendered(float f);
    }

    /* compiled from: Taobao */
    /* renamed from: com.airbnb.lottie.PerformanceTracker$a */
    /* loaded from: classes17.dex */
    class C2820a implements Comparator<Pair<String, Float>> {
        C2820a(PerformanceTracker performanceTracker) {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
            float floatValue = pair.second.floatValue();
            float floatValue2 = pair2.second.floatValue();
            if (floatValue2 > floatValue) {
                return 1;
            }
            return floatValue > floatValue2 ? -1 : 0;
        }
    }

    public PerformanceTracker() {
        new C2820a(this);
    }

    public void a(String str, float f) {
        if (this.a) {
            wd1 wd1Var = this.c.get(str);
            if (wd1Var == null) {
                wd1Var = new wd1();
                this.c.put(str, wd1Var);
            }
            wd1Var.a(f);
            if (str.equals("__container")) {
                for (FrameListener frameListener : this.b) {
                    frameListener.onFrameRendered(f);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(boolean z) {
        this.a = z;
    }
}
