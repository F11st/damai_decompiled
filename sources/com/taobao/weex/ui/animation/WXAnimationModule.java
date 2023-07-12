package com.taobao.weex.ui.animation;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.ui.action.GraphicActionAnimation;
import com.taobao.weex.ui.component.WXComponent;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXAnimationModule extends WXModule {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class AnimationHolder {
        private String callback;
        private WXAnimationBean wxAnimationBean;

        public AnimationHolder(WXAnimationBean wXAnimationBean, String str) {
            this.wxAnimationBean = wXAnimationBean;
            this.callback = str;
        }

        public void execute(WXSDKInstance wXSDKInstance, WXComponent wXComponent) {
            if (wXSDKInstance == null || wXComponent == null) {
                return;
            }
            GraphicActionAnimation graphicActionAnimation = new GraphicActionAnimation(wXSDKInstance, wXComponent.getRef(), this.wxAnimationBean, this.callback);
            WXSDKManager.v().G().postGraphicAction(graphicActionAnimation.getPageId(), graphicActionAnimation);
        }
    }

    @JSMethod
    public void transition(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        WXSDKInstance wXSDKInstance;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (wXSDKInstance = this.mWXSDKInstance) == null) {
            return;
        }
        GraphicActionAnimation graphicActionAnimation = new GraphicActionAnimation(wXSDKInstance, str, str2, str3);
        WXSDKManager.v().G().postGraphicAction(graphicActionAnimation.getPageId(), graphicActionAnimation);
    }
}
