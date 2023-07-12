package com.youku.upsplayer.module;

import com.alibaba.fastjson.annotation.JSONField;
import com.tencent.open.SocialConstants;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.BaseCellItem;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class AppBuyInfo {
    @JSONField(name = BaseCellItem.TYPE_BUTTON)
    public String button;
    @JSONField(name = "button_url")
    public String button_url;
    @JSONField(name = SocialConstants.PARAM_APP_DESC)
    public String desc;
    @JSONField(name = "price_end")
    public int price_end;
    @JSONField(name = "price_start")
    public int price_start;
    @JSONField(name = "price_text")
    public String price_text;
    @JSONField(name = "show_button")
    public int show_button;
    @JSONField(name = "show_pay_channel")
    public int show_pay_channel;
    @JSONField(name = "show_price_text")
    public int show_price_text;
}
