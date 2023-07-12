package com.alibaba.pictures.ut;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.ut.mini.UTAnalytics;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.qv2;
import tb.ss2;
import tb.ys2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class MovieShowUTHelper implements IUTPageOperation {
    private static transient /* synthetic */ IpChange $ipChange;
    private String a;
    private String b;
    private Activity c;
    private boolean d;
    private Map<String, String> e;
    private final Object f;

    public MovieShowUTHelper(@Nullable Object obj) {
        Activity activity;
        this.f = obj;
        if (obj instanceof Fragment) {
            activity = ((Fragment) obj).getActivity();
        } else {
            activity = (Activity) (obj instanceof Activity ? obj : null);
        }
        this.c = activity;
        g();
    }

    private final void d(Properties properties) {
        Intent intent;
        Intent intent2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1777066597")) {
            ipChange.ipc$dispatch("-1777066597", new Object[]{this, properties});
            return;
        }
        Activity activity = this.c;
        if (activity == null || (intent = activity.getIntent()) == null || !intent.hasExtra(ss2.UT_CONST_SQM)) {
            return;
        }
        Activity activity2 = this.c;
        properties.setProperty(ss2.UT_CONST_SQM, (activity2 == null || (intent2 = activity2.getIntent()) == null) ? null : intent2.getStringExtra(ss2.UT_CONST_SQM));
    }

    private final void e() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1705683922")) {
            ipChange.ipc$dispatch("1705683922", new Object[]{this});
        } else if (this.d) {
            String str = this.b;
            if ((str == null || str.length() == 0) ? true : true) {
                this.b = f();
            }
            String str2 = ys2.INSTANCE.f() + '.' + this.b;
            Properties properties = new Properties();
            properties.setProperty("spm-cnt", str2);
            DogCat dogCat = DogCat.INSTANCE;
            dogCat.C(this.c, properties);
            dogCat.D(str2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0044, code lost:
        if (r1 != false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String f() {
        /*
            r5 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = com.alibaba.pictures.ut.MovieShowUTHelper.$ipChange
            java.lang.String r1 = "249384000"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 0
            if (r2 == 0) goto L17
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r3] = r5
            java.lang.Object r0 = r0.ipc$dispatch(r1, r2)
            java.lang.String r0 = (java.lang.String) r0
            return r0
        L17:
            java.lang.Object r0 = r5.f
            if (r0 != 0) goto L1e
            java.lang.String r0 = "default"
            return r0
        L1e:
            java.lang.Class r0 = r0.getClass()
            java.lang.String r0 = r0.getSimpleName()
            java.lang.String r1 = "pageObj.javaClass.simpleName"
            tb.b41.h(r0, r1)
            java.lang.String r0 = r0.toLowerCase()
            java.lang.String r1 = "(this as java.lang.String).toLowerCase()"
            tb.b41.h(r0, r1)
            java.lang.String r1 = "activity"
            r2 = 2
            r4 = 0
            boolean r1 = kotlin.text.g.p(r0, r1, r3, r2, r4)
            if (r1 != 0) goto L46
            java.lang.String r1 = "fragment"
            boolean r1 = kotlin.text.g.p(r0, r1, r3, r2, r4)
            if (r1 == 0) goto L5b
        L46:
            int r1 = r0.length()     // Catch: java.lang.Exception -> L57
            int r1 = r1 + (-8)
            java.lang.String r1 = r0.substring(r3, r1)     // Catch: java.lang.Exception -> L57
            java.lang.String r2 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            tb.b41.h(r1, r2)     // Catch: java.lang.Exception -> L57
            r0 = r1
            goto L5b
        L57:
            r1 = move-exception
            tb.qv2.b(r1)
        L5b:
            tb.ys2 r1 = tb.ys2.INSTANCE
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Page_"
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            java.lang.String r1 = r1.h(r2)
            if (r1 == 0) goto L75
            r0 = r1
        L75:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.ut.MovieShowUTHelper.f():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00a0, code lost:
        if (r1 != false) goto L49;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void g() {
        /*
            Method dump skipped, instructions count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.ut.MovieShowUTHelper.g():void");
    }

    private final void j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2005168735")) {
            ipChange.ipc$dispatch("-2005168735", new Object[]{this});
            return;
        }
        UTAnalytics uTAnalytics = UTAnalytics.getInstance();
        b41.h(uTAnalytics, "UTAnalytics.getInstance()");
        Map<String, String> pageProperties = uTAnalytics.getDefaultTracker().getPageProperties(this.c);
        if (pageProperties != null) {
            Map<String, String> map = this.e;
            if (map == null) {
                this.e = new HashMap(pageProperties);
                return;
            }
            if (map != null) {
                map.clear();
            }
            Map<String, String> map2 = this.e;
            if (map2 != null) {
                map2.putAll(pageProperties);
            }
        }
    }

    @Override // com.alibaba.pictures.ut.IUTPageOperation
    @Nullable
    public String getPageSPM() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1201306763") ? (String) ipChange.ipc$dispatch("1201306763", new Object[]{this}) : this.b;
    }

    @Override // com.alibaba.pictures.ut.IUTPageOperation
    @Nullable
    public String getUTPageName() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-269073499")) {
            return (String) ipChange.ipc$dispatch("-269073499", new Object[]{this});
        }
        String str = this.a;
        if ((str == null || str.length() == 0) ? true : true) {
            SPM_Page sPM_Page = (SPM_Page) MovieShowUTHelper.class.getAnnotation(SPM_Page.class);
            this.a = sPM_Page != null ? sPM_Page.pageName() : null;
        }
        return this.a;
    }

    public final void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "541660560")) {
            ipChange.ipc$dispatch("541660560", new Object[]{this});
            return;
        }
        Object obj = this.f;
        if (obj == null) {
            return;
        }
        if (!(obj instanceof Fragment)) {
            qv2.a("onUTEnter:" + this.f + ',' + this.d);
            if (this.d) {
                DogCat.INSTANCE.v(this.c, getUTPageName());
                qv2.a("enterPage:" + this.c + AVFSCacheConstants.COMMA_SEP + getUTPageName());
            }
        } else if (this.d) {
            qv2.a("onUTEnter:" + this.f + ',' + this.d);
            StringBuilder sb = new StringBuilder();
            sb.append("leavePage:");
            sb.append(this.c);
            qv2.a(sb.toString());
            qv2.a("enterPageDonotSkip:" + this.c + AVFSCacheConstants.COMMA_SEP + getUTPageName());
            DogCat dogCat = DogCat.INSTANCE;
            dogCat.x(this.c);
            dogCat.w(this.c, getUTPageName());
        }
        e();
        j();
    }

    public final void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-69808815")) {
            ipChange.ipc$dispatch("-69808815", new Object[]{this});
            return;
        }
        qv2.a("onUTLeave:" + this.f);
        if (this.f instanceof Fragment) {
            return;
        }
        qv2.a("leavePage:" + this.c);
        DogCat.INSTANCE.x(this.c);
    }

    @Override // com.alibaba.pictures.ut.IUTPageOperation
    public void onUTButtonClick(@Nullable String str, @NotNull String... strArr) {
        Intent intent;
        Intent intent2;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1569997411")) {
            ipChange.ipc$dispatch("1569997411", new Object[]{this, str, strArr});
            return;
        }
        b41.i(strArr, "kvs");
        if (str == null) {
            qv2.c("onUTButtonClick error:controlName =null");
            return;
        }
        if (!this.d) {
            Object obj = this.f;
            if (obj instanceof Fragment) {
                FragmentActivity activity = ((Fragment) obj).getActivity();
                IUTPageOperation iUTPageOperation = (IUTPageOperation) (activity instanceof IUTPageOperation ? activity : null);
                if (iUTPageOperation != null) {
                    iUTPageOperation.onUTButtonClick(str, (String[]) Arrays.copyOf(strArr, strArr.length));
                    return;
                }
                return;
            }
        }
        Activity activity2 = this.c;
        if (activity2 != null && (intent = activity2.getIntent()) != null && intent.hasExtra(ss2.UT_CONST_SQM)) {
            String[] strArr2 = new String[strArr.length + 2];
            while (i < strArr.length) {
                strArr2[i] = strArr[i];
                i++;
            }
            strArr2[i] = ss2.UT_CONST_SQM;
            int i2 = i + 1;
            Activity activity3 = this.c;
            if (activity3 != null && (intent2 = activity3.getIntent()) != null) {
                r1 = intent2.getStringExtra(ss2.UT_CONST_SQM);
            }
            strArr2[i2] = r1;
            DogCat.INSTANCE.d().n(getUTPageName()).k(str).p((String[]) Arrays.copyOf(strArr, strArr.length)).j();
            return;
        }
        DogCat.INSTANCE.d().n(getUTPageName()).k(str).p((String[]) Arrays.copyOf(strArr, strArr.length)).j();
    }

    @Override // com.alibaba.pictures.ut.IUTPageOperation
    @Nullable
    public String querySavedPageProperty(@Nullable String str) {
        Map<String, String> map;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1822708967")) {
            return (String) ipChange.ipc$dispatch("-1822708967", new Object[]{this, str});
        }
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (z || (map = this.e) == null) {
            return null;
        }
        return map.get(str);
    }

    @Override // com.alibaba.pictures.ut.IUTPageOperation
    public void setUTPageEnable(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "906410013")) {
            ipChange.ipc$dispatch("906410013", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        qv2.a("setUTPageEnable:" + z + ',' + this.f);
        this.d = z;
        if (z) {
            Object obj = this.f;
            if (obj instanceof Fragment) {
                FragmentActivity activity = ((Fragment) obj).getActivity();
                if ((activity instanceof IUTPageOperation) && (obj instanceof IUTPageOperation)) {
                    IUTPageOperation iUTPageOperation = (IUTPageOperation) activity;
                    iUTPageOperation.setUTPageEnable(false);
                    iUTPageOperation.setUTPageName(((IUTPageOperation) obj).getUTPageName());
                }
            }
        }
        if (this.d || (this.f instanceof Fragment)) {
            return;
        }
        qv2.a("skipPage:" + this.c);
        DogCat.INSTANCE.y(this.c);
    }

    @Override // com.alibaba.pictures.ut.IUTPageOperation
    public void setUTPageName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1861227303")) {
            ipChange.ipc$dispatch("-1861227303", new Object[]{this, str});
            return;
        }
        this.a = str;
        this.b = ys2.INSTANCE.h(str);
        Object obj = this.f;
        if (obj instanceof Fragment) {
            ((Fragment) obj).getLifecycle().addObserver(new LifecycleObserver() { // from class: com.alibaba.pictures.ut.MovieShowUTHelper$setUTPageName$1
                private static transient /* synthetic */ IpChange $ipChange;

                @OnLifecycleEvent(Lifecycle.Event.ON_START)
                public final void onViewCreated() {
                    Object obj2;
                    Object obj3;
                    String str2;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "2034872674")) {
                        ipChange2.ipc$dispatch("2034872674", new Object[]{this});
                        return;
                    }
                    obj2 = MovieShowUTHelper.this.f;
                    View view = ((Fragment) obj2).getView();
                    if (view != null) {
                        int b = ss2.b();
                        str2 = MovieShowUTHelper.this.b;
                        if (str2 == null) {
                            str2 = MovieShowUTHelper.this.a;
                        }
                        view.setTag(b, str2);
                    }
                    obj3 = MovieShowUTHelper.this.f;
                    ((Fragment) obj3).getLifecycle().removeObserver(this);
                }
            });
        }
    }

    @Override // com.alibaba.pictures.ut.IUTPageOperation
    public void startExpoTrack(@Nullable Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1599221371")) {
            ipChange.ipc$dispatch("1599221371", new Object[]{this, activity});
        } else {
            DogCat.INSTANCE.z(activity);
        }
    }

    @Override // com.alibaba.pictures.ut.IUTPageOperation
    public void updateSPM(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "911059469")) {
            ipChange.ipc$dispatch("911059469", new Object[]{this, str});
        } else {
            this.b = str;
        }
    }

    @Override // com.alibaba.pictures.ut.IUTPageOperation
    public void updateUTPageProperties(@Nullable Properties properties) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-604697006")) {
            ipChange.ipc$dispatch("-604697006", new Object[]{this, properties});
            return;
        }
        if (!this.d) {
            Object obj = this.f;
            if ((obj instanceof Fragment) && (((Fragment) obj).getActivity() instanceof IUTPageOperation)) {
                FragmentActivity activity = ((Fragment) this.f).getActivity();
                Objects.requireNonNull(activity, "null cannot be cast to non-null type com.alibaba.pictures.ut.IUTPageOperation");
                ((IUTPageOperation) activity).updateUTPageProperties(properties);
                return;
            }
        }
        if (properties != null) {
            d(properties);
            DogCat.INSTANCE.C(this.c, properties);
        } else {
            Properties properties2 = new Properties();
            d(properties2);
            DogCat.INSTANCE.C(this.c, properties2);
        }
        j();
    }
}
