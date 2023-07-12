package com.taobao.weex.bridge;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.taobao.windvane.jsbridge.utils.WVUtils;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.collection.ArrayMap;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.adapter.IWXConfigAdapter;
import com.taobao.weex.adapter.IWXJSExceptionAdapter;
import com.taobao.weex.adapter.IWXJscProcessManager;
import com.taobao.weex.adapter.IWXUserTrackAdapter;
import com.taobao.weex.bridge.WXValidateProcessor;
import com.taobao.weex.common.IWXBridge;
import com.taobao.weex.common.IWXDebugConfig;
import com.taobao.weex.common.WXConfig;
import com.taobao.weex.common.WXErrorCode;
import com.taobao.weex.common.WXException;
import com.taobao.weex.common.WXJSExceptionInfo;
import com.taobao.weex.common.WXRefreshData;
import com.taobao.weex.common.WXRuntimeException;
import com.taobao.weex.common.WXThread;
import com.taobao.weex.devtools.debug.DebugServerProxy;
import com.taobao.weex.dom.CSSShorthand;
import com.taobao.weex.jsEngine.JSEngine;
import com.taobao.weex.layout.ContentBoxMeasurement;
import com.taobao.weex.performance.WXInstanceApm;
import com.taobao.weex.performance.WXStateRecord;
import com.taobao.weex.ui.WXComponentRegistry;
import com.taobao.weex.ui.WXRenderManager;
import com.taobao.weex.ui.action.ActionReloadPage;
import com.taobao.weex.ui.action.GraphicActionAddChildToRichtext;
import com.taobao.weex.ui.action.GraphicActionAddElement;
import com.taobao.weex.ui.action.GraphicActionAddEvent;
import com.taobao.weex.ui.action.GraphicActionAppendTreeCreateFinish;
import com.taobao.weex.ui.action.GraphicActionCreateBody;
import com.taobao.weex.ui.action.GraphicActionCreateFinish;
import com.taobao.weex.ui.action.GraphicActionLayout;
import com.taobao.weex.ui.action.GraphicActionMoveElement;
import com.taobao.weex.ui.action.GraphicActionRefreshFinish;
import com.taobao.weex.ui.action.GraphicActionRemoveChildFromRichtext;
import com.taobao.weex.ui.action.GraphicActionRemoveElement;
import com.taobao.weex.ui.action.GraphicActionRemoveEvent;
import com.taobao.weex.ui.action.GraphicActionRenderSuccess;
import com.taobao.weex.ui.action.GraphicActionUpdateAttr;
import com.taobao.weex.ui.action.GraphicActionUpdateRichtextAttr;
import com.taobao.weex.ui.action.GraphicActionUpdateRichtextStyle;
import com.taobao.weex.ui.action.GraphicActionUpdateStyle;
import com.taobao.weex.ui.action.GraphicPosition;
import com.taobao.weex.ui.action.GraphicSize;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.module.WXDomModule;
import com.taobao.weex.utils.WXExceptionUtils;
import com.taobao.weex.utils.WXFileUtils;
import com.taobao.weex.utils.WXJsonUtils;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXUtils;
import com.taobao.weex.utils.WXWsonJSONSwitch;
import com.taobao.weex.utils.batch.BactchExecutor;
import com.taobao.weex.utils.batch.Interceptor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import tb.jn1;
import tb.r62;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXBridgeManager implements Handler.Callback, BactchExecutor {
    public static final String ARGS = "args";
    private static final boolean BRIDGE_LOG_SWITCH = false;
    private static final String BUNDLE_TYPE = "bundleType";
    public static final String COMPONENT = "component";
    private static final int CRASHREINIT = 50;
    private static String GLOBAL_CONFIG_KEY = "global_switch_config";
    public static final String INITLOGFILE = "/jsserver_start.log";
    private static final int INIT_FRAMEWORK_OK = 1;
    public static final String KEY_ARGS = "args";
    public static final String KEY_METHOD = "method";
    public static final String KEY_PARAMS = "params";
    private static long LOW_MEM_VALUE = 120;
    public static final String METHD_COMPONENT_HOOK_SYNC = "componentHook";
    public static final String METHD_FIRE_EVENT_SYNC = "fireEventSync";
    public static final String METHOD = "method";
    public static final String METHOD_CALLBACK = "callback";
    public static final String METHOD_CALL_JS = "callJS";
    public static final String METHOD_CREATE_INSTANCE = "createInstance";
    public static final String METHOD_CREATE_INSTANCE_CONTEXT = "createInstanceContext";
    public static final String METHOD_CREATE_PAGE_WITH_CONTENT = "CreatePageWithContent";
    public static final String METHOD_DESTROY_INSTANCE = "destroyInstance";
    public static final String METHOD_FIRE_EVENT = "fireEvent";
    private static final String METHOD_JSFM_NOT_INIT_IN_EAGLE_MODE = "JsfmNotInitInEagleMode";
    public static final String METHOD_NOTIFY_SERIALIZE_CODE_CACHE = "notifySerializeCodeCache";
    public static final String METHOD_NOTIFY_TRIM_MEMORY = "notifyTrimMemory";
    private static final String METHOD_POST_TASK_TO_MSG_LOOP = "PostTaskToMsgLoop";
    public static final String METHOD_REFRESH_INSTANCE = "refreshInstance";
    public static final String METHOD_REGISTER_COMPONENTS = "registerComponents";
    public static final String METHOD_REGISTER_MODULES = "registerModules";
    public static final String METHOD_SET_TIMEOUT = "setTimeoutCallback";
    public static final String METHOD_UPDATE_COMPONENT_WITH_DATA = "UpdateComponentData";
    public static final String MODULE = "module";
    private static final String NON_CALLBACK = "-1";
    public static final String OPTIONS = "options";
    public static final String REF = "ref";
    private static final String RENDER_STRATEGY = "renderStrategy";
    private static final String UNDEFINED = "undefined";
    private static Class clazz_debugProxy = null;
    private static String crashUrl = null;
    private static String globalConfig = "none";
    private static volatile boolean isJsEngineMultiThreadEnable = false;
    private static volatile boolean isSandBoxContext = true;
    private static boolean isUseSingleProcess = false;
    private static long lastCrashTime = 0;
    static volatile WXBridgeManager mBridgeManager = null;
    private static volatile boolean mInit = false;
    private static String mRaxApi = null;
    public static volatile int reInitCount = 1;
    private static volatile int sInitFrameWorkCount;
    public static long sInitFrameWorkTimeOrigin;
    private WXParams mInitParams;
    private Interceptor mInterceptor;
    Handler mJSHandler;
    private WXThread mJSThread;
    private IWXBridge mWXBridge;
    private Object mWxDebugProxy;
    private static Map<String, String> mWeexCoreEnvOptions = new HashMap();
    public static StringBuilder sInitFrameWorkMsg = new StringBuilder();
    private WXHashMap<String, ArrayList<WXHashMap<String, Object>>> mNextTickTasks = new WXHashMap<>();
    private boolean mMock = false;
    private List<Map<String, Object>> mRegisterComponentFailList = new ArrayList(8);
    private List<Map<String, Object>> mRegisterModuleFailList = new ArrayList(8);
    private List<String> mRegisterServiceFailList = new ArrayList(8);
    private HashSet<String> mDestroyedInstanceId = new HashSet<>();
    private StringBuilder mLodBuilder = new StringBuilder(50);

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public enum BundType {
        Vue,
        Rax,
        Others
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class TimerInfo {
        public String callbackId;
        public String instanceId;
        public long time;
    }

    private WXBridgeManager() {
        initWXBridge(WXEnvironment.sRemoteDebugMode);
        WXThread wXThread = new WXThread("WeexJSBridgeThread", this);
        this.mJSThread = wXThread;
        this.mJSHandler = wXThread.getHandler();
    }

    private void addJSEventTask(final String str, final String str2, final List<Object> list, final Object... objArr) {
        post(new Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.12
            @Override // java.lang.Runnable
            public void run() {
                Object[] objArr2 = objArr;
                if (objArr2 == null || objArr2.length == 0) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj : objArr) {
                    arrayList.add(obj);
                }
                if (list != null) {
                    ArrayMap arrayMap = new ArrayMap(4);
                    arrayMap.put("params", list);
                    arrayList.add(arrayMap);
                }
                WXHashMap wXHashMap = new WXHashMap();
                wXHashMap.put("method", str);
                wXHashMap.put("args", arrayList);
                if (WXBridgeManager.this.mNextTickTasks.get(str2) != 0) {
                    ((ArrayList) WXBridgeManager.this.mNextTickTasks.get(str2)).add(wXHashMap);
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(wXHashMap);
                WXBridgeManager.this.mNextTickTasks.put(str2, arrayList2);
            }
        });
    }

    private void addJSTask(String str, String str2, Object... objArr) {
        addJSEventTask(str, str2, null, objArr);
    }

    @NonNull
    public static String argsToJSON(WXJSObject[] wXJSObjectArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(jn1.ARRAY_START_STR);
        for (WXJSObject wXJSObject : wXJSObjectArr) {
            sb.append(WXWsonJSONSwitch.fromObjectToJSONString(wXJSObject));
            sb.append(",");
        }
        sb.append(jn1.ARRAY_END_STR);
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0175  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.taobao.weex.bridge.WXParams assembleDefaultOptions() {
        /*
            Method dump skipped, instructions count: 415
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.weex.bridge.WXBridgeManager.assembleDefaultOptions():com.taobao.weex.bridge.WXParams");
    }

    private void asyncCallJSEventWithResult(final EventResult eventResult, final String str, final String str2, final List<Object> list, final Object... objArr) {
        post(new Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.11
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Object[] objArr2 = objArr;
                    if (objArr2 != null && objArr2.length != 0) {
                        ArrayList arrayList = new ArrayList();
                        for (Object obj : objArr) {
                            arrayList.add(obj);
                        }
                        if (list != null) {
                            ArrayMap arrayMap = new ArrayMap(4);
                            arrayMap.put("params", list);
                            arrayList.add(arrayMap);
                        }
                        WXHashMap wXHashMap = new WXHashMap();
                        wXHashMap.put("method", str);
                        wXHashMap.put("args", arrayList);
                        WXJSObject[] wXJSObjectArr = {new WXJSObject(2, str2), WXWsonJSONSwitch.toWsonOrJsonWXJSObject(new Object[]{wXHashMap})};
                        WXBridgeManager.this.invokeExecJSWithCallback(String.valueOf(str2), null, WXBridgeManager.METHOD_CALL_JS, wXJSObjectArr, eventResult != null ? new ResultCallback<byte[]>() { // from class: com.taobao.weex.bridge.WXBridgeManager.11.1
                            @Override // com.taobao.weex.bridge.ResultCallback
                            public void onReceiveResult(byte[] bArr) {
                                JSONArray jSONArray = (JSONArray) WXWsonJSONSwitch.parseWsonOrJSON(bArr);
                                if (jSONArray == null || jSONArray.size() <= 0) {
                                    return;
                                }
                                eventResult.onCallback(jSONArray.get(0));
                            }
                        } : null, true);
                        wXJSObjectArr[0] = null;
                    }
                } catch (Exception e) {
                    WXLogUtils.e("asyncCallJSEventWithResult", e);
                }
            }
        });
    }

    private boolean checkMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    private void doReportJSException(String str, String str2, WXErrorCode wXErrorCode, String str3) {
        String str4;
        String str5;
        File file;
        BufferedReader bufferedReader;
        WXSDKInstance wXSDKInstance = WXSDKManager.v().i().get(str);
        if (WXSDKManager.v().p() != null) {
            if (TextUtils.isEmpty(str)) {
                str = "instanceIdisNull";
            }
            if (wXSDKInstance == null && IWXUserTrackAdapter.INIT_FRAMEWORK.equals(str2)) {
                try {
                } catch (Throwable th) {
                    th = th;
                    str4 = null;
                }
                if (WXEnvironment.getApplication() != null) {
                    try {
                        file = new File(WXEnvironment.getApplication().getApplicationContext().getCacheDir().getPath() + INITLOGFILE);
                    } catch (Throwable th2) {
                        th = th2;
                        str4 = null;
                    }
                    if (file.exists()) {
                        if (file.length() > 0) {
                            StringBuilder sb = new StringBuilder();
                            try {
                                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
                                while (true) {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    sb.append(readLine + StringUtils.LF);
                                }
                                str5 = sb.toString();
                            } catch (Exception e) {
                                e = e;
                                str4 = null;
                            }
                            try {
                                try {
                                    bufferedReader.close();
                                } catch (Throwable th3) {
                                    str4 = str5;
                                    th = th3;
                                    try {
                                        WXLogUtils.e(WXLogUtils.getStackTrace(th));
                                    } catch (Throwable th4) {
                                        th = th4;
                                        WXLogUtils.e(WXLogUtils.getStackTrace(th));
                                        str5 = str4;
                                        str3 = str3 + StringUtils.LF + str5;
                                        WXLogUtils.e("reportJSException:" + str3);
                                        WXExceptionUtils.commitCriticalExceptionRT(str, wXErrorCode, str2, wXErrorCode.getErrorMsg() + str3, null);
                                    }
                                    str5 = str4;
                                    str3 = str3 + StringUtils.LF + str5;
                                    WXLogUtils.e("reportJSException:" + str3);
                                    WXExceptionUtils.commitCriticalExceptionRT(str, wXErrorCode, str2, wXErrorCode.getErrorMsg() + str3, null);
                                }
                            } catch (Exception e2) {
                                str4 = str5;
                                e = e2;
                                try {
                                    WXLogUtils.e(WXLogUtils.getStackTrace(e));
                                    str5 = str4;
                                    file.delete();
                                } catch (Throwable th5) {
                                    th = th5;
                                    WXLogUtils.e(WXLogUtils.getStackTrace(th));
                                    str5 = str4;
                                    str3 = str3 + StringUtils.LF + str5;
                                    WXLogUtils.e("reportJSException:" + str3);
                                    WXExceptionUtils.commitCriticalExceptionRT(str, wXErrorCode, str2, wXErrorCode.getErrorMsg() + str3, null);
                                }
                                str3 = str3 + StringUtils.LF + str5;
                                WXLogUtils.e("reportJSException:" + str3);
                                WXExceptionUtils.commitCriticalExceptionRT(str, wXErrorCode, str2, wXErrorCode.getErrorMsg() + str3, null);
                            }
                        } else {
                            str5 = null;
                        }
                        file.delete();
                        str3 = str3 + StringUtils.LF + str5;
                        WXLogUtils.e("reportJSException:" + str3);
                    }
                }
                str5 = null;
                str3 = str3 + StringUtils.LF + str5;
                WXLogUtils.e("reportJSException:" + str3);
            }
            WXExceptionUtils.commitCriticalExceptionRT(str, wXErrorCode, str2, wXErrorCode.getErrorMsg() + str3, null);
        }
    }

    private void execJSOnInstance(final EventResult eventResult, final String str, final String str2, final int i) {
        post(new Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.25
            @Override // java.lang.Runnable
            public void run() {
                eventResult.onCallback(WXBridgeManager.this.invokeExecJSOnInstance(str, str2, i));
            }
        });
    }

    private void execRegisterFailTask() {
        if (this.mRegisterModuleFailList.size() > 0) {
            ArrayList arrayList = new ArrayList();
            int size = this.mRegisterModuleFailList.size();
            for (int i = 0; i < size; i++) {
                invokeRegisterModules(this.mRegisterModuleFailList.get(i), arrayList);
            }
            this.mRegisterModuleFailList.clear();
            if (arrayList.size() > 0) {
                this.mRegisterModuleFailList.addAll(arrayList);
            }
        }
        if (this.mRegisterComponentFailList.size() > 0) {
            ArrayList arrayList2 = new ArrayList();
            invokeRegisterComponents(this.mRegisterComponentFailList, arrayList2);
            this.mRegisterComponentFailList.clear();
            if (arrayList2.size() > 0) {
                this.mRegisterComponentFailList.addAll(arrayList2);
            }
        }
        if (this.mRegisterServiceFailList.size() > 0) {
            ArrayList arrayList3 = new ArrayList();
            for (String str : this.mRegisterServiceFailList) {
                invokeExecJSService(str, arrayList3);
            }
            this.mRegisterServiceFailList.clear();
            if (arrayList3.size() > 0) {
                this.mRegisterServiceFailList.addAll(arrayList3);
            }
        }
    }

    private Pair<Pair<String, Object>, Boolean> extractCallbackArgs(String str) {
        try {
            JSONObject jSONObject = JSON.parseArray(str).getJSONObject(0);
            JSONArray jSONArray = jSONObject.getJSONArray("args");
            if (jSONArray.size() == 3 && METHOD_CALLBACK.equals(jSONObject.getString("method"))) {
                return new Pair<>(new Pair(jSONArray.getString(0), jSONArray.getJSONObject(1)), Boolean.valueOf(jSONArray.getBooleanValue(2)));
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private void fireEventOnDataRenderNode(final WXEaglePlugin wXEaglePlugin, final String str, final String str2, final String str3, final Map<String, Object> map, final Map<String, Object> map2) {
        this.mJSHandler.postDelayed(WXThread.secure(new Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.14
            @Override // java.lang.Runnable
            public void run() {
                String str4;
                Map map3;
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (WXEnvironment.isApkDebugable()) {
                        WXLogUtils.d("fireEventOnDataRenderNode >>>> instanceId:" + str + ", data:" + map);
                    }
                    WXEaglePlugin wXEaglePlugin2 = wXEaglePlugin;
                    String str5 = str;
                    String str6 = str2;
                    String str7 = str3;
                    Map map4 = map;
                    String str8 = "{}";
                    if (map4 != null && !map4.isEmpty()) {
                        str4 = JSON.toJSONString(map);
                        map3 = map2;
                        if (map3 != null && !map3.isEmpty()) {
                            str8 = JSON.toJSONString(map2);
                        }
                        wXEaglePlugin2.fireEvent(str5, str6, str7, str4, str8);
                        WXLogUtils.renderPerformanceLog("fireEventOnDataRenderNode", System.currentTimeMillis() - currentTimeMillis);
                    }
                    str4 = "{}";
                    map3 = map2;
                    if (map3 != null) {
                        str8 = JSON.toJSONString(map2);
                    }
                    wXEaglePlugin2.fireEvent(str5, str6, str7, str4, str8);
                    WXLogUtils.renderPerformanceLog("fireEventOnDataRenderNode", System.currentTimeMillis() - currentTimeMillis);
                } catch (Throwable th) {
                    String str9 = "[WXBridgeManager] fireEventOnDataRenderNode " + WXLogUtils.getStackTrace(th);
                    WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "fireEventOnDataRenderNode", str9, null);
                    WXLogUtils.e(str9);
                }
            }
        }), 0L);
    }

    public static WXBridgeManager getInstance() {
        if (mBridgeManager == null) {
            synchronized (WXBridgeManager.class) {
                if (mBridgeManager == null) {
                    mBridgeManager = new WXBridgeManager();
                }
            }
        }
        return mBridgeManager;
    }

    private void getNextTick(String str, String str2) {
        addJSTask(METHOD_CALLBACK, str, str2, "{}");
        sendMessage(str, 6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0108, code lost:
        if (android.os.Build.VERSION.SDK_INT < 16) goto L46;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void initFramework(java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 481
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.weex.bridge.WXBridgeManager.initFramework(java.lang.String):void");
    }

    private void initWXBridge(boolean z) {
        Method method;
        Constructor constructor;
        Method method2;
        if (z && WXEnvironment.isApkDebugable()) {
            WXEnvironment.sDebugServerConnectable = true;
        }
        if (WXEnvironment.sDebugServerConnectable) {
            WXEnvironment.isApkDebugable();
            if (WXEnvironment.getApplication() != null) {
                try {
                    if (clazz_debugProxy == null) {
                        clazz_debugProxy = DebugServerProxy.class;
                    }
                    Class cls = clazz_debugProxy;
                    if (cls != null && (constructor = cls.getConstructor(Context.class, IWXDebugConfig.class)) != null) {
                        Object newInstance = constructor.newInstance(WXEnvironment.getApplication(), new IWXDebugConfig() { // from class: com.taobao.weex.bridge.WXBridgeManager.4
                            @Override // com.taobao.weex.common.IWXDebugConfig
                            public WXDebugJsBridge getWXDebugJsBridge() {
                                return new WXDebugJsBridge();
                            }

                            @Override // com.taobao.weex.common.IWXDebugConfig
                            public WXBridgeManager getWXJSManager() {
                                return WXBridgeManager.this;
                            }
                        });
                        this.mWxDebugProxy = newInstance;
                        if (newInstance != null && (method2 = clazz_debugProxy.getMethod("start", new Class[0])) != null) {
                            method2.invoke(this.mWxDebugProxy, new Object[0]);
                        }
                    }
                } catch (Throwable unused) {
                }
                WXServiceManager.execAllCacheJsService();
            } else {
                WXLogUtils.e("WXBridgeManager", "WXEnvironment.sApplication is null, skip init Inspector");
            }
        }
        if (z && this.mWxDebugProxy != null) {
            try {
                if (clazz_debugProxy == null) {
                    clazz_debugProxy = DebugServerProxy.class;
                }
                Class cls2 = clazz_debugProxy;
                if (cls2 == null || (method = cls2.getMethod("getWXBridge", new Class[0])) == null) {
                    return;
                }
                this.mWXBridge = (IWXBridge) method.invoke(this.mWxDebugProxy, new Object[0]);
                return;
            } catch (Throwable unused2) {
                return;
            }
        }
        this.mWXBridge = new WXBridge();
    }

    private void invokeCallJSBatch(Message message) {
        if (!this.mNextTickTasks.isEmpty() && isJSFrameworkInit()) {
            try {
                Object obj = message.obj;
                Stack<String> instanceStack = this.mNextTickTasks.getInstanceStack();
                ArrayList<WXHashMap<String, Object>> arrayList = null;
                for (int size = instanceStack.size() - 1; size >= 0; size--) {
                    obj = instanceStack.get(size);
                    arrayList = this.mNextTickTasks.remove(obj);
                    if (arrayList != null && !arrayList.isEmpty()) {
                        break;
                    }
                }
                if (arrayList != null) {
                    invokeExecJS(String.valueOf(obj), null, METHOD_CALL_JS, new WXJSObject[]{new WXJSObject(2, obj), WXWsonJSONSwitch.toWsonOrJsonWXJSObject(arrayList.toArray())});
                }
            } catch (Throwable th) {
                WXLogUtils.e("WXBridgeManager", th);
                WXExceptionUtils.commitCriticalExceptionRT(null, WXErrorCode.WX_ERR_JS_FRAMEWORK, "invokeCallJSBatch", "invokeCallJSBatch#" + WXLogUtils.getStackTrace(th), null);
            }
            if (this.mNextTickTasks.isEmpty()) {
                return;
            }
            this.mJSHandler.sendEmptyMessage(6);
        } else if (!isJSFrameworkInit()) {
            WXLogUtils.e("[WXBridgeManager] invokeCallJSBatch: framework.js uninitialized!!  message:" + message.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Not initialized variable reg: 18, insn: 0x03a1: MOVE  (r2 I:??[OBJECT, ARRAY]) = (r18 I:??[OBJECT, ARRAY]), block:B:143:0x03a1 */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0221 A[Catch: all -> 0x03a0, TryCatch #0 {all -> 0x03a0, blocks: (B:92:0x01c8, B:104:0x01fe, B:106:0x0221, B:108:0x0253, B:110:0x0259, B:112:0x0267, B:114:0x0273, B:116:0x0279, B:118:0x0288, B:122:0x0292, B:124:0x0298, B:126:0x02a0, B:128:0x02a8, B:131:0x02b1, B:133:0x02f7, B:135:0x034d, B:94:0x01cd, B:96:0x01d7, B:99:0x01e0, B:101:0x01e8, B:103:0x01f6), top: B:148:0x01bd }] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0253 A[Catch: all -> 0x03a0, TryCatch #0 {all -> 0x03a0, blocks: (B:92:0x01c8, B:104:0x01fe, B:106:0x0221, B:108:0x0253, B:110:0x0259, B:112:0x0267, B:114:0x0273, B:116:0x0279, B:118:0x0288, B:122:0x0292, B:124:0x0298, B:126:0x02a0, B:128:0x02a8, B:131:0x02b1, B:133:0x02f7, B:135:0x034d, B:94:0x01cd, B:96:0x01d7, B:99:0x01e0, B:101:0x01e8, B:103:0x01f6), top: B:148:0x01bd }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0117 A[Catch: all -> 0x03a4, TryCatch #3 {all -> 0x03a4, blocks: (B:15:0x0053, B:51:0x00fd, B:53:0x0117, B:56:0x013a, B:58:0x0140, B:60:0x0149, B:65:0x0156, B:69:0x0165, B:73:0x0176, B:75:0x017d, B:78:0x0186, B:88:0x01b9, B:90:0x01bf, B:79:0x018d, B:81:0x0191, B:83:0x0197, B:84:0x019d, B:86:0x01a5, B:87:0x01b1, B:68:0x0161, B:64:0x0152, B:54:0x0128, B:50:0x00f6, B:16:0x0055, B:18:0x006b), top: B:151:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0128 A[Catch: all -> 0x03a4, TryCatch #3 {all -> 0x03a4, blocks: (B:15:0x0053, B:51:0x00fd, B:53:0x0117, B:56:0x013a, B:58:0x0140, B:60:0x0149, B:65:0x0156, B:69:0x0165, B:73:0x0176, B:75:0x017d, B:78:0x0186, B:88:0x01b9, B:90:0x01bf, B:79:0x018d, B:81:0x0191, B:83:0x0197, B:84:0x019d, B:86:0x01a5, B:87:0x01b1, B:68:0x0161, B:64:0x0152, B:54:0x0128, B:50:0x00f6, B:16:0x0055, B:18:0x006b), top: B:151:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x013a A[Catch: all -> 0x03a4, TryCatch #3 {all -> 0x03a4, blocks: (B:15:0x0053, B:51:0x00fd, B:53:0x0117, B:56:0x013a, B:58:0x0140, B:60:0x0149, B:65:0x0156, B:69:0x0165, B:73:0x0176, B:75:0x017d, B:78:0x0186, B:88:0x01b9, B:90:0x01bf, B:79:0x018d, B:81:0x0191, B:83:0x0197, B:84:0x019d, B:86:0x01a5, B:87:0x01b1, B:68:0x0161, B:64:0x0152, B:54:0x0128, B:50:0x00f6, B:16:0x0055, B:18:0x006b), top: B:151:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0152 A[Catch: all -> 0x03a4, TRY_ENTER, TryCatch #3 {all -> 0x03a4, blocks: (B:15:0x0053, B:51:0x00fd, B:53:0x0117, B:56:0x013a, B:58:0x0140, B:60:0x0149, B:65:0x0156, B:69:0x0165, B:73:0x0176, B:75:0x017d, B:78:0x0186, B:88:0x01b9, B:90:0x01bf, B:79:0x018d, B:81:0x0191, B:83:0x0197, B:84:0x019d, B:86:0x01a5, B:87:0x01b1, B:68:0x0161, B:64:0x0152, B:54:0x0128, B:50:0x00f6, B:16:0x0055, B:18:0x006b), top: B:151:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0161 A[Catch: all -> 0x03a4, TryCatch #3 {all -> 0x03a4, blocks: (B:15:0x0053, B:51:0x00fd, B:53:0x0117, B:56:0x013a, B:58:0x0140, B:60:0x0149, B:65:0x0156, B:69:0x0165, B:73:0x0176, B:75:0x017d, B:78:0x0186, B:88:0x01b9, B:90:0x01bf, B:79:0x018d, B:81:0x0191, B:83:0x0197, B:84:0x019d, B:86:0x01a5, B:87:0x01b1, B:68:0x0161, B:64:0x0152, B:54:0x0128, B:50:0x00f6, B:16:0x0055, B:18:0x006b), top: B:151:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x017d A[Catch: all -> 0x03a4, TryCatch #3 {all -> 0x03a4, blocks: (B:15:0x0053, B:51:0x00fd, B:53:0x0117, B:56:0x013a, B:58:0x0140, B:60:0x0149, B:65:0x0156, B:69:0x0165, B:73:0x0176, B:75:0x017d, B:78:0x0186, B:88:0x01b9, B:90:0x01bf, B:79:0x018d, B:81:0x0191, B:83:0x0197, B:84:0x019d, B:86:0x01a5, B:87:0x01b1, B:68:0x0161, B:64:0x0152, B:54:0x0128, B:50:0x00f6, B:16:0x0055, B:18:0x006b), top: B:151:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0191 A[Catch: all -> 0x03a4, TryCatch #3 {all -> 0x03a4, blocks: (B:15:0x0053, B:51:0x00fd, B:53:0x0117, B:56:0x013a, B:58:0x0140, B:60:0x0149, B:65:0x0156, B:69:0x0165, B:73:0x0176, B:75:0x017d, B:78:0x0186, B:88:0x01b9, B:90:0x01bf, B:79:0x018d, B:81:0x0191, B:83:0x0197, B:84:0x019d, B:86:0x01a5, B:87:0x01b1, B:68:0x0161, B:64:0x0152, B:54:0x0128, B:50:0x00f6, B:16:0x0055, B:18:0x006b), top: B:151:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01bf A[Catch: all -> 0x03a4, TRY_LEAVE, TryCatch #3 {all -> 0x03a4, blocks: (B:15:0x0053, B:51:0x00fd, B:53:0x0117, B:56:0x013a, B:58:0x0140, B:60:0x0149, B:65:0x0156, B:69:0x0165, B:73:0x0176, B:75:0x017d, B:78:0x0186, B:88:0x01b9, B:90:0x01bf, B:79:0x018d, B:81:0x0191, B:83:0x0197, B:84:0x019d, B:86:0x01a5, B:87:0x01b1, B:68:0x0161, B:64:0x0152, B:54:0x0128, B:50:0x00f6, B:16:0x0055, B:18:0x006b), top: B:151:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01cd A[Catch: all -> 0x03a0, TryCatch #0 {all -> 0x03a0, blocks: (B:92:0x01c8, B:104:0x01fe, B:106:0x0221, B:108:0x0253, B:110:0x0259, B:112:0x0267, B:114:0x0273, B:116:0x0279, B:118:0x0288, B:122:0x0292, B:124:0x0298, B:126:0x02a0, B:128:0x02a8, B:131:0x02b1, B:133:0x02f7, B:135:0x034d, B:94:0x01cd, B:96:0x01d7, B:99:0x01e0, B:101:0x01e8, B:103:0x01f6), top: B:148:0x01bd }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void invokeCreateInstance(@androidx.annotation.NonNull final com.taobao.weex.WXSDKInstance r20, final tb.r62 r21, java.util.Map<java.lang.String, java.lang.Object> r22, final java.lang.String r23) {
        /*
            Method dump skipped, instructions count: 1050
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.weex.bridge.WXBridgeManager.invokeCreateInstance(com.taobao.weex.WXSDKInstance, tb.r62, java.util.Map, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeDestroyInstance(String str) {
        try {
            WXEnvironment.isApkDebugable();
            WXJSObject[] wXJSObjectArr = {new WXJSObject(2, str)};
            if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
                invokeDestoryInstance(str, null, METHOD_DESTROY_INSTANCE, wXJSObjectArr, true);
            }
        } catch (Throwable th) {
            String str2 = "[WXBridgeManager] invokeDestroyInstance " + th.getCause();
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "invokeDestroyInstance", str2, null);
            WXLogUtils.e(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeExecJS(String str, String str2, String str3, WXJSObject[] wXJSObjectArr) {
        invokeExecJS(str, str2, str3, wXJSObjectArr, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String invokeExecJSOnInstance(String str, String str2, int i) {
        StringBuilder sb = this.mLodBuilder;
        sb.append("execJSOnInstance >>>> instanceId:");
        sb.append(str);
        WXLogUtils.d(this.mLodBuilder.substring(0));
        this.mLodBuilder.setLength(0);
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            return this.mWXBridge.execJSOnInstance(str, str2, i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeExecJSService(String str, List<String> list) {
        try {
            if (!isJSFrameworkInit()) {
                WXLogUtils.e("[WXBridgeManager] invoke execJSService: framework.js uninitialized.");
                list.add(str);
                return;
            }
            this.mWXBridge.execJSService(str);
        } catch (Throwable th) {
            WXLogUtils.e("[WXBridgeManager] invokeRegisterService:", th);
            HashMap hashMap = new HashMap();
            hashMap.put("inputParams", str + jn1.OR + list.toString());
            WXErrorCode wXErrorCode = WXErrorCode.WX_KEY_EXCEPTION_INVOKE_JSSERVICE_EXECUTE;
            WXExceptionUtils.commitCriticalExceptionRT("invokeExecJSService", wXErrorCode, "invokeExecJSService", wXErrorCode.getErrorMsg() + "[WXBridgeManager] invokeRegisterService:" + WXLogUtils.getStackTrace(th), hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeExecJSWithCallback(String str, String str2, String str3, WXJSObject[] wXJSObjectArr, ResultCallback resultCallback, boolean z) {
        WXEnvironment.isOpenDebugLog();
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            this.mWXBridge.execJSWithCallback(str, str2, str3, wXJSObjectArr, resultCallback);
        }
    }

    private void invokeInitFramework(Message message) {
        Object obj = message.obj;
        String str = obj != null ? (String) obj : "";
        if (WXUtils.getAvailMemory(WXEnvironment.getApplication()) > LOW_MEM_VALUE) {
            initFramework(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeRefreshInstance(String str, WXRefreshData wXRefreshData) {
        WXErrorCode wXErrorCode;
        try {
            WXSDKInstance y = WXSDKManager.v().y(str);
            if (!isSkipFrameworkInit(str) && !isJSFrameworkInit()) {
                if (y != null) {
                    y.onRenderError(WXErrorCode.WX_DEGRAD_ERR_INSTANCE_CREATE_FAILED.getErrorCode(), wXErrorCode.getErrorMsg() + "invokeRefreshInstance FAILED for JSFrameworkInit FAILED, intance will invoke instance.onRenderError");
                }
                WXLogUtils.e("[WXBridgeManager] invokeRefreshInstance: framework.js uninitialized.");
                return;
            }
            System.currentTimeMillis();
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.d("refreshInstance >>>> instanceId:" + str + ", data:" + wXRefreshData.data + ", isDirty:" + wXRefreshData.isDirty);
            }
            if (wXRefreshData.isDirty) {
                return;
            }
            WXJSObject wXJSObject = new WXJSObject(2, str);
            String str2 = wXRefreshData.data;
            if (str2 == null) {
                str2 = "{}";
            }
            this.mWXBridge.refreshInstance(str, null, METHOD_REFRESH_INSTANCE, new WXJSObject[]{wXJSObject, new WXJSObject(3, str2)});
        } catch (Throwable th) {
            String str3 = "[WXBridgeManager] invokeRefreshInstance " + WXLogUtils.getStackTrace(th);
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "invokeRefreshInstance", str3, null);
            WXLogUtils.e(str3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeRegisterComponents(List<Map<String, Object>> list, List<Map<String, Object>> list2) {
        WXJSObject[] wXJSObjectArr;
        String str;
        if (list != list2) {
            if (!isJSFrameworkInit()) {
                for (Map<String, Object> map : list) {
                    list2.add(map);
                }
                return;
            } else if (list == null) {
                return;
            } else {
                try {
                    str = this.mWXBridge.execJS("", null, METHOD_REGISTER_COMPONENTS, new WXJSObject[]{WXWsonJSONSwitch.toWsonOrJsonWXJSObject(list)}) == 0 ? "execJS error" : null;
                } catch (Throwable th) {
                    str = WXErrorCode.WX_KEY_EXCEPTION_INVOKE_REGISTER_COMPONENT + wXJSObjectArr.toString() + WXLogUtils.getStackTrace(th);
                }
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                WXLogUtils.e("[WXBridgeManager] invokeRegisterComponents ", str);
                WXExceptionUtils.commitCriticalExceptionRT(null, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_REGISTER_COMPONENT, METHOD_REGISTER_COMPONENTS, str, null);
                return;
            }
        }
        throw new RuntimeException("Fail receiver should not use source.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeRegisterModules(Map<String, Object> map, List<Map<String, Object>> list) {
        String str;
        if (map != null && isJSFrameworkInit()) {
            try {
                str = this.mWXBridge.execJS("", null, METHOD_REGISTER_MODULES, new WXJSObject[]{WXWsonJSONSwitch.toWsonOrJsonWXJSObject(map)}) == 0 ? "execJS error" : null;
                for (String str2 : map.keySet()) {
                    if (str2 != null) {
                        WXModuleManager.resetModuleState(str2, true);
                    }
                }
            } catch (Throwable th) {
                str = WXErrorCode.WX_KEY_EXCEPTION_INVOKE_REGISTER_MODULES.getErrorMsg() + " \n " + th.getMessage() + map.entrySet().toString();
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            WXLogUtils.e("[WXBridgeManager] invokeRegisterModules:", str);
            WXExceptionUtils.commitCriticalExceptionRT(null, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_REGISTER_MODULES, "invokeRegisterModules", str, null);
            return;
        }
        if (!isJSFrameworkInit()) {
            WXLogUtils.d("[WXinvokeRegisterModulesBridgeManager] invokeRegisterModules: framework.js uninitialized.");
        }
        list.add(map);
    }

    private boolean isSkipFrameworkInit(String str) {
        return isSkipFrameworkInit(WXSDKManager.v().y(str));
    }

    private void mock(String str) {
    }

    private void onJsFrameWorkInitSuccees() {
        for (Map.Entry<String, String> entry : mWeexCoreEnvOptions.entrySet()) {
            this.mWXBridge.registerCoreEnv(entry.getKey(), entry.getValue());
        }
        mWeexCoreEnvOptions.clear();
    }

    private void registerDomModule() throws WXException {
        HashMap hashMap = new HashMap();
        hashMap.put(WXDomModule.WXDOM, WXDomModule.METHODS);
        registerModules(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeTaskByInstance(String str) {
        this.mNextTickTasks.removeFromMapAndStack(str);
    }

    private void sendMessage(String str, int i) {
        Message obtain = Message.obtain(this.mJSHandler);
        obtain.obj = str;
        obtain.what = i;
        obtain.sendToTarget();
    }

    private void setExceedGPULimitComponentsInfo(String str, String str2, GraphicSize graphicSize) {
        float openGLRenderLimitValue = WXRenderManager.getOpenGLRenderLimitValue();
        if (openGLRenderLimitValue > 0.0f) {
            if (graphicSize.getHeight() > openGLRenderLimitValue || graphicSize.getWidth() > openGLRenderLimitValue) {
                JSONObject jSONObject = new JSONObject();
                WXComponent wXComponent = WXSDKManager.v().G().getWXComponent(str, str2);
                jSONObject.put("GPU limit", (Object) String.valueOf(openGLRenderLimitValue));
                jSONObject.put("component.width", (Object) String.valueOf(graphicSize.getWidth()));
                jSONObject.put("component.height", (Object) String.valueOf(graphicSize.getHeight()));
                if (wXComponent.getComponentType() != null && !wXComponent.getComponentType().isEmpty()) {
                    jSONObject.put("component.type", (Object) wXComponent.getComponentType());
                }
                if (wXComponent.getStyles() != null && !wXComponent.getStyles().isEmpty()) {
                    jSONObject.put("component.style", (Object) wXComponent.getStyles().toString());
                }
                if (wXComponent.getAttrs() != null && !wXComponent.getAttrs().isEmpty()) {
                    jSONObject.put("component.attr", (Object) wXComponent.getAttrs().toString());
                }
                if (wXComponent.getEvents() != null && !wXComponent.getEvents().isEmpty()) {
                    jSONObject.put("component.event", (Object) wXComponent.getEvents().toString());
                }
                if (wXComponent.getMargin() != null) {
                    jSONObject.put("component.margin", (Object) wXComponent.getMargin().toString());
                }
                if (wXComponent.getPadding() != null) {
                    jSONObject.put("component.padding", (Object) wXComponent.getPadding().toString());
                }
                if (wXComponent.getBorder() != null) {
                    jSONObject.put("component.border", (Object) wXComponent.getBorder().toString());
                }
                WXSDKManager.v().y(str).setComponentsInfoExceedGPULimit(jSONObject);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJSFrameworkInit(boolean z) {
        mInit = z;
        WXStateRecord d = WXStateRecord.d();
        d.n("setJsfmInitFlag:" + z);
        if (z) {
            onJsFrameWorkInitSuccees();
            JSEngine.getInstance().engineInitFinished();
        }
    }

    private void trackComponentAndModulesTime() {
        post(new Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.26
            @Override // java.lang.Runnable
            public void run() {
                WXEnvironment.sComponentsAndModulesReadyTime = System.currentTimeMillis() - WXEnvironment.sSDKInitStart;
            }
        });
    }

    public static void updateGlobalConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "none";
        }
        if (TextUtils.equals(str, globalConfig)) {
            return;
        }
        globalConfig = str;
        WXEnvironment.addCustomOptions(GLOBAL_CONFIG_KEY, str);
        Runnable runnable = new Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.30
            @Override // java.lang.Runnable
            public void run() {
                if (WXBridgeManager.mBridgeManager != null && WXBridgeManager.mBridgeManager.isJSFrameworkInit() && (WXBridgeManager.mBridgeManager.mWXBridge instanceof WXBridge)) {
                    ((WXBridge) WXBridgeManager.mBridgeManager.mWXBridge).nativeUpdateGlobalConfig(WXBridgeManager.globalConfig);
                }
                if (WXBridgeManager.globalConfig.contains(WXWsonJSONSwitch.WSON_OFF)) {
                    WXWsonJSONSwitch.USE_WSON = false;
                } else {
                    WXWsonJSONSwitch.USE_WSON = true;
                }
            }
        };
        if (mBridgeManager != null && mBridgeManager.isJSFrameworkInit()) {
            mBridgeManager.post(runnable);
        } else {
            runnable.run();
        }
    }

    public void asyncCallJSEventVoidResult(final String str, final String str2, final List<Object> list, final Object... objArr) {
        post(new Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Object[] objArr2 = objArr;
                    if (objArr2 != null && objArr2.length != 0) {
                        ArrayList arrayList = new ArrayList();
                        for (Object obj : objArr) {
                            arrayList.add(obj);
                        }
                        if (list != null) {
                            ArrayMap arrayMap = new ArrayMap(4);
                            arrayMap.put("params", list);
                            arrayList.add(arrayMap);
                        }
                        WXHashMap wXHashMap = new WXHashMap();
                        wXHashMap.put("method", str);
                        wXHashMap.put("args", arrayList);
                        WXJSObject[] wXJSObjectArr = {new WXJSObject(2, str2), WXWsonJSONSwitch.toWsonOrJsonWXJSObject(new Object[]{wXHashMap})};
                        WXBridgeManager.this.invokeExecJS(String.valueOf(str2), null, WXBridgeManager.METHOD_CALL_JS, wXJSObjectArr, true);
                        wXJSObjectArr[0] = null;
                    }
                } catch (Exception e) {
                    WXLogUtils.e("asyncCallJSEventVoidResult", e);
                }
            }
        });
    }

    public void bindMeasurementToRenderObject(long j) {
        if (isJSFrameworkInit()) {
            this.mWXBridge.bindMeasurementToRenderObject(j);
        }
    }

    public int callAddChildToRichtext(String str, String str2, String str3, String str4, String str5, HashMap<String, String> hashMap, HashMap<String, String> hashMap2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            WXEnvironment.isApkDebugable();
            HashSet<String> hashSet = this.mDestroyedInstanceId;
            if (hashSet == null || !hashSet.contains(str)) {
                try {
                    WXSDKInstance y = WXSDKManager.v().y(str);
                    if (y != null) {
                        GraphicActionAddChildToRichtext graphicActionAddChildToRichtext = new GraphicActionAddChildToRichtext(y, str2, str3, str4, str5, hashMap, hashMap2);
                        WXSDKManager.v().G().postGraphicAction(graphicActionAddChildToRichtext.getPageId(), graphicActionAddChildToRichtext);
                        return 1;
                    }
                    return 1;
                } catch (Exception e) {
                    WXLogUtils.e("[WXBridgeManager] callAddChildToRichtext exception: ", WXLogUtils.getStackTrace(e));
                    WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callAddChildToRichtext", WXLogUtils.getStackTrace(e), null);
                    return 1;
                }
            }
            return -1;
        }
        if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.d("[WXBridgeManager] call callAddChildToRichtext arguments is null");
        }
        WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callAddChildToRichtext", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
        return 0;
    }

    public int callAddElement(String str, String str2, String str3, int i, String str4, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, HashSet<String> hashSet, float[] fArr, float[] fArr2, float[] fArr3, boolean z) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            WXEnvironment.isApkDebugable();
            HashSet<String> hashSet2 = this.mDestroyedInstanceId;
            if (hashSet2 == null || !hashSet2.contains(str)) {
                try {
                    WXSDKInstance y = WXSDKManager.v().y(str);
                    if (y != null) {
                        GraphicActionAddElement graphicActionAddElement = new GraphicActionAddElement(y, str3, str2, str4, i, hashMap, hashMap2, hashSet, fArr, fArr2, fArr3);
                        if (z) {
                            y.addInActiveAddElementAction(str3, graphicActionAddElement);
                            return 1;
                        }
                        WXSDKManager.v().G().postGraphicAction(str, graphicActionAddElement);
                        return 1;
                    }
                    return 1;
                } catch (Exception e) {
                    WXLogUtils.e("[WXBridgeManager] callAddElement exception: ", e);
                    WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callAddElement", WXLogUtils.getStackTrace(e), null);
                    return 1;
                }
            }
            return -1;
        }
        if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.d("[WXBridgeManager] call callAddElement arguments is null");
        }
        WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callAddElement", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
        return 0;
    }

    public int callAddEvent(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            WXEnvironment.isApkDebugable();
            HashSet<String> hashSet = this.mDestroyedInstanceId;
            if (hashSet == null || !hashSet.contains(str)) {
                try {
                    WXSDKInstance y = WXSDKManager.v().y(str);
                    if (y != null) {
                        new GraphicActionAddEvent(y, str2, str3).executeActionOnRender();
                    }
                } catch (Exception e) {
                    WXLogUtils.e("[WXBridgeManager] callAddEvent exception: ", e);
                    WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callAddEvent", WXLogUtils.getStackTrace(e), null);
                }
                getNextTick(str);
                return 1;
            }
            return -1;
        }
        if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.d("[WXBridgeManager] call callAddEvent arguments is null");
        }
        WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callAddEvent", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
        return 0;
    }

    public int callAppendTreeCreateFinish(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            WXEnvironment.isApkDebugable();
            HashSet<String> hashSet = this.mDestroyedInstanceId;
            if (hashSet == null || !hashSet.contains(str)) {
                try {
                    WXSDKManager.v().G().postGraphicAction(str, new GraphicActionAppendTreeCreateFinish(WXSDKManager.v().y(str), str2));
                    return 1;
                } catch (Exception e) {
                    WXLogUtils.e("[WXBridgeManager] callAppendTreeCreateFinish exception: ", e);
                    WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callAppendTreeCreateFinish", WXLogUtils.getStackTrace(e), null);
                    return 1;
                }
            }
            return -1;
        }
        WXLogUtils.d("[WXBridgeManager] call callAppendTreeCreateFinish arguments is null");
        WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callAppendTreeCreateFinish", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
        return 0;
    }

    public int callCreateBody(String str, String str2, String str3, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, HashSet<String> hashSet, float[] fArr, float[] fArr2, float[] fArr3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            WXEnvironment.isApkDebugable();
            HashSet<String> hashSet2 = this.mDestroyedInstanceId;
            if (hashSet2 == null || !hashSet2.contains(str)) {
                try {
                    WXSDKInstance y = WXSDKManager.v().y(str);
                    if (y != null) {
                        GraphicActionCreateBody graphicActionCreateBody = new GraphicActionCreateBody(y, str3, str2, hashMap, hashMap2, hashSet, fArr, fArr2, fArr3);
                        WXSDKManager.v().G().postGraphicAction(graphicActionCreateBody.getPageId(), graphicActionCreateBody);
                        return 1;
                    }
                    return 1;
                } catch (Exception e) {
                    WXLogUtils.e("[WXBridgeManager] callCreateBody exception: ", e);
                    WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callCreateBody", WXLogUtils.getStackTrace(e), null);
                    return 1;
                }
            }
            return -1;
        }
        WXLogUtils.d("[WXBridgeManager] call callCreateBody arguments is null");
        WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callCreateBody", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
        return 0;
    }

    public int callCreateFinish(String str) {
        if (TextUtils.isEmpty(str)) {
            WXLogUtils.d("[WXBridgeManager] call callCreateFinish arguments is null");
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callCreateFinish", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        WXEnvironment.isApkDebugable();
        HashSet<String> hashSet = this.mDestroyedInstanceId;
        if (hashSet == null || !hashSet.contains(str)) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                WXSDKInstance y = WXSDKManager.v().y(str);
                if (y != null) {
                    y.getApmForInstance().r("callCreateFinish");
                    y.firstScreenCreateInstanceTime(currentTimeMillis);
                    WXSDKManager.v().G().postGraphicAction(str, new GraphicActionCreateFinish(y));
                    return 1;
                }
                return 1;
            } catch (Exception e) {
                WXLogUtils.e("[WXBridgeManager] callCreateFinish exception: ", e);
                WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callCreateFinish", WXLogUtils.getStackTrace(e), null);
                return 1;
            }
        }
        return -1;
    }

    public int callHasTransitionPros(String str, String str2, HashMap<String, String> hashMap) {
        WXComponent wXComponent = WXSDKManager.v().G().getWXComponent(str, str2);
        if (wXComponent == null || wXComponent.getTransition() == null || wXComponent.getTransition().getProperties() == null) {
            return -1;
        }
        for (String str3 : wXComponent.getTransition().getProperties()) {
            if (hashMap.containsKey(str3)) {
                return 1;
            }
        }
        return 0;
    }

    public int callLayout(String str, String str2, int i, int i2, int i3, int i4, int i5, int i6, boolean z, int i7) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            WXEnvironment.isApkDebugable();
            HashSet<String> hashSet = this.mDestroyedInstanceId;
            if (hashSet == null || !hashSet.contains(str)) {
                try {
                    WXSDKInstance y = WXSDKManager.v().y(str);
                    if (y != null) {
                        GraphicSize graphicSize = new GraphicSize(i6, i5);
                        GraphicPosition graphicPosition = new GraphicPosition(i3, i, i4, i2);
                        setExceedGPULimitComponentsInfo(str, str2, graphicSize);
                        GraphicActionAddElement inActiveAddElementAction = y.getInActiveAddElementAction(str2);
                        if (inActiveAddElementAction != null) {
                            inActiveAddElementAction.setRTL(z);
                            inActiveAddElementAction.setSize(graphicSize);
                            inActiveAddElementAction.setPosition(graphicPosition);
                            if (!TextUtils.equals(str2, WXComponent.ROOT)) {
                                inActiveAddElementAction.setIndex(i7);
                            }
                            WXSDKManager.v().G().postGraphicAction(str, inActiveAddElementAction);
                            y.removeInActiveAddElmentAction(str2);
                            return 1;
                        }
                        GraphicActionLayout graphicActionLayout = new GraphicActionLayout(y, str2, graphicPosition, graphicSize, z);
                        WXSDKManager.v().G().postGraphicAction(graphicActionLayout.getPageId(), graphicActionLayout);
                        return 1;
                    }
                    return 1;
                } catch (Exception e) {
                    WXLogUtils.e("[WXBridgeManager] callLayout exception: ", e);
                    WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callLayout", WXLogUtils.getStackTrace(e), null);
                    return 1;
                }
            }
            return -1;
        }
        if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.d("[WXBridgeManager] call callLayout arguments is null");
        }
        WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callLayout", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
        return 0;
    }

    public Object callModuleMethod(String str, String str2, String str3, JSONArray jSONArray) {
        return callModuleMethod(str, str2, str3, jSONArray, null);
    }

    public int callMoveElement(String str, String str2, String str3, int i) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            WXEnvironment.isApkDebugable();
            HashSet<String> hashSet = this.mDestroyedInstanceId;
            if (hashSet == null || !hashSet.contains(str)) {
                try {
                    WXSDKInstance y = WXSDKManager.v().y(str);
                    if (y != null) {
                        GraphicActionMoveElement graphicActionMoveElement = new GraphicActionMoveElement(y, str2, str3, i);
                        WXSDKManager.v().G().postGraphicAction(graphicActionMoveElement.getPageId(), graphicActionMoveElement);
                        return 1;
                    }
                    return 1;
                } catch (Exception e) {
                    WXLogUtils.e("[WXBridgeManager] callMoveElement exception: ", e);
                    WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callMoveElement", WXLogUtils.getStackTrace(e), null);
                    return 1;
                }
            }
            return -1;
        }
        if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.d("[WXBridgeManager] call callMoveElement arguments is null");
        }
        WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callMoveElement", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
        return 0;
    }

    public int callNative(String str, JSONArray jSONArray, String str2) {
        int i;
        int i2;
        JSONArray jSONArray2 = jSONArray;
        if (!TextUtils.isEmpty(str) && jSONArray2 != null) {
            WXEnvironment.isApkDebugable();
            HashSet<String> hashSet = this.mDestroyedInstanceId;
            if (hashSet == null || !hashSet.contains(str)) {
                long nanoTime = System.nanoTime() - System.nanoTime();
                int i3 = 1;
                if (jSONArray.size() > 0) {
                    int size = jSONArray.size();
                    int i4 = 0;
                    while (i4 < size) {
                        try {
                            JSONObject jSONObject = (JSONObject) jSONArray2.get(i4);
                            if (jSONObject != null && WXSDKManager.v().y(str) != null) {
                                Object obj = jSONObject.get("module");
                                if (obj != null) {
                                    if (WXDomModule.WXDOM.equals(obj)) {
                                        WXDomModule domModule = WXModuleManager.getDomModule(str);
                                        long[] jArr = new long[i3];
                                        jArr[0] = nanoTime;
                                        domModule.callDomMethod(jSONObject, jArr);
                                    } else {
                                        JSONObject jSONObject2 = jSONObject.getJSONObject(OPTIONS);
                                        WXStateRecord d = WXStateRecord.d();
                                        d.i(str, "callModuleMethod:" + str + "," + obj + "," + jSONObject.get("method"));
                                        i = i4;
                                        i2 = size;
                                        callModuleMethod(str, (String) obj, (String) jSONObject.get("method"), (JSONArray) jSONObject.get("args"), jSONObject2);
                                    }
                                } else {
                                    i = i4;
                                    i2 = size;
                                    if (jSONObject.get("component") != null) {
                                        WXDomModule domModule2 = WXModuleManager.getDomModule(str);
                                        WXStateRecord d2 = WXStateRecord.d();
                                        d2.i(str, "callDomMethod:" + str + "," + jSONObject.get("method"));
                                        domModule2.invokeMethod((String) jSONObject.get("ref"), (String) jSONObject.get("method"), (JSONArray) jSONObject.get("args"));
                                    } else {
                                        throw new IllegalArgumentException("unknown callNative");
                                    }
                                }
                                i4 = i + 1;
                                jSONArray2 = jSONArray;
                                size = i2;
                                i3 = 1;
                            }
                            i = i4;
                            i2 = size;
                            i4 = i + 1;
                            jSONArray2 = jSONArray;
                            size = i2;
                            i3 = 1;
                        } catch (Exception e) {
                            WXLogUtils.e("[WXBridgeManager] callNative exception: ", e);
                            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callNative", WXLogUtils.getStackTrace(e), null);
                        }
                    }
                }
                if ("undefined".equals(str2) || "-1".equals(str2)) {
                    return 0;
                }
                getNextTick(str, str2);
                return 1;
            }
            return -1;
        }
        WXLogUtils.d("[WXBridgeManager] call callNative arguments is null");
        WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callNative", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
        return 0;
    }

    public Object callNativeComponent(String str, String str2, String str3, JSONArray jSONArray, Object obj) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            WXEnvironment.isApkDebugable();
            try {
                WXDomModule domModule = WXModuleManager.getDomModule(str);
                if (domModule != null) {
                    domModule.invokeMethod(str2, str3, jSONArray);
                } else {
                    WXSDKInstance y = WXSDKManager.v().y(str);
                    if (y == null || !y.isDestroy()) {
                        WXLogUtils.e("WXBridgeManager", "callNativeComponent exception :null == dom ,method:" + str3);
                    }
                }
            } catch (Exception e) {
                WXLogUtils.e("[WXBridgeManager] callNativeComponent exception: ", e);
                WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callNativeComponent", WXLogUtils.getStackTrace(e), null);
            }
            return null;
        }
        WXLogUtils.d("[WXBridgeManager] call callNativeComponent arguments is null");
        WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callNativeComponent", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
        return 0;
    }

    public Object callNativeModule(String str, String str2, String str3, JSONArray jSONArray, Object obj) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            WXEnvironment.isApkDebugable();
            try {
                if (WXDomModule.WXDOM.equals(str2)) {
                    return WXModuleManager.getDomModule(str).callDomMethod(str3, jSONArray, new long[0]);
                }
                return callModuleMethod(str, str2, str3, jSONArray);
            } catch (Exception e) {
                String str4 = "[WXBridgeManager] callNative exception: " + WXLogUtils.getStackTrace(e);
                WXLogUtils.e(str4);
                WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callNativeModule", str4, null);
                return null;
            }
        }
        WXLogUtils.d("[WXBridgeManager] call callNativeModule arguments is null");
        WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callNativeModule", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
        return 0;
    }

    public int callRefreshFinish(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            WXLogUtils.d("[WXBridgeManager] call callRefreshFinish arguments is null");
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callRefreshFinish", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        WXEnvironment.isApkDebugable();
        HashSet<String> hashSet = this.mDestroyedInstanceId;
        if (hashSet == null || !hashSet.contains(str)) {
            try {
                WXSDKInstance y = WXSDKManager.v().y(str);
                if (y != null) {
                    WXSDKManager.v().G().postGraphicAction(str, new GraphicActionRefreshFinish(y));
                }
            } catch (Exception e) {
                WXLogUtils.e("[WXBridgeManager] callRefreshFinish exception: ", e);
                WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callRefreshFinish", WXLogUtils.getStackTrace(e), null);
            }
            if ("undefined".equals(str2) || "-1".equals(str2)) {
                return 0;
            }
            getNextTick(str, str2);
            return 1;
        }
        return -1;
    }

    public int callRemoveChildFromRichtext(String str, String str2, String str3, String str4) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            WXEnvironment.isApkDebugable();
            HashSet<String> hashSet = this.mDestroyedInstanceId;
            if (hashSet == null || !hashSet.contains(str)) {
                try {
                    WXSDKInstance y = WXSDKManager.v().y(str);
                    if (y != null) {
                        GraphicActionRemoveChildFromRichtext graphicActionRemoveChildFromRichtext = new GraphicActionRemoveChildFromRichtext(y, str2, str3, str4);
                        WXSDKManager.v().G().postGraphicAction(graphicActionRemoveChildFromRichtext.getPageId(), graphicActionRemoveChildFromRichtext);
                        return 1;
                    }
                    return 1;
                } catch (Exception e) {
                    WXLogUtils.e("[WXBridgeManager] callRemoveChildFromRichtext exception: ", e);
                    WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callRemoveChildFromRichtext", WXLogUtils.getStackTrace(e), null);
                    return 1;
                }
            }
            return -1;
        }
        if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.d("[WXBridgeManager] call callRemoveChildFromRichtext arguments is null");
        }
        WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callRemoveChildFromRichtext", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
        return 0;
    }

    public int callRemoveElement(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            WXEnvironment.isApkDebugable();
            HashSet<String> hashSet = this.mDestroyedInstanceId;
            if (hashSet == null || !hashSet.contains(str)) {
                try {
                    WXSDKInstance y = WXSDKManager.v().y(str);
                    if (y != null) {
                        GraphicActionRemoveElement graphicActionRemoveElement = new GraphicActionRemoveElement(y, str2);
                        if (y.getInActiveAddElementAction(str2) != null) {
                            y.removeInActiveAddElmentAction(str2);
                            return 1;
                        }
                        WXSDKManager.v().G().postGraphicAction(graphicActionRemoveElement.getPageId(), graphicActionRemoveElement);
                        return 1;
                    }
                    return 1;
                } catch (Exception e) {
                    WXLogUtils.e("[WXBridgeManager] callRemoveElement exception: ", e);
                    WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callRemoveElement", WXLogUtils.getStackTrace(e), null);
                    return 1;
                }
            }
            return -1;
        }
        if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.d("[WXBridgeManager] call callRemoveElement arguments is null");
        }
        WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callRemoveElement", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
        return 0;
    }

    public int callRemoveEvent(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            WXEnvironment.isApkDebugable();
            HashSet<String> hashSet = this.mDestroyedInstanceId;
            if (hashSet == null || !hashSet.contains(str)) {
                try {
                    WXSDKInstance y = WXSDKManager.v().y(str);
                    if (y != null) {
                        new GraphicActionRemoveEvent(y, str2, str3).executeActionOnRender();
                    }
                } catch (Exception e) {
                    WXLogUtils.e("[WXBridgeManager] callRemoveEvent exception: ", e);
                    WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callRemoveEvent", WXLogUtils.getStackTrace(e), null);
                }
                getNextTick(str);
                return 1;
            }
            return -1;
        }
        if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.d("[WXBridgeManager] call callRemoveEvent arguments is null");
        }
        WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callRemoveEvent", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
        return 0;
    }

    public int callRenderSuccess(String str) {
        if (TextUtils.isEmpty(str)) {
            WXLogUtils.d("[WXBridgeManager] call callRenderSuccess arguments is null");
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callRenderSuccess", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        WXEnvironment.isApkDebugable();
        HashSet<String> hashSet = this.mDestroyedInstanceId;
        if (hashSet == null || !hashSet.contains(str)) {
            try {
                WXSDKInstance y = WXSDKManager.v().y(str);
                if (y != null) {
                    y.getApmForInstance().r("callRenderSuccess");
                    WXSDKManager.v().G().postGraphicAction(str, new GraphicActionRenderSuccess(y));
                    return 1;
                }
                return 1;
            } catch (Exception e) {
                WXLogUtils.e("[WXBridgeManager] callRenderSuccess exception: ", e);
                WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callRenderSuccess", WXLogUtils.getStackTrace(e), null);
                return 1;
            }
        }
        return -1;
    }

    public void callReportCrash(String str, final String str2, final String str3, final Map<String, String> map) {
        final String str4 = str + "." + new SimpleDateFormat("yyyyMMddHHmmss", Locale.US).format(new Date());
        File file = new File(str);
        File file2 = new File(str4);
        if (file.exists()) {
            file.renameTo(file2);
        }
        new Thread(new Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    File file3 = new File(str4);
                    if (file3.exists()) {
                        if (file3.length() > 0) {
                            StringBuilder sb = new StringBuilder();
                            try {
                                BufferedReader bufferedReader = new BufferedReader(new FileReader(str4));
                                while (true) {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        break;
                                    } else if (!"".equals(readLine)) {
                                        sb.append(readLine + StringUtils.LF);
                                    }
                                }
                                WXBridgeManager.this.commitJscCrashAlarmMonitor(IWXUserTrackAdapter.JS_BRIDGE, WXErrorCode.WX_ERR_JSC_CRASH, sb.toString(), str2, str3, map);
                                bufferedReader.close();
                            } catch (Exception e) {
                                WXLogUtils.e(WXLogUtils.getStackTrace(e));
                            }
                        } else {
                            WXLogUtils.e("[WXBridgeManager] callReportCrash crash file is empty");
                        }
                        if (WXEnvironment.isApkDebugable()) {
                            return;
                        }
                        file3.delete();
                    }
                } catch (Throwable th) {
                    WXLogUtils.e("[WXBridgeManager] callReportCrash exception: ", th);
                }
            }
        }).start();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e2 A[Catch: Exception -> 0x019e, TryCatch #0 {Exception -> 0x019e, blocks: (B:3:0x000e, B:5:0x0019, B:7:0x0023, B:22:0x008e, B:26:0x009a, B:32:0x00c1, B:34:0x00e2, B:36:0x00fd, B:39:0x0106, B:41:0x010e, B:60:0x0187, B:62:0x0196, B:21:0x0087, B:27:0x00a3, B:31:0x00af), top: B:76:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00fd A[Catch: Exception -> 0x019e, TRY_LEAVE, TryCatch #0 {Exception -> 0x019e, blocks: (B:3:0x000e, B:5:0x0019, B:7:0x0023, B:22:0x008e, B:26:0x009a, B:32:0x00c1, B:34:0x00e2, B:36:0x00fd, B:39:0x0106, B:41:0x010e, B:60:0x0187, B:62:0x0196, B:21:0x0087, B:27:0x00a3, B:31:0x00af), top: B:76:0x000e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int callReportCrashReloadPage(java.lang.String r17, java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 471
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.weex.bridge.WXBridgeManager.callReportCrashReloadPage(java.lang.String, java.lang.String):int");
    }

    public int callUpdateAttrs(String str, String str2, HashMap<String, String> hashMap) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            WXEnvironment.isApkDebugable();
            HashSet<String> hashSet = this.mDestroyedInstanceId;
            if (hashSet == null || !hashSet.contains(str)) {
                try {
                    WXSDKInstance y = WXSDKManager.v().y(str);
                    if (y != null) {
                        GraphicActionUpdateAttr graphicActionUpdateAttr = new GraphicActionUpdateAttr(y, str2, hashMap);
                        WXSDKManager.v().G().postGraphicAction(graphicActionUpdateAttr.getPageId(), graphicActionUpdateAttr);
                        return 1;
                    }
                    return 1;
                } catch (Exception e) {
                    WXLogUtils.e("[WXBridgeManager] callUpdateAttrs exception: ", e);
                    WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callUpdateAttrs", WXLogUtils.getStackTrace(e), null);
                    return 1;
                }
            }
            return -1;
        }
        if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.d("[WXBridgeManager] call callUpdateAttrs arguments is null");
        }
        WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callUpdateAttrs", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
        return 0;
    }

    public int callUpdateFinish(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            WXLogUtils.d("[WXBridgeManager] call callUpdateFinish arguments is null");
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callUpdateFinish", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        WXEnvironment.isApkDebugable();
        HashSet<String> hashSet = this.mDestroyedInstanceId;
        if (hashSet == null || !hashSet.contains(str)) {
            try {
                WXSDKManager.v().y(str);
            } catch (Exception e) {
                WXLogUtils.e("[WXBridgeManager] callUpdateFinish exception: ", e);
                WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callUpdateFinish", WXLogUtils.getStackTrace(e), null);
            }
            if (str2 == null || str2.isEmpty() || "undefined".equals(str2) || "-1".equals(str2)) {
                return 0;
            }
            getNextTick(str, str2);
            return 1;
        }
        return -1;
    }

    public int callUpdateRichtextChildAttr(String str, String str2, HashMap<String, String> hashMap, String str3, String str4) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            WXEnvironment.isApkDebugable();
            HashSet<String> hashSet = this.mDestroyedInstanceId;
            if (hashSet == null || !hashSet.contains(str)) {
                try {
                    WXSDKInstance y = WXSDKManager.v().y(str);
                    if (y != null) {
                        GraphicActionUpdateRichtextAttr graphicActionUpdateRichtextAttr = new GraphicActionUpdateRichtextAttr(y, str2, hashMap, str3, str4);
                        WXSDKManager.v().G().postGraphicAction(graphicActionUpdateRichtextAttr.getPageId(), graphicActionUpdateRichtextAttr);
                        return 1;
                    }
                    return 1;
                } catch (Exception e) {
                    WXLogUtils.e("[WXBridgeManager] callUpdateRichtextChildAttr exception: ", e);
                    WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callUpdateRichtextChildAttr", WXLogUtils.getStackTrace(e), null);
                    return 1;
                }
            }
            return -1;
        }
        if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.d("[WXBridgeManager] call callUpdateRichtextChildAttr arguments is null");
        }
        WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callUpdateRichtextChildAttr", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
        return 0;
    }

    public int callUpdateRichtextStyle(String str, String str2, HashMap<String, String> hashMap, String str3, String str4) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            WXEnvironment.isApkDebugable();
            HashSet<String> hashSet = this.mDestroyedInstanceId;
            if (hashSet == null || !hashSet.contains(str)) {
                try {
                    WXSDKInstance y = WXSDKManager.v().y(str);
                    if (y != null) {
                        GraphicActionUpdateRichtextStyle graphicActionUpdateRichtextStyle = new GraphicActionUpdateRichtextStyle(y, str2, hashMap, str3, str4);
                        WXSDKManager.v().G().postGraphicAction(graphicActionUpdateRichtextStyle.getPageId(), graphicActionUpdateRichtextStyle);
                        return 1;
                    }
                    return 1;
                } catch (Exception e) {
                    WXLogUtils.e("[WXBridgeManager] callUpdateRichtextStyle exception: ", e);
                    WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callUpdateRichtextStyle", WXLogUtils.getStackTrace(e), null);
                    return 1;
                }
            }
            return -1;
        }
        if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.d("[WXBridgeManager] call callUpdateRichtextStyle arguments is null");
        }
        WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callUpdateRichtextStyle", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
        return 0;
    }

    public int callUpdateStyle(String str, String str2, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2, HashMap<String, String> hashMap3, HashMap<String, String> hashMap4) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            WXEnvironment.isApkDebugable();
            HashSet<String> hashSet = this.mDestroyedInstanceId;
            if (hashSet == null || !hashSet.contains(str)) {
                try {
                    WXSDKInstance y = WXSDKManager.v().y(str);
                    if (y != null) {
                        GraphicActionUpdateStyle graphicActionUpdateStyle = new GraphicActionUpdateStyle(y, str2, hashMap, hashMap2, hashMap3, hashMap4);
                        WXSDKManager.v().G().postGraphicAction(graphicActionUpdateStyle.getPageId(), graphicActionUpdateStyle);
                        return 1;
                    }
                    return 1;
                } catch (Exception e) {
                    WXLogUtils.e("[WXBridgeManager] callUpdateStyle exception: ", e);
                    WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callUpdateStyle", WXLogUtils.getStackTrace(e), null);
                    return 1;
                }
            }
            return -1;
        }
        if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.d("[WXBridgeManager] call callUpdateStyle arguments is null");
        }
        WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callUpdateStyle", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
        return 0;
    }

    @Deprecated
    public void callback(String str, String str2, String str3) {
        callback(str, str2, str3, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void callbackJavascript(String str, final String str2, final Object obj, boolean z) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.mJSHandler == null) {
            return;
        }
        final WXSDKInstance wXSDKInstance = WXSDKManager.v().i().get(str);
        if (wXSDKInstance != null && wXSDKInstance.isUsingEaglePlugin()) {
            int isSupportJSCallback = wXSDKInstance.getEaglePlugin().isSupportJSCallback(str);
            if (isSupportJSCallback == 0) {
                return;
            }
            callbackJavascriptOnDataRender(wXSDKInstance.getEaglePlugin(), str, str2, obj, z);
            if (isSupportJSCallback == 1) {
                return;
            }
        } else if (wXSDKInstance != null && wXSDKInstance.getReactorPage() != null) {
            if (getInstance().getJSLooper() == Looper.myLooper()) {
                wXSDKInstance.getReactorPage().invokeCallBack(str2, JSON.toJSONString(obj));
            } else {
                getInstance().post(new Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.15
                    @Override // java.lang.Runnable
                    public void run() {
                        wXSDKInstance.getReactorPage().invokeCallBack(str2, JSON.toJSONString(obj));
                    }
                });
            }
        }
        addJSTask(METHOD_CALLBACK, str, str2, obj, Boolean.valueOf(z));
        sendMessage(str, 6);
    }

    void callbackJavascriptOnDataRender(final WXEaglePlugin wXEaglePlugin, final String str, final String str2, final Object obj, final boolean z) {
        this.mJSHandler.postDelayed(WXThread.secure(new Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.16
            @Override // java.lang.Runnable
            public void run() {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    String jSONString = JSON.toJSONString(obj);
                    if (WXEnvironment.isApkDebugable()) {
                        WXLogUtils.d("callbackJavascriptOnDataRender >>>> instanceId:" + str + ", data:" + jSONString);
                    }
                    wXEaglePlugin.invokeJSCallback(str, str2, jSONString, z);
                    WXLogUtils.renderPerformanceLog("callbackJavascriptOnDataRender", System.currentTimeMillis() - currentTimeMillis);
                } catch (Throwable th) {
                    String str3 = "[WXBridgeManager] callbackJavascriptOnDataRender " + WXLogUtils.getStackTrace(th);
                    WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callbackJavascriptOnDataRender", str3, null);
                    WXLogUtils.e(str3);
                }
            }
        }), 0L);
    }

    public void checkJsEngineMultiThread() {
        IWXJscProcessManager F = WXSDKManager.v().F();
        boolean enableBackupThread = F != null ? F.enableBackupThread() : false;
        if (enableBackupThread == isJsEngineMultiThreadEnable) {
            return;
        }
        isJsEngineMultiThreadEnable = enableBackupThread;
        if (isJSFrameworkInit()) {
            if (isJSThread()) {
                WXSDKEngine.reload();
            } else {
                post(new Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.2
                    @Override // java.lang.Runnable
                    public void run() {
                        WXSDKEngine.reload();
                    }
                });
            }
        }
    }

    public void commitJscCrashAlarmMonitor(String str, WXErrorCode wXErrorCode, String str2, String str3, String str4, Map<String, String> map) {
        if (TextUtils.isEmpty(str) || wXErrorCode == null) {
            return;
        }
        Log.d("ReportCrash", " commitJscCrashAlarmMonitor errMsg " + str2);
        HashMap hashMap = new HashMap();
        hashMap.put("jscCrashStack", str2);
        if (map != null) {
            hashMap.putAll(map);
        }
        IWXJSExceptionAdapter p = WXSDKManager.v().p();
        if (p != null) {
            WXJSExceptionInfo wXJSExceptionInfo = new WXJSExceptionInfo(str3, str4, wXErrorCode, "callReportCrash", "weex core process crash and restart exception", hashMap);
            p.onJSException(wXJSExceptionInfo);
            WXLogUtils.e(wXJSExceptionInfo.toString());
        }
    }

    public void createInstance(String str, String str2, Map<String, Object> map, String str3) {
        createInstance(str, new r62(str2), map, str3);
    }

    public void destroy() {
        WXThread wXThread = this.mJSThread;
        if (wXThread != null) {
            wXThread.quit();
        }
        mBridgeManager = null;
        HashSet<String> hashSet = this.mDestroyedInstanceId;
        if (hashSet != null) {
            hashSet.clear();
        }
    }

    public void destroyInstance(final String str) {
        if (this.mJSHandler == null || TextUtils.isEmpty(str)) {
            return;
        }
        HashSet<String> hashSet = this.mDestroyedInstanceId;
        if (hashSet != null) {
            hashSet.add(str);
        }
        this.mJSHandler.removeCallbacksAndMessages(str);
        post(new Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.22
            @Override // java.lang.Runnable
            public void run() {
                WXBridgeManager.this.removeTaskByInstance(str);
                WXBridgeManager.this.invokeDestroyInstance(str);
            }
        }, str, null, METHOD_DESTROY_INSTANCE);
    }

    public String dumpIpcPageInfo() {
        IWXBridge iWXBridge = this.mWXBridge;
        return iWXBridge instanceof WXBridge ? ((WXBridge) iWXBridge).nativeDumpIpcPageQueueInfo() : "";
    }

    public void execJSService(final String str) {
        postWithName(new Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.29
            @Override // java.lang.Runnable
            public void run() {
                WXBridgeManager wXBridgeManager = WXBridgeManager.this;
                wXBridgeManager.invokeExecJSService(str, wXBridgeManager.mRegisterServiceFailList);
            }
        }, null, "execJSService");
    }

    @Deprecated
    public void fireEvent(String str, String str2, String str3, Map<String, Object> map) {
        fireEvent(str, str2, str3, map, null);
    }

    public void fireEventOnNode(String str, String str2, String str3, Map<String, Object> map, Map<String, Object> map2) {
        fireEventOnNode(str, str2, str3, map, map2, null, null);
    }

    @UiThread
    public void forceLayout(String str) {
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            this.mWXBridge.forceLayout(str);
        }
    }

    public BundType getBundleType(String str, String str2) {
        if (str != null) {
            try {
                String queryParameter = Uri.parse(str).getQueryParameter(BUNDLE_TYPE);
                if (!"Vue".equals(queryParameter) && !"vue".equals(queryParameter)) {
                    if ("Rax".equals(queryParameter) || "rax".equals(queryParameter)) {
                        return BundType.Rax;
                    }
                }
                return BundType.Vue;
            } catch (Throwable th) {
                WXLogUtils.e(WXLogUtils.getStackTrace(th));
                return BundType.Others;
            }
        }
        if (str2 != null) {
            int indexOf = str2.indexOf(WVUtils.URL_SEPARATOR);
            String string = JSON.parseObject(str2.substring(indexOf + 2, str2.indexOf(StringUtils.LF, indexOf))).getString("framework");
            if ("vue".equalsIgnoreCase(string)) {
                return BundType.Vue;
            }
            if ("rax".equalsIgnoreCase(string)) {
                return BundType.Rax;
            }
            if (Pattern.compile("(use)(\\s+)(weex:vue)", 2).matcher(str2).find()) {
                return BundType.Vue;
            }
            if (Pattern.compile("(use)(\\s+)(weex:rax)", 2).matcher(str2).find()) {
                return BundType.Rax;
            }
        }
        return BundType.Others;
    }

    public long[] getFirstScreenRenderTime(String str) {
        return isJSFrameworkInit() ? this.mWXBridge.getFirstScreenRenderTime(str) : new long[]{0, 0, 0};
    }

    public WXParams getInitParams() {
        return this.mInitParams;
    }

    @Nullable
    public Looper getJSLooper() {
        WXThread wXThread = this.mJSThread;
        if (wXThread != null) {
            return wXThread.getLooper();
        }
        return null;
    }

    public ContentBoxMeasurement getMeasurementFunc(String str, long j) {
        WXSDKInstance y = WXSDKManager.v().y(str);
        if (y != null) {
            return y.getContentBoxMeasurement(j);
        }
        return null;
    }

    public long[] getRenderFinishTime(String str) {
        return isJSFrameworkInit() ? this.mWXBridge.getRenderFinishTime(str) : new long[]{0, 0, 0};
    }

    public String getWeexCoreThreadStackTrace() {
        if (this.mJSThread == null) {
            return "null == mJSThread";
        }
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(String.format("Thread Name: '%s'\n", this.mJSThread.getName()));
            sb.append(String.format(Locale.ENGLISH, "\"%s\" prio=%d tid=%d %s\n", this.mJSThread.getName(), Integer.valueOf(this.mJSThread.getPriority()), Long.valueOf(this.mJSThread.getId()), this.mJSThread.getState()));
            StackTraceElement[] stackTrace = this.mJSThread.getStackTrace();
            int length = stackTrace.length;
            for (int i = 0; i < length; i++) {
                sb.append(String.format("\tat %s\n", stackTrace[i].toString()));
            }
        } catch (Exception e) {
            Log.e("weex", "getJSThreadStackTrace error:", e);
        }
        return sb.toString();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message == null) {
            return false;
        }
        int i = message.what;
        if (i == 1) {
            TimerInfo timerInfo = (TimerInfo) message.obj;
            if (timerInfo != null) {
                invokeExecJS("", null, METHOD_SET_TIMEOUT, new WXJSObject[]{new WXJSObject(2, timerInfo.callbackId)});
            }
        } else if (i == 13) {
            Object obj = message.obj;
            if (obj != null) {
                this.mWXBridge.takeHeapSnapshot((String) obj);
            }
        } else if (i == 6) {
            invokeCallJSBatch(message);
        } else if (i == 7) {
            invokeInitFramework(message);
        }
        return false;
    }

    public synchronized void initScriptsFramework(String str) {
        Message obtainMessage = this.mJSHandler.obtainMessage();
        obtainMessage.obj = str;
        obtainMessage.what = 7;
        obtainMessage.setTarget(this.mJSHandler);
        obtainMessage.sendToTarget();
    }

    public int invokeCreateInstanceContext(String str, String str2, String str3, WXJSObject[] wXJSObjectArr, boolean z) {
        WXLogUtils.d("invokeCreateInstanceContext instanceId:" + str + " function:" + str3 + String.format(" isJSFrameworkInit：%b", Boolean.valueOf(isJSFrameworkInit())));
        StringBuilder sb = this.mLodBuilder;
        sb.append("createInstanceContext >>>> instanceId:");
        sb.append(str);
        sb.append("function:");
        sb.append(str3);
        if (z) {
            StringBuilder sb2 = this.mLodBuilder;
            sb2.append(" tasks:");
            sb2.append(WXJsonUtils.fromObjectToJSONString(wXJSObjectArr));
        }
        WXLogUtils.d(this.mLodBuilder.substring(0));
        this.mLodBuilder.setLength(0);
        return this.mWXBridge.createInstanceContext(str, str2, str3, wXJSObjectArr);
    }

    public void invokeDestoryInstance(String str, String str2, String str3, WXJSObject[] wXJSObjectArr, boolean z) {
        StringBuilder sb = this.mLodBuilder;
        sb.append("callJS >>>> instanceId:");
        sb.append(str);
        sb.append("function:");
        sb.append(str3);
        if (z) {
            StringBuilder sb2 = this.mLodBuilder;
            sb2.append(" tasks:");
            sb2.append(WXJsonUtils.fromObjectToJSONString(wXJSObjectArr));
        }
        WXLogUtils.d(this.mLodBuilder.substring(0));
        this.mLodBuilder.setLength(0);
        this.mWXBridge.removeInstanceRenderType(str);
        this.mWXBridge.destoryInstance(str, str2, str3, wXJSObjectArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean isJSFrameworkInit() {
        return mInit;
    }

    public boolean isJSThread() {
        WXThread wXThread = this.mJSThread;
        return wXThread != null && wXThread.getId() == Thread.currentThread().getId();
    }

    public boolean isRebootExceedLimit() {
        return reInitCount > 50;
    }

    public boolean jsEngineMultiThreadEnable() {
        return isJsEngineMultiThreadEnable;
    }

    public void loadJsBundleInPreInitMode(final String str, final String str2) {
        post(new Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.8
            @Override // java.lang.Runnable
            public void run() {
                WXBridgeManager.this.invokeExecJSOnInstance(str, str2, -1);
                WXSDKInstance wXSDKInstance = WXSDKManager.v().i().get(str);
                if (wXSDKInstance == null || !wXSDKInstance.isPreInitMode()) {
                    return;
                }
                wXSDKInstance.getApmForInstance().r(WXInstanceApm.KEY_PAGE_STAGES_LOAD_BUNDLE_END);
                wXSDKInstance.getApmForInstance().s(WXInstanceApm.KEY_PAGE_STAGES_END_EXCUTE_BUNDLE, WXUtils.getFixUnixTime() + 600);
            }
        });
    }

    public void markDirty(String str, String str2, boolean z) {
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            this.mWXBridge.markDirty(str, str2, z);
        }
    }

    @UiThread
    public boolean notifyLayout(String str) {
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            return this.mWXBridge.notifyLayout(str);
        }
        return false;
    }

    public void notifySerializeCodeCache() {
        post(new Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.31
            @Override // java.lang.Runnable
            public void run() {
                if (WXBridgeManager.this.isJSFrameworkInit()) {
                    WXBridgeManager.this.invokeExecJS("", null, WXBridgeManager.METHOD_NOTIFY_SERIALIZE_CODE_CACHE, new WXJSObject[0]);
                }
            }
        });
    }

    @Deprecated
    public void notifyTrimMemory() {
    }

    public void onInstanceClose(String str) {
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            this.mWXBridge.onInstanceClose(str);
        }
    }

    public void onInteractionTimeUpdate(final String str) {
        post(new Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.1
            @Override // java.lang.Runnable
            public void run() {
                if (WXBridgeManager.this.mWXBridge instanceof WXBridge) {
                    ((WXBridge) WXBridgeManager.this.mWXBridge).nativeOnInteractionTimeUpdate(str);
                }
            }
        });
    }

    public WXJSObject optionObjConvert(boolean z, BundType bundType, WXJSObject wXJSObject) {
        JSONObject jSONObject;
        if (z) {
            try {
                JSONObject parseObject = JSON.parseObject(wXJSObject.data.toString());
                JSONObject jSONObject2 = parseObject.getJSONObject("env");
                if (jSONObject2 != null && (jSONObject = jSONObject2.getJSONObject(OPTIONS)) != null) {
                    for (String str : jSONObject.keySet()) {
                        jSONObject2.put(str, (Object) jSONObject.getString(str));
                    }
                }
                return new WXJSObject(3, parseObject.toString());
            } catch (Throwable th) {
                WXLogUtils.e(WXLogUtils.getStackTrace(th));
                return wXJSObject;
            }
        }
        return wXJSObject;
    }

    @Override // com.taobao.weex.utils.batch.BactchExecutor
    public void post(Runnable runnable) {
        postWithName(runnable, null, null);
    }

    public void postDelay(Runnable runnable, long j) {
        Handler handler = this.mJSHandler;
        if (handler == null) {
            return;
        }
        handler.postDelayed(WXThread.secure(runnable), j);
    }

    public void postWithName(Runnable runnable, WXSDKInstance wXSDKInstance, String str) {
        Handler handler;
        Runnable secure = WXThread.secure(runnable, wXSDKInstance, str);
        Interceptor interceptor = this.mInterceptor;
        if ((interceptor == null || !interceptor.take(secure)) && (handler = this.mJSHandler) != null) {
            handler.post(secure);
        }
    }

    public void refreshInstance(final String str, final WXRefreshData wXRefreshData) {
        if (TextUtils.isEmpty(str) || wXRefreshData == null) {
            return;
        }
        this.mJSHandler.postDelayed(WXThread.secure(new Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.17
            @Override // java.lang.Runnable
            public void run() {
                WXBridgeManager.this.invokeRefreshInstance(str, wXRefreshData);
            }
        }), 0L);
    }

    public void registerComponents(final List<Map<String, Object>> list) {
        if (this.mJSHandler == null || list == null || list.size() == 0) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.28
            @Override // java.lang.Runnable
            public void run() {
                WXBridgeManager wXBridgeManager = WXBridgeManager.this;
                wXBridgeManager.invokeRegisterComponents(list, wXBridgeManager.mRegisterComponentFailList);
            }
        };
        if (isJSThread() && isJSFrameworkInit()) {
            runnable.run();
        } else {
            post(runnable);
        }
    }

    public void registerCoreEnv(String str, String str2) {
        if (isJSFrameworkInit()) {
            this.mWXBridge.registerCoreEnv(str, str2);
        } else {
            mWeexCoreEnvOptions.put(str, str2);
        }
    }

    public void registerModules(final Map<String, Object> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        if (isJSThread()) {
            invokeRegisterModules(map, this.mRegisterModuleFailList);
        } else {
            post(new Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.27
                @Override // java.lang.Runnable
                public void run() {
                    WXBridgeManager wXBridgeManager = WXBridgeManager.this;
                    wXBridgeManager.invokeRegisterModules(map, wXBridgeManager.mRegisterModuleFailList);
                }
            });
        }
    }

    public void reloadPageLayout(String str) {
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            this.mWXBridge.reloadPageLayout(str);
        }
    }

    public void removeMessage(int i, Object obj) {
        WXThread wXThread;
        if (this.mJSHandler == null || (wXThread = this.mJSThread) == null || !wXThread.isWXThreadAlive() || this.mJSThread.getLooper() == null) {
            return;
        }
        this.mJSHandler.removeMessages(i, obj);
    }

    public void reportJSException(String str, String str2, String str3) {
        WXSDKInstance y;
        WXLogUtils.e("reportJSException >>>> instanceId:" + str + ", exception function:" + str2 + ", exception:" + str3);
        WXErrorCode wXErrorCode = WXErrorCode.WX_ERR_JS_EXECUTE;
        if (str != null && (y = WXSDKManager.v().y(str)) != null) {
            y.setHasException(true);
            str3 = str3 + "\n getTemplateInfo==" + y.getTemplateInfo();
            if (METHOD_CREATE_INSTANCE.equals(str2) || !y.isContentMd5Match()) {
                try {
                    if (!isSkipFrameworkInit(str) && isJSFrameworkInit() && reInitCount > 1 && reInitCount < 10 && !y.isNeedReLoad()) {
                        new ActionReloadPage(str, true).executeAction();
                        y.setNeedLoad(true);
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    WXErrorCode wXErrorCode2 = WXErrorCode.WX_DEGRAD_ERR_INSTANCE_CREATE_FAILED;
                    sb.append(wXErrorCode2.getErrorMsg());
                    sb.append(", exception function:");
                    sb.append(str2);
                    sb.append(", exception:");
                    sb.append(str3);
                    sb.append(", extInitTime:");
                    sb.append(System.currentTimeMillis() - sInitFrameWorkTimeOrigin);
                    sb.append("ms");
                    sb.append(", extInitErrorMsg:");
                    sb.append(sInitFrameWorkMsg.toString());
                    y.onRenderError(wXErrorCode2.getErrorCode(), sb.toString());
                    if (WXEnvironment.sInAliWeex) {
                        return;
                    }
                    WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_JS_CREATE_INSTANCE, str2, str3, null);
                    return;
                } catch (Exception e) {
                    WXLogUtils.e(WXLogUtils.getStackTrace(e));
                }
            }
            if (METHOD_CREATE_INSTANCE.equals(str2) && !y.getApmForInstance().o) {
                wXErrorCode = WXErrorCode.WX_RENDER_ERR_JS_CREATE_INSTANCE;
            } else if (METHOD_CREATE_INSTANCE_CONTEXT.equals(str2) && !y.getApmForInstance().o) {
                wXErrorCode = WXErrorCode.WX_RENDER_ERR_JS_CREATE_INSTANCE_CONTEXT;
            } else if ((METHOD_UPDATE_COMPONENT_WITH_DATA.equals(str2) || METHOD_CREATE_PAGE_WITH_CONTENT.equals(str2) || METHOD_POST_TASK_TO_MSG_LOOP.equals(str2) || METHOD_JSFM_NOT_INIT_IN_EAGLE_MODE.equals(str2)) && !y.getApmForInstance().o) {
                wXErrorCode = WXErrorCode.WX_DEGRAD_EAGLE_RENDER_ERROR;
            }
            y.onJSException(wXErrorCode.getErrorCode(), str2, str3);
        }
        doReportJSException(str, str2, wXErrorCode, str3);
    }

    public void restart() {
        setJSFrameworkInit(false);
        WXModuleManager.resetAllModuleState();
        initWXBridge(WXEnvironment.sRemoteDebugMode);
        this.mWXBridge.resetWXBridge(WXEnvironment.sRemoteDebugMode);
    }

    public void sendMessageDelayed(Message message, long j) {
        WXThread wXThread;
        if (message == null || this.mJSHandler == null || (wXThread = this.mJSThread) == null || !wXThread.isWXThreadAlive() || this.mJSThread.getLooper() == null) {
            return;
        }
        this.mJSHandler.sendMessageDelayed(message, j);
    }

    public void setDefaultRootSize(String str, float f, float f2, boolean z, boolean z2) {
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            this.mWXBridge.setDefaultHeightAndWidthIntoRootDom(str, f, f2, z, z2);
        }
    }

    public void setDeviceDisplay(final String str, final float f, final float f2, final float f3) {
        post(new Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.32
            @Override // java.lang.Runnable
            public void run() {
                WXBridgeManager.this.mWXBridge.setDeviceDisplay(str, f, f2, f3);
            }
        });
    }

    public void setDeviceDisplayOfPage(String str, float f, float f2) {
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            this.mWXBridge.setDeviceDisplayOfPage(str, f, f2);
        }
    }

    @Override // com.taobao.weex.utils.batch.BactchExecutor
    public void setInterceptor(Interceptor interceptor) {
        this.mInterceptor = interceptor;
    }

    public void setLogLevel(final int i, final boolean z) {
        post(new Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.18
            @Override // java.lang.Runnable
            public void run() {
                if (WXBridgeManager.this.mWXBridge != null) {
                    WXBridgeManager.this.mWXBridge.setLogType(i, z);
                }
            }
        });
    }

    public void setMargin(String str, String str2, CSSShorthand.EDGE edge, float f) {
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            this.mWXBridge.setMargin(str, str2, edge, f);
        }
    }

    public void setPadding(String str, String str2, CSSShorthand.EDGE edge, float f) {
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            this.mWXBridge.setPadding(str, str2, edge, f);
        }
    }

    public void setPageArgument(String str, String str2, String str3) {
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            this.mWXBridge.setPageArgument(str, str2, str3);
        }
    }

    public void setPosition(String str, String str2, CSSShorthand.EDGE edge, float f) {
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            this.mWXBridge.setPosition(str, str2, edge, f);
        }
    }

    public void setRenderContentWrapContentToCore(boolean z, String str) {
        if (isJSFrameworkInit()) {
            this.mWXBridge.setRenderContainerWrapContent(z, str);
        }
    }

    public void setSandBoxContext(boolean z) {
        String loadAsset;
        if (z != isSandBoxContext) {
            isSandBoxContext = z;
            if (isJSThread()) {
                setJSFrameworkInit(false);
                WXModuleManager.resetAllModuleState();
                if (!isSandBoxContext) {
                    loadAsset = WXFileUtils.loadAsset("main.js", WXEnvironment.getApplication());
                } else {
                    loadAsset = WXFileUtils.loadAsset("weex-main-jsfm.js", WXEnvironment.getApplication());
                }
                initFramework(loadAsset);
                WXServiceManager.reload();
                WXModuleManager.reload();
                WXComponentRegistry.reload();
                return;
            }
            post(new Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.3
                @Override // java.lang.Runnable
                public void run() {
                    String loadAsset2;
                    WXBridgeManager.this.setJSFrameworkInit(false);
                    WXModuleManager.resetAllModuleState();
                    if (!WXBridgeManager.isSandBoxContext) {
                        loadAsset2 = WXFileUtils.loadAsset("main.js", WXEnvironment.getApplication());
                    } else {
                        loadAsset2 = WXFileUtils.loadAsset("weex-main-jsfm.js", WXEnvironment.getApplication());
                    }
                    WXBridgeManager.this.initFramework(loadAsset2);
                    WXServiceManager.reload();
                    WXModuleManager.reload();
                    WXComponentRegistry.reload();
                }
            });
        }
    }

    public synchronized void setStackTopInstance(final String str) {
        post(new Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.5
            @Override // java.lang.Runnable
            public void run() {
                WXBridgeManager.this.mNextTickTasks.setStackTopInstance(str);
            }
        }, str, null, null);
    }

    public void setStyleHeight(String str, String str2, float f) {
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            this.mWXBridge.setStyleHeight(str, str2, f);
        }
    }

    public void setStyleWidth(String str, String str2, float f) {
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            this.mWXBridge.setStyleWidth(str, str2, f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTimeout(String str, String str2) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        TimerInfo timerInfo = new TimerInfo();
        timerInfo.callbackId = str;
        long parseFloat = Float.parseFloat(str2);
        timerInfo.time = parseFloat;
        obtain.obj = timerInfo;
        this.mJSHandler.sendMessageDelayed(obtain, parseFloat);
    }

    public void setUseSingleProcess(boolean z) {
        if (z != isUseSingleProcess) {
            isUseSingleProcess = z;
        }
    }

    public void setViewPortWidth(String str, float f) {
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            this.mWXBridge.setViewPortWidth(str, f);
        }
    }

    public boolean shouldReloadCurrentInstance(String str) {
        Uri parse;
        long currentTimeMillis = System.currentTimeMillis();
        IWXConfigAdapter J = WXSDKManager.v().J();
        if (J != null) {
            boolean parseBoolean = Boolean.parseBoolean(J.getConfig("android_weex_ext_config", "check_biz_url", "true"));
            WXLogUtils.e("check_biz_url : " + parseBoolean);
            if (parseBoolean && !TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null) {
                str = parse.buildUpon().clearQuery().build().toString();
            }
        }
        String str2 = crashUrl;
        if (str2 != null && ((str2 == null || str2.equals(str)) && currentTimeMillis - lastCrashTime <= 15000)) {
            lastCrashTime = currentTimeMillis;
            return false;
        }
        crashUrl = str;
        lastCrashTime = currentTimeMillis;
        return true;
    }

    public void stopRemoteDebug() {
        Method method;
        if (this.mWxDebugProxy != null) {
            try {
                if (clazz_debugProxy == null) {
                    clazz_debugProxy = DebugServerProxy.class;
                }
                Class cls = clazz_debugProxy;
                if (cls == null || (method = cls.getMethod("stop", Boolean.TYPE)) == null) {
                    return;
                }
                method.invoke(this.mWxDebugProxy, Boolean.TRUE);
            } catch (Throwable unused) {
            }
        }
    }

    public EventResult syncCallJSEventWithResult(String str, String str2, List<Object> list, Object... objArr) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        EventResult eventResult = new EventResult() { // from class: com.taobao.weex.bridge.WXBridgeManager.9
            @Override // com.taobao.weex.bridge.EventResult
            public void onCallback(Object obj) {
                super.onCallback(obj);
                countDownLatch.countDown();
            }
        };
        try {
            asyncCallJSEventWithResult(eventResult, str, str2, list, objArr);
            countDownLatch.await(100L, TimeUnit.MILLISECONDS);
            return eventResult;
        } catch (Exception e) {
            WXLogUtils.e("syncCallJSEventWithResult", e);
            return eventResult;
        }
    }

    public String syncExecJsOnInstanceWithResult(String str, String str2, int i) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        EventResult eventResult = new EventResult() { // from class: com.taobao.weex.bridge.WXBridgeManager.7
            @Override // com.taobao.weex.bridge.EventResult
            public void onCallback(Object obj) {
                super.onCallback(obj);
                countDownLatch.countDown();
            }
        };
        try {
            execJSOnInstance(eventResult, str, str2, i);
            countDownLatch.await(100L, TimeUnit.MILLISECONDS);
            return eventResult.getResult() != null ? eventResult.getResult().toString() : "";
        } catch (Throwable th) {
            WXLogUtils.e("syncCallExecJsOnInstance", th);
            return "";
        }
    }

    public void takeJSHeapSnapshot(String str) {
        Message obtainMessage = this.mJSHandler.obtainMessage();
        obtainMessage.obj = str;
        obtainMessage.what = 13;
        obtainMessage.setTarget(this.mJSHandler);
        obtainMessage.sendToTarget();
    }

    public void updateInitDeviceParams(final String str, final String str2, final String str3, final String str4) {
        if (isJSFrameworkInit()) {
            post(new Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.33
                @Override // java.lang.Runnable
                public void run() {
                    WXBridgeManager.this.mWXBridge.updateInitFrameworkParams("deviceWidth", str, "deviceWidth");
                }
            });
            post(new Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.34
                @Override // java.lang.Runnable
                public void run() {
                    WXBridgeManager.this.mWXBridge.updateInitFrameworkParams("deviceHeight", str2, "deviceHeight");
                }
            });
            post(new Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.35
                @Override // java.lang.Runnable
                public void run() {
                    WXBridgeManager.this.mWXBridge.updateInitFrameworkParams("scale", str3, "scale");
                }
            });
            if (str4 != null) {
                post(new Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.36
                    @Override // java.lang.Runnable
                    public void run() {
                        WXBridgeManager.this.mWXBridge.updateInitFrameworkParams(WXConfig.androidStatusBarHeight, str4, WXConfig.androidStatusBarHeight);
                    }
                });
            }
        }
    }

    public Object callModuleMethod(String str, String str2, String str3, JSONArray jSONArray, JSONObject jSONObject) {
        WXSDKInstance y = WXSDKManager.v().y(str);
        if (y == null) {
            return null;
        }
        if (y.hasModuleIntercept(str2)) {
            y.moduleIntercept(str2, str3, jSONArray, jSONObject);
        }
        if (y.isNeedValidate() && WXSDKManager.v().B() != null) {
            WXValidateProcessor.WXModuleValidateResult onModuleValidate = WXSDKManager.v().B().onModuleValidate(y, str2, str3, jSONArray, jSONObject);
            if (onModuleValidate == null) {
                return null;
            }
            if (onModuleValidate.isSuccess) {
                return WXModuleManager.callModuleMethod(str, str2, str3, jSONArray);
            }
            JSONObject jSONObject2 = onModuleValidate.validateInfo;
            if (jSONObject2 != null) {
                WXLogUtils.e("[WXBridgeManager] module validate fail. >>> " + jSONObject2.toJSONString());
            }
            return jSONObject2;
        }
        try {
            return WXModuleManager.callModuleMethod(str, str2, str3, jSONArray);
        } catch (NumberFormatException unused) {
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put("moduleName", str2);
            arrayMap.put("methodName", str3);
            arrayMap.put("args", jSONArray.toJSONString());
            WXLogUtils.e("[WXBridgeManager] callNative : numberFormatException when parsing string to numbers in args", arrayMap.toString());
            return null;
        }
    }

    @Deprecated
    public void callback(String str, String str2, Map<String, Object> map) {
        callback(str, str2, map, false);
    }

    public void createInstance(final String str, final r62 r62Var, final Map<String, Object> map, final String str2) {
        final WXSDKInstance y = WXSDKManager.v().y(str);
        if (y == null) {
            WXLogUtils.e("WXBridgeManager", "createInstance failed, SDKInstance does not exist");
            return;
        }
        if (!TextUtils.isEmpty(str) && r62Var != null && !r62Var.c() && this.mJSHandler != null) {
            if (!isSkipFrameworkInit(str) && !isJSFrameworkInit() && reInitCount == 1 && !WXEnvironment.sDebugServerConnectable) {
                WXErrorCode wXErrorCode = WXErrorCode.WX_DEGRAD_ERR_INSTANCE_CREATE_FAILED;
                String errorCode = wXErrorCode.getErrorCode();
                y.onRenderError(errorCode, wXErrorCode.getErrorMsg() + " isJSFrameworkInit==" + isJSFrameworkInit() + " reInitCount == 1");
                y.getApmForInstance().r("createInstance failed jsfm isn't init return;");
                post(new Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.19
                    @Override // java.lang.Runnable
                    public void run() {
                        WXBridgeManager.this.initFramework("");
                    }
                }, str, y, "initFrameworkInCreateInstance");
                return;
            }
            WXModuleManager.createDomModule(y);
            y.getApmForInstance().r(WXInstanceApm.KEY_PAGE_STAGES_LOAD_BUNDLE_START);
            post(new Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.20
                @Override // java.lang.Runnable
                public void run() {
                    y.getApmForInstance().r("wxLoadBundleStartOnJsThread");
                    long currentTimeMillis = System.currentTimeMillis();
                    WXBridgeManager.this.mWXBridge.setPageArgument(str, "renderTimeOrigin", String.valueOf(y.getWXPerformance().renderTimeOrigin));
                    WXBridgeManager.this.mWXBridge.setInstanceRenderType(y.getInstanceId(), y.getRenderType());
                    WXBridgeManager.this.invokeCreateInstance(y, r62Var, map, str2);
                    y.getWXPerformance().callCreateInstanceTime = System.currentTimeMillis() - currentTimeMillis;
                    y.getWXPerformance().communicateTime = y.getWXPerformance().callCreateInstanceTime;
                }
            }, str, y, METHOD_CREATE_INSTANCE);
            return;
        }
        WXErrorCode wXErrorCode2 = WXErrorCode.WX_DEGRAD_ERR_INSTANCE_CREATE_FAILED;
        String errorCode2 = wXErrorCode2.getErrorCode();
        y.onRenderError(errorCode2, wXErrorCode2.getErrorMsg() + " instanceId==" + str + " template ==" + r62Var + " mJSHandler== " + this.mJSHandler.toString());
        WXInstanceApm apmForInstance = y.getApmForInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("createInstance failed return; ");
        sb.append(TextUtils.isEmpty(str));
        sb.append(",");
        sb.append(r62Var.c());
        sb.append(",");
        sb.append(this.mJSHandler == null);
        apmForInstance.r(sb.toString());
    }

    @Deprecated
    public void fireEvent(String str, String str2, String str3, Map<String, Object> map, Map<String, Object> map2) {
        fireEventOnNode(str, str2, str3, map, map2);
    }

    public void fireEventOnNode(String str, String str2, String str3, Map<String, Object> map, Map<String, Object> map2, List<Object> list) {
        fireEventOnNode(str, str2, str3, map, map2, list, null);
    }

    public void invokeExecJS(final String str, final String str2, final String str3, final WXJSObject[] wXJSObjectArr, boolean z) {
        WXEnvironment.isOpenDebugLog();
        long currentTimeMillis = System.currentTimeMillis();
        WXSDKInstance y = WXSDKManager.v().y(str);
        if (y != null && y.isUsingEaglePlugin()) {
            final WXEaglePlugin eaglePlugin = y.getEaglePlugin();
            int isSupportInvokeExecJS = eaglePlugin.isSupportInvokeExecJS(str);
            if (isSupportInvokeExecJS == 0) {
                return;
            }
            WXThread.secure(new Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.23
                @Override // java.lang.Runnable
                public void run() {
                    eaglePlugin.invokeExecJS(str, str2, str3, wXJSObjectArr);
                }
            }, y, "ExecJsEagle").run();
            if (isSupportInvokeExecJS == 1) {
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                y.getApmForInstance().C(WXInstanceApm.KEY_PAGE_STATS_FS_CALL_JS_NUM, 1.0d);
                y.getApmForInstance().C(WXInstanceApm.KEY_PAGE_STATS_FS_CALL_JS_TIME, currentTimeMillis2);
                y.callJsTime(currentTimeMillis2);
                return;
            }
        }
        WXThread.secure(new Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.24
            @Override // java.lang.Runnable
            public void run() {
                WXBridgeManager.this.mWXBridge.execJS(str, str2, str3, wXJSObjectArr);
            }
        }, y, "ExecJs").run();
        if (y != null) {
            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
            y.getApmForInstance().C(WXInstanceApm.KEY_PAGE_STATS_FS_CALL_JS_NUM, 1.0d);
            y.getApmForInstance().C(WXInstanceApm.KEY_PAGE_STATS_FS_CALL_JS_TIME, currentTimeMillis3);
            y.callJsTime(currentTimeMillis3);
        }
    }

    public void post(Runnable runnable, Object obj, WXSDKInstance wXSDKInstance, String str) {
        Handler handler = this.mJSHandler;
        if (handler == null) {
            return;
        }
        Message obtain = Message.obtain(handler, WXThread.secure(runnable, wXSDKInstance, str));
        obtain.obj = obj;
        obtain.sendToTarget();
    }

    private void getNextTick(String str) {
        addJSTask(METHOD_CALLBACK, str, "", "{}");
        sendMessage(str, 6);
    }

    private boolean isSkipFrameworkInit(WXSDKInstance wXSDKInstance) {
        if (wXSDKInstance == null) {
            return false;
        }
        return wXSDKInstance.skipFrameworkInit();
    }

    @Deprecated
    public void callback(String str, String str2, Object obj, boolean z) {
        callbackJavascript(str, str2, obj, z);
    }

    public void fireEventOnNode(String str, final String str2, final String str3, Map<String, Object> map, final Map<String, Object> map2, List<Object> list, EventResult eventResult) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || this.mJSHandler == null) {
            return;
        }
        if (checkMainThread()) {
            final WXSDKInstance wXSDKInstance = WXSDKManager.v().i().get(str);
            if (wXSDKInstance != null && wXSDKInstance.isUsingEaglePlugin()) {
                int isSupportFireEvent = wXSDKInstance.getEaglePlugin().isSupportFireEvent(str);
                if (isSupportFireEvent == 0) {
                    return;
                }
                fireEventOnDataRenderNode(wXSDKInstance.getEaglePlugin(), str, str2, str3, map, map2);
                if (isSupportFireEvent == 1) {
                    return;
                }
            } else if (wXSDKInstance != null && wXSDKInstance.getReactorPage() != null) {
                final HashMap hashMap = new HashMap();
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        hashMap.put(entry.getKey(), String.valueOf(entry.getValue()));
                    }
                }
                if (getInstance().getJSLooper() == Looper.myLooper()) {
                    wXSDKInstance.getReactorPage().fireEvent(str2, str3, hashMap, (map2 == null || map2.isEmpty()) ? "{}" : JSON.toJSONString(map2));
                    return;
                } else {
                    getInstance().post(new Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.13
                        @Override // java.lang.Runnable
                        public void run() {
                            WXReactorPage reactorPage = wXSDKInstance.getReactorPage();
                            String str4 = str2;
                            String str5 = str3;
                            HashMap hashMap2 = hashMap;
                            Map map3 = map2;
                            reactorPage.fireEvent(str4, str5, hashMap2, (map3 == null || map3.isEmpty()) ? "{}" : JSON.toJSONString(map2));
                        }
                    });
                    return;
                }
            }
            if (eventResult == null) {
                addJSEventTask(METHOD_FIRE_EVENT, str, list, str2, str3, map, map2);
                sendMessage(str, 6);
                return;
            }
            asyncCallJSEventWithResult(eventResult, METHD_FIRE_EVENT_SYNC, str, list, str2, str3, map, map2);
            return;
        }
        throw new WXRuntimeException("fireEvent must be called by main thread");
    }

    public void post(Runnable runnable, Object obj) {
        post(runnable, obj, null, null);
    }

    public Object callNativeModule(String str, String str2, String str3, JSONArray jSONArray, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            WXEnvironment.isApkDebugable();
            try {
            } catch (Exception e) {
                WXLogUtils.e("[WXBridgeManager] callNativeModule exception: " + WXLogUtils.getStackTrace(e));
            }
            if (WXDomModule.WXDOM.equals(str2)) {
                WXDomModule domModule = WXModuleManager.getDomModule(str);
                if (domModule != null) {
                    return domModule.callDomMethod(str3, jSONArray, new long[0]);
                }
                WXModuleManager.createDomModule(WXSDKManager.v().y(str));
                return null;
            }
            return callModuleMethod(str, str2, str3, jSONArray, jSONObject);
        }
        WXLogUtils.d("[WXBridgeManager] call callNativeModule arguments is null");
        WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callNativeModule", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
        return 0;
    }
}
