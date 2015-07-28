package io.sphere.sdk.cartdiscounts.commands;

import io.sphere.sdk.cartdiscounts.CartDiscount;
import io.sphere.sdk.commands.UpdateAction;
import io.sphere.sdk.commands.UpdateCommandDsl;
import io.sphere.sdk.models.Versioned;

import java.util.List;

import static java.util.Arrays.asList;

/**
 {@doc.gen list actions}
 */
public interface CartDiscountUpdateCommand extends UpdateCommandDsl<CartDiscount, CartDiscountUpdateCommand> {
    static CartDiscountUpdateCommand of(final Versioned<CartDiscount> versioned, final UpdateAction<CartDiscount> updateAction) {
        return of(versioned, asList(updateAction));
    }

    static CartDiscountUpdateCommand of(final Versioned<CartDiscount> versioned, final List<? extends UpdateAction<CartDiscount>> updateActions) {
        return new CartDiscountUpdateCommandImpl(versioned, updateActions);
    }
}