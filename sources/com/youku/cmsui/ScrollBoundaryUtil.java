package com.youku.cmsui;

import android.graphics.PointF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.youku.resource.R;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ScrollBoundaryUtil {
    private static final String TAG = "ScrollBoundaryUtil";

    public static boolean canLoadMore(@NonNull View view, PointF pointF, boolean z) {
        if (canScrollDown(view) && view.getVisibility() == 0) {
            return false;
        }
        if ((view instanceof ViewGroup) && pointF != null) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            PointF pointF2 = new PointF();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (isTransformedTouchPointInView(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    pointF.offset(pointF2.x, pointF2.y);
                    boolean canLoadMore = canLoadMore(childAt, pointF, z);
                    pointF.offset(-pointF2.x, -pointF2.y);
                    return canLoadMore;
                }
            }
        }
        return z || canScrollUp(view);
    }

    public static boolean canScrollDown(@NonNull View view) {
        int i;
        if (Build.VERSION.SDK_INT < 14) {
            if (!(view instanceof AbsListView)) {
                return view.getScrollY() < 0;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            AbsListView absListView = (AbsListView) view;
            int childCount = viewGroup.getChildCount();
            return childCount > 0 && (absListView.getLastVisiblePosition() < (i = childCount - 1) || viewGroup.getChildAt(i).getBottom() > view.getPaddingBottom());
        } else if (view instanceof RecyclerView) {
            return canScrollVertically((RecyclerView) view, 1);
        } else {
            return view.canScrollVertically(1);
        }
    }

    public static boolean canScrollUp(@NonNull View view) {
        if (Build.VERSION.SDK_INT < 14) {
            if (!(view instanceof AbsListView)) {
                return view.getScrollY() > 0;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            return viewGroup.getChildCount() > 0 && (((AbsListView) view).getFirstVisiblePosition() > 0 || viewGroup.getChildAt(0).getTop() < view.getPaddingTop());
        } else if (view instanceof RecyclerView) {
            return canScrollVertically((RecyclerView) view, -1);
        } else {
            return view.canScrollVertically(-1);
        }
    }

    public static boolean canScrollVertically(RecyclerView recyclerView, int i) {
        if (recyclerView == null || recyclerView.getContext() == null) {
            return false;
        }
        int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
        int computeVerticalScrollRange = recyclerView.computeVerticalScrollRange() - getComputeVerticalScrollExtent(recyclerView);
        if (computeVerticalScrollRange == 0) {
            return false;
        }
        return i < 0 ? computeVerticalScrollOffset > 0 : computeVerticalScrollOffset < computeVerticalScrollRange - 1;
    }

    private static int getComputeVerticalScrollExtent(RecyclerView recyclerView) {
        int computeVerticalScrollExtent = recyclerView.computeVerticalScrollExtent();
        int storeExtent = getStoreExtent(recyclerView);
        if (storeExtent == 0) {
            putStoreExtent(recyclerView, computeVerticalScrollExtent);
        } else {
            computeVerticalScrollExtent = Math.max(computeVerticalScrollExtent, storeExtent);
            if (computeVerticalScrollExtent != storeExtent) {
                putStoreExtent(recyclerView, computeVerticalScrollExtent);
            }
        }
        return computeVerticalScrollExtent;
    }

    private static int getStoreExtent(RecyclerView recyclerView) {
        try {
            Object tag = recyclerView.getTag(R.id.recyclerview_extent);
            if (tag instanceof Integer) {
                return ((Integer) tag).intValue();
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static boolean isTransformedTouchPointInView(@NonNull View view, @NonNull View view2, float f, float f2, PointF pointF) {
        if (view2.getVisibility() != 0) {
            return false;
        }
        float[] fArr = {f, f2};
        fArr[0] = fArr[0] + (view.getScrollX() - view2.getLeft());
        fArr[1] = fArr[1] + (view.getScrollY() - view2.getTop());
        boolean z = fArr[0] >= 0.0f && fArr[1] >= 0.0f && fArr[0] < ((float) view2.getWidth()) && fArr[1] < ((float) view2.getHeight());
        if (z && pointF != null) {
            pointF.set(fArr[0] - f, fArr[1] - f2);
        }
        return z;
    }

    private static void putStoreExtent(RecyclerView recyclerView, int i) {
        recyclerView.setTag(R.id.recyclerview_extent, Integer.valueOf(i));
    }
}
