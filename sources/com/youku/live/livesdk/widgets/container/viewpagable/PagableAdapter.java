package com.youku.live.livesdk.widgets.container.viewpagable;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.LiveRoomConstants;
import com.youku.live.livesdk.widgets.container.pagable.LiveContentView;
import com.youku.live.livesdk.widgets.container.pager.model.SwitchItemModel;
import com.youku.live.livesdk.widgets.helper.Accessor;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PagableAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
    private static transient /* synthetic */ IpChange $ipChange;
    public final String TAG = "LivePagableAdapter";
    public final String TAG_APPEAR = "LivePagableAppear";
    public List<SwitchItemModel> mItemList = new LinkedList();
    public Map<Integer, LiveContentView> mRoomListInUse = new HashMap();
    public Queue<LiveContentView> mRoomListInCache = new LinkedList();
    private int mLastPosition = -1;
    private int mLastSelected = -1;

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1652163041")) {
            ipChange.ipc$dispatch("1652163041", new Object[]{this, viewGroup, Integer.valueOf(i), obj});
            return;
        }
        Log.e("LivePagableAdapter", "destroyItem('" + viewGroup + "', '" + i + "', '" + obj + "')");
        if (obj instanceof LiveContentView) {
            LiveContentView liveContentView = (LiveContentView) obj;
            viewGroup.removeView(liveContentView);
            this.mRoomListInUse.remove(Integer.valueOf(i));
            liveContentView.getInstance().putData(LiveRoomConstants.DATA_ROOM_FINISH, Boolean.TRUE);
            this.mRoomListInCache.add(liveContentView);
        }
    }

    public LiveContentView getContentViewByIndex(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-830606554") ? (LiveContentView) ipChange.ipc$dispatch("-830606554", new Object[]{this, Integer.valueOf(i)}) : this.mRoomListInUse.get(Integer.valueOf(i));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1687342264")) {
            return ((Integer) ipChange.ipc$dispatch("1687342264", new Object[]{this})).intValue();
        }
        List<SwitchItemModel> list = this.mItemList;
        int size = list != null ? list.size() : 0;
        Log.e("LivePagableAdapter", "getCount() = " + size);
        return size;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-784414691")) {
            return ipChange.ipc$dispatch("-784414691", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        Log.e("LivePagableAdapter", "instantiateItem('" + viewGroup + "', '" + i + "')");
        SwitchItemModel switchItemModel = this.mItemList.get(i);
        LiveContentView poll = this.mRoomListInCache.poll();
        if (poll == null) {
            TextView textView = new TextView(viewGroup.getContext());
            textView.setTextSize(56.0f);
            textView.setTextColor(InputDeviceCompat.SOURCE_ANY);
            LiveContentView liveContentView = new LiveContentView(viewGroup.getContext());
            liveContentView.addView(textView);
            poll = liveContentView;
        }
        View childAt = poll.getChildAt(poll.getChildCount() - 1);
        if (childAt instanceof TextView) {
            ((TextView) childAt).setText("" + i);
        }
        this.mRoomListInUse.put(Integer.valueOf(i), poll);
        poll.getInstance().asyncPutData("DATA_KEY_LAIFENG_KEYBOARD_SHOW", Boolean.FALSE);
        poll.updateWithRoomInfo(i, switchItemModel);
        viewGroup.addView(poll);
        return poll;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "898579724")) {
            return ((Boolean) ipChange.ipc$dispatch("898579724", new Object[]{this, view, obj})).booleanValue();
        }
        Log.e("LivePagableAdapter", "isViewFromObject('" + view + "', '" + obj + "')");
        return view == obj;
    }

    public void notifyAllViews(Accessor<LiveContentView> accessor) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1531728769")) {
            ipChange.ipc$dispatch("-1531728769", new Object[]{this, accessor});
            return;
        }
        for (Map.Entry<Integer, LiveContentView> entry : this.mRoomListInUse.entrySet()) {
            accessor.onAccess(entry.getValue());
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2079006979")) {
            ipChange.ipc$dispatch("2079006979", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        Log.e("LivePagableAdapter", "onPageScrollStateChanged('" + i + "')");
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2141741218")) {
            ipChange.ipc$dispatch("2141741218", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
            return;
        }
        int i3 = (f <= 0.0f ? 0 : 1) + i;
        int i4 = this.mLastPosition;
        if (i3 != i4) {
            this.mLastPosition = i3;
            if (this.mLastSelected == i3) {
                getContentViewByIndex(i4).getInstance().didDisappear();
                getContentViewByIndex(i3).getInstance().didAppear();
            } else {
                getContentViewByIndex(i3).getInstance().didAppear();
            }
            Log.e("LivePagableAppear", "didAppear('" + i3 + "')");
        }
        Log.e("LivePagableAdapter", "onPageScrolled('" + i + "', '" + i3 + "', '" + f + "', '" + i2 + "')");
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-252913650")) {
            ipChange.ipc$dispatch("-252913650", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mLastSelected = i;
        for (Map.Entry<Integer, LiveContentView> entry : this.mRoomListInUse.entrySet()) {
            int intValue = entry.getKey().intValue();
            LiveContentView value = entry.getValue();
            if (intValue == i) {
                value.getInstance().didActive();
                Log.e("LivePagableAppear", "didActive('" + intValue + "')");
            } else {
                value.getInstance().didDisappear();
                Log.e("LivePagableAppear", "didDisappear('" + intValue + "')");
                value.getInstance().didDeactive();
                Log.e("LivePagableAppear", "didDeactive('" + intValue + "')");
            }
        }
        Log.e("LivePagableAdapter", "onPageSelected('" + i + "')");
    }

    public void setDataList(List<SwitchItemModel> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "657183315")) {
            ipChange.ipc$dispatch("657183315", new Object[]{this, list});
        } else {
            this.mItemList = list;
        }
    }
}
