import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.Set;

public class InstagramChecker {

    private static JSONArray followersArray;
    private static JSONArray followingArray;

    public static void readFiles(File followersFile, File followingFile) throws IOException {
        // Followers file: raw JSON array
        String followersContent = Files.readString(followersFile.toPath());
        followersArray = new JSONArray(followersContent);

        // Following file: JSON object with array inside
        String followingContent = Files.readString(followingFile.toPath());
        JSONObject followingObject = new JSONObject(followingContent);
        followingArray = followingObject.getJSONArray("relationships_following");
    }

    public static void parseAndCompare() {
        Set<String> followers = new HashSet<>();
        Set<String> following = new HashSet<>();

        for (int i = 0; i < followersArray.length(); i++) {
            JSONObject obj = followersArray.getJSONObject(i);
            String username = obj.getJSONArray("string_list_data").getJSONObject(0).getString("value");
            followers.add(username);
        }

        for (int i = 0; i < followingArray.length(); i++) {
            JSONObject obj = followingArray.getJSONObject(i);
            String username;

            // Some JSONs use "value", others "title"
            if (obj.has("title")) {
                username = obj.getString("title");
            } else {
                username = obj.getJSONArray("string_list_data").getJSONObject(0).getString("value");
            }

            following.add(username);
        }


        System.out.println("People you follow who don't follow me back:");
        for (String user : following) {
            if (!followers.contains(user)) {
                System.out.println(user);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        File followersFile = new File("src/main/resources/followers.json");
        File followingFile = new File("src/main/resources/following.json");

        readFiles(followersFile, followingFile);
        parseAndCompare();
    }
}
