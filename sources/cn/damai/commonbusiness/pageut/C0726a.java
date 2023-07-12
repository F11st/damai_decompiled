package cn.damai.commonbusiness.pageut;

import android.app.Activity;
import android.util.Log;
import androidx.annotation.Nullable;
import cn.damai.common.user.C0525a;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.pageut.PageUtExecutor;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: cn.damai.commonbusiness.pageut.a */
/* loaded from: classes14.dex */
public class C0726a {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final HashMap<Integer, C0726a> c = new HashMap<>();
    private C0525a.C0527b a;
    private C0525a.C0527b b;

    private C0726a() {
    }

    public static void a(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1554804871")) {
            ipChange.ipc$dispatch("1554804871", new Object[]{activity});
            return;
        }
        C0726a f = f(activity);
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
        C0726a f = f(activity);
        if (f != null) {
            f.d(activity);
        }
    }

    @Nullable
    public static C0726a f(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1657478417")) {
            return (C0726a) ipChange.ipc$dispatch("-1657478417", new Object[]{activity});
        }
        if (activity == null) {
            return null;
        }
        return c.get(Integer.valueOf(activity.hashCode()));
    }

    public static void h(Activity activity, C0525a.C0527b c0527b) {
        C0726a f;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-536599250")) {
            ipChange.ipc$dispatch("-536599250", new Object[]{activity, c0527b});
        } else if (activity == null || c0527b == null || (f = f(activity)) == null) {
        } else {
            f.e(activity, c0527b);
        }
    }

    public static void i(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-148107785")) {
            ipChange.ipc$dispatch("-148107785", new Object[]{activity});
        } else {
            c.put(Integer.valueOf(activity.hashCode()), new C0726a());
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
        C0525a.C0527b c0527b = this.a;
        if (c0527b != null) {
            this.b = c0527b;
            C0529c.e().q(activity);
        }
        this.a = null;
    }

    public void d(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2107455635")) {
            ipChange.ipc$dispatch("2107455635", new Object[]{this, activity});
        } else if (this.b == null || this.a != null) {
        } else {
            C0529c.e().n(activity, this.b);
            this.a = this.b;
            this.b = null;
        }
    }

    public void e(Activity activity, C0525a.C0527b c0527b) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-899448679")) {
            ipChange.ipc$dispatch("-899448679", new Object[]{this, activity, c0527b});
            return;
        }
        C0525a.C0527b c0527b2 = this.a;
        if (c0527b2 == null) {
            this.a = c0527b;
            C0529c.e().n(activity, this.a);
        } else if (c0527b2 != c0527b) {
            boolean z = activity instanceof PageUtExecutor.FragmentPropertiesProvider;
            if (z) {
                Map<String, String> map = ((PageUtExecutor.FragmentPropertiesProvider) activity).get(c0527b2.m().t());
                if (map != null) {
                    C0529c.e().O(activity, map);
                    Log.e("abtest", "doPageViewResume: 1 onFragmentyPause FragmentPropertiesProvider , size :" + map.size() + " ,page : " + this.a.m().t());
                } else {
                    Log.e("abtest", "doPageViewResume: 2 onFragmentyPause FragmentPropertiesProvider , size null !!!");
                }
            }
            C0529c.e().q(activity);
            this.b = this.a;
            this.a = c0527b;
            if (z) {
                Map<String, String> map2 = ((PageUtExecutor.FragmentPropertiesProvider) activity).get(c0527b.m().t());
                if (map2 != null) {
                    C0529c.e().O(activity, map2);
                    Log.e("abtest", "doPageViewResume: 3 onFragmentResume FragmentPropertiesProvider , size :" + map2.size() + " ,page : " + c0527b.m().t());
                } else {
                    Log.e("abtest", "doPageViewResume: 4 onFragmentResume FragmentPropertiesProvider , size null !!!");
                }
            }
            C0529c.e().n(activity, this.a);
        }
    }

    @Nullable
    public C0525a.C0527b g() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1699427303") ? (C0525a.C0527b) ipChange.ipc$dispatch("1699427303", new Object[]{this}) : this.a;
    }
}
