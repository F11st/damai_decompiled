package cn.damai.common.nav;

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
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import cn.damai.common.AppConfig;
import cn.damai.uikit.nav.INav;
import cn.damai.uikit.nav.INavUri;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.widget.DXRecyclerLayout;
import com.youku.alixplayer.opensdk.statistics.StaticsUtil;
import com.youku.media.arch.instruments.statistics.ConfigReporter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import tb.b23;
import tb.c42;
import tb.k3;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class DMNav extends INav {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final NavResolver DEFAULT_RESOLVER;
    public static final String KExtraReferrer = "referrer";
    public static final String KRequestCodeReferrer = "DMNav_KRequestCodeReferrer";
    private static final String TAG = "DMNav";
    private static NavExceptionHandler mExceptionHandler;
    private static volatile NavResolver mNavResolver;
    private static int[] mTransition;
    private boolean clearTop;
    private boolean mAllowLeaving;
    private final Context mContext;
    private boolean mDisableTransition;
    private boolean mDisallowLoopback;
    private int[] mInstanceTransition;
    private final Intent mIntent;
    private int mRequestCode;
    private boolean mSkipHooker;
    private boolean mSkipPreprocess;
    private boolean mSkipPriorHooker;
    private List<Intent> mTaskStack;
    private NavStack navStack;
    private boolean needlogin;
    Uri stackUri;
    private static final List<NavPreprocessor> mPreprocessor = new ArrayList();
    private static final List<NavPreprocessor> mStickPreprocessor = new ArrayList();
    private static final SparseArray<NavHooker> mPriorHookers = new SparseArray<>();

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public interface NavExceptionHandler {
        boolean onException(Intent intent, Exception exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public static class NavHookIntent extends Intent {
        private NavHookIntent() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public interface NavHooker {
        public static final int NAVHOOKER_HIGH_PRIORITY = 3;
        public static final int NAVHOOKER_LOW_PRIORITY = 1;
        public static final int NAVHOOKER_NORMAL_PRIORITY = 2;
        public static final int NAVHOOKER_STICKMAX_PRIORITY = 4;

        boolean hook(Context context, Intent intent);
    }

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public interface NavPreprocessor {
        void addStackUri(Uri uri);

        boolean beforeNavTo(Intent intent, Context context);
    }

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public interface NavResolver {
        List<ResolveInfo> queryIntentActivities(PackageManager packageManager, Intent intent, int i);

        ResolveInfo resolveActivity(PackageManager packageManager, Intent intent, int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public interface NavStack {
        boolean checkExist(Intent intent);

        void clearStack();
    }

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public static class NavigationCanceledException extends Exception {
        private static final long serialVersionUID = 5015146091187397488L;
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public static final class b implements NavResolver {
        private static transient /* synthetic */ IpChange $ipChange;

        private b() {
        }

        @Override // cn.damai.common.nav.DMNav.NavResolver
        public List<ResolveInfo> queryIntentActivities(PackageManager packageManager, Intent intent, int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-907852297") ? (List) ipChange.ipc$dispatch("-907852297", new Object[]{this, packageManager, intent, Integer.valueOf(i)}) : packageManager.queryIntentActivities(intent, i);
        }

        @Override // cn.damai.common.nav.DMNav.NavResolver
        public ResolveInfo resolveActivity(PackageManager packageManager, Intent intent, int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1144289665") ? (ResolveInfo) ipChange.ipc$dispatch("1144289665", new Object[]{this, packageManager, intent, Integer.valueOf(i)}) : packageManager.resolveActivity(intent, i);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public final class c implements Comparable<c> {
        private static transient /* synthetic */ IpChange $ipChange;
        private final ResolveInfo a;
        private int b;
        private int c;

        public c(DMNav dMNav, ResolveInfo resolveInfo, int i, int i2) {
            this.b = 0;
            this.c = 0;
            this.a = resolveInfo;
            this.b = i;
            this.c = i2;
        }

        @Override // java.lang.Comparable
        /* renamed from: b */
        public int compareTo(c cVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1747806745")) {
                return ((Integer) ipChange.ipc$dispatch("-1747806745", new Object[]{this, cVar})).intValue();
            }
            if (this == cVar) {
                return 0;
            }
            int i = cVar.b;
            int i2 = this.b;
            if (i != i2) {
                return i - i2;
            }
            int i3 = cVar.c;
            int i4 = this.c;
            return i3 != i4 ? i3 - i4 : System.identityHashCode(this) < System.identityHashCode(cVar) ? -1 : 1;
        }
    }

    static {
        b bVar = new b();
        DEFAULT_RESOLVER = bVar;
        mNavResolver = bVar;
    }

    private DMNav(Context context) {
        super(context);
        this.mRequestCode = -1;
        this.clearTop = false;
        this.needlogin = false;
        this.mContext = context;
        this.mIntent = new Intent("android.intent.action.VIEW");
        this.navStack = k3.b();
    }

    private void checkClearTop(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-200043211")) {
            ipChange.ipc$dispatch("-200043211", new Object[]{this, intent});
            return;
        }
        NavStack navStack = this.navStack;
        if (navStack == null || !this.clearTop) {
            return;
        }
        if (navStack.checkExist(intent)) {
            withFlags(ConfigReporter.BIT_GETTER_IMP);
        } else {
            this.navStack.clearStack();
        }
    }

    public static DMNav from(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1207158148") ? (DMNav) ipChange.ipc$dispatch("-1207158148", new Object[]{context}) : new DMNav(context);
    }

    @TargetApi(11)
    private static PendingIntent getActivities(Context context, int i, Intent[] intentArr, int i2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "270792125") ? (PendingIntent) ipChange.ipc$dispatch("270792125", new Object[]{context, Integer.valueOf(i), intentArr, Integer.valueOf(i2)}) : getActivities(context, i, intentArr, i2);
    }

    private boolean isDebug() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-379162941") ? ((Boolean) ipChange.ipc$dispatch("-379162941", new Object[]{this})).booleanValue() : (this.mContext.getApplicationInfo().flags & 2) != 0;
    }

    private ResolveInfo optimum(List<ResolveInfo> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2026613443")) {
            return (ResolveInfo) ipChange.ipc$dispatch("-2026613443", new Object[]{this, list});
        }
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
                    arrayList.add(new c(this, resolveInfo, resolveInfo.priority, 1));
                } else {
                    String str = resolveInfo.activityInfo.packageName;
                    String packageName = this.mContext.getPackageName();
                    String[] split = str.split("\\.");
                    String[] split2 = packageName.split("\\.");
                    if (split.length >= 2 && split2.length >= 2 && split[0].equals(split2[0]) && split[1].equals(split2[1])) {
                        arrayList.add(new c(this, resolveInfo, resolveInfo.priority, 0));
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            if (arrayList.size() > 1) {
                Collections.sort(arrayList);
            }
            ResolveInfo resolveInfo2 = ((c) arrayList.get(0)).a;
            arrayList.clear();
            return resolveInfo2;
        }
        return null;
    }

    public static void registerHooker(NavHooker navHooker) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1631121214")) {
            ipChange.ipc$dispatch("1631121214", new Object[]{navHooker});
        } else {
            mPriorHookers.put(4, navHooker);
        }
    }

    public static void registerPreprocessor(NavPreprocessor navPreprocessor) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "473112478")) {
            ipChange.ipc$dispatch("473112478", new Object[]{navPreprocessor});
            return;
        }
        List<NavPreprocessor> list = mPreprocessor;
        synchronized (list) {
            list.add(navPreprocessor);
        }
    }

    public static void registerPriorHooker(NavHooker navHooker, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "459611271")) {
            ipChange.ipc$dispatch("459611271", new Object[]{navHooker, Integer.valueOf(i)});
        } else if (i <= 3 && i >= 1) {
            mPriorHookers.put(i, navHooker);
        } else {
            throw new RuntimeException("NavHooker's priority less than NAVHOOKER_HIGH_PRIORITY, larger than NAVHOOKER_LOW_PRIORITY");
        }
    }

    public static void registerStickPreprocessor(NavPreprocessor navPreprocessor) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-636263518")) {
            ipChange.ipc$dispatch("-636263518", new Object[]{navPreprocessor});
            return;
        }
        List<NavPreprocessor> list = mStickPreprocessor;
        synchronized (list) {
            list.add(navPreprocessor);
        }
    }

    public static void setExceptionHandler(NavExceptionHandler navExceptionHandler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "70616919")) {
            ipChange.ipc$dispatch("70616919", new Object[]{navExceptionHandler});
        } else {
            mExceptionHandler = navExceptionHandler;
        }
    }

    public static void setGlobalTransition(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-665099538")) {
            ipChange.ipc$dispatch("-665099538", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        mTransition = r0;
        int[] iArr = {i, i2};
    }

    public static void setNavResolver(NavResolver navResolver) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1439831812")) {
            ipChange.ipc$dispatch("-1439831812", new Object[]{navResolver});
        } else {
            mNavResolver = navResolver;
        }
    }

    private void setUriParamToIntent(Uri uri) {
        Set<String> queryParameterNames;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2010232263")) {
            ipChange.ipc$dispatch("-2010232263", new Object[]{this, uri});
        } else if (uri != null) {
            try {
                if (this.mIntent == null || (queryParameterNames = uri.getQueryParameterNames()) == null || queryParameterNames.iterator() == null) {
                    return;
                }
                for (String str : queryParameterNames) {
                    this.mIntent.putExtra(str, uri.getQueryParameter(str));
                }
            } catch (Exception e) {
                e.printStackTrace();
                Log.e(TAG, "DMNav setUriParamToIntent param error");
            }
        }
    }

    private Intent specify(Intent intent) {
        ResolveInfo optimum;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2088087599")) {
            return (Intent) ipChange.ipc$dispatch("2088087599", new Object[]{this, intent});
        }
        if (this.mAllowLeaving || (optimum = optimum(mNavResolver.queryIntentActivities(this.mContext.getPackageManager(), intent, 65536))) == null) {
            return intent;
        }
        ActivityInfo activityInfo = optimum.activityInfo;
        intent.setClassName(activityInfo.packageName, activityInfo.name);
        return intent;
    }

    @TargetApi(11)
    private void startActivities(Intent[] intentArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1889789415")) {
            ipChange.ipc$dispatch("-1889789415", new Object[]{this, intentArr});
        } else {
            this.mContext.startActivities(intentArr);
        }
    }

    private Intent to(Uri uri) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1355239667") ? (Intent) ipChange.ipc$dispatch("1355239667", new Object[]{this, uri}) : to(uri, !this.mSkipPreprocess);
    }

    public static void unregisterPreprocessor(NavPreprocessor navPreprocessor) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1014948663")) {
            ipChange.ipc$dispatch("1014948663", new Object[]{navPreprocessor});
            return;
        }
        List<NavPreprocessor> list = mPreprocessor;
        synchronized (list) {
            list.remove(navPreprocessor);
        }
    }

    public static void unregisterStickPreprocessor(NavPreprocessor navPreprocessor) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-155256919")) {
            ipChange.ipc$dispatch("-155256919", new Object[]{navPreprocessor});
            return;
        }
        List<NavPreprocessor> list = mStickPreprocessor;
        synchronized (list) {
            list.remove(navPreprocessor);
        }
    }

    public DMNav allowEscape() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1386422486")) {
            return (DMNav) ipChange.ipc$dispatch("-1386422486", new Object[]{this});
        }
        this.mAllowLeaving = true;
        return this;
    }

    public DMNav clearTop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1023496774")) {
            return (DMNav) ipChange.ipc$dispatch("1023496774", new Object[]{this});
        }
        this.clearTop = true;
        return this;
    }

    public DMNav disallowLoopback() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2034193320")) {
            return (DMNav) ipChange.ipc$dispatch("2034193320", new Object[]{this});
        }
        this.mDisallowLoopback = true;
        return this;
    }

    public DMNav paramToBundle(Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2023298837")) {
            return (DMNav) ipChange.ipc$dispatch("2023298837", new Object[]{this, uri});
        }
        if (uri != null && uri.getQueryParameter("param") != null) {
            Map map = (Map) JSON.parse(uri.getQueryParameter("param"));
            Bundle extras = this.mIntent.getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            if (map != null) {
                for (Object obj : map.keySet()) {
                    String obj2 = obj.toString();
                    extras.putString(obj2, map.get(obj) + "");
                }
            }
            this.mIntent.putExtras(extras);
        }
        return this;
    }

    public DMNav setTransition(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1355721597")) {
            return (DMNav) ipChange.ipc$dispatch("1355721597", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        this.mInstanceTransition = r0;
        int[] iArr = {i, i2};
        return this;
    }

    @TargetApi(11)
    public DMNav stack(Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-821409901")) {
            return (DMNav) ipChange.ipc$dispatch("-821409901", new Object[]{this, uri});
        }
        if (uri == null) {
            return this;
        }
        if (this.mRequestCode < 0) {
            this.stackUri = uri;
            Intent intent = new Intent(to(uri, false));
            if (this.mTaskStack == null) {
                this.mTaskStack = new ArrayList(1);
                intent.addFlags(268435456);
                if (Build.VERSION.SDK_INT >= 11) {
                    intent.addFlags(49152);
                }
            }
            this.mTaskStack.add(intent);
            return this;
        }
        throw new IllegalStateException("Cannot stack URI for result");
    }

    @Override // cn.damai.uikit.nav.INav
    public boolean toHost(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-725910451") ? ((Boolean) ipChange.ipc$dispatch("-725910451", new Object[]{this, str})).booleanValue() : toUri(NavUri.b(str));
    }

    public PendingIntent toPendingUri(Uri uri, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1819705057")) {
            return (PendingIntent) ipChange.ipc$dispatch("1819705057", new Object[]{this, uri, Integer.valueOf(i), Integer.valueOf(i2)});
        }
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

    @Override // cn.damai.uikit.nav.INav
    public boolean toUri(INavUri iNavUri) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "813519564") ? ((Boolean) ipChange.ipc$dispatch("813519564", new Object[]{this, iNavUri})).booleanValue() : toUri(iNavUri.build());
    }

    public DMNav withCategory(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "323800820")) {
            return (DMNav) ipChange.ipc$dispatch("323800820", new Object[]{this, str});
        }
        this.mIntent.addCategory(str);
        return this;
    }

    private Intent to(Uri uri, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1096416289")) {
            return (Intent) ipChange.ipc$dispatch("-1096416289", new Object[]{this, uri, Boolean.valueOf(z)});
        }
        this.mIntent.setData(uri);
        setUriParamToIntent(uri);
        if (this.needlogin) {
            this.mIntent.putExtra("checklogin", true);
        }
        this.mIntent.putExtra(KRequestCodeReferrer, this.mRequestCode);
        NavHooker navHooker = mPriorHookers.get(4);
        if (!this.mSkipHooker && navHooker != null && !navHooker.hook(this.mContext, this.mIntent)) {
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
                if (keyAt != 4 && !sparseArray.get(keyAt).hook(this.mContext, this.mIntent)) {
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
            } else if (context != null) {
                this.mIntent.putExtra("referrer", context.getPackageName());
            }
        }
        List<NavPreprocessor> list = mStickPreprocessor;
        if (!list.isEmpty()) {
            synchronized (list) {
                for (NavPreprocessor navPreprocessor : list) {
                    if (this.stackUri != null) {
                        Log.e("mStickPreprocessor", navPreprocessor.getClass().toString());
                        navPreprocessor.addStackUri(this.stackUri);
                    }
                    if (navPreprocessor.beforeNavTo(this.mIntent, this.mContext)) {
                        return new NavHookIntent();
                    }
                }
            }
        }
        if (z) {
            List<NavPreprocessor> list2 = mPreprocessor;
            if (!list2.isEmpty()) {
                synchronized (list2) {
                    for (NavPreprocessor navPreprocessor2 : list2) {
                        Uri uri2 = this.stackUri;
                        if (uri2 != null) {
                            navPreprocessor2.addStackUri(uri2);
                        }
                        if (navPreprocessor2.beforeNavTo(this.mIntent, this.mContext)) {
                            return new NavHookIntent();
                        }
                    }
                }
            }
        }
        return this.mIntent;
    }

    @Override // cn.damai.uikit.nav.INav
    public DMNav disableTransition() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "112851095")) {
            return (DMNav) ipChange.ipc$dispatch("112851095", new Object[]{this});
        }
        this.mDisableTransition = true;
        return this;
    }

    @Override // cn.damai.uikit.nav.INav
    public DMNav forResult(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-73402611")) {
            return (DMNav) ipChange.ipc$dispatch("-73402611", new Object[]{this, Integer.valueOf(i)});
        }
        if (this.mContext instanceof Activity) {
            this.mRequestCode = i;
            return this;
        }
        throw new IllegalStateException("Only valid from Activity, but from " + this.mContext);
    }

    @Override // cn.damai.uikit.nav.INav
    public DMNav needLogin() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2031935809")) {
            return (DMNav) ipChange.ipc$dispatch("2031935809", new Object[]{this});
        }
        this.needlogin = true;
        return this;
    }

    @Override // cn.damai.uikit.nav.INav
    public DMNav skipHooker() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "680671423")) {
            return (DMNav) ipChange.ipc$dispatch("680671423", new Object[]{this});
        }
        this.mSkipHooker = true;
        return this;
    }

    @Override // cn.damai.uikit.nav.INav
    public DMNav skipPreprocess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "457344483")) {
            return (DMNav) ipChange.ipc$dispatch("457344483", new Object[]{this});
        }
        this.mSkipPreprocess = true;
        return this;
    }

    @Override // cn.damai.uikit.nav.INav
    public DMNav skipPriorHooker() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1431658233")) {
            return (DMNav) ipChange.ipc$dispatch("1431658233", new Object[]{this});
        }
        this.mSkipPriorHooker = true;
        return this;
    }

    public boolean toUri(NavUri navUri) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1685859444") ? ((Boolean) ipChange.ipc$dispatch("-1685859444", new Object[]{this, navUri})).booleanValue() : toUri(navUri.a());
    }

    @Override // cn.damai.uikit.nav.INav
    public DMNav withExtras(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1417633127")) {
            return (DMNav) ipChange.ipc$dispatch("1417633127", new Object[]{this, bundle});
        }
        if (bundle == null) {
            return this;
        }
        this.mIntent.putExtras(bundle);
        return this;
    }

    @Override // cn.damai.uikit.nav.INav
    public DMNav withFlags(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2125261032")) {
            return (DMNav) ipChange.ipc$dispatch("2125261032", new Object[]{this, Integer.valueOf(i)});
        }
        this.mIntent.addFlags(i);
        return this;
    }

    @Override // cn.damai.uikit.nav.INav
    public boolean toUri(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1155204379")) {
            return ((Boolean) ipChange.ipc$dispatch("-1155204379", new Object[]{this, str})).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return toUri(Uri.parse(str));
    }

    @Override // cn.damai.uikit.nav.INav
    public boolean toUri(Uri uri) {
        ComponentName component;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1622424236")) {
            return ((Boolean) ipChange.ipc$dispatch("-1622424236", new Object[]{this, uri})).booleanValue();
        }
        Log.d(TAG, uri.toString());
        NavExceptionHandler navExceptionHandler = mExceptionHandler;
        Intent intent = to(uri);
        if (intent == null) {
            if (navExceptionHandler != null) {
                navExceptionHandler.onException(this.mIntent, new NavigationCanceledException());
            }
            return false;
        } else if (intent instanceof NavHookIntent) {
            return true;
        } else {
            try {
                Context context = this.mContext;
                if (context == null) {
                    Log.e("DMNAV", "touri npe for mContext");
                    return false;
                }
                if (this.mAllowLeaving) {
                    ResolveInfo resolveActivity = mNavResolver.resolveActivity(this.mContext.getPackageManager(), intent, 65536);
                    if (resolveActivity != null) {
                        ActivityInfo activityInfo = resolveActivity.activityInfo;
                        component = new ComponentName(activityInfo.packageName, activityInfo.name);
                    } else {
                        throw new ActivityNotFoundException("No Activity found to handle " + intent);
                    }
                } else if (!c42.a(context)) {
                    intent.setPackage(this.mContext.getPackageName());
                    ResolveInfo resolveActivity2 = mNavResolver.resolveActivity(this.mContext.getPackageManager(), intent, 65536);
                    if (resolveActivity2 == null) {
                        ResolveInfo optimum = optimum(mNavResolver.queryIntentActivities(this.mContext.getPackageManager(), intent, 65536));
                        if (optimum != null) {
                            ActivityInfo activityInfo2 = optimum.activityInfo;
                            intent.setClassName(activityInfo2.packageName, activityInfo2.name);
                        } else {
                            throw new ActivityNotFoundException("No Activity found to handle " + intent);
                        }
                    } else {
                        ActivityInfo activityInfo3 = resolveActivity2.activityInfo;
                        intent.setClassName(activityInfo3.packageName, activityInfo3.name);
                    }
                    component = intent.getComponent();
                } else {
                    ResolveInfo optimum2 = optimum(mNavResolver.queryIntentActivities(this.mContext.getPackageManager(), intent, 65536));
                    if (optimum2 != null) {
                        ActivityInfo activityInfo4 = optimum2.activityInfo;
                        intent.setClassName(activityInfo4.packageName, activityInfo4.name);
                        component = intent.getComponent();
                    } else {
                        throw new ActivityNotFoundException("No Activity found to handle " + intent);
                    }
                }
                if (this.mDisallowLoopback) {
                    Context context2 = this.mContext;
                    if ((context2 instanceof Activity) && component != null && component.equals(((Activity) context2).getComponentName())) {
                        Log.w(TAG, "Loopback disallowed: " + uri);
                        return false;
                    }
                }
                List<Intent> list = this.mTaskStack;
                if (list != null && Build.VERSION.SDK_INT >= 11) {
                    list.add(this.mIntent);
                    List<Intent> list2 = this.mTaskStack;
                    startActivities((Intent[]) list2.toArray(new Intent[list2.size()]));
                } else if (this.mRequestCode >= 0) {
                    checkClearTop(intent);
                    ((Activity) this.mContext).startActivityForResult(intent, this.mRequestCode);
                } else {
                    if (!(this.mContext instanceof Activity)) {
                        intent.addFlags(268435456);
                    }
                    checkClearTop(intent);
                    this.mContext.startActivity(intent);
                }
                if (!this.mDisableTransition) {
                    Context context3 = this.mContext;
                    if (context3 instanceof Activity) {
                        int[] iArr = this.mInstanceTransition;
                        if (iArr != null) {
                            ((Activity) context3).overridePendingTransition(iArr[0], iArr[1]);
                        } else {
                            int[] iArr2 = mTransition;
                            if (iArr2 != null) {
                                ((Activity) context3).overridePendingTransition(iArr2[0], iArr2[1]);
                            }
                        }
                    }
                }
                return true;
            } catch (ActivityNotFoundException e) {
                if (navExceptionHandler != null) {
                    navExceptionHandler.onException(intent, e);
                }
                try {
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (uri.toString().startsWith("http")) {
                    return false;
                }
                String str = DXRecyclerLayout.LOAD_MORE_EMPTY;
                if (k3.b().c() != null) {
                    str = k3.b().c().toString();
                }
                b23.g("DMNAV:jsondata={appVersion:" + AppConfig.q() + ",url:" + uri + ",topActivity:" + str + "}", StaticsUtil.PLAY_CODE_102, "目标路由不存在:ActivityNotFound");
                return false;
            }
        }
    }
}
