package com.taobao.weex.common;

import androidx.annotation.RestrictTo;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.performance.WXInstanceApm;
import com.taobao.weex.utils.WXUtils;
import com.taobao.weex.utils.WXViewUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes11.dex */
public class WXPerformance {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String CACHE_TYPE = "cacheType";
    public static final String DEFAULT = "default";
    public long JSLibInitTime;
    public double JSLibSize;
    public double JSTemplateSize;
    public long actualNetworkTime;
    public long avgFPS;
    public long backImproveMemory;
    public long callBridgeTime;
    public long callCreateFinishTime;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public long callCreateInstanceTime;
    public int cellExceedNum;
    @Deprecated
    public long communicateTime;
    public long componentCount;
    public long componentCreateTime;
    public String connectionType;
    public long cssLayoutTime;
    public String errCode;
    @Deprecated
    public String errMsg;
    public long firstScreenJSFExecuteTime;
    public int fsCallEventTotalNum;
    public int fsCallJsTotalNum;
    public long fsCallJsTotalTime;
    public int fsCallNativeTotalNum;
    public long fsCallNativeTotalTime;
    public int fsComponentCount;
    public int fsComponentCreateTime;
    public long fsRenderTime;
    public int fsRequestNum;
    public long interactionRealUnixTime;
    public long interactionTime;
    public int interactionViewAddCount;
    public int interactionViewAddLimitCount;
    public int localInteractionViewAddCount;
    public double localReadTime;
    private String mInstanceId;
    public int maxDeepVDomLayer;
    public int maxDeepViewLayer;
    public long networkTime;
    public long newFsRenderTime;
    public long packageSpendTime;
    public long parseJsonTime;
    public long pureNetworkTime;
    public String renderFailedDetail;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public long renderTimeOrigin;
    public long renderUnixTimeOrigin;
    public long screenRenderTime;
    public long syncTaskTime;
    public long templateLoadTime;
    @Deprecated
    public String templateUrl;
    public int timerInvokeCount;
    public double totalTime;
    public double wrongImgSizeCount;
    public String zCacheInfo;
    public static final int VIEW_LIMIT_HEIGHT = (WXViewUtils.getScreenHeight() / 3) * 2;
    public static final int VIEW_LIMIT_WIDTH = (WXViewUtils.getScreenWidth() / 3) * 2;
    public static boolean TRACE_DATA = WXEnvironment.isApkDebugable();
    @Deprecated
    public String bizType = "weex";
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String cacheType = "none";
    public double fluency = 100.0d;
    public String pageName = "default";
    public int useScroller = 0;
    public String JSLibVersion = WXEnvironment.JS_LIB_SDK_VERSION;
    public String WXSDKVersion = WXEnvironment.WXSDK_VERSION;
    public String args = "";
    public String requestType = "other";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Deprecated
    public String[] wxDims = new String[5];
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Deprecated
    public long[] measureTimes = new long[5];
    public int mActionAddElementCount = 0;
    public int mActionAddElementSumTime = 0;
    private StringBuilder mErrMsgBuilder = new StringBuilder();

