package tb;

import android.content.Context;
import android.content.Intent;
import com.alibaba.pictures.share.common.share.ShareChannel;
import com.alibaba.pictures.share.common.share.ShareContent;
import com.alibaba.pictures.share.weiboshare.WeiboShareActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class o13 {
    private static transient /* synthetic */ IpChange $ipChange;

    public final void a(@NotNull Context context, @Nullable ShareContent shareContent, @Nullable ShareChannel shareChannel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-952070499")) {
            ipChange.ipc$dispatch("-952070499", new Object[]{this, context, shareContent, shareChannel});
            return;
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        Intent intent = new Intent(context, WeiboShareActivity.class);
        intent.putExtra("ShareParams", shareContent);
        context.startActivity(intent);
    }
}
