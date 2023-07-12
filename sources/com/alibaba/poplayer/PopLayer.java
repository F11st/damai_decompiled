package com.alibaba.poplayer;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.poplayer.factory.view.base.PopLayerBaseView;
import com.alibaba.poplayer.layermanager.C3660e;
import com.alibaba.poplayer.layermanager.ILayerMgrAdapter;
import com.alibaba.poplayer.layermanager.PopRequest;
import com.alibaba.poplayer.norm.IConfigAdapter;
import com.alibaba.poplayer.norm.IFaceAdapter;
import com.alibaba.poplayer.norm.ILogAdapter;
import com.alibaba.poplayer.trigger.BaseConfigItem;
import com.alibaba.poplayer.trigger.InternalTriggerController;
import com.alibaba.poplayer.trigger.view.C3699d;
import com.alibaba.poplayer.utils.Monitor;
import com.youku.css.constraint.CssConst;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import tb.d7;
import tb.dt1;
import tb.gq1;
import tb.ip1;
import tb.k81;
import tb.t01;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class PopLayer<K extends BaseConfigItem> {
    public static final String ACTION_FRAGMENT_SWITCH = "com.alibaba.poplayer.PopLayer.action.FRAGMENT_SWITCH";
    public static final String ACTION_NOTIFY_TRACKS_NAME = "PopLayer.TrackingView.Event";
    public static final String ACTION_OUT_DISMISS = "com.alibaba.poplayer.PopLayer.action.out.CLOSE";
    public static final String ACTION_OUT_DISPLAY = "com.alibaba.poplayer.PopLayer.action.out.DISPLAY";
    public static final String ACTION_POP = "com.alibaba.poplayer.PopLayer.action.POP";
    public static final String ACTION_TRACK_INFO_KEY_EVENT_NAME = "eventName";
    public static final String ACTION_TRACK_INFO_KEY_GROUPID = "groupId";
    public static final String ACTION_TRACK_INFO_KEY_OPERATION_NAME = "operationName";
    public static final String ACTION_TRACK_INFO_KEY_PARAMS = "params";
    public static final String EXTRA_KEY_EVENT = "event";
    public static final String EXTRA_KEY_EXTRA_PARAMS = "extra_params";
    public static final String EXTRA_KEY_FRAGMENT_NAME = "fragment_name";
    public static final String EXTRA_KEY_FRAGMENT_NEED_ACTIVITY_PARAM = "fragment_need_activity_param";
    public static final String EXTRA_KEY_FRAGMENT_PARAM = "fragment_param";
    public static final String EXTRA_KEY_PARAM = "param";
    public static final String SCHEMA = "poplayer";
    private static PopLayer sPoplayer;
    private static boolean sSetup;
    public boolean isLogOutputMode = false;
    final CopyOnWriteArraySet<String> mActivitiesMustBroadcastPop = new CopyOnWriteArraySet<>();
    @Monitor.TargetField(name = ip1.MONITOR_ADAPTER_VERSION)
    private String mAdapterVersion;
    @Monitor.TargetField(prefix = "App")
    private d7 mAppTriggerService;
    protected Map<Integer, IConfigAdapter> mConfigContainers;
    private Application mContext;
    @Monitor.TargetField(name = ip1.MONITOR_NATIVE_URL)
    private String mCurrentNativeUrl;
    protected final IFaceAdapter mFaceAdapter;
    private ArrayList<ILogAdapter> mILogAdapters;
    @Monitor.TargetField
    private ILayerMgrAdapter mLayerMgrAdapter;
    @Monitor.TargetField(prefix = "Page")
    private gq1 mPageTriggerService;
    @Monitor.TargetField
    private InternalTriggerController mTriggleController;
    @Monitor.TargetField(name = "version")
    private String mVersion;
    @Monitor.TargetField(prefix = CssConst.CssScenes.VIEW)
    private C3699d mViewTriggerService;

    /* compiled from: Taobao */
    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes8.dex */
    public @interface PopupAllowedFromFragment {
        String tag() default "";
    }

    /* compiled from: Taobao */
    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes8.dex */
    public @interface PopupOnlyManually {
        String tag() default "";
    }

    public PopLayer(IFaceAdapter iFaceAdapter, IConfigAdapter iConfigAdapter, IConfigAdapter iConfigAdapter2, IConfigAdapter iConfigAdapter3, ILayerMgrAdapter iLayerMgrAdapter) {
        HashMap hashMap = new HashMap(3);
        this.mConfigContainers = hashMap;
        this.mILogAdapters = null;
        this.mFaceAdapter = iFaceAdapter;
        hashMap.put(1, iConfigAdapter2);
        this.mConfigContainers.put(2, iConfigAdapter);
        this.mConfigContainers.put(3, iConfigAdapter3);
        this.mLayerMgrAdapter = iLayerMgrAdapter;
        if (sPoplayer == null) {
            sPoplayer = this;
        }
    }

    public static PopLayer getReference() {
        return sPoplayer;
    }

    public static boolean isSetup() {
        return sSetup;
    }

    public void acceptMsg(String str, Map<String, String> map, View view) {
        C3699d.M().y(view, str, map);
    }

    public String getActivityInfo(Activity activity) {
        if (activity.getIntent() == null) {
            return null;
        }
        return activity.getIntent().getDataString();
    }

    public Application getApp() {
        return this.mContext;
    }

    public IConfigAdapter getConfigAdapter(int i) {
        return this.mConfigContainers.get(Integer.valueOf(i));
    }

    public long getCurrentTimeStamp() {
        return this.mFaceAdapter.getCurrentTimeStamp(this.mContext);
    }

    public IFaceAdapter getFaceAdapter() {
        return this.mFaceAdapter;
    }

    public Application.ActivityLifecycleCallbacks getLifecycleManager() {
        InternalTriggerController internalTriggerController = this.mTriggleController;
        if (internalTriggerController == null) {
            return null;
        }
        return internalTriggerController;
    }

    public ArrayList<ILogAdapter> getLogAdapters() {
        return this.mILogAdapters;
    }

    public String getVersion() {
        return this.mVersion;
    }

    public Activity internalGetCurrentActivity() {
        return this.mTriggleController.c();
    }

    public void internalNotifyDismissedIfPopLayerView(PopLayerBaseView popLayerBaseView) {
        Intent intent = new Intent(ACTION_OUT_DISMISS);
        intent.putExtra("event", popLayerBaseView.getInfo());
        LocalBroadcastManager.getInstance(this.mContext).sendBroadcast(intent);
        dt1.b("PopLayer.dismiss.notify", new Object[0]);
        onDismissed(popLayerBaseView.getContext(), popLayerBaseView);
    }

    public void internalNotifyDisplayedIfPopLayerView(PopLayerBaseView popLayerBaseView) {
        Intent intent = new Intent(ACTION_OUT_DISPLAY);
        intent.putExtra("event", popLayerBaseView.getInfo());
        LocalBroadcastManager.getInstance(popLayerBaseView.getContext()).sendBroadcast(intent);
        dt1.b("PopLayer.display.notify", new Object[0]);
        onDisplayed(popLayerBaseView.getContext(), popLayerBaseView);
    }

    public void internalNotifyNativeUrlChanged(String str) {
        this.mCurrentNativeUrl = str;
        dt1.b("PopLayer.internalNotifyNativeUrlChanged.mCurrentNativeUrl{%s}", str);
    }

    public boolean isMunualPopPageContains(String str) {
        return this.mActivitiesMustBroadcastPop.contains(str);
    }

    public boolean isSamePage(Activity activity, Activity activity2) {
        boolean z;
        if (activity == null || activity2 == null || activity2 != activity) {
            return false;
        }
        Intent intent = activity2.getIntent();
        Intent intent2 = activity.getIntent();
        if (intent != null || intent2 != null) {
            if (intent != null && intent2 != null) {
                String dataString = intent.getDataString();
                String dataString2 = intent2.getDataString();
                if (dataString == null && dataString2 == null) {
                    dt1.b("PopLayer.isSamePage.curActivity: no intent.dataString ", new Object[0]);
                } else if (dataString != null && dataString2 != null) {
                    z = dataString.equals(dataString2);
                    dt1.b("PopLayer.isSamePage.curActivity: intent.dataString equal:%s", Boolean.valueOf(z));
                    dt1.b("PopLayer.isSamePage.curActivity == preActivity {%s}", Boolean.valueOf(z));
                    return z;
                }
            }
            z = false;
            dt1.b("PopLayer.isSamePage.curActivity == preActivity {%s}", Boolean.valueOf(z));
            return z;
        }
        dt1.b("PopLayer.isSamePage.curActivity: no intent ", new Object[0]);
        z = true;
        dt1.b("PopLayer.isSamePage.curActivity == preActivity {%s}", Boolean.valueOf(z));
        return z;
    }

    public boolean isValidActivity(Activity activity) {
        return true;
    }

    public boolean isValidConfig(BaseConfigItem baseConfigItem) {
        return true;
    }

    public void onCurActivityInited() {
    }

    protected void onDismissed(Context context, PopLayerBaseView popLayerBaseView) {
        dt1.b("PopLayer.onDismissed", new Object[0]);
    }

    protected void onDisplayed(Context context, PopLayerBaseView popLayerBaseView) {
        dt1.b("PopLayer.onDisplayed", new Object[0]);
    }

    protected String onGenarateAdapterVersion() {
        return "";
    }

    public void onPopped(int i, Context context, View view) {
        dt1.b("PopLayer.onPopped", new Object[0]);
    }

    public void registerLogAdapter(ILogAdapter iLogAdapter) {
        if (this.mILogAdapters == null) {
            this.mILogAdapters = new ArrayList<>();
        }
        if (!this.mILogAdapters.contains(iLogAdapter)) {
            this.mILogAdapters.add(iLogAdapter);
        }
        dt1.b("PopLayer.registerLogAdapter.", new Object[0]);
    }

    public boolean registerManualPopPage(Class<Activity> cls) {
        String name = cls.getName();
        boolean add = this.mActivitiesMustBroadcastPop.add(name);
        dt1.b("PopLayer.registerManualPopPage?activityClazz=%s.return?add=%s", name, Boolean.valueOf(add));
        return add;
    }

    public final void registerViewType(Class<? extends PopLayerBaseView> cls) {
        try {
            k81.b().c(cls);
            dt1.b("PopLayerAction.registerViewType success!", new Object[0]);
        } catch (Throwable th) {
            dt1.c("PopLayerAction.registerViewType fail!", th);
        }
    }

    public void removeMsg(String str, View view) {
        C3699d.M().P(str, view);
    }

    public void removeRequest(PopRequest popRequest) {
        int b = popRequest.b();
        if (b == 1) {
            d7.A().q(popRequest);
        } else if (b == 2) {
            gq1.A().q(popRequest);
        } else if (b != 3) {
        } else {
            C3699d.M().q(popRequest);
        }
    }

    public void setup(Application application) {
        try {
            if (sSetup) {
                dt1.a("PopLayer.setup.alreadySetup");
                return;
            }
            this.mContext = application;
            this.mTriggleController = new InternalTriggerController(application);
            this.mAppTriggerService = d7.A();
            this.mPageTriggerService = gq1.A();
            this.mViewTriggerService = C3699d.M();
            new C3660e(this.mLayerMgrAdapter).e(application);
            this.mFaceAdapter.registerNavPreprocessor(application, this);
            this.mFaceAdapter.registerTrackViewTypes(application, this);
            for (Integer num : this.mConfigContainers.keySet()) {
                IConfigAdapter iConfigAdapter = this.mConfigContainers.get(num);
                iConfigAdapter.initializeConfigContainer(application, this);
                iConfigAdapter.addConfigObserver(application, this);
            }
            this.mVersion = getApp().getResources().getString(getApp().getResources().getIdentifier("poplayer_version", "string", getApp().getPackageName()));
            this.mAdapterVersion = onGenarateAdapterVersion();
            try {
                dt1.a = (this.mContext.getApplicationInfo().flags & 2) != 0;
            } catch (Exception unused) {
                dt1.a = false;
            }
            dt1.b("PopLayer.version{%s}.setup.success.debug{%s}", this.mVersion, Boolean.valueOf(dt1.a));
            sSetup = true;
        } catch (Throwable th) {
            dt1.c("PopLayer.setup.fail" + th.toString(), th);
        }
    }

    public void switchLogMode(boolean z) {
        this.isLogOutputMode = z;
        dt1.b("PopLayer.switchLogMode:{%s}.", Boolean.valueOf(z));
    }

    public ArrayList<t01<K>> tryOpenRequestControl(ArrayList<t01<K>> arrayList) {
        return arrayList;
    }

    public boolean unregisterManualPopPage(Class<Activity> cls) {
        String name = cls.getName();
        boolean remove = this.mActivitiesMustBroadcastPop.remove(name);
        dt1.b("PopLayer.unregisterManualPopPage?activityClazz=%s.return?remove=%s", name, Boolean.valueOf(remove));
        return remove;
    }

    public void updateCacheConfigAsync(int i) {
        try {
            dt1.b("PopLayer.updateCacheConfigAsync Domain :" + Domain.toString(i), new Object[0]);
            if (i == 1) {
                d7.A().v(false, this.mContext);
            } else if (i == 2) {
                gq1.A().v(false, this.mContext);
            } else if (i == 3) {
                C3699d.M().v(false, this.mContext);
            }
        } catch (Throwable th) {
            dt1.c("PopLayer.updateCacheConfigAsync.fail." + th.toString(), th);
        }
    }
}
