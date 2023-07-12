package com.taobao.weex.ui.component.richtext.node;

import android.content.Context;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import androidx.annotation.NonNull;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.adapter.DrawableStrategy;
import com.taobao.weex.ui.component.richtext.span.ImgSpan;
import com.taobao.weex.ui.component.richtext.span.ItemClickSpan;
import com.taobao.weex.utils.ImgURIUtil;
import com.taobao.weex.utils.WXUtils;
import com.taobao.weex.utils.WXViewUtils;
import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ImgNode extends RichTextNode {
    public static final String NODE_TYPE = "image";

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    static class ImgNodeCreator implements RichTextNodeCreator<ImgNode> {
        @Override // com.taobao.weex.ui.component.richtext.node.RichTextNodeCreator
        public /* bridge */ /* synthetic */ ImgNode createRichTextNode(Context context, String str, String str2, String str3, Map map, Map map2) {
            return createRichTextNode(context, str, str2, str3, (Map<String, Object>) map, (Map<String, Object>) map2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.taobao.weex.ui.component.richtext.node.RichTextNodeCreator
        public ImgNode createRichTextNode(Context context, String str, String str2) {
            return new ImgNode(context, str, str2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.taobao.weex.ui.component.richtext.node.RichTextNodeCreator
        public ImgNode createRichTextNode(Context context, String str, String str2, String str3, Map<String, Object> map, Map<String, Object> map2) {
            return new ImgNode(context, str, str2, str3, map, map2);
        }
    }

    @NonNull
    private ImgSpan createImgSpan(WXSDKInstance wXSDKInstance) {
        int realPxByWidth = (int) WXViewUtils.getRealPxByWidth(WXUtils.getFloat(this.style.get("width")), wXSDKInstance.getInstanceViewPortWidth());
        int realPxByWidth2 = (int) WXViewUtils.getRealPxByWidth(WXUtils.getFloat(this.style.get("height")), wXSDKInstance.getInstanceViewPortWidth());
        ImgSpan imgSpan = new ImgSpan(realPxByWidth, realPxByWidth2);
        Uri rewriteUri = wXSDKInstance.rewriteUri(Uri.parse(this.attr.get("src").toString()), "image");
        if ("local".equals(rewriteUri.getScheme())) {
            imgSpan.setDrawable(ImgURIUtil.getDrawableFromLoaclSrc(this.mContext, rewriteUri), false);
        } else {
            DrawableStrategy drawableStrategy = new DrawableStrategy();
            drawableStrategy.width = realPxByWidth;
            drawableStrategy.height = realPxByWidth2;
            WXSDKEngine.getDrawableLoader().setDrawable(rewriteUri.toString(), imgSpan, drawableStrategy);
        }
        return imgSpan;
    }

    @Override // com.taobao.weex.ui.component.richtext.node.RichTextNode
    protected boolean isInternalNode() {
        return false;
    }

    @Override // com.taobao.weex.ui.component.richtext.node.RichTextNode
    public String toString() {
        return "\ufeff";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.richtext.node.RichTextNode
    public void updateSpans(SpannableStringBuilder spannableStringBuilder, int i) {
        WXSDKInstance y = WXSDKManager.v().y(this.mInstanceId);
        if (WXSDKEngine.getDrawableLoader() != null && this.style.containsKey("width") && this.style.containsKey("height") && this.attr.containsKey("src") && y != null) {
            LinkedList<Object> linkedList = new LinkedList();
            linkedList.add(createImgSpan(y));
            if (this.attr.containsKey(RichTextNode.PSEUDO_REF)) {
                linkedList.add(new ItemClickSpan(this.mInstanceId, this.mComponentRef, this.attr.get(RichTextNode.PSEUDO_REF).toString()));
            }
            for (Object obj : linkedList) {
                spannableStringBuilder.setSpan(obj, 0, spannableStringBuilder.length(), RichTextNode.createSpanFlag(i));
            }
        }
    }

    private ImgNode(Context context, String str, String str2) {
        super(context, str, str2);
    }

    private ImgNode(Context context, String str, String str2, String str3, Map<String, Object> map, Map<String, Object> map2) {
        super(context, str, str2, str3, map, map2);
    }
}
