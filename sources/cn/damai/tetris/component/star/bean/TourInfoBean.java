package cn.damai.tetris.component.star.bean;

import android.text.TextUtils;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class TourInfoBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String contentVideoCoverUrl;
    public String contentVideoUrl;
    private List<ProjectItemBean> projects;
    private List<TourCityItem> tourCities;
    private TourInfoItem tourInfo;
    private String tourVideoCover;
    private String tourVideoUrl;

    public List<ProjectItemBean> getProjects() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "212149991") ? (List) ipChange.ipc$dispatch("212149991", new Object[]{this}) : this.projects;
    }

    public List<TourCityItem> getTourCities() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1848141906") ? (List) ipChange.ipc$dispatch("-1848141906", new Object[]{this}) : this.tourCities;
    }

    public TourInfoItem getTourInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1264157751") ? (TourInfoItem) ipChange.ipc$dispatch("-1264157751", new Object[]{this}) : this.tourInfo;
    }

    public String getTourVideoCover() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1339210746")) {
            return (String) ipChange.ipc$dispatch("1339210746", new Object[]{this});
        }
        if (!TextUtils.isEmpty(this.contentVideoCoverUrl)) {
            return this.contentVideoCoverUrl;
        }
        return this.tourVideoCover;
    }

    public String getTourVideoUrl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-937377870")) {
            return (String) ipChange.ipc$dispatch("-937377870", new Object[]{this});
        }
        if (!TextUtils.isEmpty(this.contentVideoUrl)) {
            return this.contentVideoUrl;
        }
        return this.tourVideoUrl;
    }

    public void setProjects(List<ProjectItemBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1792137157")) {
            ipChange.ipc$dispatch("1792137157", new Object[]{this, list});
        } else {
            this.projects = list;
        }
    }

    public void setTourCities(List<TourCityItem> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-434605346")) {
            ipChange.ipc$dispatch("-434605346", new Object[]{this, list});
        } else {
            this.tourCities = list;
        }
    }

    public void setTourInfo(TourInfoItem tourInfoItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "998405903")) {
            ipChange.ipc$dispatch("998405903", new Object[]{this, tourInfoItem});
        } else {
            this.tourInfo = tourInfoItem;
        }
    }

    public void setTourVideoCover(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-551246556")) {
            ipChange.ipc$dispatch("-551246556", new Object[]{this, str});
        } else {
            this.tourVideoCover = str;
        }
    }

    public void setTourVideoUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1403938156")) {
            ipChange.ipc$dispatch("1403938156", new Object[]{this, str});
        } else {
            this.tourVideoUrl = str;
        }
    }
}
