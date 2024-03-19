package com.ingeneotest.empresa_gestion_logistica.models;

import jakarta.persistence.GenerationType;

public @interface GeneratedValue {

    GenerationType strategy();

}
