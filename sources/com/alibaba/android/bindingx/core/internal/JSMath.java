package com.alibaba.android.bindingx.core.internal;

import android.animation.ArgbEvaluator;
import android.graphics.Color;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import com.alibaba.android.bindingx.core.PlatformManager;
import com.taobao.weex.common.Constants;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONException;

/* compiled from: Taobao */
@Keep
/* loaded from: classes5.dex */
public class JSMath {
    private static ArgbEvaluator sArgbEvaluator = new ArgbEvaluator();

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class a implements JSFunctionInterface {
        a() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) {
            return Double.valueOf(Math.sqrt(((Double) arrayList.get(0)).doubleValue()));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class b implements JSFunctionInterface {
        b() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) {
            return Double.valueOf(Math.cbrt(((Double) arrayList.get(0)).doubleValue()));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class c implements JSFunctionInterface {
        c() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) {
            return Double.valueOf(Math.log(((Double) arrayList.get(0)).doubleValue()));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class d implements JSFunctionInterface {
        d() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) {
            return Double.valueOf(Math.abs(((Double) arrayList.get(0)).doubleValue()));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class e implements JSFunctionInterface {
        e() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) {
            double doubleValue = ((Double) arrayList.get(0)).doubleValue();
            int i = (doubleValue > 0.0d ? 1 : (doubleValue == 0.0d ? 0 : -1));
            if (i > 0) {
                return 1;
            }
            if (i == 0) {
                return 0;
            }
            if (doubleValue < 0.0d) {
                return -1;
            }
            return Double.valueOf(Double.NaN);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class f implements JSFunctionInterface {
        f() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) {
            return Double.valueOf(Math.ceil(((Double) arrayList.get(0)).doubleValue()));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class g implements JSFunctionInterface {
        g() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) {
            return Double.valueOf(Math.floor(((Double) arrayList.get(0)).doubleValue()));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class h implements JSFunctionInterface {
        h() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) {
            return Long.valueOf(Math.round(((Double) arrayList.get(0)).doubleValue()));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class i implements JSFunctionInterface {
        i() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) {
            if (arrayList != null) {
                if (arrayList.size() >= 1) {
                    double doubleValue = ((Double) arrayList.get(0)).doubleValue();
                    int size = arrayList.size();
                    for (int i = 1; i < size; i++) {
                        double doubleValue2 = ((Double) arrayList.get(i)).doubleValue();
                        if (doubleValue2 > doubleValue) {
                            doubleValue = doubleValue2;
                        }
                    }
                    return Double.valueOf(doubleValue);
                }
                return null;
            }
            return null;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class j implements JSFunctionInterface {
        j() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) {
            if (arrayList != null) {
                if (arrayList.size() >= 1) {
                    double doubleValue = ((Double) arrayList.get(0)).doubleValue();
                    int size = arrayList.size();
                    for (int i = 1; i < size; i++) {
                        double doubleValue2 = ((Double) arrayList.get(i)).doubleValue();
                        if (doubleValue2 < doubleValue) {
                            doubleValue = doubleValue2;
                        }
                    }
                    return Double.valueOf(doubleValue);
                }
                return null;
            }
            return null;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class k implements JSFunctionInterface {
        k() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) {
            return Double.valueOf(Math.sin(((Double) arrayList.get(0)).doubleValue()));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class l implements JSFunctionInterface {
        l() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
            if (arrayList == null || arrayList.size() < 3) {
                return null;
            }
            return Integer.valueOf(Color.rgb((int) ((Double) arrayList.get(0)).doubleValue(), (int) ((Double) arrayList.get(1)).doubleValue(), (int) ((Double) arrayList.get(2)).doubleValue()));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class m implements JSFunctionInterface {
        m() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
            if (arrayList == null || arrayList.size() < 4) {
                return null;
            }
            return Integer.valueOf(Color.argb((int) (((Double) arrayList.get(3)).doubleValue() * 255.0d), (int) ((Double) arrayList.get(0)).doubleValue(), (int) ((Double) arrayList.get(1)).doubleValue(), (int) ((Double) arrayList.get(2)).doubleValue()));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class n implements JSFunctionInterface {
        n() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
            int parseColor = JSMath.parseColor((String) arrayList.get(0));
            int parseColor2 = JSMath.parseColor((String) arrayList.get(1));
            return JSMath.sArgbEvaluator.evaluate((float) Math.min(1.0d, Math.max(0.0d, ((Double) arrayList.get(2)).doubleValue())), Integer.valueOf(parseColor), Integer.valueOf(parseColor2));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class o implements JSFunctionInterface {
        o() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
            return arrayList;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class p implements JSFunctionInterface {
        p() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) {
            return Double.valueOf(Math.cos(((Double) arrayList.get(0)).doubleValue()));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class q implements JSFunctionInterface {
        q() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) {
            return Double.valueOf(Math.tan(((Double) arrayList.get(0)).doubleValue()));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class r implements JSFunctionInterface {
        r() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) {
            return Double.valueOf(Math.asin(((Double) arrayList.get(0)).doubleValue()));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class s implements JSFunctionInterface {
        s() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) {
            return Double.valueOf(Math.acos(((Double) arrayList.get(0)).doubleValue()));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class t implements JSFunctionInterface {
        t() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) {
            return Double.valueOf(Math.atan(((Double) arrayList.get(0)).doubleValue()));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class u implements JSFunctionInterface {
        u() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) {
            return Double.valueOf(Math.atan2(((Double) arrayList.get(0)).doubleValue(), ((Double) arrayList.get(1)).doubleValue()));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class v implements JSFunctionInterface {
        v() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) {
            return Double.valueOf(Math.pow(((Double) arrayList.get(0)).doubleValue(), ((Double) arrayList.get(1)).doubleValue()));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class w implements JSFunctionInterface {
        w() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) {
            return Double.valueOf(Math.exp(((Double) arrayList.get(0)).doubleValue()));
        }
    }

    private JSMath() {
    }

    public static Object E() {
        return Double.valueOf(2.718281828459045d);
    }

    public static Object PI() {
        return Double.valueOf(3.141592653589793d);
    }

    public static Object abs() {
        return new d();
    }

    public static Object acos() {
        return new s();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void applyOrientationValuesToScope(Map<String, Object> map, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        map.put("alpha", Double.valueOf(d2));
        map.put("beta", Double.valueOf(d3));
        map.put("gamma", Double.valueOf(d4));
        map.put("dalpha", Double.valueOf(d2 - d5));
        map.put("dbeta", Double.valueOf(d3 - d6));
        map.put("dgamma", Double.valueOf(d4 - d7));
        map.put(Constants.Name.X, Double.valueOf(d8));
        map.put(Constants.Name.Y, Double.valueOf(d9));
        map.put("z", Double.valueOf(d10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void applyRotationInDegreesToScope(Map<String, Object> map, double d2) {
        map.put(UploadQueueMgr.MSGTYPE_REALTIME, Double.valueOf(d2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void applyScaleFactorToScope(Map<String, Object> map, double d2) {
        map.put("s", Double.valueOf(d2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void applyScrollValuesToScope(Map<String, Object> map, double d2, double d3, double d4, double d5, double d6, double d7, PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator) {
        map.put(Constants.Name.X, Double.valueOf(iDeviceResolutionTranslator.nativeToWeb(d2, new Object[0])));
        map.put(Constants.Name.Y, Double.valueOf(iDeviceResolutionTranslator.nativeToWeb(d3, new Object[0])));
        map.put("dx", Double.valueOf(iDeviceResolutionTranslator.nativeToWeb(d4, new Object[0])));
        map.put(Constants.Name.DISTANCE_Y, Double.valueOf(iDeviceResolutionTranslator.nativeToWeb(d5, new Object[0])));
        map.put("tdx", Double.valueOf(iDeviceResolutionTranslator.nativeToWeb(d6, new Object[0])));
        map.put("tdy", Double.valueOf(iDeviceResolutionTranslator.nativeToWeb(d7, new Object[0])));
        map.put("internal_x", Double.valueOf(d2));
        map.put("internal_y", Double.valueOf(d3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void applySpringValueToScope(Map<String, Object> map, double d2, double d3) {
        map.put("p", Double.valueOf(d2));
        map.put("v", Double.valueOf(d3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void applyTimingValuesToScope(Map<String, Object> map, double d2) {
        map.put("t", Double.valueOf(d2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void applyXYToScope(Map<String, Object> map, double d2, double d3, PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator) {
        map.put(Constants.Name.X, Double.valueOf(iDeviceResolutionTranslator.nativeToWeb(d2, new Object[0])));
        map.put(Constants.Name.Y, Double.valueOf(iDeviceResolutionTranslator.nativeToWeb(d3, new Object[0])));
        map.put("internal_x", Double.valueOf(d2));
        map.put("internal_y", Double.valueOf(d3));
    }

    public static Object asArray() {
        return new o();
    }

    public static Object asin() {
        return new r();
    }

    public static Object atan() {
        return new t();
    }

    public static Object atan2() {
        return new u();
    }

    public static Object cbrt() {
        return new b();
    }

    public static Object ceil() {
        return new f();
    }

    public static Object cos() {
        return new p();
    }

    public static Object evaluateColor() {
        return new n();
    }

    public static Object exp() {
        return new w();
    }

    public static Object floor() {
        return new g();
    }

    public static Object log() {
        return new c();
    }

    public static Object max() {
        return new i();
    }

    public static Object min() {
        return new j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int parseColor(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("'") || str.startsWith("\"")) {
                str = str.substring(1, str.length() - 1);
            }
            int parseColor = Color.parseColor(str);
            return Color.argb(255, Color.red(parseColor), Color.green(parseColor), Color.blue(parseColor));
        }
        throw new IllegalArgumentException("Unknown color");
    }

    public static Object pow() {
        return new v();
    }

    public static Object rgb() {
        return new l();
    }

    public static Object rgba() {
        return new m();
    }

    public static Object round() {
        return new h();
    }

    public static Object sign() {
        return new e();
    }

    public static Object sin() {
        return new k();
    }

    public static Object sqrt() {
        return new a();
    }

    public static Object tan() {
        return new q();
    }
}
