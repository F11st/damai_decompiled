package cn.damai.commonbusiness.screenshot;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.ArrayMap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import com.alibaba.aliweex.adapter.module.audio.IWXAudio;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import tb.ir1;
import tb.k3;
import tb.mr1;
import tb.mu0;
import tb.o62;
import tb.tc2;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class ScreenShotDetector {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final String o = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString();
    private static final String p = MediaStore.Images.Media.INTERNAL_CONTENT_URI.toString();
    private static final String[] q = {"_data", "datetaken", "date_added"};
    private static final String[] r = {"screenshot", "截屏", "截图", "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap"};
    private static ScreenShotDetector s = null;
    private Context e;
    private IScreenShotDetectorListener f;
    private IScreenShotExtraListener g;
    private final List<String> a = new ArrayList();
    public boolean b = false;
    private ContentResolver c = null;
    private ContentObserver d = null;
    private boolean h = true;
    private boolean i = true;
    Handler j = new b();
    private String[] k = {"_data", "date_added"};
    private String[] l = {"image/png", "image/jpeg"};
    private ScreenShotBean m = new ScreenShotBean();
    private StringBuilder n = new StringBuilder();

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public interface IScreenShotDetectorListener {
        void onFeedbackClick(ScreenShotBean screenShotBean, Activity activity);
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public interface IScreenShotExtraListener {
        void onDetected(String str, Activity activity);
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class a extends c {
        private static transient /* synthetic */ IpChange $ipChange;

        a(Handler handler, Context context) {
            super(handler, context);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "7511482")) {
                ipChange.ipc$dispatch("7511482", new Object[]{this, Boolean.valueOf(z), uri});
                return;
            }
            Message obtainMessage = ScreenShotDetector.this.j.obtainMessage();
            obtainMessage.obj = uri;
            ScreenShotDetector.this.j.sendMessage(obtainMessage);
            super.onChange(z, uri);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class b extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "748521159")) {
                ipChange.ipc$dispatch("748521159", new Object[]{this, message});
                return;
            }
            Uri uri = (Uri) message.obj;
            if (uri == null) {
                return;
            }
            if (uri.toString().matches(ScreenShotDetector.o) || uri.toString().matches(ScreenShotDetector.p) || uri.toString().startsWith(ScreenShotDetector.o)) {
                o62.f().h();
                if (ir1.i(mr1.STORAGE)) {
                    ScreenShotDetector.this.t(uri);
                }
            }
            super.handleMessage(message);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public static class c extends ContentObserver {
        public c(Handler handler, Context context) {
            super(handler);
            new WeakReference(context);
        }
    }

    private void e(final String str, long j) {
        tc2 j2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "549901776")) {
            ipChange.ipc$dispatch("549901776", new Object[]{this, str, Long.valueOf(j)});
        } else if (!n(str, System.currentTimeMillis() / 1000, j) || f(str) || (j2 = j(this.e)) == null) {
        } else {
            if (j2.b() && this.h) {
                return;
            }
            final Activity a2 = j2.a();
            a2.runOnUiThread(new Runnable() { // from class: cn.damai.commonbusiness.screenshot.ScreenShotDetector.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1702230841")) {
                        ipChange2.ipc$dispatch("-1702230841", new Object[]{this});
                    } else {
                        ScreenShotDetector.this.s(a2, str);
                    }
                }
            });
        }
    }

    private boolean f(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1015176158")) {
            return ((Boolean) ipChange.ipc$dispatch("-1015176158", new Object[]{this, str})).booleanValue();
        }
        if (this.a.contains(str)) {
            return true;
        }
        if (this.a.size() >= 20) {
            for (int i = 0; i < 5; i++) {
                this.a.remove(0);
            }
        }
        this.a.add(str);
        return false;
    }

    private Bundle g(String str, String[] strArr, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-786640519")) {
            return (Bundle) ipChange.ipc$dispatch("-786640519", new Object[]{this, str, strArr, str2, Integer.valueOf(i)});
        }
        if (str == null && strArr == null && str2 == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        if (str != null) {
            bundle.putString("android:query-arg-sql-selection", str);
        }
        if (strArr != null) {
            bundle.putStringArray("android:query-arg-sql-selection-args", strArr);
        }
        if (str2 != null) {
            bundle.putString("android:query-arg-sql-sort-order", str2);
        }
        bundle.putString("android:query-arg-sql-limit", i + "");
        return bundle;
    }

    @NonNull
    public static List<tc2> h(@Nullable Context context, boolean z) {
        Object obj;
        Collection values;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1969191261")) {
            return (List) ipChange.ipc$dispatch("1969191261", new Object[]{context, Boolean.valueOf(z)});
        }
        ArrayList arrayList = new ArrayList();
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object i = i(context, cls);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            obj = declaredField.get(i);
        } catch (Throwable unused) {
        }
        if (obj instanceof HashMap) {
            values = ((HashMap) obj).values();
        } else {
            if (Build.VERSION.SDK_INT >= 19 && (obj instanceof ArrayMap)) {
                values = ((ArrayMap) obj).values();
            }
            return arrayList;
        }
        for (Object obj2 : values) {
            Class<?> cls2 = obj2.getClass();
            Field declaredField2 = cls2.getDeclaredField(IWXAudio.KEY_PAUSED);
            declaredField2.setAccessible(true);
            Field declaredField3 = cls2.getDeclaredField("activity");
            declaredField3.setAccessible(true);
            Activity activity = (Activity) declaredField3.get(obj2);
            if (activity != null) {
                arrayList.add(new tc2(declaredField2.getBoolean(obj2), activity));
            }
        }
        return arrayList;
    }

    @Nullable
    public static Object i(@Nullable Context context, @Nullable Class<?> cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2128699509")) {
            return ipChange.ipc$dispatch("-2128699509", new Object[]{context, cls});
        }
        if (cls == null) {
            try {
                cls = Class.forName("android.app.ActivityThread");
            } catch (Throwable unused) {
                return null;
            }
        }
        Method method = cls.getMethod("currentActivityThread", new Class[0]);
        method.setAccessible(true);
        Object invoke = method.invoke(null, new Object[0]);
        if (invoke != null || context == null) {
            return invoke;
        }
        Field field = context.getClass().getField("mLoadedApk");
        field.setAccessible(true);
        Object obj = field.get(context);
        Field declaredField = obj.getClass().getDeclaredField("mActivityThread");
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    @Nullable
    public static tc2 j(@Nullable Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-848336082")) {
            return (tc2) ipChange.ipc$dispatch("-848336082", new Object[]{context});
        }
        List<tc2> h = h(context, false);
        if (h.isEmpty()) {
            return null;
        }
        return h.get(0);
    }

    public static ScreenShotDetector k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1027227109")) {
            return (ScreenShotDetector) ipChange.ipc$dispatch("-1027227109", new Object[0]);
        }
        synchronized (ScreenShotDetector.class) {
            if (s == null) {
                s = new ScreenShotDetector();
            }
        }
        return s;
    }

    private static boolean n(String str, long j, long j2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "617011580") ? ((Boolean) ipChange.ipc$dispatch("617011580", new Object[]{str, Long.valueOf(j), Long.valueOf(j2)})).booleanValue() : q(j, j2) && p(str);
    }

    private static boolean p(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-255805403")) {
            return ((Boolean) ipChange.ipc$dispatch("-255805403", new Object[]{str})).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        for (String str2 : r) {
            if (lowerCase.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean q(long j, long j2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1699156173") ? ((Boolean) ipChange.ipc$dispatch("-1699156173", new Object[]{Long.valueOf(j), Long.valueOf(j2)})).booleanValue() : Math.abs(j - j2) <= 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(Activity activity, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "243664284")) {
            ipChange.ipc$dispatch("243664284", new Object[]{this, activity, str});
            return;
        }
        r(str);
        Activity c2 = k3.b().c();
        if (c2 != null) {
            IScreenShotExtraListener iScreenShotExtraListener = this.g;
            if (iScreenShotExtraListener != null) {
                iScreenShotExtraListener.onDetected(str, c2);
            }
        } else {
            IScreenShotExtraListener iScreenShotExtraListener2 = this.g;
            if (iScreenShotExtraListener2 != null) {
                iScreenShotExtraListener2.onDetected(str, activity);
            }
        }
        if (o()) {
            o62.f().i();
            Bundle bundle = new Bundle();
            bundle.putSerializable("screen_shot_info", this.m);
            DMNav.from(activity).withExtras(bundle).toUri(NavUri.b("screen_float"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1690858036")) {
            ipChange.ipc$dispatch("1690858036", new Object[]{this, uri});
        } else if (uri == null) {
        } else {
            Cursor cursor = null;
            if (Build.VERSION.SDK_INT >= 29) {
                ScreentShotInfo u = u();
                e(u.path, u.addTime);
                return;
            }
            try {
                cursor = this.c.query(uri, q, null, null, "date_added desc limit 1");
                if (cursor != null && cursor.moveToFirst()) {
                    e(cursor.getString(cursor.getColumnIndex("_data")), cursor.getLong(cursor.getColumnIndex("date_added")));
                }
                if (cursor == null) {
                }
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x006c, code lost:
        if (0 == 0) goto L18;
     */
    @androidx.annotation.RequiresApi(26)
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private cn.damai.commonbusiness.screenshot.ScreentShotInfo u() {
        /*
            r8 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.commonbusiness.screenshot.ScreenShotDetector.$ipChange
            java.lang.String r1 = "-1738600196"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L17
            java.lang.Object[] r2 = new java.lang.Object[r4]
            r2[r3] = r8
            java.lang.Object r0 = r0.ipc$dispatch(r1, r2)
            cn.damai.commonbusiness.screenshot.ScreentShotInfo r0 = (cn.damai.commonbusiness.screenshot.ScreentShotInfo) r0
            return r0
        L17:
            cn.damai.commonbusiness.screenshot.ScreentShotInfo r0 = new cn.damai.commonbusiness.screenshot.ScreentShotInfo
            r0.<init>()
            java.lang.String r1 = "external"
            android.net.Uri r1 = android.provider.MediaStore.Files.getContentUri(r1)
            java.lang.String[] r2 = r8.l
            java.lang.String r5 = "media_type=1 AND mime_type=? or mime_type=?"
            java.lang.String r6 = "_id DESC"
            android.os.Bundle r2 = r8.g(r5, r2, r6, r4)
            r5 = 0
            android.app.Application r6 = tb.mu0.a()     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L68
            android.content.ContentResolver r6 = r6.getContentResolver()     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L68
            java.lang.String[] r7 = r8.k     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L68
            android.database.Cursor r5 = r6.query(r1, r7, r2, r5)     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L68
            if (r5 != 0) goto L43
            if (r5 == 0) goto L42
            r5.close()
        L42:
            return r0
        L43:
            boolean r1 = r5.moveToFirst()     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L68
            if (r1 == 0) goto L6e
            java.lang.String[] r1 = r8.k     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L68
            r1 = r1[r3]     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L68
            int r1 = r5.getColumnIndexOrThrow(r1)     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L68
            java.lang.String r1 = r5.getString(r1)     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L68
            java.lang.String[] r2 = r8.k     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L68
            r2 = r2[r4]     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L68
            int r2 = r5.getColumnIndexOrThrow(r2)     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L68
            long r2 = r5.getLong(r2)     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L68
            r0.path = r1     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L68
            r0.addTime = r2     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L68
            goto L6e
        L66:
            r0 = move-exception
            goto L72
        L68:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L66
            if (r5 == 0) goto L71
        L6e:
            r5.close()
        L71:
            return r0
        L72:
            if (r5 == 0) goto L77
            r5.close()
        L77:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.commonbusiness.screenshot.ScreenShotDetector.u():cn.damai.commonbusiness.screenshot.ScreentShotInfo");
    }

    public void A(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "555835436")) {
            ipChange.ipc$dispatch("555835436", new Object[]{this, context});
            return;
        }
        this.a.clear();
        this.e = context.getApplicationContext();
        this.c = mu0.a().getContentResolver();
        a aVar = new a(null, context);
        this.d = aVar;
        this.c.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, aVar);
        this.c.registerContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, true, this.d);
    }

    public void B() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1064435932")) {
            ipChange.ipc$dispatch("-1064435932", new Object[]{this});
            return;
        }
        ContentResolver contentResolver = this.c;
        if (contentResolver != null) {
            contentResolver.unregisterContentObserver(this.d);
            this.c = null;
        }
        this.a.clear();
    }

    public ScreenShotBean l() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1239360208") ? (ScreenShotBean) ipChange.ipc$dispatch("1239360208", new Object[]{this}) : this.m;
    }

    public IScreenShotDetectorListener m() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2064628139") ? (IScreenShotDetectorListener) ipChange.ipc$dispatch("2064628139", new Object[]{this}) : this.f;
    }

    public boolean o() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1451035603") ? ((Boolean) ipChange.ipc$dispatch("1451035603", new Object[]{this})).booleanValue() : this.i;
    }

    public ScreenShotBean r(String str) {
        Set<String> keySet;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1175996708")) {
            return (ScreenShotBean) ipChange.ipc$dispatch("-1175996708", new Object[]{this, str});
        }
        if (k3.b().c() == null || this.b) {
            return null;
        }
        StringBuilder sb = this.n;
        sb.delete(0, sb.length());
        if (this.m == null) {
            this.m = new ScreenShotBean();
        }
        this.m.clear();
        Activity c2 = k3.b().c();
        if (c2 != null) {
            String name = c2.getClass().getName();
            if (!TextUtils.isEmpty(name)) {
                this.m.put("fromPage", name);
                String[] split = name.split("\\.");
                if (split != null && split.length > 2) {
                    this.m.put("module", split[2]);
                }
            }
            Bundle extras = c2.getIntent() != null ? c2.getIntent().getExtras() : null;
            if (extras != null && (keySet = extras.keySet()) != null) {
                for (String str2 : keySet) {
                    Object obj = extras.get(str2);
                    if (obj != null && obj.toString() != null) {
                        StringBuilder sb2 = this.n;
                        sb2.append(str2);
                        sb2.append("=");
                        sb2.append(obj.toString());
                        sb2.append("&");
                    }
                }
                if (this.n.length() > 0) {
                    StringBuilder sb3 = this.n;
                    sb3.delete(sb3.length() - 1, this.n.length());
                }
                this.m.put("extra", this.n.toString());
            }
        }
        return this.m;
    }

    public void v(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1514513807")) {
            ipChange.ipc$dispatch("-1514513807", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.h = z;
        }
    }

    public void w(IScreenShotDetectorListener iScreenShotDetectorListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "170942161")) {
            ipChange.ipc$dispatch("170942161", new Object[]{this, iScreenShotDetectorListener});
        } else {
            this.f = iScreenShotDetectorListener;
        }
    }

    public void x(IScreenShotExtraListener iScreenShotExtraListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "219446735")) {
            ipChange.ipc$dispatch("219446735", new Object[]{this, iScreenShotExtraListener});
        } else {
            this.g = iScreenShotExtraListener;
        }
    }

    public void y(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1271563013")) {
            ipChange.ipc$dispatch("1271563013", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.i = z;
        }
    }

    public void z(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2031379749")) {
            ipChange.ipc$dispatch("2031379749", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.b = z;
        }
    }
}
