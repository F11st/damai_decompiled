package tb;

import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alipay.sdk.m.x.AbstractC4344c;
import com.taobao.slide.stat.BizStatData;
import com.taobao.slide.stat.IBizStat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* renamed from: tb.uc */
/* loaded from: classes11.dex */
public class C9766uc implements IBizStat {
    private static String[] a = {AbstractC4344c.c, AbstractC4344c.d, "v3", "v4", "v5"};
    private static Map<String, String> b = new ConcurrentHashMap();
    private static boolean c = false;

    public C9766uc() {
        try {
            c = true;
        } catch (Exception unused) {
            c = false;
        }
        if (c) {
            try {
                MeasureSet create = MeasureSet.create();
                for (String str : a) {
                    create.addMeasure(str);
                }
                DimensionSet create2 = DimensionSet.create();
                create2.addDimension(hh1.DIMEN_BIZ);
                create2.addDimension("digest");
                create2.addDimension("etag");
                create2.addDimension(hh1.DIMEN_VERSION);
                create2.addDimension(hh1.DIMEN_POD_VERSION);
                create2.addDimension("errorCode");
                create2.addDimension(hh1.DIMEN_MESSAGE);
                AppMonitor.register(hh1.MODULE_NAME, "slide_use", create, create2);
                DimensionSet create3 = DimensionSet.create();
                create3.addDimension(hh1.DIMEN_BIZ);
                create3.addDimension("digest");
                create3.addDimension("errorCode");
                create3.addDimension(hh1.DIMEN_MESSAGE);
                create3.addDimension("etag");
                create3.addDimension(hh1.DIMEN_VERSION);
                create3.addDimension(hh1.DIMEN_POD_VERSION);
                AppMonitor.register(hh1.MODULE_NAME, "slide_download", create, create3);
                c = true;
            } catch (Throwable unused2) {
            }
        }
    }

    private void a(BizStatData bizStatData) {
        if (TextUtils.isEmpty(bizStatData.module) || TextUtils.isEmpty(bizStatData.monitorPoint)) {
            return;
        }
        if (TextUtils.isEmpty(bizStatData.module) || !bizStatData.monitorPoint.equals(b.get(bizStatData.module))) {
            DimensionSet create = DimensionSet.create();
            create.addDimension(hh1.DIMEN_BIZ);
            create.addDimension("digest");
            create.addDimension("etag");
            create.addDimension(hh1.DIMEN_VERSION);
            create.addDimension(hh1.DIMEN_POD_VERSION);
            create.addDimension("errorCode");
            create.addDimension(hh1.DIMEN_MESSAGE);
            HashMap<String, String> hashMap = bizStatData.extDimen;
            if (hashMap != null) {
                for (String str : hashMap.keySet()) {
                    create.addDimension(str);
                }
            }
            MeasureSet create2 = MeasureSet.create();
            HashMap<String, Double> hashMap2 = bizStatData.extMeasure;
            if (hashMap2 != null) {
                for (String str2 : hashMap2.keySet()) {
                    create2.addMeasure(str2);
                }
            }
            AppMonitor.register(bizStatData.module, bizStatData.monitorPoint, create2, create);
            b.put(bizStatData.module, bizStatData.monitorPoint);
        }
        DimensionValueSet create3 = DimensionValueSet.create();
        create3.setValue(hh1.DIMEN_BIZ, bizStatData.bizId);
        create3.setValue("etag", bizStatData.etag);
        create3.setValue(hh1.DIMEN_POD_VERSION, bizStatData.podver);
        create3.setValue(hh1.DIMEN_VERSION, bizStatData.appSnapshotVersion);
        create3.setValue("digest", bizStatData.digest);
        create3.setValue("errorCode", String.valueOf(bizStatData.code));
        create3.setValue(hh1.DIMEN_MESSAGE, bizStatData.message);
        HashMap<String, String> hashMap3 = bizStatData.extDimen;
        if (hashMap3 != null) {
            for (String str3 : hashMap3.keySet()) {
                create3.setValue(str3, bizStatData.extDimen.get(str3));
            }
        }
        MeasureValueSet create4 = MeasureValueSet.create();
        HashMap<String, Double> hashMap4 = bizStatData.extMeasure;
        if (hashMap4 != null) {
            for (String str4 : hashMap4.keySet()) {
                create4.setValue(str4, bizStatData.extMeasure.get(str4).doubleValue());
            }
        }
        AppMonitor.Stat.commit(bizStatData.module, bizStatData.monitorPoint, create3, create4);
    }

    @Override // com.taobao.slide.stat.IBizStat
    public void commitDownload(BizStatData bizStatData) {
        if (c) {
            int i = 0;
            if (bizStatData == null) {
                m42.e("BizStat", "commitUse statData null", new Object[0]);
                return;
            }
            DimensionValueSet create = DimensionValueSet.create();
            create.setValue(hh1.DIMEN_BIZ, bizStatData.bizId);
            create.setValue("etag", bizStatData.etag);
            create.setValue(hh1.DIMEN_POD_VERSION, bizStatData.podver);
            create.setValue(hh1.DIMEN_VERSION, bizStatData.appSnapshotVersion);
            create.setValue("digest", bizStatData.digest);
            create.setValue("errorCode", String.valueOf(bizStatData.code));
            create.setValue(hh1.DIMEN_MESSAGE, bizStatData.message);
            MeasureValueSet create2 = MeasureValueSet.create();
            HashMap<String, Double> hashMap = bizStatData.extMeasure;
            if (hashMap != null && hashMap.size() > 0) {
                for (String str : bizStatData.extMeasure.keySet()) {
                    create2.setValue(a[i], bizStatData.extMeasure.get(str).doubleValue());
                    i++;
                    if (i >= 5) {
                        break;
                    }
                }
            }
            AppMonitor.Stat.commit(hh1.MODULE_NAME, "slide_download", create, create2);
            a(bizStatData);
        }
    }

    @Override // com.taobao.slide.stat.IBizStat
    public void commitUse(BizStatData bizStatData) {
        if (c) {
            int i = 0;
            if (bizStatData == null) {
                m42.e("BizStat", "commitUse statData null", new Object[0]);
                return;
            }
            DimensionValueSet create = DimensionValueSet.create();
            create.setValue(hh1.DIMEN_BIZ, bizStatData.bizId);
            create.setValue("etag", bizStatData.etag);
            create.setValue(hh1.DIMEN_POD_VERSION, bizStatData.podver);
            create.setValue(hh1.DIMEN_VERSION, bizStatData.appSnapshotVersion);
            create.setValue("digest", bizStatData.digest);
            create.setValue("errorCode", String.valueOf(bizStatData.code));
            create.setValue(hh1.DIMEN_MESSAGE, bizStatData.message);
            MeasureValueSet create2 = MeasureValueSet.create();
            HashMap<String, Double> hashMap = bizStatData.extMeasure;
            if (hashMap != null && hashMap.size() > 0) {
                for (String str : bizStatData.extMeasure.keySet()) {
                    create2.setValue(a[i], bizStatData.extMeasure.get(str).doubleValue());
                    i++;
                    if (i >= 5) {
                        break;
                    }
                }
            }
            AppMonitor.Stat.commit(hh1.MODULE_NAME, "slide_use", create, create2);
            a(bizStatData);
        }
    }
}
