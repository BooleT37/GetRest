package ru.naumen.model;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


@Named
public class FileStorage implements Storage {

    private final String filename = ".\\storage";

    private List<WeatherData> readFromFile(String filename) {
        try(FileInputStream fin = new FileInputStream(filename)) {
            ObjectInputStream ois = new ObjectInputStream(fin);
            Object weatherDataListObject = ois.readObject();
            if (weatherDataListObject instanceof List)
                return (List<WeatherData>) weatherDataListObject;
            return new ArrayList<WeatherData>(){};
        } catch (IOException|ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void writeToFile(String fileName, List<WeatherData> data) {
        try(FileOutputStream fout = new FileOutputStream(fileName)) {
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createStorage(String fileName) throws IOException {
        Path path = Paths.get(fileName);

        Files.createDirectories(path.getParent());
        try {
            Files.createFile(path);
        } catch (FileAlreadyExistsException e) {
            System.err.println("already exists: " + e.getMessage());
        }
        try(FileOutputStream fout = new FileOutputStream(fileName)) {
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostConstruct
    public void createFileIfNotExists() {
        Path path = Paths.get(filename);
        if (!Files.exists(path))
            try {
                createStorage(filename);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }


    public List<WeatherData> getAllData() {
        return readFromFile(this.filename);
    }

    public WeatherData get(int id) {
        return null;
    }

    public void add(WeatherData data) {
        List<WeatherData> list = readFromFile(this.filename);
        list.add(data);
        writeToFile(this.filename, list);
    }

    public void remove(int id) {

    }
}
