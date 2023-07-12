package com.ut.mini.exposure;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.fastjson.JSONArray;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTPageHitHelper;
import com.ut.mini.internal.ExposureViewHandle;
import com.ut.mini.internal.IExposureViewHandleExt;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import com.ut.mini.module.trackerlistener.UTTrackerListenerMgr;
import com.youku.vpm.track.OnePlayTrack;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.StringUtils;
import tb.fd1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TrackerFrameLayout extends FrameLayout implements GestureDetector.OnGestureListener {
    private static final float CLICK_LIMIT = 20.0f;
    private static final String TAG = "TrackerFrameLayout";
    public static long TIME_INTERVAL = 100;
    public static final int TRIGGER_VIEW_CHANGED = 0;
    public static final int TRIGGER_VIEW_STATUS_CHANGED = 3;
    public static final int TRIGGER_WINDOW_CHANGED = 1;
    private static final int UT_EXPORSURE_MAX_LENGTH = 25600;
    private static final String UT_SCM_TAG = "scm";
    private static final String UT_SPM_TAG = "spm";
    private static final int eventId = 2201;
    private Map<String, ExposureView> currentViews;
    private long lastDispatchDrawSystemTimeMillis;
    private Rect mGlobalVisibleRect;
    private float mOriX;
    private float mOriY;
    private Runnable traceTask;
    private long traverseTime;
    private static HashMap<String, Object> mCommonInfo = new HashMap<>();
    private static HashMap<String, HashSet<String>> mHasExposureSet = new HashMap<>();
    private static Map<String, ArrayList> mHasExposrueMap = Collections.synchronizedMap(new HashMap());
    private static HashMap<String, Integer> mHasExposrueDataLength = new HashMap<>();
    private static final Object HasExposrueObjectLock = new Object();
    private static List<String> mImmediatelyCommitBlockList = new Vector();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class ExposureEntity implements Serializable {
        public double area;
        public long duration;
        public Map<String, String> exargs;
        public String scm;
        public String spm;
        public String viewid;

        public ExposureEntity(String str, String str2, Map map, long j, double d, String str3) {
            this.duration = 0L;
            this.spm = str;
            this.scm = str2;
            this.exargs = map;
            this.duration = j;
            this.area = d;
            this.viewid = str3;
        }

        public int length() {
            String str = this.spm;
            int length = str != null ? 0 + str.length() + 8 : 0;
            String str2 = this.scm;
            if (str2 != null) {
                length += str2.length() + 8;
            }
            Map<String, String> map = this.exargs;
            if (map != null) {
                for (String str3 : map.keySet()) {
                    if (str3 != null) {
                        length += str3.length();
                    }
                    String str4 = this.exargs.get(str3);
                    if (str4 != null) {
                        length += str4.toString().length();
                    }
                    length += 5;
                }
            }
            String str5 = this.viewid;
            if (str5 != null) {
                length += str5.length() + 11;
            }
            return length + 50;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    static class PageChangerMonitor implements UTPageHitHelper.PageChangeListener {
        PageChangerMonitor() {
        }

        @Override // com.ut.mini.UTPageHitHelper.PageChangeListener
        public void onPageAppear(Object obj) {
            if (obj instanceof Activity) {
                View view = null;
                try {
                    view = ((Activity) obj).findViewById(16908290);
                } catch (Exception e) {
                    ExpLogger.e(TrackerFrameLayout.TAG, e, new Object[0]);
                }
                if (view instanceof ViewGroup) {
                    View childAt = ((ViewGroup) view).getChildAt(0);
                    if (childAt instanceof TrackerFrameLayout) {
                        ((TrackerFrameLayout) childAt).trace(1, true);
                        return;
                    } else {
                        ExpLogger.w(TrackerFrameLayout.TAG, "cannot found the trace view", childAt);
                        return;
                    }
                }
                ExpLogger.w(TrackerFrameLayout.TAG, "contentView", view);
            }
        }

        @Override // com.ut.mini.UTPageHitHelper.PageChangeListener
        public void onPageDisAppear(Object obj) {
            if (obj instanceof Activity) {
                View view = null;
                try {
                    view = ((Activity) obj).findViewById(16908290);
                } catch (Exception e) {
                    ExpLogger.e(TrackerFrameLayout.TAG, e, new Object[0]);
                }
                if (view instanceof ViewGroup) {
                    View childAt = ((ViewGroup) view).getChildAt(0);
                    if (childAt instanceof TrackerFrameLayout) {
                        ((TrackerFrameLayout) childAt).onPageDisAppear();
                        return;
                    } else {
                        ExpLogger.w(TrackerFrameLayout.TAG, "cannot found the trace view ", childAt);
                        return;
                    }
                }
                ExpLogger.w(TrackerFrameLayout.TAG, "contentView", view);
            }
        }
    }

    static {
        UTPageHitHelper.addPageChangerListener(new PageChangerMonitor());
    }

    public TrackerFrameLayout(Context context) {
        super(context);
        this.currentViews = new ConcurrentHashMap();
        this.lastDispatchDrawSystemTimeMillis = 0L;
        this.mOriX = 0.0f;
        this.mOriY = 0.0f;
        this.traceTask = new Runnable() { // from class: com.ut.mini.exposure.TrackerFrameLayout.1
            @Override // java.lang.Runnable
            public void run() {
                Logger.f(TrackerFrameLayout.TAG, "=====traceTask=====");
                TrackerFrameLayout.this.trace(0, true);
            }
        };
        this.mGlobalVisibleRect = new Rect();
        addCommonArgsInfo();
        ExposureConfigMgr.updateExposureConfig();
    }

    @TargetApi(4)
    private void addCommonArgsInfo() {
        if (getContext() == null || !(getContext() instanceof Activity)) {
            return;
        }
        View decorView = ((Activity) getContext()).getWindow().getDecorView();
        mCommonInfo.clear();
        HashMap<String, String> hashMap = TrackerManager.getInstance().commonInfoMap;
        if (hashMap != null) {
            mCommonInfo.putAll(hashMap);
        }
        HashMap hashMap2 = (HashMap) decorView.getTag(ExposureUtils.ut_exprosure_common_info_tag);
        if (hashMap2 != null && !hashMap2.isEmpty()) {
            mCommonInfo.putAll(hashMap2);
            ExpLogger.d(TAG, "addCommonArgsInfo mCommonInfo ", hashMap2);
        }
        ExpLogger.d(TAG, "addCommonArgsInfo all mCommonInfo ", hashMap2);
    }

    private void addToCommit(ExposureView exposureView) {
        String str;
        Map map;
        String str2 = exposureView.block;
        String str3 = exposureView.tag;
        if (isExposured(str2, str3)) {
            ExpLogger.d(TAG, "isExposured block", str2, "viewId", str3);
            return;
        }
        setExposuredTag(str2, str3);
        Map<String, Object> map2 = exposureView.viewData;
        HashMap hashMap = new HashMap();
        ExposureViewHandle exposureViewHandle = TrackerManager.getInstance().getExposureViewHandle();
        if (exposureViewHandle != null) {
            Context context = exposureView.view.getContext();
            Map<String, String> exposureViewProperties = exposureViewHandle.getExposureViewProperties(context != null ? UTPageHitHelper.getInstance().getPageUrl(context) : null, exposureView.view);
            if (exposureViewProperties != null) {
                hashMap.putAll(exposureViewProperties);
            }
        }
        if (map2 != null && map2.get("UT_EXPROSURE_ARGS") != null && (map = (Map) map2.get("UT_EXPROSURE_ARGS")) != null && map.size() > 0) {
            hashMap.putAll(map);
        }
        String str4 = (String) hashMap.remove("spm");
        String str5 = (String) hashMap.remove("scm");
        synchronized (HasExposrueObjectLock) {
            ArrayList arrayList = mHasExposrueMap.get(str2);
            if (arrayList == null) {
                arrayList = new ArrayList();
                mHasExposrueMap.put(str2, arrayList);
                View view = exposureView.view;
                if (view != null) {
                    Object tag = view.getTag(ExposureUtils.ut_exposure_data_spm);
                    if (tag instanceof Map) {
                        String str6 = (String) ((Map) tag).get("x-spm-c");
                        String str7 = (String) ((Map) tag).get("x-spm-d");
                        if (!TextUtils.isEmpty(str6) && !TextUtils.isEmpty(str7)) {
                            Object rootViewTag = getRootViewTag(view, ExposureUtils.ut_exposure_root_spm);
                            if (rootViewTag instanceof Map) {
                                String str8 = (String) ((Map) rootViewTag).get("x-spm-a");
                                String str9 = (String) ((Map) rootViewTag).get("x-spm-b");
                                if (!TextUtils.isEmpty(str8) && !TextUtils.isEmpty(str9)) {
                                    str4 = str8 + "." + str9 + "." + str6 + "." + str7;
                                }
                            }
                        }
                    }
                }
            } else {
                View view2 = exposureView.view;
                if (view2 != null) {
                    Object tag2 = view2.getTag(ExposureUtils.ut_exposure_data_spm);
                    if (tag2 instanceof Map) {
                        String str10 = (String) ((Map) tag2).get("x-spm-c");
                        String str11 = (String) ((Map) tag2).get("x-spm-d");
                        if (!TextUtils.isEmpty(str10) && !TextUtils.isEmpty(str11)) {
                            String str12 = ((ExposureEntity) arrayList.get(0)).spm;
                            String[] split = TextUtils.isEmpty(str12) ? null : str12.split("\\.");
                            if (split != null && split.length == 4) {
                                str4 = split[0] + "." + split[1] + "." + str10 + "." + str11;
                            }
                        }
                    }
                }
            }
            str = str4;
            ExposureEntity exposureEntity = new ExposureEntity(str, str5, hashMap, System.currentTimeMillis() - exposureView.beginTime, exposureView.area, str3);
            arrayList.add(exposureEntity);
            Integer num = mHasExposrueDataLength.get(str2);
            if (num == null) {
                num = 0;
            }
            Integer valueOf = Integer.valueOf(num.intValue() + exposureEntity.length());
            mHasExposrueDataLength.put(str2, valueOf);
            if (valueOf.intValue() > UT_EXPORSURE_MAX_LENGTH) {
                commitToUT(str2, mCommonInfo);
            } else if (mImmediatelyCommitBlockList.contains(str2)) {
                commitToUT(str2, mCommonInfo);
            }
        }
        UTTrackerListenerMgr.getInstance().addExposureViewToCommit(str2, str3, str, str5, hashMap);
        ExpLogger.d(TAG, "提交元素viewId ", str3, "block", str2, "spm", str, "scm", str5, "args", hashMap);
    }

    private void checkViewState(int i, ExposureView exposureView) {
        if (exposureView == null) {
            return;
        }
        if (isVisableToUser(exposureView.view)) {
            int i2 = exposureView.lastState;
            if (i2 == 0) {
                exposureView.lastState = 1;
                exposureView.beginTime = System.currentTimeMillis();
            } else if (i2 != 1) {
                if (i2 == 2) {
                    exposureView.lastState = 1;
                    exposureView.beginTime = System.currentTimeMillis();
                }
            } else if (i == 1 || i == 3) {
                exposureView.lastState = 2;
                exposureView.endTime = System.currentTimeMillis();
            }
        } else if (exposureView.lastState == 1) {
            exposureView.lastState = 2;
            exposureView.endTime = System.currentTimeMillis();
        }
        if (exposureView.isSatisfyTimeRequired()) {
            addToCommit(exposureView);
            this.currentViews.remove(String.valueOf(exposureView.view.hashCode()));
        } else if (exposureView.lastState == 2) {
            this.currentViews.remove(String.valueOf(exposureView.view.hashCode()));
            ExpLogger.d(TAG, "时间不满足，元素", exposureView.tag);
        }
    }

    private void checkViewsStates(int i) {
        Map<String, ExposureView> map = this.currentViews;
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, ExposureView> entry : this.currentViews.entrySet()) {
            checkViewState(i, this.currentViews.get(String.valueOf(entry.getValue().view.hashCode())));
        }
    }

    public static void commitExposureData() {
        Object[] objArr;
        synchronized (HasExposrueObjectLock) {
            try {
                objArr = mHasExposrueMap.keySet().toArray();
            } catch (Throwable unused) {
                objArr = null;
            }
            if (objArr != null) {
                if (objArr.length > 0) {
                    for (int i = 0; i < objArr.length; i++) {
                        commitToUT(objArr[i] + "", mCommonInfo);
                    }
                }
            }
            mHasExposrueMap.clear();
        }
    }

    private static void commitToUT(String str, HashMap<String, Object> hashMap) {
        Map<String, String> a;
        ExpLogger.d();
        ArrayList remove = mHasExposrueMap.remove(str);
        HashMap hashMap2 = new HashMap();
        if (hashMap != null && hashMap.size() > 0 && (a = fd1.a(hashMap)) != null) {
            hashMap2.putAll(a);
        }
        hashMap2.put("expdata", getExpData(remove));
        UTAnalytics.getInstance().getDefaultTracker().send(new UTOriginalCustomHitBuilder(UTPageHitHelper.getInstance().getCurrentPageName(), 2201, str, null, null, hashMap2).build());
        mHasExposrueDataLength.remove(str);
    }

    private static String getExpData(ArrayList<ExposureEntity> arrayList) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.addAll(arrayList);
        return jSONArray.toJSONString();
    }

    private static Object getRootViewTag(View view, int i) {
        while (view != null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
            if (view != null && view.getTag(i) != null) {
                return view.getTag(i);
            }
        }
        return null;
    }

    private boolean isExposured(String str, String str2) {
        HashSet<String> hashSet = mHasExposureSet.get(str);
        if (hashSet == null) {
            return false;
        }
        return hashSet.contains(str2);
    }

    private boolean isVisableToUser(View view) {
        return viewSize(view) >= ExposureConfigMgr.dimThreshold;
    }

    public static void refreshExposureData() {
        mHasExposureSet.clear();
    }

    public static void refreshExposureDataByViewId(String str, String str2) {
        HashSet<String> hashSet;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (hashSet = mHasExposureSet.get(str)) == null) {
            return;
        }
        hashSet.remove(str2);
    }

    public static void setCommitImmediatelyExposureBlock(String str) {
        mImmediatelyCommitBlockList.add(str);
    }

    private void setExposuredTag(String str, String str2) {
        HashSet<String> hashSet = mHasExposureSet.get(str);
        if (hashSet == null) {
            hashSet = new HashSet<>();
            mHasExposureSet.put(str, hashSet);
        }
        hashSet.add(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trace(int i, boolean z) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (!z && currentTimeMillis - this.traverseTime < TIME_INTERVAL) {
                if (ExpLogger.enableLog) {
                    ExpLogger.d(TAG, "triggerTime interval is too close to " + TIME_INTERVAL + "ms");
                    return;
                }
                return;
            }
            ExpLogger.d(TAG, "扫描开始");
            this.traverseTime = currentTimeMillis;
            traverseViewTree(this);
            checkViewsStates(i);
            if (ExpLogger.enableLog) {
                ExpLogger.d(TAG, "扫描结束，耗时:" + (System.currentTimeMillis() - currentTimeMillis));
            }
        } catch (Throwable th) {
            ExpLogger.e(TAG, th, new Object[0]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x022e A[ORIG_RETURN, RETURN] */
    @android.annotation.TargetApi(4)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void traverseViewTree(android.view.View r18) {
        /*
            Method dump skipped, instructions count: 559
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ut.mini.exposure.TrackerFrameLayout.traverseViewTree(android.view.View):void");
    }

    private double viewSize(View view) {
        int width = view.getWidth() * view.getHeight();
        if (!view.getGlobalVisibleRect(this.mGlobalVisibleRect) || width <= 0) {
            return 0.0d;
        }
        return ((com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.mGlobalVisibleRect) * com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.mGlobalVisibleRect)) * 1.0d) / width;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        ExpLogger.d(TAG, "dispatchDraw");
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastDispatchDrawSystemTimeMillis > 1000) {
            this.lastDispatchDrawSystemTimeMillis = currentTimeMillis;
            addCommonArgsInfo();
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (ExpLogger.enableLog) {
            ExpLogger.d(TAG, "action:", Integer.valueOf(motionEvent.getAction()));
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mOriX = motionEvent.getX();
            this.mOriY = motionEvent.getY();
        } else if (action == 1) {
            Handler threadHandle = TrackerManager.getInstance().getThreadHandle();
            if (threadHandle != null) {
                threadHandle.removeCallbacks(this.traceTask);
                threadHandle.postDelayed(this.traceTask, 1000L);
            }
        } else if (action == 2) {
            if (Math.abs(motionEvent.getX() - this.mOriX) <= 20.0f && Math.abs(motionEvent.getY() - this.mOriY) <= 20.0f) {
                ExpLogger.d(TAG, "onInterceptTouchEvent ACTION_MOVE but not in click limit");
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                ExpLogger.d(TAG, " begin");
                trace(0, false);
                if (ExpLogger.enableLog) {
                    ExpLogger.d(TAG, "end costTime=" + (System.currentTimeMillis() - currentTimeMillis) + "--" + StringUtils.LF);
                }
            }
        }
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchVisibilityChanged(View view, int i) {
        if (i == 8) {
            ExpLogger.d(TAG, OnePlayTrack.PlayType.BEGIN);
            long currentTimeMillis = System.currentTimeMillis();
            trace(1, false);
            if (ExpLogger.enableLog) {
                ExpLogger.d(TAG, "end costTime=" + (System.currentTimeMillis() - currentTimeMillis) + "--");
            }
        } else {
            ExpLogger.d(TAG, "visibility", Integer.valueOf(i));
        }
        super.dispatchVisibilityChanged(view, i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchWindowFocusChanged(boolean z) {
        ExpLogger.d(TAG, OnePlayTrack.PlayType.BEGIN);
        long currentTimeMillis = System.currentTimeMillis();
        trace(1, false);
        if (ExpLogger.enableLog) {
            ExpLogger.d(TAG, "end" + (System.currentTimeMillis() - currentTimeMillis) + "--");
        }
        super.dispatchWindowFocusChanged(z);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        ExpLogger.d(TAG, OnePlayTrack.PlayType.BEGIN);
        long currentTimeMillis = System.currentTimeMillis();
        trace(0, false);
        if (ExpLogger.enableLog) {
            ExpLogger.d(TAG, "end costTime=" + (System.currentTimeMillis() - currentTimeMillis) + "--");
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    public void onPageDisAppear() {
        Handler threadHandle = TrackerManager.getInstance().getThreadHandle();
        if (threadHandle != null) {
            threadHandle.removeCallbacks(this.traceTask);
        }
        trace(1, true);
        commitExposureData();
        mImmediatelyCommitBlockList.clear();
        this.currentViews.clear();
        if (!ExposureConfigMgr.notClearTagAfterDisAppear) {
            mHasExposureSet.clear();
        }
        ExposureViewHandle exposureViewHandle = TrackerManager.getInstance().getExposureViewHandle();
        if (exposureViewHandle instanceof IExposureViewHandleExt) {
            ((IExposureViewHandleExt) exposureViewHandle).onExposureDataCleared();
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (ExpLogger.enableLog) {
            ExpLogger.d(TAG, "action:", Integer.valueOf(motionEvent.getAction()));
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public static void refreshExposureData(String str) {
        ExpLogger.d(TAG, "[refreshExposureData]block", str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        mHasExposureSet.remove(str);
    }
}
