package cn.damai.commonbusiness.share.live;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.a;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.share.live.LiveArtistView;
import cn.damai.commonbusiness.share.live.LiveShareImageBean;
import cn.damai.uikit.view.RoundImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class LiveArtistView extends RelativeLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private RoundImageView mAvatarView;
    private TextView mDescView;
    private TextView mNameView;

    public LiveArtistView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1058600697")) {
            ipChange.ipc$dispatch("1058600697", new Object[]{this, context});
            return;
        }
        LayoutInflater.from(context).inflate(R$layout.item_share_brand_or_artist, (ViewGroup) this, true);
        this.mAvatarView = (RoundImageView) findViewById(R$id.share_artist_avatar);
        this.mNameView = (TextView) findViewById(R$id.share_artist_name);
        this.mDescView = (TextView) findViewById(R$id.share_artist_desc);
        this.mAvatarView.setBorder(0.5f, Color.parseColor("#1A000000"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleView$0(DMImageCreator.DMImageSuccListener dMImageSuccListener, DMImageCreator.e eVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1928725132")) {
            ipChange.ipc$dispatch("-1928725132", new Object[]{this, dMImageSuccListener, eVar});
            return;
        }
        this.mAvatarView.setImageBitmap(eVar.b);
        if (dMImageSuccListener != null) {
            dMImageSuccListener.onSuccess(eVar);
        }
    }

    public void handleView(LiveShareImageBean.ShareArtistItem shareArtistItem, final DMImageCreator.DMImageSuccListener dMImageSuccListener, DMImageCreator.DMImageFailListener dMImageFailListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1143203780")) {
            ipChange.ipc$dispatch("1143203780", new Object[]{this, shareArtistItem, dMImageSuccListener, dMImageFailListener});
            return;
        }
        if (shareArtistItem == null || wh2.j(shareArtistItem.mArtistName)) {
            setVisibility(8);
        }
        setVisibility(0);
        this.mNameView.setText(shareArtistItem.mArtistName);
        this.mDescView.setText(shareArtistItem.mArtistDesc);
        a.b().c(shareArtistItem.mArtistAvatar).n(new DMImageCreator.DMImageSuccListener() { // from class: tb.p91
            @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
            public final void onSuccess(DMImageCreator.e eVar) {
                LiveArtistView.this.lambda$handleView$0(dMImageSuccListener, eVar);
            }
        }).e(dMImageFailListener).f();
    }

    public LiveArtistView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public LiveArtistView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public LiveArtistView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(context);
    }
}
