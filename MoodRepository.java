package com.moodifyx;

import java.util.*;


public class MoodRepository {
    
    private final Map<String, List<Song>> moodSongs = new HashMap<>();
  
    public MoodRepository(){
        initializeMoodSongs();
    }
    
    private void initializeMoodSongs(){

        Map<String, String[]> moodFiles = Map.of(
            "Happy", new String[]{"happy girl.wav", "happy girlie.wav"},
            "Worship", new String[]{"worship girl.wav", "worship girlie.wav"},
            "Calm", new String[]{"calm girl.wav", "calm girlie.wav"},
            "Cry", new String[]{"cry girl.wav", "cry girlie.wav"},
            "Angry", new String[]{"angry girl.wav", "angry girlie.wav"},
            "Excited", new String[]{"excited girl.wav", "excited girlie.wav"},
            "Believe", new String[]{"believe girl.wav", "believe girlie.wav"},
            "Praise", new String[]{"praise girl.wav", "praise girlie.wav"},
            "Victorious", new String[]{"victorious girl.wav", "victorious girlie.wav"},
            "Good", new String[]{"good girl.wav", "good girlie.wav"}
             
            );
            for(Map.Entry<String, String[]> entry : moodFiles.entrySet()){
                addMood(entry.getKey(), entry.getValue());
            }
    }
    private String formatTitle(String fileName){
        String base = fileName.replace(".wav", "");

        if(base.endsWith("girl")) 
    
            base = base.replace("girlie", "");

        else if(base.endsWith("girl")) 
            base = base.replace("girlie", "");

            base = base.trim();

        return base.substring(0,1).toUpperCase() + base.substring(1) + " Vibe";

    }
    private void addMood(String mood, String[] files){
        List<Song> songs = new ArrayList<>();
        for(String file: files){
            songs.add(new Song(formatTitle(file), "music/" + file));
        }
        moodSongs.put(mood, songs);
    }

    public List<Song> getSongsForMood(String mood){
       return moodSongs.getOrDefault(mood, List.of(new Song("Default Vibe", "music/all.wav"))); 
    }
    public Set<String> getAllMoods(){
        return moodSongs.keySet();
    }
}