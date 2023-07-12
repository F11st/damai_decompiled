package com.alibaba.aliweex.adapter.component;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.ICheckBindingScroller;
import com.taobao.weex.common.OnWXScrollListener;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.Scrollable;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXDiv;
import com.taobao.weex.ui.component.WXVContainer;
import com.taobao.weex.ui.view.WXFrameLayout;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXResourceUtils;
import com.taobao.weex.utils.WXViewUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class WXParallax extends WXDiv implements ICheckBindingScroller, OnWXScrollListener {
    public static final String BINDING_SCROLLER = "bindingScroller";
    public static final String PARALLAX = "parallax";
    public static final String WX_OPACITY = "opacity";
    public static final String WX_TRANSFORM = "transform";
    C3031b mBackgroundColor;
    String mBindingRef;
    private float mOffsetY;
    private Integer mPreBackGroundColor;
    ArrayList<C3032c> mTransformPropArrayList;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.aliweex.adapter.component.WXParallax$b */
    /* loaded from: classes15.dex */
    public class C3031b {
        int[] a;
        int[] b;

        private C3031b() {
        }

        int a(int i, int i2) {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.d("WXParallax:getColor: XDelta" + i + " YDelta:" + i2 + " mOffsetY" + WXParallax.this.mOffsetY);
            }
            if (WXParallax.this.mOffsetY <= this.a[1]) {
                if (WXParallax.this.mOffsetY < this.a[0]) {
                    return this.b[0];
                }
                int red = Color.red(this.b[0]);
                int red2 = ((int) (WXParallax.this.mOffsetY - this.a[0])) * (Color.red(this.b[1]) - Color.red(this.b[0]));
                int[] iArr = this.a;
                int i3 = red + (red2 / (iArr[1] - iArr[0]));
                int green = Color.green(this.b[0]);
                int green2 = ((int) (WXParallax.this.mOffsetY - this.a[0])) * (Color.green(this.b[1]) - Color.green(this.b[0]));
                int[] iArr2 = this.a;
                int i4 = green + (green2 / (iArr2[1] - iArr2[0]));
                int blue = Color.blue(this.b[0]);
                int blue2 = ((int) (WXParallax.this.mOffsetY - this.a[0])) * (Color.blue(this.b[1]) - Color.blue(this.b[0]));
                int[] iArr3 = this.a;
                int i5 = blue + (blue2 / (iArr3[1] - iArr3[0]));
                int alpha = Color.alpha(this.b[0]);
                int alpha2 = ((int) (WXParallax.this.mOffsetY - this.a[0])) * (Color.alpha(this.b[1]) - Color.alpha(this.b[0]));
                int[] iArr4 = this.a;
                int i6 = alpha + (alpha2 / (iArr4[1] - iArr4[0]));
                if (WXEnvironment.isApkDebugable()) {
                    WXLogUtils.d("WXParallax:getColor: r1" + i3 + " g1:" + i4 + " b1:" + i5);
                }
                return Color.argb(i6, i3, i4, i5);
            }
            return this.b[1];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.aliweex.adapter.component.WXParallax$c */
    /* loaded from: classes15.dex */
    public class C3032c {
        String a;
        float[] b;
        float[] c;
        float d;
        float e;
        float f;
        float g;
        float h;
        float i;

        C3032c(String str, JSONObject jSONObject) {
            this.a = str;
            JSONArray jSONArray = jSONObject.getJSONArray("in");
            int size = jSONArray.size();
            this.b = new float[size];
            for (int i = 0; i < size; i++) {
                this.b[i] = WXViewUtils.getRealPxByWidth(jSONArray.getFloatValue(i), WXParallax.this.getInstance().getInstanceViewPortWidth());
            }
            this.c = b(jSONObject.getJSONArray("out"));
            String str2 = this.a;
            str2.hashCode();
            char c = 65535;
            switch (str2.hashCode()) {
                case -1267206133:
                    if (str2.equals("opacity")) {
                        c = 0;
                        break;
                    }
                    break;
                case -925180581:
                    if (str2.equals("rotate")) {
                        c = 1;
                        break;
                    }
                    break;
                case 109250890:
                    if (str2.equals("scale")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1052832078:
                    if (str2.equals("translate")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.i = this.c[0];
                    return;
                case 1:
                    this.h = this.c[0];
                    return;
                case 2:
                    float[] fArr = this.c;
                    this.f = fArr[0];
                    this.g = fArr[1];
                    return;
                case 3:
                    int i2 = 0;
                    while (true) {
                        float[] fArr2 = this.c;
                        if (i2 < fArr2.length) {
                            fArr2[i2] = WXViewUtils.getRealPxByWidth(fArr2[i2], WXParallax.this.getInstance().getInstanceViewPortWidth());
                            i2++;
                        } else {
                            this.d = fArr2[0];
                            this.e = fArr2[1];
                            return;
                        }
                    }
                default:
                    return;
            }
        }

        void a(float f, float f2) {
            float f3 = WXParallax.this.mOffsetY;
            float[] fArr = this.b;
            if (f3 > fArr[1]) {
                f3 = fArr[1];
            }
            if (f3 < fArr[0]) {
                f3 = fArr[0];
            }
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.d("WXParallax", "type:" + this.a + " XDelta:" + f + " YDelta:" + f2);
            }
            String str = this.a;
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1267206133:
                    if (str.equals("opacity")) {
                        c = 0;
                        break;
                    }
                    break;
                case -925180581:
                    if (str.equals("rotate")) {
                        c = 1;
                        break;
                    }
                    break;
                case 109250890:
                    if (str.equals("scale")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1052832078:
                    if (str.equals("translate")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    float[] fArr2 = this.c;
                    float f4 = fArr2[0];
                    float f5 = fArr2[1] - fArr2[0];
                    float[] fArr3 = this.b;
                    float f6 = f4 + ((f5 * (f3 - fArr3[0])) / (fArr3[1] - fArr3[0]));
                    if (this.i != f6) {
                        WXParallax.this.setOpacity(f6);
                        if (WXEnvironment.isApkDebugable()) {
                            WXLogUtils.d("WXParallax", "opacity fromOpacity:" + this.i + " toOpacity:" + f6);
                        }
                        this.i = f6;
                        return;
                    }
                    return;
                case 1:
                    float[] fArr4 = this.c;
                    float f7 = fArr4[0];
                    float f8 = fArr4[1] - fArr4[0];
                    float[] fArr5 = this.b;
                    float f9 = f7 + ((f8 * (f3 - fArr5[0])) / (fArr5[1] - fArr5[0]));
                    if (this.h != f9) {
                        ((WXFrameLayout) WXParallax.this.getHostView()).setRotation(f9);
                        this.h = f9;
                        return;
                    }
                    return;
                case 2:
                    float[] fArr6 = this.c;
                    float f10 = fArr6[0];
                    float f11 = fArr6[2] - fArr6[0];
                    float[] fArr7 = this.b;
                    float f12 = f10 + ((f11 * (f3 - fArr7[0])) / (fArr7[1] - fArr7[0]));
                    float f13 = fArr6[1] + (((fArr6[3] - fArr6[1]) * (f3 - fArr7[0])) / (fArr7[1] - fArr7[0]));
                    if (this.f == f12 && this.g == f13) {
                        return;
                    }
                    ((WXFrameLayout) WXParallax.this.getHostView()).setScaleX(f12);
                    ((WXFrameLayout) WXParallax.this.getHostView()).setScaleY(f13);
                    if (WXEnvironment.isApkDebugable()) {
                        WXLogUtils.d("WXParallax", " fromScaleX:" + this.f + " toScaleX:" + f12 + " fromScaleY:" + this.g + " toScaleY:" + f13);
                    }
                    this.f = f12;
                    this.g = f13;
                    return;
                case 3:
                    float[] fArr8 = this.c;
                    float f14 = fArr8[0];
                    float f15 = fArr8[2] - fArr8[0];
                    float[] fArr9 = this.b;
                    float f16 = f14 + ((f15 * (f3 - fArr9[0])) / (fArr9[1] - fArr9[0]));
                    float f17 = fArr8[1] + (((fArr8[3] - fArr8[1]) * (f3 - fArr9[0])) / (fArr9[1] - fArr9[0]));
                    if (this.d == f16 && this.e == f17) {
                        return;
                    }
                    ((WXFrameLayout) WXParallax.this.getHostView()).setTranslationX(f16);
                    ((WXFrameLayout) WXParallax.this.getHostView()).setTranslationY(f17);
                    if (WXEnvironment.isApkDebugable()) {
                        WXLogUtils.d("WXParallax", "XDelta:" + f + " YDelta:" + f2);
                        WXLogUtils.d("WXParallax", " fromTranslateX:" + this.d + " toTranslateX:" + f16 + " fromTranslateY:" + this.e + " toTranslateY:" + f17);
                    }
                    this.d = f16;
                    this.e = f17;
                    return;
                default:
                    return;
            }
        }

        float[] b(JSONArray jSONArray) {
            int size = jSONArray.size();
            float[] fArr = new float[size];
            for (int i = 0; i < size; i++) {
                fArr[i] = jSONArray.getFloatValue(i);
            }
            return fArr;
        }
    }

    public WXParallax(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
        this.mTransformPropArrayList = new ArrayList<>();
        this.mBindingRef = "";
        this.mPreBackGroundColor = null;
        this.mOffsetY = 0.0f;
        initTransform(String.valueOf(getAttrs().get("transform")));
        initOpacity(String.valueOf(getAttrs().get("opacity")));
        initBackgroundColor(String.valueOf(getAttrs().get("backgroundColor")));
        this.mBindingRef = (String) getAttrs().get(BINDING_SCROLLER);
        wXSDKInstance.registerOnWXScrollListener(this);
    }

    private void initBackgroundColor(String str) {
        JSONObject parseObject;
        if (TextUtils.isEmpty(str) || (parseObject = JSON.parseObject(str)) == null) {
            return;
        }
        this.mBackgroundColor = new C3031b();
        JSONArray jSONArray = parseObject.getJSONArray("in");
        this.mBackgroundColor.a = new int[jSONArray.size()];
        for (int i = 0; i < jSONArray.size(); i++) {
            this.mBackgroundColor.a[i] = (int) WXViewUtils.getRealPxByWidth(jSONArray.getInteger(i).intValue(), getInstance().getInstanceViewPortWidth());
        }
        JSONArray jSONArray2 = parseObject.getJSONArray("out");
        this.mBackgroundColor.b = new int[jSONArray2.size()];
        for (int i2 = 0; i2 < jSONArray2.size(); i2++) {
            this.mBackgroundColor.b[i2] = WXResourceUtils.getColor(jSONArray2.getString(i2));
        }
    }

    private void initOpacity(String str) {
        if (TextUtils.isEmpty(str)) {
            WXLogUtils.w("WXParallax initOpacity opacity == null");
            return;
        }
        JSONObject parseObject = JSON.parseObject(str);
        if (parseObject != null) {
            this.mTransformPropArrayList.add(new C3032c("opacity", parseObject));
        }
    }

    private void initTransform(String str) {
        if (str == null) {
            WXLogUtils.w("WXParallax initTransform == null");
            return;
        }
        JSONArray parseArray = JSON.parseArray(str);
        if (parseArray != null) {
            for (int i = 0; i < parseArray.size(); i++) {
                JSONObject jSONObject = parseArray.getJSONObject(i);
                this.mTransformPropArrayList.add(i, new C3032c(jSONObject.getString("type"), jSONObject));
            }
        }
    }

    @Override // com.taobao.weex.common.ICheckBindingScroller
    public boolean isNeedScroller(String str, Object obj) {
        WXComponent rootComponent;
        Scrollable firstScroller;
        String str2 = (String) getAttrs().get(BINDING_SCROLLER);
        this.mBindingRef = str2;
        if (TextUtils.isEmpty(str2) && (rootComponent = getInstance().getRootComponent()) != null && (rootComponent instanceof WXVContainer) && (firstScroller = rootComponent.getFirstScroller()) != null) {
            this.mBindingRef = firstScroller.getRef();
        }
        return (TextUtils.isEmpty(this.mBindingRef) || TextUtils.isEmpty(str) || !str.equals(this.mBindingRef)) ? false : true;
    }

    @Override // com.taobao.weex.common.OnWXScrollListener
    public void onScrollStateChanged(View view, int i, int i2, int i3) {
    }

    @Override // com.taobao.weex.common.OnWXScrollListener
    public void onScrolled(View view, int i, int i2) {
        float f = i2;
        this.mOffsetY += f;
        if (getHostView() != 0) {
            Iterator<C3032c> it = this.mTransformPropArrayList.iterator();
            while (it.hasNext()) {
                it.next().a(i, f);
            }
            C3031b c3031b = this.mBackgroundColor;
            if (c3031b != null) {
                int a = c3031b.a(i, i2);
                Integer num = this.mPreBackGroundColor;
                if (num == null || num.intValue() != a) {
                    ((WXFrameLayout) getHostView()).setBackgroundColor(a);
                    this.mPreBackGroundColor = Integer.valueOf(a);
                }
            }
        }
    }
}
