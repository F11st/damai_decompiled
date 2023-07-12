package com.xiaomi.push;

import com.youku.resource.widget.YKActionSheet;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import tb.kh1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class fq {
    private XmlPullParser a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fq() {
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            this.a = newPullParser;
            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        } catch (XmlPullParserException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public gn a(byte[] bArr, fw fwVar) {
        String name;
        String str;
        this.a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
        this.a.next();
        int eventType = this.a.getEventType();
        String name2 = this.a.getName();
        if (eventType == 2) {
            if (name2.equals("message")) {
                return gv.a(this.a);
            }
            if (name2.equals("iq")) {
                return gv.a(this.a, fwVar);
            }
            if (name2.equals("presence")) {
                return gv.m935a(this.a);
            }
            if (this.a.getName().equals(kh1.RESOURCE_STREAM)) {
                return null;
            }
            if (this.a.getName().equals("error")) {
                throw new gh(gv.m936a(this.a));
            }
            if (this.a.getName().equals(YKActionSheet.ACTION_STYLE_WARNING)) {
                this.a.next();
                name = this.a.getName();
                str = "multi-login";
            } else {
                name = this.a.getName();
                str = "bind";
            }
            name.equals(str);
            return null;
        }
        return null;
    }
}
