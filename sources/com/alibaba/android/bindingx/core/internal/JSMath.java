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
    /* renamed from: com.alibaba.android.bindingx.core.internal.JSMath$a */
    /* loaded from: classes5.dex */
    static class C3153a implements JSFunctionInterface {
        C3153a() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) {
            return Double.valueOf(Math.sqrt(((Double) arrayList.get(0)).doubleValue()));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.bindingx.core.internal.JSMath$b */
    /* loaded from: classes5.dex */
    static class C3154b implements JSFunctionInterface {
        C3154b() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) {
            return Double.valueOf(Math.cbrt(((Double) arrayList.get(0)).doubleValue()));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.bindingx.core.internal.JSMath$c */
    /* loaded from: classes5.dex */
    static class C3155c implements JSFunctionInterface {
        C3155c() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) {
            return Double.valueOf(Math.log(((Double) arrayList.get(0)).doubleValue()));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.bindingx.core.internal.JSMath$d */
    /* loaded from: classes5.dex */
    static class C3156d implements JSFunctionInterface {
        C3156d() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) {
            return Double.valueOf(Math.abs(((Double) arrayList.get(0)).doubleValue()));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.bindingx.core.internal.JSMath$e */
    /* loaded from: classes5.dex */
    static class C3157e implements JSFunctionInterface {
        C3157e() {
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
    /* renamed from: com.alibaba.android.bindingx.core.internal.JSMath$f */
    /* loaded from: classes5.dex */
    static class C3158f implements JSFunctionInterface {
        C3158f() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) {
            return Double.valueOf(Math.ceil(((Double) arrayList.get(0)).doubleValue()));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.bindingx.core.internal.JSMath$g */
    /* loaded from: classes5.dex */
    static class C3159g implements JSFunctionInterface {
        C3159g() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) {
            return Double.valueOf(Math.floor(((Double) arrayList.get(0)).doubleValue()));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.bindingx.core.internal.JSMath$h */
    /* loaded from: classes5.dex */
    static class C3160h implements JSFunctionInterface {
        C3160h() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) {
            return Long.valueOf(Math.round(((Double) arrayList.get(0)).doubleValue()));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.bindingx.core.internal.JSMath$i */
    /* loaded from: classes5.dex */
    static class C3161i implements JSFunctionInterface {
        C3161i() {
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
    /* renamed from: com.alibaba.android.bindingx.core.internal.JSMath$j */
    /* loaded from: classes5.dex */
    static class C3162j implements JSFunctionInterface {
        C3162j() {
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
    /* renamed from: com.alibaba.android.bindingx.core.internal.JSMath$k */
    /* loaded from: classes5.dex */
    static class C3163k implements JSFunctionInterface {
        C3163k() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) {
            return Double.valueOf(Math.sin(((Double) arrayList.get(0)).doubleValue()));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.bindingx.core.internal.JSMath$l */
    /* loaded from: classes5.dex */
    static class C3164l implements JSFunctionInterface {
        C3164l() {
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
    /* renamed from: com.alibaba.android.bindingx.core.internal.JSMath$m */
    /* loaded from: classes5.dex */
    static class C3165m implements JSFunctionInterface {
        C3165m() {
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
    /* renamed from: com.alibaba.android.bindingx.core.internal.JSMath$n */
    /* loaded from: classes5.dex */
    static class C3166n implements JSFunctionInterface {
        C3166n() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
            int parseColor = JSMath.parseColor((String) arrayList.get(0));
            int parseColor2 = JSMath.parseColor((String) arrayList.get(1));
            return JSMath.sArgbEvaluator.evaluate((float) Math.min(1.0d, Math.max(0.0d, ((Double) arrayList.get(2)).doubleValue())), Integer.valueOf(parseColor), Integer.valueOf(parseColor2));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.bindingx.core.internal.JSMath$o */
    /* loaded from: classes5.dex */
    static class C3167o implements JSFunctionInterface {
        C3167o() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
            return arrayList;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.bindingx.core.internal.JSMath$p */
    /* loaded from: classes5.dex */
    static class C3168p implements JSFunctionInterface {
        C3168p() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) {
            return Double.valueOf(Math.cos(((Double) arrayList.get(0)).doubleValue()));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.bindingx.core.internal.JSMath$q */
    /* loaded from: classes5.dex */
    static class C3169q implements JSFunctionInterface {
        C3169q() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) {
            return Double.valueOf(Math.tan(((Double) arrayList.get(0)).doubleValue()));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.bindingx.core.internal.JSMath$r */
    /* loaded from: classes5.dex */
    static class C3170r implements JSFunctionInterface {
        C3170r() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) {
            return Double.valueOf(Math.asin(((Double) arrayList.get(0)).doubleValue()));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.bindingx.core.internal.JSMath$s */
    /* loaded from: classes5.dex */
    static class C3171s implements JSFunctionInterface {
        C3171s() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) {
            return Double.valueOf(Math.acos(((Double) arrayList.get(0)).doubleValue()));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.bindingx.core.internal.JSMath$t */
    /* loaded from: classes5.dex */
    static class C3172t implements JSFunctionInterface {
        C3172t() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) {
            return Double.valueOf(Math.atan(((Double) arrayList.get(0)).doubleValue()));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.bindingx.core.internal.JSMath$u */
    /* loaded from: classes5.dex */
    static class C3173u implements JSFunctionInterface {
        C3173u() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) {
            return Double.valueOf(Math.atan2(((Double) arrayList.get(0)).doubleValue(), ((Double) arrayList.get(1)).doubleValue()));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.bindingx.core.internal.JSMath$v */
    /* loaded from: classes5.dex */
    static class C3174v implements JSFunctionInterface {
        C3174v() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) {
            return Double.valueOf(Math.pow(((Double) arrayList.get(0)).doubleValue(), ((Double) arrayList.get(1)).doubleValue()));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.bindingx.core.internal.JSMath$w */
    /* loaded from: classes5.dex */
    static class C3175w implements JSFunctionInterface {
        C3175w() {
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
        return new C3156d();
    }

    public static Object acos() {
        return new C3171s();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void applyOrientationValuesToScope(Map<String, Object> map, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        map.put("alpha", Double.valueOf(d));
        map.put("beta", Double.valueOf(d2));
        map.put("gamma", Double.valueOf(d3));
        map.put("dalpha", Double.valueOf(d - d4));
        map.put("dbeta", Double.valueOf(d2 - d5));
        map.put("dgamma", Double.valueOf(d3 - d6));
        map.put(Constants.Name.X, Double.valueOf(d7));
        map.put(Constants.Name.Y, Double.valueOf(d8));
        map.put("z", Double.valueOf(d9));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void applyRotationInDegreesToScope(Map<String, Object> map, double d) {
        map.put(UploadQueueMgr.MSGTYPE_REALTIME, Double.valueOf(d));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void applyScaleFactorToScope(Map<String, Object> map, double d) {
        map.put("s", Double.valueOf(d));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void applyScrollValuesToScope(Map<String, Object> map, double d, double d2, double d3, double d4, double d5, double d6, PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator) {
        map.put(Constants.Name.X, Double.valueOf(iDeviceResolutionTranslator.nativeToWeb(d, new Object[0])));
        map.put(Constants.Name.Y, Double.valueOf(iDeviceResolutionTranslator.nativeToWeb(d2, new Object[0])));
        map.put("dx", Double.valueOf(iDeviceResolutionTranslator.nativeToWeb(d3, new Object[0])));
        map.put(Constants.Name.DISTANCE_Y, Double.valueOf(iDeviceResolutionTranslator.nativeToWeb(d4, new Object[0])));
        map.put("tdx", Double.valueOf(iDeviceResolutionTranslator.nativeToWeb(d5, new Object[0])));
        map.put("tdy", Double.valueOf(iDeviceResolutionTranslator.nativeToWeb(d6, new Object[0])));
        map.put("internal_x", Double.valueOf(d));
        map.put("internal_y", Double.valueOf(d2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void applySpringValueToScope(Map<String, Object> map, double d, double d2) {
        map.put("p", Double.valueOf(d));
        map.put("v", Double.valueOf(d2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void applyTimingValuesToScope(Map<String, Object> map, double d) {
        map.put("t", Double.valueOf(d));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void applyXYToScope(Map<String, Object> map, double d, double d2, PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator) {
        map.put(Constants.Name.X, Double.valueOf(iDeviceResolutionTranslator.nativeToWeb(d, new Object[0])));
        map.put(Constants.Name.Y, Double.valueOf(iDeviceResolutionTranslator.nativeToWeb(d2, new Object[0])));
        map.put("internal_x", Double.valueOf(d));
        map.put("internal_y", Double.valueOf(d2));
    }

    public static Object asArray() {
        return new C3167o();
    }

    public static Object asin() {
        return new C3170r();
    }

    public static Object atan() {
        return new C3172t();
    }

    public static Object atan2() {
        return new C3173u();
    }

    public static Object cbrt() {
        return new C3154b();
    }

    public static Object ceil() {
        return new C3158f();
    }

    public static Object cos() {
        return new C3168p();
    }

    public static Object evaluateColor() {
        return new C3166n();
    }

    public static Object exp() {
        return new C3175w();
    }

    public static Object floor() {
        return new C3159g();
    }

    public static Object log() {
        return new C3155c();
    }

    public static Object max() {
        return new C3161i();
    }

    public static Object min() {
        return new C3162j();
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
        return new C3174v();
    }

    public static Object rgb() {
        return new C3164l();
    }

    public static Object rgba() {
        return new C3165m();
    }

    public static Object round() {
        return new C3160h();
    }

    public static Object sign() {
        return new C3157e();
    }

    public static Object sin() {
        return new C3163k();
    }

    public static Object sqrt() {
        return new C3153a();
    }

    public static Object tan() {
        return new C3169q();
    }
}
