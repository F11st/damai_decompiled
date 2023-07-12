package com.alibaba.aliweex.adapter.component;

import android.widget.ImageView;
import androidx.annotation.RestrictTo;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.dom.WXImageQuality;
import com.taobao.weex.ui.ComponentCreator;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXVContainer;
import java.lang.reflect.InvocationTargetException;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class AliGifImage extends AliWXImage {

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public static class a implements ComponentCreator {
        @Override // com.taobao.weex.ui.ComponentCreator
        /* renamed from: a */
        public AliGifImage createInstance(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) throws IllegalAccessException, InvocationTargetException, InstantiationException {
            return new AliGifImage(wXSDKInstance, wXVContainer, basicComponentData);
        }
    }

    public AliGifImage(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
    }

    @Override // com.taobao.weex.ui.component.WXImage
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    protected WXImageQuality getImageQuality() {
        return WXImageQuality.ORIGINAL;
    }

    @Override // com.taobao.weex.ui.component.WXImage
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    protected ImageView.ScaleType getResizeMode(String str) {
        return ImageView.ScaleType.FIT_CENTER;
    }
}
