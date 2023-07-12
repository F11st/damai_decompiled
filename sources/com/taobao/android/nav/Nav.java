package com.taobao.android.nav;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadPoolExecutor;
import tb.c42;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class Nav {
    private static final NavResolver DEFAULT_RESOLVER;
    public static final String KExtraReferrer = "referrer";
    private static final String TAG = "Nav";
    private static NavExceptionHandler mExceptionHandler;
    private static volatile NavResolver mNavResolver;
    private static int[] mTransition;
    private boolean mAllowLeaving;
    private final Context mContext;
    private boolean mDisableTransition;
    private boolean mDisallowLoopback;
    private boolean mSkipHooker;
    private boolean mSkipPreprocess;
    private boolean mSkipPriorHooker;
    private List<Intent> mTaskStack;
    private static final List<NavPreprocessor> mPreprocessor = new CopyOnWriteArrayList();
    private static final List<NavPreprocessor> mStickPreprocessor = new ArrayList();
    private static final SparseArray<NavHooker> mPriorHookers = new SparseArray<>();
    private static NavigationTimeMonitor sNavMonitor = null;
    private int mRequestCode = -1;
    private final Intent mIntent = new Intent("android.intent.action.VIEW");

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static final class DefaultResovler implements NavResolver {
        private DefaultResovler() {
        }

        @Override // com.taobao.android.nav.Nav.NavResolver
        public List<ResolveInfo> queryIntentActivities(PackageManager packageManager, Intent intent, int i) {
            return packageManager.queryIntentActivities(intent, i);
        }

        @Override // com.taobao.android.nav.Nav.NavResolver
        public ResolveInfo resolveActivity(PackageManager packageManager, Intent intent, int i) {
            return packageManager.resolveActivity(intent, i);
        }
    }

    /* compiled from: Taobao */
    @SuppressLint({"Registered"})
    /* loaded from: classes12.dex */
    static class DemoActivity extends Activity {
        DemoActivity() {
        }

        void buildTaskStack(Uri uri, Uri uri2) {
            Nav.from(this).stack(uri).toUri(uri2);
        }

        void openItem(long j) {
            Nav.from(this).toUri(NavUri.host("item.taobao.com").path("item.htm").param("id", j));
        }

        void openUriWithinWebview(Uri uri) {
            Nav from = Nav.from(this);
            if (from.disallowLoopback().toUri(uri)) {
                return;
            }
            from.skipPreprocess().allowEscape().toUri(uri);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface NavExceptionHandler {
        boolean onException(Intent intent, Exception exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class NavHookIntent extends Intent {
        private NavHookIntent() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface NavHooker {
        public static final int NAVHOOKER_HIGH_PRIORITY = 3;
        public static final int NAVHOOKER_LOW_PRIORITY = 1;
        public static final int NAVHOOKER_NORMAL_PRIORITY = 2;
        public static final int NAVHOOKER_STICKMAX_PRIORITY = 4;

        boolean hook(Context context, Intent intent);
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface NavPreprocessor {
        boolean beforeNavTo(Intent intent);
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface NavResolver {
        List<ResolveInfo> queryIntentActivities(PackageManager packageManager, Intent intent, int i);

        ResolveInfo resolveActivity(PackageManager packageManager, Intent intent, int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class NavigationCanceledException extends Exception {
        private static final long serialVersionUID = 5015146091187397488L;

        public NavigationCanceledException(String str) {
            super(str);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface NavigationTimeMonitor {
        void threadRunTimeInfo(String str, int i, long j, long j2, long j3, String str2, int i2, ThreadPoolExecutor threadPoolExecutor);
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface RedirectNavPreprocessor extends NavPreprocessor {
        boolean beforeNavTo(Nav nav, Intent intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public final class SortedResolveInfo implements Comparable<SortedResolveInfo> {
        private final ResolveInfo info;
        private int same;
        private int weight;

        public SortedResolveInfo(ResolveInfo resolveInfo, int i, int i2) {
            this.weight = 0;
            this.same = 0;
            this.info = resolveInfo;
            this.weight = i;
            this.same = i2;
        }

        @Override // java.lang.Comparable
        public int compareTo(SortedResolveInfo sortedResolveInfo) {
            if (this == sortedResolveInfo) {
                return 0;
            }
            int i = sortedResolveInfo.weight;
            int i2 = this.weight;
            if (i != i2) {
                return i - i2;
            }
            int i3 = sortedResolveInfo.same;
            int i4 = this.same;
            return i3 != i4 ? i3 - i4 : System.identityHashCode(this) < System.identityHashCode(sortedResolveInfo) ? -1 : 1;
        }
    }

    static {
        DefaultResovler defaultResovler = new DefaultResovler();
        DEFAULT_RESOLVER = defaultResovler;
        mNavResolver = defaultResovler;
    }

    private Nav(Context context) {
        this.mContext = context;
    }

    public static Nav from(Context context) {
        return new Nav(context);
    }

    @TargetApi(11)
    private static PendingIntent getActivities(Context context, int i, Intent[] intentArr, int i2) {
        return getActivities(context, i, intentArr, i2);
    }

    private boolean isDebug() {
        return (this.mContext.getApplicationInfo().flags & 2) != 0;
    }

    private ResolveInfo optimum(List<ResolveInfo> list) {
        if (list == null) {
            return null;
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : list) {
            if (!TextUtils.isEmpty(resolveInfo.activityInfo.packageName)) {
                if (resolveInfo.activityInfo.packageName.endsWith(this.mContext.getPackageName())) {
                    arrayList.add(new SortedResolveInfo(resolveInfo, resolveInfo.priority, 1));
                } else {
                    String str = resolveInfo.activityInfo.packageName;
                    String packageName = this.mContext.getPackageName();
                    String[] split = str.split("\\.");
                    String[] split2 = packageName.split("\\.");
                    if (split.length >= 2 && split2.length >= 2 && split[0].equals(split2[0]) && split[1].equals(split2[1])) {
                        arrayList.add(new SortedResolveInfo(resolveInfo, resolveInfo.priority, 0));
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            if (arrayList.size() > 1) {
                Collections.sort(arrayList);
            }
            ResolveInfo resolveInfo2 = ((SortedResolveInfo) arrayList.get(0)).info;
            arrayList.clear();
            return resolveInfo2;
        }
        return null;
    }

    public static void registerHooker(NavHooker navHooker) {
        mPriorHookers.put(4, navHooker);
    }

    public static void registerNavMonitor(NavigationTimeMonitor navigationTimeMonitor) {
        sNavMonitor = navigationTimeMonitor;
    }

    public static void registerPreprocessor(NavPreprocessor navPreprocessor) {
        mPreprocessor.add(navPreprocessor);
    }

    public static void registerPriorHooker(NavHooker navHooker, int i) {
        if (i <= 3 && i >= 1) {
            mPriorHookers.put(i, navHooker);
            return;
        }
        throw new RuntimeException("NavHooker's priority less than NAVHOOKER_HIGH_PRIORITY, larger than NAVHOOKER_LOW_PRIORITY");
    }

    public static void registerStickPreprocessor(NavPreprocessor navPreprocessor) {
        mStickPreprocessor.add(navPreprocessor);
    }

    public static void setExceptionHandler(NavExceptionHandler navExceptionHandler) {
        mExceptionHandler = navExceptionHandler;
    }

    public static void setNavResolver(NavResolver navResolver) {
        mNavResolver = navResolver;
    }

    public static void setTransition(int i, int i2) {
        mTransition = r0;
        int[] iArr = {i, i2};
    }

    private Intent specify(Intent intent) {
        ResolveInfo optimum;
        if (this.mAllowLeaving || (optimum = optimum(mNavResolver.queryIntentActivities(this.mContext.getPackageManager(), intent, 65536))) == null) {
            return intent;
        }
        ActivityInfo activityInfo = optimum.activityInfo;
        intent.setClassName(activityInfo.packageName, activityInfo.name);
        return intent;
    }

    @TargetApi(11)
    private void startActivities(Intent[] intentArr) {
        this.mContext.startActivities(intentArr);
    }

    private Intent to(Uri uri) {
        return to(uri, !this.mSkipPreprocess);
    }

    public static void unregisterPreprocessor(NavPreprocessor navPreprocessor) {
        mPreprocessor.remove(navPreprocessor);
    }

    public static void unregisterStickPreprocessor(NavPreprocessor navPreprocessor) {
        mStickPreprocessor.remove(navPreprocessor);
    }

    public Nav allowEscape() {
        this.mAllowLeaving = true;
        return this;
    }

    public Nav allowLoopback() {
        this.mDisallowLoopback = false;
        return this;
    }

    public Nav disableTransition() {
        this.mDisableTransition = true;
        return this;
    }

    public Nav disallowLoopback() {
        this.mDisallowLoopback = true;
        return this;
    }

    public Nav forResult(int i) {
        if (this.mContext instanceof Activity) {
            this.mRequestCode = i;
            return this;
        }
        throw new IllegalStateException("Only valid from Activity, but from " + this.mContext);
    }

    public Nav skipHooker() {
        this.mSkipHooker = true;
        return this;
    }

    public Nav skipPreprocess() {
        this.mSkipPreprocess = true;
        return this;
    }

    public Nav skipPriorHooker() {
        this.mSkipPriorHooker = true;
        return this;
    }

    @TargetApi(11)
    public Nav stack(Uri uri) {
        if (this.mRequestCode < 0) {
            Intent intent = new Intent(to(uri, false));
            if (this.mTaskStack == null) {
                this.mTaskStack = new ArrayList(1);
                intent.addFlags(268435456);
                if (Build.VERSION.SDK_INT >= 11) {
                    intent.addFlags(49152);
                }
            }
            this.mTaskStack.add(intent);
            Nav nav = new Nav(this.mContext);
            nav.mTaskStack = this.mTaskStack;
            return nav;
        }
        throw new IllegalStateException("Cannot stack URI for result");
    }

    public PendingIntent toPendingUri(Uri uri, int i, int i2) {
        Intent specify = specify(to(uri, false));
        if (specify == null) {
            return null;
        }
        List<Intent> list = this.mTaskStack;
        if (list != null && Build.VERSION.SDK_INT >= 11) {
            list.add(this.mIntent);
            Context context = this.mContext;
            List<Intent> list2 = this.mTaskStack;
            return getActivities(context, i, (Intent[]) list2.toArray(new Intent[list2.size()]), i2);
        }
        specify.addFlags(268435456);
        return PendingIntent.getActivity(this.mContext, i, specify, i2);
    }

    public boolean toUri(NavUri navUri) {
        return toUri(navUri.build());
    }

    public Nav withCategory(String str) {
        this.mIntent.addCategory(str);
        return this;
    }

    public Nav withExtras(Bundle bundle) {
        if (bundle == null) {
            return this;
        }
        this.mIntent.putExtras(bundle);
        return this;
    }

    public Nav withFlags(int i) {
        this.mIntent.addFlags(i);
        return this;
    }

    private Intent to(Uri uri, boolean z) {
        boolean beforeNavTo;
        NavHooker navHooker;
        this.mIntent.setData(uri);
        NavHooker navHooker2 = mPriorHookers.get(4);
        if (!this.mSkipHooker && navHooker2 != null && !navHooker2.hook(this.mContext, this.mIntent)) {
            return new NavHookIntent();
        }
        if (!this.mSkipPriorHooker) {
            int i = 0;
            while (true) {
                SparseArray<NavHooker> sparseArray = mPriorHookers;
                if (i >= sparseArray.size()) {
                    break;
                }
                int keyAt = sparseArray.keyAt(i);
                if (keyAt != 4 && (navHooker = sparseArray.get(keyAt)) != null && !navHooker.hook(this.mContext, this.mIntent)) {
                    return new NavHookIntent();
                }
                i++;
            }
        }
        if (!this.mIntent.hasExtra("referrer")) {
            Context context = this.mContext;
            if (context instanceof Activity) {
                Intent intent = ((Activity) context).getIntent();
                if (intent != null) {
                    Uri data = intent.getData();
                    if (data != null) {
                        this.mIntent.putExtra("referrer", data.toString());
                    } else {
                        ComponentName component = intent.getComponent();
                        if (component != null) {
                            this.mIntent.putExtra("referrer", new Intent().setComponent(component).toUri(0));
                        } else {
                            this.mIntent.putExtra("referrer", intent.toUri(0));
                        }
                    }
                }
            } else {
                this.mIntent.putExtra("referrer", context.getPackageName());
            }
        }
        int myTid = Process.myTid();
        System.currentTimeMillis();
        Debug.threadCpuTimeNanos();
        List<NavPreprocessor> list = mStickPreprocessor;
        if (!list.isEmpty()) {
            for (NavPreprocessor navPreprocessor : list) {
                long currentTimeMillis = System.currentTimeMillis();
                long threadCpuTimeNanos = Debug.threadCpuTimeNanos();
                boolean beforeNavTo2 = navPreprocessor.beforeNavTo(this.mIntent);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                long threadCpuTimeNanos2 = Debug.threadCpuTimeNanos() - threadCpuTimeNanos;
                NavigationTimeMonitor navigationTimeMonitor = sNavMonitor;
                if (navigationTimeMonitor != null) {
                    navigationTimeMonitor.threadRunTimeInfo(navPreprocessor.getClass().getSimpleName(), myTid, currentTimeMillis, currentTimeMillis2, threadCpuTimeNanos2, "", 0, null);
                    continue;
                }
                if (!beforeNavTo2) {
                    return null;
                }
            }
        }
        if (z) {
            List<NavPreprocessor> list2 = mPreprocessor;
            if (!list2.isEmpty()) {
                for (NavPreprocessor navPreprocessor2 : list2) {
                    long currentTimeMillis3 = System.currentTimeMillis();
                    long threadCpuTimeNanos3 = Debug.threadCpuTimeNanos();
                    if (navPreprocessor2 instanceof RedirectNavPreprocessor) {
                        beforeNavTo = ((RedirectNavPreprocessor) navPreprocessor2).beforeNavTo(this, this.mIntent);
                    } else {
                        beforeNavTo = navPreprocessor2.beforeNavTo(this.mIntent);
                    }
                    boolean z2 = beforeNavTo;
                    long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis3;
                    long threadCpuTimeNanos4 = Debug.threadCpuTimeNanos() - threadCpuTimeNanos3;
                    NavigationTimeMonitor navigationTimeMonitor2 = sNavMonitor;
                    if (navigationTimeMonitor2 != null) {
                        navigationTimeMonitor2.threadRunTimeInfo(navPreprocessor2.getClass().getSimpleName(), myTid, currentTimeMillis3, currentTimeMillis4, threadCpuTimeNanos4, "", 0, null);
                        continue;
                    }
                    if (!z2) {
                        return null;
                    }
                }
            }
        }
        return this.mIntent;
    }

    public boolean toUri(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return toUri(Uri.parse(str));
    }

    public boolean toUri(Uri uri) {
        ComponentName component;
        int[] iArr;
        Log.d(TAG, uri.toString());
        NavExceptionHandler navExceptionHandler = mExceptionHandler;
        Intent intent = to(uri);
        if (intent == null) {
            if (navExceptionHandler != null) {
                navExceptionHandler.onException(this.mIntent, new NavigationCanceledException("Intent resolve was null"));
            }
            return false;
        } else if (intent instanceof NavHookIntent) {
            return true;
        } else {
            if (this.mContext == null) {
                if (navExceptionHandler != null) {
                    navExceptionHandler.onException(this.mIntent, new NavigationCanceledException("Context shouldn't null"));
                }
                Log.e(TAG, "Nav context was null");
                return false;
            }
            while (true) {
                try {
                    if (this.mAllowLeaving) {
                        ResolveInfo resolveActivity = mNavResolver.resolveActivity(this.mContext.getPackageManager(), intent, 65536);
                        if (resolveActivity == null) {
                            List<ResolveInfo> queryIntentActivities = mNavResolver.queryIntentActivities(this.mContext.getPackageManager(), intent, 65536);
                            ResolveInfo resolveInfo = (queryIntentActivities == null || queryIntentActivities.size() < 1) ? null : queryIntentActivities.get(0);
                            if (resolveInfo != null) {
                                ActivityInfo activityInfo = resolveInfo.activityInfo;
                                component = new ComponentName(activityInfo.packageName, activityInfo.name);
                            } else {
                                throw new ActivityNotFoundException("No Activity found to handle " + intent);
                            }
                        } else {
                            ActivityInfo activityInfo2 = resolveActivity.activityInfo;
                            component = new ComponentName(activityInfo2.packageName, activityInfo2.name);
                        }
                    } else if (!c42.a(this.mContext)) {
                        intent.setPackage(this.mContext.getPackageName());
                        ResolveInfo resolveActivity2 = mNavResolver.resolveActivity(this.mContext.getPackageManager(), intent, 65536);
                        if (resolveActivity2 == null) {
                            ResolveInfo optimum = optimum(mNavResolver.queryIntentActivities(this.mContext.getPackageManager(), intent, 65536));
                            if (optimum != null) {
                                ActivityInfo activityInfo3 = optimum.activityInfo;
                                intent.setClassName(activityInfo3.packageName, activityInfo3.name);
                            } else {
                                throw new ActivityNotFoundException("No Activity found to handle " + intent);
                            }
                        } else {
                            ActivityInfo activityInfo4 = resolveActivity2.activityInfo;
                            intent.setClassName(activityInfo4.packageName, activityInfo4.name);
                        }
                        component = intent.getComponent();
                    } else {
                        ResolveInfo optimum2 = optimum(mNavResolver.queryIntentActivities(this.mContext.getPackageManager(), intent, 65536));
                        if (optimum2 != null) {
                            ActivityInfo activityInfo5 = optimum2.activityInfo;
                            intent.setClassName(activityInfo5.packageName, activityInfo5.name);
                            component = intent.getComponent();
                        } else {
                            throw new ActivityNotFoundException("No Activity found to handle " + intent);
                        }
                    }
                    if (this.mDisallowLoopback) {
                        Context context = this.mContext;
                        if ((context instanceof Activity) && component != null && component.equals(((Activity) context).getComponentName())) {
                            Log.w(TAG, "Loopback disallowed: " + uri);
                            return false;
                        }
                    }
                    List<Intent> list = this.mTaskStack;
                    if (list != null && Build.VERSION.SDK_INT >= 11) {
                        list.add(this.mIntent);
                        List<Intent> list2 = this.mTaskStack;
                        startActivities((Intent[]) list2.toArray(new Intent[list2.size()]));
                    } else {
                        int i = this.mRequestCode;
                        if (i >= 0) {
                            ((Activity) this.mContext).startActivityForResult(intent, i);
                        } else {
                            if (!(this.mContext instanceof Activity)) {
                                intent.addFlags(268435456);
                            }
                            this.mContext.startActivity(intent);
                        }
                    }
                    if (!this.mDisableTransition && (iArr = mTransition) != null) {
                        Context context2 = this.mContext;
                        if (context2 instanceof Activity) {
                            ((Activity) context2).overridePendingTransition(iArr[0], iArr[1]);
                        }
                    }
                    if (isDebug()) {
                        String uri2 = intent.getData().toString();
                        if (uri2.length() > 5120) {
                            Toast.makeText(this.mContext, "Your url : " + uri2 + " is too large which may cause Exception, plz check it!", 1).show();
                        }
                    }
                    return true;
                } catch (ActivityNotFoundException e) {
                    if (isDebug()) {
                        Toast.makeText(this.mContext, uri.toString() + " CANN'T FOUND RESOLVED ACTIVITY", 1).show();
                    }
                    if (navExceptionHandler == null || !navExceptionHandler.onException(intent, e)) {
                        return false;
                    }
                    navExceptionHandler = null;
                }
            }
            return false;
        }
    }
}
