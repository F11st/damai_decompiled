package com.taobao.weex.ui.component.richtext.node;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.common.Constants;
import com.taobao.weex.dom.WXCustomStyleSpan;
import com.taobao.weex.dom.WXStyle;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXResourceUtils;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class RichTextNode {
    public static final String ATTR = "attr";
    public static final String CHILDREN = "children";
    public static final String ITEM_CLICK = "itemclick";
    private static final int MAX_LEVEL = 255;
    public static final String PSEUDO_REF = "pseudoRef";
    public static final String STYLE = "style";
    public static final String TYPE = "type";
    public static final String VALUE = "value";
    protected Map<String, Object> attr;
    protected List<RichTextNode> children;
    protected final String mComponentRef;
    protected final Context mContext;
    protected final String mInstanceId;
    protected final String mRef;
    protected Map<String, Object> style;

    /* JADX INFO: Access modifiers changed from: protected */
    public RichTextNode(Context context, String str, String str2) {
        this.mContext = context;
        this.mInstanceId = str;
        this.mComponentRef = str2;
        this.mRef = null;
    }

    @Nullable
    private WXCustomStyleSpan createCustomStyleSpan() {
        int fontWeight = this.style.containsKey(Constants.Name.FONT_WEIGHT) ? WXStyle.getFontWeight(this.style) : -1;
        int fontStyle = this.style.containsKey(Constants.Name.FONT_STYLE) ? WXStyle.getFontStyle(this.style) : -1;
        String fontFamily = this.style.containsKey(Constants.Name.FONT_FAMILY) ? WXStyle.getFontFamily(this.style) : null;
        if (fontWeight == -1 && fontStyle == -1 && fontFamily == null) {
            return null;
        }
        return new WXCustomStyleSpan(fontStyle, fontWeight, fontFamily);
    }

    private static int createPriorityFlag(int i) {
        if (i <= 255) {
            return (255 - i) << 16;
        }
        return 16711680;
    }

    public static int createSpanFlag(int i) {
        return createPriorityFlag(i) | 17;
    }

    @NonNull
    public static Spannable parse(@NonNull Context context, @NonNull String str, @NonNull String str2, String str3) {
        RichTextNode createRichTextNode;
        JSONArray parseArray = JSON.parseArray(str3);
        if (parseArray != null && !parseArray.isEmpty()) {
            ArrayList arrayList = new ArrayList(parseArray.size());
            for (int i = 0; i < parseArray.size(); i++) {
                JSONObject jSONObject = parseArray.getJSONObject(i);
                if (jSONObject != null && (createRichTextNode = RichTextNodeManager.createRichTextNode(context, str, str2, jSONObject)) != null) {
                    arrayList.add(createRichTextNode);
                }
            }
            return parse(arrayList);
        }
        return new SpannableString("");
    }

    public void addChildNode(RichTextNode richTextNode) {
        if (this.children == null) {
            this.children = new LinkedList();
        }
        if (richTextNode == null || !isInternalNode()) {
            return;
        }
        this.children.add(richTextNode);
    }

    public RichTextNode findRichNode(String str) {
        String str2 = this.mRef;
        if (str2 == null || !TextUtils.equals(str2, str)) {
            List<RichTextNode> list = this.children;
            if (list == null || list.isEmpty()) {
                return null;
            }
            for (RichTextNode richTextNode : this.children) {
                RichTextNode findRichNode = richTextNode.findRichNode(str);
                if (findRichNode != null) {
                    return findRichNode;
                }
            }
            return null;
        }
        return this;
    }

    public String getRef() {
        return this.mRef;
    }

    protected abstract boolean isInternalNode();

    public void removeChildNode(String str) {
        List<RichTextNode> list = this.children;
        if (list == null || list.isEmpty() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            for (RichTextNode richTextNode : this.children) {
                if (TextUtils.equals(richTextNode.mRef, str)) {
                    this.children.remove(richTextNode);
                }
            }
        } catch (Exception e) {
            WXLogUtils.getStackTrace(e);
        }
    }

    public Spannable toSpan(int i) {
        List<RichTextNode> list;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) toString());
        if (isInternalNode() && (list = this.children) != null) {
            for (RichTextNode richTextNode : list) {
                spannableStringBuilder.append((CharSequence) richTextNode.toSpan(i + 1));
            }
        }
        updateSpans(spannableStringBuilder, i);
        return spannableStringBuilder;
    }

    public abstract String toString();

    public void updateAttrs(Map<String, Object> map) {
        if (this.attr == null || map.isEmpty()) {
            return;
        }
        this.attr.putAll(map);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateSpans(SpannableStringBuilder spannableStringBuilder, int i) {
        int color;
        WXSDKInstance y = WXSDKManager.v().y(this.mInstanceId);
        if (this.style == null || y == null) {
            return;
        }
        LinkedList<Object> linkedList = new LinkedList();
        WXCustomStyleSpan createCustomStyleSpan = createCustomStyleSpan();
        if (createCustomStyleSpan != null) {
            linkedList.add(createCustomStyleSpan);
        }
        if (this.style.containsKey("fontSize")) {
            linkedList.add(new AbsoluteSizeSpan(WXStyle.getFontSize(this.style, y.getInstanceViewPortWidth())));
        }
        if (this.style.containsKey("backgroundColor") && (color = WXResourceUtils.getColor(this.style.get("backgroundColor").toString(), 0)) != 0) {
            linkedList.add(new BackgroundColorSpan(color));
        }
        if (this.style.containsKey("color")) {
            linkedList.add(new ForegroundColorSpan(WXResourceUtils.getColor(WXStyle.getTextColor(this.style))));
        }
        int createSpanFlag = createSpanFlag(i);
        for (Object obj : linkedList) {
            spannableStringBuilder.setSpan(obj, 0, spannableStringBuilder.length(), createSpanFlag);
        }
    }

    public void updateStyles(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.style.putAll(map);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RichTextNode(Context context, String str, String str2, String str3, Map<String, Object> map, Map<String, Object> map2) {
        this.mContext = context;
        this.mInstanceId = str;
        this.mComponentRef = str2;
        this.mRef = str3;
        if (map != null) {
            this.style = map;
        } else {
            this.style = new ArrayMap(0);
        }
        if (map2 != null) {
            this.attr = map2;
        } else {
            this.attr = new ArrayMap(0);
        }
        this.children = new LinkedList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void parse(@NonNull Context context, @NonNull String str, @NonNull String str2, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject.getJSONObject("style");
        if (jSONObject2 != null) {
            ArrayMap arrayMap = new ArrayMap();
            this.style = arrayMap;
            arrayMap.putAll(jSONObject2);
        } else {
            this.style = new ArrayMap(0);
        }
        JSONObject jSONObject3 = jSONObject.getJSONObject(ATTR);
        if (jSONObject3 != null) {
            ArrayMap arrayMap2 = new ArrayMap(jSONObject3.size());
            this.attr = arrayMap2;
            arrayMap2.putAll(jSONObject3);
        } else {
            this.attr = new ArrayMap(0);
        }
        JSONArray jSONArray = jSONObject.getJSONArray(CHILDREN);
        if (jSONArray != null) {
            this.children = new ArrayList(jSONArray.size());
            for (int i = 0; i < jSONArray.size(); i++) {
                RichTextNode createRichTextNode = RichTextNodeManager.createRichTextNode(context, str, str2, jSONArray.getJSONObject(i));
                if (createRichTextNode != null) {
                    this.children.add(createRichTextNode);
                }
            }
            return;
        }
        this.children = new ArrayList(0);
    }

    @NonNull
    private static Spannable parse(@NonNull List<RichTextNode> list) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (RichTextNode richTextNode : list) {
            spannableStringBuilder.append((CharSequence) richTextNode.toSpan(1));
        }
        return spannableStringBuilder;
    }
}
