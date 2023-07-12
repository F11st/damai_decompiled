package tb;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.adapter.IWXConfigAdapter;
import com.taobao.weex.common.Constants;
import com.taobao.weex.utils.WXViewUtils;
import org.android.agoo.message.MessageService;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class r13 {
    private static boolean a(ViewParent viewParent) {
        boolean z = true;
        if (viewParent instanceof View) {
            View view = (View) viewParent;
            if ((view.getVisibility() != 0 || view.getAlpha() <= 0.0f) ? false : false) {
                return a(view.getParent());
            }
            return false;
        }
        return true;
    }

    public static boolean b() {
        IWXConfigAdapter J = WXSDKManager.v().J();
        if (J == null) {
            return false;
        }
        double d = 100.0d;
        double random = Math.random() * 100.0d;
        try {
            d = Double.valueOf(J.getConfig(oz2.WXAPM_CONFIG_GROUP, "new_ws_sampling", MessageService.MSG_DB_COMPLETE)).doubleValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return random < d;
    }

    private static JSONObject c(View view) {
        if (view == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("width", view.getWidth());
            jSONObject.put("height", view.getHeight());
            int[] iArr = {-1, -1};
            view.getLocationOnScreen(iArr);
            jSONObject.put(Constants.Name.X, iArr[0]);
            jSONObject.put(Constants.Name.Y, iArr[1]);
            if (view instanceof ViewGroup) {
                jSONObject.put("type", view.getClass().getSimpleName());
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    jSONObject.put("child_" + i, c(viewGroup.getChildAt(i)));
                }
            } else {
                jSONObject.put("type", view.getClass().getSimpleName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private static boolean d(View view, int i) {
        if (view instanceof ViewGroup) {
            if (i > 0) {
                if (view.getHeight() < 10 || view.getWidth() < 10) {
                    return true;
                }
                i--;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                if (d(viewGroup.getChildAt(i2), i)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    private static boolean e(WXSDKInstance wXSDKInstance) {
        String[] split;
        IWXConfigAdapter J = WXSDKManager.v().J();
        if (J == null) {
            return false;
        }
        String config = J.getConfig(oz2.WXAPM_CONFIG_GROUP, "ws_white_list", null);
        if (TextUtils.isEmpty(config)) {
            return false;
        }
        try {
            for (String str : config.split(";")) {
                if (wXSDKInstance.getBundleUrl() != null && wXSDKInstance.getBundleUrl().contains(str)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean f(WXSDKInstance wXSDKInstance) {
        if (wXSDKInstance == null) {
            return false;
        }
        View containerView = wXSDKInstance.getContainerView();
        if ((containerView instanceof ViewGroup) && WXViewUtils.isViewVisible(containerView) && a(containerView.getParent()) && !e(wXSDKInstance)) {
            return !d(containerView, 3);
        }
        return false;
    }

    public static String g(WXSDKInstance wXSDKInstance) {
        if (wXSDKInstance == null) {
            return "nullInstance";
        }
        JSONObject c = c(wXSDKInstance.getContainerView());
        return c != null ? c.toString() : "";
    }
}
