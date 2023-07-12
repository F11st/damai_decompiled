package com.caverock.androidsvg;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import com.caverock.androidsvg.CSSParser;
import com.youku.arch.solid.monitor.SolidMonitor;
import com.youku.live.livesdk.wkit.component.Constants;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import tb.h52;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class SVG {
    private static h52 e = null;
    private static boolean f = true;
    private w a = null;
    private float b = 96.0f;
    private CSSParser.m c = new CSSParser.m();
    private Map<String, a0> d = new HashMap();

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class Colour extends SvgPaint {
        static final Colour BLACK = new Colour(-16777216);
        static final Colour TRANSPARENT = new Colour(0);
        int colour;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Colour(int i) {
            this.colour = i;
        }

        public String toString() {
            return String.format("#%08x", Integer.valueOf(this.colour));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class CurrentColor extends SvgPaint {
        private static CurrentColor instance = new CurrentColor();

        private CurrentColor() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static CurrentColor getInstance() {
            return instance;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    enum GradientSpread {
        pad,
        reflect,
        repeat
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    interface HasTransform {
        void setTransform(Matrix matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class Length implements Cloneable {
        Unit unit;
        float value;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Length(float f, Unit unit) {
            this.value = f;
            this.unit = unit;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public float floatValue() {
            return this.value;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public float floatValueX(com.caverock.androidsvg.e eVar) {
            switch (a.a[this.unit.ordinal()]) {
                case 1:
                    return this.value;
                case 2:
                    return this.value * eVar.Y();
                case 3:
                    return this.value * eVar.Z();
                case 4:
                    return this.value * eVar.b0();
                case 5:
                    return (this.value * eVar.b0()) / 2.54f;
                case 6:
                    return (this.value * eVar.b0()) / 25.4f;
                case 7:
                    return (this.value * eVar.b0()) / 72.0f;
                case 8:
                    return (this.value * eVar.b0()) / 6.0f;
                case 9:
                    b a0 = eVar.a0();
                    if (a0 == null) {
                        return this.value;
                    }
                    return (this.value * a0.c) / 100.0f;
                default:
                    return this.value;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public float floatValueY(com.caverock.androidsvg.e eVar) {
            if (this.unit == Unit.percent) {
                b a0 = eVar.a0();
                if (a0 == null) {
                    return this.value;
                }
                return (this.value * a0.d) / 100.0f;
            }
            return floatValueX(eVar);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isNegative() {
            return this.value < 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isZero() {
            return this.value == 0.0f;
        }

        public String toString() {
            return String.valueOf(this.value) + this.unit;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public float floatValue(com.caverock.androidsvg.e eVar) {
            if (this.unit == Unit.percent) {
                b a0 = eVar.a0();
                if (a0 == null) {
                    return this.value;
                }
                float f = a0.c;
                float f2 = a0.d;
                if (f == f2) {
                    return (this.value * f) / 100.0f;
                }
                return (this.value * ((float) (Math.sqrt((f * f) + (f2 * f2)) / 1.414213562373095d))) / 100.0f;
            }
            return floatValueX(eVar);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Length(float f) {
            this.value = f;
            this.unit = Unit.px;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public float floatValue(com.caverock.androidsvg.e eVar, float f) {
            if (this.unit == Unit.percent) {
                return (this.value * f) / 100.0f;
            }
            return floatValueX(eVar);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public float floatValue(float f) {
            int i = a.a[this.unit.ordinal()];
            if (i != 1) {
                switch (i) {
                    case 4:
                        return this.value * f;
                    case 5:
                        return (this.value * f) / 2.54f;
                    case 6:
                        return (this.value * f) / 25.4f;
                    case 7:
                        return (this.value * f) / 72.0f;
                    case 8:
                        return (this.value * f) / 6.0f;
                    default:
                        return this.value;
                }
            }
            return this.value;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    interface NotDirectlyRendered {
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class PaintReference extends SvgPaint {
        SvgPaint fallback;
        String href;

        /* JADX INFO: Access modifiers changed from: package-private */
        public PaintReference(String str, SvgPaint svgPaint) {
            this.href = str;
            this.fallback = svgPaint;
        }

        public String toString() {
            return this.href + " " + this.fallback;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface PathInterface {
        void arcTo(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5);

        void close();

        void cubicTo(float f, float f2, float f3, float f4, float f5, float f6);

        void lineTo(float f, float f2);

        void moveTo(float f, float f2);

        void quadTo(float f, float f2, float f3, float f4);
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class Style implements Cloneable {
        static final int FONT_WEIGHT_BOLD = 700;
        static final int FONT_WEIGHT_BOLDER = 1;
        static final int FONT_WEIGHT_LIGHTER = -1;
        static final int FONT_WEIGHT_NORMAL = 400;
        c clip;
        String clipPath;
        FillRule clipRule;
        Colour color;
        TextDirection direction;
        Boolean display;
        SvgPaint fill;
        Float fillOpacity;
        FillRule fillRule;
        List<String> fontFamily;
        Length fontSize;
        FontStyle fontStyle;
        Integer fontWeight;
        RenderQuality imageRendering;
        String markerEnd;
        String markerMid;
        String markerStart;
        String mask;
        Float opacity;
        Boolean overflow;
        SvgPaint solidColor;
        Float solidOpacity;
        SvgPaint stopColor;
        Float stopOpacity;
        SvgPaint stroke;
        Length[] strokeDashArray;
        Length strokeDashOffset;
        LineCap strokeLineCap;
        LineJoin strokeLineJoin;
        Float strokeMiterLimit;
        Float strokeOpacity;
        Length strokeWidth;
        TextAnchor textAnchor;
        TextDecoration textDecoration;
        VectorEffect vectorEffect;
        SvgPaint viewportFill;
        Float viewportFillOpacity;
        Boolean visibility;
        long specifiedFlags = 0;
        boolean important = false;

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public enum FillRule {
            NonZero,
            EvenOdd
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public enum FontStyle {
            Normal,
            Italic,
            Oblique
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public enum LineCap {
            Butt,
            Round,
            Square
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public enum LineJoin {
            Miter,
            Round,
            Bevel
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public enum RenderQuality {
            auto,
            optimizeQuality,
            optimizeSpeed
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public enum TextAnchor {
            Start,
            Middle,
            End
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public enum TextDecoration {
            None,
            Underline,
            Overline,
            LineThrough,
            Blink
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public enum TextDirection {
            LTR,
            RTL
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public enum VectorEffect {
            None,
            NonScalingStroke
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static Style getDefaultStyle() {
            Style style = new Style();
            style.specifiedFlags = -1L;
            style.important = false;
            Colour colour = Colour.BLACK;
            style.fill = colour;
            FillRule fillRule = FillRule.NonZero;
            style.fillRule = fillRule;
            Float valueOf = Float.valueOf(1.0f);
            style.fillOpacity = valueOf;
            style.stroke = null;
            style.strokeOpacity = valueOf;
            style.strokeWidth = new Length(1.0f);
            style.strokeLineCap = LineCap.Butt;
            style.strokeLineJoin = LineJoin.Miter;
            style.strokeMiterLimit = Float.valueOf(4.0f);
            style.strokeDashArray = null;
            style.strokeDashOffset = new Length(0.0f);
            style.opacity = valueOf;
            style.color = colour;
            style.fontFamily = null;
            style.fontSize = new Length(12.0f, Unit.pt);
            style.fontWeight = 400;
            style.fontStyle = FontStyle.Normal;
            style.textDecoration = TextDecoration.None;
            style.direction = TextDirection.LTR;
            style.textAnchor = TextAnchor.Start;
            Boolean bool = Boolean.TRUE;
            style.overflow = bool;
            style.clip = null;
            style.markerStart = null;
            style.markerMid = null;
            style.markerEnd = null;
            style.display = bool;
            style.visibility = bool;
            style.stopColor = colour;
            style.stopOpacity = valueOf;
            style.clipPath = null;
            style.clipRule = fillRule;
            style.mask = null;
            style.solidColor = null;
            style.solidOpacity = valueOf;
            style.viewportFill = null;
            style.viewportFillOpacity = valueOf;
            style.vectorEffect = VectorEffect.None;
            style.imageRendering = RenderQuality.auto;
            return style;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public Object clone() throws CloneNotSupportedException {
            Style style = (Style) super.clone();
            Length[] lengthArr = this.strokeDashArray;
            if (lengthArr != null) {
                style.strokeDashArray = (Length[]) lengthArr.clone();
            }
            return style;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void resetNonInheritingProperties(boolean z) {
            Boolean bool = Boolean.TRUE;
            this.display = bool;
            if (!z) {
                bool = Boolean.FALSE;
            }
            this.overflow = bool;
            this.clip = null;
            this.clipPath = null;
            this.opacity = Float.valueOf(1.0f);
            this.stopColor = Colour.BLACK;
            this.stopOpacity = Float.valueOf(1.0f);
            this.mask = null;
            this.solidColor = null;
            this.solidOpacity = Float.valueOf(1.0f);
            this.viewportFill = null;
            this.viewportFillOpacity = Float.valueOf(1.0f);
            this.vectorEffect = VectorEffect.None;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    interface SvgConditional {
        String getRequiredExtensions();

        Set<String> getRequiredFeatures();

        Set<String> getRequiredFonts();

        Set<String> getRequiredFormats();

        Set<String> getSystemLanguage();

        void setRequiredExtensions(String str);

        void setRequiredFeatures(Set<String> set);

        void setRequiredFonts(Set<String> set);

        void setRequiredFormats(Set<String> set);

        void setSystemLanguage(Set<String> set);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface SvgContainer {
        void addChild(c0 c0Var) throws SVGParseException;

        List<c0> getChildren();
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static abstract class SvgPaint implements Cloneable {
        SvgPaint() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    interface TextChild {
        TextRoot getTextRoot();

        void setTextRoot(TextRoot textRoot);
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    interface TextRoot {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public enum Unit {
        px,
        em,
        ex,
        in,
        cm,
        mm,
        pt,
        pc,
        percent
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Unit.values().length];
            a = iArr;
            try {
                iArr[Unit.px.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Unit.em.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Unit.ex.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Unit.in.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Unit.cm.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[Unit.mm.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[Unit.pt.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[Unit.pc.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[Unit.percent.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static abstract class a0 extends c0 {
        String c = null;
        Boolean d = null;
        Style e = null;
        Style f = null;
        List<String> g = null;

        a0() {
        }

        public String toString() {
            return a();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class b0 extends h {
        Length m;
        Length n;
        Length o;
        Length p;

        @Override // com.caverock.androidsvg.SVG.c0
        String a() {
            return "linearGradient";
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class c {
        Length a;
        Length b;
        Length c;
        Length d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(Length length, Length length2, Length length3, Length length4) {
            this.a = length;
            this.b = length2;
            this.c = length3;
            this.d = length4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class c0 {
        SVG a;
        SvgContainer b;

        c0() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String a() {
            return "";
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class d extends i {
        Length o;
        Length p;
        Length q;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0
        public String a() {
            return "circle";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static abstract class d0 extends x {
        PreserveAspectRatio n = null;

        d0() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class e extends j implements NotDirectlyRendered {
        Boolean o;

        @Override // com.caverock.androidsvg.SVG.j, com.caverock.androidsvg.SVG.c0
        String a() {
            return "clipPath";
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class e0 extends h {
        Length m;
        Length n;
        Length o;
        Length p;
        Length q;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0
        public String a() {
            return "radialGradient";
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class f extends j implements NotDirectlyRendered {
        @Override // com.caverock.androidsvg.SVG.j, com.caverock.androidsvg.SVG.c0
        String a() {
            return "defs";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static abstract class f0 extends d0 {
        b o;

        f0() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class g extends i {
        Length o;
        Length p;
        Length q;
        Length r;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0
        public String a() {
            return "ellipse";
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class g0 extends j {
        @Override // com.caverock.androidsvg.SVG.j, com.caverock.androidsvg.SVG.c0
        String a() {
            return "switch";
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static abstract class h extends a0 implements SvgContainer {
        List<c0> h = new ArrayList();
        Boolean i;
        Matrix j;
        GradientSpread k;
        String l;

        h() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public void addChild(c0 c0Var) throws SVGParseException {
            if (c0Var instanceof v) {
                this.h.add(c0Var);
                return;
            }
            throw new SVGParseException("Gradient elements cannot contain " + c0Var + " elements.");
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public List<c0> getChildren() {
            return this.h;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class h0 extends f0 implements NotDirectlyRendered {
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0
        public String a() {
            return "symbol";
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static abstract class i extends y implements HasTransform {
        Matrix n;

        i() {
        }

        @Override // com.caverock.androidsvg.SVG.HasTransform
        public void setTransform(Matrix matrix) {
            this.n = matrix;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class i0 extends l0 implements TextChild {
        String n;
        private TextRoot o;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0
        public String a() {
            return "tref";
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public TextRoot getTextRoot() {
            return this.o;
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public void setTextRoot(TextRoot textRoot) {
            this.o = textRoot;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class j extends x implements HasTransform {
        Matrix n;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0
        public String a() {
            return SolidMonitor.CHECK_TYPE_GROUP;
        }

        @Override // com.caverock.androidsvg.SVG.HasTransform
        public void setTransform(Matrix matrix) {
            this.n = matrix;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class j0 extends n0 implements TextChild {
        private TextRoot r;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0
        public String a() {
            return "tspan";
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public TextRoot getTextRoot() {
            return this.r;
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public void setTextRoot(TextRoot textRoot) {
            this.r = textRoot;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class k extends d0 implements HasTransform {
        String o;
        Length p;
        Length q;
        Length r;
        Length s;
        Matrix t;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0
        public String a() {
            return "image";
        }

        @Override // com.caverock.androidsvg.SVG.HasTransform
        public void setTransform(Matrix matrix) {
            this.t = matrix;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class k0 extends n0 implements HasTransform, TextRoot {
        Matrix r;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0
        public String a() {
            return "text";
        }

        @Override // com.caverock.androidsvg.SVG.HasTransform
        public void setTransform(Matrix matrix) {
            this.r = matrix;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class l extends i {
        Length o;
        Length p;
        Length q;
        Length r;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0
        public String a() {
            return "line";
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static abstract class l0 extends x {
        l0() {
        }

        @Override // com.caverock.androidsvg.SVG.x, com.caverock.androidsvg.SVG.SvgContainer
        public void addChild(c0 c0Var) throws SVGParseException {
            if (c0Var instanceof TextChild) {
                this.i.add(c0Var);
                return;
            }
            throw new SVGParseException("Text content elements cannot contain " + c0Var + " elements.");
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class m extends f0 implements NotDirectlyRendered {
        boolean p;
        Length q;
        Length r;
        Length s;
        Length t;
        Float u;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0
        public String a() {
            return "marker";
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class m0 extends l0 implements TextChild {
        String n;
        Length o;
        private TextRoot p;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0
        public String a() {
            return "textPath";
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public TextRoot getTextRoot() {
            return this.p;
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public void setTextRoot(TextRoot textRoot) {
            this.p = textRoot;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class n extends x implements NotDirectlyRendered {
        Boolean n;
        Boolean o;
        Length p;
        Length q;
        Length r;
        Length s;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0
        public String a() {
            return "mask";
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static abstract class n0 extends l0 {
        List<Length> n;
        List<Length> o;
        List<Length> p;
        List<Length> q;

        n0() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class o extends i {
        p o;
        Float p;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0
        public String a() {
            return com.alibaba.security.realidentity.jsbridge.a.V;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class o0 extends c0 implements TextChild {
        String c;
        private TextRoot d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public o0(String str) {
            this.c = str;
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public TextRoot getTextRoot() {
            return this.d;
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public void setTextRoot(TextRoot textRoot) {
            this.d = textRoot;
        }

        public String toString() {
            return "TextChild: '" + this.c + "'";
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class p implements PathInterface {
        private int b = 0;
        private int d = 0;
        private byte[] a = new byte[8];
        private float[] c = new float[16];

        private void a(byte b) {
            int i = this.b;
            byte[] bArr = this.a;
            if (i == bArr.length) {
                byte[] bArr2 = new byte[bArr.length * 2];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                this.a = bArr2;
            }
            byte[] bArr3 = this.a;
            int i2 = this.b;
            this.b = i2 + 1;
            bArr3[i2] = b;
        }

        private void b(int i) {
            float[] fArr = this.c;
            if (fArr.length < this.d + i) {
                float[] fArr2 = new float[fArr.length * 2];
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                this.c = fArr2;
            }
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void arcTo(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            a((byte) ((z ? 2 : 0) | 4 | (z2 ? 1 : 0)));
            b(5);
            float[] fArr = this.c;
            int i = this.d;
            int i2 = i + 1;
            this.d = i2;
            fArr[i] = f;
            int i3 = i2 + 1;
            this.d = i3;
            fArr[i2] = f2;
            int i4 = i3 + 1;
            this.d = i4;
            fArr[i3] = f3;
            int i5 = i4 + 1;
            this.d = i5;
            fArr[i4] = f4;
            this.d = i5 + 1;
            fArr[i5] = f5;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void c(PathInterface pathInterface) {
            int i;
            int i2 = 0;
            for (int i3 = 0; i3 < this.b; i3++) {
                byte b = this.a[i3];
                if (b == 0) {
                    float[] fArr = this.c;
                    int i4 = i2 + 1;
                    i = i4 + 1;
                    pathInterface.moveTo(fArr[i2], fArr[i4]);
                } else if (b != 1) {
                    if (b == 2) {
                        float[] fArr2 = this.c;
                        int i5 = i2 + 1;
                        float f = fArr2[i2];
                        int i6 = i5 + 1;
                        float f2 = fArr2[i5];
                        int i7 = i6 + 1;
                        float f3 = fArr2[i6];
                        int i8 = i7 + 1;
                        float f4 = fArr2[i7];
                        int i9 = i8 + 1;
                        float f5 = fArr2[i8];
                        i2 = i9 + 1;
                        pathInterface.cubicTo(f, f2, f3, f4, f5, fArr2[i9]);
                    } else if (b == 3) {
                        float[] fArr3 = this.c;
                        int i10 = i2 + 1;
                        int i11 = i10 + 1;
                        int i12 = i11 + 1;
                        pathInterface.quadTo(fArr3[i2], fArr3[i10], fArr3[i11], fArr3[i12]);
                        i2 = i12 + 1;
                    } else if (b != 8) {
                        boolean z = (b & 2) != 0;
                        boolean z2 = (b & 1) != 0;
                        float[] fArr4 = this.c;
                        int i13 = i2 + 1;
                        float f6 = fArr4[i2];
                        int i14 = i13 + 1;
                        float f7 = fArr4[i13];
                        int i15 = i14 + 1;
                        float f8 = fArr4[i14];
                        int i16 = i15 + 1;
                        pathInterface.arcTo(f6, f7, f8, z, z2, fArr4[i15], fArr4[i16]);
                        i2 = i16 + 1;
                    } else {
                        pathInterface.close();
                    }
                } else {
                    float[] fArr5 = this.c;
                    int i17 = i2 + 1;
                    i = i17 + 1;
                    pathInterface.lineTo(fArr5[i2], fArr5[i17]);
                }
                i2 = i;
            }
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void close() {
            a((byte) 8);
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void cubicTo(float f, float f2, float f3, float f4, float f5, float f6) {
            a((byte) 2);
            b(6);
            float[] fArr = this.c;
            int i = this.d;
            int i2 = i + 1;
            this.d = i2;
            fArr[i] = f;
            int i3 = i2 + 1;
            this.d = i3;
            fArr[i2] = f2;
            int i4 = i3 + 1;
            this.d = i4;
            fArr[i3] = f3;
            int i5 = i4 + 1;
            this.d = i5;
            fArr[i4] = f4;
            int i6 = i5 + 1;
            this.d = i6;
            fArr[i5] = f5;
            this.d = i6 + 1;
            fArr[i6] = f6;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean d() {
            return this.b == 0;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void lineTo(float f, float f2) {
            a((byte) 1);
            b(2);
            float[] fArr = this.c;
            int i = this.d;
            int i2 = i + 1;
            this.d = i2;
            fArr[i] = f;
            this.d = i2 + 1;
            fArr[i2] = f2;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void moveTo(float f, float f2) {
            a((byte) 0);
            b(2);
            float[] fArr = this.c;
            int i = this.d;
            int i2 = i + 1;
            this.d = i2;
            fArr[i] = f;
            this.d = i2 + 1;
            fArr[i2] = f2;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void quadTo(float f, float f2, float f3, float f4) {
            a((byte) 3);
            b(4);
            float[] fArr = this.c;
            int i = this.d;
            int i2 = i + 1;
            this.d = i2;
            fArr[i] = f;
            int i3 = i2 + 1;
            this.d = i3;
            fArr[i2] = f2;
            int i4 = i3 + 1;
            this.d = i4;
            fArr[i3] = f3;
            this.d = i4 + 1;
            fArr[i4] = f4;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class p0 extends j {
        String o;
        Length p;
        Length q;
        Length r;
        Length s;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.j, com.caverock.androidsvg.SVG.c0
        public String a() {
            return "use";
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class q extends f0 implements NotDirectlyRendered {
        Boolean p;
        Boolean q;
        Matrix r;
        Length s;
        Length t;
        Length u;
        Length v;
        String w;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0
        public String a() {
            return "pattern";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class q0 extends f0 implements NotDirectlyRendered {
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0
        public String a() {
            return "view";
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class r extends i {
        float[] o;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0
        public String a() {
            return "polyline";
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class s extends r {
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.r, com.caverock.androidsvg.SVG.c0
        public String a() {
            return "polygon";
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class t extends i {
        Length o;
        Length p;
        Length q;
        Length r;
        Length s;
        Length t;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0
        public String a() {
            return "rect";
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class u extends a0 implements SvgContainer {
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0
        public String a() {
            return "solidColor";
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public void addChild(c0 c0Var) {
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public List<c0> getChildren() {
            return Collections.emptyList();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class v extends a0 implements SvgContainer {
        Float h;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0
        public String a() {
            return "stop";
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public void addChild(c0 c0Var) {
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public List<c0> getChildren() {
            return Collections.emptyList();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class w extends f0 {
        Length p;
        Length q;
        Length r;
        Length s;
        public String t;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0
        public String a() {
            return "svg";
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static abstract class x extends z implements SvgConditional, SvgContainer {
        List<c0> i = new ArrayList();
        Set<String> j = null;
        String k = null;
        Set<String> l = null;
        Set<String> m = null;

        x() {
        }

        public void addChild(c0 c0Var) throws SVGParseException {
            this.i.add(c0Var);
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public List<c0> getChildren() {
            return this.i;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public String getRequiredExtensions() {
            return this.k;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getRequiredFeatures() {
            return this.j;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getRequiredFonts() {
            return this.m;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getRequiredFormats() {
            return this.l;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getSystemLanguage() {
            return null;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredExtensions(String str) {
            this.k = str;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredFeatures(Set<String> set) {
            this.j = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredFonts(Set<String> set) {
            this.m = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredFormats(Set<String> set) {
            this.l = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setSystemLanguage(Set<String> set) {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static abstract class y extends z implements SvgConditional {
        Set<String> i = null;
        String j = null;
        Set<String> k = null;
        Set<String> l = null;
        Set<String> m = null;

        y() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public String getRequiredExtensions() {
            return this.j;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getRequiredFeatures() {
            return this.i;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getRequiredFonts() {
            return this.m;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getRequiredFormats() {
            return this.l;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getSystemLanguage() {
            return this.k;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredExtensions(String str) {
            this.j = str;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredFeatures(Set<String> set) {
            this.i = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredFonts(Set<String> set) {
            this.m = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredFormats(Set<String> set) {
            this.l = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setSystemLanguage(Set<String> set) {
            this.k = set;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static abstract class z extends a0 {
        b h = null;

        z() {
        }
    }

    private String c(String str) {
        if (str.startsWith("\"") && str.endsWith("\"")) {
            str = str.substring(1, str.length() - 1).replace("\\\"", "\"");
        } else if (str.startsWith("'") && str.endsWith("'")) {
            str = str.substring(1, str.length() - 1).replace("\\'", "'");
        }
        return str.replace("\\\n", "").replace("\\A", StringUtils.LF);
    }

    private a0 e(SvgContainer svgContainer, String str) {
        a0 e2;
        a0 a0Var = (a0) svgContainer;
        if (str.equals(a0Var.c)) {
            return a0Var;
        }
        for (c0 c0Var : svgContainer.getChildren()) {
            if (c0Var instanceof a0) {
                a0 a0Var2 = (a0) c0Var;
                if (str.equals(a0Var2.c)) {
                    return a0Var2;
                }
                if ((c0Var instanceof SvgContainer) && (e2 = e((SvgContainer) c0Var, str)) != null) {
                    return e2;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static h52 g() {
        return e;
    }

    public static SVG h(InputStream inputStream) throws SVGParseException {
        return new SVGParser().z(inputStream, f);
    }

    public static SVG i(Context context, int i2) throws SVGParseException {
        return j(context.getResources(), i2);
    }

    public static SVG j(Resources resources, int i2) throws SVGParseException {
        SVGParser sVGParser = new SVGParser();
        InputStream openRawResource = resources.openRawResource(i2);
        try {
            return sVGParser.z(openRawResource, f);
        } finally {
            try {
                openRawResource.close();
            } catch (IOException unused) {
            }
        }
    }

    public static SVG k(String str) throws SVGParseException {
        return new SVGParser().z(new ByteArrayInputStream(str.getBytes()), f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(CSSParser.m mVar) {
        this.c.b(mVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.c.e(CSSParser.Source.RenderOptions);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<CSSParser.k> d() {
        return this.c.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a0 f(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.equals(this.a.c)) {
            return this.a;
        }
        if (this.d.containsKey(str)) {
            return this.d.get(str);
        }
        a0 e2 = e(this.a, str);
        this.d.put(str, e2);
        return e2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w l() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean m() {
        return !this.c.d();
    }

    public Picture n(int i2, int i3, com.caverock.androidsvg.d dVar) {
        Picture picture = new Picture();
        Canvas beginRecording = picture.beginRecording(i2, i3);
        if (dVar == null || dVar.f == null) {
            dVar = dVar == null ? new com.caverock.androidsvg.d() : new com.caverock.androidsvg.d(dVar);
            dVar.h(0.0f, 0.0f, i2, i3);
        }
        new com.caverock.androidsvg.e(beginRecording, this.b).O0(this, dVar);
        picture.endRecording();
        return picture;
    }

    public Picture o(com.caverock.androidsvg.d dVar) {
        b bVar;
        Length length;
        if (dVar != null && dVar.f()) {
            bVar = dVar.d;
        } else {
            w wVar = this.a;
            bVar = wVar != null ? wVar.o : null;
        }
        if (dVar != null && dVar.g()) {
            return n((int) Math.ceil(dVar.f.b()), (int) Math.ceil(dVar.f.c()), dVar);
        }
        w wVar2 = this.a;
        Length length2 = wVar2.r;
        if (length2 != null) {
            Unit unit = length2.unit;
            Unit unit2 = Unit.percent;
            if (unit != unit2 && (length = wVar2.s) != null && length.unit != unit2) {
                return n((int) Math.ceil(length2.floatValue(this.b)), (int) Math.ceil(this.a.s.floatValue(this.b)), dVar);
            }
        }
        if (length2 != null && bVar != null) {
            float floatValue = length2.floatValue(this.b);
            return n((int) Math.ceil(floatValue), (int) Math.ceil((bVar.d * floatValue) / bVar.c), dVar);
        }
        Length length3 = wVar2.s;
        if (length3 != null && bVar != null) {
            float floatValue2 = length3.floatValue(this.b);
            return n((int) Math.ceil((bVar.c * floatValue2) / bVar.d), (int) Math.ceil(floatValue2), dVar);
        }
        if (bVar != null) {
            float f2 = bVar.c;
            if (f2 > 0.0f) {
                float f3 = bVar.d;
                if (f3 > 0.0f) {
                    return n((int) f2, (int) f3, dVar);
                }
            }
        }
        return n(512, 512, dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c0 p(String str) {
        if (str == null) {
            return null;
        }
        String c2 = c(str);
        if (c2.length() <= 1 || !c2.startsWith(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
            return null;
        }
        return f(c2.substring(1));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(w wVar) {
        this.a = wVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class b {
        float a;
        float b;
        float c;
        float d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(float f, float f2, float f3, float f4) {
            this.a = f;
            this.b = f2;
            this.c = f3;
            this.d = f4;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static b a(float f, float f2, float f3, float f4) {
            return new b(f, f2, f3 - f, f4 - f2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public float b() {
            return this.a + this.c;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public float c() {
            return this.b + this.d;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void d(b bVar) {
            float f = bVar.a;
            if (f < this.a) {
                this.a = f;
            }
            float f2 = bVar.b;
            if (f2 < this.b) {
                this.b = f2;
            }
            if (bVar.b() > b()) {
                this.c = bVar.b() - this.a;
            }
            if (bVar.c() > c()) {
                this.d = bVar.c() - this.b;
            }
        }

        public String toString() {
            return jn1.ARRAY_START_STR + this.a + " " + this.b + " " + this.c + " " + this.d + jn1.ARRAY_END_STR;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(b bVar) {
            this.a = bVar.a;
            this.b = bVar.b;
            this.c = bVar.c;
            this.d = bVar.d;
        }
    }
}
