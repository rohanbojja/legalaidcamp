package org.legalaidcamp.server.services;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class UtilityServiceImpl  implements UtilityService{
    @Override
    public String getRandomString(Integer length) {
        boolean useLetters = true;
        boolean useNumbers = false;
        return RandomStringUtils.random(length-1, useLetters, useNumbers);
    }
}
