package com.alibaba.aliweex.adapter.module.blur;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.aliweex.utils.BlurTool;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.utils.WXLogUtils;

/* compiled from: Taobao */
/* renamed from: com.alibaba.aliweex.adapter.module.blur.a */
/* loaded from: classes5.dex */
class C3055a implements BlurAlgorithm {
    private boolean a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3055a(boolean z) {
        this.a = false;
        this.a = z;
    }

    @Override // com.alibaba.aliweex.adapter.module.blur.BlurAlgorithm
    @Nullable
    public Bitmap blur(Bitmap bitmap, int i) {
        int max = Math.max(0, Math.min(100, i));
        long currentTimeMillis = WXEnvironment.isApkDebugable() ? System.currentTimeMillis() : 0L;
        Bitmap bitmap2 = null;
        try {
            bitmap2 = BlurTool.f(bitmap, max, this.a);
        } catch (Exception e) {
            WXLogUtils.e("StackBlur", e.getMessage());
        }
        long currentTimeMillis2 = WXEnvironment.isApkDebugable() ? System.currentTimeMillis() : 0L;
        WXLogUtils.d("StackBlur", "blur time:" + (currentTimeMillis2 - currentTimeMillis) + "ms");
        return bitmap2;
    }

    @Override // com.alibaba.aliweex.adapter.module.blur.BlurAlgorithm
    public boolean canModifyBitmap() {
        return this.a;
    }

    @Override // com.alibaba.aliweex.adapter.module.blur.BlurAlgorithm
    @NonNull
    public Bitmap.Config getSupportedBitmapConfig() {
        return Bitmap.Config.ARGB_8888;
    }
}
