package com.alibaba.pictures.bricks.coupon.order.view;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.bricks.coupon.order.bean.Notice;
import com.alibaba.pictures.bricks.coupon.order.view.NoticeViewHolder;
import com.alibaba.pictures.bricks.listener.OnItemListener;
import com.alient.oneservice.ut.TrackInfo;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.qo1;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class NoticeViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private OnItemListener<Notice> a;
    @Nullable
    private Notice b;
    @Nullable
    private TrackInfo c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoticeViewHolder(@NotNull View view, @Nullable OnItemListener<Notice> onItemListener) {
        super(view);
        b41.i(view, "itemView");
        this.a = onItemListener;
        view.setOnClickListener(new View.OnClickListener() { // from class: tb.tl1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NoticeViewHolder.b(NoticeViewHolder.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(NoticeViewHolder noticeViewHolder, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1945094552")) {
            ipChange.ipc$dispatch("-1945094552", new Object[]{noticeViewHolder, view});
            return;
        }
        b41.i(noticeViewHolder, "this$0");
        Notice notice = noticeViewHolder.b;
        if (notice != null) {
            TrackInfo trackInfo = noticeViewHolder.c;
            if (trackInfo != null) {
                qo1 qo1Var = qo1.INSTANCE;
                b41.h(view, AdvanceSetting.NETWORK_TYPE);
                qo1Var.g(view, trackInfo);
            }
            UserTrackProviderProxy.click(view, noticeViewHolder.c, false);
            OnItemListener<Notice> onItemListener = noticeViewHolder.a;
            if (onItemListener != null) {
                onItemListener.onItemClick(notice, 0);
            }
        }
    }

    public final void c(@NotNull Notice notice, @NotNull TrackInfo trackInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1401355779")) {
            ipChange.ipc$dispatch("-1401355779", new Object[]{this, notice, trackInfo});
            return;
        }
        b41.i(notice, "bean");
        b41.i(trackInfo, "trackInfo");
        this.b = notice;
        this.c = trackInfo;
        qo1 qo1Var = qo1.INSTANCE;
        View view = this.itemView;
        b41.h(view, "itemView");
        qo1Var.h(view, trackInfo);
        UserTrackProviderProxy.expose(this.itemView, this.c);
    }
}
