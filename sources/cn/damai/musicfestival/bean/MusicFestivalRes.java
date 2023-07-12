package cn.damai.musicfestival.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tb.cb2;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class MusicFestivalRes implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public BgInfoBean bgInfo;
    public List<CityMusicBean> cityBaseInfos;
    private List<CityMusicBean> mCityMusicList;
    public List<MusicDispatchBean> musicDispatchInfos;
    public List<MusicIpBean> musicIpInfos;
    public ShareInfo shareInfo;
    public String tips;

    public List<CityMusicBean> getCityMusicListInAllMode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2007616324")) {
            return (List) ipChange.ipc$dispatch("2007616324", new Object[]{this});
        }
        if (this.mCityMusicList == null) {
            this.mCityMusicList = new ArrayList();
            if (cb2.d(this.cityBaseInfos)) {
                return this.mCityMusicList;
            }
            HashMap hashMap = new HashMap();
            if (!cb2.d(this.musicIpInfos)) {
                for (MusicIpBean musicIpBean : this.musicIpInfos) {
                    hashMap.put(musicIpBean.musicIpId, musicIpBean);
                }
            }
            for (CityMusicBean cityMusicBean : this.cityBaseInfos) {
                if (cityMusicBean.isCanShowInAllMode()) {
                    this.mCityMusicList.add(cityMusicBean);
                    List<MusicIpBean> list = cityMusicBean.musicIpInfos;
                    if (!cb2.d(list)) {
                        for (MusicIpBean musicIpBean2 : list) {
                            MusicIpBean musicIpBean3 = (MusicIpBean) hashMap.get(musicIpBean2.musicIpId);
                            if (musicIpBean3 != null) {
                                List<MusicProjectBean> list2 = musicIpBean3.projects;
                                if (!cb2.d(list2)) {
                                    Iterator<MusicProjectBean> it = list2.iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            MusicProjectBean next = it.next();
                                            if (TextUtils.equals(next.cityId, cityMusicBean.cityId)) {
                                                ArrayList arrayList = new ArrayList();
                                                musicIpBean2.projects = arrayList;
                                                arrayList.add(next);
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return this.mCityMusicList;
    }

    public void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1333395952")) {
            ipChange.ipc$dispatch("-1333395952", new Object[]{this});
            return;
        }
        if (!cb2.d(this.musicIpInfos)) {
            for (MusicIpBean musicIpBean : this.musicIpInfos) {
                musicIpBean.isTabHighlight = musicIpBean.all;
            }
        }
        if (cb2.d(this.cityBaseInfos) || cb2.d(this.musicDispatchInfos)) {
            return;
        }
        for (CityMusicBean cityMusicBean : this.cityBaseInfos) {
            cityMusicBean.high = false;
        }
    }
}
