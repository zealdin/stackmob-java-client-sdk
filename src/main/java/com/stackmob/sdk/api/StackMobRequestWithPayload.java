/**
 * Copyright 2011 StackMob
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.stackmob.sdk.api;

import com.stackmob.sdk.callback.StackMobCallback;
import com.stackmob.sdk.callback.StackMobRedirectedCallback;
import com.stackmob.sdk.net.HttpVerbWithPayload;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class StackMobRequestWithPayload extends StackMobRequest {
    private Object requestObject;
    public StackMobRequestWithPayload(ExecutorService executor,
                                      StackMobSession session,
                                      HttpVerbWithPayload verb,
                                      Map<String, String> headers,
                                      Map<String, String> params,
                                      Object requestObject,
                                      String method,
                                      StackMobCallback cb,
                                      StackMobRedirectedCallback redirCb) {
        super(executor, session, verb, headers, params, method, cb, redirCb);
        this.requestObject = requestObject;
    }

    public StackMobRequestWithPayload(ExecutorService executor, StackMobSession session, HttpVerbWithPayload verb, String method, StackMobCallback cb, StackMobRedirectedCallback redirCb) {
        this(executor, session, verb, StackMobRequest.EmptyHeaders, StackMobRequest.EmptyParams, null, method, cb, redirCb);
    }

    @Override protected String getRequestBody() {
        if(this.requestObject != null) {
            return gson.toJson(this.requestObject);
        }
        return "";
    }
}