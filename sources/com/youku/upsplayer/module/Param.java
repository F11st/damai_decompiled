package com.youku.upsplayer.module;

import com.alibaba.fastjson.annotation.JSONField;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class Param {
    @JSONField(name = "activity_code")
    public String activity_code;
    @JSONField(name = "code")
    public String code;
    @JSONField(name = "coinIsEnough")
    public String coinIsEnough;
    @JSONField(name = "dialog_desc1")
    public String dialog_desc1;
    @JSONField(name = "dialog_desc2")
    public String dialog_desc2;
    @JSONField(name = "dialog_desc3")
    public String dialog_desc3;
    @JSONField(name = "dialog_title")
    public String dialog_title;
    @JSONField(name = RemoteMessageConst.Notification.ICON)
    public String icon;
    @JSONField(name = "pageKey")
    public String pageKey;
    @JSONField(name = "pay_channel")
    public String pay_channel;
    @JSONField(name = "player_biz_type")
    public String player_biz_type;
    @JSONField(name = "popType")
    public String popType;
    @JSONField(name = "product_buy_param")
    public List<ProductBuyParam> product_buy_param;
    @JSONField(name = "products")
    public List<String> products;
    @JSONField(name = "replaceUrl")
    public String replaceUrl;
    @JSONField(name = "sbm")
    public String sbm;
    @JSONField(name = "scm")
    public String scm;
    @JSONField(name = "show_id")
    public String show_id;
    @JSONField(name = "spm")
    public String spm;
    @JSONField(name = "spm_cancel")
    public String spm_cancel;
    @JSONField(name = "spm_ok")
    public String spm_ok;
    @JSONField(name = "succ_title")
    public String succ_title;
    @JSONField(name = "success_content")
    public String success_content;
    @JSONField(name = "url")
    public String url;
    @JSONField(name = "video_id")
    public String video_id;
}
