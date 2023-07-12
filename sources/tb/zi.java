package tb;

import cn.damai.category.discountticket.util.CityListener;
import cn.damai.message.observer.Action;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class zi {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String CATEGORY_CITY_CHANGED_EVENT = "category_city_changed";
    private static zi c;
    private xr a;
    private List<WeakReference<CityListener>> b = new ArrayList();

    /* compiled from: Taobao */
    /* renamed from: tb.zi$a */
    /* loaded from: classes.dex */
    public class C10023a implements Action<String> {
        private static transient /* synthetic */ IpChange $ipChange;

        C10023a() {
        }

        @Override // cn.damai.message.observer.Action
        /* renamed from: a */
        public void call(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "681701552")) {
                ipChange.ipc$dispatch("681701552", new Object[]{this, str});
                return;
            }
            for (int i = 0; i < zi.this.b.size(); i++) {
                CityListener cityListener = (CityListener) ((WeakReference) zi.this.b.get(i)).get();
                if (cityListener != null) {
                    cityListener.onCityChanged(str);
                }
            }
        }
    }

    public zi() {
        xr xrVar = new xr();
        this.a = xrVar;
        xrVar.b(CATEGORY_CITY_CHANGED_EVENT, new C10023a());
    }

    public static synchronized zi c() {
        synchronized (zi.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "661510683")) {
                return (zi) ipChange.ipc$dispatch("661510683", new Object[0]);
            }
            if (c == null) {
                c = new zi();
            }
            return c;
        }
    }

    public synchronized void b(CityListener cityListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "232042250")) {
            ipChange.ipc$dispatch("232042250", new Object[]{this, cityListener});
            return;
        }
        if (cityListener != null) {
            this.b.add(new WeakReference<>(cityListener));
        }
    }
}
