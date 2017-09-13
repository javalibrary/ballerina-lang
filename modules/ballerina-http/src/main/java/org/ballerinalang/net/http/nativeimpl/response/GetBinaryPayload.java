/*
 *  Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.ballerinalang.net.http.nativeimpl.response;

import org.ballerinalang.bre.Context;
import org.ballerinalang.model.types.TypeEnum;
import org.ballerinalang.model.values.BValue;
import org.ballerinalang.natives.AbstractNativeFunction;
import org.ballerinalang.natives.annotations.Argument;
import org.ballerinalang.natives.annotations.Attribute;
import org.ballerinalang.natives.annotations.BallerinaAnnotation;
import org.ballerinalang.natives.annotations.BallerinaFunction;
import org.ballerinalang.natives.annotations.ReturnType;
import org.ballerinalang.net.http.util.RequestResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Native function to get payload as Blob..
 * ballerina.model.messages:getBinaryPayload
 */
@BallerinaFunction(
        packageName = "ballerina.net.http.response",
        functionName = "getBinaryPayload",
        args = {@Argument(name = "res", type = TypeEnum.STRUCT, structType = "Response",
                          structPackage = "ballerina.net.http")},
        returnType = {@ReturnType(type = TypeEnum.BLOB)},
        isPublic = true
)
public class GetBinaryPayload extends AbstractNativeFunction {

    private static final Logger log = LoggerFactory.getLogger(
            GetBinaryPayload.class);

    @Override
    public BValue[] execute(Context context) {
        return RequestResponseUtil.getBinaryPayload(context, this, log);
    }
}
