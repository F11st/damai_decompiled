package com.taobao.power_image.request;

import android.graphics.Bitmap;
import com.taobao.power_image.loader.PowerImageResult;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class PowerImageExternalRequest extends PowerImageBaseRequest {
    private boolean d;
    private Bitmap e;
    private int f;
    private int g;
    private int h;
    private int i;
    private long j;
    private int k;

    public PowerImageExternalRequest(Map<String, Object> map) {
        super(map);
    }

    @Override // com.taobao.power_image.request.PowerImageBaseRequest
    public Map<String, Object> b() {
        Map<String, Object> b = super.b();
        b.put("width", Integer.valueOf(this.f));
        b.put("height", Integer.valueOf(this.g));
        b.put("rowBytes", Integer.valueOf(this.i));
        b.put("length", Integer.valueOf(this.k));
        b.put("handle", Long.valueOf(this.j));
        b.put("flutterPixelFormat", Integer.valueOf(this.h));
        return b;
    }

    @Override // com.taobao.power_image.request.PowerImageBaseRequest
    void d(PowerImageResult powerImageResult) {
        c("PowerImageExternalRequest:onLoadResult(PowerImageResult result) result is null");
    }

    public native long getBitmapPixelsPtr(Bitmap bitmap);

    @Override // com.taobao.power_image.request.PowerImageBaseRequest
    public boolean h() {
        this.d = true;
        this.c = "releaseSucceed";
        releaseBitmapPixels(this.e);
        this.e = null;
        return true;
    }

    public native void releaseBitmapPixels(Bitmap bitmap);
}
