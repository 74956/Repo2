package org.example.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
public class BreedCollectionModel {

    @EqualsAndHashCode.Exclude
    private Integer current_page;
    private List<BreedModel> data;
    @EqualsAndHashCode.Exclude
    private String first_page_url;
    @EqualsAndHashCode.Exclude
    private Integer from;
    @EqualsAndHashCode.Exclude
    private Integer last_page;
    @EqualsAndHashCode.Exclude
    private String last_page_url;
    @EqualsAndHashCode.Exclude
    private List<Links> links;
    @EqualsAndHashCode.Exclude
    private String next_page_url;
    @EqualsAndHashCode.Exclude
    private String path;
    @EqualsAndHashCode.Exclude
    private Integer per_page;
    @EqualsAndHashCode.Exclude
    private String prev_page_url;
    @EqualsAndHashCode.Exclude
    private Integer to;
    @EqualsAndHashCode.Exclude
    private Integer total;

}
