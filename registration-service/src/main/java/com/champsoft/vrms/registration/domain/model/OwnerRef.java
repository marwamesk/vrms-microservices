package com.champsoft.vrms.registration.domain.model;

public record OwnerRef(String ownerId) {
    public OwnerRef {
        if (ownerId == null) throw new IllegalArgumentException("ownerId is required");
        ownerId = ownerId.trim();
        if (ownerId.isEmpty()) throw new IllegalArgumentException("ownerId is required");
    }

}
