package cn.damai.tetris.component.home.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.damai.common.nav.DMNav;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$string;
import cn.damai.tetris.component.home.bean.WarningMessageBean;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.mvp.CommonBean;
import cn.damai.tetris.mvp.CommonViewHolder;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.g6;
import tb.oy0;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class AnnouncementViewHolder extends CommonViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private DMIconFontTextView mAnnouncementArrow;
    private TextView mAnnouncementContent;
    private View mAnnouncementLayout;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private TrackInfo mTrackInfo;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.home.viewholder.AnnouncementViewHolder$a */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1855a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1855a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1895340826")) {
                ipChange.ipc$dispatch("-1895340826", new Object[]{this, view});
                return;
            }
            WarningMessageBean warningMessageBean = (WarningMessageBean) view.getTag();
            if (!TextUtils.isEmpty(warningMessageBean.schema)) {
                oy0.B().p(AnnouncementViewHolder.this.mTrackInfo, warningMessageBean.warningMessage);
                DMNav.from(AnnouncementViewHolder.this.mContext).toUri(warningMessageBean.schema);
            }
            AnnouncementViewHolder.this.mAnnouncementLayout.setVisibility(8);
            z20.T("remove_announcement", "true");
        }
    }

    public AnnouncementViewHolder(View view) {
        super(view);
        this.mOnClickListener = new View$OnClickListenerC1855a();
        this.mContext = view.getContext();
        this.mAnnouncementLayout = this.itemView.findViewById(R$id.homepage_announcement_layout);
        this.mAnnouncementContent = (TextView) this.itemView.findViewById(R$id.homepage_announcement_content);
        this.mAnnouncementArrow = (DMIconFontTextView) this.itemView.findViewById(R$id.homepage_announcement_arrow);
        this.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    @Override // cn.damai.tetris.mvp.CommonViewHolder
    protected void setData(CommonBean commonBean) {
        String str;
        String B;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1881937767")) {
            ipChange.ipc$dispatch("1881937767", new Object[]{this, commonBean});
        } else if (commonBean == null || !(commonBean instanceof WarningMessageBean)) {
        } else {
            this.mTrackInfo = commonBean.trackInfo;
            WarningMessageBean warningMessageBean = (WarningMessageBean) commonBean;
            String a = g6.a(this.mContext);
            if (a != null && (str = warningMessageBean.warningMessage) != null && a.equals(str) && (B = z20.B("remove_announcement")) != null && "true".equals(B)) {
                this.mAnnouncementLayout.setVisibility(8);
                return;
            }
            this.mAnnouncementLayout.setVisibility(0);
            TextView textView = this.mAnnouncementContent;
            textView.setText("公告：" + warningMessageBean.warningMessage);
            if (TextUtils.isEmpty(warningMessageBean.schema)) {
                this.mAnnouncementArrow.setText(this.mContext.getResources().getString(R$string.iconfont_guanbi12));
                this.mAnnouncementArrow.setOnClickListener(this.mOnClickListener);
                this.mAnnouncementArrow.setTag(warningMessageBean);
            } else {
                this.mAnnouncementArrow.setText(this.mContext.getResources().getString(R$string.iconfont_youjiantou12));
                this.itemView.setOnClickListener(this.mOnClickListener);
                this.itemView.setTag(warningMessageBean);
                this.mAnnouncementArrow.setOnClickListener(this.mOnClickListener);
                this.mAnnouncementArrow.setTag(warningMessageBean);
            }
            z20.T("remove_announcement", "false");
            g6.b(this.mContext, warningMessageBean.warningMessage);
            oy0.B().C(this.mTrackInfo, this.itemView, warningMessageBean.schema);
        }
    }
}
