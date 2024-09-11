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

package software.amazon.awssdk.codegen.customization.processors;

import java.util.Map;
import software.amazon.awssdk.codegen.customization.CodegenCustomizationProcessor;
import software.amazon.awssdk.codegen.model.config.customization.CustomSdkOperations;
import software.amazon.awssdk.codegen.model.intermediate.IntermediateModel;
import software.amazon.awssdk.codegen.model.service.Operation;
import software.amazon.awssdk.codegen.model.service.ServiceModel;

public class CustomSdkOperationsProcessor implements CodegenCustomizationProcessor {

    private final CustomSdkOperations customSdkOperations;

    CustomSdkOperationsProcessor(CustomSdkOperations customSdkOperations) {
        this.customSdkOperations = customSdkOperations;
    }

    @Override
    public void preprocess(ServiceModel serviceModel) {
        Map<String, Operation> operations = serviceModel.getOperations();

        if (customSdkOperations != null) {
            operations.putAll(customSdkOperations.getOperations());
            serviceModel.setOperations(operations);
        }
    }

    @Override
    public void postprocess(IntermediateModel intermediateModel) {
        // added custom operations in service model instead of intermediate model
    }
}
