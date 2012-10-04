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

package com.stackmob.sdk.testobjects;

public class UserOnServer extends StackMobObject {

    public String username;
    public String password;
    public String email;
    public Long createddate;
    public Long lastmoddate;

    //this ctor is used for gson deserialization
    public UserOnServer(String username, String password, String email, long createddate, long lastmoddate) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.createddate = createddate;
        this.lastmoddate = lastmoddate;
    }

    public UserOnServer(String username, String password, long createddate, long lastmoddate) {
        this.username = username;
        this.password = password;
        this.createddate = createddate;
        this.lastmoddate = lastmoddate;
    }

    public UserOnServer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserOnServer(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @Override public String getIdField() { return username; }
    @Override public String getIdFieldName() { return "username"; }
    @Override public String getName() { return "user"; }
}