package io.sphere.sdk.types.commands;

import io.sphere.sdk.models.EnumValue;
import io.sphere.sdk.models.LocalizedEnumValue;
import io.sphere.sdk.models.LocalizedString;
import io.sphere.sdk.models.TextInputHint;
import io.sphere.sdk.test.IntegrationTest;
import io.sphere.sdk.types.*;
import io.sphere.sdk.types.commands.updateactions.*;
import org.junit.Test;

import static io.sphere.sdk.test.SphereTestUtils.*;
import static io.sphere.sdk.types.TypeFixtures.withUpdateableType;
import static org.assertj.core.api.Assertions.assertThat;

public class TypeUpdateCommandTest extends IntegrationTest {
    @Test
    public void changeName() {
        withUpdateableType(client(), type -> {
            final LocalizedString newName = randomSlug();
            final Type updatedType = execute(TypeUpdateCommand.of(type, ChangeName.of(newName)));
            assertThat(updatedType.getName()).isEqualTo(newName);
            return updatedType;
        });
    }

    @Test
    public void setDescription() {
        withUpdateableType(client(), type -> {
            final LocalizedString newDescription = randomSlug();
            final Type updatedType = execute(TypeUpdateCommand.of(type, SetDescription.of(newDescription)));
            assertThat(updatedType.getDescription()).isEqualTo(newDescription);
            return updatedType;
        });
    }

    @Test
    public void addFieldDefinition() {
        withUpdateableType(client(), type -> {
            final String name = randomKey();
            final FieldDefinition fieldDefinition = FieldDefinition.of(StringType.of(), name, en("label"), false, TextInputHint.SINGLE_LINE);
            final Type updatedType = execute(TypeUpdateCommand.of(type, AddFieldDefinition.of(fieldDefinition)));
            assertThat(updatedType.getFieldDefinitionByName(name)).isEqualTo(fieldDefinition);
            assertThat(updatedType.getFieldDefinitions()).hasSize(type.getFieldDefinitions().size() + 1);

            final Type updated2 = execute(TypeUpdateCommand.of(updatedType, RemoveFieldDefinition.of(name)));
            assertThat(updated2.getFieldDefinitions()).hasSize(type.getFieldDefinitions().size());

            return updated2;
        });
    }

    @Test
    public void changeLabel() {
        withUpdateableType(client(), type -> {
            final LocalizedString newLabel = randomSlug();
            final String name = type.getFieldDefinitions().get(0).getName();
            final Type updatedType = execute(TypeUpdateCommand.of(type, ChangeFieldDefinitionLabel.of(name, newLabel)));
            assertThat(updatedType.getFieldDefinitionByName(name).getLabel()).isEqualTo(newLabel);
            return updatedType;
        });
    }

    @Test
    public void addEnumValue() {
        withUpdateableType(client(), type -> {
            final String name = TypeFixtures.ENUM_FIELD_NAME;
            final EnumValue newEnumValue = EnumValue.of("key-new", "label new");
            final Type updatedType = execute(TypeUpdateCommand.of(type, AddEnumValue.of(name, newEnumValue)));
            assertThat(updatedType.getFieldDefinitionByName(name).getType())
                    .isInstanceOf(EnumType.class)
                    .matches(fieldType -> ((EnumType) fieldType).getValues().contains(newEnumValue), "contains the new enum value");
            return updatedType;
        });
    }

    @Test
    public void addLocalizedEnumValue() {
        withUpdateableType(client(), type -> {
            final String name = TypeFixtures.LOCALIZED_ENUM_FIELD_NAME;
            final LocalizedEnumValue newLocalizedEnumValue = LocalizedEnumValue.of("key-new", en("label new"));
            final Type updatedType = execute(TypeUpdateCommand.of(type, AddLocalizedEnumValue.of(name, newLocalizedEnumValue)));
            assertThat(updatedType.getFieldDefinitionByName(name).getType())
                    .isInstanceOf(LocalizedEnumType.class)
                    .matches(fieldType -> ((LocalizedEnumType) fieldType).getValues().contains(newLocalizedEnumValue), "contains the new enum value");
            return updatedType;
        });
    }
}