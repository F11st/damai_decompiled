package cn.damai.tetris.component.discover.bean;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import cn.damai.comment.bean.ContentDetailItem;
import cn.damai.commonbusiness.discover.bean.ContentShareInfo;
import cn.damai.tetris.component.ip.bean.BaseUserDO;
import cn.damai.tetris.component.ip.bean.ContentInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashSet;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class NoteBean extends Extra {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TYPE_SHOW_LOOK_COMMENT = "32";
    public static final String TYPE_SHOW_PRIVILEGE = "62";
    public static final String TYPE_SHOW_SCAN_COMMENT = "65";
    public BaseUserDO baseUserDO;
    public String content;
    public ContentInfo contentInfo;
    public String contentLabels;
    public ExRelatedInfo extraRelatedInfo;
    public boolean focus;
    public String goDnaUrl;
    public String headImg;
    public String id;
    public List<String> imgList;
    public String ipvuv;
    public String isFeature;
    public boolean mySelf;
    public String nickname;
    public String pic;
    public ContentDetailItem.PraiseInfo praiseInfo;
    public boolean prohibitEditing;
    public ProjectInNote project;
    public String publishTime;
    public PublishUser publishUser;
    public RelatedInfo relatedInfo;
    @Nullable
    public String schema;
    public ContentShareInfo shareDO;
    public String similarity;
    public String sourceId;
    public String subType;
    public float localPicWhRatio = -1.0f;
    public int focusCount = 0;

    private HashSet<String> getTypeCanShowPublish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "577214072")) {
            return (HashSet) ipChange.ipc$dispatch("577214072", new Object[]{this});
        }
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("32");
        hashSet.add("62");
        hashSet.add("65");
        return hashSet;
    }

    public boolean containsStrategy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "977177967")) {
            return ((Boolean) ipChange.ipc$dispatch("977177967", new Object[]{this})).booleanValue();
        }
        String str = this.contentLabels;
        return str != null && str.contains("strategy");
    }

    public String getContentInfoText() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1622515777")) {
            return (String) ipChange.ipc$dispatch("1622515777", new Object[]{this});
        }
        ContentInfo contentInfo = this.contentInfo;
        if (contentInfo != null) {
            return contentInfo.content;
        }
        return null;
    }

    @Nullable
    public String getPublishUserId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1164828642")) {
            return (String) ipChange.ipc$dispatch("1164828642", new Object[]{this});
        }
        BaseUserDO baseUserDO = this.baseUserDO;
        if (baseUserDO != null) {
            return baseUserDO.havanaIdStr;
        }
        return null;
    }

    public int getRelateIconRid(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1949235441")) {
            return ((Integer) ipChange.ipc$dispatch("-1949235441", new Object[]{this, Boolean.valueOf(z)})).intValue();
        }
        RelatedInfo relatedInfo = this.relatedInfo;
        if (relatedInfo != null) {
            return relatedInfo.getRelateIconRid(z);
        }
        return -1;
    }

    public String getRelateText() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "351508431")) {
            return (String) ipChange.ipc$dispatch("351508431", new Object[]{this});
        }
        RelatedInfo relatedInfo = this.relatedInfo;
        return relatedInfo != null ? relatedInfo.value : "";
    }

    public boolean isCanShowRelateUi() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "193640769")) {
            return ((Boolean) ipChange.ipc$dispatch("193640769", new Object[]{this})).booleanValue();
        }
        RelatedInfo relatedInfo = this.relatedInfo;
        return relatedInfo != null && relatedInfo.isValid();
    }

    public boolean isEnableEdit() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1523450634")) {
            return ((Boolean) ipChange.ipc$dispatch("1523450634", new Object[]{this})).booleanValue();
        }
        if (!this.mySelf || TextUtils.isEmpty(this.subType)) {
            return false;
        }
        return getTypeCanShowPublish().contains(this.subType);
    }

    public boolean isFeature() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-186429275") ? ((Boolean) ipChange.ipc$dispatch("-186429275", new Object[]{this})).booleanValue() : TextUtils.equals("1", this.isFeature);
    }

    public boolean isHasVideoUnderReviewStatus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-458541350")) {
            return ((Boolean) ipChange.ipc$dispatch("-458541350", new Object[]{this})).booleanValue();
        }
        VideoInfo videoInfo = this.videoInfo;
        return videoInfo != null && videoInfo.isVideoUnderReviewStatus();
    }

    public boolean isPicNote() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1136123585") ? ((Boolean) ipChange.ipc$dispatch("-1136123585", new Object[]{this})).booleanValue() : !TextUtils.isEmpty(this.pic);
    }
}