    /* compiled from: Taobao */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes11.dex */
    public enum Dimension {
        JSLibVersion,
        WXSDKVersion,
        pageName,
        spm,
        scheme,
        cacheType,
        requestType,
        networkType,
        connectionType,
        zcacheInfo,
        wxContainerName,
        wxInstanceType,
        wxParentPage,
        wxdim1,
        wxdim2,
        wxdim3,
        wxdim4,
        wxdim5,
        bizType,
        templateUrl,
        useScroller
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public enum Measure {
        JSLibSize(0.0d, Double.MAX_VALUE),
        JSLibInitTime(0.0d, 80000.0d),
        SDKInitTime(0.0d, 120000.0d),
        SDKInitInvokeTime(0.0d, 5000.0d),
        SDKInitExecuteTime(0.0d, 5000.0d),
        JSTemplateSize(0.0d, 5000.0d),
        pureNetworkTime(0.0d, 15000.0d),
        networkTime(0.0d, 15000.0d),
        fsCreateInstanceTime(0.0d, 3000.0d),
        fsCallJsTotalTime(0.0d, 5000.0d),
        fsCallJsTotalNum(0.0d, Double.MAX_VALUE),
        fsCallNativeTotalTime(0.0d, 5000.0d),
        fsCallNativeTotalNum(0.0d, Double.MAX_VALUE),
        fsCallEventTotalNum(0.0d, Double.MAX_VALUE),
        fsComponentCount(0.0d, 100000.0d),
        fsComponentCreateTime(0.0d, Double.MAX_VALUE),
        fsRenderTime(0.0d, 5000.0d),
        fsRequestNum(0.0d, 100.0d),
        callCreateFinishTime(0.0d, 10000.0d),
        cellExceedNum(0.0d, Double.MAX_VALUE),
        communicateTotalTime(0.0d, 5000.0d),
        maxDeepViewLayer(0.0d, Double.MAX_VALUE),
        maxDeepVDomLayer(0.0d, Double.MAX_VALUE),
        componentCount(0.0d, 1000000.0d),
        componentCreateTime(0.0d, Double.MAX_VALUE),
        avgFps(0.0d, 61.0d),
        timerCount(0.0d, Double.MAX_VALUE),
        MaxImproveMemory(0.0d, Double.MAX_VALUE),
        BackImproveMemory(0.0d, Double.MAX_VALUE),
        PushImproveMemory(0.0d, Double.MAX_VALUE),
        measureTime1(0.0d, Double.MAX_VALUE),
        measureTime2(0.0d, Double.MAX_VALUE),
        measureTime3(0.0d, Double.MAX_VALUE),
        measureTime4(0.0d, Double.MAX_VALUE),
        measureTime5(0.0d, Double.MAX_VALUE),
        callBridgeTime(0.0d, Double.MAX_VALUE),
        cssLayoutTime(0.0d, Double.MAX_VALUE),
        parseJsonTime(0.0d, Double.MAX_VALUE),
        communicateTime(0.0d, 5000.0d),
        screenRenderTime(0.0d, 5000.0d),
        totalTime(0.0d, 5000.0d),
        localReadTime(0.0d, 5000.0d),
        templateLoadTime(0.0d, 5000.0d),
        packageSpendTime(0.0d, 5000.0d),
        syncTaskTime(0.0d, 5000.0d),
        actualNetworkTime(0.0d, 5000.0d),
        firstScreenJSFExecuteTime(0.0d, 5000.0d),
        fluency(0.0d, 101.0d),
        imgSizeCount(0.0d, 2000.0d),
        interactionTime(0.0d, 10000.0d),
        interactionViewAddCount(0.0d, Double.MAX_VALUE),
        interactionViewAddLimitCount(0.0d, Double.MAX_VALUE),
        newFsRenderTime(0.0d, 10000.0d);
        
        private double mMaxRange;
        private double mMinRange;

        Measure(double d, double d2) {
            this.mMinRange = d;
            this.mMaxRange = d2;
        }

        public double getMaxRange() {
            return this.mMaxRange;
        }

        public double getMinRange() {
            return this.mMinRange;
        }
    }

    public WXPerformance(String str) {
        this.mInstanceId = str;
    }

    public static String[] getDimensions() {
        LinkedList linkedList = new LinkedList();
        for (Dimension dimension : Dimension.values()) {
            linkedList.add(dimension.toString());
        }
        return (String[]) linkedList.toArray(new String[linkedList.size()]);
    }

    public static String[] getMeasures() {
        LinkedList linkedList = new LinkedList();
        for (Measure measure : Measure.values()) {
            linkedList.add(measure.toString());
        }
        return (String[]) linkedList.toArray(new String[linkedList.size()]);
    }

    public void afterInstanceDestroy(String str) {
    }

    public void appendErrMsg(CharSequence charSequence) {
        this.mErrMsgBuilder.append(charSequence);
    }

    public void beforeInstanceRender(String str) {
        this.renderTimeOrigin = System.currentTimeMillis();
        this.renderUnixTimeOrigin = WXUtils.getFixUnixTime();
    }

    public Map<String, String> getDimensionMap() {
        HashMap hashMap = new HashMap();
        hashMap.put(Dimension.JSLibVersion.toString(), this.JSLibVersion);
        hashMap.put(Dimension.WXSDKVersion.toString(), this.WXSDKVersion);
        hashMap.put(Dimension.pageName.toString(), this.pageName);
        hashMap.put(Dimension.requestType.toString(), this.requestType);
        hashMap.put(Dimension.networkType.toString(), "unknown");
        hashMap.put(Dimension.connectionType.toString(), this.connectionType);
        hashMap.put(Dimension.zcacheInfo.toString(), this.zCacheInfo);
        hashMap.put(Dimension.cacheType.toString(), this.cacheType);
        hashMap.put(Dimension.useScroller.toString(), String.valueOf(this.useScroller));
        WXSDKInstance y = WXSDKManager.v().y(this.mInstanceId);
        hashMap.put(WXInstanceApm.KEY_PAGE_PROPERTIES_CONTAINER_NAME, y == null ? "unKnow" : y.getContainerInfo().get(WXInstanceApm.KEY_PAGE_PROPERTIES_CONTAINER_NAME));
        hashMap.put(WXInstanceApm.KEY_PAGE_PROPERTIES_INSTANCE_TYPE, y == null ? "unKnow" : y.getContainerInfo().get(WXInstanceApm.KEY_PAGE_PROPERTIES_INSTANCE_TYPE));
        hashMap.put(WXInstanceApm.KEY_PAGE_PROPERTIES_PARENT_PAGE, y != null ? y.getContainerInfo().get(WXInstanceApm.KEY_PAGE_PROPERTIES_PARENT_PAGE) : "unKnow");
        hashMap.put(Dimension.wxdim1.toString(), this.wxDims[0]);
        hashMap.put(Dimension.wxdim2.toString(), this.wxDims[1]);
        hashMap.put(Dimension.wxdim3.toString(), this.wxDims[2]);
        hashMap.put(Dimension.wxdim4.toString(), this.wxDims[3]);
        hashMap.put(Dimension.wxdim5.toString(), this.wxDims[4]);
        hashMap.put(Dimension.bizType.toString(), this.bizType);
        hashMap.put(Dimension.templateUrl.toString(), this.templateUrl);
        return hashMap;
    }

