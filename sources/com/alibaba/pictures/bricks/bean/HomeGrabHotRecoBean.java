package com.alibaba.pictures.bricks.bean;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class HomeGrabHotRecoBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = -6005268060159456774L;
    public JSONObject action;
    public String bgPic;
    public List<TitleNode> noticeList;
    public String rendering;
    public String serverTime;
    public String subTitle;
    public String subTitleColor;
    public String subTitleValueType;
    public String titlePic;

    public boolean isCountDown() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1619355068") ? ((Boolean) ipChange.ipc$dispatch("1619355068", new Object[]{this})).booleanValue() : "DATETIME".equals(this.subTitleValueType);
    }

    public boolean isHotRecommendType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1226244260") ? ((Boolean) ipChange.ipc$dispatch("-1226244260", new Object[]{this})).booleanValue() : "none".equals(this.rendering) || TextUtils.isEmpty(this.rendering);
    }

    public boolean isProjectType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1651466790") ? ((Boolean) ipChange.ipc$dispatch("-1651466790", new Object[]{this})).booleanValue() : !TextUtils.isEmpty(this.rendering) && "high".equals(this.rendering);
    }
}
