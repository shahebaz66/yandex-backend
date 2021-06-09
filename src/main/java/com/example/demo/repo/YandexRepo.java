package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Yandex;

public interface YandexRepo extends JpaRepository<Yandex ,Integer> {
	
	List<Yandex> findByTitle(String title);
	@Query(value="select * from yandex u where u.title like %:keyword% ", nativeQuery=true)
	List<Yandex> findAnimeByTitle(@Param("keyword") String title);
}
