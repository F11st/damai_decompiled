package com.alibaba.aliweex.adapter.component;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.alibaba.aliweex.C3004a;
import com.alibaba.aliweex.IConfigAdapter;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.ui.ComponentCreator;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXImage;
import com.taobao.weex.ui.component.WXVContainer;
import java.lang.reflect.InvocationTargetException;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class AliWXImage extends WXImage {
    private static final String CONFIG_GROUP = "AliWXImageView";

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.aliweex.adapter.component.AliWXImage$a */
    /* loaded from: classes5.dex */
    public static class C3024a implements ComponentCreator {
        @Override // com.taobao.weex.ui.ComponentCreator
        public WXComponent createInstance(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) throws IllegalAccessException, InvocationTargetException, InstantiationException {
            return new AliWXImage(wXSDKInstance, wXVContainer, basicComponentData);
        }
    }

    public AliWXImage(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
    }

    private boolean getConfigEnableBitmapAutoManage() {
        if (isBlackHC()) {
            return false;
        }
        IConfigAdapter c = C3004a.l().c();
        if (c != null ? TextUtils.equals("true", c.getConfig(CONFIG_GROUP, "globalEnableBitmapAutoManage", "false")) : false) {
            return true;
        }
        if (!isMainHC() || c == null) {
            return c != null && TextUtils.equals("true", c.getConfig(CONFIG_GROUP, "normalEnableBitmapAutoManage", "false"));
        }
        return TextUtils.equals("true", c.getConfig(CONFIG_GROUP, "hcEnableBitmapAutoManage", "false"));
    }

    private boolean isBlackHC() {
        String[] split;
        if (getInstance() == null) {
            return false;
        }
        String bundleUrl = getInstance().getBundleUrl();
        if (TextUtils.isEmpty(bundleUrl)) {
            return false;
        }
        try {
            String config = C3004a.l().c().getConfig(CONFIG_GROUP, "black_domain", "");
            if (!TextUtils.isEmpty(config)) {
                for (String str : config.split(",")) {
                    if (!TextUtils.isEmpty(bundleUrl) && bundleUrl.contains(str)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean isMainHC() {
        String[] split;
        if (getInstance() == null) {
            return false;
        }
        String bundleUrl = getInstance().getBundleUrl();
        if (TextUtils.isEmpty(bundleUrl)) {
            return false;
        }
        try {
            String config = C3004a.l().c().getConfig(CONFIG_GROUP, "hc_domain", "");
            if (!TextUtils.isEmpty(config)) {
                for (String str : config.split(",")) {
                    if (!TextUtils.isEmpty(bundleUrl) && bundleUrl.contains(str)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean isOpenBitmapSwitch() {
        IConfigAdapter c;
        return (getInstance() == null || (c = C3004a.l().c()) == null || !TextUtils.equals("true", c.getConfig(CONFIG_GROUP, "switch_open", ""))) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXImage, com.taobao.weex.ui.component.WXComponent
    public ImageView initComponentHostView(@NonNull Context context) {
        AliWXImageView aliWXImageView = new AliWXImageView(context);
        if (isOpenBitmapSwitch()) {
            aliWXImageView.setEnableBitmapAutoManage(getConfigEnableBitmapAutoManage());
        }
        aliWXImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        if (Build.VERSION.SDK_INT >= 16) {
            aliWXImageView.setCropToPadding(true);
        }
        aliWXImageView.holdComponent((WXImage) this);
        return aliWXImageView;
    }
}
