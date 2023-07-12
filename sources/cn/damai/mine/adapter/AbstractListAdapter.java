package cn.damai.mine.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public abstract class AbstractListAdapter<T> extends BaseAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    public String artistName = "";
    protected Activity mContext;
    protected LayoutInflater mInflater;
    protected List<T> mList;
    private AdapterView mListView;

    public AbstractListAdapter(Activity activity) {
        this.mContext = activity;
        this.mInflater = LayoutInflater.from(activity);
    }

    public void clear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-291015566")) {
            ipChange.ipc$dispatch("-291015566", new Object[]{this});
            return;
        }
        List<T> list = this.mList;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.mList.clear();
    }

    public String getArtistName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1073100041") ? (String) ipChange.ipc$dispatch("1073100041", new Object[]{this}) : this.artistName;
    }

    public Context getContext() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1109727274") ? (Context) ipChange.ipc$dispatch("1109727274", new Object[]{this}) : this.mContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2103125307")) {
            return ((Integer) ipChange.ipc$dispatch("-2103125307", new Object[]{this})).intValue();
        }
        List<T> list = this.mList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1686832197")) {
            return ipChange.ipc$dispatch("1686832197", new Object[]{this, Integer.valueOf(i)});
        }
        List<T> list = this.mList;
        if (list == null) {
            return 0;
        }
        return list.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "316388988") ? ((Long) ipChange.ipc$dispatch("316388988", new Object[]{this, Integer.valueOf(i)})).longValue() : i;
    }

    public List<T> getList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1060909796") ? (List) ipChange.ipc$dispatch("-1060909796", new Object[]{this}) : this.mList;
    }

    public AdapterView getListView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1125554998") ? (AdapterView) ipChange.ipc$dispatch("1125554998", new Object[]{this}) : this.mListView;
    }

    @Override // android.widget.Adapter
    public abstract View getView(int i, View view, ViewGroup viewGroup);

    public void setArtistName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1091446773")) {
            ipChange.ipc$dispatch("1091446773", new Object[]{this, str});
        } else {
            this.artistName = str;
        }
    }

    public void setList(List<T> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1218433584")) {
            ipChange.ipc$dispatch("1218433584", new Object[]{this, list});
        } else {
            this.mList = list;
        }
    }

    public void setListView(AdapterView adapterView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1345569504")) {
            ipChange.ipc$dispatch("-1345569504", new Object[]{this, adapterView});
        } else {
            this.mListView = adapterView;
        }
    }
}
