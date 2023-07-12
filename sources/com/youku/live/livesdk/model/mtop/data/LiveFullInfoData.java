package com.youku.live.livesdk.model.mtop.data;

import com.youku.live.livesdk.model.mtop.data.livefullinfo.ConnectionInfo;
import com.youku.live.livesdk.model.mtop.data.livefullinfo.ExtDTO;
import com.youku.live.livesdk.model.mtop.data.livefullinfo.TemplateDTO;
import com.youku.live.livesdk.model.mtop.data.livefullinfo.ThemeDTO;
import com.youku.live.livesdk.model.mtop.data.livefullinfo.UserInfo;
import com.youku.live.livesdk.model.mtop.data.livefullinfo.WidgetInitDTO;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class LiveFullInfoData implements Serializable {
    public Long anchorYtid;
    public Integer bizType;
    public Long categoryId;
    public String clientIp;
    public ConnectionInfo connectionInfo;
    public String desc;
    public Long endTimestamp;
    public ExtDTO ext;
    public Long liveId;
    public Integer liveStatus;
    public UserInfo loginUser;
    public String name;
    public Long now;
    public Long screenId;
    public String sdkVersion;
    public Long startTimestamp;
    public TemplateDTO template;
    public ThemeDTO theme;
    public Long userId;
    public String virtualDollConfig;
    public WidgetInitDTO widgets;
}
