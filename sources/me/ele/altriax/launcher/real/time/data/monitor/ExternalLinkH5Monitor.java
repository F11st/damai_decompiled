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
import me.ele.altriax.launcher.real.time.data.ExternalLinkH5RealTime;
import me.ele.altriax.launcher.real.time.data.utils.Apm;
import me.ele.altriax.launcher.real.time.data.utils.Device;
import me.ele.altriax.launcher.real.time.data.utils.MonitorLog;
import me.ele.altriax.launcher.real.time.data.utils.Value;
import tb.n4;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ExternalLinkH5Monitor extends BaseMonitor {
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
    private static final String MEASURE_DAG = "dag";
    private static final String MEASURE_DEVICE_SCORE = "deviceScore";
    private static final String MEASURE_LAUNCH_DURATION = "launchDuration";
    private static final String MEASURE_M_A_C = "mAC";
    private static final String MEASURE_M_A_HEAD = "mAHead";
    private static final String MEASURE_M_A_TAIL = "mATail";
    private static final String MEASURE_M_FRONT = "mFront";
    private static final String MEASURE_M_LAUNCH = "mLaunch";
    private static final String MEASURE_RENDER_COMPLETE = "renderComplete";
    private static final String MEASURE_TO_H5_ACTIVITY = "toH5Activity";
    private static final String MEASURE_TO_HOME = "toHome";
    private static final String MODULE_NAME = "LaunchModule";
    private static final String POINT_EXTERNAL_LINK = "ExternalLink";
    private String apmEvents;
    private String apmProperties;
    private String apmStages;
    private String apmStats;
    private double application;
    private String bizEvent;
    private String bizTime;
    private double dag;
    private float deviceScore;
    private ExternalLinkH5RealTime externalLinkH5RealTime;
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
    private double renderComplete;
    private double toH5Activity;
    private double toHome;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class IoDHHolder {
        private static final ExternalLinkH5Monitor instance = new ExternalLinkH5Monitor();
    }

    private String apmEvents() {
        String processApmEvents = Apm.processApmEvents(this.gson, this.externalLinkH5RealTime.getApmEvents());
        this.apmEvents = processApmEvents;
        return processApmEvents;
    }

    private String apmProperties() {
        String processApmProperties = Apm.processApmProperties(this.gson, this.externalLinkH5RealTime.getApmProperties());
        this.apmProperties = processApmProperties;
        return processApmProperties;
    }

    private String apmStages() {
        String processApmStages = Apm.processApmStages(this.gson, this.externalLinkH5RealTime.getApmStages());
        this.apmStages = processApmStages;
        return processApmStages;
    }

    private String apmStats() {
        String processApmStats = Apm.processApmStats(this.gson, this.externalLinkH5RealTime.getApmStats());
        this.apmStats = processApmStats;
        return processApmStats;
    }

    private double application() {
        double abs = Math.abs(this.externalLinkH5RealTime.getApplicationAttach() - this.externalLinkH5RealTime.getApplicationEnd());
        this.application = abs;
        return abs;
    }

    private String bizEvent() {
        checkGson();
        Type type = new TypeToken<HashMap<String, String>>() { // from class: me.ele.altriax.launcher.real.time.data.monitor.ExternalLinkH5Monitor.2
        }.getType();
        try {
            this.bizEvent = this.gson.toJson(this.externalLinkH5RealTime.getBizEventMap(), type);
        } catch (Throwable unused) {
            this.bizEvent = "";
        }
        return this.bizEvent;
    }

    private String bizTime() {
        checkGson();
        Type type = new TypeToken<HashMap<String, Long>>() { // from class: me.ele.altriax.launcher.real.time.data.monitor.ExternalLinkH5Monitor.1
        }.getType();
        try {
            this.bizTime = this.gson.toJson(this.externalLinkH5RealTime.getBizTimeMap(), type);
        } catch (Throwable unused) {
            this.bizTime = "";
        }
        return this.bizTime;
    }

    private void checkGson() {
        if (this.gson == null) {
            this.gson = new Gson();
        }
    }

    private double dag() {
        double decimalPlaces = Value.decimalPlaces(6, Math.abs(this.externalLinkH5RealTime.getDagEnd() - this.externalLinkH5RealTime.getDagStart()));
        this.dag = decimalPlaces;
        return decimalPlaces;
    }

    private String externalLinkUrl() {
        String externalLinkUrl = this.externalLinkH5RealTime.getExternalLinkUrl();
        this.externalLinkUrl = externalLinkUrl;
        return externalLinkUrl;
    }

    private String firstInstall() {
        String valueOf = String.valueOf(this.externalLinkH5RealTime.isFirstInstall());
        this.firstInstall = valueOf;
        return valueOf;
    }

    private String firstLaunch() {
        String valueOf = String.valueOf(this.externalLinkH5RealTime.isFirstLaunch());
        this.firstLaunch = valueOf;
        return valueOf;
    }

    public static DimensionSet getDimensionSet() {
        DimensionSet create = DimensionSet.create();
        create.addDimension("ad");
        create.addDimension(DIMENSION_DEVICE_LEVEL);
        create.addDimension(DIMENSION_EXTERNAL_LINK_URL);
        create.addDimension(DIMENSION_BIZ_TIME);
        create.addDimension(DIMENSION_BIZ_EVENT);
        create.addDimension(DIMENSION_FIRST_INSTALL);
        create.addDimension(DIMENSION_FIRST_LAUNCH);
        create.addDimension(DIMENSION_APM_PROPERTIES);
        create.addDimension(DIMENSION_APM_STATS);
        create.addDimension(DIMENSION_APM_EVENTS);
        create.addDimension(DIMENSION_APM_STAGES);
        create.addDimension(DIMENSION_LAUNCH_TYPE);
        return create;
    }

    public static ExternalLinkH5Monitor getInstance() {
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
        create.addMeasure(MEASURE_TO_H5_ACTIVITY);
        create.addMeasure(MEASURE_RENDER_COMPLETE);
        create.addMeasure("deviceScore");
        create.addMeasure(MEASURE_LAUNCH_DURATION);
        return create;
    }

    private double launchDuration() {
        double decimalPlaces = Value.decimalPlaces(6, this.externalLinkH5RealTime.getLaunchDuration());
        this.launchDuration = decimalPlaces;
        return decimalPlaces;
    }

    private String launchType() {
        String launchType = this.externalLinkH5RealTime.getLaunchType();
        this.launchType = launchType;
        return launchType;
    }

    private double mAC() {
        double abs = Math.abs(this.externalLinkH5RealTime.getmAC());
        this.mAC = abs;
        return abs;
    }

    private double mAHead() {
        double abs = Math.abs(this.externalLinkH5RealTime.getmAHead());
        this.mAHead = abs;
        return abs;
    }

    private double mATail() {
        double abs = Math.abs(this.externalLinkH5RealTime.getmATail());
        this.mATail = abs;
        return abs;
    }

    private double mFront() {
        double abs = Math.abs(this.externalLinkH5RealTime.getmFront());
        this.mFront = abs;
        return abs;
    }

    private double mLaunch() {
        double abs = Math.abs(this.externalLinkH5RealTime.getmLaunch());
        this.mLaunch = abs;
        return abs;
    }

    public static void registerExternalLink() {
        AppMonitor.register(MODULE_NAME, POINT_EXTERNAL_LINK, getMeasureSet(), getDimensionSet());
    }

    private double renderComplete() {
        double abs = Math.abs(this.externalLinkH5RealTime.getRenderComplete() - this.externalLinkH5RealTime.getH5ActivityStart());
        this.renderComplete = abs;
        return abs;
    }

    private double toH5Activity() {
        double abs = Math.abs(this.externalLinkH5RealTime.getH5ActivityStart() - this.externalLinkH5RealTime.getHomeStart());
        this.toH5Activity = abs;
        return abs;
    }

    private double toHome() {
        double abs = Math.abs(this.externalLinkH5RealTime.getHomeStart() - this.externalLinkH5RealTime.getApplicationEnd());
        this.toHome = abs;
        return abs;
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
        for (Map.Entry<String, Long> entry : this.externalLinkH5RealTime.getBizTimeMap().entrySet()) {
            String key = entry.getKey();
            Long value2 = entry.getValue();
            if (!TextUtils.isEmpty(key) && value2 != null) {
                addData(key, (String) value2);
            }
        }
        for (Map.Entry<String, String> entry2 : this.externalLinkH5RealTime.getBizEventMap().entrySet()) {
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
        double h5Activity = toH5Activity();
        double renderComplete = renderComplete();
        double launchDuration = launchDuration();
        double d = this.deviceScore;
        MeasureValueSet value4 = MeasureValueSet.create().setValue(MEASURE_APPLICATION, application).setValue(MEASURE_DAG, dag).setValue(MEASURE_M_FRONT, mFront).setValue(MEASURE_M_LAUNCH, mLaunch).setValue(MEASURE_M_A_HEAD, mAHead).setValue(MEASURE_M_A_TAIL, mATail).setValue(MEASURE_M_A_C, mAC).setValue(MEASURE_TO_HOME, home).setValue(MEASURE_TO_H5_ACTIVITY, h5Activity).setValue(MEASURE_RENDER_COMPLETE, renderComplete).setValue(MEASURE_LAUNCH_DURATION, launchDuration).setValue("deviceScore", d);
        addData(MEASURE_APPLICATION, (String) Double.valueOf(application));
        addData(MEASURE_DAG, (String) Double.valueOf(dag));
        addData(MEASURE_M_FRONT, (String) Double.valueOf(mFront));
        addData(MEASURE_M_LAUNCH, (String) Double.valueOf(mLaunch));
        addData(MEASURE_M_A_HEAD, (String) Double.valueOf(mAHead));
        addData(MEASURE_M_A_TAIL, (String) Double.valueOf(mATail));
        addData(MEASURE_M_A_C, (String) Double.valueOf(mAC));
        addData(MEASURE_TO_HOME, (String) Double.valueOf(home));
        addData(MEASURE_TO_H5_ACTIVITY, (String) Double.valueOf(h5Activity));
        addData(MEASURE_RENDER_COMPLETE, (String) Double.valueOf(renderComplete));
        addData(MEASURE_LAUNCH_DURATION, (String) Double.valueOf(launchDuration));
        addData("deviceScore", (String) Double.valueOf(d));
        return Pair.create(value, value4);
    }

    public void innerReport() {
        ExternalLinkH5RealTime externalLinkH5RealTime = this.externalLinkH5RealTime;
        if (externalLinkH5RealTime == null || externalLinkH5RealTime.getRenderComplete() <= 0) {
            return;
        }
        Pair<DimensionValueSet, MeasureValueSet> dimensionAndMeasure = getDimensionAndMeasure();
        log(null);
        dataHubPublish();
        AppMonitor.Stat.commit(MODULE_NAME, POINT_EXTERNAL_LINK, (DimensionValueSet) dimensionAndMeasure.first, (MeasureValueSet) dimensionAndMeasure.second);
    }

    public void log(@Nullable String str) {
        MonitorLog.elegantLogJoin("", "");
        if (!TextUtils.isEmpty(str)) {
            MonitorLog.elegantLogJoin(str, "");
        }
        MonitorLog.elegantLogJoin("externalLink h5 report", "");
        MonitorLog.elegantLogJoin(DIMENSION_EXTERNAL_LINK_URL, String.valueOf(this.externalLinkUrl));
        MonitorLog.elegantLogJoin(MEASURE_APPLICATION, String.valueOf(this.application));
        MonitorLog.elegantLogJoin(MEASURE_DAG, String.valueOf(this.dag));
        MonitorLog.elegantLogJoin(MEASURE_M_FRONT, String.valueOf(this.mFront));
        MonitorLog.elegantLogJoin(MEASURE_M_LAUNCH, String.valueOf(this.mLaunch));
        MonitorLog.elegantLogJoin(MEASURE_M_A_HEAD, String.valueOf(this.mAHead));
        MonitorLog.elegantLogJoin(MEASURE_M_A_TAIL, String.valueOf(this.mATail));
        MonitorLog.elegantLogJoin(MEASURE_M_A_C, String.valueOf(this.mAC));
        MonitorLog.elegantLogJoin(MEASURE_TO_HOME, String.valueOf(this.toHome));
        MonitorLog.elegantLogJoin(MEASURE_TO_H5_ACTIVITY, String.valueOf(this.toH5Activity));
        MonitorLog.elegantLogJoin(MEASURE_RENDER_COMPLETE, String.valueOf(this.renderComplete));
        MonitorLog.elegantLogJoin(MEASURE_LAUNCH_DURATION, String.valueOf(this.launchDuration));
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
        MonitorLog.elegantLogJoin("", "");
        if (!TextUtils.isEmpty(str)) {
            MonitorLog.elegantLogJoin("", "");
        }
        MonitorLog.elegantLogLaunch();
    }

    public void report() {
        this.externalLinkH5RealTime = ExternalLinkH5RealTime.getInstance();
        registerExternalLink();
        innerReport();
    }

    public void setAd(boolean z) {
        this.isAd = z;
    }

    public void setGson(@NonNull Gson gson) {
        this.gson = gson;
    }

    private ExternalLinkH5Monitor() {
        this.isAd = false;
        this.application = 0.0d;
        this.dag = 0.0d;
        this.mFront = 0.0d;
        this.mLaunch = 0.0d;
        this.mAHead = 0.0d;
        this.mATail = 0.0d;
        this.mAC = 0.0d;
        this.toHome = 0.0d;
        this.toH5Activity = 0.0d;
        this.renderComplete = 0.0d;
        this.launchDuration = 0.0d;
        this.deviceScore = 0.0f;
    }
}
