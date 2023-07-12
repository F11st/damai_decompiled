package tb;

import android.graphics.Matrix;
import com.alipay.sdk.m.s.C4293a;
import com.huawei.hms.opendevice.AbstractC5658c;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.opensource.svgaplayer.SVGAVideoShapeEntity;
import com.opensource.svgaplayer.proto.FrameEntity;
import com.opensource.svgaplayer.proto.Layout;
import com.opensource.svgaplayer.proto.ShapeEntity;
import com.opensource.svgaplayer.proto.Transform;
import com.taobao.weex.common.Constants;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.C8214m;
import kotlin.collections.C8215n;
import kotlin.collections.CollectionsKt___CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class e52 {
    private double a;
    @NotNull
    private z42 b;
    @NotNull
    private Matrix c;
    @Nullable
    private v42 d;
    @NotNull
    private List<SVGAVideoShapeEntity> e;

    public e52(@NotNull JSONObject jSONObject) {
        List<SVGAVideoShapeEntity> g;
        boolean z;
        List<SVGAVideoShapeEntity> A0;
        e52 e52Var = this;
        b41.j(jSONObject, "obj");
        e52Var.b = new z42(0.0d, 0.0d, 0.0d, 0.0d);
        e52Var.c = new Matrix();
        g = C8214m.g();
        e52Var.e = g;
        e52Var.a = jSONObject.optDouble("alpha", 0.0d);
        JSONObject optJSONObject = jSONObject.optJSONObject("layout");
        if (optJSONObject != null) {
            e52Var.b = new z42(optJSONObject.optDouble(Constants.Name.X, 0.0d), optJSONObject.optDouble(Constants.Name.Y, 0.0d), optJSONObject.optDouble("width", 0.0d), optJSONObject.optDouble("height", 0.0d));
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("transform");
        if (optJSONObject2 != null) {
            double optDouble = optJSONObject2.optDouble("a", 1.0d);
            double optDouble2 = optJSONObject2.optDouble("b", 0.0d);
            double optDouble3 = optJSONObject2.optDouble(AbstractC5658c.a, 0.0d);
            double optDouble4 = optJSONObject2.optDouble("d", 1.0d);
            double optDouble5 = optJSONObject2.optDouble("tx", 0.0d);
            double optDouble6 = optJSONObject2.optDouble(C4293a.s, 0.0d);
            float f = (float) optDouble3;
            z = true;
            float f2 = (float) 0.0d;
            float[] fArr = {(float) optDouble, f, (float) optDouble5, (float) optDouble2, (float) optDouble4, (float) optDouble6, f2, f2, (float) 1.0d};
            e52Var = this;
            e52Var.c.setValues(fArr);
        } else {
            z = true;
        }
        String optString = jSONObject.optString("clipPath");
        if (optString != null) {
            if (optString.length() <= 0 ? false : z) {
                e52Var.d = new v42(optString);
            }
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("shapes");
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                if (optJSONObject3 != null) {
                    arrayList.add(new SVGAVideoShapeEntity(optJSONObject3));
                }
            }
            A0 = CollectionsKt___CollectionsKt.A0(arrayList);
            e52Var.e = A0;
        }
    }

    public final double a() {
        return this.a;
    }

    @NotNull
    public final z42 b() {
        return this.b;
    }

    @Nullable
    public final v42 c() {
        return this.d;
    }

    @NotNull
    public final List<SVGAVideoShapeEntity> d() {
        return this.e;
    }

    @NotNull
    public final Matrix e() {
        return this.c;
    }

    public final void f(@NotNull List<SVGAVideoShapeEntity> list) {
        b41.j(list, "<set-?>");
        this.e = list;
    }

    public e52(@NotNull FrameEntity frameEntity) {
        List<SVGAVideoShapeEntity> g;
        Float f;
        int q;
        Float f2;
        b41.j(frameEntity, "obj");
        this.b = new z42(0.0d, 0.0d, 0.0d, 0.0d);
        this.c = new Matrix();
        g = C8214m.g();
        this.e = g;
        this.a = frameEntity.alpha != null ? f.floatValue() : 0.0f;
        Layout layout = frameEntity.layout;
        if (layout != null) {
            Float f3 = layout.x;
            double floatValue = f3 != null ? f3.floatValue() : 0.0f;
            Float f4 = layout.y;
            double floatValue2 = f4 != null ? f4.floatValue() : 0.0f;
            Float f5 = layout.width;
            this.b = new z42(floatValue, floatValue2, f5 != null ? f5.floatValue() : 0.0f, layout.height != null ? f2.floatValue() : 0.0f);
        }
        Transform transform = frameEntity.transform;
        if (transform != null) {
            float[] fArr = new float[9];
            Float f6 = transform.a;
            float floatValue3 = f6 != null ? f6.floatValue() : 1.0f;
            Float f7 = transform.b;
            float floatValue4 = f7 != null ? f7.floatValue() : 0.0f;
            Float f8 = transform.c;
            float floatValue5 = f8 != null ? f8.floatValue() : 0.0f;
            Float f9 = transform.d;
            float floatValue6 = f9 != null ? f9.floatValue() : 1.0f;
            Float f10 = transform.tx;
            float floatValue7 = f10 != null ? f10.floatValue() : 0.0f;
            Float f11 = transform.ty;
            float floatValue8 = f11 != null ? f11.floatValue() : 0.0f;
            fArr[0] = floatValue3;
            fArr[1] = floatValue5;
            fArr[2] = floatValue7;
            fArr[3] = floatValue4;
            fArr[4] = floatValue6;
            fArr[5] = floatValue8;
            fArr[6] = 0.0f;
            fArr[7] = 0.0f;
            fArr[8] = 1.0f;
            this.c.setValues(fArr);
        }
        String str = frameEntity.clipPath;
        if (str != null) {
            str = str.length() > 0 ? str : null;
            if (str != null) {
                this.d = new v42(str);
            }
        }
        List<ShapeEntity> list = frameEntity.shapes;
        q = C8215n.q(list, 10);
        ArrayList arrayList = new ArrayList(q);
        for (ShapeEntity shapeEntity : list) {
            b41.e(shapeEntity, AdvanceSetting.NETWORK_TYPE);
            arrayList.add(new SVGAVideoShapeEntity(shapeEntity));
        }
        this.e = arrayList;
    }
}
