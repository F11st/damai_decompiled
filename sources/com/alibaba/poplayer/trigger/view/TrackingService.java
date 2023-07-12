package com.alibaba.poplayer.trigger.view;

import android.app.Activity;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.poplayer.factory.view.base.PopLayerBaseView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import tb.dt1;
import tb.fw2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class TrackingService {
    public static final String OPER_INFO = "info";
    public static final String OPER_MIRROR = "mirror";
    public static final String OPER_TRACK = "track";
    public static final String OPER_UNMIRROR = "unmirror";
    public static final String OPER_UNTRACK = "untrack";
    public static final String TAG = "TrackingService";
    public static final String TASK_OPER_REMOVE_ACTIVE_LAUNCHED = "removeActiveLaunched";
    public static final String TASK_OPER_REMOVE_ALL = "removeALL";
    public static final String TASK_OPER_REMOVE_ALL_LAUNCHED = "removeAllLaunchedByView";
    public static final String TASK_OPER_STOP = "stop";
    public static final String TASK_OPER_STOP_WITH_ID = "stopWithId";
    private static C3698c f = new C3698c();
    private static C3697b g = new C3697b();
    private static final ISOTaskMatcher h = new C3687b();
    private static final ISOTaskMatcher i = new C3688c();
    private static final ISOTaskMatcher j = new C3689d();
    private static final ISOTaskMatcher k = new C3690e();
    private static final ISOTaskMatcher l = new C3691f();
    private static final ISOTaskMatcher m = new C3692g();
    private boolean b;
    private final WeakReference<Activity> d;
    private final C3695a<C3694i> a = new C3695a<>();
    private final ViewTreeObserver.OnPreDrawListener e = new ViewTreeObserver$OnPreDrawListenerC3686a();
    private boolean c = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface ISOTaskMatcher {
        boolean match(View view, ViewConfigItem viewConfigItem, C3694i c3694i, Object... objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface OnSTaskInvokeListener {
        void OnTargetViewAdded(View view, C3694i c3694i);

        void OnTargetViewRemoved(View view, C3694i c3694i, boolean z);
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.poplayer.trigger.view.TrackingService$a */
    /* loaded from: classes8.dex */
    class ViewTreeObserver$OnPreDrawListenerC3686a implements ViewTreeObserver.OnPreDrawListener {
        ViewTreeObserver$OnPreDrawListenerC3686a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            try {
                TrackingService.this.l();
            } catch (Throwable unused) {
            }
            return true;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.poplayer.trigger.view.TrackingService$b */
    /* loaded from: classes8.dex */
    static class C3687b implements ISOTaskMatcher {
        C3687b() {
        }

        @Override // com.alibaba.poplayer.trigger.view.TrackingService.ISOTaskMatcher
        public boolean match(View view, ViewConfigItem viewConfigItem, C3694i c3694i, Object... objArr) {
            View view2 = c3694i.l;
            return view2 != null && view2 == view;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.poplayer.trigger.view.TrackingService$c */
    /* loaded from: classes8.dex */
    static class C3688c implements ISOTaskMatcher {
        C3688c() {
        }

        @Override // com.alibaba.poplayer.trigger.view.TrackingService.ISOTaskMatcher
        public boolean match(View view, ViewConfigItem viewConfigItem, C3694i c3694i, Object... objArr) {
            if (objArr == null || objArr.length < 2) {
                return false;
            }
            String str = (String) objArr[0];
            String str2 = (String) objArr[1];
            View view2 = c3694i.l;
            return view2 != null && view2 == view && c3694i.a.equals(str) && c3694i.f.equals(str2);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.poplayer.trigger.view.TrackingService$d */
    /* loaded from: classes8.dex */
    static class C3689d implements ISOTaskMatcher {
        C3689d() {
        }

        @Override // com.alibaba.poplayer.trigger.view.TrackingService.ISOTaskMatcher
        public boolean match(View view, ViewConfigItem viewConfigItem, C3694i c3694i, Object... objArr) {
            if (objArr == null || objArr.length == 0) {
                return false;
            }
            String str = (String) objArr[0];
            View view2 = c3694i.l;
            return view2 != null && view2 == view && c3694i.b.equals(str) && !c3694i.f();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.poplayer.trigger.view.TrackingService$e */
    /* loaded from: classes8.dex */
    static class C3690e implements ISOTaskMatcher {
        C3690e() {
        }

        @Override // com.alibaba.poplayer.trigger.view.TrackingService.ISOTaskMatcher
        public boolean match(View view, ViewConfigItem viewConfigItem, C3694i c3694i, Object... objArr) {
            return viewConfigItem == c3694i.j;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.poplayer.trigger.view.TrackingService$f */
    /* loaded from: classes8.dex */
    static class C3691f implements ISOTaskMatcher {
        C3691f() {
        }

        @Override // com.alibaba.poplayer.trigger.view.TrackingService.ISOTaskMatcher
        public boolean match(View view, ViewConfigItem viewConfigItem, C3694i c3694i, Object... objArr) {
            if (objArr == null || objArr.length == 0) {
                return false;
            }
            return view == c3694i.l && ((String) objArr[0]).equals(c3694i.i.uri);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.poplayer.trigger.view.TrackingService$g */
    /* loaded from: classes8.dex */
    static class C3692g implements ISOTaskMatcher {
        C3692g() {
        }

        @Override // com.alibaba.poplayer.trigger.view.TrackingService.ISOTaskMatcher
        public boolean match(View view, ViewConfigItem viewConfigItem, C3694i c3694i, Object... objArr) {
            if (objArr == null || objArr.length == 0) {
                return false;
            }
            return c3694i.o.equals((String) objArr[0]);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.poplayer.trigger.view.TrackingService$h */
    /* loaded from: classes8.dex */
    public class C3693h extends C3694i {
        public C3693h(TrackingService trackingService, String str, View view, String str2, String str3, String str4, boolean z, boolean z2, String str5, ViewEvent viewEvent, ViewConfigItem viewConfigItem, OnSTaskInvokeListener onSTaskInvokeListener) {
            super(str, view, str2, str3, str4, z, z2, str5, viewEvent, viewConfigItem, onSTaskInvokeListener);
            this.h = 1;
            SparseArray<WeakReference<View>> sparseArray = new SparseArray<>();
            this.g = sparseArray;
            sparseArray.put(0, new WeakReference<>(view));
            onSTaskInvokeListener.OnTargetViewAdded(view, this);
        }

        @Override // com.alibaba.poplayer.trigger.view.TrackingService.C3694i
        boolean g(boolean z) {
            return z;
        }

        @Override // com.alibaba.poplayer.trigger.view.TrackingService.C3694i
        public boolean h() {
            return true;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.poplayer.trigger.view.TrackingService$i */
    /* loaded from: classes8.dex */
    public class C3694i {
        public String a;
        public final String b;
        public final String c;
        public final boolean d;
        public boolean e;
        public final String f;
        public final ViewEvent i;
        public final ViewConfigItem j;
        public boolean k;
        public View l;
        public String m;
        public OnSTaskInvokeListener n;
        public int h = 1;
        public final String o = String.valueOf(System.currentTimeMillis());
        protected SparseArray<WeakReference<View>> g = new SparseArray<>();

        public C3694i(String str, View view, String str2, String str3, String str4, boolean z, boolean z2, String str5, ViewEvent viewEvent, ViewConfigItem viewConfigItem, OnSTaskInvokeListener onSTaskInvokeListener) {
            this.m = str;
            this.l = view;
            this.b = str3;
            this.c = str4;
            this.d = z;
            this.e = z2;
            this.f = str5;
            this.i = viewEvent;
            this.j = viewConfigItem;
            this.n = onSTaskInvokeListener;
            e(str2);
        }

        @Nullable
        private View[] c(String str) throws ClassNotFoundException, JSONException {
            int i;
            View[] l = TrackingService.f.l(this.a, this.d);
            if (l != null && (i = this.h) <= l.length) {
                return (l.length <= i || i == 0) ? l : (View[]) Arrays.copyOfRange(l, 0, i);
            } else if (this.e) {
                dt1.b("STask$Runner.selectAndOperate.selectedViews.withSelector{%s}.fail.scheduleLater", this.a);
                return null;
            } else {
                dt1.b("STask$Runner.selectAndOperate.selectedViews.withSelector{%s}.fail.abandonSchedule", this.a);
                j(str, false, "Select.NotFound");
                return null;
            }
        }

        private void e(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String[] split = str.split("\\?");
            this.a = split[0];
            if (split.length <= 1) {
                this.h = 1;
                return;
            }
            try {
                String[] split2 = split[1].split("=");
                String str2 = split2[0];
                String str3 = split2[1];
                if ("expectedViewSize".equals(str2)) {
                    this.h = Integer.parseInt(str3);
                }
            } catch (Throwable unused) {
                this.h = 1;
            }
        }

        @NonNull
        public void a(List<View> list) {
            this.g.clear();
            if (list == null || list.size() == 0) {
                return;
            }
            int size = list.size();
            SparseArray<WeakReference<View>> sparseArray = new SparseArray<>();
            for (int i = 0; i < size; i++) {
                sparseArray.put(i, new WeakReference<>(list.get(i)));
            }
            this.g = sparseArray;
        }

        public void b() {
            if (this.k) {
                return;
            }
            this.k = true;
            Iterator<View> it = d().iterator();
            while (it.hasNext()) {
                this.n.OnTargetViewRemoved(it.next(), this, true);
            }
            this.g.clear();
            this.l = null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NonNull
        public ArrayList<View> d() {
            SparseArray<WeakReference<View>> sparseArray = this.g;
            if (sparseArray != null && sparseArray.size() != 0) {
                int size = this.g.size();
                ArrayList<View> arrayList = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    WeakReference<View> weakReference = this.g.get(i);
                    if (weakReference != null) {
                        arrayList.add(fw2.c(weakReference));
                    }
                }
                return arrayList;
            }
            return new ArrayList<>();
        }

        protected boolean f() {
            ArrayList<View> d = d();
            if (d.size() == this.h) {
                Iterator<View> it = d.iterator();
                while (it.hasNext()) {
                    if (!fw2.g(it.next())) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }

        boolean g(boolean z) {
            return (TrackingService.OPER_MIRROR.equals(this.f) || TrackingService.OPER_TRACK.equals(this.f)) ? z || this.e : (TrackingService.OPER_UNMIRROR.equals(this.f) || TrackingService.OPER_UNTRACK.equals(this.f) || !"info".equals(this.f) || z || !this.e) ? false : true;
        }

        public boolean h() {
            String str = TrackingService.OPER_MIRROR;
            try {
                if (!TrackingService.OPER_TRACK.equals(this.f) && !TrackingService.OPER_MIRROR.equals(this.f)) {
                    if (!TrackingService.OPER_UNTRACK.equals(this.f) && !TrackingService.OPER_UNMIRROR.equals(this.f)) {
                        if ("info".equals(this.f)) {
                            View[] c = c("PopLayer.SOTask.Info");
                            if (c == null) {
                                return false;
                            }
                            TrackingService.g.b("PopLayer.SOTask.Info", c, this);
                        }
                        return true;
                    }
                    if (TrackingService.OPER_UNTRACK.equals(this.f)) {
                        str = TrackingService.OPER_TRACK;
                    }
                    TrackingService.this.m(TrackingService.i, this.l, this.j, this.a, str);
                    dt1.b("STask$Runner.removeTask success by operation:{%s}.", this.f);
                    return true;
                }
                if (f()) {
                    return true;
                }
                TrackingService.g.c("PopLayer.SOTask.Track", c("PopLayer.SOTask.Track"), this);
                return this.g.size() == this.h;
            } catch (Throwable th) {
                dt1.c("STask.Runner.error", th);
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void i(String str, String str2) {
            View view = this.l;
            if (view != null && (view instanceof PopLayerBaseView)) {
                ((PopLayerBaseView) view).onReceiveEvent(str, str2);
            } else {
                dt1.b("STask$Runner.sendTaskExecutionEventToMasterView.error:masterView is empty or isn't PopLayerBaseView.", new Object[0]);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void j(String str, boolean z, Object obj) throws JSONException {
            if (obj == null) {
                obj = new JSONObject();
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("taskHandle", this.b).put("info", obj).put("succeed", z);
            i(str, jSONObject.toString());
        }
    }

    public TrackingService(Activity activity) {
        this.d = new WeakReference<>(activity);
    }

    private void f() {
        Activity h2 = h();
        if (h2 == null) {
            dt1.b("%s.begin error,touch activity is empty.", TAG);
        } else if (this.b) {
        } else {
            this.b = true;
            ViewTreeObserver viewTreeObserver = fw2.e(h2).getViewTreeObserver();
            viewTreeObserver.removeOnPreDrawListener(this.e);
            viewTreeObserver.addOnPreDrawListener(this.e);
            dt1.b("%s.begin.", TAG);
        }
    }

    private boolean g() {
        Activity h2 = h();
        if (h2 == null) {
            dt1.b("%s.end error,touch activity is empty.", TAG);
            return false;
        }
        ViewGroup e = fw2.e(h2);
        if (e == null) {
            return false;
        }
        this.b = false;
        e.getViewTreeObserver().removeOnPreDrawListener(this.e);
        dt1.b("%s.end,mPendingTasks keep count:{%s}.", TAG, Integer.valueOf(this.a.e()));
        return true;
    }

    private boolean i(String str, String str2, ViewEvent viewEvent, ViewConfigItem viewConfigItem) {
        try {
            for (C3694i c3694i : this.a.f().b()) {
                if (!TextUtils.isEmpty(str) && str.contains(c3694i.a) && !TextUtils.isEmpty(str2) && str2.equals(c3694i.f) && !TextUtils.isEmpty(c3694i.i.uri) && c3694i.i.uri.equals(viewEvent.uri) && !TextUtils.isEmpty(c3694i.j.uuid) && c3694i.j.uuid.equals(viewConfigItem.uuid)) {
                    return true;
                }
            }
            this.a.b();
            return false;
        } finally {
            this.a.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.a.e() != 0) {
            n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(ISOTaskMatcher iSOTaskMatcher, View view, ViewConfigItem viewConfigItem, Object... objArr) {
        try {
            for (C3694i c3694i : this.a.f().b()) {
                if (iSOTaskMatcher.match(view, viewConfigItem, c3694i, objArr)) {
                    c3694i.b();
                    this.a.d(c3694i);
                }
            }
        } finally {
            this.a.b();
        }
    }

    private void n() {
        try {
            for (C3694i c3694i : this.a.f().b()) {
                if (!c3694i.g(c3694i.h())) {
                    this.a.d(c3694i);
                }
            }
        } finally {
            this.a.b();
        }
    }

    private void p(C3694i c3694i, boolean z) {
        dt1.b("scheduleSOTask.immediate{%s}", Boolean.valueOf(z));
        if (z) {
            if (c3694i.g(c3694i.h())) {
                this.a.a(c3694i);
                return;
            }
            return;
        }
        this.a.a(c3694i);
    }

    public Activity h() {
        return (Activity) fw2.c(this.d);
    }

    public void j() {
        this.c = false;
        g();
        try {
            for (C3694i c3694i : this.a.f().b()) {
                if (!c3694i.j.embed) {
                    c3694i.b();
                    this.a.d(c3694i);
                }
            }
            this.a.b();
            this.b = false;
            f.b();
        } catch (Throwable th) {
            this.a.b();
            throw th;
        }
    }

    public void k(View view, String str, String str2, ViewConfigItem viewConfigItem, String str3) {
        if ("stop".equals(str2)) {
            m(j, view, viewConfigItem, str);
        } else if (TASK_OPER_REMOVE_ALL_LAUNCHED.equals(str2)) {
            m(h, view, viewConfigItem, new Object[0]);
        } else if (TASK_OPER_REMOVE_ALL.equals(str2)) {
            m(k, view, viewConfigItem, new Object[0]);
        } else if (TASK_OPER_REMOVE_ACTIVE_LAUNCHED.equals(str2)) {
            m(l, view, viewConfigItem, str);
        } else if (TASK_OPER_STOP_WITH_ID.equals(str2)) {
            m(m, view, viewConfigItem, str3);
        }
    }

    public C3694i o(String str, View view, String str2, String str3, String str4, boolean z, boolean z2, String str5, ViewEvent viewEvent, ViewConfigItem viewConfigItem, OnSTaskInvokeListener onSTaskInvokeListener, boolean z3) throws JSONException {
        C3694i c3694i;
        if (i(str2, str5, viewEvent, viewConfigItem)) {
            dt1.b("%s.scheduleSTask.but already contains.", TAG);
            return null;
        }
        if (TextUtils.isEmpty(str2) && view != null) {
            c3694i = new C3693h(this, str, view, str2, str3, str4, z, z2, str5, viewEvent, viewConfigItem, onSTaskInvokeListener);
        } else {
            c3694i = new C3694i(str, view, str2, str3, str4, z, z2, str5, viewEvent, viewConfigItem, onSTaskInvokeListener);
        }
        p(c3694i, z3);
        if (this.c) {
            f();
        }
        return c3694i;
    }

    public void q() {
        this.c = true;
        if (this.a.e() > 0) {
            f();
        }
    }
}
