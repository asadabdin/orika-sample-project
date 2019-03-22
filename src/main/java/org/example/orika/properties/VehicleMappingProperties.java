package org.example.orika.properties;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@ConfigurationProperties(prefix = "vehicle.properties")
public class VehicleMappingProperties {
    private BiMap<String, Integer> gearTypes = HashBiMap.create();
    private BiMap<String, Integer> bodyTypes = HashBiMap.create();
    private BiMap<String, Integer> fuelTypes = HashBiMap.create();
    private BiMap<String, String> wheelPlacement = HashBiMap.create();
    private BiMap<String, Integer> rimTypes = HashBiMap.create();
    private BiMap<String, Integer> tyreTypes = HashBiMap.create();
    private BiMap<String, Integer> colors = HashBiMap.create();
    private BiMap<String, Integer> upholestryTypes = HashBiMap.create();

}
