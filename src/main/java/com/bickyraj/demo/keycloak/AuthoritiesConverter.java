package com.bickyraj.demo.keycloak;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Map;

interface AuthoritiesConverter extends Converter<Map<String, Object>, Collection<GrantedAuthority>> {
}
