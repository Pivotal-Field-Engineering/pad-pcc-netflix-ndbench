/*
 *  Copyright 2016 Netflix, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package com.netflix.ndbench.core.discovery;

import java.net.Inet4Address;
import java.util.Arrays;
import java.util.List;

/**
 * @author vchella
 */
public class LocalClusterDiscovery implements IClusterDiscovery {
    @Override
    public List<String> getApps() {
        return Arrays.asList(getLocalhostName());
    }

    private String getLocalhostName() {
        return Inet4Address.getLoopbackAddress().getHostAddress();
    }

    @Override
    public List<String> getEndpoints(String appName, int defaultPort)
    {
        return Arrays.asList(getLocalhostName() + ":" + defaultPort);
    }

}
