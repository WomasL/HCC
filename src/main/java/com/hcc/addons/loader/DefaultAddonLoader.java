/*
 *     Hypixel Community Client, Client optimized for Hypixel Network
 *     Copyright (C) 2018  HCC Dev Team
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as published
 *     by the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.hcc.addons.loader;

import com.hcc.addons.AddonManifest;
import com.hcc.addons.annotations.Addon;
import com.hcc.event.EventBus;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.launchwrapper.LaunchClassLoader;

import java.io.File;
import java.lang.annotation.Annotation;
import java.net.URI;
import java.util.jar.JarFile;

public class DefaultAddonLoader extends AddonLoaderStrategy {

    /**
     * Classloader
     */
    private static LaunchClassLoader classloader = Launch.classLoader;

    /**
     * @param file addons jar
     * @throws Exception when exception occurs
     */
    @Override
    public void load(File file) throws Exception {
        JarFile jar = new JarFile(file);
        AddonManifest manifest = new AddonManifest(jar);

        URI uri = file.toURI();
        classloader.addURL(uri.toURL());

        Class<?> addonMain = Class.forName(manifest.getMain());
        Object instance = addonMain.newInstance();
        assignInstances(instance);

        for (Annotation annotation : addonMain.getAnnotations()) {
            if (annotation instanceof Addon) {
                // do whatever with Addon annotation?
                EventBus.INSTANCE.register(instance);
                break;
            }
        }
    }
}
