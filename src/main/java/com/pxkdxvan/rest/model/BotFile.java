package com.pxkdxvan.rest.model;

import jakarta.persistence.*;

import lombok.*;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;

import java.util.UUID;

@Getter
@Entity
@Immutable
@Subselect("""
SELECT
    bf.id,
    bf.share_id,
    CASE
        WHEN p.id IS NOT NULL THEN CONCAT('photo-', bf.share_id, '.jpg')
        WHEN d.id IS NOT NULL THEN d.name
    END AS name,
    CASE
        WHEN p.id IS NOT NULL THEN 'image/jpeg'
        WHEN d.id IS NOT NULL THEN d.mime_type
    END AS mime_type,
    bf.size,
    bf.binary_id
FROM bot_file bf
LEFT JOIN bot_photo p ON p.id = bf.id
LEFT JOIN bot_document d ON d.id = bf.id
WHERE p.id IS NOT NULL OR d.id IS NOT NULL
""")
@Synchronize({"bot_photo", "bot_document", "bot_binary"})
public class BotFile {

    @Id
    private Long id;

    @Column(nullable = false)
    private UUID shareId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String mimeType;

    @Column(nullable = false)
    private Long size;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "binary_id")
    private BotBinary binary;

}
