package com.socrata.pluginstarter;

import com.socrata.sia.Plugin;
import com.socrata.sia.PluginConfigurationFieldDescriptor;
import com.socrata.sia.PluginFactory;
import com.socrata.sia.TranslatedString;

import java.io.File;
import java.util.Map;

public class Factory implements PluginFactory {
    @Override
    public Map<String, PluginConfigurationFieldDescriptor> configurationDescription() {
        return Config.configurationDescription();
    }

    @Override
    public Map<String, TranslatedString> validateConfiguration(Map<String, String> candidateConfig) {
        return Config.validateConfiguration(candidateConfig);
    }

    @Override
    public Plugin create(Map<String, String> configuration, File scratchSpace) {
        Config config = Config.fromRawConfig(configuration);
        return new PluginStarter(config);
    }
}
