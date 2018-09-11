package com.socrata.pluginstarter;

import com.socrata.sia.PluginConfigurationFieldDescriptor;
import com.socrata.sia.TranslatedString;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// This is a sample configuration that has a single configuration value called "rootDir" which
// for a file based plugin, might represent the home of the files to expose in the plugin.
// The ConfigurationFieldDescriptor.Type is DIRECTORY, which means that in the UI for setting
// up this plugin, a file chooser will be shown. TEXT, PASSWORD, DIRECTORY, and FILE types
// can be used to allow users to input different configuration values.

public class Config {
    private static String ROOT_DIR_KEY = "rootDir";
    public final String rootDir;

    public Config(String rootDir) {
        this.rootDir = rootDir;
    }

    public static Config fromRawConfig(Map<String, String> config) {
        return new Config(config.get(ROOT_DIR_KEY));
    }

    private static TranslatedString ts(String s) {
        return new TranslatedString(s, Collections.emptyMap());
    }

    public static Map<String, PluginConfigurationFieldDescriptor> configurationDescription() {
        HashMap<String, PluginConfigurationFieldDescriptor> desc = new HashMap<String, PluginConfigurationFieldDescriptor>();
        desc.put(ROOT_DIR_KEY, new PluginConfigurationFieldDescriptor(
                ts("Root Directory"),
                ts("The directory in which to allow users to get files from"),
                PluginConfigurationFieldDescriptor.Type.DIRECTORY
        ));
        return desc;
    }

    public static Map<String, TranslatedString> validateConfiguration(Map<String, String> candidate) {
        HashMap<String, TranslatedString> result = new HashMap<>();

        if (!candidate.containsKey(ROOT_DIR_KEY) || candidate.get(ROOT_DIR_KEY).equals("")) {
            result.put(ROOT_DIR_KEY, ts("rootDir is invalid"));
        }

        return result;
    }

    public String getRoot() {
        return this.rootDir;
    }
}
