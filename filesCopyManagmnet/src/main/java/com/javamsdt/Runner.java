package com.javamsdt;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Runner {

    public static void main(String[] args) throws IOException {
        Path d1 = Paths.get("filesCopyManagmnet/d1");
        Path d2 = Paths.get("filesCopyManagmnet/d2");
        Path d3 = Paths.get("filesCopyManagmnet/d3");

        boolean idD1Folder = Files.isDirectory(d1);
        boolean idD2Folder = Files.isDirectory(d2);
        boolean idD3Folder = Files.isDirectory(d3);

        File[] d1Files = new File(d1.toUri()).listFiles();
        File[] d2Files = new File(d2.toUri()).listFiles();

        assert d1Files != null;
        for (File file : d1Files) {
            System.out.println(file);
        }

        System.out.println(" ============================= ");

        Files.list(d1).filter(file -> !Files.isDirectory(file))
                .peek(System.out::println)
                .forEach(file -> {
                    try {
                        Files.copy(file, Path.of(d3 + "/" + file.getFileName()));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });

    }
}
