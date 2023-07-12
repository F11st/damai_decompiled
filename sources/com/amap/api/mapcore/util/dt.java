package com.amap.api.mapcore.util;

import android.text.TextUtils;
import com.alibaba.verificationsdk.ui.VerifyActivity;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileProvider;
import com.autonavi.base.amap.mapcore.MapConfig;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class dt implements TileProvider {
    Random a = new Random();
    private final int b;
    private final int c;
    private MapConfig d;

    public dt(int i, int i2, MapConfig mapConfig) {
        this.b = i;
        this.c = i2;
        this.d = mapConfig;
    }

    private byte[] a(int i, int i2, int i3, String str) throws IOException {
        try {
            return new C4523a(i, i2, i3, str).makeHttpRequest();
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final Tile getTile(int i, int i2, int i3) {
        try {
            MapConfig mapConfig = this.d;
            byte[] a = a(i, i2, i3, mapConfig != null ? mapConfig.getMapLanguage() : "zh_cn");
            if (a == null) {
                return TileProvider.NO_TILE;
            }
            return Tile.obtain(this.b, this.c, a);
        } catch (IOException unused) {
            return TileProvider.NO_TILE;
        }
    }

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileHeight() {
        return this.c;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileWidth() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.dt$a */
    /* loaded from: classes10.dex */
    public class C4523a extends AbstractC4517dp {
        private int e;
        private int f;
        private int g;
        private String h;
        private String i;

        public C4523a(int i, int i2, int i3, String str) {
            this.i = "";
            this.e = i;
            this.f = i2;
            this.g = i3;
            this.h = str;
            this.i = e();
            setProxy(gl.a(C4640t.a));
            setConnectionTimeout(5000);
            setSoTimeout(VerifyActivity.ALIAUTH_CLIENT_ERROR_GENERIC);
        }

        private String a() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=");
            stringBuffer.append(C4554gc.f(C4640t.a));
            stringBuffer.append("&channel=amapapi");
            if (!ej.a(this.e, this.f, this.g) && this.g >= 6) {
                if (MapsInitializer.isLoadWorldGridMap()) {
                    stringBuffer.append("&x=");
                    stringBuffer.append(this.e);
                    stringBuffer.append("&y=");
                    stringBuffer.append(this.f);
                    stringBuffer.append("&z=");
                    stringBuffer.append(this.g);
                    stringBuffer.append("&ds=0");
                    stringBuffer.append("&dpitype=webrd");
                    stringBuffer.append("&lang=");
                    stringBuffer.append(this.h);
                    stringBuffer.append("&scale=2");
                }
            } else {
                stringBuffer.append("&z=");
                stringBuffer.append(this.g);
                stringBuffer.append("&x=");
                stringBuffer.append(this.e);
                stringBuffer.append("&y=");
                stringBuffer.append(this.f);
                stringBuffer.append("&lang=en&size=1&scale=1&style=7");
            }
            String stringBuffer2 = stringBuffer.toString();
            String a = a(stringBuffer2);
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(stringBuffer2);
            String a2 = gf.a();
            stringBuffer3.append("&ts=" + a2);
            stringBuffer3.append("&scode=" + gf.a(C4640t.a, a2, a));
            return stringBuffer3.toString();
        }

        private String b(String str) {
            if (str == null) {
                return str;
            }
            try {
                return URLDecoder.decode(str, "utf-8");
            } catch (UnsupportedEncodingException e) {
                hd.c(e, "AbstractProtocalHandler", "strReEncoder");
                return "";
            } catch (Exception e2) {
                hd.c(e2, "AbstractProtocalHandler", "strReEncoderException");
                return "";
            }
        }

        private String e() {
            if (!ej.a(this.e, this.f, this.g) && this.g >= 6) {
                if (MapsInitializer.isLoadWorldGridMap()) {
                    return "http://restapi.amap.com/v4/gridmap?";
                }
                return null;
            }
            return String.format(Locale.US, "http://wprd0%d.is.autonavi.com/appmaptile?", Integer.valueOf((dt.this.a.nextInt(100000) % 4) + 1));
        }

        @Override // com.amap.api.mapcore.util.ii
        public String getIPV6URL() {
            return getURL();
        }

        @Override // com.amap.api.mapcore.util.AbstractC4517dp, com.amap.api.mapcore.util.ii
        public Map<String, String> getParams() {
            return null;
        }

        @Override // com.amap.api.mapcore.util.ii
        public Map<String, String> getRequestHead() {
            Hashtable hashtable = new Hashtable(16);
            hashtable.put(IRequestConst.USER_AGENT, C4614m.c);
            hashtable.put("Accept-Encoding", "gzip");
            hashtable.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", "7.4.0", "3dmap"));
            hashtable.put("x-INFO", gf.a(C4640t.a));
            hashtable.put("key", C4554gc.f(C4640t.a));
            hashtable.put("logversion", "2.1");
            return hashtable;
        }

        @Override // com.amap.api.mapcore.util.ii
        public String getURL() {
            if (TextUtils.isEmpty(this.i)) {
                return null;
            }
            return this.i + a();
        }

        @Override // com.amap.api.mapcore.util.ii
        public boolean isSupportIPV6() {
            return false;
        }

        private String a(String str) {
            String[] split = str.split("&");
            Arrays.sort(split);
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(b(str2));
                stringBuffer.append("&");
            }
            String stringBuffer2 = stringBuffer.toString();
            return stringBuffer2.length() > 1 ? (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1) : str;
        }
    }
}
