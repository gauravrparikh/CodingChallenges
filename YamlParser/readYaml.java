package CodingChallenges.YamlParser;

import java.util.HashSet;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.io.IOException;





public class readYaml {
    private static HashSet<node> yamlMap;
    public static HashSet<node> readYamlFile(String file_string){
        yamlMap = new HashSet< node>();
        for (String s: file_string.split("\n")){
            String[] parts = s.split(":");
            if (parts.length != 2){
                return null;
            }
            String key = parts[0];
            String value = parts[1];
            yamlMap.add(new node((Object)key, new node((Object)value)));
            
        }
        return yamlMap;
    }
    public static String toJSON(HashSet<node> yamlMap){
        String json = "{";
        for (node n: yamlMap){
            json += "\"" + n.getName() + "\":\"" + n.getChild().getName() + "\",";
        }
        json = json.substring(0, json.length()-1);
        json += "}";
        return json;
    }
    
    public static void main(String[] args) {
        String filePath = "CodingChallenges/YamlParser/file.yaml";
        String yamlContent = "";
        try {
            yamlContent = Files.readString(Paths.get(filePath), StandardCharsets.UTF_8);
            System.out.println(yamlContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HashSet<node> map=readYamlFile(yamlContent);
        if (map == null){
            System.out.println("Invalid yaml file");
        }
        else{
            System.out.println(toJSON(map));
        }
    }

    
}
