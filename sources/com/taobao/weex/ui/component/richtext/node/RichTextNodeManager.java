package com.taobao.weex.ui.component.richtext.node;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.ui.component.richtext.node.ANode;
import com.taobao.weex.ui.component.richtext.node.ImgNode;
import com.taobao.weex.ui.component.richtext.node.SpanNode;
import com.taobao.weex.utils.WXLogUtils;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class RichTextNodeManager {
    private static final Map<String, RichTextNodeCreator> registeredTextNodes;

    static {
        ArrayMap arrayMap = new ArrayMap();
        registeredTextNodes = arrayMap;
        arrayMap.put("span", new SpanNode.SpanNodeCreator());
        arrayMap.put("image", new ImgNode.ImgNodeCreator());
        arrayMap.put("a", new ANode.ANodeCreator());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static RichTextNode createRichTextNode(@NonNull Context context, @NonNull String str, @NonNull String str2, @Nullable JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                RichTextNode createRichTextNode = registeredTextNodes.get(jSONObject.getString("type")).createRichTextNode(context, str, str2);
                createRichTextNode.parse(context, str, str2, jSONObject);
                return createRichTextNode;
            } catch (Exception e) {
                WXLogUtils.e("Richtext", WXLogUtils.getStackTrace(e));
                return null;
            }
        }
        return null;
    }

    public static void registerTextNode(String str, RichTextNodeCreator richTextNodeCreator) {
        registeredTextNodes.put(str, richTextNodeCreator);
    }

    public static RichTextNode createRichTextNode(Context context, String str, String str2, String str3, String str4, Map<String, String> map, Map<String, String> map2) {
        try {
            return registeredTextNodes.get(str4).createRichTextNode(context, str, str2, str3, map, map2);
        } catch (Exception e) {
            WXLogUtils.e("Richtext", WXLogUtils.getStackTrace(e));
            return null;
        }
    }
}
