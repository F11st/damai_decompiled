package com.taobao.weex.ui.component.list.template;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.collection.ArrayMap;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.taobao.weex.common.Constants;
import com.taobao.weex.ui.view.listview.WXRecyclerView;
import com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TemplateStickyHelper {
    private WXRecyclerTemplateList recyclerTemplateList;
    private List<Integer> stickyPositions = new ArrayList();
    private ArrayMap<Integer, TemplateViewHolder> stickyHolderCache = new ArrayMap<>();
    private List<String> mStickyTypes = new ArrayList(8);

    public TemplateStickyHelper(WXRecyclerTemplateList wXRecyclerTemplateList) {
        this.recyclerTemplateList = wXRecyclerTemplateList;
    }

    public List<Integer> getStickyPositions() {
        if (this.stickyPositions == null) {
            this.stickyPositions = new ArrayList();
        }
        return this.stickyPositions;
    }

    public List<String> getStickyTypes() {
        return this.mStickyTypes;
    }

    public void onBeforeScroll(int i, int i2) {
        int i3;
        int i4;
        TemplateViewHolder templateViewHolder;
        List<Integer> list = this.stickyPositions;
        if (list == null || list.size() == 0) {
            return;
        }
        BounceRecyclerView bounceRecyclerView = (BounceRecyclerView) this.recyclerTemplateList.getHostView();
        WXRecyclerView innerView = ((BounceRecyclerView) this.recyclerTemplateList.getHostView()).getInnerView();
        RecyclerView.LayoutManager layoutManager = innerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            i4 = linearLayoutManager.findFirstVisibleItemPosition();
            i3 = linearLayoutManager.findLastVisibleItemPosition();
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            int[] iArr = new int[3];
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            int i5 = staggeredGridLayoutManager.findFirstVisibleItemPositions(iArr)[0];
            i3 = staggeredGridLayoutManager.findLastVisibleItemPositions(iArr)[0];
            i4 = i5;
        } else {
            i3 = -1;
            i4 = -1;
        }
        if (i4 >= 0 && (templateViewHolder = (TemplateViewHolder) innerView.findViewHolderForAdapterPosition(i4)) != null) {
            int i6 = -1;
            for (Integer num : this.stickyPositions) {
                if (num != null) {
                    if (num.intValue() > i4) {
                        break;
                    }
                    i6 = Math.max(i6, num.intValue());
                }
            }
            if (i6 < 0) {
                View childAt = bounceRecyclerView.getChildAt(bounceRecyclerView.getChildCount() - 1);
                if (childAt.getTag() instanceof TemplateViewHolder) {
                    TemplateViewHolder templateViewHolder2 = (TemplateViewHolder) childAt.getTag();
                    bounceRecyclerView.removeView(templateViewHolder2.itemView);
                    templateViewHolder2.itemView.setTranslationY(0.0f);
                    if (templateViewHolder2.getComponent() != null && templateViewHolder2.getComponent().getEvents().contains(Constants.Event.UNSTICKY)) {
                        templateViewHolder2.getComponent().fireEvent(Constants.Event.UNSTICKY);
                    }
                }
                for (int i7 = 0; i7 < innerView.getChildCount(); i7++) {
                    View childAt2 = innerView.getChildAt(i7);
                    TemplateViewHolder templateViewHolder3 = (TemplateViewHolder) innerView.getChildViewHolder(childAt2);
                    if (templateViewHolder3 != null) {
                        if (this.stickyPositions.contains(Integer.valueOf(templateViewHolder3.getAdapterPosition())) && childAt2.getVisibility() != 0) {
                            childAt2.setVisibility(0);
                        }
                    }
                }
                return;
            }
            View childAt3 = bounceRecyclerView.getChildAt(bounceRecyclerView.getChildCount() - 1);
            if (!(childAt3.getTag() instanceof TemplateViewHolder) || ((TemplateViewHolder) childAt3.getTag()).getHolderPosition() != i6) {
                if ((childAt3.getTag() instanceof TemplateViewHolder) && ((TemplateViewHolder) childAt3.getTag()).getHolderPosition() != i6) {
                    TemplateViewHolder templateViewHolder4 = (TemplateViewHolder) childAt3.getTag();
                    bounceRecyclerView.removeView(templateViewHolder4.itemView);
                    templateViewHolder4.itemView.setTranslationY(0.0f);
                    if (templateViewHolder4.getComponent() != null && templateViewHolder4.getComponent().getEvents().contains(Constants.Event.UNSTICKY)) {
                        templateViewHolder4.getComponent().fireEvent(Constants.Event.UNSTICKY);
                    }
                }
                int itemViewType = this.recyclerTemplateList.getItemViewType(i6);
                TemplateViewHolder templateViewHolder5 = this.stickyHolderCache.get(Integer.valueOf(itemViewType));
                if (templateViewHolder5 == null) {
                    templateViewHolder5 = this.recyclerTemplateList.onCreateViewHolder((ViewGroup) innerView, itemViewType);
                    this.stickyHolderCache.put(Integer.valueOf(itemViewType), templateViewHolder5);
                }
                this.recyclerTemplateList.onBindViewHolder(templateViewHolder5, i6);
                templateViewHolder5.itemView.setTranslationY(0.0f);
                templateViewHolder5.itemView.setTag(templateViewHolder5);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                templateViewHolder5.getComponent().clearPreLayout();
                if (templateViewHolder5.itemView.getParent() != null) {
                    ((ViewGroup) templateViewHolder5.itemView.getParent()).removeView(templateViewHolder5.itemView);
                }
                bounceRecyclerView.addView(templateViewHolder5.itemView, layoutParams);
                templateViewHolder5.getComponent().setLayout(templateViewHolder5.getComponent());
                View view = templateViewHolder5.itemView;
                if (templateViewHolder5.getComponent() != null && templateViewHolder5.getComponent().getEvents().contains("sticky")) {
                    templateViewHolder5.getComponent().fireEvent("sticky");
                }
                childAt3 = view;
            }
            TemplateViewHolder templateViewHolder6 = (TemplateViewHolder) childAt3.getTag();
            for (int i8 = 0; i8 < innerView.getChildCount(); i8++) {
                View childAt4 = innerView.getChildAt(i8);
                TemplateViewHolder templateViewHolder7 = (TemplateViewHolder) innerView.getChildViewHolder(childAt4);
                if (templateViewHolder7 != null) {
                    int adapterPosition = templateViewHolder7.getAdapterPosition();
                    if (this.stickyPositions.contains(Integer.valueOf(adapterPosition))) {
                        if (adapterPosition == templateViewHolder6.getHolderPosition()) {
                            if (childAt4.getVisibility() != 4) {
                                childAt4.setVisibility(4);
                            }
                        } else if (childAt4.getVisibility() != 0) {
                            childAt4.setVisibility(0);
                        }
                    }
                }
            }
            if (templateViewHolder.getComponent().isSticky()) {
                if (templateViewHolder.itemView.getY() < 0.0f) {
                    if (templateViewHolder.itemView.getVisibility() != 4) {
                        templateViewHolder.itemView.setVisibility(4);
                    }
                    if (childAt3.getVisibility() != 0) {
                        childAt3.setVisibility(0);
                    }
                    childAt3.bringToFront();
                } else {
                    if (templateViewHolder.itemView.getVisibility() != 0) {
                        templateViewHolder.itemView.setVisibility(0);
                    }
                    if (childAt3.getVisibility() != 8) {
                        childAt3.setVisibility(8);
                    }
                }
            } else if (childAt3.getVisibility() != 0) {
                childAt3.setVisibility(0);
            }
            int i9 = i4 + 1;
            if (i3 > 0) {
                int i10 = i9;
                while (true) {
                    if (i10 > i3) {
                        break;
                    } else if (this.stickyPositions.contains(Integer.valueOf(i10))) {
                        i9 = i10;
                        break;
                    } else {
                        i10++;
                    }
                }
            }
            if (!this.stickyPositions.contains(Integer.valueOf(i9))) {
                if (templateViewHolder6.itemView.getTranslationY() < 0.0f) {
                    templateViewHolder6.itemView.setTranslationY(0.0f);
                    return;
                }
                return;
            }
            TemplateViewHolder templateViewHolder8 = (TemplateViewHolder) innerView.findViewHolderForAdapterPosition(i9);
            if (templateViewHolder8 == null || templateViewHolder8.getComponent() == null) {
                return;
            }
            int y = (int) (templateViewHolder8.itemView.getY() - templateViewHolder6.itemView.getMeasuredHeight());
            if (y <= 0) {
                templateViewHolder6.itemView.setTranslationY(y);
            } else {
                templateViewHolder6.itemView.setTranslationY(0.0f);
            }
        }
    }
}
