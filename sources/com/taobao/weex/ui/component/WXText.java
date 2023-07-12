package com.taobao.weex.ui.component;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.Layout;
import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.Component;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.common.Constants;
import com.taobao.weex.layout.ContentBoxMeasurement;
import com.taobao.weex.layout.measurefunc.TextContentBoxMeasurement;
import com.taobao.weex.ui.ComponentCreator;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.flat.FlatComponent;
import com.taobao.weex.ui.flat.widget.TextWidget;
import com.taobao.weex.ui.view.WXTextView;
import com.taobao.weex.utils.FontDO;
import com.taobao.weex.utils.TypefaceUtil;
import com.taobao.weex.utils.WXLogUtils;
import java.lang.reflect.InvocationTargetException;

/* compiled from: Taobao */
@Component(lazyload = false)
/* loaded from: classes11.dex */
public class WXText extends WXComponent<WXTextView> implements FlatComponent<TextWidget> {
    public static final int sDEFAULT_SIZE = 32;
    private String mFontFamily;
    private TextWidget mTextWidget;
    private BroadcastReceiver mTypefaceObserver;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class Creator implements ComponentCreator {
        @Override // com.taobao.weex.ui.ComponentCreator
        public WXComponent createInstance(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) throws IllegalAccessException, InvocationTargetException, InstantiationException {
            return new WXText(wXSDKInstance, wXVContainer, basicComponentData);
        }
    }

