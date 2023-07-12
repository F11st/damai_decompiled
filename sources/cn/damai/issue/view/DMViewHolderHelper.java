package cn.damai.issue.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.issue.listener.DMOnItemChildCheckedChangeListener;
import cn.damai.issue.listener.DMOnItemChildClickListener;
import cn.damai.issue.listener.DMOnItemChildLongClickListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class DMViewHolderHelper implements View.OnClickListener, View.OnLongClickListener, CompoundButton.OnCheckedChangeListener {
    private static transient /* synthetic */ IpChange $ipChange;
    protected ViewGroup mAdapterView;
    protected Context mContext;
    protected View mConvertView;
    protected Object mObj;
    protected DMOnItemChildCheckedChangeListener mOnItemChildCheckedChangeListener;
    protected DMOnItemChildClickListener mOnItemChildClickListener;
    protected DMOnItemChildLongClickListener mOnItemChildLongClickListener;
    protected int mPosition;
    protected RecyclerView mRecyclerView;
    protected DMRecyclerViewHolder mRecyclerViewHolder;
    protected final SparseArray<View> mViews = new SparseArray<>();

    public DMViewHolderHelper(ViewGroup viewGroup, View view) {
        this.mAdapterView = viewGroup;
        this.mConvertView = view;
        this.mContext = view.getContext();
    }

    public View getConvertView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1494920694") ? (View) ipChange.ipc$dispatch("1494920694", new Object[]{this}) : this.mConvertView;
    }

    public ImageView getImageView(@IdRes int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-573095239") ? (ImageView) ipChange.ipc$dispatch("-573095239", new Object[]{this, Integer.valueOf(i)}) : (ImageView) getView(i);
    }

    public Object getObj() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-733925251") ? ipChange.ipc$dispatch("-733925251", new Object[]{this}) : this.mObj;
    }

    public int getPosition() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-555258936")) {
            return ((Integer) ipChange.ipc$dispatch("-555258936", new Object[]{this})).intValue();
        }
        DMRecyclerViewHolder dMRecyclerViewHolder = this.mRecyclerViewHolder;
        if (dMRecyclerViewHolder != null) {
            return dMRecyclerViewHolder.getAdapterPosition();
        }
        return this.mPosition;
    }

    public DMRecyclerViewHolder getRecyclerViewHolder() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "137132997") ? (DMRecyclerViewHolder) ipChange.ipc$dispatch("137132997", new Object[]{this}) : this.mRecyclerViewHolder;
    }

    public TextView getTextView(@IdRes int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1735637749") ? (TextView) ipChange.ipc$dispatch("-1735637749", new Object[]{this, Integer.valueOf(i)}) : (TextView) getView(i);
    }

    public <T extends View> T getView(@IdRes int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1822698868")) {
            return (T) ipChange.ipc$dispatch("-1822698868", new Object[]{this, Integer.valueOf(i)});
        }
        T t = (T) this.mViews.get(i);
        if (t == null) {
            T t2 = (T) this.mConvertView.findViewById(i);
            this.mViews.put(i, t2);
            return t2;
        }
        return t;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "960673925")) {
            ipChange.ipc$dispatch("960673925", new Object[]{this, compoundButton, Boolean.valueOf(z)});
            return;
        }
        DMOnItemChildCheckedChangeListener dMOnItemChildCheckedChangeListener = this.mOnItemChildCheckedChangeListener;
        if (dMOnItemChildCheckedChangeListener != null) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                dMOnItemChildCheckedChangeListener.onItemChildCheckedChanged(recyclerView, compoundButton, getPosition(), z);
                return;
            }
            ViewGroup viewGroup = this.mAdapterView;
            if (viewGroup != null) {
                dMOnItemChildCheckedChangeListener.onItemChildCheckedChanged(viewGroup, compoundButton, getPosition(), z);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1633559591")) {
            ipChange.ipc$dispatch("1633559591", new Object[]{this, view});
            return;
        }
        DMOnItemChildClickListener dMOnItemChildClickListener = this.mOnItemChildClickListener;
        if (dMOnItemChildClickListener != null) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                dMOnItemChildClickListener.onItemChildClick(recyclerView, view, getPosition());
                return;
            }
            ViewGroup viewGroup = this.mAdapterView;
            if (viewGroup != null) {
                dMOnItemChildClickListener.onItemChildClick(viewGroup, view, getPosition());
            }
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-266627313")) {
            return ((Boolean) ipChange.ipc$dispatch("-266627313", new Object[]{this, view})).booleanValue();
        }
        DMOnItemChildLongClickListener dMOnItemChildLongClickListener = this.mOnItemChildLongClickListener;
        if (dMOnItemChildLongClickListener != null) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return dMOnItemChildLongClickListener.onItemChildLongClick(recyclerView, view, getPosition());
            }
            ViewGroup viewGroup = this.mAdapterView;
            if (viewGroup != null) {
                return dMOnItemChildLongClickListener.onItemChildLongClick(viewGroup, view, getPosition());
            }
        }
        return false;
    }

    public DMViewHolderHelper setBackgroundColor(@IdRes int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1875192641")) {
            return (DMViewHolderHelper) ipChange.ipc$dispatch("1875192641", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        getView(i).setBackgroundColor(i2);
        return this;
    }

    public DMViewHolderHelper setBackgroundColorRes(@IdRes int i, @ColorRes int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1677443229")) {
            return (DMViewHolderHelper) ipChange.ipc$dispatch("1677443229", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        getView(i).setBackgroundColor(this.mContext.getResources().getColor(i2));
        return this;
    }

    public DMViewHolderHelper setBackgroundRes(@IdRes int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-740342594")) {
            return (DMViewHolderHelper) ipChange.ipc$dispatch("-740342594", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        getView(i).setBackgroundResource(i2);
        return this;
    }

    public DMViewHolderHelper setChecked(@IdRes int i, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1648360158")) {
            return (DMViewHolderHelper) ipChange.ipc$dispatch("-1648360158", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)});
        }
        ((Checkable) getView(i)).setChecked(z);
        return this;
    }

    public DMViewHolderHelper setHtml(@IdRes int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "964740894")) {
            return (DMViewHolderHelper) ipChange.ipc$dispatch("964740894", new Object[]{this, Integer.valueOf(i), str});
        }
        ((TextView) getView(i)).setText(Html.fromHtml(str));
        return this;
    }

    public DMViewHolderHelper setImageBitmap(@IdRes int i, Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-204704437")) {
            return (DMViewHolderHelper) ipChange.ipc$dispatch("-204704437", new Object[]{this, Integer.valueOf(i), bitmap});
        }
        ((ImageView) getView(i)).setImageBitmap(bitmap);
        return this;
    }

    public DMViewHolderHelper setImageDrawable(@IdRes int i, Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "928021948")) {
            return (DMViewHolderHelper) ipChange.ipc$dispatch("928021948", new Object[]{this, Integer.valueOf(i), drawable});
        }
        ((ImageView) getView(i)).setImageDrawable(drawable);
        return this;
    }

    public DMViewHolderHelper setImageResource(@IdRes int i, @DrawableRes int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1872691253")) {
            return (DMViewHolderHelper) ipChange.ipc$dispatch("1872691253", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        ((ImageView) getView(i)).setImageResource(i2);
        return this;
    }

    public void setItemChildCheckedChangeListener(@IdRes int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1479807821")) {
            ipChange.ipc$dispatch("-1479807821", new Object[]{this, Integer.valueOf(i)});
        } else if (getView(i) instanceof CompoundButton) {
            ((CompoundButton) getView(i)).setOnCheckedChangeListener(this);
        }
    }

    public void setItemChildClickListener(@IdRes int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2046076036")) {
            ipChange.ipc$dispatch("2046076036", new Object[]{this, Integer.valueOf(i)});
        } else {
            getView(i).setOnClickListener(this);
        }
    }

    public void setItemChildLongClickListener(@IdRes int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1846335592")) {
            ipChange.ipc$dispatch("1846335592", new Object[]{this, Integer.valueOf(i)});
        } else {
            getView(i).setOnLongClickListener(this);
        }
    }

    public void setObj(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "545900797")) {
            ipChange.ipc$dispatch("545900797", new Object[]{this, obj});
        } else {
            this.mObj = obj;
        }
    }

    public void setOnItemChildCheckedChangeListener(DMOnItemChildCheckedChangeListener dMOnItemChildCheckedChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-253408724")) {
            ipChange.ipc$dispatch("-253408724", new Object[]{this, dMOnItemChildCheckedChangeListener});
        } else {
            this.mOnItemChildCheckedChangeListener = dMOnItemChildCheckedChangeListener;
        }
    }

    public void setOnItemChildClickListener(DMOnItemChildClickListener dMOnItemChildClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "686296778")) {
            ipChange.ipc$dispatch("686296778", new Object[]{this, dMOnItemChildClickListener});
        } else {
            this.mOnItemChildClickListener = dMOnItemChildClickListener;
        }
    }

    public void setOnItemChildLongClickListener(DMOnItemChildLongClickListener dMOnItemChildLongClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "365200770")) {
            ipChange.ipc$dispatch("365200770", new Object[]{this, dMOnItemChildLongClickListener});
        } else {
            this.mOnItemChildLongClickListener = dMOnItemChildLongClickListener;
        }
    }

    public void setPosition(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "877624538")) {
            ipChange.ipc$dispatch("877624538", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mPosition = i;
        }
    }

    public void setRecyclerViewHolder(DMRecyclerViewHolder dMRecyclerViewHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-726391425")) {
            ipChange.ipc$dispatch("-726391425", new Object[]{this, dMRecyclerViewHolder});
        } else {
            this.mRecyclerViewHolder = dMRecyclerViewHolder;
        }
    }

    public DMViewHolderHelper setTag(@IdRes int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-160949277")) {
            return (DMViewHolderHelper) ipChange.ipc$dispatch("-160949277", new Object[]{this, Integer.valueOf(i), obj});
        }
        getView(i).setTag(obj);
        return this;
    }

    public DMViewHolderHelper setText(@IdRes int i, CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "205089602")) {
            return (DMViewHolderHelper) ipChange.ipc$dispatch("205089602", new Object[]{this, Integer.valueOf(i), charSequence});
        }
        ((TextView) getView(i)).setText(charSequence);
        return this;
    }

    public DMViewHolderHelper setTextColor(@IdRes int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "661638882")) {
            return (DMViewHolderHelper) ipChange.ipc$dispatch("661638882", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        ((TextView) getView(i)).setTextColor(i2);
        return this;
    }

    public DMViewHolderHelper setTextColorRes(@IdRes int i, @ColorRes int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-562860708")) {
            return (DMViewHolderHelper) ipChange.ipc$dispatch("-562860708", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        ((TextView) getView(i)).setTextColor(this.mContext.getResources().getColor(i2));
        return this;
    }

    public DMViewHolderHelper setVisibility(@IdRes int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-943469916")) {
            return (DMViewHolderHelper) ipChange.ipc$dispatch("-943469916", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        View view = getView(i);
        if (view.getVisibility() != i2) {
            view.setVisibility(i2);
        }
        return this;
    }

    public DMViewHolderHelper setTag(@IdRes int i, int i2, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1420261418")) {
            return (DMViewHolderHelper) ipChange.ipc$dispatch("1420261418", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), obj});
        }
        getView(i).setTag(i2, obj);
        return this;
    }

    public DMViewHolderHelper setText(@IdRes int i, @StringRes int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1275846271")) {
            return (DMViewHolderHelper) ipChange.ipc$dispatch("1275846271", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        ((TextView) getView(i)).setText(i2);
        return this;
    }

    public DMViewHolderHelper(RecyclerView recyclerView, View view) {
        this.mRecyclerView = recyclerView;
        this.mConvertView = view;
        this.mContext = view.getContext();
    }
}
