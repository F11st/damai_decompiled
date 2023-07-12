package com.taobao.weex.ui.component.richtext.node;

import android.content.Context;
import com.taobao.weex.ui.component.richtext.node.RichTextNode;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface RichTextNodeCreator<T extends RichTextNode> {
    T createRichTextNode(Context context, String str, String str2);

    T createRichTextNode(Context context, String str, String str2, String str3, Map<String, Object> map, Map<String, Object> map2);
}
