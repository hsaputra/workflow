/**
 * Copyright 2014 Nirmata, Inc.
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
package com.nirmata.workflow.models;

public enum TaskMode
{
    STANDARD(0),
    DELAY(1),
    PRIORITY(2)
    ;

    public static TaskMode fromCode(int code)
    {
        for ( TaskMode mode : values() )
        {
            if ( mode.code == code )
            {
                return mode;
            }
        }
        return null;
    }

    public int getCode()
    {
        return code;
    }

    private final int code;

    TaskMode(int code)
    {
        this.code = code;
    }
}