    @Deprecated
    public WXText(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, String str, boolean z, BasicComponentData basicComponentData) {
        this(wXSDKInstance, wXVContainer, basicComponentData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void forceRelayout() {
        WXBridgeManager.getInstance().post(new Runnable() { // from class: com.taobao.weex.ui.component.WXText.2
            @Override // java.lang.Runnable
            public void run() {
                ContentBoxMeasurement contentBoxMeasurement = WXText.this.contentBoxMeasurement;
                if (contentBoxMeasurement instanceof TextContentBoxMeasurement) {
                    ((TextContentBoxMeasurement) contentBoxMeasurement).forceRelayout();
                }
            }
        });
    }

    private void registerTypefaceObserver(String str) {
        if (WXEnvironment.getApplication() == null) {
            WXLogUtils.w("WXText", "ApplicationContent is null on register typeface observer");
            return;
        }
        this.mFontFamily = str;
        if (this.mTypefaceObserver != null) {
            return;
        }
        this.mTypefaceObserver = new BroadcastReceiver() { // from class: com.taobao.weex.ui.component.WXText.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                FontDO fontDO;
                String stringExtra = intent.getStringExtra(Constants.Name.FONT_FAMILY);
                if (!WXText.this.mFontFamily.equals(stringExtra) || (fontDO = TypefaceUtil.getFontDO(stringExtra)) == null || fontDO.getTypeface() == null || WXText.this.getHostView() == null) {
                    return;
                }
                Layout textLayout = WXText.this.getHostView().getTextLayout();
                if (textLayout != null) {
                    textLayout.getPaint().setTypeface(fontDO.getTypeface());
                } else {
                    WXLogUtils.d("WXText", "Layout not created");
                }
                WXBridgeManager.getInstance().markDirty(WXText.this.getInstanceId(), WXText.this.getRef(), true);
                WXText.this.forceRelayout();
            }
        };
        LocalBroadcastManager.getInstance(WXEnvironment.getApplication()).registerReceiver(this.mTypefaceObserver, new IntentFilter(TypefaceUtil.ACTION_TYPE_FACE_AVAILABLE));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public Object convertEmptyProperty(String str, Object obj) {
        str.hashCode();
        if (str.equals("color")) {
            return "black";
        }
        if (!str.equals("fontSize")) {
            return super.convertEmptyProperty(str, obj);
        }
        return 32;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public void createViewImpl() {
        if (promoteToView(true)) {
            super.createViewImpl();
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void destroy() {
        super.destroy();
        if (WXEnvironment.getApplication() == null || this.mTypefaceObserver == null) {
            return;
        }
        WXLogUtils.d("WXText", "Unregister the typeface observer");
        LocalBroadcastManager.getInstance(WXEnvironment.getApplication()).unregisterReceiver(this.mTypefaceObserver);
        this.mTypefaceObserver = null;
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public boolean isVirtualComponent() {
        return true ^ promoteToView(true);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected void layoutDirectionDidChanged(boolean z) {
        forceRelayout();
    }

    @Override // com.taobao.weex.ui.flat.FlatComponent
    public boolean promoteToView(boolean z) {
        if (getInstance().getFlatUIContext() != null) {
            return getInstance().getFlatUIContext().promoteToView(this, z, WXText.class);
        }
        return false;
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void refreshData(WXComponent wXComponent) {
        super.refreshData(wXComponent);
        if (wXComponent instanceof WXText) {
            updateExtra(wXComponent.getExtra());
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected void setAriaLabel(String str) {
        WXTextView hostView = getHostView();
        if (hostView != null) {
            hostView.setAriaLabel(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public boolean setProperty(String str, Object obj) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1550943582:
                if (str.equals(Constants.Name.FONT_STYLE)) {
                    c = 0;
                    break;
                }
                break;
            case -1224696685:
                if (str.equals(Constants.Name.FONT_FAMILY)) {
                    c = 1;
                    break;
                }
                break;
            case -1065511464:
                if (str.equals(Constants.Name.TEXT_ALIGN)) {
                    c = 2;
                    break;
                }
                break;
            case -879295043:
                if (str.equals(Constants.Name.TEXT_DECORATION)) {
                    c = 3;
                    break;
                }
                break;
            case -734428249:
                if (str.equals(Constants.Name.FONT_WEIGHT)) {
                    c = 4;
                    break;
                }
                break;
            case -515807685:
                if (str.equals(Constants.Name.LINE_HEIGHT)) {
                    c = 5;
                    break;
                }
                break;
            case 94842723:
                if (str.equals("color")) {
                    c = 6;
                    break;
                }
                break;
            case 102977279:
                if (str.equals(Constants.Name.LINES)) {
                    c = 7;
                    break;
                }
                break;
            case 111972721:
                if (str.equals("value")) {
                    c = '\b';
                    break;
                }
                break;
            case 261414991:
                if (str.equals(Constants.Name.TEXT_OVERFLOW)) {
                    c = '\t';
                    break;
                }
                break;
            case 365601008:
                if (str.equals("fontSize")) {
                    c = '\n';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case '\b':
            case '\t':
            case '\n':
                break;
            default:
                return super.setProperty(str, obj);
            case 1:
                if (obj != null) {
                    registerTypefaceObserver(obj.toString());
                    break;
                }
                break;
        }
        return true;
    }

    @Override // com.taobao.weex.ui.component.basic.WXBasicComponent
    public void updateExtra(Object obj) {
        super.updateExtra(obj);
        if (obj instanceof Layout) {
            Layout layout = (Layout) obj;
            if (!promoteToView(true)) {
                getOrCreateFlatWidget().updateTextDrawable(layout);
            } else if (getHostView() == null || obj.equals(getHostView().getTextLayout())) {
            } else {
                getHostView().setTextLayout(layout);
                getHostView().invalidate();
            }
        }
    }

    public WXText(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
        setContentBoxMeasurement(new TextContentBoxMeasurement(this));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.taobao.weex.ui.flat.FlatComponent
    @NonNull
    public TextWidget getOrCreateFlatWidget() {
        if (this.mTextWidget == null) {
            this.mTextWidget = new TextWidget(getInstance().getFlatUIContext());
        }
        return this.mTextWidget;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public WXTextView initComponentHostView(@NonNull Context context) {
        WXTextView wXTextView = new WXTextView(context);
        wXTextView.holdComponent(this);
        return wXTextView;
    }
}
