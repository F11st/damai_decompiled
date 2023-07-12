package tb;

import android.text.TextUtils;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import java.util.HashMap;
import java.util.Random;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class h23 {
    @NotNull
    public static final String BIZ_CODE_DIMEN = "bizCode";
    @NotNull
    public static final String BIZ_MSG_DIMEN = "bizMsg";
    @NotNull
    public static final String BIZ_SCENE_DIMEN = "bizScene";
    @NotNull
    public static final String BIZ_TYPE_DIMEN = "bizType";
    @NotNull
    public static final String EXTRA_DATA_DIMEN = "extraData";
    @NotNull
    public static final String PAGE_NAME_DIMEN = "pageName";
    @NotNull
    public static final String PAGE_SPM_DIMEN = "pageSpm";
    @NotNull
    public static final String PLATFORM_DIMEN = "platform";
    @NotNull
    public static final String POINT_FAIL_COUNT_MEASURE = "failCount";
    @NotNull
    public static final String POINT_SUCCESS_COUNT_MEASURE = "successCount";
    @NotNull
    public static final String POINT_SUCCESS_MEASURE = "success";
    @NotNull
    public static final String SIGN_CODE_DIMEN = "signCode";
    @NotNull
    public static final String USER_ID_DIMEN = "userId";
    @Nullable
    private static h23 h;
    @NotNull
    private final String a;
    private boolean b;
    private int c;
    @NotNull
    private final Random d;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private static String e = "android";
    @NotNull
    private static String f = "yyModule";
    @NotNull
    private static String g = "yyMoviePoint";

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        @NotNull
        public final synchronized h23 a() {
            h23 h23Var;
            if (h23.h == null) {
                h23.h = new h23();
            }
            h23Var = h23.h;
            b41.f(h23Var);
            return h23Var;
        }
    }

    public h23() {
        this.a = "YYBaseStatMonitor";
        this.c = 100;
        this.d = new Random();
    }

    private final boolean c(int i) {
        return i <= 0 || (i < 100 && !e(i));
    }

    private final boolean e(int i) {
        return this.d.nextInt(100) + 1 <= i;
    }

    public void d(@NotNull MeasureSet measureSet, @NotNull String str, double d, @Nullable Double d2, @Nullable Double d3) {
        b41.i(measureSet, "set");
        b41.i(str, "name");
        Measure measure = new Measure(str, Double.valueOf(d));
        if (d2 != null && d3 != null) {
            measure.setRange(d2, d3);
        }
        measureSet.addMeasure(measure);
    }

    public synchronized void f() {
        if (this.b) {
            return;
        }
        Logger.f(f, "iapp monitor register start");
        DimensionSet create = DimensionSet.create();
        create.addDimension("bizType");
        create.addDimension(BIZ_SCENE_DIMEN);
        create.addDimension("bizCode");
        create.addDimension(BIZ_MSG_DIMEN);
        create.addDimension(PAGE_SPM_DIMEN);
        create.addDimension("pageName");
        create.addDimension(SIGN_CODE_DIMEN);
        create.addDimension(EXTRA_DATA_DIMEN);
        create.addDimension("platform");
        create.addDimension("userId");
        MeasureSet create2 = MeasureSet.create();
        b41.h(create2, "measSet");
        d(create2, "success", 0.0d, null, null);
        d(create2, POINT_FAIL_COUNT_MEASURE, 0.0d, null, null);
        d(create2, POINT_SUCCESS_COUNT_MEASURE, 0.0d, null, null);
        AppMonitor.register(f, g, create2, create);
        this.b = true;
        Logger.f(f, "app monitor register end");
    }

    public void g(@NotNull nb nbVar) {
        b41.i(nbVar, "appMonitorPoint");
        i23 i23Var = i23.INSTANCE;
        i23Var.a(this.a, "release: step1");
        if (c(this.c)) {
            return;
        }
        String mPointName = nbVar.getMPointName();
        String bizScene = nbVar.getBizScene();
        String bizCode = nbVar.getBizCode();
        String bizMsg = nbVar.getBizMsg();
        String pageSpm = nbVar.getPageSpm();
        String pageName = nbVar.getPageName();
        int successState = nbVar.getSuccessState();
        int failCount = nbVar.getFailCount();
        int successCount = nbVar.getSuccessCount();
        String a2 = l23.INSTANCE.a();
        HashMap<String, String> extraDataMap = nbVar.getExtraDataMap();
        String signCode = nbVar.getSignCode();
        f();
        DimensionValueSet create = DimensionValueSet.create();
        create.setValue("bizType", mPointName);
        create.setValue("bizCode", bizCode);
        create.setValue(BIZ_MSG_DIMEN, bizMsg);
        create.setValue(PAGE_SPM_DIMEN, pageSpm);
        create.setValue("pageName", pageName);
        create.setValue(SIGN_CODE_DIMEN, signCode);
        create.setValue("platform", e);
        create.setValue("userId", a2);
        if (!TextUtils.isEmpty(bizScene)) {
            create.setValue(BIZ_SCENE_DIMEN, bizScene);
        }
        if (extraDataMap != null && extraDataMap.size() > 0) {
            create.setValue(EXTRA_DATA_DIMEN, yh0.INSTANCE.e(extraDataMap));
        }
        MeasureValueSet create2 = MeasureValueSet.create();
        create2.setValue("success", successState);
        create2.setValue(POINT_SUCCESS_COUNT_MEASURE, successCount);
        create2.setValue(POINT_FAIL_COUNT_MEASURE, failCount);
        i23Var.a(this.a, "release: ready-commit");
        AppMonitor.Stat.commit(f, g, create, create2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h23(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        this();
        b41.i(str, "platform");
        b41.i(str2, "module");
        b41.i(str3, "point");
        e = str;
        f = str2;
        g = str3;
    }
}
