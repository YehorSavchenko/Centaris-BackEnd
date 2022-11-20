package backend.services;

import backend.repositories.ImageRepository;
import model.Image;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Image addImage(Image image) {
        imageRepository.save(image);
        return image;
    }

    public List<Image> addImages(List<Image> images) {
        imageRepository.saveAll(images);
        return images;
    }

    public List<Image> getImagesForItem(Long itemId) {
        return imageRepository.getImagesForItem(itemId);
    }
}
