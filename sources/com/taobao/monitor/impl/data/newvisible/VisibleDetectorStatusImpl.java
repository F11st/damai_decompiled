package com.taobao.monitor.impl.data.newvisible;

import android.taobao.windvane.connect.HttpRequest;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.taobao.monitor.impl.data.newvisible.IVisibleDetector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import tb.fu0;
import tb.ho2;
import tb.i60;
import tb.jn1;
import tb.k13;
import tb.ky2;
import tb.pb1;
import tb.ry2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class VisibleDetectorStatusImpl implements IVisibleDetector, Runnable {
    private static final List<a> BLACK_VIEW_INFO_LIST;
    private static final long CONTINUOUS_OBSERVER_DURATION = 5000;
    private static final long INTERVAL = 75;
    private static final String TAG = "VisibleDetectorStatusImpl";
    private static final int WEEX_VISIBLE_KEY = -307;
    private IVisibleDetector.IDetectorCallback callback;
    private final WeakReference<View> containRef;
    private final String pageName;
    final com.taobao.monitor.impl.data.newvisible.a pagePercentCalculate;
    private int validElementCount = 0;
    private Set<String> typeLocationStatusSet = new HashSet();
    private Map<String, String> typeKeyStatusMap = new HashMap();
    private Set<String> moveViewCacheSet = new HashSet();
    private Map<String, Integer> oldViews = new HashMap();
    private volatile boolean stopped = false;
    private long lastChangedTime = ho2.a();
    private String lastChangedView = "";
    private boolean stopImmediately = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class a {
        private String a;
        private int b;
        private String c;

        public a(String str, int i, String str2) {
            this.a = str;
            this.b = i;
            this.c = str2;
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        BLACK_VIEW_INFO_LIST = arrayList;
        arrayList.add(new a("TBMainActivity", id("uik_refresh_header_second_floor"), jn1.MUL));
        arrayList.add(new a("MainActivity3", id("uik_refresh_header_second_floor"), jn1.MUL));
        arrayList.add(new a(jn1.MUL, id("mytaobao_carousel"), "RecyclerView"));
        arrayList.add(new a(jn1.MUL, -1, "HLoopView"));
        arrayList.add(new a(jn1.MUL, -1, "HGifView"));
        arrayList.add(new a("TBLiveVideoActivity", id("recyclerview"), "AliLiveRecyclerView"));
    }

    public VisibleDetectorStatusImpl(View view, String str, float f) {
        try {
            View findViewById = view.findViewById(view.getResources().getIdentifier("content", "id", "android"));
            if (findViewById != null) {
                view = findViewById;
            }
        } catch (Exception unused) {
        }
        this.containRef = new WeakReference<>(view);
        this.pageName = str;
        this.pagePercentCalculate = new com.taobao.monitor.impl.data.newvisible.a(f);
        pb1.a(TAG, str);
    }

    private void calculateStatus(View view, View view2) {
        View[] c;
        if (isValidView(view)) {
            boolean z = !inBlackList(view);
            if (view instanceof WebView) {
                int webViewProgress = i60.INSTANCE.webViewProgress(view);
                if (webViewProgress != 100) {
                    this.lastChangedTime = ho2.a();
                } else {
                    this.stopImmediately = true;
                }
                this.validElementCount = webViewProgress;
                this.lastChangedView = "progress";
                return;
            }
            k13 k13Var = k13.INSTANCE;
            if (k13Var.isWebView(view)) {
                int webViewProgress2 = k13Var.webViewProgress(view);
                if (webViewProgress2 != 100) {
                    this.lastChangedTime = ho2.a();
                } else {
                    this.stopImmediately = true;
                }
                this.validElementCount = webViewProgress2;
                this.lastChangedView = "progress";
            } else if ((view instanceof EditText) && view.hasFocus()) {
                this.stopImmediately = true;
            } else {
                boolean z2 = view instanceof TextView;
                if (z2) {
                    this.validElementCount++;
                } else if (view instanceof ImageView) {
                    if (((ImageView) view).getDrawable() != null) {
                        this.validElementCount++;
                    }
                } else if (view.getBackground() != null) {
                    this.validElementCount++;
                }
                if (z2) {
                    doValidViewAction(view, view2);
                } else if ((view instanceof ImageView) && ((ImageView) view).getDrawable() != null) {
                    doValidViewAction(view, view2);
                }
                if ((view instanceof ViewGroup) && z && (c = ry2.c((ViewGroup) view)) != null) {
                    for (View view3 : c) {
                        if (view3 == null) {
                            return;
                        }
                        calculateStatus(view3, view2);
                    }
                }
            }
        }
    }

    private void check() {
        IVisibleDetector.IDetectorCallback iDetectorCallback;
        View view = this.containRef.get();
        long j = this.lastChangedTime;
        this.validElementCount = 0;
        if (view == null) {
            stop();
            return;
        }
        try {
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        if (view.getHeight() * view.getWidth() == 0) {
            return;
        }
        this.pagePercentCalculate.b();
        calculateStatus(view, view);
        if (j != this.lastChangedTime) {
            this.pagePercentCalculate.a();
        }
        if ((j != this.lastChangedTime || this.stopImmediately) && (iDetectorCallback = this.callback) != null) {
            iDetectorCallback.onChanged(j);
            this.callback.onValidElementChanged(this.validElementCount);
            this.callback.onLastChangedView(this.lastChangedView);
        }
    }

    private void doValidViewAction(View view, View view2) {
        this.pagePercentCalculate.c(view);
        String e = ky2.e(view);
        String b = ky2.b(view2, view);
        String d = ky2.d(view);
        String a2 = ky2.a(view);
        String str = e + b + d;
        String str2 = e + a2 + d;
        String str3 = e + a2;
        String c = ky2.c(view2, view);
        Integer num = 1;
        if (ry2.d(view, view2) && !this.typeKeyStatusMap.containsKey(str2)) {
            if (this.oldViews.containsKey(str3)) {
                if (!this.typeKeyStatusMap.containsKey(str2)) {
                    this.lastChangedTime = ho2.a();
                    this.lastChangedView = c + " " + str;
                    pb1.a(TAG, c, str);
                }
            } else if (!this.moveViewCacheSet.contains(c) && !this.typeLocationStatusSet.contains(str)) {
                this.lastChangedTime = ho2.a();
                this.lastChangedView = c + " " + str;
                pb1.a(TAG, c, str);
            }
        }
        Integer num2 = this.oldViews.get(str3);
        if (num2 == null) {
            this.oldViews.put(str3, num);
        } else {
            num = num2;
        }
        String str4 = this.typeKeyStatusMap.get(str2);
        if (!b.equals(str4) && !TextUtils.isEmpty(str4)) {
            Integer valueOf = Integer.valueOf(num.intValue() + 1);
            this.oldViews.put(str3, valueOf);
            if (valueOf.intValue() > 2) {
                this.moveViewCacheSet.add(c);
            }
        }
        this.typeKeyStatusMap.put(str2, b);
        this.typeLocationStatusSet.add(str);
    }

    private static int id(String str) {
        try {
            return fu0.e().a().getResources().getIdentifier(str, "id", fu0.e().a().getPackageName());
        } catch (Exception unused) {
            return -1;
        }
    }

    private boolean inBlackList(View view) {
        for (a aVar : BLACK_VIEW_INFO_LIST) {
            if (aVar.a.equals(jn1.MUL) || this.pageName.endsWith(aVar.a)) {
                if (view.getId() == aVar.b || aVar.b == -1) {
                    if (aVar.c.equals(jn1.MUL) || aVar.c.equals(view.getClass().getSimpleName())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isValidView(View view) {
        if (HttpRequest.DEFAULT_HTTPS_ERROR_INVALID.equals(view.getTag(WEEX_VISIBLE_KEY)) || view.getVisibility() != 0 || (view instanceof ViewStub)) {
            return false;
        }
        if ((view instanceof EditText) && view.hasFocus()) {
            return true;
        }
        if (view.getHeight() < ry2.screenHeight / 25) {
            return false;
        }
        return (view instanceof TextView) || (view instanceof ImageView) || (view instanceof ViewGroup);
    }

    @Override // com.taobao.monitor.impl.data.IExecutor
    public void execute() {
        if (this.containRef.get() == null) {
            stop();
            return;
        }
        long a2 = ho2.a();
        this.lastChangedTime = a2;
        IVisibleDetector.IDetectorCallback iDetectorCallback = this.callback;
        if (iDetectorCallback != null) {
            iDetectorCallback.onChanged(a2);
        }
        fu0.e().b().postDelayed(this, 75L);
    }

    public long getLastChangedTime() {
        return this.lastChangedTime;
    }

    @Override // java.lang.Runnable
    public void run() {
        long a2 = ho2.a();
        if (this.stopped) {
            return;
        }
        if (a2 - this.lastChangedTime <= 5000 && !this.stopImmediately) {
            check();
            fu0.e().b().postDelayed(this, 75L);
            return;
        }
        visibleEndByType("NORMAL");
        stop();
    }

    public void setCallback(IVisibleDetector.IDetectorCallback iDetectorCallback) {
        this.callback = iDetectorCallback;
    }

    @Override // com.taobao.monitor.impl.data.IExecutor
    public void stop() {
        if (this.stopped) {
            return;
        }
        this.stopped = true;
        fu0.e().b().removeCallbacks(this);
        IVisibleDetector.IDetectorCallback iDetectorCallback = this.callback;
        if (iDetectorCallback != null) {
            iDetectorCallback.onCompleted(this.pagePercentCalculate.d(this.lastChangedTime));
        }
    }

    void visibleEndByType(String str) {
        if (this.stopped) {
            return;
        }
        stop();
    }
}
