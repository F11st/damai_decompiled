package com.caverock.androidsvg;

import android.graphics.Matrix;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.util.Xml;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.alipay.sdk.m.n.C4250a;
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
    /* renamed from: com.caverock.androidsvg.SVGParser$a */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class C4737a {
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
    /* renamed from: com.caverock.androidsvg.SVGParser$b */
    /* loaded from: classes10.dex */
    public static class C4738b {
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
    /* renamed from: com.caverock.androidsvg.SVGParser$c */
    /* loaded from: classes10.dex */
    public static class C4739c {
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
    /* renamed from: com.caverock.androidsvg.SVGParser$d */
    /* loaded from: classes10.dex */
    public static class C4740d {
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
    /* renamed from: com.caverock.androidsvg.SVGParser$e */
    /* loaded from: classes10.dex */
    public static class C4741e {
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
    /* renamed from: com.caverock.androidsvg.SVGParser$f */
    /* loaded from: classes10.dex */
    public class C4742f extends DefaultHandler2 {
        private C4742f() {
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
            SVGParser.this.r(str, SVGParser.this.x0(new C4743g(str2)));
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startDocument() throws SAXException {
            SVGParser.this.W0();
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            SVGParser.this.X0(str, str2, str3, attributes);
        }

        /* synthetic */ C4742f(SVGParser sVGParser, C4737a c4737a) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.caverock.androidsvg.SVGParser$g */
    /* loaded from: classes10.dex */
    public static class C4743g {
        String a;
        int c;
        int b = 0;
        private C4747c d = new C4747c();

        /* JADX INFO: Access modifiers changed from: package-private */
        public C4743g(String str) {
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
    /* renamed from: com.caverock.androidsvg.SVGParser$h */
    /* loaded from: classes10.dex */
    public class C4744h implements Attributes {
        private XmlPullParser a;

        public C4744h(SVGParser sVGParser, XmlPullParser xmlPullParser) {
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

    private void A(SVG.C4697d c4697d, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (C4737a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()]) {
                case 12:
                    c4697d.o = o0(trim);
                    break;
                case 13:
                    c4697d.p = o0(trim);
                    break;
                case 14:
                    SVG.Length o0 = o0(trim);
                    c4697d.q = o0;
                    if (o0.isNegative()) {
                        throw new SVGParseException("Invalid <circle> element. r cannot be negative");
                    }
                    break;
            }
        }
    }

    private static Set<String> A0(String str) {
        C4743g c4743g = new C4743g(str);
        HashSet hashSet = new HashSet();
        while (!c4743g.h()) {
            hashSet.add(c4743g.r());
            c4743g.A();
        }
        return hashSet;
    }

    private void B(SVG.C4699e c4699e, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            if (C4737a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()] == 38) {
                if ("objectBoundingBox".equals(trim)) {
                    c4699e.o = Boolean.FALSE;
                } else if ("userSpaceOnUse".equals(trim)) {
                    c4699e.o = Boolean.TRUE;
                } else {
                    throw new SVGParseException("Invalid value for attribute clipPathUnits");
                }
            }
        }
    }

    private static SVG.Length[] B0(String str) {
        SVG.Length p;
        C4743g c4743g = new C4743g(str);
        c4743g.A();
        if (c4743g.h() || (p = c4743g.p()) == null || p.isNegative()) {
            return null;
        }
        float floatValue = p.floatValue();
        ArrayList arrayList = new ArrayList();
        arrayList.add(p);
        while (!c4743g.h()) {
            c4743g.z();
            SVG.Length p2 = c4743g.p();
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
            switch (C4737a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()]) {
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

    private void D(SVG.AbstractC4692a0 abstractC4692a0, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String qName = attributes.getQName(i);
            if (!qName.equals("id") && !qName.equals("xml:id")) {
                if (qName.equals("xml:space")) {
                    String trim = attributes.getValue(i).trim();
                    if ("default".equals(trim)) {
                        abstractC4692a0.d = Boolean.FALSE;
                        return;
                    } else if ("preserve".equals(trim)) {
                        abstractC4692a0.d = Boolean.TRUE;
                        return;
                    } else {
                        throw new SVGParseException("Invalid value for \"xml:space\" attribute: " + trim);
                    }
                }
            } else {
                abstractC4692a0.c = attributes.getValue(i).trim();
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

    private void E(SVG.C4703g c4703g, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (C4737a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()]) {
                case 10:
                    SVG.Length o0 = o0(trim);
                    c4703g.q = o0;
                    if (o0.isNegative()) {
                        throw new SVGParseException("Invalid <ellipse> element. rx cannot be negative");
                    }
                    break;
                case 11:
                    SVG.Length o02 = o0(trim);
                    c4703g.r = o02;
                    if (o02.isNegative()) {
                        throw new SVGParseException("Invalid <ellipse> element. ry cannot be negative");
                    }
                    break;
                case 12:
                    c4703g.o = o0(trim);
                    break;
                case 13:
                    c4703g.p = o0(trim);
                    break;
            }
        }
    }

    private static void E0(SVG.AbstractC4692a0 abstractC4692a0, String str) {
        C4743g c4743g = new C4743g(str.replaceAll("/\\*.*?\\*/", ""));
        while (true) {
            String s = c4743g.s(jn1.CONDITION_IF_MIDDLE);
            c4743g.A();
            if (!c4743g.f(jn1.CONDITION_IF_MIDDLE)) {
                return;
            }
            c4743g.A();
            String u = c4743g.u(b90.TokenSEM);
            if (u == null) {
                return;
            }
            c4743g.A();
            if (c4743g.h() || c4743g.f(b90.TokenSEM)) {
                if (abstractC4692a0.f == null) {
                    abstractC4692a0.f = new SVG.Style();
                }
                if (u.contains("!important")) {
                    abstractC4692a0.f.important = true;
                }
                S0(abstractC4692a0.f, s, u);
                c4743g.A();
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
    private void F(com.caverock.androidsvg.SVG.AbstractC4705h r5, org.xml.sax.Attributes r6) throws com.caverock.androidsvg.SVGParseException {
        /*
            r4 = this;
            r0 = 0
        L1:
            int r1 = r6.getLength()
            if (r0 >= r1) goto L90
            java.lang.String r1 = r6.getValue(r0)
            java.lang.String r1 = r1.trim()
            int[] r2 = com.caverock.androidsvg.SVGParser.C4737a.b
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
        C4743g c4743g = new C4743g(str);
        HashSet hashSet = new HashSet();
        while (!c4743g.h()) {
            String r = c4743g.r();
            int indexOf = r.indexOf(45);
            if (indexOf != -1) {
                r = r.substring(0, indexOf);
            }
            hashSet.add(new Locale(r, "", "").getLanguage());
            c4743g.A();
        }
        return hashSet;
    }

    private void G(SVG.C4711k c4711k, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i2 = C4737a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 1) {
                c4711k.p = o0(trim);
            } else if (i2 == 2) {
                c4711k.q = o0(trim);
            } else if (i2 == 3) {
                SVG.Length o0 = o0(trim);
                c4711k.r = o0;
                if (o0.isNegative()) {
                    throw new SVGParseException("Invalid <use> element. width cannot be negative");
                }
            } else if (i2 == 4) {
                SVG.Length o02 = o0(trim);
                c4711k.s = o02;
                if (o02.isNegative()) {
                    throw new SVGParseException("Invalid <use> element. height cannot be negative");
                }
            } else if (i2 != 6) {
                if (i2 == 7) {
                    w0(c4711k, trim);
                }
            } else if ("".equals(attributes.getURI(i)) || "http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                c4711k.o = trim;
            }
        }
    }

    private static SVG.Style.TextAnchor G0(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1074341483:
                if (str.equals("middle")) {
                    c = 0;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    c = 1;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
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

    private void H(SVG.C4713l c4713l, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (C4737a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()]) {
                case 15:
                    c4713l.o = o0(trim);
                    break;
                case 16:
                    c4713l.p = o0(trim);
                    break;
                case 17:
                    c4713l.q = o0(trim);
                    break;
                case 18:
                    c4713l.r = o0(trim);
                    break;
            }
        }
    }

    private static SVG.Style.TextDecoration H0(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1171789332:
                if (str.equals("line-through")) {
                    c = 0;
                    break;
                }
                break;
            case -1026963764:
                if (str.equals("underline")) {
                    c = 1;
                    break;
                }
                break;
            case 3387192:
                if (str.equals("none")) {
                    c = 2;
                    break;
                }
                break;
            case 93826908:
                if (str.equals("blink")) {
                    c = 3;
                    break;
                }
                break;
            case 529818312:
                if (str.equals("overline")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
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

    private void I(SVG.C4694b0 c4694b0, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (C4737a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()]) {
                case 15:
                    c4694b0.m = o0(trim);
                    break;
                case 16:
                    c4694b0.n = o0(trim);
                    break;
                case 17:
                    c4694b0.o = o0(trim);
                    break;
                case 18:
                    c4694b0.p = o0(trim);
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

    private void J(SVG.C4715m c4715m, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (C4737a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()]) {
                case 26:
                    c4715m.q = o0(trim);
                    break;
                case 27:
                    c4715m.r = o0(trim);
                    break;
                case 28:
                    SVG.Length o0 = o0(trim);
                    c4715m.s = o0;
                    if (o0.isNegative()) {
                        throw new SVGParseException("Invalid <marker> element. markerWidth cannot be negative");
                    }
                    break;
                case 29:
                    SVG.Length o02 = o0(trim);
                    c4715m.t = o02;
                    if (o02.isNegative()) {
                        throw new SVGParseException("Invalid <marker> element. markerHeight cannot be negative");
                    }
                    break;
                case 30:
                    if ("strokeWidth".equals(trim)) {
                        c4715m.p = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        c4715m.p = true;
                        break;
                    } else {
                        throw new SVGParseException("Invalid value for attribute markerUnits");
                    }
                case 31:
                    if ("auto".equals(trim)) {
                        c4715m.u = Float.valueOf(Float.NaN);
                        break;
                    } else {
                        c4715m.u = Float.valueOf(f0(trim));
                        break;
                    }
            }
        }
    }

    private Matrix J0(String str) throws SVGParseException {
        Matrix matrix = new Matrix();
        C4743g c4743g = new C4743g(str);
        c4743g.A();
        while (!c4743g.h()) {
            String o = c4743g.o();
            if (o != null) {
                char c = 65535;
                switch (o.hashCode()) {
                    case -1081239615:
                        if (o.equals("matrix")) {
                            c = 0;
                            break;
                        }
                        break;
                    case -925180581:
                        if (o.equals("rotate")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 109250890:
                        if (o.equals("scale")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 109493390:
                        if (o.equals("skewX")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 109493391:
                        if (o.equals("skewY")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 1052832078:
                        if (o.equals("translate")) {
                            c = 5;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        c4743g.A();
                        float n = c4743g.n();
                        c4743g.z();
                        float n2 = c4743g.n();
                        c4743g.z();
                        float n3 = c4743g.n();
                        c4743g.z();
                        float n4 = c4743g.n();
                        c4743g.z();
                        float n5 = c4743g.n();
                        c4743g.z();
                        float n6 = c4743g.n();
                        c4743g.A();
                        if (!Float.isNaN(n6) && c4743g.f(')')) {
                            Matrix matrix2 = new Matrix();
                            matrix2.setValues(new float[]{n, n3, n5, n2, n4, n6, 0.0f, 0.0f, 1.0f});
                            matrix.preConcat(matrix2);
                            break;
                        } else {
                            throw new SVGParseException("Invalid transform list: " + str);
                        }
                        break;
                    case 1:
                        c4743g.A();
                        float n7 = c4743g.n();
                        float x = c4743g.x();
                        float x2 = c4743g.x();
                        c4743g.A();
                        if (!Float.isNaN(n7) && c4743g.f(')')) {
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
                        c4743g.A();
                        float n8 = c4743g.n();
                        float x3 = c4743g.x();
                        c4743g.A();
                        if (!Float.isNaN(n8) && c4743g.f(')')) {
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
                        c4743g.A();
                        float n9 = c4743g.n();
                        c4743g.A();
                        if (!Float.isNaN(n9) && c4743g.f(')')) {
                            matrix.preSkew((float) Math.tan(Math.toRadians(n9)), 0.0f);
                            break;
                        } else {
                            throw new SVGParseException("Invalid transform list: " + str);
                        }
                        break;
                    case 4:
                        c4743g.A();
                        float n10 = c4743g.n();
                        c4743g.A();
                        if (!Float.isNaN(n10) && c4743g.f(')')) {
                            matrix.preSkew(0.0f, (float) Math.tan(Math.toRadians(n10)));
                            break;
                        } else {
                            throw new SVGParseException("Invalid transform list: " + str);
                        }
                    case 5:
                        c4743g.A();
                        float n11 = c4743g.n();
                        float x4 = c4743g.x();
                        c4743g.A();
                        if (!Float.isNaN(n11) && c4743g.f(')')) {
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
                if (c4743g.h()) {
                    return matrix;
                }
                c4743g.z();
            } else {
                throw new SVGParseException("Bad transform function encountered in transform list: " + str);
            }
        }
        return matrix;
    }

    private void K(SVG.C4717n c4717n, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i2 = C4737a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 1) {
                c4717n.p = o0(trim);
            } else if (i2 == 2) {
                c4717n.q = o0(trim);
            } else if (i2 == 3) {
                SVG.Length o0 = o0(trim);
                c4717n.r = o0;
                if (o0.isNegative()) {
                    throw new SVGParseException("Invalid <mask> element. width cannot be negative");
                }
            } else if (i2 == 4) {
                SVG.Length o02 = o0(trim);
                c4717n.s = o02;
                if (o02.isNegative()) {
                    throw new SVGParseException("Invalid <mask> element. height cannot be negative");
                }
            } else if (i2 != 43) {
                if (i2 != 44) {
                    continue;
                } else if ("objectBoundingBox".equals(trim)) {
                    c4717n.o = Boolean.FALSE;
                } else if ("userSpaceOnUse".equals(trim)) {
                    c4717n.o = Boolean.TRUE;
                } else {
                    throw new SVGParseException("Invalid value for attribute maskContentUnits");
                }
            } else if ("objectBoundingBox".equals(trim)) {
                c4717n.n = Boolean.FALSE;
            } else if ("userSpaceOnUse".equals(trim)) {
                c4717n.n = Boolean.TRUE;
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
            C4742f c4742f = new C4742f(this, null);
            xMLReader.setContentHandler(c4742f);
            xMLReader.setProperty("http://xml.org/sax/properties/lexical-handler", c4742f);
            xMLReader.parse(new InputSource(inputStream));
        } catch (IOException e) {
            throw new SVGParseException("Stream error", e);
        } catch (ParserConfigurationException e2) {
            throw new SVGParseException("XML parser problem", e2);
        } catch (SAXException e3) {
            throw new SVGParseException("SVG parse error", e3);
        }
    }

    private void L(SVG.C4719o c4719o, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i2 = C4737a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 8) {
                c4719o.o = u0(trim);
            } else if (i2 != 9) {
                continue;
            } else {
                Float valueOf = Float.valueOf(f0(trim));
                c4719o.p = valueOf;
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
                C4744h c4744h = new C4744h(this, newPullParser);
                newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-docdecl", false);
                newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                newPullParser.setInput(inputStream, null);
                for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.nextToken()) {
                    if (eventType == 0) {
                        W0();
                    } else if (eventType == 8) {
                        Log.d("SVGParser", "PROC INSTR: " + newPullParser.getText());
                        C4743g c4743g = new C4743g(newPullParser.getText());
                        r(c4743g.r(), x0(c4743g));
                    } else if (eventType != 10) {
                        if (eventType == 2) {
                            String name = newPullParser.getName();
                            if (newPullParser.getPrefix() != null) {
                                name = newPullParser.getPrefix() + jn1.CONDITION_IF_MIDDLE + name;
                            }
                            X0(newPullParser.getNamespace(), newPullParser.getName(), name, c4744h);
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
            } catch (XmlPullParserException e) {
                throw new SVGParseException("XML parser problem", e);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } catch (IOException e2) {
            throw new SVGParseException("Stream error", e2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x00cf, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void M(com.caverock.androidsvg.SVG.C4723q r6, org.xml.sax.Attributes r7) throws com.caverock.androidsvg.SVGParseException {
        /*
            r5 = this;
            r0 = 0
        L1:
            int r1 = r7.getLength()
            if (r0 >= r1) goto Ld3
            java.lang.String r1 = r7.getValue(r0)
            java.lang.String r1 = r1.trim()
            int[] r2 = com.caverock.androidsvg.SVGParser.C4737a.b
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

    private void N(SVG.C4725r c4725r, Attributes attributes, String str) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            if (SVGAttr.fromString(attributes.getLocalName(i)) == SVGAttr.points) {
                C4743g c4743g = new C4743g(attributes.getValue(i));
                ArrayList<Float> arrayList = new ArrayList();
                c4743g.A();
                while (!c4743g.h()) {
                    float n = c4743g.n();
                    if (!Float.isNaN(n)) {
                        c4743g.z();
                        float n2 = c4743g.n();
                        if (!Float.isNaN(n2)) {
                            c4743g.z();
                            arrayList.add(Float.valueOf(n));
                            arrayList.add(Float.valueOf(n2));
                        } else {
                            throw new SVGParseException("Invalid <" + str + "> points attribute. There should be an even number of coordinates.");
                        }
                    } else {
                        throw new SVGParseException("Invalid <" + str + "> points attribute. Non-coordinate content found in list.");
                    }
                }
                c4725r.o = new float[arrayList.size()];
                int i2 = 0;
                for (Float f : arrayList) {
                    c4725r.o[i2] = f.floatValue();
                    i2++;
                }
            }
        }
    }

    private static SVG.C4693b N0(String str) throws SVGParseException {
        C4743g c4743g = new C4743g(str);
        c4743g.A();
        float n = c4743g.n();
        c4743g.z();
        float n2 = c4743g.n();
        c4743g.z();
        float n3 = c4743g.n();
        c4743g.z();
        float n4 = c4743g.n();
        if (Float.isNaN(n) || Float.isNaN(n2) || Float.isNaN(n3) || Float.isNaN(n4)) {
            throw new SVGParseException("Invalid viewBox definition - should have four numbers");
        }
        if (n3 >= 0.0f) {
            if (n4 >= 0.0f) {
                return new SVG.C4693b(n, n2, n3, n4);
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
    private void O(com.caverock.androidsvg.SVG.C4700e0 r5, org.xml.sax.Attributes r6) throws com.caverock.androidsvg.SVGParseException {
        /*
            r4 = this;
            r0 = 0
        L1:
            int r1 = r6.getLength()
            if (r0 >= r1) goto L5e
            java.lang.String r1 = r6.getValue(r0)
            java.lang.String r1 = r1.trim()
            int[] r2 = com.caverock.androidsvg.SVGParser.C4737a.b
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
            SVG.C4719o c4719o = new SVG.C4719o();
            c4719o.a = this.a;
            c4719o.b = this.b;
            D(c4719o, attributes);
            S(c4719o, attributes);
            W(c4719o, attributes);
            C(c4719o, attributes);
            L(c4719o, attributes);
            this.b.addChild(c4719o);
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void P(SVG.C4727t c4727t, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i2 = C4737a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 1) {
                c4727t.o = o0(trim);
            } else if (i2 == 2) {
                c4727t.p = o0(trim);
            } else if (i2 == 3) {
                SVG.Length o0 = o0(trim);
                c4727t.q = o0;
                if (o0.isNegative()) {
                    throw new SVGParseException("Invalid <rect> element. width cannot be negative");
                }
            } else if (i2 == 4) {
                SVG.Length o02 = o0(trim);
                c4727t.r = o02;
                if (o02.isNegative()) {
                    throw new SVGParseException("Invalid <rect> element. height cannot be negative");
                }
            } else if (i2 == 10) {
                SVG.Length o03 = o0(trim);
                c4727t.s = o03;
                if (o03.isNegative()) {
                    throw new SVGParseException("Invalid <rect> element. rx cannot be negative");
                }
            } else if (i2 != 11) {
                continue;
            } else {
                SVG.Length o04 = o0(trim);
                c4727t.t = o04;
                if (o04.isNegative()) {
                    throw new SVGParseException("Invalid <rect> element. ry cannot be negative");
                }
            }
        }
    }

    private void P0(Attributes attributes) throws SVGParseException {
        l("<pattern>", new Object[0]);
        if (this.b != null) {
            SVG.C4723q c4723q = new SVG.C4723q();
            c4723q.a = this.a;
            c4723q.b = this.b;
            D(c4723q, attributes);
            S(c4723q, attributes);
            C(c4723q, attributes);
            Y(c4723q, attributes);
            M(c4723q, attributes);
            this.b.addChild(c4723q);
            this.b = c4723q;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void Q(SVG.C4730w c4730w, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i2 = C4737a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 1) {
                c4730w.p = o0(trim);
            } else if (i2 == 2) {
                c4730w.q = o0(trim);
            } else if (i2 == 3) {
                SVG.Length o0 = o0(trim);
                c4730w.r = o0;
                if (o0.isNegative()) {
                    throw new SVGParseException("Invalid <svg> element. width cannot be negative");
                }
            } else if (i2 == 4) {
                SVG.Length o02 = o0(trim);
                c4730w.s = o02;
                if (o02.isNegative()) {
                    throw new SVGParseException("Invalid <svg> element. height cannot be negative");
                }
            } else if (i2 == 5) {
                c4730w.t = trim;
            }
        }
    }

    private void Q0(Attributes attributes) throws SVGParseException {
        l("<polygon>", new Object[0]);
        if (this.b != null) {
            SVG.C4725r c4726s = new SVG.C4726s();
            c4726s.a = this.a;
            c4726s.b = this.b;
            D(c4726s, attributes);
            S(c4726s, attributes);
            W(c4726s, attributes);
            C(c4726s, attributes);
            N(c4726s, attributes, "polygon");
            this.b.addChild(c4726s);
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void R(SVG.C4729v c4729v, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            if (C4737a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()] == 37) {
                c4729v.h = n0(trim);
            }
        }
    }

    private void R0(Attributes attributes) throws SVGParseException {
        l("<polyline>", new Object[0]);
        if (this.b != null) {
            SVG.C4725r c4725r = new SVG.C4725r();
            c4725r.a = this.a;
            c4725r.b = this.b;
            D(c4725r, attributes);
            S(c4725r, attributes);
            W(c4725r, attributes);
            C(c4725r, attributes);
            N(c4725r, attributes, "polyline");
            this.b.addChild(c4725r);
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void S(SVG.AbstractC4692a0 abstractC4692a0, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            if (trim.length() != 0) {
                int i2 = C4737a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
                if (i2 == 45) {
                    E0(abstractC4692a0, trim);
                } else if (i2 != 46) {
                    if (abstractC4692a0.e == null) {
                        abstractC4692a0.e = new SVG.Style();
                    }
                    S0(abstractC4692a0.e, attributes.getLocalName(i), attributes.getValue(i).trim());
                } else {
                    abstractC4692a0.g = CSSParser.f(trim);
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
            switch (C4737a.b[SVGAttr.fromString(str).ordinal()]) {
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
                        } catch (SVGParseException e) {
                            Log.w("SVGParser", e.getMessage());
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
                    SVG.C4695c a0 = a0(str2);
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
                        } catch (SVGParseException e2) {
                            Log.w("SVGParser", e2.getMessage());
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
                        } catch (SVGParseException e3) {
                            Log.w("SVGParser", e3.getMessage());
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

    private void T(SVG.C4708i0 c4708i0, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            if (C4737a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()] == 6 && ("".equals(attributes.getURI(i)) || "http://www.w3.org/1999/xlink".equals(attributes.getURI(i)))) {
                c4708i0.n = trim;
            }
        }
    }

    private void T0(Attributes attributes) throws SVGParseException {
        l("<radialGradient>", new Object[0]);
        if (this.b != null) {
            SVG.C4700e0 c4700e0 = new SVG.C4700e0();
            c4700e0.a = this.a;
            c4700e0.b = this.b;
            D(c4700e0, attributes);
            S(c4700e0, attributes);
            F(c4700e0, attributes);
            O(c4700e0, attributes);
            this.b.addChild(c4700e0);
            this.b = c4700e0;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void U(SVG.C4716m0 c4716m0, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i2 = C4737a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 != 6) {
                if (i2 == 39) {
                    c4716m0.o = o0(trim);
                }
            } else if ("".equals(attributes.getURI(i)) || "http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                c4716m0.n = trim;
            }
        }
    }

    private void U0(Attributes attributes) throws SVGParseException {
        l("<rect>", new Object[0]);
        if (this.b != null) {
            SVG.C4727t c4727t = new SVG.C4727t();
            c4727t.a = this.a;
            c4727t.b = this.b;
            D(c4727t, attributes);
            S(c4727t, attributes);
            W(c4727t, attributes);
            C(c4727t, attributes);
            P(c4727t, attributes);
            this.b.addChild(c4727t);
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void V(SVG.AbstractC4718n0 abstractC4718n0, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i2 = C4737a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 1) {
                abstractC4718n0.n = p0(trim);
            } else if (i2 == 2) {
                abstractC4718n0.o = p0(trim);
            } else if (i2 == 19) {
                abstractC4718n0.p = p0(trim);
            } else if (i2 == 20) {
                abstractC4718n0.q = p0(trim);
            }
        }
    }

    private void V0(Attributes attributes) throws SVGParseException {
        l("<solidColor>", new Object[0]);
        if (this.b != null) {
            SVG.C4728u c4728u = new SVG.C4728u();
            c4728u.a = this.a;
            c4728u.b = this.b;
            D(c4728u, attributes);
            S(c4728u, attributes);
            this.b.addChild(c4728u);
            this.b = c4728u;
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

    private void X(SVG.C4722p0 c4722p0, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i2 = C4737a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 1) {
                c4722p0.p = o0(trim);
            } else if (i2 == 2) {
                c4722p0.q = o0(trim);
            } else if (i2 == 3) {
                SVG.Length o0 = o0(trim);
                c4722p0.r = o0;
                if (o0.isNegative()) {
                    throw new SVGParseException("Invalid <use> element. width cannot be negative");
                }
            } else if (i2 != 4) {
                if (i2 == 6 && ("".equals(attributes.getURI(i)) || "http://www.w3.org/1999/xlink".equals(attributes.getURI(i)))) {
                    c4722p0.o = trim;
                }
            } else {
                SVG.Length o02 = o0(trim);
                c4722p0.s = o02;
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
            switch (C4737a.a[fromString.ordinal()]) {
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

    private void Y(SVG.AbstractC4702f0 abstractC4702f0, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i2 = C4737a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 7) {
                w0(abstractC4702f0, trim);
            } else if (i2 == 87) {
                abstractC4702f0.o = N0(trim);
            }
        }
    }

    private void Y0(Attributes attributes) throws SVGParseException {
        l("<stop>", new Object[0]);
        SVG.SvgContainer svgContainer = this.b;
        if (svgContainer != null) {
            if (svgContainer instanceof SVG.AbstractC4705h) {
                SVG.C4729v c4729v = new SVG.C4729v();
                c4729v.a = this.a;
                c4729v.b = this.b;
                D(c4729v, attributes);
                S(c4729v, attributes);
                R(c4729v, attributes);
                this.b.addChild(c4729v);
                this.b = c4729v;
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
                int i2 = C4737a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
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

    private static SVG.C4695c a0(String str) {
        if (!"auto".equals(str) && str.startsWith("rect(")) {
            C4743g c4743g = new C4743g(str.substring(5));
            c4743g.A();
            SVG.Length q0 = q0(c4743g);
            c4743g.z();
            SVG.Length q02 = q0(c4743g);
            c4743g.z();
            SVG.Length q03 = q0(c4743g);
            c4743g.z();
            SVG.Length q04 = q0(c4743g);
            c4743g.A();
            if (c4743g.f(')') || c4743g.h()) {
                return new SVG.C4695c(q0, q02, q03, q04);
            }
            return null;
        }
        return null;
    }

    private void a1(Attributes attributes) throws SVGParseException {
        l("<svg>", new Object[0]);
        SVG.C4730w c4730w = new SVG.C4730w();
        c4730w.a = this.a;
        c4730w.b = this.b;
        D(c4730w, attributes);
        S(c4730w, attributes);
        C(c4730w, attributes);
        Y(c4730w, attributes);
        Q(c4730w, attributes);
        SVG.SvgContainer svgContainer = this.b;
        if (svgContainer == null) {
            this.a.r(c4730w);
        } else {
            svgContainer.addChild(c4730w);
        }
        this.b = c4730w;
    }

    private static SVG.Colour b0(String str) throws SVGParseException {
        if (str.charAt(0) == '#') {
            C4746b b = C4746b.b(str, 1, str.length());
            if (b != null) {
                int a = b.a();
                if (a == 4) {
                    int d = b.d();
                    int i = d & 3840;
                    int i2 = d & GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN;
                    int i3 = d & 15;
                    return new SVG.Colour(i3 | (i << 8) | (-16777216) | (i << 12) | (i2 << 8) | (i2 << 4) | (i3 << 4));
                } else if (a == 5) {
                    int d2 = b.d();
                    int i4 = 61440 & d2;
                    int i5 = d2 & 3840;
                    int i6 = d2 & GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN;
                    int i7 = d2 & 15;
                    return new SVG.Colour((i7 << 24) | (i7 << 28) | (i4 << 8) | (i4 << 4) | (i5 << 4) | i5 | i6 | (i6 >> 4));
                } else if (a != 7) {
                    if (a == 9) {
                        return new SVG.Colour((b.d() >>> 8) | (b.d() << 24));
                    }
                    throw new SVGParseException("Bad hex colour value: " + str);
                } else {
                    return new SVG.Colour(b.d() | (-16777216));
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
            C4743g c4743g = new C4743g(str.substring(startsWith2 ? 5 : 4));
            c4743g.A();
            float n = c4743g.n();
            float d3 = c4743g.d(n);
            if (!Float.isNaN(d3)) {
                c4743g.f(WXUtils.PERCENT);
            }
            float d4 = c4743g.d(d3);
            if (!Float.isNaN(d4)) {
                c4743g.f(WXUtils.PERCENT);
            }
            if (startsWith2) {
                float d5 = c4743g.d(d4);
                c4743g.A();
                if (!Float.isNaN(d5) && c4743g.f(')')) {
                    return new SVG.Colour((j(d5 * 256.0f) << 24) | s(n, d3, d4));
                }
                throw new SVGParseException("Bad hsla() colour value: " + str);
            }
            c4743g.A();
            if (!Float.isNaN(d4) && c4743g.f(')')) {
                return new SVG.Colour(s(n, d3, d4) | (-16777216));
            }
            throw new SVGParseException("Bad hsl() colour value: " + str);
        }
        C4743g c4743g2 = new C4743g(str.substring(startsWith ? 5 : 4));
        c4743g2.A();
        float n2 = c4743g2.n();
        if (!Float.isNaN(n2) && c4743g2.f(WXUtils.PERCENT)) {
            n2 = (n2 * 256.0f) / 100.0f;
        }
        float d6 = c4743g2.d(n2);
        if (!Float.isNaN(d6) && c4743g2.f(WXUtils.PERCENT)) {
            d6 = (d6 * 256.0f) / 100.0f;
        }
        float d7 = c4743g2.d(d6);
        if (!Float.isNaN(d7) && c4743g2.f(WXUtils.PERCENT)) {
            d7 = (d7 * 256.0f) / 100.0f;
        }
        if (startsWith) {
            float d8 = c4743g2.d(d7);
            c4743g2.A();
            if (!Float.isNaN(d8) && c4743g2.f(')')) {
                return new SVG.Colour((j(d8 * 256.0f) << 24) | (j(n2) << 16) | (j(d6) << 8) | j(d7));
            }
            throw new SVGParseException("Bad rgba() colour value: " + str);
        }
        c4743g2.A();
        if (!Float.isNaN(d7) && c4743g2.f(')')) {
            return new SVG.Colour((j(n2) << 16) | (-16777216) | (j(d6) << 8) | j(d7));
        }
        throw new SVGParseException("Bad rgb() colour value: " + str);
    }

    private void b1(Attributes attributes) throws SVGParseException {
        l("<symbol>", new Object[0]);
        if (this.b != null) {
            SVG.AbstractC4702f0 c4706h0 = new SVG.C4706h0();
            c4706h0.a = this.a;
            c4706h0.b = this.b;
            D(c4706h0, attributes);
            S(c4706h0, attributes);
            C(c4706h0, attributes);
            Y(c4706h0, attributes);
            this.b.addChild(c4706h0);
            this.b = c4706h0;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private static SVG.Colour c0(String str) throws SVGParseException {
        Integer a = C4739c.a(str);
        if (a != null) {
            return new SVG.Colour(a.intValue());
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
        } else if (this.b instanceof SVG.AbstractC4714l0) {
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
            SVG.C4712k0 c4712k0 = new SVG.C4712k0();
            c4712k0.a = this.a;
            c4712k0.b = this.b;
            D(c4712k0, attributes);
            S(c4712k0, attributes);
            W(c4712k0, attributes);
            C(c4712k0, attributes);
            V(c4712k0, attributes);
            this.b.addChild(c4712k0);
            this.b = c4712k0;
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
        } else if (this.b instanceof SVG.AbstractC4714l0) {
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
            SVG.C4716m0 c4716m0 = new SVG.C4716m0();
            c4716m0.a = this.a;
            c4716m0.b = this.b;
            D(c4716m0, attributes);
            S(c4716m0, attributes);
            C(c4716m0, attributes);
            U(c4716m0, attributes);
            this.b.addChild(c4716m0);
            this.b = c4716m0;
            SVG.SvgContainer svgContainer = c4716m0.b;
            if (svgContainer instanceof SVG.TextRoot) {
                c4716m0.setTextRoot((SVG.TextRoot) svgContainer);
                return;
            } else {
                c4716m0.setTextRoot(((SVG.TextChild) svgContainer).getTextRoot());
                return;
            }
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private static float g0(String str, int i, int i2) throws SVGParseException {
        float b = new C4747c().b(str, i, i2);
        if (Float.isNaN(b)) {
            throw new SVGParseException("Invalid float value: " + str);
        }
        return b;
    }

    private void g1(Attributes attributes) throws SVGParseException {
        l("<tref>", new Object[0]);
        SVG.SvgContainer svgContainer = this.b;
        if (svgContainer != null) {
            if (svgContainer instanceof SVG.AbstractC4714l0) {
                SVG.C4708i0 c4708i0 = new SVG.C4708i0();
                c4708i0.a = this.a;
                c4708i0.b = this.b;
                D(c4708i0, attributes);
                S(c4708i0, attributes);
                C(c4708i0, attributes);
                T(c4708i0, attributes);
                this.b.addChild(c4708i0);
                SVG.SvgContainer svgContainer2 = c4708i0.b;
                if (svgContainer2 instanceof SVG.TextRoot) {
                    c4708i0.setTextRoot((SVG.TextRoot) svgContainer2);
                    return;
                } else {
                    c4708i0.setTextRoot(((SVG.TextChild) svgContainer2).getTextRoot());
                    return;
                }
            }
            throw new SVGParseException("Invalid document. <tref> elements are only valid inside <text> or <tspan> elements.");
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void h(String str) throws SVGParseException {
        SVG.AbstractC4731x abstractC4731x = (SVG.AbstractC4731x) this.b;
        int size = abstractC4731x.i.size();
        SVG.C4696c0 c4696c0 = size == 0 ? null : abstractC4731x.i.get(size - 1);
        if (c4696c0 instanceof SVG.C4720o0) {
            StringBuilder sb = new StringBuilder();
            SVG.C4720o0 c4720o0 = (SVG.C4720o0) c4696c0;
            sb.append(c4720o0.c);
            sb.append(str);
            c4720o0.c = sb.toString();
            return;
        }
        this.b.addChild(new SVG.C4720o0(str));
    }

    private static void h0(SVG.Style style, String str) {
        String s;
        if ("|caption|icon|menu|message-box|small-caption|status-bar|".contains('|' + str + '|')) {
            C4743g c4743g = new C4743g(str);
            Integer num = null;
            SVG.Style.FontStyle fontStyle = null;
            String str2 = null;
            while (true) {
                s = c4743g.s(r10.DIR);
                c4743g.A();
                if (s != null) {
                    if (num != null && fontStyle != null) {
                        break;
                    } else if (!s.equals("normal") && (num != null || (num = C4741e.a(s)) == null)) {
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
            if (c4743g.f(r10.DIR)) {
                c4743g.A();
                String r = c4743g.r();
                if (r != null) {
                    try {
                        o0(r);
                    } catch (SVGParseException unused) {
                        return;
                    }
                }
                c4743g.A();
            }
            style.fontFamily = i0(c4743g.y());
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
            if (svgContainer instanceof SVG.AbstractC4714l0) {
                SVG.C4710j0 c4710j0 = new SVG.C4710j0();
                c4710j0.a = this.a;
                c4710j0.b = this.b;
                D(c4710j0, attributes);
                S(c4710j0, attributes);
                C(c4710j0, attributes);
                V(c4710j0, attributes);
                this.b.addChild(c4710j0);
                this.b = c4710j0;
                SVG.SvgContainer svgContainer2 = c4710j0.b;
                if (svgContainer2 instanceof SVG.TextRoot) {
                    c4710j0.setTextRoot((SVG.TextRoot) svgContainer2);
                    return;
                } else {
                    c4710j0.setTextRoot(((SVG.TextChild) svgContainer2).getTextRoot());
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
            SVG.C4697d c4697d = new SVG.C4697d();
            c4697d.a = this.a;
            c4697d.b = this.b;
            D(c4697d, attributes);
            S(c4697d, attributes);
            W(c4697d, attributes);
            C(c4697d, attributes);
            A(c4697d, attributes);
            this.b.addChild(c4697d);
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private static List<String> i0(String str) {
        C4743g c4743g = new C4743g(str);
        ArrayList arrayList = null;
        do {
            String q = c4743g.q();
            if (q == null) {
                q = c4743g.u(',');
            }
            if (q == null) {
                break;
            }
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(q);
            c4743g.z();
        } while (!c4743g.h());
        return arrayList;
    }

    private void i1(Attributes attributes) throws SVGParseException {
        l("<use>", new Object[0]);
        if (this.b != null) {
            SVG.C4722p0 c4722p0 = new SVG.C4722p0();
            c4722p0.a = this.a;
            c4722p0.b = this.b;
            D(c4722p0, attributes);
            S(c4722p0, attributes);
            W(c4722p0, attributes);
            C(c4722p0, attributes);
            X(c4722p0, attributes);
            this.b.addChild(c4722p0);
            this.b = c4722p0;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private static int j(float f) {
        if (f < 0.0f) {
            return 0;
        }
        if (f > 255.0f) {
            return 255;
        }
        return Math.round(f);
    }

    private static SVG.Length j0(String str) {
        try {
            SVG.Length a = C4740d.a(str);
            return a == null ? o0(str) : a;
        } catch (SVGParseException unused) {
            return null;
        }
    }

    private void j1(Attributes attributes) throws SVGParseException {
        l("<view>", new Object[0]);
        if (this.b != null) {
            SVG.AbstractC4702f0 c4724q0 = new SVG.C4724q0();
            c4724q0.a = this.a;
            c4724q0.b = this.b;
            D(c4724q0, attributes);
            C(c4724q0, attributes);
            Y(c4724q0, attributes);
            this.b.addChild(c4724q0);
            this.b = c4724q0;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void k(Attributes attributes) throws SVGParseException {
        l("<clipPath>", new Object[0]);
        if (this.b != null) {
            SVG.C4699e c4699e = new SVG.C4699e();
            c4699e.a = this.a;
            c4699e.b = this.b;
            D(c4699e, attributes);
            S(c4699e, attributes);
            W(c4699e, attributes);
            C(c4699e, attributes);
            B(c4699e, attributes);
            this.b.addChild(c4699e);
            this.b = c4699e;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private static SVG.Style.FontStyle k0(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1657669071:
                if (str.equals("oblique")) {
                    c = 0;
                    break;
                }
                break;
            case -1178781136:
                if (str.equals(Constants.Value.ITALIC)) {
                    c = 1;
                    break;
                }
                break;
            case -1039745817:
                if (str.equals("normal")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
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
            SVG.C4704g0 c4704g0 = new SVG.C4704g0();
            c4704g0.a = this.a;
            c4704g0.b = this.b;
            D(c4704g0, attributes);
            S(c4704g0, attributes);
            W(c4704g0, attributes);
            C(c4704g0, attributes);
            this.b.addChild(c4704g0);
            this.b = c4704g0;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void l(String str, Object... objArr) {
    }

    private static Integer l0(String str) {
        return C4741e.a(str);
    }

    private void m(Attributes attributes) throws SVGParseException {
        l("<defs>", new Object[0]);
        if (this.b != null) {
            SVG.C4701f c4701f = new SVG.C4701f();
            c4701f.a = this.a;
            c4701f.b = this.b;
            D(c4701f, attributes);
            S(c4701f, attributes);
            W(c4701f, attributes);
            this.b.addChild(c4701f);
            this.b = c4701f;
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
            SVG.C4703g c4703g = new SVG.C4703g();
            c4703g.a = this.a;
            c4703g.b = this.b;
            D(c4703g, attributes);
            S(c4703g, attributes);
            W(c4703g, attributes);
            C(c4703g, attributes);
            E(c4703g, attributes);
            this.b.addChild(c4703g);
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
                float f = 100.0f;
                if (z) {
                    g0 /= 100.0f;
                }
                if (g0 < 0.0f) {
                    f = 0.0f;
                } else if (g0 <= 100.0f) {
                    f = g0;
                }
                return Float.valueOf(f);
            } catch (NumberFormatException e) {
                throw new SVGParseException("Invalid offset value in <stop>: " + str, e);
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
            } catch (NumberFormatException e) {
                throw new SVGParseException("Invalid length value: " + str, e);
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
            int i2 = C4737a.a[SVGElem.fromString(str2).ordinal()];
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
            this.b = ((SVG.C4696c0) this.b).b;
        }
    }

    private static List<SVG.Length> p0(String str) throws SVGParseException {
        if (str.length() != 0) {
            ArrayList arrayList = new ArrayList(1);
            C4743g c4743g = new C4743g(str);
            c4743g.A();
            while (!c4743g.h()) {
                float n = c4743g.n();
                if (!Float.isNaN(n)) {
                    SVG.Unit v = c4743g.v();
                    if (v == null) {
                        v = SVG.Unit.px;
                    }
                    arrayList.add(new SVG.Length(n, v));
                    c4743g.z();
                } else {
                    throw new SVGParseException("Invalid length list value: " + c4743g.b());
                }
            }
            return arrayList;
        }
        throw new SVGParseException("Invalid length list (empty string)");
    }

    private void q(Attributes attributes) throws SVGParseException {
        l("<g>", new Object[0]);
        if (this.b != null) {
            SVG.C4709j c4709j = new SVG.C4709j();
            c4709j.a = this.a;
            c4709j.b = this.b;
            D(c4709j, attributes);
            S(c4709j, attributes);
            W(c4709j, attributes);
            C(c4709j, attributes);
            this.b.addChild(c4709j);
            this.b = c4709j;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private static SVG.Length q0(C4743g c4743g) {
        if (c4743g.g("auto")) {
            return new SVG.Length(0.0f);
        }
        return c4743g.p();
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

    private static int s(float f, float f2, float f3) {
        int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
        float f4 = f % 360.0f;
        if (i < 0) {
            f4 += 360.0f;
        }
        float f5 = f4 / 60.0f;
        float f6 = f2 / 100.0f;
        float f7 = f3 / 100.0f;
        if (f6 < 0.0f) {
            f6 = 0.0f;
        } else if (f6 > 1.0f) {
            f6 = 1.0f;
        }
        float f8 = f7 >= 0.0f ? f7 > 1.0f ? 1.0f : f7 : 0.0f;
        float f9 = f8 <= 0.5f ? (f6 + 1.0f) * f8 : (f8 + f6) - (f6 * f8);
        float f10 = (f8 * 2.0f) - f9;
        return j(t(f10, f9, f5 - 2.0f) * 256.0f) | (j(t(f10, f9, f5 + 2.0f) * 256.0f) << 16) | (j(t(f10, f9, f5) * 256.0f) << 8);
    }

    private static Boolean s0(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1217487446:
                if (str.equals("hidden")) {
                    c = 0;
                    break;
                }
                break;
            case -907680051:
                if (str.equals("scroll")) {
                    c = 1;
                    break;
                }
                break;
            case 3005871:
                if (str.equals("auto")) {
                    c = 2;
                    break;
                }
                break;
            case 466743410:
                if (str.equals("visible")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
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

    private static float t(float f, float f2, float f3) {
        float f4;
        if (f3 < 0.0f) {
            f3 += 6.0f;
        }
        if (f3 >= 6.0f) {
            f3 -= 6.0f;
        }
        if (f3 < 1.0f) {
            f4 = (f2 - f) * f3;
        } else if (f3 < 3.0f) {
            return f2;
        } else {
            if (f3 >= 4.0f) {
                return f;
            }
            f4 = (f2 - f) * (4.0f - f3);
        }
        return f4 + f;
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
            SVG.C4711k c4711k = new SVG.C4711k();
            c4711k.a = this.a;
            c4711k.b = this.b;
            D(c4711k, attributes);
            S(c4711k, attributes);
            W(c4711k, attributes);
            C(c4711k, attributes);
            G(c4711k, attributes);
            this.b.addChild(c4711k);
            this.b = c4711k;
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
    private static com.caverock.androidsvg.SVG.C4721p u0(java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 762
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVGParser.u0(java.lang.String):com.caverock.androidsvg.SVG$p");
    }

    private void v(Attributes attributes) throws SVGParseException {
        l("<line>", new Object[0]);
        if (this.b != null) {
            SVG.C4713l c4713l = new SVG.C4713l();
            c4713l.a = this.a;
            c4713l.b = this.b;
            D(c4713l, attributes);
            S(c4713l, attributes);
            W(c4713l, attributes);
            C(c4713l, attributes);
            H(c4713l, attributes);
            this.b.addChild(c4713l);
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    static PreserveAspectRatio v0(String str) throws SVGParseException {
        C4743g c4743g = new C4743g(str);
        c4743g.A();
        String r = c4743g.r();
        if ("defer".equals(r)) {
            c4743g.A();
            r = c4743g.r();
        }
        PreserveAspectRatio.Alignment a = C4738b.a(r);
        PreserveAspectRatio.Scale scale = null;
        c4743g.A();
        if (!c4743g.h()) {
            String r2 = c4743g.r();
            r2.hashCode();
            if (r2.equals("meet")) {
                scale = PreserveAspectRatio.Scale.meet;
            } else if (r2.equals("slice")) {
                scale = PreserveAspectRatio.Scale.slice;
            } else {
                throw new SVGParseException("Invalid preserveAspectRatio definition: " + str);
            }
        }
        return new PreserveAspectRatio(a, scale);
    }

    private void w(Attributes attributes) throws SVGParseException {
        l("<linearGradient>", new Object[0]);
        if (this.b != null) {
            SVG.C4694b0 c4694b0 = new SVG.C4694b0();
            c4694b0.a = this.a;
            c4694b0.b = this.b;
            D(c4694b0, attributes);
            S(c4694b0, attributes);
            F(c4694b0, attributes);
            I(c4694b0, attributes);
            this.b.addChild(c4694b0);
            this.b = c4694b0;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private static void w0(SVG.AbstractC4698d0 abstractC4698d0, String str) throws SVGParseException {
        abstractC4698d0.n = v0(str);
    }

    private void x(Attributes attributes) throws SVGParseException {
        l("<marker>", new Object[0]);
        if (this.b != null) {
            SVG.C4715m c4715m = new SVG.C4715m();
            c4715m.a = this.a;
            c4715m.b = this.b;
            D(c4715m, attributes);
            S(c4715m, attributes);
            C(c4715m, attributes);
            Y(c4715m, attributes);
            J(c4715m, attributes);
            this.b.addChild(c4715m);
            this.b = c4715m;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> x0(C4743g c4743g) {
        HashMap hashMap = new HashMap();
        c4743g.A();
        String s = c4743g.s(C4250a.h);
        while (s != null) {
            c4743g.f(C4250a.h);
            hashMap.put(s, c4743g.q());
            c4743g.A();
            s = c4743g.s(C4250a.h);
        }
        return hashMap;
    }

    private void y(Attributes attributes) throws SVGParseException {
        l("<mask>", new Object[0]);
        if (this.b != null) {
            SVG.C4717n c4717n = new SVG.C4717n();
            c4717n.a = this.a;
            c4717n.b = this.b;
            D(c4717n, attributes);
            S(c4717n, attributes);
            C(c4717n, attributes);
            K(c4717n, attributes);
            this.b.addChild(c4717n);
            this.b = c4717n;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private static SVG.Style.RenderQuality y0(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -933002398:
                if (str.equals("optimizeQuality")) {
                    c = 0;
                    break;
                }
                break;
            case 3005871:
                if (str.equals("auto")) {
                    c = 1;
                    break;
                }
                break;
            case 362741610:
                if (str.equals("optimizeSpeed")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
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
        C4743g c4743g = new C4743g(str);
        HashSet hashSet = new HashSet();
        while (!c4743g.h()) {
            String r = c4743g.r();
            if (r.startsWith("http://www.w3.org/TR/SVG11/feature#")) {
                hashSet.add(r.substring(35));
            } else {
                hashSet.add("UNSUPPORTED");
            }
            c4743g.A();
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
