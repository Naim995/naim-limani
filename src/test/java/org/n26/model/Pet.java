package org.n26.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder(toBuilder = true)
public class Pet {
    private Long id;
    private Category category;
    private String name;
    @Builder.Default
    private List<String> photoUrls = new ArrayList<>();
    @Builder.Default
    private List<Tag> tags = new ArrayList<>();
    private String status;
}
