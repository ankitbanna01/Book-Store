package com.ankit.bookstore.catalog.domain;

import java.math.BigDecimal;

public record Product(String code, String name, String description, String imgUrl, BigDecimal price) {}
