package cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser;

import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.model.CSSStyle;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.model.G;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.model.SVGLine;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.model.SVGOval;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.model.SVGPaintData;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.model.SVGPath;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.model.SVGPolygon;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.model.SVGRect;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.model.SVGText;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.model.PointLocation;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import com.alibaba.security.realidentity.jsbridge.AbstractC3893a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.taobao.weex.common.Constants;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import tb.cb1;
import tb.cb2;
import tb.jn1;
import tb.sq1;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class SVGXmlParser {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static boolean a = true;
    private static final Pattern b = Pattern.compile("[\\s,]*");
    private static final RectF c = new RectF();
    private static final Matrix d = new Matrix();
    private static final Matrix e = new Matrix();

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class Properties {
        private static transient /* synthetic */ IpChange $ipChange;
        Attributes atts;
        C0861e styles;

        private int hex3Tohex6(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-414144069")) {
                return ((Integer) ipChange.ipc$dispatch("-414144069", new Object[]{this, Integer.valueOf(i)})).intValue();
            }
            int i2 = i & 3840;
            int i3 = (i2 << 12) | (i2 << 8);
            int i4 = i & GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN;
            int i5 = i & 15;
            return i5 | i3 | (i4 << 4) | (i4 << 8) | (i5 << 4);
        }

        private int parseNum(String str) throws NumberFormatException {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "34264051")) {
                return ((Integer) ipChange.ipc$dispatch("34264051", new Object[]{this, str})).intValue();
            }
            if (str == null) {
                return 0;
            }
            String trim = str.trim();
            if (trim.endsWith("%")) {
                return Math.round((Float.parseFloat(trim.substring(0, trim.length() - 1)) / 100.0f) * 255.0f);
            }
            return Integer.parseInt(trim);
        }

        private Integer rgb(int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "236454262") ? (Integer) ipChange.ipc$dispatch("236454262", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) : Integer.valueOf(((i & 255) << 16) | ((i2 & 255) << 8) | (i3 & 255));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAttributes(Attributes attributes) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2113870952")) {
                ipChange.ipc$dispatch("-2113870952", new Object[]{this, attributes});
                return;
            }
            this.atts = attributes;
            String m = SVGXmlParser.m("style", attributes);
            if (m != null) {
                this.styles = new C0861e(m);
            } else {
                this.styles = null;
            }
        }

        public void clearData() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-473639414")) {
                ipChange.ipc$dispatch("-473639414", new Object[]{this});
                return;
            }
            this.styles = null;
            this.atts = null;
        }

        public String getAttr(String str) {
            Attributes attributes;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "674864540")) {
                return (String) ipChange.ipc$dispatch("674864540", new Object[]{this, str});
            }
            C0861e c0861e = this.styles;
            String a = c0861e != null ? c0861e.a(str) : null;
            return (a != null || (attributes = this.atts) == null) ? a : SVGXmlParser.m(str, attributes);
        }

        public Integer getColor(String str) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1455467507") ? (Integer) ipChange.ipc$dispatch("-1455467507", new Object[]{this, str}) : parseColor(getAttr(str));
        }

        public float getFloat(String str, float f) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "457634883")) {
                return ((Float) ipChange.ipc$dispatch("457634883", new Object[]{this, str, Float.valueOf(f)})).floatValue();
            }
            String attr = getAttr(str);
            if (attr == null) {
                return f;
            }
            try {
                return Float.parseFloat(attr);
            } catch (NumberFormatException unused) {
                return f;
            }
        }

        public String getString(String str) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1545389764") ? (String) ipChange.ipc$dispatch("-1545389764", new Object[]{this, str}) : getAttr(str);
        }

        public Integer parseColor(String str) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-335602966") ? (Integer) ipChange.ipc$dispatch("-335602966", new Object[]{this, str}) : C0864c.c(str);
        }

        private Properties() {
            this.styles = null;
        }

        public float getFloat(String str) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1815876861") ? ((Float) ipChange.ipc$dispatch("1815876861", new Object[]{this, str})).floatValue() : getFloat(str, 0.0f);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.SVGXmlParser$b */
    /* loaded from: classes.dex */
    public static class C0858b {
        private static transient /* synthetic */ IpChange $ipChange;
        String a;
        String b;
        boolean c;
        float d;
        float e;
        float f;
        float g;
        float h;
        float i;
        float j;
        ArrayList<Float> k;
        ArrayList<Integer> l;
        Matrix m;
        public Shader n;
        public boolean o;
        public Shader.TileMode p;

        private C0858b() {
            this.k = new ArrayList<>();
            this.l = new ArrayList<>();
            this.m = null;
            this.n = null;
            this.o = false;
        }

        public C0858b a(C0858b c0858b) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "264422268")) {
                return (C0858b) ipChange.ipc$dispatch("264422268", new Object[]{this, c0858b});
            }
            C0858b c0858b2 = new C0858b();
            c0858b2.a = c0858b.a;
            c0858b2.b = this.a;
            c0858b2.c = c0858b.c;
            c0858b2.d = c0858b.d;
            c0858b2.f = c0858b.f;
            c0858b2.e = c0858b.e;
            c0858b2.g = c0858b.g;
            c0858b2.h = c0858b.h;
            c0858b2.i = c0858b.i;
            c0858b2.j = c0858b.j;
            c0858b2.k = this.k;
            c0858b2.l = this.l;
            c0858b2.m = this.m;
            Matrix matrix = c0858b.m;
            if (matrix != null) {
                if (this.m == null) {
                    c0858b2.m = matrix;
                } else {
                    Matrix matrix2 = new Matrix(this.m);
                    matrix2.preConcat(c0858b.m);
                    c0858b2.m = matrix2;
                }
            }
            c0858b2.o = c0858b.o;
            c0858b2.n = c0858b.n;
            c0858b2.p = c0858b.p;
            return c0858b2;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.SVGXmlParser$c */
    /* loaded from: classes.dex */
    public static class C0859c {
        private static transient /* synthetic */ IpChange $ipChange;
        private ArrayList<Float> a;

        public C0859c(ArrayList<Float> arrayList, int i) {
            this.a = arrayList;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.SVGXmlParser$d */
    /* loaded from: classes.dex */
    public static class C0860d extends DefaultHandler {
        private static transient /* synthetic */ IpChange $ipChange;
        private float a;
        final LinkedList<Float> b;
        Paint c;
        final LinkedList<Paint> d;
        Paint e;
        final LinkedList<Paint> f;
        final LinkedList<String> g;
        final RectF h;
        final HashMap<String, C0858b> i;
        final Matrix j;
        C0858b k;
        private int l;
        private boolean m;
        List<String> n;
        Properties o;
        Properties p;
        SVGPaintData q;
        private String r;
        private SVGText s;
        private String t;
        private StringBuilder u;
        private List<CSSStyle> v;

        public C0860d() {
            LinkedList<Float> linkedList = new LinkedList<>();
            this.b = linkedList;
            this.d = new LinkedList<>();
            this.f = new LinkedList<>();
            this.g = new LinkedList<>();
            this.h = new RectF();
            this.i = new HashMap<>();
            this.j = new Matrix();
            this.k = null;
            this.l = 0;
            this.m = false;
            this.n = new ArrayList();
            new ArrayList();
            this.o = new Properties();
            this.p = new Properties();
            this.t = "";
            Paint paint = new Paint();
            this.c = paint;
            paint.setAntiAlias(true);
            this.c.setStyle(Paint.Style.STROKE);
            Paint paint2 = new Paint();
            this.e = paint2;
            paint2.setAntiAlias(true);
            this.e.setStyle(Paint.Style.FILL);
            linkedList.addFirst(Float.valueOf(1.0f));
            this.q = new SVGPaintData();
        }

        private void b(Properties properties, int i, boolean z, Paint paint) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-142916123")) {
                ipChange.ipc$dispatch("-142916123", new Object[]{this, properties, Integer.valueOf(i), Boolean.valueOf(z), paint});
                return;
            }
            paint.setShader(null);
            paint.setColor((i & 16777215) | (-16777216));
            String string = properties.getString("opacity");
            float f = 1.0f;
            if (!TextUtils.isEmpty(string)) {
                f = SVGXmlParser.p(string, 1.0f);
            } else {
                String string2 = properties.getString(z ? "fill-opacity" : "stroke-opacity");
                if (!TextUtils.isEmpty(string2)) {
                    f = SVGXmlParser.p(string2, 1.0f);
                }
            }
            paint.setAlpha((int) (f * a().floatValue() * 255.0f));
        }

        private void c(CSSStyle cSSStyle, int i, boolean z, Paint paint) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-186780770")) {
                ipChange.ipc$dispatch("-186780770", new Object[]{this, cSSStyle, Integer.valueOf(i), Boolean.valueOf(z), paint});
                return;
            }
            paint.setShader(null);
            paint.setColor((i & 16777215) | (-16777216));
            String string = cSSStyle.getString("opacity");
            float f = 1.0f;
            if (!TextUtils.isEmpty(string)) {
                f = SVGXmlParser.p(string, 1.0f);
            } else {
                String string2 = cSSStyle.getString(z ? "fill-opacity" : "stroke-opacity");
                if (!TextUtils.isEmpty(string2)) {
                    f = SVGXmlParser.p(string2, 1.0f);
                }
            }
            paint.setAlpha((int) (f * a().floatValue() * 255.0f));
        }

        private boolean d(Properties properties, RectF rectF) {
            String string;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "68617500")) {
                return ((Boolean) ipChange.ipc$dispatch("68617500", new Object[]{this, properties, rectF})).booleanValue();
            }
            if ("none".equals(properties.getString("display"))) {
                return false;
            }
            String string2 = properties.getString("fill");
            if (string2 != null) {
                if (string2.startsWith("url(#")) {
                    String substring = string2.substring(5, string2.length() - 1);
                    C0858b c0858b = this.i.get(substring);
                    Shader shader = c0858b != null ? c0858b.n : null;
                    if (shader != null) {
                        this.e.setShader(shader);
                        this.j.set(c0858b.m);
                        if (c0858b.o && rectF != null) {
                            this.j.preTranslate(rectF.left, rectF.top);
                            this.j.preScale(rectF.width(), rectF.height());
                        }
                        shader.setLocalMatrix(this.j);
                        return true;
                    }
                    cb1.c("SVGAndroid", "Didn't find shader, using white: " + substring);
                    this.e.setShader(null);
                    b(properties, -16777216, true, this.e);
                    return true;
                } else if (string2.equalsIgnoreCase("none")) {
                    this.e.setShader(null);
                    this.e.setColor(0);
                    return true;
                } else {
                    this.e.setShader(null);
                    Integer color = properties.getColor("fill");
                    if (color != null) {
                        b(properties, color.intValue(), true, this.e);
                        return true;
                    }
                    cb1.c("SVGAndroid", "Unrecognized fill color, using black: " + string2);
                    b(properties, -16777216, true, this.e);
                    return true;
                }
            }
            CSSStyle i = i(this.v, this.o);
            if (i != null && (string = i.getString("fill")) != null) {
                if (string.equalsIgnoreCase("none")) {
                    this.e.setShader(null);
                    this.e.setColor(0);
                    return true;
                }
                this.e.setShader(null);
                Integer color2 = i.getColor("fill");
                if (color2 != null) {
                    c(i, color2.intValue(), true, this.e);
                    return true;
                }
                cb1.c("SVGAndroid", "Unrecognized fill color, using black: " + string);
                c(i, -16777216, true, this.e);
                return true;
            } else if (!this.f.isEmpty() && this.f.getLast() != null) {
                Paint last = this.f.getLast();
                this.e = last;
                return last.getColor() != 0;
            } else {
                this.e.setShader(null);
                this.e.setColor(-16777216);
                return true;
            }
        }

        private C0858b e(boolean z, Attributes attributes) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2075496021")) {
                return (C0858b) ipChange.ipc$dispatch("-2075496021", new Object[]{this, Boolean.valueOf(z), attributes});
            }
            C0858b c0858b = new C0858b();
            c0858b.a = SVGXmlParser.m("id", attributes);
            c0858b.c = z;
            if (z) {
                c0858b.d = SVGXmlParser.k("x1", attributes, 0.0f);
                c0858b.f = SVGXmlParser.k("x2", attributes, 1.0f);
                c0858b.e = SVGXmlParser.k("y1", attributes, 0.0f);
                c0858b.g = SVGXmlParser.k("y2", attributes, 0.0f);
            } else {
                c0858b.h = SVGXmlParser.k("cx", attributes, 0.0f);
                c0858b.i = SVGXmlParser.k("cy", attributes, 0.0f);
                c0858b.j = SVGXmlParser.k(UploadQueueMgr.MSGTYPE_REALTIME, attributes, 0.0f);
            }
            String m = SVGXmlParser.m("gradientTransform", attributes);
            if (m != null) {
                c0858b.m = SVGXmlParser.r(m);
            }
            String m2 = SVGXmlParser.m("spreadMethod", attributes);
            if (m2 == null) {
                m2 = "pad";
            }
            c0858b.p = m2.equals("reflect") ? Shader.TileMode.MIRROR : m2.equals("repeat") ? Shader.TileMode.REPEAT : Shader.TileMode.CLAMP;
            String m3 = SVGXmlParser.m("gradientUnits", attributes);
            if (m3 == null) {
                m3 = "objectBoundingBox";
            }
            c0858b.o = !m3.equals("userSpaceOnUse");
            String m4 = SVGXmlParser.m("href", attributes);
            if (m4 != null) {
                if (m4.startsWith(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
                    m4 = m4.substring(1);
                }
                c0858b.b = m4;
            }
            return c0858b;
        }

        private boolean f(Properties properties) {
            String string;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-767164096")) {
                return ((Boolean) ipChange.ipc$dispatch("-767164096", new Object[]{this, properties})).booleanValue();
            }
            if ("none".equals(properties.getString("display"))) {
                return false;
            }
            String string2 = properties.getString("stroke-width");
            if (!TextUtils.isEmpty(string2)) {
                this.c.setStrokeWidth(Float.valueOf(SVGXmlParser.p(string2, 1.0f)).floatValue());
            }
            String string3 = properties.getString("stroke-linecap");
            if ("round".equals(string3)) {
                this.c.setStrokeCap(Paint.Cap.ROUND);
            } else if ("square".equals(string3)) {
                this.c.setStrokeCap(Paint.Cap.SQUARE);
            } else if ("butt".equals(string3)) {
                this.c.setStrokeCap(Paint.Cap.BUTT);
            }
            String string4 = properties.getString("stroke-linejoin");
            if ("miter".equals(string4)) {
                this.c.setStrokeJoin(Paint.Join.MITER);
            } else if ("round".equals(string4)) {
                this.c.setStrokeJoin(Paint.Join.ROUND);
            } else if ("bevel".equals(string4)) {
                this.c.setStrokeJoin(Paint.Join.BEVEL);
            }
            q(properties.getString("stroke-dasharray"), properties.getString("stroke-dashoffset"));
            String attr = properties.getAttr("stroke");
            if (attr != null) {
                if (attr.equalsIgnoreCase("none")) {
                    this.c.setColor(0);
                    return false;
                }
                Integer color = properties.getColor("stroke");
                if (color != null) {
                    b(properties, color.intValue(), false, this.c);
                    return true;
                }
                cb1.c("SVGAndroid", "Unrecognized stroke color, using none: " + attr);
                this.c.setColor(0);
                return false;
            }
            CSSStyle i = i(this.v, properties);
            if (i != null && (string = i.getString("stroke")) != null) {
                if (string.equalsIgnoreCase("none")) {
                    this.c.setColor(0);
                    return false;
                }
                Integer color2 = i.getColor("stroke");
                if (color2 != null) {
                    String string5 = i.getString("stroke-width");
                    if (!TextUtils.isEmpty(string5)) {
                        this.c.setStrokeWidth(Float.valueOf(SVGXmlParser.p(string5, 1.0f)).floatValue());
                    }
                    String string6 = i.getString("stroke-linecap");
                    if ("round".equals(string6)) {
                        this.c.setStrokeCap(Paint.Cap.ROUND);
                    } else if ("square".equals(string6)) {
                        this.c.setStrokeCap(Paint.Cap.SQUARE);
                    } else if ("butt".equals(string6)) {
                        this.c.setStrokeCap(Paint.Cap.BUTT);
                    }
                    String string7 = i.getString("stroke-linejoin");
                    if ("miter".equals(string7)) {
                        this.c.setStrokeJoin(Paint.Join.MITER);
                    } else if ("round".equals(string7)) {
                        this.c.setStrokeJoin(Paint.Join.ROUND);
                    } else if ("bevel".equals(string7)) {
                        this.c.setStrokeJoin(Paint.Join.BEVEL);
                    }
                    c(i, color2.intValue(), false, this.c);
                    return true;
                }
            }
            if (this.d.isEmpty() || this.d.getLast() == null) {
                return false;
            }
            Paint last = this.d.getLast();
            this.c = last;
            return last.getColor() != 0;
        }

        private List<PointLocation> g(RectF rectF, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-329762763")) {
                return (List) ipChange.ipc$dispatch("-329762763", new Object[]{this, rectF, str});
            }
            PointLocation pointLocation = new PointLocation();
            pointLocation.id = str;
            pointLocation.x = rectF.left;
            pointLocation.y = rectF.top;
            pointLocation.rectF = rectF;
            PointLocation pointLocation2 = new PointLocation();
            pointLocation2.id = str;
            pointLocation2.x = rectF.right;
            pointLocation2.y = rectF.bottom;
            pointLocation2.rectF = rectF;
            ArrayList arrayList = new ArrayList();
            arrayList.add(pointLocation);
            arrayList.add(pointLocation2);
            return arrayList;
        }

        private List<PointLocation> h(ArrayList<Float> arrayList, RectF rectF, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-534189671")) {
                return (List) ipChange.ipc$dispatch("-534189671", new Object[]{this, arrayList, rectF, str});
            }
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                return null;
            }
            if (arrayList.size() > 1) {
                arrayList2 = new ArrayList();
                PointLocation pointLocation = new PointLocation();
                pointLocation.id = str;
                pointLocation.x = arrayList.get(0).floatValue();
                pointLocation.y = arrayList.get(1).floatValue();
                pointLocation.rectF = rectF;
                arrayList2.add(pointLocation);
                for (int i = 2; i < arrayList.size(); i += 2) {
                    PointLocation pointLocation2 = new PointLocation();
                    float floatValue = arrayList.get(i).floatValue();
                    float floatValue2 = arrayList.get(i + 1).floatValue();
                    pointLocation2.id = str;
                    pointLocation2.x = floatValue;
                    pointLocation2.y = floatValue2;
                    pointLocation2.rectF = rectF;
                    arrayList2.add(pointLocation2);
                }
                PointLocation pointLocation3 = new PointLocation();
                pointLocation3.id = str;
                pointLocation3.x = arrayList.get(0).floatValue();
                pointLocation3.y = arrayList.get(1).floatValue();
                pointLocation3.rectF = rectF;
                arrayList2.add(pointLocation3);
            }
            return arrayList2;
        }

        private CSSStyle i(@Nullable List<CSSStyle> list, @Nullable Properties properties) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1388147225")) {
                return (CSSStyle) ipChange.ipc$dispatch("1388147225", new Object[]{this, list, properties});
            }
            if (list != null && list.size() != 0 && properties != null) {
                String attr = properties.getAttr("id");
                if (!TextUtils.isEmpty(attr)) {
                    for (int i = 0; i < list.size(); i++) {
                        CSSStyle cSSStyle = list.get(i);
                        if (cSSStyle.isIdSelector() && cSSStyle.isNameEquals(attr)) {
                            return cSSStyle;
                        }
                    }
                }
                String attr2 = properties.getAttr("class");
                if (!TextUtils.isEmpty(attr2)) {
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        CSSStyle cSSStyle2 = list.get(i2);
                        if (cSSStyle2.isClassSelector() && cSSStyle2.isNameEquals(attr2)) {
                            return cSSStyle2;
                        }
                    }
                }
            }
            return null;
        }

        private String j(char[] cArr, int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1290655759")) {
                return (String) ipChange.ipc$dispatch("-1290655759", new Object[]{this, cArr, Integer.valueOf(i), Integer.valueOf(i2)});
            }
            try {
                return new String(cArr, i, i2);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        private RectF n(RectF rectF, @Nullable Matrix matrix) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "918997535")) {
                return (RectF) ipChange.ipc$dispatch("918997535", new Object[]{this, rectF, matrix});
            }
            if (matrix != null) {
                try {
                    RectF rectF2 = new RectF(rectF);
                    matrix.mapRect(rectF2);
                    return rectF2;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return rectF;
        }

        private ArrayList<Float> o(ArrayList<Float> arrayList, @Nullable Matrix matrix) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1774112113")) {
                return (ArrayList) ipChange.ipc$dispatch("-1774112113", new Object[]{this, arrayList, matrix});
            }
            if (matrix != null) {
                try {
                    if (!cb2.d(arrayList)) {
                        int size = arrayList.size();
                        float[] fArr = new float[size];
                        for (int i = 0; i < arrayList.size(); i++) {
                            fArr[i] = arrayList.get(i).floatValue();
                        }
                        matrix.mapPoints(fArr);
                        ArrayList<Float> arrayList2 = new ArrayList<>();
                        for (int i2 = 0; i2 < size; i2++) {
                            arrayList2.add(Float.valueOf(fArr[i2]));
                        }
                        return arrayList2;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return arrayList;
        }

        private float p(Attributes attributes) {
            int indexOf;
            String substring;
            int indexOf2;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "906264487")) {
                return ((Float) ipChange.ipc$dispatch("906264487", new Object[]{this, attributes})).floatValue();
            }
            String m = SVGXmlParser.m("transform", attributes);
            if (TextUtils.isEmpty(m)) {
                return 1.0f;
            }
            String replaceAll = m.replaceAll(" ", "");
            if (!replaceAll.contains("scale(") || (indexOf = replaceAll.indexOf("scale(")) >= replaceAll.length() || (indexOf2 = (substring = replaceAll.substring(indexOf)).indexOf(jn1.BRACKET_END_STR)) == -1) {
                return 1.0f;
            }
            try {
                return Float.parseFloat(substring.substring(6, indexOf2));
            } catch (Exception e) {
                e.printStackTrace();
                return 1.0f;
            }
        }

        private void q(String str, String str2) {
            IpChange ipChange = $ipChange;
            int i = 0;
            if (AndroidInstantRuntime.support(ipChange, "-1640830904")) {
                ipChange.ipc$dispatch("-1640830904", new Object[]{this, str, str2});
            } else if (str == null) {
            } else {
                String trim = str.trim();
                if (trim.equals("none")) {
                    this.c.setPathEffect(null);
                    return;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(trim, " ,");
                int countTokens = stringTokenizer.countTokens();
                if ((countTokens & 1) == 1) {
                    countTokens *= 2;
                }
                float[] fArr = new float[countTokens];
                float f = 1.0f;
                float f2 = 0.0f;
                int i2 = 0;
                float f3 = 0.0f;
                while (stringTokenizer.hasMoreTokens()) {
                    f = SVGXmlParser.p(stringTokenizer.nextToken(), f);
                    fArr[i2] = f;
                    f3 += f;
                    i2++;
                }
                while (i2 < countTokens) {
                    float f4 = fArr[i];
                    fArr[i2] = f4;
                    f3 += f4;
                    i2++;
                    i++;
                }
                if (str2 != null) {
                    try {
                        f2 = Float.parseFloat(str2) % f3;
                    } catch (NumberFormatException unused) {
                    }
                }
                this.c.setPathEffect(new DashPathEffect(fArr, f2));
            }
        }

        public Float a() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "918172438") ? (Float) ipChange.ipc$dispatch("918172438", new Object[]{this}) : this.b.getLast();
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-66357318")) {
                ipChange.ipc$dispatch("-66357318", new Object[]{this, cArr, Integer.valueOf(i), Integer.valueOf(i2)});
            } else if ("style".equals(this.r)) {
                if (this.u != null) {
                    String j = j(cArr, i, i2);
                    if (TextUtils.isEmpty(j)) {
                        return;
                    }
                    this.u.append(j);
                }
            } else if ("text".equals(this.r)) {
                this.t = new String(cArr, i, i2);
            } else {
                this.t = "";
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endDocument() throws SAXException {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-454938504")) {
                ipChange.ipc$dispatch("-454938504", new Object[]{this});
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) throws SAXException {
            C0858b c0858b;
            StringBuilder sb;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-987448615")) {
                ipChange.ipc$dispatch("-987448615", new Object[]{this, str, str2, str3});
            } else if (!str2.equals("svg")) {
                if (!str2.equals("linearGradient") && !str2.equals("radialGradient")) {
                    if (str2.equals("g")) {
                        if (this.m) {
                            int i = this.l - 1;
                            this.l = i;
                            if (i == 0) {
                                this.m = false;
                            }
                        }
                        if (!this.g.isEmpty()) {
                            G g = new G();
                            g.isParseEnd = true;
                            this.q.addShape(102);
                            this.q.addG(g);
                            this.g.removeLast();
                        }
                        if (this.b.size() > 1) {
                            this.b.removeLast();
                        }
                        if (!this.f.isEmpty()) {
                            this.f.removeLast();
                        }
                        if (!this.d.isEmpty()) {
                            this.d.removeLast();
                        }
                        this.p.clearData();
                        return;
                    } else if (str2.equals("text")) {
                        SVGText sVGText = this.s;
                        if (sVGText != null) {
                            sVGText.content = this.t;
                            this.q.addShape(107);
                            this.q.addText(this.s);
                            return;
                        }
                        return;
                    } else if (!"style".equals(str2) || (sb = this.u) == null) {
                        return;
                    } else {
                        List<CSSStyle> parse = CSSStyle.parse(sb.toString());
                        if (parse != null && parse.size() > 0) {
                            if (this.v == null) {
                                this.v = new ArrayList();
                            }
                            this.v.addAll(parse);
                        }
                        this.u = null;
                        return;
                    }
                }
                C0858b c0858b2 = this.k;
                if (c0858b2.a != null) {
                    String str4 = c0858b2.b;
                    if (str4 != null && (c0858b = this.i.get(str4)) != null) {
                        this.k = c0858b.a(this.k);
                    }
                    int size = this.k.l.size();
                    int[] iArr = new int[size];
                    for (int i2 = 0; i2 < size; i2++) {
                        iArr[i2] = this.k.l.get(i2).intValue();
                    }
                    int size2 = this.k.k.size();
                    float[] fArr = new float[size2];
                    for (int i3 = 0; i3 < size2; i3++) {
                        fArr[i3] = this.k.k.get(i3).floatValue();
                    }
                    if (size == 0) {
                        cb1.b("BAD", "BAD");
                    }
                    if (str2.equals("linearGradient")) {
                        C0858b c0858b3 = this.k;
                        C0858b c0858b4 = this.k;
                        c0858b3.n = new LinearGradient(c0858b4.d, c0858b4.e, c0858b4.f, c0858b4.g, iArr, fArr, c0858b4.p);
                    } else {
                        C0858b c0858b5 = this.k;
                        C0858b c0858b6 = this.k;
                        c0858b5.n = new RadialGradient(c0858b6.h, c0858b6.i, c0858b6.j, iArr, fArr, c0858b6.p);
                    }
                    HashMap<String, C0858b> hashMap = this.i;
                    C0858b c0858b7 = this.k;
                    hashMap.put(c0858b7.a, c0858b7);
                }
            }
        }

        public SVGPaintData k() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-515423538") ? (SVGPaintData) ipChange.ipc$dispatch("-515423538", new Object[]{this}) : this.q;
        }

        public float l() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1782938878") ? ((Float) ipChange.ipc$dispatch("-1782938878", new Object[]{this})).floatValue() : this.a;
        }

        public List<String> m() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1769823953") ? (List) ipChange.ipc$dispatch("-1769823953", new Object[]{this}) : this.n;
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startDocument() throws SAXException {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1441154991")) {
                ipChange.ipc$dispatch("-1441154991", new Object[]{this});
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            String m;
            String str4;
            float p;
            float f;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-72120528")) {
                ipChange.ipc$dispatch("-72120528", new Object[]{this, str, str2, str3, attributes});
            } else if (str2 != null) {
                this.r = str2;
                this.c.setAlpha(255);
                this.e.setAlpha(255);
                if (str2.equals("style")) {
                    if (TextUtils.equals("text/css", SVGXmlParser.m("type", attributes))) {
                        this.u = new StringBuilder();
                    }
                } else if (!this.m && str2.equals(AbstractC3893a.V)) {
                    Path i = SVGXmlParser.i(SVGXmlParser.m("d", attributes));
                    if (i != null) {
                        SVGPath sVGPath = new SVGPath();
                        sVGPath.path = i;
                        String m2 = SVGXmlParser.m("transform", attributes);
                        if (m2 != null) {
                            sVGPath.transformMatrix = SVGXmlParser.r(m2);
                        }
                        this.o.setAttributes(attributes);
                        i.computeBounds(this.h, false);
                        sVGPath.rect = new RectF(this.h);
                        sVGPath.floorId = SVGXmlParser.m("floorId", attributes);
                        String m3 = SVGXmlParser.m("row_id", attributes);
                        sVGPath.rowId = m3;
                        if (sVGPath.floorId != null && m3 == null) {
                            Path path = new Path(i);
                            Matrix matrix = sVGPath.transformMatrix;
                            if (matrix != null) {
                                path.transform(matrix);
                            }
                            sVGPath.locationList = g(n(sVGPath.rect, sVGPath.transformMatrix), sVGPath.floorId);
                            sVGPath.transformBound = path;
                        }
                        if (d(this.o, this.h)) {
                            sVGPath.fillPaint = new Paint(this.e);
                            sVGPath.fillColor = this.e.getColor();
                        }
                        if (f(this.o)) {
                            sVGPath.strokePaint = new Paint(this.c);
                            sVGPath.strokeColor = this.c.getColor();
                        }
                        this.q.addShape(106);
                        this.q.addPath(sVGPath);
                    }
                } else if (str2.equals("g")) {
                    this.o.setAttributes(attributes);
                    this.p.setAttributes(attributes);
                    if (this.m) {
                        this.l++;
                    }
                    if (("none".equals(SVGXmlParser.m("display", attributes)) || "none".equals(this.o.getString("display"))) && !this.m) {
                        this.m = true;
                        this.l = 1;
                    }
                    String attr = this.o.getAttr("opacity");
                    if (attr != null) {
                        this.b.addLast(Float.valueOf(a().floatValue() * SVGXmlParser.p(attr, 1.0f)));
                    }
                    if (this.o.getString("fill") != null) {
                        d(this.o, null);
                        this.f.addLast(new Paint(this.e));
                    }
                    if (this.o.getString("stroke") != null) {
                        f(this.o);
                        this.d.addLast(new Paint(this.c));
                    }
                    String m4 = SVGXmlParser.m("transform", attributes);
                    if (m4 != null) {
                        G g = new G();
                        g.transformMatrix = SVGXmlParser.r(m4);
                        g.isParseEnd = false;
                        this.q.addShape(102);
                        this.q.addG(g);
                        this.g.add(m4);
                    }
                } else if (!this.m && (str2.equals("polygon") || str2.equals("polyline"))) {
                    C0859c l = SVGXmlParser.l("points", attributes);
                    if (l != null) {
                        ArrayList<Float> arrayList = l.a;
                        if (arrayList.size() > 1) {
                            SVGPolygon sVGPolygon = new SVGPolygon();
                            sVGPolygon.points = l.a;
                            String m5 = SVGXmlParser.m("transform", attributes);
                            if (m5 != null) {
                                sVGPolygon.transformMatrix = SVGXmlParser.r(m5);
                            }
                            Path path2 = new Path();
                            path2.moveTo(arrayList.get(0).floatValue(), arrayList.get(1).floatValue());
                            for (int i2 = 2; i2 < arrayList.size(); i2 += 2) {
                                path2.lineTo(arrayList.get(i2).floatValue(), arrayList.get(i2 + 1).floatValue());
                            }
                            if (str2.equals("polygon")) {
                                path2.close();
                            }
                            path2.computeBounds(this.h, false);
                            sVGPolygon.path = path2;
                            sVGPolygon.rect = new RectF(this.h);
                            this.o.setAttributes(attributes);
                            sVGPolygon.floorId = SVGXmlParser.m("floorId", attributes);
                            String m6 = SVGXmlParser.m("row_id", attributes);
                            sVGPolygon.rowId = m6;
                            if (sVGPolygon.floorId != null && m6 == null) {
                                sVGPolygon.locationList = h(o(arrayList, sVGPolygon.transformMatrix), sVGPolygon.rect, sVGPolygon.floorId);
                            }
                            if (d(this.o, this.h)) {
                                sVGPolygon.fillPaint = new Paint(this.e);
                                sVGPolygon.fillColor = this.e.getColor();
                            }
                            if (f(this.o)) {
                                sVGPolygon.strokePaint = new Paint(this.c);
                                sVGPolygon.strokeColor = this.c.getColor();
                            }
                            this.q.addShape(105);
                            this.q.addPolygon(sVGPolygon);
                        }
                    }
                } else if (!this.m && (str2.equals("circle") || str2.equals("ellipse"))) {
                    if (str2.equals("ellipse")) {
                        m = SVGXmlParser.m("rx", attributes);
                        str4 = SVGXmlParser.m("ry", attributes);
                    } else {
                        m = SVGXmlParser.m(UploadQueueMgr.MSGTYPE_REALTIME, attributes);
                        str4 = m;
                    }
                    if (m == null || str4 == null) {
                        return;
                    }
                    float k = SVGXmlParser.k("cx", attributes, 0.0f);
                    float k2 = SVGXmlParser.k("cy", attributes, 0.0f);
                    if (str2.equals("ellipse")) {
                        p = SVGXmlParser.p(m, 0.0f);
                        f = SVGXmlParser.p(str4, 0.0f);
                    } else {
                        p = SVGXmlParser.p(m, 0.0f);
                        f = p;
                    }
                    SVGOval sVGOval = new SVGOval();
                    sVGOval.centerX = k;
                    sVGOval.centerY = k2;
                    sVGOval.radiusX = p;
                    sVGOval.radiusY = f;
                    String m7 = SVGXmlParser.m("transform", attributes);
                    if (m7 != null) {
                        sVGOval.transformMatrix = SVGXmlParser.r(m7);
                    }
                    this.o.setAttributes(attributes);
                    this.h.set(k - p, k2 - f, k + p, k2 + f);
                    sVGOval.rect = new RectF(this.h);
                    sVGOval.floorId = SVGXmlParser.m("floorId", attributes);
                    String m8 = SVGXmlParser.m("row_id", attributes);
                    sVGOval.rowId = m8;
                    if (sVGOval.floorId != null && m8 == null) {
                        sVGOval.locationList = g(n(sVGOval.rect, sVGOval.transformMatrix), sVGOval.floorId);
                    }
                    if (d(this.o, this.h)) {
                        sVGOval.fillPaint = new Paint(this.e);
                        sVGOval.fillColor = this.e.getColor();
                    }
                    if (f(this.o)) {
                        sVGOval.strokePaint = new Paint(this.c);
                        sVGOval.strokeColor = this.c.getColor();
                    }
                    this.q.addShape(104);
                    this.q.addOval(sVGOval);
                } else if (!this.m && str2.equals("rect")) {
                    float k3 = SVGXmlParser.k(Constants.Name.X, attributes, 0.0f);
                    float k4 = SVGXmlParser.k(Constants.Name.Y, attributes, 0.0f);
                    float k5 = SVGXmlParser.k("width", attributes, 0.0f);
                    float k6 = SVGXmlParser.k("height", attributes, 0.0f);
                    float k7 = SVGXmlParser.k("rx", attributes, 0.0f);
                    float k8 = SVGXmlParser.k("ry", attributes, 0.0f);
                    SVGRect sVGRect = new SVGRect();
                    sVGRect.x = k3;
                    sVGRect.y = k4;
                    sVGRect.rx = k7;
                    sVGRect.ry = k8;
                    sVGRect.width = k5;
                    sVGRect.height = k6;
                    String m9 = SVGXmlParser.m("transform", attributes);
                    if (m9 != null) {
                        sVGRect.transformMatrix = SVGXmlParser.r(m9);
                    }
                    this.h.set(k3, k4, k5 + k3, k6 + k4);
                    sVGRect.rect = new RectF(this.h);
                    this.o.setAttributes(attributes);
                    sVGRect.floorId = SVGXmlParser.m("floorId", attributes);
                    String m10 = SVGXmlParser.m("row_id", attributes);
                    sVGRect.rowId = m10;
                    if (sVGRect.floorId != null && m10 == null) {
                        sVGRect.locationList = g(n(sVGRect.rect, sVGRect.transformMatrix), sVGRect.floorId);
                    }
                    if (d(this.o, this.h)) {
                        sVGRect.fillPaint = new Paint(this.e);
                        sVGRect.fillColor = this.e.getColor();
                    }
                    if (f(this.o)) {
                        sVGRect.strokePaint = new Paint(this.c);
                        sVGRect.strokeColor = this.c.getColor();
                    }
                    this.q.addShape(101);
                    this.q.addRect(sVGRect);
                } else if (!this.m && str2.equals("line")) {
                    SVGLine sVGLine = new SVGLine();
                    sVGLine.startX = SVGXmlParser.k("x1", attributes, 0.0f);
                    sVGLine.startY = SVGXmlParser.k("y1", attributes, 0.0f);
                    sVGLine.endX = SVGXmlParser.k("x2", attributes, 0.0f);
                    sVGLine.endY = SVGXmlParser.k("y2", attributes, 0.0f);
                    String m11 = SVGXmlParser.m("transform", attributes);
                    if (m11 != null) {
                        sVGLine.transformMatrix = SVGXmlParser.r(m11);
                    }
                    this.o.setAttributes(attributes);
                    if (f(this.o)) {
                        sVGLine.strokePaint = new Paint(this.c);
                        sVGLine.strokeColor = this.c.getColor();
                    }
                    this.q.addShape(103);
                    this.q.addLine(sVGLine);
                } else if (str2.equals("svg")) {
                    this.a = p(attributes);
                    String m12 = SVGXmlParser.m("viewBox", attributes);
                    if (m12 != null) {
                        String[] split = m12.replace(',', ' ').split("\\s+");
                        if (split.length == 4) {
                            float p2 = SVGXmlParser.p(split[0], 0.0f);
                            float p3 = SVGXmlParser.p(split[1], 0.0f);
                            float p4 = SVGXmlParser.p(split[2], 0.0f);
                            float p5 = SVGXmlParser.p(split[3], 0.0f);
                            float ceil = (float) Math.ceil(p4 - p2);
                            float ceil2 = (float) Math.ceil(p5 - p3);
                            if (ceil <= 0.0f || ceil2 <= 0.0f) {
                                return;
                            }
                            this.q.setSVGHeightAndWidth((int) ceil, (int) ceil2, true, p2, p3);
                            r9 = 1;
                        }
                    }
                    if (r9 == 0) {
                        String m13 = SVGXmlParser.m("width", attributes);
                        String m14 = SVGXmlParser.m("height", attributes);
                        float f2 = 3000.0f;
                        float p6 = (TextUtils.isEmpty(m13) || m13.endsWith("%")) ? 3000.0f : SVGXmlParser.p(m13, 3000.0f);
                        if (!TextUtils.isEmpty(m14) && !m14.endsWith("%")) {
                            f2 = SVGXmlParser.p(m14, 3000.0f);
                        }
                        this.q.setSVGHeightAndWidth((int) Math.ceil(p6), (int) Math.ceil(f2), false, 0.0f, 0.0f);
                    }
                } else if (!str2.equals("defs")) {
                    if (str2.equals("linearGradient")) {
                        this.k = e(true, attributes);
                    } else if (str2.equals("radialGradient")) {
                        this.k = e(false, attributes);
                    } else if (str2.equals("stop")) {
                        if (this.k != null) {
                            this.o.setAttributes(attributes);
                            Integer color = this.o.getColor("stop-color");
                            this.k.l.add(Integer.valueOf(color != null ? color.intValue() | (Math.round((this.o.getFloat("stop-opacity", 1.0f) * a().floatValue()) * 255.0f) << 24) : 0));
                            this.k.k.add(Float.valueOf(this.o.getFloat("offset", 0.0f)));
                        }
                    } else if (!this.m && str2.equals("text")) {
                        this.t = "";
                        this.s = new SVGText();
                        float n = SVGXmlParser.n("dx", attributes, 0.0f);
                        float n2 = SVGXmlParser.n(Constants.Name.DISTANCE_Y, attributes, 0.0f);
                        this.s.x = SVGXmlParser.n(Constants.Name.X, attributes, 0.0f) + n;
                        this.s.y = SVGXmlParser.n(Constants.Name.Y, attributes, 0.0f) + n2;
                        String m15 = SVGXmlParser.m("transform", attributes);
                        if (m15 != null) {
                            this.s.transformMatrix = SVGXmlParser.r(m15);
                        }
                        this.o.setAttributes(attributes);
                        String string = this.o.getString("font-size");
                        if (TextUtils.isEmpty(string)) {
                            string = this.p.getString("font-size");
                        }
                        this.s.textSize = SVGXmlParser.p(string, 40.0f);
                        String string2 = this.o.getString("text-anchor");
                        if (TextUtils.isEmpty(string2)) {
                            string2 = this.p.getAttr("text-anchor");
                        }
                        if (d(this.o, this.h) && this.e.getColor() != 0) {
                            this.s.fillPaint = new Paint(this.e);
                            this.s.fillColor = this.e.getColor();
                            if ("middle".equals(string2)) {
                                this.s.fillPaint.setTextAlign(Paint.Align.CENTER);
                            } else if ("end".equals(string2)) {
                                this.s.fillPaint.setTextAlign(Paint.Align.RIGHT);
                            } else {
                                this.s.fillPaint.setTextAlign(Paint.Align.LEFT);
                            }
                        }
                        if (f(this.o)) {
                            this.s.strokePaint = new Paint(this.c);
                            this.s.strokeColor = this.c.getColor();
                            if ("middle".equals(string2)) {
                                this.s.strokePaint.setTextAlign(Paint.Align.CENTER);
                            } else if ("end".equals(string2)) {
                                this.s.strokePaint.setTextAlign(Paint.Align.RIGHT);
                            } else {
                                this.s.strokePaint.setTextAlign(Paint.Align.LEFT);
                            }
                        }
                    } else if (!this.m) {
                        cb1.g("SVGAndroid", "UNRECOGNIZED SVG COMMAND: " + str2);
                        if (this.n.contains(str2)) {
                            return;
                        }
                        this.n.add(str2);
                    }
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.SVGXmlParser$e */
    /* loaded from: classes.dex */
    public static class C0861e {
        private static transient /* synthetic */ IpChange $ipChange;
        HashMap<String, String> a;

        public C0861e(String str) {
            HashMap<String, String> hashMap = new HashMap<>();
            this.a = hashMap;
            hashMap.clear();
            for (String str2 : str.split(";")) {
                String[] split = str2.split(":");
                if (split.length == 2) {
                    this.a.put(split[0].trim(), split[1].trim());
                }
            }
        }

        public String a(String str) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-726615158") ? (String) ipChange.ipc$dispatch("-726615158", new Object[]{this, str}) : this.a.get(str);
        }
    }

    private static float h(float f, float f2, float f3, float f4) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-427380601") ? ((Float) ipChange.ipc$dispatch("-427380601", new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})).floatValue() : ((float) Math.toDegrees(Math.atan2(f, f2) - Math.atan2(f3, f4))) % 360.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Path i(String str) {
        char c2;
        char c3;
        char c4;
        float d2;
        float d3;
        float f;
        float f2;
        float f3;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1171217378")) {
            return (Path) ipChange.ipc$dispatch("1171217378", new Object[]{str});
        }
        if (str == null) {
            return null;
        }
        Path path = new Path();
        int length = str.length();
        sq1 sq1Var = new sq1(str, 0);
        sq1Var.i();
        float f4 = 0.0f;
        char c5 = 0;
        float f5 = 0.0f;
        float f6 = 0.0f;
        char c6 = 0;
        float f7 = 0.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        float f10 = 0.0f;
        while (true) {
            int i = sq1Var.d;
            if (i >= length) {
                return path;
            }
            char charAt = str.charAt(i);
            switch (charAt) {
                case '+':
                case ',':
                case '-':
                case '.':
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    if (c5 != 'm' && c5 != 'M') {
                        if ("lhvcsqta".indexOf(Character.toLowerCase(c5)) >= 0) {
                            c3 = c5;
                            c2 = c6;
                            break;
                        }
                    } else {
                        c2 = c6;
                        char c7 = c5;
                        c5 = (char) (c5 - 1);
                        c3 = c7;
                        break;
                    }
                    break;
                case '/':
                default:
                    sq1Var.a();
                    c2 = c5;
                    c3 = charAt;
                    c5 = c3;
                    break;
            }
            switch (c5) {
                case 'A':
                case 'a':
                    c4 = c2;
                    float d4 = sq1Var.d();
                    float d5 = sq1Var.d();
                    float d6 = sq1Var.d();
                    int c8 = sq1Var.c();
                    int c9 = sq1Var.c();
                    float d7 = sq1Var.d();
                    float d8 = sq1Var.d();
                    if (c5 == 'a') {
                        d7 += f5;
                        d8 += f6;
                    }
                    float f11 = d7;
                    float f12 = d8;
                    j(path, f5, f6, f11, f12, d4, d5, d6, c8, c9);
                    f8 = f8;
                    f5 = f11;
                    f6 = f12;
                    f7 = f7;
                    z = false;
                    break;
                case 'C':
                case 'c':
                    c4 = c2;
                    float d9 = sq1Var.d();
                    float d10 = sq1Var.d();
                    float d11 = sq1Var.d();
                    float d12 = sq1Var.d();
                    float d13 = sq1Var.d();
                    float d14 = sq1Var.d();
                    if (c5 == 'c') {
                        d9 += f5;
                        d11 += f5;
                        d13 += f5;
                        d10 += f6;
                        d12 += f6;
                        d14 += f6;
                    }
                    float f13 = d11;
                    float f14 = d12;
                    path.cubicTo(d9, d10, f13, f14, d13, d14);
                    f5 = d13;
                    f6 = d14;
                    f10 = f14;
                    f9 = f13;
                    z = true;
                    break;
                case 'H':
                case 'h':
                    c4 = c2;
                    float d15 = sq1Var.d();
                    if (c5 == 'h') {
                        path.rLineTo(d15, 0.0f);
                        f5 += d15;
                    } else {
                        path.lineTo(d15, f6);
                        f5 = d15;
                    }
                    z = false;
                    break;
                case 'L':
                case 'l':
                    c4 = c2;
                    d2 = sq1Var.d();
                    d3 = sq1Var.d();
                    if (c5 == 'l') {
                        path.rLineTo(d2, d3);
                        f5 += d2;
                        f6 += d3;
                        z = false;
                        break;
                    } else {
                        path.lineTo(d2, d3);
                        f5 = d2;
                        f6 = d3;
                        z = false;
                    }
                case 'M':
                case 'm':
                    c4 = c2;
                    d2 = sq1Var.d();
                    d3 = sq1Var.d();
                    if (c5 == 'm') {
                        f8 += d2;
                        f7 += d3;
                        path.rMoveTo(d2, d3);
                        f5 += d2;
                        f6 += d3;
                        z = false;
                        break;
                    } else {
                        path.moveTo(d2, d3);
                        f5 = d2;
                        f8 = f5;
                        f6 = d3;
                        f7 = f6;
                        z = false;
                    }
                case 'Q':
                case 'q':
                    c4 = c2;
                    float d16 = sq1Var.d();
                    float d17 = sq1Var.d();
                    float d18 = sq1Var.d();
                    float d19 = sq1Var.d();
                    if (Character.isLowerCase(c5)) {
                        d16 += f5;
                        d18 += f5;
                        d17 += f6;
                        d19 += f6;
                    }
                    f5 = d18;
                    f6 = d19;
                    path.quadTo(d16, d17, f5, f6);
                    f9 = d16;
                    f10 = d17;
                    z = true;
                    break;
                case 'S':
                case 's':
                    float d20 = sq1Var.d();
                    float d21 = sq1Var.d();
                    float d22 = sq1Var.d();
                    float d23 = sq1Var.d();
                    if (Character.isLowerCase(c5)) {
                        d20 += f5;
                        d22 += f5;
                        d21 += f6;
                        d23 += f6;
                    }
                    float f15 = d22;
                    float f16 = d23;
                    float f17 = d21;
                    float f18 = d20;
                    if (c2 != 'C' && c2 != 'c' && c2 != 'S' && c2 != 's') {
                        path.quadTo(f18, f17, f15, f16);
                        f = f15;
                        f2 = f17;
                        f3 = f18;
                        c4 = c2;
                    } else {
                        float f19 = (f5 * 2.0f) - f9;
                        float f20 = (f6 * 2.0f) - f10;
                        f = f15;
                        f2 = f17;
                        f3 = f18;
                        c4 = c2;
                        path.cubicTo(f19, f20, f18, f17, f, f16);
                    }
                    f6 = f16;
                    f5 = f;
                    z = true;
                    float f21 = f3;
                    f10 = f2;
                    f9 = f21;
                    break;
                case 'T':
                case 't':
                    float d24 = sq1Var.d();
                    float d25 = sq1Var.d();
                    if (c2 != 'T' && c2 != 't' && c2 != 'Q' && c2 != 'q') {
                        if (Character.isLowerCase(c5)) {
                            path.rLineTo(d24, d25);
                            d24 += f5;
                            d25 += f6;
                        } else {
                            path.lineTo(d24, d25);
                        }
                    } else {
                        if (Character.isLowerCase(c5)) {
                            d24 += f5;
                            d25 += f6;
                        }
                        path.quadTo((f5 - f9) + f5, (f6 - f10) + f6, d24, d25);
                    }
                    f5 = d24;
                    f6 = d25;
                    c4 = c2;
                    z = false;
                    break;
                case 'V':
                case 'v':
                    float d26 = sq1Var.d();
                    if (c5 == 'v') {
                        path.rLineTo(f4, d26);
                        f6 += d26;
                    } else {
                        path.lineTo(f5, d26);
                        f6 = d26;
                    }
                    c4 = c2;
                    z = false;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path.moveTo(f8, f7);
                    c4 = c2;
                    f6 = f7;
                    f10 = f6;
                    f5 = f8;
                    f9 = f5;
                    break;
                default:
                    c4 = c2;
                    cb1.c("SVGAndroid", "Invalid path command: " + c5);
                    sq1Var.a();
                    z = false;
                    break;
            }
            if (!z) {
                f9 = f5;
                f10 = f6;
            }
            sq1Var.i();
            c5 = c3;
            c6 = c4;
            z = true;
            f4 = 0.0f;
        }
    }

    private static void j(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, int i, int i2) {
        float f8;
        int i3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-218272316")) {
            ipChange.ipc$dispatch("-218272316", new Object[]{path, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7), Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (f5 == 0.0f || f6 == 0.0f) {
            path.lineTo(f3, f4);
        } else if (f3 == f && f4 == f2) {
        } else {
            float abs = Math.abs(f5);
            float abs2 = Math.abs(f6);
            double d2 = (3.1415927f * f7) / 180.0f;
            float sin = (float) Math.sin(d2);
            float cos = (float) Math.cos(d2);
            float f9 = (f - f3) / 2.0f;
            float f10 = (f2 - f4) / 2.0f;
            float f11 = (cos * f9) + (sin * f10);
            float f12 = ((-sin) * f9) + (f10 * cos);
            float f13 = f11 * f11;
            float f14 = f12 * f12;
            float f15 = abs * abs;
            float f16 = abs2 * abs2;
            float f17 = ((f13 / f15) + (f14 / f16)) * 1.001f;
            if (f17 > 1.0f) {
                float sqrt = (float) Math.sqrt(f17);
                abs *= sqrt;
                abs2 *= sqrt;
                f15 = abs * abs;
                f16 = abs2 * abs2;
            }
            float f18 = f15 * f16;
            float f19 = f15 * f14;
            float f20 = f16 * f13;
            double sqrt2 = Math.sqrt(((f18 - f19) - f20) / (f19 + f20));
            if (i == i2) {
                i3 = -1;
                f8 = abs;
            } else {
                f8 = abs;
                i3 = 1;
            }
            float f21 = (float) (sqrt2 * i3);
            float f22 = ((f21 * f8) * f12) / abs2;
            float f23 = (((-f21) * abs2) * f11) / f8;
            float f24 = ((cos * f22) - (sin * f23)) + ((f + f3) / 2.0f);
            float f25 = (sin * f22) + (cos * f23) + ((f2 + f4) / 2.0f);
            float f26 = (f11 - f22) / f8;
            float f27 = (f12 - f23) / abs2;
            float h = h(1.0f, 0.0f, f26, f27);
            float h2 = h(f26, f27, ((-f11) - f22) / f8, ((-f12) - f23) / abs2);
            if (i2 == 0 && h2 > 0.0f) {
                h2 -= 360.0f;
            } else if (i2 != 0 && h2 < 0.0f) {
                h2 += 360.0f;
            }
            if (f7 % 360.0f == 0.0f) {
                RectF rectF = c;
                rectF.set(f24 - f8, f25 - abs2, f24 + f8, f25 + abs2);
                path.arcTo(rectF, h, h2);
                return;
            }
            RectF rectF2 = c;
            float f28 = f8;
            rectF2.set(-f28, -abs2, f28, abs2);
            Matrix matrix = d;
            matrix.reset();
            matrix.postRotate(f7);
            matrix.postTranslate(f24, f25);
            Matrix matrix2 = e;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.arcTo(rectF2, h, h2);
            path.transform(matrix);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float k(String str, Attributes attributes, float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-682665843") ? ((Float) ipChange.ipc$dispatch("-682665843", new Object[]{str, attributes, Float.valueOf(f)})).floatValue() : p(m(str, attributes), f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static C0859c l(String str, Attributes attributes) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-382387457")) {
            return (C0859c) ipChange.ipc$dispatch("-382387457", new Object[]{str, attributes});
        }
        if (str == null) {
            return null;
        }
        int length = attributes.getLength();
        for (int i = 0; i < length; i++) {
            if (attributes.getLocalName(i).trim().equals(str)) {
                return q(attributes.getValue(i).trim());
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String m(String str, Attributes attributes) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-325127660")) {
            return (String) ipChange.ipc$dispatch("-325127660", new Object[]{str, attributes});
        }
        if (str == null) {
            return null;
        }
        int length = attributes.getLength();
        for (int i = 0; i < length; i++) {
            if (attributes.getLocalName(i).trim().equals(str)) {
                return attributes.getValue(i).trim();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float n(String str, Attributes attributes, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1842555616")) {
            return ((Float) ipChange.ipc$dispatch("-1842555616", new Object[]{str, attributes, Float.valueOf(f)})).floatValue();
        }
        String m = m(str, attributes);
        if (m != null && m.contains(" ")) {
            m = m.split(" ")[0];
        }
        return p(m, f);
    }

    public static SVGPaintData o(InputSource inputSource, C0860d c0860d) throws SVGParseException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1951691981")) {
            return (SVGPaintData) ipChange.ipc$dispatch("1951691981", new Object[]{inputSource, c0860d});
        }
        try {
            XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            xMLReader.setContentHandler(c0860d);
            xMLReader.setFeature("http://xml.org/sax/features/validation", false);
            if (a) {
                try {
                    xMLReader.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
                } catch (SAXNotRecognizedException unused) {
                    a = false;
                }
            }
            xMLReader.parse(inputSource);
            SVGPaintData k = c0860d.k();
            k.setSvgScale(c0860d.l());
            k.setUnrecognizedCommandList(c0860d.m());
            return k;
        } catch (Exception e2) {
            throw new SVGParseException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float p(String str, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "236474596")) {
            return ((Float) ipChange.ipc$dispatch("236474596", new Object[]{str, Float.valueOf(f)})).floatValue();
        }
        if (str == null) {
            return f;
        }
        if (str.endsWith("px") && str.length() > 2) {
            str = str.substring(0, str.length() - 2);
        } else if (str.endsWith("%") && str.length() > 1) {
            try {
                return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
            } catch (Exception unused) {
                return f;
            }
        } else if (str.endsWith("pt") && str.length() > 2) {
            try {
                return Float.parseFloat(str.substring(0, str.length() - 2)) * 1.25f;
            } catch (NumberFormatException unused2) {
                return f;
            }
        }
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException unused3) {
            return f;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0035, code lost:
        if (r7 != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.SVGXmlParser.C0859c q(java.lang.String r10) {
        /*
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.SVGXmlParser.$ipChange
            java.lang.String r1 = "-195581663"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L17
            java.lang.Object[] r2 = new java.lang.Object[r3]
            r2[r4] = r10
            java.lang.Object r10 = r0.ipc$dispatch(r1, r2)
            cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.SVGXmlParser$c r10 = (cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.SVGXmlParser.C0859c) r10
            return r10
        L17:
            int r0 = r10.length()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2 = 1
            r5 = 0
            r6 = 0
            r7 = 0
        L24:
            if (r2 >= r0) goto L80
            if (r6 == 0) goto L2a
            r6 = 0
            goto L7d
        L2a:
            char r8 = r10.charAt(r2)
            switch(r8) {
                case 9: goto L57;
                case 10: goto L57;
                case 32: goto L57;
                case 41: goto L38;
                case 44: goto L57;
                case 45: goto L35;
                case 65: goto L38;
                case 67: goto L38;
                case 72: goto L38;
                case 76: goto L38;
                case 77: goto L38;
                case 81: goto L38;
                case 83: goto L38;
                case 84: goto L38;
                case 86: goto L38;
                case 90: goto L38;
                case 97: goto L38;
                case 99: goto L38;
                case 101: goto L33;
                case 104: goto L38;
                case 108: goto L38;
                case 109: goto L38;
                case 113: goto L38;
                case 115: goto L38;
                case 116: goto L38;
                case 118: goto L38;
                case 122: goto L38;
                default: goto L31;
            }
        L31:
            r7 = 0
            goto L7d
        L33:
            r7 = 1
            goto L7d
        L35:
            if (r7 == 0) goto L57
            goto L31
        L38:
            java.lang.String r10 = r10.substring(r5, r2)
            java.lang.String r0 = r10.trim()
            int r0 = r0.length()
            if (r0 <= 0) goto L51
            float r10 = java.lang.Float.parseFloat(r10)
            java.lang.Float r10 = java.lang.Float.valueOf(r10)
            r1.add(r10)
        L51:
            cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.SVGXmlParser$c r10 = new cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.SVGXmlParser$c
            r10.<init>(r1, r2)
            return r10
        L57:
            java.lang.String r7 = r10.substring(r5, r2)
            java.lang.String r9 = r7.trim()
            int r9 = r9.length()
            if (r9 <= 0) goto L7a
            float r5 = java.lang.Float.parseFloat(r7)
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            r1.add(r5)
            r5 = 45
            if (r8 != r5) goto L76
            r5 = r2
            goto L31
        L76:
            int r5 = r2 + 1
            r6 = 1
            goto L31
        L7a:
            int r5 = r5 + 1
            goto L31
        L7d:
            int r2 = r2 + 1
            goto L24
        L80:
            java.lang.String r0 = r10.substring(r5)
            int r2 = r0.length()
            if (r2 <= 0) goto L99
            float r0 = java.lang.Float.parseFloat(r0)     // Catch: java.lang.NumberFormatException -> L95
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch: java.lang.NumberFormatException -> L95
            r1.add(r0)     // Catch: java.lang.NumberFormatException -> L95
        L95:
            int r5 = r10.length()
        L99:
            cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.SVGXmlParser$c r10 = new cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.SVGXmlParser$c
            r10.<init>(r1, r5)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.SVGXmlParser.q(java.lang.String):cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.SVGXmlParser$c");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Matrix r(String str) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-143695427")) {
            return (Matrix) ipChange.ipc$dispatch("-143695427", new Object[]{str});
        }
        Matrix matrix = new Matrix();
        while (true) {
            s(str, matrix);
            int indexOf = str.indexOf(jn1.BRACKET_END_STR);
            if (indexOf <= 0 || str.length() <= (i = indexOf + 1)) {
                break;
            }
            str = b.matcher(str.substring(i)).replaceFirst("");
        }
        return matrix;
    }

    private static Matrix s(String str, Matrix matrix) {
        float f;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1076414666")) {
            return (Matrix) ipChange.ipc$dispatch("1076414666", new Object[]{str, matrix});
        }
        if (str == null) {
            return matrix;
        }
        if (str.startsWith("matrix(")) {
            C0859c q = q(str.substring(7));
            if (q.a.size() == 6) {
                Matrix matrix2 = new Matrix();
                matrix2.setValues(new float[]{((Float) q.a.get(0)).floatValue(), ((Float) q.a.get(2)).floatValue(), ((Float) q.a.get(4)).floatValue(), ((Float) q.a.get(1)).floatValue(), ((Float) q.a.get(3)).floatValue(), ((Float) q.a.get(5)).floatValue(), 0.0f, 0.0f, 1.0f});
                matrix.preConcat(matrix2);
            }
        } else if (str.startsWith("translate(")) {
            C0859c q2 = q(str.substring(10));
            if (q2.a.size() > 0) {
                matrix.preTranslate(((Float) q2.a.get(0)).floatValue(), q2.a.size() > 1 ? ((Float) q2.a.get(1)).floatValue() : 0.0f);
            }
        } else if (str.startsWith("scale(")) {
            C0859c q3 = q(str.substring(6));
            if (q3.a.size() > 0) {
                float floatValue = ((Float) q3.a.get(0)).floatValue();
                matrix.preScale(floatValue, q3.a.size() > 1 ? ((Float) q3.a.get(1)).floatValue() : floatValue);
            }
        } else if (str.startsWith("skewX(")) {
            C0859c q4 = q(str.substring(6));
            if (q4.a.size() > 0) {
                matrix.preSkew((float) Math.tan(((Float) q4.a.get(0)).floatValue()), 0.0f);
            }
        } else if (str.startsWith("skewY(")) {
            C0859c q5 = q(str.substring(6));
            if (q5.a.size() > 0) {
                matrix.preSkew(0.0f, (float) Math.tan(((Float) q5.a.get(0)).floatValue()));
            }
        } else if (str.startsWith("rotate(")) {
            C0859c q6 = q(str.substring(7));
            if (q6.a.size() > 0) {
                float floatValue2 = ((Float) q6.a.get(0)).floatValue();
                if (q6.a.size() > 2) {
                    r6 = ((Float) q6.a.get(1)).floatValue();
                    f = ((Float) q6.a.get(2)).floatValue();
                } else {
                    f = 0.0f;
                }
                matrix.preTranslate(-r6, -f);
                matrix.preRotate(floatValue2);
                matrix.preTranslate(r6, f);
            }
        } else {
            cb1.c("SVGAndroid", "Invalid transform (" + str + jn1.BRACKET_END_STR);
        }
        return matrix;
    }
}
