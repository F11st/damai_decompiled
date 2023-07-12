package cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser;

import cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.SVGXmlParser;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.model.SVGPaintData;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.zip.GZIPInputStream;
import org.xml.sax.InputSource;
import tb.cb1;

/* compiled from: Taobao */
/* renamed from: cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.b */
/* loaded from: classes.dex */
public class C0863b {
    private static transient /* synthetic */ IpChange $ipChange;
    private InputStream a;
    private HashMap<String, String> b;
    private HashMap<String, HashMap<String, String>> c;
    private boolean d = true;
    private boolean e = false;

    public C0862a a() throws SVGParseException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1168266083")) {
            return (C0862a) ipChange.ipc$dispatch("-1168266083", new Object[]{this});
        }
        InputStream inputStream = this.a;
        if (inputStream != null) {
            try {
                try {
                    if (!inputStream.markSupported()) {
                        this.a = new BufferedInputStream(this.a);
                    }
                    try {
                        this.a.mark(4);
                        byte[] bArr = new byte[2];
                        int read = this.a.read(bArr, 0, 2);
                        int i = 65535 & (bArr[0] + (bArr[1] << 8));
                        this.a.reset();
                        if (read == 2 && i == 35615) {
                            this.a = new GZIPInputStream(this.a);
                        }
                        SVGXmlParser.C0860d c0860d = new SVGXmlParser.C0860d();
                        long currentTimeMillis = System.currentTimeMillis();
                        SVGPaintData o = SVGXmlParser.o(new InputSource(this.a), c0860d);
                        cb1.g("SVG parse", "---------------------- parse cost = " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                        if (this.e) {
                            o.setRegionColorData(null);
                            o.setRainbowColorData(this.c);
                        } else {
                            o.setRegionColorData(this.b);
                            o.setRainbowColorData(null);
                        }
                        long currentTimeMillis2 = System.currentTimeMillis();
                        C0862a c0862a = new C0862a(o, o.getRegionLocationList(), o.getRegionBounds());
                        cb1.g("SVG build", "---------------------- build cost = " + (System.currentTimeMillis() - currentTimeMillis2) + "ms");
                        c0862a.setSVGScale(o.getSvgScale());
                        c0862a.setUnrecognizedCommandList(o.getUnrecognizedCommandList());
                        if (this.d) {
                            try {
                                this.a.close();
                            } catch (IOException e) {
                                cb1.c("SVGAndroid", "Error closing SVG input stream: " + e.getMessage());
                            }
                        }
                        return c0862a;
                    } catch (IOException e2) {
                        throw new SVGParseException(e2);
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    if (this.d) {
                        try {
                            this.a.close();
                        } catch (IOException e4) {
                            cb1.c("SVGAndroid", "Error closing SVG input stream: " + e4.getMessage());
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                if (this.d) {
                    try {
                        this.a.close();
                    } catch (IOException e5) {
                        cb1.c("SVGAndroid", "Error closing SVG input stream: " + e5.getMessage());
                    }
                }
                throw th;
            }
        }
        throw new IllegalStateException("SVG input not specified. Call one of the readFrom...() methods first.");
    }

    public C0863b b(InputStream inputStream) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "415711837")) {
            return (C0863b) ipChange.ipc$dispatch("415711837", new Object[]{this, inputStream});
        }
        this.a = inputStream;
        return this;
    }
}
