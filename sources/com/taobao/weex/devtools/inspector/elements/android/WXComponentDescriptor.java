package com.taobao.weex.devtools.inspector.elements.android;

import android.text.TextUtils;
import android.view.View;
import com.taobao.weex.common.Constants;
import com.taobao.weex.devtools.common.Accumulator;
import com.taobao.weex.devtools.common.StringUtil;
import com.taobao.weex.devtools.inspector.elements.AbstractChainedDescriptor;
import com.taobao.weex.devtools.inspector.elements.AttributeAccumulator;
import com.taobao.weex.devtools.inspector.elements.StyleAccumulator;
import com.taobao.weex.devtools.inspector.elements.W3CStyleConstants;
import com.taobao.weex.ui.component.WXA;
import com.taobao.weex.ui.component.WXBasicComponentType;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXDiv;
import com.taobao.weex.ui.component.WXEmbed;
import com.taobao.weex.ui.component.WXHeader;
import com.taobao.weex.ui.component.WXImage;
import com.taobao.weex.ui.component.WXInput;
import com.taobao.weex.ui.component.WXLoading;
import com.taobao.weex.ui.component.WXScroller;
import com.taobao.weex.ui.component.WXSlider;
import com.taobao.weex.ui.component.WXSwitch;
import com.taobao.weex.ui.component.WXText;
import com.taobao.weex.ui.component.WXVContainer;
import com.taobao.weex.ui.component.WXVideo;
import com.taobao.weex.ui.component.list.HorizontalListComponent;
import com.taobao.weex.ui.component.list.WXCell;
import com.taobao.weex.ui.component.list.WXListComponent;
import com.taobao.weex.ui.view.WXEditText;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXComponentDescriptor extends AbstractChainedDescriptor<WXComponent> implements HighlightableDescriptor {
    private static HashMap<Class, String> sClassName;

    static {
        HashMap<Class, String> hashMap = new HashMap<>();
        sClassName = hashMap;
        hashMap.put(WXComponent.class, "component");
        sClassName.put(WXText.class, "text");
        sClassName.put(WXVContainer.class, "container");
        sClassName.put(WXDiv.class, WXBasicComponentType.DIV);
        sClassName.put(WXEditText.class, WXBasicComponentType.TEXTAREA);
        sClassName.put(WXA.class, "a");
        sClassName.put(WXInput.class, "input");
        sClassName.put(WXLoading.class, "loading");
        sClassName.put(WXScroller.class, WXBasicComponentType.SCROLLER);
        sClassName.put(WXSwitch.class, "switch");
        sClassName.put(WXSlider.class, "slider");
        sClassName.put(WXVideo.class, "video");
        sClassName.put(WXImage.class, "image");
        sClassName.put(WXHeader.class, "header");
        sClassName.put(WXEmbed.class, WXBasicComponentType.EMBED);
        sClassName.put(WXListComponent.class, "list");
        sClassName.put(HorizontalListComponent.class, WXBasicComponentType.HLIST);
        sClassName.put(WXCell.class, WXBasicComponentType.CELL);
    }

    private static boolean filter(String str) {
        if (str != null) {
            String lowerCase = str.toLowerCase();
            return (lowerCase.contains(Constants.Name.PADDING) || lowerCase.contains(Constants.Name.MARGIN) || lowerCase.contains("width") || lowerCase.contains("height") || lowerCase.contains("left") || lowerCase.contains("right") || lowerCase.contains("top") || lowerCase.contains("bottom")) ? false : true;
        }
        return false;
    }

    public HashMap<String, String> getAttribute(WXComponent wXComponent) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (Map.Entry<String, Object> entry : wXComponent.getAttrs().entrySet()) {
            if (entry.getValue() != null) {
                hashMap.put(entry.getKey(), entry.getValue().toString());
            }
        }
        return hashMap;
    }

    public HashMap<String, String> getStyles(WXComponent wXComponent) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (Map.Entry<String, Object> entry : wXComponent.getStyles().entrySet()) {
            if (entry.getValue() != null) {
                hashMap.put(entry.getKey(), entry.getValue().toString());
            }
        }
        return hashMap;
    }

    @Override // com.taobao.weex.devtools.inspector.elements.android.HighlightableDescriptor
    @Nullable
    public View getViewForHighlighting(Object obj) {
        return ((WXComponent) obj).getRealView();
    }

    /* renamed from: onGetChildren  reason: avoid collision after fix types in other method */
    protected void onGetChildren2(WXComponent wXComponent, Accumulator<Object> accumulator) {
    }

    @Override // com.taobao.weex.devtools.inspector.elements.AbstractChainedDescriptor
    protected /* bridge */ /* synthetic */ void onGetChildren(WXComponent wXComponent, Accumulator accumulator) {
        onGetChildren2(wXComponent, (Accumulator<Object>) accumulator);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.devtools.inspector.elements.AbstractChainedDescriptor
    public void onGetAttributes(WXComponent wXComponent, AttributeAccumulator attributeAccumulator) {
        HashMap<String, String> attribute = getAttribute(wXComponent);
        if (attribute != null && attribute.size() > 0) {
            for (Map.Entry<String, String> entry : attribute.entrySet()) {
                attributeAccumulator.store(entry.getKey(), entry.getValue());
            }
        }
        View realView = wXComponent.getRealView();
        if (realView == null || realView.isShown()) {
            return;
        }
        attributeAccumulator.store("visibility", String.valueOf(realView.isShown()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.devtools.inspector.elements.AbstractChainedDescriptor
    public String onGetNodeName(WXComponent wXComponent) {
        Class<?> cls = wXComponent.getClass();
        String str = sClassName.get(cls);
        return TextUtils.isEmpty(str) ? StringUtil.removePrefix(cls.getSimpleName(), "WX") : str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.devtools.inspector.elements.AbstractChainedDescriptor
    public void onGetStyles(WXComponent wXComponent, StyleAccumulator styleAccumulator) {
        HashMap<String, String> styles = getStyles(wXComponent);
        if (styles != null && styles.size() > 0) {
            for (Map.Entry<String, String> entry : styles.entrySet()) {
                styleAccumulator.store(W3CStyleConstants.V_PREFIX + entry.getKey(), entry.getValue(), false);
                if (filter(entry.getKey())) {
                    styleAccumulator.store(entry.getKey(), entry.getValue(), false);
                }
            }
        }
        View realView = wXComponent.getRealView();
        if (realView != null) {
            styleAccumulator.store("left", String.valueOf(realView.getLeft()), false);
            styleAccumulator.store("top", String.valueOf(realView.getTop()), false);
            styleAccumulator.store("right", String.valueOf(realView.getRight()), false);
            styleAccumulator.store("bottom", String.valueOf(realView.getBottom()), false);
            styleAccumulator.store("width", String.valueOf(realView.getWidth()), false);
            styleAccumulator.store("height", String.valueOf(realView.getHeight()), false);
            if (realView.getPaddingTop() != 0 || realView.getPaddingBottom() != 0 || realView.getPaddingLeft() != 0 || realView.getPaddingRight() != 0) {
                styleAccumulator.store(W3CStyleConstants.PADDING_LEFT, String.valueOf(realView.getPaddingLeft()), false);
                styleAccumulator.store(W3CStyleConstants.PADDING_TOP, String.valueOf(realView.getPaddingTop()), false);
                styleAccumulator.store(W3CStyleConstants.PADDING_RIGHT, String.valueOf(realView.getPaddingRight()), false);
                styleAccumulator.store(W3CStyleConstants.PADDING_BOTTOM, String.valueOf(realView.getPaddingBottom()), false);
            }
            styleAccumulator.store("visibility", String.valueOf(realView.isShown()), false);
        }
    }
}
