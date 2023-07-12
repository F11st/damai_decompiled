package com.youku.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.taobao.phenix.animate.AnimatedImageDrawable;
import com.taobao.uikit.extend.feature.features.ImageLoadFeature;
import com.taobao.uikit.extend.feature.view.TUrlImageView;
import com.taobao.uikit.feature.callback.RecyclerAdapterCallback;
import com.taobao.uikit.feature.features.AbsFeature;
import com.taobao.uikit.feature.view.TImageView;
import tb.qb1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PauseGifSmoothRecyclerScrollFeature extends AbsFeature<RecyclerView> implements RecyclerAdapterCallback {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public class InnerScrollListener extends RecyclerView.OnScrollListener {
        private int mLastScrollState = 0;

        InnerScrollListener() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0 || (1 == i && 2 == this.mLastScrollState)) {
                qb1.a("imageLog", "onScrollStateChange-->resume", new Object[0]);
                PauseGifSmoothRecyclerScrollFeature.this.resume(recyclerView);
            } else if (1 == i) {
                PauseGifSmoothRecyclerScrollFeature.this.pause(recyclerView);
                qb1.a("imageLog", "onScrollStateChange-->pause", new Object[0]);
            }
            this.mLastScrollState = i;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    class SmoothAdapter extends RecyclerView.Adapter {
        private RecyclerView.Adapter mDelegateAdapter;

        protected SmoothAdapter(RecyclerView.Adapter adapter) {
            this.mDelegateAdapter = adapter;
            super.setHasStableIds(adapter.hasStableIds());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.mDelegateAdapter.getItemCount();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return this.mDelegateAdapter.getItemId(i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return this.mDelegateAdapter.getItemViewType(i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (2 != PauseGifSmoothRecyclerScrollFeature.this.getHost().getScrollState()) {
                PauseGifSmoothRecyclerScrollFeature.this.resume(viewHolder.itemView);
            } else {
                PauseGifSmoothRecyclerScrollFeature.this.pause(viewHolder.itemView);
            }
            this.mDelegateAdapter.onBindViewHolder(viewHolder, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return this.mDelegateAdapter.onCreateViewHolder(viewGroup, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
            this.mDelegateAdapter.onViewAttachedToWindow(viewHolder);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
            this.mDelegateAdapter.onViewDetachedFromWindow(viewHolder);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            this.mDelegateAdapter.onViewRecycled(viewHolder);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
            this.mDelegateAdapter.registerAdapterDataObserver(adapterDataObserver);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
            this.mDelegateAdapter.unregisterAdapterDataObserver(adapterDataObserver);
        }
    }

    private ImageLoadFeature getImageLoadFeature(TImageView tImageView) {
        return (ImageLoadFeature) tImageView.findFeature(ImageLoadFeature.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pause(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                pause(viewGroup.getChildAt(i));
            }
        } else if (view instanceof TImageView) {
            TImageView tImageView = (TImageView) view;
            ImageLoadFeature imageLoadFeature = getImageLoadFeature(tImageView);
            if (imageLoadFeature != null) {
                imageLoadFeature.pause();
            }
            qb1.a("imageLog", "TImageView-->pause", new Object[0]);
            boolean z = TUrlImageView.sTemporaryDrawableGetting;
            TUrlImageView.sTemporaryDrawableGetting = true;
            if (tImageView.getDrawable() != null && (tImageView.getDrawable() instanceof AnimatedImageDrawable)) {
                ((AnimatedImageDrawable) tImageView.getDrawable()).pause(false);
            }
            TUrlImageView.sTemporaryDrawableGetting = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resume(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                resume(viewGroup.getChildAt(i));
            }
        } else if (view instanceof TImageView) {
            TImageView tImageView = (TImageView) view;
            ImageLoadFeature imageLoadFeature = getImageLoadFeature(tImageView);
            if (imageLoadFeature != null) {
                imageLoadFeature.resume();
            }
            qb1.a("imageLog", "TImageView-->resume", new Object[0]);
            boolean z = TUrlImageView.sTemporaryDrawableGetting;
            TUrlImageView.sTemporaryDrawableGetting = true;
            if (tImageView.getDrawable() != null && (tImageView.getDrawable() instanceof AnimatedImageDrawable)) {
                ((AnimatedImageDrawable) tImageView.getDrawable()).start();
            }
            TUrlImageView.sTemporaryDrawableGetting = z;
        }
    }

    @Override // com.taobao.uikit.feature.features.AbsFeature
    public void constructor(Context context, AttributeSet attributeSet, int i) {
    }

    @Override // com.taobao.uikit.feature.callback.RecyclerAdapterCallback
    public RecyclerView.Adapter wrapAdapter(RecyclerView.Adapter adapter) {
        return (adapter == null || (adapter instanceof SmoothAdapter)) ? adapter : new SmoothAdapter(adapter);
    }

    @Override // com.taobao.uikit.feature.features.AbsFeature
    public void setHost(RecyclerView recyclerView) {
        super.setHost((PauseGifSmoothRecyclerScrollFeature) recyclerView);
        recyclerView.addOnScrollListener(new InnerScrollListener());
    }
}
