package tb;

import android.os.Build;
import android.view.View;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.OrangeConfigCenter;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.lazyimg.ImgLoader;
import cn.damai.commonbusiness.lazyimg.InstantImgLoader;
import cn.damai.commonbusiness.lazyimg.LazyImageLoader;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class c21 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String LAZY_TURN_FAST_LOAD_IMG_SWITCH = "damai_lazy_turn_fast_load_img_switch";
    public static final String SWITCH_OPEN_FEED_SCROLL_OPT = "switch_open_feed_scroll_opt";

    public static ImgLoader a(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1406871657")) {
            return (ImgLoader) ipChange.ipc$dispatch("1406871657", new Object[]{view});
        }
        if (view == null) {
            return new InstantImgLoader();
        }
        if (view instanceof RecyclerView) {
            Object tag = ((RecyclerView) view).getTag(R$id.id_img_loader_tag);
            if (tag instanceof ImgLoader) {
                return (ImgLoader) tag;
            }
        }
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            return a((View) parent);
        }
        return new InstantImgLoader();
    }

    public static void b(RecyclerView recyclerView) {
        RecyclerView.OnScrollListener instantImgLoader;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1201600049")) {
            ipChange.ipc$dispatch("1201600049", new Object[]{recyclerView});
        } else if (recyclerView != null) {
            int a = OrangeConfigCenter.c().a(LAZY_TURN_FAST_LOAD_IMG_SWITCH, SWITCH_OPEN_FEED_SCROLL_OPT, 1);
            cb1.b("OrangeSwitch", "feed scroll opt " + a + " 1=开启");
            if (a == 1) {
                if (Build.VERSION.SDK_INT >= 19) {
                    instantImgLoader = new LazyImageLoader();
                    recyclerView.addOnScrollListener(instantImgLoader);
                } else {
                    instantImgLoader = new InstantImgLoader();
                }
            } else {
                instantImgLoader = new InstantImgLoader();
            }
            recyclerView.setTag(R$id.id_img_loader_tag, instantImgLoader);
        }
    }

    public static void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1030692434")) {
            ipChange.ipc$dispatch("-1030692434", new Object[0]);
        } else {
            OrangeConfigCenter.c().e(LAZY_TURN_FAST_LOAD_IMG_SWITCH);
        }
    }

    public static void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-329674155")) {
            ipChange.ipc$dispatch("-329674155", new Object[0]);
        } else {
            OrangeConfigCenter.c().g(LAZY_TURN_FAST_LOAD_IMG_SWITCH);
        }
    }
}
