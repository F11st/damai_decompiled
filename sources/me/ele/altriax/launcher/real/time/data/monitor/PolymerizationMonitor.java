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
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import me.ele.altriax.launcher.real.time.data.ColdLaunchRealTime;
import me.ele.altriax.launcher.real.time.data.ExternalLinkH5RealTime;
import me.ele.altriax.launcher.real.time.data.ExternalLinkHomeRealTime;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class PolymerizationMonitor {
    public static final String COLD = "cold";
    public static final String DIMENSION_LAUNCH_STYLE = "launchStyle";
    public static final String LINK_H5 = "linkH5";
    public static final String LINK_HOME = "linkHome";
    private static final String MODULE_NAME = "LaunchModule";
    private static final String POINT = "Cold";
    private static final String TAG = "PolymerizationMonitor";

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class IoDHHolder {
        private static final PolymerizationMonitor instance = new PolymerizationMonitor();
    }

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes11.dex */
    public @interface LaunchStyle {
    }

    public static PolymerizationMonitor getInstance() {
        return IoDHHolder.instance;
    }

    private void innerReport(@NonNull String str) {
        char c;
        Pair<DimensionValueSet, MeasureValueSet> dimensionAndMeasure;
        int hashCode = str.hashCode();
        if (hashCode == -1102667161) {
            if (str.equals(LINK_H5)) {
                c = 2;
            }
            c = 65535;
        } else if (hashCode != 3059428) {
            if (hashCode == 1193839609 && str.equals(LINK_HOME)) {
                c = 3;
            }
            c = 65535;
        } else {
            if (str.equals(COLD)) {
                c = 1;
            }
            c = 65535;
        }
        if (c == 2) {
            ExternalLinkH5RealTime externalLinkH5RealTime = ExternalLinkH5RealTime.getInstance();
            if (externalLinkH5RealTime == null || externalLinkH5RealTime.getPageFinished() <= 0) {
                return;
            }
            ExternalLinkH5Monitor externalLinkH5Monitor = ExternalLinkH5Monitor.getInstance();
            dimensionAndMeasure = externalLinkH5Monitor.getDimensionAndMeasure();
            externalLinkH5Monitor.log(TAG);
        } else if (c != 3) {
            ColdLaunchRealTime coldLaunchRealTime = ColdLaunchRealTime.getInstance();
            if (coldLaunchRealTime == null || coldLaunchRealTime.getRenderComplete() <= 0) {
                return;
            }
            ColdLaunchMonitor coldLaunchMonitor = ColdLaunchMonitor.getInstance();
            dimensionAndMeasure = coldLaunchMonitor.getDimensionAndMeasure();
            coldLaunchMonitor.log(TAG);
        } else {
            ExternalLinkHomeRealTime externalLinkHomeRealTime = ExternalLinkHomeRealTime.getInstance();
            if (externalLinkHomeRealTime == null || externalLinkHomeRealTime.getRenderComplete() <= 0) {
                return;
            }
            ExternalLinkHomeMonitor externalLinkHomeMonitor = ExternalLinkHomeMonitor.getInstance();
            dimensionAndMeasure = externalLinkHomeMonitor.getDimensionAndMeasure();
            externalLinkHomeMonitor.log(TAG);
        }
        DimensionValueSet dimensionValueSet = (DimensionValueSet) dimensionAndMeasure.first;
        dimensionValueSet.setValue(DIMENSION_LAUNCH_STYLE, str);
        AppMonitor.Stat.commit(MODULE_NAME, POINT, dimensionValueSet, (MeasureValueSet) dimensionAndMeasure.second);
    }

    private static void registerExternalLink(@NonNull String str) {
        char c;
        MeasureSet measureSet;
        DimensionSet dimensionSet;
        int hashCode = str.hashCode();
        if (hashCode == -1102667161) {
            if (str.equals(LINK_H5)) {
                c = 2;
            }
            c = 65535;
        } else if (hashCode != 3059428) {
            if (hashCode == 1193839609 && str.equals(LINK_HOME)) {
                c = 3;
            }
            c = 65535;
        } else {
            if (str.equals(COLD)) {
                c = 1;
            }
            c = 65535;
        }
        if (c == 2) {
            measureSet = ExternalLinkH5Monitor.getMeasureSet();
            dimensionSet = ExternalLinkH5Monitor.getDimensionSet();
        } else if (c != 3) {
            measureSet = ColdLaunchMonitor.getMeasureSet();
            dimensionSet = ColdLaunchMonitor.getDimensionSet();
        } else {
            measureSet = ExternalLinkHomeMonitor.getMeasureSet();
            dimensionSet = ExternalLinkHomeMonitor.getDimensionSet();
        }
        dimensionSet.addDimension(DIMENSION_LAUNCH_STYLE);
        AppMonitor.register(MODULE_NAME, POINT, measureSet, dimensionSet);
    }

    public void report(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        registerExternalLink(str);
        innerReport(str);
    }

    private PolymerizationMonitor() {
    }
}
