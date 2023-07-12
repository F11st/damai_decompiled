package tb;

import com.alibaba.appmonitor.pool.ReuseJSONArray;
import com.alibaba.appmonitor.pool.ReuseJSONObject;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureValue;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class bg2 extends qf0 {
    private nf1 g;
    private Map<DimensionValueSet, a> h;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class a {
        private int a = 0;
        private int b = 0;
        private List<MeasureValueSet> c = new ArrayList();

        public a() {
        }

        private MeasureValueSet d(MeasureValueSet measureValueSet) {
            List<Measure> measures;
            MeasureValueSet measureValueSet2 = (MeasureValueSet) com.alibaba.appmonitor.pool.a.a().poll(MeasureValueSet.class, new Object[0]);
            if (bg2.this.g != null && bg2.this.g.b() != null && (measures = bg2.this.g.b().getMeasures()) != null) {
                int size = measures.size();
                for (int i = 0; i < size; i++) {
                    Measure measure = measures.get(i);
                    if (measure != null) {
                        MeasureValue measureValue = (MeasureValue) com.alibaba.appmonitor.pool.a.a().poll(MeasureValue.class, new Object[0]);
                        MeasureValue value = measureValueSet.getValue(measure.getName());
                        if (value.getOffset() != null) {
                            measureValue.setOffset(value.getOffset().doubleValue());
                        }
                        measureValue.setValue(value.getValue());
                        measureValueSet2.setValue(measure.getName(), measureValue);
                    }
                }
            }
            return measureValueSet2;
        }

        public void c(MeasureValueSet measureValueSet) {
            if (measureValueSet != null) {
                if (bg2.this.g != null && bg2.this.g.e()) {
                    this.c.add(d(measureValueSet));
                } else if (this.c.isEmpty()) {
                    MeasureValueSet d = d(measureValueSet);
                    if (bg2.this.g != null && bg2.this.g.b() != null) {
                        d.setBuckets(bg2.this.g.b().getMeasures());
                    }
                    this.c.add(d);
                } else {
                    this.c.get(0).merge(measureValueSet);
                }
            }
        }

        public List<Map<String, Map<String, Object>>> e() {
            Map<String, MeasureValue> map;
            List<MeasureValueSet> list = this.c;
            if (list == null || list.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                MeasureValueSet measureValueSet = this.c.get(i);
                if (measureValueSet != null && (map = measureValueSet.getMap()) != null && !map.isEmpty()) {
                    HashMap hashMap = new HashMap();
                    for (Map.Entry<String, MeasureValue> entry : map.entrySet()) {
                        HashMap hashMap2 = new HashMap();
                        String key = entry.getKey();
                        MeasureValue value = entry.getValue();
                        hashMap2.put("value", Double.valueOf(value.getValue()));
                        if (value.getOffset() != null) {
                            hashMap2.put("offset", value.getOffset());
                        }
                        Map<String, Double> buckets = value.getBuckets();
                        if (buckets != null) {
                            hashMap2.put("buckets", buckets);
                        }
                        hashMap.put(key, hashMap2);
                    }
                    arrayList.add(hashMap);
                }
            }
            return arrayList;
        }

        public void f() {
            this.a++;
        }

        public void g() {
            this.b++;
        }
    }

    @Override // tb.qf0
    public synchronized JSONObject b() {
        JSONObject b;
        b = super.b();
        nf1 nf1Var = this.g;
        if (nf1Var != null) {
            b.put("isCommitDetail", (Object) String.valueOf(nf1Var.e()));
        }
        JSONArray jSONArray = (JSONArray) com.alibaba.appmonitor.pool.a.a().poll(ReuseJSONArray.class, new Object[0]);
        Map<DimensionValueSet, a> map = this.h;
        if (map != null) {
            for (Map.Entry<DimensionValueSet, a> entry : map.entrySet()) {
                JSONObject jSONObject = (JSONObject) com.alibaba.appmonitor.pool.a.a().poll(ReuseJSONObject.class, new Object[0]);
                DimensionValueSet key = entry.getKey();
                a value = entry.getValue();
                Integer valueOf = Integer.valueOf(value.a);
                Integer valueOf2 = Integer.valueOf(value.b);
                jSONObject.put(AdUtConstants.XAD_UT_ARG_COUNT, (Object) valueOf);
                jSONObject.put("noise", (Object) valueOf2);
                jSONObject.put("dimensions", (Object) (key != null ? new HashMap(key.getMap()) : null));
                jSONObject.put("measures", (Object) value.e());
                jSONArray.add(jSONObject);
            }
        }
        b.put("values", (Object) jSONArray);
        return b;
    }

    @Override // tb.qf0, com.alibaba.appmonitor.pool.Reusable
    public synchronized void clean() {
        super.clean();
        this.g = null;
        for (DimensionValueSet dimensionValueSet : this.h.keySet()) {
            com.alibaba.appmonitor.pool.a.a().offer(dimensionValueSet);
        }
        this.h.clear();
    }

    public synchronized void d(DimensionValueSet dimensionValueSet, MeasureValueSet measureValueSet) {
        a aVar;
        if (dimensionValueSet == null) {
            dimensionValueSet = (DimensionValueSet) com.alibaba.appmonitor.pool.a.a().poll(DimensionValueSet.class, new Object[0]);
        }
        if (this.h.containsKey(dimensionValueSet)) {
            aVar = this.h.get(dimensionValueSet);
        } else {
            DimensionValueSet dimensionValueSet2 = (DimensionValueSet) com.alibaba.appmonitor.pool.a.a().poll(DimensionValueSet.class, new Object[0]);
            dimensionValueSet2.addValues(dimensionValueSet);
            a aVar2 = new a();
            this.h.put(dimensionValueSet2, aVar2);
            aVar = aVar2;
        }
        nf1 nf1Var = this.g;
        if (nf1Var != null ? nf1Var.g(dimensionValueSet, measureValueSet) : false) {
            aVar.f();
            aVar.c(measureValueSet);
        } else {
            aVar.g();
            nf1 nf1Var2 = this.g;
            if (nf1Var2 != null && nf1Var2.e()) {
                aVar.c(measureValueSet);
            }
        }
        super.a(null);
    }

    @Override // tb.qf0, com.alibaba.appmonitor.pool.Reusable
    public void fill(Object... objArr) {
        super.fill(objArr);
        if (this.h == null) {
            this.h = new HashMap();
        }
        this.g = of1.c().b(this.a, this.b);
    }
}
