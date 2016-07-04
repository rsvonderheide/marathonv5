/*******************************************************************************
 * Copyright 2016 Jalian Systems Pvt. Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package net.sourceforge.marathon.runtime;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

import net.sourceforge.marathon.runtime.api.IRuntimeLauncherModel;

public interface IWebDriverRuntimeLauncherModel extends IRuntimeLauncherModel {

    public abstract IWebdriverProxy createDriver(Map<String, Object> props, int recordingPort, OutputStream outputStream);

    public abstract URL getProfileAsURL(Map<String, Object> props, int recordingPort, OutputStream outputStream)
            throws URISyntaxException, IOException;

    public abstract boolean needReplaceEnviron();

    public abstract boolean confirmConfiguration();

}