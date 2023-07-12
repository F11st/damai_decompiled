package cn.damai.onearch.component.shoptip;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.onearch.component.shoptip.ShopTipContract;
import com.alibaba.pictures.bricks.component.scriptmurder.GenericBannerPresenterExt;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.event.EventHandler;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ShopTipPresent extends AbsPresenter<IItem<ItemValue>, ShopTipContract.Model<IItem<ItemValue>>, ShopTipContract.View> implements ShopTipContract.Presenter<IItem<ItemValue>, ShopTipContract.Model<IItem<ItemValue>>> {
    private static transient /* synthetic */ IpChange $ipChange;

    public ShopTipPresent(String str, String str2, View view, EventHandler eventHandler, String str3) {
        super(str, str2, view, eventHandler, str3);
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(@NonNull IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1587447995")) {
            ipChange.ipc$dispatch("-1587447995", new Object[]{this, iItem});
            return;
        }
        super.init(iItem);
        ((ShopTipContract.View) this.view).renderContent(((ShopTipContract.Model) this.model).getContent());
        if (getItemAction() != null) {
            if (TextUtils.isEmpty(getItemAction().getActionUrl())) {
                ((ShopTipContract.View) this.view).hideRightArrow();
                return;
            } else {
                ((ShopTipContract.View) this.view).showRightArrow();
                return;
            }
        }
        ((ShopTipContract.View) this.view).hideRightArrow();
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public boolean onMessage(@NonNull String str, @Nullable Map<String, ?> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "722919162")) {
            return ((Boolean) ipChange.ipc$dispatch("722919162", new Object[]{this, str, map})).booleanValue();
        }
        if (GenericBannerPresenterExt.MSG_BANNER_BG_UPDATE.equals(str)) {
            if (map != null && map.containsKey("color")) {
                ((ShopTipContract.View) this.view).updateBgColor(((Integer) map.get("color")).intValue());
            }
            return true;
        }
        return super.onMessage(str, map);
    }
}
