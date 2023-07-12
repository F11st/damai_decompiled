package cn.damai.tetris.component.ip.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class VideoAlbumBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String latestCount;
    private List<VideoAlbum> result;
    public String schema;

    public List<VideoAlbum> getResult() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "549020077") ? (List) ipChange.ipc$dispatch("549020077", new Object[]{this}) : this.result;
    }

    public void setResult(List<VideoAlbum> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "452543167")) {
            ipChange.ipc$dispatch("452543167", new Object[]{this, list});
        } else {
            this.result = list;
        }
    }
}
