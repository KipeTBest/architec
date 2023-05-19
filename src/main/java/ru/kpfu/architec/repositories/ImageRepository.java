package ru.kpfu.architec.repositories;

import ru.kpfu.architec.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
