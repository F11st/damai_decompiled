package com.taobao.weex.ui.component.richtext;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.layout.measurefunc.TextContentBoxMeasurement;
import com.taobao.weex.ui.ComponentCreator;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXText;
import com.taobao.weex.ui.component.WXVContainer;
import com.taobao.weex.ui.component.richtext.node.RichTextNode;
import com.taobao.weex.ui.component.richtext.node.RichTextNodeManager;
import com.taobao.weex.ui.view.WXTextView;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXRichText extends WXText {
    private List<RichTextNode> nodes;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class Creator implements ComponentCreator {
        @Override // com.taobao.weex.ui.ComponentCreator
        public WXComponent createInstance(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) throws IllegalAccessException, InvocationTargetException, InstantiationException {
            return new WXRichText(wXSDKInstance, wXVContainer, basicComponentData);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    static class RichTextContentBoxMeasurement extends TextContentBoxMeasurement {
        public RichTextContentBoxMeasurement(WXComponent wXComponent) {
            super(wXComponent);
        }

        @Override // com.taobao.weex.layout.measurefunc.TextContentBoxMeasurement
        @NonNull
        protected Spanned createSpanned(String str) {
            if (TextUtils.isEmpty(str)) {
                Spannable span = ((WXRichText) this.mComponent).toSpan();
                updateSpannable(span, RichTextNode.createSpanFlag(0));
                return span;
            }
            if (((this.mComponent.getInstance() != null) & (this.mComponent.getInstance().getUIContext() != null)) && !TextUtils.isEmpty(this.mComponent.getInstanceId())) {
                Spannable parse = RichTextNode.parse(this.mComponent.getInstance().getUIContext(), this.mComponent.getInstanceId(), this.mComponent.getRef(), str);
                updateSpannable(parse, RichTextNode.createSpanFlag(0));
                return parse;
            }
            return new SpannedString("");
        }
    }

    public WXRichText(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
        this.nodes = new LinkedList();
        setContentBoxMeasurement(new RichTextContentBoxMeasurement(this));
    }

    private RichTextNode findRichNode(String str) {
        List<RichTextNode> list;
        if (TextUtils.isEmpty(str) || (list = this.nodes) == null || list.isEmpty()) {
            return null;
        }
        for (RichTextNode richTextNode : this.nodes) {
            RichTextNode findRichNode = richTextNode.findRichNode(str);
            if (findRichNode != null) {
                return findRichNode;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Spannable toSpan() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        List<RichTextNode> list = this.nodes;
        if (list != null && !list.isEmpty()) {
            for (RichTextNode richTextNode : this.nodes) {
                spannableStringBuilder.append((CharSequence) richTextNode.toSpan(1));
            }
        }
        return spannableStringBuilder;
    }

    public void AddChildNode(String str, String str2, String str3, Map<String, String> map, Map<String, String> map2) {
        if (getInstance() == null || getInstance().getUIContext() == null || TextUtils.isEmpty(getInstanceId()) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        RichTextNode createRichTextNode = RichTextNodeManager.createRichTextNode(getInstance().getUIContext(), getInstanceId(), getRef(), str, str2, map, map2);
        if (TextUtils.isEmpty(str3)) {
            this.nodes.add(createRichTextNode);
            return;
        }
        RichTextNode findRichNode = findRichNode(str3);
        if (findRichNode != null) {
            findRichNode.addChildNode(createRichTextNode);
        }
    }

    public void removeChildNode(String str, String str2) {
        List<RichTextNode> list = this.nodes;
        if (list == null || list.isEmpty()) {
            return;
        }
        if (str.equals("")) {
            for (RichTextNode richTextNode : this.nodes) {
                if (TextUtils.equals(richTextNode.getRef(), str2)) {
                    this.nodes.remove(richTextNode);
                }
            }
            return;
        }
        RichTextNode findRichNode = findRichNode(str);
        if (findRichNode != null) {
            findRichNode.removeChildNode(str2);
        }
    }

    public void updateChildNodeAttrs(String str, Map<String, Object> map) {
        RichTextNode findRichNode = findRichNode(str);
        if (findRichNode != null) {
            findRichNode.updateAttrs(map);
        }
    }

    public void updateChildNodeStyles(String str, Map<String, Object> map) {
        RichTextNode findRichNode = findRichNode(str);
        if (findRichNode != null) {
            findRichNode.updateStyles(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXText, com.taobao.weex.ui.component.WXComponent
    public WXTextView initComponentHostView(@NonNull Context context) {
        return new WXRichTextView(context);
    }
}
