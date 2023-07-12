package com.youku.upsplayer.module;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.pictures.picpermission.mantle.PermissionBaseActivity;
import com.tencent.open.SocialConstants;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class Point {
    @JSONField(name = "al")
    public String al;
    @JSONField(name = "ctype")
    public String ctype;
    @JSONField(name = "cut_vid")
    public String cut_vid;
    @JSONField(name = SocialConstants.PARAM_APP_DESC)
    public String desc;
    @JSONField(name = "point_icon")
    public String pointIcon;
    @JSONField(name = "point_url")
    public String pointUrl;
    @JSONField(name = "point_video")
    public PointVideo pointVideo;
    @JSONField(name = "start")
    public String start;
    @JSONField(name = "text_link_icon")
    public String textLinkIcon;
    @JSONField(name = "text_link_title")
    public String textLinkTitle;
    @JSONField(name = "tips_btn_text")
    public String tipsBtnText;
    @JSONField(name = "tipsDynamicPicUrl")
    public String tipsDynamicPicUrl;
    @JSONField(name = PermissionBaseActivity.EXTRA_TIPS_ICON)
    public String tipsIcon;
    @JSONField(name = "tips_pic_url")
    public String tipsPicUrl;
    @JSONField(name = "tips_subtitle")
    public String tipsSubtitle;
    @JSONField(name = PermissionBaseActivity.EXTRA_TIPS_TITLE)
    public String tipsTitle;
    @JSONField(name = "title")
    public String title;
}
