package com.taobao.weex.ui.component.richtext.span;

import android.text.style.ClickableSpan;
import android.view.View;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.ui.component.richtext.node.RichTextNode;
import com.taobao.weex.utils.WXDataStructureUtil;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ItemClickSpan extends ClickableSpan {
    private final String mComponentRef;
    private final String mInstanceId;
    private final String mPseudoRef;

    public ItemClickSpan(String str, String str2, String str3) {
        this.mPseudoRef = str3;
        this.mInstanceId = str;
        this.mComponentRef = str2;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        WXSDKInstance y = WXSDKManager.v().y(this.mInstanceId);
        if (y == null || y.isDestroy()) {
            return;
        }
        HashMap newHashMapWithExpectedSize = WXDataStructureUtil.newHashMapWithExpectedSize(1);
        newHashMapWithExpectedSize.put(RichTextNode.PSEUDO_REF, this.mPseudoRef);
        y.fireEvent(this.mComponentRef, RichTextNode.ITEM_CLICK, newHashMapWithExpectedSize);
    }
}
