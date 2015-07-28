package io.sphere.sdk.orders.commands.updateactions;

import io.sphere.sdk.commands.UpdateAction;
import io.sphere.sdk.orders.Delivery;
import io.sphere.sdk.orders.Order;
import io.sphere.sdk.orders.ParcelMeasurements;
import io.sphere.sdk.orders.TrackingData;

import javax.annotation.Nullable;

/**

 {@include.example io.sphere.sdk.orders.commands.OrderUpdateCommandTest#addParcelToDelivery()}
 */
public class AddParcelToDelivery extends UpdateAction<Order> {
    private final String deliveryId;
    @Nullable
    private final ParcelMeasurements measurements;
    @Nullable
    private final TrackingData trackingData;

    private AddParcelToDelivery(final String deliveryId, @Nullable final ParcelMeasurements measurements, @Nullable final TrackingData trackingData) {
        super("addParcelToDelivery");
        this.deliveryId = deliveryId;
        this.measurements = measurements;
        this.trackingData = trackingData;
    }

    public static AddParcelToDelivery of(final String deliveryId, final ParcelDraft parcelDraft) {
        return new AddParcelToDelivery(deliveryId, parcelDraft.getMeasurements(), parcelDraft.getTrackingData());
    }

    public static AddParcelToDelivery of(final Delivery delivery, final ParcelDraft parcelDraft) {
        return of(delivery.getId(), parcelDraft);
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    @Nullable
    public ParcelMeasurements getMeasurements() {
        return measurements;
    }

    @Nullable
    public TrackingData getTrackingData() {
        return trackingData;
    }
}