package cn.damai.tetris.mvp;

import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.tetris.core.NodeData;
import cn.damai.tetris.core.TrackInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import tb.m61;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public abstract class CommonViewHolder<T> extends RecyclerView.ViewHolder implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    protected CommonPresenter commonPresenter;
    private Class<T> tClass;

    public CommonViewHolder(View view) {
        super(view);
    }

    public void rebind(NodeData nodeData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1670980292")) {
            ipChange.ipc$dispatch("-1670980292", new Object[]{this, nodeData});
        }
    }

    public boolean rebindAble() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1583301778")) {
            return ((Boolean) ipChange.ipc$dispatch("-1583301778", new Object[]{this})).booleanValue();
        }
        return false;
    }

    public void setCommonPresenter(CommonPresenter commonPresenter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-451785714")) {
            ipChange.ipc$dispatch("-451785714", new Object[]{this, commonPresenter});
        } else {
            this.commonPresenter = commonPresenter;
        }
    }

    protected abstract void setData(CommonBean commonBean);

    public void setData(CommonBean commonBean, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1359060281")) {
            ipChange.ipc$dispatch("1359060281", new Object[]{this, commonBean, Boolean.valueOf(z)});
        } else {
            setData(commonBean);
        }
    }

    public void setMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-480304880")) {
            ipChange.ipc$dispatch("-480304880", new Object[]{this, Integer.valueOf(i), obj});
        } else {
            Log.e("test", "test");
        }
    }

    public void setNode(NodeData nodeData, TrackInfo trackInfo, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "58961627")) {
            ipChange.ipc$dispatch("58961627", new Object[]{this, nodeData, trackInfo, Boolean.valueOf(z)});
            return;
        }
        try {
            CommonBean commonBean = (CommonBean) m61.d(nodeData, this.tClass);
            if (commonBean != null) {
                commonBean.trackInfo = trackInfo;
                setData(commonBean, z);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTClass(Class<T> cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-345079187")) {
            ipChange.ipc$dispatch("-345079187", new Object[]{this, cls});
        } else {
            this.tClass = cls;
        }
    }
}
