package cn.damai.commonbusiness.share.live;

import cn.damai.comment.bean.DmInfo;
import cn.damai.comment.bean.StoreInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class LiveShareImageBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public DmInfo dmInfo;
    public int itemType;
    public List<ShareArtistItem> mArtistList;
    public boolean mIsVip;
    public String mIvAccountImage;
    public List<String> mLivePicList;
    public String mNoteText;
    public String mProjectImage;
    public String mProjectInfo;
    public String mProjectTitle;
    public String mShareQrcode;
    public String mUserTitle;
    public String mUserTitleSub;
    public StoreInfo storeInfo;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class ShareArtistItem implements Serializable {
        public String mArtistAvatar;
        public String mArtistDesc;
        public String mArtistName;
    }

    public int getImageCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-199666764")) {
            return ((Integer) ipChange.ipc$dispatch("-199666764", new Object[]{this})).intValue();
        }
        List<String> list = this.mLivePicList;
        if (list == null || list.isEmpty()) {
            return 0;
        }
        return this.mLivePicList.size();
    }
}
