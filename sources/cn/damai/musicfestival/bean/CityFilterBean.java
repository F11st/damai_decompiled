package cn.damai.musicfestival.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tb.cb2;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class CityFilterBean implements Marker, Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String iconUrl;
    public String projectId;
    public String title;
    public float xRatioInWidth;
    public float yRatioInHeight;

    public CityFilterBean() {
    }

    public static List<CityFilterBean> composeFilterBeanList(MusicIpBean musicIpBean, List<CityMusicBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1246486505")) {
            return (List) ipChange.ipc$dispatch("-1246486505", new Object[]{musicIpBean, list});
        }
        ArrayList arrayList = new ArrayList();
        if (!cb2.d(list)) {
            HashMap hashMap = new HashMap(list.size());
            for (CityMusicBean cityMusicBean : list) {
                hashMap.put(cityMusicBean.cityId, cityMusicBean);
            }
            List<MusicProjectBean> list2 = musicIpBean.projects;
            if (!cb2.d(list2)) {
                for (MusicProjectBean musicProjectBean : list2) {
                    CityMusicBean cityMusicBean2 = (CityMusicBean) hashMap.get(musicProjectBean.cityId);
                    if (cityMusicBean2 != null) {
                        arrayList.add(new CityFilterBean(musicIpBean, cityMusicBean2, musicProjectBean));
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // cn.damai.musicfestival.bean.Marker
    public boolean isHighlight() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1280910646")) {
            return ((Boolean) ipChange.ipc$dispatch("-1280910646", new Object[]{this})).booleanValue();
        }
        return false;
    }

    public CityFilterBean(String str, String str2, float f, float f2) {
        this.iconUrl = str;
        this.title = str2;
        this.xRatioInWidth = f;
        this.yRatioInHeight = f2;
    }

    public CityFilterBean(MusicIpBean musicIpBean, CityMusicBean cityMusicBean, MusicProjectBean musicProjectBean) {
        this.iconUrl = musicIpBean.musicIpIcon;
        this.title = cityMusicBean.cityName + musicProjectBean.showTime;
        this.xRatioInWidth = cityMusicBean.getXRatioInWidth();
        this.yRatioInHeight = cityMusicBean.getYRatioInHeight();
        this.projectId = musicProjectBean.projectId;
    }
}
