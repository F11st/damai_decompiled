package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.MotionEventCompat;
import com.amap.api.mapcore.util.dg;
import com.amap.api.maps.model.CustomMapStyleOptions;
import com.amap.api.maps.model.MyTrafficStyle;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.FileUtil;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.autonavi.base.amap.mapcore.tools.GLFileUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class b implements dg.a {
    private IAMapDelegate a;
    private CustomMapStyleOptions b;
    private Context h;
    private boolean n;
    private boolean o;
    private dg s;
    private dg t;
    private boolean x;
    private a z;
    private boolean c = false;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    private int g = 1;
    private byte[] i = null;
    private byte[] j = null;
    private byte[] k = null;
    private byte[] l = null;
    private byte[] m = null;
    private boolean p = false;
    private boolean q = false;
    private boolean r = false;
    private byte[] u = null;
    private byte[] v = null;
    private boolean w = false;
    private MyTrafficStyle y = new MyTrafficStyle();

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface a {
        void a(byte[] bArr);
    }

    public b(IAMapDelegate iAMapDelegate, Context context, boolean z) {
        this.n = false;
        this.o = false;
        this.x = false;
        this.a = iAMapDelegate;
        this.h = context;
        this.n = false;
        this.o = false;
        this.x = z;
    }

    private void b(byte[] bArr) {
        dk a2;
        JSONObject optJSONObject;
        if (bArr == null || (a2 = dn.a(bArr)) == null || a2.a() == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(a2.a());
            JSONObject optJSONObject2 = jSONObject.optJSONObject("bg");
            String str = null;
            boolean z = true;
            if (optJSONObject2 != null) {
                z = optJSONObject2.optBoolean("visible", true);
                str = optJSONObject2.optString("lineColor", null);
            }
            a(str, z);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("traffic");
            if (optJSONObject3 == null || (optJSONObject = optJSONObject3.optJSONObject("multiFillColors")) == null) {
                return;
            }
            int a3 = dn.a(optJSONObject.optString("smooth"));
            int a4 = dn.a(optJSONObject.optString("slow"));
            int a5 = dn.a(optJSONObject.optString("congested"));
            int a6 = dn.a(optJSONObject.optString("seriousCongested"));
            this.y.setSmoothColor(a3);
            this.y.setSlowColor(a4);
            this.y.setCongestedColor(a5);
            this.y.setSeriousCongestedColor(a6);
            IAMapDelegate iAMapDelegate = this.a;
            if (iAMapDelegate == null || iAMapDelegate.getGLMapEngine() == null) {
                return;
            }
            this.a.getGLMapEngine().setTrafficStyle(this.g, this.y.getSmoothColor(), this.y.getSlowColor(), this.y.getCongestedColor(), this.y.getSeriousCongestedColor(), true);
        } catch (Throwable th) {
            hd.c(th, "AMapCustomStyleManager", "setExtraStyle");
            eq.a(th);
        }
    }

    private boolean c(byte[] bArr) {
        if (bArr == null) {
            return true;
        }
        try {
        } catch (Throwable th) {
            hd.c(th, "AMapCustomStyleManager", "checkData");
            eq.a(th);
        }
        if (bArr.length < 8) {
            return false;
        }
        return ((bArr[4] & 255) | ((((bArr[7] << 24) & (-16777216)) | ((bArr[6] << 16) & 16711680)) | ((bArr[5] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK))) == 2000;
    }

    private void f() {
        IAMapDelegate iAMapDelegate = this.a;
        if (iAMapDelegate != null && iAMapDelegate.getGLMapEngine() != null && this.k != null) {
            this.a.getGLMapEngine().setBackgroundTexture(this.g, this.k);
        }
        IAMapDelegate iAMapDelegate2 = this.a;
        if (iAMapDelegate2 != null && iAMapDelegate2.getGLMapEngine() != null) {
            this.a.getGLMapEngine().setTrafficStyle(this.g, 0, 0, 0, 0, false);
        }
        this.r = false;
    }

    private void g() {
        if (this.x) {
            if (this.j == null) {
                Context context = this.h;
                this.j = a(FileUtil.readFileContentsFromAssets(context, AMapEngineUtils.MAP_MAP_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_STYLE_DATA_ABROAD));
            }
        } else if (this.j == null) {
            Context context2 = this.h;
            this.j = a(FileUtil.readFileContentsFromAssets(context2, AMapEngineUtils.MAP_MAP_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_STYLE_DATA));
        }
        this.a.getGLMapEngine().setCustomStyleData(this.g, this.j, this.i);
        this.q = false;
    }

    private void h() {
        if (this.p) {
            if (this.l == null) {
                Context context = this.h;
                this.l = FileUtil.readFileContentsFromAssets(context, AMapEngineUtils.MAP_MAP_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_ICON_5_NAME_FOR_CUSTOM);
            }
            this.p = false;
            this.a.getGLMapEngine().setCustomStyleTexture(this.g, this.l);
        }
    }

    private void i() {
        CustomMapStyleOptions customMapStyleOptions = this.b;
        if (customMapStyleOptions != null) {
            customMapStyleOptions.setStyleId(null);
            this.b.setStyleDataPath(null);
            this.b.setStyleData(null);
            this.b.setStyleTexturePath(null);
            this.b.setStyleTextureData(null);
            this.b.setStyleExtraData(null);
            this.b.setStyleExtraPath(null);
        }
    }

    public void a() {
        IAMapDelegate iAMapDelegate;
        if (this.b == null || this.o) {
            return;
        }
        try {
            MapConfig mapConfig = this.a.getMapConfig();
            if (mapConfig == null) {
                return;
            }
            synchronized (this) {
                if (mapConfig.isHideLogoEnable() && (iAMapDelegate = this.a) != null && iAMapDelegate.getUiSettings() != null) {
                    if (this.a.getUiSettings().isLogoEnable()) {
                        if (this.b.isEnable()) {
                            if (this.q) {
                                this.a.getUiSettings().setLogoEnable(false);
                            }
                        } else {
                            this.a.getUiSettings().setLogoEnable(true);
                        }
                    } else if (!this.q) {
                        this.a.getUiSettings().setLogoEnable(true);
                    }
                }
                if (this.c) {
                    if (this.b.isEnable()) {
                        this.a.getGLMapEngine().setNativeMapModeAndStyle(this.g, 0, 0, 0, false, false, null);
                        mapConfig.setCustomStyleEnable(true);
                        this.c = false;
                    } else {
                        this.a.getGLMapEngine().setNativeMapModeAndStyle(this.g, mapConfig.getMapStyleMode(), mapConfig.getMapStyleTime(), mapConfig.getMapStyleState(), false, false, null);
                        this.q = false;
                        if (mapConfig.isCustomStyleEnable()) {
                            if (mapConfig.getMapStyleMode() == 0 && mapConfig.getMapStyleTime() == 0 && mapConfig.getMapStyleState() == 0) {
                                g();
                            }
                            h();
                            if (this.r) {
                                f();
                            }
                            mapConfig.setCustomStyleEnable(false);
                        }
                        this.c = false;
                        return;
                    }
                }
                if (this.e) {
                    String styleTexturePath = this.b.getStyleTexturePath();
                    if (this.b.getStyleTextureData() == null && !TextUtils.isEmpty(styleTexturePath)) {
                        this.b.setStyleTextureData(FileUtil.readFileContents(styleTexturePath));
                    }
                    if (this.b.getStyleTextureData() != null) {
                        this.w = true;
                        if (mapConfig.isProFunctionAuthEnable()) {
                            this.p = true;
                            this.a.getGLMapEngine().setCustomStyleTexture(this.g, this.b.getStyleTextureData());
                            mapConfig.setUseProFunction(true);
                        } else {
                            h();
                        }
                    } else {
                        h();
                        this.w = false;
                    }
                    this.e = false;
                }
                if (this.d) {
                    String styleDataPath = this.b.getStyleDataPath();
                    if (this.b.getStyleData() == null && !TextUtils.isEmpty(styleDataPath)) {
                        this.b.setStyleData(FileUtil.readFileContents(styleDataPath));
                    }
                    if (this.b.getStyleData() == null && this.u == null) {
                        if (this.q) {
                            this.c = true;
                            this.b.setEnable(false);
                        }
                        this.d = false;
                    }
                    if (this.m == null) {
                        Context context = this.h;
                        this.m = a(FileUtil.readFileContentsFromAssets(context, AMapEngineUtils.MAP_MAP_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_STYLE_DATA_0_FOR_TEXTURE));
                    }
                    byte[] bArr = this.u;
                    if (bArr == null) {
                        bArr = this.b.getStyleData();
                    }
                    if (!c(bArr)) {
                        ds.a();
                    } else {
                        this.a.getGLMapEngine().setCustomStyleData(this.g, bArr, this.m);
                        this.q = true;
                        IAMapDelegate iAMapDelegate2 = this.a;
                        if (iAMapDelegate2 != null) {
                            iAMapDelegate2.resetRenderTime();
                        }
                    }
                    this.d = false;
                }
                if (this.f) {
                    String styleExtraPath = this.b.getStyleExtraPath();
                    if (this.b.getStyleExtraData() == null && !TextUtils.isEmpty(styleExtraPath)) {
                        this.b.setStyleExtraData(FileUtil.readFileContents(styleExtraPath));
                    }
                    if (this.b.getStyleExtraData() != null || this.v != null) {
                        byte[] bArr2 = this.v;
                        if (bArr2 == null) {
                            bArr2 = this.b.getStyleExtraData();
                        }
                        if (bArr2 != null) {
                            b(bArr2);
                            this.r = true;
                        }
                    }
                    this.f = false;
                }
            }
        } catch (Throwable th) {
            hd.c(th, "AMapCustomStyleManager", "updateStyle");
            eq.a(th);
        }
    }

    public boolean d() {
        return this.b != null;
    }

    public void e() {
        synchronized (this) {
            CustomMapStyleOptions customMapStyleOptions = this.b;
            if (customMapStyleOptions != null) {
                customMapStyleOptions.setEnable(false);
                i();
                this.c = true;
            }
        }
    }

    public void c() {
        if (this.b == null) {
            this.b = new CustomMapStyleOptions();
        }
    }

    public void b() {
        if (this.b == null) {
            return;
        }
        synchronized (this) {
            IAMapDelegate iAMapDelegate = this.a;
            if (iAMapDelegate != null && iAMapDelegate.getMapConfig() != null && !this.a.getMapConfig().isProFunctionAuthEnable()) {
                this.b.setStyleId(null);
                this.u = null;
                this.v = null;
            }
            this.e = true;
            this.d = true;
            if (this.r) {
                this.f = true;
            }
            this.c = true;
        }
    }

    private void a(String str, boolean z) {
        boolean z2;
        int a2 = !TextUtils.isEmpty(str) ? dn.a(str) : Integer.MIN_VALUE;
        IAMapDelegate iAMapDelegate = this.a;
        if (iAMapDelegate == null || iAMapDelegate.getGLMapEngine() == null) {
            return;
        }
        if (this.k == null) {
            Context context = this.h;
            this.k = FileUtil.readFileContentsFromAssets(context, AMapEngineUtils.MAP_MAP_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_BACKGROUND_NAME);
        }
        byte[] bArr = this.k;
        if (bArr != null) {
            if (!z) {
                a2 = 0;
            } else if (a2 == Integer.MIN_VALUE) {
                z2 = true;
                this.a.getGLMapEngine().setBackgroundTexture(this.g, eq.a((byte[]) bArr.clone(), 0, a2, z2));
            }
            z2 = false;
            this.a.getGLMapEngine().setBackgroundTexture(this.g, eq.a((byte[]) bArr.clone(), 0, a2, z2));
        }
    }

    public void a(CustomMapStyleOptions customMapStyleOptions) {
        IAMapDelegate iAMapDelegate;
        if (this.b == null || customMapStyleOptions == null) {
            return;
        }
        synchronized (this) {
            if (!this.n) {
                this.n = true;
                if (this.b.isEnable()) {
                    this.c = true;
                }
            }
            if (this.b.isEnable() != customMapStyleOptions.isEnable()) {
                this.b.setEnable(customMapStyleOptions.isEnable());
                this.c = true;
                eo.b(this.h, customMapStyleOptions.isEnable());
            }
            if (this.b.isEnable()) {
                if (!TextUtils.equals(this.b.getStyleId(), customMapStyleOptions.getStyleId())) {
                    this.b.setStyleId(customMapStyleOptions.getStyleId());
                    String styleId = this.b.getStyleId();
                    if (!TextUtils.isEmpty(styleId) && (iAMapDelegate = this.a) != null && iAMapDelegate.getMapConfig() != null && this.a.getMapConfig().isProFunctionAuthEnable()) {
                        if (this.s == null) {
                            if (this.x) {
                                this.s = new dg(this.h, this, 2, "abroad_sdk_json_sdk_700_zip");
                            } else {
                                this.s = new dg(this.h, this, 1, "sdk_700");
                            }
                        }
                        this.s.a(styleId);
                        this.s.b();
                        if (this.t == null) {
                            this.t = new dg(this.h, this, 0, null);
                        }
                        this.t.a(styleId);
                        this.t.b();
                    }
                }
                if (!TextUtils.equals(this.b.getStyleDataPath(), customMapStyleOptions.getStyleDataPath())) {
                    this.b.setStyleDataPath(customMapStyleOptions.getStyleDataPath());
                    this.d = true;
                }
                if (this.b.getStyleData() != customMapStyleOptions.getStyleData()) {
                    this.b.setStyleData(customMapStyleOptions.getStyleData());
                    this.d = true;
                }
                if (!TextUtils.equals(this.b.getStyleTexturePath(), customMapStyleOptions.getStyleTexturePath())) {
                    this.b.setStyleTexturePath(customMapStyleOptions.getStyleTexturePath());
                    this.e = true;
                }
                if (this.b.getStyleTextureData() != customMapStyleOptions.getStyleTextureData()) {
                    this.b.setStyleTextureData(customMapStyleOptions.getStyleTextureData());
                    this.e = true;
                }
                if (!TextUtils.equals(this.b.getStyleExtraPath(), customMapStyleOptions.getStyleExtraPath())) {
                    this.b.setStyleExtraPath(customMapStyleOptions.getStyleExtraPath());
                    this.f = true;
                }
                if (this.b.getStyleExtraData() != customMapStyleOptions.getStyleExtraData()) {
                    this.b.setStyleExtraData(customMapStyleOptions.getStyleExtraData());
                    this.f = true;
                }
                eo.a(this.h, true);
            } else {
                i();
                eo.a(this.h, false);
            }
        }
    }

    public static byte[] a(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        } catch (Throwable th) {
            th = th;
            gZIPInputStream = null;
        }
        try {
            byte[] bArr2 = new byte[256];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read >= 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                eq.a(th);
                th.printStackTrace();
                return null;
            } finally {
                GLFileUtil.closeQuietly(byteArrayOutputStream);
                GLFileUtil.closeQuietly(byteArrayInputStream);
                GLFileUtil.closeQuietly(gZIPInputStream);
            }
        }
    }

    @Override // com.amap.api.mapcore.util.dg.a
    public void a(byte[] bArr, int i) {
        MapConfig mapConfig;
        a aVar;
        if (this.b != null) {
            synchronized (this) {
                IAMapDelegate iAMapDelegate = this.a;
                if (iAMapDelegate != null && (mapConfig = iAMapDelegate.getMapConfig()) != null && mapConfig.isProFunctionAuthEnable()) {
                    mapConfig.setUseProFunction(true);
                    if (i == 1) {
                        this.u = bArr;
                        this.d = true;
                    } else if (i == 0) {
                        this.v = bArr;
                        this.f = true;
                    } else if (i == 2) {
                        String str = this.b.getStyleId() + "_sdk_700.data";
                        String str2 = this.b.getStyleId() + "_abroad_sdk.json";
                        Map<String, byte[]> uncompressToByteWithKeys = FileUtil.uncompressToByteWithKeys(bArr, new String[]{str, str2});
                        if (uncompressToByteWithKeys != null) {
                            byte[] bArr2 = uncompressToByteWithKeys.get(str);
                            if (bArr2 != null) {
                                this.u = bArr2;
                                this.d = true;
                            }
                            byte[] bArr3 = uncompressToByteWithKeys.get(str2);
                            if (bArr3 != null && (aVar = this.z) != null) {
                                aVar.a(bArr3);
                            }
                        }
                    }
                }
            }
        }
    }

    public void a(a aVar) {
        this.z = aVar;
    }
}
