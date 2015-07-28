package io.sphere.sdk.cartdiscounts.commands.updateactions;

import io.sphere.sdk.cartdiscounts.CartDiscount;
import io.sphere.sdk.commands.UpdateAction;

import javax.annotation.Nullable;
import java.time.ZonedDateTime;

/**
 * {@include.example io.sphere.sdk.cartdiscounts.commands.CartDiscountUpdateCommandTest#setValidFrom()}
 */
public class SetValidFrom extends UpdateAction<CartDiscount> {
    @Nullable
    private final ZonedDateTime validFrom;

    private SetValidFrom(@Nullable final ZonedDateTime validFrom) {
        super("setValidFrom");
        this.validFrom = validFrom;
    }

    public static SetValidFrom of(@Nullable final ZonedDateTime validFrom) {
        return new SetValidFrom(validFrom);
    }

    @Nullable
    public ZonedDateTime getValidFrom() {
        return validFrom;
    }
}