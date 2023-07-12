package com.taobao.weex.ui.action;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.common.Constants;
import com.taobao.weex.utils.FontDO;
import com.taobao.weex.utils.TypefaceUtil;
import tb.yo0;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ActionAddRule implements IExecutable {
    private final JSONObject mData;
    private final String mPageId;
    private final String mType;

    public ActionAddRule(String str, String str2, JSONObject jSONObject) {
        this.mPageId = str;
        this.mType = str2;
        this.mData = jSONObject;
    }

    private void notifyAddFontRule(WXSDKInstance wXSDKInstance, FontDO fontDO) {
        yo0 m = WXSDKManager.v().m();
        if (m != null) {
            m.a(wXSDKInstance.getInstanceId(), fontDO.getFontFamilyName(), fontDO.getUrl());
        }
    }

    private FontDO parseFontDO(JSONObject jSONObject, WXSDKInstance wXSDKInstance) {
        if (jSONObject == null) {
            return null;
        }
        return new FontDO(jSONObject.getString(Constants.Name.FONT_FAMILY), jSONObject.getString("src"), wXSDKInstance);
    }

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
        FontDO parseFontDO;
        WXSDKInstance wXSDKInstance = WXSDKManager.v().G().getWXSDKInstance(this.mPageId);
        if (wXSDKInstance == null || wXSDKInstance.isDestroy() || !Constants.Name.FONT_FACE.equals(this.mType) || (parseFontDO = parseFontDO(this.mData, wXSDKInstance)) == null || TextUtils.isEmpty(parseFontDO.getFontFamilyName())) {
            return;
        }
        notifyAddFontRule(wXSDKInstance, parseFontDO);
        FontDO fontDO = TypefaceUtil.getFontDO(parseFontDO.getFontFamilyName());
        if (fontDO != null && TextUtils.equals(fontDO.getUrl(), parseFontDO.getUrl())) {
            TypefaceUtil.loadTypeface(fontDO, true);
            return;
        }
        TypefaceUtil.putFontDO(parseFontDO);
        TypefaceUtil.loadTypeface(parseFontDO, true);
    }
}
