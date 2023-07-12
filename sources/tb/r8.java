package tb;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.bricks.bean.HeadAtmosphereBean;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.uikit.feature.features.FeatureFactory;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.PageContext;
import java.lang.ref.WeakReference;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class r8 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final r8 INSTANCE = new r8();
    public static final int INVALID_ATMOSPHERE_TOP = -10000;
    public static final int INVALID_CATEGORY_ICON_TOP = -10000;
    @NotNull
    public static final String KEY_EVENT_ATMOSPHERE_STATE = "KEY_EVENT_ATMOSPHERE_STATE";
    @NotNull
    public static final String KEY_IS_HAS_ATMOSPHERE = "KEY_IS_HAS_ATMOSPHERE";
    @NotNull
    public static final String KEY_IS_HAS_CLICK_AREA_HEIGHT = "KEY_IS_HAS_CLICK_AREA_HEIGHT";
    @NotNull
    public static final String TAG = "Atmosphere";
    @NotNull
    public static final String TYPE_FAIL_LOTTIE_DRAW = "1";
    @NotNull
    public static final String TYPE_FAIL_LOTTIE_LOAD = "2";
    @NotNull
    public static final String TYPE_FAIL_PIC_LOAD = "3";
    @Nullable
    private static WeakReference<View> a;

    private r8() {
    }

    private final Node b(Node node) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1267887187")) {
            return (Node) ipChange.ipc$dispatch("-1267887187", new Object[]{this, node});
        }
        if (node != null) {
            if (node.getLevel() == 3 && node.getType() == 7542) {
                return node;
            }
            List<Node> children = node.getChildren();
            if (children != null && children.size() > 0) {
                for (Node node2 : children) {
                    Node b = b(node2);
                    if (b != null) {
                        return b;
                    }
                }
            }
            return null;
        }
        return null;
    }

    @NotNull
    public final s8 a(@NotNull Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-293931791")) {
            return (s8) ipChange.ipc$dispatch("-293931791", new Object[]{this, activity});
        }
        b41.i(activity, "activity");
        int i = (DisplayMetrics.getwidthPixels(s60.INSTANCE.f(activity)) * 400) / FeatureFactory.PRIORITY_ABOVE_NORMAL;
        return new s8(i, (int) ((i * 124) / 400.0f), (int) (i * 0.25f), bv0.INSTANCE.a(activity));
    }

    public final int c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1378337404")) {
            return ((Integer) ipChange.ipc$dispatch("-1378337404", new Object[]{this})).intValue();
        }
        WeakReference<View> weakReference = a;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            if (view.isAttachedToWindow()) {
                return view.getTop();
            }
            return -view.getMeasuredHeight();
        }
        return -10000;
    }

    public final boolean d(@Nullable PageContext pageContext, @Nullable Node node) {
        JSONObject data;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-202958636")) {
            return ((Boolean) ipChange.ipc$dispatch("-202958636", new Object[]{this, pageContext, node})).booleanValue();
        }
        if (pageContext != null) {
            if (pageContext.getBundle() == null) {
                pageContext.setBundle(new Bundle());
            }
            Bundle bundle = pageContext.getBundle();
            if (bundle != null) {
                bundle.remove(KEY_IS_HAS_ATMOSPHERE);
            }
            Bundle bundle2 = pageContext.getBundle();
            if (bundle2 != null) {
                bundle2.remove(KEY_IS_HAS_CLICK_AREA_HEIGHT);
            }
            Node b = INSTANCE.b(node);
            if (b == null || (data = b.getData()) == null) {
                return false;
            }
            try {
                HeadAtmosphereBean headAtmosphereBean = (HeadAtmosphereBean) JSON.parseObject(data.toJSONString(), HeadAtmosphereBean.class);
                if (headAtmosphereBean == null || !headAtmosphereBean.isValid()) {
                    return false;
                }
                Bundle bundle3 = pageContext.getBundle();
                if (bundle3 != null) {
                    bundle3.putBoolean(KEY_IS_HAS_ATMOSPHERE, true);
                }
                Bundle bundle4 = pageContext.getBundle();
                if (bundle4 != null) {
                    bundle4.putBoolean(KEY_IS_HAS_CLICK_AREA_HEIGHT, headAtmosphereBean.isShowPlaceholderHeight());
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public final void e(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1968054981")) {
            ipChange.ipc$dispatch("-1968054981", new Object[]{this, view});
            return;
        }
        b41.i(view, "itemView");
        a = new WeakReference<>(view);
    }

    public final void f(@Nullable HeadAtmosphereBean headAtmosphereBean, @NotNull String str, @NotNull String str2) {
        String str3;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-480037768")) {
            ipChange.ipc$dispatch("-480037768", new Object[]{this, headAtmosphereBean, str, str2});
            return;
        }
        b41.i(str, "code");
        b41.i(str2, "msg");
        if (headAtmosphereBean != null) {
            try {
                if (!b41.d(str, "1")) {
                    z = b41.d(str, "2");
                }
                if (z) {
                    str3 = headAtmosphereBean.lottie;
                    b41.h(str3, "{\n                      …tie\n                    }");
                } else {
                    str3 = headAtmosphereBean.backgroundPic;
                    b41.h(str3, "{\n                      …Pic\n                    }");
                }
                z13.a(z13.b("aristotle.get", "首页OneArch接口", str, str2, "atmoUrl: " + str3 + "  atmoId：" + headAtmosphereBean.id), gz0.NEW_HOME_ATMOSPHERE_DISPLAYED_FAIL_CODE, gz0.NEW_HOME_ATMOSPHERE_DISPLAYED_FAIL_MSG);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
