package addon;


import com.github.victools.jsonschema.generator.*;

public class JsonSchemaModule implements Module {

    public JsonSchemaModule() {
    }

    ;

    @Override
    public void applyToConfigBuilder(SchemaGeneratorConfigBuilder configBuilder) {

        configBuilder.forTypesInGeneral().withTitleResolver(typeScope -> {
            if (typeScope.getFullTypeDescription().startsWith("java.lang.")) {
                return null;
            }
            return typeScope.getSimpleTypeDescription();
        });
        configBuilder.forFields().withAdditionalPropertiesResolver(target -> Void.class);
        configBuilder.forTypesInGeneral().withAdditionalPropertiesResolver(target -> Void.class);

        configBuilder.forFields()
            .withRequiredCheck(MemberScope::isFinal);
        configBuilder.with(Option.GETTER_METHODS);
        configBuilder.with(Option.NONPUBLIC_NONSTATIC_FIELDS_WITHOUT_GETTERS);
        configBuilder.with(Option.SIMPLIFIED_ENUMS);
        configBuilder.with(Option.DEFINITIONS_FOR_ALL_OBJECTS);
//        configBuilder.with(Option.DEFINITION_FOR_MAIN_SCHEMA);


    }
}