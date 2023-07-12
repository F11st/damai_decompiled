package com.taobao.login4android.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.ali.user.mobile.ui.R;
import com.ali.user.mobile.utils.ImageUtil;
import com.ali.user.mobile.utils.NetworkUtil;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class AliUserBindMobileDialog extends TaobaoRegProtocolDialogFragment {
    @Override // com.taobao.login4android.ui.TaobaoRegProtocolDialogFragment
    protected int getLayoutContent() {
        return R.layout.aliuser_bind_mobile_dialog;
    }

    @Override // com.taobao.login4android.ui.TaobaoRegProtocolDialogFragment
    protected void initViews(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.aliuser_dialog_logo);
        if (imageView != null) {
            if (!NetworkUtil.isNetworkConnected()) {
                imageView.setVisibility(8);
            } else if (!TextUtils.isEmpty(this.mLogoUrl)) {
                ImageUtil.updateImage(imageView, this.mLogoUrl);
            } else {
                ImageUtil.updateImage(imageView, "https://gw.alicdn.com/imgextra/i4/O1CN012c7Vcs1Xr3OZMZ4la_!!6000000002976-2-tps-885-435.png");
            }
        }
    }
}
