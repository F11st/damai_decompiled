package cn.damai.commonbusiness.notice;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.C0504a;
import cn.damai.common.nav.DMNav;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.imagebrowse.bean.PicInfo;
import cn.damai.commonbusiness.notice.NoticeViewHolder;
import cn.damai.commonbusiness.notice.bean.ItemContent;
import cn.damai.uikit.view.FixImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.cs;
import tb.q60;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public final class NoticeViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private TextView a;
    @NotNull
    private TextView b;
    @NotNull
    private TextView c;
    @NotNull
    private LinearLayout d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoticeViewHolder(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
        View findViewById = view.findViewById(R$id.notice_list_title);
        b41.h(findViewById, "itemView.findViewById(R.id.notice_list_title)");
        this.a = (TextView) findViewById;
        View findViewById2 = view.findViewById(R$id.notice_list_time);
        b41.h(findViewById2, "itemView.findViewById(R.id.notice_list_time)");
        this.b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R$id.notice_list_content);
        b41.h(findViewById3, "itemView.findViewById(R.id.notice_list_content)");
        this.c = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R$id.notice_list_imgcontent);
        b41.h(findViewById4, "itemView.findViewById(R.id.notice_list_imgcontent)");
        this.d = (LinearLayout) findViewById4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(String str, NoticeViewHolder noticeViewHolder, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1973018239")) {
            ipChange.ipc$dispatch("-1973018239", new Object[]{str, noticeViewHolder, view});
            return;
        }
        b41.i(str, "$url");
        b41.i(noticeViewHolder, "this$0");
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        PicInfo picInfo = new PicInfo();
        picInfo.setPicUrl(str);
        arrayList.add(picInfo);
        Bundle bundle = new Bundle();
        bundle.putString("projectId", String.valueOf(noticeViewHolder.getItemId()));
        bundle.putParcelableArrayList("pic_info", arrayList);
        bundle.putInt("position", 0);
        DMNav.from(noticeViewHolder.itemView.getContext()).withExtras(bundle).toUri(cs.e());
    }

    public final void b(@Nullable ItemContent itemContent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "747727903")) {
            ipChange.ipc$dispatch("747727903", new Object[]{this, itemContent});
        } else if (itemContent != null) {
            this.a.setVisibility(8);
            if (!TextUtils.isEmpty(itemContent.getRootTitle())) {
                this.a.setText(itemContent.getRootTitle());
                this.a.setVisibility(0);
            }
            this.b.setVisibility(8);
            if (!TextUtils.isEmpty(itemContent.getPerformName())) {
                TextView textView = this.b;
                textView.setText("· " + itemContent.getPerformName());
                this.b.setVisibility(0);
            }
            this.c.setVisibility(8);
            if (!TextUtils.isEmpty(itemContent.getContent())) {
                this.c.setText(itemContent.getContent());
                this.c.setVisibility(0);
            }
            LinearLayout linearLayout = this.d;
            linearLayout.removeAllViews();
            ArrayList<String> imageUrlList = itemContent.getImageUrlList();
            if (imageUrlList != null) {
                for (final String str : imageUrlList) {
                    FixImageView fixImageView = new FixImageView(this.itemView.getContext());
                    linearLayout.addView(fixImageView);
                    ViewGroup.LayoutParams layoutParams = fixImageView.getLayoutParams();
                    b41.g(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, q60.a(this.itemView.getContext(), 3.0f));
                    C0504a.b().c(str).g(fixImageView);
                    fixImageView.setOnClickListener(new View.OnClickListener() { // from class: tb.sl1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            NoticeViewHolder.c(str, this, view);
                        }
                    });
                }
            }
        }
    }
}
