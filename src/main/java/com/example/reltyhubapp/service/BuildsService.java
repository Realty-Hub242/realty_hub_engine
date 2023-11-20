package com.example.reltyhubapp.service;

import com.example.reltyhubapp.entity.Builds;
import com.example.reltyhubapp.entity.Image;
import com.example.reltyhubapp.repository.BuildsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BuildsService {
    private final BuildsRepository buildsRepository;

    public List<Builds> listProducts(String title) {
        if (title != null) return buildsRepository.findByTitle(title);
        return buildsRepository.findAll();
    }

    public void saveBuilds(Builds builds, ArrayList<MultipartFile> files) throws IOException {

        Image image;
        for (int i = 0; i < files.size(); i++) {
            MultipartFile file = files.get(i);
            if (i == 0 && file.getSize() != 0) {
                image = toImageEntity(file);
                image.setPreviewImage(true);
                builds.addImageToBuilds(image);
            }
            if (file.getSize() != 0 && i != 0) {
                image = toImageEntity(file);
                builds.addImageToBuilds(image);
            }
        }

        Builds buildsFromDb = buildsRepository.save(builds);
        buildsFromDb.setPreviewImageId(buildsFromDb.getImageList().get(0).getId());
        buildsRepository.save(builds);

    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalName(file.getOriginalFilename());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }

    public void deleteBuilds(Long id) {
        buildsRepository.deleteById(id);
    }

    public Builds getBuildsById(Long id) {
        return buildsRepository.findById(id).orElse(null);
    }

}
