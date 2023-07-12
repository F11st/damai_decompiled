package android.taobao.windvane.xmlmanager;

import android.content.res.XmlResourceParser;
import android.taobao.windvane.util.TaoLog;
import java.lang.reflect.Constructor;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
class WVFileParser {
    private Constructor<?> xmlBlockConstructor;

    public WVFileParser() {
        init();
    }

    private void init() {
        try {
            this.xmlBlockConstructor = Class.forName("android.content.res.XmlBlock").getConstructor(byte[].class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public XmlPullParser openXmlResourceParser(String str) {
        byte[] bArr;
        if (this.xmlBlockConstructor == null) {
            return null;
        }
        try {
            bArr = WVInputStreamUtils.InputStreamTOByte(WVXmlResUtils.class.getResourceAsStream(str));
        } catch (Exception e) {
            TaoLog.e("Read Error", e.toString());
            bArr = null;
        }
        if (bArr != null && bArr.length != 0) {
            try {
                Object invoke = WVReflectUtils.invoke(this.xmlBlockConstructor.newInstance(bArr), "newParser", new Object[0]);
                if (invoke instanceof XmlResourceParser) {
                    return (XmlResourceParser) invoke;
                }
            } catch (Exception e2) {
                TaoLog.e("Read Error", e2.toString());
            }
        }
        return null;
    }
}
