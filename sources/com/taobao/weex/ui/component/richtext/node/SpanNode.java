package com.taobao.weex.ui.component.richtext.node;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.taobao.weex.dom.TextDecorationSpan;
import com.taobao.weex.dom.WXStyle;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class SpanNode extends RichTextNode {
    public static final String NODE_TYPE = "span";

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    static class SpanNodeCreator implements RichTextNodeCreator<SpanNode> {
        @Override // com.taobao.weex.ui.component.richtext.node.RichTextNodeCreator
        public /* bridge */ /* synthetic */ SpanNode createRichTextNode(Context context, String str, String str2, String str3, Map map, Map map2) {
            return createRichTextNode2(context, str, str2, str3, (Map<String, Object>) map, (Map<String, Object>) map2);
        }

        @Override // com.taobao.weex.ui.component.richtext.node.RichTextNodeCreator
        public SpanNode createRichTextNode(Context context, String str, String str2) {
            return new SpanNode(context, str, str2);
        }

        @Override // com.taobao.weex.ui.component.richtext.node.RichTextNodeCreator
        /* renamed from: createRichTextNode  reason: avoid collision after fix types in other method */
        public SpanNode createRichTextNode2(Context context, String str, String str2, String str3, Map<String, Object> map, Map<String, Object> map2) {
            return new SpanNode(context, str, str2, str3, map, map2);
        }
    }

    @Override // com.taobao.weex.ui.component.richtext.node.RichTextNode
    protected boolean isInternalNode() {
        return true;
    }

    @Override // com.taobao.weex.ui.component.richtext.node.RichTextNode
    public String toString() {
        Map<String, Object> map = this.attr;
        return (map == null || !map.containsKey("value")) ? "" : this.attr.get("value").toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.richtext.node.RichTextNode
    public void updateSpans(SpannableStringBuilder spannableStringBuilder, int i) {
        super.updateSpans(spannableStringBuilder, i);
        spannableStringBuilder.setSpan(new TextDecorationSpan(WXStyle.getTextDecoration(this.style)), 0, spannableStringBuilder.length(), RichTextNode.createSpanFlag(i));
    }

    private SpanNode(Context context, String str, String str2) {
        super(context, str, str2);
    }

    private SpanNode(Context context, String str, String str2, String str3, Map<String, Object> map, Map<String, Object> map2) {
        super(context, str, str2, str3, map, map2);
    }
}
