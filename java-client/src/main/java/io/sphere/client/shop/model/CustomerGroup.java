package io.sphere.client.shop.model;

import io.sphere.client.model.VersionedId;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Nonnull;

/** A {@link Customer} can be a member of a customer group (e.g. reseller, gold member).
 *  A customer group can be used in price calculations with special prices being assigned to certain customer groups. */
public class CustomerGroup {
    @Nonnull private String id;
    @JsonProperty("version") private int version;
    private String name;

    // for JSON deserializer
    private CustomerGroup() {}

    /** The unique id. */
    @Nonnull public String getId() { return id; }

    /** The {@link #getId() id} plus version. */
    @Nonnull public VersionedId getIdAndVersion() { return VersionedId.create(id, version); }

    /** The name of the customer group. */
    public String getName() { return name; }

    @Override
    public String toString() {
        return "CustomerGroup{" +
                "id='" + id + '\'' +
                ", version=" + version +
                ", name='" + name + '\'' +
                '}';
    }
}
