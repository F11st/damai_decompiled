package com.opensource.svgaplayer;

import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.huawei.hms.opendevice.c;
import com.opensource.svgaplayer.proto.ShapeEntity;
import com.opensource.svgaplayer.proto.Transform;
import com.taobao.weex.common.Constants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tb.b41;
import tb.b52;
import tb.c52;
import tb.v42;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class SVGAVideoShapeEntity {
    @NotNull
    private Type a;
    @Nullable
    private Map<String, ? extends Object> b;
    @Nullable
    private a c;
    @Nullable
    private Matrix d;
    @Nullable
    private Path e;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/opensource/svgaplayer/SVGAVideoShapeEntity$Type;", "", "<init>", "(Ljava/lang/String;I)V", "shape", "rect", "ellipse", "keep", "library_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes10.dex */
    public enum Type {
        shape,
        rect,
        ellipse,
        keep
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class a {
        private int a;
        private int b;
        private float c;
        private int f;
        @NotNull
        private String d = "butt";
        @NotNull
        private String e = "miter";
        @NotNull
        private float[] g = new float[0];

        public final int a() {
            return this.a;
        }

        @NotNull
        public final String b() {
            return this.d;
        }

        @NotNull
        public final float[] c() {
            return this.g;
        }

        @NotNull
        public final String d() {
            return this.e;
        }

        public final int e() {
            return this.f;
        }

        public final int f() {
            return this.b;
        }

        public final float g() {
            return this.c;
        }

        public final void h(int i) {
            this.a = i;
        }

        public final void i(@NotNull String str) {
            b41.j(str, "<set-?>");
            this.d = str;
        }

        public final void j(@NotNull float[] fArr) {
            b41.j(fArr, "<set-?>");
            this.g = fArr;
        }

        public final void k(@NotNull String str) {
            b41.j(str, "<set-?>");
            this.e = str;
        }

        public final void l(int i) {
            this.f = i;
        }

        public final void m(int i) {
            this.b = i;
        }

        public final void n(float f) {
            this.c = f;
        }
    }

    public SVGAVideoShapeEntity(@NotNull JSONObject jSONObject) {
        b41.j(jSONObject, "obj");
        this.a = Type.shape;
        m(jSONObject);
        g(jSONObject);
        i(jSONObject);
        k(jSONObject);
    }

    private final void f(ShapeEntity shapeEntity) {
        String str;
        HashMap hashMap = new HashMap();
        ShapeEntity.ShapeArgs shapeArgs = shapeEntity.shape;
        if (shapeArgs != null && (str = shapeArgs.d) != null) {
            hashMap.put("d", str);
        }
        ShapeEntity.EllipseArgs ellipseArgs = shapeEntity.ellipse;
        if (ellipseArgs != null) {
            Float f = ellipseArgs.x;
            if (f == null) {
                f = Float.valueOf(0.0f);
            }
            hashMap.put(Constants.Name.X, f);
            Float f2 = ellipseArgs.y;
            if (f2 == null) {
                f2 = Float.valueOf(0.0f);
            }
            hashMap.put(Constants.Name.Y, f2);
            Float f3 = ellipseArgs.radiusX;
            if (f3 == null) {
                f3 = Float.valueOf(0.0f);
            }
            hashMap.put("radiusX", f3);
            Float f4 = ellipseArgs.radiusY;
            if (f4 == null) {
                f4 = Float.valueOf(0.0f);
            }
            hashMap.put("radiusY", f4);
        }
        ShapeEntity.RectArgs rectArgs = shapeEntity.rect;
        if (rectArgs != null) {
            Float f5 = rectArgs.x;
            if (f5 == null) {
                f5 = Float.valueOf(0.0f);
            }
            hashMap.put(Constants.Name.X, f5);
            Float f6 = rectArgs.y;
            if (f6 == null) {
                f6 = Float.valueOf(0.0f);
            }
            hashMap.put(Constants.Name.Y, f6);
            Float f7 = rectArgs.width;
            if (f7 == null) {
                f7 = Float.valueOf(0.0f);
            }
            hashMap.put("width", f7);
            Float f8 = rectArgs.height;
            if (f8 == null) {
                f8 = Float.valueOf(0.0f);
            }
            hashMap.put("height", f8);
            Float f9 = rectArgs.cornerRadius;
            if (f9 == null) {
                f9 = Float.valueOf(0.0f);
            }
            hashMap.put("cornerRadius", f9);
        }
        this.b = hashMap;
    }

    private final void g(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        JSONObject optJSONObject = jSONObject.optJSONObject("args");
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = optJSONObject.get(next);
                if (obj != null) {
                    hashMap.put(next, obj);
                }
            }
            this.b = hashMap;
        }
    }

    private final void h(ShapeEntity shapeEntity) {
        ShapeEntity.ShapeStyle shapeStyle = shapeEntity.styles;
        if (shapeStyle != null) {
            a aVar = new a();
            ShapeEntity.ShapeStyle.RGBAColor rGBAColor = shapeStyle.fill;
            if (rGBAColor != null) {
                Float f = rGBAColor.a;
                float f2 = 255;
                int floatValue = (int) ((f != null ? f.floatValue() : 0.0f) * f2);
                Float f3 = rGBAColor.r;
                int floatValue2 = (int) ((f3 != null ? f3.floatValue() : 0.0f) * f2);
                Float f4 = rGBAColor.g;
                int floatValue3 = (int) ((f4 != null ? f4.floatValue() : 0.0f) * f2);
                Float f5 = rGBAColor.b;
                aVar.h(Color.argb(floatValue, floatValue2, floatValue3, (int) ((f5 != null ? f5.floatValue() : 0.0f) * f2)));
            }
            ShapeEntity.ShapeStyle.RGBAColor rGBAColor2 = shapeStyle.stroke;
            if (rGBAColor2 != null) {
                Float f6 = rGBAColor2.a;
                float f7 = 255;
                int floatValue4 = (int) ((f6 != null ? f6.floatValue() : 0.0f) * f7);
                Float f8 = rGBAColor2.r;
                int floatValue5 = (int) ((f8 != null ? f8.floatValue() : 0.0f) * f7);
                Float f9 = rGBAColor2.g;
                int floatValue6 = (int) ((f9 != null ? f9.floatValue() : 0.0f) * f7);
                Float f10 = rGBAColor2.b;
                aVar.m(Color.argb(floatValue4, floatValue5, floatValue6, (int) ((f10 != null ? f10.floatValue() : 0.0f) * f7)));
            }
            Float f11 = shapeStyle.strokeWidth;
            aVar.n(f11 != null ? f11.floatValue() : 0.0f);
            ShapeEntity.ShapeStyle.LineCap lineCap = shapeStyle.lineCap;
            if (lineCap != null) {
                int i = b52.$EnumSwitchMapping$1[lineCap.ordinal()];
                if (i == 1) {
                    aVar.i("butt");
                } else if (i == 2) {
                    aVar.i("round");
                } else if (i == 3) {
                    aVar.i("square");
                }
            }
            ShapeEntity.ShapeStyle.LineJoin lineJoin = shapeStyle.lineJoin;
            if (lineJoin != null) {
                int i2 = b52.$EnumSwitchMapping$2[lineJoin.ordinal()];
                if (i2 == 1) {
                    aVar.k("bevel");
                } else if (i2 == 2) {
                    aVar.k("miter");
                } else if (i2 == 3) {
                    aVar.k("round");
                }
            }
            Float f12 = shapeStyle.miterLimit;
            aVar.l((int) (f12 != null ? f12.floatValue() : 0.0f));
            aVar.j(new float[3]);
            Float f13 = shapeStyle.lineDashI;
            if (f13 != null) {
                aVar.c()[0] = f13.floatValue();
            }
            Float f14 = shapeStyle.lineDashII;
            if (f14 != null) {
                aVar.c()[1] = f14.floatValue();
            }
            Float f15 = shapeStyle.lineDashIII;
            if (f15 != null) {
                aVar.c()[2] = f15.floatValue();
            }
            this.c = aVar;
        }
    }

    private final void i(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("styles");
        if (optJSONObject != null) {
            a aVar = new a();
            JSONArray optJSONArray = optJSONObject.optJSONArray("fill");
            if (optJSONArray != null && optJSONArray.length() == 4) {
                double d = 255;
                aVar.h(Color.argb((int) (optJSONArray.optDouble(3) * d), (int) (optJSONArray.optDouble(0) * d), (int) (optJSONArray.optDouble(1) * d), (int) (optJSONArray.optDouble(2) * d)));
            }
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("stroke");
            if (optJSONArray2 != null && optJSONArray2.length() == 4) {
                double d2 = 255;
                aVar.m(Color.argb((int) (optJSONArray2.optDouble(3) * d2), (int) (optJSONArray2.optDouble(0) * d2), (int) (optJSONArray2.optDouble(1) * d2), (int) (optJSONArray2.optDouble(2) * d2)));
            }
            aVar.n((float) optJSONObject.optDouble("strokeWidth", 0.0d));
            String optString = optJSONObject.optString("lineCap", "butt");
            b41.e(optString, "it.optString(\"lineCap\", \"butt\")");
            aVar.i(optString);
            String optString2 = optJSONObject.optString("lineJoin", "miter");
            b41.e(optString2, "it.optString(\"lineJoin\", \"miter\")");
            aVar.k(optString2);
            aVar.l(optJSONObject.optInt("miterLimit", 0));
            JSONArray optJSONArray3 = optJSONObject.optJSONArray("lineDash");
            if (optJSONArray3 != null) {
                aVar.j(new float[optJSONArray3.length()]);
                int length = optJSONArray3.length();
                for (int i = 0; i < length; i++) {
                    aVar.c()[i] = (float) optJSONArray3.optDouble(i, 0.0d);
                }
            }
            this.c = aVar;
        }
    }

    private final void j(ShapeEntity shapeEntity) {
        Transform transform = shapeEntity.transform;
        if (transform != null) {
            Matrix matrix = new Matrix();
            float[] fArr = new float[9];
            Float f = transform.a;
            float floatValue = f != null ? f.floatValue() : 1.0f;
            Float f2 = transform.b;
            float floatValue2 = f2 != null ? f2.floatValue() : 0.0f;
            Float f3 = transform.c;
            float floatValue3 = f3 != null ? f3.floatValue() : 0.0f;
            Float f4 = transform.d;
            float floatValue4 = f4 != null ? f4.floatValue() : 1.0f;
            Float f5 = transform.tx;
            float floatValue5 = f5 != null ? f5.floatValue() : 0.0f;
            Float f6 = transform.ty;
            float floatValue6 = f6 != null ? f6.floatValue() : 0.0f;
            fArr[0] = floatValue;
            fArr[1] = floatValue3;
            fArr[2] = floatValue5;
            fArr[3] = floatValue2;
            fArr[4] = floatValue4;
            fArr[5] = floatValue6;
            fArr[6] = 0.0f;
            fArr[7] = 0.0f;
            fArr[8] = 1.0f;
            matrix.setValues(fArr);
            this.d = matrix;
        }
    }

    private final void k(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("transform");
        if (optJSONObject != null) {
            Matrix matrix = new Matrix();
            double optDouble = optJSONObject.optDouble("a", 1.0d);
            double optDouble2 = optJSONObject.optDouble("b", 0.0d);
            float f = (float) 0.0d;
            matrix.setValues(new float[]{(float) optDouble, (float) optJSONObject.optDouble(c.a, 0.0d), (float) optJSONObject.optDouble("tx", 0.0d), (float) optDouble2, (float) optJSONObject.optDouble("d", 1.0d), (float) optJSONObject.optDouble(com.alipay.sdk.m.s.a.s, 0.0d), f, f, (float) 1.0d});
            this.d = matrix;
        }
    }

    private final void l(ShapeEntity shapeEntity) {
        Type type;
        ShapeEntity.ShapeType shapeType = shapeEntity.type;
        if (shapeType != null) {
            int i = b52.$EnumSwitchMapping$0[shapeType.ordinal()];
            if (i == 1) {
                type = Type.shape;
            } else if (i == 2) {
                type = Type.rect;
            } else if (i == 3) {
                type = Type.ellipse;
            } else if (i != 4) {
                throw new NoWhenBranchMatchedException();
            } else {
                type = Type.keep;
            }
            this.a = type;
        }
    }

    private final void m(JSONObject jSONObject) {
        boolean q;
        boolean q2;
        boolean q3;
        boolean q4;
        String optString = jSONObject.optString("type");
        if (optString != null) {
            q = o.q(optString, "shape", true);
            if (q) {
                this.a = Type.shape;
                return;
            }
            q2 = o.q(optString, "rect", true);
            if (q2) {
                this.a = Type.rect;
                return;
            }
            q3 = o.q(optString, "ellipse", true);
            if (q3) {
                this.a = Type.ellipse;
                return;
            }
            q4 = o.q(optString, "keep", true);
            if (q4) {
                this.a = Type.keep;
            }
        }
    }

    public final void a() {
        if (this.e != null) {
            return;
        }
        c52.a().reset();
        if (b41.d(this.a, Type.shape)) {
            Map<String, ? extends Object> map = this.b;
            Object obj = map != null ? map.get("d") : null;
            String str = obj instanceof String ? obj : null;
            if (str != null) {
                new v42(str).a(c52.a());
            }
        } else if (b41.d(this.a, Type.ellipse)) {
            Map<String, ? extends Object> map2 = this.b;
            Object obj2 = map2 != null ? map2.get(Constants.Name.X) : null;
            if (!(obj2 instanceof Number)) {
                obj2 = null;
            }
            Number number = (Number) obj2;
            if (number == null) {
                return;
            }
            Map<String, ? extends Object> map3 = this.b;
            Object obj3 = map3 != null ? map3.get(Constants.Name.Y) : null;
            if (!(obj3 instanceof Number)) {
                obj3 = null;
            }
            Number number2 = (Number) obj3;
            if (number2 == null) {
                return;
            }
            Map<String, ? extends Object> map4 = this.b;
            Object obj4 = map4 != null ? map4.get("radiusX") : null;
            if (!(obj4 instanceof Number)) {
                obj4 = null;
            }
            Number number3 = (Number) obj4;
            if (number3 == null) {
                return;
            }
            Map<String, ? extends Object> map5 = this.b;
            Object obj5 = map5 != null ? map5.get("radiusY") : null;
            Number number4 = (Number) (obj5 instanceof Number ? obj5 : null);
            if (number4 == null) {
                return;
            }
            float floatValue = number.floatValue();
            float floatValue2 = number2.floatValue();
            float floatValue3 = number3.floatValue();
            float floatValue4 = number4.floatValue();
            c52.a().addOval(new RectF(floatValue - floatValue3, floatValue2 - floatValue4, floatValue + floatValue3, floatValue2 + floatValue4), Path.Direction.CW);
        } else if (b41.d(this.a, Type.rect)) {
            Map<String, ? extends Object> map6 = this.b;
            Object obj6 = map6 != null ? map6.get(Constants.Name.X) : null;
            if (!(obj6 instanceof Number)) {
                obj6 = null;
            }
            Number number5 = (Number) obj6;
            if (number5 == null) {
                return;
            }
            Map<String, ? extends Object> map7 = this.b;
            Object obj7 = map7 != null ? map7.get(Constants.Name.Y) : null;
            if (!(obj7 instanceof Number)) {
                obj7 = null;
            }
            Number number6 = (Number) obj7;
            if (number6 == null) {
                return;
            }
            Map<String, ? extends Object> map8 = this.b;
            Object obj8 = map8 != null ? map8.get("width") : null;
            if (!(obj8 instanceof Number)) {
                obj8 = null;
            }
            Number number7 = (Number) obj8;
            if (number7 == null) {
                return;
            }
            Map<String, ? extends Object> map9 = this.b;
            Object obj9 = map9 != null ? map9.get("height") : null;
            if (!(obj9 instanceof Number)) {
                obj9 = null;
            }
            Number number8 = (Number) obj9;
            if (number8 == null) {
                return;
            }
            Map<String, ? extends Object> map10 = this.b;
            Object obj10 = map10 != null ? map10.get("cornerRadius") : null;
            Number number9 = obj10 instanceof Number ? obj10 : null;
            if (number9 == null) {
                return;
            }
            float floatValue5 = number5.floatValue();
            float floatValue6 = number6.floatValue();
            float floatValue7 = number7.floatValue();
            float floatValue8 = number8.floatValue();
            float floatValue9 = number9.floatValue();
            c52.a().addRoundRect(new RectF(floatValue5, floatValue6, floatValue7 + floatValue5, floatValue8 + floatValue6), floatValue9, floatValue9, Path.Direction.CW);
        }
        Path path = new Path();
        this.e = path;
        path.set(c52.a());
    }

    @Nullable
    public final Path b() {
        return this.e;
    }

    @Nullable
    public final a c() {
        return this.c;
    }

    @Nullable
    public final Matrix d() {
        return this.d;
    }

    public final boolean e() {
        return b41.d(this.a, Type.keep);
    }

    public SVGAVideoShapeEntity(@NotNull ShapeEntity shapeEntity) {
        b41.j(shapeEntity, "obj");
        this.a = Type.shape;
        l(shapeEntity);
        f(shapeEntity);
        h(shapeEntity);
        j(shapeEntity);
    }
}
