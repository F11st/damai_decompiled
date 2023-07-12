package com.alibaba.aliweex.adapter.component;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.aliweex.a;
import com.alibaba.aliweex.adapter.adapter.WXImgLoaderAdapter;
import com.taobao.weex.common.Destroyable;
import com.taobao.weex.ui.view.WXImageView;
import tb.ds1;
import tb.m12;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class AliWXImageView extends WXImageView implements Destroyable {
    private m12 reference;

    public AliWXImageView(Context context) {
        super(context);
    }

    private void releaseDrawable() {
        m12 m12Var = this.reference;
        if (m12Var != null) {
            m12Var.b();
            this.reference = null;
        }
    }

    @Override // com.taobao.weex.common.Destroyable
    public void destroy() {
        try {
            if (getTag() instanceof ds1) {
                ((ds1) getTag()).cancel();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        releaseDrawable();
    }

    @Override // com.taobao.weex.ui.view.WXImageView, android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        releaseDrawable();
        super.setImageDrawable(drawable);
        if (drawable instanceof m12) {
            String config = a.l().c().getConfig(WXImgLoaderAdapter.WX_IMAGE_RELEASE_CONFIG, WXImgLoaderAdapter.WX_ALLOW_RELEASE_DOMAIN, "");
            if (TextUtils.isEmpty(config) || !TextUtils.equals("true", config)) {
                return;
            }
            this.reference = (m12) drawable;
        }
    }
}
