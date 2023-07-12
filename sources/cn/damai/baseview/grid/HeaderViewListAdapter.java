package cn.damai.baseview.grid;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import cn.damai.baseview.grid.ExtendableListView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class HeaderViewListAdapter implements Filterable, WrapperListAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    static final ArrayList<ExtendableListView.c> EMPTY_INFO_LIST = new ArrayList<>();
    private final ListAdapter mAdapter;
    boolean mAreAllFixedViewsSelectable;
    ArrayList<ExtendableListView.c> mFooterViewInfos;
    ArrayList<ExtendableListView.c> mHeaderViewInfos;
    private final boolean mIsFilterable;

    public HeaderViewListAdapter(ArrayList<ExtendableListView.c> arrayList, ArrayList<ExtendableListView.c> arrayList2, ListAdapter listAdapter) {
        this.mAdapter = listAdapter;
        this.mIsFilterable = listAdapter instanceof Filterable;
        if (arrayList == null) {
            this.mHeaderViewInfos = EMPTY_INFO_LIST;
        } else {
            this.mHeaderViewInfos = arrayList;
        }
        if (arrayList2 == null) {
            this.mFooterViewInfos = EMPTY_INFO_LIST;
        } else {
            this.mFooterViewInfos = arrayList2;
        }
        this.mAreAllFixedViewsSelectable = areAllListInfosSelectable(this.mHeaderViewInfos) && areAllListInfosSelectable(this.mFooterViewInfos);
    }

    private boolean areAllListInfosSelectable(ArrayList<ExtendableListView.c> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "364718845")) {
            return ((Boolean) ipChange.ipc$dispatch("364718845", new Object[]{this, arrayList})).booleanValue();
        }
        if (arrayList != null) {
            Iterator<ExtendableListView.c> it = arrayList.iterator();
            while (it.hasNext()) {
                if (!it.next().c) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1869036127")) {
            return ((Boolean) ipChange.ipc$dispatch("1869036127", new Object[]{this})).booleanValue();
        }
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null) {
            return this.mAreAllFixedViewsSelectable && listAdapter.areAllItemsEnabled();
        }
        return true;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1828408003")) {
            return ((Integer) ipChange.ipc$dispatch("1828408003", new Object[]{this})).intValue();
        }
        if (this.mAdapter != null) {
            return getFootersCount() + getHeadersCount() + this.mAdapter.getCount();
        }
        return getFootersCount() + getHeadersCount();
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "450375969")) {
            return (Filter) ipChange.ipc$dispatch("450375969", new Object[]{this});
        }
        if (this.mIsFilterable) {
            return ((Filterable) this.mAdapter).getFilter();
        }
        return null;
    }

    public int getFootersCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-52428729") ? ((Integer) ipChange.ipc$dispatch("-52428729", new Object[]{this})).intValue() : this.mFooterViewInfos.size();
    }

    public int getHeadersCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1470645141") ? ((Integer) ipChange.ipc$dispatch("1470645141", new Object[]{this})).intValue() : this.mHeaderViewInfos.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-88158201")) {
            return ipChange.ipc$dispatch("-88158201", new Object[]{this, Integer.valueOf(i)});
        }
        int headersCount = getHeadersCount();
        if (i < headersCount) {
            return this.mHeaderViewInfos.get(i).b;
        }
        int i3 = i - headersCount;
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null && i3 < (i2 = listAdapter.getCount())) {
            return this.mAdapter.getItem(i3);
        }
        return this.mFooterViewInfos.get(i3 - i2).b;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1051320582")) {
            return ((Long) ipChange.ipc$dispatch("-1051320582", new Object[]{this, Integer.valueOf(i)})).longValue();
        }
        int headersCount = getHeadersCount();
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null || i < headersCount || (i2 = i - headersCount) >= listAdapter.getCount()) {
            return -1L;
        }
        return this.mAdapter.getItemId(i2);
    }

    @Override // android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1598094947")) {
            return ((Integer) ipChange.ipc$dispatch("-1598094947", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        int headersCount = getHeadersCount();
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null || i < headersCount || (i2 = i - headersCount) >= listAdapter.getCount()) {
            return -2;
        }
        return this.mAdapter.getItemViewType(i2);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "717960470")) {
            return (View) ipChange.ipc$dispatch("717960470", new Object[]{this, Integer.valueOf(i), view, viewGroup});
        }
        int headersCount = getHeadersCount();
        if (i < headersCount) {
            return this.mHeaderViewInfos.get(i).a;
        }
        int i3 = i - headersCount;
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null && i3 < (i2 = listAdapter.getCount())) {
            return this.mAdapter.getView(i3, view, viewGroup);
        }
        return this.mFooterViewInfos.get(i3 - i2).a;
    }

    @Override // android.widget.Adapter
    public int getViewTypeCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-313607838")) {
            return ((Integer) ipChange.ipc$dispatch("-313607838", new Object[]{this})).intValue();
        }
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null) {
            return listAdapter.getViewTypeCount();
        }
        return 1;
    }

    @Override // android.widget.WrapperListAdapter
    public ListAdapter getWrappedAdapter() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1328430850") ? (ListAdapter) ipChange.ipc$dispatch("-1328430850", new Object[]{this}) : this.mAdapter;
    }

    @Override // android.widget.Adapter
    public boolean hasStableIds() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1738694634")) {
            return ((Boolean) ipChange.ipc$dispatch("1738694634", new Object[]{this})).booleanValue();
        }
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null) {
            return listAdapter.hasStableIds();
        }
        return false;
    }

    @Override // android.widget.Adapter
    public boolean isEmpty() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-419523966")) {
            return ((Boolean) ipChange.ipc$dispatch("-419523966", new Object[]{this})).booleanValue();
        }
        ListAdapter listAdapter = this.mAdapter;
        return listAdapter == null || listAdapter.isEmpty();
    }

    @Override // android.widget.ListAdapter
    public boolean isEnabled(int i) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-992120387")) {
            return ((Boolean) ipChange.ipc$dispatch("-992120387", new Object[]{this, Integer.valueOf(i)})).booleanValue();
        }
        int headersCount = getHeadersCount();
        if (i < headersCount) {
            return this.mHeaderViewInfos.get(i).c;
        }
        int i3 = i - headersCount;
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null && i3 < (i2 = listAdapter.getCount())) {
            return this.mAdapter.isEnabled(i3);
        }
        return this.mFooterViewInfos.get(i3 - i2).c;
    }

    @Override // android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-795329397")) {
            ipChange.ipc$dispatch("-795329397", new Object[]{this, dataSetObserver});
            return;
        }
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(dataSetObserver);
        }
    }

    public boolean removeFooter(View view) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1541080428")) {
            return ((Boolean) ipChange.ipc$dispatch("1541080428", new Object[]{this, view})).booleanValue();
        }
        for (int i = 0; i < this.mFooterViewInfos.size(); i++) {
            if (this.mFooterViewInfos.get(i).a == view) {
                this.mFooterViewInfos.remove(i);
                if (areAllListInfosSelectable(this.mHeaderViewInfos) && areAllListInfosSelectable(this.mFooterViewInfos)) {
                    z = true;
                }
                this.mAreAllFixedViewsSelectable = z;
                return true;
            }
        }
        return false;
    }

    public boolean removeHeader(View view) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-1553264418")) {
            return ((Boolean) ipChange.ipc$dispatch("-1553264418", new Object[]{this, view})).booleanValue();
        }
        for (int i = 0; i < this.mHeaderViewInfos.size(); i++) {
            if (this.mHeaderViewInfos.get(i).a == view) {
                this.mHeaderViewInfos.remove(i);
                if (areAllListInfosSelectable(this.mHeaderViewInfos) && areAllListInfosSelectable(this.mFooterViewInfos)) {
                    z = true;
                }
                this.mAreAllFixedViewsSelectable = z;
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "854367396")) {
            ipChange.ipc$dispatch("854367396", new Object[]{this, dataSetObserver});
            return;
        }
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null) {
            listAdapter.unregisterDataSetObserver(dataSetObserver);
        }
    }
}
