package me.ele.altriax.launcher.real.time.data.monitor;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import me.ele.altriax.launcher.real.time.data.ExternalLinkHomeRealTime;
import me.ele.altriax.launcher.real.time.data.utils.Apm;
import me.ele.altriax.launcher.real.time.data.utils.Device;
import me.ele.altriax.launcher.real.time.data.utils.MonitorLog;
import me.ele.altriax.launcher.real.time.data.utils.Value;
import tb.n4;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ExternalLinkHomeMonitor extends BaseMonitor {
    private static final String DIMENSION_AD = "ad";
    private static final String DIMENSION_APM_EVENTS = "apmEvents";
    private static final String DIMENSION_APM_PROPERTIES = "apmProperties";
    private static final String DIMENSION_APM_STAGES = "apmStages";
    private static final String DIMENSION_APM_STATS = "apmStats";
    private static final String DIMENSION_BIZ_EVENT = "bizEvent";
    private static final String DIMENSION_BIZ_TIME = "bizTime";
    private static final String DIMENSION_DEVICE_LEVEL = "deviceLevel";
    private static final String DIMENSION_EXTERNAL_LINK_URL = "externalLinkUrl";
    private static final String DIMENSION_FIRST_INSTALL = "firstInstall";
    private static final String DIMENSION_FIRST_LAUNCH = "firstLaunch";
    private static final String DIMENSION_LAUNCH_TYPE = "launchType";
    private static final String DIMENSION_VALUE_IS_AD = "idAd";
    private static final String DIMENSION_VALUE_NO_AD = "noAd";
    private static final String EMPTY_STRING = "";
    private static final String MEASURE_APPLICATION = "application";
    private static final String MEASURE_CACHE_CREATE_MIST_ITEMS = "cacheCreateMistItems";
    private static final String MEASURE_CACHE_DAY = "cacheDay";
    private static final String MEASURE_CACHE_DURATION = "cacheDuration";
    private static final String MEASURE_CACHE_HOUR = "cacheHour";
    private static final String MEASURE_CACHE_LOAD_MIST_TEMPLATES = "cacheLoadMistTemplates";
    private static final String MEASURE_CACHE_MILLISECOND = "cacheMillisecond";
    private static final String MEASURE_CACHE_MINUTE = "cacheMinute";
    private static final String MEASURE_CACHE_SECOND = "cacheSecond";
    private static final String MEASURE_DAG = "dag";
    private static final String MEASURE_DEVICE_SCORE = "deviceScore";
    private static final String MEASURE_LAUNCH_DURATION = "launchDuration";
    private static final String MEASURE_M_A_C = "mAC";
    private static final String MEASURE_M_A_HEAD = "mAHead";
    private static final String MEASURE_M_A_TAIL = "mATail";
    private static final String MEASURE_M_FRONT = "mFront";
    private static final String MEASURE_M_LAUNCH = "mLaunch";
    private static final String MEASURE_PRE_ADDRESS = "preAddress";
    private static final String MEASURE_PRE_REQUEST = "preRequest";
    private static final String MEASURE_RENDER_COMPLETE = "renderComplete";
    private static final String MEASURE_TO_HOME = "toHome";
    private static final String MEASURE_USE_CACHE = "useCache";
    private static final String MEASURE_USE_PRESET_DATA = "usePresetData";
    private static final String MODULE_NAME = "LaunchModule";
    private static final String POINT = "ExternalLinkHome";
    private String apmEvents;
    private String apmProperties;
    private String apmStages;
    private String apmStats;
    private double application;
    private String bizEvent;
    private String bizTime;
    private double cacheCreateMistItems;
    private double cacheDay;
    private double cacheDuration;
    private double cacheHour;
    private double cacheLoadMistTemplates;
    private double cacheMillisecond;
    private double cacheMinute;
    private double cacheSecond;
    private double dag;
    private float deviceScore;
    private ExternalLinkHomeRealTime externalLinkHomeRealTime;
    private String externalLinkUrl;
    private String firstInstall;
    private String firstLaunch;
    private Gson gson;
    public boolean isAd;
    private double launchDuration;
    private String launchType;
    private double mAC;
    private double mAHead;
    private double mATail;
    private double mFront;
    private double mLaunch;
    private double preAddress;
    private double preRequest;
    private double renderComplete;
    private double toHome;
    private double useCache;
    private double usePresetData;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class IoDHHolder {
        private static final ExternalLinkHomeMonitor instance = new ExternalLinkHomeMonitor();
    }

    private String apmEvents() {
        String processApmEvents = Apm.processApmEvents(this.gson, this.externalLinkHomeRealTime.getApmEvents());
        this.apmEvents = processApmEvents;
        return processApmEvents;
    }

    private String apmProperties() {
        String processApmProperties = Apm.processApmProperties(this.gson, this.externalLinkHomeRealTime.getApmProperties());
        this.apmProperties = processApmProperties;
        return processApmProperties;
    }

    private String apmStages() {
        String processApmStages = Apm.processApmStages(this.gson, this.externalLinkHomeRealTime.getApmStages());
        this.apmStages = processApmStages;
        return processApmStages;
    }

    private String apmStats() {
        String processApmStats = Apm.processApmStats(this.gson, this.externalLinkHomeRealTime.getApmStats());
        this.apmStats = processApmStats;
        return processApmStats;
    }

    private double application() {
        double decimalPlaces = Value.decimalPlaces(6, Math.abs(this.externalLinkHomeRealTime.getApplicationAttach() - this.externalLinkHomeRealTime.getApplicationEnd()));
        this.application = decimalPlaces;
        return decimalPlaces;
    }

    private String bizEvent() {
        checkGson();
        Type type = new TypeToken<HashMap<String, String>>() { // from class: me.ele.altriax.launcher.real.time.data.monitor.ExternalLinkHomeMonitor.2
        }.getType();
        try {
            this.bizEvent = this.gson.toJson(this.externalLinkHomeRealTime.getBizEventMap(), type);
        } catch (Throwable unused) {
            this.bizEvent = "";
        }
        return this.bizEvent;
    }

    private String bizTime() {
        checkGson();
        Type type = new TypeToken<HashMap<String, Long>>() { // from class: me.ele.altriax.launcher.real.time.data.monitor.ExternalLinkHomeMonitor.1
        }.getType();
        try {
            this.bizTime = this.gson.toJson(this.externalLinkHomeRealTime.getBizTimeMap(), type);
        } catch (Throwable unused) {
            this.bizTime = "";
        }
        return this.bizTime;
    }

    private double cacheCreateMistItems() {
        double decimalPlaces = Value.decimalPlaces(6, Math.abs(this.externalLinkHomeRealTime.getCacheCreateMistItemsEnd() - this.externalLinkHomeRealTime.getCacheCreateMistItemsStart()));
        this.cacheCreateMistItems = decimalPlaces;
        return decimalPlaces;
    }

    private double cacheDay() {
        double decimalPlaces = Value.decimalPlaces(6, this.externalLinkHomeRealTime.getCacheDay());
        this.cacheDay = decimalPlaces;
        return decimalPlaces;
    }

    private double cacheDuration() {
        double decimalPlaces = Value.decimalPlaces(6, this.externalLinkHomeRealTime.getCacheDuration());
        this.cacheDuration = decimalPlaces;
        return decimalPlaces;
    }

    private double cacheHour() {
        double decimalPlaces = Value.decimalPlaces(6, this.externalLinkHomeRealTime.getCacheHour());
        this.cacheHour = decimalPlaces;
        return decimalPlaces;
    }

    private double cacheLoadMistTemplates() {
        double decimalPlaces = Value.decimalPlaces(6, Math.abs(this.externalLinkHomeRealTime.getCacheLoadMistTemplatesEnd() - this.externalLinkHomeRealTime.getCacheLoadMistTemplatesStart()));
        this.cacheLoadMistTemplates = decimalPlaces;
        return decimalPlaces;
    }

    private double cacheMillisecond() {
        double decimalPlaces = Value.decimalPlaces(6, this.externalLinkHomeRealTime.getCacheMillisecond());
        this.cacheMillisecond = decimalPlaces;
        return decimalPlaces;
    }

    private double cacheMinute() {
        double decimalPlaces = Value.decimalPlaces(6, this.externalLinkHomeRealTime.getCacheMinute());
        this.cacheMinute = decimalPlaces;
        return decimalPlaces;
    }

    private double cacheSecond() {
        double decimalPlaces = Value.decimalPlaces(6, this.externalLinkHomeRealTime.getCacheSecond());
        this.cacheSecond = decimalPlaces;
        return decimalPlaces;
    }

    private void checkGson() {
        if (this.gson == null) {
            this.gson = new Gson();
        }
    }

    private double dag() {
        double decimalPlaces = Value.decimalPlaces(6, Math.abs(this.externalLinkHomeRealTime.getDagEnd() - this.externalLinkHomeRealTime.getDagStart()));
        this.dag = decimalPlaces;
        return decimalPlaces;
    }

    private String externalLinkUrl() {
        String externalLinkUrl = this.externalLinkHomeRealTime.getExternalLinkUrl();
        this.externalLinkUrl = externalLinkUrl;
        return externalLinkUrl;
    }

    private String firstInstall() {
        String valueOf = String.valueOf(this.externalLinkHomeRealTime.isFirstInstall());
        this.firstInstall = valueOf;
        return valueOf;
    }

    private String firstLaunch() {
        String valueOf = String.valueOf(this.externalLinkHomeRealTime.isFirstLaunch());
        this.firstLaunch = valueOf;
        return valueOf;
    }

    public static DimensionSet getDimensionSet() {
        DimensionSet create = DimensionSet.create();
        create.addDimension("ad");
        create.addDimension(DIMENSION_DEVICE_LEVEL);
        create.addDimension(DIMENSION_BIZ_TIME);
        create.addDimension(DIMENSION_BIZ_EVENT);
        create.addDimension(DIMENSION_EXTERNAL_LINK_URL);
        create.addDimension(DIMENSION_FIRST_INSTALL);
        create.addDimension(DIMENSION_FIRST_LAUNCH);
        create.addDimension(DIMENSION_APM_PROPERTIES);
        create.addDimension(DIMENSION_APM_STATS);
        create.addDimension(DIMENSION_APM_EVENTS);
        create.addDimension(DIMENSION_APM_STAGES);
        create.addDimension(DIMENSION_LAUNCH_TYPE);
        return create;
    }

    public static ExternalLinkHomeMonitor getInstance() {
        return IoDHHolder.instance;
    }

    public static MeasureSet getMeasureSet() {
        MeasureSet create = MeasureSet.create();
        create.addMeasure(MEASURE_APPLICATION);
        create.addMeasure(MEASURE_DAG);
        create.addMeasure(MEASURE_M_FRONT);
        create.addMeasure(MEASURE_M_LAUNCH);
        create.addMeasure(MEASURE_M_A_HEAD);
        create.addMeasure(MEASURE_M_A_TAIL);
        create.addMeasure(MEASURE_M_A_C);
        create.addMeasure(MEASURE_TO_HOME);
        create.addMeasure(MEASURE_RENDER_COMPLETE);
        create.addMeasure(MEASURE_USE_CACHE);
        create.addMeasure(MEASURE_USE_PRESET_DATA);
        create.addMeasure(MEASURE_CACHE_DURATION);
        create.addMeasure(MEASURE_CACHE_DAY);
        create.addMeasure(MEASURE_CACHE_HOUR);
        create.addMeasure(MEASURE_CACHE_MINUTE);
        create.addMeasure(MEASURE_CACHE_SECOND);
        create.addMeasure(MEASURE_CACHE_MILLISECOND);
        create.addMeasure(MEASURE_PRE_ADDRESS);
        create.addMeasure(MEASURE_PRE_REQUEST);
        create.addMeasure(MEASURE_CACHE_LOAD_MIST_TEMPLATES);
        create.addMeasure(MEASURE_CACHE_CREATE_MIST_ITEMS);
        create.addMeasure(MEASURE_LAUNCH_DURATION);
        return create;
    }

    private double launchDuration() {
        double decimalPlaces = Value.decimalPlaces(6, this.externalLinkHomeRealTime.getLaunchDuration());
        this.launchDuration = decimalPlaces;
        return decimalPlaces;
    }

    private String launchType() {
        String launchType = this.externalLinkHomeRealTime.getLaunchType();
        this.launchType = launchType;
        return launchType;
    }

    private double mAC() {
        double abs = Math.abs(this.externalLinkHomeRealTime.getmAC());
        this.mAC = abs;
        return abs;
    }

    private double mAHead() {
        double abs = Math.abs(this.externalLinkHomeRealTime.getmAHead());
        this.mAHead = abs;
        return abs;
    }

    private double mATail() {
        double abs = Math.abs(this.externalLinkHomeRealTime.getmATail());
        this.mATail = abs;
        return abs;
    }

    private double mFront() {
        double abs = Math.abs(this.externalLinkHomeRealTime.getmFront());
        this.mFront = abs;
        return abs;
    }

    private double mLaunch() {
        double abs = Math.abs(this.externalLinkHomeRealTime.getmLaunch());
        this.mLaunch = abs;
        return abs;
    }

    private double preAddress() {
        double decimalPlaces = Value.decimalPlaces(6, Math.abs(this.externalLinkHomeRealTime.getPreAddressEnd() - this.externalLinkHomeRealTime.getPreAddressStart()));
        this.preAddress = decimalPlaces;
        return decimalPlaces;
    }

    private double preRequest() {
        double decimalPlaces = Value.decimalPlaces(6, Math.abs(this.externalLinkHomeRealTime.getPreRequestEnd() - this.externalLinkHomeRealTime.getPreRequestStart()));
        this.preRequest = decimalPlaces;
        return decimalPlaces;
    }

    public static void registerExternalLink() {
        AppMonitor.register(MODULE_NAME, POINT, getMeasureSet(), getDimensionSet());
    }

    private double renderComplete() {
        double decimalPlaces = Value.decimalPlaces(6, Math.abs(this.externalLinkHomeRealTime.getRenderComplete() - this.externalLinkHomeRealTime.getHomeStart()));
        this.renderComplete = decimalPlaces;
        return decimalPlaces;
    }

    private double toHome() {
        double decimalPlaces = Value.decimalPlaces(6, Math.abs(this.externalLinkHomeRealTime.getHomeStart() - this.externalLinkHomeRealTime.getApplicationEnd()));
        this.toHome = decimalPlaces;
        return decimalPlaces;
    }

    private double useCache() {
        double d = this.externalLinkHomeRealTime.isUseCache() ? 1.0d : 0.0d;
        this.useCache = d;
        return d;
    }

    private double usePresetData() {
        double d = this.externalLinkHomeRealTime.isUsePresetData() ? 1.0d : 0.0d;
        this.usePresetData = d;
        return d;
    }

    public Pair<DimensionValueSet, MeasureValueSet> getDimensionAndMeasure() {
        String switchDeviceValue = Device.switchDeviceValue(n4.a());
        this.deviceScore = n4.getDeviceScore();
        String str = this.isAd ? DIMENSION_VALUE_IS_AD : DIMENSION_VALUE_NO_AD;
        String externalLinkUrl = externalLinkUrl();
        String firstInstall = firstInstall();
        String firstLaunch = firstLaunch();
        String launchType = launchType();
        DimensionValueSet value = DimensionValueSet.create().setValue("ad", str).setValue(DIMENSION_DEVICE_LEVEL, switchDeviceValue).setValue(DIMENSION_EXTERNAL_LINK_URL, externalLinkUrl).setValue(DIMENSION_BIZ_TIME, bizTime()).setValue(DIMENSION_BIZ_EVENT, bizEvent()).setValue(DIMENSION_FIRST_INSTALL, firstInstall).setValue(DIMENSION_FIRST_LAUNCH, firstLaunch).setValue(DIMENSION_APM_PROPERTIES, apmProperties()).setValue(DIMENSION_APM_STATS, apmStats()).setValue(DIMENSION_APM_EVENTS, apmEvents()).setValue(DIMENSION_APM_STAGES, apmStages()).setValue(DIMENSION_LAUNCH_TYPE, launchType);
        addData("ad", str);
        addData(DIMENSION_DEVICE_LEVEL, switchDeviceValue);
        addData(DIMENSION_EXTERNAL_LINK_URL, externalLinkUrl);
        for (Map.Entry<String, Long> entry : this.externalLinkHomeRealTime.getBizTimeMap().entrySet()) {
            String key = entry.getKey();
            Long value2 = entry.getValue();
            if (!TextUtils.isEmpty(key) && value2 != null) {
                addData(key, (String) value2);
            }
        }
        for (Map.Entry<String, String> entry2 : this.externalLinkHomeRealTime.getBizEventMap().entrySet()) {
            String key2 = entry2.getKey();
            String value3 = entry2.getValue();
            if (!TextUtils.isEmpty(key2) && value3 != null) {
                addData(key2, value3);
            }
        }
        addData(DIMENSION_FIRST_INSTALL, firstInstall);
        addData(DIMENSION_FIRST_LAUNCH, firstLaunch);
        addData(DIMENSION_LAUNCH_TYPE, launchType);
        double application = application();
        double dag = dag();
        double mFront = mFront();
        double mLaunch = mLaunch();
        double mAHead = mAHead();
        double mATail = mATail();
        double mAC = mAC();
        double home = toHome();
        double renderComplete = renderComplete();
        double useCache = useCache();
        double usePresetData = usePresetData();
        double launchDuration = launchDuration();
        double cacheDay = cacheDay();
        double cacheHour = cacheHour();
        double cacheMinute = cacheMinute();
        double cacheSecond = cacheSecond();
        double cacheMillisecond = cacheMillisecond();
        double preAddress = preAddress();
        double preRequest = preRequest();
        double cacheLoadMistTemplates = cacheLoadMistTemplates();
        double cacheCreateMistItems = cacheCreateMistItems();
        double d = this.deviceScore;
        MeasureValueSet value4 = MeasureValueSet.create().setValue(MEASURE_APPLICATION, application).setValue(MEASURE_DAG, dag).setValue(MEASURE_M_FRONT, mFront).setValue(MEASURE_M_LAUNCH, mLaunch).setValue(MEASURE_M_A_HEAD, mAHead).setValue(MEASURE_M_A_TAIL, mATail).setValue(MEASURE_M_A_C, mAC).setValue(MEASURE_TO_HOME, home).setValue(MEASURE_RENDER_COMPLETE, renderComplete).setValue(MEASURE_USE_CACHE, useCache).setValue(MEASURE_USE_PRESET_DATA, usePresetData).setValue(MEASURE_LAUNCH_DURATION, launchDuration).setValue(MEASURE_CACHE_DAY, cacheDay).setValue(MEASURE_CACHE_HOUR, cacheHour).setValue(MEASURE_CACHE_MINUTE, cacheMinute).setValue(MEASURE_CACHE_SECOND, cacheSecond).setValue(MEASURE_CACHE_MILLISECOND, cacheMillisecond).setValue(MEASURE_PRE_ADDRESS, preAddress).setValue(MEASURE_PRE_REQUEST, preRequest).setValue(MEASURE_CACHE_LOAD_MIST_TEMPLATES, cacheLoadMistTemplates).setValue(MEASURE_CACHE_CREATE_MIST_ITEMS, cacheCreateMistItems).setValue("deviceScore", d);
        addData(MEASURE_APPLICATION, (String) Double.valueOf(application));
        addData(MEASURE_DAG, (String) Double.valueOf(dag));
        addData(MEASURE_M_FRONT, (String) Double.valueOf(mFront));
        addData(MEASURE_M_LAUNCH, (String) Double.valueOf(mLaunch));
        addData(MEASURE_M_A_HEAD, (String) Double.valueOf(mAHead));
        addData(MEASURE_M_A_TAIL, (String) Double.valueOf(mATail));
        addData(MEASURE_M_A_C, (String) Double.valueOf(mAC));
        addData(MEASURE_TO_HOME, (String) Double.valueOf(home));
        addData(MEASURE_RENDER_COMPLETE, (String) Double.valueOf(renderComplete));
        addData(MEASURE_USE_CACHE, (String) Double.valueOf(useCache));
        addData(MEASURE_USE_PRESET_DATA, (String) Double.valueOf(usePresetData));
        addData(MEASURE_LAUNCH_DURATION, (String) Double.valueOf(launchDuration));
        addData(MEASURE_CACHE_DAY, (String) Double.valueOf(cacheDay));
        addData(MEASURE_CACHE_HOUR, (String) Double.valueOf(cacheHour));
        addData(MEASURE_CACHE_MINUTE, (String) Double.valueOf(cacheMinute));
        addData(MEASURE_CACHE_SECOND, (String) Double.valueOf(cacheSecond));
        addData(MEASURE_CACHE_MILLISECOND, (String) Double.valueOf(cacheMillisecond));
        addData(MEASURE_PRE_ADDRESS, (String) Double.valueOf(preAddress));
        addData(MEASURE_PRE_REQUEST, (String) Double.valueOf(preRequest));
        addData(MEASURE_CACHE_LOAD_MIST_TEMPLATES, (String) Double.valueOf(cacheLoadMistTemplates));
        addData(MEASURE_CACHE_CREATE_MIST_ITEMS, (String) Double.valueOf(cacheCreateMistItems));
        addData("deviceScore", (String) Double.valueOf(d));
        return Pair.create(value, value4);
    }

    public void innerReport() {
        ExternalLinkHomeRealTime externalLinkHomeRealTime = this.externalLinkHomeRealTime;
        if (externalLinkHomeRealTime == null || externalLinkHomeRealTime.getRenderComplete() <= 0) {
            return;
        }
        Pair<DimensionValueSet, MeasureValueSet> dimensionAndMeasure = getDimensionAndMeasure();
        log(null);
        dataHubPublish();
        AppMonitor.Stat.commit(MODULE_NAME, POINT, (DimensionValueSet) dimensionAndMeasure.first, (MeasureValueSet) dimensionAndMeasure.second);
    }

    public void log(@Nullable String str) {
        MonitorLog.elegantLogJoin("", "");
        if (!TextUtils.isEmpty(str)) {
            MonitorLog.elegantLogJoin(str, "");
        }
        MonitorLog.elegantLogJoin("externalLink home report", "");
        MonitorLog.elegantLogJoin(DIMENSION_EXTERNAL_LINK_URL, String.valueOf(this.externalLinkUrl));
        MonitorLog.elegantLogJoin(MEASURE_APPLICATION, String.valueOf(this.application));
        MonitorLog.elegantLogJoin(MEASURE_DAG, String.valueOf(this.dag));
        MonitorLog.elegantLogJoin(MEASURE_M_FRONT, String.valueOf(this.mFront));
        MonitorLog.elegantLogJoin(MEASURE_M_LAUNCH, String.valueOf(this.mLaunch));
        MonitorLog.elegantLogJoin(MEASURE_M_A_HEAD, String.valueOf(this.mAHead));
        MonitorLog.elegantLogJoin(MEASURE_M_A_TAIL, String.valueOf(this.mATail));
        MonitorLog.elegantLogJoin(MEASURE_M_A_C, String.valueOf(this.mAC));
        MonitorLog.elegantLogJoin(MEASURE_TO_HOME, String.valueOf(this.toHome));
        MonitorLog.elegantLogJoin(MEASURE_RENDER_COMPLETE, String.valueOf(this.renderComplete));
        MonitorLog.elegantLogJoin(MEASURE_LAUNCH_DURATION, String.valueOf(this.launchDuration));
        MonitorLog.elegantLogJoin(MEASURE_USE_CACHE, String.valueOf(this.useCache));
        MonitorLog.elegantLogJoin(MEASURE_USE_PRESET_DATA, String.valueOf(this.usePresetData));
        MonitorLog.elegantLogJoin(MEASURE_CACHE_MILLISECOND, String.valueOf(this.cacheMillisecond));
        MonitorLog.elegantLogJoin(MEASURE_CACHE_SECOND, String.valueOf(this.cacheSecond));
        MonitorLog.elegantLogJoin(MEASURE_CACHE_MINUTE, String.valueOf(this.cacheMinute));
        MonitorLog.elegantLogJoin(MEASURE_CACHE_HOUR, String.valueOf(this.cacheHour));
        MonitorLog.elegantLogJoin(MEASURE_CACHE_DAY, String.valueOf(this.cacheDay));
        MonitorLog.elegantLogJoin(MEASURE_PRE_ADDRESS, String.valueOf(this.preAddress));
        MonitorLog.elegantLogJoin(MEASURE_PRE_REQUEST, String.valueOf(this.preRequest));
        MonitorLog.elegantLogJoin(MEASURE_CACHE_LOAD_MIST_TEMPLATES, String.valueOf(this.cacheDay));
        MonitorLog.elegantLogJoin(MEASURE_CACHE_CREATE_MIST_ITEMS, String.valueOf(this.cacheCreateMistItems));
        MonitorLog.elegantLogJoin("deviceScore", String.valueOf(this.deviceScore));
        MonitorLog.elegantLogJoin(DIMENSION_LAUNCH_TYPE, String.valueOf(this.launchType));
        MonitorLog.elegantLogJoin(DIMENSION_FIRST_INSTALL, String.valueOf(this.firstInstall));
        MonitorLog.elegantLogJoin(DIMENSION_FIRST_LAUNCH, String.valueOf(this.firstLaunch));
        MonitorLog.elegantLogJoin(DIMENSION_BIZ_TIME, String.valueOf(this.bizTime));
        MonitorLog.elegantLogJoin(DIMENSION_BIZ_EVENT, String.valueOf(this.bizEvent));
        MonitorLog.elegantLogJoin(DIMENSION_APM_PROPERTIES, String.valueOf(this.apmProperties));
        MonitorLog.elegantLogJoin(DIMENSION_APM_STATS, String.valueOf(this.apmStats));
        MonitorLog.elegantLogJoin(DIMENSION_APM_STAGES, String.valueOf(this.apmStages));
        MonitorLog.elegantLogJoin(DIMENSION_APM_EVENTS, String.valueOf(this.apmEvents));
        if (!TextUtils.isEmpty(str)) {
            MonitorLog.elegantLogJoin("", "");
        }
        MonitorLog.elegantLogLaunch();
    }

    public void report() {
        this.externalLinkHomeRealTime = ExternalLinkHomeRealTime.getInstance();
        registerExternalLink();
        innerReport();
    }

    public void setGson(@NonNull Gson gson) {
        this.gson = gson;
    }

    private ExternalLinkHomeMonitor() {
        this.isAd = false;
        this.application = 0.0d;
        this.dag = 0.0d;
        this.mFront = 0.0d;
        this.mLaunch = 0.0d;
        this.mAHead = 0.0d;
        this.mATail = 0.0d;
        this.mAC = 0.0d;
        this.toHome = 0.0d;
        this.renderComplete = 0.0d;
        this.useCache = 0.0d;
        this.usePresetData = 0.0d;
        this.cacheDay = 0.0d;
        this.cacheHour = 0.0d;
        this.cacheMinute = 0.0d;
        this.cacheSecond = 0.0d;
        this.cacheMillisecond = 0.0d;
        this.preAddress = 0.0d;
        this.preRequest = 0.0d;
        this.cacheLoadMistTemplates = 0.0d;
        this.cacheCreateMistItems = 0.0d;
        this.launchDuration = 0.0d;
        this.cacheDuration = 0.0d;
        this.deviceScore = 0.0f;
    }
}
