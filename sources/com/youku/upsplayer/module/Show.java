package com.youku.upsplayer.module;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.pictures.bricks.orderconfirm.CouponOrderConfirmFragment;
import com.taobao.tao.log.statistics.TLogEventConst;
import com.youku.playerservice.axp.modules.history.PlayerHistoryModule;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class Show {
    @JSONField(name = "client_close_flags")
    public String[] client_close_flags;
    @JSONField(name = "copyright")
    public String copyright;
    @JSONField(name = "encodeid")
    public String encodeid;
    @JSONField(name = "episode_total")
    public int episode_total;
    @JSONField(name = "exclusive")
    public boolean exclusive;
    @JSONField(name = "fountain")
    public String[] fountain;
    @JSONField(name = "id")
    public int id;
    @JSONField(name = "license_num")
    public String license_num;
    @JSONField(name = "package_type")
    public String[] package_type;
    @JSONField(name = "pay")
    public int pay;
    @JSONField(name = CouponOrderConfirmFragment.EVENT_PAY_TYPE)
    public String[] pay_type;
    @JSONField(name = "show_icon")
    public int show_icon;
    @JSONField(name = "show_thumburl")
    public String show_thumburl;
    @JSONField(name = "show_thumburl_big_jpg")
    public String show_thumburl_big_jpg;
    @JSONField(name = "show_thumburl_huge")
    public String show_thumburl_huge;
    @JSONField(name = "show_videotype")
    public String show_videotype;
    @JSONField(name = "show_vthumburl")
    public String show_vthumburl;
    @JSONField(name = "show_vthumburl_big_jpg")
    public String show_vthumburl_big_jpg;
    @JSONField(name = "show_vthumburl_huge")
    public String show_vthumburl_huge;
    @JSONField(name = "showcategory")
    public String showcategory;
    @JSONField(name = "showkind")
    public String[] showkind;
    @JSONField(name = TLogEventConst.PARAM_UPLOAD_STAGE)
    public int stage;
    @JSONField(name = "title")
    public String title;
    @JSONField(name = "tudou_register_num")
    public String tudou_register_num;
    @JSONField(name = "video_pay")
    public int video_pay;
    @JSONField(name = PlayerHistoryModule.INT_SHOW_VIDEO_TYPE)
    public int video_type;
    @JSONField(name = "youku_register_num")
    public String youku_register_num;
}
