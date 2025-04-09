package com.yunusemrecakmak.webOdev_5.Repository;

import com.yunusemrecakmak.webOdev_5.Entity.Ogrenci;
import com.yunusemrecakmak.webOdev_5.Entity.PrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OgrenciRepos extends JpaRepository<Ogrenci, PrimaryKey> {
}
