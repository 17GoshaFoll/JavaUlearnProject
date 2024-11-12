package org.example.parser;

import org.example.classes.*;
import java.io.*;
import java.io.IOException;
import java.util.*;

public class CsvParser {
    public static List<String[]> readCSVFile(String file) throws IOException {
        var sc = getScanner(file);
        var nameTheme = Arrays.stream(sc.nextLine().split(";")).toList();
        var namePartOfTheme = Arrays.stream(sc.nextLine().split(";")).toList();
        var maximums = Arrays.stream(sc.nextLine().split(";")).toList();
        var parsedThemes = parseThemes(nameTheme,namePartOfTheme, maximums);
        var parseStudent = parseStudent(sc,parsedThemes);
        sc.close();
        return null;
    }

    private static Scanner getScanner(String file) throws IOException {
        return new Scanner(new File(file));
    }

    private static List<Theme> parseThemes(List<String> themes, List<String> parts, List<String> maximums){
        int themesIndex = 0;
        List<Theme> parseThemes = new ArrayList<>(List.of());
        List<Part_of_Theme> partsForCurrentTheme = new ArrayList<>(List.of());

        for (var i = 0; i < parts.size(); i++) {
            String part = parts.get(i).trim();
            if ("Акт".equals(part)) {
                if (!partsForCurrentTheme.isEmpty()) {
                    var currentTheme = themes.get(themesIndex).trim();
                    parseThemes.add(new Theme(currentTheme, partsForCurrentTheme));
                }
                do themesIndex++;
                while (themes.get(themesIndex).trim().isEmpty());
                partsForCurrentTheme = new ArrayList<>(List.of());
                partsForCurrentTheme.add(new Part_of_Theme(Integer.parseInt(maximums.get(i).trim()),part));
            } else if (!part.isEmpty()) {
                if (themesIndex > 0) partsForCurrentTheme.add(new Part_of_Theme(Integer.parseInt(maximums.get(i).trim()),part));
            }
        }

        if (!partsForCurrentTheme.isEmpty()) {
            String currentTheme = themes.get(themesIndex).trim();
            parseThemes.add(new Theme(currentTheme, partsForCurrentTheme));
        }
        return parseThemes;
    }

    private static List<Student> parseStudent(Scanner sc, List<Theme> themes) throws IOException{
        var parseStudents = new ArrayList<Student>();
        for(var i = 3; i < 977; i++){
            var student = Arrays.stream(sc.nextLine().split(";")).toList();
            var name = student.get(0);
            var group = student.get(1);
            var index = 2;
            var themesStudent = new ArrayList<Theme>();
            for(var j = 0; j < themes.size(); j++){
                themesStudent.add(parseStudentTheme(j,index,themes,student));
                index += themes.get(j).getAllTheme().size();
            }
            var parseStudent = new Student(name,group, new Course("basicprogramming",themesStudent));
            parseStudents.add(parseStudent);
        }
        return parseStudents;
    }

    private static Theme parseStudentTheme(int indexTheme, int index, List<Theme> themes, List<String> student){
        var name = themes.get(indexTheme).getTitle();
        var partsForCurrentTheme = new ArrayList<Part_of_Theme>();
        for(var i = 0; i < themes.get(indexTheme).getAllTheme().size(); i++) {partsForCurrentTheme.add(new Part_of_Theme(Integer.parseInt(student.get(index)),
                themes.get(indexTheme)
                .getAllTheme()
                .get(i)
                .getName()));
            index ++;
        }
        return new Theme(name, partsForCurrentTheme);
    }
}
