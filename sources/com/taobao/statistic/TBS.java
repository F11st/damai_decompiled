package com.taobao.statistic;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.alibaba.analytics.core.model.LogField;
import com.alibaba.analytics.utils.Logger;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.taobao.weex.annotation.JSMethod;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTConstants;
import com.ut.mini.UTHitBuilders;
import com.ut.mini.UTHybridHelper;
import com.ut.mini.UTPageHitHelper;
import com.ut.mini.UTTracker;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import com.ut.mini.internal.UTTeamWork;
import com.youku.vpm.track.OnePlayTrack;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import org.json.JSONException;
import org.json.JSONObject;
import tb.fd1;
import tb.yh2;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes11.dex */
public class TBS {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class Adv {
        public static void ctrlClicked(String str, CT ct, String str2, String... strArr) {
            Page._commitCtrlEvent(str, 2101, ct, str2, 0, strArr);
        }

        public static void ctrlClickedOnPage(String str, CT ct, String str2, String... strArr) {
            Page._commitCtrlEvent(str, 2101, ct, str2, 0, strArr);
        }

        public static void ctrlLongClicked(String str, CT ct, String str2, String... strArr) {
            Page._commitCtrlEvent(str, 2103, ct, str2, 0, strArr);
        }

        public static void ctrlLongClickedOnPage(String str, CT ct, String str2, String... strArr) {
            Page._commitCtrlEvent(str, 2103, ct, str2, 0, strArr);
        }

        @Deprecated
        public static void destroy(String str, String... strArr) {
        }

        @Deprecated
        public static void easyTraceEnter(String str, boolean z, String... strArr) {
        }

        @Deprecated
        public static void easyTraceInternalCtrlClick(String str, String str2, String... strArr) {
        }

        @Deprecated
        public static void easyTraceLeave(String str, boolean z, String... strArr) {
        }

        @Deprecated
        public static void enter(String str, String... strArr) {
        }

        @Deprecated
        public static void enterWithPageName(String str, String str2, String... strArr) {
        }

        @Deprecated
        public static String getUtsid() {
            return UTTeamWork.getInstance().getUtsid();
        }

        public static void itemSelected(String str, CT ct, String str2, int i, String... strArr) {
            Page._commitCtrlEvent(str, 2102, ct, str2, i, strArr);
        }

        public static void itemSelectedOnPage(String str, CT ct, String str2, int i, String... strArr) {
            Page._commitCtrlEvent(str, 2102, ct, str2, i, strArr);
        }

        @Deprecated
        public static void keepKvs(String str, String... strArr) {
        }

        @Deprecated
        public static void leave(String str, String... strArr) {
        }

        @Deprecated
        public static void onCaughException(Throwable th) {
        }

        @Deprecated
        public static void putKvs(String str, Object obj) {
        }

        @Deprecated
        public static void turnOffLogFriendly() {
        }

        @Deprecated
        public static void unKeepKvs(String str, String... strArr) {
        }

        @Deprecated
        void forceUpload() {
        }

        public static void ctrlClicked(CT ct, String str, String... strArr) {
            Page._commitCtrlEvent(null, 2101, ct, str, 0, strArr);
        }

        public static void ctrlClickedOnPage(String str, CT ct, String str2) {
            Page._commitCtrlEvent(str, 2101, ct, str2, 0, new String[0]);
        }

        public static void ctrlLongClicked(CT ct, String str, String... strArr) {
            Page._commitCtrlEvent(null, 2103, ct, str, 0, strArr);
        }

        public static void ctrlLongClickedOnPage(String str, CT ct, String str2) {
            Page._commitCtrlEvent(str, 2103, ct, str2, 0, new String[0]);
        }

        public static void itemSelected(CT ct, String str, int i, String... strArr) {
            Page._commitCtrlEvent(null, 2102, ct, str, i, strArr);
        }

        public static void itemSelectedOnPage(String str, CT ct, String str2, int i) {
            Page._commitCtrlEvent(str, 2103, ct, str2, i, new String[0]);
        }

        public static void ctrlClicked(String str, CT ct, String str2) {
            Page._commitCtrlEvent(str, 2101, ct, str2, 0, new String[0]);
        }

        public static void ctrlLongClicked(String str, CT ct, String str2) {
            Page._commitCtrlEvent(str, 2103, ct, str2, 0, new String[0]);
        }

