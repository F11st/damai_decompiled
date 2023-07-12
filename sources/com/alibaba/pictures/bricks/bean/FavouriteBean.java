package com.alibaba.pictures.bricks.bean;

import android.text.TextUtils;
import cn.damai.uikit.view.LiveRoomView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class FavouriteBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 9125109472611687243L;
    public String alg;
    public String cardType;
    public String categoryName;
    public String contentCount;
    public String coverUrl;
    public String displayContent;
    public String gmtModified;
    public String id;
    public String itemScore;
    public String liveStatus;
    public String name;
    public String priority;
    public String schema;
    public String tagType;

    public LiveRoomView.DMLiveRoomType getLiveType() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1296307340")) {
            return (LiveRoomView.DMLiveRoomType) ipChange.ipc$dispatch("1296307340", new Object[]{this});
        }
        if (!TextUtils.isEmpty(this.liveStatus)) {
            if (this.liveStatus.equals("2")) {
                return LiveRoomView.DMLiveRoomType.TAG_TYPE_LIVE;
            }
            if (this.liveStatus.equals("1")) {
                return LiveRoomView.DMLiveRoomType.TAG_TYPE_DEFAULT;
            }
        }
        return LiveRoomView.DMLiveRoomType.TAG_TYPE_INIT;
    }
}
