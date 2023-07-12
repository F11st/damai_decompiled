package tb;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.imagebrowse.bean.PicInfo;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class px2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(Context context, String str, String str2, String str3, String str4, ArrayList<PicInfo> arrayList, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-535137849")) {
            ipChange.ipc$dispatch("-535137849", new Object[]{context, str, str2, str3, str4, arrayList, Integer.valueOf(i)});
        } else if (context == null) {
        } else {
            ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                VideoInfo videoInfo = new VideoInfo();
                videoInfo.setPicUrl(str2);
                videoInfo.setVideoUrl(str3);
                videoInfo.setType(VideoInfo.VideoType.VIDEO_URL);
                videoInfo.setSourceLabel(str4);
                arrayList2.add(videoInfo);
            }
            Bundle bundle = new Bundle();
            bundle.putString("projectId", str);
            bundle.putParcelableArrayList("video_info", arrayList2);
            bundle.putParcelableArrayList("pic_info", arrayList);
            bundle.putInt("position", i);
            DMNav.from(context).withExtras(bundle).toUri(NavUri.b("videobrowse"));
        }
    }
}
