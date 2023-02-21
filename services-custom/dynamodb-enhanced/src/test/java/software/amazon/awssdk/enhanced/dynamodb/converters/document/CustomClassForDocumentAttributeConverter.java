/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package software.amazon.awssdk.enhanced.dynamodb.converters.document;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.enhanced.dynamodb.AttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.AttributeValueType;
import software.amazon.awssdk.enhanced.dynamodb.EnhancedType;
import software.amazon.awssdk.enhanced.dynamodb.internal.converter.attribute.BigDecimalAttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.internal.converter.attribute.BooleanAttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.internal.converter.attribute.ByteArrayAttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.internal.converter.attribute.EnhancedAttributeValue;
import software.amazon.awssdk.enhanced.dynamodb.internal.converter.attribute.ListAttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.internal.converter.attribute.LongAttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.internal.converter.attribute.SetAttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.internal.converter.attribute.StringAttributeConverter;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class CustomClassForDocumentAttributeConverter implements AttributeConverter<CustomClassForDocumentAPI> {

    final static Integer DEFAULT_INCREMENT = 10;

    @Override
    public AttributeValue transformFrom(CustomClassForDocumentAPI input) {

        if(input == null){
            return null;
        }
        Map<String, AttributeValue> attributeValueMap = new HashMap<>();

        if(input.string() != null){
            attributeValueMap.put("string", AttributeValue.fromS(input.string()));
        }

        if(input.longNumber() != null){
            attributeValueMap.put("longNumber", AttributeValue.fromN(input.longNumber().toString()));
        }

        attributeValueMap.put("aBoolean", AttributeValue.fromBool(input.aBoolean()));

        if(input.stringSet() != null){
            attributeValueMap.put("stringSet", AttributeValue.fromSs(input.stringSet().stream().collect(Collectors.toList())));
        }

        if(input.booleanSet() != null){
            attributeValueMap.put("booleanSet",
                                  AttributeValue.fromL(input.booleanSet().stream().map(b -> AttributeValue.fromBool(b)).collect(Collectors.toList())));
        }

        if(input.bigDecimalSet() != null){
            attributeValueMap.put("stringSet",
                                  AttributeValue.fromNs(input.bigDecimalSet().stream().map(b -> b.toString()).collect(Collectors.toList())));
        }

        if(input.customClassList() != null){
            attributeValueMap.put("customClassList", convertCustomList(input.customClassList()));
        }

        if (input.innerCustomClass() != null){
            attributeValueMap.put("innerCustomClass", transformFrom(input.innerCustomClass()));
        }
        return EnhancedAttributeValue.fromMap(attributeValueMap).toAttributeValue();
    }


    private static AttributeValue convertCustomList(List<CustomClassForDocumentAPI> customClassForDocumentAPIList){
        List<AttributeValue> convertCustomList =
            customClassForDocumentAPIList.stream().map(customClassForDocumentAPI -> create().transformFrom(customClassForDocumentAPI)).collect(Collectors.toList());
        return AttributeValue.fromL(convertCustomList);

    }

    @Override
    public CustomClassForDocumentAPI transformTo(AttributeValue input) {

        if(input == null){
            return null;
        }

        EnhancedAttributeValue value = EnhancedAttributeValue.fromAttributeValue(input);

        Map<String, AttributeValue> customAttr = input.m();

        CustomClassForDocumentAPI.Builder builder = CustomClassForDocumentAPI.builder();
        builder.string(StringAttributeConverter.create().transformTo(customAttr.get("string")));

        if(value.isSetOfNumbers())
            builder.stringSet(SetAttributeConverter.setConverter(StringAttributeConverter.create()).transformTo(customAttr.get("stringSet")));

        if(value.isBytes())
        builder.binary(SdkBytes.fromByteArray(ByteArrayAttributeConverter.create().transformTo(customAttr.get("binary"))));

        if(value.isSetOfBytes())
            builder.binarySet(SetAttributeConverter.setConverter(ByteArrayAttributeConverter.create()).transformTo(customAttr.get("binarySet")));

        if(EnhancedAttributeValue.fromAttributeValue(customAttr.get("aBoolean")).isBoolean())
            builder.aBoolean(BooleanAttributeConverter.create().transformTo(customAttr.get("aBoolean")));
        if(value.isListOfAttributeValues())
            builder.booleanSet(SetAttributeConverter.setConverter(BooleanAttributeConverter.create()).transformTo(customAttr.get(
            "booleanSet")));

        if(EnhancedAttributeValue.fromAttributeValue(customAttr.get("longNumber")).isNumber())
            builder.longNumber(LongAttributeConverter.create().transformTo(customAttr.get("longNumber")));

        if(value.isSetOfNumbers())

            builder.longSet(SetAttributeConverter.setConverter(LongAttributeConverter.create()).transformTo(customAttr.get("longSet")));

        if(value.isNumber())
            builder.bigDecimal(BigDecimalAttributeConverter.create().transformTo(customAttr.get("bigDecimal")));

        if(value.isSetOfNumbers())

            builder.bigDecimalSet(SetAttributeConverter.setConverter(BigDecimalAttributeConverter.create()).transformTo(customAttr.get("bigDecimalSet")));

        if(value.isListOfAttributeValues())

            builder.customClassList(ListAttributeConverter.create(create()).transformTo(customAttr.get("customClassList")));

        if(value.isMap())

            builder.innerCustomClass(create().transformTo(customAttr.get("innerCustomClass")));

        return builder.build();
    }

    public static CustomClassForDocumentAttributeConverter create() {
        return new CustomClassForDocumentAttributeConverter();
    }

    @Override
    public EnhancedType<CustomClassForDocumentAPI> type() {
        return EnhancedType.of(CustomClassForDocumentAPI.class);
    }

    @Override
    public AttributeValueType attributeValueType() {
        return AttributeValueType.M;
    }


}
