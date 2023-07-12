package com.alient.onearch.adapter.delegate;

import com.uc.webview.export.extension.UCCore;
import com.youku.arch.v3.core.PageContext;
import com.youku.arch.v3.event.FragmentEvent;
import com.youku.arch.v3.event.Subject;
import com.youku.arch.v3.page.GenericFragment;
import com.youku.arch.v3.page.IDelegate;
import com.youku.kubus.Event;
import com.youku.kubus.EventBus;
import com.youku.kubus.Subscribe;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007J\b\u0010\n\u001a\u00020\u0004H\u0016R$\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/alient/onearch/adapter/delegate/BasicDelegate;", "Lcom/youku/arch/v3/page/IDelegate;", "Lcom/youku/arch/v3/page/GenericFragment;", "container", "Ltb/wt2;", "setDelegatedContainer", Subject.FRAGMENT, UCCore.LEGACY_EVENT_INIT, "Lcom/youku/kubus/Event;", "event", "onFragmentDestroy", "Lcom/youku/arch/v3/page/GenericFragment;", "getFragment", "()Lcom/youku/arch/v3/page/GenericFragment;", "setFragment", "(Lcom/youku/arch/v3/page/GenericFragment;)V", "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public class BasicDelegate implements IDelegate<GenericFragment> {
    @Nullable
    private GenericFragment fragment;

    @Nullable
    public final GenericFragment getFragment() {
        return this.fragment;
    }

    public void init(@NotNull GenericFragment genericFragment) {
        b41.i(genericFragment, Subject.FRAGMENT);
    }

    public void onFragmentDestroy() {
    }

    @Subscribe(eventType = {FragmentEvent.ON_FRAGMENT_DESTROY})
    public final void onFragmentDestroy(@Nullable Event event) {
        PageContext pageContext;
        EventBus eventBus;
        GenericFragment genericFragment = this.fragment;
        if (genericFragment != null && (pageContext = genericFragment.getPageContext()) != null && (eventBus = pageContext.getEventBus()) != null && eventBus.isRegistered(this)) {
            eventBus.unregister(this);
        }
        onFragmentDestroy();
        this.fragment = null;
    }

    public final void setFragment(@Nullable GenericFragment genericFragment) {
        this.fragment = genericFragment;
    }

    @Override // com.youku.arch.v3.page.IDelegate
    public void setDelegatedContainer(@NotNull GenericFragment genericFragment) {
        PageContext pageContext;
        EventBus eventBus;
        b41.i(genericFragment, "container");
        this.fragment = genericFragment;
        if (genericFragment != null && (pageContext = genericFragment.getPageContext()) != null && (eventBus = pageContext.getEventBus()) != null && !eventBus.isRegistered(this)) {
            eventBus.register(this);
        }
        init(genericFragment);
    }
}
