package services;

import java.io.*;
import java.util.*;

public class FileManager {

    public static List<String> read(String path) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String l;
            while ((l = br.readLine()) != null)
                lines.add(l);
        } catch (IOException ignored) {}
        return lines;
    }

    public static void write(String path, List<String> data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (String s : data) {
                bw.write(s);
                bw.newLine();
            }
        } catch (IOException ignored) {}
    }

    public static void append(String path, String record) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            bw.write(record);
            bw.newLine();
        } catch (IOException ignored) {}
    }
}