    public String getErrMsg() {
        return this.mErrMsgBuilder.toString();
    }

    public Map<String, Double> getMeasureMap() {
        double d;
        long j = this.fsRenderTime;
        Double valueOf = Double.valueOf(0.0d);
        if (j != 0) {
            d = j - this.renderTimeOrigin;
        } else {
            d = this.totalTime;
            if (d == 0.0d) {
                d = -1.0d;
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put(Measure.JSLibSize.toString(), Double.valueOf(this.JSLibSize));
        hashMap.put(Measure.JSLibInitTime.toString(), Double.valueOf(this.JSLibInitTime));
        hashMap.put(Measure.SDKInitTime.toString(), Double.valueOf(WXEnvironment.sSDKInitTime));
        hashMap.put(Measure.SDKInitInvokeTime.toString(), Double.valueOf(WXEnvironment.sSDKInitInvokeTime));
        hashMap.put(Measure.SDKInitExecuteTime.toString(), Double.valueOf(WXEnvironment.sSDKInitExecuteTime));
        hashMap.put(Measure.JSTemplateSize.toString(), Double.valueOf(this.JSTemplateSize));
        hashMap.put(Measure.pureNetworkTime.toString(), Double.valueOf(this.pureNetworkTime));
        hashMap.put(Measure.networkTime.toString(), Double.valueOf(this.networkTime));
        hashMap.put(Measure.fsCreateInstanceTime.toString(), Double.valueOf(this.callCreateInstanceTime));
        hashMap.put(Measure.fsCallJsTotalTime.toString(), Double.valueOf(this.fsCallJsTotalTime));
        hashMap.put(Measure.fsCallJsTotalNum.toString(), Double.valueOf(this.fsCallJsTotalNum));
        hashMap.put(Measure.fsCallNativeTotalTime.toString(), Double.valueOf(this.fsCallNativeTotalTime));
        hashMap.put(Measure.fsCallNativeTotalNum.toString(), Double.valueOf(this.fsCallNativeTotalNum));
        hashMap.put(Measure.fsComponentCount.toString(), Double.valueOf(this.fsComponentCount));
        hashMap.put(Measure.fsComponentCreateTime.toString(), Double.valueOf(this.fsComponentCreateTime));
        hashMap.put(Measure.fsRenderTime.toString(), Double.valueOf(d));
        hashMap.put(Measure.fsRequestNum.toString(), Double.valueOf(this.fsRequestNum));
        hashMap.put(Measure.communicateTotalTime.toString(), Double.valueOf(this.totalTime));
        hashMap.put(Measure.maxDeepViewLayer.toString(), Double.valueOf(this.maxDeepViewLayer));
        hashMap.put(Measure.maxDeepVDomLayer.toString(), Double.valueOf(this.maxDeepVDomLayer));
        hashMap.put(Measure.componentCount.toString(), Double.valueOf(this.componentCount));
        hashMap.put(Measure.componentCreateTime.toString(), Double.valueOf(this.componentCreateTime));
        hashMap.put(Measure.cellExceedNum.toString(), Double.valueOf(this.cellExceedNum));
        hashMap.put(Measure.timerCount.toString(), Double.valueOf(this.timerInvokeCount));
        hashMap.put(Measure.avgFps.toString(), Double.valueOf(this.avgFPS));
        hashMap.put(Measure.fluency.toString(), Double.valueOf(this.fluency));
        hashMap.put(Measure.MaxImproveMemory.toString(), valueOf);
        hashMap.put(Measure.BackImproveMemory.toString(), Double.valueOf(this.backImproveMemory));
        hashMap.put(Measure.PushImproveMemory.toString(), valueOf);
        hashMap.put(Measure.fsCallEventTotalNum.toString(), Double.valueOf(this.fsCallEventTotalNum));
        hashMap.put(Measure.callCreateFinishTime.toString(), Double.valueOf(this.callCreateFinishTime));
        hashMap.put(Measure.imgSizeCount.toString(), Double.valueOf(this.wrongImgSizeCount));
        hashMap.put(Measure.interactionTime.toString(), Double.valueOf(this.interactionTime));
        hashMap.put(Measure.interactionViewAddCount.toString(), Double.valueOf(this.interactionViewAddCount));
        hashMap.put(Measure.interactionViewAddLimitCount.toString(), Double.valueOf(this.interactionViewAddLimitCount));
        hashMap.put(Measure.newFsRenderTime.toString(), Double.valueOf(this.newFsRenderTime));
        hashMap.put(Measure.callBridgeTime.toString(), Double.valueOf(this.callBridgeTime));
        hashMap.put(Measure.cssLayoutTime.toString(), Double.valueOf(this.cssLayoutTime));
        hashMap.put(Measure.parseJsonTime.toString(), Double.valueOf(this.parseJsonTime));
        hashMap.put(Measure.screenRenderTime.toString(), Double.valueOf(this.screenRenderTime));
        hashMap.put(Measure.communicateTime.toString(), Double.valueOf(this.communicateTime));
        hashMap.put(Measure.localReadTime.toString(), Double.valueOf(this.localReadTime));
        hashMap.put(Measure.templateLoadTime.toString(), Double.valueOf(this.templateLoadTime));
        hashMap.put(Measure.firstScreenJSFExecuteTime.toString(), Double.valueOf(this.firstScreenJSFExecuteTime));
        hashMap.put(Measure.actualNetworkTime.toString(), Double.valueOf(this.actualNetworkTime));
        hashMap.put(Measure.syncTaskTime.toString(), Double.valueOf(this.syncTaskTime));
        hashMap.put(Measure.packageSpendTime.toString(), Double.valueOf(this.packageSpendTime));
        hashMap.put(Measure.measureTime1.toString(), Double.valueOf(this.measureTimes[0]));
        hashMap.put(Measure.measureTime2.toString(), Double.valueOf(this.measureTimes[1]));
        hashMap.put(Measure.measureTime3.toString(), Double.valueOf(this.measureTimes[2]));
        hashMap.put(Measure.measureTime4.toString(), Double.valueOf(this.measureTimes[3]));
        hashMap.put(Measure.measureTime5.toString(), Double.valueOf(this.measureTimes[4]));
        return hashMap;
    }

    public String getPerfData() {
        return "networkTime:" + this.networkTime + " actualNetworkTime:" + this.actualNetworkTime + " connectionType:" + this.connectionType + " requestType:" + this.requestType + " firstScreenRenderTime:" + this.screenRenderTime + " firstScreenJSFExecuteTime:" + this.firstScreenJSFExecuteTime + " componentCount:" + this.componentCount + " JSTemplateSize:" + this.JSTemplateSize + " SDKInitTime:" + WXEnvironment.sSDKInitTime + " totalTime:" + this.totalTime + " JSLibVersion:" + this.JSLibVersion + " WXSDKVersion:" + this.WXSDKVersion + " pageName:" + this.pageName + " useScroller:" + this.useScroller;
    }

    public String toString() {
        if (WXEnvironment.isApkDebugable()) {
            return "bizType:" + this.bizType + ",pageName:" + this.pageName + ",templateLoadTime" + this.templateLoadTime + ",localReadTime:" + this.localReadTime + ",JSLibInitTime:" + this.JSLibInitTime + ",JSLibSize:" + this.JSLibSize + ",templateUrl" + this.templateUrl + ",JSTemplateSize:" + this.JSTemplateSize + ",communicateTime:" + this.communicateTime + ",screenRenderTime:" + this.screenRenderTime + ",firstScreenJSFExecuteTime:" + this.firstScreenJSFExecuteTime + ",componentCount:" + this.componentCount + ",syncTaskTime:" + this.syncTaskTime + ",pureNetworkTime:" + this.pureNetworkTime + ",networkTime:" + this.networkTime + ",actualNetworkTime:" + this.actualNetworkTime + ",packageSpendTime:" + this.packageSpendTime + ",connectionType:" + this.connectionType + ",requestType:" + this.requestType + ",initInvokeTime:" + WXEnvironment.sSDKInitInvokeTime + ",initExecuteTime:" + WXEnvironment.sSDKInitExecuteTime + ",SDKInitTime:" + WXEnvironment.sSDKInitTime + ",totalTime:" + this.totalTime + ",JSLibVersion:" + this.JSLibVersion + ",WXSDKVersion:" + this.WXSDKVersion + ",errCode:" + this.errCode + ",renderFailedDetail:" + this.renderFailedDetail + ",arg:" + this.args + ",errMsg:" + getErrMsg();
        }
        return super.toString();
    }
}
