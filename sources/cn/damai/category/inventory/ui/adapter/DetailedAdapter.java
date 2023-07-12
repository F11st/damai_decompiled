package cn.damai.category.inventory.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.inventory.bean.DetailedDataHolder;
import cn.damai.category.inventory.ui.viewholder.DetailedEndItemHolder;
import cn.damai.category.inventory.ui.viewholder.DetailedItemHolder;
import cn.damai.category.inventory.ui.viewholder.DetailedItemTopHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class DetailedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int END_TYPE = 1;
    public static final int FIRST_TYPE = 2;
    public static final int OTHER_TYPE = 0;
    private Context a;
    private List<DetailedDataHolder> b;
    private String c;
    private String d;
    private int e;
    private int[] f;

    public DetailedAdapter(Context context, List<DetailedDataHolder> list) {
        this.a = context;
        this.b = list;
    }

    public void a(int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1629028260")) {
            ipChange.ipc$dispatch("1629028260", new Object[]{this, iArr});
        } else {
            this.f = iArr;
        }
    }

    public void b(String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2124586525")) {
            ipChange.ipc$dispatch("-2124586525", new Object[]{this, str, str2, Integer.valueOf(i)});
            return;
        }
        this.c = str;
        this.d = str2;
        this.e = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1785241967") ? ((Integer) ipChange.ipc$dispatch("1785241967", new Object[]{this})).intValue() : wh2.e(this.b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "459885718") ? ((Integer) ipChange.ipc$dispatch("459885718", new Object[]{this, Integer.valueOf(i)})).intValue() : this.b.get(i).mType;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-619670998")) {
            ipChange.ipc$dispatch("-619670998", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else if (viewHolder != null) {
            DetailedDataHolder detailedDataHolder = this.b.get(i);
            int i2 = detailedDataHolder.mType;
            if (i2 == 0) {
                DetailedItemHolder detailedItemHolder = (DetailedItemHolder) viewHolder;
                detailedItemHolder.d(this.c, this.d, this.e);
                detailedItemHolder.a(detailedDataHolder.itemsBean, i);
            } else if (i2 != 2) {
            } else {
                DetailedItemTopHolder detailedItemTopHolder = (DetailedItemTopHolder) viewHolder;
                detailedItemTopHolder.i(this.c, this.d, this.f);
                detailedItemTopHolder.a(detailedDataHolder.topItems);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2025501428")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-2025501428", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        LayoutInflater from = LayoutInflater.from(this.a);
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return new DetailedItemTopHolder(from);
            }
            return new DetailedEndItemHolder(from);
        }
        return new DetailedItemHolder(from);
    }
}
