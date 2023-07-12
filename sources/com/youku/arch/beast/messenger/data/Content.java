package com.youku.arch.beast.messenger.data;

import cn.damai.user.userprofile.FeedsViewModel;
import com.ali.user.open.tbauth.TbAuthConstants;
import com.alibaba.fastjson.annotation.JSONField;
import com.youku.ups.data.RequestParams;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class Content {
    @JSONField(name = "accessValue")
    public String accessValue;
    @JSONField(name = "actionId")
    public String actionId;
    @JSONField(name = "actionNum")
    public String actionNum;
    @JSONField(name = "actionShow")
    public String actionShow;
    @JSONField(name = "appkey")
    public String appkey;
    @JSONField(name = "ccode")
    public String ccode;
    @JSONField(name = "chipset")
    public String chipset;
    @JSONField(name = RequestParams.client_ts)
    public String client_ts;
    @JSONField(name = "deviceNetScore")
    public String deviceNetScore;
    @JSONField(name = "deviceType")
    public String deviceType;
    @JSONField(name = "deviceid")
    public String deviceid;
    @JSONField(name = "eventInfos")
    public List<HashMap<String, String>> eventInfos = new LinkedList();
    @JSONField(name = "ext")
    public String ext;
    @JSONField(name = TbAuthConstants.IP)
    public String ip;
    @JSONField(name = "islogin")
    public String islogin;
    @JSONField(name = "isvip")
    public String isvip;
    @JSONField(name = "network")
    public String network;
    @JSONField(name = "networkQuality")
    public String networkQuality;
    @JSONField(name = "osVer")
    public String osVer;
    @JSONField(name = "pid")
    public String pid;
    @JSONField(name = "sig")
    public String sig;
    @JSONField(name = "userNick")
    public String userNick;
    @JSONField(name = FeedsViewModel.ARG_USERID)
    public String userid;
    @JSONField(name = "version")
    public String version;
    @JSONField(name = "viptype")
    public String viptype;
}
