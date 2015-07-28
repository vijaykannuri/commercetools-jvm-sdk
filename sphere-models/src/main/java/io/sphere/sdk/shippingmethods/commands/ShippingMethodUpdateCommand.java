package io.sphere.sdk.shippingmethods.commands;

import io.sphere.sdk.commands.UpdateAction;
import io.sphere.sdk.commands.UpdateCommandDsl;
import io.sphere.sdk.models.Versioned;
import io.sphere.sdk.shippingmethods.ShippingMethod;

import java.util.List;

import static java.util.Arrays.asList;

/**
 {@doc.gen list actions}
 */
public interface ShippingMethodUpdateCommand extends UpdateCommandDsl<ShippingMethod, ShippingMethodUpdateCommand> {
    static ShippingMethodUpdateCommand of(final Versioned<ShippingMethod> versioned,
                                                 final List<? extends UpdateAction<ShippingMethod>> updateActions) {
        return new ShippingMethodUpdateCommandImpl(versioned, updateActions);
    }

    static ShippingMethodUpdateCommand of(final Versioned<ShippingMethod> versioned, final UpdateAction<ShippingMethod> updateAction) {
        return of(versioned, asList(updateAction));
    }
}