        public static void itemSelected(String str, CT ct, String str2, int i) {
            Page._commitCtrlEvent(str, 2102, ct, str2, i, new String[0]);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class CrashHandler {

        /* compiled from: Taobao */
        /* loaded from: classes11.dex */
        public interface OnCrashCaughtListener {
            Arg OnCrashCaught(Thread thread, Throwable th, Arg arg);
        }

        /* compiled from: Taobao */
        /* loaded from: classes11.dex */
        public interface OnDaemonThreadCrashCaughtListener {
            void OnDaemonThreadCrashCaught(Thread thread);
        }

        @Deprecated
        public static void disableEffect() {
        }

        @Deprecated
        public static void removeDaemonCrashCaughtListener(String str) {
        }

        @Deprecated
        public static void setContinueWhenDaemonThreadUncaughException() {
        }

        @Deprecated
        public static void setOnCrashCaughtListener(OnCrashCaughtListener onCrashCaughtListener) {
        }

        @Deprecated
        public static void setOnDaemonCrashCaughtListener(OnDaemonThreadCrashCaughtListener onDaemonThreadCrashCaughtListener) {
        }

        @Deprecated
        public static void setOnDaemonCrashCaughtListener(String str, OnDaemonThreadCrashCaughtListener onDaemonThreadCrashCaughtListener) {
        }

        @Deprecated
        public static void setSubmitToSystemFlag() {
        }

        @Deprecated
        public static void setToastStyle(int i, String str) {
        }

        @Deprecated
        public static void turnOff() {
        }

        @Deprecated
        public static void withRestart(Activity activity, int i, int i2) {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class DelayEventObject {
        private long mTimestamp = 0;
        private Properties mProperties = null;
        private String mBeginOrEnd = OnePlayTrack.PlayType.BEGIN;

        public Properties getProperties() {
            return this.mProperties;
        }

        public long getTimestamp() {
            return this.mTimestamp;
        }

        public boolean isBegin() {
            return this.mBeginOrEnd.equals(OnePlayTrack.PlayType.BEGIN);
        }

        public void setBegin() {
            this.mBeginOrEnd = OnePlayTrack.PlayType.BEGIN;
        }

        public void setEnd() {
            this.mBeginOrEnd = "end";
        }

        public void setProperties(Properties properties) {
            this.mProperties = properties;
        }

        public void setTimestamp(long j) {
            this.mTimestamp = j;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class EasyTrace {
        @Deprecated
        public static void easyTraceCtrlClickManual(View view, String str, String... strArr) {
        }

        @Deprecated
        public static void easyTraceCtrlClickManual(View view, String... strArr) {
        }

        public static void easyTraceEnterManual(Activity activity, String str) {
            UTAnalytics.getInstance().getDefaultTracker().pageAppear(activity);
            UTAnalytics.getInstance().getDefaultTracker().updatePageName(activity, str);
        }

        @TargetApi(11)
        public static void easyTraceFragmentEnterManual(Fragment fragment) {
            UTAnalytics.getInstance().getDefaultTracker().pageAppear(fragment);
        }

        @TargetApi(11)
        public static void easyTraceFragmentLeaveManual(Fragment fragment) {
            UTAnalytics.getInstance().getDefaultTracker().pageDisAppear(fragment);
        }

        public static void easyTraceFragmentV4EnterManual(androidx.fragment.app.Fragment fragment) {
            UTAnalytics.getInstance().getDefaultTracker().pageAppear(fragment);
        }

        public static void easyTraceFragmentV4LeaveManual(androidx.fragment.app.Fragment fragment) {
            UTAnalytics.getInstance().getDefaultTracker().pageDisAppear(fragment);
        }

        public static void easyTraceLeaveManual(Activity activity, String str) {
            UTAnalytics.getInstance().getDefaultTracker().updatePageName(activity, str);
            UTAnalytics.getInstance().getDefaultTracker().pageDisAppear(activity);
        }

        public static void easyTraceUpdatePageNameManual(Activity activity, String str) {
            UTAnalytics.getInstance().getDefaultTracker().updatePageName(activity, str);
        }

        @Deprecated
        public static void easyTraceUpdatePageNameManual(String str, String str2) {
        }

        @Deprecated
        public static Runtime getUserTrackRuntime() {
            return null;
        }

        @Deprecated
        public static void updateEasyTraceActivityProperties(Activity activity, Properties properties) {
            if (UTAnalytics.getInstance().getDefaultTracker() != null) {
                UTAnalytics.getInstance().getDefaultTracker().updatePageProperties(activity, fd1.b(properties));
            }
        }

        @Deprecated
        public static void updateEasyTraceActivityPropertiesManual(Activity activity, String str, Properties properties) {
            UTAnalytics.getInstance().getDefaultTracker().updatePageProperties(activity, fd1.b(properties));
            UTAnalytics.getInstance().getDefaultTracker().updatePageName(activity, str);
        }

        @TargetApi(11)
        public static void updateEasyTraceFragmentProperties(Fragment fragment, Properties properties) {
            UTAnalytics.getInstance().getDefaultTracker().updatePageProperties(fragment, fd1.b(properties));
        }

        @Deprecated
        public static void updateEasyTraceFragmentV4Properties(androidx.fragment.app.Fragment fragment, Properties properties) {
            UTAnalytics.getInstance().getDefaultTracker().updatePageProperties(fragment, fd1.b(properties));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class Network {
        @Deprecated
        public static void download(String str, String str2, long j, long j2, String str3, String str4, boolean z) {
        }

        @Deprecated
        public static void download(String str, String str2, long j, long j2, boolean z) {
        }

        @Deprecated
        public static void pushArrive(String str) {
        }

        @Deprecated
        public static void pushDisplay(String str) {
        }

        @Deprecated
        public static void pushView(String str) {
        }

        @Deprecated
        public static void searchKeyword(String str, String str2) {
        }

        @Deprecated
        public static void updateUTCookie(String str, Map<String, String> map) {
        }

        @Deprecated
        public static void updateUTSIDToCookie(String str) {
        }

        @Deprecated
        public static void weiboShare(String str, String str2) {
        }
    }

    /* compiled from: Taobao */
    @Deprecated
    /* loaded from: classes11.dex */
    public interface OnInitFinishListener {
        void onFinish(int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class Page {
        private static String _calControlName(String str, CT ct, String str2) {
            if (str == null || str2 == null) {
                return null;
            }
            if (!str.startsWith("Page_")) {
                str = "Page_" + str;
            }
            return str + JSMethod.NOT_SET + ct.toString() + "-" + str2;
        }

        private static String _calPageName(String str) {
            if (str == null || str.startsWith("Page_")) {
                return str;
            }
            return "Page_" + str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void _commitCtrlEvent(String str, int i, CT ct, String str2, int i2, String... strArr) {
            String _calPageName;
            if (str == null) {
                _calPageName = _getCurPageName();
            } else {
                _calPageName = _calPageName(str);
            }
            if (yh2.f(_calPageName)) {
                return;
            }
            String _calControlName = _calControlName(_calPageName, ct, str2);
            if (yh2.f(_calControlName)) {
                return;
            }
            String _convertStringAToKVSString = Ext._convertStringAToKVSString(strArr);
            HashMap hashMap = new HashMap();
            hashMap.put(LogField.PAGE.toString(), _calPageName);
            String str3 = LogField.EVENTID.toString();
            hashMap.put(str3, "" + i);
            hashMap.put(LogField.ARG1.toString(), _calControlName);
            hashMap.put(UTConstants.PrivateLogFields.FLAG_BUILD_MAP_BY_UT, BQCCameraParam.VALUE_YES);
            hashMap.put("ut_tbs", "1");
            if (i == 2102) {
                String str4 = LogField.ARG3.toString();
                hashMap.put(str4, "" + i2);
            }
            if (_convertStringAToKVSString != null) {
                hashMap.put(LogField.ARGS.toString(), _convertStringAToKVSString);
            }
            UTAnalytics.getInstance().getDefaultTracker().send(hashMap);
        }

        private static String _getCurPageName() {
            String currentPageName = UTPageHitHelper.getInstance().getCurrentPageName();
            if (currentPageName == null || currentPageName.startsWith("Page_")) {
                return currentPageName;
            }
            return "Page_" + currentPageName;
        }

        public static void buttonClicked(String str) {
            ctrlClicked(CT.Button, str);
        }

        @Deprecated
        public static void create(String str) {
        }

        @Deprecated
        public static void create(String str, String str2) {
        }

        public static void ctrlClicked(CT ct, String str) {
            _commitCtrlEvent(null, 2101, ct, str, 0, new String[0]);
        }

        public static void ctrlLongClicked(CT ct, String str) {
            _commitCtrlEvent(null, 2103, ct, str, 0, new String[0]);
        }

        @Deprecated
        public static void destroy(String str) {
        }

        @Deprecated
        public static void enter(String str) {
        }

        @Deprecated
        public static void enterWithPageName(String str, String str2) {
        }

        @Deprecated
        public static void goBack() {
        }

        public static void itemSelected(CT ct, String str, int i) {
            _commitCtrlEvent(null, 2102, ct, str, i, new String[0]);
        }

        @Deprecated
        public static void leave(String str) {
        }

        @Deprecated
        public static void updatePageName(String str, String str2) {
        }

        @Deprecated
        public static void updatePageProperties(String str, Properties properties) {
        }
    }

    @Deprecated
    public static synchronized String getSharedProperty(String str) {
        synchronized (TBS.class) {
        }
        return null;
    }

    @Deprecated
    public static void h5UT(String str, WebView webView) {
        h5UT(null, str, webView);
    }

    @Deprecated
    public static void init() {
    }

    @Deprecated
    public static void setChannel(String str) {
    }

    @Deprecated
    public static void setEnvironment(Context context) {
    }

    @Deprecated
    public static void setEnvironment(Context context, String str) {
    }

    public static void setH5Url(String str) {
        UTHybridHelper.getInstance().setH5Url(str);
    }

    @Deprecated
    public static void setKey(String str, String str2) {
    }

    @Deprecated
    public static void setVersion(String str) {
    }

    @Deprecated
    public static void swithFromSimplePipeLineToCommon(boolean z) {
    }

    @Deprecated
    public static void trade(String str) {
    }

    @Deprecated
    public static void turnDebug() {
    }

    @Deprecated
    public static void turnOnSecuritySDKSupport() {
    }

    @Deprecated
    public static void uninit() {
    }

    public static void updateGPSInfo(String str, double d, double d2) {
        UTAnalytics.getInstance().getDefaultTracker().send(new UTOriginalCustomHitBuilder(str, 1005, "" + d, "" + d2, null, null).build());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void updateNextPageProperties(Properties properties) {
        UTAnalytics.getInstance().getDefaultTracker().updateNextPageProperties(fd1.b(properties));
    }

    public static void updateSessionProperties(Properties properties) {
        UTAnalytics.getInstance().updateSessionProperties(fd1.b(properties));
    }

    @Deprecated
    public static synchronized void updateSharedProprety(String str, String str2) {
        synchronized (TBS.class) {
        }
    }

    public static void updateUserAccount(String str) {
        UTAnalytics.getInstance().updateUserAccount(str, null);
    }

    public static void userRegister(String str) {
        UTAnalytics.getInstance().userRegister(str);
    }

    private static void h5UT(String str, String str2, Object obj) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str2);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!yh2.f(next)) {
                    String string = jSONObject.getString(next);
                    if (!yh2.f(string)) {
                        hashMap.put(next, string);
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (obj != null) {
            UTHybridHelper.getInstance().h5UT(hashMap, obj);
        }
    }

    public static void updateUserAccount(String str, String str2) {
        UTAnalytics.getInstance().updateUserAccount(str, str2);
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class Ext {
        private static final String PAGE_EXTEND = "Page_Extend";
        public static final /* synthetic */ int a = 0;
        private static HashMap<String, DelayEventObject> mDelayEventObject = new HashMap<>();
        private static Object lCommitEventLockObj = new Object();

        /* JADX INFO: Access modifiers changed from: private */
        public static String _convertStringAToKVSString(String... strArr) {
            if (strArr == null || strArr.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (strArr != null && strArr.length > 0) {
                    boolean z = false;
                    for (int i = 0; i < strArr.length; i++) {
                        if (!yh2.f(strArr[i])) {
                            if (z) {
                                stringBuffer.append(",");
                            }
                            stringBuffer.append(strArr[i]);
                            z = true;
                        }
                    }
                }
                return stringBuffer.toString();
            }
            return null;
        }

        public static void commitEvent(String str, Properties properties) {
            if (yh2.f(str)) {
                return;
            }
            UTHitBuilders.UTCustomHitBuilder uTCustomHitBuilder = new UTHitBuilders.UTCustomHitBuilder(str);
            uTCustomHitBuilder.setProperties(fd1.b(properties));
            UTTracker defaultTracker = UTAnalytics.getInstance().getDefaultTracker();
            if (defaultTracker != null) {
                defaultTracker.send(uTCustomHitBuilder.build());
            } else {
                Logger.v("TBS", "please call UTAnalytics.getInstance().setAppApplicationInstance() before this method");
            }
        }

        public static void commitEventBegin(String str, Properties properties) {
            if (yh2.f(str)) {
                return;
            }
            synchronized (lCommitEventLockObj) {
                if (mDelayEventObject.size() > 2000) {
                    mDelayEventObject.clear();
                }
                if (mDelayEventObject.containsKey(str)) {
                    mDelayEventObject.remove(str);
                }
                DelayEventObject delayEventObject = new DelayEventObject();
                delayEventObject.setTimestamp(System.currentTimeMillis());
                delayEventObject.setProperties(properties);
                delayEventObject.setBegin();
                mDelayEventObject.put(str, delayEventObject);
            }
        }

        public static void commitEventEnd(String str, Properties properties) {
            if (yh2.f(str)) {
                return;
            }
            synchronized (lCommitEventLockObj) {
                if (mDelayEventObject.containsKey(str)) {
                    DelayEventObject delayEventObject = mDelayEventObject.get(str);
                    mDelayEventObject.remove(str);
                    if (delayEventObject != null && delayEventObject.isBegin()) {
                        Properties properties2 = delayEventObject.getProperties();
                        HashMap hashMap = new HashMap();
                        if (properties2 != null) {
                            hashMap.putAll(fd1.b(properties2));
                        }
                        if (properties != null) {
                            hashMap.putAll(fd1.b(properties));
                        }
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put(LogField.EVENTID.toString(), "19999");
                        hashMap2.put(LogField.ARG1.toString(), str);
                        String str2 = LogField.ARG3.toString();
                        hashMap2.put(str2, "" + (System.currentTimeMillis() - delayEventObject.getTimestamp()));
                        hashMap2.putAll(hashMap);
                        hashMap2.put(UTConstants.PrivateLogFields.FLAG_BUILD_MAP_BY_UT, BQCCameraParam.VALUE_YES);
                        UTAnalytics.getInstance().getDefaultTracker().send(hashMap2);
                    }
                }
            }
        }

        public static void commitEvent(String str, int i) {
            commitEvent(str, i, null, null, null, null);
        }

        public static void commitEvent(String str, int i, Object obj) {
            commitEvent(str, i, obj, null, null, null);
        }

        public static void commitEvent(String str, int i, Object obj, Object obj2) {
            commitEvent(str, i, obj, obj2, null, null);
        }

        public static void commitEvent(String str, int i, Object obj, Object obj2, Object obj3) {
            commitEvent(str, i, obj, obj2, obj3, null);
        }

        public static void commitEvent(String str, int i, Object obj, Object obj2, Object obj3, String... strArr) {
            String _convertStringAToKVSString = _convertStringAToKVSString(strArr);
            HashMap hashMap = new HashMap();
            hashMap.put(LogField.PAGE.toString(), str);
            String str2 = LogField.EVENTID.toString();
            hashMap.put(str2, "" + i);
            hashMap.put(LogField.ARG1.toString(), yh2.c(obj));
            hashMap.put(LogField.ARG2.toString(), yh2.c(obj2));
            hashMap.put(LogField.ARG3.toString(), yh2.c(obj3));
            if (_convertStringAToKVSString != null) {
                hashMap.put(LogField.ARGS.toString(), _convertStringAToKVSString);
            }
            hashMap.put(UTConstants.PrivateLogFields.FLAG_BUILD_MAP_BY_UT, BQCCameraParam.VALUE_YES);
            hashMap.put("ut_tbs", "1");
            UTAnalytics.getInstance().getDefaultTracker().send(hashMap);
        }

        public static void commitEvent(int i) {
            commitEvent(PAGE_EXTEND, i, null, null, null, null);
        }

        public static void commitEvent(int i, Object obj) {
            commitEvent(PAGE_EXTEND, i, obj, null, null, null);
        }

        public static void commitEvent(int i, Object obj, Object obj2) {
            commitEvent(PAGE_EXTEND, i, obj, obj2, null, null);
        }

        public static void commitEvent(int i, Object obj, Object obj2, Object obj3) {
            commitEvent(PAGE_EXTEND, i, obj, obj2, obj3, null);
        }

        public static void commitEvent(int i, Object obj, Object obj2, Object obj3, String... strArr) {
            commitEvent(PAGE_EXTEND, i, obj, obj2, obj3, strArr);
        }
    }

    @Deprecated
    public static void h5UT(String str, Context context) {
        h5UT(null, str, context);
    }
}
