package org.n26.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class Category {
    private long id;
    private String name;
}
