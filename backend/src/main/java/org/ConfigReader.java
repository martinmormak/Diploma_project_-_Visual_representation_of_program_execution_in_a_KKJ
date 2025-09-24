package org;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class ConfigReader {
    public boolean getToggleState(String toggle) {
        // Use ClassLoader to load the resource
        try (InputStream inputStream = ConfigReader.class.getClassLoader().getResourceAsStream("config.json")) {
            if (inputStream == null) {
                System.out.println("File not found in resources folder!");
                return false;
            }

            // Parse the JSON
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode config = objectMapper.readTree(inputStream);

            // Read data from JSON
            return config.get(toggle).asBoolean();

        } catch (IOException e) {
            System.err.println("Error while reading file " + e);
            return true;
        } catch (NullPointerException e) {
            System.err.println("Can not find " + toggle + " " + e);
            return true;
        }
    }
}
