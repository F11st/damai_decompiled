package cn.damai.tetris.componentplugin;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.tetris.component.drama.bean.AnchorBean;
import cn.damai.tetris.component.drama.bean.AnchorEvent;
import cn.damai.tetris.component.drama.bean.AnchorList;
import cn.damai.tetris.component.drama.mvp.AnchorFloatingView;
import cn.damai.tetris.core.NodeData;
import cn.damai.tetris.v2.componentplugin.ComponentPageUi;
import cn.damai.tetris.v2.componentplugin.ComponentPlugin;
import cn.damai.tetris.v2.structure.section.ISection;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.m61;
import tb.m62;
import tb.mu0;
import tb.r3;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class AnchorFloatingPlugin extends ComponentPlugin {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isKeepListenScroll;
    private AnchorList mAnchorList;
    private r3 mAptIds;
    private int mFloatViewHeight;
    private AnchorFloatingView mFloatingView;
    private HashMap<Integer, AnchorBean> mId2BeanMap;
    private RecyclerView mRecycler;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.componentplugin.AnchorFloatingPlugin$a */
    /* loaded from: classes16.dex */
    public class View$OnTouchListenerC1979a implements View.OnTouchListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnTouchListenerC1979a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-912812373")) {
                return ((Boolean) ipChange.ipc$dispatch("-912812373", new Object[]{this, view, motionEvent})).booleanValue();
            }
            AnchorFloatingPlugin.this.isKeepListenScroll = true;
            return false;
        }
    }

    public AnchorFloatingPlugin(ComponentPageUi componentPageUi) {
        super(componentPageUi);
        this.isKeepListenScroll = true;
        this.mAptIds = r3.a();
        this.mRecycler = componentPageUi.getRecycler();
        this.mFloatViewHeight = m62.a(mu0.a(), 38.0f);
        addScrollListener();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void addScrollListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "396487147")) {
            ipChange.ipc$dispatch("396487147", new Object[]{this});
            return;
        }
        RecyclerView recyclerView = this.mRecycler;
        if (recyclerView == null) {
            return;
        }
        recyclerView.setOnTouchListener(new View$OnTouchListenerC1979a());
        this.mRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: cn.damai.tetris.componentplugin.AnchorFloatingPlugin.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView2, int i, int i2) {
                int childAdapterPosition;
                int itemCount;
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1351273609")) {
                    ipChange2.ipc$dispatch("-1351273609", new Object[]{this, recyclerView2, Integer.valueOf(i), Integer.valueOf(i2)});
                } else if (AnchorFloatingPlugin.this.isKeepListenScroll && i2 != 0 && AnchorFloatingPlugin.this.mAnchorList != null && AnchorFloatingPlugin.this.mId2BeanMap != null && AnchorFloatingPlugin.this.mFloatingView != null) {
                    View childAt = recyclerView2.getChildAt(0);
                    RecyclerView.Adapter adapter = recyclerView2.getAdapter();
                    if (childAt == null || adapter == null || (itemCount = adapter.getItemCount() - (childAdapterPosition = recyclerView2.getChildAdapterPosition(childAt))) <= 0) {
                        return;
                    }
                    for (int i3 = 0; i3 < itemCount; i3++) {
                        AnchorBean anchorBean = (AnchorBean) AnchorFloatingPlugin.this.mId2BeanMap.get(Integer.valueOf(AnchorFloatingPlugin.this.mAptIds.c(adapter.getItemId(i3 + childAdapterPosition))));
                        if (anchorBean != null) {
                            if (AnchorFloatingPlugin.this.mAnchorList.setSelectBean(anchorBean)) {
                                AnchorFloatingPlugin.this.mFloatingView.notifyItemChanged();
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        });
    }

    private void autoScrollToAnchor(AnchorBean anchorBean) {
        RecyclerView recyclerView;
        RecyclerView.Adapter adapter;
        int itemCount;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "120322145")) {
            ipChange.ipc$dispatch("120322145", new Object[]{this, anchorBean});
        } else if (anchorBean != null && !TextUtils.isEmpty(anchorBean.sectionId) && (recyclerView = this.mRecycler) != null && recyclerView.getAdapter() != null && (itemCount = (adapter = this.mRecycler.getAdapter()).getItemCount()) > 0) {
            int b = this.mAptIds.b(anchorBean.sectionId);
            for (int i = 0; i < itemCount; i++) {
                if (this.mAptIds.c(adapter.getItemId(i)) == b) {
                    RecyclerView.LayoutManager layoutManager = this.mRecycler.getLayoutManager();
                    if (layoutManager instanceof LinearLayoutManager) {
                        ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, this.mFloatViewHeight);
                        return;
                    } else {
                        this.mRecycler.smoothScrollToPosition(i);
                        return;
                    }
                }
            }
        }
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public boolean onLoadMore() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1315139449")) {
            return ((Boolean) ipChange.ipc$dispatch("-1315139449", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public boolean onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1924144990")) {
            return ((Boolean) ipChange.ipc$dispatch("1924144990", new Object[]{this, Integer.valueOf(i), obj})).booleanValue();
        }
        if (obj instanceof AnchorEvent) {
            AnchorEvent anchorEvent = (AnchorEvent) obj;
            if (i == 51) {
                this.isKeepListenScroll = false;
                autoScrollToAnchor(anchorEvent.select);
            } else if (i == 52) {
                this.mFloatingView = anchorEvent.mFloatingView;
            }
            return true;
        }
        return false;
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public boolean onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-941956779")) {
            return ((Boolean) ipChange.ipc$dispatch("-941956779", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public void onSectionBind(ISection iSection) {
        JSONObject item;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1908430973")) {
            ipChange.ipc$dispatch("1908430973", new Object[]{this, iSection});
        } else if (iSection == null || (item = iSection.getItem()) == null) {
        } else {
            AnchorList anchorList = (AnchorList) m61.d(new NodeData(item), AnchorList.class);
            this.mAnchorList = anchorList;
            if (anchorList != null) {
                anchorList.setSelectBean(anchorList.first());
                this.mAnchorList.sectionIdBindAptId();
                this.mId2BeanMap = this.mAnchorList.id2BeanMap;
            }
            iSection.setExtra(this.mAnchorList);
        }
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public void onSectionRemoved(@Nullable ISection iSection) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "747950212")) {
            ipChange.ipc$dispatch("747950212", new Object[]{this, iSection});
            return;
        }
        this.mFloatingView = null;
        this.mAnchorList = null;
        this.mId2BeanMap = null;
    }
}
