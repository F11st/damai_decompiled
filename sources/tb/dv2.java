package tb;

import android.content.Context;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.taobao.tao.log.TLogConstant;
import com.uploader.export.IUploaderStatistics;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class dv2 implements IUploaderStatistics {
    private AtomicBoolean a = new AtomicBoolean(true);

    @Override // com.uploader.export.IUploaderStatistics
    public void onCommit(String str, String str2, Map<String, Double> map, Map<String, String> map2) {
        try {
            if (this.a.get()) {
                Double d = map.get("upstream");
                Double d2 = map.get("downstream");
                if (d == null) {
                    d = Double.valueOf(0.0d);
                }
                if (d2 == null) {
                    d2 = Double.valueOf(0.0d);
                }
                Class<?> cls = Class.forName("com.taobao.analysis.FlowCenter");
                Method method = cls.getMethod("getInstance", new Class[0]);
                Class<?> cls2 = Long.TYPE;
                cls.getMethod("commitFlow", Context.class, String.class, Boolean.TYPE, String.class, cls2, cls2).invoke(method.invoke(cls, new Object[0]), yu2.d, TLogConstant.TOKEN_TYPE_ARUP, Boolean.FALSE, TLogConstant.TOKEN_TYPE_ARUP, Long.valueOf(d.longValue()), Long.valueOf(d2.longValue()));
            }
        } catch (Throwable th) {
            if (!(th instanceof ClassNotFoundException) && !(th instanceof NoSuchMethodException)) {
                th.printStackTrace();
            } else {
                this.a.compareAndSet(true, false);
            }
        }
        try {
            DimensionValueSet create = DimensionValueSet.create();
            create.setMap(map2);
            MeasureValueSet create2 = MeasureValueSet.create();
            for (Map.Entry<String, Double> entry : map.entrySet()) {
                create2.setValue(entry.getKey(), entry.getValue().doubleValue());
            }
            AppMonitor.Stat.commit(str, str2, create, create2);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.uploader.export.IUploaderStatistics
    public void onRegister(String str, String str2, Set<String> set, Set<String> set2, boolean z) {
        try {
            AppMonitor.register(str, str2, MeasureSet.create(set), DimensionSet.create(set2), z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
