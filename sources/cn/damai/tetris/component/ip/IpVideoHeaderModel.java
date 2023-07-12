package cn.damai.tetris.component.ip;

import android.text.TextUtils;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.tetris.component.ip.IpVideoHeaderContract;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class IpVideoHeaderModel extends AbsModel implements IpVideoHeaderContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    VideoInfo videoInfo;

    @Override // cn.damai.tetris.component.ip.IpVideoHeaderContract.Model
    public VideoInfo getVideoInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-280677093") ? (VideoInfo) ipChange.ipc$dispatch("-280677093", new Object[]{this}) : this.videoInfo;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1065687601")) {
            ipChange.ipc$dispatch("-1065687601", new Object[]{this, baseNode});
            return;
        }
        JSONArray jSONArray = null;
        try {
            JSONObject parseObject = JSON.parseObject(baseNode.toJSONString());
            if (parseObject != null && parseObject.containsKey("result")) {
                jSONArray = parseObject.getJSONArray("result");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (jSONArray == null || jSONArray.getJSONObject(0) == null) {
            return;
        }
        JSONObject jSONObject = jSONArray.getJSONObject(0);
        this.videoInfo = new VideoInfo();
        if (!TextUtils.isEmpty(jSONObject.getString("contentVideoUrl"))) {
            this.videoInfo.setVideoUrl(jSONObject.getString("contentVideoUrl"));
            this.videoInfo.setType(VideoInfo.VideoType.VIDEO_URL);
        } else {
            this.videoInfo.setVid(jSONObject.getString("vid"));
            this.videoInfo.setType(VideoInfo.VideoType.VIDEO_VID);
        }
        if (!TextUtils.isEmpty(jSONObject.getString("contentVideoCoverUrl"))) {
            this.videoInfo.setPicUrl(jSONObject.getString("contentVideoCoverUrl"));
        } else {
            this.videoInfo.setPicUrl(jSONObject.getString("vPic"));
        }
    }
}
