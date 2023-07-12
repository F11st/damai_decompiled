package cn.damai.commonbusiness.pageut;

import android.app.Activity;
import android.util.Log;
import androidx.annotation.Nullable;
import cn.damai.common.user.a;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.pageut.PageUtExecutor;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class a {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final HashMap<Integer, a> c = new HashMap<>();
    private a.b a;
    private a.b b;

    private a() {
    }

    public static void a(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1554804871")) {
            ipChange.ipc$dispatch("1554804871", new Object[]{activity});
            return;
        }
        a f = f(activity);
        if (f != null) {
            f.c(activity);
        }
    }

    public static void b(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "880709508")) {
            ipChange.ipc$dispatch("880709508", new Object[]{activity});
            return;
        }
        a f = f(activity);
        if (f != null) {
            f.d(activity);
        }
    }

    @Nullable
    public static a f(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1657478417")) {
            return (a) ipChange.ipc$dispatch("-1657478417", new Object[]{activity});
        }
        if (activity == null) {
            return null;
        }
        return c.get(Integer.valueOf(activity.hashCode()));
    }

    public static void h(Activity activity, a.b bVar) {
        a f;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-536599250")) {
            ipChange.ipc$dispatch("-536599250", new Object[]{activity, bVar});
        } else if (activity == null || bVar == null || (f = f(activity)) == null) {
        } else {
            f.e(activity, bVar);
        }
    }

    public static void i(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-148107785")) {
            ipChange.ipc$dispatch("-148107785", new Object[]{activity});
        } else {
            c.put(Integer.valueOf(activity.hashCode()), new a());
        }
    }

    public static void j(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1778267582")) {
            ipChange.ipc$dispatch("1778267582", new Object[]{activity});
        } else {
            c.remove(Integer.valueOf(activity.hashCode()));
        }
    }

    public void c(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1315116648")) {
            ipChange.ipc$dispatch("-1315116648", new Object[]{this, activity});
            return;
        }
        a.b bVar = this.a;
        if (bVar != null) {
            this.b = bVar;
            c.e().q(activity);
        }
        this.a = null;
    }

    public void d(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2107455635")) {
            ipChange.ipc$dispatch("2107455635", new Object[]{this, activity});
        } else if (this.b == null || this.a != null) {
        } else {
            c.e().n(activity, this.b);
            this.a = this.b;
            this.b = null;
        }
    }

    public void e(Activity activity, a.b bVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-899448679")) {
            ipChange.ipc$dispatch("-899448679", new Object[]{this, activity, bVar});
            return;
        }
        a.b bVar2 = this.a;
        if (bVar2 == null) {
            this.a = bVar;
            c.e().n(activity, this.a);
        } else if (bVar2 != bVar) {
            boolean z = activity instanceof PageUtExecutor.FragmentPropertiesProvider;
            if (z) {
                Map<String, String> map = ((PageUtExecutor.FragmentPropertiesProvider) activity).get(bVar2.m().t());
                if (map != null) {
                    c.e().O(activity, map);
                    Log.e("abtest", "doPageViewResume: 1 onFragmentyPause FragmentPropertiesProvider , size :" + map.size() + " ,page : " + this.a.m().t());
                } else {
                    Log.e("abtest", "doPageViewResume: 2 onFragmentyPause FragmentPropertiesProvider , size null !!!");
                }
            }
            c.e().q(activity);
            this.b = this.a;
            this.a = bVar;
            if (z) {
                Map<String, String> map2 = ((PageUtExecutor.FragmentPropertiesProvider) activity).get(bVar.m().t());
                if (map2 != null) {
                    c.e().O(activity, map2);
                    Log.e("abtest", "doPageViewResume: 3 onFragmentResume FragmentPropertiesProvider , size :" + map2.size() + " ,page : " + bVar.m().t());
                } else {
                    Log.e("abtest", "doPageViewResume: 4 onFragmentResume FragmentPropertiesProvider , size null !!!");
                }
            }
            c.e().n(activity, this.a);
        }
    }

    @Nullable
    public a.b g() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1699427303") ? (a.b) ipChange.ipc$dispatch("1699427303", new Object[]{this}) : this.a;
    }
}
