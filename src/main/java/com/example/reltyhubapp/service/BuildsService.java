package com.example.reltyhubapp.service;

import com.example.reltyhubapp.entity.Builds;
import com.example.reltyhubapp.entity.Image;
import com.example.reltyhubapp.repository.BuildsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BuildsService {
    private final BuildsRepository buildsRepository;

    public void saveBuilds(Builds builds, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
        Image image1;
        Image image2;
        Image image3;
        if (file1.getSize() != 0) {
            image1 = toImageEntity(file1);
            image1.setPreviewImage(true);
            builds.addImageToBuilds(image1);

        }
        if (file2.getSize() != 0) {
            image2 = toImageEntity(file2);
            builds.addImageToBuilds(image2);

        }
        if (file3.getSize() != 0) {
            image3 = toImageEntity(file3);
            builds.addImageToBuilds(image3);

        }

        log.info("Saving a new builds Builds. Title:{};", builds.getName());
        Builds buildsFromDb = buildsRepository.save(builds);
        buildsRepository.save(builds);
        buildsFromDb.setPreviewImageId(buildsFromDb.getImageList().get(0).getId());
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

    public List<Builds> getAllBuild() {
        return buildsRepository.getAllBuilds();
    }
}
