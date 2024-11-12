package org.example.classes;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Theme {
    @Getter
    String title;
    Integer max_point;
    @Getter
    List<Part_of_Theme> allTheme = new ArrayList<>();
    List<Part_of_Theme> exercises = new ArrayList<>();
    List<Part_of_Theme> activity_on_pairs = new ArrayList<>();;
    List<Part_of_Theme> practices = new ArrayList<>();;

    public Theme(String title, List<Part_of_Theme> allThemes){
        this.title = title;
        this.allTheme = allThemes;
        parseTheme(allThemes);
    }

    private void parseTheme(List<Part_of_Theme> allThemes){
        for (var theme : allThemes) {
            var name = theme.name;
            if (name.contentEquals("акт")) {
                activity_on_pairs.add(theme);
            } else if ("упр".equalsIgnoreCase(name)) {
                exercises.add(theme);
            } else {
                practices.add(theme);
            }//доделай эту не работающую хуйню
        }
    }

    @Override
    public String toString(){
        return String.format(" %s:/n %n", title, exercises.toString());
    }

}
