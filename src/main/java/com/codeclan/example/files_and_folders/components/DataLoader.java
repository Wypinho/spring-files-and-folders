package com.codeclan.example.files_and_folders.components;

import com.codeclan.example.files_and_folders.models.File;
import com.codeclan.example.files_and_folders.models.Folder;
import com.codeclan.example.files_and_folders.models.User;
import com.codeclan.example.files_and_folders.repositories.FileRepository;
import com.codeclan.example.files_and_folders.repositories.FolderRepository;
import com.codeclan.example.files_and_folders.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;
    @Autowired
    FolderRepository folderRepository;
    @Autowired
    UserRepository userRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) {
        User andy = new User("Andy");
        userRepository.save(andy);

        Folder stuff = new Folder("Stuff", andy);
        folderRepository.save(stuff);

        File thing = new File("Thing", ".txt", 200, stuff);
        fileRepository.save(thing);
    }
}
