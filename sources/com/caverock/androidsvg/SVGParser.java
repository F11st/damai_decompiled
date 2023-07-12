package com.caverock.androidsvg;

import android.graphics.Matrix;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.util.Xml;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.caverock.androidsvg.CSSParser;
import com.caverock.androidsvg.PreserveAspectRatio;
import com.caverock.androidsvg.SVG;
import com.taobao.weex.common.Constants;
import com.taobao.weex.utils.WXUtils;
import com.youku.arch.v3.data.Constants;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.android.agoo.message.MessageService;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.DefaultHandler2;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import tb.b90;
import tb.gh0;
import tb.jn1;
import tb.r10;
import tb.wv;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class SVGParser {
    public static final int ENTITY_WATCH_BUFFER_SIZE = 4096;
    public static final String XML_STYLESHEET_ATTR_ALTERNATE = "alternate";
    public static final String XML_STYLESHEET_ATTR_ALTERNATE_NO = "no";
    public static final String XML_STYLESHEET_ATTR_HREF = "href";
    public static final String XML_STYLESHEET_ATTR_MEDIA = "media";
    public static final String XML_STYLESHEET_ATTR_MEDIA_ALL = "all";
    public static final String XML_STYLESHEET_ATTR_TYPE = "type";
    private int d;
    private SVG a = null;
    private SVG.SvgContainer b = null;
    private boolean c = false;
    private boolean e = false;
    private SVGElem f = null;
    private StringBuilder g = null;
    private boolean h = false;
    private StringBuilder i = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public enum SVGAttr {
        CLASS,
        clip,
        clip_path,
        clipPathUnits,
        clip_rule,
        color,
        cx,
        cy,
        direction,
        dx,
        dy,
        fx,
        fy,
        d,
        display,
        fill,
        fill_rule,
        fill_opacity,
        font,
        font_family,
        font_size,
        font_weight,
        font_style,
        gradientTransform,
        gradientUnits,
        height,
        href,
        image_rendering,
        marker,
        marker_start,
        marker_mid,
        marker_end,
        markerHeight,
        markerUnits,
        markerWidth,
        mask,
        maskContentUnits,
        maskUnits,
        media,
        offset,
        opacity,
        orient,
        overflow,
        pathLength,
        patternContentUnits,
        patternTransform,
        patternUnits,
        points,
        preserveAspectRatio,
        r,
        refX,
        refY,
        requiredFeatures,
        requiredExtensions,
        requiredFormats,
        requiredFonts,
        rx,
        ry,
        solid_color,
        solid_opacity,
        spreadMethod,
        startOffset,
        stop_color,
        stop_opacity,
        stroke,
        stroke_dasharray,
        stroke_dashoffset,
        stroke_linecap,
        stroke_linejoin,
        stroke_miterlimit,
        stroke_opacity,
        stroke_width,
        style,
        systemLanguage,
        text_anchor,
        text_decoration,
        transform,
        type,
        vector_effect,
        version,
        viewBox,
        width,
        x,
        y,
        x1,
        y1,
        x2,
        y2,
        viewport_fill,
        viewport_fill_opacity,
        visibility,
        UNSUPPORTED;
        
        private static final Map<String, SVGAttr> cache = new HashMap();

        static {
            SVGAttr[] values;
            for (SVGAttr sVGAttr : values()) {
                if (sVGAttr == CLASS) {
                    cache.put("class", sVGAttr);
                } else if (sVGAttr != UNSUPPORTED) {
                    cache.put(sVGAttr.name().replace('_', '-'), sVGAttr);
                }
            }
        }

        public static SVGAttr fromString(String str) {
            SVGAttr sVGAttr = cache.get(str);
            return sVGAttr != null ? sVGAttr : UNSUPPORTED;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public enum SVGElem {
        svg,
        a,
        circle,
        clipPath,
        defs,
        desc,
        ellipse,
        g,
        image,
        line,
        linearGradient,
        marker,
        mask,
        path,
        pattern,
        polygon,
        polyline,
        radialGradient,
        rect,
        solidColor,
        stop,
        style,
        SWITCH,
        symbol,
        text,
        textPath,
        title,
        tref,
        tspan,
        use,
        view,
        UNSUPPORTED;
        
        private static final Map<String, SVGElem> cache = new HashMap();

        static {
            SVGElem[] values;
            for (SVGElem sVGElem : values()) {
                if (sVGElem == SWITCH) {
                    cache.put("switch", sVGElem);
                } else if (sVGElem != UNSUPPORTED) {
                    cache.put(sVGElem.name(), sVGElem);
                }
            }
        }

        public static SVGElem fromString(String str) {
            SVGElem sVGElem = cache.get(str);
            return sVGElem != null ? sVGElem : UNSUPPORTED;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[SVGAttr.values().length];
            b = iArr;
            try {
                iArr[SVGAttr.x.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[SVGAttr.y.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[SVGAttr.width.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[SVGAttr.height.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[SVGAttr.version.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[SVGAttr.href.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[SVGAttr.preserveAspectRatio.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[SVGAttr.d.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                b[SVGAttr.pathLength.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                b[SVGAttr.rx.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                b[SVGAttr.ry.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                b[SVGAttr.cx.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                b[SVGAttr.cy.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                b[SVGAttr.r.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                b[SVGAttr.x1.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                b[SVGAttr.y1.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                b[SVGAttr.x2.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                b[SVGAttr.y2.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                b[SVGAttr.dx.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                b[SVGAttr.dy.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                b[SVGAttr.requiredFeatures.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                b[SVGAttr.requiredExtensions.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                b[SVGAttr.systemLanguage.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                b[SVGAttr.requiredFormats.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                b[SVGAttr.requiredFonts.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                b[SVGAttr.refX.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                b[SVGAttr.refY.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                b[SVGAttr.markerWidth.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                b[SVGAttr.markerHeight.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                b[SVGAttr.markerUnits.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                b[SVGAttr.orient.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                b[SVGAttr.gradientUnits.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                b[SVGAttr.gradientTransform.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                b[SVGAttr.spreadMethod.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                b[SVGAttr.fx.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                b[SVGAttr.fy.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                b[SVGAttr.offset.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                b[SVGAttr.clipPathUnits.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                b[SVGAttr.startOffset.ordinal()] = 39;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                b[SVGAttr.patternUnits.ordinal()] = 40;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                b[SVGAttr.patternContentUnits.ordinal()] = 41;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                b[SVGAttr.patternTransform.ordinal()] = 42;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                b[SVGAttr.maskUnits.ordinal()] = 43;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                b[SVGAttr.maskContentUnits.ordinal()] = 44;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                b[SVGAttr.style.ordinal()] = 45;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                b[SVGAttr.CLASS.ordinal()] = 46;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                b[SVGAttr.fill.ordinal()] = 47;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                b[SVGAttr.fill_rule.ordinal()] = 48;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                b[SVGAttr.fill_opacity.ordinal()] = 49;
            } catch (NoSuchFieldError unused49) {
            }
            try {
                b[SVGAttr.stroke.ordinal()] = 50;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                b[SVGAttr.stroke_opacity.ordinal()] = 51;
            } catch (NoSuchFieldError unused51) {
            }
            try {
                b[SVGAttr.stroke_width.ordinal()] = 52;
            } catch (NoSuchFieldError unused52) {
            }
            try {
                b[SVGAttr.stroke_linecap.ordinal()] = 53;
            } catch (NoSuchFieldError unused53) {
            }
            try {
                b[SVGAttr.stroke_linejoin.ordinal()] = 54;
            } catch (NoSuchFieldError unused54) {
            }
            try {
                b[SVGAttr.stroke_miterlimit.ordinal()] = 55;
            } catch (NoSuchFieldError unused55) {
            }
            try {
                b[SVGAttr.stroke_dasharray.ordinal()] = 56;
            } catch (NoSuchFieldError unused56) {
            }
            try {
                b[SVGAttr.stroke_dashoffset.ordinal()] = 57;
            } catch (NoSuchFieldError unused57) {
            }
            try {
                b[SVGAttr.opacity.ordinal()] = 58;
            } catch (NoSuchFieldError unused58) {
            }
            try {
                b[SVGAttr.color.ordinal()] = 59;
            } catch (NoSuchFieldError unused59) {
            }
            try {
                b[SVGAttr.font.ordinal()] = 60;
            } catch (NoSuchFieldError unused60) {
            }
            try {
                b[SVGAttr.font_family.ordinal()] = 61;
            } catch (NoSuchFieldError unused61) {
            }
            try {
                b[SVGAttr.font_size.ordinal()] = 62;
            } catch (NoSuchFieldError unused62) {
            }
            try {
                b[SVGAttr.font_weight.ordinal()] = 63;
            } catch (NoSuchFieldError unused63) {
            }
            try {
                b[SVGAttr.font_style.ordinal()] = 64;
            } catch (NoSuchFieldError unused64) {
            }
            try {
                b[SVGAttr.text_decoration.ordinal()] = 65;
            } catch (NoSuchFieldError unused65) {
            }
            try {
                b[SVGAttr.direction.ordinal()] = 66;
            } catch (NoSuchFieldError unused66) {
            }
            try {
                b[SVGAttr.text_anchor.ordinal()] = 67;
            } catch (NoSuchFieldError unused67) {
            }
            try {
                b[SVGAttr.overflow.ordinal()] = 68;
            } catch (NoSuchFieldError unused68) {
            }
            try {
                b[SVGAttr.marker.ordinal()] = 69;
            } catch (NoSuchFieldError unused69) {
            }
            try {
                b[SVGAttr.marker_start.ordinal()] = 70;
            } catch (NoSuchFieldError unused70) {
            }
            try {
                b[SVGAttr.marker_mid.ordinal()] = 71;
            } catch (NoSuchFieldError unused71) {
            }
            try {
                b[SVGAttr.marker_end.ordinal()] = 72;
            } catch (NoSuchFieldError unused72) {
            }
            try {
                b[SVGAttr.display.ordinal()] = 73;
            } catch (NoSuchFieldError unused73) {
            }
            try {
                b[SVGAttr.visibility.ordinal()] = 74;
            } catch (NoSuchFieldError unused74) {
            }
            try {
                b[SVGAttr.stop_color.ordinal()] = 75;
            } catch (NoSuchFieldError unused75) {
            }
            try {
                b[SVGAttr.stop_opacity.ordinal()] = 76;
            } catch (NoSuchFieldError unused76) {
            }
            try {
                b[SVGAttr.clip.ordinal()] = 77;
            } catch (NoSuchFieldError unused77) {
            }
            try {
                b[SVGAttr.clip_path.ordinal()] = 78;
            } catch (NoSuchFieldError unused78) {
            }
            try {
                b[SVGAttr.clip_rule.ordinal()] = 79;
            } catch (NoSuchFieldError unused79) {
            }
            try {
                b[SVGAttr.mask.ordinal()] = 80;
            } catch (NoSuchFieldError unused80) {
            }
            try {
                b[SVGAttr.solid_color.ordinal()] = 81;
            } catch (NoSuchFieldError unused81) {
            }
            try {
                b[SVGAttr.solid_opacity.ordinal()] = 82;
            } catch (NoSuchFieldError unused82) {
            }
            try {
                b[SVGAttr.viewport_fill.ordinal()] = 83;
            } catch (NoSuchFieldError unused83) {
            }
            try {
                b[SVGAttr.viewport_fill_opacity.ordinal()] = 84;
            } catch (NoSuchFieldError unused84) {
            }
            try {
                b[SVGAttr.vector_effect.ordinal()] = 85;
            } catch (NoSuchFieldError unused85) {
            }
            try {
                b[SVGAttr.image_rendering.ordinal()] = 86;
            } catch (NoSuchFieldError unused86) {
            }
            try {
                b[SVGAttr.viewBox.ordinal()] = 87;
            } catch (NoSuchFieldError unused87) {
            }
            try {
                b[SVGAttr.type.ordinal()] = 88;
            } catch (NoSuchFieldError unused88) {
            }
            try {
                b[SVGAttr.media.ordinal()] = 89;
            } catch (NoSuchFieldError unused89) {
            }
            int[] iArr2 = new int[SVGElem.values().length];
            a = iArr2;
            try {
                iArr2[SVGElem.svg.ordinal()] = 1;
            } catch (NoSuchFieldError unused90) {
            }
            try {
                a[SVGElem.g.ordinal()] = 2;
            } catch (NoSuchFieldError unused91) {
            }
            try {
                a[SVGElem.a.ordinal()] = 3;
            } catch (NoSuchFieldError unused92) {
            }
            try {
                a[SVGElem.defs.ordinal()] = 4;
            } catch (NoSuchFieldError unused93) {
            }
            try {
                a[SVGElem.use.ordinal()] = 5;
            } catch (NoSuchFieldError unused94) {
            }
            try {
                a[SVGElem.path.ordinal()] = 6;
            } catch (NoSuchFieldError unused95) {
            }
            try {
                a[SVGElem.rect.ordinal()] = 7;
            } catch (NoSuchFieldError unused96) {
            }
            try {
                a[SVGElem.circle.ordinal()] = 8;
            } catch (NoSuchFieldError unused97) {
            }
            try {
                a[SVGElem.ellipse.ordinal()] = 9;
            } catch (NoSuchFieldError unused98) {
            }
            try {
                a[SVGElem.line.ordinal()] = 10;
            } catch (NoSuchFieldError unused99) {
            }
            try {
                a[SVGElem.polyline.ordinal()] = 11;
            } catch (NoSuchFieldError unused100) {
            }
            try {
                a[SVGElem.polygon.ordinal()] = 12;
            } catch (NoSuchFieldError unused101) {
            }
            try {
                a[SVGElem.text.ordinal()] = 13;
            } catch (NoSuchFieldError unused102) {
            }
            try {
                a[SVGElem.tspan.ordinal()] = 14;
            } catch (NoSuchFieldError unused103) {
            }
            try {
                a[SVGElem.tref.ordinal()] = 15;
            } catch (NoSuchFieldError unused104) {
            }
            try {
                a[SVGElem.SWITCH.ordinal()] = 16;
            } catch (NoSuchFieldError unused105) {
            }
            try {
                a[SVGElem.symbol.ordinal()] = 17;
            } catch (NoSuchFieldError unused106) {
            }
            try {
                a[SVGElem.marker.ordinal()] = 18;
            } catch (NoSuchFieldError unused107) {
            }
            try {
                a[SVGElem.linearGradient.ordinal()] = 19;
            } catch (NoSuchFieldError unused108) {
            }
            try {
                a[SVGElem.radialGradient.ordinal()] = 20;
            } catch (NoSuchFieldError unused109) {
            }
            try {
                a[SVGElem.stop.ordinal()] = 21;
            } catch (NoSuchFieldError unused110) {
            }
            try {
                a[SVGElem.title.ordinal()] = 22;
            } catch (NoSuchFieldError unused111) {
            }
            try {
                a[SVGElem.desc.ordinal()] = 23;
            } catch (NoSuchFieldError unused112) {
            }
            try {
                a[SVGElem.clipPath.ordinal()] = 24;
            } catch (NoSuchFieldError unused113) {
            }
            try {
                a[SVGElem.textPath.ordinal()] = 25;
            } catch (NoSuchFieldError unused114) {
            }
            try {
                a[SVGElem.pattern.ordinal()] = 26;
            } catch (NoSuchFieldError unused115) {
            }
            try {
                a[SVGElem.image.ordinal()] = 27;
            } catch (NoSuchFieldError unused116) {
            }
            try {
                a[SVGElem.view.ordinal()] = 28;
            } catch (NoSuchFieldError unused117) {
            }
            try {
                a[SVGElem.mask.ordinal()] = 29;
            } catch (NoSuchFieldError unused118) {
            }
            try {
                a[SVGElem.style.ordinal()] = 30;
            } catch (NoSuchFieldError unused119) {
            }
            try {
                a[SVGElem.solidColor.ordinal()] = 31;
            } catch (NoSuchFieldError unused120) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class b {
        private static final Map<String, PreserveAspectRatio.Alignment> a;

        static {
            HashMap hashMap = new HashMap(10);
            a = hashMap;
            hashMap.put("none", PreserveAspectRatio.Alignment.none);
            hashMap.put("xMinYMin", PreserveAspectRatio.Alignment.xMinYMin);
            hashMap.put("xMidYMin", PreserveAspectRatio.Alignment.xMidYMin);
            hashMap.put("xMaxYMin", PreserveAspectRatio.Alignment.xMaxYMin);
            hashMap.put("xMinYMid", PreserveAspectRatio.Alignment.xMinYMid);
            hashMap.put("xMidYMid", PreserveAspectRatio.Alignment.xMidYMid);
            hashMap.put("xMaxYMid", PreserveAspectRatio.Alignment.xMaxYMid);
            hashMap.put("xMinYMax", PreserveAspectRatio.Alignment.xMinYMax);
            hashMap.put("xMidYMax", PreserveAspectRatio.Alignment.xMidYMax);
            hashMap.put("xMaxYMax", PreserveAspectRatio.Alignment.xMaxYMax);
        }

        static PreserveAspectRatio.Alignment a(String str) {
            return a.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class c {
        private static final Map<String, Integer> a;

        static {
            HashMap hashMap = new HashMap(47);
            a = hashMap;
            hashMap.put("aliceblue", -984833);
            hashMap.put("antiquewhite", -332841);
            hashMap.put("aqua", -16711681);
            hashMap.put("aquamarine", -8388652);
            hashMap.put("azure", -983041);
            hashMap.put("beige", -657956);
            hashMap.put("bisque", -6972);
            hashMap.put("black", -16777216);
            hashMap.put("blanchedalmond", -5171);
            hashMap.put("blue", -16776961);
            hashMap.put("blueviolet", -7722014);
            hashMap.put("brown", -5952982);
            hashMap.put("burlywood", -2180985);
            hashMap.put("cadetblue", -10510688);
            hashMap.put("chartreuse", -8388864);
            hashMap.put("chocolate", -2987746);
            hashMap.put("coral", -32944);
            hashMap.put("cornflowerblue", -10185235);
            hashMap.put("cornsilk", -1828);
            hashMap.put("crimson", -2354116);
            hashMap.put("cyan", -16711681);
            hashMap.put("darkblue", -16777077);
            hashMap.put("darkcyan", -16741493);
            hashMap.put("darkgoldenrod", -4684277);
            hashMap.put("darkgray", -5658199);
            hashMap.put("darkgreen", -16751616);
            hashMap.put("darkgrey", -5658199);
            hashMap.put("darkkhaki", -4343957);
            hashMap.put("darkmagenta", -7667573);
            hashMap.put("darkolivegreen", -11179217);
            hashMap.put("darkorange", -29696);
            hashMap.put("darkorchid", -6737204);
            hashMap.put("darkred", -7667712);
            hashMap.put("darksalmon", -1468806);
            hashMap.put("darkseagreen", -7357297);
            hashMap.put("darkslateblue", -12042869);
            hashMap.put("darkslategray", -13676721);
            hashMap.put("darkslategrey", -13676721);
            hashMap.put("darkturquoise", -16724271);
            hashMap.put("darkviolet", -7077677);
            hashMap.put("deeppink", -60269);
            hashMap.put("deepskyblue", -16728065);
            hashMap.put("dimgray", -9868951);
            hashMap.put("dimgrey", -9868951);
            hashMap.put("dodgerblue", -14774017);
            hashMap.put("firebrick", -5103070);
            hashMap.put("floralwhite", -1296);
            hashMap.put("forestgreen", -14513374);
            hashMap.put("fuchsia", -65281);
            hashMap.put("gainsboro", -2302756);
            hashMap.put("ghostwhite", -460545);
            hashMap.put("gold", -10496);
            hashMap.put("goldenrod", -2448096);
            hashMap.put("gray", -8355712);
            hashMap.put("green", -16744448);
            hashMap.put("greenyellow", -5374161);
            hashMap.put("grey", -8355712);
            hashMap.put("honeydew", -983056);
            hashMap.put("hotpink", -38476);
            hashMap.put("indianred", -3318692);
            hashMap.put("indigo", -11861886);
            hashMap.put("ivory", -16);
            hashMap.put("khaki", -989556);
            hashMap.put("lavender", -1644806);
            hashMap.put("lavenderblush", -3851);
            hashMap.put("lawngreen", -8586240);
            hashMap.put("lemonchiffon", -1331);
            hashMap.put("lightblue", -5383962);
            hashMap.put("lightcoral", -1015680);
            hashMap.put("lightcyan", -2031617);
            hashMap.put("lightgoldenrodyellow", -329006);
            hashMap.put("lightgray", -2894893);
            hashMap.put("lightgreen", -7278960);
            hashMap.put("lightgrey", -2894893);
            hashMap.put("lightpink", -18751);
            hashMap.put("lightsalmon", -24454);
            hashMap.put("lightseagreen", -14634326);
            hashMap.put("lightskyblue", -7876870);
            hashMap.put("lightslategray", -8943463);
            hashMap.put("lightslategrey", -8943463);
            hashMap.put("lightsteelblue", -5192482);
            hashMap.put("lightyellow", -32);
            hashMap.put("lime", -16711936);
            hashMap.put("limegreen", -13447886);
            hashMap.put("linen", -331546);
            hashMap.put("magenta", -65281);
            hashMap.put("maroon", -8388608);
            hashMap.put("mediumaquamarine", -10039894);
            hashMap.put("mediumblue", -16777011);
            hashMap.put("mediumorchid", -4565549);
            hashMap.put("mediumpurple", -7114533);
            hashMap.put("mediumseagreen", -12799119);
            hashMap.put("mediumslateblue", -8689426);
            hashMap.put("mediumspringgreen", -16713062);
            hashMap.put("mediumturquoise", -12004916);
            hashMap.put("mediumvioletred", -3730043);
            hashMap.put("midnightblue", -15132304);
            hashMap.put("mintcream", -655366);
            hashMap.put("mistyrose", -6943);
            hashMap.put("moccasin", -6987);
            hashMap.put("navajowhite", -8531);
            hashMap.put("navy", -16777088);
            hashMap.put("oldlace", -133658);
            hashMap.put("olive", -8355840);
            hashMap.put("olivedrab", -9728477);
            hashMap.put("orange", -23296);
            hashMap.put("orangered", -47872);
            hashMap.put("orchid", -2461482);
            hashMap.put("palegoldenrod", -1120086);
            hashMap.put("palegreen", -6751336);
            hashMap.put("paleturquoise", -5247250);
            hashMap.put("palevioletred", -2396013);
            hashMap.put("papayawhip", -4139);
            hashMap.put("peachpuff", -9543);
            hashMap.put("peru", -3308225);
            hashMap.put("pink", -16181);
            hashMap.put("plum", -2252579);
            hashMap.put("powderblue", -5185306);
            hashMap.put("purple", -8388480);
            hashMap.put("rebeccapurple", -10079335);
            hashMap.put("red", Integer.valueOf((int) SupportMenu.CATEGORY_MASK));
            hashMap.put("rosybrown", -4419697);
            hashMap.put("royalblue", -12490271);
            hashMap.put("saddlebrown", -7650029);
            hashMap.put("salmon", -360334);
            hashMap.put("sandybrown", -744352);
            hashMap.put("seagreen", -13726889);
            hashMap.put("seashell", -2578);
            hashMap.put("sienna", -6270419);
            hashMap.put("silver", -4144960);
            hashMap.put("skyblue", -7876885);
            hashMap.put("slateblue", -9807155);
            hashMap.put("slategray", -9404272);
            hashMap.put("slategrey", -9404272);
            hashMap.put(BQCCameraParam.SCENE_SNOW, -1286);
            hashMap.put("springgreen", -16711809);
            hashMap.put("steelblue", -12156236);
            hashMap.put("tan", -2968436);
            hashMap.put("teal", -16744320);
            hashMap.put("thistle", -2572328);
            hashMap.put("tomato", -40121);
            hashMap.put("turquoise", -12525360);
            hashMap.put("violet", -1146130);
            hashMap.put("wheat", -663885);
            hashMap.put("white", -1);
            hashMap.put("whitesmoke", -657931);
            hashMap.put("yellow", Integer.valueOf((int) InputDeviceCompat.SOURCE_ANY));
            hashMap.put("yellowgreen", -6632142);
            hashMap.put("transparent", 0);
        }

        static Integer a(String str) {
            return a.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class d {
        private static final Map<String, SVG.Length> a;

        static {
            HashMap hashMap = new HashMap(9);
            a = hashMap;
            SVG.Unit unit = SVG.Unit.pt;
            hashMap.put("xx-small", new SVG.Length(0.694f, unit));
            hashMap.put("x-small", new SVG.Length(0.833f, unit));
            hashMap.put("small", new SVG.Length(10.0f, unit));
            hashMap.put(wv.PARAM_LEVEL_MEDIUM, new SVG.Length(12.0f, unit));
            hashMap.put("large", new SVG.Length(14.4f, unit));
            hashMap.put("x-large", new SVG.Length(17.3f, unit));
            hashMap.put("xx-large", new SVG.Length(20.7f, unit));
            SVG.Unit unit2 = SVG.Unit.percent;
            hashMap.put("smaller", new SVG.Length(83.33f, unit2));
            hashMap.put("larger", new SVG.Length(120.0f, unit2));
        }

        static SVG.Length a(String str) {
            return a.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class e {
        private static final Map<String, Integer> a;

        static {
            HashMap hashMap = new HashMap(13);
            a = hashMap;
            hashMap.put("normal", 400);
            hashMap.put(Constants.Value.BOLD, 700);
            hashMap.put("bolder", 1);
            hashMap.put("lighter", -1);
            hashMap.put(MessageService.MSG_DB_COMPLETE, 100);
            hashMap.put("200", 200);
            hashMap.put("300", 300);
            hashMap.put("400", 400);
            hashMap.put("500", 500);
            hashMap.put("600", 600);
            hashMap.put("700", 700);
            hashMap.put("800", 800);
            hashMap.put("900", 900);
        }

        static Integer a(String str) {
            return a.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class f extends DefaultHandler2 {
        private f() {
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i, int i2) throws SAXException {
            SVGParser.this.c1(new String(cArr, i, i2));
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endDocument() throws SAXException {
            SVGParser.this.o();
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) throws SAXException {
            SVGParser.this.p(str, str2, str3);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void processingInstruction(String str, String str2) throws SAXException {
            SVGParser.this.r(str, SVGParser.this.x0(new g(str2)));
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startDocument() throws SAXException {
            SVGParser.this.W0();
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            SVGParser.this.X0(str, str2, str3, attributes);
        }

        /* synthetic */ f(SVGParser sVGParser, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class g {
        String a;
        int c;
        int b = 0;
        private com.caverock.androidsvg.c d = new com.caverock.androidsvg.c();

        /* JADX INFO: Access modifiers changed from: package-private */
        public g(String str) {
            this.c = 0;
            String trim = str.trim();
            this.a = trim;
            this.c = trim.length();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void A() {
            while (true) {
                int i = this.b;
                if (i >= this.c || !k(this.a.charAt(i))) {
                    return;
                }
                this.b++;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int a() {
            int i = this.b;
            int i2 = this.c;
            if (i == i2) {
                return -1;
            }
            int i3 = i + 1;
            this.b = i3;
            if (i3 < i2) {
                return this.a.charAt(i3);
            }
            return -1;
        }

        String b() {
            int i = this.b;
            while (!h() && !k(this.a.charAt(this.b))) {
                this.b++;
            }
            String substring = this.a.substring(i, this.b);
            this.b = i;
            return substring;
        }

        Boolean c(Object obj) {
            if (obj == null) {
                return null;
            }
            z();
            return m();
        }

        float d(float f) {
            if (Float.isNaN(f)) {
                return Float.NaN;
            }
            z();
            return n();
        }

        float e(Boolean bool) {
            if (bool == null) {
                return Float.NaN;
            }
            z();
            return n();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean f(char c) {
            int i = this.b;
            boolean z = i < this.c && this.a.charAt(i) == c;
            if (z) {
                this.b++;
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean g(String str) {
            int length = str.length();
            int i = this.b;
            boolean z = i <= this.c - length && this.a.substring(i, i + length).equals(str);
            if (z) {
                this.b += length;
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean h() {
            return this.b == this.c;
        }

        boolean i() {
            int i = this.b;
            if (i == this.c) {
                return false;
            }
            char charAt = this.a.charAt(i);
            return (charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z');
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean j(int i) {
            return i == 10 || i == 13;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean k(int i) {
            return i == 32 || i == 10 || i == 13 || i == 9;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Integer l() {
            int i = this.b;
            if (i == this.c) {
                return null;
            }
            String str = this.a;
            this.b = i + 1;
            return Integer.valueOf(str.charAt(i));
        }

        Boolean m() {
            int i = this.b;
            if (i == this.c) {
                return null;
            }
            char charAt = this.a.charAt(i);
            if (charAt == '0' || charAt == '1') {
                this.b++;
                return Boolean.valueOf(charAt == '1');
            }
            return null;
        }

        float n() {
            float b = this.d.b(this.a, this.b, this.c);
            if (!Float.isNaN(b)) {
                this.b = this.d.a();
            }
            return b;
        }

        String o() {
            if (h()) {
                return null;
            }
            int i = this.b;
            int charAt = this.a.charAt(i);
            while (true) {
                if ((charAt < 97 || charAt > 122) && (charAt < 65 || charAt > 90)) {
                    break;
                }
                charAt = a();
            }
            int i2 = this.b;
            while (k(charAt)) {
                charAt = a();
            }
            if (charAt == 40) {
                this.b++;
                return this.a.substring(i, i2);
            }
            this.b = i;
            return null;
        }

        SVG.Length p() {
            float n = n();
            if (Float.isNaN(n)) {
                return null;
            }
            SVG.Unit v = v();
            if (v == null) {
                return new SVG.Length(n, SVG.Unit.px);
            }
            return new SVG.Length(n, v);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String q() {
            if (h()) {
                return null;
            }
            int i = this.b;
            char charAt = this.a.charAt(i);
            if (charAt == '\'' || charAt == '\"') {
                int a = a();
                while (a != -1 && a != charAt) {
                    a = a();
                }
                if (a == -1) {
                    this.b = i;
                    return null;
                }
                int i2 = this.b + 1;
                this.b = i2;
                return this.a.substring(i + 1, i2 - 1);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String r() {
            return t(' ', false);
        }

        String s(char c) {
            return t(c, false);
        }

        String t(char c, boolean z) {
            if (h()) {
                return null;
            }
            char charAt = this.a.charAt(this.b);
            if ((z || !k(charAt)) && charAt != c) {
                int i = this.b;
                int a = a();
                while (a != -1 && a != c && (z || !k(a))) {
                    a = a();
                }
                return this.a.substring(i, this.b);
            }
            return null;
        }

        String u(char c) {
            return t(c, true);
        }

        SVG.Unit v() {
            if (h()) {
                return null;
            }
            if (this.a.charAt(this.b) == '%') {
                this.b++;
                return SVG.Unit.percent;
            }
            int i = this.b;
            if (i > this.c - 2) {
                return null;
            }
            try {
                SVG.Unit valueOf = SVG.Unit.valueOf(this.a.substring(i, i + 2).toLowerCase(Locale.US));
                this.b += 2;
                return valueOf;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String w() {
            if (h()) {
                return null;
            }
            int i = this.b;
            char charAt = this.a.charAt(i);
            if ((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z')) {
                int a = a();
                while (true) {
                    if ((a < 65 || a > 90) && (a < 97 || a > 122)) {
                        break;
                    }
                    a = a();
                }
                return this.a.substring(i, this.b);
            }
            this.b = i;
            return null;
        }

        float x() {
            z();
            float b = this.d.b(this.a, this.b, this.c);
            if (!Float.isNaN(b)) {
                this.b = this.d.a();
            }
            return b;
        }

        String y() {
            if (h()) {
                return null;
            }
            int i = this.b;
            this.b = this.c;
            return this.a.substring(i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean z() {
            A();
            int i = this.b;
            if (i != this.c && this.a.charAt(i) == ',') {
                this.b++;
                A();
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class h implements Attributes {
        private XmlPullParser a;

        public h(SVGParser sVGParser, XmlPullParser xmlPullParser) {
            this.a = xmlPullParser;
        }

        @Override // org.xml.sax.Attributes
        public int getIndex(String str) {
            return -1;
        }

        @Override // org.xml.sax.Attributes
        public int getIndex(String str, String str2) {
            return -1;
        }

        @Override // org.xml.sax.Attributes
        public int getLength() {
            return this.a.getAttributeCount();
        }

        @Override // org.xml.sax.Attributes
        public String getLocalName(int i) {
            return this.a.getAttributeName(i);
        }

        @Override // org.xml.sax.Attributes
        public String getQName(int i) {
            String attributeName = this.a.getAttributeName(i);
            if (this.a.getAttributePrefix(i) != null) {
                return this.a.getAttributePrefix(i) + jn1.CONDITION_IF_MIDDLE + attributeName;
            }
            return attributeName;
        }

        @Override // org.xml.sax.Attributes
        public String getType(int i) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getType(String str) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getType(String str, String str2) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getURI(int i) {
            return this.a.getAttributeNamespace(i);
        }

        @Override // org.xml.sax.Attributes
        public String getValue(int i) {
            return this.a.getAttributeValue(i);
        }

        @Override // org.xml.sax.Attributes
        public String getValue(String str) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getValue(String str, String str2) {
            return null;
        }
    }

    private void A(SVG.d dVar, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()]) {
                case 12:
                    dVar.o = o0(trim);
                    break;
                case 13:
                    dVar.p = o0(trim);
                    break;
                case 14:
                    SVG.Length o0 = o0(trim);
                    dVar.q = o0;
                    if (o0.isNegative()) {
                        throw new SVGParseException("Invalid <circle> element. r cannot be negative");
                    }
                    break;
            }
        }
    }

    private static Set<String> A0(String str) {
        g gVar = new g(str);
        HashSet hashSet = new HashSet();
        while (!gVar.h()) {
            hashSet.add(gVar.r());
            gVar.A();
        }
        return hashSet;
    }

    private void B(SVG.e eVar, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            if (a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()] == 38) {
                if ("objectBoundingBox".equals(trim)) {
                    eVar.o = Boolean.FALSE;
                } else if ("userSpaceOnUse".equals(trim)) {
                    eVar.o = Boolean.TRUE;
                } else {
                    throw new SVGParseException("Invalid value for attribute clipPathUnits");
                }
            }
        }
    }

    private static SVG.Length[] B0(String str) {
        SVG.Length p;
        g gVar = new g(str);
        gVar.A();
        if (gVar.h() || (p = gVar.p()) == null || p.isNegative()) {
            return null;
        }
        float floatValue = p.floatValue();
        ArrayList arrayList = new ArrayList();
        arrayList.add(p);
        while (!gVar.h()) {
            gVar.z();
            SVG.Length p2 = gVar.p();
            if (p2 == null || p2.isNegative()) {
                return null;
            }
            arrayList.add(p2);
            floatValue += p2.floatValue();
        }
        if (floatValue == 0.0f) {
            return null;
        }
        return (SVG.Length[]) arrayList.toArray(new SVG.Length[arrayList.size()]);
    }

    private void C(SVG.SvgConditional svgConditional, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()]) {
                case 21:
                    svgConditional.setRequiredFeatures(z0(trim));
                    break;
                case 22:
                    svgConditional.setRequiredExtensions(trim);
                    break;
                case 23:
                    svgConditional.setSystemLanguage(F0(trim));
                    break;
                case 24:
                    svgConditional.setRequiredFormats(A0(trim));
                    break;
                case 25:
                    List<String> i0 = i0(trim);
                    svgConditional.setRequiredFonts(i0 != null ? new HashSet(i0) : new HashSet(0));
                    break;
            }
        }
    }

    private static SVG.Style.LineCap C0(String str) {
        if ("butt".equals(str)) {
            return SVG.Style.LineCap.Butt;
        }
        if ("round".equals(str)) {
            return SVG.Style.LineCap.Round;
        }
        if ("square".equals(str)) {
            return SVG.Style.LineCap.Square;
        }
        return null;
    }

    private void D(SVG.a0 a0Var, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String qName = attributes.getQName(i);
            if (!qName.equals("id") && !qName.equals("xml:id")) {
                if (qName.equals("xml:space")) {
                    String trim = attributes.getValue(i).trim();
                    if ("default".equals(trim)) {
                        a0Var.d = Boolean.FALSE;
                        return;
                    } else if ("preserve".equals(trim)) {
                        a0Var.d = Boolean.TRUE;
                        return;
                    } else {
                        throw new SVGParseException("Invalid value for \"xml:space\" attribute: " + trim);
                    }
                }
            } else {
                a0Var.c = attributes.getValue(i).trim();
                return;
            }
        }
    }

    private static SVG.Style.LineJoin D0(String str) {
        if ("miter".equals(str)) {
            return SVG.Style.LineJoin.Miter;
        }
        if ("round".equals(str)) {
            return SVG.Style.LineJoin.Round;
        }
        if ("bevel".equals(str)) {
            return SVG.Style.LineJoin.Bevel;
        }
        return null;
    }

    private void E(SVG.g gVar, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()]) {
                case 10:
                    SVG.Length o0 = o0(trim);
                    gVar.q = o0;
                    if (o0.isNegative()) {
                        throw new SVGParseException("Invalid <ellipse> element. rx cannot be negative");
                    }
                    break;
                case 11:
                    SVG.Length o02 = o0(trim);
                    gVar.r = o02;
                    if (o02.isNegative()) {
                        throw new SVGParseException("Invalid <ellipse> element. ry cannot be negative");
                    }
                    break;
                case 12:
                    gVar.o = o0(trim);
                    break;
                case 13:
                    gVar.p = o0(trim);
                    break;
            }
        }
    }

    private static void E0(SVG.a0 a0Var, String str) {
        g gVar = new g(str.replaceAll("/\\*.*?\\*/", ""));
        while (true) {
            String s = gVar.s(jn1.CONDITION_IF_MIDDLE);
            gVar.A();
            if (!gVar.f(jn1.CONDITION_IF_MIDDLE)) {
                return;
            }
            gVar.A();
            String u = gVar.u(b90.TokenSEM);
            if (u == null) {
                return;
            }
            gVar.A();
            if (gVar.h() || gVar.f(b90.TokenSEM)) {
                if (a0Var.f == null) {
                    a0Var.f = new SVG.Style();
                }
                if (u.contains("!important")) {
                    a0Var.f.important = true;
                }
                S0(a0Var.f, s, u);
                gVar.A();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x008c, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void F(com.caverock.androidsvg.SVG.h r5, org.xml.sax.Attributes r6) throws com.caverock.androidsvg.SVGParseException {
        /*
            r4 = this;
            r0 = 0
        L1:
            int r1 = r6.getLength()
            if (r0 >= r1) goto L90
            java.lang.String r1 = r6.getValue(r0)
            java.lang.String r1 = r1.trim()
            int[] r2 = com.caverock.androidsvg.SVGParser.a.b
            java.lang.String r3 = r6.getLocalName(r0)
            com.caverock.androidsvg.SVGParser$SVGAttr r3 = com.caverock.androidsvg.SVGParser.SVGAttr.fromString(r3)
            int r3 = r3.ordinal()
            r2 = r2[r3]
            r3 = 6
            if (r2 == r3) goto L72
            switch(r2) {
                case 32: goto L50;
                case 33: goto L49;
                case 34: goto L26;
                default: goto L25;
            }
        L25:
            goto L8c
        L26:
            com.caverock.androidsvg.SVG$GradientSpread r2 = com.caverock.androidsvg.SVG.GradientSpread.valueOf(r1)     // Catch: java.lang.IllegalArgumentException -> L2d
            r5.k = r2     // Catch: java.lang.IllegalArgumentException -> L2d
            goto L8c
        L2d:
            com.caverock.androidsvg.SVGParseException r5 = new com.caverock.androidsvg.SVGParseException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "Invalid spreadMethod attribute. \""
            r6.append(r0)
            r6.append(r1)
            java.lang.String r0 = "\" is not a valid value."
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L49:
            android.graphics.Matrix r1 = r4.J0(r1)
            r5.j = r1
            goto L8c
        L50:
            java.lang.String r2 = "objectBoundingBox"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L5d
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            r5.i = r1
            goto L8c
        L5d:
            java.lang.String r2 = "userSpaceOnUse"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L6a
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            r5.i = r1
            goto L8c
        L6a:
            com.caverock.androidsvg.SVGParseException r5 = new com.caverock.androidsvg.SVGParseException
            java.lang.String r6 = "Invalid value for attribute gradientUnits"
            r5.<init>(r6)
            throw r5
        L72:
            java.lang.String r2 = r6.getURI(r0)
            java.lang.String r3 = ""
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L8a
            java.lang.String r2 = r6.getURI(r0)
            java.lang.String r3 = "http://www.w3.org/1999/xlink"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L8c
        L8a:
            r5.l = r1
        L8c:
            int r0 = r0 + 1
            goto L1
        L90:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVGParser.F(com.caverock.androidsvg.SVG$h, org.xml.sax.Attributes):void");
    }

    private static Set<String> F0(String str) {
        g gVar = new g(str);
        HashSet hashSet = new HashSet();
        while (!gVar.h()) {
            String r = gVar.r();
            int indexOf = r.indexOf(45);
            if (indexOf != -1) {
                r = r.substring(0, indexOf);
            }
            hashSet.add(new Locale(r, "", "").getLanguage());
            gVar.A();
        }
        return hashSet;
    }

    private void G(SVG.k kVar, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i2 = a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 1) {
                kVar.p = o0(trim);
            } else if (i2 == 2) {
                kVar.q = o0(trim);
            } else if (i2 == 3) {
                SVG.Length o0 = o0(trim);
                kVar.r = o0;
                if (o0.isNegative()) {
                    throw new SVGParseException("Invalid <use> element. width cannot be negative");
                }
            } else if (i2 == 4) {
                SVG.Length o02 = o0(trim);
                kVar.s = o02;
                if (o02.isNegative()) {
                    throw new SVGParseException("Invalid <use> element. height cannot be negative");
                }
            } else if (i2 != 6) {
                if (i2 == 7) {
                    w0(kVar, trim);
                }
            } else if ("".equals(attributes.getURI(i)) || "http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                kVar.o = trim;
            }
        }
    }

    private static SVG.Style.TextAnchor G0(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1074341483:
                if (str.equals("middle")) {
                    c2 = 0;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    c2 = 1;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return SVG.Style.TextAnchor.Middle;
            case 1:
                return SVG.Style.TextAnchor.End;
            case 2:
                return SVG.Style.TextAnchor.Start;
            default:
                return null;
        }
    }

    private void H(SVG.l lVar, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()]) {
                case 15:
                    lVar.o = o0(trim);
                    break;
                case 16:
                    lVar.p = o0(trim);
                    break;
                case 17:
                    lVar.q = o0(trim);
                    break;
                case 18:
                    lVar.r = o0(trim);
                    break;
            }
        }
    }

    private static SVG.Style.TextDecoration H0(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1171789332:
                if (str.equals("line-through")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1026963764:
                if (str.equals("underline")) {
                    c2 = 1;
                    break;
                }
                break;
            case 3387192:
                if (str.equals("none")) {
                    c2 = 2;
                    break;
                }
                break;
            case 93826908:
                if (str.equals("blink")) {
                    c2 = 3;
                    break;
                }
                break;
            case 529818312:
                if (str.equals("overline")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return SVG.Style.TextDecoration.LineThrough;
            case 1:
                return SVG.Style.TextDecoration.Underline;
            case 2:
                return SVG.Style.TextDecoration.None;
            case 3:
                return SVG.Style.TextDecoration.Blink;
            case 4:
                return SVG.Style.TextDecoration.Overline;
            default:
                return null;
        }
    }

    private void I(SVG.b0 b0Var, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()]) {
                case 15:
                    b0Var.m = o0(trim);
                    break;
                case 16:
                    b0Var.n = o0(trim);
                    break;
                case 17:
                    b0Var.o = o0(trim);
                    break;
                case 18:
                    b0Var.p = o0(trim);
                    break;
            }
        }
    }

    private static SVG.Style.TextDirection I0(String str) {
        str.hashCode();
        if (str.equals("ltr")) {
            return SVG.Style.TextDirection.LTR;
        }
        if (str.equals(Constants.Name.RTL)) {
            return SVG.Style.TextDirection.RTL;
        }
        return null;
    }

    private void J(SVG.m mVar, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()]) {
                case 26:
                    mVar.q = o0(trim);
                    break;
                case 27:
                    mVar.r = o0(trim);
                    break;
                case 28:
                    SVG.Length o0 = o0(trim);
                    mVar.s = o0;
                    if (o0.isNegative()) {
                        throw new SVGParseException("Invalid <marker> element. markerWidth cannot be negative");
                    }
                    break;
                case 29:
                    SVG.Length o02 = o0(trim);
                    mVar.t = o02;
                    if (o02.isNegative()) {
                        throw new SVGParseException("Invalid <marker> element. markerHeight cannot be negative");
                    }
                    break;
                case 30:
                    if ("strokeWidth".equals(trim)) {
                        mVar.p = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        mVar.p = true;
                        break;
                    } else {
                        throw new SVGParseException("Invalid value for attribute markerUnits");
                    }
                case 31:
                    if ("auto".equals(trim)) {
                        mVar.u = Float.valueOf(Float.NaN);
                        break;
                    } else {
                        mVar.u = Float.valueOf(f0(trim));
                        break;
                    }
            }
        }
    }

    private Matrix J0(String str) throws SVGParseException {
        Matrix matrix = new Matrix();
        g gVar = new g(str);
        gVar.A();
        while (!gVar.h()) {
            String o = gVar.o();
            if (o != null) {
                char c2 = 65535;
                switch (o.hashCode()) {
                    case -1081239615:
                        if (o.equals("matrix")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -925180581:
                        if (o.equals("rotate")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 109250890:
                        if (o.equals("scale")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 109493390:
                        if (o.equals("skewX")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 109493391:
                        if (o.equals("skewY")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 1052832078:
                        if (o.equals("translate")) {
                            c2 = 5;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        gVar.A();
                        float n = gVar.n();
                        gVar.z();
                        float n2 = gVar.n();
                        gVar.z();
                        float n3 = gVar.n();
                        gVar.z();
                        float n4 = gVar.n();
                        gVar.z();
                        float n5 = gVar.n();
                        gVar.z();
                        float n6 = gVar.n();
                        gVar.A();
                        if (!Float.isNaN(n6) && gVar.f(')')) {
                            Matrix matrix2 = new Matrix();
                            matrix2.setValues(new float[]{n, n3, n5, n2, n4, n6, 0.0f, 0.0f, 1.0f});
                            matrix.preConcat(matrix2);
                            break;
                        } else {
                            throw new SVGParseException("Invalid transform list: " + str);
                        }
                        break;
                    case 1:
                        gVar.A();
                        float n7 = gVar.n();
                        float x = gVar.x();
                        float x2 = gVar.x();
                        gVar.A();
                        if (!Float.isNaN(n7) && gVar.f(')')) {
                            if (Float.isNaN(x)) {
                                matrix.preRotate(n7);
                                break;
                            } else if (!Float.isNaN(x2)) {
                                matrix.preRotate(n7, x, x2);
                                break;
                            } else {
                                throw new SVGParseException("Invalid transform list: " + str);
                            }
                        } else {
                            throw new SVGParseException("Invalid transform list: " + str);
                        }
                    case 2:
                        gVar.A();
                        float n8 = gVar.n();
                        float x3 = gVar.x();
                        gVar.A();
                        if (!Float.isNaN(n8) && gVar.f(')')) {
                            if (Float.isNaN(x3)) {
                                matrix.preScale(n8, n8);
                                break;
                            } else {
                                matrix.preScale(n8, x3);
                                break;
                            }
                        } else {
                            throw new SVGParseException("Invalid transform list: " + str);
                        }
                        break;
                    case 3:
                        gVar.A();
                        float n9 = gVar.n();
                        gVar.A();
                        if (!Float.isNaN(n9) && gVar.f(')')) {
                            matrix.preSkew((float) Math.tan(Math.toRadians(n9)), 0.0f);
                            break;
                        } else {
                            throw new SVGParseException("Invalid transform list: " + str);
                        }
                        break;
                    case 4:
                        gVar.A();
                        float n10 = gVar.n();
                        gVar.A();
                        if (!Float.isNaN(n10) && gVar.f(')')) {
                            matrix.preSkew(0.0f, (float) Math.tan(Math.toRadians(n10)));
                            break;
                        } else {
                            throw new SVGParseException("Invalid transform list: " + str);
                        }
                    case 5:
                        gVar.A();
                        float n11 = gVar.n();
                        float x4 = gVar.x();
                        gVar.A();
                        if (!Float.isNaN(n11) && gVar.f(')')) {
                            if (Float.isNaN(x4)) {
                                matrix.preTranslate(n11, 0.0f);
                                break;
                            } else {
                                matrix.preTranslate(n11, x4);
                                break;
                            }
                        } else {
                            throw new SVGParseException("Invalid transform list: " + str);
                        }
                        break;
                    default:
                        throw new SVGParseException("Invalid transform list fn: " + o + jn1.BRACKET_END_STR);
                }
                if (gVar.h()) {
                    return matrix;
                }
                gVar.z();
            } else {
                throw new SVGParseException("Bad transform function encountered in transform list: " + str);
            }
        }
        return matrix;
    }

    private void K(SVG.n nVar, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i2 = a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 1) {
                nVar.p = o0(trim);
            } else if (i2 == 2) {
                nVar.q = o0(trim);
            } else if (i2 == 3) {
                SVG.Length o0 = o0(trim);
                nVar.r = o0;
                if (o0.isNegative()) {
                    throw new SVGParseException("Invalid <mask> element. width cannot be negative");
                }
            } else if (i2 == 4) {
                SVG.Length o02 = o0(trim);
                nVar.s = o02;
                if (o02.isNegative()) {
                    throw new SVGParseException("Invalid <mask> element. height cannot be negative");
                }
            } else if (i2 != 43) {
                if (i2 != 44) {
                    continue;
                } else if ("objectBoundingBox".equals(trim)) {
                    nVar.o = Boolean.FALSE;
                } else if ("userSpaceOnUse".equals(trim)) {
                    nVar.o = Boolean.TRUE;
                } else {
                    throw new SVGParseException("Invalid value for attribute maskContentUnits");
                }
            } else if ("objectBoundingBox".equals(trim)) {
                nVar.n = Boolean.FALSE;
            } else if ("userSpaceOnUse".equals(trim)) {
                nVar.n = Boolean.TRUE;
            } else {
                throw new SVGParseException("Invalid value for attribute maskUnits");
            }
        }
    }

    private void K0(InputStream inputStream) throws SVGParseException {
        Log.d("SVGParser", "Falling back to SAX parser");
        try {
            SAXParserFactory newInstance = SAXParserFactory.newInstance();
            newInstance.setFeature("http://xml.org/sax/features/external-general-entities", false);
            newInstance.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            XMLReader xMLReader = newInstance.newSAXParser().getXMLReader();
            f fVar = new f(this, null);
            xMLReader.setContentHandler(fVar);
            xMLReader.setProperty("http://xml.org/sax/properties/lexical-handler", fVar);
            xMLReader.parse(new InputSource(inputStream));
        } catch (IOException e2) {
            throw new SVGParseException("Stream error", e2);
        } catch (ParserConfigurationException e3) {
            throw new SVGParseException("XML parser problem", e3);
        } catch (SAXException e4) {
            throw new SVGParseException("SVG parse error", e4);
        }
    }

    private void L(SVG.o oVar, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i2 = a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 8) {
                oVar.o = u0(trim);
            } else if (i2 != 9) {
                continue;
            } else {
                Float valueOf = Float.valueOf(f0(trim));
                oVar.p = valueOf;
                if (valueOf.floatValue() < 0.0f) {
                    throw new SVGParseException("Invalid <path> element. pathLength cannot be negative");
                }
            }
        }
    }

    private void L0(InputStream inputStream, boolean z) throws SVGParseException {
        try {
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                h hVar = new h(this, newPullParser);
                newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-docdecl", false);
                newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                newPullParser.setInput(inputStream, null);
                for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.nextToken()) {
                    if (eventType == 0) {
                        W0();
                    } else if (eventType == 8) {
                        Log.d("SVGParser", "PROC INSTR: " + newPullParser.getText());
                        g gVar = new g(newPullParser.getText());
                        r(gVar.r(), x0(gVar));
                    } else if (eventType != 10) {
                        if (eventType == 2) {
                            String name = newPullParser.getName();
                            if (newPullParser.getPrefix() != null) {
                                name = newPullParser.getPrefix() + jn1.CONDITION_IF_MIDDLE + name;
                            }
                            X0(newPullParser.getNamespace(), newPullParser.getName(), name, hVar);
                        } else if (eventType == 3) {
                            String name2 = newPullParser.getName();
                            if (newPullParser.getPrefix() != null) {
                                name2 = newPullParser.getPrefix() + jn1.CONDITION_IF_MIDDLE + name2;
                            }
                            p(newPullParser.getNamespace(), newPullParser.getName(), name2);
                        } else if (eventType == 4) {
                            int[] iArr = new int[2];
                            e1(newPullParser.getTextCharacters(iArr), iArr[0], iArr[1]);
                        } else if (eventType == 5) {
                            c1(newPullParser.getText());
                        }
                    } else if (z && this.a.l() == null && newPullParser.getText().contains("<!ENTITY ")) {
                        try {
                            Log.d("SVGParser", "Switching to SAX parser to process entities");
                            inputStream.reset();
                            K0(inputStream);
                            return;
                        } catch (IOException unused) {
                            Log.w("SVGParser", "Detected internal entity definitions, but could not parse them.");
                            return;
                        }
                    }
                }
                o();
            } catch (XmlPullParserException e2) {
                throw new SVGParseException("XML parser problem", e2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } catch (IOException e3) {
            throw new SVGParseException("Stream error", e3);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x00cf, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void M(com.caverock.androidsvg.SVG.q r6, org.xml.sax.Attributes r7) throws com.caverock.androidsvg.SVGParseException {
        /*
            r5 = this;
            r0 = 0
        L1:
            int r1 = r7.getLength()
            if (r0 >= r1) goto Ld3
            java.lang.String r1 = r7.getValue(r0)
            java.lang.String r1 = r1.trim()
            int[] r2 = com.caverock.androidsvg.SVGParser.a.b
            java.lang.String r3 = r7.getLocalName(r0)
            com.caverock.androidsvg.SVGParser$SVGAttr r3 = com.caverock.androidsvg.SVGParser.SVGAttr.fromString(r3)
            int r3 = r3.ordinal()
            r2 = r2[r3]
            r3 = 1
            if (r2 == r3) goto Lc9
            r3 = 2
            if (r2 == r3) goto Lc2
            r3 = 3
            if (r2 == r3) goto Lad
            r3 = 4
            if (r2 == r3) goto L98
            r3 = 6
            if (r2 == r3) goto L7d
            java.lang.String r3 = "userSpaceOnUse"
            java.lang.String r4 = "objectBoundingBox"
            switch(r2) {
                case 40: goto L5f;
                case 41: goto L3f;
                case 42: goto L37;
                default: goto L35;
            }
        L35:
            goto Lcf
        L37:
            android.graphics.Matrix r1 = r5.J0(r1)
            r6.r = r1
            goto Lcf
        L3f:
            boolean r2 = r4.equals(r1)
            if (r2 == 0) goto L4b
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            r6.q = r1
            goto Lcf
        L4b:
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L57
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            r6.q = r1
            goto Lcf
        L57:
            com.caverock.androidsvg.SVGParseException r6 = new com.caverock.androidsvg.SVGParseException
            java.lang.String r7 = "Invalid value for attribute patternContentUnits"
            r6.<init>(r7)
            throw r6
        L5f:
            boolean r2 = r4.equals(r1)
            if (r2 == 0) goto L6a
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            r6.p = r1
            goto Lcf
        L6a:
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L75
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            r6.p = r1
            goto Lcf
        L75:
            com.caverock.androidsvg.SVGParseException r6 = new com.caverock.androidsvg.SVGParseException
            java.lang.String r7 = "Invalid value for attribute patternUnits"
            r6.<init>(r7)
            throw r6
        L7d:
            java.lang.String r2 = r7.getURI(r0)
            java.lang.String r3 = ""
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L95
            java.lang.String r2 = r7.getURI(r0)
            java.lang.String r3 = "http://www.w3.org/1999/xlink"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto Lcf
        L95:
            r6.w = r1
            goto Lcf
        L98:
            com.caverock.androidsvg.SVG$Length r1 = o0(r1)
            r6.v = r1
            boolean r1 = r1.isNegative()
            if (r1 != 0) goto La5
            goto Lcf
        La5:
            com.caverock.androidsvg.SVGParseException r6 = new com.caverock.androidsvg.SVGParseException
            java.lang.String r7 = "Invalid <pattern> element. height cannot be negative"
            r6.<init>(r7)
            throw r6
        Lad:
            com.caverock.androidsvg.SVG$Length r1 = o0(r1)
            r6.u = r1
            boolean r1 = r1.isNegative()
            if (r1 != 0) goto Lba
            goto Lcf
        Lba:
            com.caverock.androidsvg.SVGParseException r6 = new com.caverock.androidsvg.SVGParseException
            java.lang.String r7 = "Invalid <pattern> element. width cannot be negative"
            r6.<init>(r7)
            throw r6
        Lc2:
            com.caverock.androidsvg.SVG$Length r1 = o0(r1)
            r6.t = r1
            goto Lcf
        Lc9:
            com.caverock.androidsvg.SVG$Length r1 = o0(r1)
            r6.s = r1
        Lcf:
            int r0 = r0 + 1
            goto L1
        Ld3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVGParser.M(com.caverock.androidsvg.SVG$q, org.xml.sax.Attributes):void");
    }

    private static SVG.Style.VectorEffect M0(String str) {
        str.hashCode();
        if (str.equals("none")) {
            return SVG.Style.VectorEffect.None;
        }
        if (str.equals("non-scaling-stroke")) {
            return SVG.Style.VectorEffect.NonScalingStroke;
        }
        return null;
    }

    private void N(SVG.r rVar, Attributes attributes, String str) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            if (SVGAttr.fromString(attributes.getLocalName(i)) == SVGAttr.points) {
                g gVar = new g(attributes.getValue(i));
                ArrayList<Float> arrayList = new ArrayList();
                gVar.A();
                while (!gVar.h()) {
                    float n = gVar.n();
                    if (!Float.isNaN(n)) {
                        gVar.z();
                        float n2 = gVar.n();
                        if (!Float.isNaN(n2)) {
                            gVar.z();
                            arrayList.add(Float.valueOf(n));
                            arrayList.add(Float.valueOf(n2));
                        } else {
                            throw new SVGParseException("Invalid <" + str + "> points attribute. There should be an even number of coordinates.");
                        }
                    } else {
                        throw new SVGParseException("Invalid <" + str + "> points attribute. Non-coordinate content found in list.");
                    }
                }
                rVar.o = new float[arrayList.size()];
                int i2 = 0;
                for (Float f2 : arrayList) {
                    rVar.o[i2] = f2.floatValue();
                    i2++;
                }
            }
        }
    }

    private static SVG.b N0(String str) throws SVGParseException {
        g gVar = new g(str);
        gVar.A();
        float n = gVar.n();
        gVar.z();
        float n2 = gVar.n();
        gVar.z();
        float n3 = gVar.n();
        gVar.z();
        float n4 = gVar.n();
        if (Float.isNaN(n) || Float.isNaN(n2) || Float.isNaN(n3) || Float.isNaN(n4)) {
            throw new SVGParseException("Invalid viewBox definition - should have four numbers");
        }
        if (n3 >= 0.0f) {
            if (n4 >= 0.0f) {
                return new SVG.b(n, n2, n3, n4);
            }
            throw new SVGParseException("Invalid viewBox. height cannot be negative");
        }
        throw new SVGParseException("Invalid viewBox. width cannot be negative");
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x005b, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void O(com.caverock.androidsvg.SVG.e0 r5, org.xml.sax.Attributes r6) throws com.caverock.androidsvg.SVGParseException {
        /*
            r4 = this;
            r0 = 0
        L1:
            int r1 = r6.getLength()
            if (r0 >= r1) goto L5e
            java.lang.String r1 = r6.getValue(r0)
            java.lang.String r1 = r1.trim()
            int[] r2 = com.caverock.androidsvg.SVGParser.a.b
            java.lang.String r3 = r6.getLocalName(r0)
            com.caverock.androidsvg.SVGParser$SVGAttr r3 = com.caverock.androidsvg.SVGParser.SVGAttr.fromString(r3)
            int r3 = r3.ordinal()
            r2 = r2[r3]
            r3 = 35
            if (r2 == r3) goto L55
            r3 = 36
            if (r2 == r3) goto L4e
            switch(r2) {
                case 12: goto L47;
                case 13: goto L40;
                case 14: goto L2b;
                default: goto L2a;
            }
        L2a:
            goto L5b
        L2b:
            com.caverock.androidsvg.SVG$Length r1 = o0(r1)
            r5.o = r1
            boolean r1 = r1.isNegative()
            if (r1 != 0) goto L38
            goto L5b
        L38:
            com.caverock.androidsvg.SVGParseException r5 = new com.caverock.androidsvg.SVGParseException
            java.lang.String r6 = "Invalid <radialGradient> element. r cannot be negative"
            r5.<init>(r6)
            throw r5
        L40:
            com.caverock.androidsvg.SVG$Length r1 = o0(r1)
            r5.n = r1
            goto L5b
        L47:
            com.caverock.androidsvg.SVG$Length r1 = o0(r1)
            r5.m = r1
            goto L5b
        L4e:
            com.caverock.androidsvg.SVG$Length r1 = o0(r1)
            r5.q = r1
            goto L5b
        L55:
            com.caverock.androidsvg.SVG$Length r1 = o0(r1)
            r5.p = r1
        L5b:
            int r0 = r0 + 1
            goto L1
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVGParser.O(com.caverock.androidsvg.SVG$e0, org.xml.sax.Attributes):void");
    }

    private void O0(Attributes attributes) throws SVGParseException {
        l("<path>", new Object[0]);
        if (this.b != null) {
            SVG.o oVar = new SVG.o();
            oVar.a = this.a;
            oVar.b = this.b;
            D(oVar, attributes);
            S(oVar, attributes);
            W(oVar, attributes);
            C(oVar, attributes);
            L(oVar, attributes);
            this.b.addChild(oVar);
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void P(SVG.t tVar, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i2 = a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 1) {
                tVar.o = o0(trim);
            } else if (i2 == 2) {
                tVar.p = o0(trim);
            } else if (i2 == 3) {
                SVG.Length o0 = o0(trim);
                tVar.q = o0;
                if (o0.isNegative()) {
                    throw new SVGParseException("Invalid <rect> element. width cannot be negative");
                }
            } else if (i2 == 4) {
                SVG.Length o02 = o0(trim);
                tVar.r = o02;
                if (o02.isNegative()) {
                    throw new SVGParseException("Invalid <rect> element. height cannot be negative");
                }
            } else if (i2 == 10) {
                SVG.Length o03 = o0(trim);
                tVar.s = o03;
                if (o03.isNegative()) {
                    throw new SVGParseException("Invalid <rect> element. rx cannot be negative");
                }
            } else if (i2 != 11) {
                continue;
            } else {
                SVG.Length o04 = o0(trim);
                tVar.t = o04;
                if (o04.isNegative()) {
                    throw new SVGParseException("Invalid <rect> element. ry cannot be negative");
                }
            }
        }
    }

    private void P0(Attributes attributes) throws SVGParseException {
        l("<pattern>", new Object[0]);
        if (this.b != null) {
            SVG.q qVar = new SVG.q();
            qVar.a = this.a;
            qVar.b = this.b;
            D(qVar, attributes);
            S(qVar, attributes);
            C(qVar, attributes);
            Y(qVar, attributes);
            M(qVar, attributes);
            this.b.addChild(qVar);
            this.b = qVar;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void Q(SVG.w wVar, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i2 = a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 1) {
                wVar.p = o0(trim);
            } else if (i2 == 2) {
                wVar.q = o0(trim);
            } else if (i2 == 3) {
                SVG.Length o0 = o0(trim);
                wVar.r = o0;
                if (o0.isNegative()) {
                    throw new SVGParseException("Invalid <svg> element. width cannot be negative");
                }
            } else if (i2 == 4) {
                SVG.Length o02 = o0(trim);
                wVar.s = o02;
                if (o02.isNegative()) {
                    throw new SVGParseException("Invalid <svg> element. height cannot be negative");
                }
            } else if (i2 == 5) {
                wVar.t = trim;
            }
        }
    }

    private void Q0(Attributes attributes) throws SVGParseException {
        l("<polygon>", new Object[0]);
        if (this.b != null) {
            SVG.r sVar = new SVG.s();
            sVar.a = this.a;
            sVar.b = this.b;
            D(sVar, attributes);
            S(sVar, attributes);
            W(sVar, attributes);
            C(sVar, attributes);
            N(sVar, attributes, "polygon");
            this.b.addChild(sVar);
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void R(SVG.v vVar, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            if (a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()] == 37) {
                vVar.h = n0(trim);
            }
        }
    }

    private void R0(Attributes attributes) throws SVGParseException {
        l("<polyline>", new Object[0]);
        if (this.b != null) {
            SVG.r rVar = new SVG.r();
            rVar.a = this.a;
            rVar.b = this.b;
            D(rVar, attributes);
            S(rVar, attributes);
            W(rVar, attributes);
            C(rVar, attributes);
            N(rVar, attributes, "polyline");
            this.b.addChild(rVar);
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void S(SVG.a0 a0Var, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            if (trim.length() != 0) {
                int i2 = a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
                if (i2 == 45) {
                    E0(a0Var, trim);
                } else if (i2 != 46) {
                    if (a0Var.e == null) {
                        a0Var.e = new SVG.Style();
                    }
                    S0(a0Var.e, attributes.getLocalName(i), attributes.getValue(i).trim());
                } else {
                    a0Var.g = CSSParser.f(trim);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void S0(SVG.Style style, String str, String str2) {
        if (str2.length() == 0 || str2.equals("inherit")) {
            return;
        }
        try {
            switch (a.b[SVGAttr.fromString(str).ordinal()]) {
                case 47:
                    SVG.SvgPaint t0 = t0(str2);
                    style.fill = t0;
                    if (t0 != null) {
                        style.specifiedFlags |= 1;
                        return;
                    }
                    return;
                case 48:
                    SVG.Style.FillRule e0 = e0(str2);
                    style.fillRule = e0;
                    if (e0 != null) {
                        style.specifiedFlags |= 2;
                        return;
                    }
                    return;
                case 49:
                    Float r0 = r0(str2);
                    style.fillOpacity = r0;
                    if (r0 != null) {
                        style.specifiedFlags |= 4;
                        return;
                    }
                    return;
                case 50:
                    SVG.SvgPaint t02 = t0(gh0.a(str2));
                    style.stroke = t02;
                    if (t02 != null) {
                        style.specifiedFlags |= 8;
                        return;
                    }
                    return;
                case 51:
                    Float r02 = r0(str2);
                    style.strokeOpacity = r02;
                    if (r02 != null) {
                        style.specifiedFlags |= 16;
                        return;
                    }
                    return;
                case 52:
                    style.strokeWidth = o0(str2);
                    style.specifiedFlags |= 32;
                    break;
                case 53:
                    SVG.Style.LineCap C0 = C0(str2);
                    style.strokeLineCap = C0;
                    if (C0 != null) {
                        style.specifiedFlags |= 64;
                        return;
                    }
                    return;
                case 54:
                    SVG.Style.LineJoin D0 = D0(str2);
                    style.strokeLineJoin = D0;
                    if (D0 != null) {
                        style.specifiedFlags |= 128;
                        return;
                    }
                    return;
                case 55:
                    style.strokeMiterLimit = Float.valueOf(f0(str2));
                    style.specifiedFlags |= 256;
                    break;
                case 56:
                    if ("none".equals(str2)) {
                        style.strokeDashArray = null;
                        style.specifiedFlags |= 512;
                        return;
                    }
                    SVG.Length[] B0 = B0(str2);
                    style.strokeDashArray = B0;
                    if (B0 != null) {
                        style.specifiedFlags |= 512;
                        return;
                    }
                    return;
                case 57:
                    style.strokeDashOffset = o0(str2);
                    style.specifiedFlags |= 1024;
                    break;
                case 58:
                    style.opacity = r0(str2);
                    style.specifiedFlags |= 2048;
                    return;
                case 59:
                    style.color = b0(str2);
                    style.specifiedFlags |= 4096;
                    break;
                case 60:
                    h0(style, str2);
                    return;
                case 61:
                    List<String> i0 = i0(str2);
                    style.fontFamily = i0;
                    if (i0 != null) {
                        style.specifiedFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                        return;
                    }
                    return;
                case 62:
                    SVG.Length j0 = j0(str2);
                    style.fontSize = j0;
                    if (j0 != null) {
                        style.specifiedFlags |= PlaybackStateCompat.ACTION_PREPARE;
                        return;
                    }
                    return;
                case 63:
                    Integer l0 = l0(str2);
                    style.fontWeight = l0;
                    if (l0 != null) {
                        style.specifiedFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                        return;
                    }
                    return;
                case 64:
                    SVG.Style.FontStyle k0 = k0(str2);
                    style.fontStyle = k0;
                    if (k0 != null) {
                        style.specifiedFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                        return;
                    }
                    return;
                case 65:
                    SVG.Style.TextDecoration H0 = H0(str2);
                    style.textDecoration = H0;
                    if (H0 != null) {
                        style.specifiedFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
                        return;
                    }
                    return;
                case 66:
                    SVG.Style.TextDirection I0 = I0(str2);
                    style.direction = I0;
                    if (I0 != null) {
                        style.specifiedFlags |= Constants.RequestStrategy.REMOTE_FILE;
                        return;
                    }
                    return;
                case 67:
                    SVG.Style.TextAnchor G0 = G0(str2);
                    style.textAnchor = G0;
                    if (G0 != null) {
                        style.specifiedFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                        return;
                    }
                    return;
                case 68:
                    Boolean s0 = s0(str2);
                    style.overflow = s0;
                    if (s0 != null) {
                        style.specifiedFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                        return;
                    }
                    return;
                case 69:
                    String m0 = m0(str2, str);
                    style.markerStart = m0;
                    style.markerMid = m0;
                    style.markerEnd = m0;
                    style.specifiedFlags |= 14680064;
                    return;
                case 70:
                    style.markerStart = m0(str2, str);
                    style.specifiedFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
                    return;
                case 71:
                    style.markerMid = m0(str2, str);
                    style.specifiedFlags |= 4194304;
                    return;
                case 72:
                    style.markerEnd = m0(str2, str);
                    style.specifiedFlags |= 8388608;
                    return;
                case 73:
                    if (str2.indexOf(124) < 0) {
                        if ("|inline|block|list-item|run-in|compact|marker|table|inline-table|table-row-group|table-header-group|table-footer-group|table-row|table-column-group|table-column|table-cell|table-caption|none|".contains('|' + str2 + '|')) {
                            style.display = Boolean.valueOf(!str2.equals("none"));
                            style.specifiedFlags |= 16777216;
                            return;
                        }
                        return;
                    }
                    return;
                case 74:
                    if (str2.indexOf(124) < 0) {
                        if ("|visible|hidden|collapse|".contains('|' + str2 + '|')) {
                            style.visibility = Boolean.valueOf(str2.equals("visible"));
                            style.specifiedFlags |= 33554432;
                            return;
                        }
                        return;
                    }
                    return;
                case 75:
                    if (str2.equals("currentColor")) {
                        style.stopColor = SVG.CurrentColor.getInstance();
                    } else {
                        try {
                            style.stopColor = b0(str2);
                        } catch (SVGParseException e2) {
                            Log.w("SVGParser", e2.getMessage());
                            return;
                        }
                    }
                    style.specifiedFlags |= 67108864;
                    return;
                case 76:
                    style.stopOpacity = r0(str2);
                    style.specifiedFlags |= 134217728;
                    return;
                case 77:
                    SVG.c a0 = a0(str2);
                    style.clip = a0;
                    if (a0 != null) {
                        style.specifiedFlags |= 1048576;
                        return;
                    }
                    return;
                case 78:
                    style.clipPath = m0(str2, str);
                    style.specifiedFlags |= 268435456;
                    return;
                case 79:
                    style.clipRule = e0(str2);
                    style.specifiedFlags |= 536870912;
                    return;
                case 80:
                    style.mask = m0(str2, str);
                    style.specifiedFlags |= 1073741824;
                    return;
                case 81:
                    if (str2.equals("currentColor")) {
                        style.solidColor = SVG.CurrentColor.getInstance();
                    } else {
                        try {
                            style.solidColor = b0(str2);
                        } catch (SVGParseException e3) {
                            Log.w("SVGParser", e3.getMessage());
                            return;
                        }
                    }
                    style.specifiedFlags |= 2147483648L;
                    return;
                case 82:
                    style.solidOpacity = r0(str2);
                    style.specifiedFlags |= Constants.RequestStrategy.LOCAL_FIRST;
                    return;
                case 83:
                    if (str2.equals("currentColor")) {
                        style.viewportFill = SVG.CurrentColor.getInstance();
                    } else {
                        try {
                            style.viewportFill = b0(str2);
                        } catch (SVGParseException e4) {
                            Log.w("SVGParser", e4.getMessage());
                            return;
                        }
                    }
                    style.specifiedFlags |= Constants.RequestStrategy.REMOTE_FIRST;
                    return;
                case 84:
                    style.viewportFillOpacity = r0(str2);
                    style.specifiedFlags |= Constants.RequestStrategy.LOCAL_SERIAL;
                    return;
                case 85:
                    SVG.Style.VectorEffect M0 = M0(str2);
                    style.vectorEffect = M0;
                    if (M0 != null) {
                        style.specifiedFlags |= Constants.RequestStrategy.LOCAL_FILE;
                        return;
                    }
                    return;
                case 86:
                    SVG.Style.RenderQuality y0 = y0(str2);
                    style.imageRendering = y0;
                    if (y0 != null) {
                        style.specifiedFlags |= 137438953472L;
                        return;
                    }
                    return;
                default:
            }
        } catch (SVGParseException unused) {
        }
    }

    private void T(SVG.i0 i0Var, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            if (a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()] == 6 && ("".equals(attributes.getURI(i)) || "http://www.w3.org/1999/xlink".equals(attributes.getURI(i)))) {
                i0Var.n = trim;
            }
        }
    }

    private void T0(Attributes attributes) throws SVGParseException {
        l("<radialGradient>", new Object[0]);
        if (this.b != null) {
            SVG.e0 e0Var = new SVG.e0();
            e0Var.a = this.a;
            e0Var.b = this.b;
            D(e0Var, attributes);
            S(e0Var, attributes);
            F(e0Var, attributes);
            O(e0Var, attributes);
            this.b.addChild(e0Var);
            this.b = e0Var;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void U(SVG.m0 m0Var, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i2 = a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 != 6) {
                if (i2 == 39) {
                    m0Var.o = o0(trim);
                }
            } else if ("".equals(attributes.getURI(i)) || "http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                m0Var.n = trim;
            }
        }
    }

    private void U0(Attributes attributes) throws SVGParseException {
        l("<rect>", new Object[0]);
        if (this.b != null) {
            SVG.t tVar = new SVG.t();
            tVar.a = this.a;
            tVar.b = this.b;
            D(tVar, attributes);
            S(tVar, attributes);
            W(tVar, attributes);
            C(tVar, attributes);
            P(tVar, attributes);
            this.b.addChild(tVar);
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void V(SVG.n0 n0Var, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i2 = a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 1) {
                n0Var.n = p0(trim);
            } else if (i2 == 2) {
                n0Var.o = p0(trim);
            } else if (i2 == 19) {
                n0Var.p = p0(trim);
            } else if (i2 == 20) {
                n0Var.q = p0(trim);
            }
        }
    }

    private void V0(Attributes attributes) throws SVGParseException {
        l("<solidColor>", new Object[0]);
        if (this.b != null) {
            SVG.u uVar = new SVG.u();
            uVar.a = this.a;
            uVar.b = this.b;
            D(uVar, attributes);
            S(uVar, attributes);
            this.b.addChild(uVar);
            this.b = uVar;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void W(SVG.HasTransform hasTransform, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            if (SVGAttr.fromString(attributes.getLocalName(i)) == SVGAttr.transform) {
                hasTransform.setTransform(J0(attributes.getValue(i)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W0() {
        this.a = new SVG();
    }

    private void X(SVG.p0 p0Var, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i2 = a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 1) {
                p0Var.p = o0(trim);
            } else if (i2 == 2) {
                p0Var.q = o0(trim);
            } else if (i2 == 3) {
                SVG.Length o0 = o0(trim);
                p0Var.r = o0;
                if (o0.isNegative()) {
                    throw new SVGParseException("Invalid <use> element. width cannot be negative");
                }
            } else if (i2 != 4) {
                if (i2 == 6 && ("".equals(attributes.getURI(i)) || "http://www.w3.org/1999/xlink".equals(attributes.getURI(i)))) {
                    p0Var.o = trim;
                }
            } else {
                SVG.Length o02 = o0(trim);
                p0Var.s = o02;
                if (o02.isNegative()) {
                    throw new SVGParseException("Invalid <use> element. height cannot be negative");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0(String str, String str2, String str3, Attributes attributes) throws SVGParseException {
        if (this.c) {
            this.d++;
        } else if ("http://www.w3.org/2000/svg".equals(str) || "".equals(str)) {
            if (str2.length() <= 0) {
                str2 = str3;
            }
            SVGElem fromString = SVGElem.fromString(str2);
            switch (a.a[fromString.ordinal()]) {
                case 1:
                    a1(attributes);
                    return;
                case 2:
                case 3:
                    q(attributes);
                    return;
                case 4:
                    m(attributes);
                    return;
                case 5:
                    i1(attributes);
                    return;
                case 6:
                    O0(attributes);
                    return;
                case 7:
                    U0(attributes);
                    return;
                case 8:
                    i(attributes);
                    return;
                case 9:
                    n(attributes);
                    return;
                case 10:
                    v(attributes);
                    return;
                case 11:
                    R0(attributes);
                    return;
                case 12:
                    Q0(attributes);
                    return;
                case 13:
                    d1(attributes);
                    return;
                case 14:
                    h1(attributes);
                    return;
                case 15:
                    g1(attributes);
                    return;
                case 16:
                    k1(attributes);
                    return;
                case 17:
                    b1(attributes);
                    return;
                case 18:
                    x(attributes);
                    return;
                case 19:
                    w(attributes);
                    return;
                case 20:
                    T0(attributes);
                    return;
                case 21:
                    Y0(attributes);
                    return;
                case 22:
                case 23:
                    this.e = true;
                    this.f = fromString;
                    return;
                case 24:
                    k(attributes);
                    return;
                case 25:
                    f1(attributes);
                    return;
                case 26:
                    P0(attributes);
                    return;
                case 27:
                    u(attributes);
                    return;
                case 28:
                    j1(attributes);
                    return;
                case 29:
                    y(attributes);
                    return;
                case 30:
                    Z0(attributes);
                    return;
                case 31:
                    V0(attributes);
                    return;
                default:
                    this.c = true;
                    this.d = 1;
                    return;
            }
        }
    }

    private void Y(SVG.f0 f0Var, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i2 = a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 7) {
                w0(f0Var, trim);
            } else if (i2 == 87) {
                f0Var.o = N0(trim);
            }
        }
    }

    private void Y0(Attributes attributes) throws SVGParseException {
        l("<stop>", new Object[0]);
        SVG.SvgContainer svgContainer = this.b;
        if (svgContainer != null) {
            if (svgContainer instanceof SVG.h) {
                SVG.v vVar = new SVG.v();
                vVar.a = this.a;
                vVar.b = this.b;
                D(vVar, attributes);
                S(vVar, attributes);
                R(vVar, attributes);
                this.b.addChild(vVar);
                this.b = vVar;
                return;
            }
            throw new SVGParseException("Invalid document. <stop> elements are only valid inside <linearGradient> or <radialGradient> elements.");
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void Z(String str) {
        this.a.a(new CSSParser(CSSParser.MediaType.screen, CSSParser.Source.Document).d(str));
    }

    private void Z0(Attributes attributes) throws SVGParseException {
        l("<style>", new Object[0]);
        if (this.b != null) {
            String str = "all";
            boolean z = true;
            for (int i = 0; i < attributes.getLength(); i++) {
                String trim = attributes.getValue(i).trim();
                int i2 = a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
                if (i2 == 88) {
                    z = trim.equals("text/css");
                } else if (i2 == 89) {
                    str = trim;
                }
            }
            if (z && CSSParser.b(str, CSSParser.MediaType.screen)) {
                this.h = true;
                return;
            }
            this.c = true;
            this.d = 1;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private static SVG.c a0(String str) {
        if (!"auto".equals(str) && str.startsWith("rect(")) {
            g gVar = new g(str.substring(5));
            gVar.A();
            SVG.Length q0 = q0(gVar);
            gVar.z();
            SVG.Length q02 = q0(gVar);
            gVar.z();
            SVG.Length q03 = q0(gVar);
            gVar.z();
            SVG.Length q04 = q0(gVar);
            gVar.A();
            if (gVar.f(')') || gVar.h()) {
                return new SVG.c(q0, q02, q03, q04);
            }
            return null;
        }
        return null;
    }

    private void a1(Attributes attributes) throws SVGParseException {
        l("<svg>", new Object[0]);
        SVG.w wVar = new SVG.w();
        wVar.a = this.a;
        wVar.b = this.b;
        D(wVar, attributes);
        S(wVar, attributes);
        C(wVar, attributes);
        Y(wVar, attributes);
        Q(wVar, attributes);
        SVG.SvgContainer svgContainer = this.b;
        if (svgContainer == null) {
            this.a.r(wVar);
        } else {
            svgContainer.addChild(wVar);
        }
        this.b = wVar;
    }

    private static SVG.Colour b0(String str) throws SVGParseException {
        if (str.charAt(0) == '#') {
            com.caverock.androidsvg.b b2 = com.caverock.androidsvg.b.b(str, 1, str.length());
            if (b2 != null) {
                int a2 = b2.a();
                if (a2 == 4) {
                    int d2 = b2.d();
                    int i = d2 & 3840;
                    int i2 = d2 & GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN;
                    int i3 = d2 & 15;
                    return new SVG.Colour(i3 | (i << 8) | (-16777216) | (i << 12) | (i2 << 8) | (i2 << 4) | (i3 << 4));
                } else if (a2 == 5) {
                    int d3 = b2.d();
                    int i4 = 61440 & d3;
                    int i5 = d3 & 3840;
                    int i6 = d3 & GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN;
                    int i7 = d3 & 15;
                    return new SVG.Colour((i7 << 24) | (i7 << 28) | (i4 << 8) | (i4 << 4) | (i5 << 4) | i5 | i6 | (i6 >> 4));
                } else if (a2 != 7) {
                    if (a2 == 9) {
                        return new SVG.Colour((b2.d() >>> 8) | (b2.d() << 24));
                    }
                    throw new SVGParseException("Bad hex colour value: " + str);
                } else {
                    return new SVG.Colour(b2.d() | (-16777216));
                }
            }
            throw new SVGParseException("Bad hex colour value: " + str);
        }
        String lowerCase = str.toLowerCase(Locale.US);
        boolean startsWith = lowerCase.startsWith("rgba(");
        if (!startsWith && !lowerCase.startsWith("rgb(")) {
            boolean startsWith2 = lowerCase.startsWith("hsla(");
            if (!startsWith2 && !lowerCase.startsWith("hsl(")) {
                return c0(lowerCase);
            }
            g gVar = new g(str.substring(startsWith2 ? 5 : 4));
            gVar.A();
            float n = gVar.n();
            float d4 = gVar.d(n);
            if (!Float.isNaN(d4)) {
                gVar.f(WXUtils.PERCENT);
            }
            float d5 = gVar.d(d4);
            if (!Float.isNaN(d5)) {
                gVar.f(WXUtils.PERCENT);
            }
            if (startsWith2) {
                float d6 = gVar.d(d5);
                gVar.A();
                if (!Float.isNaN(d6) && gVar.f(')')) {
                    return new SVG.Colour((j(d6 * 256.0f) << 24) | s(n, d4, d5));
                }
                throw new SVGParseException("Bad hsla() colour value: " + str);
            }
            gVar.A();
            if (!Float.isNaN(d5) && gVar.f(')')) {
                return new SVG.Colour(s(n, d4, d5) | (-16777216));
            }
            throw new SVGParseException("Bad hsl() colour value: " + str);
        }
        g gVar2 = new g(str.substring(startsWith ? 5 : 4));
        gVar2.A();
        float n2 = gVar2.n();
        if (!Float.isNaN(n2) && gVar2.f(WXUtils.PERCENT)) {
            n2 = (n2 * 256.0f) / 100.0f;
        }
        float d7 = gVar2.d(n2);
        if (!Float.isNaN(d7) && gVar2.f(WXUtils.PERCENT)) {
            d7 = (d7 * 256.0f) / 100.0f;
        }
        float d8 = gVar2.d(d7);
        if (!Float.isNaN(d8) && gVar2.f(WXUtils.PERCENT)) {
            d8 = (d8 * 256.0f) / 100.0f;
        }
        if (startsWith) {
            float d9 = gVar2.d(d8);
            gVar2.A();
            if (!Float.isNaN(d9) && gVar2.f(')')) {
                return new SVG.Colour((j(d9 * 256.0f) << 24) | (j(n2) << 16) | (j(d7) << 8) | j(d8));
            }
            throw new SVGParseException("Bad rgba() colour value: " + str);
        }
        gVar2.A();
        if (!Float.isNaN(d8) && gVar2.f(')')) {
            return new SVG.Colour((j(n2) << 16) | (-16777216) | (j(d7) << 8) | j(d8));
        }
        throw new SVGParseException("Bad rgb() colour value: " + str);
    }

    private void b1(Attributes attributes) throws SVGParseException {
        l("<symbol>", new Object[0]);
        if (this.b != null) {
            SVG.f0 h0Var = new SVG.h0();
            h0Var.a = this.a;
            h0Var.b = this.b;
            D(h0Var, attributes);
            S(h0Var, attributes);
            C(h0Var, attributes);
            Y(h0Var, attributes);
            this.b.addChild(h0Var);
            this.b = h0Var;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private static SVG.Colour c0(String str) throws SVGParseException {
        Integer a2 = c.a(str);
        if (a2 != null) {
            return new SVG.Colour(a2.intValue());
        }
        throw new SVGParseException("Invalid colour keyword: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c1(String str) throws SVGParseException {
        if (this.c) {
            return;
        }
        if (this.e) {
            if (this.g == null) {
                this.g = new StringBuilder(str.length());
            }
            this.g.append(str);
        } else if (this.h) {
            if (this.i == null) {
                this.i = new StringBuilder(str.length());
            }
            this.i.append(str);
        } else if (this.b instanceof SVG.l0) {
            h(str);
        }
    }

    private static SVG.SvgPaint d0(String str) {
        str.hashCode();
        if (str.equals("none")) {
            return SVG.Colour.TRANSPARENT;
        }
        if (!str.equals("currentColor")) {
            try {
                return b0(str);
            } catch (SVGParseException unused) {
                return null;
            }
        }
        return SVG.CurrentColor.getInstance();
    }

    private void d1(Attributes attributes) throws SVGParseException {
        l("<text>", new Object[0]);
        if (this.b != null) {
            SVG.k0 k0Var = new SVG.k0();
            k0Var.a = this.a;
            k0Var.b = this.b;
            D(k0Var, attributes);
            S(k0Var, attributes);
            W(k0Var, attributes);
            C(k0Var, attributes);
            V(k0Var, attributes);
            this.b.addChild(k0Var);
            this.b = k0Var;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private static SVG.Style.FillRule e0(String str) {
        if ("nonzero".equals(str)) {
            return SVG.Style.FillRule.NonZero;
        }
        if ("evenodd".equals(str)) {
            return SVG.Style.FillRule.EvenOdd;
        }
        return null;
    }

    private void e1(char[] cArr, int i, int i2) throws SVGParseException {
        if (this.c) {
            return;
        }
        if (this.e) {
            if (this.g == null) {
                this.g = new StringBuilder(i2);
            }
            this.g.append(cArr, i, i2);
        } else if (this.h) {
            if (this.i == null) {
                this.i = new StringBuilder(i2);
            }
            this.i.append(cArr, i, i2);
        } else if (this.b instanceof SVG.l0) {
            h(new String(cArr, i, i2));
        }
    }

    private static float f0(String str) throws SVGParseException {
        int length = str.length();
        if (length != 0) {
            return g0(str, 0, length);
        }
        throw new SVGParseException("Invalid float value (empty string)");
    }

    private void f1(Attributes attributes) throws SVGParseException {
        l("<textPath>", new Object[0]);
        if (this.b != null) {
            SVG.m0 m0Var = new SVG.m0();
            m0Var.a = this.a;
            m0Var.b = this.b;
            D(m0Var, attributes);
            S(m0Var, attributes);
            C(m0Var, attributes);
            U(m0Var, attributes);
            this.b.addChild(m0Var);
            this.b = m0Var;
            SVG.SvgContainer svgContainer = m0Var.b;
            if (svgContainer instanceof SVG.TextRoot) {
                m0Var.setTextRoot((SVG.TextRoot) svgContainer);
                return;
            } else {
                m0Var.setTextRoot(((SVG.TextChild) svgContainer).getTextRoot());
                return;
            }
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private static float g0(String str, int i, int i2) throws SVGParseException {
        float b2 = new com.caverock.androidsvg.c().b(str, i, i2);
        if (Float.isNaN(b2)) {
            throw new SVGParseException("Invalid float value: " + str);
        }
        return b2;
    }

    private void g1(Attributes attributes) throws SVGParseException {
        l("<tref>", new Object[0]);
        SVG.SvgContainer svgContainer = this.b;
        if (svgContainer != null) {
            if (svgContainer instanceof SVG.l0) {
                SVG.i0 i0Var = new SVG.i0();
                i0Var.a = this.a;
                i0Var.b = this.b;
                D(i0Var, attributes);
                S(i0Var, attributes);
                C(i0Var, attributes);
                T(i0Var, attributes);
                this.b.addChild(i0Var);
                SVG.SvgContainer svgContainer2 = i0Var.b;
                if (svgContainer2 instanceof SVG.TextRoot) {
                    i0Var.setTextRoot((SVG.TextRoot) svgContainer2);
                    return;
                } else {
                    i0Var.setTextRoot(((SVG.TextChild) svgContainer2).getTextRoot());
                    return;
                }
            }
            throw new SVGParseException("Invalid document. <tref> elements are only valid inside <text> or <tspan> elements.");
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void h(String str) throws SVGParseException {
        SVG.x xVar = (SVG.x) this.b;
        int size = xVar.i.size();
        SVG.c0 c0Var = size == 0 ? null : xVar.i.get(size - 1);
        if (c0Var instanceof SVG.o0) {
            StringBuilder sb = new StringBuilder();
            SVG.o0 o0Var = (SVG.o0) c0Var;
            sb.append(o0Var.c);
            sb.append(str);
            o0Var.c = sb.toString();
            return;
        }
        this.b.addChild(new SVG.o0(str));
    }

    private static void h0(SVG.Style style, String str) {
        String s;
        if ("|caption|icon|menu|message-box|small-caption|status-bar|".contains('|' + str + '|')) {
            g gVar = new g(str);
            Integer num = null;
            SVG.Style.FontStyle fontStyle = null;
            String str2 = null;
            while (true) {
                s = gVar.s(r10.DIR);
                gVar.A();
                if (s != null) {
                    if (num != null && fontStyle != null) {
                        break;
                    } else if (!s.equals("normal") && (num != null || (num = e.a(s)) == null)) {
                        if (fontStyle != null || (fontStyle = k0(s)) == null) {
                            if (str2 != null || !s.equals("small-caps")) {
                                break;
                            }
                            str2 = s;
                        }
                    }
                } else {
                    return;
                }
            }
            SVG.Length j0 = j0(s);
            if (gVar.f(r10.DIR)) {
                gVar.A();
                String r = gVar.r();
                if (r != null) {
                    try {
                        o0(r);
                    } catch (SVGParseException unused) {
                        return;
                    }
                }
                gVar.A();
            }
            style.fontFamily = i0(gVar.y());
            style.fontSize = j0;
            style.fontWeight = Integer.valueOf(num == null ? 400 : num.intValue());
            if (fontStyle == null) {
                fontStyle = SVG.Style.FontStyle.Normal;
            }
            style.fontStyle = fontStyle;
            style.specifiedFlags |= 122880;
        }
    }

    private void h1(Attributes attributes) throws SVGParseException {
        l("<tspan>", new Object[0]);
        SVG.SvgContainer svgContainer = this.b;
        if (svgContainer != null) {
            if (svgContainer instanceof SVG.l0) {
                SVG.j0 j0Var = new SVG.j0();
                j0Var.a = this.a;
                j0Var.b = this.b;
                D(j0Var, attributes);
                S(j0Var, attributes);
                C(j0Var, attributes);
                V(j0Var, attributes);
                this.b.addChild(j0Var);
                this.b = j0Var;
                SVG.SvgContainer svgContainer2 = j0Var.b;
                if (svgContainer2 instanceof SVG.TextRoot) {
                    j0Var.setTextRoot((SVG.TextRoot) svgContainer2);
                    return;
                } else {
                    j0Var.setTextRoot(((SVG.TextChild) svgContainer2).getTextRoot());
                    return;
                }
            }
            throw new SVGParseException("Invalid document. <tspan> elements are only valid inside <text> or other <tspan> elements.");
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void i(Attributes attributes) throws SVGParseException {
        l("<circle>", new Object[0]);
        if (this.b != null) {
            SVG.d dVar = new SVG.d();
            dVar.a = this.a;
            dVar.b = this.b;
            D(dVar, attributes);
            S(dVar, attributes);
            W(dVar, attributes);
            C(dVar, attributes);
            A(dVar, attributes);
            this.b.addChild(dVar);
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private static List<String> i0(String str) {
        g gVar = new g(str);
        ArrayList arrayList = null;
        do {
            String q = gVar.q();
            if (q == null) {
                q = gVar.u(',');
            }
            if (q == null) {
                break;
            }
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(q);
            gVar.z();
        } while (!gVar.h());
        return arrayList;
    }

    private void i1(Attributes attributes) throws SVGParseException {
        l("<use>", new Object[0]);
        if (this.b != null) {
            SVG.p0 p0Var = new SVG.p0();
            p0Var.a = this.a;
            p0Var.b = this.b;
            D(p0Var, attributes);
            S(p0Var, attributes);
            W(p0Var, attributes);
            C(p0Var, attributes);
            X(p0Var, attributes);
            this.b.addChild(p0Var);
            this.b = p0Var;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private static int j(float f2) {
        if (f2 < 0.0f) {
            return 0;
        }
        if (f2 > 255.0f) {
            return 255;
        }
        return Math.round(f2);
    }

    private static SVG.Length j0(String str) {
        try {
            SVG.Length a2 = d.a(str);
            return a2 == null ? o0(str) : a2;
        } catch (SVGParseException unused) {
            return null;
        }
    }

    private void j1(Attributes attributes) throws SVGParseException {
        l("<view>", new Object[0]);
        if (this.b != null) {
            SVG.f0 q0Var = new SVG.q0();
            q0Var.a = this.a;
            q0Var.b = this.b;
            D(q0Var, attributes);
            C(q0Var, attributes);
            Y(q0Var, attributes);
            this.b.addChild(q0Var);
            this.b = q0Var;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void k(Attributes attributes) throws SVGParseException {
        l("<clipPath>", new Object[0]);
        if (this.b != null) {
            SVG.e eVar = new SVG.e();
            eVar.a = this.a;
            eVar.b = this.b;
            D(eVar, attributes);
            S(eVar, attributes);
            W(eVar, attributes);
            C(eVar, attributes);
            B(eVar, attributes);
            this.b.addChild(eVar);
            this.b = eVar;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private static SVG.Style.FontStyle k0(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1657669071:
                if (str.equals("oblique")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1178781136:
                if (str.equals(Constants.Value.ITALIC)) {
                    c2 = 1;
                    break;
                }
                break;
            case -1039745817:
                if (str.equals("normal")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return SVG.Style.FontStyle.Oblique;
            case 1:
                return SVG.Style.FontStyle.Italic;
            case 2:
                return SVG.Style.FontStyle.Normal;
            default:
                return null;
        }
    }

    private void k1(Attributes attributes) throws SVGParseException {
        l("<switch>", new Object[0]);
        if (this.b != null) {
            SVG.g0 g0Var = new SVG.g0();
            g0Var.a = this.a;
            g0Var.b = this.b;
            D(g0Var, attributes);
            S(g0Var, attributes);
            W(g0Var, attributes);
            C(g0Var, attributes);
            this.b.addChild(g0Var);
            this.b = g0Var;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void l(String str, Object... objArr) {
    }

    private static Integer l0(String str) {
        return e.a(str);
    }

    private void m(Attributes attributes) throws SVGParseException {
        l("<defs>", new Object[0]);
        if (this.b != null) {
            SVG.f fVar = new SVG.f();
            fVar.a = this.a;
            fVar.b = this.b;
            D(fVar, attributes);
            S(fVar, attributes);
            W(fVar, attributes);
            this.b.addChild(fVar);
            this.b = fVar;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private static String m0(String str, String str2) {
        if (!str.equals("none") && str.startsWith("url(")) {
            if (str.endsWith(jn1.BRACKET_END_STR)) {
                return str.substring(4, str.length() - 1).trim();
            }
            return str.substring(4).trim();
        }
        return null;
    }

    private void n(Attributes attributes) throws SVGParseException {
        l("<ellipse>", new Object[0]);
        if (this.b != null) {
            SVG.g gVar = new SVG.g();
            gVar.a = this.a;
            gVar.b = this.b;
            D(gVar, attributes);
            S(gVar, attributes);
            W(gVar, attributes);
            C(gVar, attributes);
            E(gVar, attributes);
            this.b.addChild(gVar);
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private Float n0(String str) throws SVGParseException {
        if (str.length() != 0) {
            int length = str.length();
            boolean z = true;
            if (str.charAt(str.length() - 1) == '%') {
                length--;
            } else {
                z = false;
            }
            try {
                float g0 = g0(str, 0, length);
                float f2 = 100.0f;
                if (z) {
                    g0 /= 100.0f;
                }
                if (g0 < 0.0f) {
                    f2 = 0.0f;
                } else if (g0 <= 100.0f) {
                    f2 = g0;
                }
                return Float.valueOf(f2);
            } catch (NumberFormatException e2) {
                throw new SVGParseException("Invalid offset value in <stop>: " + str, e2);
            }
        }
        throw new SVGParseException("Invalid offset value in <stop> (empty string)");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
    }

    static SVG.Length o0(String str) throws SVGParseException {
        if (str.length() != 0) {
            int length = str.length();
            SVG.Unit unit = SVG.Unit.px;
            char charAt = str.charAt(length - 1);
            if (charAt == '%') {
                length--;
                unit = SVG.Unit.percent;
            } else if (length > 2 && Character.isLetter(charAt) && Character.isLetter(str.charAt(length - 2))) {
                length -= 2;
                try {
                    unit = SVG.Unit.valueOf(str.substring(length).toLowerCase(Locale.US));
                } catch (IllegalArgumentException unused) {
                    throw new SVGParseException("Invalid length unit specifier: " + str);
                }
            }
            try {
                return new SVG.Length(g0(str, 0, length), unit);
            } catch (NumberFormatException e2) {
                throw new SVGParseException("Invalid length value: " + str, e2);
            }
        }
        throw new SVGParseException("Invalid length value (empty string)");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(String str, String str2, String str3) throws SVGParseException {
        if (this.c) {
            int i = this.d - 1;
            this.d = i;
            if (i == 0) {
                this.c = false;
                return;
            }
        }
        if ("http://www.w3.org/2000/svg".equals(str) || "".equals(str)) {
            if (str2.length() <= 0) {
                str2 = str3;
            }
            int i2 = a.a[SVGElem.fromString(str2).ordinal()];
            if (i2 != 1 && i2 != 2 && i2 != 4 && i2 != 5 && i2 != 13 && i2 != 14) {
                switch (i2) {
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 31:
                        break;
                    case 22:
                    case 23:
                        this.e = false;
                        StringBuilder sb = this.g;
                        if (sb != null) {
                            SVGElem sVGElem = this.f;
                            if (sVGElem == SVGElem.title) {
                                this.a.s(sb.toString());
                            } else if (sVGElem == SVGElem.desc) {
                                this.a.q(sb.toString());
                            }
                            this.g.setLength(0);
                            return;
                        }
                        return;
                    case 30:
                        StringBuilder sb2 = this.i;
                        if (sb2 != null) {
                            this.h = false;
                            Z(sb2.toString());
                            this.i.setLength(0);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
            this.b = ((SVG.c0) this.b).b;
        }
    }

    private static List<SVG.Length> p0(String str) throws SVGParseException {
        if (str.length() != 0) {
            ArrayList arrayList = new ArrayList(1);
            g gVar = new g(str);
            gVar.A();
            while (!gVar.h()) {
                float n = gVar.n();
                if (!Float.isNaN(n)) {
                    SVG.Unit v = gVar.v();
                    if (v == null) {
                        v = SVG.Unit.px;
                    }
                    arrayList.add(new SVG.Length(n, v));
                    gVar.z();
                } else {
                    throw new SVGParseException("Invalid length list value: " + gVar.b());
                }
            }
            return arrayList;
        }
        throw new SVGParseException("Invalid length list (empty string)");
    }

    private void q(Attributes attributes) throws SVGParseException {
        l("<g>", new Object[0]);
        if (this.b != null) {
            SVG.j jVar = new SVG.j();
            jVar.a = this.a;
            jVar.b = this.b;
            D(jVar, attributes);
            S(jVar, attributes);
            W(jVar, attributes);
            C(jVar, attributes);
            this.b.addChild(jVar);
            this.b = jVar;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private static SVG.Length q0(g gVar) {
        if (gVar.g("auto")) {
            return new SVG.Length(0.0f);
        }
        return gVar.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(String str, Map<String, String> map) {
        if (str.equals("xml-stylesheet")) {
            SVG.g();
        }
    }

    private static Float r0(String str) {
        try {
            float f0 = f0(str);
            if (f0 < 0.0f) {
                f0 = 0.0f;
            } else if (f0 > 1.0f) {
                f0 = 1.0f;
            }
            return Float.valueOf(f0);
        } catch (SVGParseException unused) {
            return null;
        }
    }

    private static int s(float f2, float f3, float f4) {
        int i = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
        float f5 = f2 % 360.0f;
        if (i < 0) {
            f5 += 360.0f;
        }
        float f6 = f5 / 60.0f;
        float f7 = f3 / 100.0f;
        float f8 = f4 / 100.0f;
        if (f7 < 0.0f) {
            f7 = 0.0f;
        } else if (f7 > 1.0f) {
            f7 = 1.0f;
        }
        float f9 = f8 >= 0.0f ? f8 > 1.0f ? 1.0f : f8 : 0.0f;
        float f10 = f9 <= 0.5f ? (f7 + 1.0f) * f9 : (f9 + f7) - (f7 * f9);
        float f11 = (f9 * 2.0f) - f10;
        return j(t(f11, f10, f6 - 2.0f) * 256.0f) | (j(t(f11, f10, f6 + 2.0f) * 256.0f) << 16) | (j(t(f11, f10, f6) * 256.0f) << 8);
    }

    private static Boolean s0(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1217487446:
                if (str.equals("hidden")) {
                    c2 = 0;
                    break;
                }
                break;
            case -907680051:
                if (str.equals("scroll")) {
                    c2 = 1;
                    break;
                }
                break;
            case 3005871:
                if (str.equals("auto")) {
                    c2 = 2;
                    break;
                }
                break;
            case 466743410:
                if (str.equals("visible")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
                return Boolean.FALSE;
            case 2:
            case 3:
                return Boolean.TRUE;
            default:
                return null;
        }
    }

    private static float t(float f2, float f3, float f4) {
        float f5;
        if (f4 < 0.0f) {
            f4 += 6.0f;
        }
        if (f4 >= 6.0f) {
            f4 -= 6.0f;
        }
        if (f4 < 1.0f) {
            f5 = (f3 - f2) * f4;
        } else if (f4 < 3.0f) {
            return f3;
        } else {
            if (f4 >= 4.0f) {
                return f2;
            }
            f5 = (f3 - f2) * (4.0f - f4);
        }
        return f5 + f2;
    }

    private static SVG.SvgPaint t0(String str) {
        if (str.startsWith("url(")) {
            int indexOf = str.indexOf(jn1.BRACKET_END_STR);
            if (indexOf != -1) {
                String trim = str.substring(4, indexOf).trim();
                String trim2 = str.substring(indexOf + 1).trim();
                return new SVG.PaintReference(trim, trim2.length() > 0 ? d0(trim2) : null);
            }
            return new SVG.PaintReference(str.substring(4).trim(), null);
        }
        return d0(str);
    }

    private void u(Attributes attributes) throws SVGParseException {
        l("<image>", new Object[0]);
        if (this.b != null) {
            SVG.k kVar = new SVG.k();
            kVar.a = this.a;
            kVar.b = this.b;
            D(kVar, attributes);
            S(kVar, attributes);
            W(kVar, attributes);
            C(kVar, attributes);
            G(kVar, attributes);
            this.b.addChild(kVar);
            this.b = kVar;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x02a6, code lost:
        return r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.caverock.androidsvg.SVG.p u0(java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 762
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVGParser.u0(java.lang.String):com.caverock.androidsvg.SVG$p");
    }

    private void v(Attributes attributes) throws SVGParseException {
        l("<line>", new Object[0]);
        if (this.b != null) {
            SVG.l lVar = new SVG.l();
            lVar.a = this.a;
            lVar.b = this.b;
            D(lVar, attributes);
            S(lVar, attributes);
            W(lVar, attributes);
            C(lVar, attributes);
            H(lVar, attributes);
            this.b.addChild(lVar);
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    static PreserveAspectRatio v0(String str) throws SVGParseException {
        g gVar = new g(str);
        gVar.A();
        String r = gVar.r();
        if ("defer".equals(r)) {
            gVar.A();
            r = gVar.r();
        }
        PreserveAspectRatio.Alignment a2 = b.a(r);
        PreserveAspectRatio.Scale scale = null;
        gVar.A();
        if (!gVar.h()) {
            String r2 = gVar.r();
            r2.hashCode();
            if (r2.equals("meet")) {
                scale = PreserveAspectRatio.Scale.meet;
            } else if (r2.equals("slice")) {
                scale = PreserveAspectRatio.Scale.slice;
            } else {
                throw new SVGParseException("Invalid preserveAspectRatio definition: " + str);
            }
        }
        return new PreserveAspectRatio(a2, scale);
    }

    private void w(Attributes attributes) throws SVGParseException {
        l("<linearGradient>", new Object[0]);
        if (this.b != null) {
            SVG.b0 b0Var = new SVG.b0();
            b0Var.a = this.a;
            b0Var.b = this.b;
            D(b0Var, attributes);
            S(b0Var, attributes);
            F(b0Var, attributes);
            I(b0Var, attributes);
            this.b.addChild(b0Var);
            this.b = b0Var;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private static void w0(SVG.d0 d0Var, String str) throws SVGParseException {
        d0Var.n = v0(str);
    }

    private void x(Attributes attributes) throws SVGParseException {
        l("<marker>", new Object[0]);
        if (this.b != null) {
            SVG.m mVar = new SVG.m();
            mVar.a = this.a;
            mVar.b = this.b;
            D(mVar, attributes);
            S(mVar, attributes);
            C(mVar, attributes);
            Y(mVar, attributes);
            J(mVar, attributes);
            this.b.addChild(mVar);
            this.b = mVar;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> x0(g gVar) {
        HashMap hashMap = new HashMap();
        gVar.A();
        String s = gVar.s(com.alipay.sdk.m.n.a.h);
        while (s != null) {
            gVar.f(com.alipay.sdk.m.n.a.h);
            hashMap.put(s, gVar.q());
            gVar.A();
            s = gVar.s(com.alipay.sdk.m.n.a.h);
        }
        return hashMap;
    }

    private void y(Attributes attributes) throws SVGParseException {
        l("<mask>", new Object[0]);
        if (this.b != null) {
            SVG.n nVar = new SVG.n();
            nVar.a = this.a;
            nVar.b = this.b;
            D(nVar, attributes);
            S(nVar, attributes);
            C(nVar, attributes);
            K(nVar, attributes);
            this.b.addChild(nVar);
            this.b = nVar;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private static SVG.Style.RenderQuality y0(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -933002398:
                if (str.equals("optimizeQuality")) {
                    c2 = 0;
                    break;
                }
                break;
            case 3005871:
                if (str.equals("auto")) {
                    c2 = 1;
                    break;
                }
                break;
            case 362741610:
                if (str.equals("optimizeSpeed")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return SVG.Style.RenderQuality.optimizeQuality;
            case 1:
                return SVG.Style.RenderQuality.auto;
            case 2:
                return SVG.Style.RenderQuality.optimizeSpeed;
            default:
                return null;
        }
    }

    private static Set<String> z0(String str) {
        g gVar = new g(str);
        HashSet hashSet = new HashSet();
        while (!gVar.h()) {
            String r = gVar.r();
            if (r.startsWith("http://www.w3.org/TR/SVG11/feature#")) {
                hashSet.add(r.substring(35));
            } else {
                hashSet.add("UNSUPPORTED");
            }
            gVar.A();
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SVG z(InputStream inputStream, boolean z) throws SVGParseException {
        if (!inputStream.markSupported()) {
            inputStream = new BufferedInputStream(inputStream);
        }
        try {
            inputStream.mark(3);
            int read = inputStream.read() + (inputStream.read() << 8);
            inputStream.reset();
            if (read == 35615) {
                inputStream = new BufferedInputStream(new GZIPInputStream(inputStream));
            }
        } catch (IOException unused) {
        }
        try {
            inputStream.mark(4096);
            L0(inputStream, z);
            return this.a;
        } finally {
            try {
                inputStream.close();
            } catch (IOException unused2) {
                Log.e("SVGParser", "Exception thrown closing input stream");
            }
        }
    }
}
