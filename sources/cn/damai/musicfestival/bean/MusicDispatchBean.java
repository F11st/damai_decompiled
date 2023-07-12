package cn.damai.musicfestival.bean;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tb.cb2;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class MusicDispatchBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String ipId;
    public String picUrl;
    public int pos;
    public String projectId;
    public String title;
    public String type;
    public String url;

    @Nullable
    public List<CityMusicBean> doShiningChangedEdit(List<CityMusicBean> list, List<MusicIpBean> list2) {
        String str;
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-731756788")) {
            return (List) ipChange.ipc$dispatch("-731756788", new Object[]{this, list, list2});
        }
        if (cb2.d(list) || cb2.d(list2)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (isValidProjectType()) {
            Iterator<MusicIpBean> it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                MusicIpBean next = it.next();
                if (TextUtils.equals(this.ipId, next.musicIpId)) {
                    List<MusicProjectBean> list3 = next.projects;
                    if (!cb2.d(list3)) {
                        for (MusicProjectBean musicProjectBean : list3) {
                            if (TextUtils.equals(this.projectId, musicProjectBean.projectId)) {
                                str = musicProjectBean.cityId;
                                break;
                            }
                        }
                    }
                }
            }
            str = null;
            for (CityMusicBean cityMusicBean : list) {
                if (TextUtils.equals(cityMusicBean.cityId, str)) {
                    List<MusicIpBean> list4 = cityMusicBean.musicIpInfos;
                    if (!cb2.d(list4)) {
                        for (MusicIpBean musicIpBean : list4) {
                            if (TextUtils.equals(this.ipId, musicIpBean.musicIpId)) {
                                str2 = this.ipId;
                                break;
                            }
                        }
                    }
                    str2 = null;
                    if (!TextUtils.equals(cityMusicBean.shiningIpId, str2)) {
                        cityMusicBean.shiningIpId = str2;
                        arrayList.add(cityMusicBean);
                    }
                } else {
                    if (!TextUtils.isEmpty(cityMusicBean.shiningIpId)) {
                        arrayList.add(cityMusicBean);
                    }
                    cityMusicBean.shiningIpId = null;
                }
            }
        } else {
            for (CityMusicBean cityMusicBean2 : list) {
                if (!TextUtils.isEmpty(cityMusicBean2.shiningIpId)) {
                    arrayList.add(cityMusicBean2);
                }
                cityMusicBean2.shiningIpId = null;
            }
        }
        return arrayList;
    }

    public boolean isValidProject() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1861783433") ? ((Boolean) ipChange.ipc$dispatch("-1861783433", new Object[]{this})).booleanValue() : TextUtils.equals("1", this.type) && !TextUtils.isEmpty(this.projectId);
    }

    public boolean isValidProjectType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2015967267") ? ((Boolean) ipChange.ipc$dispatch("-2015967267", new Object[]{this})).booleanValue() : isValidProject() && !TextUtils.isEmpty(this.ipId);
    }

    public boolean isValidUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2068234721") ? ((Boolean) ipChange.ipc$dispatch("2068234721", new Object[]{this})).booleanValue() : TextUtils.equals("2", this.type) && !TextUtils.isEmpty(this.url);
    }
}
